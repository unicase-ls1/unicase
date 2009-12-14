/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
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
public class ActorEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

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
	public ActorEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.ui.diagram.usecaseDiagram.edit.policies.ActorItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that
		// would let children add reasonable editpolicies
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
		ActorFigure figure = new ActorFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ActorFigure getPrimaryShape() {
		return (ActorFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ActorNameEditPart) {
			((ActorNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureActorFigure_name());
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

		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(40), getMapMode().DPtoLP(40));
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
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
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class ActorFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private Label fFigureActorFigure_name;

		/**
		 * @generated
		 */
		public ActorFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginWidth = 0;
			layoutThis.marginHeight = 0;
			this.setLayoutManager(layoutThis);

			this.setOutline(false);
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(10),
					getMapMode().DPtoLP(10)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			org.unicase.ui.diagram.usecaseDiagram.unicase.StickMan actorFigure0 = new org.unicase.ui.diagram.usecaseDiagram.unicase.StickMan();

			GridData constraintActorFigure0 = new GridData();
			constraintActorFigure0.verticalAlignment = GridData.FILL;
			constraintActorFigure0.horizontalAlignment = GridData.FILL;
			constraintActorFigure0.horizontalIndent = 0;
			constraintActorFigure0.horizontalSpan = 1;
			constraintActorFigure0.verticalSpan = 1;
			constraintActorFigure0.grabExcessHorizontalSpace = true;
			constraintActorFigure0.grabExcessVerticalSpace = true;
			this.add(actorFigure0, constraintActorFigure0);

			fFigureActorFigure_name = new Label();

			fFigureActorFigure_name.setFont(FFIGUREACTORFIGURE_NAME_FONT);

			GridData constraintFFigureActorFigure_name = new GridData();
			constraintFFigureActorFigure_name.verticalAlignment = GridData.CENTER;
			constraintFFigureActorFigure_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureActorFigure_name.horizontalIndent = 0;
			constraintFFigureActorFigure_name.horizontalSpan = 1;
			constraintFFigureActorFigure_name.verticalSpan = 1;
			constraintFFigureActorFigure_name.grabExcessHorizontalSpace = false;
			constraintFFigureActorFigure_name.grabExcessVerticalSpace = false;
			this
					.add(fFigureActorFigure_name,
							constraintFFigureActorFigure_name);

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
		public Label getFigureActorFigure_name() {
			return fFigureActorFigure_name;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREACTORFIGURE_NAME_FONT = new Font(Display
			.getCurrent(), "Arial", 12, SWT.BOLD);

}
