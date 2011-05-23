/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui;

import org.eclipse.jface.window.Window;
import org.unicase.changetracking.common.IDecisionProvider;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.ui.AdvancedMessageDialog.NoRemoteRepoChoices;
import org.unicase.changetracking.ui.dialogs.ModelElementPlacementDialog;
import org.unicase.model.UnicaseModelElement;

/**
 * Implementation of the decision provider interface which shows a dialog to the
 * user for each decision and thus lets the user decide.
 * 
 * @author jfinis
 * 
 */
public class UIDecisionProvider implements IDecisionProvider {

	/**
	 * {@inheritDoc}
	 */
	public PlacementAndNameDecision decideModelElementPlacementAndName(UnicaseModelElement elementToPlace, String defaultName) throws CancelledByUserException {
		final ModelElementPlacementDialog placementDialog = new ModelElementPlacementDialog(UIUtil.getActiveShell(), elementToPlace, true);
		placementDialog.setDefaultName(defaultName);
		if (placementDialog.open() != Window.OK) {
			throw new CancelledByUserException();
		}
		return new PlacementAndNameDecision(elementToPlace, placementDialog.getSelectedName(), placementDialog.getSelection());
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean decideCreateRepoLocation() throws CancelledByUserException {
		NoRemoteRepoChoices choice = AdvancedMessageDialog.openNoRemoteRepoFoundDialog(UIUtil.getActiveShell());
		switch (choice) {
		case CANCEL:
			throw new CancelledByUserException();
		case CREATE:
			return true;
		case DO_NOT_CREATE:
		default:
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean decideUpdateFromRemote() {
		return UIUtil.askForRefreshing();
	}

}
