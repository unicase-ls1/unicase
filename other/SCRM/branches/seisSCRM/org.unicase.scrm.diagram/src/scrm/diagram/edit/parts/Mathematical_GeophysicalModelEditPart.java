package scrm.diagram.edit.parts;

import java.util.ArrayList;
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
import scrm.diagram.edit.policies.Mathematical_GeophysicalModelItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenMEEditorPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class Mathematical_GeophysicalModelEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2047;

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
	public Mathematical_GeophysicalModelEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new Mathematical_GeophysicalModelItemSemanticEditPolicy());
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
		return primaryShape = new Mathematical_GeophysicalModelFigure();
	}

	/**
	 * @generated
	 */
	public Mathematical_GeophysicalModelFigure getPrimaryShape() {
		return (Mathematical_GeophysicalModelFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof Mathematical_GeophysicalModelNameEditPart) {
			((Mathematical_GeophysicalModelNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureMathematical_GeophysicalModel_name());
			return true;
		}
		if (childEditPart instanceof Mathematical_GeophysicalModelDescriptionEditPart) {
			((Mathematical_GeophysicalModelDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureMathematical_GeophysicalModel_description());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof Mathematical_GeophysicalModelNameEditPart) {
			return true;
		}
		if (childEditPart instanceof Mathematical_GeophysicalModelDescriptionEditPart) {
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
				.getType(Mathematical_GeophysicalModelNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(4);
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
			types.add(ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067);
		case KNOWLEDGE_DIAGRAM:
			types.add(ScrmElementTypes.Mathematical_GeophysicalModelRefinements_4064);
			types.add(ScrmElementTypes.Mathematical_GeophysicalModelUsedInNumericalMethods_4065);
			types.add(ScrmElementTypes.Mathematical_GeophysicalModelDependencies_4066);
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
			if (targetEditPart instanceof DataDefinitionEditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067);
			}
			if (targetEditPart instanceof SeismicSourceEditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067);
			}
			if (targetEditPart instanceof ComputationalMeshEditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067);
			}
			if (targetEditPart instanceof SyntheticSeismogramEditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067);
			}
			if (targetEditPart instanceof StationEditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067);
			}
			if (targetEditPart instanceof DataDefinition2EditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067);
			}
			if (targetEditPart instanceof SeismicSource2EditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067);
			}
			if (targetEditPart instanceof ComputationalMesh2EditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067);
			}
			if (targetEditPart instanceof SyntheticSeismogram2EditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067);
			}
			if (targetEditPart instanceof Station2EditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067);
			}
		case KNOWLEDGE_DIAGRAM:
			if (targetEditPart instanceof Mathematical_GeophysicalModelEditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelRefinements_4064);
			}
			if (targetEditPart instanceof scrm.diagram.edit.parts.Mathematical_GeophysicalModel2EditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelRefinements_4064);
			}
			if (targetEditPart instanceof NumericalMethodEditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelUsedInNumericalMethods_4065);
			}
			if (targetEditPart instanceof NumericalMethod2EditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelUsedInNumericalMethods_4065);
			}
			if (targetEditPart instanceof AssumptionEditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelDependencies_4066);
			}
			if (targetEditPart instanceof Assumption2EditPart) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModelDependencies_4066);
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
			if (relationshipType == ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067) {
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
			}
		case KNOWLEDGE_DIAGRAM:
			if (relationshipType == ScrmElementTypes.Mathematical_GeophysicalModelRefinements_4064) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModel_2047);
				types.add(ScrmElementTypes.Mathematical_GeophysicalModel_3030);
			} else if (relationshipType == ScrmElementTypes.Mathematical_GeophysicalModelUsedInNumericalMethods_4065) {
				types.add(ScrmElementTypes.NumericalMethod_2006);
				types.add(ScrmElementTypes.NumericalMethod_3002);
			} else if (relationshipType == ScrmElementTypes.Mathematical_GeophysicalModelDependencies_4066) {
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
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
		case KNOWLEDGE_DIAGRAM:
			types.add(ScrmElementTypes.ScientificProblemRepresentingModel_4063);
			types.add(ScrmElementTypes.Mathematical_GeophysicalModelRefinements_4064);
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
		case KNOWLEDGE_DIAGRAM:
			if (relationshipType == ScrmElementTypes.ScientificProblemRepresentingModel_4063) {
				types.add(ScrmElementTypes.ScientificProblem_2007);
				types.add(ScrmElementTypes.ScientificProblem_3001);
			} else if (relationshipType == ScrmElementTypes.Mathematical_GeophysicalModelRefinements_4064) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModel_2047);
				types.add(ScrmElementTypes.Mathematical_GeophysicalModel_3030);
			}
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class Mathematical_GeophysicalModelFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMathematical_GeophysicalModel_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureMathematical_GeophysicalModel_description;

		/**
		 * @generated
		 */
		public Mathematical_GeophysicalModelFigure() {

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
		 * @generated NOT: enabled text wrap
		 */
		private void createContents() {

			fFigureMathematical_GeophysicalModel_name = new WrappingLabel();
			fFigureMathematical_GeophysicalModel_name.setText("");

			fFigureMathematical_GeophysicalModel_name
					.setFont(FFIGUREMATHEMATICAL_GEOPHYSICALMODEL_NAME_FONT);

			GridData constraintFFigureMathematical_GeophysicalModel_name = new GridData();
			constraintFFigureMathematical_GeophysicalModel_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureMathematical_GeophysicalModel_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureMathematical_GeophysicalModel_name.horizontalIndent = 0;
			constraintFFigureMathematical_GeophysicalModel_name.horizontalSpan = 1;
			constraintFFigureMathematical_GeophysicalModel_name.verticalSpan = 1;
			constraintFFigureMathematical_GeophysicalModel_name.grabExcessHorizontalSpace = false;
			constraintFFigureMathematical_GeophysicalModel_name.grabExcessVerticalSpace = false;
			this.add(fFigureMathematical_GeophysicalModel_name,
					constraintFFigureMathematical_GeophysicalModel_name);

			fFigureMathematical_GeophysicalModel_description = new WrappingLabel();
			fFigureMathematical_GeophysicalModel_description.setText("");
			fFigureMathematical_GeophysicalModel_description.setTextWrap(true);

			GridData constraintFFigureMathematical_GeophysicalModel_description = new GridData();
			constraintFFigureMathematical_GeophysicalModel_description.verticalAlignment = GridData.BEGINNING;
			constraintFFigureMathematical_GeophysicalModel_description.horizontalAlignment = GridData.FILL;
			constraintFFigureMathematical_GeophysicalModel_description.horizontalIndent = 0;
			constraintFFigureMathematical_GeophysicalModel_description.horizontalSpan = 1;
			constraintFFigureMathematical_GeophysicalModel_description.verticalSpan = 1;
			constraintFFigureMathematical_GeophysicalModel_description.grabExcessHorizontalSpace = true;
			constraintFFigureMathematical_GeophysicalModel_description.grabExcessVerticalSpace = false;
			this.add(fFigureMathematical_GeophysicalModel_description,
					constraintFFigureMathematical_GeophysicalModel_description);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMathematical_GeophysicalModel_name() {
			return fFigureMathematical_GeophysicalModel_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMathematical_GeophysicalModel_description() {
			return fFigureMathematical_GeophysicalModel_description;
		}

	}

	/**
	 * @generated NOT: adjusted color
	 */
	static final Color THIS_BACK = new Color(null, 255, 153, 0);

	/**
	 * @generated
	 */
	static final Font FFIGUREMATHEMATICAL_GEOPHYSICALMODEL_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
