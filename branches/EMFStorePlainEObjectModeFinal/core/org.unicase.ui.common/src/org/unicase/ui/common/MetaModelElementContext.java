/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * MetaModelContext used by the editor to determine which modelelements belong to the model.
 * 
 * @author helming
 */
public abstract class MetaModelElementContext {

	/**
	 * Retrieve all EClasses from the Ecore package registry that are subclasses of the given EClass. Does not include
	 * abstract classes or interfaces.
	 * 
	 * @param eClass the superClass of the subClasses to retrieve
	 * @return a set of EClasses
	 */
	public Set<EClass> getAllSubEClasses(EClass eClass) {
		Set<EClass> allEClasses = getAllModelElementEClasses();
		Set<EClass> result = new HashSet<EClass>();
		for (EClass subClass : allEClasses) {
			if (eClass.isSuperTypeOf(subClass) && (!subClass.isAbstract()) && (!subClass.isInterface())) {
				result.add(subClass);
			}
		}
		return result;
	}

	/**
	 * Returns all types of model elements in this context.
	 * 
	 * @return a set of eclasses
	 */
	public abstract Set<EClass> getAllModelElementEClasses();

	/**
	 * @param newMEInstance {@link EObject} the new modelElement instance.
	 * @return EReference the Container
	 * @param parent The EObject to get conatinment references from
	 */
	public EReference getPossibleContainingReference(final EObject newMEInstance, EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass().getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			if (containmentitem.getEReferenceType().equals(newMEInstance)) {
				reference = containmentitem;

				break;
			} else if (containmentitem.getEReferenceType().isSuperTypeOf(newMEInstance.eClass())) {

				reference = containmentitem;
				break;
			}
		}
		return reference;
	}

}
