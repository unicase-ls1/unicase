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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;
import org.unicase.uiModeling.Image;
import org.unicase.uiModeling.UiModelingPackage;
import org.unicase.uiModeling.diagram.UiModelingConstants;
import org.unicase.uiModeling.diagram.util.UiModelingDiagramUtil;

/**
 * @generated
 */
public class Image2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3002;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * The x-coordinate of this edit part's figure.
	 */
	private int x;

	/**
	 * The y-coordinate of this edit part's figure.
	 */
	private int y;

	/**
	 * The width of this edit part's figure.
	 */
	private int width;

	/**
	 * The height of this edit part's figure.
	 */
	private int height;

	/**
	 * @generated
	 */
	public Image2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
			new org.unicase.uiModeling.diagram.edit.policies.Image2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
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
	 * {@inheritDoc}
	 */
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		Object notifier = notification.getNotifier();
		Object feature = notification.getFeature();
		EObject element = EditPartUtility.getElement(this);

		boolean sizeChanged = false;
		// only change layout if this element or the diagram element changed
		if (getDiagramView() == notifier) {
			if (UiModelingConstants.POSITIONING_ENABLED.equals(feature)) {
				boolean positioningEnabled = notification.getNewBooleanValue();
				if (positioningEnabled) {
					// TODO: set values of edit part to widget OR widget to editpart
				}
			} else if (UiModelingConstants.SIZING_ENABLED.equals(feature)) {
				boolean sizingEnabled = notification.getNewBooleanValue();
				if (sizingEnabled) {
					// TODO: set values of edit part to widget OR widget to editpart
					sizeChanged = true;
				}
			}
		} else if (element == notifier) {
			if (UiModelingDiagramUtil.isPositioningEnabled(element)) {
				if (UiModelingConstants.WIDGET_X.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (x != newValue) {
						x = newValue;
						UiModelingDiagramUtil.setViewFeature(this, UiModelingConstants.NOTATION_X, newValue);
					}
				} else if (UiModelingConstants.WIDGET_Y.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (y != newValue) {
						y = newValue;
						UiModelingDiagramUtil.setViewFeature(this, UiModelingConstants.NOTATION_Y, newValue);
					}
				}
			}
			if (UiModelingDiagramUtil.isSizingEnabled(element)) {
				if (UiModelingConstants.WIDGET_WIDTH.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (width != newValue) {
						width = newValue;
						UiModelingDiagramUtil.setViewFeature(this, UiModelingConstants.NOTATION_WIDTH, newValue);
						sizeChanged = true;
					}
				} else if (UiModelingConstants.WIDGET_HEIGHT.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (height != newValue) {
						height = newValue;
						UiModelingDiagramUtil.setViewFeature(this, UiModelingConstants.NOTATION_HEIGHT, newValue);
						sizeChanged = true;
					}
				}
			}
		} else {
			if (UiModelingDiagramUtil.isPositioningEnabled(element)) {
				if (UiModelingConstants.NOTATION_X.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (x != newValue) {
						x = newValue;
						UiModelingDiagramUtil.setElementFeature(this, UiModelingConstants.WIDGET_X, newValue);
					}
				} else if (UiModelingConstants.NOTATION_Y.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (y != newValue) {
						y = newValue;
						UiModelingDiagramUtil.setElementFeature(this, UiModelingConstants.WIDGET_Y, newValue);
					}
				}
			}
			if (UiModelingDiagramUtil.isSizingEnabled(element)) {
				if (UiModelingConstants.NOTATION_WIDTH.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (width != newValue) {
						if (width > 0) {
							width = newValue;
						}
						UiModelingDiagramUtil.setElementFeature(this, UiModelingConstants.WIDGET_WIDTH, newValue);
						sizeChanged = true;
					}
				} else if (UiModelingConstants.NOTATION_HEIGHT.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (height != newValue) {
						if (height > 0) {
							height = newValue;
						}
						UiModelingDiagramUtil.setElementFeature(this, UiModelingConstants.WIDGET_HEIGHT, newValue);
						sizeChanged = true;
					}
				}
			}
		}

		if (sizeChanged && (primaryShape instanceof ImageDescriptor)) {
			((ImageDescriptor) primaryShape).updateImage();
		}

		if (UiModelingPackage.eINSTANCE.getImage_ImageURL().equals(notification.getFeature())) {
			if (primaryShape instanceof ImageDescriptor) {
				((ImageDescriptor) primaryShape).updateImage();
			}
		}

	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new ImageDescriptor();
	}

	/**
	 * @generated
	 */
	public ImageDescriptor getPrimaryShape() {
		return (ImageDescriptor) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.ImageText2EditPart) {
			((org.unicase.uiModeling.diagram.edit.parts.ImageText2EditPart) childEditPart).setLabel(getPrimaryShape()
				.getImage_text());
			return true;
		}
		return false;
	}

	/**
	 * @generated*
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.ImageText2EditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(150, 125);
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
			.getType(org.unicase.uiModeling.diagram.edit.parts.ImageText2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class ImageDescriptor extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fImage_text;

		private ScalableImageFigure imageImageFigure0;

		private GridData constraintImageImageFigure0;

		/**
		 * @generated
		 */
		public ImageDescriptor() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setOutline(false);
			createContents();
		}

		/**
		 * @generated NOT: added image
		 */
		private void createContents() {

			// custom code: added image
			Object adapter = getAdapter(Image.class);
			if (adapter != null && adapter instanceof Image) {
				final Image image = (Image) adapter;

				constraintImageImageFigure0 = new GridData();
				constraintImageImageFigure0.verticalAlignment = GridData.BEGINNING;
				constraintImageImageFigure0.horizontalAlignment = GridData.CENTER;
				constraintImageImageFigure0.horizontalIndent = 0;
				constraintImageImageFigure0.horizontalSpan = 1;
				constraintImageImageFigure0.verticalSpan = 1;
				constraintImageImageFigure0.grabExcessHorizontalSpace = true;
				constraintImageImageFigure0.grabExcessVerticalSpace = true;

				imageImageFigure0 = new ScalableImageFigure(getSwtImage(image));
				imageImageFigure0.setPreferredImageSize(150, 100);
				this.add(imageImageFigure0, constraintImageImageFigure0);
			}

			fImage_text = new WrappingLabel();

			fImage_text.setText("My Image");
			// custom code: enabled text wrap
			fImage_text.setTextWrap(true);

			fImage_text.setFont(FIMAGE_TEXT_FONT);

			GridData constraintFImage_text = new GridData();
			constraintFImage_text.verticalAlignment = GridData.END;
			constraintFImage_text.horizontalAlignment = GridData.CENTER;
			constraintFImage_text.horizontalIndent = 0;
			constraintFImage_text.horizontalSpan = 1;
			constraintFImage_text.verticalSpan = 1;
			constraintFImage_text.grabExcessHorizontalSpace = false;
			constraintFImage_text.grabExcessVerticalSpace = false;
			this.add(fImage_text, constraintFImage_text);

		}

		private org.eclipse.swt.graphics.Image getSwtImage(Image image) {
			org.eclipse.swt.graphics.Image swtImage = UiModelingDiagramUtil.getImageImage(image);
			if (swtImage == null) {
				swtImage = UiModelingDiagramUtil.getErrorImage();
			}
			return swtImage;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getImage_text() {
			return fImage_text;
		}

		public void updateImage() {
			Object adapter = getAdapter(Image.class);
			if (adapter != null && adapter instanceof Image) {
				final Image image = (Image) adapter;
				// remove old figures
				remove(fImage_text);
				remove(imageImageFigure0);
				// add figures
				imageImageFigure0 = new ScalableImageFigure(getSwtImage(image));
				imageImageFigure0.setPreferredImageSize(width - 10, height - 20);
				ImageDescriptor.this.add(imageImageFigure0, constraintImageImageFigure0);
				ImageDescriptor.this.add(fImage_text);

			}
		}

	}

	/**
	 * @generated
	 */
	static final Font FIMAGE_TEXT_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.BOLD);

}
