package scrm.diagram.opener;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.common.util.ModelElementOpener;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import scrm.SCRMDiagram;

public class SCRMDiagramOpener implements ModelElementOpener {
	
	public int canOpen(EObject eObject) {
		if(eObject instanceof SCRMDiagram) {
			return 1;
		}
		return DONOTOPEN;
	}

	public void openModelElement(EObject eObject) {
		
		URI uri = EcoreUtil.getURI(eObject);
		uri.appendFragment(eObject.eResource().getURIFragment(eObject));
		URIEditorInput input = new URIEditorInput(uri, ((SCRMDiagram) eObject).getName());		

		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.showView("org.eclipse.ui.views.PropertySheet");
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, "scrm.diagram.part.ScrmDiagramEditorID", true);

		} catch (PartInitException e) {
			ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error",
				e.getMessage(), e.getStatus());
		}
	}

}
