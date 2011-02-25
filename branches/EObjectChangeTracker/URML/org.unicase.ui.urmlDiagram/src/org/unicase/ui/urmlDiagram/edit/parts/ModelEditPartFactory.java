package org.unicase.ui.urmlDiagram.edit.parts;

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

/**
 * @generated
 */
public class ModelEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
					.getVisualID(view)) {

			case org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.MEDiagramEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.HazardCauseEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseNameEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.HazardCauseNameEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.MitigationEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.MitigationEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.MitigationNameEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.MitigationNameEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.HazardEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.HazardNameEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.HazardNameEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.ActorEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.ActorEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.ActorNameEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.ActorNameEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.UseCaseEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.UseCaseNameEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.UseCaseNameEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementNameEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementNameEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.ActorParticipatedUseCasesEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.ParticipateLabelEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.ParticipateLabelEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.ActorInitiatedUseCasesEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.InitiateLabelEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.InitiateLabelEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.UseCaseIncludedUseCasesEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.IncludeLabelEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.IncludeLabelEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.UseCaseExtendedUseCasesEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.IncludeLabel2EditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.IncludeLabel2EditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.MitigationHazardsEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.MitigationHazardsEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.MitigateLabelEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.MitigateLabelEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.MitigationCausesEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.MitigationCausesEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.MitigateLabel2EditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.MitigateLabel2EditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementRefinedRequirementEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementRefinedRequirementEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.RefineLabelEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.RefineLabelEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementMitigationsEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementMitigationsEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.MitigateLabel3EditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.MitigateLabel3EditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.ActorHazardsEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.ActorHazardsEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.MitigateLabel4EditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.MitigateLabel4EditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseHazardsEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.HazardCauseHazardsEditPart(
						view);

			case org.unicase.ui.urmlDiagram.edit.parts.CauseLabelEditPart.VISUAL_ID:
				return new org.unicase.ui.urmlDiagram.edit.parts.CauseLabelEditPart(
						view);
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
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
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
			if (getWrapLabel().isTextWrapOn()
					&& getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width,
						SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
						SWT.DEFAULT)).expand(avr * 2, 0));
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
			int avr = FigureUtilities.getFontMetrics(text.getFont())
					.getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
					SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
