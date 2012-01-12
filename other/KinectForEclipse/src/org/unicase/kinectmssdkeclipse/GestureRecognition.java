package org.unicase.kinectmssdkeclipse;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

import humandiagramgef.HumanBodyEnum;

public class GestureRecognition {
	private boolean wasLefHandUp=false;
	private float leftHandYPosition;
	private float headYPosition;
	private long timeLeftHandAboveHead;
	private float leftHandYPositionBefore;
	private float headYPositionBefore;
	private Gesture actualRecognizedGesture=null;
	
	
	public void saveYPositions(HumanBodyEnum humanPart, float positionY) {
		if (humanPart.equals(HumanBodyEnum.Hand_Left)) {
				this.leftHandYPosition = positionY;
			} else if (humanPart.equals(HumanBodyEnum.Head)) {
				this.headYPosition = positionY;
			}
	}


	public void checkForGesture() {
		if (this.wasLefHandUp && this.leftHandYPosition < this.headYPosition) {
			this.showText("Hello JONAS!!!!!!!!!!!!!!!!!!!!!!!");
			this.wasLefHandUp = false;
			this.timeLeftHandAboveHead=0;
			this.headYPositionBefore = 0;
			this.leftHandYPositionBefore=0;
			this.actualRecognizedGesture = Gesture.HAND_OVER_HEAD;
			
		} else if (this.leftHandYPosition >= this.headYPosition && this.headYPositionBefore == 0 && this.leftHandYPositionBefore == 0) {
			this.leftHandYPositionBefore = this.leftHandYPosition;
			this.headYPositionBefore = this.headYPosition;
			this.wasLefHandUp = true;
		}
		
	}
	
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
	
	public Gesture getActualRecognizedGesture() {
		return this.actualRecognizedGesture;
	}
	
	
}
