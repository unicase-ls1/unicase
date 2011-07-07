/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package scrm.diagram.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.parts.DataProcessSpaceDataProcessSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.DataProcessSpaceDataProcessSpaceCompartmentEditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceKnowledgeSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceKnowledgeSpaceCompartmentEditPart;
import scrm.diagram.edit.parts.RequirementSpaceRequirementSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.RequirementSpaceRequirementSpaceCompartmentEditPart;

/**
 * @author schroech, denglerm
 */
public final class EditPartUtility {

	private EditPartUtility() {
		// private constructor: static methods only
	}

	/**
	 * Finds EditParts corresponding to a Set of objects. Other than GrapicalEditPart, also goes through connection
	 * EditParts.
	 * 
	 * @param host The EditPart at which the search starts
	 * @param objects The objects being searched
	 * @return The found EditParts correspoding to the objects
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
					editParts
						.addAll(EditPartUtility.findConnectionEditParts((NodeEditPart) graphicalEditPart, objects));
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
	 * @return The found {@link ConnectionEditPart}s
	 */
	@SuppressWarnings("unchecked")
	public static Set<ConnectionEditPart> findConnectionEditParts(NodeEditPart editPart, Set<EObject> objects) {
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
	 * Finds the DiagramEditPart (normally MEDiagramEditpart) with the help of a diagram element.
	 * 
	 * @param editPart The {@link EditPart}
	 * @return The element of the {@link EditPart}s model
	 */
	public static DiagramEditPart getDiagramEditPart(EditPart editPart) {
		DiagramEditPart rootEditPart = null;
		View view = getView(editPart);
		if (view instanceof Node) {
			rootEditPart = (DiagramEditPart) editPart.getRoot().getContents();
		} else if (view instanceof Edge) {
			rootEditPart = (DiagramEditPart) ((DiagramRootEditPart) editPart.getRoot()).getContents();
		}
		return rootEditPart;
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

	/**
	 * @param touchedEditPart The editPart being examined
	 * @return The next {@link ShapeNodeEditPart} or {@link DiagramEditPart} in the {@link EditPart} hierarchy or null,
	 *         if such doesn't exist
	 */
	public static INodeEditPart traverseToNodeEditPart(EditPart touchedEditPart) {
		EditPart primaryEditPart = touchedEditPart;
		while (primaryEditPart != null) {
			if ((primaryEditPart instanceof ShapeNodeEditPart) || (primaryEditPart instanceof ConnectionNodeEditPart)) {
				break;
			}
			primaryEditPart = primaryEditPart.getParent();
		}
		return (INodeEditPart) primaryEditPart;
	}

	/**
	 * @param touchedEditPart The editPart being examined
	 * @return The next {@link ShapeNodeEditPart}, {@link DiagramEditPart} or {@link CompartmentEditPart} in the
	 *         {@link EditPart} hierarchy or null, if such doesn't exist
	 */
	public static CompartmentEditPart traverseToCompartmentEditPart(EditPart touchedEditPart) {
		EditPart secondaryEditPart = touchedEditPart;
		while (secondaryEditPart != null) {
			if (secondaryEditPart instanceof CompartmentEditPart) {
				break;
			}
			secondaryEditPart = secondaryEditPart.getParent();
		}
		return (CompartmentEditPart) secondaryEditPart;
	}

	/**
	 * Traverses the {@link EditPart} hierarchy upwards to the next {@link EditPart} matching the specified type.
	 * 
	 * @param <T> A class type extending {@link IGraphicalEditPart}
	 * @param touchedEditPart The EditPart being the root of the search. May not be null.
	 * @param classType The class type extending {@link IGraphicalEditPart}. May not be null.
	 * @return An {@link IGraphicalEditPart} if found, null otherwise.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends IGraphicalEditPart> T traverseToEditPartOfType(EditPart touchedEditPart, Class<T> classType) {
		EditPart classTypeEditPart = touchedEditPart;
		while (classTypeEditPart != null && !(classType.isInstance(classTypeEditPart))) {
			classTypeEditPart = classTypeEditPart.getParent();
		}

		return (T) classTypeEditPart;
	}

	/**
	 * Returns the elements of each {@link EditPart}'s model.
	 * 
	 * @param editParts The {@link EditPart}s which should be searched
	 * @return A Collection of elements of Type classType
	 */
	@SuppressWarnings("unchecked")
	public static Collection getElements(Collection<? extends EditPart> editParts) {
		Set elements = new HashSet();
		for (EditPart editPart : editParts) {
			EObject element = EditPartUtility.getElement(editPart);
			if (element != null) {
				elements.add(element);
			}
		}
		return elements;
	}
	
	public static boolean isSubCompartment(EditPart editPart) {
		if(editPart instanceof KnowledgeSpaceKnowledgeSpaceCompartmentEditPart
				|| editPart instanceof KnowledgeSpaceKnowledgeSpaceCompartment2EditPart)
			return true;
		if(editPart instanceof RequirementSpaceRequirementSpaceCompartmentEditPart
				|| editPart instanceof RequirementSpaceRequirementSpaceCompartment2EditPart)
			return true;
		if(editPart instanceof DataProcessSpaceDataProcessSpaceCompartmentEditPart
				|| editPart instanceof DataProcessSpaceDataProcessSpaceCompartment2EditPart)
			return true;
		return false;
	}
}
