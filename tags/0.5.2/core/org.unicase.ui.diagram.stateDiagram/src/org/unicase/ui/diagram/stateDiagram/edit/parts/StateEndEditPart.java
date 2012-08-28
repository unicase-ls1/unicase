/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.stateDiagram.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.unicase.ui.unicasecommon.diagram.figures.CenterLayout;

/**
 * @generated
 */
public class StateEndEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2003;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public StateEndEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.ui.diagram.stateDiagram.edit.policies.StateEndItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		StateFinalFigure figure = new StateFinalFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public StateFinalFigure getPrimaryShape() {
		return (StateFinalFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(23, 23);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types
				.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof org.unicase.ui.diagram.stateDiagram.edit.parts.StateEditPart) {
			types
					.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof org.unicase.ui.diagram.stateDiagram.edit.parts.StateInitialEditPart) {
			types
					.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof org.unicase.ui.diagram.stateDiagram.edit.parts.StateEndEditPart) {
			types
					.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.State_2001);
		}
		if (relationshipType == org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.StateInitial_2002);
		}
		if (relationshipType == org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.StateEnd_2003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types
				.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.State_2001);
		}
		if (relationshipType == org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.StateInitial_2002);
		}
		if (relationshipType == org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.StateEnd_2003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class StateFinalFigure extends Ellipse {

		/**
		 * @generated
		 */
		public StateFinalFigure() {

			CenterLayout layoutThis = new CenterLayout();

			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			this.setForegroundColor(ColorConstants.black);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(23),
					getMapMode().DPtoLP(23)));
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(23),
					getMapMode().DPtoLP(23)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(23),
					getMapMode().DPtoLP(23)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			Ellipse stateFinalFigure_inner0 = new Ellipse();
			stateFinalFigure_inner0.setLineWidth(1);
			stateFinalFigure_inner0.setBackgroundColor(ColorConstants.black);
			stateFinalFigure_inner0.setPreferredSize(new Dimension(getMapMode()
					.DPtoLP(15), getMapMode().DPtoLP(15)));
			stateFinalFigure_inner0.setMaximumSize(new Dimension(getMapMode()
					.DPtoLP(15), getMapMode().DPtoLP(15)));
			stateFinalFigure_inner0.setMinimumSize(new Dimension(getMapMode()
					.DPtoLP(15), getMapMode().DPtoLP(15)));

			this.add(stateFinalFigure_inner0);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

	}

}
