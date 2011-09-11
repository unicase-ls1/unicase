/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.config;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.metamodel.Project;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.urml.UrmlFactory;
import org.unicase.model.urml.danger.DangerPackage;
import org.unicase.model.urml.goal.GoalPackage;
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
		final EMap<EClass, EList<EStructuralFeature>> reviewSet = testEngineer.getReviewSet();
		createSetEntry(DangerPackage.eINSTANCE.getDanger(), null, reviewSet);
		createSetEntry(RequirementPackage.eINSTANCE.getNonFunctionalRequirement(), null, reviewSet);
		createSetEntry(RequirementPackage.eINSTANCE.getFunctionalRequirement(), null, reviewSet);
		final EMap<EClass, EList<EStructuralFeature>> filterSet = testEngineer.getFilterSet();
		createSetEntry(GoalPackage.eINSTANCE.getGoal(), null, filterSet);
		
		
		final org.unicase.model.urml.StakeholderRole safetyEngineer = UrmlFactory.eINSTANCE.createStakeholderRole();
		safetyEngineer.setName("Safety Engineer");
		final EMap<EClass, EList<EStructuralFeature>> safetySet = safetyEngineer.getReviewSet();
		createSetEntry(DangerPackage.eINSTANCE.getDanger(), null, reviewSet);
		createSetEntry(RequirementPackage.eINSTANCE.getFunctionalRequirement(), null, safetySet);
		final EMap<EClass, EList<EStructuralFeature>> safetyFilterSet = testEngineer.getFilterSet();
		createSetEntry(DangerPackage.eINSTANCE.getMitigation(), null, safetyFilterSet);
		
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
			
				project.addModelElement(testEngineer);
				project.addModelElement(safetyEngineer);

			}
		}.run();
	}


	private void createSetEntry(EClass className, EStructuralFeature referenceToShow, EMap<EClass, EList<EStructuralFeature>> reviewSet){
		EList<EStructuralFeature> referenceList = new BasicEList<EStructuralFeature>();
		if(referenceToShow != null){
			referenceList.add(referenceToShow);
		}
		reviewSet.put(className, referenceList);
	}
	
}
