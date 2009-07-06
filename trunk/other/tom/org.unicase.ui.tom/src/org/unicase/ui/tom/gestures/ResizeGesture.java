package org.unicase.ui.tom.gestures;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.common.diagram.util.EditPartUtility;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.tools.TouchConstants;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;

public class ResizeGesture extends AbstractContinuousGesture {

	public ResizeGesture(TouchDispatch dispatch) {
		super(dispatch);
	}

	private static final class MapUtility {

		@SuppressWarnings("unchecked")
		public static <K, V> Set<K> getKeysForObject(Map<K, Set<V>> map,
				V object) {
			Set<K> keysForObject = new HashSet<K>();
			Set<K> keySet = map.keySet();

			for (K key : keySet) {
				Set set = map.get(key);
				if (set.contains(object)) {
					keysForObject.add(key);
				}
			}

			return keysForObject;
		}
	}

	INodeEditPart targetEditPart;

	private SingleTouch leftTouch;
	private SingleTouch rightTouch;
	private SingleTouch upperTouch;
	private SingleTouch lowerTouch;

	private final Map<INodeEditPart, Set<SingleTouch>> editPartTouchesMap = new HashMap<INodeEditPart, Set<SingleTouch>>();

	private ChangeBoundsRequest changeBoundsRequest;

	private org.eclipse.draw2d.geometry.Rectangle targetEditPartBounds;

	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {
		INodeEditPart nodeEditPart = findTouchedNodeEditPart(touch.getPosition());
		if (nodeEditPart == null) {
			return;
		}

		Set<SingleTouch> set = editPartTouchesMap.get(nodeEditPart);
		if (set == null) {
			set = new HashSet<SingleTouch>();
			editPartTouchesMap.put(nodeEditPart, set);
		}
		set.add(touch);
	}

	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {

		if (!isExecuting()) {

			boolean touchMoved = touchMoved(touch, TouchConstants.TOUCH_MOVEMENT_THRESHOLD);
			if (!touchMoved) {
				return;
			}
			
			Set<INodeEditPart> nodesForTouch = MapUtility.getKeysForObject(
					editPartTouchesMap, touch);
			if (nodesForTouch.size() != 1) {
				return;
			}

			INodeEditPart nodeEditPart = null;
			for (INodeEditPart currentEditPart : nodesForTouch) {
				nodeEditPart = currentEditPart;
			}

			Set<SingleTouch> set = editPartTouchesMap.get(nodeEditPart);
			if (set.size() != 2) {
				return;
			}

			Object[] array = set.toArray();
			SingleTouch firstTouch = (SingleTouch) array[0];
			SingleTouch secondTouch = (SingleTouch) array[1];

			if (firstTouch.getPath().getFirstPoint().x < secondTouch.getPath()
					.getFirstPoint().x) {
				leftTouch = firstTouch;
				rightTouch = secondTouch;
			} else {
				leftTouch = secondTouch;
				rightTouch = firstTouch;
			}

			if (firstTouch.getPath().getFirstPoint().y < secondTouch.getPath()
					.getFirstPoint().y) {
				upperTouch = firstTouch;
				lowerTouch = secondTouch;
			} else {
				upperTouch = secondTouch;
				lowerTouch = firstTouch;
			}

			targetEditPart = nodeEditPart;
			targetEditPartBounds = nodeEditPart.getFigure().getBounds();

			setCanExecute(true);

		} else {

			changeBoundsRequest.setMoveDelta(new Point(getLeftDelta(),
					getUpperDelta()));
			changeBoundsRequest.setSizeDelta(new Dimension(
					getRightDelta() - getLeftDelta(),  getLowerDelta() - getUpperDelta()));

			showEditPartFeedback();
		}
	}

	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {

		Set<INodeEditPart> nodesForTouch = MapUtility.getKeysForObject(
				editPartTouchesMap, touch);
		if (nodesForTouch.size() != 1) {
			return;
		}

		INodeEditPart nodeEditPart = null;
		for (INodeEditPart currentEditPart : nodesForTouch) {
			nodeEditPart = currentEditPart;
		}

		if (nodeEditPart == null) {
			return;
		}

		Set<SingleTouch> set = editPartTouchesMap.get(nodeEditPart);
		if (set != null) {
			if (set.size() == 0) {
				editPartTouchesMap.remove(nodeEditPart);
			} else {
				set.remove(touch);
			}
		}

		if (isExecuting()) {

			if (touch == leftTouch || touch == rightTouch) {
				eraseEditPartFeedback();
				Command command = targetEditPart
						.getCommand(getChangeBoundsRequest());
				getDiagramEditPart().getDiagramEditDomain()
						.getDiagramCommandStack().execute(command);
				setExecuting(false);
			}
		}

	}

	public List<MultiTouch> getMandatoryTouches() {
		ArrayList<MultiTouch> mandatoryTouches = new ArrayList<MultiTouch>();
		mandatoryTouches.add(leftTouch.getMultiTouch());
		mandatoryTouches.add(rightTouch.getMultiTouch());

		return mandatoryTouches;
	}

	public void execute() {
		if (isExecuting()) {
			return;
		}

		setAcceptsAdditionalTouches(false);
		setExecuting(true);

		getChangeBoundsRequest().setResizeDirection(
				org.eclipse.draw2d.PositionConstants.NORTH_EAST);
		getChangeBoundsRequest().setConstrainedResize(false);
		getChangeBoundsRequest().setCenteredResize(false);

		changeBoundsRequest.setMoveDelta(new Point(getLeftDelta(),
				getUpperDelta()));
		changeBoundsRequest.setSizeDelta(new Dimension(
				getRightDelta() - getLeftDelta(),  getLowerDelta() - getUpperDelta()));

		showEditPartFeedback();

	}

	private int getLeftDelta() {
		Point firstPoint = leftTouch.getPath().getFirstPoint();
		Point lastPoint = leftTouch.getPosition();

		int delta = lastPoint.x - firstPoint.x;

		return delta;
	}

	private int getRightDelta() {
		Point firstPoint = rightTouch.getPath().getFirstPoint();
		Point lastPoint = rightTouch.getPosition();

		int delta = lastPoint.x - firstPoint.x;

		return delta;
	}

	private int getUpperDelta() {
		Point firstPoint = upperTouch.getPath().getFirstPoint();
		Point lastPoint = upperTouch.getPosition();

		int delta = lastPoint.y - firstPoint.y;

		return delta;
	}

	private int getLowerDelta() {
		Point firstPoint = lowerTouch.getPath().getFirstPoint();
		Point lastPoint = lowerTouch.getPosition();

		int delta = lastPoint.y - firstPoint.y;

		return delta;
	}

	private void eraseEditPartFeedback() {
		targetEditPart.eraseSourceFeedback(getChangeBoundsRequest());
		targetEditPart.eraseTargetFeedback(getChangeBoundsRequest());
	}

	private void showEditPartFeedback() {
		targetEditPart.showSourceFeedback(getChangeBoundsRequest());
		targetEditPart.showTargetFeedback(getChangeBoundsRequest());
	}

	private ChangeBoundsRequest getChangeBoundsRequest() {
		if (changeBoundsRequest == null) {
			changeBoundsRequest = createChangeBoundsRequest();
		}
		return changeBoundsRequest;
	}

	private ChangeBoundsRequest createChangeBoundsRequest() {
		if (targetEditPart == null) {
			return null;
		}

		ChangeBoundsRequest request = new ChangeBoundsRequest(
				RequestConstants.REQ_RESIZE);
		request.setEditParts(targetEditPart);
		request.getExtendedData().clear();

		return request;
	}

}
