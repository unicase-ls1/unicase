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
import scrm.diagram.edit.policies.SeismicSourceItemSemanticEditPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class SeismicSourceEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2053;

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
	public SeismicSourceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new SeismicSourceItemSemanticEditPolicy());
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
		return primaryShape = new SeismicSourceFigure();
	}

	/**
	 * @generated
	 */
	public SeismicSourceFigure getPrimaryShape() {
		return (SeismicSourceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof SeismicSourceNameEditPart) {
			((SeismicSourceNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureSeismicSource_name());
			return true;
		}
		if (childEditPart instanceof SeismicSourceDescriptionEditPart) {
			((SeismicSourceDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureSeismicSource_description());
			return true;
		}
		if (childEditPart instanceof SeismicSourceAccuracyEditPart) {
			((SeismicSourceAccuracyEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureSeismicSource_accuracy());
			return true;
		}
		if (childEditPart instanceof SeismicSourceFormatEditPart) {
			((SeismicSourceFormatEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureSeismicSource_format());
			return true;
		}
		if (childEditPart instanceof SeismicSourceRangeEditPart) {
			((SeismicSourceRangeEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureSeismicSource_range());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof SeismicSourceNameEditPart) {
			return true;
		}
		if (childEditPart instanceof SeismicSourceDescriptionEditPart) {
			return true;
		}
		if (childEditPart instanceof SeismicSourceAccuracyEditPart) {
			return true;
		}
		if (childEditPart instanceof SeismicSourceFormatEditPart) {
			return true;
		}
		if (childEditPart instanceof SeismicSourceRangeEditPart) {
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
	 * @generated NOT: adjusted size
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
				.getType(SeismicSourceNameEditPart.VISUAL_ID));
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
	public class SeismicSourceFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureSeismicSource_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSeismicSource_description;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSeismicSource_accuracy;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSeismicSource_range;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSeismicSource_format;

		/**
		 * @generated NOT: adjusted size
		 */
		public SeismicSourceFigure() {

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
		 * @generated NOT: enabled text wrap
		 */
		private void createContents() {

			fFigureSeismicSource_name = new WrappingLabel();
			fFigureSeismicSource_name.setText("");

			fFigureSeismicSource_name.setFont(FFIGURESEISMICSOURCE_NAME_FONT);

			GridData constraintFFigureSeismicSource_name = new GridData();
			constraintFFigureSeismicSource_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSeismicSource_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureSeismicSource_name.horizontalIndent = 0;
			constraintFFigureSeismicSource_name.horizontalSpan = 1;
			constraintFFigureSeismicSource_name.verticalSpan = 1;
			constraintFFigureSeismicSource_name.grabExcessHorizontalSpace = false;
			constraintFFigureSeismicSource_name.grabExcessVerticalSpace = false;
			this.add(fFigureSeismicSource_name,
					constraintFFigureSeismicSource_name);

			fFigureSeismicSource_description = new WrappingLabel();
			fFigureSeismicSource_description.setText("");
			fFigureSeismicSource_description.setTextWrap(true);

			GridData constraintFFigureSeismicSource_description = new GridData();
			constraintFFigureSeismicSource_description.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSeismicSource_description.horizontalAlignment = GridData.FILL;
			constraintFFigureSeismicSource_description.horizontalIndent = 0;
			constraintFFigureSeismicSource_description.horizontalSpan = 1;
			constraintFFigureSeismicSource_description.verticalSpan = 1;
			constraintFFigureSeismicSource_description.grabExcessHorizontalSpace = true;
			constraintFFigureSeismicSource_description.grabExcessVerticalSpace = false;
			this.add(fFigureSeismicSource_description,
					constraintFFigureSeismicSource_description);

			fFigureSeismicSource_accuracy = new WrappingLabel();
			fFigureSeismicSource_accuracy.setText("");
			fFigureSeismicSource_accuracy.setTextWrap(true);

			GridData constraintFFigureSeismicSource_accuracy = new GridData();
			constraintFFigureSeismicSource_accuracy.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSeismicSource_accuracy.horizontalAlignment = GridData.FILL;
			constraintFFigureSeismicSource_accuracy.horizontalIndent = 0;
			constraintFFigureSeismicSource_accuracy.horizontalSpan = 1;
			constraintFFigureSeismicSource_accuracy.verticalSpan = 1;
			constraintFFigureSeismicSource_accuracy.grabExcessHorizontalSpace = true;
			constraintFFigureSeismicSource_accuracy.grabExcessVerticalSpace = false;
			this.add(fFigureSeismicSource_accuracy,
					constraintFFigureSeismicSource_accuracy);

			fFigureSeismicSource_range = new WrappingLabel();
			fFigureSeismicSource_range.setText("");
			fFigureSeismicSource_range.setTextWrap(true);

			GridData constraintFFigureSeismicSource_range = new GridData();
			constraintFFigureSeismicSource_range.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSeismicSource_range.horizontalAlignment = GridData.FILL;
			constraintFFigureSeismicSource_range.horizontalIndent = 0;
			constraintFFigureSeismicSource_range.horizontalSpan = 1;
			constraintFFigureSeismicSource_range.verticalSpan = 1;
			constraintFFigureSeismicSource_range.grabExcessHorizontalSpace = true;
			constraintFFigureSeismicSource_range.grabExcessVerticalSpace = false;
			this.add(fFigureSeismicSource_range,
					constraintFFigureSeismicSource_range);

			fFigureSeismicSource_format = new WrappingLabel();
			fFigureSeismicSource_format.setText("");
			fFigureSeismicSource_format.setTextWrap(true);

			GridData constraintFFigureSeismicSource_format = new GridData();
			constraintFFigureSeismicSource_format.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSeismicSource_format.horizontalAlignment = GridData.FILL;
			constraintFFigureSeismicSource_format.horizontalIndent = 0;
			constraintFFigureSeismicSource_format.horizontalSpan = 1;
			constraintFFigureSeismicSource_format.verticalSpan = 1;
			constraintFFigureSeismicSource_format.grabExcessHorizontalSpace = true;
			constraintFFigureSeismicSource_format.grabExcessVerticalSpace = false;
			this.add(fFigureSeismicSource_format,
					constraintFFigureSeismicSource_format);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSeismicSource_name() {
			return fFigureSeismicSource_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSeismicSource_description() {
			return fFigureSeismicSource_description;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSeismicSource_accuracy() {
			return fFigureSeismicSource_accuracy;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSeismicSource_range() {
			return fFigureSeismicSource_range;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSeismicSource_format() {
			return fFigureSeismicSource_format;
		}

	}

	/**
	 * @generated NOT: adjusted color
	 */
	static final Color THIS_BACK = new Color(null, 51, 255, 102);

	/**
	 * @generated
	 */
	static final Font FFIGURESEISMICSOURCE_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
