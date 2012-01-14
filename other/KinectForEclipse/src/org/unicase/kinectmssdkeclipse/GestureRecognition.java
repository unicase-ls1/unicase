package org.unicase.kinectmssdkeclipse;

/*
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
*/
import humandiagramgef.HumanBodyEnum;

public class GestureRecognition {
	private int KINECT_FPS = 30;
	private boolean wasLefHandUp=false;
	private float leftHandYPosition;
	private float headYPosition;
	//private long timeLeftHandAboveHead;
	private float leftHandYPositionBefore;
	private float headYPositionBefore;
	private int leftFootY;
	private int leftFootYBefore;
	private int rightFootY;
	private int rightFootYBefore;
	private Gesture actualRecognizedGesture=null;
	private int frameCount = 0;
	
	public void saveYPositions(HumanBodyEnum humanPart, float positionY) {
		if (humanPart.equals(HumanBodyEnum.Hand_Left)) {
			leftHandYPosition = Math.round(positionY * 10);
		} else if (humanPart.equals(HumanBodyEnum.Head)) {
			headYPosition = Math.round(positionY * 10);
		} else if (humanPart.equals(HumanBodyEnum.Foot_Left)) {
			leftFootY = Math.round(positionY * 10);
		} else if (humanPart.equals(HumanBodyEnum.Foot_Right)) {
			rightFootY = Math.round(positionY * 10);
		}
	}


	private boolean isHelloJonas() {
		if (this.wasLefHandUp && this.leftHandYPosition < this.headYPosition) {
			this.wasLefHandUp = false;
			//this.timeLeftHandAboveHead=0;
			this.headYPositionBefore = 0;
			this.leftHandYPositionBefore=0;
			this.actualRecognizedGesture = Gesture.HAND_OVER_HEAD;
			return true;
		}  else if (this.leftHandYPosition >= this.headYPosition && this.headYPositionBefore == 0 && this.leftHandYPositionBefore == 0) {
			this.leftHandYPositionBefore = this.leftHandYPosition;
			this.headYPositionBefore = this.headYPosition;
			this.wasLefHandUp = true;
		}
		return false;
	}
	
	private boolean isNice() {
		boolean ret = false;
		return ret;
	}
	
	private boolean isJump() {
		if ((leftFootY > leftFootYBefore) && (rightFootY > rightFootYBefore)) {
			return true;
		}
		return false;
	}
	
	private boolean isCrouch() {
		boolean ret = false;
		return ret;
	}
	
	public void checkForGesture() {
		frameCount++;
		if (frameCount > KINECT_FPS) {
			/* Check the gesture every ONE SECOND */
			frameCount = 0;
			if (isHelloJonas()) {
				System.out.println("Hello Jonas!");
			} else if (isNice()) {
				
			} else if (isJump()) {
				System.out.println("Jump!");
				
			} else if (isCrouch()) {
				
			}
			
			leftFootYBefore = leftFootY;
			rightFootYBefore = rightFootY;
		}	
	}
	
	/*
	private void showText(final String text){
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				Shell shell = new Shell (Display.getDefault());
				Label label = new Label(shell, SWT.BORDER);
				Menu menu = new Menu (shell, SWT.POP_UP);
				label.setText(text);
				label.setBounds(0, 0, 300, 25);
				menu.setVisible(true);
				shell.setMenu (menu);
				shell.setSize (300, 70);
				shell.open ();
			}
		});
	}
	*/
	
	public Gesture getActualRecognizedGesture() {
		return this.actualRecognizedGesture;
	}
	
	
}
