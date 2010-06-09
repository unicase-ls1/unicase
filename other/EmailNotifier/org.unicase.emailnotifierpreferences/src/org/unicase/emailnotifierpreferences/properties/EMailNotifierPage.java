package org.unicase.emailnotifierpreferences.properties;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.dialogs.PropertyPage;
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

	/**
	 * Constructor for EMailNotifierPage.
	 */
	public EMailNotifierPage() {
		super();
	}

	private Project project;
	private ProjectSpace projectSpace;
	private List<NotificationGroup> tempNotificationGroups;
	private Boolean existEmail = false;
	private String mailLabel = "test";

	private ListViewer notificationGroupList;
	private Button btnAdd;
	private Button btnRemove;
	private Button btnEdit;

	private Composite compositeNotificationGroupProperties;
	private CompositeNotificationTypeSelection compositeNotificationTypeSelection;
	private CompositeSendOptions compositeSendOptions;
	private CompositeBottom compositeBottom;

	private Control createMainTab(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);
		GridDataFactory.fillDefaults().applyTo(root);
		root.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));

		{
			final Composite compositeTop = new Composite(root, SWT.NONE);
			GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(compositeTop);
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).span(1, 1).applyTo(
				compositeTop);
			compositeTop.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_GREEN));
			{
				Composite compositeNotificationGroups = new Composite(compositeTop, SWT.NONE);
				GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(compositeNotificationGroups);

				Label groupListLabel = new Label(compositeNotificationGroups, SWT.PUSH | SWT.TOP);
				groupListLabel.setText("notification groups");
				GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).hint(150, SWT.DEFAULT).grab(true, false)
					.applyTo(groupListLabel);
				notificationGroupList = new ListViewer(compositeNotificationGroups, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
				GridDataFactory.fillDefaults().grab(true, true).hint(150, 150).applyTo(notificationGroupList.getControl());
				addButtons(compositeNotificationGroups);
				notificationGroupList.setContentProvider(new IStructuredContentProvider() {
					public Object[] getElements(Object inputElement) {
						List<NotificationGroup> l = (List<NotificationGroup>) inputElement;
						return l.toArray();
					}

					public void dispose() {
					}

					public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
//						System.out.println("Input changed: old=" + oldInput + ", new=" + newInput);
						notificationGroupList.refresh();
					}
				});
				notificationGroupList.setInput(tempNotificationGroups);
				notificationGroupList.setLabelProvider(new LabelProvider() {
					public Image getImage(Object element) {
						return null;
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
							try{
								NotificationGroup group = (NotificationGroup) selection.getFirstElement();
								String groupname = group.getNotificationGroupName();
								compositeNotificationTypeSelection = new CompositeNotificationTypeSelection(
									compositeNotificationGroupProperties, groupname, tempNotificationGroups, group);
								compositeSendOptions = new CompositeSendOptions(compositeNotificationGroupProperties, groupname,
									tempNotificationGroups, group);
								loadProviderProperties(tempNotificationGroups, tempNotificationGroups.indexOf(selection.getFirstElement()));
								compositeNotificationGroupProperties.layout();
								compositeNotificationGroupProperties.pack();
							}
							catch (Exception e) {
								// TODO: handle exception
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
					// return ((NotificationGroup) e1).getNotificationGroupName().compareTo(((NotificationGroup) e2).getNotificationGroupName());
					// }
				});
			}
			compositeNotificationGroupProperties = new Composite(compositeTop, SWT.NONE);
			GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(compositeNotificationGroupProperties);
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(1, 1).applyTo(
				compositeNotificationGroupProperties);
			compositeNotificationGroupProperties.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));
		}
		compositeBottom = new CompositeBottom(root, mailLabel, existEmail);
		return root;
	}

	/**
	 * @see PreferencePage#createContents(Composite)
	 */
	protected Control createContents(Composite parent) {
		GridLayoutFactory.fillDefaults().applyTo(parent);
		if (!init()) {
			Label label = new Label(parent, SWT.WRAP);
			label.setText("Could not determine the current project!");
			return label;
		}
		TabFolder folder = new TabFolder(parent, SWT.TOP);

		TabItem mainTab = new TabItem(folder, SWT.NONE);
		mainTab.setControl(createMainTab(folder));
		mainTab.setText("Main");

		loadProperties();
		notificationGroupList.refresh();

		return folder;
	}

	private void loadProperties() {
		try {
			OrgUnitProperty loadedNotificationGroups = PreferenceManager.INSTANCE.getProperty(projectSpace,
				EMailNotifierKey.NOTIFICATIONGROUPS);
			OrgUnitProperty loadedActivation = PreferenceManager.INSTANCE.getProperty(projectSpace,
				EMailNotifierKey.ACTIVATED);
			compositeBottom.activate(loadedActivation.getBooleanProperty());
			if (loadedNotificationGroups != null) {
				loadedNotificationGroups.getEObjectListProperty(tempNotificationGroups);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadProviderProperties(List<NotificationGroup> l, int x) {
		compositeNotificationTypeSelection.setCheckedElements(l.get(x).getProviders().toArray());
	}

	private void disposeProperties() {
		if (compositeNotificationTypeSelection != null) {
			compositeNotificationTypeSelection.dispose();
		}
		if (compositeSendOptions != null) {
			compositeSendOptions.dispose();
		}
	}

	private boolean init() {
		if (!(getElement() instanceof Project)) {
			return false;
		}
		tempNotificationGroups = new Vector<NotificationGroup>();
		project = (Project) getElement();
		projectSpace = WorkspaceManager.getProjectSpace(project);

		String userName = projectSpace.getUsersession().getACUser().getName();
		EList<User> listOfUsers = project.getModelElementsByClass(OrganizationPackage.eINSTANCE.getUser(),
			new BasicEList<User>());
		User currentUser = null;
		for (User u : listOfUsers) {
			if (u.getName().equals(userName)) {
				currentUser = u;
			}
		}

		if (currentUser != null) {
			if (currentUser.getEmail().equals("")) {
				existEmail = false;
				mailLabel = "Please fill in your e-mail address";
			} else {
				existEmail = true;
				mailLabel = "The notifications will be send to the following e-mail address" + currentUser.getEmail();
			}
		}
		return true;
	}

	protected void performDefaults() {
	}

	public boolean performOk() {
		final UnicaseCommandWithResult<Object> command = new SavePropertiesCommand();
		command.run();
		return true;
	}

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

	private void addButtons(Composite composite) {
		btnAdd = new Button(composite, SWT.PUSH);
		btnAdd.setText("Add");
		btnEdit = new Button(composite, SWT.PUSH);
		btnEdit.setText("Modify");
		btnRemove = new Button(composite, SWT.PUSH);
		btnRemove.setText("Remove");

		btnAdd.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(), "new notification group",
					"Enter 1-14 characters", "dummy", new LengthValidator());

				if (dlg.open() == Window.OK) {
					NotificationGroup newgroup = EmailnotificationgroupFactoryImpl.eINSTANCE.createNotificationGroup();
					newgroup.setNotificationGroupName(dlg.getValue());
					tempNotificationGroups.add(newgroup);
					disposeProperties();
					((org.eclipse.swt.widgets.List) notificationGroupList.getControl()).select(tempNotificationGroups.indexOf(newgroup));
				}
				notificationGroupList.refresh(true);

			}
		});

		btnEdit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) notificationGroupList.getSelection();
				NotificationGroup group = (NotificationGroup) selection.getFirstElement();
				if (group == null) {
					return;
				}
				InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(), "edit notification group: " + group.getNotificationGroupName(),
					"Enter 1-14 characters", group.getNotificationGroupName(), new LengthValidator());
				if (dlg.open() == Window.OK) {
					group.setNotificationGroupName(dlg.getValue());
				}
				notificationGroupList.update(group, null);
			}
		});

		btnRemove.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
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
	}

	/**
	 * This class validates a String. It makes sure that the String is between 1 and 14 characters
	 */
	class LengthValidator implements IInputValidator {
		/**
		 * Validates the String. Returns null for no error, or an error message
		 * 
		 * @param newText the String to validate
		 * @return String
		 */
		public String isValid(String s) {
			int len = s.length();
			if (len < 1)
				return "notification group name is too short";
			if (len > 14)
				return "notification group is too long";
			return null;
		}
	}
}