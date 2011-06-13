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

import scrm.diagram.edit.policies.Hardware2ItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenDiagramEditPolicy;
import scrm.diagram.edit.policies.ScrmTextSelectionEditPolicy;
import scrm.diagram.opener.MEEditorOpenerPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class Hardware2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3010;

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
	public Hardware2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new Hardware2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new MEEditorOpenerPolicy());
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
		return primaryShape = new HardwareFigure();
	}

	/**
	 * @generated
	 */
	public HardwareFigure getPrimaryShape() {
		return (HardwareFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof HardwareName2EditPart) {
			((HardwareName2EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureHardware_name());
			return true;
		}
		if (childEditPart instanceof HardwareDescription2EditPart) {
			((HardwareDescription2EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureHardware_description());
			return true;
		}
		if (childEditPart instanceof HardwareProcessor2EditPart) {
			((HardwareProcessor2EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureHardware_processor());
			return true;
		}
		if (childEditPart instanceof HardwarePlatform2EditPart) {
			((HardwarePlatform2EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureHardware_platform());
			return true;
		}
		if (childEditPart instanceof HardwareMemory2EditPart) {
			((HardwareMemory2EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureHardware_memory());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof HardwareName2EditPart) {
			return true;
		}
		if (childEditPart instanceof HardwareDescription2EditPart) {
			return true;
		}
		if (childEditPart instanceof HardwareProcessor2EditPart) {
			return true;
		}
		if (childEditPart instanceof HardwarePlatform2EditPart) {
			return true;
		}
		if (childEditPart instanceof HardwareMemory2EditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(140, 110);
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
				.getType(HardwareName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(ScrmElementTypes.FeatureDependencies_4026);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ScrmElementTypes.FeatureDependencies_4026) {
			types.add(ScrmElementTypes.Feature_2009);
			types.add(ScrmElementTypes.Feature_3009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class HardwareFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureHardware_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureHardware_description;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureHardware_processor;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureHardware_platform;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureHardware_memory;

		/**
		 * @generated
		 */
		public HardwareFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutThis.setSpacing(5);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(32),
					getMapMode().DPtoLP(32)));
			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(140),
					getMapMode().DPtoLP(110)));
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureHardware_name = new WrappingLabel();
			fFigureHardware_name.setText("");
			fFigureHardware_name.setTextWrap(true);

			fFigureHardware_name.setFont(FFIGUREHARDWARE_NAME_FONT);

			this.add(fFigureHardware_name);

			fFigureHardware_description = new WrappingLabel();
			fFigureHardware_description.setText("");
			fFigureHardware_description.setTextWrap(true);

			this.add(fFigureHardware_description);

			fFigureHardware_processor = new WrappingLabel();
			fFigureHardware_processor.setText("");
			fFigureHardware_processor.setTextWrap(true);

			this.add(fFigureHardware_processor);

			fFigureHardware_platform = new WrappingLabel();
			fFigureHardware_platform.setText("");
			fFigureHardware_platform.setTextWrap(true);

			this.add(fFigureHardware_platform);

			fFigureHardware_memory = new WrappingLabel();
			fFigureHardware_memory.setText("");
			fFigureHardware_memory.setTextWrap(true);

			this.add(fFigureHardware_memory);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureHardware_name() {
			return fFigureHardware_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureHardware_description() {
			return fFigureHardware_description;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureHardware_processor() {
			return fFigureHardware_processor;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureHardware_platform() {
			return fFigureHardware_platform;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureHardware_memory() {
			return fFigureHardware_memory;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 16, 240, 167);

	/**
	 * @generated
	 */
	static final Font FFIGUREHARDWARE_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
