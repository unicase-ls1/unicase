package scrm.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import scrm.diagram.edit.policies.MathematicalModelItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenDiagramEditPolicy;
import scrm.diagram.edit.policies.ScrmTextSelectionEditPolicy;
import scrm.diagram.opener.MEEditorOpenerPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated NOT
 */
public class MathematicalModelEditPart extends SCRMModelElementEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2005;

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
	public MathematicalModelEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new MathematicalModelItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {

		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new ScrmTextSelectionEditPolicy();
					}
				}
				return super.createChildEditPolicy(child);
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new MathematicalModelFigure();
	}

	/**
	 * @generated
	 */
	public MathematicalModelFigure getPrimaryShape() {
		return (MathematicalModelFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof MathematicalModelNameEditPart) {
			((MathematicalModelNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureMathematicalModel_name());
			return true;
		}
		if (childEditPart instanceof MathematicalModelDescriptionEditPart) {
			((MathematicalModelDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureMathematicalModel_description());
			return true;
		}
		if (childEditPart instanceof MathematicalModelTheoryEditPart) {
			((MathematicalModelTheoryEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureMathematicalModel_theory());
			return true;
		}
		if (childEditPart instanceof MathematicalModelMathematicalExpressionEditPart) {
			((MathematicalModelMathematicalExpressionEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureMathematicalModel_mathematicalExpression());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof MathematicalModelNameEditPart) {
			return true;
		}
		if (childEditPart instanceof MathematicalModelDescriptionEditPart) {
			return true;
		}
		if (childEditPart instanceof MathematicalModelTheoryEditPart) {
			return true;
		}
		if (childEditPart instanceof MathematicalModelMathematicalExpressionEditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(200, 90);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
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
		return getChildBySemanticHint(ScrmVisualIDRegistry
				.getType(MathematicalModelNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.MathematicalModel_4004);
		types.add(ScrmElementTypes.MathematicalModelNumericalMethods_4011);
		types.add(ScrmElementTypes.MathematicalModelDependencies_4012);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof scrm.diagram.edit.parts.MathematicalModelEditPart) {
			types.add(ScrmElementTypes.MathematicalModel_4004);
		}
		if (targetEditPart instanceof NumericalMethodEditPart) {
			types.add(ScrmElementTypes.MathematicalModelNumericalMethods_4011);
		}
		if (targetEditPart instanceof AssumptionEditPart) {
			types.add(ScrmElementTypes.MathematicalModelDependencies_4012);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ScrmElementTypes.MathematicalModel_4004) {
			types.add(ScrmElementTypes.MathematicalModel_2005);
		} else if (relationshipType == ScrmElementTypes.MathematicalModelNumericalMethods_4011) {
			types.add(ScrmElementTypes.NumericalMethod_2006);
		} else if (relationshipType == ScrmElementTypes.MathematicalModelDependencies_4012) {
			types.add(ScrmElementTypes.Assumption_2008);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.ScientificProblemRepresentingModel_4006);
		types.add(ScrmElementTypes.MathematicalModel_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ScrmElementTypes.ScientificProblemRepresentingModel_4006) {
			types.add(ScrmElementTypes.ScientificProblem_2007);
		} else if (relationshipType == ScrmElementTypes.MathematicalModel_4004) {
			types.add(ScrmElementTypes.MathematicalModel_2005);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class MathematicalModelFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMathematicalModel_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureMathematicalModel_description;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureMathematicalModel_theory;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureMathematicalModel_mathematicalExpression;

		/**
		 * @generated
		 */
		public MathematicalModelFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutThis.setSpacing(5);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(200),
					getMapMode().DPtoLP(90)));
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureMathematicalModel_name = new WrappingLabel();
			fFigureMathematicalModel_name.setText("");
			fFigureMathematicalModel_name.setTextWrap(true);

			fFigureMathematicalModel_name
					.setFont(FFIGUREMATHEMATICALMODEL_NAME_FONT);

			this.add(fFigureMathematicalModel_name);

			fFigureMathematicalModel_description = new WrappingLabel();
			fFigureMathematicalModel_description.setText("");
			fFigureMathematicalModel_description.setTextWrap(true);

			this.add(fFigureMathematicalModel_description);

			fFigureMathematicalModel_theory = new WrappingLabel();
			fFigureMathematicalModel_theory.setText("");
			fFigureMathematicalModel_theory.setTextWrap(true);

			this.add(fFigureMathematicalModel_theory);

			fFigureMathematicalModel_mathematicalExpression = new WrappingLabel();
			fFigureMathematicalModel_mathematicalExpression.setText("");
			fFigureMathematicalModel_mathematicalExpression.setTextWrap(true);

			this.add(fFigureMathematicalModel_mathematicalExpression);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMathematicalModel_name() {
			return fFigureMathematicalModel_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMathematicalModel_description() {
			return fFigureMathematicalModel_description;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMathematicalModel_theory() {
			return fFigureMathematicalModel_theory;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMathematicalModel_mathematicalExpression() {
			return fFigureMathematicalModel_mathematicalExpression;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 244, 119, 36);

	/**
	 * @generated
	 */
	static final Font FFIGUREMATHEMATICALMODEL_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
