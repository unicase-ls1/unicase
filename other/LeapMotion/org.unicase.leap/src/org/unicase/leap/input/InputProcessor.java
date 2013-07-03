/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.input;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.unicase.leap.action.ILeapActionHandler;
import org.unicase.leap.action.LeapHelper;
import org.unicase.leap.events.LeapActionEvent;
import org.unicase.leap.events.LeapGestureEvent;
import org.unicase.leap.events.LeapInputEvent;
import org.unicase.leap.events.LeapKeyEvent;
import org.unicase.leap.events.LeapMouseEvent;

import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Gesture.State;

/**
 * This input processor can process input sequences as defined by the {@link ActionInput} class and the classes
 * extending it. An input sequence is defined as an array of inputs. Once the whole array has been processed, a
 * {@link LeapActionEvent} is forwarded to the corresponding {@link ILeapActionHandler}.
 * 
 * @author mharut
 */
public class InputProcessor {

	/**
	 * The workbench page this input processor is defined for.
	 */
	private final IWorkbenchPage page;
	/**
	 * The input sequence as an array of single inputs.
	 */
	private final ActionInput[] inputArray;
	/**
	 * The handler the leap action event shall be forwarded to, once the input sequence has been completely processed.
	 */
	private final ILeapActionHandler handler;
	/**
	 * The helper object which can be used for computations regarding leap sensor data.
	 */
	private LeapHelper helper;
	/**
	 * The leap action event that will be forwarded to the specified handler. Whenever the input sequence is cancelled,
	 * this event will be null.
	 */
	private LeapActionEvent leapEvent;
	/**
	 * The current index of the input sequence. If this is the same as the length of the input array, the sequence is
	 * processed completely and the leap action event will be forwarded to the specified handler.
	 */
	private int currentInputIndex;
	/**
	 * Amount of clicks that are still remaining to finish a {@link MouseInput doubleclick-input}. If the current input
	 * is not a doubleclick-input, this will always be 0.
	 */
	private int remainingClicks;
	/**
	 * The timeout in milliseconds of the input that was currently processed. If the time between two inputs exceeds
	 * this timeout, the whole sequence will be discarded and started from the beginning.
	 */
	private int currentTimeout;
	/**
	 * The time in milliseconds when the last input occurred. If the time between two inputs is larger than the allowed
	 * timeout, the whole input sequence will be discarded and started from the beginning.
	 */
	private long timeOfLastInput;

	/**
	 * Constructs a new input processor for a workbench page, an input sequence and a handler to handle leap action
	 * events.
	 * 
	 * @param page the workbench page this input processor is defined for
	 * @param inputArray the input seqeuence as an array of {@link ActionInput}
	 * @param handler the handler to handle {@link LeapActionEvent}s that are fired once the input sequence has been
	 *            performed
	 */
	public InputProcessor(IWorkbenchPage page, ActionInput[] inputArray, ILeapActionHandler handler) {
		this.page = page;
		this.inputArray = inputArray;
		this.handler = handler;
		this.currentInputIndex = 0;
		this.remainingClicks = 0;
	}

	/**
	 * Processes a gesture input. This process is considered successful, if the next input in the input sequence is
	 * actually a gesture, if the gesture types match and if the input types (fingers or tools) are supported.
	 * 
	 * @param event the event of the gesture that was performed
	 */
	public synchronized void processGesture(LeapGestureEvent event) {
		GestureInput gestureInput = validateInput(GestureInput.class, event);
		if (gestureInput == null) {
			// next input is not a gesture -> start input sequence from the beginning and check if the first input is a
			// gesture
			discardEvent();
			gestureInput = validateInput(GestureInput.class, event);
			if (gestureInput == null) {
				// this gesture is not part of this input sequence
				return;
			}
		}
		Gesture gesture = event.getGesture();
		if (gesture.type().equals(gestureInput.getInputType())
			&& (event.isFingersInvolved() && gestureInput.isFingersEnabled())
			|| (event.isToolsInvolved() && gestureInput.isToolsEnabled())) {
			if (leapEvent == null) {
				leapEvent = new LeapActionEvent(page.getActiveEditor(), helper);
			}
			leapEvent.addEvent(event);
			// finish this step of the input sequence only for the last state of the gesture
			if (State.STATE_STOP.equals(gesture.state())) {
				proceed(leapEvent, event);
			}
		} else {
			discardEvent();
		}
	}

	/**
	 * Processes a keyboard input. This process is considered successful, if the next input in the input sequence is
	 * actually a keyboard input and if the key codes match. If the key input is a {@link KeyInput hold-input}, the
	 * input processing is considered sucessful once the key is pressed, otherwise, once it is released. If the key of
	 * an hold-input is released, before the input sequence is finished, the whole input seqeunce is discarded and
	 * started from the beginning.
	 * 
	 * @param event the event of the keyboard input that was performed
	 */
	public synchronized void processKeyEvent(LeapKeyEvent event) {
		KeyInput keyInput = validateInput(KeyInput.class, event);
		if (keyInput == null) {
			// next input is not a keyboard input -> start input sequence from the beginning and check if the first
			// input is a keyboard input
			discardEvent();
			keyInput = validateInput(KeyInput.class, event);
			if (keyInput == null) {
				return;
			}
		}
		if (event.getKeyEvent().keyCode == keyInput.getKey()) {
			if (leapEvent == null) {
				leapEvent = new LeapActionEvent(page.getActiveEditor(), helper);
			}
			leapEvent.addEvent(event);
			if (event.getType() == SWT.KeyDown) {
				if (keyInput.isHold()) { // key down events are only relevant for hold-input
					proceed(leapEvent, event);
				}
			} else if (event.getType() == SWT.KeyUp) {
				if (keyInput.isHold()) { // key of hold-input has been released, before the input sequence was complete
					discardEvent();
				} else { // push-input was performed successfully
					proceed(leapEvent, event);
				}
			} else {
				discardEvent();
			}
		} else {
			discardEvent();
		}
	}

