/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.taskview.filters;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * This filter filters to the elements of a ModelElement.
 * 
 * @author abdelhamidbarzali.
 */
public class UnicaseViewerFilter extends ViewerFilter {
	private EClass eclass;

	/**
	 * @param eclass EClass.
	 */
	public UnicaseViewerFilter(EClass eclass) {
		setEclass(eclass);
	}

	/**
	 * @param element Object.
	 * @param viewer Viewer.
	 * @param parentElement Object.
	 * @return Boolean.
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		return getEclass().isInstance(element);
	}

	/**
	 * @return EClass
	 */
	public EClass getEclass() {
		return eclass;
	}

	/**
	 * @param eclass {@link EClass}
	 */
	public void setEclass(EClass eclass) {
		this.eclass = eclass;
	}

}
