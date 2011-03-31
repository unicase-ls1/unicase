/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.ecp.model.workSpaceModel.util;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.ecp.model.ECPAssociationClassElement;
import org.unicase.ecp.model.ECPMetaModelElementContext;
import org.unicase.ecp.model.ECPModelelementContext;

/**
 * This class contains some utility methods for adding or deleting elements related to {@link AssociationClassElement}.
 * 
 * @author Michael Haeger
 */
public final class AssociationClassHelper {
	
	/**
	 * Private constructor.
	 */
	private AssociationClassHelper() {
	}

	/**
	 * This method computes the additional {@link AssociationClassElement}'s for a dropped element.
	 * 
	 * @param objectsToDrop The dropped element.
	 * @param elements The elements of the diagram the element was dropped on.
	 * @param context The context.
	 * @return The the {@link AssociationClassElement}'s which should be added.
	 */
	public static List<EObject> getRelatedAssociationClassToDrop(List<EObject> objectsToDrop, List<EObject> elements,
		ECPMetaModelElementContext context) {
		List<EObject> result = new LinkedList<EObject>();
		for (EObject objectToDrop : objectsToDrop) {
			// get all features and try to find a AssociationClassElement
			EList<EStructuralFeature> features = objectToDrop.eClass().getEAllStructuralFeatures();
			for (EStructuralFeature feature : features) {
				if (feature instanceof EReference
					&& context.isAssociationClassElement(
						((EReference) feature).getEReferenceType())) {
					// get the value of the feature
					Object evaluatedFeatures = objectToDrop.eGet(feature);
					// feature value is a list
					if (evaluatedFeatures instanceof List<?>) {
						for (Object evaluatedFeature : (List<?>) evaluatedFeatures) {
							handleAssociationClass(objectToDrop, objectsToDrop, (EObject) evaluatedFeature, elements,
								result, context);
						}
					} // feature value is a single AssociationClassElement
					else if (context.isAssociationClassElement((EObject) evaluatedFeatures)) {
						handleAssociationClass(objectToDrop, objectsToDrop, (EObject) evaluatedFeatures, elements,
							result, context);
					}
				}
			}
		}
		return result;
	}

	private static void handleAssociationClass(EObject objectToDrop, List<EObject> objectsToDrop, EObject association,
		List<EObject> elements, List<EObject> result, ECPMetaModelElementContext context) {
		
		ECPAssociationClassElement ecpAssociation = 
			context.getAssociationClassElement(association);
		
		if (!result.contains(association) && !elements.contains(association)) {
			// if source and target are on the diagram add also the AssociationClassElement
			Object source = association.eGet(ecpAssociation.getSourceFeature());
			Object target = association.eGet(ecpAssociation.getTargetFeature());
			
			if (source.equals(objectToDrop)) {
				if (elements.contains(target) || objectsToDrop.contains(target)) {
					result.add(association);
				}
			} else if (target.equals(objectToDrop)) {
				if (elements.contains(source) || objectsToDrop.contains(source)) {
					result.add(association);
				}
			}
		}
	}

	/**
	 * This method computes the additional {@link AssociationClassElement}'s for a deleted element.
	 * 
	 * @param objectToDelete The deleted element.
	 * @param context The context.
	 * @return The the {@link AssociationClassElement}'s which should be also deleted.
	 */
	public static List<EObject> getRelatedAssociationClassToDelete(EObject objectToDelete,
		ECPMetaModelElementContext context) {
		List<EObject> result = new LinkedList<EObject>();
		// get all features and try to find a AssociationClassElement
		EList<EStructuralFeature> features = objectToDelete.eClass().getEAllStructuralFeatures();
		for (EStructuralFeature feature : features) {
			if (feature instanceof EReference
				&& context.isAssociationClassElement(
					((EReference) feature).getEReferenceType())) {
				// get the value of the feature
				Object evaluatedFeatures = objectToDelete.eGet(feature);
				if(evaluatedFeatures == null) {
					continue;
				}
				// feature value is a list
				if (evaluatedFeatures instanceof List<?>) {
					for (Object evaluatedFeature : (List<?>) evaluatedFeatures) {
						// TODO: Chainsaw - review this part
						if (context.isAssociationClassElement((EObject) evaluatedFeature)) {
							result.add((EObject) evaluatedFeature);
						}
					}
				} // feature value is a single AssociationClassElement
				// TODO: Chainsaw - review this part
				else if (context.isAssociationClassElement((EObject) evaluatedFeatures)) {
					result.add((EObject) evaluatedFeatures);
				}
			}
		}
		return result;
	}

