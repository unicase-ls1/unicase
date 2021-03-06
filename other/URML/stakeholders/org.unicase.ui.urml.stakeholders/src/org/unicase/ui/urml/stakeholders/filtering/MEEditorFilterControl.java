/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.filtering;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.urml.stakeholders.config.UrmlSettingsManager;

/**
 * Controller, which is used to hide set of model element
 * properties when the model element is opened  in the MEEditor.
 * @author kterzieva
 *
 */
public class MEEditorFilterControl extends AbstractMEControl {

	private Composite composite;

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {

		if (!(modelElement instanceof UrmlModelElement)) {
			return DO_NOT_RENDER;
		}
		StakeholderRole activeRole = UrmlSettingsManager.INSTANCE.getActiveRole();
		if (activeRole == null) {
			return DO_NOT_RENDER;
		}
		EMap<EClass, EList<EStructuralFeature>> filterSet = activeRole.getFilterSet();
		EList<EStructuralFeature> referenceList = filterSet.get(modelElement.eClass());

		if (referenceList == null) {
			return DO_NOT_RENDER;
		}
		EStructuralFeature featureToShow = (EStructuralFeature) itemPropertyDescriptor.getFeature(modelElement);

		if (!referenceList.contains(featureToShow)) {
			return DO_NOT_RENDER;
		}
		return  100;
	}

	@Override
	protected Control createControl(Composite parent, int style) {
		composite = new Composite(parent, SWT.NONE);
		return composite;
	}

	@Override
	public void applyCustomLayoutData() {
	}

	@Override
	public boolean doShow() {
		return false;
	}

}
