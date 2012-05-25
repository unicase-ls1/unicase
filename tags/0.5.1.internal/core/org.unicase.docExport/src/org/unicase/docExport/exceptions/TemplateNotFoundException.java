/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exceptions;

/**
 * A template could not be found.
 * 
 * @author Sebastian Hoecht
 */
public class TemplateNotFoundException extends Exception {

	private static final long serialVersionUID = 4462931162843699016L;

	/**
	 * @param templateName the name of the template which could not be found
	 */
	public TemplateNotFoundException(String templateName) {
		super("The template " + templateName + " could not be found");
	}

}
