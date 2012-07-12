/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.prefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecp.common.MEClassLabelProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommandWithResult;
import org.eclipse.emf.emfstore.client.properties.PropertyManager;
import org.eclipse.emf.emfstore.client.ui.dialogs.login.LoginDialog;
import org.eclipse.emf.emfstore.client.ui.dialogs.login.LoginDialogController;
import org.eclipse.emf.emfstore.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.PropertyPage;
import org.unicase.dashboard.DashboardFactory;
import org.unicase.dashboard.SubscriptionComposite;
import org.unicase.dashboard.TaskTraceClassesComposite;
import org.unicase.ui.unicasecommon.common.util.UnicaseUiUtil;

/**
 * A property page for the dashboard.
 * 
 * @author Shterev
 */
public class DashboardPropertyPage extends PropertyPage {

	/**
	 * Recording command to save the properties in the model.
	 * 
	 * @author Shterev
	 */
	private final class SavePropertiesCommand extends EMFStoreCommandWithResult<Object> {

		@Override
		protected Object doRun() {

			SubscriptionComposite subscriptionComposite = DashboardFactory.eINSTANCE.createSubscriptionComposite();
			for (EObject me : subscriptions) {
				ModelElementId meId = ModelUtil.getProject(me).getModelElementId(me);
				subscriptionComposite.getSubscriptions().add(meId);
			}
			manager.setSharedProperty(DashboardProperties.SUBSCRIPTIONS, subscriptionComposite);
			manager.setSharedStringProperty(DashboardProperties.DASHBOARD_SIZE,
				String.valueOf(notificationSize.getSelection()));
			manager.setSharedStringProperty(DashboardProperties.TASK_PROVIDER,
				String.valueOf(providersTable.getChecked(DashboardProperties.TASK_PROVIDER)));
			manager.setSharedStringProperty(DashboardProperties.TASK_CHANGE_PROVIDER,
				String.valueOf(providersTable.getChecked(DashboardProperties.TASK_CHANGE_PROVIDER)));
			manager.setSharedStringProperty(DashboardProperties.TASK_REVIEW_PROVIDER,
				String.valueOf(providersTable.getChecked(DashboardProperties.TASK_REVIEW_PROVIDER)));
			manager.setSharedStringProperty(DashboardProperties.TASK_TRACE_PROVIDER,
				String.valueOf(providersTable.getChecked(DashboardProperties.TASK_TRACE_PROVIDER)));
			manager.setSharedStringProperty(DashboardProperties.SUBSCRIPTION_PROVIDER,
				String.valueOf(providersTable.getChecked(DashboardProperties.SUBSCRIPTION_PROVIDER)));
			manager.setSharedStringProperty(DashboardProperties.COMMENTS_PROVIDER,
				String.valueOf(providersTable.getChecked(DashboardProperties.COMMENTS_PROVIDER)));
			manager.setSharedStringProperty(DashboardProperties.HIGHLIGHT_PUSHED_COMMENTS,
				String.valueOf(highlightPersonalComments.getSelection()));
			manager.setSharedStringProperty(DashboardProperties.SHOW_CONTAINMENT_REPLIES,
				String.valueOf(showContainmentReplies.getSelection()));
			manager.setSharedStringProperty(DashboardProperties.SHOW_AI_TASKS,
				String.valueOf(showAITasks.getSelection()));
			manager.setSharedStringProperty(DashboardProperties.SHOW_BR_TASKS,
				String.valueOf(showBRTasks.getSelection()));
			manager.setSharedStringProperty(DashboardProperties.SHOW_ISSUE_TASKS,
				String.valueOf(showIssueTasks.getSelection()));
			manager.setSharedStringProperty(DashboardProperties.SHOW_WP_TASKS,
				String.valueOf(showWPTasks.getSelection()));
			manager.setSharedStringProperty(DashboardProperties.SHOW_ONLY_READYFORREVIEW,
				String.valueOf(showOnlyReadyForReview.getSelection()));
			manager.setSharedStringProperty(DashboardProperties.TASKTRACE_LENGTH,
				String.valueOf(taskTraceLength.getSelection()));
			manager.setSharedProperty(DashboardProperties.TASKTRACE_CLASSES, taskTraceClassesComposite);
			return null;
		}
	}

