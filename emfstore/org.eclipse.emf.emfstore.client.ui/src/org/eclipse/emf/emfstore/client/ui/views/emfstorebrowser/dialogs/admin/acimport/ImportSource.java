/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.acimport;

import java.util.Properties;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;

/**
 * @author deser, karakoc
 */
public abstract class ImportSource implements ITreeContentProvider {

	/**
	 * @param obj
	 *            the object to get the children from.
	 * @return the children of the given object.
	 */
	public abstract Object[] getChildren(Object obj);

	/**
	 * @param obj
	 *            Object from which the parent object will be returned
	 * @return the parent object of the given object
	 * @see org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.acimport.ImportSource#getParent(java.lang.Object)
	 */
	public Object getParent(Object obj) {
		if (obj instanceof TreeItem) {
			if ((ImportItemWrapper) ((TreeItem) obj).getData() != null) {
				return ((ImportItemWrapper) ((TreeItem) obj).getData())
						.getParentOrgUnit();
			}
		}
		if (obj instanceof ImportItemWrapper) {
			return ((ImportItemWrapper) obj).getParentOrgUnit();
		}
		return null;
	}

	/**
	 * @param arg0
	 *            the object to get the information, if it has children.
	 * @return whether the given object has children or not.
	 */
	public boolean hasChildren(Object arg0) {
		// Get the children
		Object[] obj = getChildren(arg0);

		// Return whether the parent has children
		return obj == null ? false : obj.length > 0;
	}

	/**
	 * @param obj
	 *            The object to get the root elements from.
	 * @return The root elements of the given object.
	 */
	public abstract Object[] getElements(Object obj);

	/**
	 * @param properties
	 *            the properties of the import source
	 */
	public void setOptions(Properties properties) {
	}

	/**
	 * @return a small label for the import source.
	 */
	public abstract String getLabel();

	/**
	 * @param shell
	 *            Shell for UI actions, if needed. This parameter can be
	 *            ignored, if there is no use for it.
	 * @return whether the initialization of the source worked or not.
	 */
	public abstract boolean init(Shell shell);

	/**
	 * @return Returns a little description of the current ImportSource, e.g.
	 *         the server String of an LDAP server or the file of an CSV import.
	 */
	public abstract String getMessage();

}