	/**
	 * This method returns the other side of an association as a model element for a given element and association.
	 * 
	 * @param element One end of the association
	 * @param association The association
	 * @param context The context.
	 * @return The other side of the association or {@code null} if the element not belongs to the association
	 */
	public static EObject getRelatedModelElement(EObject element, EObject association, ECPModelelementContext context) {
		
		ECPAssociationClassElement ecpAssociation = 
			context.getMetaModelElementContext().getAssociationClassElement(association);
		
		Object source = association.eGet(ecpAssociation.getSourceFeature());
		Object target = association.eGet(ecpAssociation.getTargetFeature());
		
		if (element.equals(source)) {
			return (EObject) target;
		} else if (element.equals(target)) {
			return (EObject) source;
		}
		
		return null;
	}

	/**
	 * This method returns the other side of an association as an {@link EReference} for a given reference and
	 * association.
	 * 
	 * @param eReference One end of the association
	 * @param association The association
	 * @param context The context.
	 * @return The other side of the association or {@code null} if the reference not belongs to the association
	 */
	public static EReference getRelatedEReference(EReference eReference, EObject association,
		ECPMetaModelElementContext context) {
		ECPAssociationClassElement ecpAssociation = context.getAssociationClassElement(association);
		if (eReference.equals(ecpAssociation.getTargetFeature().getEOpposite())) {
			return ecpAssociation.getSourceFeature().getEOpposite();
		} else if (eReference.equals(ecpAssociation.getSourceFeature().getEOpposite())) {
			return ecpAssociation.getTargetFeature().getEOpposite();
		}
		return null;
	}

	/**
	 * This method returns all features of a given association.
	 * 
	 * @param association the association
	 * @param context the context.
	 * @return a list of features.
	 */
	public static List<EStructuralFeature> getAssociationFeatures(EObject association, 
			ECPMetaModelElementContext context) {
		
		ECPAssociationClassElement ecpAssociation = 
			context.getAssociationClassElement(association);
		
		return ecpAssociation.getAssociationFeatures();
	}

	/**
	 * This method creates an association model element and setup all references between the given model elements. The
	 * reference is contained in the source model element. The method automatically calculate source and target.
	 * 
	 * @param eReference The reference that belongs to {@code modelElement}
	 * @param modelElement One model element
	 * @param relatedModelElement Second model element
	 * @param context The context.
	 */
	public static void createAssociation(EReference eReference, EObject modelElement, EObject relatedModelElement,
		ECPMetaModelElementContext context) {
		
		EClass eClazz = eReference.getEReferenceType();
		EPackage ePackage = eClazz.getEPackage();
		final EObject association = ePackage.getEFactoryInstance().create(eClazz);
		
		ECPAssociationClassElement ecpAssociation = 
			context.getAssociationClassElement(association);
		
		if (ecpAssociation.getSourceFeature().getEOpposite().equals(eReference)) {
			association.eSet(ecpAssociation.getSourceFeature(), modelElement);
			association.eSet(ecpAssociation.getTargetFeature(), relatedModelElement);
		} else {
			association.eSet(ecpAssociation.getSourceFeature(), relatedModelElement);
			association.eSet(ecpAssociation.getTargetFeature(), modelElement);
		}
	}

	/**
	 * This methods computes the association features for an association. Use this for standard implementation.
	 * 
	 * @param eClazz the {@link EClass}
	 * @param source the source feature
	 * @param target the target feature
	 * @return all association features without source and target
	 */
	public static List<EStructuralFeature> getAssociationFeatures(EClass eClazz, EReference source, EReference target) {
		
		LinkedList<EStructuralFeature> result = new LinkedList<EStructuralFeature>();
		result.addAll(eClazz.getEStructuralFeatures());
		result.remove(source);
		result.remove(target);
		
		return result;
	}
}
