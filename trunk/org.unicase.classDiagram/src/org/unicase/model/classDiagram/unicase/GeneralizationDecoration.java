package org.unicase.model.classDiagram.unicase;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

public class GeneralizationDecoration extends Figure implements RotatableDecoration{

	private static final Locator NULL_LOCATOR = new LocatorStub();

	public GeneralizationDecoration() {
		super();
		initDecoration();
		setLayoutManager(new DelegatingLayout());

		updateDecoration();

//		association.eAdapters().add(new AdapterImpl() {
//			@Override
//			public void notifyChanged(Notification msg) {
//				updateDecoration();
//				super.notifyChanged(msg);
//			}
//		});
	}

	private void updateDecoration() {
		addDecoration(myGeneralizationDecoration);
	}


	private static final PointList CLOSED_ARROW = new PointList(new int[] {
					-1, 2,
					0, 0,
					-1, -2,
					-1, 0,
					-1, 2,
			});
	
	private ComposablePolygonDecoration myGeneralizationDecoration;

	private void initDecoration() {
		myGeneralizationDecoration = new ComposablePolygonDecoration();
		myGeneralizationDecoration.setTemplate(CLOSED_ARROW.getCopy());
		myGeneralizationDecoration.setBoundPoint(new Point(-1, 0));
		myGeneralizationDecoration.setFill(true);
		myGeneralizationDecoration.setBackgroundColor(ColorConstants.white);
	}

	public void addDecoration(ComposableRotatableDecoration figure) {
		if (!getChildren().contains(figure)) {
			super.add(figure, NULL_LOCATOR);
		}
	};

	public void removeDecoration() {
		for (Object object : getChildren()) {
			if (object instanceof Figure) {
				remove((IFigure) object);
			}
		}
	}

	private static class LocatorStub implements Locator {
		public void relocate(IFigure target) {
		}
	}

	@Override
	public Rectangle getBounds() {
		Rectangle result = super.getBounds();
		for (IFigure child : getChildrenImpl()) {
			result = result.union(child.getBounds());
		}
		return result;
	}

	@SuppressWarnings("unchecked")//$NON-NLS-1$
	private List<ComposableRotatableDecoration> getChildrenImpl() {
		return getChildren();
	}

	public void setReferencePoint(Point p) {
		for (Object child : getChildren()) {
			if (child instanceof RotatableDecoration) {
				((RotatableDecoration) child).setReferencePoint(p);
			}
		}
	}

	@Override
	public void setLocation(Point p) {
		super.setLocation(p);
		ComposableRotatableDecoration prev = null;
		for (ComposableRotatableDecoration next : getChildrenImpl()) {
			if (prev == null) {
				next.setLocation(p);
			} else {
				Point endPoint = prev.getBoundPoint();
				next.setLocation(endPoint);
			}
			prev = next;
		}
	}
}
