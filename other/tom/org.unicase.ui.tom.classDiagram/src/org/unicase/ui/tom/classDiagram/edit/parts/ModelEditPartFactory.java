package org.unicase.ui.tom.classDiagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

public class ModelEditPartFactory extends org.unicase.ui.diagram.classDiagram.edit.parts.ModelEditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
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
			}
		}
		return super.createEditPart(context, model);
	}
}
