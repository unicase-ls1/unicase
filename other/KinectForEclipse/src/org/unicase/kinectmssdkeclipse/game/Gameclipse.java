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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.part.ViewPart;
import org.unicase.kinectmssdkeclipse.game.state.FinalState;
import org.unicase.kinectmssdkeclipse.game.state.FourthState;
import org.unicase.kinectmssdkeclipse.game.state.GameState;
import org.unicase.kinectmssdkeclipse.game.state.Gesture;
import org.unicase.kinectmssdkeclipse.game.state.IntroState;
import org.unicase.kinectmssdkeclipse.game.state.SecondState;
import org.unicase.kinectmssdkeclipse.game.state.ThirdState;
import org.unicase.kinectmssdkeclipse.game.timer.GameTimer;
import org.unicase.kinectmssdkeclipse.handlers.KinectProxy;

public class Gameclipse extends ViewPart implements Listener, GestureListener {

	public static final String ID = "org.unicase.kinectmssdkeclipse.game.Gameclipse";

	private List<GameState> gameStates = new LinkedList<GameState>();

	private Label label = null;

	private Label label_time = null;

	private Button buttonStart = null;

	private int index = 0;

	private boolean gameState = false;

	private Composite thisComp = null;

	private GameState currentState = null;

	private GameTimer gameTimer = null;

	private void initStates() {
		IntroState introState = new IntroState();
		SecondState secState = new SecondState();
		ThirdState thState = new ThirdState();
		FourthState fourthState = new FourthState();
		FinalState finalState = new FinalState();

		gameStates.add(introState);
		gameStates.add(secState);
		gameStates.add(thState);
		gameStates.add(fourthState);
		gameStates.add(finalState);
	}

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
		label.setFont(new Font(parent.getDisplay(), "Arial", 52, SWT.BOLD));
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
				.setFont(new Font(parent.getDisplay(), "Arial", 32, SWT.BOLD));
		label_time.setLayoutData(gridData);
		label_time.setText("0");
		label_time.setAlignment(SWT.CENTER);

		// Initialize first gameState
		currentState = gameStates.get(index);
		currentState.paintScreen(label);

		KinectProxy.handle(this);

		buttonStart.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// Button has been clicked, what's the current action?
				if (gameState) {
					// Stop
					KinectProxy.stopHandle();
					stop();
				} else if (!gameState) {
					if (gameTimer.getTime() != 0) {
						KinectProxy.stopHandle();
						// Reset
						reset();
					} else {
						// Start
						// init the kinect
						KinectProxy.startGestureRecognition();
						KinectProxy.startSpeechRecog();
						start();
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		gameTimer = new GameTimer(thisComp.getDisplay(), label_time);

		parent.getDisplay().addFilter(SWT.KeyDown, this);
		parent.setFocus();
	}

	public void setFocus() {
		thisComp.setFocus();
	}

	@Override
	public void handleEvent(Event e) {
		char c = e.character;
		switch (c) {
		case 'a':
			if (gameState) {
				// perform action on the current state
				currentState.performAction();

				// paint the next state (and update the current state)
				currentState = gameStates.get(++index);
				currentState.paintScreen(label);

				if (index == gameStates.size() - 1) {
					index = 0;
					stop();
					currentState.paintScreen(label);
					return;
				}
			}
			break;
		}
	}

	private void start() {
		buttonStart.setText("Stop Game");
		gameState = true;
		setFocus();
		gameTimer.startTimer();
	}

	private void stop() {
		gameState = false;
		gameTimer.stopTimer();
		buttonStart.setText("Reset Game");
	}

	private void reset() {
		gameTimer.reset();
		index = 0;
		currentState = gameStates.get(index);
		currentState.paintScreen(label);
		buttonStart.setText("Start Game");
	}

	@Override
	public void gestureDetected(Gesture gesture) {
		if (currentState.getRequiredGesture().equals(gesture)) {
			// perform action on the current state
			currentState.performAction();

			// paint the next state (and update the current state)
			currentState = gameStates.get(++index);
			currentState.paintScreen(label);

			if (index == gameStates.size() - 1) {
				index = 0;
				stop();
				currentState.paintScreen(label);
				return;
			}

		}

	}
}
