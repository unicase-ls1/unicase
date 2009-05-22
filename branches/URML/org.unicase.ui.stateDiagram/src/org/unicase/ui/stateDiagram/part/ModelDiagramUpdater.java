/** 
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stateDiagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.state.State;
import org.unicase.model.state.StatePackage;
import org.unicase.model.state.Transition;

/**
 * @generated
 */
public class ModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.stateDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_55SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_55SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		MEDiagram modelElement = (MEDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			ModelElement childElement = (ModelElement) it.next();
			int visualID = org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.ui.stateDiagram.edit.parts.StateEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.stateDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.stateDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_55ContainedLinks(view);
		case org.unicase.ui.stateDiagram.edit.parts.StateEditPart.VISUAL_ID:
			return getState_2001ContainedLinks(view);
		case org.unicase.ui.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.stateDiagram.edit.parts.StateEditPart.VISUAL_ID:
			return getState_2001IncomingLinks(view);
		case org.unicase.ui.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.stateDiagram.edit.parts.StateEditPart.VISUAL_ID:
			return getState_2001OutgoingLinks(view);
		case org.unicase.ui.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_55ContainedLinks(View view) {
		MEDiagram modelElement = (MEDiagram) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_2001IncomingLinks(View view) {
		State modelElement = (State) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_2001OutgoingLinks(View view) {
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Transition_4001(
			MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (org.unicase.ui.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID != org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State dst = link.getTarget();
			State src = link.getSource();
			result
					.add(new org.unicase.ui.stateDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.stateDiagram.providers.ModelElementTypes.Transition_4001,
							org.unicase.ui.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Transition_4001(
			State target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != StatePackage.eINSTANCE
					.getTransition_Target()
					|| false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition) setting.getEObject();
			if (org.unicase.ui.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID != org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State src = link.getSource();
			result
					.add(new org.unicase.ui.stateDiagram.part.ModelLinkDescriptor(
							src,
							target,
							link,
							org.unicase.ui.stateDiagram.providers.ModelElementTypes.Transition_4001,
							org.unicase.ui.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Transition_4001(
			State source) {
		MEDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof MEDiagram) {
				container = (MEDiagram) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (org.unicase.ui.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID != org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State dst = link.getTarget();
			State src = link.getSource();
			if (src != source) {
				continue;
			}
			result
					.add(new org.unicase.ui.stateDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.stateDiagram.providers.ModelElementTypes.Transition_4001,
							org.unicase.ui.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

}
