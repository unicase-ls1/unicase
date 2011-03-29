package scrm.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
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
import scrm.diagram.edit.policies.InputDataReadingItemSemanticEditPolicy;
import scrm.diagram.edit.policies.ScrmTextSelectionEditPolicy;
import scrm.diagram.opener.MEEditorOpenerPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class InputDataReadingEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2018;

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
	public InputDataReadingEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new InputDataReadingItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new MEEditorOpenerPolicy());
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
		return primaryShape = new InputDataReadingFigure();
	}

	/**
	 * @generated
	 */
	public InputDataReadingFigure getPrimaryShape() {
		return (InputDataReadingFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InputDataReadingNameEditPart) {
			((InputDataReadingNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureInputDataReading_name());
			return true;
		}
		if (childEditPart instanceof InputDataReadingDescriptionEditPart) {
			((InputDataReadingDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureInputDataReading_description());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InputDataReadingNameEditPart) {
			return true;
		}
		if (childEditPart instanceof InputDataReadingDescriptionEditPart) {
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
		return getChildBySemanticHint(ScrmVisualIDRegistry
				.getType(InputDataReadingNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Requirement_4036);
		types.add(ScrmElementTypes.RequirementDefiningData_4038);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ProcessEditPart) {
			types.add(ScrmElementTypes.Requirement_4036);
		}
		if (targetEditPart instanceof PerformanceEditPart) {
			types.add(ScrmElementTypes.Requirement_4036);
		}
		if (targetEditPart instanceof DataFlowEditPart) {
			types.add(ScrmElementTypes.Requirement_4036);
		}
		if (targetEditPart instanceof DataDefinitionEditPart) {
			types.add(ScrmElementTypes.Requirement_4036);
		}
		if (targetEditPart instanceof scrm.diagram.edit.parts.InputDataReadingEditPart) {
			types.add(ScrmElementTypes.Requirement_4036);
		}
		if (targetEditPart instanceof DataHandlingEditPart) {
			types.add(ScrmElementTypes.Requirement_4036);
		}
		if (targetEditPart instanceof ResultsOutputEditPart) {
			types.add(ScrmElementTypes.Requirement_4036);
		}
		if (targetEditPart instanceof ErrorHandlingEditPart) {
			types.add(ScrmElementTypes.Requirement_4036);
		}
		if (targetEditPart instanceof StatusMonitoringEditPart) {
			types.add(ScrmElementTypes.Requirement_4036);
		}
		if (targetEditPart instanceof DataDefinitionEditPart) {
			types.add(ScrmElementTypes.RequirementDefiningData_4038);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ScrmElementTypes.Requirement_4036) {
			types.add(ScrmElementTypes.Process_2014);
			types.add(ScrmElementTypes.Performance_2015);
			types.add(ScrmElementTypes.DataFlow_2016);
			types.add(ScrmElementTypes.DataDefinition_2017);
			types.add(ScrmElementTypes.InputDataReading_2018);
			types.add(ScrmElementTypes.DataHandling_2019);
			types.add(ScrmElementTypes.ResultsOutput_2020);
			types.add(ScrmElementTypes.ErrorHandling_2021);
			types.add(ScrmElementTypes.StatusMonitoring_2022);
		} else if (relationshipType == ScrmElementTypes.RequirementDefiningData_4038) {
			types.add(ScrmElementTypes.DataDefinition_2017);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(4);
		types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		types.add(ScrmElementTypes.NumericalMethodRealizingRequirement_4016);
		types.add(ScrmElementTypes.FeatureDetailedRequirements_4027);
		types.add(ScrmElementTypes.Requirement_4036);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.ScientificProblem_2007);
			types.add(ScrmElementTypes.MathematicalModel_2005);
			types.add(ScrmElementTypes.NumericalMethod_2006);
			types.add(ScrmElementTypes.Assumption_2008);
		} else if (relationshipType == ScrmElementTypes.NumericalMethodRealizingRequirement_4016) {
			types.add(ScrmElementTypes.NumericalMethod_2006);
		} else if (relationshipType == ScrmElementTypes.FeatureDetailedRequirements_4027) {
			types.add(ScrmElementTypes.Feature_2009);
		} else if (relationshipType == ScrmElementTypes.Requirement_4036) {
			types.add(ScrmElementTypes.Process_2014);
			types.add(ScrmElementTypes.Performance_2015);
			types.add(ScrmElementTypes.DataFlow_2016);
			types.add(ScrmElementTypes.DataDefinition_2017);
			types.add(ScrmElementTypes.InputDataReading_2018);
			types.add(ScrmElementTypes.DataHandling_2019);
			types.add(ScrmElementTypes.ResultsOutput_2020);
			types.add(ScrmElementTypes.ErrorHandling_2021);
			types.add(ScrmElementTypes.StatusMonitoring_2022);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class InputDataReadingFigure extends Ellipse {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureInputDataReading_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureInputDataReading_description;

		/**
		 * @generated
		 */
		public InputDataReadingFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutThis.setSpacing(5);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureInputDataReading_name = new WrappingLabel();
			fFigureInputDataReading_name.setText("");
			fFigureInputDataReading_name.setTextWrap(true);

			fFigureInputDataReading_name
					.setFont(FFIGUREINPUTDATAREADING_NAME_FONT);

			this.add(fFigureInputDataReading_name);

			fFigureInputDataReading_description = new WrappingLabel();
			fFigureInputDataReading_description.setText("");
			fFigureInputDataReading_description.setTextWrap(true);

			this.add(fFigureInputDataReading_description);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureInputDataReading_name() {
			return fFigureInputDataReading_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureInputDataReading_description() {
			return fFigureInputDataReading_description;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 0, 0, 255);

	/**
	 * @generated
	 */
	static final Font FFIGUREINPUTDATAREADING_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
