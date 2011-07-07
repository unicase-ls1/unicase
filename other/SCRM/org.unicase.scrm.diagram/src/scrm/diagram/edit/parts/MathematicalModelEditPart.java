package scrm.diagram.edit.parts;

import java.util.LinkedList;
import java.util.List;

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
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

import scrm.SCRMDiagram;
import scrm.diagram.edit.policies.MathematicalModelItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenMEEditorPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class MathematicalModelEditPart extends ShapeNodeEditPart {

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
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenMEEditorPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
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
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnSource() {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		List<IElementType> types = new LinkedList<IElementType>();
		switch(scrmDiagram.getDiagramType()) {
			case DEFAULT_DIAGRAM:
			case KNOWLEDGE_DIAGRAM:
				types.add(ScrmElementTypes.MathematicalModelRepresentedProblem_4048);
				types.add(ScrmElementTypes.MathematicalModelRefinedModel_4058);
				types.add(ScrmElementTypes.MathematicalModelNumericalMethods_4011);
				types.add(ScrmElementTypes.MathematicalModelDependencies_4012);
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		List<IElementType> types = new LinkedList<IElementType>();
		switch(scrmDiagram.getDiagramType()) {
			case DEFAULT_DIAGRAM:
			case KNOWLEDGE_DIAGRAM:
				if (targetEditPart instanceof ScientificProblemEditPart) {
					types.add(ScrmElementTypes.MathematicalModelRepresentedProblem_4048);
				}
				if (targetEditPart instanceof ScientificProblem2EditPart) {
					types.add(ScrmElementTypes.MathematicalModelRepresentedProblem_4048);
				}
				if (targetEditPart instanceof MathematicalModelEditPart) {
					types.add(ScrmElementTypes.MathematicalModelRefinedModel_4058);
				}
				if (targetEditPart instanceof MathematicalModel2EditPart) {
					types.add(ScrmElementTypes.MathematicalModelRefinedModel_4058);
				}
				if (targetEditPart instanceof NumericalMethodEditPart) {
					types.add(ScrmElementTypes.MathematicalModelNumericalMethods_4011);
				}
				if (targetEditPart instanceof NumericalMethod2EditPart) {
					types.add(ScrmElementTypes.MathematicalModelNumericalMethods_4011);
				}
				if (targetEditPart instanceof AssumptionEditPart) {
					types.add(ScrmElementTypes.MathematicalModelDependencies_4012);
				}
				if (targetEditPart instanceof Assumption2EditPart) {
					types.add(ScrmElementTypes.MathematicalModelDependencies_4012);
				}
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		List<IElementType> types = new LinkedList<IElementType>();
		switch(scrmDiagram.getDiagramType()) {
			case DEFAULT_DIAGRAM: 
			case KNOWLEDGE_DIAGRAM:
				if (relationshipType == ScrmElementTypes.MathematicalModelRepresentedProblem_4048) {
					types.add(ScrmElementTypes.ScientificProblem_2007);
					types.add(ScrmElementTypes.ScientificProblem_3001);
				} else if (relationshipType == ScrmElementTypes.MathematicalModelRefinedModel_4058) {
					types.add(ScrmElementTypes.MathematicalModel_2005);
					types.add(ScrmElementTypes.MathematicalModel_3003);
				} else if (relationshipType == ScrmElementTypes.MathematicalModelNumericalMethods_4011) {
					types.add(ScrmElementTypes.NumericalMethod_2006);
					types.add(ScrmElementTypes.NumericalMethod_3002);
				} else if (relationshipType == ScrmElementTypes.MathematicalModelDependencies_4012) {
					types.add(ScrmElementTypes.Assumption_2008);
					types.add(ScrmElementTypes.Assumption_3004);
				}
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		List<IElementType> types = new LinkedList<IElementType>();
		switch(scrmDiagram.getDiagramType()) {
			case DEFAULT_DIAGRAM: 
			case KNOWLEDGE_DIAGRAM:
				types.add(ScrmElementTypes.MathematicalModelRefinedModel_4058);
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		List<IElementType> types = new LinkedList<IElementType>();
		switch(scrmDiagram.getDiagramType()) {
			case DEFAULT_DIAGRAM: 
			case KNOWLEDGE_DIAGRAM:
				if (relationshipType == ScrmElementTypes.MathematicalModelRefinedModel_4058) {
					types.add(ScrmElementTypes.MathematicalModel_2005);
					types.add(ScrmElementTypes.MathematicalModel_3003);
				}
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

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(200),
					getMapMode().DPtoLP(90)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureMathematicalModel_name = new WrappingLabel();
			fFigureMathematicalModel_name.setText("");

			fFigureMathematicalModel_name
					.setFont(FFIGUREMATHEMATICALMODEL_NAME_FONT);

			GridData constraintFFigureMathematicalModel_name = new GridData();
			constraintFFigureMathematicalModel_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureMathematicalModel_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureMathematicalModel_name.horizontalIndent = 0;
			constraintFFigureMathematicalModel_name.horizontalSpan = 1;
			constraintFFigureMathematicalModel_name.verticalSpan = 1;
			constraintFFigureMathematicalModel_name.grabExcessHorizontalSpace = false;
			constraintFFigureMathematicalModel_name.grabExcessVerticalSpace = false;
			this.add(fFigureMathematicalModel_name,
					constraintFFigureMathematicalModel_name);

			fFigureMathematicalModel_description = new WrappingLabel();
			fFigureMathematicalModel_description.setText("");

			GridData constraintFFigureMathematicalModel_description = new GridData();
			constraintFFigureMathematicalModel_description.verticalAlignment = GridData.BEGINNING;
			constraintFFigureMathematicalModel_description.horizontalAlignment = GridData.FILL;
			constraintFFigureMathematicalModel_description.horizontalIndent = 0;
			constraintFFigureMathematicalModel_description.horizontalSpan = 1;
			constraintFFigureMathematicalModel_description.verticalSpan = 1;
			constraintFFigureMathematicalModel_description.grabExcessHorizontalSpace = true;
			constraintFFigureMathematicalModel_description.grabExcessVerticalSpace = false;
			this.add(fFigureMathematicalModel_description,
					constraintFFigureMathematicalModel_description);

			fFigureMathematicalModel_theory = new WrappingLabel();
			fFigureMathematicalModel_theory.setText("");

			GridData constraintFFigureMathematicalModel_theory = new GridData();
			constraintFFigureMathematicalModel_theory.verticalAlignment = GridData.BEGINNING;
			constraintFFigureMathematicalModel_theory.horizontalAlignment = GridData.FILL;
			constraintFFigureMathematicalModel_theory.horizontalIndent = 0;
			constraintFFigureMathematicalModel_theory.horizontalSpan = 1;
			constraintFFigureMathematicalModel_theory.verticalSpan = 1;
			constraintFFigureMathematicalModel_theory.grabExcessHorizontalSpace = true;
			constraintFFigureMathematicalModel_theory.grabExcessVerticalSpace = false;
			this.add(fFigureMathematicalModel_theory,
					constraintFFigureMathematicalModel_theory);

			fFigureMathematicalModel_mathematicalExpression = new WrappingLabel();
			fFigureMathematicalModel_mathematicalExpression.setText("");

			GridData constraintFFigureMathematicalModel_mathematicalExpression = new GridData();
			constraintFFigureMathematicalModel_mathematicalExpression.verticalAlignment = GridData.BEGINNING;
			constraintFFigureMathematicalModel_mathematicalExpression.horizontalAlignment = GridData.FILL;
			constraintFFigureMathematicalModel_mathematicalExpression.horizontalIndent = 0;
			constraintFFigureMathematicalModel_mathematicalExpression.horizontalSpan = 1;
			constraintFFigureMathematicalModel_mathematicalExpression.verticalSpan = 1;
			constraintFFigureMathematicalModel_mathematicalExpression.grabExcessHorizontalSpace = true;
			constraintFFigureMathematicalModel_mathematicalExpression.grabExcessVerticalSpace = false;
			this.add(fFigureMathematicalModel_mathematicalExpression,
					constraintFFigureMathematicalModel_mathematicalExpression);

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
	static final Color THIS_BACK = new Color(null, 255, 153, 0);

	/**
	 * @generated
	 */
	static final Font FFIGUREMATHEMATICALMODEL_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
