/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.jdt.ITeamSynchronizer;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>History Version Mapping</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.jdt.configuration.HistoryVersionMapping#getHvmEntry <em>Hvm Entry</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getHistoryVersionMapping()
 * @model
 * @generated
 */
public interface HistoryVersionMapping extends VersionMapping {
	/**
	 * Returns the value of the '<em><b>Hvm Entry</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hvm Entry</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hvm Entry</em>' containment reference list.
	 * @see org.unicase.emfstore.jdt.configuration.ConfigurationPackage#getHistoryVersionMapping_HvmEntry()
	 * @model containment="true"
	 * @generated
	 */
	EList<HistoryVersionMappingEntry> getHvmEntry();

	/**
	 * Finds for a team revision the matching EMFStore revision.
	 * 
	 * @param teamRevision A team revision.
	 * @return The matched VersionMapping or null if the ream revision cannot be matched.
	 * @generated NOT
	 */
	HistoryVersionMappingEntry getVersionMapping4TeamRevision(String teamRevision);

	/**
	 * Finds for a team revision the best matching EMFStore revision. Best matching means the lowest top most revision
	 * in respect to the variable from the parameter teamRevision.
	 * 
	 * @param teamSynchronizer A team synchronizer to be able to compare team revisions.
	 * @param teamRevision A team revision.
	 * @return The matched VersionMapping or null if the ream revision cannot be matched.
	 * @generated NOT
	 */
	HistoryVersionMappingEntry getVersionMapping4TeamRevisionBestMatch(ITeamSynchronizer teamSynchronizer,
		String teamRevision);

	/**
	 * Returns the lowest VersionMapping based on the team revisions.
	 * 
	 * @param teamSynchronizer A team synchronizer to be able to compare team revisions.
	 * @return The lowest VersionMapping or null if no VersionMapping exists.
	 * @generated NOT
	 */
	HistoryVersionMappingEntry getLowestTeamVersionMapping(ITeamSynchronizer teamSynchronizer);

} // HistoryVersionMapping
