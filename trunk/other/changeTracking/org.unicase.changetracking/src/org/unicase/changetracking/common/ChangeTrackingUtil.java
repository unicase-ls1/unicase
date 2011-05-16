/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.common;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Main utility class of the changetracking plug-in.
 * 
 * @author gex
 *
 */
public final class ChangeTrackingUtil {
	
	private ChangeTrackingUtil(){}
	
	/**
	 * Adds a model element to a project, relative to another model element:
	 * The model element tree is walked upwards from the model element until
	 * a place where the new model element can be inserted is found.
	 * 
	 * @param toAdd model element to add
	 * @param relativeTo target model element
	 * @param wrapInUnicaseCommand if true, the operation will be wrapped in a
	 * unicase command.
	 */
	public static void addToProjectRelative(final EObject toAdd, final EObject relativeTo, boolean wrapInUnicaseCommand) {
		if(wrapInUnicaseCommand){
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					addToProjectRelative(toAdd, relativeTo, false);
				}
			};
		} else {
			if(!placeRelative(toAdd,relativeTo)){
				Project p = ModelUtil.getProject(relativeTo);
				if(p != null){
					p.addModelElement(toAdd);
				}
			}
		}
	
		
	}
	
	/**
	 * @param newMEInstance {@link EObject} the new modelElement instance.
	 * @return EReference the Container
	 * @param parent The EObject to get containment references from
	 */
	public static EReference getPossibleContainingReference(final EObject newMEInstance, EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass().getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			EClass eReferenceType = containmentitem.getEReferenceType();
			if (eReferenceType.isInstance(newMEInstance)) {
				reference = containmentitem;
				break;
			}
		}
		return reference;
	}
	
	/**
	 * Places a model element in a project, relative to another one.
	 * @param newMEInstance model element to be placed
	 * @param parent target model eleent.
	 * @return whether the model element could be placed in the project.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean placeRelative(final EObject newMEInstance, EObject parent){
		EReference ref = getPossibleContainingReference(newMEInstance, parent);
		if(ref != null){
			Object r = parent.eGet(ref);
			if(ref.isMany()){
				((EList)r).add(newMEInstance);
				return true;
			}
			return false;
		} else if(parent.eContainer() != null){
			return placeRelative(newMEInstance,parent.eContainer());
		} else {
			return false;
		}
		
	}

	/**
	 * Places a model element "in" another one.
	 * I.e. it is checked if the target model element has a containment reference
	 * which can contain the new model element.
	 * @param newMEInstance model element to be placed
	 * @param parent target for the model element
	 * @return whether the model element could be placed in the model element
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean putInto(final EObject newMEInstance, EObject parent){
		EReference ref = getPossibleContainingReference(newMEInstance, parent);
		if(ref != null){
			Object r = parent.eGet(ref);
			if(ref.isMany()){
				((EList)r).add(newMEInstance);
				return true;
			}
			return false;
		} else {
			return false;
		}
		
	}
}
