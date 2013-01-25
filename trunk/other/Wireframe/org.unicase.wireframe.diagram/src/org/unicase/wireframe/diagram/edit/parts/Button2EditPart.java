/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe.diagram.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.unicase.wireframe.Button;
import org.unicase.wireframe.WireframePackage;
import org.unicase.wireframe.diagram.edit.policies.Button2ItemSemanticEditPolicy;
import org.unicase.wireframe.diagram.util.EditPartImageUtil;

/**
 * @generated
 */
public class Button2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;

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
	public Button2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Button2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
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
		return primaryShape = new ButtonDescriptor();
	}

	/**
	 * @generated
	 */
	public ButtonDescriptor getPrimaryShape() {
		return (ButtonDescriptor) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(36, 36);
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
	public class ButtonDescriptor extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fButton_text;

		private ScalableImageFigure buttonImageFigure0;

		/**
		 * @generated
		 */
		public ButtonDescriptor() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = false;
			this.setLayoutManager(layoutThis);

			this.setOutline(false);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(36), getMapMode().DPtoLP(36)));
			createContents();
		}

		/**
		 * @generated NOT: added image
		 */
		private void createContents() {

			fButton_text = new WrappingLabel();

			fButton_text.setText("My Button");

			fButton_text.setFont(FBUTTON_TEXT_FONT);

			// custom code: added custom image for button
			Object adapter = getAdapter(Button.class);
			if (adapter instanceof Button) {
				final Button button = (Button) adapter;
				final GridData constraintButtonImageFigure0 = new GridData();
				constraintButtonImageFigure0.verticalAlignment = GridData.CENTER;
				constraintButtonImageFigure0.horizontalAlignment = GridData.CENTER;
				constraintButtonImageFigure0.horizontalIndent = 0;
				constraintButtonImageFigure0.horizontalSpan = 1;
				constraintButtonImageFigure0.verticalSpan = 1;
				constraintButtonImageFigure0.grabExcessHorizontalSpace = true;
				constraintButtonImageFigure0.grabExcessVerticalSpace = true;
				buttonImageFigure0 = new ScalableImageFigure(EditPartImageUtil.getButtonImage(button));
				buttonImageFigure0.setPreferredImageSize(36, 36);
				this.add(buttonImageFigure0, constraintButtonImageFigure0);

				button.eAdapters().add(new AdapterImpl() {

					public void notifyChanged(Notification notification) {
						if (WireframePackage.eINSTANCE.getButton_Style().equals(notification.getFeature())) {
							// remove old figures
							ButtonDescriptor.this.remove(buttonImageFigure0);
							// add figures
							buttonImageFigure0 = new ScalableImageFigure(EditPartImageUtil.getButtonImage(button));
							buttonImageFigure0.setPreferredImageSize(36, 36);
							ButtonDescriptor.this.add(buttonImageFigure0, constraintButtonImageFigure0);
						}
					}

					public boolean isAdapterForType(Object type) {
						return type instanceof Button;
					}

				});

			}

		}

		/**
		 * @generated
		 */
		public WrappingLabel getButton_text() {
			return fButton_text;
		}

	}

	/**
	 * @generated
	 */
	static final Font FBUTTON_TEXT_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.BOLD);

}
