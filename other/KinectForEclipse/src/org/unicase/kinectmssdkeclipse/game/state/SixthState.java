package org.unicase.kinectmssdkeclipse.game.state;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.unicase.kinectmssdkeclipse.handlers.EclipseActions;

public class SixthState implements GameState {

	@Override
	public Gesture getRequiredGesture() {
		return Gesture.CROUCH;
	}

	@Override
	public void performAction() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				EclipseActions
						.runCommand("org.eclipse.debug.ui.commands.StepInto");
			}
		});
	}

	@Override
	public void paintScreen(final Label label) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				label.setText("Crouch again to Step Into");
			}
		});
	}

	@Override
	public String getRequiredSpeechString() {
		return null;
	}

	@Override
	public boolean isGestureEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isSpeechEnabled() {
		return false;
	}
}
