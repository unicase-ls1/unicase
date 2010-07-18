package org.unicase.model.urml.ui.diagram.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
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
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.unicase.model.urml.ui.diagram.edit.policies.NonFunctionalRequirementItemSemanticEditPolicy;
import org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;
import org.unicase.ui.diagrams.urml.icons.NonFunctionalRequirementIcon;
import org.unicase.ui.unicasecommon.diagram.figures.Label;

/**
 * @generated
 */
public class NonFunctionalRequirementEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2008;

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
	public NonFunctionalRequirementEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new NonFunctionalRequirementItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
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
		NonFunctionalRequirementFigure figure = new NonFunctionalRequirementFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public NonFunctionalRequirementFigure getPrimaryShape() {
		return (NonFunctionalRequirementFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof NonFunctionalRequirementNameEditPart) {
			((NonFunctionalRequirementNameEditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureNonFunctionalRequirementFigure_name());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof NonFunctionalRequirementNameEditPart) {
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
		return getChildBySemanticHint(UrmlVisualIDRegistry.getType(NonFunctionalRequirementNameEditPart.VISUAL_ID));
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
		types.add(UrmlElementTypes.RequirementSubRequirements_4021);
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
		if (targetEditPart instanceof FunctionalRequirementEditPart) {
			types.add(UrmlElementTypes.RequirementSubRequirements_4021);
		}
		if (targetEditPart instanceof org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementEditPart) {
			types.add(UrmlElementTypes.RequirementSubRequirements_4021);
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
		if (relationshipType == UrmlElementTypes.RequirementSubRequirements_4021) {
			types.add(UrmlElementTypes.FunctionalRequirement_2006);
		}
		if (relationshipType == UrmlElementTypes.RequirementSubRequirements_4021) {
			types.add(UrmlElementTypes.NonFunctionalRequirement_2008);
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
		types.add(UrmlElementTypes.AbstractFeatureConstrainingNonFunctionalRequirements_4036);
		types.add(UrmlElementTypes.RequirementSubRequirements_4021);
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
		if (relationshipType == UrmlElementTypes.AbstractFeatureConstrainingNonFunctionalRequirements_4036) {
			types.add(UrmlElementTypes.Feature_2012);
		}
		if (relationshipType == UrmlElementTypes.AbstractFeatureConstrainingNonFunctionalRequirements_4036) {
			types.add(UrmlElementTypes.VariationPoint_2013);
		}
		if (relationshipType == UrmlElementTypes.RequirementSubRequirements_4021) {
			types.add(UrmlElementTypes.FunctionalRequirement_2006);
		}
		if (relationshipType == UrmlElementTypes.RequirementSubRequirements_4021) {
			types.add(UrmlElementTypes.NonFunctionalRequirement_2008);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class NonFunctionalRequirementFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private Label fFigureNonFunctionalRequirementFigure_name;

		/**
		 * @generated
		 */
		public NonFunctionalRequirementFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginWidth = 0;
			layoutThis.marginHeight = 0;
			this.setLayoutManager(layoutThis);

			this.setLineWidth(0);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			NonFunctionalRequirementIcon nonFunctionalRequirementFigure0 = new NonFunctionalRequirementIcon();

			this.add(nonFunctionalRequirementFigure0);

			fFigureNonFunctionalRequirementFigure_name = new Label();

			fFigureNonFunctionalRequirementFigure_name.setFont(FFIGURENONFUNCTIONALREQUIREMENTFIGURE_NAME_FONT);

			GridData constraintFFigureNonFunctionalRequirementFigure_name = new GridData();
			constraintFFigureNonFunctionalRequirementFigure_name.verticalAlignment = GridData.CENTER;
			constraintFFigureNonFunctionalRequirementFigure_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureNonFunctionalRequirementFigure_name.horizontalIndent = 0;
			constraintFFigureNonFunctionalRequirementFigure_name.horizontalSpan = 1;
			constraintFFigureNonFunctionalRequirementFigure_name.verticalSpan = 1;
			constraintFFigureNonFunctionalRequirementFigure_name.grabExcessHorizontalSpace = false;
			constraintFFigureNonFunctionalRequirementFigure_name.grabExcessVerticalSpace = false;
			this.add(fFigureNonFunctionalRequirementFigure_name, constraintFFigureNonFunctionalRequirementFigure_name);

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
		public Label getFigureNonFunctionalRequirementFigure_name() {
			return fFigureNonFunctionalRequirementFigure_name;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGURENONFUNCTIONALREQUIREMENTFIGURE_NAME_FONT = new Font(Display.getCurrent(), "Arial", 10,
		SWT.BOLD);

}
