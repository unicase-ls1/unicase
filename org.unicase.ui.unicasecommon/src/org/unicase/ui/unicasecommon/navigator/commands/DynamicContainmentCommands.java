/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;

/**
 * . This class creates a group of commands to create different containments of a model element through context menu.
 * The created commands have all the same ID and are handled with the same handler class {@link CreateMEHandler}.
 * 
 * @author Hodaie
 */
public class DynamicContainmentCommands extends CompoundContributionItem {

	private static AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
		new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	private static final String COMMAND_ID = "org.unicase.ui.navigator.createContaiment";
	private EObject selectedME;

	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected IContributionItem[] getContributionItems() {
		// 1. get selected ME
		selectedME = ActionHelper.getSelectedModelElement();
		if (selectedME == null || selectedME instanceof MEDiagram) {
			return new IContributionItem[0];
		} else if (selectedME instanceof ProjectSpace) {
			selectedME = ((ProjectSpace) selectedME).getProject();
		}

		// 2. get its containments
		List<EReference> containments = selectedME.eClass().getEAllContainments();

		// 3. create commands for these containments
		IContributionItem[] commands = createCommands(containments);
		return commands;
	}

	/**
	 * .
	 * 
	 * @param containments a list of EReference of containments of selected ME
	 * @return an array of IContributionsItem (commands) to create different types of containments.
	 */
	private IContributionItem[] createCommands(List<EReference> containments) {

		List<IContributionItem> commands = new ArrayList<IContributionItem>();

		// every command takes its corresponding EClass type as parameter
		for (EReference containment : containments) {

			// do not create any commands for containments with multiplicity one
			if (!containment.isMany()) {
				continue;
			}

			// do not create any command for NonDomainElement types
			if (MetamodelPackage.eINSTANCE.getNonDomainElement().isSuperTypeOf(containment.getEReferenceType())) {
				continue;
			}

			// do not create commands for containments of type MEDiagram
			// (because of different diagram types)
			if (containment.getEReferenceType().equals(DiagramPackage.eINSTANCE.getMEDiagram())) {
				continue;
			}

			// do not create commands for raw EObjects
			if (containment.getEReferenceType().equals(EcoreFactory.eINSTANCE.getEcorePackage().getEObject())) {
				continue;
			}

			// if containment type is abstract, create a list of
			// commands for its subclasses
			if (containment.getEReferenceType().isAbstract() || containment.getEReferenceType().isInterface()) {

				// note that a reference of commands array is passed,
				// corresponding commands are created and added to it,
				// then continue
				// TODO: fix
				addCommandsForSubTypes(containment.getEReferenceType(), commands);
				continue;
			}

			CommandContributionItemParameter commandParam = new CommandContributionItemParameter(PlatformUI
				.getWorkbench(), null, COMMAND_ID, CommandContributionItem.STYLE_PUSH);

			Map<Object, Object> commandParams = new HashMap<Object, Object>();

			commandParams.put(CreateMEHandler.COMMAND_ECLASS_PARAM, containment.getEReferenceType());
			commandParam.label = "New " + containment.getEReferenceType().getName();
			commandParam.icon = getImage(containment.getEReferenceType());

			// create command
			commandParam.parameters = commandParams;
			CommandContributionItem command = new CommandContributionItem(commandParam);
			commands.add(command);
		}

		return commands.toArray(new IContributionItem[commands.size()]);

	}

	private ImageDescriptor getImage(EClass eClass) {
		EObject instance = eClass.getEPackage().getEFactoryInstance().create(eClass);
		Image image = labelProvider.getImage(instance);
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromImage(image);
		return imageDescriptor;
	}

	/**
	 * If reference type is abstract create commands for its subclasses.
	 * 
	 * @param refClass
	 * @param commands
	 */
	private void addCommandsForSubTypes(EClass refClass, List<IContributionItem> commands) {

		// do not create commands for subclasses of ModelElement
		if (refClass.equals(EcoreFactory.eINSTANCE.createEObject())) {
			return;
		}

		Set<EClass> eClazz = ModelUtil.getSubclasses(refClass);
		for (EClass eClass : eClazz) {
			CommandContributionItemParameter commandParam = new CommandContributionItemParameter(PlatformUI
				.getWorkbench(), null, COMMAND_ID, CommandContributionItem.STYLE_PUSH);

			Map<Object, Object> commandParams = new HashMap<Object, Object>();
			commandParams.put(CreateMEHandler.COMMAND_ECLASS_PARAM, eClass);
			commandParam.label = "New " + eClass.getName();
			commandParam.icon = getImage(eClass);

			// create command
			commandParam.parameters = commandParams;
			CommandContributionItem command = new CommandContributionItem(commandParam);
			commands.add(command);
		}

	}

}
