package scrm.diagram.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import scrm.diagram.common.TemplateManager;

/**
 * Handler for the Save Template command. This handler obtains a SCRM Diagram from
 * the context the command was called in and lets the user choose a file to save the
 * diagram as a template to. This template can be used by calling the Load Template
 * command.
 * 
 * @author mharut
 */
public abstract class AbstractSaveTemplateHandler extends AbstractTemplateHandler {

	private static final String defaultTemplateFileName = "myTemplate";

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// obtain SCRMDiagram from selection
		EObject rootEObject = getRootEObject(event);
		
		TemplateManager templateManager = getTemplateManager();
		
		// obtain the default directory to save files to
		String templatePath = templateManager.getTemplateDirectoryPath();
		
		// this dialog lets the user choose one file to save to
		FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
		dialog.setFilterPath(templatePath);
		dialog.setFilterExtensions(getTemplateFileExtensions());
		dialog.setFileName(getDefaultTemplateFileName());
		dialog.setOverwrite(true);
		String resourcePath = dialog.open();
		
		// were the choices valid?
		if(rootEObject!=null && resourcePath!=null) {
			// perform the actual saving process
			templateManager.doSave(rootEObject, resourcePath);
		}
		
		return null;
	}

	protected EObject getRootEObject(ExecutionEvent event) {
		return getSelectedClass(event, EObject.class);
	}
	
	protected String getDefaultTemplateFileName() {
		return defaultTemplateFileName;
	}
	
}
