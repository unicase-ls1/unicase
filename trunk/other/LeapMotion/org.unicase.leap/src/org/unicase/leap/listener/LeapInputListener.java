/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.listener;

import java.io.IOException;
import java.lang.Thread.State;
import java.net.URL;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.unicase.leap.action.LeapHelper;
import org.unicase.leap.action.MouseMoverRunnable;
import org.unicase.leap.events.LeapGestureEvent;
import org.unicase.leap.events.LeapKeyEvent;
import org.unicase.leap.events.LeapMouseEvent;
import org.unicase.leap.events.LeapSpeechEvent;
import org.unicase.leap.input.InputProcessor;
import org.unicase.leap.input.InputUtil;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.Pointable;
import com.leapmotion.leap.Tool;
import com.leapmotion.leap.Vector;

import edu.cmu.sphinx.jsgf.JSGFGrammarException;
import edu.cmu.sphinx.jsgf.JSGFGrammarParseException;
import edu.cmu.sphinx.result.Result;

/**
 * A {@link Listener} extension that provides the possibility to convert leap motion input data into cursor movement.
 * Also, any captured fingers or tools can be displayed. Any occurring gestures are forwarded to the corresponding
 * {@link org.unicase.leap.action.ILeapActionHandler ILeapActionHandlers}.
 * 
 * @author mharut
 */
public class LeapInputListener extends Listener {

	/**
	 * The leap motion controller tracking sensor data.
	 */
	private final Controller controller;
	/**
	 * Flag indicating whether {@link Finger} input should be listened to or not.
	 */
	private final boolean fingersEnabled;
	/**
	 * Flag indicating whether {@link Tool} input should be listened to or not.
	 */
	private final boolean toolsEnabled;
	/**
	 * Flag indicating whether all {@link Pointable} input should be visualized (instead of only the first pointable to
	 * enter the tracking area).
	 */
	private final boolean visualizeAll;
	/**
	 * Mapping from IDs of {@link Pointable}s to the shell used to visualize their input.
	 */
	private final Map<Integer, Shell> pointableToVisual = new HashMap<Integer, Shell>();
	/**
	 * The list of input processors the input events should be forwarded to.
	 */
	private final List<InputProcessor> inputProcessors = new LinkedList<InputProcessor>();
	/**
	 * The leap helper used for computations on leap motion sensor data.
	 */
	private final LeapHelper helper;
	/**
	 * The mouse listener {@link MouseEvent}s are forwarded to.
	 */
	private final MouseListener mouseListener;
	/**
	 * The key listener {@link KeyEvent}s are forwarded to.
	 */
	private final KeyListener keyListener;
	/**
	 * The speech listeners used to listen to recognized speech by sphinx4.
	 */
	private final Set<SpeechListener> speechListeners = new HashSet<SpeechListener>();
	/**
	 * Flag indicating whether gestures are enabled or not. If this is <code>false</code>, the leap sensor is only
	 * listened to if mouse movement has been enabled by either fingers or tools.
	 * 
	 * @see #fingersEnabled
	 * @see #toolsEnabled
	 */
	private boolean gesturesEnabled;
	/**
	 * The ID of the main {@link Pointable} that is being captured by the leap motion {@link Controller}. This is the
	 * pointable that was tracked first by the controller and is still valid. Once the main pointable is invalid, it
	 * will be replaced by the next valid pointable.
	 */
	private int mainPointableId = -1;
	/**
	 * The thread used to process {@link org.eclipse.swt.graphics.Cursor Cursor} movement asynchronously whenever new
	 * leap motion sensor data has been tracked.
	 */
	private Thread moveCursorThread;

	/**
	 * Constructs a new leap listener for a {@link Controller} tracking sensor data and flags used for configuration.
	 * 
	 * @param controller the leap motion controller tracking sensor data
	 * @param toolsEnabled whether or not {@link Tool} tracking should be enabled
	 * @param fingersEnabled whether or not {@link Finger} tracking should be enabled
	 * @param visualizeAll whether or not all {@link Pointable}s should be visualized (instead of just the main
	 *            pointable)
	 */
	public LeapInputListener(Controller controller, boolean toolsEnabled, boolean fingersEnabled, boolean visualizeAll) {
		this.controller = controller;
		this.fingersEnabled = fingersEnabled;
		this.toolsEnabled = toolsEnabled;
		this.visualizeAll = visualizeAll;
		this.helper = new LeapHelper(controller);
		this.mouseListener = new MouseListener(this);
		this.keyListener = new KeyListener(this);
	}

