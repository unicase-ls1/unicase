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
import scrm.diagram.edit.policies.OpenMEEditorPolicy;
import scrm.diagram.edit.policies.StationItemSemanticEditPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class StationEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2056;

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
	public StationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new StationItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenMEEditorPolicy());
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
		return primaryShape = new StationFigure();
	}

	/**
	 * @generated
	 */
	public StationFigure getPrimaryShape() {
		return (StationFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StationNameEditPart) {
			((StationNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureStation_name());
			return true;
		}
		if (childEditPart instanceof StationDescriptionEditPart) {
			((StationDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureStation_description());
			return true;
		}
		if (childEditPart instanceof StationAccuracyEditPart) {
			((StationAccuracyEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureStation_accuracy());
			return true;
		}
		if (childEditPart instanceof StationFormatEditPart) {
			((StationFormatEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureStation_format());
			return true;
		}
		if (childEditPart instanceof StationRangeEditPart) {
			((StationRangeEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureStation_range());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StationNameEditPart) {
			return true;
		}
		if (childEditPart instanceof StationDescriptionEditPart) {
			return true;
		}
		if (childEditPart instanceof StationAccuracyEditPart) {
			return true;
		}
		if (childEditPart instanceof StationFormatEditPart) {
			return true;
		}
		if (childEditPart instanceof StationRangeEditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(130, 65);
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
				.getType(StationNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
		case REQUIREMENTS_DIAGRAM:
			types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			types.add(ScrmElementTypes.DataDefinitionProvidedInterface_4076);
			types.add(ScrmElementTypes.DataDefinitionRequiredInterface_4077);
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
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof PerformanceEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof ProcessEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof InputDataReadingEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof ResultsOutputEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof ErrorHandlingEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof StatusMonitoringEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof SolverEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof MeshCreationEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof PreProcessingEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof PostProcessingEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof DataProcessSpaceEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof Requirement2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof Performance2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof Process2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof InputDataReading2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof ResultsOutput2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof ErrorHandling2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof StatusMonitoring2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof Solver2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof MeshCreation2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof PreProcessing2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof PostProcessing2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof DataProcessSpace2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof UserInterfaceEditPart) {
				types.add(ScrmElementTypes.DataDefinitionProvidedInterface_4076);
			}
			if (targetEditPart instanceof SoftwareInterfaceEditPart) {
				types.add(ScrmElementTypes.DataDefinitionProvidedInterface_4076);
			}
			if (targetEditPart instanceof UserInterface2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionProvidedInterface_4076);
			}
			if (targetEditPart instanceof SoftwareInterface2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionProvidedInterface_4076);
			}
			if (targetEditPart instanceof UserInterfaceEditPart) {
				types.add(ScrmElementTypes.DataDefinitionRequiredInterface_4077);
			}
			if (targetEditPart instanceof SoftwareInterfaceEditPart) {
				types.add(ScrmElementTypes.DataDefinitionRequiredInterface_4077);
			}
			if (targetEditPart instanceof UserInterface2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionRequiredInterface_4077);
			}
			if (targetEditPart instanceof SoftwareInterface2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionRequiredInterface_4077);
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
			if (relationshipType == ScrmElementTypes.DataDefinitionDefinedRequirement_4075) {
				types.add(ScrmElementTypes.Requirement_2034);
				types.add(ScrmElementTypes.Performance_2015);
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
				types.add(ScrmElementTypes.Requirement_3012);
				types.add(ScrmElementTypes.Performance_3011);
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
			} else if (relationshipType == ScrmElementTypes.DataDefinitionProvidedInterface_4076) {
				types.add(ScrmElementTypes.UserInterface_2012);
				types.add(ScrmElementTypes.SoftwareInterface_2013);
				types.add(ScrmElementTypes.UserInterface_3014);
				types.add(ScrmElementTypes.SoftwareInterface_3013);
			} else if (relationshipType == ScrmElementTypes.DataDefinitionRequiredInterface_4077) {
				types.add(ScrmElementTypes.UserInterface_2012);
				types.add(ScrmElementTypes.SoftwareInterface_2013);
				types.add(ScrmElementTypes.UserInterface_3014);
				types.add(ScrmElementTypes.SoftwareInterface_3013);
			}
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
			types.add(ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067);
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
			if (relationshipType == ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModel_2047);
				types.add(ScrmElementTypes.Mathematical_GeophysicalModel_3030);
			}
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class StationFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureStation_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureStation_description;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureStation_accuracy;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureStation_range;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureStation_format;

		/**
		 * @generated
		 */
		public StationFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(32),
					getMapMode().DPtoLP(32)));
			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(130),
					getMapMode().DPtoLP(65)));
			createContents();
		}

		/**
		 * @generated NOT: enabled text wrap
		 */
		private void createContents() {

			fFigureStation_name = new WrappingLabel();
			fFigureStation_name.setText("");

			fFigureStation_name.setFont(FFIGURESTATION_NAME_FONT);

			GridData constraintFFigureStation_name = new GridData();
			constraintFFigureStation_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureStation_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureStation_name.horizontalIndent = 0;
			constraintFFigureStation_name.horizontalSpan = 1;
			constraintFFigureStation_name.verticalSpan = 1;
			constraintFFigureStation_name.grabExcessHorizontalSpace = false;
			constraintFFigureStation_name.grabExcessVerticalSpace = false;
			this.add(fFigureStation_name, constraintFFigureStation_name);

			fFigureStation_description = new WrappingLabel();
			fFigureStation_description.setText("");
			fFigureStation_description.setTextWrap(true);

			GridData constraintFFigureStation_description = new GridData();
			constraintFFigureStation_description.verticalAlignment = GridData.BEGINNING;
			constraintFFigureStation_description.horizontalAlignment = GridData.FILL;
			constraintFFigureStation_description.horizontalIndent = 0;
			constraintFFigureStation_description.horizontalSpan = 1;
			constraintFFigureStation_description.verticalSpan = 1;
			constraintFFigureStation_description.grabExcessHorizontalSpace = true;
			constraintFFigureStation_description.grabExcessVerticalSpace = false;
			this.add(fFigureStation_description,
					constraintFFigureStation_description);

			fFigureStation_accuracy = new WrappingLabel();
			fFigureStation_accuracy.setText("");
			fFigureStation_accuracy.setTextWrap(true);

			GridData constraintFFigureStation_accuracy = new GridData();
			constraintFFigureStation_accuracy.verticalAlignment = GridData.BEGINNING;
			constraintFFigureStation_accuracy.horizontalAlignment = GridData.FILL;
			constraintFFigureStation_accuracy.horizontalIndent = 0;
			constraintFFigureStation_accuracy.horizontalSpan = 1;
			constraintFFigureStation_accuracy.verticalSpan = 1;
			constraintFFigureStation_accuracy.grabExcessHorizontalSpace = true;
			constraintFFigureStation_accuracy.grabExcessVerticalSpace = false;
			this.add(fFigureStation_accuracy, constraintFFigureStation_accuracy);

			fFigureStation_range = new WrappingLabel();
			fFigureStation_range.setText("");
			fFigureStation_range.setTextWrap(true);

			GridData constraintFFigureStation_range = new GridData();
			constraintFFigureStation_range.verticalAlignment = GridData.BEGINNING;
			constraintFFigureStation_range.horizontalAlignment = GridData.FILL;
			constraintFFigureStation_range.horizontalIndent = 0;
			constraintFFigureStation_range.horizontalSpan = 1;
			constraintFFigureStation_range.verticalSpan = 1;
			constraintFFigureStation_range.grabExcessHorizontalSpace = true;
			constraintFFigureStation_range.grabExcessVerticalSpace = false;
			this.add(fFigureStation_range, constraintFFigureStation_range);

			fFigureStation_format = new WrappingLabel();
			fFigureStation_format.setText("");
			fFigureStation_format.setTextWrap(true);

			GridData constraintFFigureStation_format = new GridData();
			constraintFFigureStation_format.verticalAlignment = GridData.BEGINNING;
			constraintFFigureStation_format.horizontalAlignment = GridData.FILL;
			constraintFFigureStation_format.horizontalIndent = 0;
			constraintFFigureStation_format.horizontalSpan = 1;
			constraintFFigureStation_format.verticalSpan = 1;
			constraintFFigureStation_format.grabExcessHorizontalSpace = true;
			constraintFFigureStation_format.grabExcessVerticalSpace = false;
			this.add(fFigureStation_format, constraintFFigureStation_format);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStation_name() {
			return fFigureStation_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStation_description() {
			return fFigureStation_description;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStation_accuracy() {
			return fFigureStation_accuracy;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStation_range() {
			return fFigureStation_range;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStation_format() {
			return fFigureStation_format;
		}

	}

	/**
	 * @generated NOT: adjusted color
	 */
	static final Color THIS_BACK = new Color(null, 51, 255, 102);

	/**
	 * @generated
	 */
	static final Font FFIGURESTATION_NAME_FONT = new Font(Display.getCurrent(),
			"Arial", 9, SWT.BOLD);

}
