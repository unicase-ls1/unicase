package org.unicase.ui.tom.classDiagram.edit.parts;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
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
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.diagram.ConfigurableRectangleFigure;
import org.unicase.ui.common.diagram.figures.CenterLayout;
import org.unicase.ui.common.diagram.part.ModelDiagramEditor;
import org.unicase.ui.tom.TouchController;
import org.unicase.ui.tom.classDiagram.edit.policies.TouchResizableShapeEditPolicy;
import org.unicase.ui.tom.tools.TouchConstants;

public class ClassEditPart extends
		org.unicase.model.classDiagram.edit.parts.ClassEditPart {

	public ClassEditPart(View view) {
		super(view);
	}

	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy editPolicy = super.getPrimaryDragEditPolicy();
		
		if (!TouchController.getInstance().isActive()) {
			return editPolicy;
		}
		
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (activeWorkbenchWindow == null) {
			return editPolicy;
		}

		IEditorPart editor = activeWorkbenchWindow.getActivePage()
				.getActiveEditor();
		if (editor == null || !(editor instanceof ModelDiagramEditor)) {
			return editPolicy;
		}

		ModelDiagramEditor activeEditor = (ModelDiagramEditor) editor;

		RootEditPart diagramRoot = activeEditor.getDiagramEditPart().getRoot();
		RootEditPart editPartRoot = this.getRoot();

		if (diagramRoot == editPartRoot) {
			editPolicy = new TouchResizableShapeEditPolicy();	
		}
		
		return editPolicy;
	}

}
