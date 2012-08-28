package org.unicase.scrm.unicase.handlers;

import java.io.IOException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.document.LeafSection;
import org.unicase.workspace.util.UnicaseCommand;

import scrm.diagram.common.SCRMTemplateManager;
import scrm.diagram.common.TemplateManager;
import scrm.diagram.handlers.AbstractTemplateHandler;

public class UnicaseLoadTemplateHandler extends AbstractTemplateHandler {
	
	private static final String[] templateFileExtensions = new String[] {"*.*", "*.scrm"};

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final LeafSection leafSection = getInstanceOfClass(event, LeafSection.class);
		
		final TemplateManager templateManager = getTemplateManager();
		
		// obtain the default directory to load files from
		String templatePath = templateManager.getTemplateDirectoryPath();
		
		// this dialog lets the user choose one file to load from
		FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
		dialog.setFilterPath(templatePath);
		dialog.setFilterExtensions(getTemplateFileExtensions());
		String resourcePath = dialog.open();
		
		// were the choices valid?
		if(leafSection !=null && resourcePath!=null) {
			try {
				// perform the actual loading process
				templateManager.doLoad(ModelUtil.getProject(leafSection), resourcePath);
				new UnicaseCommand() {

					@Override
					protected void doRun() {
						for(EObject copy : templateManager.getCopiedElements()) {
							if(copy.eContainer() instanceof Project) {
								leafSection.getModelElements().add(copy);
							}
						}
					}
					
				}.run(true);
				
			} catch (IOException e) {
				Status status = new Status(IStatus.ERROR, "org.unicase.scrm.diagram", e.getLocalizedMessage(), e);
				ErrorDialog.openError(Display.getCurrent().getActiveShell(), 
						"Invalid Template file",
						"The selected file is not a valid template file!", status);
			}
		}
		
		return null;
	}

	@Override
	protected SCRMTemplateManager getTemplateManager() {
		return new SCRMTemplateManager();
	}

	@Override
	protected String[] getTemplateFileExtensions() {
		return templateFileExtensions;
	}


}
