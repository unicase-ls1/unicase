/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.views.changes;

import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;

/**
 * Composite for the merge tree viewer.
 * 
 * @author Shterev
 * 
 */
public class MergeChangesComposite extends Composite implements
		ChangesComposite, ICheckStateListener, ISelectionChangedListener {

	private TabFolder folder;
	private SashForm detailedTab;
	private SashForm compactTab;

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

		setLayout(new GridLayout());
		folder = new TabFolder(this, style);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				true).applyTo(folder);

		compactTab = new SashForm(folder, SWT.HORIZONTAL);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(true)
				.applyTo(compactTab);
		TabItem compactTabItem = new TabItem(folder, style);
		compactTabItem.setText("Compact");
		compactTabItem.setControl(compactTab);

		CompactChangesComposite myCompactComposite = new CompactChangesComposite(
				compactTab, SWT.NONE, AbstractChangesComposite.HORIZONTAL,
				myChangePackages, true);
		CompactChangesComposite theirCompactComposite = new CompactChangesComposite(
				compactTab, SWT.NONE, AbstractChangesComposite.HORIZONTAL,
				theirChangePackages, true);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				true).applyTo(myCompactComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				true).applyTo(theirCompactComposite);
		compactTab.setWeights(new int[] { 50, 50 });

		myCompactComposite.getTreeViewer().expandAll();
		CheckboxTreeViewer myCompactTreeViewer = (CheckboxTreeViewer) myCompactComposite
				.getTreeViewer();
		myCompactTreeViewer.addCheckStateListener(this);
		myCompactTreeViewer.addSelectionChangedListener(this);

		theirCompactComposite.getTreeViewer().expandAll();
		CheckboxTreeViewer theirCompactTreeViewer = (CheckboxTreeViewer) theirCompactComposite
				.getTreeViewer();
		theirCompactTreeViewer.addCheckStateListener(this);
		theirCompactTreeViewer.addSelectionChangedListener(this);

		detailedTab = new SashForm(folder, SWT.HORIZONTAL);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(true)
				.applyTo(detailedTab);
		TabItem detailedTabItem = new TabItem(folder, style);
		detailedTabItem.setText("Detailed");
		detailedTabItem.setControl(detailedTab);

		DetailedChangesComposite myDetailedComposite = new DetailedChangesComposite(
				detailedTab, SWT.NONE, AbstractChangesComposite.HORIZONTAL,
				myChangePackages, true);
		DetailedChangesComposite theirDetailedComposite = new DetailedChangesComposite(
				detailedTab, SWT.NONE, AbstractChangesComposite.HORIZONTAL,
				theirChangePackages, true);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				true).applyTo(myDetailedComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				true).applyTo(theirDetailedComposite);
		detailedTab.setWeights(new int[] { 50, 50 });

		myDetailedComposite.getTreeViewer().expandAll();
		CheckboxTreeViewer myDetailedTreeViewer = (CheckboxTreeViewer) myDetailedComposite
				.getTreeViewer();
		myDetailedTreeViewer.addCheckStateListener(this);
		myDetailedTreeViewer.addSelectionChangedListener(this);

		theirDetailedComposite.getTreeViewer().expandAll();
		CheckboxTreeViewer theirDetailedTreeViewer = (CheckboxTreeViewer) theirDetailedComposite
				.getTreeViewer();
		theirDetailedTreeViewer.addCheckStateListener(this);
		theirDetailedTreeViewer.addSelectionChangedListener(this);

	}

	// // currently status column is set using a random boolean
	// statusColumn.setLabelProvider(new ColumnLabelProvider() {
	// @Override
	// public Color getForeground(Object element) {
	// if(element instanceof AbstractOperation){
	// AbstractOperation op = (AbstractOperation)element;
	// return
	// (op.isAccepted()?Display.getCurrent().getSystemColor(SWT.COLOR_GREEN
	// ):Display.getCurrent().getSystemColor(SWT.COLOR_RED));
	// }else{
	// return super.getForeground(element);
	// }
	//				
	// }
	//
	// @Override
	// public String getText(Object element) {
	// if(element instanceof AbstractOperation){
	// AbstractOperation op = (AbstractOperation) element;
	// return (op.isAccepted()?"Accepted":"Rejected");
	// }
	// return "";
	// }
	//			
	// });

	/**
	 * {@inheritDoc}
	 */
	public void checkStateChanged(CheckStateChangedEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		// TODO Auto-generated method stub

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

}
