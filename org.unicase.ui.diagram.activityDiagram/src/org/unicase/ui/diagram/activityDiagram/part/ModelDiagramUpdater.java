/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.activityDiagram.part;

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
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.activity.Activity;
import org.unicase.model.activity.ActivityEnd;
import org.unicase.model.activity.ActivityInitial;
import org.unicase.model.activity.ActivityObject;
import org.unicase.model.activity.ActivityPackage;
import org.unicase.model.activity.Branch;
import org.unicase.model.activity.Fork;
import org.unicase.model.activity.Transition;
import org.unicase.model.diagram.ActivityDiagram;
import org.unicase.model.diagram.MEDiagram;

/**
 * @generated
 */
public class ModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.activityDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getActivityDiagram_33SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivityDiagram_33SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ActivityDiagram modelElement = (ActivityDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			UnicaseModelElement childElement = (UnicaseModelElement) it.next();
			int visualID = org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.activityDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.diagram.activityDiagram.edit.parts.ForkEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.activityDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityInitialEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.activityDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEndEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.activityDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.diagram.activityDiagram.edit.parts.BranchEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.activityDiagram.part.ModelNodeDescriptor(
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
		switch (org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.activityDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getActivityDiagram_33ContainedLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEditPart.VISUAL_ID:
			return getActivity_2002ContainedLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ForkEditPart.VISUAL_ID:
			return getFork_2003ContainedLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityInitialEditPart.VISUAL_ID:
			return getActivityInitial_2004ContainedLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEndEditPart.VISUAL_ID:
			return getActivityEnd_2005ContainedLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.BranchEditPart.VISUAL_ID:
			return getBranch_2006ContainedLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEditPart.VISUAL_ID:
			return getActivity_2002IncomingLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ForkEditPart.VISUAL_ID:
			return getFork_2003IncomingLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityInitialEditPart.VISUAL_ID:
			return getActivityInitial_2004IncomingLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEndEditPart.VISUAL_ID:
			return getActivityEnd_2005IncomingLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.BranchEditPart.VISUAL_ID:
			return getBranch_2006IncomingLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEditPart.VISUAL_ID:
			return getActivity_2002OutgoingLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ForkEditPart.VISUAL_ID:
			return getFork_2003OutgoingLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityInitialEditPart.VISUAL_ID:
			return getActivityInitial_2004OutgoingLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEndEditPart.VISUAL_ID:
			return getActivityEnd_2005OutgoingLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.BranchEditPart.VISUAL_ID:
			return getBranch_2006OutgoingLinks(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivityDiagram_33ContainedLinks(View view) {
		ActivityDiagram modelElement = (ActivityDiagram) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivity_2002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFork_2003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivityInitial_2004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivityEnd_2005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBranch_2006ContainedLinks(View view) {
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
	public static List getActivity_2002IncomingLinks(View view) {
		Activity modelElement = (Activity) view.getElement();
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
	public static List getFork_2003IncomingLinks(View view) {
		Fork modelElement = (Fork) view.getElement();
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
	public static List getActivityInitial_2004IncomingLinks(View view) {
		ActivityInitial modelElement = (ActivityInitial) view.getElement();
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
	public static List getActivityEnd_2005IncomingLinks(View view) {
		ActivityEnd modelElement = (ActivityEnd) view.getElement();
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
	public static List getBranch_2006IncomingLinks(View view) {
		Branch modelElement = (Branch) view.getElement();
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
	public static List getActivity_2002OutgoingLinks(View view) {
		Activity modelElement = (Activity) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFork_2003OutgoingLinks(View view) {
		Fork modelElement = (Fork) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityInitial_2004OutgoingLinks(View view) {
		ActivityInitial modelElement = (ActivityInitial) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityEnd_2005OutgoingLinks(View view) {
		ActivityEnd modelElement = (ActivityEnd) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBranch_2006OutgoingLinks(View view) {
		Branch modelElement = (Branch) view.getElement();
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
			if (org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionEditPart.VISUAL_ID != org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			ActivityObject dst = link.getTarget();
			ActivityObject src = link.getSource();
			result
					.add(new org.unicase.ui.diagram.activityDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001,
							org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Transition_4001(
			ActivityObject target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != ActivityPackage.eINSTANCE
					.getTransition_Target()
					|| false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition) setting.getEObject();
			if (org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionEditPart.VISUAL_ID != org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			ActivityObject src = link.getSource();
			result
					.add(new org.unicase.ui.diagram.activityDiagram.part.ModelLinkDescriptor(
							src,
							target,
							link,
							org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001,
							org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Transition_4001(
			ActivityObject source) {
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
			if (org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionEditPart.VISUAL_ID != org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			ActivityObject dst = link.getTarget();
			ActivityObject src = link.getSource();
			if (src != source) {
				continue;
			}
			result
					.add(new org.unicase.ui.diagram.activityDiagram.part.ModelLinkDescriptor(
							src,
							dst,
							link,
							org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001,
							org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

}
