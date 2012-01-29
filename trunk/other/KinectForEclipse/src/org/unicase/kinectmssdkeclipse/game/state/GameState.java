package org.unicase.kinectmssdkeclipse.game.state;

import org.eclipse.swt.widgets.Label;

public interface GameState {
	public Gesture getRequiredGesture();

	public String getRequiredSpeechString();

	public void performAction();

	public void paintScreen(Label label);

	public boolean isGestureEnabled();

	public boolean isSpeechEnabled();
}
