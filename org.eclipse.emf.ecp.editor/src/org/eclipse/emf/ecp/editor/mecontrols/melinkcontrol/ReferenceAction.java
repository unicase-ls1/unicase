/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.PlatformUI;

public abstract class ReferenceAction extends Action {

	protected EReference eReference;
	protected EObject modelElement;

	protected boolean checkMultiplicity(boolean silent) {
		if (eReference.getUpperBound() == 1 || eReference.getUpperBound() == -1) {
			return true;
		}
		Object object = modelElement.eGet(eReference);
		if (object instanceof EList<?>) {
			@SuppressWarnings("unchecked")
			EList<EObject> eList = (EList<EObject>) object;
			if (eList.size() < eReference.getUpperBound()) {
				return true;
			} else {
				MessageBox box = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
				box.setMessage("Reference " + eReference.getName() + " has a multiplicity of "
					+ eReference.getUpperBound() + ". Please remove referenced elements before you add new.");
				box.open();
				return false;
			}

		}
		return false;

	}

}
