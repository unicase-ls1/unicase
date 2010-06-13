package org.unicase.model.urml.ui.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureDetailingFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureParentFeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalRealizedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.RequirementImplementingServicesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.Stakeholder2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.URMLDiagramEditPart;
import org.unicase.model.urml.ui.diagram.part.UrmlDiagramEditorPlugin;
import org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;
import org.unicase.model.urml.ui.diagram.providers.UrmlParserProvider;

import urml.goal.Goal;
import urml.requirement.FunctionalRequirement;

/**
 * @generated
 */
public class UrmlNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		UrmlDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		UrmlDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof UrmlNavigatorItem && !isOwnView(((UrmlNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof UrmlNavigatorGroup) {
			UrmlNavigatorGroup group = (UrmlNavigatorGroup) element;
			return UrmlDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof UrmlNavigatorItem) {
			UrmlNavigatorItem navigatorItem = (UrmlNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case URMLDiagramEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Diagram?http://unicase.org/model/urml?URMLDiagram", UrmlElementTypes.URMLDiagram_1000); //$NON-NLS-1$
		case StakeholderEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml?Stakeholder", UrmlElementTypes.Stakeholder_2002); //$NON-NLS-1$
		case GoalEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml/goal?Goal", UrmlElementTypes.Goal_2001); //$NON-NLS-1$
		case FunctionalRequirementEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml/requirement?FunctionalRequirement", UrmlElementTypes.FunctionalRequirement_2006); //$NON-NLS-1$
		case FeatureEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml?Feature", UrmlElementTypes.Feature_2005); //$NON-NLS-1$
		case ServiceEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml/service?Service", UrmlElementTypes.Service_2007); //$NON-NLS-1$
		case NonFunctionalRequirementEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml/requirement?NonFunctionalRequirement", UrmlElementTypes.NonFunctionalRequirement_2008); //$NON-NLS-1$
		case DangerEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml/danger?Danger", UrmlElementTypes.Danger_2009); //$NON-NLS-1$
		case ActorEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml/usecase?Actor", UrmlElementTypes.Actor_2010); //$NON-NLS-1$
		case Stakeholder2EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml?Stakeholder", UrmlElementTypes.Stakeholder_4001); //$NON-NLS-1$
		case FeatureParentFeatureEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml?Feature?parentFeature", UrmlElementTypes.FeatureParentFeature_4002); //$NON-NLS-1$
		case StakeholderGoalsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml?Stakeholder?goals", UrmlElementTypes.StakeholderGoals_4003); //$NON-NLS-1$
		case GoalRealizedFeaturesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/goal?Goal?realizedFeatures", UrmlElementTypes.GoalRealizedFeatures_4004); //$NON-NLS-1$
		case RequirementImplementingServicesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/requirement?Requirement?implementingServices", UrmlElementTypes.RequirementImplementingServices_4005); //$NON-NLS-1$
		case FeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml?Feature?detailingFunctionalRequirements", UrmlElementTypes.FeatureDetailingFunctionalRequirements_4006); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = UrmlDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && UrmlElementTypes.isKnownElementType(elementType)) {
			image = UrmlElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof UrmlNavigatorGroup) {
			UrmlNavigatorGroup group = (UrmlNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof UrmlNavigatorItem) {
			UrmlNavigatorItem navigatorItem = (UrmlNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case URMLDiagramEditPart.VISUAL_ID:
			return getURMLDiagram_1000Text(view);
		case StakeholderEditPart.VISUAL_ID:
			return getStakeholder_2002Text(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001Text(view);
		case FunctionalRequirementEditPart.VISUAL_ID:
			return getFunctionalRequirement_2006Text(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2005Text(view);
		case ServiceEditPart.VISUAL_ID:
			return getService_2007Text(view);
		case NonFunctionalRequirementEditPart.VISUAL_ID:
			return getNonFunctionalRequirement_2008Text(view);
		case DangerEditPart.VISUAL_ID:
			return getDanger_2009Text(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2010Text(view);
		case Stakeholder2EditPart.VISUAL_ID:
			return getStakeholder_4001Text(view);
		case FeatureParentFeatureEditPart.VISUAL_ID:
			return getFeatureParentFeature_4002Text(view);
		case StakeholderGoalsEditPart.VISUAL_ID:
			return getStakeholderGoals_4003Text(view);
		case GoalRealizedFeaturesEditPart.VISUAL_ID:
			return getGoalRealizedFeatures_4004Text(view);
		case RequirementImplementingServicesEditPart.VISUAL_ID:
			return getRequirementImplementingServices_4005Text(view);
		case FeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
			return getFeatureDetailingFunctionalRequirements_4006Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getURMLDiagram_1000Text(View view) {
		URMLDiagram domainModelElement = (URMLDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStakeholder_2002Text(View view) {
		Stakeholder domainModelElement = (Stakeholder) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGoal_2001Text(View view) {
		Goal domainModelElement = (Goal) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFunctionalRequirement_2006Text(View view) {
		FunctionalRequirement domainModelElement = (FunctionalRequirement) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeature_2005Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.Feature_2005, view.getElement() != null ? view
			.getElement() : view, UrmlVisualIDRegistry.getType(FeatureNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getService_2007Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.Service_2007, view.getElement() != null ? view
			.getElement() : view, UrmlVisualIDRegistry.getType(ServiceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNonFunctionalRequirement_2008Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.NonFunctionalRequirement_2008,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(NonFunctionalRequirementNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDanger_2009Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.Danger_2009, view.getElement() != null ? view
			.getElement() : view, UrmlVisualIDRegistry.getType(DangerNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActor_2010Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.Actor_2010, view.getElement() != null ? view
			.getElement() : view, UrmlVisualIDRegistry.getType(ActorNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStakeholder_4001Text(View view) {
		Stakeholder domainModelElement = (Stakeholder) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeatureParentFeature_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getStakeholderGoals_4003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getGoalRealizedFeatures_4004Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRequirementImplementingServices_4005Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFeatureDetailingFunctionalRequirements_4006Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return URMLDiagramEditPart.MODEL_ID.equals(UrmlVisualIDRegistry.getModelID(view));
	}

}
