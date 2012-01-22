package org.unicase.kinectmssdkeclipse;

/*
 import org.eclipse.swt.SWT;
 import org.eclipse.swt.widgets.Display;
 import org.eclipse.swt.widgets.Label;
 import org.eclipse.swt.widgets.Menu;
 import org.eclipse.swt.widgets.Shell;
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.unicase.kinectmssdkeclipse.game.GestureListener;

import humandiagramgef.HumanBodyEnum;

public class GestureRecognition {
	private boolean wasLeftHandUp = false;
	private boolean wasRightHandUp = false;
	private float leftHandYPosition;
	private float leftHandYPositionBefore;
	private float rightHandYPosition;
	private float rightHandYPositionBefore;
	private float headYPosition;
	private float headYPositionBefore;
	private float headYNice = 0;
	private boolean isCalibrated = false;
	private boolean isStopped = false;
	private int frameCount = 0;
	private int status = Constants.STATUS_NICE;
	private GestureListener gestureListener;

	public void setGestureListener(GestureListener gestureListener) {
		this.gestureListener = gestureListener;
	}

	public void saveYPositions(HumanBodyEnum humanPart, float positionY) {
		if (humanPart.equals(HumanBodyEnum.Hand_Left)) {
			leftHandYPosition = Math.round(positionY * 10);
		} else if (humanPart.equals(HumanBodyEnum.Head)) {
			headYPosition = Math.round(positionY * 10);
		}
		if (humanPart.equals(HumanBodyEnum.Hand_Right)) {
			rightHandYPosition = Math.round(positionY * 10);
		}
	}

	private boolean isHelloJonas() {
		if (this.wasLeftHandUp && this.leftHandYPosition < this.headYPosition) {
			this.wasLeftHandUp = false;
			this.headYPositionBefore = 0;
			this.leftHandYPositionBefore = 0;
			headYNice = headYPosition;
			return true;
		} else if (this.leftHandYPosition >= this.headYPosition
				&& this.headYPositionBefore == 0
				&& this.leftHandYPositionBefore == 0) {
			this.leftHandYPositionBefore = this.leftHandYPosition;
			this.headYPositionBefore = this.headYPosition;
			this.wasLeftHandUp = true;
		}
		return false;
	}

	private boolean isGoodByeJonas() {
		if (status == Constants.STATUS_NICE) {
			if (this.wasRightHandUp && this.rightHandYPosition < this.headYPosition) {
				this.wasRightHandUp = false;
				this.headYPositionBefore = 0;
				this.rightHandYPositionBefore = 0;
				return true;
			} else if (this.rightHandYPosition >= this.headYPosition
					&& this.rightHandYPositionBefore == 0) {
				this.rightHandYPositionBefore = this.rightHandYPosition;
				this.headYPositionBefore = this.headYPosition;
				this.wasRightHandUp = true;
			}
		}
		return false;
	}

	private boolean isNice() {
		if (headYPosition == headYNice) {
			status = Constants.STATUS_NICE;
			return true;
		}
		return false;
	}

	private boolean isJump() {
		if (status == Constants.STATUS_NICE) {
			if (headYPosition >= (headYNice + Constants.THRESHOLD_JUMP)) {
				status = Constants.STATUS_JUMP;
				return true;
			}
		}
		return false;
	}

	private boolean isCrouch() {
		if (status == Constants.STATUS_NICE) {
			if (headYPosition <= (headYNice - Constants.THRESHOLD_CROUCH)) {
				status = Constants.STATUS_CROUCH;
				return true;
			}
		}
		return false;
	}

	public void checkForGesture() {
		frameCount++;
		if (!isStopped) {
			if (frameCount > Constants.KINECT_FPS) {
				frameCount = 0;
				if (isHelloJonas()) {
					showText("Hello! " + headYNice);
					isCalibrated = true;
				}
				if (isCalibrated) {
					if (isNice()) {
						/* Do Nothing */
					} else if (isJump()) {
						gestureListener.gestureDetected(org.unicase.kinectmssdkeclipse.game.state.Gesture.JUMP);
//						showText("Jump! " + headYPosition);

					} else if (isCrouch()) {
						gestureListener.gestureDetected(org.unicase.kinectmssdkeclipse.game.state.Gesture.CROUCH);
//						showText("Crouch! " + headYPosition);
					} else if (isGoodByeJonas()) {
						gestureListener.gestureDetected(org.unicase.kinectmssdkeclipse.game.state.Gesture.WAVE_RIGHT);
						showText("Good Bye!");
						isStopped = true;
					}
					headYPositionBefore = headYPosition;
				}
			}
		}
	}

	private void showText(final String text) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				Shell shell = new Shell(Display.getDefault());
				Label label = new Label(shell, SWT.BORDER);
				Menu menu = new Menu(shell, SWT.POP_UP);
				label.setText(text);
				label.setBounds(0, 0, 300, 25);
				menu.setVisible(true);
				shell.setMenu(menu);
				shell.setSize(300, 70);
				shell.open();
			}
		});
	}

	public Gesture getActualRecognizedGesture() {
		return Gesture.HAND_OVER_HEAD;
	}
}
