package scrm.diagram.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
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

import scrm.diagram.edit.policies.OpenSCRMSpaceEditPolicy;
import scrm.diagram.edit.policies.RequirementSpace2ItemSemanticEditPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;

/**
 * @generated
 */
public class RequirementSpace2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3015;

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
	public RequirementSpace2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RequirementSpace2ItemSemanticEditPolicy());
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
		return primaryShape = new RequirementSpaceFigure();
	}

	/**
	 * @generated
	 */
	public RequirementSpaceFigure getPrimaryShape() {
		return (RequirementSpaceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RequirementSpaceName2EditPart) {
			((RequirementSpaceName2EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureRequirementSpace_name());
			return true;
		}
		if (childEditPart instanceof RequirementSpaceRequirementSpaceCompartment2EditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureRequirementSpace_containedInformationOfRequirements();
			setupContentPane(pane); // FIXME each comparment should handle his
									// content pane in his own way
			pane.add(((RequirementSpaceRequirementSpaceCompartment2EditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RequirementSpaceName2EditPart) {
			return true;
		}
		if (childEditPart instanceof RequirementSpaceRequirementSpaceCompartment2EditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureRequirementSpace_containedInformationOfRequirements();
			setupContentPane(pane); // FIXME each comparment should handle his
									// content pane in his own way
			pane.remove(((RequirementSpaceRequirementSpaceCompartment2EditPart) childEditPart)
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
		if (editPart instanceof RequirementSpaceRequirementSpaceCompartment2EditPart) {
			return getPrimaryShape()
					.getFigureRequirementSpace_containedInformationOfRequirements();
		}
		return getContentPane();
	}

	/**
	 * @generated NOT: adjusted size
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(150, 120);
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
				.getType(RequirementSpaceName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class RequirementSpaceFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureRequirementSpace_name;
		/**
		 * @generated
		 */
		private RoundedRectangle fFigureRequirementSpace_containedInformationOfRequirements;

		/**
		 * @generated NOT: adjusted size
		 */
		public RequirementSpaceFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(32),
					getMapMode().DPtoLP(32)));
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(150),
					getMapMode().DPtoLP(120)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureRequirementSpace_name = new WrappingLabel();
			fFigureRequirementSpace_name.setText("");

			fFigureRequirementSpace_name
					.setFont(FFIGUREREQUIREMENTSPACE_NAME_FONT);

			GridData constraintFFigureRequirementSpace_name = new GridData();
			constraintFFigureRequirementSpace_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureRequirementSpace_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureRequirementSpace_name.horizontalIndent = 0;
			constraintFFigureRequirementSpace_name.horizontalSpan = 1;
			constraintFFigureRequirementSpace_name.verticalSpan = 1;
			constraintFFigureRequirementSpace_name.grabExcessHorizontalSpace = false;
			constraintFFigureRequirementSpace_name.grabExcessVerticalSpace = false;
			this.add(fFigureRequirementSpace_name,
					constraintFFigureRequirementSpace_name);

			fFigureRequirementSpace_containedInformationOfRequirements = new RoundedRectangle();
			fFigureRequirementSpace_containedInformationOfRequirements
					.setCornerDimensions(new Dimension(getMapMode().DPtoLP(32),
							getMapMode().DPtoLP(32)));

			GridData constraintFFigureRequirementSpace_containedInformationOfRequirements = new GridData();
			constraintFFigureRequirementSpace_containedInformationOfRequirements.verticalAlignment = GridData.FILL;
			constraintFFigureRequirementSpace_containedInformationOfRequirements.horizontalAlignment = GridData.FILL;
			constraintFFigureRequirementSpace_containedInformationOfRequirements.horizontalIndent = 0;
			constraintFFigureRequirementSpace_containedInformationOfRequirements.horizontalSpan = 1;
			constraintFFigureRequirementSpace_containedInformationOfRequirements.verticalSpan = 1;
			constraintFFigureRequirementSpace_containedInformationOfRequirements.grabExcessHorizontalSpace = true;
			constraintFFigureRequirementSpace_containedInformationOfRequirements.grabExcessVerticalSpace = true;
			this.add(
					fFigureRequirementSpace_containedInformationOfRequirements,
					constraintFFigureRequirementSpace_containedInformationOfRequirements);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureRequirementSpace_name() {
			return fFigureRequirementSpace_name;
		}

		/**
		 * @generated
		 */
		public RoundedRectangle getFigureRequirementSpace_containedInformationOfRequirements() {
			return fFigureRequirementSpace_containedInformationOfRequirements;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREREQUIREMENTSPACE_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
