/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.update.steps;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Version;
import org.unicase.emfstore.update.UpdateStepTransformClass;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.RationaleFactory;

/**
 * @author schroech
 *
 */
public class UpdateStepRemoveAnnotationInstances extends UpdateStepTransformClass{

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
	 * @see org.unicase.emfstore.update.UpdateStepTransformClass#getTransformableEClass()
	 */
	@Override
	public EClass getTransformableEClass() {
		return ModelPackage.eINSTANCE.getAnnotation();
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepTransformClass#updateModelElement(org.unicase.model.ModelElement)
	 */
	@Override
	public int updateModelElement(ModelElement modelElement) {
		if (modelElement instanceof Annotation) {
			Annotation annotation = (Annotation)modelElement;
			
			Comment newComment = RationaleFactory.eINSTANCE.createComment();
			
			EList<EStructuralFeature> structuralFeatures = annotation.eClass().getEStructuralFeatures();
			for (EStructuralFeature structuralFeature : structuralFeatures) {
				int featureID = structuralFeature.getFeatureID();
				if (featureID != ModelPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER) {
					newComment.eSet(structuralFeature, annotation.eGet(structuralFeature));
				}
			}
			
			EcoreUtil.remove(annotation);
			
			return 1;
		}
		return 0;
	}
}
