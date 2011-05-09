/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
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
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.unicase.ui.unicasecommon.diagram.figures.CenterLayout;
import org.unicase.ui.unicasecommon.diagram.figures.Label;

/**
 * @generated
 */
public class UseCaseEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2002;

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
	public UseCaseEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.ui.diagram.usecaseDiagram.edit.policies.UseCaseItemSemanticEditPolicy());
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
		UseCaseFigure figure = new UseCaseFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public UseCaseFigure getPrimaryShape() {
		return (UseCaseFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseNameEditPart) {
			((org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getUseCaseFigure_name());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseNameEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(140, 60);
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
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types
				.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003);
		types
				.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart) {
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003);
		}
		if (targetEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart) {
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003) {
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002);
		}
		if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004) {
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types
				.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001);
		types
				.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4002);
		types
				.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003);
		types
				.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001) {
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.Actor_2001);
		}
		if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4002) {
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.Actor_2001);
		}
		if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003) {
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002);
		}
		if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004) {
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class UseCaseFigure extends Ellipse {

		/**
		 * @generated
		 */
		private Label fUseCaseFigure_name;

		/**
		 * @generated
		 */
		public UseCaseFigure() {

			CenterLayout layoutThis = new CenterLayout();

			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			this.setForegroundColor(ColorConstants.black);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fUseCaseFigure_name = new Label();

			fUseCaseFigure_name.setFont(FUSECASEFIGURE_NAME_FONT);

			this.add(fUseCaseFigure_name);

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

		/**
		 * @generated
		 */
		public Label getUseCaseFigure_name() {
			return fUseCaseFigure_name;
		}

	}

	/**
	 * @generated
	 */
	static final Font FUSECASEFIGURE_NAME_FONT = new Font(Display.getCurrent(),
			"Arial", 12, SWT.BOLD);

}
