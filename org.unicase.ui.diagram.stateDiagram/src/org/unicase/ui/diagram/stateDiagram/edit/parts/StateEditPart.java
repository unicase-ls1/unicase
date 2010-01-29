/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.stateDiagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RoundedRectangle;
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
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.unicase.ui.diagram.stateDiagram.unicase.CenterLayout;
import org.unicase.ui.unicasecommon.diagram.figures.ConfigurableRectangleFigure;

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
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
			new org.unicase.ui.diagram.stateDiagram.edit.policies.StateItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
		// editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {

		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new org.unicase.ui.diagram.stateDiagram.edit.policies.ModelTextSelectionEditPolicy();
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
		if (childEditPart instanceof org.unicase.ui.diagram.stateDiagram.edit.parts.StateNameEditPart) {
			((org.unicase.ui.diagram.stateDiagram.edit.parts.StateNameEditPart) childEditPart)
				.setLabel(getPrimaryShape().getFigureStateFigure_name());
			return true;
		}
		if (childEditPart instanceof org.unicase.ui.diagram.stateDiagram.edit.parts.StateEntryConditionsEditPart) {
			((org.unicase.ui.diagram.stateDiagram.edit.parts.StateEntryConditionsEditPart) childEditPart)
				.setLabel(getPrimaryShape().getFigureStateFigure_entryConditions());
			return true;
		}
		if (childEditPart instanceof org.unicase.ui.diagram.stateDiagram.edit.parts.StateActivitiesEditPart) {
			((org.unicase.ui.diagram.stateDiagram.edit.parts.StateActivitiesEditPart) childEditPart)
				.setLabel(getPrimaryShape().getFigureStateFigure_activities());
			return true;
		}
		if (childEditPart instanceof org.unicase.ui.diagram.stateDiagram.edit.parts.StateExitConditionsEditPart) {
			((org.unicase.ui.diagram.stateDiagram.edit.parts.StateExitConditionsEditPart) childEditPart)
				.setLabel(getPrimaryShape().getFigureStateFigure_exitConditions());
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
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
		return result;
	}

	/**
	 * Creates figure for this edit part. Body of this method does not depend on settings in generation model so you may
	 * safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	@Override
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
			layout.setSpacing(getMapMode().DPtoLP(5));
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	@Override
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
			.getType(org.unicase.ui.diagram.stateDiagram.edit.parts.StateNameEditPart.VISUAL_ID));
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

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(8), getMapMode().DPtoLP(0), getMapMode().DPtoLP(8),
				getMapMode().DPtoLP(0)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			ConfigurableRectangleFigure stateFigure_name0 = new ConfigurableRectangleFigure();

			stateFigure_name0.setBorders("SEW");

			stateFigure_name0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(5), getMapMode()
				.DPtoLP(2), getMapMode().DPtoLP(5)));

			this.add(stateFigure_name0);

			CenterLayout layoutStateFigure_name0 = new CenterLayout();

			stateFigure_name0.setLayoutManager(layoutStateFigure_name0);

			fFigureStateFigure_name = new WrappingLabel();
			fFigureStateFigure_name.setText("unnamed");

			fFigureStateFigure_name.setFont(FFIGURESTATEFIGURE_NAME_FONT);

			fFigureStateFigure_name.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(5),
				getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));

			stateFigure_name0.add(fFigureStateFigure_name);

			ConfigurableRectangleFigure stateFigure_entryConditions0 = new ConfigurableRectangleFigure();

			stateFigure_entryConditions0.setBorders("EW");

			stateFigure_entryConditions0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(5),
				getMapMode().DPtoLP(2), getMapMode().DPtoLP(5)));

			this.add(stateFigure_entryConditions0);

			org.unicase.ui.diagram.stateDiagram.unicase.CenterLayout layoutStateFigure_entryConditions0 = new org.unicase.ui.diagram.stateDiagram.unicase.CenterLayout();

			stateFigure_entryConditions0.setLayoutManager(layoutStateFigure_entryConditions0);

			fFigureStateFigure_entryConditions = new WrappingLabel();
			fFigureStateFigure_entryConditions.setText("");

			fFigureStateFigure_entryConditions.setFont(FFIGURESTATEFIGURE_ENTRYCONDITIONS_FONT);

			fFigureStateFigure_entryConditions.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode()
				.DPtoLP(5), getMapMode().DPtoLP(0), getMapMode().DPtoLP(5)));

			stateFigure_entryConditions0.add(fFigureStateFigure_entryConditions);

			ConfigurableRectangleFigure stateFigure_activities0 = new ConfigurableRectangleFigure();

			stateFigure_activities0.setBorders("EW");

			stateFigure_activities0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(5),
				getMapMode().DPtoLP(2), getMapMode().DPtoLP(5)));

			this.add(stateFigure_activities0);

			org.unicase.ui.diagram.stateDiagram.unicase.CenterLayout layoutStateFigure_activities0 = new org.unicase.ui.diagram.stateDiagram.unicase.CenterLayout();

			stateFigure_activities0.setLayoutManager(layoutStateFigure_activities0);

			fFigureStateFigure_activities = new WrappingLabel();
			fFigureStateFigure_activities.setText("");

			fFigureStateFigure_activities.setFont(FFIGURESTATEFIGURE_ACTIVITIES_FONT);

			fFigureStateFigure_activities.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(5),
				getMapMode().DPtoLP(0), getMapMode().DPtoLP(5)));

			stateFigure_activities0.add(fFigureStateFigure_activities);

			ConfigurableRectangleFigure stateFigure_exitConditions0 = new ConfigurableRectangleFigure();

			stateFigure_exitConditions0.setBorders("EW");

			stateFigure_exitConditions0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(5),
				getMapMode().DPtoLP(2), getMapMode().DPtoLP(5)));

			this.add(stateFigure_exitConditions0);

			org.unicase.ui.diagram.stateDiagram.unicase.CenterLayout layoutStateFigure_exitConditions0 = new org.unicase.ui.diagram.stateDiagram.unicase.CenterLayout();

			stateFigure_exitConditions0.setLayoutManager(layoutStateFigure_exitConditions0);

			fFigureStateFigure_exitConditions = new WrappingLabel();
			fFigureStateFigure_exitConditions.setText("");

			fFigureStateFigure_exitConditions.setFont(FFIGURESTATEFIGURE_EXITCONDITIONS_FONT);

			fFigureStateFigure_exitConditions.setBorder(new MarginBorder(getMapMode().DPtoLP(0),
				getMapMode().DPtoLP(5), getMapMode().DPtoLP(0), getMapMode().DPtoLP(5)));

			stateFigure_exitConditions0.add(fFigureStateFigure_exitConditions);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		@Override
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
	static final Font FFIGURESTATEFIGURE_NAME_FONT = new Font(Display.getCurrent(), Display.getDefault()
		.getSystemFont().getFontData()[0].getName(), 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURESTATEFIGURE_ENTRYCONDITIONS_FONT = new Font(Display.getCurrent(), Display.getDefault()
		.getSystemFont().getFontData()[0].getName(), 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURESTATEFIGURE_ACTIVITIES_FONT = new Font(Display.getCurrent(), Display.getDefault()
		.getSystemFont().getFontData()[0].getName(), 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURESTATEFIGURE_EXITCONDITIONS_FONT = new Font(Display.getCurrent(), Display.getDefault()
		.getSystemFont().getFontData()[0].getName(), 9, SWT.NORMAL);

}
