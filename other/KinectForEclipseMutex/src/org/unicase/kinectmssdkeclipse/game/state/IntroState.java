package org.unicase.kinectmssdkeclipse.game.state;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class IntroState implements GameState {

	@Override
	public Gesture getRequiredGesture() {
		return Gesture.CALIBRATE;
	}

	@Override
	public String getRequiredSpeechString() {
		return "Fix Bug";
	}

	@Override
	public void performAction() {

	}

	@Override
	public void paintScreen(final Label label) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				label.setText("Please Click on the Start Game button to start...");
			}
		});
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
