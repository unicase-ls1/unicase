/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
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
	public Set<UnicaseModelElement> getOpeners(UnicaseModelElement me) {
		Set<UnicaseModelElement> openers = new HashSet<UnicaseModelElement>();
		EList<EObject> contents = me.eContents();
		for (EObject eObject : contents) {
			if (eObject instanceof UnicaseModelElement) {
				openers.add((UnicaseModelElement) eObject);
			}
		}

		openers.addAll(me.getAnnotations());

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
			EList<UnicaseModelElement> containedModelElements = ((Milestone) me).getContainedModelElements();
			openers.addAll(containedModelElements);
		}
		openers.remove(me);
		return openers;
	}

	/**
	 * Returns all elements which are opened by the source model element. That means, they are connected with the source
	 * by a opening link. The target element has not to be open until the source is open or blocked.
	 * 
	 * @param modelElement The source modelelement
	 * @return all opened modelelements
	 */
	public ArrayList<UnicaseModelElement> getOpened(UnicaseModelElement modelElement) {
		ArrayList<UnicaseModelElement> opened = new ArrayList<UnicaseModelElement>();
		EObject container = modelElement.eContainer();
		if (container instanceof UnicaseModelElement) {
			opened.add((UnicaseModelElement) container);
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
	public Set<UnicaseModelElement> getLeafOpeners(UnicaseModelElement modelElement) {
		return getRecursiveLeafOpeners(modelElement, new HashSet<UnicaseModelElement>());
	}

	private Set<UnicaseModelElement> getRecursiveLeafOpeners(UnicaseModelElement modelElement,
		HashSet<UnicaseModelElement> visited) {
		Set<UnicaseModelElement> leafOpeners = new HashSet<UnicaseModelElement>();
		Set<UnicaseModelElement> openers = getOpeners(modelElement);
		visited.add(modelElement);
		for (UnicaseModelElement opener : openers) {
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

	/**
	 * Returns the aggregated estimate for a set of {@link WorkItem}s.
	 * 
	 * @param leafOpeners the list of work items
	 * @return the estimate
	 */
	public int getEstimate(Set<WorkItem> leafOpeners) {
		int estimate = 0;
		Iterator<WorkItem> iterator = leafOpeners.iterator();
		while (iterator.hasNext()) {
			WorkItem next = iterator.next();
			estimate = estimate + next.getEstimate();
		}
		return estimate;
	}

	/**
	 * Returns the aggregated estimate for a model element.
	 * 
	 * @param input The model element
	 * @return the estimate
	 */
	public int getEstimate(UnicaseModelElement input) {
		Set<UnicaseModelElement> leafOpeners = getLeafOpeners(input);
		Set<WorkItem> workItems = new HashSet<WorkItem>();
		Iterator<UnicaseModelElement> iterator = leafOpeners.iterator();
		while (iterator.hasNext()) {
			UnicaseModelElement me = iterator.next();
			if (me instanceof WorkItem) {
				workItems.add((WorkItem) me);

			}
		}
		return getEstimate(workItems);
	}

	/**
	 * Returns work items of this model element, which are contained in this work package.
	 * 
	 * @param workPackage WorkPackage that contains related work items
	 * @param modelElement ModelElement whose relative work items are returned
	 * @return relative work items for this model element
	 */
	public Set<WorkItem> getRelativeWorkItems(WorkPackage workPackage, UnicaseModelElement modelElement) {

		Set<UnicaseModelElement> leafOpeners = getLeafOpeners(modelElement);
		Set<WorkItem> relativeWorkItems = new HashSet<WorkItem>();
		for (UnicaseModelElement me : leafOpeners) {
			if (me instanceof WorkItem) {
				if (workPackage.getAllContainedWorkItems().contains(me)) {
					relativeWorkItems.add((WorkItem) me);
				}
			}
		}

		return relativeWorkItems;
	}

	/**
	 * Gets all checkable of an modelelement which are not assignes.
	 * 
	 * @param me the modelelement
	 * @return the opener
	 */
	public Set<Checkable> getUnassignedWorkItems(UnicaseModelElement me) {

		Set<Checkable> checkable = new HashSet<Checkable>();

		// then check its openers (hierarchical)
		Set<UnicaseModelElement> openers = getLeafOpeners(me);
		for (UnicaseModelElement opener : openers) {
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
	public Set<Checkable> getWorkItems(UnicaseModelElement me, OrgUnit assignee) {

		Set<Checkable> checkable = new HashSet<Checkable>();

		// then check its openers (hierarchical)
		Set<UnicaseModelElement> openers = getLeafOpeners(me);
		for (UnicaseModelElement opener : openers) {
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
