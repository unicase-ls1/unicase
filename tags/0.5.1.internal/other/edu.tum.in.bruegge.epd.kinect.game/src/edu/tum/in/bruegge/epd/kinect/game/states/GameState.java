package edu.tum.in.bruegge.epd.kinect.game.states;

import org.eclipse.swt.widgets.Label;

import edu.tum.in.bruegge.epd.kinect.gesture.Gesture;

public interface GameState {

	public Class<? extends Gesture> getRequiredGesture();

	public String getRequiredSpeechString();

	public void performAction();

	public void paintScreen(Label label);

	public boolean isGestureEnabled();

	public boolean isSpeechEnabled();
}
