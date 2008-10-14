package org.unicase.ui.navigator.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.util.ModelUtil;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.common.util.UnicaseUiUtil;

public class DynamicContainmentCommands extends CompoundContributionItem {

	private static final String COMMAND_ID = "org.unicase.ui.navigator.createContaiment";
	private ModelElement selectedME;

	@Override
	protected IContributionItem[] getContributionItems() {
		// 1. get selected ME
		selectedME = (ModelElement) ActionHelper.getSelectedModelElement();
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

	private IContributionItem[] createCommands(List<EReference> containments) {

		List<IContributionItem> commands = new ArrayList<IContributionItem>();
		// handleAbstractClasses(containments);
		// every command takes its corresponding EClass type as parameter
		for (EReference containment : containments) {
			if (!containment.isMany()) {
				continue;
			}
			if (ModelPackage.eINSTANCE.getNonDomainElement().isSuperTypeOf(
					containment.getEReferenceType())) {
				continue;
			}
			if (containment.getEReferenceType().isAbstract()
					|| containment.getEReferenceType().isInterface()) {
				addCommandsForSubTypes(containment.getEReferenceType(),
						commands);
				continue;
			}
			CommandContributionItemParameter p = new CommandContributionItemParameter(
					PlatformUI.getWorkbench(), null, COMMAND_ID,
					CommandContributionItem.STYLE_PUSH);

			Map<Object, Object> commandParams = new HashMap<Object, Object>();

			// set the EClass parameter
			// set the DiagramType Parameter if the object is a MEiagram
			// if(containment instanceof MEDiagram){
			// MEDiagram createMEDiagram = DiagramFactory.eINSTANCE
			// .createMEDiagram();
			// DiagramType type =(DiagramType) containments.get(i);
			// commandParams.put(CreateMEHandler.COMMAND_ECLASS_PARAM,
			// createMEDiagram.eClass());
			// commandParams.put(CreateMEHandler.COMMAND_DIAGRAMTYPE_PARAM,
			// type);
			// p.label = "New " + type.getLiteral();
			// }else
			if (!containment.getEReferenceType().equals(
					DiagramPackage.eINSTANCE.getMEDiagram())) {
				commandParams.put(CreateMEHandler.COMMAND_ECLASS_PARAM,
						containment.getEReferenceType());
				p.label = "New " + containment.getEReferenceType().getName();
			}

			// create command
			p.parameters = commandParams;
			CommandContributionItem command = new CommandContributionItem(p);
			commands.add(command);
		}

		return commands.toArray(new IContributionItem[commands.size()]);

	}

	// private void handleAbstractClasses(List<EReference> containments) {
	//		
	//	
	// for(EReference containment : containments){
	//			
	// EClass refClass = containment.getEReferenceType();
	//			
	//			
	// if(refClass.isAbstract() &&
	// !refClass.equals(ModelPackage.eINSTANCE.getModelElement())){
	// List<EClass> eClazz = ModelUtil.getSubclasses(refClass);
	// for(EClass eClass : eClazz){
	//					
	// }
	//				
	//			
	//	
	// }
	// }
	//		
	// }

	private void addCommandsForSubTypes(EClass refClass,
			List<IContributionItem> commands) {

		if (refClass.equals(ModelPackage.eINSTANCE.getModelElement())) {
			return;
		}
		List<EClass> eClazz = ModelUtil.getSubclasses(refClass);
		for (EClass eClass : eClazz) {
			if(eClass.equals(selectedME.eClass())){
				continue;
			}
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
