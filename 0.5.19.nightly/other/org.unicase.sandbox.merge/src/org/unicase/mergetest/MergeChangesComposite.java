/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.mergetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.views.changes.AbstractChangesComposite;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;
import org.unicase.workspace.ui.views.changes.ChangesComposite;
import org.unicase.workspace.ui.views.changes.DetailedChangesComposite;
import org.unicase.workspace.ui.views.changes.DetailedChangesContentProvider;
import org.unicase.workspace.ui.views.changes.MENameLabelProvider;
import org.unicase.workspace.ui.views.changes.OperationColorLabelProvider;
import org.unicase.workspace.ui.views.changes.OperationState;
import org.unicase.workspace.ui.views.changes.OperationsNameLabelProvider;

/**
 * Composite for the merge tree viewer.
 * 
 * @author Shterev
 */
public class MergeChangesComposite extends Composite implements
		ChangesComposite, ICheckStateListener, ISelectionChangedListener {

	private TabFolder folder;

	private HashMap<AbstractOperation, OperationState> operationStates;
	private HashMap<CheckboxTreeViewer, CheckboxTreeViewer> treeMap;

	private List<ChangePackage> theirChangePackages;
	private List<ChangePackage> myChangePackages;
	private List<AbstractOperation> theirOperations;
	private List<AbstractOperation> myOperations;

	private CheckboxTreeViewer myCompactTreeViewer;
	private CheckboxTreeViewer theirCompactTreeViewer;
	private CheckboxTreeViewer myDetailedTreeViewer;
	private CheckboxTreeViewer theirDetailedTreeViewer;

	private AdapterFactoryLabelProvider emfLabelProvider;
	private ChangePackageVisualizationHelper visualizationHelper;

	private ConflictDetector conflictDetector;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the composite's parent
	 * @param style
	 *            the style
	 * @param myChangePackages
	 *            the input of change packages as a list
	 * @param theirChangePackages
	 *            the input of change packages as a list
	 */
	public MergeChangesComposite(Composite parent, int style,
			List<ChangePackage> myChangePackages,
			List<ChangePackage> theirChangePackages) {
		super(parent, style);
		conflictDetector = new ConflictDetector();
		operationStates = new HashMap<AbstractOperation, OperationState>();
		treeMap = new HashMap<CheckboxTreeViewer, CheckboxTreeViewer>();
		this.myChangePackages = myChangePackages;
		this.theirChangePackages = theirChangePackages;

		theirOperations = getAllOperations(theirChangePackages);
		myOperations = getAllOperations(myChangePackages);

		// initialize the operation-state mapping
		initOperationStateMap(myChangePackages);
		initOperationStateMap(theirChangePackages);
		emfLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		ArrayList<ChangePackage> allChangePackages = new ArrayList<ChangePackage>();
		allChangePackages.addAll(myChangePackages);
		allChangePackages.addAll(theirChangePackages);
		visualizationHelper = new ChangePackageVisualizationHelper(
				allChangePackages, WorkspaceManager.getInstance()
						.getCurrentWorkspace().getActiveProjectSpace()
						.getProject());

		setLayout(new GridLayout());
		folder = new TabFolder(this, style);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				true).applyTo(folder);

		// createCompactTab();
		createDetailedTab();

		treeMap.put(myCompactTreeViewer, theirCompactTreeViewer);
		treeMap.put(theirCompactTreeViewer, myCompactTreeViewer);
		treeMap.put(myDetailedTreeViewer, theirDetailedTreeViewer);
		treeMap.put(theirDetailedTreeViewer, myDetailedTreeViewer);

	}

	private void createDetailedTab() {
		SashForm detailedTab = new SashForm(folder, SWT.HORIZONTAL);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(true)
				.applyTo(detailedTab);
		TabItem detailedTabItem = new TabItem(folder, SWT.NONE);
		detailedTabItem.setText("Detailed");
		detailedTabItem.setControl(detailedTab);
		DetailedChangesComposite myDetailedComposite = new DetailedChangesComposite(
				detailedTab, SWT.BORDER, AbstractChangesComposite.VERTICAL,
				this.myChangePackages, true);
		DetailedChangesComposite theirDetailedComposite = new DetailedChangesComposite(
				detailedTab, SWT.BORDER, AbstractChangesComposite.VERTICAL,
				this.theirChangePackages, true);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				true).applyTo(myDetailedComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				true).applyTo(theirDetailedComposite);
		detailedTab.setWeights(new int[] { 50, 50 });

		// override the labelprovider
		MENameLabelProvider labelProvider1 = new MENameLabelProvider(
				emfLabelProvider, visualizationHelper,
				new OperationColorLabelProvider(operationStates));
		myDetailedComposite.getMeColumn().setLabelProvider(labelProvider1);
		theirDetailedComposite.getMeColumn().setLabelProvider(labelProvider1);

		OperationsNameLabelProvider labelProvider2 = new OperationsNameLabelProvider(
				emfLabelProvider, visualizationHelper,
				new OperationColorLabelProvider(operationStates));
		myDetailedComposite.getOpColumn().setLabelProvider(labelProvider2);
		theirDetailedComposite.getOpColumn().setLabelProvider(labelProvider2);

		// expand the trees and add listeners
		myDetailedComposite.getTreeViewer().expandAll();
		myDetailedTreeViewer = (CheckboxTreeViewer) myDetailedComposite
				.getTreeViewer();
		myDetailedTreeViewer.addCheckStateListener(this);
		myDetailedTreeViewer.addSelectionChangedListener(this);

		theirDetailedComposite.getTreeViewer().expandAll();
		theirDetailedTreeViewer = (CheckboxTreeViewer) theirDetailedComposite
				.getTreeViewer();
		theirDetailedTreeViewer.addCheckStateListener(this);
		theirDetailedTreeViewer.addSelectionChangedListener(this);

	}

	private void initOperationStateMap(List<ChangePackage> cps) {
		for (ChangePackage p : cps) {
			for (AbstractOperation op : p.getOperations()) {
				operationStates.put(op, new OperationState());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void checkStateChanged(CheckStateChangedEvent event) {
		Object element = event.getElement();
		CheckboxTreeViewer checkBoxViewer = (CheckboxTreeViewer) event
				.getSource();

		// check/uncheck the parent acc. to its children's state
		if (element instanceof ChangePackage) {
			Object[] elements = ((DetailedChangesContentProvider) checkBoxViewer
					.getContentProvider()).getChildren(element);
			for (Object op : elements) {
				checkBoxViewer.setChecked(op, event.getChecked());
			}
		}
		if (element instanceof AbstractOperation) {
			EObject container = ((AbstractOperation) element).eContainer();
			Object[] elements = ((DetailedChangesContentProvider) checkBoxViewer
					.getContentProvider()).getChildren(container);
			int checked = 0;
			for (Object o : elements) {
				if (checkBoxViewer.getChecked(o)) {
					checked++;
				}
			}
			if (checked == elements.length) {
				checkBoxViewer.setGrayChecked(container, false);
				checkBoxViewer.setChecked(container, true);
			} else if (checked > 0) {
				checkBoxViewer.setChecked(container, false);
				checkBoxViewer.setGrayChecked(container, true);
			} else {
				checkBoxViewer.setGrayChecked(container, false);
				checkBoxViewer.setChecked(container, false);
			}
		}

		// check all required && uncheck all conflicting
		if (event.getChecked()) {
			if (element instanceof ChangePackage) {
				ChangePackage p = (ChangePackage) element;
				for (AbstractOperation op : p.getOperations()) {
					checkOperation(checkBoxViewer, op);
				}
			} else if (element instanceof AbstractOperation) {
				AbstractOperation op = (AbstractOperation) element;
				checkOperation(checkBoxViewer, op);
			}
		}
	}

	private void checkOperation(CheckboxTreeViewer viewer,
			AbstractOperation selected) {
		List<AbstractOperation> from = null;
		List<AbstractOperation> to = null;
		if (viewer.equals(myCompactTreeViewer)
				|| viewer.equals(myDetailedTreeViewer)) {
			from = myOperations;
			to = theirOperations;
		} else if (viewer.equals(theirCompactTreeViewer)
				|| viewer.equals(theirDetailedTreeViewer)) {
			from = theirOperations;
			to = myOperations;
		}
		List<AbstractOperation> required = conflictDetector.getRequired(from,
				selected);
		for (AbstractOperation op : required) {
			viewer.setChecked(op, true);
			checkStateChanged(new CheckStateChangedEvent(viewer, op, true));
		}
		required.add(selected);
		Set<AbstractOperation> conflicting = conflictDetector.getConflicting(
				required, to);
		for (AbstractOperation op : conflicting) {
			final CheckboxTreeViewer checkboxTreeViewer = treeMap.get(viewer);
			checkboxTreeViewer.setChecked(op, false);
			checkStateChanged(new CheckStateChangedEvent(checkboxTreeViewer,
					op, false));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		Object element = ((IStructuredSelection) event.getSelection())
				.getFirstElement();
		CheckboxTreeViewer viewer = (CheckboxTreeViewer) event.getSource();

		// clear all operations
		for (AbstractOperation op : myOperations) {
			operationStates.get(op).setPreviewState(OperationState.NONE);
		}
		for (AbstractOperation op : theirOperations) {
			operationStates.get(op).setPreviewState(OperationState.NONE);
		}

		if (element instanceof ChangePackage) {
			ChangePackage p = (ChangePackage) element;
			for (AbstractOperation op : p.getOperations()) {
				markOperation(viewer, op);
			}

		} else if (element instanceof AbstractOperation) {
			AbstractOperation selected = (AbstractOperation) element;
			markOperation(viewer, selected);
		}
		viewer.refresh(true);
		treeMap.get(viewer).refresh(true);
	}

	private void markOperation(CheckboxTreeViewer viewer,
			AbstractOperation selected) {
		treeMap.get(viewer).setSelection(null);
		List<AbstractOperation> from = null;
		List<AbstractOperation> to = null;
		if (viewer.equals(myCompactTreeViewer)
				|| viewer.equals(myDetailedTreeViewer)) {
			from = myOperations;
			to = theirOperations;
		} else if (viewer.equals(theirCompactTreeViewer)
				|| viewer.equals(theirDetailedTreeViewer)) {
			from = theirOperations;
			to = myOperations;
		}
		List<AbstractOperation> required = conflictDetector.getRequired(from,
				selected);
		for (AbstractOperation op : required) {
			if (!viewer.getChecked(op)) {
				operationStates.get(op)
						.setPreviewState(OperationState.ACCEPTED);
			}
		}
		required.add(selected);
		Set<AbstractOperation> conflicting = conflictDetector.getConflicting(
				required, to);
		for (AbstractOperation op : conflicting) {
			if (treeMap.get(viewer).getChecked(op)) {
				operationStates.get(op)
						.setPreviewState(OperationState.REJECTED);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ChangePackage> getChangePackages() {
		return null; // there are two kinds of input (my changes and their
		// changes), so nothing is returned.
	}

	/**
	 * {@inheritDoc}
	 */
	public void setInput(List<ChangePackage> changes) {
		// do nothing.
	}

	private List<AbstractOperation> getAllOperations(
			List<ChangePackage> packages) {
		ArrayList<AbstractOperation> ret = new ArrayList<AbstractOperation>();
		for (ChangePackage cp : packages) {
			ret.addAll(cp.getOperations());
		}
		return ret;
	}

	/**
	 * @return the result of the merging in the form of a HashMap. Three lists
	 *         are returned mapped by the keys "theirs", "mineChecked",
	 *         theirsNotChecked
	 *         " ->> "theirs" being all new changes from the server, "
	 *         mineChecked
	 *         " - all local changes that were selected, "theirsNotChecked" -
	 *         all remote changes that were declined.
	 */
	public HashMap<String, List<AbstractOperation>> getResultSet() {
		HashMap<String, List<AbstractOperation>> ret = new HashMap<String, List<AbstractOperation>>();

		ret.put("theirs", theirOperations);

		List<AbstractOperation> mineChecked = getChecked(myDetailedTreeViewer);
		ret.put("mineChecked", mineChecked);

		List<AbstractOperation> theirsChecked = getChecked(theirDetailedTreeViewer);
		List<AbstractOperation> theirsNotChecked = new ArrayList<AbstractOperation>();
		theirsNotChecked.addAll(theirOperations);
		theirsNotChecked.removeAll(theirsChecked);
		ret.put("theirsNotChecked", theirsNotChecked);

		return ret;
	}

	private List<AbstractOperation> getChecked(CheckboxTreeViewer viewer) {
		ArrayList<AbstractOperation> checked = new ArrayList<AbstractOperation>();
		for (Object o : viewer.getCheckedElements()) {
			if (o instanceof AbstractOperation) {
				checked.add((AbstractOperation) o);
			}
		}
		return checked;
	}

	/**
	 * Selects all local ops.
	 */
	public void selectAllMine() {
		myDetailedTreeViewer.expandAll();
		theirDetailedTreeViewer.expandAll();
		for (Object o : myDetailedTreeViewer.getVisibleExpandedElements()) {
			myDetailedTreeViewer.setSubtreeChecked(o, true);
		}
		for (Object o : theirDetailedTreeViewer.getVisibleExpandedElements()) {
			theirDetailedTreeViewer.setSubtreeChecked(o, false);
		}
	}

	/**
	 * Selects all remote ops.
	 */
	public void selectAllTheirs() {
		myDetailedTreeViewer.expandAll();
		theirDetailedTreeViewer.expandAll();
		for (Object o : myDetailedTreeViewer.getVisibleExpandedElements()) {
			myDetailedTreeViewer.setSubtreeChecked(o, false);
		}
		for (Object o : theirDetailedTreeViewer.getVisibleExpandedElements()) {
			theirDetailedTreeViewer.setSubtreeChecked(o, true);
		}
	}
}
