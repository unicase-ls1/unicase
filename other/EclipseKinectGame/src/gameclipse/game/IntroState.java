package gameclipse.game;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import gameclipse.handlers.EclipseActions;

public class IntroState implements GameState {

	@Override
	public Gesture getRequiredGesture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void performAction() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				EclipseActions.runCommand("org.eclipse.debug.ui.commands.DebugLast");
			}
		});
	}

	@Override
	public void paintScreen(Label label) {
		label.setText("Initial State");
	}
}
