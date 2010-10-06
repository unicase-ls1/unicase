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
import org.eclipse.emf.ecore.EcorePackage;
import org.unicase.metamodel.AssociationClassElement;

/**
 * MetaModelContext used by the editor to determine which model elements belong to the model.
 * 
 * @author helming
 */
public abstract class MetaModelElementContext {

	/**
	 * Retrieve all EClasses from the ECore package registry that are subclasses of the given EClass. Does not include
	 * abstract classes or interfaces.
	 * 
	 * @param eClass the superClass of the subClasses to retrieve
	 * @return a set of EClasses
	 */
	public Set<EClass> getAllSubEClasses(EClass eClass) {
		return getAllSubEClasses(eClass, true);
	}

	/**
	 * Retrieve all EClasses from the Ecore package registry that are subclasses of the given EClass. Does not include
	 * abstract classes or interfaces. Could exclude {@link AssociationClassElement}'s.
	 * 
	 * @param eClass the superClass of the subClasses to retrieve
	 * @param association whether to include {@link AssociationClassElement}
	 * @return a set of EClasses
	 */
	public Set<EClass> getAllSubEClasses(EClass eClass, boolean association) {
		Set<EClass> allEClasses = getAllModelElementEClasses();
		Set<EClass> result = new HashSet<EClass>();
		for (EClass subClass : allEClasses) {

			if (association || !isAssociationClassElement(subClass)) {
				if ((eClass.equals(EcorePackage.eINSTANCE.getEObject()) || eClass.isSuperTypeOf(subClass))
					&& (!subClass.isAbstract()) && (!subClass.isInterface())) {
					result.add(subClass);
				}
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
	 * Whether a {@link EClass} is a association class. Association classes are not displayed as dedicated elements. A
	 * link from one element to another which goes over an association class is displayed by a dedicated widget. This
	 * widgets allows to trace transparently without seeing the association class.
	 * 
	 * @param eClazz the {@link EClass}
	 * @return if it is an association
	 */
	public abstract boolean isAssociationClassElement(EClass eClazz);

	/**
	 * @param newMEInstance {@link EObject} the new modelElement instance.
	 * @return EReference the Container
	 * @param parent The EObject to get containment references from
	 */
	public EReference getPossibleContainingReference(final EObject newMEInstance, EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass().getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			EClass eReferenceType = containmentitem.getEReferenceType();
			if (eReferenceType.equals(newMEInstance)) {
				reference = containmentitem;

				break;
			} else if (eReferenceType.equals(EcorePackage.eINSTANCE.getEObject())
				|| eReferenceType.isSuperTypeOf(newMEInstance.eClass())) {
				reference = containmentitem;
				break;
			}
		}
		return reference;
	}

}
