/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.changes;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.workspace.WorkspaceManager;

/**
 * A composite that displays a list of AbstactOperations with a TreeViewer.
 * 
 * @author Shterev
 */
public abstract class AbstractChangesComposite extends Composite implements ChangesComposite {

	/**
	 * do not show the affected elements composite.
	 */
	public static final int NONE = 0;
	/**
	 * show the affected elements composite under the tree viewer.
	 */
	public static final int VERTICAL = 1;
	/**
	 * show the affected elements composite to the right of the tree viewer.
	 */
	public static final int HORIZONTAL = 2;

	private List<ChangePackage> changePackages;
	private AdapterFactoryLabelProvider emfLabelProvider;
	private ChangePackageVisualizationHelper visualizationHelper;
	private TreeViewer treeViewer;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent composite
	 * @param style the style
	 * @param relatedElementsStyle the style for the related elements table - {@link #HORIZONTAL}, {@link #VERTICAL},
	 *            {@link #NONE}.
	 * @param changePackages the input ChangePackages
	 * @param contentProvider the content provider for this composite.
	 * @param checkable should the treeviewer be checkboxtreeviewer.
	 */
	public AbstractChangesComposite(Composite parent, int style, int relatedElementsStyle,
		List<ChangePackage> changePackages, IContentProvider contentProvider, boolean checkable) {
		super(parent, style);
		emfLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		visualizationHelper = new ChangePackageVisualizationHelper(changePackages, WorkspaceManager.getInstance()
			.getCurrentWorkspace().getActiveProjectSpace().getProject());

		boolean showAffected = (relatedElementsStyle > 0);
		int numColums = (showAffected ? relatedElementsStyle : 1);
		GridLayoutFactory.fillDefaults().numColumns(numColums).equalWidth(false).applyTo(this);
		TreeComposite treeComposite = null;
		if (checkable) {
			treeComposite = new CheckboxTreeComposite(this, style);
		} else {
			treeComposite = new TreeComposite(this, style);
		}
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(treeComposite);
		treeViewer = treeComposite.getTreeViewer();
		if (showAffected) {
			treeViewer.addSelectionChangedListener(new RelatedElementsListener(this, emfLabelProvider,
				visualizationHelper));
		}
		buildColumns(contentProvider);
		treeViewer.setInput(changePackages);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setInput(List<ChangePackage> changePackages) {
		this.changePackages = changePackages;
		visualizationHelper = new ChangePackageVisualizationHelper(changePackages, WorkspaceManager.getInstance()
			.getCurrentWorkspace().getActiveProjectSpace().getProject());
		if (changePackages != null) {
			treeViewer.setInput(changePackages);
			treeViewer.expandAll();
		}
	}

	/**
	 * Load the data and the columns to the tree viewer.
	 * 
	 * @param contentProvider the content provider for this tree.
	 */
	protected void buildColumns(IContentProvider contentProvider) {
		getTreeViewer().setContentProvider(contentProvider);
		ColumnViewerToolTipSupport.enableFor(getTreeViewer());
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ChangePackage> getChangePackages() {
		return changePackages;
	}

	/**
	 * @return the treeViewer
	 */
	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	/**
	 * @return the emfLabelProvider
	 */
	public AdapterFactoryLabelProvider getEmfLabelProvider() {
		return emfLabelProvider;
	}

	/**
	 * @return the visualizationHelper
	 */
	public ChangePackageVisualizationHelper getVisualizationHelper() {
		return visualizationHelper;
	}

}
