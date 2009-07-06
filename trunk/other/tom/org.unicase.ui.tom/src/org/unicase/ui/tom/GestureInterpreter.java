/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.Viewport;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.diagram.part.ModelDiagramEditor;
import org.unicase.ui.common.util.CollectionFilter;
import org.unicase.ui.tom.gestures.ChangeConnectionTypeGesture;
import org.unicase.ui.tom.gestures.CreateCompartmentNodeGesture;
import org.unicase.ui.tom.gestures.CreateConnectionGesture;
import org.unicase.ui.tom.gestures.CreateNodeAndConnectionGesture;
import org.unicase.ui.tom.gestures.CreateNodeGesture;
import org.unicase.ui.tom.gestures.DiscoveryGesture;
import org.unicase.ui.tom.gestures.Gesture;
import org.unicase.ui.tom.gestures.MoveCanvasGesture;
import org.unicase.ui.tom.gestures.MoveConnectionBendpointGesture;
import org.unicase.ui.tom.gestures.MoveNodeGesture;
import org.unicase.ui.tom.gestures.ResizeGesture;
import org.unicase.ui.tom.gestures.SelectGesture;
import org.unicase.ui.tom.notifications.GestureAdapter;
import org.unicase.ui.tom.notifications.GestureNotification;
import org.unicase.ui.tom.notifications.TouchAdapter;
import org.unicase.ui.tom.notifications.TouchNotification;
import org.unicase.ui.tom.notifications.TouchNotificationImpl;
import org.unicase.ui.tom.notifications.TouchNotifierImpl;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.Touch;

/**
 * @author schroech
 * 
 */
