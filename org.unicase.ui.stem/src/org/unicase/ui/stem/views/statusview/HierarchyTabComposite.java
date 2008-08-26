package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.MEState;
import org.unicase.ui.common.commands.ActionHelper;

public class HierarchyTabComposite extends Composite {

	private TreeViewer treeViewer;
	private ModelElement input;
	
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
		
		
//		createColumns();
		

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
