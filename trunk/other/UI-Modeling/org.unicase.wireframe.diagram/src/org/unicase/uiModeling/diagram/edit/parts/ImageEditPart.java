package org.unicase.uiModeling.diagram.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
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
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.unicase.uiModeling.Image;
import org.unicase.uiModeling.UiModelingPackage;
import org.unicase.uiModeling.diagram.UiModelingAdapter;
import org.unicase.uiModeling.diagram.util.UiModelingDiagramUtil;

/**
 * @generated
 */
public class ImageEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2008;

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
	public ImageEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
			new org.unicase.uiModeling.diagram.edit.policies.ImageItemSemanticEditPolicy());
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
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.ImageTextEditPart) {
			((org.unicase.uiModeling.diagram.edit.parts.ImageTextEditPart) childEditPart).setLabel(getPrimaryShape()
				.getImage_text());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.ImageTextEditPart) {
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
	 * @generated NOT: added customized size
	 */
	protected NodeFigure createNodePlate() {
		// begin custom code
		Dimension size = UiModelingDiagramUtil.getSize(this);
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(size.width, size.height);
		// end of custom code
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
			.getType(org.unicase.uiModeling.diagram.edit.parts.ImageTextEditPart.VISUAL_ID));
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

		/**
		 * @generated NOT: added customized size
		 */
		public ImageDescriptor() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setOutline(false);

			// begin custom code
			IMapMode mapMode = getMapMode();
			Dimension size = UiModelingDiagramUtil.getSize(ImageEditPart.this);
			this.setPreferredSize(new Dimension(mapMode.DPtoLP(size.width), mapMode.DPtoLP(size.height)));
			// end of custom code

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

				final GridData constraintImageImageFigure0 = new GridData();
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

				new UiModelingAdapter(ImageEditPart.this) {

					public void notifyChanged(Notification notification) {
						Dimension oldSize = size;
						super.notifyChanged(notification);
						if (UiModelingPackage.eINSTANCE.getImage_ImageURL().equals(notification.getFeature())
							|| oldSize != size) {
							// remove old figures
							ImageDescriptor.this.remove(imageImageFigure0);
							ImageDescriptor.this.remove(fImage_text);
							// add figures
							imageImageFigure0 = new ScalableImageFigure(getSwtImage(image));
							imageImageFigure0.setPreferredImageSize(size.width - 10, size.height - 20);
							ImageDescriptor.this.add(imageImageFigure0, constraintImageImageFigure0);
							ImageDescriptor.this.add(fImage_text);
						}
					}

				}.adapt();

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

	}

	/**
	 * @generated
	 */
	static final Font FIMAGE_TEXT_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.BOLD);

}
