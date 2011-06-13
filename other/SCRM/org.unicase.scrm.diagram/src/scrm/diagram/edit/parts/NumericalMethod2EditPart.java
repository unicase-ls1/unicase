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

import scrm.diagram.edit.policies.NumericalMethod2ItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenDiagramEditPolicy;
import scrm.diagram.edit.policies.ScrmTextSelectionEditPolicy;
import scrm.diagram.opener.MEEditorOpenerPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class NumericalMethod2EditPart extends ShapeNodeEditPart {

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
	 * @generated
	 */
	public NumericalMethod2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new NumericalMethod2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new MEEditorOpenerPolicy());
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
		return primaryShape = new NumericalMethodFigure();
	}

	/**
	 * @generated
	 */
	public NumericalMethodFigure getPrimaryShape() {
		return (NumericalMethodFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof NumericalMethodName2EditPart) {
			((NumericalMethodName2EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureNumericalMethod_name());
			return true;
		}
		if (childEditPart instanceof NumericalMethodDescription2EditPart) {
			((NumericalMethodDescription2EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureNumericalMethod_description());
			return true;
		}
		if (childEditPart instanceof NumericalMethodTheory2EditPart) {
			((NumericalMethodTheory2EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureNumericalMethod_theory());
			return true;
		}
		if (childEditPart instanceof NumericalMethodAlgorithm2EditPart) {
			((NumericalMethodAlgorithm2EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureNumericalMethod_algorithm());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof NumericalMethodName2EditPart) {
			return true;
		}
		if (childEditPart instanceof NumericalMethodDescription2EditPart) {
			return true;
		}
		if (childEditPart instanceof NumericalMethodTheory2EditPart) {
			return true;
		}
		if (childEditPart instanceof NumericalMethodAlgorithm2EditPart) {
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
				.getType(NumericalMethodName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.NumericalMethodSolvedProblem_4057);
		types.add(ScrmElementTypes.NumericalMethodDependencies_4015);
		types.add(ScrmElementTypes.NumericalMethodPerformance_4017);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ScientificProblemEditPart) {
			types.add(ScrmElementTypes.NumericalMethodSolvedProblem_4057);
		}
		if (targetEditPart instanceof ScientificProblem2EditPart) {
			types.add(ScrmElementTypes.NumericalMethodSolvedProblem_4057);
		}
		if (targetEditPart instanceof AssumptionEditPart) {
			types.add(ScrmElementTypes.NumericalMethodDependencies_4015);
		}
		if (targetEditPart instanceof Assumption2EditPart) {
			types.add(ScrmElementTypes.NumericalMethodDependencies_4015);
		}
		if (targetEditPart instanceof PerformanceEditPart) {
			types.add(ScrmElementTypes.NumericalMethodPerformance_4017);
		}
		if (targetEditPart instanceof Performance2EditPart) {
			types.add(ScrmElementTypes.NumericalMethodPerformance_4017);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ScrmElementTypes.NumericalMethodSolvedProblem_4057) {
			types.add(ScrmElementTypes.ScientificProblem_2007);
			types.add(ScrmElementTypes.ScientificProblem_3001);
		} else if (relationshipType == ScrmElementTypes.NumericalMethodDependencies_4015) {
			types.add(ScrmElementTypes.Assumption_2008);
			types.add(ScrmElementTypes.Assumption_3004);
		} else if (relationshipType == ScrmElementTypes.NumericalMethodPerformance_4017) {
			types.add(ScrmElementTypes.Performance_2015);
			types.add(ScrmElementTypes.Performance_3011);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.MathematicalModelNumericalMethods_4011);
		types.add(ScrmElementTypes.RequirementRealizedMethod_4050);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ScrmElementTypes.MathematicalModelNumericalMethods_4011) {
			types.add(ScrmElementTypes.MathematicalModel_2005);
			types.add(ScrmElementTypes.MathematicalModel_3003);
		} else if (relationshipType == ScrmElementTypes.RequirementRealizedMethod_4050) {
			types.add(ScrmElementTypes.Process_2035);
			types.add(ScrmElementTypes.Performance_2015);
			types.add(ScrmElementTypes.InputDataReading_2036);
			types.add(ScrmElementTypes.DataHandling_2037);
			types.add(ScrmElementTypes.ResultsOutput_2038);
			types.add(ScrmElementTypes.ErrorHandling_2039);
			types.add(ScrmElementTypes.StatusMonitoring_2040);
			types.add(ScrmElementTypes.Requirement_2034);
			types.add(ScrmElementTypes.DataProcessSpace_2046);
			types.add(ScrmElementTypes.Performance_3011);
			types.add(ScrmElementTypes.Requirement_3012);
			types.add(ScrmElementTypes.StatusMonitoring_3016);
			types.add(ScrmElementTypes.ResultsOutput_3017);
			types.add(ScrmElementTypes.Process_3018);
			types.add(ScrmElementTypes.InputDataReading_3019);
			types.add(ScrmElementTypes.ErrorHandling_3020);
			types.add(ScrmElementTypes.DataHandling_3021);
			types.add(ScrmElementTypes.DataProcessSpace_3022);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class NumericalMethodFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureNumericalMethod_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNumericalMethod_description;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNumericalMethod_theory;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNumericalMethod_algorithm;

		/**
		 * @generated
		 */
		public NumericalMethodFigure() {

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

			fFigureNumericalMethod_name = new WrappingLabel();
			fFigureNumericalMethod_name.setText("");
			fFigureNumericalMethod_name.setTextWrap(true);

			fFigureNumericalMethod_name
					.setFont(FFIGURENUMERICALMETHOD_NAME_FONT);

			this.add(fFigureNumericalMethod_name);

			fFigureNumericalMethod_description = new WrappingLabel();
			fFigureNumericalMethod_description.setText("");
			fFigureNumericalMethod_description.setTextWrap(true);

			this.add(fFigureNumericalMethod_description);

			fFigureNumericalMethod_theory = new WrappingLabel();
			fFigureNumericalMethod_theory.setText("");
			fFigureNumericalMethod_theory.setTextWrap(true);

			this.add(fFigureNumericalMethod_theory);

			fFigureNumericalMethod_algorithm = new WrappingLabel();
			fFigureNumericalMethod_algorithm.setText("");
			fFigureNumericalMethod_algorithm.setTextWrap(true);

			this.add(fFigureNumericalMethod_algorithm);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNumericalMethod_name() {
			return fFigureNumericalMethod_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNumericalMethod_description() {
			return fFigureNumericalMethod_description;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNumericalMethod_theory() {
			return fFigureNumericalMethod_theory;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNumericalMethod_algorithm() {
			return fFigureNumericalMethod_algorithm;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 240, 240, 0);

	/**
	 * @generated
	 */
	static final Font FFIGURENUMERICALMETHOD_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
