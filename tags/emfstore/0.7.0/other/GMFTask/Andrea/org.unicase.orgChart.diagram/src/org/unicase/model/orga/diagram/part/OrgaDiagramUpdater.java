package org.unicase.model.orga.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.orga.Employee;
import org.unicase.model.orga.OrgDiagram;
import org.unicase.model.orga.OrgaPackage;
import org.unicase.model.orga.OrgaUnit;
import org.unicase.model.orga.Team;
import org.unicase.model.orga.diagram.edit.parts.EmployeeEditPart;
import org.unicase.model.orga.diagram.edit.parts.OrgDiagramEditPart;
import org.unicase.model.orga.diagram.edit.parts.TeamEditPart;
import org.unicase.model.orga.diagram.edit.parts.TeamHasOrgUnitEditPart;
import org.unicase.model.orga.diagram.providers.OrgaElementTypes;

/**
 * @generated
 */
public class OrgaDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (OrgaVisualIDRegistry.getVisualID(view)) {
		case OrgDiagramEditPart.VISUAL_ID:
			return getOrgDiagram_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOrgDiagram_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		OrgDiagram modelElement = (OrgDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNewElements().iterator(); it
				.hasNext();) {
			UnicaseModelElement childElement = (UnicaseModelElement) it.next();
			int visualID = OrgaVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EmployeeEditPart.VISUAL_ID) {
				result.add(new OrgaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TeamEditPart.VISUAL_ID) {
				result.add(new OrgaNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (OrgaVisualIDRegistry.getVisualID(view)) {
		case OrgDiagramEditPart.VISUAL_ID:
			return getOrgDiagram_1000ContainedLinks(view);
		case EmployeeEditPart.VISUAL_ID:
			return getEmployee_2001ContainedLinks(view);
		case TeamEditPart.VISUAL_ID:
			return getTeam_2002ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (OrgaVisualIDRegistry.getVisualID(view)) {
		case EmployeeEditPart.VISUAL_ID:
			return getEmployee_2001IncomingLinks(view);
		case TeamEditPart.VISUAL_ID:
			return getTeam_2002IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (OrgaVisualIDRegistry.getVisualID(view)) {
		case EmployeeEditPart.VISUAL_ID:
			return getEmployee_2001OutgoingLinks(view);
		case TeamEditPart.VISUAL_ID:
			return getTeam_2002OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOrgDiagram_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEmployee_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTeam_2002ContainedLinks(View view) {
		Team modelElement = (Team) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Team_HasOrgUnit_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEmployee_2001IncomingLinks(View view) {
		Employee modelElement = (Employee) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Team_HasOrgUnit_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTeam_2002IncomingLinks(View view) {
		Team modelElement = (Team) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Team_HasOrgUnit_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEmployee_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTeam_2002OutgoingLinks(View view) {
		Team modelElement = (Team) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Team_HasOrgUnit_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Team_HasOrgUnit_4001(
			OrgaUnit target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == OrgaPackage.eINSTANCE
					.getTeam_HasOrgUnit()) {
				result.add(new OrgaLinkDescriptor(setting.getEObject(), target,
						OrgaElementTypes.TeamHasOrgUnit_4001,
						TeamHasOrgUnitEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Team_HasOrgUnit_4001(
			Team source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getHasOrgUnit().iterator(); destinations
				.hasNext();) {
			OrgaUnit destination = (OrgaUnit) destinations.next();
			result.add(new OrgaLinkDescriptor(source, destination,
					OrgaElementTypes.TeamHasOrgUnit_4001,
					TeamHasOrgUnitEditPart.VISUAL_ID));
		}
		return result;
	}

}
