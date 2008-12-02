package org.unicase.ui.stateDiagram.edit.parts;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @generated
 */
public class StateEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

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
	public StateEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.ui.stateDiagram.edit.policies.StateItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {

		FlowLayoutEditPolicy lep = new FlowLayoutEditPolicy() {

			protected Command createAddCommand(EditPart child, EditPart after) {
				return null;
			}

			protected Command createMoveChildCommand(EditPart child,
					EditPart after) {
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
		StateFigure figure = new StateFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public StateFigure getPrimaryShape() {
		return (StateFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.ui.stateDiagram.edit.parts.StateNameEditPart) {
			((org.unicase.ui.stateDiagram.edit.parts.StateNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureStateFigure_name());
			return true;
		}
		if (childEditPart instanceof org.unicase.ui.stateDiagram.edit.parts.StateEntryConditionsEditPart) {
			((org.unicase.ui.stateDiagram.edit.parts.StateEntryConditionsEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureStateFigure_entryConditions());
			return true;
		}
		if (childEditPart instanceof org.unicase.ui.stateDiagram.edit.parts.StateActivitiesEditPart) {
			((org.unicase.ui.stateDiagram.edit.parts.StateActivitiesEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureStateFigure_activities());
			return true;
		}
		if (childEditPart instanceof org.unicase.ui.stateDiagram.edit.parts.StateExitConditionsEditPart) {
			((org.unicase.ui.stateDiagram.edit.parts.StateExitConditionsEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureStateFigure_exitConditions());
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
				.DPtoLP(40), getMapMode().DPtoLP(40));
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
		return getChildBySemanticHint(org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.stateDiagram.edit.parts.StateNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class StateFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureStateFigure_name;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureStateFigure_entryConditions;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureStateFigure_activities;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureStateFigure_exitConditions;

		/**
		 * @generated
		 */
		public StateFigure() {

			FlowLayout layoutThis = new FlowLayout();
			layoutThis.setStretchMinorAxis(false);
			layoutThis.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

			layoutThis.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
			layoutThis.setMajorSpacing(5);
			layoutThis.setMinorSpacing(5);
			layoutThis.setHorizontal(true);

			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(8)));
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(1), getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(1)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure state0 = new RectangleFigure();
			state0.setOutlineXOR(true);
			state0.setForegroundColor(STATE0_FORE);

			this.add(state0);

			org.unicase.ui.stateDiagram.unicase.CenterLayout layoutState0 = new org.unicase.ui.stateDiagram.unicase.CenterLayout();

			state0.setLayoutManager(layoutState0);

			fFigureStateFigure_name = new WrappingLabel();
			fFigureStateFigure_name.setText("unnamed");

			fFigureStateFigure_name.setFont(FFIGURESTATEFIGURE_NAME_FONT);

			fFigureStateFigure_name.setBorder(new MarginBorder(getMapMode()
					.DPtoLP(0), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5)));

			state0.add(fFigureStateFigure_name);

			Polyline polyline0 = new Polyline();
			polyline0.setLocation(new Point(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0)));
			polyline0.setSize(getMapMode().DPtoLP(10), getMapMode().DPtoLP(10));

			this.add(polyline0);

			RectangleFigure stateFigure_entryConditions0 = new RectangleFigure();

			stateFigure_entryConditions0.setBorder(new MarginBorder(
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(-2),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(-2)));

			this.add(stateFigure_entryConditions0);

			FlowLayout layoutStateFigure_entryConditions0 = new FlowLayout();
			layoutStateFigure_entryConditions0.setStretchMinorAxis(false);
			layoutStateFigure_entryConditions0
					.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

			layoutStateFigure_entryConditions0
					.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
			layoutStateFigure_entryConditions0.setMajorSpacing(5);
			layoutStateFigure_entryConditions0.setMinorSpacing(5);
			layoutStateFigure_entryConditions0.setHorizontal(true);

			stateFigure_entryConditions0
					.setLayoutManager(layoutStateFigure_entryConditions0);

			fFigureStateFigure_entryConditions = new WrappingLabel();
			fFigureStateFigure_entryConditions.setText("");

			fFigureStateFigure_entryConditions
					.setFont(FFIGURESTATEFIGURE_ENTRYCONDITIONS_FONT);

			fFigureStateFigure_entryConditions.setBorder(new MarginBorder(
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(5)));

			stateFigure_entryConditions0
					.add(fFigureStateFigure_entryConditions);

			RectangleFigure stateFigure_activities0 = new RectangleFigure();

			stateFigure_activities0.setBorder(new MarginBorder(getMapMode()
					.DPtoLP(0), getMapMode().DPtoLP(-5),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(-5)));

			this.add(stateFigure_activities0);

			FlowLayout layoutStateFigure_activities0 = new FlowLayout();
			layoutStateFigure_activities0.setStretchMinorAxis(false);
			layoutStateFigure_activities0
					.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

			layoutStateFigure_activities0
					.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
			layoutStateFigure_activities0.setMajorSpacing(5);
			layoutStateFigure_activities0.setMinorSpacing(5);
			layoutStateFigure_activities0.setHorizontal(true);

			stateFigure_activities0
					.setLayoutManager(layoutStateFigure_activities0);

			fFigureStateFigure_activities = new WrappingLabel();
			fFigureStateFigure_activities.setText("");

			fFigureStateFigure_activities
					.setFont(FFIGURESTATEFIGURE_ACTIVITIES_FONT);

			fFigureStateFigure_activities.setBorder(new MarginBorder(
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));

			stateFigure_activities0.add(fFigureStateFigure_activities);

			RectangleFigure stateFigure_exitConditions0 = new RectangleFigure();

			stateFigure_exitConditions0.setBorder(new MarginBorder(getMapMode()
					.DPtoLP(0), getMapMode().DPtoLP(-1),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(-1)));

			this.add(stateFigure_exitConditions0);

			FlowLayout layoutStateFigure_exitConditions0 = new FlowLayout();
			layoutStateFigure_exitConditions0.setStretchMinorAxis(false);
			layoutStateFigure_exitConditions0
					.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

			layoutStateFigure_exitConditions0
					.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
			layoutStateFigure_exitConditions0.setMajorSpacing(5);
			layoutStateFigure_exitConditions0.setMinorSpacing(5);
			layoutStateFigure_exitConditions0.setHorizontal(true);

			stateFigure_exitConditions0
					.setLayoutManager(layoutStateFigure_exitConditions0);

			fFigureStateFigure_exitConditions = new WrappingLabel();
			fFigureStateFigure_exitConditions.setText("");

			fFigureStateFigure_exitConditions
					.setFont(FFIGURESTATEFIGURE_EXITCONDITIONS_FONT);

			fFigureStateFigure_exitConditions.setBorder(new MarginBorder(
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));

			stateFigure_exitConditions0.add(fFigureStateFigure_exitConditions);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = true;

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
		public WrappingLabel getFigureStateFigure_name() {
			return fFigureStateFigure_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStateFigure_entryConditions() {
			return fFigureStateFigure_entryConditions;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStateFigure_activities() {
			return fFigureStateFigure_activities;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStateFigure_exitConditions() {
			return fFigureStateFigure_exitConditions;
		}

	}

	/**
	 * @generated
	 */
	static final Color STATE0_FORE = new Color(null, 120, 120, 120);

	/**
	 * @generated
	 */
	static final Font FFIGURESTATEFIGURE_NAME_FONT = new Font(Display
			.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 9,
			SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURESTATEFIGURE_ENTRYCONDITIONS_FONT = new Font(
			Display.getCurrent(), Display.getDefault().getSystemFont()
					.getFontData()[0].getName(), 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURESTATEFIGURE_ACTIVITIES_FONT = new Font(Display
			.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 9,
			SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURESTATEFIGURE_EXITCONDITIONS_FONT = new Font(Display
			.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 9,
			SWT.NORMAL);

}
