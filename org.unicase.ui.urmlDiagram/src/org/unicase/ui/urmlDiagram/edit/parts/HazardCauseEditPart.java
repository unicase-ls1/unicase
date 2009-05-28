package org.unicase.ui.urmlDiagram.edit.parts;

import org.eclipse.draw2d.ImageFigure;
import org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin;

	/**
 * @generated
 */
public class HazardCauseEditPart extends org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart  {

				/**
 * @generated
 */
	public static final int VISUAL_ID = 2003;

		/**
 * @generated
 */
	protected org.eclipse.draw2d.IFigure contentPane;

		/**
 * @generated
 */
	protected org.eclipse.draw2d.IFigure primaryShape;
	
			/**
 * @generated
 */
	public HazardCauseEditPart(org.eclipse.gmf.runtime.notation.View view) {
		super(view);
	}
	
			/**
 * @generated
 */
	protected void createDefaultEditPolicies() {
					super.createDefaultEditPolicies();
			installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.SEMANTIC_ROLE, new org.unicase.ui.urmlDiagram.edit.policies.HazardCauseItemSemanticEditPolicy());
						installEditPolicy(org.eclipse.gef.EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
			// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
	// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}
	
			/**
 * @generated
 */
	protected org.eclipse.gef.editpolicies.LayoutEditPolicy createLayoutEditPolicy() {
					org.eclipse.gef.editpolicies.LayoutEditPolicy lep = new org.eclipse.gef.editpolicies.LayoutEditPolicy() {

			protected org.eclipse.gef.EditPolicy createChildEditPolicy(org.eclipse.gef.EditPart child) {
								org.eclipse.gef.EditPolicy result = child.getEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new org.eclipse.gef.editpolicies.NonResizableEditPolicy();
				}
				return result;
			}

			protected org.eclipse.gef.commands.Command getMoveChildrenCommand(org.eclipse.gef.Request request) {
				return null;
			}

			protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gef.requests.CreateRequest request) {
				return null;
			}
		};
		return lep;
		}
	
			/**
 * @generated
 */
	protected org.eclipse.draw2d.IFigure createNodeShape() {
		HazardCauseFigure figure = new HazardCauseFigure();
		 		return primaryShape = figure;
	}

			/**
 * @generated
 */
	public HazardCauseFigure getPrimaryShape() {
		return (HazardCauseFigure) primaryShape;
	}
	
			
			
			
			
			
			
			/**
 * @generated
 */
	protected org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure createNodePlate() {
		org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure result =
			new org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
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
	protected org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure createNodeFigure() {
		org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new org.eclipse.draw2d.StackLayout());
		org.eclipse.draw2d.IFigure shape = createNodeShape();
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
	protected org.eclipse.draw2d.IFigure setupContentPane(org.eclipse.draw2d.IFigure nodeShape) {
				return nodeShape; // use nodeShape itself as contentPane
	}
	
			/**
 * @generated
 */
	public org.eclipse.draw2d.IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}
	
			
		
		
	
	
/**
 * @generated
 */
public class HazardCauseFigure extends ImageFigure {




	public HazardCauseFigure() {
        super(ModelDiagramEditorPlugin.imageDescriptorFromPlugin(ModelDiagramEditorPlugin.ID,
                "icons/NewDiagramWizard.gif").createImage(), 0);
    }




}



	}
