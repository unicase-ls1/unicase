/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.stateDiagram.edit.parts;

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
			switch (org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
					.getVisualID(view)) {

			case org.unicase.ui.diagram.stateDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.stateDiagram.edit.parts.MEDiagramEditPart(
						view);

			case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.stateDiagram.edit.parts.StateEditPart(
						view);

			case org.unicase.ui.diagram.stateDiagram.edit.parts.StateNameEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.stateDiagram.edit.parts.StateNameEditPart(
						view);

			case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEntryConditionsEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.stateDiagram.edit.parts.StateEntryConditionsEditPart(
						view);

			case org.unicase.ui.diagram.stateDiagram.edit.parts.StateActivitiesEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.stateDiagram.edit.parts.StateActivitiesEditPart(
						view);

			case org.unicase.ui.diagram.stateDiagram.edit.parts.StateExitConditionsEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.stateDiagram.edit.parts.StateExitConditionsEditPart(
						view);

			case org.unicase.ui.diagram.stateDiagram.edit.parts.StateInitialEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.stateDiagram.edit.parts.StateInitialEditPart(
						view);

			case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEndEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.stateDiagram.edit.parts.StateEndEditPart(
						view);

			case org.unicase.ui.diagram.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.stateDiagram.edit.parts.TransitionEditPart(
						view);

			case org.unicase.ui.diagram.stateDiagram.edit.parts.TransitionConditionNameEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.stateDiagram.edit.parts.TransitionConditionNameEditPart(
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
