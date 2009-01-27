/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
