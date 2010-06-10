package org.unicase.model.urml.ui.diagram.part;

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
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.Stakeholder2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.URMLDiagramEditPart;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;

import urml.goal.Goal;

/**
 * @generated
 */
public class UrmlDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case URMLDiagramEditPart.VISUAL_ID:
			return getURMLDiagram_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getURMLDiagram_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		URMLDiagram modelElement = (URMLDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNewElements().iterator(); it.hasNext();) {
			UnicaseModelElement childElement = (UnicaseModelElement) it.next();
			int visualID = UrmlVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == StakeholderEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			UnicaseModelElement childElement = (UnicaseModelElement) it.next();
			int visualID = UrmlVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == GoalEditPart.VISUAL_ID) {
				result.add(new UrmlNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case URMLDiagramEditPart.VISUAL_ID:
			return getURMLDiagram_1000ContainedLinks(view);
		case StakeholderEditPart.VISUAL_ID:
			return getStakeholder_2002ContainedLinks(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001ContainedLinks(view);
		case Stakeholder2EditPart.VISUAL_ID:
			return getStakeholder_4001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case StakeholderEditPart.VISUAL_ID:
			return getStakeholder_2002IncomingLinks(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001IncomingLinks(view);
		case Stakeholder2EditPart.VISUAL_ID:
			return getStakeholder_4001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case StakeholderEditPart.VISUAL_ID:
			return getStakeholder_2002OutgoingLinks(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001OutgoingLinks(view);
		case Stakeholder2EditPart.VISUAL_ID:
			return getStakeholder_4001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getURMLDiagram_1000ContainedLinks(View view) {
		URMLDiagram modelElement = (URMLDiagram) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Stakeholder_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_2002ContainedLinks(View view) {
		Stakeholder modelElement = (Stakeholder) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGoal_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_4001ContainedLinks(View view) {
		Stakeholder modelElement = (Stakeholder) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_2002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGoal_2001IncomingLinks(View view) {
		Goal modelElement = (Goal) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Stakeholder_Goals_4003(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_2002OutgoingLinks(View view) {
		Stakeholder modelElement = (Stakeholder) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGoal_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStakeholder_4001OutgoingLinks(View view) {
		Stakeholder modelElement = (Stakeholder) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Stakeholder_4001(MEDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getNewElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Stakeholder) {
				continue;
			}
			Stakeholder link = (Stakeholder) linkObject;
			if (Stakeholder2EditPart.VISUAL_ID != UrmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getAnnotations();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Annotation) {
				continue;
			}
			Annotation dst = (Annotation) theTarget;
			result.add(new UrmlLinkDescriptor(container, dst, link, UrmlElementTypes.Stakeholder_4001,
				Stakeholder2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Stakeholder_Goals_4003(Goal target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UrmlPackage.eINSTANCE.getStakeholder_Goals()) {
				result.add(new UrmlLinkDescriptor(setting.getEObject(), target, UrmlElementTypes.StakeholderGoals_4003,
					StakeholderGoalsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Stakeholder_Goals_4003(Stakeholder source) {
		Collection result = new LinkedList();
		Goal destination = source.getGoals();
		if (destination == null) {
			return result;
		}
		result.add(new UrmlLinkDescriptor(source, destination, UrmlElementTypes.StakeholderGoals_4003,
			StakeholderGoalsEditPart.VISUAL_ID));
		return result;
	}

}
