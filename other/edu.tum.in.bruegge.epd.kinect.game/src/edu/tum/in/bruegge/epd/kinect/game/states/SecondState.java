package edu.tum.in.bruegge.epd.kinect.game.states;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import edu.tum.in.bruegge.epd.kinect.game.GameHelper;
import edu.tum.in.bruegge.epd.kinect.gesture.Gesture;
import edu.tum.in.bruegge.epd.kinect.gesture.detectors.JumpGestureDetector;

public class SecondState implements GameState {

	@Override
	public void performAction() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				GameHelper.runCommand("org.eclipse.debug.ui.commands.StepOver");
			}
		});
	}

	@Override
	public void paintScreen(final Label label) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				label.setText("JUMP to Step Over");
			}
		});
	}

	@Override
	public String getRequiredSpeechString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isGestureEnabled() {
		return true;
	}

	@Override
	public boolean isSpeechEnabled() {
		return false;
	}

	@Override
	public Class<? extends Gesture> getRequiredGesture() {
		return JumpGestureDetector.class;
	}

}
