package humandiagramgef;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

public class HumanDiagramLinkEditPart extends AbstractConnectionEditPart {

	public HumanDiagramLinkEditPart() {
		super();
	}
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		
	}
	
	  @Override 
	  protected IFigure createFigure() {
		PolylineConnection conn = new PolylineConnection();
		return conn;
	  }

}
