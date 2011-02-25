/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.ui.IEditorPart;
import org.unicase.ui.common.diagram.part.ModelDiagramEditor;
import org.unicase.ui.tom.gestures.CreateNodeAndConnectionGesture;
import org.unicase.ui.tom.gestures.CreateNodeGesture;
import org.unicase.ui.tom.gestures.Gesture;
import org.unicase.ui.tom.gestures.MoveCanvasGesture;
import org.unicase.ui.tom.gestures.MoveConnectionBendpointGesture;
import org.unicase.ui.tom.gestures.MoveMultiNodeGesture;
import org.unicase.ui.tom.gestures.MoveNodeGesture;
import org.unicase.ui.tom.gestures.SelectGesture;
import org.unicase.ui.tom.notifications.GestureAdapter;
import org.unicase.ui.tom.notifications.GestureNotification;
import org.unicase.ui.tom.notifications.TouchAdapter;
import org.unicase.ui.tom.notifications.TouchNotification;
import org.unicase.ui.tom.notifications.TouchNotificationImpl;
import org.unicase.ui.tom.notifications.TouchNotifierImpl;
import org.unicase.ui.tom.touches.Touch;

/**
 * @author schroech
 *
 */
public class GestureInterpreter extends TouchNotifierImpl 
implements TouchAdapter, GestureAdapter{

	private TouchDispatch dispatch;
	private List<Gesture> gestures;

	/**
	 * @param dispatch
	 */
	public GestureInterpreter(TouchDispatch dispatch) {
		setDispatch(dispatch);
		setGestures(new ArrayList<Gesture>());

		IEditorPart editor = Utility.getActiveEditor();	
		if (editor == null){
			return;
		}


		DiagramEditPart diagramEditPart = ((ModelDiagramEditor) editor).getDiagramEditPart();

		Gesture createNodeGesture = new CreateNodeGesture(dispatch, diagramEditPart);
		addGesture(createNodeGesture);

		Gesture createNodeAndConnectionGesture 
		= new CreateNodeAndConnectionGesture(dispatch, diagramEditPart);
		addGesture(createNodeAndConnectionGesture);

//		Gesture moveGesture = new MoveNodeGesture(dispatch, diagramEditPart);
//		addGesture(moveGesture);
		
		Gesture moveMultiNodeGesture = new MoveMultiNodeGesture(dispatch, diagramEditPart);
		addGesture(moveMultiNodeGesture);

		Gesture moveConnectionBendpointGesture 
		= new MoveConnectionBendpointGesture(dispatch, diagramEditPart);
		addGesture(moveConnectionBendpointGesture);

		Gesture moveCanvasGesture = new MoveCanvasGesture(dispatch, diagramEditPart);
		addGesture(moveCanvasGesture);

		Gesture selectGesture = new SelectGesture(dispatch, diagramEditPart);
		addGesture(selectGesture);
		
		
		createNodeGesture.getRestrictingGestures().add(createNodeAndConnectionGesture);
		moveConnectionBendpointGesture.getRestrictingGestures().add(moveCanvasGesture);
	}

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
		List<Gesture> executableGestures = new ArrayList<Gesture>();
		for (Gesture gesture : gestures) {
			if (gesture.canExecute()) {
				executableGestures.add(gesture);
			}
		}	
		
		GestureExecutionStrategy strategy = new RestrictionGestureExecutionStrategy(executableGestures);
		List<Gesture> gestures = strategy.getExecutableGestures();
		
		for (Gesture gesture : gestures) {
			gesture.execute();
		}
		
		if (getDispatch().getActiveSingleTouches().size() == 0) {
			for (Gesture gesture : getGestures()) {
				gesture.reset();
			}
		}
	} 

	public void handleTouchAdded(Touch touch) {
		//don't do anything
	}


	public void handleTouchChanged(Touch touch) {
		//don't do anything		
	}

	public void handleTouchRemoved(Touch touch) {
		notifyAdapters(new TouchNotificationImpl(touch, TouchNotification.touchRemoved));
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

	public void handleGestureExecutionChanged(Gesture gesture){
		//Do nothing
	}

	public void setDispatch(TouchDispatch dispatch) {
		if (dispatch != this.dispatch) {
			if (this.dispatch != null) {
				this.dispatch.getAdapters().remove(this);	
			}
			this.dispatch = dispatch;
			if (this.dispatch!= null) {
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
}
