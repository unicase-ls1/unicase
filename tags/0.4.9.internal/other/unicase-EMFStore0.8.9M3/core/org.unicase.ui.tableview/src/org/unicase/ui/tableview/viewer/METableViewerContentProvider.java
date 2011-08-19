/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.viewer;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.UnicaseModelElement;

/**
 * This is the content provider for TaskView. Taskview shows checkables only.
 * 
 * @author zardosht
 */
public class METableViewerContentProvider implements IStructuredContentProvider {

	private org.eclipse.emf.emfstore.common.model.Project project;
	private EClass meType;
	private Collection<? extends UnicaseModelElement> directInput;

	/**
	 * {@inheritDoc} Returns checables only.
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		if (meType == null || project == null) {
			if (directInput != null) {
				return directInput.toArray();
			}
			return new Object[0];
		}

		List<? extends UnicaseModelElement> content = project.getAllModelElementsbyClass(meType,
			new BasicEList<UnicaseModelElement>());
		return content.toArray();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object,
	 *      java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput != oldInput) {
			if (newInput instanceof org.eclipse.emf.emfstore.common.model.Project) {
				this.project = (Project) newInput;
				directInput = null;
			} else if (newInput instanceof Collection) {
				this.directInput = (Collection<? extends UnicaseModelElement>) newInput;
				project = null;
				// meType = null;
			} else if (newInput == null) {
				this.project = null;
				directInput = Collections.emptyList();
			}
		}

	}

	/**
	 * This content provider shows all MEs of this type in project.
	 * 
	 * @param contentType model element type
	 */
	public void setMEType(EClass contentType) {
		this.meType = contentType;
	}

}
