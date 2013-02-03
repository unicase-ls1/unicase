package org.unicase.uiModeling.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
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
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
			new org.unicase.uiModeling.diagram.edit.policies.WindowItemSemanticEditPolicy());
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
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.WindowTextEditPart) {
			((org.unicase.uiModeling.diagram.edit.parts.WindowTextEditPart) childEditPart).setLabel(getPrimaryShape()
				.getWindow_text());
			return true;
		}
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getWindow_widgets();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart) childEditPart)
				.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.WindowTextEditPart) {
			return true;
		}
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getWindow_widgets();
			pane.remove(((org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart) childEditPart)
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
		if (editPart instanceof org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart) {
			return getPrimaryShape().getWindow_widgets();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(400, 200);
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
			.getType(org.unicase.uiModeling.diagram.edit.parts.WindowTextEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class WindowDescriptor extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fWindow_text;

		/**
		 * @generated
		 */
		private RectangleFigure fWindow_widgets;

		/**
		 * @generated
		 */
		public WindowDescriptor() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(400), getMapMode().DPtoLP(200)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure windowTopBar0 = new RectangleFigure();

			windowTopBar0.setOutline(false);
			windowTopBar0.setBackgroundColor(ColorConstants.lightGray);

			GridData constraintWindowTopBar0 = new GridData();
			constraintWindowTopBar0.verticalAlignment = GridData.BEGINNING;
			constraintWindowTopBar0.horizontalAlignment = GridData.FILL;
			constraintWindowTopBar0.horizontalIndent = 0;
			constraintWindowTopBar0.horizontalSpan = 1;
			constraintWindowTopBar0.verticalSpan = 1;
			constraintWindowTopBar0.grabExcessHorizontalSpace = true;
			constraintWindowTopBar0.grabExcessVerticalSpace = false;
			this.add(windowTopBar0, constraintWindowTopBar0);

			GridLayout layoutWindowTopBar0 = new GridLayout();
			layoutWindowTopBar0.numColumns = 4;
			layoutWindowTopBar0.makeColumnsEqualWidth = false;
			windowTopBar0.setLayoutManager(layoutWindowTopBar0);

			fWindow_text = new WrappingLabel();

			fWindow_text.setText("My Window");

			fWindow_text.setFont(FWINDOW_TEXT_FONT);

			GridData constraintFWindow_text = new GridData();
			constraintFWindow_text.verticalAlignment = GridData.FILL;
			constraintFWindow_text.horizontalAlignment = GridData.FILL;
			constraintFWindow_text.horizontalIndent = 0;
			constraintFWindow_text.horizontalSpan = 1;
			constraintFWindow_text.verticalSpan = 1;
			constraintFWindow_text.grabExcessHorizontalSpace = false;
			constraintFWindow_text.grabExcessVerticalSpace = false;
			windowTopBar0.add(fWindow_text, constraintFWindow_text);

			RectangleFigure window_CloseButton1 = new RectangleFigure();

			window_CloseButton1.setBackgroundColor(ColorConstants.darkGray);

			GridData constraintWindow_CloseButton1 = new GridData();
			constraintWindow_CloseButton1.verticalAlignment = GridData.FILL;
			constraintWindow_CloseButton1.horizontalAlignment = GridData.BEGINNING;
			constraintWindow_CloseButton1.horizontalIndent = 0;
			constraintWindow_CloseButton1.horizontalSpan = 1;
			constraintWindow_CloseButton1.verticalSpan = 1;
			constraintWindow_CloseButton1.grabExcessHorizontalSpace = false;
			constraintWindow_CloseButton1.grabExcessVerticalSpace = false;
			windowTopBar0.add(window_CloseButton1, constraintWindow_CloseButton1);

			fWindow_widgets = new RectangleFigure();

			fWindow_widgets.setOutline(false);

			GridData constraintFWindow_widgets = new GridData();
			constraintFWindow_widgets.verticalAlignment = GridData.FILL;
			constraintFWindow_widgets.horizontalAlignment = GridData.FILL;
			constraintFWindow_widgets.horizontalIndent = 0;
			constraintFWindow_widgets.horizontalSpan = 1;
			constraintFWindow_widgets.verticalSpan = 1;
			constraintFWindow_widgets.grabExcessHorizontalSpace = true;
			constraintFWindow_widgets.grabExcessVerticalSpace = true;
			this.add(fWindow_widgets, constraintFWindow_widgets);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getWindow_text() {
			return fWindow_text;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getWindow_widgets() {
			return fWindow_widgets;
		}

	}

	/**
	 * @generated
	 */
	static final Font FWINDOW_TEXT_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.BOLD);

}
