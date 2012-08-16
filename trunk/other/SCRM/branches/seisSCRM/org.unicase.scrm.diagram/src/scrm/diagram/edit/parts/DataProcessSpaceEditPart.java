package scrm.diagram.edit.parts;

import java.util.ArrayList;
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
import scrm.diagram.edit.policies.DataProcessSpaceItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenSCRMSpaceEditPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class DataProcessSpaceEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2046;

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
	public DataProcessSpaceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new DataProcessSpaceItemSemanticEditPolicy());
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
		return primaryShape = new DataProcessSpaceFigure();
	}

	/**
	 * @generated
	 */
	public DataProcessSpaceFigure getPrimaryShape() {
		return (DataProcessSpaceFigure) primaryShape;
	}

	/**
	 * @generated NOT
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof DataProcessSpaceNameEditPart) {
			((DataProcessSpaceNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureDataProcessSpace_name());
			return true;
		}
		if (childEditPart instanceof DataProcessSpaceDataProcessSpaceCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureDataProcessSpace_containedDataProcessSteps();
			setupContentPane(pane); // FIXME each comparment should handle his
									// content pane in his own way
			pane.add(((DataProcessSpaceDataProcessSpaceCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated NOT
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof DataProcessSpaceNameEditPart) {
			return true;
		}
		if (childEditPart instanceof DataProcessSpaceDataProcessSpaceCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureDataProcessSpace_containedDataProcessSteps();
			setupContentPane(pane); // FIXME each comparment should handle his
									// content pane in his own way
			pane.remove(((DataProcessSpaceDataProcessSpaceCompartmentEditPart) childEditPart)
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
	 * @generated NOT
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof DataProcessSpaceDataProcessSpaceCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureDataProcessSpace_containedDataProcessSteps();
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
				.getType(DataProcessSpaceNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(5);
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
		case REQUIREMENTS_DIAGRAM:
			types.add(ScrmElementTypes.RequirementSpecifiedFeature_4052);
			types.add(ScrmElementTypes.RequirementProvidedInterface_4072);
			types.add(ScrmElementTypes.RequirementRequiredInterface_4073);
			// break left out on purpose
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
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
		case REQUIREMENTS_DIAGRAM:
			if (targetEditPart instanceof RequirementEditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof PerformanceEditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof Requirement2EditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof Performance2EditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof FeatureEditPart) {
				types.add(ScrmElementTypes.RequirementSpecifiedFeature_4052);
			}
			if (targetEditPart instanceof Feature2EditPart) {
				types.add(ScrmElementTypes.RequirementSpecifiedFeature_4052);
			}
			if (targetEditPart instanceof UserInterfaceEditPart) {
				types.add(ScrmElementTypes.RequirementProvidedInterface_4072);
			}
			if (targetEditPart instanceof SoftwareInterfaceEditPart) {
				types.add(ScrmElementTypes.RequirementProvidedInterface_4072);
			}
			if (targetEditPart instanceof UserInterface2EditPart) {
				types.add(ScrmElementTypes.RequirementProvidedInterface_4072);
			}
			if (targetEditPart instanceof SoftwareInterface2EditPart) {
				types.add(ScrmElementTypes.RequirementProvidedInterface_4072);
			}
			if (targetEditPart instanceof UserInterfaceEditPart) {
				types.add(ScrmElementTypes.RequirementRequiredInterface_4073);
			}
			if (targetEditPart instanceof SoftwareInterfaceEditPart) {
				types.add(ScrmElementTypes.RequirementRequiredInterface_4073);
			}
			if (targetEditPart instanceof UserInterface2EditPart) {
				types.add(ScrmElementTypes.RequirementRequiredInterface_4073);
			}
			if (targetEditPart instanceof SoftwareInterface2EditPart) {
				types.add(ScrmElementTypes.RequirementRequiredInterface_4073);
			}
			// break left out on purpose
		case DATA_PROCESS_DIAGRAM:
			if (targetEditPart instanceof ProcessEditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof InputDataReadingEditPart) {
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
			if (targetEditPart instanceof SolverEditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof MeshCreationEditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof PreProcessingEditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof PostProcessingEditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof DataProcessSpaceEditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof Process2EditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof InputDataReading2EditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof ResultsOutput2EditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof ErrorHandling2EditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof StatusMonitoring2EditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof Solver2EditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof MeshCreation2EditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof PreProcessing2EditPart) {
				types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			}
			if (targetEditPart instanceof PostProcessing2EditPart) {
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
			if (targetEditPart instanceof ResultsOutputEditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof ErrorHandlingEditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof StatusMonitoringEditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof SolverEditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof MeshCreationEditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof PreProcessingEditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof PostProcessingEditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof DataProcessSpaceEditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof Process2EditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof InputDataReading2EditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof ResultsOutput2EditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof ErrorHandling2EditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof StatusMonitoring2EditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof Solver2EditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof MeshCreation2EditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof PreProcessing2EditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
			if (targetEditPart instanceof PostProcessing2EditPart) {
				types.add(ScrmElementTypes.ProcessSuccessor_4047);
			}
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
		case REQUIREMENTS_DIAGRAM:
			if (relationshipType == ScrmElementTypes.RequirementRefinedRequirement_4054) {
				types.add(ScrmElementTypes.Requirement_2034);
				types.add(ScrmElementTypes.Performance_2015);
				types.add(ScrmElementTypes.Requirement_3012);
				types.add(ScrmElementTypes.Performance_3011);
				// no break -> add process elements as well
			} else if (relationshipType == ScrmElementTypes.RequirementSpecifiedFeature_4052) {
				types.add(ScrmElementTypes.Feature_2009);
				types.add(ScrmElementTypes.Feature_3009);
				break;
			} else if (relationshipType == ScrmElementTypes.RequirementProvidedInterface_4072) {
				types.add(ScrmElementTypes.UserInterface_2012);
				types.add(ScrmElementTypes.SoftwareInterface_2013);
				types.add(ScrmElementTypes.UserInterface_3014);
				types.add(ScrmElementTypes.SoftwareInterface_3013);
				break;
			} else if (relationshipType == ScrmElementTypes.RequirementRequiredInterface_4073) {
				types.add(ScrmElementTypes.UserInterface_2012);
				types.add(ScrmElementTypes.SoftwareInterface_2013);
				types.add(ScrmElementTypes.UserInterface_3014);
				types.add(ScrmElementTypes.SoftwareInterface_3013);
				break;
			}
		case DATA_PROCESS_DIAGRAM:
			if (relationshipType == ScrmElementTypes.RequirementRefinedRequirement_4054) {
				types.add(ScrmElementTypes.Process_2035);
				types.add(ScrmElementTypes.InputDataReading_2036);
				types.add(ScrmElementTypes.ResultsOutput_2038);
				types.add(ScrmElementTypes.ErrorHandling_2039);
				types.add(ScrmElementTypes.StatusMonitoring_2040);
				types.add(ScrmElementTypes.Solver_2048);
				types.add(ScrmElementTypes.MeshCreation_2049);
				types.add(ScrmElementTypes.PreProcessing_2050);
				types.add(ScrmElementTypes.PostProcessing_2051);
				types.add(ScrmElementTypes.DataProcessSpace_2046);
				types.add(ScrmElementTypes.Process_3025);
				types.add(ScrmElementTypes.InputDataReading_3026);
				types.add(ScrmElementTypes.ResultsOutput_3024);
				types.add(ScrmElementTypes.ErrorHandling_3027);
				types.add(ScrmElementTypes.StatusMonitoring_3023);
				types.add(ScrmElementTypes.Solver_3031);
				types.add(ScrmElementTypes.MeshCreation_3032);
				types.add(ScrmElementTypes.PreProcessing_3033);
				types.add(ScrmElementTypes.PostProcessing_3034);
				types.add(ScrmElementTypes.DataProcessSpace_3029);
			} else if (relationshipType == ScrmElementTypes.ProcessSuccessor_4047) {
				types.add(ScrmElementTypes.Process_2035);
				types.add(ScrmElementTypes.InputDataReading_2036);
				types.add(ScrmElementTypes.ResultsOutput_2038);
				types.add(ScrmElementTypes.ErrorHandling_2039);
				types.add(ScrmElementTypes.StatusMonitoring_2040);
				types.add(ScrmElementTypes.Solver_2048);
				types.add(ScrmElementTypes.MeshCreation_2049);
				types.add(ScrmElementTypes.PreProcessing_2050);
				types.add(ScrmElementTypes.PostProcessing_2051);
				types.add(ScrmElementTypes.DataProcessSpace_2046);
				types.add(ScrmElementTypes.Process_3025);
				types.add(ScrmElementTypes.InputDataReading_3026);
				types.add(ScrmElementTypes.ResultsOutput_3024);
				types.add(ScrmElementTypes.ErrorHandling_3027);
				types.add(ScrmElementTypes.StatusMonitoring_3023);
				types.add(ScrmElementTypes.Solver_3031);
				types.add(ScrmElementTypes.MeshCreation_3032);
				types.add(ScrmElementTypes.PreProcessing_3033);
				types.add(ScrmElementTypes.PostProcessing_3034);
				types.add(ScrmElementTypes.DataProcessSpace_3029);
			}
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
			types.add(ScrmElementTypes.NumericalMethodRealizingRequirement_4068);
			// break left out on purpose
		case REQUIREMENTS_DIAGRAM:
			types.add(ScrmElementTypes.InterfaceDetailsOfProvidingFunctionsAndProperties_4070);
			types.add(ScrmElementTypes.InterfaceDetailsOfRequiringFunctionsAndProperties_4071);
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
			types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			// break left out on purpose
		case DATA_PROCESS_DIAGRAM:
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
			types.add(ScrmElementTypes.ErrorHandlingHandledProcess_4061);
			types.add(ScrmElementTypes.StatusMonitoringMonitoredProcess_4062);
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
			if (relationshipType == ScrmElementTypes.NumericalMethodRealizingRequirement_4068) {
				types.add(ScrmElementTypes.NumericalMethod_2006);
				types.add(ScrmElementTypes.NumericalMethod_3002);
				break;
			}
		case REQUIREMENTS_DIAGRAM:
			if (relationshipType == ScrmElementTypes.RequirementRefinedRequirement_4054) {
				types.add(ScrmElementTypes.Requirement_2034);
				types.add(ScrmElementTypes.Performance_2015);
				types.add(ScrmElementTypes.Requirement_3012);
				types.add(ScrmElementTypes.Performance_3011);
				// no break -> add process elements as well
			} else if (relationshipType == ScrmElementTypes.InterfaceDetailsOfProvidingFunctionsAndProperties_4070) {
				types.add(ScrmElementTypes.UserInterface_2012);
				types.add(ScrmElementTypes.SoftwareInterface_2013);
				types.add(ScrmElementTypes.UserInterface_3014);
				types.add(ScrmElementTypes.SoftwareInterface_3013);
				break;
			} else if (relationshipType == ScrmElementTypes.InterfaceDetailsOfRequiringFunctionsAndProperties_4071) {
				types.add(ScrmElementTypes.UserInterface_2012);
				types.add(ScrmElementTypes.SoftwareInterface_2013);
				types.add(ScrmElementTypes.UserInterface_3014);
				types.add(ScrmElementTypes.SoftwareInterface_3013);
				break;
			} else if (relationshipType == ScrmElementTypes.DataDefinitionDefinedRequirement_4075) {
				types.add(ScrmElementTypes.DataDefinition_2052);
				types.add(ScrmElementTypes.SeismicSource_2053);
				types.add(ScrmElementTypes.ComputationalMesh_2054);
				types.add(ScrmElementTypes.SyntheticSeismogram_2055);
				types.add(ScrmElementTypes.Station_2056);
				types.add(ScrmElementTypes.DataDefinition_3035);
				types.add(ScrmElementTypes.SeismicSource_3036);
				types.add(ScrmElementTypes.ComputationalMesh_3037);
				types.add(ScrmElementTypes.SyntheticSeismogram_3038);
				types.add(ScrmElementTypes.Station_3039);
				break;
			} else if (relationshipType == ScrmElementTypes.ControlParameterControlledProcess_4078) {
				types.add(ScrmElementTypes.ControlParameter_2057);
				types.add(ScrmElementTypes.ControlParameter_3040);
				break;
			}
		case DATA_PROCESS_DIAGRAM:
			if (relationshipType == ScrmElementTypes.RequirementRefinedRequirement_4054) {
				types.add(ScrmElementTypes.Process_2035);
				types.add(ScrmElementTypes.InputDataReading_2036);
				types.add(ScrmElementTypes.ResultsOutput_2038);
				types.add(ScrmElementTypes.ErrorHandling_2039);
				types.add(ScrmElementTypes.StatusMonitoring_2040);
				types.add(ScrmElementTypes.Solver_2048);
				types.add(ScrmElementTypes.MeshCreation_2049);
				types.add(ScrmElementTypes.PreProcessing_2050);
				types.add(ScrmElementTypes.PostProcessing_2051);
				types.add(ScrmElementTypes.DataProcessSpace_2046);
				types.add(ScrmElementTypes.Process_3025);
				types.add(ScrmElementTypes.InputDataReading_3026);
				types.add(ScrmElementTypes.ResultsOutput_3024);
				types.add(ScrmElementTypes.ErrorHandling_3027);
				types.add(ScrmElementTypes.StatusMonitoring_3023);
				types.add(ScrmElementTypes.Solver_3031);
				types.add(ScrmElementTypes.MeshCreation_3032);
				types.add(ScrmElementTypes.PreProcessing_3033);
				types.add(ScrmElementTypes.PostProcessing_3034);
				types.add(ScrmElementTypes.DataProcessSpace_3029);
			} else if (relationshipType == ScrmElementTypes.ProcessSuccessor_4047) {
				types.add(ScrmElementTypes.Process_2035);
				types.add(ScrmElementTypes.InputDataReading_2036);
				types.add(ScrmElementTypes.ResultsOutput_2038);
				types.add(ScrmElementTypes.ErrorHandling_2039);
				types.add(ScrmElementTypes.StatusMonitoring_2040);
				types.add(ScrmElementTypes.Solver_2048);
				types.add(ScrmElementTypes.MeshCreation_2049);
				types.add(ScrmElementTypes.PreProcessing_2050);
				types.add(ScrmElementTypes.PostProcessing_2051);
				types.add(ScrmElementTypes.DataProcessSpace_2046);
				types.add(ScrmElementTypes.Process_3025);
				types.add(ScrmElementTypes.InputDataReading_3026);
				types.add(ScrmElementTypes.ResultsOutput_3024);
				types.add(ScrmElementTypes.ErrorHandling_3027);
				types.add(ScrmElementTypes.StatusMonitoring_3023);
				types.add(ScrmElementTypes.Solver_3031);
				types.add(ScrmElementTypes.MeshCreation_3032);
				types.add(ScrmElementTypes.PreProcessing_3033);
				types.add(ScrmElementTypes.PostProcessing_3034);
				types.add(ScrmElementTypes.DataProcessSpace_3029);
			} else if (relationshipType == ScrmElementTypes.ErrorHandlingHandledProcess_4061) {
				types.add(ScrmElementTypes.ErrorHandling_2039);
				types.add(ScrmElementTypes.ErrorHandling_3027);
			} else if (relationshipType == ScrmElementTypes.StatusMonitoringMonitoredProcess_4062) {
				types.add(ScrmElementTypes.StatusMonitoring_2040);
				types.add(ScrmElementTypes.StatusMonitoring_3023);
			}
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class DataProcessSpaceFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureDataProcessSpace_name;
		/**
		 * @generated
		 */
		private RoundedRectangle fFigureDataProcessSpace_containedDataProcessSteps;

		/**
		 * @generated
		 */
		public DataProcessSpaceFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(32),
					getMapMode().DPtoLP(32)));
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(300),
					getMapMode().DPtoLP(240)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureDataProcessSpace_name = new WrappingLabel();
			fFigureDataProcessSpace_name.setText("");

			fFigureDataProcessSpace_name
					.setFont(FFIGUREDATAPROCESSSPACE_NAME_FONT);

			GridData constraintFFigureDataProcessSpace_name = new GridData();
			constraintFFigureDataProcessSpace_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureDataProcessSpace_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureDataProcessSpace_name.horizontalIndent = 0;
			constraintFFigureDataProcessSpace_name.horizontalSpan = 1;
			constraintFFigureDataProcessSpace_name.verticalSpan = 1;
			constraintFFigureDataProcessSpace_name.grabExcessHorizontalSpace = false;
			constraintFFigureDataProcessSpace_name.grabExcessVerticalSpace = false;
			this.add(fFigureDataProcessSpace_name,
					constraintFFigureDataProcessSpace_name);

			fFigureDataProcessSpace_containedDataProcessSteps = new RoundedRectangle();
			fFigureDataProcessSpace_containedDataProcessSteps
					.setCornerDimensions(new Dimension(getMapMode().DPtoLP(32),
							getMapMode().DPtoLP(32)));

			GridData constraintFFigureDataProcessSpace_containedDataProcessSteps = new GridData();
			constraintFFigureDataProcessSpace_containedDataProcessSteps.verticalAlignment = GridData.FILL;
			constraintFFigureDataProcessSpace_containedDataProcessSteps.horizontalAlignment = GridData.FILL;
			constraintFFigureDataProcessSpace_containedDataProcessSteps.horizontalIndent = 0;
			constraintFFigureDataProcessSpace_containedDataProcessSteps.horizontalSpan = 1;
			constraintFFigureDataProcessSpace_containedDataProcessSteps.verticalSpan = 1;
			constraintFFigureDataProcessSpace_containedDataProcessSteps.grabExcessHorizontalSpace = true;
			constraintFFigureDataProcessSpace_containedDataProcessSteps.grabExcessVerticalSpace = true;
			this.add(fFigureDataProcessSpace_containedDataProcessSteps,
					constraintFFigureDataProcessSpace_containedDataProcessSteps);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDataProcessSpace_name() {
			return fFigureDataProcessSpace_name;
		}

		/**
		 * @generated
		 */
		public RoundedRectangle getFigureDataProcessSpace_containedDataProcessSteps() {
			return fFigureDataProcessSpace_containedDataProcessSteps;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREDATAPROCESSSPACE_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
