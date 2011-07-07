package scrm.diagram.edit.parts;

import java.util.LinkedList;
import java.util.List;

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
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

import scrm.SCRMDiagram;
import scrm.diagram.edit.policies.OpenMEEditorPolicy;
import scrm.diagram.edit.policies.ResultsOutputItemSemanticEditPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class ResultsOutputEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2038;

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
	public ResultsOutputEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ResultsOutputItemSemanticEditPolicy());
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
		return primaryShape = new ResultsOutputFigure();
	}

	/**
	 * @generated
	 */
	public ResultsOutputFigure getPrimaryShape() {
		return (ResultsOutputFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ResultsOutputNameEditPart) {
			((ResultsOutputNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureResultsOutput_name());
			return true;
		}
		if (childEditPart instanceof ResultsOutputDescriptionEditPart) {
			((ResultsOutputDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureResultsOutput_description());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ResultsOutputNameEditPart) {
			return true;
		}
		if (childEditPart instanceof ResultsOutputDescriptionEditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(160, 65);
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
				.getType(ResultsOutputNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnSource() {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		List<IElementType> types = new LinkedList<IElementType>();
		switch(scrmDiagram.getDiagramType()) {
			case DEFAULT_DIAGRAM:
				types.add(ScrmElementTypes.RequirementRealizedMethod_4050);
			case REQUIREMENTS_DIAGRAM:
				types.add(ScrmElementTypes.RequirementSpecifiedFeature_4052);
			case DATA_PROCESS_DIAGRAM:
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
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
				if (targetEditPart instanceof NumericalMethodEditPart) {
					types.add(ScrmElementTypes.RequirementRealizedMethod_4050);
				}
				if (targetEditPart instanceof NumericalMethod2EditPart) {
					types.add(ScrmElementTypes.RequirementRealizedMethod_4050);
				}
			case REQUIREMENTS_DIAGRAM:
				if (targetEditPart instanceof FeatureEditPart) {
					types.add(ScrmElementTypes.RequirementSpecifiedFeature_4052);
				}
				if (targetEditPart instanceof Feature2EditPart) {
					types.add(ScrmElementTypes.RequirementSpecifiedFeature_4052);
				}
				if (targetEditPart instanceof PerformanceEditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof RequirementEditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof Performance2EditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof Requirement2EditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
			case DATA_PROCESS_DIAGRAM:
				if (targetEditPart instanceof ProcessEditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof InputDataReadingEditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof DataHandlingEditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof ResultsOutputEditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof ErrorHandlingEditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof StatusMonitoringEditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof DataProcessSpaceEditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof StatusMonitoring2EditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof ResultsOutput2EditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof Process2EditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof InputDataReading2EditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof ErrorHandling2EditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof DataHandling2EditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof DataProcessSpace2EditPart) {
					types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				}
				if (targetEditPart instanceof ProcessEditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
				}
				if (targetEditPart instanceof InputDataReadingEditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
				}
				if (targetEditPart instanceof DataHandlingEditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
				}
				if (targetEditPart instanceof ResultsOutputEditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
				}
				if (targetEditPart instanceof ErrorHandlingEditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
				}
				if (targetEditPart instanceof StatusMonitoringEditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
				}
				if (targetEditPart instanceof DataProcessSpaceEditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
				}
				if (targetEditPart instanceof StatusMonitoring2EditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
				}
				if (targetEditPart instanceof ResultsOutput2EditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
				}
				if (targetEditPart instanceof Process2EditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
				}
				if (targetEditPart instanceof InputDataReading2EditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
				}
				if (targetEditPart instanceof ErrorHandling2EditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
				}
				if (targetEditPart instanceof DataHandling2EditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
				}
				if (targetEditPart instanceof DataProcessSpace2EditPart) {
					types.add(ScrmElementTypes.ProcessSuccessor_4047);
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
				if (relationshipType == ScrmElementTypes.RequirementRealizedMethod_4050) {
					types.add(ScrmElementTypes.NumericalMethod_2006);
					types.add(ScrmElementTypes.NumericalMethod_3002);
					break;
				}
			case REQUIREMENTS_DIAGRAM:
				if (relationshipType == ScrmElementTypes.RequirementSpecifiedFeature_4052) {
					types.add(ScrmElementTypes.Feature_2009);
					types.add(ScrmElementTypes.Feature_3009);
					break;
				} else if (relationshipType == ScrmElementTypes.RequirementRefinedRequirement_4054) {
					types.add(ScrmElementTypes.Performance_2015);
					types.add(ScrmElementTypes.Requirement_2034);
					types.add(ScrmElementTypes.Performance_3011);
					types.add(ScrmElementTypes.Requirement_3012);
				}
			case DATA_PROCESS_DIAGRAM:
				if (relationshipType == ScrmElementTypes.RequirementRefinedRequirement_4054) {
					types.add(ScrmElementTypes.Process_2035);
					types.add(ScrmElementTypes.InputDataReading_2036);
					types.add(ScrmElementTypes.DataHandling_2037);
					types.add(ScrmElementTypes.ResultsOutput_2038);
					types.add(ScrmElementTypes.ErrorHandling_2039);
					types.add(ScrmElementTypes.StatusMonitoring_2040);
					types.add(ScrmElementTypes.DataProcessSpace_2046);
					types.add(ScrmElementTypes.StatusMonitoring_3016);
					types.add(ScrmElementTypes.ResultsOutput_3017);
					types.add(ScrmElementTypes.Process_3018);
					types.add(ScrmElementTypes.InputDataReading_3019);
					types.add(ScrmElementTypes.ErrorHandling_3020);
					types.add(ScrmElementTypes.DataHandling_3021);
					types.add(ScrmElementTypes.DataProcessSpace_3022);
				} else if (relationshipType == ScrmElementTypes.ProcessSuccessor_4047) {
					types.add(ScrmElementTypes.Process_2035);
					types.add(ScrmElementTypes.InputDataReading_2036);
					types.add(ScrmElementTypes.DataHandling_2037);
					types.add(ScrmElementTypes.ResultsOutput_2038);
					types.add(ScrmElementTypes.ErrorHandling_2039);
					types.add(ScrmElementTypes.StatusMonitoring_2040);
					types.add(ScrmElementTypes.DataProcessSpace_2046);
					types.add(ScrmElementTypes.StatusMonitoring_3016);
					types.add(ScrmElementTypes.ResultsOutput_3017);
					types.add(ScrmElementTypes.Process_3018);
					types.add(ScrmElementTypes.InputDataReading_3019);
					types.add(ScrmElementTypes.ErrorHandling_3020);
					types.add(ScrmElementTypes.DataHandling_3021);
					types.add(ScrmElementTypes.DataProcessSpace_3022);
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
			case REQUIREMENTS_DIAGRAM:
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4055);
				types.add(ScrmElementTypes.DataFlowSpecifiedProcess_4056);
			case DATA_PROCESS_DIAGRAM:
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
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
			case REQUIREMENTS_DIAGRAM:
				if (relationshipType == ScrmElementTypes.RequirementRefinedRequirement_4054) {
					types.add(ScrmElementTypes.Performance_2015);
					types.add(ScrmElementTypes.Requirement_2034);
					types.add(ScrmElementTypes.Performance_3011);
					types.add(ScrmElementTypes.Requirement_3012);
				} else if (relationshipType == ScrmElementTypes.DataDefinitionDefinedRequirement_4055) {
					types.add(ScrmElementTypes.DataDefinition_2017);
					types.add(ScrmElementTypes.DataDefinition_3007);
				} else if (relationshipType == ScrmElementTypes.DataFlowSpecifiedProcess_4056) {
					types.add(ScrmElementTypes.DataFlow_2016);
					types.add(ScrmElementTypes.DataFlow_3008);
				}
			case DATA_PROCESS_DIAGRAM:
				if (relationshipType == ScrmElementTypes.RequirementRefinedRequirement_4054) {
					types.add(ScrmElementTypes.Process_2035);
					types.add(ScrmElementTypes.InputDataReading_2036);
					types.add(ScrmElementTypes.DataHandling_2037);
					types.add(ScrmElementTypes.ResultsOutput_2038);
					types.add(ScrmElementTypes.ErrorHandling_2039);
					types.add(ScrmElementTypes.StatusMonitoring_2040);
					types.add(ScrmElementTypes.DataProcessSpace_2046);
					types.add(ScrmElementTypes.StatusMonitoring_3016);
					types.add(ScrmElementTypes.ResultsOutput_3017);
					types.add(ScrmElementTypes.Process_3018);
					types.add(ScrmElementTypes.InputDataReading_3019);
					types.add(ScrmElementTypes.ErrorHandling_3020);
					types.add(ScrmElementTypes.DataHandling_3021);
					types.add(ScrmElementTypes.DataProcessSpace_3022);
					break;
				}
				if (relationshipType == ScrmElementTypes.ProcessSuccessor_4047) {
					types.add(ScrmElementTypes.Process_2035);
					types.add(ScrmElementTypes.InputDataReading_2036);
					types.add(ScrmElementTypes.DataHandling_2037);
					types.add(ScrmElementTypes.ResultsOutput_2038);
					types.add(ScrmElementTypes.ErrorHandling_2039);
					types.add(ScrmElementTypes.StatusMonitoring_2040);
					types.add(ScrmElementTypes.DataProcessSpace_2046);
					types.add(ScrmElementTypes.StatusMonitoring_3016);
					types.add(ScrmElementTypes.ResultsOutput_3017);
					types.add(ScrmElementTypes.Process_3018);
					types.add(ScrmElementTypes.InputDataReading_3019);
					types.add(ScrmElementTypes.ErrorHandling_3020);
					types.add(ScrmElementTypes.DataHandling_3021);
					types.add(ScrmElementTypes.DataProcessSpace_3022);
				}
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class ResultsOutputFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureResultsOutput_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureResultsOutput_description;

		/**
		 * @generated
		 */
		public ResultsOutputFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(32),
					getMapMode().DPtoLP(32)));
			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(160),
					getMapMode().DPtoLP(65)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureResultsOutput_name = new WrappingLabel();
			fFigureResultsOutput_name.setText("");

			fFigureResultsOutput_name.setFont(FFIGURERESULTSOUTPUT_NAME_FONT);

			GridData constraintFFigureResultsOutput_name = new GridData();
			constraintFFigureResultsOutput_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureResultsOutput_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureResultsOutput_name.horizontalIndent = 0;
			constraintFFigureResultsOutput_name.horizontalSpan = 1;
			constraintFFigureResultsOutput_name.verticalSpan = 1;
			constraintFFigureResultsOutput_name.grabExcessHorizontalSpace = false;
			constraintFFigureResultsOutput_name.grabExcessVerticalSpace = false;
			this.add(fFigureResultsOutput_name,
					constraintFFigureResultsOutput_name);

			fFigureResultsOutput_description = new WrappingLabel();
			fFigureResultsOutput_description.setText("");

			GridData constraintFFigureResultsOutput_description = new GridData();
			constraintFFigureResultsOutput_description.verticalAlignment = GridData.BEGINNING;
			constraintFFigureResultsOutput_description.horizontalAlignment = GridData.FILL;
			constraintFFigureResultsOutput_description.horizontalIndent = 0;
			constraintFFigureResultsOutput_description.horizontalSpan = 1;
			constraintFFigureResultsOutput_description.verticalSpan = 1;
			constraintFFigureResultsOutput_description.grabExcessHorizontalSpace = true;
			constraintFFigureResultsOutput_description.grabExcessVerticalSpace = false;
			this.add(fFigureResultsOutput_description,
					constraintFFigureResultsOutput_description);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureResultsOutput_name() {
			return fFigureResultsOutput_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureResultsOutput_description() {
			return fFigureResultsOutput_description;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 51, 204, 255);

	/**
	 * @generated
	 */
	static final Font FFIGURERESULTSOUTPUT_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
