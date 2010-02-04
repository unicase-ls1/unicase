/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.classDiagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author schroech
 *
 */
public class ModelEditPartFactory extends org.unicase.ui.diagram.classDiagram.edit.parts.ModelEditPartFactory {

	/**
	 * {@inheritDoc}
	 * @see org.unicase.ui.diagram.classDiagram.edit.parts.ModelEditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (!(model instanceof View)) {
			return super.createEditPart(context, model);
		}

		View view = (View) model;
		
		EditPart newEditPart = checkstyleMania1(view);
		if (newEditPart != null) {
			return newEditPart;
		}
		
		return checkstyleMania2(view);
	}

	private EditPart checkstyleMania2(View view) {
		switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
			.getVisualID(view)) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicityEditPart.VISUAL_ID:
			return new org.unicase.ui.tom.classDiagram.edit.parts.AssociationTargetMultiplicityEditPart(
				view);

		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationName2EditPart.VISUAL_ID:
			return new org.unicase.ui.tom.classDiagram.edit.parts.AssociationName2EditPart(
				view);

		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity2EditPart.VISUAL_ID:
			return new org.unicase.ui.tom.classDiagram.edit.parts.AssociationSourceMultiplicity2EditPart(
				view);

		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity2EditPart.VISUAL_ID:
			return new org.unicase.ui.tom.classDiagram.edit.parts.AssociationTargetMultiplicity2EditPart(
				view);

		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationName3EditPart.VISUAL_ID:
			return new org.unicase.ui.tom.classDiagram.edit.parts.AssociationName3EditPart(
				view);

		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity3EditPart.VISUAL_ID:
			return new org.unicase.ui.tom.classDiagram.edit.parts.AssociationSourceMultiplicity3EditPart(
				view);

		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity3EditPart.VISUAL_ID:
			return new org.unicase.ui.tom.classDiagram.edit.parts.AssociationTargetMultiplicity3EditPart(
				view);

		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationName4EditPart.VISUAL_ID:
			return new org.unicase.ui.tom.classDiagram.edit.parts.AssociationName4EditPart(
				view);

		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity4EditPart.VISUAL_ID:
			return new org.unicase.ui.tom.classDiagram.edit.parts.AssociationSourceMultiplicity4EditPart(
				view);

		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity4EditPart.VISUAL_ID:
			return new org.unicase.ui.tom.classDiagram.edit.parts.AssociationTargetMultiplicity4EditPart(
				view);
		default:
			return null;
		}
	}

	private EditPart checkstyleMania1(View view) {
		switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
			.getVisualID(view)) {

			case org.unicase.ui.tom.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
				return new org.unicase.ui.tom.classDiagram.edit.parts.MEDiagramEditPart(
					view);

			case org.unicase.ui.tom.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
				return new org.unicase.ui.tom.classDiagram.edit.parts.ClassEditPart(
					view);

			case org.unicase.ui.tom.classDiagram.edit.parts.PackageEditPart.VISUAL_ID:
				return new org.unicase.ui.tom.classDiagram.edit.parts.PackageEditPart(
					view);

			case org.unicase.ui.tom.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
				return new org.unicase.ui.tom.classDiagram.edit.parts.AssociationEditPart(
					view);

			case org.unicase.ui.tom.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
				return new org.unicase.ui.tom.classDiagram.edit.parts.Association2EditPart(
					view);

			case org.unicase.ui.tom.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
				return new org.unicase.ui.tom.classDiagram.edit.parts.Association3EditPart(
					view);

			case org.unicase.ui.tom.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
				return new org.unicase.ui.tom.classDiagram.edit.parts.Association4EditPart(
					view);

			case org.unicase.ui.tom.classDiagram.edit.parts.ClassSubClassesEditPart.VISUAL_ID:
				return new org.unicase.ui.tom.classDiagram.edit.parts.ClassSubClassesEditPart(
					view);

			case org.unicase.ui.tom.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID:
				return new org.unicase.ui.tom.classDiagram.edit.parts.DependencyEditPart(
					view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationNameEditPart.VISUAL_ID:
				return new org.unicase.ui.tom.classDiagram.edit.parts.AssociationNameEditPart(
					view);

			case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicityEditPart.VISUAL_ID:
				return new org.unicase.ui.tom.classDiagram.edit.parts.AssociationSourceMultiplicityEditPart(
					view);
			default:
				return null;
		}
	}
}
