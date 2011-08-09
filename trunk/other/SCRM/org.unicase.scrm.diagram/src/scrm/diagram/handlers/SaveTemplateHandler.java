package scrm.diagram.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.workspace.util.WorkspaceUtil;

import scrm.SCRMDiagram;
import scrm.diagram.common.SCRMTemplateManager;
import scrm.diagram.common.TemplateManager;

public class SaveTemplateHandler extends AbstractSaveTemplateHandler {
	
	private static final String[] filterExtensions = new String[] {"*.scrm", "*.*"};

	@Override
	protected EObject getRootEObject(ExecutionEvent event) {
		SCRMDiagram rootDiagram = getSelectedClass(event, SCRMDiagram.class);
		if(rootDiagram == null) {
			// no SCRMDiagram was selected -> check if a diagram editor is active
			IEditorPart editor;
			try {
				editor = HandlerUtil.getActiveEditorChecked(event);
				if(editor instanceof DiagramEditor) {
					DiagramEditor diagramEditor = (DiagramEditor) editor;
					EObject diagramCanvas = diagramEditor.getDiagram().eContainer();
					if(diagramCanvas instanceof SCRMDiagram) {
						rootDiagram = (SCRMDiagram) diagramCanvas;
					}
				}
			} catch (ExecutionException e) {
				WorkspaceUtil.logException("Saving template failed: Editor error!", e);
			}
		}
		if(rootDiagram == null) {
			throw new IllegalArgumentException("Selection is invalid!");
		}
		return rootDiagram;
	}
	
	@Override
	protected TemplateManager getTemplateManager() {
		return new SCRMTemplateManager();
	}

	@Override
	protected String[] getTemplateFileExtensions() {
		return filterExtensions;
	}

}
