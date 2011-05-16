/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.common.IDecisionProvider;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.ui.AdvancedMessageDialog.NoRemoteRepoChoices;
import org.unicase.changetracking.ui.dialogs.ModelElementPlacementDialog;
import org.unicase.model.UnicaseModelElement;

public class UIDecisionProvider implements IDecisionProvider {
	
	private Shell getShell(){
		return PlatformUI.getWorkbench().
		getActiveWorkbenchWindow().getShell();
	}

	@Override
	public PlacementAndNameDecision decideModelElementPlacementAndName (
			UnicaseModelElement elementToPlace, String defaultName) throws CancelledByUserException{;
		final ModelElementPlacementDialog placementDialog = new ModelElementPlacementDialog(getShell(), elementToPlace, true);
		placementDialog.setDefaultName(defaultName);
		if(placementDialog.open() != Window.OK){
			throw new CancelledByUserException();
		}
		return new PlacementAndNameDecision(elementToPlace, placementDialog.getSelectedName(), placementDialog.getSelection());
	}

	
	@Override
	public boolean decideCreateRepoLocation()
			throws CancelledByUserException {
		NoRemoteRepoChoices choice = AdvancedMessageDialog.openNoRemoteRepoFoundDialog(getShell());
		switch(choice){
		case CANCEL:
			throw new CancelledByUserException();
		case CREATE:
			return true;
		case DO_NOT_CREATE:
		default:
			return false;
		}
	}

	@Override
	public boolean decideUpdateFromRemote() {
		return UIUtil.askForRefreshing();
	}

}
