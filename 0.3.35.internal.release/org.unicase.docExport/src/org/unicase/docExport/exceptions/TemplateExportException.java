/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exceptions;

/**
 * Any error while exporting a template.
 * 
 * @author Sebastian Hoecht
 */
public class TemplateExportException extends Exception {

	private static final long serialVersionUID = 8486934896423948673L;

	/**
	 * constructor.
	 * 
	 * @param e the nested exception
	 */
	public TemplateExportException(Exception e) {
		super(e);
	}

}
