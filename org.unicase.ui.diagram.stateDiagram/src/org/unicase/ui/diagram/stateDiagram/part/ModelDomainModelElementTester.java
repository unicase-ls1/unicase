/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.stateDiagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.model.ModelPackage;

/**
 * @generated
 */
public class ModelDomainModelElementTester extends PropertyTester {

	/**
	 * @generated
	 */
	public boolean test(Object receiver, String method, Object[] args, Object expectedValue) {
		if (false == receiver instanceof EObject) {
			return false;
		}
		EObject eObject = (EObject) receiver;
		EClass eClass = eObject.eClass();
		if (eClass == MetamodelPackage.eINSTANCE.getModelElement()) {
			return true;
		}
		if (eClass == MetamodelPackage.eINSTANCE.getProject()) {
			return true;
		}
		if (eClass == MetamodelPackage.eINSTANCE.getUniqueIdentifier()) {
			return true;
		}
		if (eClass == ModelPackage.eINSTANCE.getAnnotation()) {
			return true;
		}
		if (eClass == ModelPackage.eINSTANCE.getAttachment()) {
			return true;
		}
		if (eClass == MetamodelPackage.eINSTANCE.getIdentifiableElement()) {
			return true;
		}
		if (eClass == MetamodelPackage.eINSTANCE.getModelElementId()) {
			return true;
		}
		if (eClass == MetamodelPackage.eINSTANCE.getNonDomainElement()) {
			return true;
		}
		if (eClass == MetamodelPackage.eINSTANCE.getModelVersion()) {
			return true;
		}
		return false;
	}

}
