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

			case ServiceProviderEditPart.VISUAL_ID:
				return new ServiceProviderEditPart(view);

			case ServiceProviderNameEditPart.VISUAL_ID:
				return new ServiceProviderNameEditPart(view);

			case StakeholderGoalsEditPart.VISUAL_ID:
				return new StakeholderGoalsEditPart(view);

			case ExpressesLabelEditPart.VISUAL_ID:
				return new ExpressesLabelEditPart(view);

			case FeatureSubFeaturesEditPart.VISUAL_ID:
				return new FeatureSubFeaturesEditPart(view);

			case IsRefinedLabel2EditPart.VISUAL_ID:
				return new IsRefinedLabel2EditPart(view);

			case GoalRealizedFeaturesEditPart.VISUAL_ID:
				return new GoalRealizedFeaturesEditPart(view);

			case MotivatesLabelEditPart.VISUAL_ID:
				return new MotivatesLabelEditPart(view);

			case RequirementImplementingServicesEditPart.VISUAL_ID:
				return new RequirementImplementingServicesEditPart(view);

			case IsImplementedLabelEditPart.VISUAL_ID:
				return new IsImplementedLabelEditPart(view);

			case FeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID:
				return new FeatureDetailingFunctionalRequirementsEditPart(view);

			case IsDetailedLabelEditPart.VISUAL_ID:
				return new IsDetailedLabelEditPart(view);

			case GoalSubGoalsEditPart.VISUAL_ID:
				return new GoalSubGoalsEditPart(view);

			case IsRefinedLabelEditPart.VISUAL_ID:
				return new IsRefinedLabelEditPart(view);

			case FeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID:
				return new FeatureConstrainingNonFunctionalRequirementsEditPart(view);

			case IsConstraintLabelEditPart.VISUAL_ID:
				return new IsConstraintLabelEditPart(view);

			case ServiceServiceProviderEditPart.VISUAL_ID:
				return new ServiceServiceProviderEditPart(view);

			case IsProvidedLabelEditPart.VISUAL_ID:
				return new IsProvidedLabelEditPart(view);

			case MitigationMitigatedDangersEditPart.VISUAL_ID:
				return new MitigationMitigatedDangersEditPart(view);

			case MitigatesLabelEditPart.VISUAL_ID:
				return new MitigatesLabelEditPart(view);

			case DangerHarmedAssetsEditPart.VISUAL_ID:
				return new DangerHarmedAssetsEditPart(view);

			case HarmsLabelEditPart.VISUAL_ID:
				return new HarmsLabelEditPart(view);

			case ActorTriggeredDangersEditPart.VISUAL_ID:
				return new ActorTriggeredDangersEditPart(view);

			case TriggersLabelEditPart.VISUAL_ID:
				return new TriggersLabelEditPart(view);

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
