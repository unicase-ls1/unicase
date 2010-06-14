package org.unicase.emailnotifierpreferences.properties;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.PreferencePage;
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
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * A property page for the E-Mail Notifier Service.
 * 
 * @author fuesescc
 */
public class EMailNotifierPage extends PropertyPage {

	private Project project;
	private ProjectSpace projectSpace;
	private List<NotificationGroup> tempNotificationGroups;
	private User currentUser;
	private boolean existUser;
	private boolean existEmail;

	private TableViewer notificationGroupList;
	private Composite compositeNotificationGroupProperties;
	private CompositeNotificationTypeSelection compositeNotificationTypeSelection;
	private CompositeSendOptions compositeSendOptions;
	private CompositeBottom compositeBottom;

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
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).hint(510, SWT.DEFAULT).applyTo(
			compositeTop);

		Composite compositeNotificationGroups = new Composite(compositeTop, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(compositeNotificationGroups);

		Label groupListLabel = new Label(compositeNotificationGroups, SWT.PUSH | SWT.TOP);
		groupListLabel.setText("Notification Groups");
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).hint(110, SWT.DEFAULT).applyTo(groupListLabel);
		notificationGroupList = new TableViewer(compositeNotificationGroups, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL
			| SWT.BORDER);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.FILL).grab(false, true).hint(80, 150).applyTo(
			notificationGroupList.getControl());

		Composite btntoolbar = new Composite(compositeNotificationGroups, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).margins(0, 5).spacing(11, 0).applyTo(btntoolbar);
		addButtons(btntoolbar);

		compositeNotificationGroupProperties = new Composite(compositeTop, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(compositeNotificationGroupProperties);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(compositeNotificationGroupProperties);

		compositeBottom = new CompositeBottom(root, existEmail, currentUser);

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
						compositeNotificationTypeSelection = new CompositeNotificationTypeSelection(
							compositeNotificationGroupProperties, groupname, tempNotificationGroups, group);
						compositeSendOptions = new CompositeSendOptions(compositeNotificationGroupProperties,
							groupname, tempNotificationGroups, group);
						loadProviderProperties(tempNotificationGroups, tempNotificationGroups.indexOf(group));
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
	 * @see PreferencePage#createContents(Composite)
	 */
	protected Control createContents(Composite parent) {
		GridLayoutFactory.fillDefaults().applyTo(parent);
		if (!init()) {
			Label label = new Label(parent, SWT.WRAP);
			if (existUser) {
				label.setText("Could not determine the current project!");
				return label;
			} else {
				label.setText("User does not exist in the current project!");
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
	 * This Method loads the Properties for the user's EMail Notifier Service for the selected project.
	 * 
	 * @author fuesescc
	 */
	private void loadProperties() {
		OrgUnitProperty loadedNotificationGroups = PreferenceManager.INSTANCE.getProperty(projectSpace,
			EMailNotifierKey.NOTIFICATIONGROUPS);
		if (existEmail) {
			OrgUnitProperty loadedActivation = PreferenceManager.INSTANCE.getProperty(projectSpace,
				EMailNotifierKey.ACTIVATED);
			compositeBottom.activate(loadedActivation.getBooleanProperty());
		}
		if (loadedNotificationGroups != null) {
			loadedNotificationGroups.getEObjectListProperty(tempNotificationGroups);
		}
	}

	private void loadProviderProperties(List<NotificationGroup> l, int x) {
		compositeNotificationTypeSelection.setCheckedElements(l.get(x).getProviders().toArray());
	}

	/**
	 * This Method disposes the UI of the Properties associated with the currently selected NotificationGroup.
	 * 
	 * @author fuesescc
	 */
	private void disposeProperties() {
		if (compositeNotificationTypeSelection != null) {
			compositeNotificationTypeSelection.dispose();
		}
		if (compositeSendOptions != null) {
			compositeSendOptions.dispose();
		}
	}

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
			if (u.getAcOrgId().equals(userid.getId())) {
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
	protected void performDefaults() {
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean performOk() {
		final UnicaseCommandWithResult<Object> command = new SavePropertiesCommand();
		command.run();
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
			PreferenceManager.INSTANCE.setProperty(projectSpace, EMailNotifierKey.ACTIVATED, compositeBottom
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
					"Enter 1-14 characters", "", new InputValidator(tempNotificationGroups));
				if (dlg.open() == Window.OK) {
					NotificationGroup newgroup = EmailnotificationgroupFactoryImpl.eINSTANCE.createNotificationGroup();
					newgroup.setNotificationGroupName(dlg.getValue());
					tempNotificationGroups.add(newgroup);
					disposeProperties();
					notificationGroupList.refresh();
//					((Table) notificationGroupList.getControl()).select(tempNotificationGroups.size());
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
					"Enter 1-14 characters", group.getNotificationGroupName(), new InputValidator(
						tempNotificationGroups));
				if (dlg.open() == Window.OK) {
					group.setNotificationGroupName(dlg.getValue());
					disposeProperties();
					compositeNotificationTypeSelection = new CompositeNotificationTypeSelection(
						compositeNotificationGroupProperties, dlg.getValue(), tempNotificationGroups, group);
					compositeSendOptions = new CompositeSendOptions(compositeNotificationGroupProperties, dlg
						.getValue(), tempNotificationGroups, group);
					loadProviderProperties(tempNotificationGroups, tempNotificationGroups.indexOf(group));
					compositeNotificationGroupProperties.layout();
					notificationGroupList.update(group, null);
				}
			}
		});
	}
}