package scrm.diagram.edit.parts;

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

import scrm.diagram.part.ScrmVisualIDRegistry;

/**
 * @generated
 */
public class ScrmEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (ScrmVisualIDRegistry.getVisualID(view)) {

			case SCRMDiagramEditPart.VISUAL_ID:
				return new SCRMDiagramEditPart(view);

			case ScientificProblemEditPart.VISUAL_ID:
				return new ScientificProblemEditPart(view);

			case ScientificProblemNameEditPart.VISUAL_ID:
				return new ScientificProblemNameEditPart(view);

			case ScientificProblemDescriptionEditPart.VISUAL_ID:
				return new ScientificProblemDescriptionEditPart(view);

			case MathematicalModelEditPart.VISUAL_ID:
				return new MathematicalModelEditPart(view);

			case MathematicalModelDescriptionNameEditPart.VISUAL_ID:
				return new MathematicalModelDescriptionNameEditPart(view);

			case NumericalMethodEditPart.VISUAL_ID:
				return new NumericalMethodEditPart(view);

			case NumericalMethodDescriptionNameEditPart.VISUAL_ID:
				return new NumericalMethodDescriptionNameEditPart(view);

			case AssumptionEditPart.VISUAL_ID:
				return new AssumptionEditPart(view);

			case AssumptionDescriptionNameEditPart.VISUAL_ID:
				return new AssumptionDescriptionNameEditPart(view);

			case FeatureEditPart.VISUAL_ID:
				return new FeatureEditPart(view);

			case FeatureDescriptionNameEditPart.VISUAL_ID:
				return new FeatureDescriptionNameEditPart(view);

			case HardwareEditPart.VISUAL_ID:
				return new HardwareEditPart(view);

			case HardwareDescriptionNameEditPart.VISUAL_ID:
				return new HardwareDescriptionNameEditPart(view);

			case ConstraintEditPart.VISUAL_ID:
				return new ConstraintEditPart(view);

			case ConstraintDescriptionNameEditPart.VISUAL_ID:
				return new ConstraintDescriptionNameEditPart(view);

			case UserInterfaceEditPart.VISUAL_ID:
				return new UserInterfaceEditPart(view);

			case UserInterfaceDescriptionNameEditPart.VISUAL_ID:
				return new UserInterfaceDescriptionNameEditPart(view);

			case SoftwareInterfaceEditPart.VISUAL_ID:
				return new SoftwareInterfaceEditPart(view);

			case SoftwareInterfaceDescriptionNameEditPart.VISUAL_ID:
				return new SoftwareInterfaceDescriptionNameEditPart(view);

			case ProcessEditPart.VISUAL_ID:
				return new ProcessEditPart(view);

			case ProcessDescriptionNameEditPart.VISUAL_ID:
				return new ProcessDescriptionNameEditPart(view);

			case PerformanceEditPart.VISUAL_ID:
				return new PerformanceEditPart(view);

			case PerformanceDescriptionNameEditPart.VISUAL_ID:
				return new PerformanceDescriptionNameEditPart(view);

			case DataFlowEditPart.VISUAL_ID:
				return new DataFlowEditPart(view);

			case DataFlowDescriptionNameEditPart.VISUAL_ID:
				return new DataFlowDescriptionNameEditPart(view);

			case DataDefinitionEditPart.VISUAL_ID:
				return new DataDefinitionEditPart(view);

			case DataDefinitionDescriptionNameEditPart.VISUAL_ID:
				return new DataDefinitionDescriptionNameEditPart(view);

			case InputDataReadingEditPart.VISUAL_ID:
				return new InputDataReadingEditPart(view);

			case InputDataReadingDescriptionNameEditPart.VISUAL_ID:
				return new InputDataReadingDescriptionNameEditPart(view);

			case DataHandlingEditPart.VISUAL_ID:
				return new DataHandlingEditPart(view);

			case DataHandlingDescriptionNameEditPart.VISUAL_ID:
				return new DataHandlingDescriptionNameEditPart(view);

			case ResultsOutputEditPart.VISUAL_ID:
				return new ResultsOutputEditPart(view);

			case ResultsOutputDescriptionNameEditPart.VISUAL_ID:
				return new ResultsOutputDescriptionNameEditPart(view);

			case ErrorHandlingEditPart.VISUAL_ID:
				return new ErrorHandlingEditPart(view);

			case ErrorHandlingDescriptionNameEditPart.VISUAL_ID:
				return new ErrorHandlingDescriptionNameEditPart(view);

			case StatusMonitoringEditPart.VISUAL_ID:
				return new StatusMonitoringEditPart(view);

			case StatusMonitoringDescriptionNameEditPart.VISUAL_ID:
				return new StatusMonitoringDescriptionNameEditPart(view);

