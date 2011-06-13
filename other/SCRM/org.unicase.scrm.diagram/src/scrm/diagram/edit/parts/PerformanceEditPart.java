package scrm.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
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
import scrm.diagram.edit.policies.OpenDiagramEditPolicy;
import scrm.diagram.edit.policies.PerformanceItemSemanticEditPolicy;
import scrm.diagram.edit.policies.ScrmTextSelectionEditPolicy;
import scrm.diagram.opener.MEEditorOpenerPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class PerformanceEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2015;

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
	public PerformanceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new PerformanceItemSemanticEditPolicy());
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
		return primaryShape = new PerformanceFigure();
	}

	/**
	 * @generated
	 */
	public PerformanceFigure getPrimaryShape() {
		return (PerformanceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PerformanceNameEditPart) {
			((PerformanceNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigurePerformance_name());
			return true;
		}
		if (childEditPart instanceof PerformanceDescriptionEditPart) {
			((PerformanceDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigurePerformance_description());
			return true;
		}
		if (childEditPart instanceof PerformanceProblemSizeEditPart) {
			((PerformanceProblemSizeEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigurePerformance_problemSize());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PerformanceNameEditPart) {
			return true;
		}
		if (childEditPart instanceof PerformanceDescriptionEditPart) {
			return true;
		}
		if (childEditPart instanceof PerformanceProblemSizeEditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(160, 77);
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
				.getType(PerformanceNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.RequirementRealizedMethod_4050);
		types.add(ScrmElementTypes.RequirementSpecifiedFeature_4052);
		types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof NumericalMethodEditPart) {
			types.add(ScrmElementTypes.RequirementRealizedMethod_4050);
		}
		if (targetEditPart instanceof NumericalMethod2EditPart) {
			types.add(ScrmElementTypes.RequirementRealizedMethod_4050);
		}
		if (targetEditPart instanceof FeatureEditPart) {
			types.add(ScrmElementTypes.RequirementSpecifiedFeature_4052);
		}
		if (targetEditPart instanceof Feature2EditPart) {
			types.add(ScrmElementTypes.RequirementSpecifiedFeature_4052);
		}
		if (targetEditPart instanceof ProcessEditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof scrm.diagram.edit.parts.PerformanceEditPart) {
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
		if (targetEditPart instanceof RequirementEditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof DataProcessSpaceEditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof Performance2EditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof Requirement2EditPart) {
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
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ScrmElementTypes.RequirementRealizedMethod_4050) {
			types.add(ScrmElementTypes.NumericalMethod_2006);
			types.add(ScrmElementTypes.NumericalMethod_3002);
		} else if (relationshipType == ScrmElementTypes.RequirementSpecifiedFeature_4052) {
			types.add(ScrmElementTypes.Feature_2009);
			types.add(ScrmElementTypes.Feature_3009);
		} else if (relationshipType == ScrmElementTypes.RequirementRefinedRequirement_4054) {
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
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.NumericalMethodPerformance_4017);
		types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4055);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ScrmElementTypes.NumericalMethodPerformance_4017) {
			types.add(ScrmElementTypes.NumericalMethod_2006);
			types.add(ScrmElementTypes.NumericalMethod_3002);
		} else if (relationshipType == ScrmElementTypes.RequirementRefinedRequirement_4054) {
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
		} else if (relationshipType == ScrmElementTypes.DataDefinitionDefinedRequirement_4055) {
			types.add(ScrmElementTypes.DataDefinition_2017);
			types.add(ScrmElementTypes.DataDefinition_3007);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class PerformanceFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigurePerformance_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePerformance_description;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePerformance_problemSize;

		/**
		 * @generated
		 */
		public PerformanceFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutThis.setSpacing(5);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(32),
					getMapMode().DPtoLP(32)));
			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(160),
					getMapMode().DPtoLP(77)));
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigurePerformance_name = new WrappingLabel();
			fFigurePerformance_name.setText("");
			fFigurePerformance_name.setTextWrap(true);

			fFigurePerformance_name.setFont(FFIGUREPERFORMANCE_NAME_FONT);

			this.add(fFigurePerformance_name);

			fFigurePerformance_description = new WrappingLabel();
			fFigurePerformance_description.setText("");
			fFigurePerformance_description.setTextWrap(true);

			this.add(fFigurePerformance_description);

			fFigurePerformance_problemSize = new WrappingLabel();
			fFigurePerformance_problemSize.setText("");
			fFigurePerformance_problemSize.setTextWrap(true);

			this.add(fFigurePerformance_problemSize);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePerformance_name() {
			return fFigurePerformance_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePerformance_description() {
			return fFigurePerformance_description;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePerformance_problemSize() {
			return fFigurePerformance_problemSize;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 13, 242, 231);

	/**
	 * @generated
	 */
	static final Font FFIGUREPERFORMANCE_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
