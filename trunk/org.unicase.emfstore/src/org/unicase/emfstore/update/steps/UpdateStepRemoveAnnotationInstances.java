/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.update.steps;

import org.eclipse.emf.ecore.EClass;
import org.osgi.framework.Version;
import org.unicase.emfstore.update.UpdateStepRemoveClass;
import org.unicase.model.ModelPackage;

/**
 * @author schroech
 *
 */
public class UpdateStepRemoveAnnotationInstances extends UpdateStepRemoveClass{

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getSourceVersion()
	 */
	public Version getSourceVersion() {
		return new Version("0.0.2.beta");
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getTargetVersion()
	 */
	public Version getTargetVersion() {
		return new Version("0.0.3.beta");
	}

	
	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getTitle()
	 */
	public String getTitle() {
		return "Remove Annotation Instances";
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepRemoveClass#getRemovableEClass()
	 */
	@Override
	public EClass getRemovableEClass() {
		return ModelPackage.eINSTANCE.getAnnotation();
	}
}
