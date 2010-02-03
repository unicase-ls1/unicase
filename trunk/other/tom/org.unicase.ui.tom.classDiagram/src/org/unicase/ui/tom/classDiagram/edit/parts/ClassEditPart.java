package org.unicase.ui.tom.classDiagram.edit.parts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.tom.TouchController;
import org.unicase.ui.tom.classDiagram.edit.policies.TouchResizableShapeEditPolicy;
import org.unicase.ui.unicasecommon.diagram.part.ModelDiagramEditor;

public class ClassEditPart extends
		org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart {

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
