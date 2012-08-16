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
import scrm.diagram.edit.policies.DataDefinitionItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenMEEditorPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class DataDefinitionEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2052;

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
	public DataDefinitionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new DataDefinitionItemSemanticEditPolicy());
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
		return primaryShape = new DataDefinitionFigure();
	}

	/**
	 * @generated
	 */
	public DataDefinitionFigure getPrimaryShape() {
		return (DataDefinitionFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof DataDefinitionNameEditPart) {
			((DataDefinitionNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureDataDefinition_name());
			return true;
		}
		if (childEditPart instanceof DataDefinitionDescriptionEditPart) {
			((DataDefinitionDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureDataDefinition_description());
			return true;
		}
		if (childEditPart instanceof DataDefinitionAccuracyEditPart) {
			((DataDefinitionAccuracyEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureDataDefinition_accuracy());
			return true;
		}
		if (childEditPart instanceof DataDefinitionFormatEditPart) {
			((DataDefinitionFormatEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureDataDefinition_format());
			return true;
		}
		if (childEditPart instanceof DataDefinitionRangeEditPart) {
			((DataDefinitionRangeEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureDataDefinition_range());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof DataDefinitionNameEditPart) {
			return true;
		}
		if (childEditPart instanceof DataDefinitionDescriptionEditPart) {
			return true;
		}
		if (childEditPart instanceof DataDefinitionAccuracyEditPart) {
			return true;
		}
		if (childEditPart instanceof DataDefinitionFormatEditPart) {
			return true;
		}
		if (childEditPart instanceof DataDefinitionRangeEditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(160, 120);
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
				.getType(DataDefinitionNameEditPart.VISUAL_ID));
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
	public class DataDefinitionFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureDataDefinition_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDataDefinition_description;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDataDefinition_accuracy;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDataDefinition_range;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDataDefinition_format;

		/**
		 * @generated
		 */
		public DataDefinitionFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(32),
					getMapMode().DPtoLP(32)));
			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(160),
					getMapMode().DPtoLP(120)));
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureDataDefinition_name = new WrappingLabel();
			fFigureDataDefinition_name.setText("");

			fFigureDataDefinition_name.setFont(FFIGUREDATADEFINITION_NAME_FONT);

			GridData constraintFFigureDataDefinition_name = new GridData();
			constraintFFigureDataDefinition_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureDataDefinition_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureDataDefinition_name.horizontalIndent = 0;
			constraintFFigureDataDefinition_name.horizontalSpan = 1;
			constraintFFigureDataDefinition_name.verticalSpan = 1;
			constraintFFigureDataDefinition_name.grabExcessHorizontalSpace = false;
			constraintFFigureDataDefinition_name.grabExcessVerticalSpace = false;
			this.add(fFigureDataDefinition_name,
					constraintFFigureDataDefinition_name);

			fFigureDataDefinition_description = new WrappingLabel();
			fFigureDataDefinition_description.setText("");
			fFigureDataDefinition_description.setTextWrap(true);

			GridData constraintFFigureDataDefinition_description = new GridData();
			constraintFFigureDataDefinition_description.verticalAlignment = GridData.BEGINNING;
			constraintFFigureDataDefinition_description.horizontalAlignment = GridData.FILL;
			constraintFFigureDataDefinition_description.horizontalIndent = 0;
			constraintFFigureDataDefinition_description.horizontalSpan = 1;
			constraintFFigureDataDefinition_description.verticalSpan = 1;
			constraintFFigureDataDefinition_description.grabExcessHorizontalSpace = true;
			constraintFFigureDataDefinition_description.grabExcessVerticalSpace = false;
			this.add(fFigureDataDefinition_description,
					constraintFFigureDataDefinition_description);

			fFigureDataDefinition_accuracy = new WrappingLabel();
			fFigureDataDefinition_accuracy.setText("");
			fFigureDataDefinition_accuracy.setTextWrap(true);

			GridData constraintFFigureDataDefinition_accuracy = new GridData();
			constraintFFigureDataDefinition_accuracy.verticalAlignment = GridData.BEGINNING;
			constraintFFigureDataDefinition_accuracy.horizontalAlignment = GridData.FILL;
			constraintFFigureDataDefinition_accuracy.horizontalIndent = 0;
			constraintFFigureDataDefinition_accuracy.horizontalSpan = 1;
			constraintFFigureDataDefinition_accuracy.verticalSpan = 1;
			constraintFFigureDataDefinition_accuracy.grabExcessHorizontalSpace = true;
			constraintFFigureDataDefinition_accuracy.grabExcessVerticalSpace = false;
			this.add(fFigureDataDefinition_accuracy,
					constraintFFigureDataDefinition_accuracy);

			fFigureDataDefinition_range = new WrappingLabel();
			fFigureDataDefinition_range.setText("");
			fFigureDataDefinition_range.setTextWrap(true);

			GridData constraintFFigureDataDefinition_range = new GridData();
			constraintFFigureDataDefinition_range.verticalAlignment = GridData.BEGINNING;
			constraintFFigureDataDefinition_range.horizontalAlignment = GridData.FILL;
			constraintFFigureDataDefinition_range.horizontalIndent = 0;
			constraintFFigureDataDefinition_range.horizontalSpan = 1;
			constraintFFigureDataDefinition_range.verticalSpan = 1;
			constraintFFigureDataDefinition_range.grabExcessHorizontalSpace = true;
			constraintFFigureDataDefinition_range.grabExcessVerticalSpace = false;
			this.add(fFigureDataDefinition_range,
					constraintFFigureDataDefinition_range);

			fFigureDataDefinition_format = new WrappingLabel();
			fFigureDataDefinition_format.setText("");
			fFigureDataDefinition_format.setTextWrap(true);

			GridData constraintFFigureDataDefinition_format = new GridData();
			constraintFFigureDataDefinition_format.verticalAlignment = GridData.BEGINNING;
			constraintFFigureDataDefinition_format.horizontalAlignment = GridData.FILL;
			constraintFFigureDataDefinition_format.horizontalIndent = 0;
			constraintFFigureDataDefinition_format.horizontalSpan = 1;
			constraintFFigureDataDefinition_format.verticalSpan = 1;
			constraintFFigureDataDefinition_format.grabExcessHorizontalSpace = true;
			constraintFFigureDataDefinition_format.grabExcessVerticalSpace = false;
			this.add(fFigureDataDefinition_format,
					constraintFFigureDataDefinition_format);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDataDefinition_name() {
			return fFigureDataDefinition_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDataDefinition_description() {
			return fFigureDataDefinition_description;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDataDefinition_accuracy() {
			return fFigureDataDefinition_accuracy;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDataDefinition_range() {
			return fFigureDataDefinition_range;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDataDefinition_format() {
			return fFigureDataDefinition_format;
		}

	}

	/**
	 * @generated NOT: adjusted color
	 */
	static final Color THIS_BACK = new Color(null, 51, 255, 102);

	/**
	 * @generated
	 */
	static final Font FFIGUREDATADEFINITION_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
