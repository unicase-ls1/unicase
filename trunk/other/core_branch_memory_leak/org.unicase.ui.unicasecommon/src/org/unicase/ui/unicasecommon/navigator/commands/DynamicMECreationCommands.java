/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.document.LeafSection;
import org.unicase.ui.common.util.ActionHelper;

/**
 * @author Hodaie This class creates a group of commands to create different model element types, which are shown in the
 *         context menu of a leaf section. The commands appear in the order of how frequent are the model element types
 *         in a leaf section. For example, if a leaf section contains 3 FRs and 2 AIs the command to create a FR appears
 *         before command to create an AI. The created commands have all the same ID and are handled with the same
 *         handler class {@link CreateMEHandler}.
 */
public class DynamicMECreationCommands extends CompoundContributionItem {

	private static AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
		new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	// jc: open
	// was tun bei static?

	private static final String COMMAND_ID = "org.unicase.ui.unicasecommon.navigator.createME";

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	protected IContributionItem[] getContributionItems() {
		// get the leaf section right clicked on in navigator.
		// For each ME type contained in this leaf section is a
		// creation command added to context menu.
		LeafSection leafSection = (LeafSection) ActionHelper.getSelectedModelElement();
		if (leafSection == null) {
			return new IContributionItem[0];
		}

		// 1. get a list of MEs in this LeafSection,
		// (sorted based on their frequency)
		Object[] contentTypes = getContentTypes(leafSection);

		// 2. create commands for these ME types
		IContributionItem[] commands = createCommands(contentTypes);
		return commands;

	}

	private IContributionItem[] createCommands(Object[] contentTypes) {

		IContributionItem[] commands = new IContributionItem[contentTypes.length];
		// every command takes its corresponding EClass type as parameter
		// create command for contents of this leaf section
		for (int i = 0; i < contentTypes.length; i++) {
			CommandContributionItemParameter commandParam = new CommandContributionItemParameter(PlatformUI
				.getWorkbench(), null, COMMAND_ID, CommandContributionItem.STYLE_PUSH);

			Map<Object, Object> map = new HashMap<Object, Object>();

			// set the EClass parameter
			if (contentTypes[i] instanceof EClass) {
				map.put(CreateMEHandler.COMMAND_ECLASS_PARAM, contentTypes[i]);
				commandParam.label = "New " + ((EClass) contentTypes[i]).getName();
				commandParam.icon = getImage((EClass) contentTypes[i]);
			}
			// set the DiagramType Parameter if the object is a MEiagram

			if (contentTypes[i] instanceof MEDiagram) {
				DiagramType type = (DiagramType) contentTypes[i];
				// map.put(CreateMEHandler.COMMAND_ECLASS_PARAM, createMEDiagram.eClass());
				map.put(CreateMEHandler.COMMAND_DIAGRAMTYPE_PARAM, type);
				commandParam.label = "New " + type.getLiteral();
			}
			// create command
			commandParam.parameters = map;
			CommandContributionItem command = new CommandContributionItem(commandParam);
			commands[i] = command;
		}

		return commands;
	}

	private ImageDescriptor getImage(EClass eClass) {
		UnicaseModelElement instance = (UnicaseModelElement) eClass.getEPackage().getEFactoryInstance().create(eClass);
		Image image = labelProvider.getImage(instance);
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromImage(image);
		return imageDescriptor;
	}

	/**
	 * This method return a list of ModelElement types (EClasses) contained in a LeafSection.
	 * 
	 * @param leafSection
	 * @return
	 */
	private Object[] getContentTypes(LeafSection leafSection) {
		// create a map of (EClass, EClassCount)
		Map<Object, Countable> meCounts = new HashMap<Object, Countable>();

		for (UnicaseModelElement me : leafSection.getModelElements()) {
			Object key = null;

			// Same for diagrams and other model elements.
			key = me.eClass();
			if (meCounts.containsKey(key)) {
				// if Count for this ME is already added to the map,
				// increment its count.
				Countable count = meCounts.get(key);
				count.setCount(count.getCount() + 1);
			} else {
				meCounts.put(key, new Countable(key));
			}
		}

		// get list of modelelement keys from map and sort it based on count field.
		List<Countable> meSortedByCount = new ArrayList<Countable>(meCounts.values());
		Collections.sort(meSortedByCount, new MeFrequencyComparator());

		// create an array of EClass by extracting the eClass field
		// from elements of sorted EClassCount list.
		Object[] contents = new Object[meSortedByCount.size()];
		for (int i = 0; i < meSortedByCount.size(); i++) {
			contents[i] = meSortedByCount.get(i).getObject();
		}

		return contents;

	}

	/**
	 * This Interface is used to count the occurrence of model elements in the navigator.
	 */
	public interface ICountable {

		/**
		 * This method should set the occurrence count.
		 * 
		 * @param count the new occurrence count value
		 */
		void setCount(int count);

		/**
		 * This method should return the occurrence count.
		 * 
		 * @return the occurrence count
		 */
		int getCount();

		/**
		 * This method should return the object, for which the occurrence is counted.
		 * 
		 * @return Object the object, which is counted
		 */
		Object getObject();

	}

	/**
	 * @author denglerm This class is used to count ModelElements in the LeafSection.
	 */

	public class Countable implements ICountable {

		private int count;
		private Object object;

		/**
		 * The constructor.
		 * 
		 * @param object the object, for which the occurrence is counted
		 */
		public Countable(Object object) {
			this.setCount(1);
			this.object = object;
		}

		/**
		 * @see ICountable.
		 * @param newCount the new occurrence count value
		 */
		public void setCount(int newCount) {
			this.count = newCount;
		}

		/**
		 * @see ICountable.
		 * @return the occurrence count
		 */
		public int getCount() {
			return count;
		}

		/**
		 * @see ICountable.
		 * @return the occurrence count
		 */
		public Object getObject() {
			return object;
		}
	}

	/**
	 * @author denglermThis is a Comparator for Countable type.
	 */
	private class MeFrequencyComparator implements Comparator<Countable> {

		public int compare(Countable arg0, Countable arg1) {

			return arg1.getCount() - arg0.getCount();
		}

	}
}
