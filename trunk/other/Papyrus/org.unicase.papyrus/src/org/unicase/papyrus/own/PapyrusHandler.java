package org.unicase.papyrus.own;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Package;

/**
 * Handler for ActivityOpener-Command. This handler is called when selecting
 * "Open Activity Diagram" from a UML2Package's context menu. This opens the
 * associated GMF Diagram or creates a new one if none is existent.
 * @author mharut
 */
public class PapyrusHandler extends AbstractHandler {
	
	private static boolean isInitialized = false;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		
		if(sel instanceof IStructuredSelection) {
			IStructuredSelection iStrucSel = (IStructuredSelection) sel;
			Object selectedObject = iStrucSel.getFirstElement();
			if(selectedObject instanceof Package) {
				final Package pckge = (Package) selectedObject;
				
				// TODO: find a better place to put this
				if(!isInitialized) {
					pckge.eResource().eAdapters().add(new UnicaseModelSetQueryAdapter());
					isInitialized = true;
				}
				
				URI uri = EcoreUtil.getURI(pckge);
				uri.appendFragment(pckge.eResource().getURIFragment(pckge));
				URIEditorInput input = new URIEditorInput(uri, pckge.getName());
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, "org.unicase.papyrus.activity.UMLDiagramEditorID", true);
				} catch (PartInitException e) {
					ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error",
							e.getMessage(), e.getStatus());
				}
			} else {
				throw new IllegalArgumentException("Selected Object is no Package");
			}
		} else {
			throw new IllegalArgumentException("Selection is invalid!");
		}

		
		return null;
	}

}
