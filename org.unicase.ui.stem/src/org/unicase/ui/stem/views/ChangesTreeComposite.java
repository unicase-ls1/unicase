/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;


/**.
 * This class is a composite containing a TreeViewer which shows operations
 * of an input ChangePacage. This composite will be shown on UpdateDialog, 
 * CommitDialog, MergDialog, and ChangeBrowserView's browser tab. 
 * Currently contents of this tree comes from a dummy implementation. 
 * TreeViewer has columns for Name, Description, UserName and Status of
 * an Operation. In the dummy implementation the Status is just a random 
 * boolean value. 
 * MergeDialog has three instances of this composite (my changes, 
 * merged changes, their changes). The tree in the middles show no columns.
 * This is set using showColumn flag of composite's contructor. 
 * 
 * @author Hodaie
 *
 */
public class ChangesTreeComposite extends Composite {

	private TreeViewer treeViewer;
	//number of changes will be shown over TreeViewer
	private int numOfChanges;
	//if description, user and status columns should be shown.
	private boolean showColumns;
	
	//input ChangePackage
	private ChangePackage changePackage;


	/**.
	 * Constructor
	 * @param parent parent
	 * @param style style
	 * @param showColumns if description, user and status columns should be shown.
	 */
	public ChangesTreeComposite(Composite parent, int style, boolean showColumns) {
		super(parent, style);
		this.setLayout(new GridLayout());
		this.showColumns = showColumns;
		createTreeViewer();
		
		
	}
	
	
	private void createTreeViewer() {
		treeViewer = new TreeViewer(this, SWT.FULL_SELECTION);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		treeViewer.setContentProvider(new ChangesTreeContentProvider());
		
		//operation's name.
		//if showColumns is false, this will be the only column shown in tree
		TreeViewerColumn tclmName = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmName.getColumn().setWidth(200);
		tclmName.getColumn().setText("ModelElement");
		final ILabelProvider emfProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		tclmName.setLabelProvider(new ColumnLabelProvider(){

			@Override
			public String getText(Object element) {
				AbstractOperation operation = (AbstractOperation)element;
				ModelElement me = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getProject().getModelElement(operation.getModelElementId());
				return me.getName();
			}			
			
			@Override
			public Image getImage(Object element) {
				AbstractOperation operation = (AbstractOperation)element;
				ModelElement me = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getProject().getModelElement(operation.getModelElementId());
				return emfProvider.getImage(me);
			}
 
		});
		
		if (showColumns){
			createOtherColumns();
		}
		
		//set the dummy input to tree
//		treeViewer.setInput(getOperations());
		//auto size tree columns
		if(showColumns){
			for (TreeColumn column : treeViewer.getTree().getColumns()) {
				column.pack();
			}
		}
	
		//this.numOfChanges = operations.size();
		
	}


	private void createOtherColumns() {
		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
				
		//operation column
		TreeViewerColumn tclmName = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmName.getColumn().setText("Operation");
		tclmName.getColumn().setWidth(200);
		tclmName.setLabelProvider(new ColumnLabelProvider(){
			
			@Override
			public String getText(Object element) {
				AbstractOperation operation = (AbstractOperation)element;
				return operation.getName();
				
			}			
		});
		
		//description column
		TreeViewerColumn tclmDescription = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmDescription.getColumn().setText("Description");
		tclmDescription.getColumn().setWidth(200);
		tclmDescription.setLabelProvider(new ColumnLabelProvider(){

			@Override
			public String getText(Object element) {
				AbstractOperation operation = (AbstractOperation)element;
				return operation.getDescription();
				
			}			
		});
		
		//username column
		TreeViewerColumn tclmUsername = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmUsername.getColumn().setText("Username");
		tclmUsername.getColumn().setWidth(200);
		tclmUsername.setLabelProvider(new ColumnLabelProvider(){

			@Override
			public String getText(Object element) {
				AbstractOperation operation = (AbstractOperation)element;
				return operation.getUsername();
				
			}			
		});
	
		//status column
		TreeViewerColumn tclmStatus = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmStatus.getColumn().setText("Status");
		tclmStatus.getColumn().setWidth(200);
		final Random rnd = new Random();
		//currently status column is set using a random boolean  
		tclmStatus.setLabelProvider(new ColumnLabelProvider(){
			private boolean accepted;
			@Override
			public Color getForeground(Object element) {
				if(accepted){
					return Display.getCurrent().getSystemColor(SWT.COLOR_GREEN);
				}else {
					return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
				}
			}

			@Override
			public String getText(Object element) {
				AbstractOperation operation = (AbstractOperation)element;
				if(isAccepted(operation)){
					accepted = true;
					return "Accepted";
				}else{
					accepted = false;
					return "Rejected";
				}
				
			}
			//a dummy method.
			private boolean isAccepted(AbstractOperation operation) {
				return rnd.nextBoolean();
			}			
		});
	}


	//returns dummy contents of tree 
	private List<AbstractOperation> getOperations() {
		return createDummyOperations();
		
	}

	
	//create some operations
	//there is a modeling issue that i have also added to unicase: 
	//a composite operation cannot contains other composite operations
	//because it has a list of atomic operations and a composite operation 
	//is not itself an atomic operation but an abstract operation. 
	private List<AbstractOperation> createDummyOperations() {
		List<AbstractOperation> ops = new ArrayList<AbstractOperation>();
		
		CreateDeleteOperation op1 = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		op1.setUsername("john");
		ops.add(op1);
		
		CreateDeleteOperation op2 = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		op2.setUsername("mike");
		ops.add(op2);
		
		CreateDeleteOperation op3 = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		op3.setUsername("susi");
		ops.add(op3);
		
		CreateDeleteOperation op4 = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		op4.setUsername("alice");
		ops.add(op4);
		
		CreateDeleteOperation op5 = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		op5.setUsername("joe");
		ops.add(op5);
		
		CompositeOperation compOp1 = OperationsFactory.eINSTANCE.createCompositeOperation();
		compOp1.setUsername("joe");
		compOp1.getSubOperations().add(op1);
		compOp1.getSubOperations().add(op2);
		ops.add((AbstractOperation)compOp1);
		
		CompositeOperation compOp2 = OperationsFactory.eINSTANCE.createCompositeOperation();
		compOp2.setUsername("joe");
		compOp2.getSubOperations().add(op3);
		compOp2.getSubOperations().add(op4);
		//compOp2.getAtomicOperations().add((AtomicOperation)compOp1);
		ops.add((AbstractOperation)compOp2);
		
		this.numOfChanges = ops.size();
		return ops;
		
	}


	/**.
	 * get number of operations to show at top of tree
	 * @return number of operations
	 */
	public int getNumOfChanges() {
		
		return this.numOfChanges;
	}


	/**.
	 * set input ChangePackage whose operations will be shown in tree
	 * @param changePackage input ChangePackage
	 */
	public void setInput(ChangePackage changePackage) {
		this.changePackage = changePackage;
		if(changePackage != null){
			treeViewer.setInput(changePackage.getOperations());
		}
		
	}


	/**.
	 * for future use maybe
	 * @return input ChangePackage
	 */
	public ChangePackage getChangePackage() {
		return changePackage;
	}
	
	

}
