/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.views.changescomposite;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Tree;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.workspace.WorkspaceManager;

/**
 * This class is a composite containing a TreeViewer which shows operations of
 * an input list of ChangePackages. This composite will be shown on
 * UpdateDialog, CommitDialog and ChangeBrowserView's browser tab. TreeViewer
 * has columns for ModelElement, Name and Description of the Operation.
 * 
 * @author Hodaie
 * @author Shterev
 * 
 */
public class ChangesTreeComposite extends Composite {

	// input ChangePackages
	private List<ChangePackage> changePackages;
	private ChangePackageVisualizationHelper visualizationHelper;
	private TabFolder folder;
	private AdapterFactoryLabelProvider emfLabelProvider;
	private TreeViewer activeTreeViewer;
	private HashMap<TabItem, TreeViewer> tabTreeMap;
	private List<ChangePackage> input;
	private TreeViewerColumn tclmOp;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            parent
	 * @param style
	 *            style
	 * @param changePackages
	 *            the initial input for this composite
	 */
	public ChangesTreeComposite(Composite parent, int style,
			List<ChangePackage> changePackages) {
		super(parent, style);
		setLayout(new GridLayout());
		folder = new TabFolder(this, style);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				true).applyTo(folder);
		emfLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		this.visualizationHelper = new ChangePackageVisualizationHelper(
				changePackages, WorkspaceManager.getInstance()
						.getCurrentWorkspace().getActiveProjectSpace()
						.getProject());
		tabTreeMap = new HashMap<TabItem, TreeViewer>();

		createModelElementTab(style);

		createOperationsTab(style);

		folder.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {

			}

			public void widgetSelected(SelectionEvent e) {
				TabItem tab = folder.getSelection()[0];
				activeTreeViewer = tabTreeMap.get(tab);
			}

		});

	}

	private void createOperationsTab(int style) {
		Composite opComposite = new Composite(folder, style);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false)
				.applyTo(opComposite);
		TabItem opTab = new TabItem(folder, style);
		opTab.setText("Detailed");
		opTab.setControl(opComposite);
		TreeViewer opTree = createTreeViewer(opComposite);
		initTreeViewer(opTree, ChangesTreeContentProvider.DETAILED);
		
		tclmOp = new TreeViewerColumn(opTree, SWT.NONE);
		tclmOp.getColumn().setText("Operation");
		tclmOp.getColumn().setWidth(getShell().getSize().x / 2);
		tclmOp.setLabelProvider(new OperationsNameLabelProvider(
				emfLabelProvider, visualizationHelper));
		tabTreeMap.put(opTab, opTree);
		activeTreeViewer = opTree;
	}
	
	private void createModelElementTab(int style) {
		Composite meComposite = new Composite(folder, style);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false)
				.applyTo(meComposite);
		TabItem meTab = new TabItem(folder, style);
		meTab.setText("Compact");
		meTab.setControl(meComposite);
		TreeViewer meTree = createTreeViewer(meComposite);
		initTreeViewer(meTree, ChangesTreeContentProvider.COMPACT);
		tabTreeMap.put(meTab, meTree);
	}

	/**
	 * Method for creating a {@link TreeViewer}.
	 * 
	 * @param parent
	 *            where the viewer should be created
	 * @return the {@link TreeViewer}
	 */
	protected TreeViewer createTreeViewer(Composite parent) {
		TreeViewer treeViewer = new TreeViewer(parent, SWT.FULL_SELECTION);
		return treeViewer;

	}

	/**
	 * Load the data and the additional columns to the tree viewer.
	 * 
	 * @param treeViewer
	 *            the viewer.
	 * @param the
	 *            context of the content - @see
	 *            {@link ChangesTreeContentProvider}
	 */
	private void initTreeViewer(final TreeViewer treeViewer, int context) {

		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		ChangesTreeContentProvider provider = new ChangesTreeContentProvider(
				context);
		treeViewer.setContentProvider(provider);
		treeViewer
				.addSelectionChangedListener(new ChangesTreeSelectionListener(
						treeViewer, emfLabelProvider, visualizationHelper));

		// the changed model element
		TreeViewerColumn tclmME = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmME.getColumn().setWidth(300);
		tclmME.getColumn().setText("ModelElement");
		tclmME.setLabelProvider(new ChangesTreeLabelProvider(emfLabelProvider,visualizationHelper));

		ColumnViewerToolTipSupport.enableFor(treeViewer);

		createAdditionalColumns(treeViewer);
		treeViewer.expandAll();
	}

	/**
	 * Subclasses must override this method to creates additional columns.
	 * 
	 * @param treeViewer
	 *            the parent tree viewer for the additional columns
	 */
	protected void createAdditionalColumns(TreeViewer treeViewer) {
	}

	/**
	 * get number of operations to show at top of tree.
	 * 
	 * @return number of operations
	 */
	public int getNumOfChanges() {
		int sum = 0;
		if (changePackages != null) {
			for (ChangePackage cp : changePackages) {
				sum += cp.getOperations().size();
			}
		}
		return sum;
	}

	/**
	 * Set input ChangePackage whose operations will be shown in tree.
	 * 
	 * @param changePackages
	 *            the input ChangePackages
	 */
	@SuppressWarnings("cast")
	public void setInput(List<ChangePackage> changePackages) {
		this.changePackages = changePackages;
		this.visualizationHelper = new ChangePackageVisualizationHelper(
				changePackages, WorkspaceManager.getInstance()
						.getCurrentWorkspace().getActiveProjectSpace()
						.getProject());
		if (changePackages != null) {
			for (TabItem ti : tabTreeMap.keySet()) {
				TreeViewer treeViewer = (TreeViewer) tabTreeMap.get(ti);
				treeViewer.setInput(changePackages);
				treeViewer.expandAll();
			}
			this.input = changePackages;
		}
	}

	/**
	 * Getter for the change packages.
	 * 
	 * @return input ChangePackages
	 */
	public List<ChangePackage> getChangePackages() {
		return changePackages;
	}

	/**
	 * Getter for this composite's input.
	 * 
	 * @return the input.
	 */
	public List<ChangePackage> getInput() {
		return input;
	}

	/**
	 * Getter for this composite's active TreeViewer.
	 * 
	 * @return the TreeViewer.
	 */
	public TreeViewer getActiveTreeViewer() {
		return activeTreeViewer;
	}

}
