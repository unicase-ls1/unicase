package org.unicase.navigator;

import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;

public class TreeActionProvider extends CommonActionProvider {
	private DoubleClickAction doubleClickAction;

	@Override
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		doubleClickAction = new DoubleClickAction();
		aSite.getStructuredViewer().addSelectionChangedListener(
				doubleClickAction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
	 */
	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		// forward doubleClick to doubleClickAction
		actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN,
				doubleClickAction);
	}
}