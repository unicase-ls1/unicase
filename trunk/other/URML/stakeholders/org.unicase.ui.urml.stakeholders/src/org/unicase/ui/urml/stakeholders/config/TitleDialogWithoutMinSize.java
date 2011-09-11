/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.config;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;

/**
 * Class for adjusting the size of the used dialogs.
 * @author kterzieva
 *
 */
public class TitleDialogWithoutMinSize extends TitleAreaDialog {

	/**
	 * The construct.
	 * @param parentShell the shell
	 */
	public TitleDialogWithoutMinSize(Shell parentShell) {
		super(parentShell);
	}
	

	private boolean sizeHack;
	
	/**
	 * 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
	 */
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
	 * .
	 * @return .
	 */
	public int getMinWidth(){
		return 0;
	}
	
	/**
	 * .
	 * @return .
	 */
	public int getMinHeight(){
		return 0;
	}
}