package org.unicase.ui.tom.gestures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.swt.widgets.Display;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.notifications.GestureNotification;
import org.unicase.ui.tom.notifications.GestureNotificationImpl;
import org.unicase.ui.tom.notifications.GestureNotifierImpl;
import org.unicase.ui.tom.notifications.TouchAdapter;
import org.unicase.ui.tom.notifications.TouchNotification;
import org.unicase.ui.tom.touches.Touch;

public abstract class AbstractGesture extends GestureNotifierImpl 
implements TouchAdapter, Gesture{

	private TouchDispatch dispatch;
	protected boolean acceptsTouches;
	protected DiagramEditPart editor;
	protected boolean canExecute;

	public AbstractGesture(TouchDispatch dispatch, DiagramEditPart editor) {
		setDispatch(dispatch);
		setEditor(editor);
		acceptsTouches = true;
		canExecute = false;
	}

	public void execute(){
		final Display current = Display.getDefault();
		if (current != null) {
			current.syncExec(new Runnable(){
				public void run() {
					current.beep();						
				}
			});
		}
	}

	public void notifyChanged(TouchNotification notification){
		int eventType = notification.getEventType();
		switch (eventType) {
		case TouchNotification.touchAdded:
			handleTouchAdded(notification.getTouch());
			break;
		case TouchNotification.touchRemoved:
			handleTouchRemoved(notification.getTouch());
			break;
		case TouchNotification.touchChanged:
			handleTouchChanged(notification.getTouch());
			break;
		default:
			break;
		}		
	}

	public abstract void handleTouchAdded(Touch touch);

	public abstract void handleTouchRemoved(Touch touch);

	public abstract void handleTouchChanged(Touch touch);

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

	public EditPart getTouchedEditPart(Touch touch){
		IFigure figure = getEditor().getFigure().findFigureAt(touch.getPosition());
		
		EditPart part = null;
		while (part == null && figure != null) {
			part = (EditPart)getEditor().getViewer().getVisualPartMap().get(figure);
			figure = figure.getParent();
		}

		return part;
	}
	
	public boolean pointsInDistance(Touch firstTouch, Touch secondTouch, float distance){
		return (firstTouch.getPosition().getDistance(secondTouch.getPosition()) < distance);
	}
	
	public TouchDispatch getDispatch() {
		return dispatch;
	}
	
	public void setAcceptsTouches(boolean acceptsTouches) {
		if (acceptsTouches != this.acceptsTouches) {
			this.acceptsTouches = acceptsTouches;
			notifyAdapters(new GestureNotificationImpl(this,GestureNotification.gestureAcceptanceChange));
		}
	}

	public boolean getAcceptsTouches() {
		return acceptsTouches;
	}

	public void setCanExecute(boolean canExecute) {
		if (canExecute != this.canExecute) {
			this.canExecute = canExecute;
			notifyAdapters(new GestureNotificationImpl(this,GestureNotification.gestureExecutionChange));
		}
	}

	public boolean getCanExecute() {
		return canExecute;
	}
	public DiagramEditPart getEditor() {
		return editor;
	}

	public void setEditor(DiagramEditPart editor) {
		this.editor = editor;
	}
}