	/**
	 * Processes a mouse input. This process is considered successful, if the next input in the input sequence is
	 * actually a mouse input and if the buttons match. For {@link MouseInput doubleclick-inputs}, three mouse events
	 * have to be processed: one for the first click, one for the doubleclick and one for the second click. It is
	 * notably, that the doubleclick is processed as the second event, as defined by the SWT event framework.
	 * 
	 * @param event the event of the keyboard input that was performed
	 */
	public synchronized void processMouseEvent(LeapMouseEvent event) {
		if (event.getType() == SWT.MouseUp && remainingClicks == 1) { // check for an open doubleclick event
			// last click of the doubleclick event -> finish processing and reset the counter
			proceed(leapEvent, event);
			remainingClicks = 0;
			return;
		}
		MouseInput mouseInput = validateInput(MouseInput.class, event);
		if (mouseInput == null) {
			// next input is not a mouse input -> start input sequence from the beginning and check if the first
			// input is a mouse input
			discardEvent();
			mouseInput = validateInput(MouseInput.class, event);
			if (mouseInput == null) {
				return;
			}
		}
		if (event.getMouseEvent().button == mouseInput.getButton()) {
			if (leapEvent == null) {
				leapEvent = new LeapActionEvent(page.getActiveEditor(), helper);
			}
			leapEvent.addEvent(event);
			if (event.getType() == SWT.MouseDoubleClick) {
				// check for second sub-event of the doubleclick event
				if (mouseInput.isDoubleClick() && remainingClicks == 2) {
					remainingClicks--;
				}
			} else if (event.getType() == SWT.MouseUp) {
				if (!mouseInput.isDoubleClick()) {
					// no doubleclick -> processing successful
					proceed(leapEvent, event);
				} else if (remainingClicks == 0) {
					// initiate double-click event -> wait for 2 more sub-events
					remainingClicks = 2;
				} else {
					// waiting for doubleclick, but none occurred
					discardEvent();
				}
			} else {
				discardEvent();
			}
		} else {
			discardEvent();
		}
	}

	/**
	 * Validates an input against the input sequence for an occuring input class and the corresponding event. If the
	 * next input in the sequence matches the specified class, the input will be returned. If the timeout was exceeded
	 * or the next input in the sequence doesn't match the specified class, <code>null</code> will be returned.
	 * 
	 * @param cls the class of the received input as an extension of {@link ActionInput}
	 * @param event the occurred input event belonging to the received input
	 * @return the next input in the sequence or<br/>
	 *         <code>null</code> if no valid input could be retrieved
	 */
	private <T extends ActionInput> T validateInput(Class<T> cls, LeapInputEvent event) {
		long timeDelta = event.getTime() - timeOfLastInput;
		if ((currentTimeout <= 0 || timeDelta < currentTimeout) && currentInputIndex < inputArray.length
			&& cls.isInstance(inputArray[currentInputIndex])) {
			T result = cls.cast(inputArray[currentInputIndex]);
			if (!(result instanceof MouseInput) || remainingClicks == 1) {
				currentTimeout = result.getTimeout();
			}
			return result;
		} else {
			return null;
		}
	}

	/**
	 * Discards the current leap action event and resets all values involved in the input sequence processing process.
	 */
	private synchronized void discardEvent() {
		leapEvent = null;
		currentInputIndex = 0;
		remainingClicks = 0;
		timeOfLastInput = 0;
		currentTimeout = 0;
	}

	/**
	 * Proceeds by stepping forward in the input sequence. If the last input in the sequence has been processed, the
	 * action event is forwarded to the specified handler. Otherwise, the time of the last input is set to the time
	 * value of the input event.
	 * 
	 * @param actionEvent the action event which will be forwarded to the handler if the input sequence has been
	 *            processed completely
	 * @param inputEvent the input event which defines the time which will be used to set the time of the last input
	 */
	private void proceed(final LeapActionEvent actionEvent, LeapInputEvent inputEvent) {
		if (++currentInputIndex == inputArray.length) {
			final Display display = Display.getDefault();
			display.asyncExec(new Runnable() {
				@Override
				public void run() {
					actionEvent.setMousePosition(display.getCursorLocation());
					handler.handleLeapAction(actionEvent);
				}
			});
		} else {
			timeOfLastInput = inputEvent.getTime();
		}
	}

	/**
	 * Sets this input processors helper object to a new value.
	 * 
	 * @param helper the new helper object which can be used for leap motion sensor data computations
	 */
	public void setHelper(LeapHelper helper) {
		this.helper = helper;
	}

}
