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
import scrm.diagram.edit.policies.ControlParameterItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenMEEditorPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class ControlParameterEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2057;

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
	public ControlParameterEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ControlParameterItemSemanticEditPolicy());
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
		return primaryShape = new ControlParameterFigure();
	}

	/**
	 * @generated
	 */
	public ControlParameterFigure getPrimaryShape() {
		return (ControlParameterFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ControlParameterNameEditPart) {
			((ControlParameterNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureControlParameter_name());
			return true;
		}
		if (childEditPart instanceof ControlParameterDescriptionEditPart) {
			((ControlParameterDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureControlParameter_description());
			return true;
		}
		if (childEditPart instanceof ControlParameterFormatEditPart) {
			((ControlParameterFormatEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureControlParameter_format());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ControlParameterNameEditPart) {
			return true;
		}
		if (childEditPart instanceof ControlParameterDescriptionEditPart) {
			return true;
		}
		if (childEditPart instanceof ControlParameterFormatEditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(170, 85);
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
				.getType(ControlParameterNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
		case REQUIREMENTS_DIAGRAM:
			types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
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
			if (targetEditPart instanceof ProcessEditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof InputDataReadingEditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof ResultsOutputEditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof ErrorHandlingEditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof StatusMonitoringEditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof SolverEditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof MeshCreationEditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof PreProcessingEditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof PostProcessingEditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof DataProcessSpaceEditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof Process2EditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof InputDataReading2EditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof ResultsOutput2EditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof ErrorHandling2EditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof StatusMonitoring2EditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof Solver2EditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof MeshCreation2EditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof PreProcessing2EditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof PostProcessing2EditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
			}
			if (targetEditPart instanceof DataProcessSpace2EditPart) {
				types.add(ScrmElementTypes.ControlParameterControlledProcess_4078);
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
			if (relationshipType == ScrmElementTypes.ControlParameterControlledProcess_4078) {
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
	 * @generated
	 */
	public class ControlParameterFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureControlParameter_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureControlParameter_description;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureControlParameter_format;

		/**
		 * @generated
		 */
		public ControlParameterFigure() {

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
		 * @generated NOT
		 */
		private void createContents() {

			fFigureControlParameter_name = new WrappingLabel();
			fFigureControlParameter_name.setText("");

			fFigureControlParameter_name
					.setFont(FFIGURECONTROLPARAMETER_NAME_FONT);

			GridData constraintFFigureControlParameter_name = new GridData();
			constraintFFigureControlParameter_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureControlParameter_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureControlParameter_name.horizontalIndent = 0;
			constraintFFigureControlParameter_name.horizontalSpan = 1;
			constraintFFigureControlParameter_name.verticalSpan = 1;
			constraintFFigureControlParameter_name.grabExcessHorizontalSpace = false;
			constraintFFigureControlParameter_name.grabExcessVerticalSpace = false;
			this.add(fFigureControlParameter_name,
					constraintFFigureControlParameter_name);

			fFigureControlParameter_description = new WrappingLabel();
			fFigureControlParameter_description.setText("");
			fFigureControlParameter_description.setTextWrap(true);

			GridData constraintFFigureControlParameter_description = new GridData();
			constraintFFigureControlParameter_description.verticalAlignment = GridData.BEGINNING;
			constraintFFigureControlParameter_description.horizontalAlignment = GridData.FILL;
			constraintFFigureControlParameter_description.horizontalIndent = 0;
			constraintFFigureControlParameter_description.horizontalSpan = 1;
			constraintFFigureControlParameter_description.verticalSpan = 1;
			constraintFFigureControlParameter_description.grabExcessHorizontalSpace = true;
			constraintFFigureControlParameter_description.grabExcessVerticalSpace = false;
			this.add(fFigureControlParameter_description,
					constraintFFigureControlParameter_description);

			fFigureControlParameter_format = new WrappingLabel();
			fFigureControlParameter_format.setText("");
			fFigureControlParameter_format.setTextWrap(true);

			GridData constraintFFigureControlParameter_format = new GridData();
			constraintFFigureControlParameter_format.verticalAlignment = GridData.BEGINNING;
			constraintFFigureControlParameter_format.horizontalAlignment = GridData.FILL;
			constraintFFigureControlParameter_format.horizontalIndent = 0;
			constraintFFigureControlParameter_format.horizontalSpan = 1;
			constraintFFigureControlParameter_format.verticalSpan = 1;
			constraintFFigureControlParameter_format.grabExcessHorizontalSpace = true;
			constraintFFigureControlParameter_format.grabExcessVerticalSpace = false;
			this.add(fFigureControlParameter_format,
					constraintFFigureControlParameter_format);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureControlParameter_name() {
			return fFigureControlParameter_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureControlParameter_description() {
			return fFigureControlParameter_description;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureControlParameter_format() {
			return fFigureControlParameter_format;
		}

	}

	/**
	 * @generated NOT: adjusted color
	 */
	static final Color THIS_BACK = new Color(null, 51, 255, 102);

	/**
	 * @generated
	 */
	static final Font FFIGURECONTROLPARAMETER_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
