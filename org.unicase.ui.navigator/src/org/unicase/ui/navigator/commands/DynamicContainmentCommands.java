/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.navigator.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.util.ModelUtil;
import org.unicase.ui.common.util.ActionHelper;


/**.
 * 		   This class creates a group of commands to create different
 *         containments of a model element through context menu.
 *         The created commands have all the same ID
 *         and are handled with the same handler class {@link CreateMEHandler}.
 * @author Hodaie
 *
 */
public class DynamicContainmentCommands extends CompoundContributionItem {

	private static final String COMMAND_ID = "org.unicase.ui.navigator.createContaiment";
	private ModelElement selectedME;

	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	protected IContributionItem[] getContributionItems() {
		// 1. get selected ME
		selectedME = ActionHelper.getSelectedModelElement();
		if (selectedME == null) {
			return new IContributionItem[0];
		}
		// 2. get its containments
		List<EReference> containments = selectedME.eClass()
				.getEAllContainments();

		// 3. create commands for these containments
		IContributionItem[] commands = createCommands(containments);
		return commands;
	}

	/**.
	 * 
	 * @param containments a list of EReference of containments of selected ME
	 * @return an array of IContributionsItem (commands) to create 
	 * 		   different types of containments.
	 */
	private IContributionItem[] createCommands(List<EReference> containments) {

		List<IContributionItem> commands = new ArrayList<IContributionItem>();
		
		// every command takes its corresponding EClass type as parameter
		for (EReference containment : containments) {
			
			//do not create any commands for containments with multiplicity one
			if (!containment.isMany()) {
				continue;
			}
			
			//do not create any command for NonDomainElement types
			if (ModelPackage.eINSTANCE.getNonDomainElement().isSuperTypeOf(
					containment.getEReferenceType())) {
				continue;
			}
			
			//do not create commands for containments of type MEDiagram 
			//(because of different diagram types)
			if (containment.getEReferenceType().equals(
					DiagramPackage.eINSTANCE.getMEDiagram())) {
				continue;
			}
			
			//if containment type is abstract, create a list of 
			//commands for its subclasses
			if (containment.getEReferenceType().isAbstract()
					|| containment.getEReferenceType().isInterface()) {
				
				//note that a reference of commands array is passed,
				//corresponding commands are created and added to it, 
				//then continue
				addCommandsForSubTypes(containment.getEReferenceType(),
						commands);
				continue;
			}
			
			CommandContributionItemParameter p = new CommandContributionItemParameter(
					PlatformUI.getWorkbench(), null, COMMAND_ID,
					CommandContributionItem.STYLE_PUSH);

			Map<Object, Object> commandParams = new HashMap<Object, Object>();

			
			commandParams.put(CreateMEHandler.COMMAND_ECLASS_PARAM,
						containment.getEReferenceType());
			p.label = "New " + containment.getEReferenceType().getName();
		

			// create command
			p.parameters = commandParams;
			CommandContributionItem command = new CommandContributionItem(p);
			commands.add(command);
		}

		return commands.toArray(new IContributionItem[commands.size()]);

	}

	
	/**.
	 * If reference type is abstract create commands for its subclasses
	 * 
	 * @param refClass
	 * @param commands
	 */
	private void addCommandsForSubTypes(EClass refClass,
			List<IContributionItem> commands) {

		//do not create commands for subclasses of ModelElement
		if (refClass.equals(ModelPackage.eINSTANCE.getModelElement())) {
			return;
		}
		
		List<EClass> eClazz = ModelUtil.getSubclasses(refClass);
		for (EClass eClass : eClazz) {
			CommandContributionItemParameter p = new CommandContributionItemParameter(
					PlatformUI.getWorkbench(), null, COMMAND_ID,
					CommandContributionItem.STYLE_PUSH);

			Map<Object, Object> commandParams = new HashMap<Object, Object>();
			commandParams.put(CreateMEHandler.COMMAND_ECLASS_PARAM, eClass);
			p.label = "New " + eClass.getName();

			// create command
			p.parameters = commandParams;
			CommandContributionItem command = new CommandContributionItem(p);
			commands.add(command);
		}

	}

}
