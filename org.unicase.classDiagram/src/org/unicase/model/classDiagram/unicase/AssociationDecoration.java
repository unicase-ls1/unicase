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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.AssociationType;

public class AssociationDecoration extends Figure implements
		RotatableDecoration {
	private static final Locator NULL_LOCATOR = new LocatorStub();

	private Association association;

	private boolean source;

	public AssociationDecoration(Association association, boolean source) {
		super();
		initAggregationDecorations();
		initNavigabilityDecorations();
		setLayoutManager(new DelegatingLayout());

		this.association = association;
		this.source = source;
		updateDecortation();

		association.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				updateDecortation();
				super.notifyChanged(msg);
			}
		});
	}

	private void updateDecortation() {
		removeDecoration();
		if (association.getType().equals(AssociationType.AGGREGATION)) {
			if (source == true) {
				addDecoration(mySharedAggrecationDecoration);
			}
		}
		if (association.getType().equals(AssociationType.COMPOSITION)) {
			if (source == true) {
				addDecoration(myCompositeAggrecationDecoration);
			}
		}
		if (association.getType().equals(AssociationType.ASSOCIATION)) {
			if (source == false) {
				addDecoration(myNavigableDecoration);
			}
		}

	}

	private static final PointList RHOMB = new PointList(new int[] { //
			//
					-1, 1, //
					0, 0, //
					-1, -1, //
					-2, 0, //
					-1, 1, //
			});

	private static final PointList ARROW = new PointList(new int[] { //
			//
					-1, 1, //
					0, 0, //
					-1, -1, //
					0, 0, //
					-1, 1, //
			});
	private static final PointList CROSS = new PointList(new int[] { //
			//
					-1, 0, //
					-2, -1, //
					-1, 0, //
					-2, 1, //
					-1, 0, //
					0, 1, //
					-1, 0, //
					0, -1, //
					-1, 0, //
			});

	private ComposablePolygonDecoration myCompositeAggrecationDecoration;

	private ComposablePolygonDecoration mySharedAggrecationDecoration;

	private ComposablePolygonDecoration myNavigableDecoration;

	private ComposablePolygonDecoration myNonNavigableDecoration;

	private void initAggregationDecorations() {
		myCompositeAggrecationDecoration = new ComposablePolygonDecoration();
		myCompositeAggrecationDecoration.setTemplate(RHOMB.getCopy());
		myCompositeAggrecationDecoration.setBoundPoint(new Point(-2, 0));
		myCompositeAggrecationDecoration.setFill(true);
		if (getParent() != null && getParent().getForegroundColor() != null) {
			myCompositeAggrecationDecoration.setBackgroundColor(getParent()
					.getForegroundColor());
		}
		mySharedAggrecationDecoration = new ComposablePolygonDecoration();
		mySharedAggrecationDecoration.setTemplate(RHOMB.getCopy());
		mySharedAggrecationDecoration.setBoundPoint(new Point(-2, 0));
		mySharedAggrecationDecoration.setFill(true);
		mySharedAggrecationDecoration.setBackgroundColor(ColorConstants.white);
	}

	private void initNavigabilityDecorations() {
		myNavigableDecoration = new ComposablePolygonDecoration();
		myNavigableDecoration.setTemplate(ARROW.getCopy());
		myNavigableDecoration.setBoundPoint(new Point(-1, 0));

		myNonNavigableDecoration = new ComposablePolygonDecoration();
		myNonNavigableDecoration.setScale(4, 3);
		myNonNavigableDecoration.setTemplate(CROSS.getCopy());
		myNonNavigableDecoration.setBoundPoint(new Point(-2, 0));
	}

	public void addDecoration(ComposableRotatableDecoration figure) {
		if (!getChildren().contains(figure)) {
			super.add(figure, NULL_LOCATOR);
			// super.add(figure);
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
