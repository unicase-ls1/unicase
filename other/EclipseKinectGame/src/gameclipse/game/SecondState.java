package gameclipse.game;

import org.eclipse.swt.widgets.Label;

public class SecondState implements GameState {

	@Override
	public Gesture getRequiredGesture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void performAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintScreen(Label label) {
		label.setText("Second State");
	}

}
