package org.unicase.model.orga.diagram.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;

public class DiagramTypeTester extends
		org.unicase.ui.unicasecommon.diagram.part.DiagramTypeTester {

	
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue){
		if(receiver instanceof MEDiagram){
			return super.test(receiver, property, args, expectedValue);
		}
		View view = null;
		IEditorPart iep = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(iep instanceof DiagramDocumentEditor){
			DiagramDocumentEditor dde = (DiagramDocumentEditor) iep;
			DiagramEditPart editPart = dde.getDiagramEditPart();
			view = EditPartUtility.getView(editPart);
		}
		if(OrgaVisualIDRegistry.getNodeVisualID(view, (EObject)receiver) != -1){
			return true;
		}
		return false;
	}
}
