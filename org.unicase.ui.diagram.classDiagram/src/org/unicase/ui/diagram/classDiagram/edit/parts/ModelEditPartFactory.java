/*
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 *   accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.edit.parts;

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
			switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(view)) {

			case org.unicase.ui.diagram.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.MEDiagramEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.ClassNameEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.ClassNameEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.PackageEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.PackageEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.PackageNameEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.PackageNameEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_attributesEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_methodsEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTypeEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTypeEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicityEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicityEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicityEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicityEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationType2EditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AssociationType2EditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity2EditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity2EditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity2EditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity2EditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationType3EditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AssociationType3EditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity3EditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity3EditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity3EditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity3EditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationType4EditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AssociationType4EditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity4EditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity4EditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity4EditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity4EditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.ClassSuperClassesEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.ClassSuperClassesEditPart(
						view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID:
				return new org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart(
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
