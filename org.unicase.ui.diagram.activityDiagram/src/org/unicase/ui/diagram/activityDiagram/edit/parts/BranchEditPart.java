/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.activityDiagram.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
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
public class BranchEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2006;

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
	public BranchEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.ui.diagram.activityDiagram.edit.policies.BranchItemSemanticEditPolicy());
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
		BranchFigure figure = new BranchFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public BranchFigure getPrimaryShape() {
		return (BranchFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
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
	public class BranchFigure extends Shape {

		/**
		 * @generated
		 */
		public BranchFigure() {
			this.addPoint(new Point(getMapMode().DPtoLP(20), getMapMode()
					.DPtoLP(0)));
			this.addPoint(new Point(getMapMode().DPtoLP(40), getMapMode()
					.DPtoLP(20)));
			this.addPoint(new Point(getMapMode().DPtoLP(20), getMapMode()
					.DPtoLP(40)));
			this.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode()
					.DPtoLP(20)));
			this.setFill(true);
			this.setLineWidth(1);
			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(ColorConstants.lightGray);
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(10),
					getMapMode().DPtoLP(10)));
		}

		/**
		 * @generated
		 */
		private final PointList myTemplate = new PointList();
		/**
		 * @generated
		 */
		private Rectangle myTemplateBounds;

		/**
		 * @generated
		 */
		public void addPoint(Point point) {
			myTemplate.addPoint(point);
			myTemplateBounds = null;
		}

		/**
		 * @generated
		 */
		protected void fillShape(Graphics graphics) {
			Rectangle bounds = getBounds();
			graphics.pushState();
			graphics.translate(bounds.x, bounds.y);
			graphics.fillPolygon(scalePointList());
			graphics.popState();
		}

		/**
		 * @generated
		 */
		protected void outlineShape(Graphics graphics) {
			Rectangle bounds = getBounds();
			graphics.pushState();
			graphics.translate(bounds.x, bounds.y);
			graphics.drawPolygon(scalePointList());
			graphics.popState();
		}

		/**
		 * @generated
		 */
		private Rectangle getTemplateBounds() {
			if (myTemplateBounds == null) {
				myTemplateBounds = myTemplate.getBounds().getCopy().union(0, 0);
				//just safety -- we are going to use this as divider 
				if (myTemplateBounds.width < 1) {
					myTemplateBounds.width = 1;
				}
				if (myTemplateBounds.height < 1) {
					myTemplateBounds.height = 1;
				}
			}
			return myTemplateBounds;
		}

		/**
		 * @generated
		 */
		private int[] scalePointList() {
			Rectangle pointsBounds = getTemplateBounds();
			Rectangle actualBounds = getBounds();

			float xScale = ((float) actualBounds.width) / pointsBounds.width;
			float yScale = ((float) actualBounds.height) / pointsBounds.height;

			if (xScale == 1 && yScale == 1) {
				return myTemplate.toIntArray();
			}
			int[] scaled = (int[]) myTemplate.toIntArray().clone();
			for (int i = 0; i < scaled.length; i += 2) {
				scaled[i] = (int) Math.floor(scaled[i] * xScale);
				scaled[i + 1] = (int) Math.floor(scaled[i + 1] * yScale);
			}
			return scaled;
		}

	}

}
