/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.commands.ActionHelper;

/**.
 * 
 * This class provides contents of hierarchy tab in Status view. It contains a
 * TreeViewer. 
 * For a WorkPackage as input model element, the TreeViewer shows 
 * a hierarchical view of all model elements being annotated by WorkItems 
 * contained in this WorckPackage. 
 * For a model element as input, the TreeViewer just shows a hierarchical 
 * view of all its openers as returned by OpeningLinkTaxonomy.getOpeners()
 * I believe that for a model element as input there should also be an implementation
 * like that of a WorkPackage, i.e. for every opener that is an Annotation, 
 * instead of this opener its annotated model elements should be shown. This is
 * implemented but currently commented out. 
 * 
 * @author Hodaie
 *
 */
public class HierarchyTabComposite extends Composite {

	private TreeViewer treeViewer;
	//private ModelElement input;
	
	/**.
	 * Constructor
	 * @param parent parent
	 * @param style style
	 */
	public HierarchyTabComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTree();
		
	}

	
	private void createTree() {
		treeViewer = new TreeViewer(this, SWT.BORDER);
		treeViewer.getTree().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		
		treeViewer.setLabelProvider(new HierarchyTabLabelProvider());
		treeViewer.setContentProvider(new HierarchyTabContentProvider());
		//sort contents
		treeViewer.setComparator(new ViewerComparator());
		
		hookDoubleClick();
		
	}

	//on double-click open the selection
	private void hookDoubleClick() {
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				ActionHelper.openModelElement((ModelElement) sel
						.getFirstElement());
			}

		});
	}
	
	/**.
	 * set input to TreeViewer
	 * 
	 * @param me input model element
	 */
	public void setInput(ModelElement me) {
		//this.input = me;
		treeViewer.setInput(me);
	
	}

}