public class GestureInterpreter extends TouchNotifierImpl implements
		TouchAdapter, GestureAdapter {

	private TouchDispatch dispatch;
	private List<Gesture> gestures;
	private Set<MultiTouch> claimedTouches;

	private ModelDiagramEditor activeEditor;

	/**
	 * @param dispatch
	 */
	public GestureInterpreter(TouchDispatch dispatch) {
		setDispatch(dispatch);
		setGestures(new ArrayList<Gesture>());
		setClaimedTouches(new HashSet<MultiTouch>());

		Gesture resizeGesture = new ResizeGesture(dispatch);
		addGesture(resizeGesture);

		Gesture discoveryGesture = new DiscoveryGesture(dispatch);
		addGesture(discoveryGesture);

		Gesture createNodeGesture = new CreateNodeGesture(dispatch);
		addGesture(createNodeGesture);

		Gesture createCompartmentNodeGesture = new CreateCompartmentNodeGesture(
				dispatch);
		addGesture(createCompartmentNodeGesture);

		Gesture createNodeAndConnectionGesture = new CreateNodeAndConnectionGesture(
				dispatch);
		addGesture(createNodeAndConnectionGesture);

		Gesture moveNodeGesture = new MoveNodeGesture(dispatch);
		addGesture(moveNodeGesture);

		Gesture moveConnectionBendpointGesture = new MoveConnectionBendpointGesture(
				dispatch);
		addGesture(moveConnectionBendpointGesture);

		Gesture moveCanvasGesture = new MoveCanvasGesture(dispatch);
		addGesture(moveCanvasGesture);

		Gesture selectGesture = new SelectGesture(dispatch);
		addGesture(selectGesture);

		Gesture createConnectionGesture = new CreateConnectionGesture(dispatch);
		addGesture(createConnectionGesture);

		Gesture changeConnectionTypeGesture = new ChangeConnectionTypeGesture(dispatch);
		addGesture(changeConnectionTypeGesture);
		
		
		moveNodeGesture.getRestrictingGestures().add(resizeGesture);
		
		createNodeGesture.getRestrictingGestures().add(
				createNodeAndConnectionGesture);
		createNodeGesture.getRestrictingGestures().add(createConnectionGesture);
		createNodeGesture.getRestrictingGestures().add(
				createCompartmentNodeGesture);

		createCompartmentNodeGesture.getRestrictingGestures().add(
				createNodeAndConnectionGesture);
		createCompartmentNodeGesture.getRestrictingGestures().add(
				createConnectionGesture);

		createNodeAndConnectionGesture.getRestrictingGestures().add(
				createConnectionGesture);

		moveConnectionBendpointGesture.getRestrictingGestures().add(
				changeConnectionTypeGesture);
		
		selectGesture.setPriority(8);
		resizeGesture.setPriority(7);
		moveNodeGesture.setPriority(6);
		moveConnectionBendpointGesture.setPriority(5);
		createNodeGesture.setPriority(4);
		createConnectionGesture.setPriority(3);
		createNodeAndConnectionGesture.setPriority(2);
		moveCanvasGesture.setPriority(0);

		moveConnectionBendpointGesture.getRestrictingGestures().add(
				moveCanvasGesture);
	}

	/**
	 * Default constructor.
	 */
	public GestureInterpreter() {
		this(null);
	}

	public void addGesture(Gesture gesture) {
		getGestures().add(gesture);
		gesture.getAdapters().add(this);
	}

	public void notifyChanged(TouchNotification notification) {
		switch (notification.getEventType()) {
		case TouchNotification.touchAdded:
			handleTouchAdded(notification.getTouch());
			break;
		case TouchNotification.touchRemoved:
			handleTouchRemoved(notification.getTouch());
			break;
		case TouchNotification.touchChanged:
			handleTouchChanged(notification.getTouch());
			break;
		case TouchNotification.touchPropagated:
			handleTouchPropagated(notification.getTouch());
		default:
			break;
		}
	}

	private void handleTouchPropagated(Touch touch) {
		List<Gesture> executableGestures = findExecutableGestures();
		if (executableGestures.size() == 0) {
			return;
		}
		
		List<SelectGesture> selectGestures = filterSelectGestures(executableGestures);
		for (SelectGesture selectGesture : selectGestures) {
			selectGesture.execute();	
		}
		
		executableGestures.removeAll(selectGestures);
		if (executableGestures.size() == 0) {
			return;
		}

		List<Gesture> gesturesWithUnclaimedMandatoryTouches = extractGesturesWithUnclaimedMandatoryTouches(executableGestures);
		if (gesturesWithUnclaimedMandatoryTouches.size() == 0) {
			return;
		}

		GestureExecutionStrategy strategy = new RestrictionGestureExecutionStrategy(
				gesturesWithUnclaimedMandatoryTouches);
		executableGestures = strategy.getExecutableGestures();
		if (executableGestures.size() == 0) {
			return;
		}

		Set<Gesture> prioritizedGestures = extractPrioritizedGestures(executableGestures);
		if (prioritizedGestures.size() == 0) {
			return;
		}

		addClaimedTouches(prioritizedGestures);

		for (Gesture gesture : prioritizedGestures) {
			gesture.execute();
		}

		if (getDispatch().getActiveSingleTouches().size() == 0) {
			for (Gesture gesture : getGestures()) {
				gesture.reset();
			}
		}
	}

	private List<SelectGesture> filterSelectGestures(List<Gesture> executableGestures) {
		List<SelectGesture> selectGestures = CollectionFilter.filter(executableGestures, SelectGesture.class);
		return selectGestures;
	}

	private void addClaimedTouches(Set<Gesture> gestures) {
		for (Gesture gesture : gestures) {
			if (gesture instanceof SelectGesture) {
				continue;
			}
			if (gesture instanceof MoveNodeGesture) {
				continue;
			}

			List<MultiTouch> mandatoryTouches = gesture.getMandatoryTouches();
			// List<MultiTouch> optionalTouches = gesture.getOptionalTouches();
			claimedTouches.addAll(mandatoryTouches);
			// claimedTouches.addAll(optionalTouches);
		}
	}

	private Set<Gesture> extractPrioritizedGestures(List<Gesture> gestures) {
		Map<MultiTouch, Set<Gesture>> mandatoryTouchMap = new HashMap<MultiTouch, Set<Gesture>>();

		for (Gesture gesture : gestures) {
			List<MultiTouch> gestureMandatoryTouches = gesture
					.getMandatoryTouches();
			for (MultiTouch multiTouch : gestureMandatoryTouches) {
				Set<Gesture> set;
				if (mandatoryTouchMap.containsKey(multiTouch)) {
					set = mandatoryTouchMap.get(multiTouch);
				} else {
					set = new HashSet<Gesture>();
					mandatoryTouchMap.put(multiTouch, set);
				}
				set.add(gesture);
			}
		}

		Set<Gesture> collisionFreeGestures = new HashSet<Gesture>();
		for (MultiTouch multiTouch : mandatoryTouchMap.keySet()) {
			Set<Gesture> set = mandatoryTouchMap.get(multiTouch);

			Gesture priorizedGesture = null;
			for (Gesture gesture : set) {
				if (priorizedGesture == null) {
					priorizedGesture = gesture;
				} else {
					int priorizedPriority = priorizedGesture.getPriority();
					int gesturePriority = gesture.getPriority();
					if (gesturePriority > priorizedPriority) {
						priorizedGesture = gesture;
					}
				}
			}

			collisionFreeGestures.add(priorizedGesture);
		}
		return collisionFreeGestures;
	}

	private List<Gesture> extractGesturesWithUnclaimedMandatoryTouches(List<Gesture> gestures) {
		List<Gesture> unclaimedGestures = new ArrayList<Gesture>();
		for (Gesture gesture : gestures) {
			List<MultiTouch> mandatoryTouches = gesture.getMandatoryTouches();
			if (mandatoryTouches == null) {
				return Collections.emptyList();
			}
			Set<MultiTouch> claimedTouches = getClaimedTouches();
			if (claimedTouches == null) {
				return Collections.emptyList();
			}

			boolean disjoint = Collections.disjoint(claimedTouches,
					mandatoryTouches);
			if (disjoint) {
				unclaimedGestures.add(gesture);
			}
		}
		return unclaimedGestures;
	}

	private List<Gesture> findExecutableGestures() {
		List<Gesture> executableGestures = new ArrayList<Gesture>();

		for (Gesture gesture : gestures) {
			if (gesture.canExecute()) {
				executableGestures.add(gesture);
			}
		}
		return executableGestures;
	}

	public void handleTouchAdded(Touch touch) {
		// don't do anything
	}

	public void handleTouchChanged(Touch touch) {
		// don't do anything
	}

	public void handleTouchRemoved(Touch touch) {
		notifyAdapters(new TouchNotificationImpl(touch,
				TouchNotification.touchRemoved));
	}

	public void notifyChanged(GestureNotification notification) {
		switch (notification.getEventType()) {
		case GestureNotification.gestureExecutionChange:
			handleGestureExecutionChanged(notification.getGesture());
			break;
		case GestureNotification.gestureAcceptanceChange:
			handleGestureAcceptanceChanged(notification.getGesture());
		default:
			break;
		}

	}

	private void handleGestureAcceptanceChanged(Gesture gesture) {
		if (!gesture.acceptsAdditionalTouches()) {
			for (Gesture currentGesture : getGestures()) {
				if (currentGesture.acceptsAdditionalTouches()) {
					return;
				}
			}
			System.out.println("There are no more gestures accepting touches");
			Utility.beep(1);
		}
	}

	public void handleGestureExecutionChanged(Gesture gesture) {
		// Do nothing
	}

	public void setDispatch(TouchDispatch dispatch) {
		if (dispatch != this.dispatch) {
			if (this.dispatch != null) {
				this.dispatch.getAdapters().remove(this);
			}
			this.dispatch = dispatch;
			if (this.dispatch != null) {
				this.dispatch.getAdapters().add(this);
			}
		}
	}

	public TouchDispatch getDispatch() {
		return dispatch;
	}

	public void setGestures(List<Gesture> gestures) {
		this.gestures = gestures;
	}

	public List<Gesture> getGestures() {
		return gestures;
	}

	public void setClaimedTouches(Set<MultiTouch> claimedTouches) {
		this.claimedTouches = claimedTouches;
	}

	public Set<MultiTouch> getClaimedTouches() {
		return claimedTouches;
	}

	public void setActiveEditor(ModelDiagramEditor activeEditor) {

		if (this.activeEditor != activeEditor) {
			this.activeEditor = activeEditor;

			if (activeEditor != null) {
				DiagramEditPart diagramEditPart = activeEditor
						.getDiagramEditPart();
				for (Gesture gesture : getGestures()) {
					gesture.setDiagramEditPart(diagramEditPart);
				}
			} else {
				for (Gesture gesture : getGestures()) {
					gesture.setDiagramEditPart(null);
				}
			}
		}

	}

	public ModelDiagramEditor getActiveEditor() {
		return activeEditor;
	}
}
