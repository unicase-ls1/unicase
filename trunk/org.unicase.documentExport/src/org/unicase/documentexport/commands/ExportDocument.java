package org.unicase.documentexport.commands;





import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.documentexport.docWriter.PdfWriter;
import org.unicase.documentexport.renderers.DocumentRenderer;
import org.unicase.documentexport.DocumentExport;
import org.unicase.documentexport.TemplateSaveHelper;
import org.unicase.model.ModelElement;
import org.unicase.model.impl.ModelElementImpl;



public class ExportDocument extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}
		
		Object o = ssel.getFirstElement();
		if (!(o instanceof ModelElement)) {
			return null;
		}
		
		ModelElementImpl modelElement = (ModelElementImpl) o;
	
		
	    Shell s = new Shell();
	    
	    FileDialog fd = new FileDialog(s, SWT.SAVE);
	    fd.setText("select file for export of " + modelElement.getName());
	    String[] filterExt = {"*.pdf", "*.txt", "*.doc", ".rtf", "*.*"};
	    fd.setFilterExtensions(filterExt);
	    String selected = fd.open();
//	    System.out.println(selected);
		
		if (selected != null) {
			File f = new File(selected);
			Boolean doIt = true;
			if (f.exists()) {
				MessageBox messageBox = new MessageBox(new Shell(), 
						SWT.YES | SWT.NO | SWT.ICON_WARNING | SWT.CENTER );
				messageBox.setMessage("The file '" + selected + "' already exists. Do you want to overwrite it?");
				messageBox.setText("File already exists");
				int result = messageBox.open();
				if (result == SWT.NO)
					doIt = false;
			} 
			
			if (doIt) { 

				DocumentExport docExport = new DocumentExport(
						modelElement, 
						new PdfWriter(), 
						TemplateSaveHelper.getTemplate(), 
						new DocumentRenderer()
					);
				//docExport.export(selected);	
				docExport.setFileName(selected);
				
				ProgressMonitorDialog dialog = new ProgressMonitorDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
				
				//dialog.open();
				try {
					dialog.run(true, true, docExport);
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				


//				MessageBox finished = new MessageBox(new Shell(), SWT.OK | SWT.ICON_WORKING);
//				finished.setText("Export status");
//				finished.setMessage("export successfull");
//				finished.open();
			}
		}
		
//		System.out.println(TemplateSaveHelper.meCount);

		return null;
		
	}
	
}
