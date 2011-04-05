package scrm.diagram.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
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
import org.eclipse.swt.graphics.Color;

import scrm.diagram.edit.policies.NumericalMethodItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenDiagramEditPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class NumericalMethodEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2006;

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
	public NumericalMethodEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new NumericalMethodItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

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
		NumericalMethodFigure figure = new NumericalMethodFigure();
		return primaryShape = figure;
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
		if (childEditPart instanceof NumericalMethodDescriptionNameEditPart) {
			((NumericalMethodDescriptionNameEditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureNumericalMethodLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof NumericalMethodDescriptionNameEditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
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
		return getChildBySemanticHint(ScrmVisualIDRegistry.getType(NumericalMethodDescriptionNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		types.add(ScrmElementTypes.NumericalMethodDependencies_4015);
		types.add(ScrmElementTypes.NumericalMethodRealizingRequirement_4016);
		types.add(ScrmElementTypes.NumericalMethodPerformance_4017);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(
		IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof FeatureEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof HardwareEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof UserInterfaceEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof SoftwareInterfaceEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof ProcessEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof PerformanceEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof DataFlowEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof DataDefinitionEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof InputDataReadingEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof DataHandlingEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof ResultsOutputEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof ErrorHandlingEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof StatusMonitoringEditPart) {
			types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		}
		if (targetEditPart instanceof AssumptionEditPart) {
			types.add(ScrmElementTypes.NumericalMethodDependencies_4015);
		}
		if (targetEditPart instanceof ProcessEditPart) {
			types.add(ScrmElementTypes.NumericalMethodRealizingRequirement_4016);
		}
		if (targetEditPart instanceof PerformanceEditPart) {
			types.add(ScrmElementTypes.NumericalMethodRealizingRequirement_4016);
		}
		if (targetEditPart instanceof DataFlowEditPart) {
			types.add(ScrmElementTypes.NumericalMethodRealizingRequirement_4016);
		}
		if (targetEditPart instanceof DataDefinitionEditPart) {
			types.add(ScrmElementTypes.NumericalMethodRealizingRequirement_4016);
		}
		if (targetEditPart instanceof InputDataReadingEditPart) {
			types.add(ScrmElementTypes.NumericalMethodRealizingRequirement_4016);
		}
		if (targetEditPart instanceof DataHandlingEditPart) {
			types.add(ScrmElementTypes.NumericalMethodRealizingRequirement_4016);
		}
		if (targetEditPart instanceof ResultsOutputEditPart) {
			types.add(ScrmElementTypes.NumericalMethodRealizingRequirement_4016);
		}
		if (targetEditPart instanceof ErrorHandlingEditPart) {
			types.add(ScrmElementTypes.NumericalMethodRealizingRequirement_4016);
		}
		if (targetEditPart instanceof StatusMonitoringEditPart) {
			types.add(ScrmElementTypes.NumericalMethodRealizingRequirement_4016);
		}
		if (targetEditPart instanceof PerformanceEditPart) {
			types.add(ScrmElementTypes.NumericalMethodPerformance_4017);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(
		IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.Feature_2009);
		}
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.Hardware_2010);
		}
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.Constraint_2011);
		}
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.UserInterface_2012);
		}
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.SoftwareInterface_2013);
		}
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.Process_2014);
		}
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.Performance_2015);
		}
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.DataFlow_2016);
		}
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.DataDefinition_2017);
		}
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.InputDataReading_2018);
		}
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.DataHandling_2019);
		}
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.ResultsOutput_2020);
		}
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.ErrorHandling_2021);
		}
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.StatusMonitoring_2022);
		}
		if (relationshipType == ScrmElementTypes.NumericalMethodDependencies_4015) {
			types.add(ScrmElementTypes.Assumption_2008);
		}
		if (relationshipType == ScrmElementTypes.NumericalMethodRealizingRequirement_4016) {
			types.add(ScrmElementTypes.Process_2014);
		}
		if (relationshipType == ScrmElementTypes.NumericalMethodRealizingRequirement_4016) {
			types.add(ScrmElementTypes.Performance_2015);
		}
		if (relationshipType == ScrmElementTypes.NumericalMethodRealizingRequirement_4016) {
			types.add(ScrmElementTypes.DataFlow_2016);
		}
		if (relationshipType == ScrmElementTypes.NumericalMethodRealizingRequirement_4016) {
			types.add(ScrmElementTypes.DataDefinition_2017);
		}
		if (relationshipType == ScrmElementTypes.NumericalMethodRealizingRequirement_4016) {
			types.add(ScrmElementTypes.InputDataReading_2018);
		}
		if (relationshipType == ScrmElementTypes.NumericalMethodRealizingRequirement_4016) {
			types.add(ScrmElementTypes.DataHandling_2019);
		}
		if (relationshipType == ScrmElementTypes.NumericalMethodRealizingRequirement_4016) {
			types.add(ScrmElementTypes.ResultsOutput_2020);
		}
		if (relationshipType == ScrmElementTypes.NumericalMethodRealizingRequirement_4016) {
			types.add(ScrmElementTypes.ErrorHandling_2021);
		}
		if (relationshipType == ScrmElementTypes.NumericalMethodRealizingRequirement_4016) {
			types.add(ScrmElementTypes.StatusMonitoring_2022);
		}
		if (relationshipType == ScrmElementTypes.NumericalMethodPerformance_4017) {
			types.add(ScrmElementTypes.Performance_2015);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(ScrmElementTypes.ScientificProblemSolvingMethod_4007);
		types.add(ScrmElementTypes.MathematicalModelNumericalMethods_4011);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(
		IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == ScrmElementTypes.ScientificProblemSolvingMethod_4007) {
			types.add(ScrmElementTypes.ScientificProblem_2007);
		}
		if (relationshipType == ScrmElementTypes.MathematicalModelNumericalMethods_4011) {
			types.add(ScrmElementTypes.MathematicalModel_2005);
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
		private WrappingLabel fFigureNumericalMethodLabel;

		/**
		 * @generated
		 */
		public NumericalMethodFigure() {
			this.setLineWidth(1);
			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureNumericalMethodLabel = new WrappingLabel();
			fFigureNumericalMethodLabel.setText("NumericalMethod");

			this.add(fFigureNumericalMethodLabel);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNumericalMethodLabel() {
			return fFigureNumericalMethodLabel;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 240, 240, 0);

}
