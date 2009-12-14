/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.unicase.ui.unicasecommon.diagram.figures.CenterLayout;
import org.unicase.ui.unicasecommon.diagram.figures.ConfigurableRectangleFigure;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @generated
 */
public class ClassEditPart extends ShapeNodeEditPart {

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
	public ClassEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy() {
			@Override
			public Command getCommand(Request request) {
				if (understandsRequest(request)) {
					if (request instanceof CreateViewAndElementRequest) {
						CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
							.getViewAndElementDescriptor().getCreateElementRequestAdapter();
						IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
						if (type == org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Attribute_3001) {
							EditPart compartmentEditPart = getChildBySemanticHint(org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID));
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
						if (type == org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Method_3002) {
							EditPart compartmentEditPart = getChildBySemanticHint(org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID));
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
					}
					return super.getCommand(request);
				}
				return null;
			}
		});
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
			new org.unicase.ui.diagram.classDiagram.edit.policies.ClassItemSemanticEditPolicy());
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
						return new org.unicase.ui.diagram.classDiagram.edit.policies.ModelTextSelectionEditPolicy();
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
		ClassFigure figure = new ClassFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ClassFigure getPrimaryShape() {
		return (ClassFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ClassNameEditPart) {
			((ClassNameEditPart) childEditPart)
				.setLabel(getPrimaryShape().getFigureClassFigure_name());
			return true;
		}
		if (childEditPart instanceof ClassClassNode_attributesEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_attributes();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_attributesEditPart) childEditPart)
				.getFigure());
			return true;
		}
		if (childEditPart instanceof ClassClassNode_methodsEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_methods();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_methodsEditPart) childEditPart)
				.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof ClassClassNode_attributesEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_attributes();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane
				.remove(((ClassClassNode_attributesEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof ClassClassNode_methodsEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_methods();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.remove(((org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_methodsEditPart) childEditPart)
				.getFigure());
			return true;
		}
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

		if (editPart instanceof ClassClassNode_attributesEditPart) {
			return getPrimaryShape().getFigureClassFigure_attributes();
		}
		if (editPart instanceof ClassClassNode_methodsEditPart) {
			return getPrimaryShape().getFigureClassFigure_methods();
		}
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
		return getChildBySemanticHint(org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
			.getType(org.unicase.ui.diagram.classDiagram.edit.parts.ClassNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class ClassFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureClassFigure_name;

		/**
		 * @generated
		 */
		private ConfigurableRectangleFigure fFigureClassFigure_attributes;
		/**
		 * @generated
		 */
		private ConfigurableRectangleFigure fFigureClassFigure_methods;

		/**
		 * @generated
		 */
		public ClassFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(1),
				getMapMode().DPtoLP(0)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			ConfigurableRectangleFigure classFigure_Header0 = new ConfigurableRectangleFigure();

			classFigure_Header0.setBorders("NEW");

			this.add(classFigure_Header0);

			CenterLayout layoutClassFigure_Header0 = new CenterLayout();

			classFigure_Header0.setLayoutManager(layoutClassFigure_Header0);

			fFigureClassFigure_name = new WrappingLabel();
			fFigureClassFigure_name.setText("unnamed");

			fFigureClassFigure_name.setFont(FFIGURECLASSFIGURE_NAME_FONT);

			fFigureClassFigure_name.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(5),
				getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));

			classFigure_Header0.add(fFigureClassFigure_name);

			fFigureClassFigure_attributes = new org.unicase.ui.unicasecommon.diagram.figures.ConfigurableRectangleFigure();

			fFigureClassFigure_attributes.setBorders("EW");

			this.add(fFigureClassFigure_attributes);
			fFigureClassFigure_attributes.setLayoutManager(new StackLayout());

			fFigureClassFigure_methods = new ConfigurableRectangleFigure();

			fFigureClassFigure_methods.setBorders("EW");

			this.add(fFigureClassFigure_methods);
			fFigureClassFigure_methods.setLayoutManager(new StackLayout());

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
		public WrappingLabel getFigureClassFigure_name() {
			return fFigureClassFigure_name;
		}

		/**
		 * @generated
		 */
		public ConfigurableRectangleFigure getFigureClassFigure_attributes() {
			return fFigureClassFigure_attributes;
		}

		/**
		 * @generated
		 */
		public ConfigurableRectangleFigure getFigureClassFigure_methods() {
			return fFigureClassFigure_methods;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGURECLASSFIGURE_NAME_FONT = new Font(Display.getCurrent(), Display.getDefault()
		.getSystemFont().getFontData()[0].getName(), 9, SWT.NORMAL);

}
