package scrm.diagram.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
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
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

import scrm.diagram.edit.policies.OpenDiagramEditPolicy;
import scrm.diagram.edit.policies.ScientificProblemItemSemanticEditPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class ScientificProblemEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2007;

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
	public ScientificProblemEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ScientificProblemItemSemanticEditPolicy());
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
		ScientificProblemFigure figure = new ScientificProblemFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ScientificProblemFigure getPrimaryShape() {
		return (ScientificProblemFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ScientificProblemDescriptionEditPart) {
			((ScientificProblemDescriptionEditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureScientificProblem_description());
			return true;
		}
		if (childEditPart instanceof ScientificProblemNameEditPart) {
			((ScientificProblemNameEditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureScientificProblem_name());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ScientificProblemDescriptionEditPart) {
			return true;
		}
		if (childEditPart instanceof ScientificProblemNameEditPart) {
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
		return getChildBySemanticHint(ScrmVisualIDRegistry.getType(ScientificProblemNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		types.add(ScrmElementTypes.ScientificProblemRepresentingModel_4006);
		types.add(ScrmElementTypes.ScientificProblemSolvingMethod_4007);
		types.add(ScrmElementTypes.ScientificProblemInfluencedFeature_4008);
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
		if (targetEditPart instanceof MathematicalModelEditPart) {
			types.add(ScrmElementTypes.ScientificProblemRepresentingModel_4006);
		}
		if (targetEditPart instanceof NumericalMethodEditPart) {
			types.add(ScrmElementTypes.ScientificProblemSolvingMethod_4007);
		}
		if (targetEditPart instanceof FeatureEditPart) {
			types.add(ScrmElementTypes.ScientificProblemInfluencedFeature_4008);
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
		if (relationshipType == ScrmElementTypes.ScientificProblemRepresentingModel_4006) {
			types.add(ScrmElementTypes.MathematicalModel_2005);
		}
		if (relationshipType == ScrmElementTypes.ScientificProblemSolvingMethod_4007) {
			types.add(ScrmElementTypes.NumericalMethod_2006);
		}
		if (relationshipType == ScrmElementTypes.ScientificProblemInfluencedFeature_4008) {
			types.add(ScrmElementTypes.Feature_2009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class ScientificProblemFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureScientificProblem_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureScientificProblem_description;

		/**
		 * @generated
		 */
		public ScientificProblemFigure() {
			this.setLineWidth(1);
			this.setBackgroundColor(THIS_BACK);
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(160), getMapMode().DPtoLP(65)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureScientificProblem_name = new WrappingLabel();
			fFigureScientificProblem_name.setText("");

			fFigureScientificProblem_name.setFont(FFIGURESCIENTIFICPROBLEM_NAME_FONT);

			this.add(fFigureScientificProblem_name);

			fFigureScientificProblem_description = new WrappingLabel();
			fFigureScientificProblem_description.setText("");

			this.add(fFigureScientificProblem_description);

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
		public WrappingLabel getFigureScientificProblem_name() {
			return fFigureScientificProblem_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureScientificProblem_description() {
			return fFigureScientificProblem_description;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 255, 0, 0);

	/**
	 * @generated
	 */
	static final Font FFIGURESCIENTIFICPROBLEM_NAME_FONT = new Font(Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
