package org.unicase.documentexport;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.unicase.documentexport.docWriter.DocWriter;
import org.unicase.documentexport.documentTemplate.Template;
import org.unicase.documentexport.documentTemplate.renderers.DocumentRenderer;
import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.model.ModelElement;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class DocumentExport implements IRunnableWithProgress{

	private ModelElement modelElement;
	private DocWriter docWriter;
	private Template template;
	private DocumentRenderer renderer;
	private String fileLocation;
	
	/**
	 * 
	 * @param modelElement the ModelElement you want to export
	 * @param docWriter the docWriter used to write the document
	 * @param documentTemplate the template which defines how the modelElement is rendered
	 * @param renderer the DocumentRenderer which renders the modelElement using the template
	 */
	public DocumentExport(
			ModelElement modelElement, 
			DocWriter docWriter, 
			Template documentTemplate,
			DocumentRenderer renderer
	) {
		this.modelElement = modelElement;
		this.docWriter = docWriter;
		this.template = documentTemplate;
		this.renderer = renderer;
	}
	
	/**
	 * exports a the ModelElement to the file.
	 * @param fileLocation the location where the modelElement shall be exported.
	 */
	public void export(String fileLocation) {
		UCompositeSection doc = renderer.render(modelElement, template);
		
		docWriter.export(fileLocation, doc);

	}
	
	/**
	 * @param monitor i dunno what this param is for, because i don't use it ;)
	 * @throws InterruptedException .
	 * @throws InvocationTargetException .
	 */
	public void run(IProgressMonitor monitor) 
		throws InvocationTargetException, InterruptedException {
		
		monitor.beginTask("Exporting Document", IProgressMonitor.UNKNOWN);
		export(this.fileLocation);
		
		if (monitor.isCanceled()) {
			throw new InterruptedException("The export has been canceled");
		}
		
		monitor.done();
	}

	/**
	 * @param fileLocation the fileLocation to set
	 */
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
}
