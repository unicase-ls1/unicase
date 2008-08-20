package org.unicase.ui.stem.views;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AtomicOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;

public class ChangesTreeComposite extends Composite {

	private TreeViewer treeViewer;


	public ChangesTreeComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTreeViewer();
		
	}
	
	
	private void createTreeViewer() {
		treeViewer = new TreeViewer(this, SWT.FULL_SELECTION);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		treeViewer.setContentProvider(new ChangesTreeContentProvider());
		
		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		
		TreeViewerColumn tclmName = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmName.getColumn().setWidth(200);
		tclmName.getColumn().setText("Name");
		tclmName.setLabelProvider(new ColumnLabelProvider(){

			@Override
			public String getText(Object element) {
				AbstractOperation operation = (AbstractOperation)element;
				return operation.getName();
				
			}			
		});
		
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
	
		TreeViewerColumn tclmStatus = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmStatus.getColumn().setText("Status");
		tclmStatus.getColumn().setWidth(200);
		final Random rnd = new Random();
		tclmStatus.setLabelProvider(new ColumnLabelProvider(){

			@Override
			public String getText(Object element) {
				AbstractOperation operation = (AbstractOperation)element;
				if(isAccepted(operation)){
					return "Accepted";
				}else{
					return "Rejected";
				}
				
			}

			private boolean isAccepted(AbstractOperation operation) {
				return rnd.nextBoolean();
			}			
		});
		
		treeViewer.setInput(getOperations());
		
	}


	private List<AbstractOperation> getOperations() {
		
		
		return createDummyOperations();
		
	}


	private List<AbstractOperation> createDummyOperations() {
		List<AbstractOperation> ops = new ArrayList<AbstractOperation>();
		
		AtomicOperation op1 = OperationsFactory.eINSTANCE.createAtomicOperation();
		op1.setName("operation1");
		op1.setDescription("an operation1");
		op1.setUsername("john");
		ops.add(op1);
		
		AtomicOperation op2 = OperationsFactory.eINSTANCE.createAtomicOperation();
		op2.setName("operation2");
		op2.setDescription("an operation2");
		op2.setUsername("mike");
		ops.add(op2);
		
		AtomicOperation op3 = OperationsFactory.eINSTANCE.createAtomicOperation();
		op3.setName("operation3");
		op3.setDescription("an operation3");
		op3.setUsername("susi");
		ops.add(op3);
		
		AtomicOperation op4 = OperationsFactory.eINSTANCE.createAtomicOperation();
		op4.setName("operation4");
		op4.setDescription("an operation4");
		op4.setUsername("alice");
		ops.add(op4);
		
		AtomicOperation op5 = OperationsFactory.eINSTANCE.createAtomicOperation();
		op5.setName("operation5");
		op5.setDescription("an operation5");
		op5.setUsername("joe");
		ops.add(op5);
		
		CompositeOperation compOp1 = OperationsFactory.eINSTANCE.createCompositeOperation();
		compOp1.setName("compOp1");
		compOp1.setDescription("a composite operation1");
		compOp1.setUsername("joe");
		compOp1.getAtomicOperations().add(op1);
		compOp1.getAtomicOperations().add(op2);
		ops.add((AbstractOperation)compOp1);
		
		CompositeOperation compOp2 = OperationsFactory.eINSTANCE.createCompositeOperation();
		compOp2.setName("compOp2");
		compOp2.setDescription("a composite operation2");
		compOp2.setUsername("joe");
		compOp2.getAtomicOperations().add(op3);
		compOp2.getAtomicOperations().add(op4);
//		compOp2.getAtomicOperations().add((AtomicOperation)compOp1);
		ops.add((AbstractOperation)compOp2);
		
		return ops;
		
	}
	
	

}
