package gameclipse.game;

import org.eclipse.swt.widgets.Label;

public class IntroState implements GameState {

	@Override
	public Gesture getRequiredGesture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void performAction() {

	}

	@Override
	public void paintScreen(Label label) {
		label.setText("Initial State");
	}
}
