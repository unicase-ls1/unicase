package org.unicase.ui.diagram.urml.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
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
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.unicase.ui.diagram.urml.edit.policies.VariationPointInstanceItemSemanticEditPolicy;
import org.unicase.ui.diagram.urml.own.figures.IconSizeNodeFigure;
import org.unicase.ui.diagram.urml.own.icons.VariationPointInstanceIcon;
import org.unicase.ui.diagram.urml.own.policies.MEEditorOpenPolicie;
import org.unicase.ui.diagram.urml.part.UrmlVisualIDRegistry;
import org.unicase.ui.diagram.urml.providers.UrmlElementTypes;
import org.unicase.ui.unicasecommon.diagram.figures.Label;

/**
 * @generated
 */
public class VariationPointInstanceEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2014;

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
	public VariationPointInstanceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new VariationPointInstanceItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new MEEditorOpenPolicie());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
		// editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
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
		VariationPointInstanceFigure figure = new VariationPointInstanceFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public VariationPointInstanceFigure getPrimaryShape() {
		return (VariationPointInstanceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof VariationPointInstanceNameEditPart) {
			((VariationPointInstanceNameEditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureVariationPointInstance_name());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof VariationPointInstanceNameEditPart) {
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
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		/* user code */
		// DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		NodeFigure result = new IconSizeNodeFigure();
		/* user code */
		return result;
	}

	/**
	 * Creates figure for this edit part. Body of this method does not depend on settings in generation model so you may
	 * safely remove <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane. Respects layout one may have set for generated
	 * figure.
	 * 
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
		return getChildBySemanticHint(UrmlVisualIDRegistry.getType(VariationPointInstanceNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSource() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse.gmf.runtime.emf
																							 * .type.core.IElementType>
																							 */();
		types.add(UrmlElementTypes.VariationPointInstanceVariationPoint_4033);
		types.add(UrmlElementTypes.VariationPointInstanceSelectedFeatures_4040);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSourceAndTarget(
		IGraphicalEditPart targetEditPart) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse.gmf.runtime.emf
																							 * .type.core.IElementType>
																							 */();
		if (targetEditPart instanceof VariationPointEditPart) {
			types.add(UrmlElementTypes.VariationPointInstanceVariationPoint_4033);
		}
		if (targetEditPart instanceof FeatureEditPart) {
			types.add(UrmlElementTypes.VariationPointInstanceSelectedFeatures_4040);
		}
		if (targetEditPart instanceof VariationPointEditPart) {
			types.add(UrmlElementTypes.VariationPointInstanceSelectedFeatures_4040);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(
		IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse.gmf.runtime.emf
																							 * .type.core.IElementType>
																							 */();
		if (relationshipType == UrmlElementTypes.VariationPointInstanceVariationPoint_4033) {
			types.add(UrmlElementTypes.VariationPoint_2013);
		}
		if (relationshipType == UrmlElementTypes.VariationPointInstanceSelectedFeatures_4040) {
			types.add(UrmlElementTypes.Feature_2012);
		}
		if (relationshipType == UrmlElementTypes.VariationPointInstanceSelectedFeatures_4040) {
			types.add(UrmlElementTypes.VariationPoint_2013);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnTarget() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse.gmf.runtime.emf
																							 * .type.core.IElementType>
																							 */();
		types.add(UrmlElementTypes.ProductVariationPointInstances_4032);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForSource(
		IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse.gmf.runtime.emf
																							 * .type.core.IElementType>
																							 */();
		if (relationshipType == UrmlElementTypes.ProductVariationPointInstances_4032) {
			types.add(UrmlElementTypes.Product_2015);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class VariationPointInstanceFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private Label fFigureVariationPointInstance_name;

		/**
		 * @generated
		 */
		public VariationPointInstanceFigure() {
			this.setFill(false);
			this.setOutline(false);
			this.setLineWidth(0);
			this.setLineStyle(Graphics.LINE_CUSTOM);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			VariationPointInstanceIcon variationPointInstanceFigure0 = new VariationPointInstanceIcon();

			this.add(variationPointInstanceFigure0);

			fFigureVariationPointInstance_name = new Label();

			fFigureVariationPointInstance_name.setFont(FFIGUREVARIATIONPOINTINSTANCE_NAME_FONT);

			this.add(fFigureVariationPointInstance_name);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public Label getFigureVariationPointInstance_name() {
			return fFigureVariationPointInstance_name;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREVARIATIONPOINTINSTANCE_NAME_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.BOLD);

}
