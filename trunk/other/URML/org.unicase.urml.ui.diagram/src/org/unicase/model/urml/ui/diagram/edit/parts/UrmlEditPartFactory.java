package org.unicase.model.urml.ui.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry;

/**
 * @generated
 */
public class UrmlEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (UrmlVisualIDRegistry.getVisualID(view)) {

			case URMLDiagramEditPart.VISUAL_ID:
				return new URMLDiagramEditPart(view);

			case StakeholderEditPart.VISUAL_ID:
				return new StakeholderEditPart(view);

			case StakeholderNameEditPart.VISUAL_ID:
				return new StakeholderNameEditPart(view);

			case GoalEditPart.VISUAL_ID:
				return new GoalEditPart(view);

			case GoalNameEditPart.VISUAL_ID:
				return new GoalNameEditPart(view);

			case FunctionalRequirementEditPart.VISUAL_ID:
				return new FunctionalRequirementEditPart(view);

			case FunctionalRequirementNameEditPart.VISUAL_ID:
				return new FunctionalRequirementNameEditPart(view);

			case FeatureEditPart.VISUAL_ID:
				return new FeatureEditPart(view);

			case FeatureNameEditPart.VISUAL_ID:
				return new FeatureNameEditPart(view);

			case ServiceEditPart.VISUAL_ID:
				return new ServiceEditPart(view);

			case ServiceNameEditPart.VISUAL_ID:
				return new ServiceNameEditPart(view);

			case NonFunctionalRequirementEditPart.VISUAL_ID:
				return new NonFunctionalRequirementEditPart(view);

			case NonFunctionalRequirementNameEditPart.VISUAL_ID:
				return new NonFunctionalRequirementNameEditPart(view);

			case DangerEditPart.VISUAL_ID:
				return new DangerEditPart(view);

			case DangerNameEditPart.VISUAL_ID:
				return new DangerNameEditPart(view);

			case ActorEditPart.VISUAL_ID:
				return new ActorEditPart(view);

			case ActorNameEditPart.VISUAL_ID:
				return new ActorNameEditPart(view);

			case ProceduralMitigationEditPart.VISUAL_ID:
				return new ProceduralMitigationEditPart(view);

			case ProceduralMitigationNameEditPart.VISUAL_ID:
				return new ProceduralMitigationNameEditPart(view);

			case VariationPointEditPart.VISUAL_ID:
				return new VariationPointEditPart(view);

			case VariationPointNameEditPart.VISUAL_ID:
				return new VariationPointNameEditPart(view);

			case VariationPointInstanceEditPart.VISUAL_ID:
				return new VariationPointInstanceEditPart(view);

			case VariationPointInstanceNameEditPart.VISUAL_ID:
				return new VariationPointInstanceNameEditPart(view);

			case ProductEditPart.VISUAL_ID:
				return new ProductEditPart(view);

			case ProductNameEditPart.VISUAL_ID:
				return new ProductNameEditPart(view);

			case StakeholderGoalsEditPart.VISUAL_ID:
				return new StakeholderGoalsEditPart(view);

			case ExpressesLabelEditPart.VISUAL_ID:
				return new ExpressesLabelEditPart(view);

			case AbstractFeatureSubFeaturesEditPart.VISUAL_ID:
				return new AbstractFeatureSubFeaturesEditPart(view);

			case IsRefinedLabel2EditPart.VISUAL_ID:
				return new IsRefinedLabel2EditPart(view);

			case AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
				return new AbstractFeatureDetailingFunctionalRequirementsEditPart(view);

			case IsDetailedLabelEditPart.VISUAL_ID:
				return new IsDetailedLabelEditPart(view);

			case AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID:
				return new AbstractFeatureConstrainingNonFunctionalRequirementsEditPart(view);

			case IsConstraintLabelEditPart.VISUAL_ID:
				return new IsConstraintLabelEditPart(view);

			case AbstractFeatureRequieredFeaturesEditPart.VISUAL_ID:
				return new AbstractFeatureRequieredFeaturesEditPart(view);

			case RequieresLabelEditPart.VISUAL_ID:
				return new RequieresLabelEditPart(view);

			case AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID:
				return new AbstractFeatureExcludedFeaturesEditPart(view);

