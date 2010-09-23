/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
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
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.common.MEClassLabelProvider;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.preferences.DashboardKey;
import org.unicase.workspace.preferences.PreferenceManager;
import org.unicase.workspace.preferences.PropertyKey;
import org.unicase.workspace.ui.dialogs.LoginDialog;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

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
	private final class SavePropertiesCommand extends UnicaseCommandWithResult<Object> {

		@Override
		protected Object doRun() {
			ArrayList<ModelElementId> subscriptionsIds = new ArrayList<ModelElementId>();
			for (ModelElement me : subscriptions) {
				subscriptionsIds.add(me.getModelElementId());
			}
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.SUBSCRIPTIONS, subscriptionsIds
				.toArray(new ModelElementId[0]));
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.DASHBOARD_SIZE, notificationSize
				.getSelection());
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.TASK_PROVIDER, providersTable
				.getChecked(DashboardKey.TASK_PROVIDER));
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.TASK_CHANGE_PROVIDER, providersTable
				.getChecked(DashboardKey.TASK_CHANGE_PROVIDER));
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.TASK_REVIEW_PROVIDER, providersTable
				.getChecked(DashboardKey.TASK_REVIEW_PROVIDER));
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.TASK_TRACE_PROVIDER, providersTable
				.getChecked(DashboardKey.TASK_TRACE_PROVIDER));
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.SUBSCRIPTION_PROVIDER, providersTable
				.getChecked(DashboardKey.SUBSCRIPTION_PROVIDER));
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.COMMENTS_PROVIDER, providersTable
				.getChecked(DashboardKey.COMMENTS_PROVIDER));
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.HIGHLIGHT_PUSHED_COMMENTS,
				highlightPersonalComments.getSelection());
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.SHOW_CONTAINMENT_REPLIES,
				showContainmentReplies.getSelection());
			PreferenceManager.INSTANCE
				.setProperty(projectSpace, DashboardKey.SHOW_AI_TASKS, showAITasks.getSelection());
			PreferenceManager.INSTANCE
				.setProperty(projectSpace, DashboardKey.SHOW_BR_TASKS, showBRTasks.getSelection());
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.SHOW_ISSUE_TASKS, showIssueTasks
				.getSelection());
			PreferenceManager.INSTANCE
				.setProperty(projectSpace, DashboardKey.SHOW_WP_TASKS, showWPTasks.getSelection());
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.SHOW_ONLY_READYFORREVIEW,
				showOnlyReadyForReview.getSelection());
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.TASKTRACE_LENGTH, taskTraceLength
				.getSelection());
			PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.TASKTRACE_CLASSES, taskTraceClasses
				.toArray(new EObject[0]));
			return null;
		}
	}

	private HashMap<PropertyKey, String[]> providerHints;
	private AdapterFactoryLabelProvider labelProvider;
	private Project project;
	private ProjectSpace projectSpace;

	private HashSet<ModelElement> subscriptions;
	private Spinner taskTraceLength;
	private HashSet<EClass> taskTraceClasses;
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
					subscriptions.addAll((List<? extends ModelElement>) Arrays.asList(dialog.getResult()));
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
					ModelElement modelElement = (ModelElement) o;
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
				Set<EClass> subclasses = ModelUtil.getSubclasses(MetamodelPackage.eINSTANCE.getModelElement());
				subclasses.removeAll(taskTraceClasses);
				dialog.setElements(subclasses.toArray());
				if (dialog.open() == Window.OK) {
					taskTraceClasses.addAll((List<? extends EClass>) Arrays.asList(dialog.getResult()));
					elementTypes.setInput(taskTraceClasses.toArray());
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
				dialog.setElements(taskTraceClasses.toArray());
				if (dialog.open() == Window.OK) {
					taskTraceClasses.removeAll(Arrays.asList(dialog.getResult()));
					elementTypes.setInput(taskTraceClasses.toArray());
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
		ArrayList<PropertyKey> providers = new ArrayList<PropertyKey>();
		providers.addAll(providerHints.keySet());
		Collections.sort(providers, new Comparator<PropertyKey>() {
			public int compare(PropertyKey o1, PropertyKey o2) {
				return o1.toString().compareTo(o2.toString());
			}
		});
		providersTable.setInput(providers);

		final Label hint = new Label(root, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(hint);
		hint.setText("Hint: Select an item to view its description");

		providersTable.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Object object = ((IStructuredSelection) event.getSelection()).getFirstElement();
				if (object instanceof DashboardKey) {
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
				if (element instanceof DashboardKey) {
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
		providerHints = new HashMap<PropertyKey, String[]>();

		providerHints.put(DashboardKey.TASK_PROVIDER, new String[] { "Task notifications",
			"Show notifications for tasks that have been assigned to you." });
		providerHints.put(DashboardKey.TASK_CHANGE_PROVIDER, new String[] { "Task changes notifications",
			"Show notifications for changes on tasks you have been assigned to." });
		providerHints.put(DashboardKey.TASK_TRACE_PROVIDER, new String[] { "Task trace notifications",
			"Shows notifications for elements that are related to your tasks." });
		providerHints.put(DashboardKey.TASK_REVIEW_PROVIDER, new String[] { "Reviewer task notifications",
			"Shows notifications for tasks that you have to review." });
		providerHints.put(DashboardKey.SUBSCRIPTION_PROVIDER, new String[] { "Subscriptions",
			"Allows you to subscribe to arbitrary model elements and receive notifications upon their changes." });
		providerHints.put(DashboardKey.COMMENTS_PROVIDER, new String[] { "Comment notifications",
			"Shows notifications for new comments regarding your tasks or a discussion you participate in." });

		// init the model based UI
		subscriptions = new HashSet<ModelElement>();
		if (projectSpace.hasProperty(DashboardKey.SUBSCRIPTIONS)) {
			OrgUnitProperty subscriptionsProperty = PreferenceManager.INSTANCE.getProperty(projectSpace,
				DashboardKey.SUBSCRIPTIONS);
			List<EObject> subscriptionsIds = subscriptionsProperty.getEObjectListProperty(new ArrayList<EObject>());

			for (EObject id : subscriptionsIds) {
				if (id instanceof ModelElementId) {
					ModelElement modelElement = project.getModelElement((ModelElementId) id);
					if (modelElement != null) {
						subscriptions.add(modelElement);
					}
				}
			}
		}

		taskTraceClasses = new HashSet<EClass>();
		if (projectSpace.hasProperty(DashboardKey.TASKTRACE_CLASSES)) {
			OrgUnitProperty taskTraceClassesProperty = PreferenceManager.INSTANCE.getProperty(projectSpace,
				DashboardKey.TASKTRACE_CLASSES);
			List<EObject> eclasses = taskTraceClassesProperty.getEObjectListProperty(new ArrayList<EObject>());

			for (EObject eclass : eclasses) {
				if (eclass instanceof EClass) {
					taskTraceClasses.add((EClass) eclass);
				}
			}
		}

		return true;
	}

	private void loadProperties() {

		loadProviderProperties();

		loadTaskProperties();

		OrgUnitProperty dashboardSize = PreferenceManager.INSTANCE.getProperty(projectSpace,
			DashboardKey.DASHBOARD_SIZE);
		notificationSize.setSelection(dashboardSize.getIntegerProperty());

		OrgUnitProperty highlightPushed = PreferenceManager.INSTANCE.getProperty(projectSpace,
			DashboardKey.HIGHLIGHT_PUSHED_COMMENTS);
		highlightPersonalComments.setSelection(highlightPushed.getBooleanProperty());

		OrgUnitProperty showContainmentComments = PreferenceManager.INSTANCE.getProperty(projectSpace,
			DashboardKey.SHOW_CONTAINMENT_REPLIES);
		showContainmentReplies.setSelection(showContainmentComments.getBooleanProperty());

		OrgUnitProperty taskTraceLength = PreferenceManager.INSTANCE.getProperty(projectSpace,
			DashboardKey.TASKTRACE_LENGTH);
		this.taskTraceLength.setSelection(taskTraceLength.getIntegerProperty());

	}

	private void loadTaskProperties() {
		OrgUnitProperty showAI = PreferenceManager.INSTANCE.getProperty(projectSpace, DashboardKey.SHOW_AI_TASKS);
		showAITasks.setSelection(showAI.getBooleanProperty());

		OrgUnitProperty showBR = PreferenceManager.INSTANCE.getProperty(projectSpace, DashboardKey.SHOW_BR_TASKS);
		showBRTasks.setSelection(showBR.getBooleanProperty());

		OrgUnitProperty showI = PreferenceManager.INSTANCE.getProperty(projectSpace, DashboardKey.SHOW_ISSUE_TASKS);
		showIssueTasks.setSelection(showI.getBooleanProperty());

		OrgUnitProperty showWP = PreferenceManager.INSTANCE.getProperty(projectSpace, DashboardKey.SHOW_WP_TASKS);
		showWPTasks.setSelection(showWP.getBooleanProperty());

		OrgUnitProperty showOnlyReadyForReview = PreferenceManager.INSTANCE.getProperty(projectSpace,
			DashboardKey.SHOW_ONLY_READYFORREVIEW);
		this.showOnlyReadyForReview.setSelection(showOnlyReadyForReview.getBooleanProperty());
	}

	private void loadProviderProperties() {
		OrgUnitProperty taskProvider = PreferenceManager.INSTANCE.getProperty(projectSpace, DashboardKey.TASK_PROVIDER);
		providersTable.setChecked(DashboardKey.TASK_PROVIDER, taskProvider.getBooleanProperty());

		OrgUnitProperty taskChangeProvider = PreferenceManager.INSTANCE.getProperty(projectSpace,
			DashboardKey.TASK_CHANGE_PROVIDER);
		providersTable.setChecked(DashboardKey.TASK_CHANGE_PROVIDER, taskChangeProvider.getBooleanProperty());

		OrgUnitProperty taskReviewProvider = PreferenceManager.INSTANCE.getProperty(projectSpace,
			DashboardKey.TASK_REVIEW_PROVIDER);
		providersTable.setChecked(DashboardKey.TASK_REVIEW_PROVIDER, taskReviewProvider.getBooleanProperty());

		OrgUnitProperty taskTraceProvider = PreferenceManager.INSTANCE.getProperty(projectSpace,
			DashboardKey.TASK_TRACE_PROVIDER);
		providersTable.setChecked(DashboardKey.TASK_TRACE_PROVIDER, taskTraceProvider.getBooleanProperty());

		OrgUnitProperty subscriptionProvider = PreferenceManager.INSTANCE.getProperty(projectSpace,
			DashboardKey.SUBSCRIPTION_PROVIDER);
		providersTable.setChecked(DashboardKey.SUBSCRIPTION_PROVIDER, subscriptionProvider.getBooleanProperty());

		OrgUnitProperty commentsProvider = PreferenceManager.INSTANCE.getProperty(projectSpace,
			DashboardKey.COMMENTS_PROVIDER);
		providersTable.setChecked(DashboardKey.COMMENTS_PROVIDER, commentsProvider.getBooleanProperty());
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
		if (projectSpace == null || projectSpace.getUsersession() == null) {
			return true;
		}
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

}
