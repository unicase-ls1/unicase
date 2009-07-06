package org.unicase.ui.common.dnd;

import java.util.List;

import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.unicase.model.ModelElement;

public class UCDragAdapter extends ViewerDragAdapter {

	
	


	public UCDragAdapter(Viewer viewer) {
		super(viewer);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void dragStart(DragSourceEvent event) {
		// TODO Auto-generated method stub
		super.dragStart(event);
		List<ModelElement> dragSource = null; 
		ISelection sel = viewer.getSelection();
		if(sel instanceof IStructuredSelection){
			IStructuredSelection ssel = (IStructuredSelection) sel;
			dragSource = (List<ModelElement>)ssel.toList();
			
		}
		viewer.setData(UCDropAdapter.DRAG_SOURCE_KEY, dragSource );
	}
}
