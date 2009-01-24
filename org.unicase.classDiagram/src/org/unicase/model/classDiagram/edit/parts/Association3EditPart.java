/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.classDiagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.unicase.model.classes.Association;

/**
 * @generated
 */
public class Association3EditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4003;

	/**
	 * @generated
	 */
	public Association3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.model.classDiagram.edit.policies.Association3ItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.model.classDiagram.edit.parts.AssociationName3EditPart) {
			((org.unicase.model.classDiagram.edit.parts.AssociationName3EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureAssociationFigure_name());
			return true;
		}
		if (childEditPart instanceof org.unicase.model.classDiagram.edit.parts.AssociationSourceMultiplicity3EditPart) {
			((org.unicase.model.classDiagram.edit.parts.AssociationSourceMultiplicity3EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureAssociationFigure_sourceMultiplicity());
			return true;
		}
		if (childEditPart instanceof org.unicase.model.classDiagram.edit.parts.AssociationTargetMultiplicity3EditPart) {
			((org.unicase.model.classDiagram.edit.parts.AssociationTargetMultiplicity3EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureAssociationFigure_targetMultiplicity());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	@Override
	protected Connection createConnectionFigure() {
		return new AssociationFigure();
	}

	/**
	 * @generated
	 */
	public AssociationFigure getPrimaryShape() {
		return (AssociationFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class AssociationFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureAssociationFigure_name;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureAssociationFigure_sourceMultiplicity;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureAssociationFigure_targetMultiplicity;

		/**
		 * @generated
		 */
		public AssociationFigure() {

			createContents();
			setSourceDecoration(createSourceDecoration());
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureAssociationFigure_name = new WrappingLabel();
			fFigureAssociationFigure_name.setText("unnamed");

			this.add(fFigureAssociationFigure_name);

			fFigureAssociationFigure_targetMultiplicity = new WrappingLabel();
			fFigureAssociationFigure_targetMultiplicity.setText("1");

			this.add(fFigureAssociationFigure_targetMultiplicity);

			fFigureAssociationFigure_sourceMultiplicity = new WrappingLabel();
			fFigureAssociationFigure_sourceMultiplicity.setText("1");

			this.add(fFigureAssociationFigure_sourceMultiplicity);

		}

		/**
		 * @generated NOT
		 * 
		 * @return The source decoration
		 */
		private RotatableDecoration createSourceDecoration() {
			org.unicase.model.classDiagram.unicase.AssociationDecoration df;
			Object object = getModel();
			if (object instanceof EdgeImpl) {
				EdgeImpl edgeImpl = (EdgeImpl) object;
				object = edgeImpl.getElement();
			}
			if (object instanceof Association) {
				Association association = (Association) object;
				df = new org.unicase.model.classDiagram.unicase.AssociationDecoration(
						association, true);
			} else {
				throw new IllegalArgumentException();
			}

			return df;
		}

		/**
		 * @generated NOT
		 * 
		 * @return The target decoration
		 */
		private RotatableDecoration createTargetDecoration() {
			org.unicase.model.classDiagram.unicase.AssociationDecoration df;
			Object object = getModel();
			if (object instanceof EdgeImpl) {
				EdgeImpl edgeImpl = (EdgeImpl) object;
				object = edgeImpl.getElement();
			}
			if (object instanceof Association) {
				Association association = (Association) object;
				df = new org.unicase.model.classDiagram.unicase.AssociationDecoration(
						association, false);
			} else {
				throw new IllegalArgumentException();
			}

			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureAssociationFigure_name() {
			return fFigureAssociationFigure_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureAssociationFigure_sourceMultiplicity() {
			return fFigureAssociationFigure_sourceMultiplicity;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureAssociationFigure_targetMultiplicity() {
			return fFigureAssociationFigure_targetMultiplicity;
		}

	}

}
