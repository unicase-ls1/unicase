/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholders.filtering;

import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlModelElement;

/**
 * Filter for the UNICASE navigation view.
 * @author kterzieva
 *
 */
public class NavigatorViewerFilter extends ViewerFilter {
	private final StakeholderRole role;

	/**
	 * The construct.
	 * @param role the stakeholder role, which includes the settings for the filtering
	 */
	public NavigatorViewerFilter(StakeholderRole role) {
		this.role = role;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof UrmlModelElement) {
			EMap<EClass, EList<EStructuralFeature>> filterSet = role.getFilterSet();
			for (Entry<EClass, EList<EStructuralFeature>> entry : filterSet) {		
				 if(entry.getKey().getName().equals(((UrmlModelElement) element).eClass().getName())){
					 return true;
				 }
			}
			return false;
		}
		return true;
	}
}