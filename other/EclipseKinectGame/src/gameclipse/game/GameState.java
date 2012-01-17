package gameclipse.game;

import org.eclipse.swt.widgets.Label;

public interface GameState {
	public Gesture getRequiredGesture();

	public void performAction();

	public void paintScreen(Label label);
}
