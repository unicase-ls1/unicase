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
import scrm.diagram.edit.policies.FeatureItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenMEEditorPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class FeatureEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2009;

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
	public FeatureEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new FeatureItemSemanticEditPolicy());
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
		return primaryShape = new FeatureFigure();
	}

	/**
	 * @generated
	 */
	public FeatureFigure getPrimaryShape() {
		return (FeatureFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof FeatureNameEditPart) {
			((FeatureNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureFeature_name());
			return true;
		}
		if (childEditPart instanceof FeatureDescriptionEditPart) {
			((FeatureDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureFeature_description());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof FeatureNameEditPart) {
			return true;
		}
		if (childEditPart instanceof FeatureDescriptionEditPart) {
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
				.getType(FeatureNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnSource() {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		List<IElementType> types = new LinkedList<IElementType>();
		switch(scrmDiagram.getDiagramType()) {
			case DEFAULT_DIAGRAM:
			case REQUIREMENTS_DIAGRAM:
				types.add(ScrmElementTypes.FeatureRequiredInterfaces_4023);
				types.add(ScrmElementTypes.FeatureProvidedInterfaces_4024);
				types.add(ScrmElementTypes.FeatureDependencies_4026);
				types.add(ScrmElementTypes.FeatureSuperFeature_4053);
				types.add(ScrmElementTypes.FeatureRequiredFeatures_4030);
				types.add(ScrmElementTypes.FeatureExcludedFeatures_4032);
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
			case REQUIREMENTS_DIAGRAM:
				if (targetEditPart instanceof UserInterfaceEditPart) {
					types.add(ScrmElementTypes.FeatureRequiredInterfaces_4023);
				}
				if (targetEditPart instanceof SoftwareInterfaceEditPart) {
					types.add(ScrmElementTypes.FeatureRequiredInterfaces_4023);
				}
				if (targetEditPart instanceof SoftwareInterface2EditPart) {
					types.add(ScrmElementTypes.FeatureRequiredInterfaces_4023);
				}
				if (targetEditPart instanceof UserInterface2EditPart) {
					types.add(ScrmElementTypes.FeatureRequiredInterfaces_4023);
				}
				if (targetEditPart instanceof UserInterfaceEditPart) {
					types.add(ScrmElementTypes.FeatureProvidedInterfaces_4024);
				}
				if (targetEditPart instanceof SoftwareInterfaceEditPart) {
					types.add(ScrmElementTypes.FeatureProvidedInterfaces_4024);
				}
				if (targetEditPart instanceof SoftwareInterface2EditPart) {
					types.add(ScrmElementTypes.FeatureProvidedInterfaces_4024);
				}
				if (targetEditPart instanceof UserInterface2EditPart) {
					types.add(ScrmElementTypes.FeatureProvidedInterfaces_4024);
				}
				if (targetEditPart instanceof HardwareEditPart) {
					types.add(ScrmElementTypes.FeatureDependencies_4026);
				}
				if (targetEditPart instanceof Hardware2EditPart) {
					types.add(ScrmElementTypes.FeatureDependencies_4026);
				}
				if (targetEditPart instanceof FeatureEditPart) {
					types.add(ScrmElementTypes.FeatureSuperFeature_4053);
				}
				if (targetEditPart instanceof Feature2EditPart) {
					types.add(ScrmElementTypes.FeatureSuperFeature_4053);
				}
				if (targetEditPart instanceof FeatureEditPart) {
					types.add(ScrmElementTypes.FeatureRequiredFeatures_4030);
				}
				if (targetEditPart instanceof Feature2EditPart) {
					types.add(ScrmElementTypes.FeatureRequiredFeatures_4030);
				}
				if (targetEditPart instanceof FeatureEditPart) {
					types.add(ScrmElementTypes.FeatureExcludedFeatures_4032);
				}
				if (targetEditPart instanceof Feature2EditPart) {
					types.add(ScrmElementTypes.FeatureExcludedFeatures_4032);
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
			case REQUIREMENTS_DIAGRAM:
				if (relationshipType == ScrmElementTypes.FeatureRequiredInterfaces_4023) {
					types.add(ScrmElementTypes.UserInterface_2012);
					types.add(ScrmElementTypes.SoftwareInterface_2013);
					types.add(ScrmElementTypes.SoftwareInterface_3013);
					types.add(ScrmElementTypes.UserInterface_3014);
				} else if (relationshipType == ScrmElementTypes.FeatureProvidedInterfaces_4024) {
					types.add(ScrmElementTypes.UserInterface_2012);
					types.add(ScrmElementTypes.SoftwareInterface_2013);
					types.add(ScrmElementTypes.SoftwareInterface_3013);
					types.add(ScrmElementTypes.UserInterface_3014);
				} else if (relationshipType == ScrmElementTypes.FeatureDependencies_4026) {
					types.add(ScrmElementTypes.Hardware_2010);
					types.add(ScrmElementTypes.Hardware_3010);
				} else if (relationshipType == ScrmElementTypes.FeatureSuperFeature_4053) {
					types.add(ScrmElementTypes.Feature_2009);
					types.add(ScrmElementTypes.Feature_3009);
				} else if (relationshipType == ScrmElementTypes.FeatureRequiredFeatures_4030) {
					types.add(ScrmElementTypes.Feature_2009);
					types.add(ScrmElementTypes.Feature_3009);
				} else if (relationshipType == ScrmElementTypes.FeatureExcludedFeatures_4032) {
					types.add(ScrmElementTypes.Feature_2009);
					types.add(ScrmElementTypes.Feature_3009);
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
				types.add(ScrmElementTypes.ScientificProblemInfluencedFeature_4008);
			case REQUIREMENTS_DIAGRAM:
				types.add(ScrmElementTypes.ConstraintRestrictedFeature_4051);
				types.add(ScrmElementTypes.RequirementSpecifiedFeature_4052);
				types.add(ScrmElementTypes.FeatureSuperFeature_4053);
				types.add(ScrmElementTypes.FeatureRequiredFeatures_4030);
				types.add(ScrmElementTypes.FeatureExcludedFeatures_4032);
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
				if (relationshipType == ScrmElementTypes.ScientificProblemInfluencedFeature_4008) {
					types.add(ScrmElementTypes.ScientificProblem_2007);
					types.add(ScrmElementTypes.ScientificProblem_3001);
					break;
				}
			case REQUIREMENTS_DIAGRAM:
				if (relationshipType == ScrmElementTypes.ConstraintRestrictedFeature_4051) {
					types.add(ScrmElementTypes.Constraint_2011);
					types.add(ScrmElementTypes.Constraint_3006);
				} else if (relationshipType == ScrmElementTypes.RequirementSpecifiedFeature_4052) {
					types.add(ScrmElementTypes.Process_2035);
					types.add(ScrmElementTypes.Performance_2015);
					types.add(ScrmElementTypes.InputDataReading_2036);
					types.add(ScrmElementTypes.DataHandling_2037);
					types.add(ScrmElementTypes.ResultsOutput_2038);
					types.add(ScrmElementTypes.ErrorHandling_2039);
					types.add(ScrmElementTypes.StatusMonitoring_2040);
					types.add(ScrmElementTypes.Requirement_2034);
					types.add(ScrmElementTypes.DataProcessSpace_2046);
					types.add(ScrmElementTypes.Performance_3011);
					types.add(ScrmElementTypes.Requirement_3012);
					types.add(ScrmElementTypes.StatusMonitoring_3016);
					types.add(ScrmElementTypes.ResultsOutput_3017);
					types.add(ScrmElementTypes.Process_3018);
					types.add(ScrmElementTypes.InputDataReading_3019);
					types.add(ScrmElementTypes.ErrorHandling_3020);
					types.add(ScrmElementTypes.DataHandling_3021);
					types.add(ScrmElementTypes.DataProcessSpace_3022);
				} else if (relationshipType == ScrmElementTypes.FeatureSuperFeature_4053) {
					types.add(ScrmElementTypes.Feature_2009);
					types.add(ScrmElementTypes.Feature_3009);
				} else if (relationshipType == ScrmElementTypes.FeatureRequiredFeatures_4030) {
					types.add(ScrmElementTypes.Feature_2009);
					types.add(ScrmElementTypes.Feature_3009);
				} else if (relationshipType == ScrmElementTypes.FeatureExcludedFeatures_4032) {
					types.add(ScrmElementTypes.Feature_2009);
					types.add(ScrmElementTypes.Feature_3009);
				}
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class FeatureFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureFeature_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFeature_description;

		/**
		 * @generated
		 */
		public FeatureFigure() {

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
		 * @generated NOT: enabled textWrap
		 */
		private void createContents() {

			fFigureFeature_name = new WrappingLabel();
			fFigureFeature_name.setText("");

			fFigureFeature_name.setFont(FFIGUREFEATURE_NAME_FONT);

			GridData constraintFFigureFeature_name = new GridData();
			constraintFFigureFeature_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureFeature_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureFeature_name.horizontalIndent = 0;
			constraintFFigureFeature_name.horizontalSpan = 1;
			constraintFFigureFeature_name.verticalSpan = 1;
			constraintFFigureFeature_name.grabExcessHorizontalSpace = false;
			constraintFFigureFeature_name.grabExcessVerticalSpace = false;
			this.add(fFigureFeature_name, constraintFFigureFeature_name);

			fFigureFeature_description = new WrappingLabel();
			fFigureFeature_description.setText("");
			fFigureFeature_description.setTextWrap(true);

			GridData constraintFFigureFeature_description = new GridData();
			constraintFFigureFeature_description.verticalAlignment = GridData.BEGINNING;
			constraintFFigureFeature_description.horizontalAlignment = GridData.FILL;
			constraintFFigureFeature_description.horizontalIndent = 0;
			constraintFFigureFeature_description.horizontalSpan = 1;
			constraintFFigureFeature_description.verticalSpan = 1;
			constraintFFigureFeature_description.grabExcessHorizontalSpace = true;
			constraintFFigureFeature_description.grabExcessVerticalSpace = false;
			this.add(fFigureFeature_description,
					constraintFFigureFeature_description);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFeature_name() {
			return fFigureFeature_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFeature_description() {
			return fFigureFeature_description;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 0, 255, 0);

	/**
	 * @generated
	 */
	static final Font FFIGUREFEATURE_NAME_FONT = new Font(Display.getCurrent(),
			"Arial", 9, SWT.BOLD);

}
