/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview.roles;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.Project;
import org.unicase.model.urml.ReviewSetEntry;
import org.unicase.model.urml.UrmlFactory;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Creates the default stakeholder roles. Another roles must be add.
 * @author kterzieva
 *
 */
public class DefaultStakeholderRoles {

	
	/**
	 * Test class.
	 * @param project the project whose default stakeholder roles are set.
	 */
	public void createDefaultRoles(final Project project){
		final org.unicase.model.urml.StakeholderRole testEngineer = UrmlFactory.eINSTANCE.createStakeholderRole();
		testEngineer.setName("Test Engineer");
		final EList<ReviewSetEntry> reviewSet = testEngineer.getReviewSet();
		createReviewSetEntry("Danger", null, reviewSet);
		createReviewSetEntry("NonFunctionalRequirement", null, reviewSet);
		createReviewSetEntry("FunctionalRequirement", null, reviewSet);
		final EList<String> filterSet = testEngineer.getFilterSet();
		filterSet.add("Goal");
		
		final org.unicase.model.urml.StakeholderRole safetyEngineer = UrmlFactory.eINSTANCE.createStakeholderRole();
		safetyEngineer.setName("Safety Engineer");
		final EList<ReviewSetEntry> safetySet = safetyEngineer.getReviewSet();
		createReviewSetEntry("Danger", null, reviewSet);
		createReviewSetEntry("FunctionalRequirement", null, safetySet);
		final EList<String> safetyFilterSet = testEngineer.getFilterSet();
		safetyFilterSet.add("Mitigation");
		
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
			
				project.addModelElement(testEngineer);
				project.addModelElement(safetyEngineer);

			}
		}.run();
	}


	private void createReviewSetEntry(String className, String referenceToShow, EList<ReviewSetEntry> reviewSet){
		ReviewSetEntry entry = UrmlFactory.eINSTANCE.createReviewSetEntry();
		entry.setElementClass(className);
		entry.setReferenceToShow(referenceToShow);
		reviewSet.add(entry);
	}
	
}
