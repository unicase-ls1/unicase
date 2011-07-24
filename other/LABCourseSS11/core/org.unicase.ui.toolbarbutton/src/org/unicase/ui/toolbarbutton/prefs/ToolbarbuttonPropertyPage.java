/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.toolbarbutton.prefs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.toolbarbutton.ModelIdDoesNotExistException;
import org.unicase.ui.toolbarbutton.ShortcutActionKey;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.preferences.PreferenceManager;
import org.unicase.workspace.ui.dialogs.LoginDialog;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * A property page for the ShortcutActions.
 * 
 * @author groeber
 */
public class ToolbarbuttonPropertyPage extends PropertyPage implements
		IWorkbenchPropertyPage {

	/**
	 * Recording command to save the properties in the model.
	 * 
	 */
	private final class SavePropertiesCommand extends
			UnicaseCommandWithResult<Object> {

		@Override
		protected Object doRun() {

			// TODO Matthias: So kannst du Task und Bug WorkPackage
			// ModelElementIds speichern!!!!
			// Project project = projectSpace.getProject();
			// project.setModelElementIDBug(bugChoiceListener.getTargetWorkPackage().getModelElementId());
			// project.setModelElementIDTask(taskChoiceListener.getTargetWorkPackage().getModelElementId());

			PreferenceManager.INSTANCE.setProperty(projectSpace,
					ShortcutActionKey.USERTASKLOCATION,
					new ModelElementId[] { workPackagePropertyCompositeTask
							.getTargetWorkPackage().getModelElementId() }); // targetTaskWorkPackage.getModelElementId()
			PreferenceManager.INSTANCE.setProperty(projectSpace,
					ShortcutActionKey.USERBUGLOCATION,
					new ModelElementId[] { workPackagePropertyCompositeBug
							.getTargetWorkPackage().getModelElementId() });

			return null;
		}
	}

	private ProjectSpace projectSpace;
	private Project project;

	private WorkPackage targetTaskWorkPackage;
	private WorkPackage targetBugWorkPackage;

	// Button for browsing the WorkPackages
	private CLabel workPackageTaskLabel;
	private CLabel workPackageBugLabel;

	private WorkPackagePropertyComposite workPackagePropertyCompositeTask;
	private WorkPackagePropertyComposite workPackagePropertyCompositeBug;

	@Override
	protected Control createContents(Composite parent) {

		GridLayoutFactory.fillDefaults().applyTo(parent);
		noDefaultAndApplyButton();

		if (!init()) {
			Label label = new Label(parent, SWT.WRAP);
			label.setText("Could not determine the current project!");
			return label;
		}

		TabFolder folder = new TabFolder(parent, SWT.TOP);

		TabItem generalTab = new TabItem(folder, SWT.NONE);
		generalTab.setControl(createUserTab(folder));
		generalTab.setText("Current User");

		TabItem projrctSettingsTab = new TabItem(folder, SWT.NONE);
		projrctSettingsTab.setControl(createProjectsTab(folder));
		projrctSettingsTab.setText("Current Project");
		loadProperties();

		return folder;
	}

	private void loadProperties() {
		loadProperty(ShortcutActionKey.USERTASKLOCATION,
				workPackagePropertyCompositeTask, workPackageTaskLabel);
		loadProperty(ShortcutActionKey.USERBUGLOCATION,
				workPackagePropertyCompositeBug, workPackageBugLabel);
		// TODO: load here also for project
		// ...
	}

	private void loadProperty(ShortcutActionKey prefKey,
			WorkPackagePropertyComposite targetWorkPackage, CLabel label) {
		try {
			OrgUnitProperty userProp = PreferenceManager.INSTANCE.getProperty(
					projectSpace, prefKey);

			ArrayList<EObject> result = new ArrayList<EObject>();
			List<EObject> resultList = userProp.getEObjectListProperty(result);
			EObject givenId = result.get(0);

			if (givenId instanceof ModelElementId) {
				targetWorkPackage
						.setTargetWorkPackage((ModelElementId) givenId);
			}
		} catch (ModelIdDoesNotExistException e) {
			// if no corresponding workpackage is available keep the choose
			// dialog open
			// e.printStackTrace();
		} catch (IllegalStateException e) {
			// if no property is available keep the choose dialog open
			// e.printStackTrace();
			// TODO franzi: getProjectSpezificLocations()
		}
	}

	private Control createProjectsTab(TabFolder folder) {
		// Composite (Container)
		final Composite composite = new Composite(folder, SWT.NULL);
		GridLayout gridLayout = new GridLayout(1, false);
		composite.setLayout(gridLayout);
		new WorkPackagePropertyComposite(composite, composite.getStyle(),
				project,
				"Enter the Project specific Path to the default Save location for Tasks:");
		new WorkPackagePropertyComposite(composite, composite.getStyle(),
				project,
				"Enter the Project specific Path to the default Save location for Bugs:");
		return composite;
	}

	private Control createUserTab(TabFolder folder) {
		// Composite (Container)
		final Composite composite = new Composite(folder, SWT.NULL);
		GridLayout gridLayout = new GridLayout(1, false);
		composite.setLayout(gridLayout);

		workPackagePropertyCompositeTask = new WorkPackagePropertyComposite(
				composite, composite.getStyle(), project,
				"Enter the Path to the default Save location for Tasks:");
		workPackagePropertyCompositeBug = new WorkPackagePropertyComposite(
				composite, composite.getStyle(), project,
				"Enter the Path to the default Save location for Bugs:");

		return composite;
	}

	public boolean performOk() {
		final UnicaseCommandWithResult<Object> command = new SavePropertiesCommand();
		command.run();
		if (projectSpace.getUsersession().isLoggedIn()) {
			new UnicaseCommand() {

				@Override
				protected void doRun() {
					projectSpace.transmitProperties();
				}
			}.run();
		} else {
			new UnicaseCommand() {

				@Override
				protected void doRun() {
					boolean yes = MessageDialog
							.openQuestion(
									getShell(),
									"Transmit properties",
									"You are currently not logged in! Do you wish to log in and thereby transmit your properties?");
					if (yes) {
						LoginDialog loginDialog = new LoginDialog(Display
								.getCurrent().getActiveShell(),
								projectSpace.getUsersession(), projectSpace
										.getUsersession().getServerInfo());
						loginDialog.open();
					}
				}
			}.run();

		}
		return true;
	}

	private boolean init() {
		if (!(getElement() instanceof Project)) {
			return false;
		}

		project = (Project) getElement();

		projectSpace = WorkspaceManager.getProjectSpace(project);
		return true;
	}

}
