package humandiagramgef;

import humanbodymodel.Human;
import humanbodymodel.HumanLink;

import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class HumanDiagramEditPart extends AbstractGraphicalEditPart {

	public HumanDiagramEditPart() {
		super();
	}

	@Override
	protected IFigure createFigure() {
		return new HumanPolylineConnectionAnchorFigure();
	}

	@Override
	protected void createEditPolicies() {
	}

	@Override
	protected List<HumanLink> getModelSourceConnections() {
		Human model = (Human) getModel();
		return model.getOutgoingLinks();
	}

	@Override
	protected List<HumanLink> getModelTargetConnections() {
		Human model = (Human) getModel();
		return model.getIncomingLinks();
	}

	@Override
	protected void refreshVisuals() {
		final HumanPolylineConnectionAnchorFigure figure = (HumanPolylineConnectionAnchorFigure) getFigure();
		Human model = (Human) getModel();
		final HumanContainerEditPart parent = (HumanContainerEditPart) this.getParent();

		figure.getLable().setText(model.getName());
		// figure.getLable().setFont(new Font(Display.getCurrent(), "Arial", 5, 1));
		figure.setForegroundColor(new Color(Display.getCurrent(), model.getColor_r(), model.getColor_g(), model.getColor_b()));

		Rectangle layout = new Rectangle(Math.round(200 + model.getX() * 250), Math.round(275 - model.getY() * 250), 40, 40);
		parent.setLayoutConstraint(this, figure, layout);
	}

	@Override
	public void setModel(Object model) {
		super.setModel(model);

		((Human) model).eAdapters().add(new Adapter() {
			@Override
			public void notifyChanged(Notification notification) {
				Display.getDefault().syncExec(new Runnable() {
					@Override
					public void run() {
						refreshVisuals();
						refreshSourceConnections();
						refreshTargetConnections();
					}
				});
			}

			@Override
			public Notifier getTarget() {
				return (Human) getModel();
			}

			@Override
			public void setTarget(Notifier newTarget) {
				// TODO Auto-generated method stub
			}

			@Override
			public boolean isAdapterForType(Object type) {
				// TODO Auto-generated method stub
				return false;
			}
		});
	}

	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return ((HumanPolylineConnectionAnchorFigure) getFigure()).getConnectionAnchor();
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return ((HumanPolylineConnectionAnchorFigure) getFigure()).getConnectionAnchor();
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return ((HumanPolylineConnectionAnchorFigure) getFigure()).getConnectionAnchor();
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return ((HumanPolylineConnectionAnchorFigure) getFigure()).getConnectionAnchor();
	}

}
