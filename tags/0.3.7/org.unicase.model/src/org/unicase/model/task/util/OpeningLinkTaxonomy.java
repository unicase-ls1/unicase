/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.Method;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.Scenario;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * Taxonomy to define opening links.
 * 
 * @author helming
 */
public class OpeningLinkTaxonomy {

	/**
	 * Get all openers of a modelelement. Includes Subelements. zardosht: I had to implement this method with a set<>
	 * because it returned many duplicate opener instances. The other methods that worked with method should have set<>
	 * implementation accordingly.
	 * 
	 * @param me the Modelelement
	 * @return a list of modelelements, the openers
	 */
	public Set<ModelElement> getOpeners(ModelElement me) {
		Set<ModelElement> openers = new HashSet<ModelElement>();
		EList<EObject> contents = me.eContents();
		for (EObject eObject : contents) {
			if (eObject instanceof ModelElement) {
				openers.add((ModelElement) eObject);
			}
		}
		for (ModelElement annotation : me.getAnnotations()) {
			openers.add(annotation);
		}

		if (me instanceof WorkPackage) {
			getWorkPackageOpeners((WorkPackage) me, openers);
		}
		if (me instanceof UseCase) {
			EList<FunctionalRequirement> functionalRequirements = ((UseCase) me).getFunctionalRequirements();
			openers.addAll(functionalRequirements);
		}
		if (me instanceof Scenario) {
			EList<Class> participatingClasses = ((Scenario) me).getParticipatingClasses();
			EList<Method> participatingMethods = ((Scenario) me).getParticipatingMethods();
			openers.addAll(participatingClasses);
			openers.addAll(participatingMethods);
		}
		if (me instanceof Milestone) {
			EList<ModelElement> containedModelElements = ((Milestone) me).getContainedModelElements();
			openers.addAll(containedModelElements);
		}
		openers.remove(me);
		return openers;
	}

	private void getWorkPackageOpeners(WorkPackage wp, Set<ModelElement> openers) {
		openers.addAll(wp.getContainedWorkItems());
	}

	/**
	 * Returns all elements which are opened by the source model element. That means, they are connected with the source
	 * by a opening link. The target element has not to be open until the source is open or blocked.
	 * 
	 * @param modelElement The source modelelement
	 * @return all opened modelelements
	 */
	public ArrayList<ModelElement> getOpened(ModelElement modelElement) {
		ArrayList<ModelElement> opened = new ArrayList<ModelElement>();
		EObject container = modelElement.eContainer();
		if (container instanceof ModelElement) {
			opened.add((ModelElement) container);
		}
		if (modelElement instanceof Annotation) {
			Annotation annotation = (Annotation) modelElement;
			opened.addAll(annotation.getAnnotatedModelElements());
		}
		if (modelElement instanceof FunctionalRequirement) {
			EList<UseCase> useCases = ((FunctionalRequirement) modelElement).getUseCases();
			opened.addAll(useCases);
		}
		if (modelElement instanceof UseCase) {
			EList<Scenario> scenarios = ((UseCase) modelElement).getScenarios();
			opened.addAll(scenarios);
		}
		if (modelElement instanceof Method) {
			EList<Scenario> demoParticipations = ((Method) modelElement).getDemoParticipations();
			opened.addAll(demoParticipations);
		}
		if (modelElement instanceof Class) {
			EList<Scenario> demoParticipations = ((Class) modelElement).getDemoParticipations();
			opened.addAll(demoParticipations);
		}
		opened.remove(modelElement);
		return opened;
	}

	/**
	 * Returns all leaf openers, that means all checkables which causes the source to be open.
	 * 
	 * @param modelElement the source
	 * @return a set of modelelement
	 */
	public Set<ModelElement> getLeafOpeners(ModelElement modelElement) {
		return getRecursiveLeafOpeners(modelElement, new HashSet<ModelElement>());
	}

	private Set<ModelElement> getRecursiveLeafOpeners(ModelElement modelElement, HashSet<ModelElement> visited) {
		Set<ModelElement> leafOpeners = new HashSet<ModelElement>();
		Set<ModelElement> openers = getOpeners(modelElement);
		visited.add(modelElement);
		for (ModelElement opener : openers) {
			if (visited.contains(opener)) {
				continue;
			}
			if (opener instanceof Checkable) {
				leafOpeners.add(opener);
			}
			leafOpeners.addAll(getRecursiveLeafOpeners(opener, visited));
		}
		leafOpeners.remove(modelElement);
		return leafOpeners;
	}

	private int getEstimate(Set<ModelElement> leafOpeners) {
		int estimate = 0;
		Iterator<ModelElement> iterator = leafOpeners.iterator();
		while (iterator.hasNext()) {
			ModelElement next = iterator.next();
			if (next instanceof WorkItem) {
				estimate = estimate + ((WorkItem) next).getEstimate();
			}
		}
		return estimate;
	}

	/**
	 * Returns the aggregated estimate for a model element.
	 * 
	 * @param input The model element
	 * @return the estimate
	 */
	public int getEstimate(ModelElement input) {
		Set<ModelElement> leafOpeners = getLeafOpeners(input);
		return getEstimate(leafOpeners);
	}

	/**
	 * Gets all checkable of an modelelement which are not assignes.
	 * 
	 * @param me the modelelement
	 * @return the opener
	 */
	public Set<Checkable> getUnassignedWorkItems(ModelElement me) {

		Set<Checkable> checkable = new HashSet<Checkable>();

		// then check its openers (hierarchical)
		Set<ModelElement> openers = getLeafOpeners(me);
		for (ModelElement opener : openers) {
			if (opener instanceof Checkable && opener instanceof WorkItem) {
				OrgUnit assignee2 = ((WorkItem) opener).getAssignee();
				if (assignee2 == null) {
					checkable.add((Checkable) opener);
				}
			}
		}
		return checkable;
	}

	/**
	 * This goes through openers hierarchy of an modelelement and gathers all Assignables assigned to this Assignee.
	 * 
	 * @param me the model element
	 * @param assignee OrgUnit assignee
	 * @return The checkables
	 */
	public Set<Checkable> getWorkItems(ModelElement me, OrgUnit assignee) {

		Set<Checkable> checkable = new HashSet<Checkable>();

		// then check its openers (hierarchical)
		Set<ModelElement> openers = getLeafOpeners(me);
		for (ModelElement opener : openers) {
			if (opener instanceof Checkable && opener instanceof WorkItem) {
				OrgUnit assignee2 = ((WorkItem) opener).getAssignee();
				if (assignee2 != null && assignee.equals(assignee2)) {
					checkable.add((Checkable) opener);
				}
			}
		}
		return checkable;
	}

}
