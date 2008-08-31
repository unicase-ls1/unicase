/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.historybrowserview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.ui.stem.views.AbstractSCMView;

/**.
 * This the History Browser view. It inherits AbstractSCMView and hence has
 * a query tab, where the user can set criteria for view's content. It also 
 * has a browser tab (a HistoryComposite). 
 * @author Hodaie
 *
 */
public class HistoryBrowserView extends AbstractSCMView {

	//temporarily used to show dialogs.
	private Composite parent;
	
	/**.
	 * Constructor
	 */
	public HistoryBrowserView() {
		
	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		browserTab.setText("History");
		this.parent = parent;
	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
	
		
	}

	/**.
	 * TODO final implementation
	 */
	@Override
	protected void refreshClicked() {
//		lblCriteria.setText(queryComposite.getQuery().getDescription());

//************************************************
//		//these were just used to show different dialogs.
//		//because i did not know how should the dialogs be shown.
//		CommitDialog commitDialog = new CommitDialog(parent.getShell());
//		commitDialog.create();
//		commitDialog.open();
		
//		UpdateDialog updateDialog = new UpdateDialog(parent.getShell());
//		updateDialog.create();
//		updateDialog.open();
		
//		MergeDialog mergeDialog = new MergeDialog(parent.getShell());
//		mergeDialog.create();
//		mergeDialog.open();
//************************************************		
	}


	/**.
	 * this will be called to set contents of browser tab.
	 * 
	 */
	@Override
	protected Control setBrowserTabControl() {
		return new HistoryComposite(tabFolder, SWT.NONE);
	}

}
