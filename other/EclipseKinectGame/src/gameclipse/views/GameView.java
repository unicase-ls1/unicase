package gameclipse.views;

import gameclipse.game.FinalState;
import gameclipse.game.GameState;
import gameclipse.game.IntroState;
import gameclipse.game.SecondState;
import gameclipse.game.ThirdState;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class GameView extends ViewPart implements KeyListener {

	public static final String ID = "gameclipse.views.GameView";

	private List<GameState> gameStates = new LinkedList<GameState>();

	private Label label = null;

	private int index = 0;

	private Composite thisComp = null;

	private GameState currentState = null;

	private void initStates() {
		IntroState introState = new IntroState();
		SecondState secState = new SecondState();
		ThirdState thState = new ThirdState();
		FinalState finalState = new FinalState();

		gameStates.add(introState);
		gameStates.add(secState);
		gameStates.add(thState);
		gameStates.add(finalState);
	}

	public void createPartControl(Composite parent) {
		thisComp = parent;

		// initialize the game states
		initStates();

		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 10;
		parent.setLayout(layout);
		label = new Label(parent, SWT.NONE);

		currentState = gameStates.get(index++);
		currentState.paintScreen(label);

		parent.addKeyListener(this);
		parent.setFocus();
	}

	public void setFocus() {
		thisComp.setFocus();
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		char c = e.character;
		switch (c) {
		case 'a':
			if (index == gameStates.size()) {
				index = 0;
			}

			// perform action on the current state
			currentState.performAction();

			// paint the next state (and update the current state)
			currentState = gameStates.get(index++);
			currentState.paintScreen(label);
			break;
		}
	}
}