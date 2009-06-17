package org.unicase.ui.urmlDiagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
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
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.hazard.Hazard;
import org.unicase.model.hazard.HazardCause;
import org.unicase.model.hazard.Mitigation;
import org.unicase.model.requirement.FunctionalRequirement;

/**
 * @generated
 */
public class ModelNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof org.unicase.ui.urmlDiagram.navigator.ModelNavigatorItem
				&& !isOwnView(((org.unicase.ui.urmlDiagram.navigator.ModelNavigatorItem) element)
						.getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof org.unicase.ui.urmlDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.urmlDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.urmlDiagram.navigator.ModelNavigatorGroup) element;
			return org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof org.unicase.ui.urmlDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.urmlDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.urmlDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://unicase.org/model/diagram?MEDiagram", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.MEDiagram_66); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/hazard?HazardCause", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCause_2001); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.MitigationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/hazard?Mitigation", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Mitigation_2002); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/hazard?Hazard", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Hazard_2003); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/requirement?Actor", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Actor_2004); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/requirement?UseCase", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCase_2005); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/requirement?FunctionalRequirement", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirement_2006); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/requirement?Actor?participatedUseCases", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/requirement?Actor?initiatedUseCases", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4012); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/requirement?UseCase?includedUseCases", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/requirement?UseCase?extendedUseCases", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.MitigationHazardsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/hazard?Mitigation?hazards", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.MitigationHazards_4013); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.MitigationCausesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/hazard?Mitigation?causes", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.MitigationCauses_4014); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementRefinedRequirementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/requirement?FunctionalRequirement?refinedRequirement", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirementRefinedRequirement_4015); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementMitigationsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/requirement?FunctionalRequirement?mitigations", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirementMitigations_4008); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.ActorHazardsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/requirement?Actor?hazards", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorHazards_4010); //$NON-NLS-1$
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseHazardsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/hazard?HazardCause?hazards", org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCauseHazards_4016); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& org.unicase.ui.urmlDiagram.providers.ModelElementTypes
						.isKnownElementType(elementType)) {
			image = org.unicase.ui.urmlDiagram.providers.ModelElementTypes
					.getImage(elementType);
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
		if (element instanceof org.unicase.ui.urmlDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.urmlDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.urmlDiagram.navigator.ModelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof org.unicase.ui.urmlDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.urmlDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.urmlDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_66Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID:
			return getHazardCause_2001Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.MitigationEditPart.VISUAL_ID:
			return getMitigation_2002Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID:
			return getHazard_2003Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_2004Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_2005Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementEditPart.VISUAL_ID:
			return getFunctionalRequirement_2006Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID:
			return getActorParticipatedUseCases_4001Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID:
			return getActorInitiatedUseCases_4012Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID:
			return getUseCaseIncludedUseCases_4003Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID:
			return getUseCaseExtendedUseCases_4004Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.MitigationHazardsEditPart.VISUAL_ID:
			return getMitigationHazards_4013Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.MitigationCausesEditPart.VISUAL_ID:
			return getMitigationCauses_4014Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementRefinedRequirementEditPart.VISUAL_ID:
			return getFunctionalRequirementRefinedRequirement_4015Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementMitigationsEditPart.VISUAL_ID:
			return getFunctionalRequirementMitigations_4008Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.ActorHazardsEditPart.VISUAL_ID:
			return getActorHazards_4010Text(view);
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseHazardsEditPart.VISUAL_ID:
			return getHazardCauseHazards_4016Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getMEDiagram_66Text(View view) {
		MEDiagram domainModelElement = (MEDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"No domain element for view with visualID = " + 66); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getHazardCause_2001Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCause_2001,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.HazardCauseNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getMitigation_2002Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Mitigation_2002,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.MitigationNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getHazard_2003Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Hazard_2003,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.HazardNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getActor_2004Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Actor_2004,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.ActorNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getUseCase_2005Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCase_2005,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.UseCaseNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getFunctionalRequirement_2006Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirement_2006,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getActorParticipatedUseCases_4001Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.ParticipateLabelEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getActorInitiatedUseCases_4012Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4012,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.InitiateLabelEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getUseCaseIncludedUseCases_4003Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.IncludeLabelEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getUseCaseExtendedUseCases_4004Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.IncludeLabel2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getMitigationHazards_4013Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.MitigationHazards_4013,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.MitigateLabelEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getMitigationCauses_4014Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.MitigationCauses_4014,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.MitigateLabel2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getFunctionalRequirementRefinedRequirement_4015Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirementRefinedRequirement_4015,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.RefineLabelEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getFunctionalRequirementMitigations_4008Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirementMitigations_4008,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.MitigateLabel3EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getActorHazards_4010Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorHazards_4010,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.MitigateLabel4EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getHazardCauseHazards_4016Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.urmlDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCauseHazards_4016,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.urmlDiagram.edit.parts.CauseLabelEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
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
		return org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
						.getModelID(view));
	}

}
