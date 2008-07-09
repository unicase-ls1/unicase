/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.navigator.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.unicase.model.ModelElement;
import org.unicase.model.document.LeafSection;

/**
 * 
 * @author Hodaie This class creates a group of commands to create different
 *         model element types, which are shown in the context menu of a leaf
 *         section. The commands appear in the order of how frequent are the
 *         model element types in a leaf section. For example, if a leaf section
 *         contains 3 FRs and 2 AIs the command to create a FR appears before
 *         command to create an AI. The created commands have all the same ID
 *         and are handled with the same handler class {@link CreateMEHandler}.
 * 
 */
public class DynamicMECreationCommands extends CompoundContributionItem {

	private static final String COMMAND_ID = "org.unicase.ui.navigator.createME";

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	protected IContributionItem[] getContributionItems() {
		// get the leaf section right clicked on in navigator.
		// For each ME type contained in this leaf section is a
		// creation command added to context menu.
		LeafSection leafSection = getSelectedLeafSection();
		if (leafSection == null) {
			return new IContributionItem[0];
		}

		// 1. get a list of MEs in this LeafSection,
		// (sorted based on their frequency)
		EClass[] contentTypes = getContentTypes(leafSection);

		// 2. create commands for these ME types
		IContributionItem[] commands = createCommands(contentTypes);
		return commands;

	}

	private IContributionItem[] createCommands(EClass[] contentTypes) {

		IContributionItem[] commands = new IContributionItem[contentTypes.length];
		// every command take its corresponding EClass type as parameter
		for (int i = 0; i < contentTypes.length; i++) {
			CommandContributionItemParameter p = new CommandContributionItemParameter(
					PlatformUI.getWorkbench(), null, COMMAND_ID,
					CommandContributionItem.STYLE_PUSH);
			// set the EClas parameter
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put(CreateMEHandler.COMMAND_ECLASS_PARAM, contentTypes[i]);
			p.parameters = map;
			p.label = "New " + contentTypes[i].getName();
			// create command
			CommandContributionItem command = new CommandContributionItem(p);
			commands[i] = command;
		}

		return commands;
	}

	/**
	 * This method return a list of ModelElement types (EClasses) contained in a
	 * LeafSection.
	 * 
	 * @param leafSection
	 * @return
	 */
	private EClass[] getContentTypes(LeafSection leafSection) {
		// create a map of (EClass, EClassCount)
		Map<EClass, EClassCount> meCounts = new HashMap<EClass, EClassCount>();
		for (ModelElement me : leafSection.getModelElements()) {
			if (meCounts.containsKey(me.eClass())) {
				// if EClass for this ME is already added to the map,
				// increment its count.
				EClassCount eclassCount = meCounts.get(me
						.eClass());
				eclassCount.setCount(eclassCount.getCount() + 1);
			} else {
				meCounts.put(me.eClass(), new EClassCount(me.eClass()));

			}
		}

		// get list of EClassCounts from map and sort it based on count field.
		List<EClassCount> eclazzSortedByCount = new ArrayList<EClassCount>(
				meCounts.values());
		Collections.sort(eclazzSortedByCount, new EClassFrequencyComparator());

		// create an array of EClass by extracting the eClass field
		// from elements of sorted EClassCount list.
		EClass[] contents = new EClass[eclazzSortedByCount.size()];
		for (int i = 0; i < eclazzSortedByCount.size(); i++) {
			contents[i] = eclazzSortedByCount.get(i).getEClass();
		}

		return contents;

	}

	/**
	 * Get the leaf section right clicked on in navigator.
	 * 
	 * @return LeafSection
	 */
	private LeafSection getSelectedLeafSection() {
		ISelectionService selectionService = 
			(ISelectionService)PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getPartService()
					.getActivePart().getSite().getService(ISelectionService.class);
	
		
		ISelection sel = selectionService.getSelection();
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object o = ssel.getFirstElement();
		if (!(o instanceof LeafSection)) {
			return null;
		}

		return (LeafSection) o;

	}

	/**
	 * 
	 * @author Hodaie This class is a helper to sort the list of contained
	 *         ModelElements in a LeafSection based on their frequency. This
	 *         class just keeps track of count of every EClass type encountered
	 *         in a LeafSectoin.
	 * 
	 */
	private class EClassCount {

		private EClass eClass;
		private int count;

		public EClassCount(EClass eClass) {
			this.eClass = eClass;
			setCount(1);

		}

		public EClass getEClass() {
			return eClass;
		}

		public void setCount(int newCount) {
			this.count = newCount;
		}

		public int getCount() {
			return count;
		}

	}

	/**
	 * 
	 * @author Hodaie This is a Comparator for EClassCount type.
	 * 
	 */
	private class EClassFrequencyComparator implements Comparator<EClassCount> {

		public int compare(EClassCount arg0, EClassCount arg1) {

			return arg1.getCount() - arg0.getCount();
		}

	}

}
