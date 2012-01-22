package humandiagramgef;

import humanbodymodel.Human;
import humanbodymodel.HumanContainer;
import humanbodymodel.PositionedElement;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

public class HumanContainerEditPart extends AbstractGraphicalEditPart {
	  @Override
	  protected IFigure createFigure() {
	    FreeformLayer layer = new FreeformLayer();
	    layer.setLayoutManager(new FreeformLayout());
	    layer.setBorder(new LineBorder(1));
	    return layer;
	  }
	 
	  @Override
	  protected void createEditPolicies() {
	    // TODO Auto-generated method stub
	  }
	 
	  @Override protected List<PositionedElement> getModelChildren() {
	    List<PositionedElement> retVal = new ArrayList<PositionedElement>();
	    HumanContainer opd = (HumanContainer) getModel();
	    retVal.addAll(opd.getElements());
	    return retVal;
	  }
	}
