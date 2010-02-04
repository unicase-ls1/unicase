/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.openurl.preferences;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringButtonFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.unicase.openurl.preferences.protocolhandlers.AbstractRegisterProtocolHandler;
import org.unicase.openurl.preferences.protocolhandlers.RegisterProtocolHandlerFactory;

/**
 * The preference page locates the org.unciase.link.startup jar file which has been installed with the feature and finds
 * out the eclipse path of the eclipse installation which will be passed to the startup application. It then registers
 * theorg.unciase.link.startup jar as a protocol handler for the unicase protocol *
 * <p>
 * 
 * @author emueller
 */
public class UnicaseLinkPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private final AbstractRegisterProtocolHandler protocolHandler;

	public UnicaseLinkPreferencePage() {
		super(GRID);
		setDescription("Configuration pane for the link plugin.");
		setValid(true);
		RegisterProtocolHandlerFactory fac = new RegisterProtocolHandlerFactory();
		protocolHandler = fac.getRegisterProtocolHandler();
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common GUI blocks needed to manipulate various
	 * types of preferences. Each field editor knows how to save and restore itself.
	 */
	@Override
	public void createFieldEditors() {
		addField(new UnicaseLinkFieldEditor("Protocol handler", "Protocol handler associated:", getFieldEditorParent()));
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
			getTextControl().setText(protocolHandler.isProtocolHandlerRegistered() ? "Yes" : "No");
			getTextControl().setEditable(false);
			// getTextControl().setEnabled(false);
			// getApplyButton().setText(string)
		}

		@Override
		protected String changePressed() {
			try {
				if (protocolHandler == null) {
					Display.getDefault().syncExec(new Runnable() {
						public void run() {
							MessageDialog.openError(getShell(), "Protocol handler registration failed",
								"The registration of the UNICASE protocol hasn't been implemented yet "
									+ "for your operating system.");
						}
					});
				}

				protocolHandler.registerProtocolHandler();
				writeStartupConfigFile(protocolHandler.getEclipseExecutable(), protocolHandler.getStartUpJar());
			} catch (IOException e) {
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						MessageDialog.openError(getShell(), "Start-up jar not found.",
							"The start-up jar file has not been found.");
					}
				});
			}

			if (protocolHandler.isProtocolHandlerRegistered()) {
				getTextControl().setText("Yes");
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						MessageDialog.openInformation(getShell(), "URL handler registration succesful",
							"The registration of the URL handler for unicase:// URLs on your operating system "
								+ " was successful.");
					}
				});
			} else {
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						MessageDialog.openError(getShell(), "URL handler registration failed",
							"The registration of the URL handler for unicase:// URLs on your operating system "
								+ " wasn't successful.");
					}
				});
			}

			return null;
		}

		private void writeStartupConfigFile(String eclipseExecutablePath, String startUpJarPath) {
			String cfgFilePath = startUpJarPath.substring(0, startUpJarPath.lastIndexOf(File.separator))
				+ File.separator + "unicaseLink.conf";
			File cfgFile = new File(cfgFilePath);

			try {
				cfgFile.createNewFile();
				FileWriter cfgFileWriter = new FileWriter(cfgFile);
				BufferedWriter bufferedWriter = new BufferedWriter(cfgFileWriter);
				bufferedWriter.write(eclipseExecutablePath);
				bufferedWriter.close();
			} catch (IOException e) {
				showErrorMessage(e.getMessage());
			}
		}
	}

}