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

			case GoalEditPart.VISUAL_ID:
				return new GoalEditPart(view);

			case FunctionalRequirementEditPart.VISUAL_ID:
				return new FunctionalRequirementEditPart(view);

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

			case Stakeholder2EditPart.VISUAL_ID:
				return new Stakeholder2EditPart(view);

			case FeatureParentFeatureEditPart.VISUAL_ID:
				return new FeatureParentFeatureEditPart(view);

			case StakeholderGoalsEditPart.VISUAL_ID:
				return new StakeholderGoalsEditPart(view);

			case GoalRealizedFeaturesEditPart.VISUAL_ID:
				return new GoalRealizedFeaturesEditPart(view);

			case RequirementImplementingServicesEditPart.VISUAL_ID:
				return new RequirementImplementingServicesEditPart(view);

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
