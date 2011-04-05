package org.unicase.ui.diagram.workItemDiagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;

/**
 * @generated
 */
public class ModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_33SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_33SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		MEDiagram modelElement = (MEDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			ModelElement childElement = (ModelElement) it.next();
			int visualID = org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == org.unicase.ui.diagram.workItemDiagram.edit.parts.ActionItemEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.workItemDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.diagram.workItemDiagram.edit.parts.IssueEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.workItemDiagram.part.ModelNodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == org.unicase.ui.diagram.workItemDiagram.edit.parts.BugReportEditPart.VISUAL_ID) {
				result
						.add(new org.unicase.ui.diagram.workItemDiagram.part.ModelNodeDescriptor(
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
		switch (org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_33ContainedLinks(view);
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.ActionItemEditPart.VISUAL_ID:
			return getActionItem_2001ContainedLinks(view);
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.IssueEditPart.VISUAL_ID:
			return getIssue_2002ContainedLinks(view);
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.BugReportEditPart.VISUAL_ID:
			return getBugReport_2003ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.ActionItemEditPart.VISUAL_ID:
			return getActionItem_2001IncomingLinks(view);
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.IssueEditPart.VISUAL_ID:
			return getIssue_2002IncomingLinks(view);
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.BugReportEditPart.VISUAL_ID:
			return getBugReport_2003IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.ActionItemEditPart.VISUAL_ID:
			return getActionItem_2001OutgoingLinks(view);
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.IssueEditPart.VISUAL_ID:
			return getIssue_2002OutgoingLinks(view);
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.BugReportEditPart.VISUAL_ID:
			return getBugReport_2003OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMEDiagram_33ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActionItem_2001ContainedLinks(View view) {
		ActionItem modelElement = (ActionItem) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_WorkItem_Successors_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIssue_2002ContainedLinks(View view) {
		Issue modelElement = (Issue) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_WorkItem_Successors_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBugReport_2003ContainedLinks(View view) {
		BugReport modelElement = (BugReport) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_WorkItem_Successors_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActionItem_2001IncomingLinks(View view) {
		ActionItem modelElement = (ActionItem) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_WorkItem_Successors_4003(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIssue_2002IncomingLinks(View view) {
		Issue modelElement = (Issue) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_WorkItem_Successors_4003(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBugReport_2003IncomingLinks(View view) {
		BugReport modelElement = (BugReport) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_WorkItem_Successors_4003(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActionItem_2001OutgoingLinks(View view) {
		ActionItem modelElement = (ActionItem) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_WorkItem_Successors_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIssue_2002OutgoingLinks(View view) {
		Issue modelElement = (Issue) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_WorkItem_Successors_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBugReport_2003OutgoingLinks(View view) {
		BugReport modelElement = (BugReport) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_WorkItem_Successors_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_WorkItem_Successors_4003(
			WorkItem target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == TaskPackage.eINSTANCE
					.getWorkItem_Successors()) {
				result
						.add(new org.unicase.ui.diagram.workItemDiagram.part.ModelLinkDescriptor(
								setting.getEObject(),
								target,
								org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.WorkItemSuccessors_4003,
								org.unicase.ui.diagram.workItemDiagram.edit.parts.WorkItemSuccessorsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_WorkItem_Successors_4003(
			WorkItem source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getSuccessors().iterator(); destinations
				.hasNext();) {
			WorkItem destination = (WorkItem) destinations.next();
			result
					.add(new org.unicase.ui.diagram.workItemDiagram.part.ModelLinkDescriptor(
							source,
							destination,
							org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.WorkItemSuccessors_4003,
							org.unicase.ui.diagram.workItemDiagram.edit.parts.WorkItemSuccessorsEditPart.VISUAL_ID));
		}
		return result;
	}

}
