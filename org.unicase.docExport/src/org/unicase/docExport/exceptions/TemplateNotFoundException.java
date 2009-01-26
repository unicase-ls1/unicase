package org.unicase.docExport.exceptions;

/**
 * @author Sebastian Hoecht
 */
@SuppressWarnings("serial")
public class TemplateNotFoundException extends Exception {

	/**
	 * @param templateName the name of the template which could not be found
	 */
	public TemplateNotFoundException(String templateName) {
		super("The template " + templateName + " could not be found");
	}

}
