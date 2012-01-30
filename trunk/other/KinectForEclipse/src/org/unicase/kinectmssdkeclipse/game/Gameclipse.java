package org.unicase.kinectmssdkeclipse.game;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;
import org.unicase.kinectmssdkeclipse.game.state.FifthState;
import org.unicase.kinectmssdkeclipse.game.state.FinalState;
import org.unicase.kinectmssdkeclipse.game.state.FourthState;
import org.unicase.kinectmssdkeclipse.game.state.GameState;
import org.unicase.kinectmssdkeclipse.game.state.Gesture;
import org.unicase.kinectmssdkeclipse.game.state.IntroState;
import org.unicase.kinectmssdkeclipse.game.state.SecondState;
import org.unicase.kinectmssdkeclipse.game.state.SeventhState;
import org.unicase.kinectmssdkeclipse.game.state.SixthState;
import org.unicase.kinectmssdkeclipse.game.state.ThirdState;
import org.unicase.kinectmssdkeclipse.game.timer.GameTimer;
import org.unicase.kinectmssdkeclipse.handlers.KinectProxy;

/**
 * The Kinect eclipse game.
 * 
 * @author Deepak Srinathan
 * 
 */
public class Gameclipse extends ViewPart implements SelectionListener,
		GestureListener, SpeechListener {

	public static final String ID = "org.unicase.kinectmssdkeclipse.game.Gameclipse";

	// the list of game states. assumption is that the game state transition is
	// linear (one after the other)
	private List<GameState> gameStates = new LinkedList<GameState>();

	// the label resource which gets changed by every state
	private Label label = null;

	// the timer lable
	private Label label_time = null;

	// game start/stop/reset button
	private Button buttonStart = null;

	// variable to remember the current state
	private int index = 0;

	// flag to check if the game is currently running or not
	private boolean gameState = false;

	// this is to make the focus working
	private Composite thisComp = null;

	// holds the value of the current game state
	private GameState currentState = null;

	// the game timer
	private GameTimer gameTimer = null;

	// isCalibratedFlag
	private boolean isCalibrated = false;

	// isKinectConnectedFlag
	private boolean isKinectConnected = false;

	/**
	 * Initialize the states ande its members and the state transitions
	 */
	private void initStates() {
		IntroState introState = new IntroState();
		SecondState secState = new SecondState();
		ThirdState thState = new ThirdState();
		FourthState fourthState = new FourthState();
		FifthState fifthState = new FifthState();
		SixthState sixthState = new SixthState();
		SeventhState seventhState = new SeventhState();
		FinalState finalState = new FinalState();

		gameStates.add(introState);
		gameStates.add(secState);
		gameStates.add(thState);
		gameStates.add(fourthState);
		gameStates.add(fifthState);
		gameStates.add(sixthState);
		gameStates.add(seventhState);
		gameStates.add(finalState);

	}

	/**
	 * Method to create the view
	 */
	@Override
	public void createPartControl(Composite parent) {
		thisComp = parent;

		// initialize the game states
		initStates();
		// Game not running
		gameState = false;

		// Define GridLayout
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 10;
		layout.marginTop = 10;
		layout.verticalSpacing = 20;
		layout.horizontalSpacing = 10;
		parent.setLayout(layout);

		// Add actions label
		label = new Label(parent, SWT.NONE);
		label.setFont(new Font(parent.getDisplay(), "Arial", 45, SWT.BOLD));
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		label.setLayoutData(gridData);

		// Add start/stop/reset button
		buttonStart = new Button(parent, SWT.None);
		buttonStart.setText("Start Game!");
		buttonStart
				.setFont(new Font(parent.getDisplay(), "Arial", 28, SWT.BOLD));

		// Add a label that shows the time
		label_time = new Label(parent, SWT.None);
		label_time
				.setFont(new Font(parent.getDisplay(), "Arial", 35, SWT.BOLD));
		label_time.setLayoutData(gridData);
		label_time.setText("0");
		label_time.setAlignment(SWT.CENTER);

		// Initialize first gameState
		currentState = gameStates.get(index);
		// currentState.paintScreen(label);
		label.setText("Please Click on the Start Game button to start...");

		buttonStart.addSelectionListener(this);

		gameTimer = new GameTimer(thisComp.getDisplay(), label_time);
		parent.setFocus();
	}

	/**
	 * Set focus to set the focus to the component inside the view
	 */
	@Override
	public void setFocus() {
		thisComp.setFocus();
	}

	/**
	 * Game start method, which also initializes the Kinect Gesture recognition
	 */
	private void start() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				currentState.paintScreen(label);
				gameTimer.startTimer();
			}
		});
	}

	/**
	 * Game stop method
	 */
	private void stop() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				// KinectProxy.stopHandle();
				// KinectProxy.stopGestureRecognition();
				// isCalibrated = false;
				gameState = false;
				gameTimer.stopTimer();
				label.setText("And your're done.. Good Job !!");
				buttonStart.setText("Reset Game");
			}
		});
	}

	/**
	 * Game reset method
	 */
	private void reset() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				// KinectProxy.stopHandle();
				// KinectProxy.stopGestureRecognition();
				gameTimer.reset();
				// isCalibrated = false;
				index = 0;
				currentState = gameStates.get(index);
				// currentState.paintScreen(label);
				label.setText("Please Click on the Start Game button to start...");
				buttonStart.setText("Start Game");
			}
		});
	}

	/**
	 * Gesture listener
	 */
	@Override
	public void gestureDetected(Gesture gesture) {
		if (!isCalibrated && gesture.equals(Gesture.CALIBRATE)) {
			System.out.println("Calibrated");
			isCalibrated = true;
			start();
		}

		if (isCalibrated && currentState.isGestureEnabled()
				&& currentState.getRequiredGesture().equals(gesture)) {
			performStateOperation();
		}
	}

	/**
	 * Action for Game button
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		// Button has been clicked, what's the current action?
		if (gameState) {
			// Stop
			stop();
		} else if (!gameState) {
			if (gameTimer.getTime() != 0) {
				// Reset
				reset();
			} else {
				// Start
				// init the kinect
				if (!isKinectConnected) {
					KinectProxy.handle(this);
					isKinectConnected = true;
				}
				KinectProxy.startGestureRecognition();
				KinectProxy.startSpeechRecog();
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						buttonStart.setText("Stop Game");
						gameState = true;
						setFocus();
						if (!isCalibrated) {
							label.setText("Please Calibrate the device to start the game..");
						} else {
							start();
							currentState.paintScreen(label);
						}
					}
				});
			}
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
	}

	private void performStateOperation() {
		if (gameState) {
			// perform action on the current state
			currentState.performAction();

			// paint the next state (and update the current state)
			currentState = gameStates.get(++index);
			currentState.paintScreen(label);

			if (index == gameStates.size() - 1) {
				index = 0;
				stop();
			}
		}
	}

	@Override
	public void speechDetected(String speech) {
		if (currentState.isSpeechEnabled()
				&& currentState.getRequiredSpeechString().equalsIgnoreCase(
						speech)) {
			performStateOperation();
		}
	}

}
