/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.unicase.model.changetracking.ChangeTrackingRelease;

public class ReleaseTreeViewer extends Composite{

	private static Image ACTION_ITEM_ICON = Activator.getImageDescriptor("icons/full/obj16/ActionItem.png").createImage();
	private static Image CHANGE_TRACKING_RELEASE_ICON = Activator.getImageDescriptor("icons/full/obj16/ChangeTrackingRelease.gif").createImage();
	private static Image EXPAND_ALL_ICON = Activator.getImageDescriptor("icons/expandall.gif").createImage();
	private static Image COLLAPSE_ALL_ICON = Activator.getImageDescriptor("icons/collapseall.png").createImage();
	
	private ToolBar toolbar;
	private TreeViewer treeViewer;
//	private ToolItem showRootButton;
	private ToolItem showWorkItemsButton;
	private ToolItem expandAllButton;
	private ToolItem collapseAllButton;
	private FullReleaseContentProvider contentProvider;
	private ImageAndTextLabel captionLabel;

	public ReleaseTreeViewer(Composite parent, int style) {
		super(parent, style);
		
		GridLayoutFactory.fillDefaults().spacing(0, 0).numColumns(2).applyTo(this);
		//Color colorWhite = parent.getDisplay().getSystemColor(SWT.COLOR_WHITE);
		//this.setBackground(colorWhite);
		
		//Caption label
		captionLabel = new ImageAndTextLabel(this, SWT.NONE);
		GridDataFactory.fillDefaults().indent(5, 0).align(SWT.LEFT, SWT.CENTER).applyTo(captionLabel);

		//Toolbar
		toolbar = new ToolBar(this, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.RIGHT, SWT.FILL).applyTo(toolbar);
		//toolbar.setBackground(colorWhite);
		
//		showRootButton = new ToolItem(toolbar, SWT.CHECK);
//		showRootButton.setImage(CHANGE_TRACKING_RELEASE_ICON);
//		showRootButton.setSelection(true);
//		showRootButton.setToolTipText("Toggle showing the release node itself");
		showWorkItemsButton = new ToolItem(toolbar, SWT.CHECK);
		showWorkItemsButton.setImage(ACTION_ITEM_ICON);
		showWorkItemsButton.setSelection(true);
		showWorkItemsButton.setToolTipText("Toggle showing work items or only their change packages");
		new ToolItem(toolbar, SWT.SEPARATOR);
		expandAllButton = new ToolItem(toolbar, SWT.NONE);
		expandAllButton.setImage(EXPAND_ALL_ICON);
		collapseAllButton = new ToolItem(toolbar, SWT.NONE);
		collapseAllButton.setImage(COLLAPSE_ALL_ICON);
		
		//Tree Viewer
		treeViewer = new TreeViewer(this);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).span(2, 1).applyTo(treeViewer.getControl());
		
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		
		treeViewer.setLabelProvider(labelProvider);
		contentProvider = new FullReleaseContentProvider();
		treeViewer.setContentProvider(contentProvider);
		
		captionLabel.setLabelProvider(labelProvider);
		
		addListeners();
	}

	private void addListeners() {
//		showRootButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				boolean show = showRootButton.getSelection();
//				contentProvider.setShowRoot(show);
//				treeViewer.refresh();
//			}	
//		});
		showWorkItemsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean show = showWorkItemsButton.getSelection();
				contentProvider.setShowWorkItems(show);
				treeViewer.refresh();
			}
		});
		expandAllButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				treeViewer.expandAll();
			}
		});
		collapseAllButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				treeViewer.collapseAll();
			}
		});
	}

	public void setInput(ChangeTrackingRelease release){
		treeViewer.setInput(new Object[]{release});
		captionLabel.setInput(release);
	}

	public void expandAll() {
		treeViewer.expandAll();		
	}
	
	public void setLabelProvider(ILabelProvider labelProvider){
		treeViewer.setLabelProvider(labelProvider);
	}
	
	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {
		// TODO Auto-generated method stub
		return super.computeSize(wHint, hHint, changed);
	}
	
}