	/**
	 * Starts this listener by adding it to the {@link Controller}. If either {@link Finger} or {@link Tool} tracking is
	 * enabled, a new thread responsible for mouse movement is being started. In addition, filters for mouse and
	 * keyboard events will be added to the display.
	 */
	public void start() {
		// listen to the leap controller if either gestures, fingers or tools are enabled
		boolean mouseMovementEnabled = fingersEnabled || toolsEnabled;
		if (gesturesEnabled || mouseMovementEnabled) {
			controller.addListener(this);
			if (mouseMovementEnabled) {
				moveCursorThread = new Thread(new MouseMoverRunnable(helper));
				if (controller.isConnected()) {
					moveCursorThread.start();
				}
			}
		}

		// add filters for mouse and keyboard events to the display
		Display display = Display.getCurrent();
		if (display == null) {
			display = Display.getDefault();
		}
		final Display finalDisplay = display;
		finalDisplay.asyncExec(new Runnable() {

			@Override
			public void run() {
				finalDisplay.addFilter(SWT.MouseUp, mouseListener);
				finalDisplay.addFilter(SWT.MouseDoubleClick, mouseListener);
				finalDisplay.addFilter(SWT.KeyDown, keyListener);
				finalDisplay.addFilter(SWT.KeyUp, keyListener);
			}
		});

		// start listening to sphinx4 speech recognition
		for (SpeechListener speechListener : speechListeners) {
			speechListener.addListener(this);
		}

	}

	/**
	 * Stops this listener by removing it from the {@link Controller}. If the {@link Thread} responsible for mouse
	 * movement is still alive, it is being interrupted. In the process, the cursor is also set back to its default
	 * value. In addition, filters for mouse and keyboard events will be removed from the display.
	 */
	public void stop() {
		// stop mouse movement via leap sensor information and hide the cursor, if it was enabled
		if (moveCursorThread != null && moveCursorThread.isAlive()) {
			moveCursorThread.interrupt();
			helper.hideLeapCursor();
		}
		controller.removeListener(this);

		// remove mouse and keyboard event filters
		Display display = Display.getCurrent();
		if (display == null) {
			display = Display.getDefault();
		}
		final Display finalDisplay = display;
		finalDisplay.asyncExec(new Runnable() {

			@Override
			public void run() {
				finalDisplay.removeFilter(SWT.MouseUp, mouseListener);
				finalDisplay.removeFilter(SWT.MouseDoubleClick, mouseListener);
				finalDisplay.removeFilter(SWT.KeyDown, keyListener);
				finalDisplay.removeFilter(SWT.KeyUp, keyListener);
			}
		});

		// stop listening to sphinx4 speech recognition
		for (SpeechListener speechListener : speechListeners) {
			speechListener.removeListener(this);
		}
	}

	/**
	 * Disposes this listener. This will try to dispose every speech listener by deallocating the required resources
	 * (like microphone or recognizer).
	 */
	public void dispose() {
		// FIXME controller.delete();

		for (SpeechListener speechListener : speechListeners) {
			speechListener.dispose();
		}
	}

	@Override
	public void onConnect(Controller controller) {
		if (moveCursorThread != null && State.NEW.equals(moveCursorThread.getState())) {
			moveCursorThread.start();
		}
	}

	@Override
	public void onDisconnect(Controller controller) {
		helper.hideLeapCursor();
	}

	@Override
	public void onFrame(Controller controller) {
		Frame frame = controller.frame();
		if (mainPointableId >= 0) { // make sure the main pointable is still tracked
			Pointable mainPointable = frame.pointable(mainPointableId);
			if (!mainPointable.isValid()) {
				mainPointableId = -1;
			}
		}
		if (toolsEnabled) {
			processTools(frame);
		}
		if (fingersEnabled) {
			processFingers(frame);
		}
		processGestures(frame);
		if (visualizeAll) {
			try {
				Set<Integer> copiedEntries = new HashSet<Integer>(pointableToVisual.keySet());
				for (Integer id : copiedEntries) {
					Pointable pointable = frame.pointable(id);
					if (!pointable.isValid() || id.equals(mainPointableId)) {
						removeVisualization(id); // remove any visualization from untracked pointables
					}
				}
			} catch (ConcurrentModificationException e) {
				// do nothing
			}
		}
	}

