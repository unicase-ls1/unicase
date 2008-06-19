package org.unicase.model.classDiagram.unicase;

import java.util.List;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class CompositeDecoration extends Figure implements RotatableDecoration {
	private static final Locator NULL_LOCATOR = new LocatorStub();
	
	public CompositeDecoration() {
		setLayoutManager(new DelegatingLayout());
	}
	
	@Override
	public Rectangle getBounds() {
		Rectangle result = super.getBounds();
		for (IFigure child: getChildrenImpl()) {
			result = result.union(child.getBounds());
		}
		return result;
	}
	
	public void addDecoration(ComposableRotatableDecoration figure) {
		if (!getChildren().contains(figure)) {
			super.add(figure, NULL_LOCATOR);
			//super.add(figure);
		}
	};
	
	public void removeDecoration(ComposableRotatableDecoration figure) {
		if (getChildren().contains(figure)) {
			remove(figure);
		}
	}

	public void setReferencePoint(Point p) {
		for (Object child: getChildren()) {
			if (child instanceof RotatableDecoration) {
				((RotatableDecoration)child).setReferencePoint(p);
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
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	private List<ComposableRotatableDecoration> getChildrenImpl(){
		return getChildren();
	}

	private static class LocatorStub implements Locator {
		public void relocate(IFigure target) {
		}
	}

}
