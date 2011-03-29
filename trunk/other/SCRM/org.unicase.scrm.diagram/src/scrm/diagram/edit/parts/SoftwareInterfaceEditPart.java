package scrm.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
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
import scrm.diagram.edit.policies.ScrmTextSelectionEditPolicy;
import scrm.diagram.edit.policies.SoftwareInterfaceItemSemanticEditPolicy;
import scrm.diagram.opener.MEEditorOpenerPolicy;
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
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new SoftwareInterfaceItemSemanticEditPolicy());
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
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
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.ScientificKnowledgeRequirements_4005);
		types.add(ScrmElementTypes.FeatureRequiredInterfaces_4023);
		types.add(ScrmElementTypes.FeatureProvidedInterfaces_4024);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ScrmElementTypes.ScientificKnowledgeRequirements_4005) {
			types.add(ScrmElementTypes.ScientificProblem_2007);
			types.add(ScrmElementTypes.MathematicalModel_2005);
			types.add(ScrmElementTypes.NumericalMethod_2006);
			types.add(ScrmElementTypes.Assumption_2008);
		} else if (relationshipType == ScrmElementTypes.FeatureRequiredInterfaces_4023) {
			types.add(ScrmElementTypes.Feature_2009);
		} else if (relationshipType == ScrmElementTypes.FeatureProvidedInterfaces_4024) {
			types.add(ScrmElementTypes.Feature_2009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class SoftwareInterfaceFigure extends Ellipse {

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

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutThis.setSpacing(5);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureSoftwareInterface_name = new WrappingLabel();
			fFigureSoftwareInterface_name.setText("");
			fFigureSoftwareInterface_name.setTextWrap(true);

			fFigureSoftwareInterface_name
					.setFont(FFIGURESOFTWAREINTERFACE_NAME_FONT);

			this.add(fFigureSoftwareInterface_name);

			fFigureSoftwareInterface_description = new WrappingLabel();
			fFigureSoftwareInterface_description.setText("");
			fFigureSoftwareInterface_description.setTextWrap(true);

			this.add(fFigureSoftwareInterface_description);

			fFigureSoftwareInterface_dataTypes = new WrappingLabel();
			fFigureSoftwareInterface_dataTypes.setText("");
			fFigureSoftwareInterface_dataTypes.setTextWrap(true);

			this.add(fFigureSoftwareInterface_dataTypes);

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
