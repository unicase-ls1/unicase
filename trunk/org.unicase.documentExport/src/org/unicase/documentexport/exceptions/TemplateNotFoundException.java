package org.unicase.documentexport.exceptions;

@SuppressWarnings("serial")
public class TemplateNotFoundException extends Exception {

	public TemplateNotFoundException(String templateName) {
		super("The template " + templateName + " could not be found");
	}

}
