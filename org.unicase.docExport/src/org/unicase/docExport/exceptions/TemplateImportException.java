/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exceptions;

/**
 * Any error while importing a template.
 * 
 * @author Sebastian Hoecht
 */
public class TemplateImportException extends Exception {
	private static final long serialVersionUID = -8993878185865408711L;

	/**
	 * constructor.
	 * 
	 * @param e the nested exception
	 */
	public TemplateImportException(Exception e) {
		super(e);
	}
}
