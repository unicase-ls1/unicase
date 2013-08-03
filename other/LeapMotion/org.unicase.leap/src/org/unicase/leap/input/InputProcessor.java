/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.input;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.unicase.leap.action.ILeapActionHandler;
import org.unicase.leap.action.LeapHelper;
import org.unicase.leap.events.LeapActionEvent;
import org.unicase.leap.events.LeapGestureEvent;
import org.unicase.leap.events.LeapInputEvent;
import org.unicase.leap.events.LeapKeyEvent;
import org.unicase.leap.events.LeapMouseEvent;
import org.unicase.leap.events.LeapSpeechEvent;

import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Gesture.State;
import com.leapmotion.leap.Gesture.Type;

import edu.cmu.sphinx.result.Result;

/**
 * This input processor can process input sequences as defined by the {@link ActionInput} class and the classes
 * extending it. An input sequence is defined as an array of inputs. Once the whole array has been processed, a
 * {@link LeapActionEvent} is forwarded to the corresponding {@link ILeapActionHandler}.
 * 
 * @author mharut
 */
public class InputProcessor {

	/**
	 * Flag indicating whether or not this processor is processing any gestures.
	 */
	private final boolean hasGestures;
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
	 * The locations of JSGF definitions used by specified {@link SpeechInput} instances. This may contain
	 * <code>null</code>, in which case the default UNICASE grammar is being used.
	 */
	private final Set<URL> grammarLocations;
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
	 * Code of a button of the input sequence that is being held down. If this is positive, any input not occurring in
	 * the input sequence will not discard the action event. This is because it might be that users performed one action
	 * before performing another with the same key held down (e.g. Ctrl+A to select all and Ctrl+D to delete the
	 * selected elements). A negative value indicates that no key is being held down at the moment.
	 */
	private int holding;
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
		this.holding = -1;
		this.grammarLocations = new HashSet<URL>();
		boolean hasGestures = false;
		for (ActionInput input : inputArray) {
			if (input instanceof GestureInput) {
				hasGestures = true;
			} else if (input instanceof SpeechInput) {
				SpeechInput speechInput = (SpeechInput) input;
				grammarLocations.add(speechInput.getGrammarLocation());
			}
		}
		this.hasGestures = hasGestures;
	}

	/**
	 * Processes a gesture input. This process is considered successful, if the next input in the input sequence is
	 * actually a gesture, if the gesture types match and if the input types (fingers or tools) are supported.
	 * 
	 * @param gestureEvent the event of the gesture that was performed
	 */
	public synchronized void processGesture(LeapGestureEvent gestureEvent) {
		GestureInput gestureInput = validateInput(GestureInput.class, gestureEvent);
		if (gestureInput == null) {
			// next input is not a gesture -> start input sequence from the beginning and check if the first input is a
			// gesture
			discardEvent();
			gestureInput = validateInput(GestureInput.class, gestureEvent);
			if (gestureInput == null) {
				// this gesture is not part of this input sequence
				return;
			}
		}
		Gesture gesture = gestureEvent.getGesture();
		Type actualType = gesture.type();
		Type expectedType = gestureInput.getInputType();
		if (expectedType.equals(actualType) && (gestureEvent.isFingersInvolved() && gestureInput.isFingersEnabled())
			|| (gestureEvent.isToolsInvolved() && gestureInput.isToolsEnabled())) {
			if (leapEvent == null) {
				leapEvent = new LeapActionEvent(page.getActiveEditor(), helper);
			}
			leapEvent.addEvent(gestureEvent);
			// finish this step of the input sequence only for the last state of the gesture
			if (State.STATE_STOP.equals(gesture.state())) {
				proceed(leapEvent, gestureEvent);
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
	 * @param keyEvent the event of the keyboard input that was performed
	 */
	public synchronized void processKeyEvent(LeapKeyEvent keyEvent) {
		int actualKey = keyEvent.getKeyEvent().keyCode;
		int eventType = keyEvent.getType();
		if (holding == actualKey && eventType == SWT.KeyUp) {
			// held down key has been released before the input sequence was completed
			holding = -1;
			discardEvent();
			return;
		}
		KeyInput keyInput = validateInput(KeyInput.class, keyEvent);
		if (keyInput == null) {
			// next input is not a keyboard input -> start input sequence from the beginning and check if the first
			// input is a keyboard input
			discardEvent();
			keyInput = validateInput(KeyInput.class, keyEvent);
			if (keyInput == null) {
				return;
			}
		}
		int expectedKey = keyInput.getKey();
		if (expectedKey == actualKey) {
			if (leapEvent == null) {
				leapEvent = new LeapActionEvent(page.getActiveEditor(), helper);
			}
			leapEvent.addEvent(keyEvent);
			if (eventType == SWT.KeyDown) {
				if (keyInput.isHold()) { // key down events are only relevant for hold-input
					holding = actualKey;
					proceed(leapEvent, keyEvent);
				}
			} else if (eventType == SWT.KeyUp) {
				// key up events are only relevant for push-input
				proceed(leapEvent, keyEvent);
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
	 * @param mouseEvent the event of the mouse input that was performed
	 */
	public synchronized void processMouseEvent(LeapMouseEvent mouseEvent) {
		if (mouseEvent.getType() == SWT.MouseUp && remainingClicks == 1) { // check for an open doubleclick event
			// last click of the doubleclick event -> finish processing and reset the counter
			proceed(leapEvent, mouseEvent);
			remainingClicks = 0;
			return;
		}
		MouseInput mouseInput = validateInput(MouseInput.class, mouseEvent);
		if (mouseInput == null) {
			// next input is not a mouse input -> start input sequence from the beginning and check if the first
			// input is a mouse input
			discardEvent();
			mouseInput = validateInput(MouseInput.class, mouseEvent);
			if (mouseInput == null) {
				return;
			}
		}
		if (mouseEvent.getMouseEvent().button == mouseInput.getButton()) {
			if (leapEvent == null) {
				leapEvent = new LeapActionEvent(page.getActiveEditor(), helper);
			}
			leapEvent.addEvent(mouseEvent);
			if (mouseEvent.getType() == SWT.MouseDoubleClick) {
				// check for second sub-event of the doubleclick event
				if (mouseInput.isDoubleClick() && remainingClicks == 2) {
					remainingClicks--;
				}
			} else if (mouseEvent.getType() == SWT.MouseUp) {
				if (!mouseInput.isDoubleClick()) {
					// no doubleclick -> processing successful
					proceed(leapEvent, mouseEvent);
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
	 * Processes a speech event. This process is considered successful, if the next input in the input sequence is
	 * actually a speech input and if the actual phrase matches the expected phrase (ignoring case). In contrast to
	 * other processing steps, invalid speech input will not discard the current input event. This means, that phrases
	 * that differ from the expected phrase will not reset the input sequence. Thus, a phrase that is not recognized
	 * properly will have no effect.
	 * 
	 * @param speechEvent the event of the speech input that was performed
	 */
	public void processSpeech(LeapSpeechEvent speechEvent) {
		Result result = speechEvent.getResult();
		String actualPhrase = result.getBestFinalResultNoFiller();
		SpeechInput speechInput = validateInput(SpeechInput.class, speechEvent);
		if (speechInput == null) {
			return;
		}
		String expectedPhrase = speechInput.getPhrase();
		if (expectedPhrase.equalsIgnoreCase(actualPhrase)) {
			if (leapEvent == null) {
				leapEvent = new LeapActionEvent(page.getActiveEditor(), helper);
			}
			leapEvent.addEvent(speechEvent);
			proceed(leapEvent, speechEvent);
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
		if (holding >= 0) {
			leapEvent = null;
			currentInputIndex = 0;
			remainingClicks = 0;
			timeOfLastInput = 0;
			currentTimeout = 0;
		}
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
					notifyHandler(display.getActiveShell(), actionEvent);
				}
			});
			currentInputIndex = 0;
			holding = -1;
		} else {
			timeOfLastInput = inputEvent.getTime();
		}
	}

	/**
	 * Notifies this processor's {@link ILeapActionHandler} about the leap action event. If the handler requests a
	 * progress bar, a {@link ProgressMonitorDialog} is shown. Otherwise, the handler is passed a
	 * {@link NullProgressMonitor}, which will not display any progress.
	 * 
	 * @param shell the {@link Shell} to show the progress monitor dialog in- this is only used if the handler requests
	 *            a progress bar
	 * @param actionEvent the {@link LeapActionEvent} to notify the handler about
	 */
	private void notifyHandler(final Shell shell, final LeapActionEvent actionEvent) {
		if (handler.showProgress()) {
			ProgressMonitorDialog progressMonitor = new ProgressMonitorDialog(shell);
			try {
				progressMonitor.run(false, true, new IRunnableWithProgress() {

					@Override
					public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
						handler.handleLeapAction(actionEvent, monitor);
					}
				});
			} catch (InvocationTargetException e) {
				// a progress bar cannot be shown, but the handler can still be notified
				handler.handleLeapAction(actionEvent, new NullProgressMonitor());
			} catch (InterruptedException e) {
				handler.handleLeapAction(actionEvent, new NullProgressMonitor());
			}
		} else {
			// handler doesn't request a progress bar, so a null progress monitor is sufficient
			handler.handleLeapAction(actionEvent, new NullProgressMonitor());
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

	/**
	 * Retrieves this processor's JSGF definition locations used by the specified {@link SpeechInput}. The result may
	 * contain <code>null</code>, in which case the UNICASE default grammar is being used.
	 * 
	 * @return the JSGF definition locations as a set of {@link URL}s
	 */
	public Set<URL> getGrammarLocations() {
		return grammarLocations;
	}

	/**
	 * Checks whether or not this input processor has any gestures specified to process. This is <code>true</code> if
	 * and only if at least one {@link GestureInput} has been specified in the input sequence.
	 * 
	 * @return <code>true</code> if a {@link GestureInput} has been specified,<br />
	 *         <code>false</code> otherwise
	 */
	public boolean hasGestures() {
		return hasGestures;
	}

}
