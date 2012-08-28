/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.release;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.WorkItem;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Abstract Release</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.release.AbstractRelease#getIncludedWorkItems <em>Included Work Items</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.release.ReleasePackage#getAbstractRelease()
 * @model abstract="true"
 * @generated
 */
public interface AbstractRelease extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Included Work Items</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.task.WorkItem}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.task.WorkItem#getIncludingReleases <em>Including Releases</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Included Work Items</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Included Work Items</em>' reference list.
	 * @see org.unicase.model.release.ReleasePackage#getAbstractRelease_IncludedWorkItems()
	 * @see org.unicase.model.task.WorkItem#getIncludingReleases
	 * @model opposite="includingReleases" annotation="org.unicase.ui.meeditor priority='10' position='right'"
	 * @generated
	 */
	EList<WorkItem> getIncludedWorkItems();

} // AbstractRelease
