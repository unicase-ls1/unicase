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
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorTriggeredDangersEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerHarmedAssetsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ExpressesLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureConstrainingNonFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureDetailingFunctionalRequirementsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureSubFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalRealizedFeaturesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalSubGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.HarmsLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.IsConstraintLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.IsDetailedLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.IsImplementedLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.IsProvidedLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.IsRefinedLabel2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.IsRefinedLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.MitigatesLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.MitigationMitigatedDangersEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.MotivatesLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProceduralMitigationEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProceduralMitigationNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.RequirementImplementingServicesEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceProviderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceProviderNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceServiceProviderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderNameEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.TriggersLabelEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.URMLDiagramEditPart;
import org.unicase.model.urml.ui.diagram.part.UrmlDiagramEditorPlugin;
import org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;
import org.unicase.model.urml.ui.diagram.providers.UrmlParserProvider;

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
		case ProceduralMitigationEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml/danger?ProceduralMitigation", UrmlElementTypes.ProceduralMitigation_2011); //$NON-NLS-1$
		case ServiceProviderEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml/service?ServiceProvider", UrmlElementTypes.ServiceProvider_2012); //$NON-NLS-1$
		case StakeholderGoalsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml?Stakeholder?goals", UrmlElementTypes.StakeholderGoals_4008); //$NON-NLS-1$
		case FeatureSubFeaturesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml?Feature?subFeatures", UrmlElementTypes.FeatureSubFeatures_4015); //$NON-NLS-1$
		case GoalRealizedFeaturesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/goal?Goal?realizedFeatures", UrmlElementTypes.GoalRealizedFeatures_4004); //$NON-NLS-1$
		case RequirementImplementingServicesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/requirement?Requirement?implementingServices", UrmlElementTypes.RequirementImplementingServices_4005); //$NON-NLS-1$
		case FeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml?Feature?detailingFunctionalRequirements", UrmlElementTypes.FeatureDetailingFunctionalRequirements_4006); //$NON-NLS-1$
		case GoalSubGoalsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/goal?Goal?subGoals", UrmlElementTypes.GoalSubGoals_4009); //$NON-NLS-1$
		case FeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml?Feature?constrainingNonFunctionalRequirements", UrmlElementTypes.FeatureConstrainingNonFunctionalRequirements_4010); //$NON-NLS-1$
		case ServiceServiceProviderEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/service?Service?serviceProvider", UrmlElementTypes.ServiceServiceProvider_4011); //$NON-NLS-1$
		case MitigationMitigatedDangersEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/danger?Mitigation?mitigatedDangers", UrmlElementTypes.MitigationMitigatedDangers_4012); //$NON-NLS-1$
		case DangerHarmedAssetsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/danger?Danger?harmedAssets", UrmlElementTypes.DangerHarmedAssets_4013); //$NON-NLS-1$
		case ActorTriggeredDangersEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/usecase?Actor?triggeredDangers", UrmlElementTypes.ActorTriggeredDangers_4014); //$NON-NLS-1$
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
		case ProceduralMitigationEditPart.VISUAL_ID:
			return getProceduralMitigation_2011Text(view);
		case ServiceProviderEditPart.VISUAL_ID:
			return getServiceProvider_2012Text(view);
		case StakeholderGoalsEditPart.VISUAL_ID:
			return getStakeholderGoals_4008Text(view);
		case FeatureSubFeaturesEditPart.VISUAL_ID:
			return getFeatureSubFeatures_4015Text(view);
		case GoalRealizedFeaturesEditPart.VISUAL_ID:
			return getGoalRealizedFeatures_4004Text(view);
		case RequirementImplementingServicesEditPart.VISUAL_ID:
			return getRequirementImplementingServices_4005Text(view);
		case FeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
			return getFeatureDetailingFunctionalRequirements_4006Text(view);
		case GoalSubGoalsEditPart.VISUAL_ID:
			return getGoalSubGoals_4009Text(view);
		case FeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID:
			return getFeatureConstrainingNonFunctionalRequirements_4010Text(view);
		case ServiceServiceProviderEditPart.VISUAL_ID:
			return getServiceServiceProvider_4011Text(view);
		case MitigationMitigatedDangersEditPart.VISUAL_ID:
			return getMitigationMitigatedDangers_4012Text(view);
		case DangerHarmedAssetsEditPart.VISUAL_ID:
			return getDangerHarmedAssets_4013Text(view);
		case ActorTriggeredDangersEditPart.VISUAL_ID:
			return getActorTriggeredDangers_4014Text(view);
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
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.Stakeholder_2002,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(StakeholderNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGoal_2001Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.Goal_2001, view.getElement() != null ? view
			.getElement() : view, UrmlVisualIDRegistry.getType(GoalNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFunctionalRequirement_2006Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.FunctionalRequirement_2006,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(FunctionalRequirementNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5010); //$NON-NLS-1$
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
	private String getProceduralMitigation_2011Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.ProceduralMitigation_2011,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(ProceduralMitigationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getServiceProvider_2012Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.ServiceProvider_2012,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(ServiceProviderNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStakeholderGoals_4008Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.StakeholderGoals_4008,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(ExpressesLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeatureSubFeatures_4015Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.FeatureSubFeatures_4015,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(IsRefinedLabel2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGoalRealizedFeatures_4004Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.GoalRealizedFeatures_4004,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(MotivatesLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementImplementingServices_4005Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.RequirementImplementingServices_4005, view
			.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
			.getType(IsImplementedLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeatureDetailingFunctionalRequirements_4006Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.FeatureDetailingFunctionalRequirements_4006,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(IsDetailedLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGoalSubGoals_4009Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.GoalSubGoals_4009,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(IsRefinedLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeatureConstrainingNonFunctionalRequirements_4010Text(View view) {
		IParser parser = UrmlParserProvider.getParser(
			UrmlElementTypes.FeatureConstrainingNonFunctionalRequirements_4010, view.getElement() != null ? view
				.getElement() : view, UrmlVisualIDRegistry.getType(IsConstraintLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getServiceServiceProvider_4011Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.ServiceServiceProvider_4011,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(IsProvidedLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMitigationMitigatedDangers_4012Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.MitigationMitigatedDangers_4012, view
			.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
			.getType(MitigatesLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDangerHarmedAssets_4013Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.DangerHarmedAssets_4013,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(HarmsLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActorTriggeredDangers_4014Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.ActorTriggeredDangers_4014,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(TriggersLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
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
