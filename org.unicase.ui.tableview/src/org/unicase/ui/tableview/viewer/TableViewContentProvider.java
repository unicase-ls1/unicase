/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.tableview.viewer;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.ModelElement;

/**
 * 
 * @author Hodaie
 * 
 * 
 */
public class TableViewContentProvider implements IStructuredContentProvider {

	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public Object[] getElements(Object inputElement) {

		return (ModelElement[]) inputElement;

	}

	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public void dispose() {

	}

	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

}
