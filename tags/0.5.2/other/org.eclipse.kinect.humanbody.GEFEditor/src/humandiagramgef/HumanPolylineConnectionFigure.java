package humandiagramgef;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.XYLayout;

public class HumanPolylineConnectionFigure extends Figure {

	private PolylineConnection connection;
	
	public HumanPolylineConnectionFigure() {
		setLayoutManager(new XYLayout());
		connection = new PolylineConnection();
		add(connection);
	}
	
	  @Override 
	 protected void paintFigure(Graphics graphics) {
	    super.paint(graphics);
	  }
	  
	public PolylineConnection getPolylineConnection() {
		return this.connection;
	}
	
	public void setSourceAnchor(ChopboxAnchor sourceAnchor) {
		this.connection.setSourceAnchor(sourceAnchor);
	}
	
	public void setTargetAnchor(ChopboxAnchor targetAnchor) {
		this.connection.setTargetAnchor(targetAnchor);
	}
	
}
