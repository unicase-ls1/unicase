package org.unicase.wireframe.diagram.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
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
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.unicase.wireframe.Window;
import org.unicase.wireframe.diagram.edit.policies.WindowItemSemanticEditPolicy;
import org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry;
import org.unicase.wireframe.diagram.util.EditPartImageUtil;

/**
 * @generated
 */
public class WindowEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2003;

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
	public WindowEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new WindowItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that
		// would let children add reasonable editpolicies
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
		return primaryShape = new WindowDescriptor();
	}

	/**
	 * @generated
	 */
	public WindowDescriptor getPrimaryShape() {
		return (WindowDescriptor) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WindowTextEditPart) {
			((WindowTextEditPart) childEditPart).setLabel(getPrimaryShape().getWindow_text());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WindowTextEditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(453, 280);
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
		return getChildBySemanticHint(WireframeVisualIDRegistry.getType(WindowTextEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class WindowDescriptor extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fWindow_text;

		private ScalableImageFigure windowImageFigure;

		/**
		 * @generated
		 */
		public WindowDescriptor() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(453), getMapMode().DPtoLP(280)));
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(901), getMapMode().DPtoLP(530)));
			createContents();
		}

		/**
		 * @generated NOT: added image, removed outline
		 */
		private void createContents() {

			fWindow_text = new WrappingLabel();

			fWindow_text.setText("My Window");

			fWindow_text.setFont(FWINDOW_TEXT_FONT);

			GridData constraintFWindow_text = new GridData();
			constraintFWindow_text.verticalAlignment = GridData.BEGINNING;
			constraintFWindow_text.horizontalAlignment = GridData.CENTER;
			constraintFWindow_text.horizontalIndent = 0;
			constraintFWindow_text.horizontalSpan = 1;
			constraintFWindow_text.verticalSpan = 1;
			constraintFWindow_text.grabExcessHorizontalSpace = false;
			constraintFWindow_text.grabExcessVerticalSpace = false;
			this.add(fWindow_text, constraintFWindow_text);

			// custom code: added image, removed outline
			Object adapter = getAdapter(Window.class);
			if (adapter != null && adapter instanceof Window) {
				Image image = EditPartImageUtil.getWindowImage((Window) adapter);
				if (image != null) {
					windowImageFigure = new ScalableImageFigure(image);
					windowImageFigure.setPreferredImageSize(450, 250);

					GridData constraintWindowImageFigure0 = new GridData();
					constraintWindowImageFigure0.verticalAlignment = GridData.END;
					constraintWindowImageFigure0.horizontalAlignment = GridData.CENTER;
					constraintWindowImageFigure0.horizontalIndent = 0;
					constraintWindowImageFigure0.horizontalSpan = 1;
					constraintWindowImageFigure0.verticalSpan = 1;
					constraintWindowImageFigure0.grabExcessHorizontalSpace = true;
					constraintWindowImageFigure0.grabExcessVerticalSpace = true;
					this.add(windowImageFigure, constraintWindowImageFigure0);
				}
			}

			this.setOutline(false);
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWindow_text() {
			return fWindow_text;
		}

	}

	/**
	 * @generated
	 */
	static final Font FWINDOW_TEXT_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.BOLD);

}
