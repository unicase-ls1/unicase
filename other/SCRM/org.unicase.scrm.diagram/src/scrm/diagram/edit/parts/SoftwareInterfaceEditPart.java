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
import scrm.diagram.edit.policies.OpenMEEditorPolicy;
import scrm.diagram.edit.policies.SoftwareInterfaceItemSemanticEditPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class SoftwareInterfaceEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2013;

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
	public SoftwareInterfaceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new SoftwareInterfaceItemSemanticEditPolicy());
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
		return primaryShape = new SoftwareInterfaceFigure();
	}

	/**
	 * @generated
	 */
	public SoftwareInterfaceFigure getPrimaryShape() {
		return (SoftwareInterfaceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof SoftwareInterfaceNameEditPart) {
			((SoftwareInterfaceNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureSoftwareInterface_name());
			return true;
		}
		if (childEditPart instanceof SoftwareInterfaceDescriptionEditPart) {
			((SoftwareInterfaceDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureSoftwareInterface_description());
			return true;
		}
		if (childEditPart instanceof SoftwareInterfaceDataTypesEditPart) {
			((SoftwareInterfaceDataTypesEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureSoftwareInterface_dataTypes());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof SoftwareInterfaceNameEditPart) {
			return true;
		}
		if (childEditPart instanceof SoftwareInterfaceDescriptionEditPart) {
			return true;
		}
		if (childEditPart instanceof SoftwareInterfaceDataTypesEditPart) {
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
				.getType(SoftwareInterfaceNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		List<IElementType> types = new LinkedList<IElementType>();
		switch(scrmDiagram.getDiagramType()) {
			case DEFAULT_DIAGRAM:
			case REQUIREMENTS_DIAGRAM:
				types.add(ScrmElementTypes.FeatureRequiredInterfaces_4023);
				types.add(ScrmElementTypes.FeatureProvidedInterfaces_4024);
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
			case REQUIREMENTS_DIAGRAM:
				if (relationshipType == ScrmElementTypes.FeatureRequiredInterfaces_4023) {
					types.add(ScrmElementTypes.Feature_2009);
					types.add(ScrmElementTypes.Feature_3009);
				} else if (relationshipType == ScrmElementTypes.FeatureProvidedInterfaces_4024) {
					types.add(ScrmElementTypes.Feature_2009);
					types.add(ScrmElementTypes.Feature_3009);
				}
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class SoftwareInterfaceFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureSoftwareInterface_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSoftwareInterface_description;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSoftwareInterface_dataTypes;

		/**
		 * @generated
		 */
		public SoftwareInterfaceFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(32),
					getMapMode().DPtoLP(32)));
			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(160),
					getMapMode().DPtoLP(77)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureSoftwareInterface_name = new WrappingLabel();
			fFigureSoftwareInterface_name.setText("");

			fFigureSoftwareInterface_name
					.setFont(FFIGURESOFTWAREINTERFACE_NAME_FONT);

			GridData constraintFFigureSoftwareInterface_name = new GridData();
			constraintFFigureSoftwareInterface_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSoftwareInterface_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureSoftwareInterface_name.horizontalIndent = 0;
			constraintFFigureSoftwareInterface_name.horizontalSpan = 1;
			constraintFFigureSoftwareInterface_name.verticalSpan = 1;
			constraintFFigureSoftwareInterface_name.grabExcessHorizontalSpace = false;
			constraintFFigureSoftwareInterface_name.grabExcessVerticalSpace = false;
			this.add(fFigureSoftwareInterface_name,
					constraintFFigureSoftwareInterface_name);

			fFigureSoftwareInterface_description = new WrappingLabel();
			fFigureSoftwareInterface_description.setText("");

			GridData constraintFFigureSoftwareInterface_description = new GridData();
			constraintFFigureSoftwareInterface_description.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSoftwareInterface_description.horizontalAlignment = GridData.FILL;
			constraintFFigureSoftwareInterface_description.horizontalIndent = 0;
			constraintFFigureSoftwareInterface_description.horizontalSpan = 1;
			constraintFFigureSoftwareInterface_description.verticalSpan = 1;
			constraintFFigureSoftwareInterface_description.grabExcessHorizontalSpace = true;
			constraintFFigureSoftwareInterface_description.grabExcessVerticalSpace = false;
			this.add(fFigureSoftwareInterface_description,
					constraintFFigureSoftwareInterface_description);

			fFigureSoftwareInterface_dataTypes = new WrappingLabel();
			fFigureSoftwareInterface_dataTypes.setText("");

			GridData constraintFFigureSoftwareInterface_dataTypes = new GridData();
			constraintFFigureSoftwareInterface_dataTypes.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSoftwareInterface_dataTypes.horizontalAlignment = GridData.FILL;
			constraintFFigureSoftwareInterface_dataTypes.horizontalIndent = 0;
			constraintFFigureSoftwareInterface_dataTypes.horizontalSpan = 1;
			constraintFFigureSoftwareInterface_dataTypes.verticalSpan = 1;
			constraintFFigureSoftwareInterface_dataTypes.grabExcessHorizontalSpace = true;
			constraintFFigureSoftwareInterface_dataTypes.grabExcessVerticalSpace = false;
			this.add(fFigureSoftwareInterface_dataTypes,
					constraintFFigureSoftwareInterface_dataTypes);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSoftwareInterface_name() {
			return fFigureSoftwareInterface_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSoftwareInterface_description() {
			return fFigureSoftwareInterface_description;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSoftwareInterface_dataTypes() {
			return fFigureSoftwareInterface_dataTypes;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 16, 240, 167);

	/**
	 * @generated
	 */
	static final Font FFIGURESOFTWAREINTERFACE_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
