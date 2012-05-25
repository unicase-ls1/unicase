package humandiagramgef;

import humanbodymodel.Human;
import humanbodymodel.HumanContainer;
import humanbodymodel.HumanLink;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

public class HumanDiagramEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		 
	    if(model instanceof HumanContainer) {
	      part = new HumanContainerEditPart();
	    } else if (model instanceof Human) {
	    	part = new HumanDiagramEditPart();
	    } else if (model instanceof HumanLink) {
	    	part = new HumanDiagramLinkEditPart();
	    }
	 
	    if(part != null) {
	      part.setModel(model);
	    }
	 
	    return part;
	}

}
