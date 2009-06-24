/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.prefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.PropertyPage;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.util.ModelUtil;
import org.unicase.ui.common.MEClassLabelProvider;
import org.unicase.workspace.util.RecordingCommandWithResult;

/**
 * A property page for the dashboard.
 * 
 * @author Shterev
 */
public class DashboardPropertyPage extends PropertyPage {

	private static final String TASK_PROVIDER = "Assignment Tasks";
	private static final String TASK_CHANGE_PROVIDER = "Task changes";
	private static final String TASK_TRACE_PROVIDER = "Task traces";
	private static final String TASK_REVIEW_PROVIDER = "Review Tasks";
	private static final String SUBSCRIPTION_PROVIDER = "Subscriptions";
	private static final String COMMENTS_PROVIDER = "Comments";
	private static final String PUSHED_COMMENTS_PROVIDER = "Personal comments";
	private HashMap<String, String> providerHints;
	private AdapterFactoryLabelProvider labelProvider;
	private Project project;
	//private ProjectSpaceImpl projectSpace;
	private ArrayList<ModelElement> subscriptions;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createContents(Composite parent) {

		GridLayoutFactory.fillDefaults().applyTo(parent);
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

		return folder;
	}

	private Control createSubscriptionProviderTab(TabFolder folder) {
		if (subscriptions == null) {
			subscriptions = new ArrayList<ModelElement>();
		}

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

		return root;
	}

	private Control createTaskTraceProviderTab(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);

		Composite lengthComposite = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(lengthComposite);
		Label lengthLabel = new Label(lengthComposite, SWT.WRAP);
		lengthLabel.setText("Maximum trace length:");
		Spinner lengthSpinner = new Spinner(lengthComposite, SWT.WRAP);
		lengthSpinner.setMinimum(1);
		lengthSpinner.setMaximum(200);

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
		final ArrayList<EClass> selectedClasses = new ArrayList<EClass>();
		addType.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), meClassLabelProvider);
				dialog.setBlockOnOpen(true);
				dialog.setMultipleSelection(true);
				ArrayList<EClass> subclasses = ModelUtil.getSubclasses(ModelPackage.eINSTANCE.getModelElement());
				subclasses.removeAll(selectedClasses);
				dialog.setElements(subclasses.toArray());
				if (dialog.open() == Window.OK) {
					selectedClasses.addAll((List<? extends EClass>) Arrays.asList(dialog.getResult()));
					elementTypes.setInput(selectedClasses.toArray());
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
				dialog.setElements(selectedClasses.toArray());
				if (dialog.open() == Window.OK) {
					selectedClasses.removeAll(Arrays.asList(dialog.getResult()));
					elementTypes.setInput(selectedClasses.toArray());
				}
			}
		});

		return root;
	}

	private Control createTaskProvidersTab(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);

		Button showBR = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(showBR);
		showBR.setText("Show notifications for new BugReports");

		Button showAI = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(showAI);
		showAI.setText("Show notifications for new ActionItems");

		Button showIssues = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(showIssues);
		showIssues.setText("Show notifications for new Issues");

		Button showWP = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(showWP);
		showWP.setText("Show notifications for new WorkPackages");

		Button showReviewer = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(showReviewer);
		showReviewer.setText("Do not show reviewer tasks until they are ready for review");

		return root;
	}

	private Control createCommentProvidersTab(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);

		Button showContainmentReplies = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(showContainmentReplies);
		showContainmentReplies.setText("Show notifications for every reply in the thread tree");

		Button highlightPM = new Button(root, SWT.CHECK | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(highlightPM);
		highlightPM.setText("Hightlight personal comments");

		return root;
	}

	private Control createGeneralTab(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);

		Composite sizeComposite = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(sizeComposite);
		Label sizeLabel = new Label(sizeComposite, SWT.WRAP);
		sizeLabel.setText("Maximum number of notifications on the dashboard:");
		Spinner sizeSpinner = new Spinner(sizeComposite, SWT.WRAP);
		sizeSpinner.setMinimum(1);
		sizeSpinner.setMaximum(200);

		Label title = new Label(root, SWT.WRAP);
		title.setText("Active notification types:");
		GridDataFactory.fillDefaults().grab(true, false).applyTo(title);

		CheckboxTableViewer availProviders = CheckboxTableViewer.newCheckList(root, SWT.SINGLE | SWT.RESIZE
			| SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(availProviders.getControl());
		availProviders.setContentProvider(new ArrayContentProvider());
		availProviders.setInput(providerHints.keySet());

		final Label hint = new Label(root, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(hint);
		hint.setText("Hint: Select an item to view its description");

		availProviders.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Object object = ((IStructuredSelection) event.getSelection()).getFirstElement();
				if (object instanceof String) {
					hint.setText(providerHints.get(object) + "");
					root.layout();
				}
			}
		});

		return root;
	}

	private boolean init() {
		if (!(getElement() instanceof Project)) {
			return false;
		}

		project = (Project) getElement();

		//projectSpace = (ProjectSpaceImpl) WorkspaceManager.getProjectSpace(project);
		providerHints = new HashMap<String, String>();

		providerHints.put(TASK_PROVIDER, "Shows notifications for tasks that have been assigned to you.");
		providerHints.put(TASK_CHANGE_PROVIDER, "Shows notifications for changes on tasks you have been assigned to.");
		providerHints.put(TASK_TRACE_PROVIDER, "Shows notifications for elements that are related to your tasks.");
		providerHints.put(TASK_REVIEW_PROVIDER, "Shows notifications for tasks that you have to review.");
		providerHints.put(SUBSCRIPTION_PROVIDER,
			"Allows you to subscribe to arbitrary model elements and receive notifications upon their changes.");
		providerHints.put(COMMENTS_PROVIDER,
			"Shows notifications for new comments regarding your tasks or a discussion you participate in.");
		providerHints.put(PUSHED_COMMENTS_PROVIDER, "Shows comments that were personally sent to you.");

//		//ModelElementId[] subscriptionsIds = projectSpace.getModelElementIdArrayProperty("dashboardSubscriptions");
//		if (subscriptionsIds != null) {
//			subscriptions = new ArrayList<ModelElement>();
//			for (ModelElementId id : subscriptionsIds) {
//				ModelElement modelElement = project.getModelElement(id);
//				if (modelElement != null) {
//					subscriptions.add(modelElement);
//				}
//			}
//		}

		return true;

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

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		final RecordingCommandWithResult<Object> command = new RecordingCommandWithResult<Object>(domain) {

			@Override
			protected void doExecute() {
				//String prefix = "dashboard";
				if (subscriptions != null) {
					ArrayList<ModelElementId> subscriptionsIds = new ArrayList<ModelElementId>();
					for (ModelElement me : subscriptions) {
						subscriptionsIds.add(me.getModelElementId());
					}
					//projectSpace.setProperty(prefix + "Subscriptions", subscriptionsIds.toArray(new ModelElementId[0]));
				}
			}
		};
		domain.getCommandStack().execute(command);

		return true;
	}

}
