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
public class RadioGroupEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2009;

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
	public RadioGroupEditPart(View view) {
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
			new org.unicase.uiModeling.diagram.edit.policies.RadioGroupItemSemanticEditPolicy());
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
		return primaryShape = new RadioGroupDescriptor();
	}

	/**
	 * @generated
	 */
	public RadioGroupDescriptor getPrimaryShape() {
		return (RadioGroupDescriptor) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.RadioGroupTextEditPart) {
			((org.unicase.uiModeling.diagram.edit.parts.RadioGroupTextEditPart) childEditPart)
				.setLabel(getPrimaryShape().getRadioGroup_text());
			return true;
		}
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getRadioGroup_buttons();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart) childEditPart)
				.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.RadioGroupTextEditPart) {
			return true;
		}
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getRadioGroup_buttons();
			pane.remove(((org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart) childEditPart)
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
		if (editPart instanceof org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart) {
			return getPrimaryShape().getRadioGroup_buttons();
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
			.getType(org.unicase.uiModeling.diagram.edit.parts.RadioGroupTextEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
				.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioButton_3006) {
				return getChildBySemanticHint(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class RadioGroupDescriptor extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fRadioGroup_text;
		/**
		 * @generated
		 */
		private RectangleFigure fRadioGroup_buttons;

		/**
		 * @generated
		 */
		public RadioGroupDescriptor() {

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

			fRadioGroup_text = new WrappingLabel();

			fRadioGroup_text.setText("My RadioGroup");

			GridData constraintFRadioGroup_text = new GridData();
			constraintFRadioGroup_text.verticalAlignment = GridData.BEGINNING;
			constraintFRadioGroup_text.horizontalAlignment = GridData.FILL;
			constraintFRadioGroup_text.horizontalIndent = 0;
			constraintFRadioGroup_text.horizontalSpan = 1;
			constraintFRadioGroup_text.verticalSpan = 1;
			constraintFRadioGroup_text.grabExcessHorizontalSpace = true;
			constraintFRadioGroup_text.grabExcessVerticalSpace = false;
			this.add(fRadioGroup_text, constraintFRadioGroup_text);

			fRadioGroup_buttons = new RectangleFigure();

			fRadioGroup_buttons.setOutline(false);

			GridData constraintFRadioGroup_buttons = new GridData();
			constraintFRadioGroup_buttons.verticalAlignment = GridData.FILL;
			constraintFRadioGroup_buttons.horizontalAlignment = GridData.FILL;
			constraintFRadioGroup_buttons.horizontalIndent = 0;
			constraintFRadioGroup_buttons.horizontalSpan = 1;
			constraintFRadioGroup_buttons.verticalSpan = 1;
			constraintFRadioGroup_buttons.grabExcessHorizontalSpace = true;
			constraintFRadioGroup_buttons.grabExcessVerticalSpace = true;
			this.add(fRadioGroup_buttons, constraintFRadioGroup_buttons);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getRadioGroup_text() {
			return fRadioGroup_text;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getRadioGroup_buttons() {
			return fRadioGroup_buttons;
		}

	}

}
