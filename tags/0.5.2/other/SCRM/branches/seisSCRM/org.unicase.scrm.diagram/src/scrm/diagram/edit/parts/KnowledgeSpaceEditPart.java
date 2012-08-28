package scrm.diagram.edit.parts;

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

import scrm.diagram.edit.policies.KnowledgeSpaceItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenSCRMSpaceEditPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;

/**
 * @generated
 */
public class KnowledgeSpaceEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2044;

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
	public KnowledgeSpaceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new KnowledgeSpaceItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new OpenSCRMSpaceEditPolicy());
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
		return primaryShape = new KnowledgeSpaceFigure();
	}

	/**
	 * @generated
	 */
	public KnowledgeSpaceFigure getPrimaryShape() {
		return (KnowledgeSpaceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof KnowledgeSpaceNameEditPart) {
			((KnowledgeSpaceNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureKnowledgeSpace_name());
			return true;
		}
		if (childEditPart instanceof KnowledgeSpaceKnowledgeSpaceCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureKnowledgeSpace_containedScientificKnowledge();
			setupContentPane(pane); // FIXME each comparment should handle his
									// content pane in his own way
			pane.add(((KnowledgeSpaceKnowledgeSpaceCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof KnowledgeSpaceNameEditPart) {
			return true;
		}
		if (childEditPart instanceof KnowledgeSpaceKnowledgeSpaceCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureKnowledgeSpace_containedScientificKnowledge();
			setupContentPane(pane); // FIXME each comparment should handle his
									// content pane in his own way
			pane.remove(((KnowledgeSpaceKnowledgeSpaceCompartmentEditPart) childEditPart)
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
		if (editPart instanceof KnowledgeSpaceKnowledgeSpaceCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureKnowledgeSpace_containedScientificKnowledge();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(300, 240);
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
		return getChildBySemanticHint(ScrmVisualIDRegistry
				.getType(KnowledgeSpaceNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class KnowledgeSpaceFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureKnowledgeSpace_name;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureKnowledgeSpace_containedScientificKnowledge;

		/**
		 * @generated
		 */
		public KnowledgeSpaceFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(300),
					getMapMode().DPtoLP(240)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureKnowledgeSpace_name = new WrappingLabel();
			fFigureKnowledgeSpace_name.setText("");

			fFigureKnowledgeSpace_name.setFont(FFIGUREKNOWLEDGESPACE_NAME_FONT);

			GridData constraintFFigureKnowledgeSpace_name = new GridData();
			constraintFFigureKnowledgeSpace_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureKnowledgeSpace_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureKnowledgeSpace_name.horizontalIndent = 0;
			constraintFFigureKnowledgeSpace_name.horizontalSpan = 1;
			constraintFFigureKnowledgeSpace_name.verticalSpan = 1;
			constraintFFigureKnowledgeSpace_name.grabExcessHorizontalSpace = false;
			constraintFFigureKnowledgeSpace_name.grabExcessVerticalSpace = false;
			this.add(fFigureKnowledgeSpace_name,
					constraintFFigureKnowledgeSpace_name);

			fFigureKnowledgeSpace_containedScientificKnowledge = new RectangleFigure();

			GridData constraintFFigureKnowledgeSpace_containedScientificKnowledge = new GridData();
			constraintFFigureKnowledgeSpace_containedScientificKnowledge.verticalAlignment = GridData.FILL;
			constraintFFigureKnowledgeSpace_containedScientificKnowledge.horizontalAlignment = GridData.FILL;
			constraintFFigureKnowledgeSpace_containedScientificKnowledge.horizontalIndent = 0;
			constraintFFigureKnowledgeSpace_containedScientificKnowledge.horizontalSpan = 1;
			constraintFFigureKnowledgeSpace_containedScientificKnowledge.verticalSpan = 1;
			constraintFFigureKnowledgeSpace_containedScientificKnowledge.grabExcessHorizontalSpace = true;
			constraintFFigureKnowledgeSpace_containedScientificKnowledge.grabExcessVerticalSpace = true;
			this.add(fFigureKnowledgeSpace_containedScientificKnowledge,
					constraintFFigureKnowledgeSpace_containedScientificKnowledge);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureKnowledgeSpace_name() {
			return fFigureKnowledgeSpace_name;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureKnowledgeSpace_containedScientificKnowledge() {
			return fFigureKnowledgeSpace_containedScientificKnowledge;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREKNOWLEDGESPACE_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
