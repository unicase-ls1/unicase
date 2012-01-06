/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.urml.Phase;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author kterzieva
 */
public final class StakeholderUtil {

	private static HashMap<EClass, ArrayList<EClass>> staticAssociationMap;
	private static ArrayList<EClass> sortedElementNames;

	private StakeholderUtil() {
	}

	/**
	 * Gets the currently active project.
	 * 
	 * @return the current project
	 */
	public static Project getActiveProject() {
		return getActiveProjectSpace().getProject();
	}

	/**
	 * Retrieves all URML model elements in a project.
	 * @param project the project.
	 * @return all URML model elements in that project
	 */
	public static Collection<UrmlModelElement> getUrmlElementsfromProjects(Project project) {
		Collection<EObject> elementList = project.getAllModelElementsbyClass(
			UrmlPackage.eINSTANCE.getUrmlModelElement(), new BasicEList<EObject>());
		List<UrmlModelElement> list = new ArrayList<UrmlModelElement>();
		for (EObject urmlElment : elementList) {
			list.add((UrmlModelElement) urmlElment);
		}
		return list;
	}

	/**
	 * Gets the active project space within the current workspace.
	 * 
	 * @return space the project space
	 */
	public static ProjectSpace getActiveProjectSpace() {
		ProjectSpace space = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces().get(0);
		return space;
	}

	/**
	 * Workaround to avoid the bug that maps do not get resolved properly.
	 * To be removed once this EMF bug is fixed.
	 * @param project project to be resolved
	 */
	public static void resolveAll(final Project project) {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				EList<StakeholderRole> roles = project.getAllModelElementsbyClass(
					UrmlPackage.eINSTANCE.getStakeholderRole(), new BasicEList<StakeholderRole>());
				for (StakeholderRole r : roles) {
					resolveStakeholderRole(r);
				}
				EList<Phase> phases = project.getAllModelElementsbyClass(UrmlPackage.eINSTANCE.getPhase(),
					new BasicEList<Phase>());
				for (Phase p : phases) {
					resolvePhase(p);
				}
			}
		}.run();

	}

	/**
	 * Workaround to avoid the bug that maps do not get resolved properly.
	 * To be removed once this EMF bug is fixed.
	 * @param role the role to be resolved
	 */
	public static void resolveStakeholderRole(StakeholderRole role) {
		resolveEMap(role.getReviewSet(), role);
		resolveEMap(role.getFilterSet(), role);
	}

	/**
	 * Workaround to avoid the bug that maps do not get resolved properly.
	 * To be removed once this EMF bug is fixed.
	 * @param p the phase to be resolved
	 */
	public static void resolvePhase(Phase p) {
		resolveEMap(p.getAllowedAssociations(), p);
	}

	/**
	 * Workaround to avoid the bug that maps do not get resolved properly.
	 * To be removed once this EMF bug is fixed.
	 * @param m the map to be resolved 
	 * @param context the context
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void resolveEMap(EMap<?, ?> m, EObject context) {
		ListIterator it = m.listIterator();

		while (it.hasNext()) {
			Entry<?, ?> e = (Entry<?, ?>) it.next();
			EObject obj = EcoreUtil.resolve((EObject) e, context);
			EcoreUtil.resolveAll(obj);
			it.set(obj);
		}

	}

	private static HashMap<EClass, Integer> createElementNumberMapping() {
		HashMap<EClass, Integer> elementNumberMapping = new HashMap<EClass, Integer>();
		Set<EClass> subClasses = ModelUtil.getSubclasses(UrmlPackage.eINSTANCE.getUrmlModelElement());
		sortedElementNames = new ArrayList<EClass>();
		for (EClass eclass : subClasses) {
			if (!eclass.getName().equals("Phase")) {
				sortedElementNames.add(eclass);
			}
		}

		Collections.sort(sortedElementNames, new Comparator<EClass>() {

			@Override
			public int compare(EClass element, EClass elementTwo) {
				return element.getName().compareToIgnoreCase(elementTwo.getName());
			}

		});
		for (int i = 0; i < sortedElementNames.size(); i++) {
			elementNumberMapping.put(sortedElementNames.get(i), i);
		}
		return elementNumberMapping;
	}

	private static HashMap<EClass, ArrayList<EClass>> createAssociationMap(HashMap<EClass, Integer> elementNumberMapping) {
		staticAssociationMap = new HashMap<EClass, ArrayList<EClass>>();
		for (EClass eclass : sortedElementNames) {
			ArrayList<EClass> associationList = createAssociationListToElement(eclass, elementNumberMapping);
			staticAssociationMap.put(eclass, associationList);

		}
		return staticAssociationMap;
	}

	// creates association list to specific eclass
	private static ArrayList<EClass> createAssociationListToElement(EClass eclass,
		HashMap<EClass, Integer> elementNumberMapping) {
		ArrayList<EClass> result = new ArrayList<EClass>();

		if (elementNumberMapping.containsKey(eclass)) {
			EList<EReference> elementReferences = eclass.getEAllReferences();

			for (EReference eReference : elementReferences) {
				result.add(eReference.getEReferenceType());
			}
		}
		return result;
	}
	
	/**
	 * Gets the map of associations which are always allowed
	 * due to the URML meta model.
	 * @return association map
	 */
	public static HashMap<EClass, ArrayList<EClass>> getStaticAssociationMap() {
		if (staticAssociationMap == null) {
			HashMap<EClass, Integer> numMapping = createElementNumberMapping();
			createAssociationMap(numMapping);
		}
		return staticAssociationMap;
	}

}
