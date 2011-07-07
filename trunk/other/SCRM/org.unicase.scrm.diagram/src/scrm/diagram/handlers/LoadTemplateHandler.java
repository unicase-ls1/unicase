package scrm.diagram.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.WorkspaceUtil;

import scrm.diagram.common.TemplateUtil;

/**
 * @author mharut
 *  
 * Handler for the Load Template command. This handler lets the user choose a file
 * and loads it, if it is a valid SCRM Template file. Loading includes creating a
 * copy of the SCRMDiagram and adding it and all its elements to the selected project.
 */
public class LoadTemplateHandler extends AbstractHandler {
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// obtain Project from selection
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		Project project = validateSelection(selection);
		
		// obtain the default directory to load files from
		String templatePath = TemplateUtil.instance.getTemplateDirectoryPath();
		
		// this dialog lets the user choose one file to load from
		FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
		dialog.setFilterPath(templatePath);
		dialog.setFilterExtensions(new String[] {"*.*", "*.scrm"});
		String resourcePath = dialog.open();

		// were the choices valid?
		if(project!=null && resourcePath!=null) {
			try {
				// perform the actual loading process
				TemplateUtil.doLoad(project, resourcePath);
			} catch (IOException e) {
				WorkspaceUtil.logException("Loading SCRM template failed!", e);
			}
		}
		
		return null;
	}

	/**
	 * Validates the selection in terms of returning the proper project.
	 * A project is returned if and only if a ProjectSpace was selected,
	 * otherwise this Handler shouldn't have been called and an 
	 * IllegalArgumentException is thrown.
	 * 
	 * @param selection the event's current selection
	 * @return the project obtained from validating the selection
	 */
	private Project validateSelection(ISelection selection) {
		IStructuredSelection ssel;
		if (selection != null && selection instanceof IStructuredSelection) {
			ssel = (IStructuredSelection) selection;
			if (ssel.isEmpty()) {
				throw new IllegalArgumentException("No Project selected!");
			} else if (ssel.getFirstElement() instanceof ProjectSpace){
				return ((ProjectSpace) ssel.getFirstElement()).getProject();
			} else {
				throw new IllegalArgumentException("Selected Object is no Project!");
			}
		}
		return null;
	}

}
