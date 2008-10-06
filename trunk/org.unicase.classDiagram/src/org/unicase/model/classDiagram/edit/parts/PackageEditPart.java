package org.unicase.model.classDiagram.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
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
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class PackageEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2002;

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
	public PackageEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.model.classDiagram.edit.policies.PackageItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

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
		PackageFigure figure = new PackageFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public PackageFigure getPrimaryShape() {
		return (PackageFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.model.classDiagram.edit.parts.PackageNameEditPart) {
			((org.unicase.model.classDiagram.edit.parts.PackageNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigurePackageFigure_name());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

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

		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(150), getMapMode().DPtoLP(110));
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
			layout.setSpacing(getMapMode().DPtoLP(5));
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.model.classDiagram.edit.parts.PackageNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class PackageFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigurePackageFigure_name;

		/**
		 * @generated
		 */
		public PackageFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setFill(false);
			this.setFillXOR(true);
			this.setOutline(false);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure packageFigure_AuxTop0 = new RectangleFigure();
			packageFigure_AuxTop0.setFill(false);
			packageFigure_AuxTop0.setFillXOR(true);
			packageFigure_AuxTop0.setOutline(false);
			packageFigure_AuxTop0.setOutlineXOR(true);

			this.add(packageFigure_AuxTop0, BorderLayout.TOP);

			ConstrainedToolbarLayout layoutPackageFigure_AuxTop0 = new ConstrainedToolbarLayout();

			layoutPackageFigure_AuxTop0.setStretchMajorAxis(true);

			layoutPackageFigure_AuxTop0.setVertical(false);

			packageFigure_AuxTop0.setLayoutManager(layoutPackageFigure_AuxTop0);

			RectangleFigure packageFigure_AuxLeftTab1 = new RectangleFigure();
			packageFigure_AuxLeftTab1.setPreferredSize(new Dimension(
					getMapMode().DPtoLP(1), getMapMode().DPtoLP(30)));

			packageFigure_AuxTop0.add(packageFigure_AuxLeftTab1);

			RectangleFigure packageFigure_AuxRightPadding1 = new RectangleFigure();
			packageFigure_AuxRightPadding1.setFill(false);
			packageFigure_AuxRightPadding1.setOutline(false);
			packageFigure_AuxRightPadding1.setPreferredSize(new Dimension(
					getMapMode().DPtoLP(1), getMapMode().DPtoLP(30)));

			packageFigure_AuxTop0.add(packageFigure_AuxRightPadding1);

			RectangleFigure packageFigure_AuxCenter0 = new RectangleFigure();
			packageFigure_AuxCenter0.setFillXOR(true);
			packageFigure_AuxCenter0.setOutlineXOR(true);

			this.add(packageFigure_AuxCenter0, BorderLayout.CENTER);

			ToolbarLayout layoutPackageFigure_AuxCenter0 = new ToolbarLayout();
			layoutPackageFigure_AuxCenter0.setStretchMinorAxis(true);
			layoutPackageFigure_AuxCenter0
					.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutPackageFigure_AuxCenter0.setSpacing(0);
			layoutPackageFigure_AuxCenter0.setVertical(true);

			packageFigure_AuxCenter0
					.setLayoutManager(layoutPackageFigure_AuxCenter0);

			RectangleFigure packageFigure_NameContainer1 = new RectangleFigure();
			packageFigure_NameContainer1.setFill(false);
			packageFigure_NameContainer1.setOutline(false);
			packageFigure_NameContainer1.setMinimumSize(new Dimension(
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(20)));

			packageFigure_NameContainer1.setBorder(new MarginBorder(
					getMapMode().DPtoLP(5), getMapMode().DPtoLP(10),
					getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));

			packageFigure_AuxCenter0.add(packageFigure_NameContainer1);

			org.unicase.model.classDiagram.unicase.CenterLayout layoutPackageFigure_NameContainer1 = new org.unicase.model.classDiagram.unicase.CenterLayout();

			packageFigure_NameContainer1
					.setLayoutManager(layoutPackageFigure_NameContainer1);

			fFigurePackageFigure_name = new WrappingLabel();
			fFigurePackageFigure_name.setText("unnamed");

			packageFigure_NameContainer1.add(fFigurePackageFigure_name);

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
		public WrappingLabel getFigurePackageFigure_name() {
			return fFigurePackageFigure_name;
		}

	}

}
