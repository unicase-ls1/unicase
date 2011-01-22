package org.unicase.ui.urml.stakeholderview;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;

public class TitleDialogWithoutMinSize extends TitleAreaDialog {

	public TitleDialogWithoutMinSize(Shell parentShell) {
		super(parentShell);
	}
	

	private boolean sizeHack;
	
	protected Point getInitialSize() {
		sizeHack = true;
		Point point = super.getInitialSize();
		sizeHack = false;
		return point;
	}
	
	@Override
	protected int convertHorizontalDLUsToPixels(int dlus) {
		if(sizeHack){
			return getMinWidth();
		}
		return super.convertHorizontalDLUsToPixels(dlus);
	}
	
	@Override
	protected int convertVerticalDLUsToPixels(int dlus) {
		if(sizeHack){
			return getMinHeight();
		}
		return super.convertVerticalDLUsToPixels(dlus);
	}
	
	/**
	 * 
	 * @return 
	 */
	public int getMinWidth(){
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getMinHeight(){
		return 0;
	}
}