/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.componentDiagram.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
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
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.unicase.ui.unicasecommon.diagram.figures.Label;

/**
 * @generated
 */
public class ComponentEditPart extends ShapeNodeEditPart {

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
	public ComponentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
			new org.unicase.ui.diagram.componentDiagram.edit.policies.ComponentItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
		// editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			@Override
			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			@Override
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
		ComponentFigure figure = new ComponentFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ComponentFigure getPrimaryShape() {
		return (ComponentFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ComponentNameEditPart) {
			((ComponentNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureComponentFigure_name());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

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
	 * @generated
	 */
	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(100), getMapMode().DPtoLP(40));
		return result;
	}

	/**
	 * Creates figure for this edit part. Body of this method does not depend on settings in generation model so you may
	 * safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	@Override
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects layout one may have set for generated
	 * figure.
	 * 
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	@Override
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
			.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class ComponentFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private Label fFigureComponentFigure_name;

		/**
		 * @generated
		 */
		public ComponentFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setForegroundColor(ColorConstants.black);
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5),
				getMapMode().DPtoLP(5)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			Figure header0 = new Figure();

			this.add(header0, BorderLayout.TOP);
			header0.setLayoutManager(new StackLayout());

			Label componentText1 = new Label();

			componentText1.setText("\u00ABcomponent\u00BB");

			header0.add(componentText1);

			Figure iconContainer1 = new Figure();

			header0.add(iconContainer1);

			BorderLayout layoutIconContainer1 = new BorderLayout();
			iconContainer1.setLayoutManager(layoutIconContainer1);

			org.unicase.ui.diagram.componentDiagram.unicase.ComponentIcon componentIcon2 = new org.unicase.ui.diagram.componentDiagram.unicase.ComponentIcon();

			componentIcon2.setSize(getMapMode().DPtoLP(20), getMapMode().DPtoLP(22));

			iconContainer1.add(componentIcon2, BorderLayout.RIGHT);

			Figure fig0 = new Figure();

			this.add(fig0, BorderLayout.CENTER);

			org.unicase.ui.diagram.componentDiagram.unicase.CenterLayoutParent layoutFig0 = new org.unicase.ui.diagram.componentDiagram.unicase.CenterLayoutParent();

			fig0.setLayoutManager(layoutFig0);

			fFigureComponentFigure_name = new Label();

			fFigureComponentFigure_name.setFont(FFIGURECOMPONENTFIGURE_NAME_FONT);

			fig0.add(fFigureComponentFigure_name);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		@Override
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
		public Label getFigureComponentFigure_name() {
			return fFigureComponentFigure_name;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGURECOMPONENTFIGURE_NAME_FONT = new Font(Display.getCurrent(), "Arial", 12, SWT.BOLD);

}