	private HashMap<String, String[]> providerHints;
	private AdapterFactoryLabelProvider labelProvider;
	private Project project;
	private ProjectSpace projectSpace;
	private PropertyManager manager;

	private HashSet<EObject> subscriptions;
	private Spinner taskTraceLength;
	private TaskTraceClassesComposite taskTraceClassesComposite;
	private Button showBRTasks;
	private Button showAITasks;
	private Button showIssueTasks;
	private Button showWPTasks;
	private Button showOnlyReadyForReview;
	private Button showContainmentReplies;
	private Button highlightPersonalComments;
	private Spinner notificationSize;
	private CheckboxTableViewer providersTable;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createContents(Composite parent) {

		GridLayoutFactory.fillDefaults().applyTo(parent);
		noDefaultAndApplyButton();
		if (!init()) {
			Label label = new Label(parent, SWT.WRAP);
			label.setText("Could not determine the current project!");
			return label;
		}

		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		TabFolder folder = new TabFolder(parent, SWT.TOP);

		TabItem generalTab = new TabItem(folder, SWT.NONE);
		generalTab.setControl(createGeneralTab(folder));
		generalTab.setText("General");

		TabItem commentProvidersTab = new TabItem(folder, SWT.NONE);
		commentProvidersTab.setControl(createCommentProvidersTab(folder));
		commentProvidersTab.setText("Comments");

		TabItem taskProvidersTab = new TabItem(folder, SWT.NONE);
		taskProvidersTab.setControl(createTaskProvidersTab(folder));
		taskProvidersTab.setText("Tasks");

		TabItem taskTraceProviderTab = new TabItem(folder, SWT.NONE);
		taskTraceProviderTab.setControl(createTaskTraceProviderTab(folder));
		taskTraceProviderTab.setText("Task traces");

		TabItem subscriptionsTab = new TabItem(folder, SWT.NONE);
		subscriptionsTab.setControl(createSubscriptionProviderTab(folder));
		subscriptionsTab.setText("Subscriptions");

		loadProperties();

		return folder;
	}

	private Control createSubscriptionProviderTab(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);

		Label subscriptionLabel = new Label(root, SWT.WRAP);
		subscriptionLabel.setText("You are subscribed to the following elements:");

		final TableViewer elementsTable = new TableViewer(root);
		elementsTable.setContentProvider(new ArrayContentProvider());
		elementsTable.setLabelProvider(labelProvider);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(elementsTable.getControl());
		elementsTable.setInput(subscriptions.toArray());

