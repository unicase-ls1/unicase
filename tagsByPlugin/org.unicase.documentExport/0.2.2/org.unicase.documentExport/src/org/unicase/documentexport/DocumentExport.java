package org.unicase.documentexport;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.unicase.documentexport.docWriter.DocWriter;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.documentexport.renderers.DocumentRenderer;
import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.model.ModelElement;

public class DocumentExport implements IRunnableWithProgress{

	ModelElement modelElement;
	DocWriter docWriter;
	DocumentTemplate template;
	DocumentRenderer renderer;
	String fileName;
	
	public DocumentExport(
			ModelElement modelElement, 
			DocWriter docWriter, 
			DocumentTemplate documentTemplate,
			DocumentRenderer renderer
	) {
		this.modelElement = modelElement;
		this.docWriter = docWriter;
		this.template = documentTemplate;
		this.renderer = renderer;
	}
	
	public void export(String fileName) {
		UCompositeSection doc = renderer.renderDocument(modelElement, template);
		
		docWriter.export(fileName, doc);

	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		
		monitor.beginTask("Exporting Document", IProgressMonitor.UNKNOWN);
		export(this.fileName);
		monitor.done();
		
		if (monitor.isCanceled())
			throw new InterruptedException("The export has been canceled");
	}
}
