package org.unicase.ui.diagram.urml.navigator;

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
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureConstrainingNonFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureDetailingFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureExcludedFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureRequiredFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureSubFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ActorEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ActorNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AssetTriggeredDangersEditPart;
import org.unicase.ui.diagram.urml.edit.parts.CombineLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ConsistsOfLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.DangerEditPart;
import org.unicase.ui.diagram.urml.edit.parts.DangerHarmedAssetsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.DangerNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ExcludesLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ExpressesLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FeatureEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FeatureNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FunctionalRequirementEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FunctionalRequirementNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FunctionalRequirementSubFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalRealizedFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReference2EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReference3EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReference4EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReferenceEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReferenceWeight2EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReferenceWeight3EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReferenceWeightEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalSubGoalsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.HarmsLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.InstantiateLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.IsConstraintLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.IsDetailedLabel2EditPart;
import org.unicase.ui.diagram.urml.edit.parts.IsDetailedLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.IsImplementedLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.IsRefinedLabel2EditPart;
import org.unicase.ui.diagram.urml.edit.parts.IsRefinedLabel3EditPart;
import org.unicase.ui.diagram.urml.edit.parts.IsRefinedLabel4EditPart;
import org.unicase.ui.diagram.urml.edit.parts.IsRefinedLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.MitigatesLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.MitigationMitigatedDangersEditPart;
import org.unicase.ui.diagram.urml.edit.parts.MotivatesLabel2EditPart;
import org.unicase.ui.diagram.urml.edit.parts.MotivatesLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.NonFunctionalRequirementEditPart;
import org.unicase.ui.diagram.urml.edit.parts.NonFunctionalRequirementNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.NonFunctionalRequirementSubNonFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProceduralMitigationEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProceduralMitigationNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProductEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProductFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProductNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProductVariationPointInstancesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.RequirementImplementingServicesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.RequiresLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.SelectLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ServiceEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ServiceNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ServiceSubServicesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.StakeholderEditPart;
import org.unicase.ui.diagram.urml.edit.parts.StakeholderGoalsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.StakeholderNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.SuggestsLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.TriggersLabelEditPart;
import org.unicase.ui.diagram.urml.edit.parts.URMLDiagramEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointInstanceEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointInstanceNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointInstanceSelectedFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointInstanceVariationPointEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointNameEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointOptionalSubFeaturesEditPart;
import org.unicase.ui.diagram.urml.part.UrmlDiagramEditorPlugin;
import org.unicase.ui.diagram.urml.part.UrmlVisualIDRegistry;
import org.unicase.ui.diagram.urml.providers.UrmlElementTypes;
import org.unicase.ui.diagram.urml.providers.UrmlParserProvider;

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
				"Navigator?TopLevelNode?http://unicase.org/model/urml/feature?Feature", UrmlElementTypes.Feature_2012); //$NON-NLS-1$
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
		case VariationPointEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml/feature?VariationPoint", UrmlElementTypes.VariationPoint_2013); //$NON-NLS-1$
		case VariationPointInstanceEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml/feature?VariationPointInstance", UrmlElementTypes.VariationPointInstance_2014); //$NON-NLS-1$
		case ProductEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml/feature?Product", UrmlElementTypes.Product_2015); //$NON-NLS-1$
		case StakeholderGoalsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml?Stakeholder?goals", UrmlElementTypes.StakeholderGoals_4008); //$NON-NLS-1$
		case AbstractFeatureSubFeaturesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/feature?AbstractFeature?subFeatures", UrmlElementTypes.AbstractFeatureSubFeatures_4034); //$NON-NLS-1$
		case AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/feature?AbstractFeature?detailingFunctionalRequirements", UrmlElementTypes.AbstractFeatureDetailingFunctionalRequirements_4035); //$NON-NLS-1$
		case AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/feature?AbstractFeature?constrainingNonFunctionalRequirements", UrmlElementTypes.AbstractFeatureConstrainingNonFunctionalRequirements_4036); //$NON-NLS-1$
		case AbstractFeatureRequiredFeaturesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/feature?AbstractFeature?requiredFeatures", UrmlElementTypes.AbstractFeatureRequiredFeatures_4045); //$NON-NLS-1$
		case AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/feature?AbstractFeature?excludedFeatures", UrmlElementTypes.AbstractFeatureExcludedFeatures_4038); //$NON-NLS-1$
		case GoalRealizedFeaturesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/goal?Goal?realizedFeatures", UrmlElementTypes.GoalRealizedFeatures_4004); //$NON-NLS-1$
		case GoalSubGoalsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/goal?Goal?subGoals", UrmlElementTypes.GoalSubGoals_4018); //$NON-NLS-1$
		case GoalReferenceEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/goal?GoalReference", UrmlElementTypes.GoalReference_4016); //$NON-NLS-1$
		case GoalReference2EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/goal?GoalReference", UrmlElementTypes.GoalReference_4023); //$NON-NLS-1$
		case GoalReference3EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/goal?GoalReference", UrmlElementTypes.GoalReference_4024); //$NON-NLS-1$
		case GoalReference4EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/goal?GoalReference", UrmlElementTypes.GoalReference_4025); //$NON-NLS-1$
		case RequirementImplementingServicesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/requirement?Requirement?implementingServices", UrmlElementTypes.RequirementImplementingServices_4005); //$NON-NLS-1$
		case NonFunctionalRequirementSubNonFunctionalRequirementsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/requirement?NonFunctionalRequirement?subNonFunctionalRequirements", UrmlElementTypes.NonFunctionalRequirementSubNonFunctionalRequirements_4043); //$NON-NLS-1$
		case FunctionalRequirementSubFunctionalRequirementsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/requirement?FunctionalRequirement?subFunctionalRequirements", UrmlElementTypes.FunctionalRequirementSubFunctionalRequirements_4044); //$NON-NLS-1$
		case MitigationMitigatedDangersEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/danger?Mitigation?mitigatedDangers", UrmlElementTypes.MitigationMitigatedDangers_4012); //$NON-NLS-1$
		case DangerHarmedAssetsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/danger?Danger?harmedAssets", UrmlElementTypes.DangerHarmedAssets_4013); //$NON-NLS-1$
		case AssetTriggeredDangersEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/danger?Asset?triggeredDangers", UrmlElementTypes.AssetTriggeredDangers_4017); //$NON-NLS-1$
		case ServiceSubServicesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/service?Service?subServices", UrmlElementTypes.ServiceSubServices_4022); //$NON-NLS-1$
		case VariationPointOptionalSubFeaturesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/feature?VariationPoint?optionalSubFeatures", UrmlElementTypes.VariationPointOptionalSubFeatures_4046); //$NON-NLS-1$
		case VariationPointInstanceVariationPointEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/feature?VariationPointInstance?variationPoint", UrmlElementTypes.VariationPointInstanceVariationPoint_4033); //$NON-NLS-1$
		case VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/feature?VariationPointInstance?selectedFeatures", UrmlElementTypes.VariationPointInstanceSelectedFeatures_4040); //$NON-NLS-1$
		case ProductVariationPointInstancesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/feature?Product?variationPointInstances", UrmlElementTypes.ProductVariationPointInstances_4032); //$NON-NLS-1$
		case ProductFeaturesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml/feature?Product?features", UrmlElementTypes.ProductFeatures_4047); //$NON-NLS-1$
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
			return getFeature_2012Text(view);
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
		case VariationPointEditPart.VISUAL_ID:
			return getVariationPoint_2013Text(view);
		case VariationPointInstanceEditPart.VISUAL_ID:
			return getVariationPointInstance_2014Text(view);
		case ProductEditPart.VISUAL_ID:
			return getProduct_2015Text(view);
		case StakeholderGoalsEditPart.VISUAL_ID:
			return getStakeholderGoals_4008Text(view);
		case AbstractFeatureSubFeaturesEditPart.VISUAL_ID:
			return getAbstractFeatureSubFeatures_4034Text(view);
		case AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
			return getAbstractFeatureDetailingFunctionalRequirements_4035Text(view);
		case AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID:
			return getAbstractFeatureConstrainingNonFunctionalRequirements_4036Text(view);
		case AbstractFeatureRequiredFeaturesEditPart.VISUAL_ID:
			return getAbstractFeatureRequiredFeatures_4045Text(view);
		case AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID:
			return getAbstractFeatureExcludedFeatures_4038Text(view);
		case GoalRealizedFeaturesEditPart.VISUAL_ID:
			return getGoalRealizedFeatures_4004Text(view);
		case GoalSubGoalsEditPart.VISUAL_ID:
			return getGoalSubGoals_4018Text(view);
		case GoalReferenceEditPart.VISUAL_ID:
			return getGoalReference_4016Text(view);
		case GoalReference2EditPart.VISUAL_ID:
			return getGoalReference_4023Text(view);
		case GoalReference3EditPart.VISUAL_ID:
			return getGoalReference_4024Text(view);
		case GoalReference4EditPart.VISUAL_ID:
			return getGoalReference_4025Text(view);
		case RequirementImplementingServicesEditPart.VISUAL_ID:
			return getRequirementImplementingServices_4005Text(view);
		case NonFunctionalRequirementSubNonFunctionalRequirementsEditPart.VISUAL_ID:
			return getNonFunctionalRequirementSubNonFunctionalRequirements_4043Text(view);
		case FunctionalRequirementSubFunctionalRequirementsEditPart.VISUAL_ID:
			return getFunctionalRequirementSubFunctionalRequirements_4044Text(view);
		case MitigationMitigatedDangersEditPart.VISUAL_ID:
			return getMitigationMitigatedDangers_4012Text(view);
		case DangerHarmedAssetsEditPart.VISUAL_ID:
			return getDangerHarmedAssets_4013Text(view);
		case AssetTriggeredDangersEditPart.VISUAL_ID:
			return getAssetTriggeredDangers_4017Text(view);
		case ServiceSubServicesEditPart.VISUAL_ID:
			return getServiceSubServices_4022Text(view);
		case VariationPointOptionalSubFeaturesEditPart.VISUAL_ID:
			return getVariationPointOptionalSubFeatures_4046Text(view);
		case VariationPointInstanceVariationPointEditPart.VISUAL_ID:
			return getVariationPointInstanceVariationPoint_4033Text(view);
		case VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID:
			return getVariationPointInstanceSelectedFeatures_4040Text(view);
		case ProductVariationPointInstancesEditPart.VISUAL_ID:
			return getProductVariationPointInstances_4032Text(view);
		case ProductFeaturesEditPart.VISUAL_ID:
			return getProductFeatures_4047Text(view);
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
	private String getFeature_2012Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.Feature_2012, view.getElement() != null ? view
			.getElement() : view, UrmlVisualIDRegistry.getType(FeatureNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5011); //$NON-NLS-1$
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
	private String getVariationPoint_2013Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.VariationPoint_2013,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(VariationPointNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getVariationPointInstance_2014Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.VariationPointInstance_2014,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(VariationPointInstanceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProduct_2015Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.Product_2015, view.getElement() != null ? view
			.getElement() : view, UrmlVisualIDRegistry.getType(ProductNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5014); //$NON-NLS-1$
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
	private String getAbstractFeatureSubFeatures_4034Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.AbstractFeatureSubFeatures_4034, view
			.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
			.getType(IsRefinedLabel2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6034); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAbstractFeatureDetailingFunctionalRequirements_4035Text(View view) {
		IParser parser = UrmlParserProvider.getParser(
			UrmlElementTypes.AbstractFeatureDetailingFunctionalRequirements_4035, view.getElement() != null ? view
				.getElement() : view, UrmlVisualIDRegistry.getType(IsDetailedLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6035); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAbstractFeatureConstrainingNonFunctionalRequirements_4036Text(View view) {
		IParser parser = UrmlParserProvider.getParser(
			UrmlElementTypes.AbstractFeatureConstrainingNonFunctionalRequirements_4036,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(IsConstraintLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6036); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAbstractFeatureRequiredFeatures_4045Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.AbstractFeatureRequiredFeatures_4045, view
			.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
			.getType(RequiresLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6045); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAbstractFeatureExcludedFeatures_4038Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.AbstractFeatureExcludedFeatures_4038, view
			.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
			.getType(ExcludesLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6038); //$NON-NLS-1$
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
	private String getGoalSubGoals_4018Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.GoalSubGoals_4018,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(IsRefinedLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGoalReference_4016Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.GoalReference_4016,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(IsDetailedLabel2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGoalReference_4023Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.GoalReference_4023,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(GoalReferenceWeightEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGoalReference_4024Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.GoalReference_4024,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(GoalReferenceWeight2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGoalReference_4025Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.GoalReference_4025,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(GoalReferenceWeight3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6021); //$NON-NLS-1$
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
	private String getNonFunctionalRequirementSubNonFunctionalRequirements_4043Text(View view) {
		IParser parser = UrmlParserProvider.getParser(
			UrmlElementTypes.NonFunctionalRequirementSubNonFunctionalRequirements_4043,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(IsRefinedLabel3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6043); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFunctionalRequirementSubFunctionalRequirements_4044Text(View view) {
		IParser parser = UrmlParserProvider.getParser(
			UrmlElementTypes.FunctionalRequirementSubFunctionalRequirements_4044, view.getElement() != null ? view
				.getElement() : view, UrmlVisualIDRegistry.getType(IsRefinedLabel4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6044); //$NON-NLS-1$
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
	private String getAssetTriggeredDangers_4017Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.AssetTriggeredDangers_4017,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(TriggersLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getServiceSubServices_4022Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.ServiceSubServices_4022,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(MotivatesLabel2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getVariationPointOptionalSubFeatures_4046Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.VariationPointOptionalSubFeatures_4046, view
			.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
			.getType(SuggestsLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6046); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getVariationPointInstanceVariationPoint_4033Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.VariationPointInstanceVariationPoint_4033, view
			.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
			.getType(InstantiateLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6033); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getVariationPointInstanceSelectedFeatures_4040Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.VariationPointInstanceSelectedFeatures_4040,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(SelectLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6040); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProductVariationPointInstances_4032Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.ProductVariationPointInstances_4032, view
			.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
			.getType(CombineLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6032); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProductFeatures_4047Text(View view) {
		IParser parser = UrmlParserProvider.getParser(UrmlElementTypes.ProductFeatures_4047,
			view.getElement() != null ? view.getElement() : view, UrmlVisualIDRegistry
				.getType(ConsistsOfLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6047); //$NON-NLS-1$
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
