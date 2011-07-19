/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol.associationclasscontrol;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.action.Action;
import org.unicase.ui.common.ECPAssociationClassElement;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.AddReferenceAction;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MESingleLinkControl;

/**
 * This widget removes the new reference action for source and target from every association class. We have to do this
 * because of the source containment of the association.
 * 
 * @author Michael Haeger
 */
public class AssociationClassControlNoNew extends MESingleLinkControl {
	private static final int PRIORITY = 2;

	/**
	 * Default constructor.
	 */
	public AssociationClassControlNoNew() {
		super();
	}

	/**
	 * Only create an AddReferenceAction. We can not support NewReferenceActions because of the containment.
	 * 
	 * @return Returns the actions.
	 */
	@Override
	protected List<Action> initActions() {
		List<Action> result = new ArrayList<Action>();
		AddReferenceAction addAction = new AddReferenceAction(getModelElement(), geteReference(),
			getItemPropertyDescriptor(), getContext());
		result.add(addAction);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.melinkcontrol.MESingleLinkControl#canRender(org.eclipse.emf.edit.provider.IItemPropertyDescriptor,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EReference && !((EReference) feature).isMany()) {
			if (getContext() != null && getContext().isAssociationClassElement(modelElement)) {
				ECPAssociationClassElement association = getContext().getAssociationClassElement(modelElement);
				// display if given reference is equal to source or target feature
				if (association.getSourceFeature().equals(feature) || association.getTargetFeature().equals(feature)) {
					return PRIORITY;
				}
			}
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}
}
