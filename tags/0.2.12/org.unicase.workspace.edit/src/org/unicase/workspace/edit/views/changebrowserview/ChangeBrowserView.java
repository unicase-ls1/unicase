/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.views.changebrowserview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.workspace.edit.views.AbstractSCMView;

/**.
 * This is the Change Browser view. It inherits AbstractSCMView and hence has
 * a query tab, where the user can set criteria for view's content. It also 
 * has a browser tab (a ChangesComposite) which shows a ChangePackage based 
 * Query criteria. 
 * There is currently no implementation for how the contents should be set. 
 * This view my also be invoked from History browser view with some 
 * ChangePackage as input.
 * 
 * @author Hodaie
 *
 */
public class ChangeBrowserView extends AbstractSCMView {

	//the input change package
	private ChangePackage changePackage;
	private ChangesComposite changesComposite;
	

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		getBrowserTab().setText("Changes");

	}
	
	
	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		

	}

	
	/** 
	 * {@inheritDoc}
	 * @see org.unicase.workspace.edit.views.AbstractSCMView#refreshClicked()
	 */
	@Override
	protected void refreshClicked() {
		//TODO: final implementation
		getLblCriteria().setText(getQueryComposite().getQuery().getDescription());
		
	}

	/**.
	 * this will be called to set contents of browser tab.
	 * 
	 */
	/** 
	 * {@inheritDoc}
	 * @see org.unicase.workspace.edit.views.AbstractSCMView#setBrowserTabControl()
	 */
	@Override
	protected Control setBrowserTabControl() {
		
		 
		changesComposite = new ChangesComposite(getTabFolder(), SWT.NONE);
		changesComposite.setInput(this.changePackage);
		return changesComposite;
	}
	
	/**.
	 * This will be called from HistoryBrowserView to set contents of 
	 * ChangeBrowser view when invoking it.
	 * @param input the change package to display
	 */
	public void setInput(ChangePackage input){
		this.changePackage = input;
		changesComposite.setInput(input);
	}
}
