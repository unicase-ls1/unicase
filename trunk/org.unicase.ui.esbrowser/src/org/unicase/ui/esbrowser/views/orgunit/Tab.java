package org.unicase.ui.esbrowser.views.orgunit;

import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;

public class Tab  {

	private ListViewer list;
	private Composite tabFolderPage;
	private String tabName;
	
	private PropertiesForm frm; 
	
	
	public Tab(String tabName) {
		this.tabName = tabName;
	}


	Composite createTabFolderPage(TabFolder tabFolder){
		
		Control[] controlsOnSash = tabFolder.getParent().getChildren();
		frm = (PropertiesForm)controlsOnSash[1];
		
		tabFolderPage = new Composite (tabFolder, SWT.NONE);
		tabFolderPage.setLayoutData (new GridData(SWT.FILL, SWT.FILL, true, true));
		tabFolderPage.setLayout (new FillLayout ());
		
		initList(tabFolderPage);
		
		return tabFolderPage;
		
	}
	
	private void initList(Composite tabPage) {
		
		list = new ListViewer(tabPage, SWT.V_SCROLL | SWT.BORDER);
		list.setLabelProvider(new ListLabelProvider());
		list.setContentProvider(new ListContentProvider());
		
		if(tabName.equals("Projects")){
			list.setInput("Projects");
			
		}else if(tabName.equals("Groups")){
			list.setInput("Groups");
			
		}else if(tabName.equals("Users")){
			list.setInput("Users");
		}
		
		list.addDoubleClickListener(new IDoubleClickListener(){

			public void doubleClick(DoubleClickEvent event) {
				frm.setInput(getSelectedItem(event));
			}
			
		});
		
		int ops = DND.DROP_COPY;
		Transfer[] transfers = new Transfer[]{LocalSelectionTransfer.getTransfer()};
		
		DragSourceListener dragListener = new DragSourceListener(){

			public void dragFinished(DragSourceEvent event) {
						
			}

			public void dragSetData(DragSourceEvent event) {
				ACOrgUnit orgUnit = (ACOrgUnit)((IStructuredSelection)list.getSelection()).getFirstElement();
				//event.data = orgUnit;
				PropertiesForm.dragNDropObject = orgUnit;
			}

			public void dragStart(DragSourceEvent event) {
								
			}

			
			
		};
		list.addDragSupport(ops, transfers, dragListener);
	}


	public String getName(){
		return tabName;
	}
	
	private EObject getSelectedItem(DoubleClickEvent event){
		EObject result = null;
		ISelection sel = event.getSelection();
		IStructuredSelection ssel= (IStructuredSelection)sel;
		
		if (ssel != null){
			Object obj = ssel.getFirstElement();
			if(obj instanceof ProjectInfo){
				result = (ProjectInfo)obj;
			}else if(obj instanceof ACOrgUnit){
				result = (ACOrgUnit)obj;
			}
		}
		
		return result;
		
	}

}
