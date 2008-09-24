/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.update.steps;

import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.update.UpdateStepRenameFeature;
import org.unicase.model.rationale.RationalePackage;

/**
 * @author schroech
 *
 */
public class UpdateStepRenameFacilitator extends UpdateStepRenameFeature{ 
	
	

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getTitle()
	 */
	public String getTitle(){
		return "Assignable transformation";
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getSourceVersion()
	 */
	public org.osgi.framework.Version getSourceVersion() {
		return new org.osgi.framework.Version("0.0.1");
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getTargetVersion()
	 */
	public org.osgi.framework.Version getTargetVersion() {
		return new org.osgi.framework.Version("0.0.2");
	}

	
	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepRenameFeature#getSourceFeatureName()
	 */
	@Override
	public String getSourceFeatureName() {
		return "facilitator";
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepRenameFeature#getTargetFeatureName()
	 */
	@Override
	public String getTargetFeatureName() {
		return "assignee";
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepTransformClass#getTransformableEClass()
	 */
	@Override
	public EClass getTransformableEClass() {
		return RationalePackage.eINSTANCE.getIssue();
	}


}