			case ScientificKnowledgeRequirementsEditPart.VISUAL_ID:
				return new ScientificKnowledgeRequirementsEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case ScientificProblemRepresentingModelEditPart.VISUAL_ID:
				return new ScientificProblemRepresentingModelEditPart(view);

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			case ScientificProblemSolvingMethodEditPart.VISUAL_ID:
				return new ScientificProblemSolvingMethodEditPart(view);

			case WrappingLabel3EditPart.VISUAL_ID:
				return new WrappingLabel3EditPart(view);

			case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
				return new ScientificProblemInfluencedFeatureEditPart(view);

			case WrappingLabel4EditPart.VISUAL_ID:
				return new WrappingLabel4EditPart(view);

			case MathematicalModel2EditPart.VISUAL_ID:
				return new MathematicalModel2EditPart(view);

			case WrappingLabel5EditPart.VISUAL_ID:
				return new WrappingLabel5EditPart(view);

			case MathematicalModel3EditPart.VISUAL_ID:
				return new MathematicalModel3EditPart(view);

			case WrappingLabel6EditPart.VISUAL_ID:
				return new WrappingLabel6EditPart(view);

			case MathematicalModelNumericalMethodsEditPart.VISUAL_ID:
				return new MathematicalModelNumericalMethodsEditPart(view);

			case WrappingLabel7EditPart.VISUAL_ID:
				return new WrappingLabel7EditPart(view);

			case MathematicalModelDependenciesEditPart.VISUAL_ID:
				return new MathematicalModelDependenciesEditPart(view);

			case WrappingLabel8EditPart.VISUAL_ID:
				return new WrappingLabel8EditPart(view);

			case NumericalMethodDependenciesEditPart.VISUAL_ID:
				return new NumericalMethodDependenciesEditPart(view);

			case WrappingLabel9EditPart.VISUAL_ID:
				return new WrappingLabel9EditPart(view);

			case NumericalMethodRealizingRequirementEditPart.VISUAL_ID:
				return new NumericalMethodRealizingRequirementEditPart(view);

			case WrappingLabel10EditPart.VISUAL_ID:
				return new WrappingLabel10EditPart(view);

			case NumericalMethodPerformanceEditPart.VISUAL_ID:
				return new NumericalMethodPerformanceEditPart(view);

			case WrappingLabel11EditPart.VISUAL_ID:
				return new WrappingLabel11EditPart(view);

			case FeatureRequiredInterfacesEditPart.VISUAL_ID:
				return new FeatureRequiredInterfacesEditPart(view);

			case WrappingLabel12EditPart.VISUAL_ID:
				return new WrappingLabel12EditPart(view);

			case FeatureProvidedInterfacesEditPart.VISUAL_ID:
				return new FeatureProvidedInterfacesEditPart(view);

			case WrappingLabel13EditPart.VISUAL_ID:
				return new WrappingLabel13EditPart(view);

			case FeatureConstraintsEditPart.VISUAL_ID:
				return new FeatureConstraintsEditPart(view);

			case WrappingLabel14EditPart.VISUAL_ID:
				return new WrappingLabel14EditPart(view);

			case FeatureDependenciesEditPart.VISUAL_ID:
				return new FeatureDependenciesEditPart(view);

			case WrappingLabel15EditPart.VISUAL_ID:
				return new WrappingLabel15EditPart(view);

			case FeatureDetailedRequirementsEditPart.VISUAL_ID:
				return new FeatureDetailedRequirementsEditPart(view);

			case WrappingLabel16EditPart.VISUAL_ID:
				return new WrappingLabel16EditPart(view);

			case Feature2EditPart.VISUAL_ID:
				return new Feature2EditPart(view);

			case WrappingLabel17EditPart.VISUAL_ID:
				return new WrappingLabel17EditPart(view);

			case FeatureRequiredFeaturesEditPart.VISUAL_ID:
				return new FeatureRequiredFeaturesEditPart(view);

			case WrappingLabel18EditPart.VISUAL_ID:
				return new WrappingLabel18EditPart(view);

			case FeatureExcludedFeaturesEditPart.VISUAL_ID:
				return new FeatureExcludedFeaturesEditPart(view);

			case WrappingLabel19EditPart.VISUAL_ID:
				return new WrappingLabel19EditPart(view);

			case RequirementEditPart.VISUAL_ID:
				return new RequirementEditPart(view);

			case WrappingLabel20EditPart.VISUAL_ID:
				return new WrappingLabel20EditPart(view);

			case RequirementDefiningDataEditPart.VISUAL_ID:
				return new RequirementDefiningDataEditPart(view);

			case WrappingLabel21EditPart.VISUAL_ID:
				return new WrappingLabel21EditPart(view);

			case ProcessDataFlowEditPart.VISUAL_ID:
				return new ProcessDataFlowEditPart(view);

			case WrappingLabel22EditPart.VISUAL_ID:
				return new WrappingLabel22EditPart(view);

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
