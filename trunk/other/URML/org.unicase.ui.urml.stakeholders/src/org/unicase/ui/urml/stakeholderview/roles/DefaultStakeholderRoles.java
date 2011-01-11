/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview.roles;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.model.urml.StakeholderRole;
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
	 * @return roleList the list the predefined roles
	 */
	public List<StakeholderRole> createDefaultRoles(final ECPProject project){
		List<StakeholderRole> roleList = new ArrayList<StakeholderRole>();
		final org.unicase.model.urml.StakeholderRole testEngineer = UrmlFactory.eINSTANCE.createStakeholderRole();
		testEngineer.setName("Test Engineer");
		final EList<String> set = testEngineer.getReviewSet();
		set.add("Danger");
		set.add("NonFunctionalRequirement");
		set.add("FunctionalRequirement");
		roleList.add(testEngineer);
		
		final org.unicase.model.urml.StakeholderRole safetyEngineer = UrmlFactory.eINSTANCE.createStakeholderRole();
		safetyEngineer.setName("Safety Engineer");
		final EList<String> safetySet = testEngineer.getReviewSet();
		safetySet.add("Danger");
		safetySet.add("FunctionalRequirement");
		
		
		roleList.add(safetyEngineer);
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				project.addModelElementToRoot(testEngineer);
				project.addModelElementToRoot(safetyEngineer);
				
			}
		}.run();
		return roleList;
	}
	
}