	/**
	 * Processes tracking data regarding {@link Tool}s for a single {@link Frame}. If no {@link Pointable} is used for
	 * moving the mouse cursor, the first valid tool will be put as the main pointable responsible for cursor movement.
	 * If {@link #visualizeAll} is set to true, every other tool will be visualized using a {@link Shell}.
	 * 
	 * @param frame the {@link Frame} containing leap motion tracking data
	 */
	private void processTools(Frame frame) {
		if (mainPointableId < 0 || visualizeAll) {
			for (final Tool tool : frame.tools()) {
				final int id = tool.id();
				if (mainPointableId < 0) {
					mainPointableId = id;
					helper.setMainPointable(id);
					if (!visualizeAll) {
						break;
					}
				} else if (id != mainPointableId) {
					final Vector leapPosition = helper.getTip(tool);
					final Vector screenPosition = helper.convert(leapPosition, tool);
					if (screenPosition != null && screenPosition.isValid()) {
						addVisualization(id, Math.round(screenPosition.getX()), Math.round(screenPosition.getY()));
					}
				}
			}
		}
	}

	/**
	 * Processes tracking data regarding {@link Finger}s for a single {@link Frame}. If no {@link Pointable} is used for
	 * moving the mouse cursor, the first valid finger will be put as the main pointable responsible for cursor
	 * movement. If {@link #visualizeAll} is set to true, every other finger will be visualized using a {@link Shell}.
	 * 
	 * @param frame the {@link Frame} containing leap motion tracking data
	 */
	private void processFingers(Frame frame) {
		if (mainPointableId < 0 || visualizeAll) {
			for (final Finger finger : frame.fingers()) {
				final int id = finger.id();
				if (mainPointableId < 0) {
					mainPointableId = id;
					helper.setMainPointable(id);
					if (!visualizeAll) {
						break;
					}
				} else if (id != mainPointableId) {
					final Vector leapPosition = helper.getTip(finger);
					final Vector screenPosition = helper.convert(leapPosition, finger);
					if (screenPosition != null && screenPosition.isValid()) {
						addVisualization(id, Math.round(screenPosition.getX()), Math.round(screenPosition.getY()));
					}
				}
			}
		}
	}

	/**
	 * Processes {@link Gesture}s of a single {@link Frame}. Any gesture will be wrapped in a gesture event and
	 * forwarded to the corresponding input processor.
	 * 
	 * @param frame the {@link Frame} containing the gesture sensor data
	 */
	private void processGestures(Frame frame) {
		for (Gesture gesture : frame.gestures()) {
			LeapGestureEvent event = new LeapGestureEvent(gesture, System.currentTimeMillis());
			for (InputProcessor inputProcessor : inputProcessors) {
				inputProcessor.processGesture(event);
			}
		}
	}

	/**
	 * Adds a visualiztaion for a {@link Pointable}, identified by its ID. The visualization will be a small image in a
	 * new {@link Shell}. The new shell is required to make it possible for the visualization to be moved to any place
	 * in the screen. If a shell already exists for the specified pointable, it will simply be updated instead of
	 * creating a new one.
	 * 
	 * @param id the ID of the {@link Pointable} to add the visualization for
	 * @param x the x-coordinate of the visualization to add
	 * @param y the y-coordinate of the visualization to add
	 */
	private void addVisualization(final int id, final int x, final int y) {
		final Display display = Display.getDefault();
		final Shell existingShell = pointableToVisual.get(id);
		if (existingShell == null) {
			display.syncExec(new Runnable() {

				@Override
				public void run() {
					Shell activeShell = display.getActiveShell();
					Shell shell = createVisualization(display, x, y);
					pointableToVisual.put(id, shell);
					shell.open();
					if (activeShell != null) {
						activeShell.forceActive(); // ensure the previously activated shell doesn't lose focus
					}
				}
			});
		} else {
			display.syncExec(new Runnable() {

				@Override
				public void run() {
					if (!existingShell.isDisposed()) {
						existingShell.setLocation(x, y);
					}
				}
			});
		}
	}

