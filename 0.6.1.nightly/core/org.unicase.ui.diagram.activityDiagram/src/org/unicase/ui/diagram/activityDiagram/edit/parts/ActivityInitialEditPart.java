/*
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 *   accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.activityDiagram.edit.parts;

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

/**
 * @generated
 */
public class ActivityInitialEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2004;

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
	public ActivityInitialEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.ui.diagram.activityDiagram.edit.policies.ActivityInitialItemSemanticEditPolicy());
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
		ActivityInitialFigure figure = new ActivityInitialFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ActivityInitialFigure getPrimaryShape() {
		return (ActivityInitialFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(15, 15);
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
				.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEditPart) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof org.unicase.ui.diagram.activityDiagram.edit.parts.ForkEditPart) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityInitialEditPart) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEndEditPart) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof org.unicase.ui.diagram.activityDiagram.edit.parts.BranchEditPart) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Activity_2002);
		}
		if (relationshipType == org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Fork_2003);
		}
		if (relationshipType == org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.ActivityInitial_2004);
		}
		if (relationshipType == org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.ActivityEnd_2005);
		}
		if (relationshipType == org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Branch_2006);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types
				.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Activity_2002);
		}
		if (relationshipType == org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Fork_2003);
		}
		if (relationshipType == org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.ActivityInitial_2004);
		}
		if (relationshipType == org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.ActivityEnd_2005);
		}
		if (relationshipType == org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001) {
			types
					.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Branch_2006);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class ActivityInitialFigure extends Ellipse {

		/**
		 * @generated
		 */
		public ActivityInitialFigure() {
			this.setLineWidth(1);
			this.setBackgroundColor(ColorConstants.black);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(15),
					getMapMode().DPtoLP(15)));
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(15),
					getMapMode().DPtoLP(15)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(15),
					getMapMode().DPtoLP(15)));
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
