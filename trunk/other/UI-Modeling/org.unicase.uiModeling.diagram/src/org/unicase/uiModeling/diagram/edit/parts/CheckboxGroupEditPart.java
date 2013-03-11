/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class CheckboxGroupEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2010;

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
	public CheckboxGroupEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
			new org.unicase.uiModeling.diagram.edit.policies.CheckboxGroupItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
			new org.unicase.uiModeling.diagram.edit.policies.OpenDiagramEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
		// editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
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
		return primaryShape = new CheckboxGroupDescriptor();
	}

	/**
	 * @generated
	 */
	public CheckboxGroupDescriptor getPrimaryShape() {
		return (CheckboxGroupDescriptor) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupTextEditPart) {
			((org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupTextEditPart) childEditPart)
				.setLabel(getPrimaryShape().getCheckboxGroup_text());
			return true;
		}
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCheckboxGroup_buttons();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart) childEditPart)
				.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupTextEditPart) {
			return true;
		}
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCheckboxGroup_buttons();
			pane.remove(((org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart) childEditPart)
				.getFigure());
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
		if (editPart instanceof org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart) {
			return getPrimaryShape().getCheckboxGroup_buttons();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part. Body of this method does not depend on settings in generation model so you may
	 * safely remove <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane. Respects layout one may have set for generated
	 * figure.
	 * 
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
		return getChildBySemanticHint(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupTextEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
				.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Checkbox_3007) {
				return getChildBySemanticHint(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class CheckboxGroupDescriptor extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fCheckboxGroup_text;
		/**
		 * @generated
		 */
		private RectangleFigure fCheckboxGroup_buttons;

		/**
		 * @generated
		 */
		public CheckboxGroupDescriptor() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fCheckboxGroup_text = new WrappingLabel();

			fCheckboxGroup_text.setText("My CheckboxGroup");

			GridData constraintFCheckboxGroup_text = new GridData();
			constraintFCheckboxGroup_text.verticalAlignment = GridData.BEGINNING;
			constraintFCheckboxGroup_text.horizontalAlignment = GridData.FILL;
			constraintFCheckboxGroup_text.horizontalIndent = 0;
			constraintFCheckboxGroup_text.horizontalSpan = 1;
			constraintFCheckboxGroup_text.verticalSpan = 1;
			constraintFCheckboxGroup_text.grabExcessHorizontalSpace = true;
			constraintFCheckboxGroup_text.grabExcessVerticalSpace = false;
			this.add(fCheckboxGroup_text, constraintFCheckboxGroup_text);

			fCheckboxGroup_buttons = new RectangleFigure();

			fCheckboxGroup_buttons.setOutline(false);

			GridData constraintFCheckboxGroup_buttons = new GridData();
			constraintFCheckboxGroup_buttons.verticalAlignment = GridData.FILL;
			constraintFCheckboxGroup_buttons.horizontalAlignment = GridData.FILL;
			constraintFCheckboxGroup_buttons.horizontalIndent = 0;
			constraintFCheckboxGroup_buttons.horizontalSpan = 1;
			constraintFCheckboxGroup_buttons.verticalSpan = 1;
			constraintFCheckboxGroup_buttons.grabExcessHorizontalSpace = true;
			constraintFCheckboxGroup_buttons.grabExcessVerticalSpace = true;
			this.add(fCheckboxGroup_buttons, constraintFCheckboxGroup_buttons);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getCheckboxGroup_text() {
			return fCheckboxGroup_text;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getCheckboxGroup_buttons() {
			return fCheckboxGroup_buttons;
		}

	}

}
