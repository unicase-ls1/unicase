package gameclipse.game;

import gameclipse.handlers.EclipseActions;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class FinalState implements GameState {

	@Override
	public Gesture getRequiredGesture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void performAction() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				EclipseActions.runCommand("org.eclipse.debug.ui.commands.Resume");
			}
		});

	}

	@Override
	public void paintScreen(Label label) {
		label.setText("Final State");
	}

}