	/**
	 * Creates a new {@link Pointable} visualization by constructing a new {@link Shell} with no trimming that is always
	 * on top of other shells.
	 * 
	 * @param display the {@link Display} to create the visualization for
	 * @param x the x-coordinate of the location where the visualization should be created
	 * @param y the y-coordinate of the location where the visualization should be created
	 * @return the created visualization as a {@link Shell}
	 */
	private Shell createVisualization(Display display, int x, int y) {
		Shell shell = new Shell(display, SWT.NO_TRIM | SWT.ON_TOP);
		shell.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
		shell.setSize(18, 18);
		shell.setLocation(x, y);
		return shell;
	}

	/**
	 * Removes a visualization of a {@link Pointable} specified by an ID. This will close the corresponding
	 * {@link Shell} and dispose it.
	 * 
	 * @param id the ID of the {@link Pointable} to remove
	 */
	private void removeVisualization(final int id) {
		final Shell shell = pointableToVisual.get(id);
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				if (shell != null && !shell.isDisposed()) {
					shell.close();
					shell.dispose();
				}
				pointableToVisual.remove(id);
			}

		});
	}

	/**
	 * Handles a mouse event by wrapping the actual {@link MouseEvent} in a {@link LeapMouseEvent} and forwarding this
	 * wrapper to all input processors.
	 * 
	 * @param event the event to handle
	 * @param type the type of the event to handle
	 * @see org.eclipse.swt.SWT#MouseUp
	 * @see org.eclipse.swt.SWT#MouseDown
	 */
	public void handleMouseEvent(MouseEvent event, int type) {
		LeapMouseEvent leapEvent = new LeapMouseEvent(controller.frame(), event, type);
		for (InputProcessor inputProcessor : inputProcessors) {
			inputProcessor.processMouseEvent(leapEvent);
		}
	}

	/**
	 * Handles a key event by wrapping the actual {@link KeyEvent} in a {@link LeapKeyEvent} and forwarding this wrapper
	 * to all input processors.
	 * 
	 * @param event the event to handle
	 * @param type the type of the event to handle
	 * @see org.eclipse.swt.SWT keyboard constants
	 */
	public void handleKeyEvent(KeyEvent event, int type) {
		LeapKeyEvent leapEvent = new LeapKeyEvent(controller.frame(), event, type);
		for (InputProcessor inputProcessor : inputProcessors) {
			inputProcessor.processKeyEvent(leapEvent);
		}
	}

	/**
	 * Handles the result of a sphinx4 speech recognition by wrapping the result in a {@link LeapSpeechEvent} along with
	 * the current time and the current {@link Frame} of the leap motion {@link Controller}. The speech event is then
	 * forwarded to all input processors.
	 * 
	 * @param result the result of the sphinx4 speech recognition
	 */
	public void handleSpeechRecognized(Result result) {
		LeapSpeechEvent leapEvent = new LeapSpeechEvent(controller.frame(), result, System.currentTimeMillis());
		for (InputProcessor inputProcessor : inputProcessors) {
			inputProcessor.processSpeech(leapEvent);
		}
	}

	/**
	 * Adds an input processor to this listener. Any input received by this listener will be forwarded to all input
	 * processor. If one of the input processors completely processes an input sequence, it will call the corresponding
	 * handler to execute its actions.
	 * 
	 * @param inputProcessor the {@link InputProcessor} to add
	 */
	public void addInputProcessor(InputProcessor inputProcessor) {
		inputProcessors.add(inputProcessor);
		inputProcessor.setHelper(helper);
		if (inputProcessor.hasGestures()) {
			gesturesEnabled = true;
		}
		for (URL grammarLocation : inputProcessor.getGrammarLocations()) {
			try {
				SpeechListener speechListener = InputUtil.getSpeechListener(grammarLocation);
				speechListeners.add(speechListener);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSGFGrammarParseException e) {
				e.printStackTrace();
			} catch (JSGFGrammarException e) {
				e.printStackTrace();
			}
		}
	}
}
