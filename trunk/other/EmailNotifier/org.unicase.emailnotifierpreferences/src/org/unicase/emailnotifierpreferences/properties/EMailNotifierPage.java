/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emailnotifierpreferences.properties;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.emailnotifierpreferences.Activator;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.metamodel.Project;
import org.unicase.model.emailnotificationgroup.NotificationGroup;
import org.unicase.model.emailnotificationgroup.impl.EmailnotificationgroupFactoryImpl;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.dialogs.LoginDialog;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * A property page for the EMail Notifier Service.
 * 
 * @author fuesescc
 */
public class EMailNotifierPage extends PropertyPage {

	// maximum length for the name of a Notification Group
	private static final Integer MAX = 15;

	private Project project;
	private ProjectSpace projectSpace;
	private List<NotificationGroup> tempNotificationGroups;
	private User currentUser;
	private boolean existUser;
	private boolean existEmail;

	private TableViewer notificationGroupList;
	private Composite compositeNotificationGroupProperties;
	private Group groupNotificationGroupProperties;
	private CompositeNotificationTypeSelection compositeNotificationTypeSelection;
	private CompositeGlobalOptions compositeGlobalOptions;

	/**
	 * Init method that is called before the UI is built.
	 * 
	 * @author fuesescc
	 */
	private boolean init() {
		existUser = true;
		if (!(getElement() instanceof Project)) {
			return false;
		}
		tempNotificationGroups = new Vector<NotificationGroup>();
		project = (Project) getElement();
		projectSpace = WorkspaceManager.getProjectSpace(project);

		// check the current user
		ACOrgUnitId userid = projectSpace.getUsersession().getACUser().getId();
		EList<User> listOfUsers = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
			new BasicEList<User>());
		currentUser = null;
		for (User u : listOfUsers) {
			if (u.getAcOrgId() != null && u.getAcOrgId().equals(userid.getId())) {
				currentUser = u;
			}
		}
		if (currentUser == null) {
			existUser = false;
			return false;
		} else {
			if (currentUser.getEmail() == null) {
				existEmail = false;
			} else if (currentUser.getEmail().equals("")) {
				existEmail = false;
			} else {
				existEmail = true;
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Control createContents(Composite parent) {
		GridLayoutFactory.fillDefaults().applyTo(parent);
		noDefaultAndApplyButton();

		if (!init()) {
			Label label = new Label(parent, SWT.WRAP);
			if (!existUser) {
				label.setText("User does not exist in the current project!");
				return label;
			} else {
				label.setText("Could not determine the current project!");
				return label;
			}
		}

		TabFolder folder = new TabFolder(parent, SWT.TOP);

		TabItem mainTab = new TabItem(folder, SWT.NONE);
		mainTab.setControl(createMainTab(folder));
		mainTab.setText("EMail Notifier Properties");

		loadProperties();
		notificationGroupList.refresh();

		return folder;
	}

	/**
	 * This Method builds the main part of the UI for EmailNotifier Service Properties.
	 * 
	 * @author fuesescc
	 */
	private Control createMainTab(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);
		GridDataFactory.fillDefaults().applyTo(root);

		final Composite compositeTop = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(compositeTop);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).hint(540, SWT.DEFAULT).applyTo(
			compositeTop);

		Group groupNotificationGroups = new Group(compositeTop, SWT.NONE);
		GridLayoutFactory.fillDefaults().extendedMargins(3, 5, 10, 0).applyTo(groupNotificationGroups);
		groupNotificationGroups.setText("Notification Groups");

		notificationGroupList = new TableViewer(groupNotificationGroups, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL
			| SWT.BORDER);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.FILL).grab(false, true).hint(100, 150).applyTo(
			notificationGroupList.getControl());

		Composite btntoolbar = new Composite(groupNotificationGroups, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).margins(0, 5).spacing(11, 0).applyTo(btntoolbar);
		addButtons(btntoolbar);

