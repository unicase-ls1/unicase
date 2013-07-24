/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.events;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IEditorPart;
import org.unicase.leap.action.LeapHelper;

import com.leapmotion.leap.Frame;

/**
 * Event class used to provide information about events that occurred while using the leap motion sensor.
 * 
 * @author mharut
 */
public class LeapActionEvent {

	/**
	 * The editor instance that was open while the event occurred.
	 */
	private final IEditorPart editor;
	/**
	 * The helper object which can be used to perform computations on leap data.
	 */
	private final LeapHelper helper;
	/**
	 * The list of gesture events that occurred during the leap action.
	 */
	private final List<LeapGestureEvent> gestureEvents;
	/**
	 * The list of mouse events that occurred during the leap action.
	 */
	private final List<LeapMouseEvent> mouseEvents;
	/**
	 * The list of key events that occurred during the leap action.
	 */
	private final List<LeapKeyEvent> keyEvents;
	/**
	 * The list of speech events that occurred during the leap action.
	 */
	private final List<LeapSpeechEvent> speechEvents;
	/**
	 * The position of the mouse when the event occurred.
	 */
	private Point mousePosition;
	/**
	 * The last leap {@link Frame} before the event occurred.
	 */
	private Frame frame;

	/**
	 * Constructs a new event for an editor and a leap helper object.
	 * 
	 * @param editor the {@link IEditorPart} that was open when the event occurred
	 * @param helper the {@link LeapHelper} which can be used for computations regarding leap sensor data
	 */
	public LeapActionEvent(IEditorPart editor, LeapHelper helper) {
		this.editor = editor;
		this.helper = helper;
		this.gestureEvents = new LinkedList<LeapGestureEvent>();
		this.mouseEvents = new LinkedList<LeapMouseEvent>();
		this.keyEvents = new LinkedList<LeapKeyEvent>();
		this.speechEvents = new LinkedList<LeapSpeechEvent>();
	}

	/**
	 * Retrieves the editor that was open when the event occurred.
	 * 
	 * @return the active editor instance of the event
	 */
	public IEditorPart getEditor() {
		return editor;
	}

	/**
	 * Retrieves the leap helper object, which can be used for computations regarding leap sensor data.
	 * 
	 * @return the event's leap helper object
	 */
	public LeapHelper getHelper() {
		return helper;
	}

	/**
	 * Adds a leap input event to the list of occurred events.
	 * 
	 * @param event the {@link LeapInputEvent} to add
	 */
	public void addEvent(LeapInputEvent event) {
		frame = event.getFrame();
		if (event instanceof LeapGestureEvent) {
			gestureEvents.add((LeapGestureEvent) event);
		} else if (event instanceof LeapMouseEvent) {
			mouseEvents.add((LeapMouseEvent) event);
		} else if (event instanceof LeapKeyEvent) {
			keyEvents.add((LeapKeyEvent) event);
		} else if (event instanceof LeapSpeechEvent) {
			speechEvents.add((LeapSpeechEvent) event);
		}
	}

	/**
	 * Retrieves the list of gesture events that occurred during the leap action.
	 * 
	 * @return the list of {@link LeapGestureEvent}s
	 */
	public List<LeapGestureEvent> getGestureEvents() {
		return gestureEvents;
	}

	/**
	 * Retrieves the list of mouse events that occurred during the leap action.
	 * 
	 * @return the list of {@link LeapMouseEvent}s
	 */
	public List<LeapMouseEvent> getMouseEvents() {
		return mouseEvents;
	}

	/**
	 * Retrieves the list of key events that occurred during the leap action.
	 * 
	 * @return the list of {@link LeapKeyEvent}s
	 */
	public List<LeapKeyEvent> getKeyEvents() {
		return keyEvents;
	}

	/**
	 * Retrieves the list of speech events that occurred during the leap action.
	 * 
	 * @return the list of {@link LeapSpeechEvent}s
	 */
	public List<LeapSpeechEvent> getSpeechEvents() {
		return speechEvents;
	}

	/**
	 * Sets the position of the cursor at the triggering of the event to a new value.
	 * 
	 * @param position the position of the cursor when the event occurred
	 */
	public void setMousePosition(Point position) {
		this.mousePosition = position;
	}

	/**
	 * Retrieves the position of the cursor when the event occurred.
	 * 
	 * @return the position of the cursor when the event occurred
	 */
	public Point getMousePosition() {
		return mousePosition;
	}

	/**
	 * Retrieves the last leap frame that was involved in the leap action of this event.
	 * 
	 * @return the last active leap {@link Frame} of this event
	 */
	public Frame getFrame() {
		return frame;
	}

}
