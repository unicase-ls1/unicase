/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.util.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.AddReferenceAction;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MESingleLinkControl;

/**
 * @author pfeifferc
 */
public class MESingeLinkControlWithoutNewReferenceAction extends
		MESingleLinkControl {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<Action> initActions() {
		List<Action> result = new ArrayList<Action>();
		AddReferenceAction addAction = new AddReferenceAction(getModelElement(), super.geteReference(),
			getItemPropertyDescriptor(), getContext());
		result.add(addAction);
		return result;
	}
	
	
}