			case ExcludesLabelEditPart.VISUAL_ID:
				return new ExcludesLabelEditPart(view);

			case GoalRealizedFeaturesEditPart.VISUAL_ID:
				return new GoalRealizedFeaturesEditPart(view);

			case MotivatesLabelEditPart.VISUAL_ID:
				return new MotivatesLabelEditPart(view);

			case GoalSubGoalsEditPart.VISUAL_ID:
				return new GoalSubGoalsEditPart(view);

			case IsRefinedLabelEditPart.VISUAL_ID:
				return new IsRefinedLabelEditPart(view);

			case GoalReferenceEditPart.VISUAL_ID:
				return new GoalReferenceEditPart(view);

			case IsDetailedLabel2EditPart.VISUAL_ID:
				return new IsDetailedLabel2EditPart(view);

			case InfluencesLabelEditPart.VISUAL_ID:
				return new InfluencesLabelEditPart(view);

			case GoalReference2EditPart.VISUAL_ID:
				return new GoalReference2EditPart(view);

			case GoalReferenceWeightEditPart.VISUAL_ID:
				return new GoalReferenceWeightEditPart(view);

			case InfluencesLabel2EditPart.VISUAL_ID:
				return new InfluencesLabel2EditPart(view);

			case GoalReference3EditPart.VISUAL_ID:
				return new GoalReference3EditPart(view);

			case GoalReferenceWeight2EditPart.VISUAL_ID:
				return new GoalReferenceWeight2EditPart(view);

			case InfluencesLabel3EditPart.VISUAL_ID:
				return new InfluencesLabel3EditPart(view);

			case GoalReference4EditPart.VISUAL_ID:
				return new GoalReference4EditPart(view);

			case GoalReferenceWeight3EditPart.VISUAL_ID:
				return new GoalReferenceWeight3EditPart(view);

			case InfluencesLabel4EditPart.VISUAL_ID:
				return new InfluencesLabel4EditPart(view);

			case RequirementImplementingServicesEditPart.VISUAL_ID:
				return new RequirementImplementingServicesEditPart(view);

			case IsImplementedLabelEditPart.VISUAL_ID:
				return new IsImplementedLabelEditPart(view);

			case RequirementSubRequirementsEditPart.VISUAL_ID:
				return new RequirementSubRequirementsEditPart(view);

			case IsRefinedLabel5EditPart.VISUAL_ID:
				return new IsRefinedLabel5EditPart(view);

			case MitigationMitigatedDangersEditPart.VISUAL_ID:
				return new MitigationMitigatedDangersEditPart(view);

			case MitigatesLabelEditPart.VISUAL_ID:
				return new MitigatesLabelEditPart(view);

			case DangerHarmedAssetsEditPart.VISUAL_ID:
				return new DangerHarmedAssetsEditPart(view);

			case HarmsLabelEditPart.VISUAL_ID:
				return new HarmsLabelEditPart(view);

			case AssetTriggeredDangersEditPart.VISUAL_ID:
				return new AssetTriggeredDangersEditPart(view);

			case TriggersLabelEditPart.VISUAL_ID:
				return new TriggersLabelEditPart(view);

			case ServiceSubServicesEditPart.VISUAL_ID:
				return new ServiceSubServicesEditPart(view);

			case MotivatesLabel2EditPart.VISUAL_ID:
				return new MotivatesLabel2EditPart(view);

			case VariationPointFeaturesEditPart.VISUAL_ID:
				return new VariationPointFeaturesEditPart(view);

			case CombineLabel2EditPart.VISUAL_ID:
				return new CombineLabel2EditPart(view);

			case VariationPointInstanceVariationPointEditPart.VISUAL_ID:
				return new VariationPointInstanceVariationPointEditPart(view);

			case InstantiateLabelEditPart.VISUAL_ID:
				return new InstantiateLabelEditPart(view);

			case VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID:
				return new VariationPointInstanceSelectedFeaturesEditPart(view);

			case SelectLabelEditPart.VISUAL_ID:
				return new SelectLabelEditPart(view);

			case ProductVariationPointInstancesEditPart.VISUAL_ID:
				return new ProductVariationPointInstancesEditPart(view);

			case CombineLabelEditPart.VISUAL_ID:
				return new CombineLabelEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
