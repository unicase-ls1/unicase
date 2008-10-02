/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.update.steps;

import org.eclipse.emf.ecore.EClass;
import org.osgi.framework.Version;
import org.unicase.emfstore.update.UpdateStepRemoveEnumLiteral;
import org.unicase.model.classes.ClassesPackage;

/**
 * @author schroech
 *
 */
public class UpdateStepRemoveAssociationTypeDependency extends UpdateStepRemoveEnumLiteral {

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepTransformFeature#getFeatureName()
	 */
	@Override
	public String getFeatureName() {
		return "type";
	}

	/**
	* {@inheritDoc}
	* @see org.unicase.emfstore.update.UpdateStepTransformClass#getTransformableEClass()
	*/
	@Override
	public EClass getTransformableEClass() {
		return ClassesPackage.eINSTANCE.getAssociation();
	}

	/**
	* {@inheritDoc}
	* @see org.unicase.emfstore.update.UpdateStep#getSourceVersion()
	*/
	public Version getSourceVersion() {
		return new Version("0.0.5");
	}

	/**
	* {@inheritDoc}
	* @see org.unicase.emfstore.update.UpdateStep#getTargetVersion()
	*/
	public Version getTargetVersion() {
		return new Version("0.0.6");
	}

	/**
	* {@inheritDoc}
	* @see org.unicase.emfstore.update.UpdateStep#getTitle()
	*/
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	* {@inheritDoc}
	* @see org.unicase.emfstore.update.UpdateStepRemoveEnumLiteral#getLiteralName()
	*/
	@Override
	public String getLiteralName() {
		return "DEPENDENCY";
	}

}
