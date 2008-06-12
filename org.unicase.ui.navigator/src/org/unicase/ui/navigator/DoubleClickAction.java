package org.unicase.ui.navigator;
//
//import org.eclipse.emf.common.ui.URIEditorInput;
//import org.eclipse.emf.common.util.URI;
//import org.eclipse.jface.action.Action;
//import org.eclipse.jface.dialogs.MessageDialog;
//import org.eclipse.jface.viewers.ISelectionChangedListener;
//import org.eclipse.jface.viewers.SelectionChangedEvent;
//import org.eclipse.jface.viewers.TreeSelection;
//import org.eclipse.swt.widgets.Event;
//import org.eclipse.ui.PartInitException;
//import org.eclipse.ui.PlatformUI;
//import org.unicase.model.ModelElement;
//import org.unicase.model.diagram.MEDiagram;
//import org.unicase.ui.meeditor.MEEditorInput;
//
//public class DoubleClickAction extends Action implements
//		ISelectionChangedListener {
//	SelectionChangedEvent event;
//
//	@Override
//	public void run() {
//		TreeSelection selection = (TreeSelection) event.getSelection();
//		Object object = selection.getFirstElement();
//		if (object instanceof ModelElement) {
//			if (object instanceof MEDiagram) {
//				ModelElement modelElement = (ModelElement)object;
//				URIEditorInput input = new URIEditorInput(URI.createURI(modelElement.getName()));
//				try {
//					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//					.getActivePage().openEditor(input,
//							"org.unicase.model.diagram.part.ModelDiagramEditorID", true);
//				} catch (PartInitException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} else {
//				MEEditorInput input = new MEEditorInput((ModelElement) object);
//				try {
//					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//							.getActivePage().openEditor(input,
//									"org.unicase.ui.meeditor", true);
//				} catch (PartInitException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//	@Override
//	public void runWithEvent(Event event) {
//		// TODO Auto-generated method stub
//		super.runWithEvent(event);
//	}
//
//	public void selectionChanged(SelectionChangedEvent event) {
//		this.event = event;
//	}
//}
