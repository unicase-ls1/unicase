/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.common.diagram.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author schroech
 *
 */
public final class EditPartUtility {

	private EditPartUtility() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * Finds EditParts corresponding to a Set of objects.
	 * Other than GrapicalEditPart, also goes through connection EditParts.
	 * 
	 * @param host The EditPart at which the search starts
	 * @param objects The objects being searched
	 * @return
	 * The found EditParts correspoding to the objects
	 */
	@SuppressWarnings("unchecked")
	public static Set<EditPart> findEditParts(GraphicalEditPart host, Set<EObject> objects) {
		Set<EditPart> editParts = new HashSet<EditPart>();
		
		List children = host.getChildren();
		for (Object editPart : children) {
			if (editPart instanceof GraphicalEditPart) {
				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) editPart;
				
				EObject element = EditPartUtility.getElement(graphicalEditPart);
				if (objects.contains(element)) {
					editParts.add(graphicalEditPart);					
				}
				
				editParts.addAll(findEditParts(graphicalEditPart, objects));
				
				if (graphicalEditPart instanceof NodeEditPart) {
					editParts.addAll(EditPartUtility.findConnectionEditParts((NodeEditPart) graphicalEditPart, objects));	
				}
	
			}
			
		}
		
		return editParts;
	}
	/**
	 * Finds the ConnectionEditParts of an EditPart corresponding to objects.
	 * 
	 * @param editPart The {@link NodeEditPart} whose connections will be searched 
	 * @param objects The objects being searched
	 * @return
	 * The found {@link ConnectionEditPart}s
	 */
	@SuppressWarnings("unchecked")
	public static Set<ConnectionEditPart> findConnectionEditParts(NodeEditPart editPart, Set<EObject> objects){
		Set<ConnectionEditPart> connectionEditParts = new HashSet<ConnectionEditPart>();
	
		Set connections = new HashSet();
		connections.addAll((editPart).getSourceConnections());
		connections.addAll((editPart).getTargetConnections());
	
		for (Object connection : connections) {
			if (!(connection instanceof ConnectionEditPart)) {
				continue;
			}
	
			EObject element = EditPartUtility.getElement((ConnectionEditPart) connection);
			if (objects.contains(element)) {
				connectionEditParts.add((ConnectionEditPart) connection);
			}
		}
	
		return connectionEditParts; 
	}
	/**
	 * @param editPart The {@link EditPart}
	 * @return The {@link EditPart}s notation View or the {@link EditPart}s model in case it is a view
	 */
	public static View getView(EditPart editPart) {
		if (editPart instanceof GraphicalEditPart) {
			View notationView = ((GraphicalEditPart) editPart).getNotationView();
			return notationView;
		}
	
		Object model = editPart.getModel();
		if (model instanceof View) {
			return (View) model;
		}
		return null;
	}
	/**
	 * @param editPart The {@link EditPart}
	 * @return The element of the {@link EditPart}s model
	 */
	public static EObject getElement(EditPart editPart) {
		Object model = (editPart).getModel();
		if (model instanceof View) {
			EObject element = ((View) model).getElement();
			return element;
		}
		return null;
	}
	
	/**
	 * Returns the elements of each {@link EditPart}'s model which are instances of type <T>.
	 * 
	 * @param <T> The type of interest
	 * @param editParts The {@link EditPart}s which should be searched
	 * @param classType The type of interest
	 * @return A Collection of elements of Type classType
	 */
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> getElements(Collection<? extends EditPart> editParts, java.lang.Class<T> classType) {
		Set<T> elements = new HashSet<T>();
		for (EditPart editPart : editParts) {
			EObject element = EditPartUtility.getElement(editPart);
			if (classType.isInstance(element)) {
				elements.add((T) element);
			}
		}
		return elements;
	}

}
