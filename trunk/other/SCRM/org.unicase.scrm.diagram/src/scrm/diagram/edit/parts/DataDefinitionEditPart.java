package scrm.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Ellipse;
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
import scrm.diagram.edit.policies.DataDefinitionItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenDiagramEditPolicy;
import scrm.diagram.edit.policies.ScrmTextSelectionEditPolicy;
import scrm.diagram.opener.MEEditorOpenerPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated NOT
 */
public class DataDefinitionEditPart extends SCRMModelElementEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2017;

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
		if (childEditPart instanceof DataDefinitionDataTypeEditPart) {
			((DataDefinitionDataTypeEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureDataDefinition_dataType());
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
		if (childEditPart instanceof DataDefinitionDataTypeEditPart) {
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
				.getType(DataDefinitionNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(ScrmElementTypes.RequirementDefiningData_4038);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ScrmElementTypes.RequirementDefiningData_4038) {
			types.add(ScrmElementTypes.Process_2014);
			types.add(ScrmElementTypes.Performance_2015);
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
		private WrappingLabel fFigureDataDefinition_format;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDataDefinition_range;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDataDefinition_dataType;

		/**
		 * @generated
		 */
		public DataDefinitionFigure() {

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
					getMapMode().DPtoLP(120)));
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureDataDefinition_name = new WrappingLabel();
			fFigureDataDefinition_name.setText("");
			fFigureDataDefinition_name.setTextWrap(true);

			fFigureDataDefinition_name.setFont(FFIGUREDATADEFINITION_NAME_FONT);

			this.add(fFigureDataDefinition_name);

			fFigureDataDefinition_description = new WrappingLabel();
			fFigureDataDefinition_description.setText("");
			fFigureDataDefinition_description.setTextWrap(true);

			this.add(fFigureDataDefinition_description);

			fFigureDataDefinition_accuracy = new WrappingLabel();
			fFigureDataDefinition_accuracy.setText("");
			fFigureDataDefinition_accuracy.setTextWrap(true);

			this.add(fFigureDataDefinition_accuracy);

			fFigureDataDefinition_format = new WrappingLabel();
			fFigureDataDefinition_format.setText("");
			fFigureDataDefinition_format.setTextWrap(true);

			this.add(fFigureDataDefinition_format);

			fFigureDataDefinition_range = new WrappingLabel();
			fFigureDataDefinition_range.setText("");
			fFigureDataDefinition_range.setTextWrap(true);

			this.add(fFigureDataDefinition_range);

			fFigureDataDefinition_dataType = new WrappingLabel();
			fFigureDataDefinition_dataType.setText("");
			fFigureDataDefinition_dataType.setTextWrap(true);

			this.add(fFigureDataDefinition_dataType);

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
		public WrappingLabel getFigureDataDefinition_format() {
			return fFigureDataDefinition_format;
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
		public WrappingLabel getFigureDataDefinition_dataType() {
			return fFigureDataDefinition_dataType;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 131, 185, 242);

	/**
	 * @generated
	 */
	static final Font FFIGUREDATADEFINITION_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
