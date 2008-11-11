package org.unicase.docExport.commands;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.docExport.DocumentExport;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.docWriter.HtmlWriter;
import org.unicase.docExport.docWriter.PdfWriter;
import org.unicase.docExport.docWriter.RtfWriter;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersFactory;
import org.unicase.model.ModelElement;
import org.unicase.model.impl.ModelElementImpl;



/**
 * 
 * @author Sebastian Höcht
 *
 */
public class ExportDocument extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
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
	    String[] filterExt = {"*.pdf", ".rtf", ".html"};
	    fd.setFilterExtensions(filterExt);
	    String selected = fd.open();
		
		if (selected != null) {
			File f = new File(selected);
			Boolean doIt = true;
			if (f.exists()) {
				MessageBox messageBox = new MessageBox(new Shell(), 
						SWT.YES | SWT.NO | SWT.ICON_WARNING | SWT.CENTER );
				messageBox.setMessage("The file '" + selected + "' already exists. Do you want to overwrite it?");
				messageBox.setText("File already exists");
				int result = messageBox.open();
				if (result == SWT.NO) {
					doIt = false;
				}
			} 
			
			if (doIt) { 
				Path path = new Path(selected);
				if (path.getFileExtension() == null) {
					selected += ".pdf";
				}
				
				DocumentExport docExport;
				
				path = new Path(selected);
				if (path.getFileExtension().equals("rtf")) {
					docExport = new DocumentExport(
							modelElement, 
							new RtfWriter(), 
							TemplateRegistry.getTemplate(), 
							DefaultRenderersFactory.eINSTANCE.createDefaultDocumentRenderer()
						);	
				} else if (path.getFileExtension().equals("html")) {
					docExport = new DocumentExport(
							modelElement, 
							new HtmlWriter(),
							TemplateRegistry.getTemplate(), 
							DefaultRenderersFactory.eINSTANCE.createDefaultDocumentRenderer()
						);				
				} else {
					docExport = new DocumentExport(
							modelElement, 
							new PdfWriter(), 
							TemplateRegistry.getTemplate(), 
							DefaultRenderersFactory.eINSTANCE.createDefaultDocumentRenderer()
						);					
				}


				docExport.setFileLocation(selected);
				
				ProgressMonitorDialog dialog = new ProgressMonitorDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
				
				//dialog.open();
				try {
					dialog.run(true, true, docExport);
				} catch (InvocationTargetException e) {
					MessageBox finished = new MessageBox(new Shell(), SWT.OK | SWT.ICON_WORKING);
					finished.setText("Export status");
					finished.setMessage(e.getClass().getSimpleName() + ": " + e.getMessage());
					finished.open();
					e.printStackTrace();
				} catch (InterruptedException e) {
					MessageBox finished = new MessageBox(new Shell(), SWT.OK | SWT.ICON_WORKING);
					finished.setText("Export status");
					finished.setMessage("Export interrupted");
					finished.open();
					e.printStackTrace();
				}
			}
		}
		
//		System.out.println(TemplateSaveHelper.meCount);

		return null;
		
	}
}