		compositeNotificationGroupProperties = new Composite(compositeTop, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(compositeNotificationGroupProperties);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(compositeNotificationGroupProperties);

		compositeGlobalOptions = new CompositeGlobalOptions(root, existEmail, currentUser);

		notificationGroupList.setContentProvider(new IStructuredContentProvider() {
			@SuppressWarnings("unchecked")
			public Object[] getElements(Object inputElement) {
				List<NotificationGroup> l = (List<NotificationGroup>) inputElement;
				return l.toArray();
			}

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				notificationGroupList.refresh();
			}
		});
		notificationGroupList.setInput(tempNotificationGroups);
		notificationGroupList.setLabelProvider(new LabelProvider() {
			public Image getImage(Object element) {
				return Activator.getImageDescriptor("icons/box.png").createImage();
			}

			public String getText(Object element) {
				return ((NotificationGroup) element).getNotificationGroupName();
			}
		});
		notificationGroupList.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				disposeProperties();
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				if (selection != null) {
					NotificationGroup group = (NotificationGroup) selection.getFirstElement();
					if (group != null) {
						String groupname = group.getNotificationGroupName();
						createOptions(group, groupname);
						compositeNotificationGroupProperties.layout();
					}
				}
			}
		});
		notificationGroupList.addFilter(new ViewerFilter() {
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return true;
			}
		});
		notificationGroupList.setSorter(new ViewerSorter() {
			// public int compare(Viewer viewer, Object e1, Object e2) {
			// return ((NotificationGroup) e1).getNotificationGroupName().compareTo(((NotificationGroup)
			// e2).getNotificationGroupName());
			// }
		});

		return root;
	}

	/**
	 * This Method loads the Properties for the user's EMail Notifier Service for the selected project.
	 * 
	 * @author fuesescc
	 */
	private void loadProperties() {
		final OrgUnitProperty loadedNotificationGroups = PreferenceManager.INSTANCE.getProperty(projectSpace,
			EMailNotifierKey.NOTIFICATIONGROUPS);
		if (existEmail) {
			final OrgUnitProperty loadedActivation = PreferenceManager.INSTANCE.getProperty(projectSpace,
				EMailNotifierKey.ACTIVATED);
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					compositeGlobalOptions.activate(loadedActivation.getBooleanProperty());
				}
			}.run();
		}
		if (loadedNotificationGroups != null) {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					loadedNotificationGroups.getEObjectListProperty(tempNotificationGroups);
				}
			}.run();
		}
	}

	/**
	 * This Method selects the providers which the user wishes to be notified for.
	 * 
	 * @author fuesescc
	 */
	private void loadProviderProperties(List<NotificationGroup> l, int x) {
		compositeNotificationTypeSelection.setCheckedElements(l.get(x).getProviders().toArray());
	}

	/**
	 * This Method disposes the UI of the Properties associated with the currently selected NotificationGroup.
	 * 
	 * @author fuesescc
	 */
	private void disposeProperties() {
		if (groupNotificationGroupProperties != null) {
			groupNotificationGroupProperties.dispose();
		}
	}

	/**
	 * {@inheritDoc}
	 */
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
					boolean yes = MessageDialog.openQuestion(getShell(), "Transmit properties",
						"You are currently not logged in! Do you wish to log in and thereby transmit your properties?");
					if (yes) {
						LoginDialog loginDialog = new LoginDialog(Display.getCurrent().getActiveShell(), projectSpace
							.getUsersession(), projectSpace.getUsersession().getServerInfo());
						loginDialog.open();
					}
				}
			}.run();

		}
		return true;
	}

	/**
	 * Recording command to save the properties in the model.
	 * 
	 * @author fuesescc
	 */
	private final class SavePropertiesCommand extends UnicaseCommandWithResult<Object> {

		@Override
		protected Object doRun() {
			EObject[] b = new EObject[tempNotificationGroups.size()];
			for (int i = 0; i < tempNotificationGroups.size(); i++) {
				b[i] = (NotificationGroup) tempNotificationGroups.get(i);
			}
			PreferenceManager.INSTANCE.setProperty(projectSpace, EMailNotifierKey.NOTIFICATIONGROUPS, b);
			PreferenceManager.INSTANCE.setProperty(projectSpace, EMailNotifierKey.ACTIVATED, compositeGlobalOptions
				.getActivation());
			return null;
		}
	}

	/**
	 * Method to add buttons to the UI so NotificationGroups can be added, edited and removed.
	 * 
	 * @author fuesescc
	 */
	private void addButtons(Composite composite) {
		ImageHyperlink addButton = new ImageHyperlink(composite, SWT.TOP);
		addButton.setImage(Activator.getImageDescriptor("icons/add.png").createImage());
		addButton.setToolTipText("Add a Notification Group");

		ImageHyperlink removeButton = new ImageHyperlink(composite, SWT.TOP);
		removeButton.setImage(Activator.getImageDescriptor("icons/delete.png").createImage());
		removeButton.setToolTipText("Remove the selected Notification Group");

		ImageHyperlink editButton = new ImageHyperlink(composite, SWT.TOP);
		editButton.setImage(Activator.getImageDescriptor("icons/edit.png").createImage());
		editButton.setToolTipText("Edit the name of the selected Notification Group");

		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(), "Create a Notification Group",
					"Enter 1-" + MAX.toString() + " characters", "", new GroupInputValidator(tempNotificationGroups,
						MAX));
				if (dlg.open() == Window.OK) {
					NotificationGroup newgroup = EmailnotificationgroupFactoryImpl.eINSTANCE.createNotificationGroup();
					newgroup.setNotificationGroupName(dlg.getValue());
					tempNotificationGroups.add(newgroup);
					disposeProperties();
					notificationGroupList.refresh();
					// ((Table) notificationGroupList.getControl()).select(tempNotificationGroups.size());
				}
			}
		});
		removeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				IStructuredSelection selection = (IStructuredSelection) notificationGroupList.getSelection();
				NotificationGroup group = (NotificationGroup) selection.getFirstElement();
				if (group == null) {
					return;
				}
				disposeProperties();
				tempNotificationGroups.remove(group);
				notificationGroupList.refresh();
			}
		});
		editButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				IStructuredSelection selection = (IStructuredSelection) notificationGroupList.getSelection();
				NotificationGroup group = (NotificationGroup) selection.getFirstElement();
				if (group == null) {
					return;
				}
				InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(),
					"Edit the name of the selected Notification Group \"" + group.getNotificationGroupName() + "\"",
					"Enter 1-" + MAX.toString() + " characters", group.getNotificationGroupName(),
					new GroupInputValidator(tempNotificationGroups, MAX));
				if (dlg.open() == Window.OK) {
					group.setNotificationGroupName(dlg.getValue());
					disposeProperties();
					createOptions(group, dlg.getValue());
					notificationGroupList.update(group, null);
				}
			}
		});
	}

	/**
	 * This Method builds the UI part for the options for a selected Notification Group.
	 * 
	 * @author fuesescc
	 */
	private void createOptions(NotificationGroup group, String name) {
		groupNotificationGroupProperties = new Group(compositeNotificationGroupProperties, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).extendedMargins(0, 0, 5, 0).applyTo(
			groupNotificationGroupProperties);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(groupNotificationGroupProperties);
		groupNotificationGroupProperties.setText("Options for group \"" + name + "\"");
		compositeNotificationTypeSelection = new CompositeNotificationTypeSelection(groupNotificationGroupProperties,
			tempNotificationGroups, group);
		new CompositeSendOptions(groupNotificationGroupProperties, tempNotificationGroups, group);
		loadProviderProperties(tempNotificationGroups, tempNotificationGroups.indexOf(group));
		compositeNotificationGroupProperties.layout();
	}
}