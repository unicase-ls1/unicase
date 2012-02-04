package edu.tum.in.bruegge.epd.kinect.game.states;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import edu.tum.in.bruegge.epd.kinect.game.GameHelper;
import edu.tum.in.bruegge.epd.kinect.gesture.Gesture;
import edu.tum.in.bruegge.epd.kinect.gesture.detectors.CrouchGestureDetector;

public class SixthState implements GameState {

	@Override
	public Class<? extends Gesture> getRequiredGesture() {
		return CrouchGestureDetector.class;
	}

	@Override
	public void performAction() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				GameHelper.runCommand("org.eclipse.debug.ui.commands.StepInto");
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
