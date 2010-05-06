/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.projectGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.activity.ActivityPackage;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.state.StatePackage;

/**
 * @author Hodaie
 */
public class MEDiagramElementsProvider {

	private Project project;

	/**
	 * Constructor.
	 * 
	 * @param project meInstancesByClass
	 */
	public MEDiagramElementsProvider(Project project) {
		this.project = project;
	}

	/**
	 * @return a list of model element instances matching this diagram type
	 * @param diagramType diagram type
	 */
	public List<ModelElement> getMatchingElements(DiagramType diagramType) {
		ArrayList<ModelElement> result = new ArrayList<ModelElement>();
		List<EClass> matchingEClazz = getMatchingEClazz(diagramType);
		for (EClass eClass : matchingEClazz) {
			result.addAll(project.getAllModelElementsbyClass(eClass, new BasicEList<ModelElement>(), true));
		}
		return result;
	}

	/**
	 * @param diagramType diagram type
	 * @return a random number of matching elements to be shown on this diagram.
	 */
	public int getRandomNumOfDiagramElements(DiagramType diagramType) {
		ArrayList<EObject> result = new ArrayList<EObject>();
		List<EClass> matchingEClazz = getMatchingEClazz(diagramType);
		for (EClass eClass : matchingEClazz) {
			result.addAll(project.getAllModelElementsbyClass(eClass, new BasicEList<ModelElement>(), true));
		}
		return result.size() == 0 ? 0 : new Random().nextInt(result.size());
	}

	private List<EClass> getMatchingEClazz(DiagramType diagramType) {
		List<EClass> result = new ArrayList<EClass>();
		switch (diagramType.getValue()) {
		case DiagramType.ACTIVITY_DIAGRAM_VALUE:
			result.add(ActivityPackage.eINSTANCE.getActivityObject());
			break;

		case DiagramType.USECASE_DIAGRAM_VALUE:
			result.add(RequirementPackage.eINSTANCE.getUseCase());
			result.add(RequirementPackage.eINSTANCE.getActor());
			break;

		case DiagramType.COMPONENT_DIAGRAM_VALUE:
			break;

		case DiagramType.STATE_DIAGRAM_VALUE:
			result.add(StatePackage.eINSTANCE.getStateNode());
			break;

		case DiagramType.CLASS_DIAGRAM_VALUE:
			result.add(ClassesPackage.eINSTANCE.getPackageElement());
			break;

		case DiagramType.WORKITEM_DIAGRAM_VALUE:
			break;

		default:
			break;

		}

		return result;
	}

}
