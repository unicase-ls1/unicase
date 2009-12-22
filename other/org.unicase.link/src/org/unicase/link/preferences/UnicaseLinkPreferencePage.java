package org.unicase.link.preferences;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringButtonFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.unicase.link.Activator;
import org.unicase.link.preferences.protocolhandlers.IRegisterProtocolHandler;
import org.unicase.link.preferences.protocolhandlers.RegisterProtocolHandlerFactory;

/**
 * TODO: What we'll need to do here - locate the org.unciase.link.startup application which has been installed with the
 * feature - Find out the eclipse path which will be passed to the startup application - register the
 * org.unciase.link.startup application as a protocol handler for the unicase protocol (this should happen via a button
 * click)
 * <p>
 * This page is used to modify preferences only. They are stored in the preference store that belongs to the main
 * plug-in class. That way, preferences can be accessed directly via the preference store.
 */

public class UnicaseLinkPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public UnicaseLinkPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Configuration pane for the link plugin.");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common GUI blocks needed to manipulate various
	 * types of preferences. Each field editor knows how to save and restore itself.
	 */
	@Override
	public void createFieldEditors() {
		addField(new DirectoryFieldEditor(PreferenceConstants.P_PATH, "&Directory preference:", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceConstants.P_BOOLEAN, "&An example of a boolean preference",
			getFieldEditorParent()));

		addField(new RadioGroupFieldEditor(PreferenceConstants.P_CHOICE, "An example of a multiple-choice preference",
			1, new String[][] { { "&Choice 1", "choice1" }, { "C&hoice 2", "choice2" } }, getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceConstants.P_STRING, "A &text preference:", getFieldEditorParent()));

		addField(new UnicaseLinkFieldEditor("Protocol handler", "Associate protocol handler", getFieldEditorParent()));
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	private class UnicaseLinkFieldEditor extends StringButtonFieldEditor {

		public UnicaseLinkFieldEditor(String name, String labelText, Composite parent) {
			super(name, labelText, parent);
		}

		private String getEclipseFilePath() {
			return Platform.getInstallLocation().getURL().getFile();
		}

		private String getEclipseExecutable() {
			String osName = System.getProperty("os.name").toLowerCase();

			if (osName.contains("win")) {
				return "eclipse.exe";
			} else if (osName.contains("mac")) {
				return "eclipse.app";
			}

			return null;
		}

		private String findStartUpApplication() throws IOException {
			File featuresDir = new File(getEclipseFilePath() + File.separator + "features");

			File[] features = featuresDir.listFiles();

			for (File feature : features) {
				if (feature.getName().toLowerCase().contains("org.unicase.link")) {
					String startUpJarFilePath = feature.getAbsoluteFile() + File.separator + "lib" + File.separator
						+ "org.unicase.link.startup.jar";

					File startUpJar = new File(startUpJarFilePath);

					// check whether startup jar really exists
					if (!startUpJar.exists()) {
						throw new IOException("Start up jar not found.");
					}

					return startUpJar.getAbsolutePath();
				}
			}

			return null;
			// org.unicase.link_feature_1.0.0
		}

		@Override
		protected String changePressed() {
			try {
				String startUpJar = findStartUpApplication();
				// String eclipsePath = getEclipseFilePath();
				RegisterProtocolHandlerFactory fac = new RegisterProtocolHandlerFactory();
				IRegisterProtocolHandler protocolHandler = fac
					.getRegisterProtocolHandler(System.getProperty("os.name"));

				if (protocolHandler == null) {
					Display.getDefault().syncExec(new Runnable() {
						public void run() {
							MessageDialog.openError(getShell(), "Not implemented yet", "TODO");
						}
					});
				}

				protocolHandler.registerProtocolHandler(startUpJar);
				writeStartupConfigFile(startUpJar);
			} catch (IOException e) {
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						MessageDialog.openError(getShell(), "Start-up jar not found.",
							"The start-up jar file has not been found.");
					}
				});
			}
			return null;
		}

		private void writeStartupConfigFile(String startUpJarPath) {
			String eclipsePath = getEclipseFilePath();
			String eclipseExecutable = eclipsePath + File.separator + getEclipseExecutable();
			String cfgFilePath = startUpJarPath.substring(0, startUpJarPath.lastIndexOf(File.separator))
				+ "unicaseLink.conf";
			File cfgFile = new File(cfgFilePath);

			try {
				cfgFile.createNewFile();
				FileWriter cfgFileWriter = new FileWriter(cfgFile);
				BufferedWriter bufferedWriter = new BufferedWriter(cfgFileWriter);
				// we need to write this (will be replaced by the startup jar)
				bufferedWriter.write(eclipseExecutable + " <LINK>");
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}