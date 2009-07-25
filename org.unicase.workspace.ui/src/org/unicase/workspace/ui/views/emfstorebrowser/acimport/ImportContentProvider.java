/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.acimport;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * @author deser
 */
public class ImportContentProvider implements ITreeContentProvider {

	private ImportSource source;

	/**
	 * @param controller the import controller
	 */
	public ImportContentProvider(ImportController controller) {
		super();
		this.source = controller.getImportSource();
		// this.source.init();
	}

	/**
	 * Gets the children of the specified object.
	 * 
	 * @param arg0 the parent object
	 * @return Object[]
	 */
	public Object[] getChildren(Object arg0) {
		return source.getChildren(arg0);
	}

	/**
	 * Gets the parent of the specified object.
	 * 
	 * @param arg0 the object
	 * @return Object
	 */
	public Object getParent(Object arg0) {
		return source.getParent(arg0);
	}

	/**
	 * Returns whether the passed object has children.
	 * 
	 * @param arg0 the parent object
	 * @return boolean
	 */
	public boolean hasChildren(Object arg0) {
		// Get the children
		Object[] obj = getChildren(arg0);

		// Return whether the parent has children
		return obj == null ? false : obj.length > 0;
	}

	/**
	 * Gets the root element(s) of the tree.
	 * 
	 * @param arg0 the input data
	 * @return Object[]
	 */
	public Object[] getElements(Object arg0) {
		// These are the root elements of the tree
		return source.getElements(arg0);
	}

	/**
	 * Disposes any created resources.
	 */
	public void dispose() {
		// Nothing to dispose
	}

	/**
	 * Called when the input changes.
	 * 
	 * @param arg0 the viewer
	 * @param arg1 the old input
	 * @param arg2 the new input
	 */
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		// Nothing to change
	}
}
