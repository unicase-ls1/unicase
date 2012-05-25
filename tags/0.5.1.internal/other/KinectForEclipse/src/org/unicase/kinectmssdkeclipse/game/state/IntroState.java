package org.unicase.kinectmssdkeclipse.game.state;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.unicase.kinectmssdkeclipse.handlers.EclipseActions;

public class IntroState implements GameState {

	@Override
	public Gesture getRequiredGesture() {
		return Gesture.JUMP;
	}

	@Override
	public void performAction() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				EclipseActions
						.runCommand("org.eclipse.debug.ui.commands.DebugLast");
			}
		});
	}

	@Override
	public void paintScreen(final Label label) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				label.setText("Say \"Start Debug Mode\"..");
			}
		});
	}

	@Override
	public String getRequiredSpeechString() {
		return "Start debug mode";
	}

	@Override
	public boolean isGestureEnabled() {
		return false;
	}

	@Override
	public boolean isSpeechEnabled() {
		return true;
	}

}
