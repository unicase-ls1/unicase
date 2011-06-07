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
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;
import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.toolbarbutton.ModelIdDoesNotExistException;
import org.unicase.ui.toolbarbutton.ShortcutActionKey;
import org.unicase.ui.util.DialogHandler;
import org.unicase.ui.workpackagetransfer.TreeHandler;
import org.unicase.workpackagetransfer.navigator.wizards.ChooseWorkPackagePage;
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
			
			//TODO Matthias: So kannst du Task und Bug WorkPackage ModelElementIds speichern!!!!
			//Project project = projectSpace.getProject();
			// project.setModelElementIDBug(bugChoiceListener.getTargetWorkPackage().getModelElementId());
			// project.setModelElementIDTask(taskChoiceListener.getTargetWorkPackage().getModelElementId());
			 
			 
			PreferenceManager.INSTANCE.setProperty(projectSpace,
					ShortcutActionKey.USERTASKLOCATION,
					new ModelElementId[] { taskChoiceListener.getTargetWorkPackage()
							.getModelElementId() }); //targetTaskWorkPackage.getModelElementId()
			PreferenceManager.INSTANCE.setProperty(projectSpace,
					ShortcutActionKey.USERBUGLOCATION,
					new ModelElementId[] { bugChoiceListener.getTargetWorkPackage()
							.getModelElementId() });

			return null;
		}
	}

	private ProjectSpace projectSpace;
	private Project project;

	private AdapterFactoryLabelProvider labelProvider;
	private WorkPackage targetTaskWorkPackage;
	private WorkPackage targetBugWorkPackage;
	private static final String CLABEL_INIT_TEXT = ">> Select target Workpackage <<";
	private static final String BROWSE_BUTTON_TEXT = "Browse Workpackages";

	// Button for browsing the WorkPackages
	private Button browseButton1;
	private CLabel workPackageTaskLabel;
	
	private Button browseButton2;
	private CLabel workPackageBugLabel;

	private ChooseWorkItemPageListener taskChoiceListener;
	private ChooseWorkItemPageListener bugChoiceListener;
	private TreeHandler treeHandler;

	// Tree contains WorkItems
	private Tree tree;

	@Override
	protected Control createContents(Composite parent) {

		GridLayoutFactory.fillDefaults().applyTo(parent);
		noDefaultAndApplyButton();

		if (!init()) {
			Label label = new Label(parent, SWT.WRAP);
			label.setText("Could not determine the current project!");
			return label;
		}

		labelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		TabFolder folder = new TabFolder(parent, SWT.TOP);

		TabItem generalTab = new TabItem(folder, SWT.NONE);
		generalTab.setControl(createUserTab(folder));
		generalTab.setText("User");

		TabItem commentProvidersTab = new TabItem(folder, SWT.NONE);
		commentProvidersTab.setControl(createProjectsTab(folder));
		commentProvidersTab.setText("Group");
		// testSaveProp();
		loadProperties();

		return folder;
	}

	private void loadProperties() {
		loadProperty(ShortcutActionKey.USERTASKLOCATION, targetTaskWorkPackage, workPackageTaskLabel);
		loadProperty(ShortcutActionKey.USERBUGLOCATION, targetBugWorkPackage, workPackageBugLabel);

	}

	private void loadProperty(ShortcutActionKey prefKey, WorkPackage targetWorkPackage, CLabel label) {
		try {
			OrgUnitProperty userProp = PreferenceManager.INSTANCE.getProperty(
					projectSpace, prefKey);
			

			ArrayList<EObject> result = new ArrayList<EObject>();
			List<EObject> resultList = userProp.getEObjectListProperty(result);
			EObject givenId = result.get(0);

			if (givenId instanceof ModelElementId) {

				EObject parentPackage = projectSpace.getProject()
						.getModelElement((ModelElementId) givenId);
				if (parentPackage == null) {
					throw new ModelIdDoesNotExistException(givenId);
				}

				if (parentPackage instanceof WorkPackage) {
					targetWorkPackage = (WorkPackage) parentPackage;

					label.setImage(labelProvider
							.getImage(targetWorkPackage));
					label.setText(labelProvider
							.getText(targetWorkPackage));
				}

			}
		} catch (ModelIdDoesNotExistException e) {
			// if no corresponding workpackage is available keep the choose dialog open
			// e.printStackTrace();
		} catch (IllegalStateException e){
			// if no property is available keep the choose dialog open
			// e.printStackTrace();
			// TODO franzi: getProjectSpezificLocations()
			//project.getD
		}
	}

	private Control createProjectsTab(TabFolder folder) {
		// TODO Auto-generated method stub
		return null;
	}

	private Control createUserTab(TabFolder folder) {
		// Composite (Container)
		final Composite composite = new Composite(folder, SWT.NULL);
		GridLayout gridLayout = new GridLayout(4, false);
		composite.setLayout(gridLayout);

		taskChoiceListener  = createSingleWPPropertyGUI(composite, "Enter the Path to the default Save location for Tasks:", workPackageTaskLabel, browseButton1, targetTaskWorkPackage);
		bugChoiceListener = createSingleWPPropertyGUI(composite, "Enter the Path to the default Save location for Bugs:", workPackageBugLabel, browseButton2, targetBugWorkPackage);

		return composite;
	}

	private ChooseWorkItemPageListener createSingleWPPropertyGUI(final Composite composite, String labelText, CLabel workPackageLabel, Button browseButton, WorkPackage targetWorkPackage) {
		Label label1 = new Label(composite, SWT.LEFT);
		label1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));
		label1.setText(labelText);

		workPackageLabel = new CLabel(composite, SWT.BORDER);
		workPackageLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 2, 1));
		workPackageLabel.setAlignment(SWT.CENTER);
		workPackageLabel.setText(CLABEL_INIT_TEXT);

		browseButton = new Button(composite, SWT.PUSH);
		browseButton.setText(BROWSE_BUTTON_TEXT);
		browseButton.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false,
				false, 2, 1));
		ChooseWorkItemPageListener choiceListener = new ChooseWorkItemPageListener(targetWorkPackage,
				workPackageLabel, browseButton);
		browseButton.addListener(SWT.Selection, choiceListener);
		return choiceListener;
	}

	/**
	 * Listener handling button pressed events and selection events in the
	 * table.
	 * 
	 * @author mkagel
	 */
	private class ChooseWorkItemPageListener implements Listener,
			SelectionListener {
		private WorkPackage targetWorkPackage;
		private CLabel workPackageLabel;
		private Widget browseButton;

		public ChooseWorkItemPageListener(WorkPackage targetWorkPackage,
				CLabel workPackageLabel, Widget browseButton) {
			super();
			this.targetWorkPackage = targetWorkPackage;
			this.workPackageLabel = workPackageLabel;
			this.browseButton = browseButton;
		}

		public WorkPackage getTargetWorkPackage() {
			return targetWorkPackage;
		}

		public void handleEvent(Event event) {
			Widget widget = event.widget;

			if (widget == browseButton) {
				showChooseWorkPackageDialog();
			}

			else if (widget == tree && event.detail == SWT.CHECK) {

				TreeItem treeItem = (TreeItem) event.item;

				manageSelection(treeItem);
			}

		}

		/**
		 * shows the dialog for choosing the target workPackage
		 */
		private void showChooseWorkPackageDialog() {
			ECPModelelementContext context;

			try {

				context = ECPWorkspaceManager.getInstance().getWorkSpace()
						.getActiveProject();
				ChooseWorkPackagePage dialog = new ChooseWorkPackagePage(
						context, project);

				if (dialog.open() == Window.OK) {
					Object[] result = dialog.getResult();

					if (result.length == 1) {
						if (result[0] instanceof WorkPackage) {
							targetWorkPackage = (WorkPackage) result[0];

							workPackageLabel.setImage(labelProvider
									.getImage(targetWorkPackage));
							workPackageLabel.setText(labelProvider
									.getText(targetWorkPackage));
							// parentWizard.setCanFinish(true);
							// setPageComplete(true);
						}
					}
				}
			} catch (NoWorkspaceException e) {
				DialogHandler.showExceptionDialog(e);
			}
		}

		/**
		 * Managing the Selection-Event, new checked treeItems have to check
		 * their children treeItems and newly unchecked treeItems have to
		 * uncheck their parent and children treeItems.
		 * 
		 * @param treeItem
		 *            whose checking has been changed
		 */
		private void manageSelection(TreeItem treeItem) {

			if (treeItem.getChecked()) {
				treeHandler.checkTreeItem(treeItem, true);
			} else {
				treeHandler.uncheckTreeItem(treeItem, true, true);
			}
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
		}

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

	private void testSaveProp() {
		// for testing: (setting a workpackage as property)
		Project p = projectSpace.getProject();
		Set<EObject> modelElements = p.getAllModelElements();
		ModelElementId element = null;
		for (EObject modelElement : modelElements) {
			if (modelElement instanceof WorkPackage) {
				element = ((WorkPackage) modelElement).getModelElementId();
				break;
			}
		}

		if (element != null) {
			targetTaskWorkPackage = (WorkPackage) project
					.getModelElement(element);

			new UnicaseCommand() {

				@Override
				protected void doRun() {
					projectSpace.transmitProperties();
				}
			}.run();
		}
	}
}
