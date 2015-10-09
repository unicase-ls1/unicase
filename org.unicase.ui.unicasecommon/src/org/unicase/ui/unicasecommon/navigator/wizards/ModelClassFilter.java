/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.wizards;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.diagram.MEDiagram;

/**
 * Filter for selective input in the NewModelElementWizard.
 * 
 * @author Shterev
 */
public class ModelClassFilter extends ViewerFilter {

	private String searchTerm;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchTerm == null || searchTerm.length() == 0) {
			return true;
		}
		if (element instanceof EClass) {
			return ((EClass) element).getName().toLowerCase().contains(searchTerm.toLowerCase())
				|| ((EPackage) parentElement).getName().toLowerCase().contains(searchTerm.toLowerCase());
		} else if (element instanceof EPackage) {
			EPackage ePackage = (EPackage) element;
			Object[] children = ((ModelTreeContentProvider) ((TreeViewer) viewer).getContentProvider())
				.getChildren(element);
			boolean show = ePackage.getName().toLowerCase().contains(searchTerm.toLowerCase());
			for (Object child : children) {
				show = show || select(viewer, element, child);
			}
			return show;
		} else if (element instanceof MEDiagram) {
			return ((MEDiagram) element).getName().toLowerCase().contains(searchTerm.toLowerCase());
		}
		return true;
	}

	/**
	 * Sets the search term for this name filter.
	 * 
	 * @param searchTerm the search term
	 */
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
}