		Composite buttonsComposite = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(buttonsComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(buttonsComposite);
		Button addME = new Button(buttonsComposite, SWT.PUSH);
		addME.setText("Add");
		addME.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), labelProvider);
				dialog.setBlockOnOpen(true);
				dialog.setMultipleSelection(true);
				dialog.setElements(project.getAllModelElements().toArray());
				if (dialog.open() == Window.OK) {
					subscriptions.addAll((List<? extends EObject>) Arrays.asList(dialog.getResult()));
					elementsTable.setInput(subscriptions.toArray());
				}
			}
		});

		Button removeME = new Button(buttonsComposite, SWT.PUSH);
		removeME.setText("Remove");
		removeME.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection) elementsTable.getSelection();
				Iterator<Object> iterator = selection.iterator();
				while (iterator.hasNext()) {
					Object o = iterator.next();
					EObject modelElement = (EObject) o;
					subscriptions.remove(modelElement);
					elementsTable.setInput(subscriptions.toArray());
				}
			}
		});

		return root;
	}

	private Control createTaskTraceProviderTab(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);

		Composite lengthComposite = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(lengthComposite);
		Label lengthLabel = new Label(lengthComposite, SWT.WRAP);
		lengthLabel.setText("Maximum trace length:");
		taskTraceLength = new Spinner(lengthComposite, SWT.WRAP | SWT.BORDER);
		taskTraceLength.setMinimum(1);
		taskTraceLength.setMaximum(200);

		Label elementTypesLabel = new Label(root, SWT.WRAP);
		elementTypesLabel.setText("You are subscribed to the following element types:");
		final TableViewer elementTypes = new TableViewer(root);
		elementTypes.setContentProvider(new ArrayContentProvider());
		final MEClassLabelProvider meClassLabelProvider = new MEClassLabelProvider();
		elementTypes.setLabelProvider(meClassLabelProvider);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(elementTypes.getControl());

		Composite buttonsComposite = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(buttonsComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(buttonsComposite);
		Button addType = new Button(buttonsComposite, SWT.PUSH);
		addType.setText("Add");
		addType.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), meClassLabelProvider);
				dialog.setBlockOnOpen(true);
				dialog.setMultipleSelection(true);
				Set<EClass> subclasses = UnicaseUiUtil.getSubclasses(EcoreFactory.eINSTANCE.getEcorePackage()
					.getEObject());
				subclasses.removeAll(taskTraceClassesComposite.getTaskTraceClasses());
				dialog.setElements(subclasses.toArray());
				if (dialog.open() == Window.OK) {
					taskTraceClassesComposite.getTaskTraceClasses().addAll(
						(List<? extends EClass>) Arrays.asList(dialog.getResult()));
					elementTypes.setInput(taskTraceClassesComposite.getTaskTraceClasses().toArray());
				}
			}
		});

		Button removeType = new Button(buttonsComposite, SWT.PUSH);
		removeType.setText("Remove");
		removeType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), meClassLabelProvider);
				dialog.setBlockOnOpen(true);
				dialog.setMultipleSelection(true);
				dialog.setElements(taskTraceClassesComposite.getTaskTraceClasses().toArray());
				if (dialog.open() == Window.OK) {
					taskTraceClassesComposite.getTaskTraceClasses().removeAll(Arrays.asList(dialog.getResult()));
					elementTypes.setInput(taskTraceClassesComposite.getTaskTraceClasses().toArray());
				}
			}
		});

		return root;
	}

	private Control createTaskProvidersTab(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);

		showBRTasks = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(showBRTasks);
		showBRTasks.setText("Show notifications for new BugReports");

		showAITasks = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(showAITasks);
		showAITasks.setText("Show notifications for new ActionItems");

		showIssueTasks = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(showIssueTasks);
		showIssueTasks.setText("Show notifications for new Issues");

		showWPTasks = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(showWPTasks);
		showWPTasks.setText("Show notifications for new WorkPackages");

		showOnlyReadyForReview = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(showOnlyReadyForReview);
		showOnlyReadyForReview.setText("Do not show reviewer tasks until they are ready for review");

		return root;
	}

	private Control createCommentProvidersTab(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);

		showContainmentReplies = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(showContainmentReplies);
		showContainmentReplies.setText("Show notifications for every reply in the thread tree");

		highlightPersonalComments = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(highlightPersonalComments);
		highlightPersonalComments.setText("Hightlight personal comments");

		return root;
	}

	private Control createGeneralTab(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);

		Composite sizeComposite = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(sizeComposite);
		Label sizeLabel = new Label(sizeComposite, SWT.WRAP);
		sizeLabel.setText("Maximum number of notifications on the dashboard:");
		notificationSize = new Spinner(sizeComposite, SWT.WRAP | SWT.BORDER);
		notificationSize.setMinimum(1);
		notificationSize.setMaximum(200);

		Label title = new Label(root, SWT.WRAP);
		title.setText("Active notification types:");
		GridDataFactory.fillDefaults().grab(true, false).applyTo(title);

		providersTable = CheckboxTableViewer.newCheckList(root, SWT.SINGLE | SWT.RESIZE | SWT.V_SCROLL | SWT.H_SCROLL
			| SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(providersTable.getControl());
		providersTable.setContentProvider(new ArrayContentProvider());
		ArrayList<String> providers = new ArrayList<String>();
		providers.addAll(providerHints.keySet());
		Collections.sort(providers, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		providersTable.setInput(providers);

		final Label hint = new Label(root, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(hint);
		hint.setText("Hint: Select an item to view its description");

		providersTable.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Object object = ((IStructuredSelection) event.getSelection()).getFirstElement();
				if (object instanceof String) {
					hint.setText(providerHints.get(object)[1] + "");
					root.layout();
				} else {
					hint.setText("Hint: Select an item to view its description");
					root.layout();
				}
			}
		});

		providersTable.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof String) {
					return providerHints.get(element)[0];
				}
				return super.getText(element);
			}
		});

		return root;
	}

	private boolean init() {
		if (!(getElement() instanceof Project)) {
			return false;
		}

		project = (Project) getElement();

		projectSpace = WorkspaceManager.getProjectSpace(project);
		manager = projectSpace.getPropertyManager();
		providerHints = new HashMap<String, String[]>();

		providerHints.put(DashboardProperties.TASK_PROVIDER, new String[] { "Task notifications",
			"Show notifications for tasks that have been assigned to you." });
		providerHints.put(DashboardProperties.TASK_CHANGE_PROVIDER, new String[] { "Task changes notifications",
			"Show notifications for changes on tasks you have been assigned to." });
		providerHints.put(DashboardProperties.TASK_TRACE_PROVIDER, new String[] { "Task trace notifications",
			"Shows notifications for elements that are related to your tasks." });
		providerHints.put(DashboardProperties.TASK_REVIEW_PROVIDER, new String[] { "Reviewer task notifications",
			"Shows notifications for tasks that you have to review." });
		providerHints.put(DashboardProperties.SUBSCRIPTION_PROVIDER, new String[] { "Subscriptions",
			"Allows you to subscribe to arbitrary model elements and receive notifications upon their changes." });
		providerHints.put(DashboardProperties.COMMENTS_PROVIDER, new String[] { "Comment notifications",
			"Shows notifications for new comments regarding your tasks or a discussion you participate in." });

		// init the model based UI
		subscriptions = new HashSet<EObject>();
		EMFStoreProperty subscriptionsProperty = manager.getSharedProperty(DashboardProperties.SUBSCRIPTIONS);
		if (subscriptionsProperty != null) {
			EObject value = subscriptionsProperty.getValue();
			if (value instanceof SubscriptionComposite) {
				for (ModelElementId id : ((SubscriptionComposite) value).getSubscriptions()) {
					EObject modelElement = project.getModelElement(id);
					if (modelElement != null) {
						subscriptions.add(modelElement);
					}
				}
			}

		}

		taskTraceClassesComposite = DashboardFactory.eINSTANCE.createTaskTraceClassesComposite();
		EMFStoreProperty taskTraceClassesProperty = manager.getSharedProperty(DashboardProperties.TASKTRACE_CLASSES);
		if (taskTraceClassesProperty != null) {
			EObject value = taskTraceClassesProperty.getValue();

			if (value instanceof TaskTraceClassesComposite) {
				for (EObject eObject : ((TaskTraceClassesComposite) value).getTaskTraceClasses()) {
					if (eObject instanceof EClass) {
						taskTraceClassesComposite.getTaskTraceClasses().add(eObject);
					}
				}
			}

		}

		return true;
	}

	private void loadProperties() {

		loadProviderProperties();

		loadTaskProperties();

		String size = manager.getSharedStringProperty(DashboardProperties.DASHBOARD_SIZE);
		notificationSize.setSelection(Integer.parseInt(size));

		String highlightPushed = manager.getSharedStringProperty(DashboardProperties.HIGHLIGHT_PUSHED_COMMENTS);
		highlightPersonalComments.setSelection(Boolean.parseBoolean(highlightPushed));

		String showContainmentComments = manager.getSharedStringProperty(DashboardProperties.SHOW_CONTAINMENT_REPLIES);
		showContainmentReplies.setSelection(Boolean.parseBoolean(showContainmentComments));

		String taskTraceLength = manager.getSharedStringProperty(DashboardProperties.TASKTRACE_LENGTH);
		this.taskTraceLength.setSelection(Integer.parseInt(taskTraceLength));

	}

	private void loadTaskProperties() {
		String showAI = manager.getSharedStringProperty(DashboardProperties.SHOW_AI_TASKS);
		showAITasks.setSelection(Boolean.parseBoolean(showAI));

		String showBR = manager.getSharedStringProperty(DashboardProperties.SHOW_BR_TASKS);
		showBRTasks.setSelection(Boolean.parseBoolean(showBR));

		String showI = manager.getSharedStringProperty(DashboardProperties.SHOW_ISSUE_TASKS);
		showIssueTasks.setSelection(Boolean.parseBoolean(showI));

		String showWP = manager.getSharedStringProperty(DashboardProperties.SHOW_WP_TASKS);
		showWPTasks.setSelection(Boolean.parseBoolean(showWP));

		String showOnlyReadyForReview = manager.getSharedStringProperty(DashboardProperties.SHOW_ONLY_READYFORREVIEW);
		this.showOnlyReadyForReview.setSelection(Boolean.parseBoolean(showOnlyReadyForReview));
	}

	private void loadProviderProperties() {
		String taskProvider = manager.getSharedStringProperty(DashboardProperties.TASK_PROVIDER);
		providersTable.setChecked(DashboardProperties.TASK_PROVIDER, Boolean.parseBoolean(taskProvider));

		String taskChangeProvider = manager.getSharedStringProperty(DashboardProperties.TASK_CHANGE_PROVIDER);
		providersTable.setChecked(DashboardProperties.TASK_CHANGE_PROVIDER, Boolean.parseBoolean(taskChangeProvider));

		String taskReviewProvider = manager.getSharedStringProperty(DashboardProperties.TASK_REVIEW_PROVIDER);
		providersTable.setChecked(DashboardProperties.TASK_REVIEW_PROVIDER, Boolean.parseBoolean(taskReviewProvider));

		String taskTraceProvider = manager.getSharedStringProperty(DashboardProperties.TASK_TRACE_PROVIDER);
		providersTable.setChecked(DashboardProperties.TASK_TRACE_PROVIDER, Boolean.parseBoolean(taskTraceProvider));

		String subscriptionProvider = manager.getSharedStringProperty(DashboardProperties.SUBSCRIPTION_PROVIDER);
		providersTable
			.setChecked(DashboardProperties.SUBSCRIPTION_PROVIDER, Boolean.parseBoolean(subscriptionProvider));

		String commentsProvider = manager.getSharedStringProperty(DashboardProperties.COMMENTS_PROVIDER);
		providersTable.setChecked(DashboardProperties.COMMENTS_PROVIDER, Boolean.parseBoolean(commentsProvider));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void performDefaults() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performOk() {
		final EMFStoreCommandWithResult<Object> command = new SavePropertiesCommand();
		command.run(true);
		if (projectSpace.getUsersession().isLoggedIn()) {
			new EMFStoreCommand() {

				@Override
				protected void doRun() {
					projectSpace.transmitProperties();
				}
			}.run();
		} else {
			new EMFStoreCommand() {

				@Override
				protected void doRun() {
					boolean yes = MessageDialog.openQuestion(getShell(), "Transmit properties",
						"You are currently not logged in! Do you wish to log in and thereby transmit your properties?");
					if (yes) {
						LoginDialogController controller = new LoginDialogController();
						LoginDialog loginDialog = new LoginDialog(Display.getCurrent().getActiveShell(), controller);
						loginDialog.open();
					}
				}
			}.run();

		}
		return true;
	}

}
