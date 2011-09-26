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
import org.unicase.metamodel.Project;
import org.unicase.model.urml.UrmlFactory;
import org.unicase.model.urml.UrmlProjectSettings;
import org.unicase.model.urml.danger.DangerPackage;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.model.urml.service.ServicePackage;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Creates the default phases. Another phase must be add.
 * @author kterzieva
 *
 */
public class DefaultPhases {

	private static final String ANALYSE = "Analyse";
	private static final String REQUIREMENTS_ELICITATION = "RequirementElicitation";
	/**
	 * Test class.
	 * @param project the project whose default stakeholder roles are set.
	 */
	public UrmlProjectSettings createDefaultPhases(final Project project){
		final UrmlProjectSettings phaseSettings = UrmlFactory.eINSTANCE.createUrmlProjectSettings();
		final org.unicase.model.urml.Phase testStage = UrmlFactory.eINSTANCE.createPhase();
		testStage.setName(REQUIREMENTS_ELICITATION);
		final EMap<EClass, EList<EClass>> allowedAssociation = testStage.getAllowedAssociations();
		createStageSetEntry(GoalPackage.eINSTANCE.getGoal(),ServicePackage.eINSTANCE.getService(), allowedAssociation);
		createStageSetEntry(FeaturePackage.eINSTANCE.getProduct(),DangerPackage.eINSTANCE.getDanger(), allowedAssociation);
		
		final org.unicase.model.urml.Phase testStage2 = UrmlFactory.eINSTANCE.createPhase();
		testStage2.setName(ANALYSE);
		final EMap<EClass, EList<EClass>> allowedAssociationStage2 = testStage2.getAllowedAssociations();
		createStageSetEntry(GoalPackage.eINSTANCE.getGoal(), DangerPackage.eINSTANCE.getDanger(), allowedAssociationStage2);
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				project.addModelElement(testStage);
				project.addModelElement(testStage2);
				project.addModelElement(phaseSettings);
				phaseSettings.setActivePhase(testStage);
			}
		}.run();
		return phaseSettings;
	}

	private void createStageSetEntry(EClass className, EClass association, EMap<EClass, EList<EClass>> allowedAssociation){
		EList<EClass> associations = new BasicEList<EClass>();
	if(association != null){
		associations.add(association);
	}
		allowedAssociation.put(className, associations);
	}
	
}
