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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.unicase.model.changetracking.Release;

/**
 * 
 * Composite widget which is used in the check release and build release views.
 * Contains a tree viewer which shows a release->work item->change package tree
 * from an input release. The root (release) in this tree is omitted. Instead,
 * the icon and name of the release are displayed above the tree viewer in an
 * own caption label. In addition, the widget provides buttons to expand and
 * collapse the tree and to hide the work items or the release itself in the
 * tree.
 * 
 * @author jfinis
 * 
 */
public class ReleaseTreeViewer extends Composite {

	/* Images */
	private static final Image ACTION_ITEM_ICON = Activator.getImageDescriptor("icons/full/obj16/ActionItem.png").createImage();
	private static final Image EXPAND_ALL_ICON = Activator.getImageDescriptor("icons/expandall.gif").createImage();
	private static final Image COLLAPSE_ALL_ICON = Activator.getImageDescriptor("icons/collapseall.png").createImage();

	private ToolBar toolbar;
	private TreeViewer treeViewer;
	private ToolItem showWorkItemsButton;
	private ToolItem expandAllButton;
	private ToolItem collapseAllButton;
	private FullReleaseContentProvider contentProvider;
	private ImageAndTextLabel captionLabel;

	/**
	 * Default constructor.
	 * 
	 * @param parent parent widget
	 * @param style style constants
	 */
	public ReleaseTreeViewer(Composite parent, int style) {
		super(parent, style);

		GridLayoutFactory.fillDefaults().spacing(0, 0).numColumns(2).applyTo(this);

		// Caption label
		captionLabel = new ImageAndTextLabel(this, SWT.NONE);
		GridDataFactory.fillDefaults().indent(5, 0).align(SWT.LEFT, SWT.CENTER).applyTo(captionLabel);

		// Toolbar
		toolbar = new ToolBar(this, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.RIGHT, SWT.FILL).applyTo(toolbar);

		showWorkItemsButton = new ToolItem(toolbar, SWT.CHECK);
		showWorkItemsButton.setImage(ACTION_ITEM_ICON);
		showWorkItemsButton.setSelection(true);
		showWorkItemsButton.setToolTipText("Toggle showing work items or only their change packages");
		new ToolItem(toolbar, SWT.SEPARATOR);
		expandAllButton = new ToolItem(toolbar, SWT.NONE);
		expandAllButton.setImage(EXPAND_ALL_ICON);
		collapseAllButton = new ToolItem(toolbar, SWT.NONE);
		collapseAllButton.setImage(COLLAPSE_ALL_ICON);

		// Tree Viewer
		treeViewer = new TreeViewer(this);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).span(2, 1).applyTo(treeViewer.getControl());

		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		treeViewer.setLabelProvider(labelProvider);
		contentProvider = new FullReleaseContentProvider();
		treeViewer.setContentProvider(contentProvider);

		captionLabel.setLabelProvider(labelProvider);

		addListeners();
	}

	/**
	 * Adds listeners to all buttons. Called during initialization.
	 */
	private void addListeners() {
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

	/**
	 * Sets the input release to be displayed.
	 * 
	 * @param release input release
	 */
	public void setInput(Release release) {
		treeViewer.setInput(new Object[] { release });
		captionLabel.setInput(release);
	}

	/**
	 * Expands the tree.
	 */
	public void expandAll() {
		treeViewer.expandAll();
	}

	/**
	 * Sets a label provider for the tree viewer.
	 * 
	 * @param labelProvider label provider
	 */
	public void setLabelProvider(ILabelProvider labelProvider) {
		treeViewer.setLabelProvider(labelProvider);
	}

}
