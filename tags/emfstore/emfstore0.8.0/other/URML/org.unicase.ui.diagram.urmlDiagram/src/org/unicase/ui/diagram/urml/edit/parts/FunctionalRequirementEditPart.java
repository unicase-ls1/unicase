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
import org.unicase.ui.diagram.urml.edit.policies.FunctionalRequirementItemSemanticEditPolicy;
import org.unicase.ui.diagram.urml.own.figures.IconSizeNodeFigure;
import org.unicase.ui.diagram.urml.own.icons.FunctionalRequirementIcon;
import org.unicase.ui.diagram.urml.own.policies.MEEditorOpenPolicie;
import org.unicase.ui.diagram.urml.part.UrmlVisualIDRegistry;
import org.unicase.ui.diagram.urml.providers.UrmlElementTypes;
import org.unicase.ui.unicasecommon.diagram.figures.Label;

/**
 * @generated
 */
public class FunctionalRequirementEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2006;

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
	public FunctionalRequirementEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new FunctionalRequirementItemSemanticEditPolicy());
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
		FunctionalRequirement figure = new FunctionalRequirement();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public FunctionalRequirement getPrimaryShape() {
		return (FunctionalRequirement) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof FunctionalRequirementNameEditPart) {
			((FunctionalRequirementNameEditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureFunctionalRequirementFigure_name());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof FunctionalRequirementNameEditPart) {
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
		return getChildBySemanticHint(UrmlVisualIDRegistry.getType(FunctionalRequirementNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSource() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse.gmf.runtime.emf
																							 * .type.core.IElementType>
																							 */();
		types.add(UrmlElementTypes.RequirementImplementingServices_4005);
		types.add(UrmlElementTypes.FunctionalRequirementSubFunctionalRequirements_4044);
		types.add(UrmlElementTypes.MitigationMitigatedDangers_4012);
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
		if (targetEditPart instanceof ServiceEditPart) {
			types.add(UrmlElementTypes.RequirementImplementingServices_4005);
		}
		if (targetEditPart instanceof org.unicase.ui.diagram.urml.edit.parts.FunctionalRequirementEditPart) {
			types.add(UrmlElementTypes.FunctionalRequirementSubFunctionalRequirements_4044);
		}
		if (targetEditPart instanceof DangerEditPart) {
			types.add(UrmlElementTypes.MitigationMitigatedDangers_4012);
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
		if (relationshipType == UrmlElementTypes.RequirementImplementingServices_4005) {
			types.add(UrmlElementTypes.Service_2007);
		}
		if (relationshipType == UrmlElementTypes.FunctionalRequirementSubFunctionalRequirements_4044) {
			types.add(UrmlElementTypes.FunctionalRequirement_2006);
		}
		if (relationshipType == UrmlElementTypes.MitigationMitigatedDangers_4012) {
			types.add(UrmlElementTypes.Danger_2009);
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
		types.add(UrmlElementTypes.AbstractFeatureDetailingFunctionalRequirements_4035);
		types.add(UrmlElementTypes.FunctionalRequirementSubFunctionalRequirements_4044);
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
		if (relationshipType == UrmlElementTypes.AbstractFeatureDetailingFunctionalRequirements_4035) {
			types.add(UrmlElementTypes.Feature_2012);
		}
		if (relationshipType == UrmlElementTypes.AbstractFeatureDetailingFunctionalRequirements_4035) {
			types.add(UrmlElementTypes.VariationPoint_2013);
		}
		if (relationshipType == UrmlElementTypes.FunctionalRequirementSubFunctionalRequirements_4044) {
			types.add(UrmlElementTypes.FunctionalRequirement_2006);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class FunctionalRequirement extends RectangleFigure {

		/**
		 * @generated
		 */
		private Label fFigureFunctionalRequirementFigure_name;

		/**
		 * @generated
		 */
		public FunctionalRequirement() {
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

			FunctionalRequirementIcon functionalRequirementFigure0 = new FunctionalRequirementIcon();

			this.add(functionalRequirementFigure0);

			fFigureFunctionalRequirementFigure_name = new Label();

			fFigureFunctionalRequirementFigure_name.setFont(FFIGUREFUNCTIONALREQUIREMENTFIGURE_NAME_FONT);

			this.add(fFigureFunctionalRequirementFigure_name);

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
		public Label getFigureFunctionalRequirementFigure_name() {
			return fFigureFunctionalRequirementFigure_name;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREFUNCTIONALREQUIREMENTFIGURE_NAME_FONT = new Font(Display.getCurrent(), "Arial", 10,
		SWT.BOLD);

}
