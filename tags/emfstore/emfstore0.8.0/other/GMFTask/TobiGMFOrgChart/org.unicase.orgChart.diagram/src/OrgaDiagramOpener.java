import org.eclipse.emf.ecore.EObject;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.orga.OrgDiagram;
import org.unicase.ui.common.ModelElementOpener;
import org.unicase.ui.unicasecommon.common.diagram.DiagramOpener;


public class OrgaDiagramOpener extends DiagramOpener implements
		ModelElementOpener {

	public int canOpen(EObject modelElement) {
		// TODO Auto-generated method stub
		if(modelElement instanceof OrgDiagram){
			return 1;
		}
		return DONOTOPEN;
	}

	public void openModelElement(EObject modelElement) {
		// TODO Auto-generated method stub
		if(modelElement instanceof MEDiagram){
			MEDiagram diagram = (MEDiagram) modelElement;
			super.openDiagram(diagram, "org.unicase.model.orga.diagram.part.OrgaDiagramEditorID");
		}
		else{
			throw new IllegalArgumentException("Opener only applicable for MEDiagrams");
		}
	}

}
