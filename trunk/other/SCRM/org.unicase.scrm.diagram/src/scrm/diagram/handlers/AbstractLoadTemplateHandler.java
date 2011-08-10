package scrm.diagram.handlers;

import java.io.IOException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.WorkspaceUtil;

import scrm.diagram.common.TemplateManager;

/**
 * Handler for the Load Template command. This handler lets the user choose a file
 * and loads it, if it is a valid SCRM Template file. Loading includes creating a
 * copy of the SCRMDiagram and adding it and all its elements to the selected project.
 * 
 * @author mharut
 */
public abstract class AbstractLoadTemplateHandler extends AbstractTemplateHandler {
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// obtain Project from selection
		ProjectSpace projectSpace = getInstanceOfClass(event, ProjectSpace.class);
		Project project = projectSpace.getProject();
		
		TemplateManager templateManager = getTemplateManager();
		
		// obtain the default directory to load files from
		String templatePath = templateManager.getTemplateDirectoryPath();
		
		// this dialog lets the user choose one file to load from
		FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
		dialog.setFilterPath(templatePath);
		dialog.setFilterExtensions(getTemplateFileExtensions());
		String resourcePath = dialog.open();

		// were the choices valid?
		if(project!=null && resourcePath!=null) {
			try {
				// perform the actual loading process
				templateManager.doLoad(project, resourcePath);
			} catch (IOException e) {
				WorkspaceUtil.logException("Loading SCRM template failed!", e);
			}
		}
		
		return null;
	}

}
