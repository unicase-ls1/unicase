/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.projectgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.Project;
import org.unicase.model.activity.ActivityPackage;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.diagram.DiagramPackage;
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
	public List<EObject> getMatchingElements(EClass diagramType) {
		ArrayList<EObject> result = new ArrayList<EObject>();
		List<EClass> matchingEClazz = getMatchingEClazz(diagramType);
		for (EClass eClass : matchingEClazz) {
			result.addAll(project.getAllModelElementsbyClass(eClass, new BasicEList<EObject>(), true));
		}
		return result;
	}

	/**
	 * @param diagramType diagram type
	 * @return a random number of matching elements to be shown on this diagram.
	 */
	public int getRandomNumOfDiagramElements(EClass diagramType) {
		ArrayList<EObject> result = new ArrayList<EObject>();
		List<EClass> matchingEClazz = getMatchingEClazz(diagramType);
		for (EClass eClass : matchingEClazz) {
			result.addAll(project.getAllModelElementsbyClass(eClass, new BasicEList<EObject>(), true));
		}
		return result.size() == 0 ? 0 : new Random().nextInt(result.size());
	}

	private List<EClass> getMatchingEClazz(EClass diagramType) {
		List<EClass> result = new ArrayList<EClass>();
		if (DiagramPackage.eINSTANCE.getActivityDiagram().equals(diagramType)) {
			result.add(ActivityPackage.eINSTANCE.getActivityObject());
		} else if (DiagramPackage.eINSTANCE.getUseCaseDiagram().equals(diagramType)) {
			result.add(RequirementPackage.eINSTANCE.getUseCase());
			result.add(RequirementPackage.eINSTANCE.getActor());
		} else if (DiagramPackage.eINSTANCE.getComponentDiagram().equals(diagramType)) {
			// TODO: result.add(matching types for a component diagram);
		} else if (DiagramPackage.eINSTANCE.getStateDiagram().equals(diagramType)) {
			result.add(StatePackage.eINSTANCE.getStateNode());
		} else if (DiagramPackage.eINSTANCE.getClassDiagram().equals(diagramType)) {
			result.add(ClassesPackage.eINSTANCE.getPackageElement());
		} else if (DiagramPackage.eINSTANCE.getWorkItemDiagram().equals(diagramType)) {
			// TODO: result.add(matching types for a component diagram);
		}
		return result;
	}
}
