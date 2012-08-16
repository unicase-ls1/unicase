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
import scrm.diagram.edit.policies.HardwareItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenMEEditorPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class HardwareEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2010;

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
	public HardwareEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new HardwareItemSemanticEditPolicy());
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
		if (childEditPart instanceof HardwareNameEditPart) {
			((HardwareNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureHardware_name());
			return true;
		}
		if (childEditPart instanceof HardwareDescriptionEditPart) {
			((HardwareDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureHardware_description());
			return true;
		}
		if (childEditPart instanceof HardwareProcessorEditPart) {
			((HardwareProcessorEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureHardware_processor());
			return true;
		}
		if (childEditPart instanceof HardwarePlatformEditPart) {
			((HardwarePlatformEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureHardware_platform());
			return true;
		}
		if (childEditPart instanceof HardwareMemoryEditPart) {
			((HardwareMemoryEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureHardware_memory());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof HardwareNameEditPart) {
			return true;
		}
		if (childEditPart instanceof HardwareDescriptionEditPart) {
			return true;
		}
		if (childEditPart instanceof HardwareProcessorEditPart) {
			return true;
		}
		if (childEditPart instanceof HardwarePlatformEditPart) {
			return true;
		}
		if (childEditPart instanceof HardwareMemoryEditPart) {
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
				.getType(HardwareNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
		case REQUIREMENTS_DIAGRAM:
			types.add(ScrmElementTypes.FeatureDependencies_4026);
			types.add(ScrmElementTypes.PerformanceHardware_4074);
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
		case REQUIREMENTS_DIAGRAM:
			if (relationshipType == ScrmElementTypes.FeatureDependencies_4026) {
				types.add(ScrmElementTypes.Feature_2009);
				types.add(ScrmElementTypes.Feature_3009);
			} else if (relationshipType == ScrmElementTypes.PerformanceHardware_4074) {
				types.add(ScrmElementTypes.Performance_2015);
				types.add(ScrmElementTypes.Performance_3011);
			}
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
		 * @generated NOT: adjusted size
		 */
		public HardwareFigure() {

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

			fFigureHardware_name = new WrappingLabel();
			fFigureHardware_name.setText("");

			fFigureHardware_name.setFont(FFIGUREHARDWARE_NAME_FONT);

			GridData constraintFFigureHardware_name = new GridData();
			constraintFFigureHardware_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureHardware_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureHardware_name.horizontalIndent = 0;
			constraintFFigureHardware_name.horizontalSpan = 1;
			constraintFFigureHardware_name.verticalSpan = 1;
			constraintFFigureHardware_name.grabExcessHorizontalSpace = false;
			constraintFFigureHardware_name.grabExcessVerticalSpace = false;
			this.add(fFigureHardware_name, constraintFFigureHardware_name);

			fFigureHardware_description = new WrappingLabel();
			fFigureHardware_description.setText("");
			fFigureHardware_description.setTextWrap(true);

			GridData constraintFFigureHardware_description = new GridData();
			constraintFFigureHardware_description.verticalAlignment = GridData.BEGINNING;
			constraintFFigureHardware_description.horizontalAlignment = GridData.FILL;
			constraintFFigureHardware_description.horizontalIndent = 0;
			constraintFFigureHardware_description.horizontalSpan = 1;
			constraintFFigureHardware_description.verticalSpan = 1;
			constraintFFigureHardware_description.grabExcessHorizontalSpace = true;
			constraintFFigureHardware_description.grabExcessVerticalSpace = false;
			this.add(fFigureHardware_description,
					constraintFFigureHardware_description);

			fFigureHardware_processor = new WrappingLabel();
			fFigureHardware_processor.setText("");
			fFigureHardware_processor.setTextWrap(true);

			GridData constraintFFigureHardware_processor = new GridData();
			constraintFFigureHardware_processor.verticalAlignment = GridData.BEGINNING;
			constraintFFigureHardware_processor.horizontalAlignment = GridData.FILL;
			constraintFFigureHardware_processor.horizontalIndent = 0;
			constraintFFigureHardware_processor.horizontalSpan = 1;
			constraintFFigureHardware_processor.verticalSpan = 1;
			constraintFFigureHardware_processor.grabExcessHorizontalSpace = true;
			constraintFFigureHardware_processor.grabExcessVerticalSpace = false;
			this.add(fFigureHardware_processor,
					constraintFFigureHardware_processor);

			fFigureHardware_platform = new WrappingLabel();
			fFigureHardware_platform.setText("");
			fFigureHardware_platform.setTextWrap(true);

			GridData constraintFFigureHardware_platform = new GridData();
			constraintFFigureHardware_platform.verticalAlignment = GridData.BEGINNING;
			constraintFFigureHardware_platform.horizontalAlignment = GridData.FILL;
			constraintFFigureHardware_platform.horizontalIndent = 0;
			constraintFFigureHardware_platform.horizontalSpan = 1;
			constraintFFigureHardware_platform.verticalSpan = 1;
			constraintFFigureHardware_platform.grabExcessHorizontalSpace = true;
			constraintFFigureHardware_platform.grabExcessVerticalSpace = false;
			this.add(fFigureHardware_platform,
					constraintFFigureHardware_platform);

			fFigureHardware_memory = new WrappingLabel();
			fFigureHardware_memory.setText("");
			fFigureHardware_memory.setTextWrap(true);

			GridData constraintFFigureHardware_memory = new GridData();
			constraintFFigureHardware_memory.verticalAlignment = GridData.BEGINNING;
			constraintFFigureHardware_memory.horizontalAlignment = GridData.FILL;
			constraintFFigureHardware_memory.horizontalIndent = 0;
			constraintFFigureHardware_memory.horizontalSpan = 1;
			constraintFFigureHardware_memory.verticalSpan = 1;
			constraintFFigureHardware_memory.grabExcessHorizontalSpace = true;
			constraintFFigureHardware_memory.grabExcessVerticalSpace = false;
			this.add(fFigureHardware_memory, constraintFFigureHardware_memory);

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
	 * @generated NOT: adjusted color
	 */
	static final Color THIS_BACK = new Color(null, 159, 255, 53);

	/**
	 * @generated
	 */
	static final Font FFIGUREHARDWARE_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
