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

public class UserTabComposite extends Composite {

	private TreeViewer treeViewer;
	private ModelElement input;

	public UserTabComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTree();
	}

	private void createTree() {

		treeViewer = new TreeViewer(this, SWT.BORDER);
		treeViewer.getTree().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));

		

		
		UserTabContentProvider provider = new UserTabContentProvider();
		treeViewer.setContentProvider(provider);
		treeViewer.setLabelProvider(new UserTabLabelProvider(provider));
		treeViewer.setComparator(new ViewerComparator());
		
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				ActionHelper.openModelElement((ModelElement) sel
						.getFirstElement());
			}

		});
	}
	
	
	public void setInput(ModelElement me) {
		this.input = me;
		treeViewer.setInput(me);
//		for(TableColumn column : treeViewer.getTable().getColumns()){
//			column.pack();
//		}
	}
	
}
