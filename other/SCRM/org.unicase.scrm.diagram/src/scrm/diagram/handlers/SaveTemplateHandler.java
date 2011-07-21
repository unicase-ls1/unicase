package scrm.diagram.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.workspace.util.WorkspaceUtil;

import scrm.SCRMDiagram;
import scrm.diagram.common.TemplateUtil;

/**
 * Handler for the Save Template command. This handler obtains a SCRM Diagram from
 * the context the command was called in and lets the user choose a file to save the
 * diagram as a template to. This template can be used by calling the Load Template
 * command.
 * 
 * @author mharut
 */
public class SaveTemplateHandler extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// obtain SCRMDiagram from selection
		SCRMDiagram scrmDiagram = obtainSCRMDiagram(event);
		
		// obtain the default directory to save files to
		String templatePath = TemplateUtil.getInstance().getTemplateDirectoryPath();
		
		// this dialog lets the user choose one file to save to
		FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
		dialog.setFilterPath(templatePath);
		dialog.setFilterExtensions(new String[] {"*.scrm", "*.*"});
		dialog.setFileName("myTemplate");
		dialog.setOverwrite(true);
		String resourcePath = dialog.open();
		
		// were the choices valid?
		if(scrmDiagram!=null && resourcePath!=null) {
			try {
				// perform the actual saving process
				TemplateUtil.doSave(scrmDiagram, resourcePath);
			} catch (IOException e) {
				WorkspaceUtil.logException("Saving SCRM template failed!", e);
			}
		}
		
		return null;
	}

	/**
	 * Obtains a SCRMDiagram by checking if one was selected. If no SCRMDiagram was
	 * selected, checks if the active editor is actually a diagram editor.
	 * If so, the Diagrams container, which is a SCRMDiagram, is returned.
	 * If none of the above holds, throws an IllegalArgumentException, as this
	 * Handler was falsely called. 
	 * 
	 * @param event an event containing all the information about the current 
	 * state of the application
	 * @return the properly obtained SCRMDiagram
	 * @throws ExecutionException if an exception occurred during the execution
	 */
	private SCRMDiagram obtainSCRMDiagram(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		// check if a SCRMDiagram was selected		
		IStructuredSelection ssel;
		if (selection != null && selection instanceof IStructuredSelection) {
			ssel = (IStructuredSelection) selection;
			if (!ssel.isEmpty() && ssel.getFirstElement() instanceof SCRMDiagram) {
				return (SCRMDiagram) ssel.getFirstElement();
			}
		}
		
		// no SCRMDiagram was selected -> check if a diagram editor is active
		IEditorPart editor = HandlerUtil.getActiveEditorChecked(event);
		if(editor instanceof DiagramEditor) {
			DiagramEditor diagramEditor = (DiagramEditor) editor;
			return (SCRMDiagram) diagramEditor.getDiagram().eContainer();
		} else {
			throw new IllegalArgumentException("Selection is invalid!");
		}
	}

}
