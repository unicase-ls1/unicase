/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.commands;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.WorkspaceManager;

/**
 * . This is the generic handler for commands to create containments of a model element
 * 
 * @author Hodaie
 */
public class CreateContainmentHandler extends AbstractHandler {

	/**
	 * The Id for EClass parameter to command. A model element of this EClass type is created in this handler.
	 */
	public static final String COMMAND_ECLASS_PARAM = "org.unicase.ui.navigator.eClassParameter";

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// get the command parameter (EClass)
		Object o = event.getObjectParameterForExecution(COMMAND_ECLASS_PARAM);
		if (o instanceof EClass) {
			final EClass newMEType = (EClass) o;
			final UnicaseModelElement newMEInstance;
			// create a new model element from this EClass
			newMEInstance = (UnicaseModelElement) newMEType.getEPackage().getEFactoryInstance().create(newMEType);
			newMEInstance.setName("new " + newMEType.getName());

			// add this newly created model element to corresponding containment
			// feature of
			// selected ME
			final UnicaseModelElement selectedME = ActionHelper.getSelectedModelElement();

			final String sourceID = this.getClass().getName();
			if (selectedME != null) {
				TransactionalEditingDomain domain = WorkspaceManager.getInstance().getCurrentWorkspace()
					.getEditingDomain();
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@SuppressWarnings("unchecked")
					@Override
					protected void doExecute() {
						// get EStructuralFeature of selected ME
						EReference ref = getStructuralFeature(selectedME, newMEType);
						// note that in DynamicContainmentCommands, context menu
						// items
						// are created only for references that are many
						if (ref != null && ref.isMany()) {
							Object object = selectedME.eGet(ref);
							EList<EObject> eList = (EList<EObject>) object;
							eList.add(newMEInstance);

							ActionHelper.openModelElement(newMEInstance, sourceID);
						}

					}
				});

			}
		}
		return null;
	}

	private EReference getStructuralFeature(UnicaseModelElement selectedME, EClass newMEType) {
		List<EReference> containments = selectedME.eClass().getEAllContainments();
		EReference ref = null;
		for (EReference containment : containments) {
			if (containment.getEReferenceType().equals(newMEType)) {
				ref = containment;
				break;
			} else if (containment.getEReferenceType().isSuperTypeOf(newMEType)) {
				ref = containment;
				break;
			}
		}

		return ref;

	}
}
