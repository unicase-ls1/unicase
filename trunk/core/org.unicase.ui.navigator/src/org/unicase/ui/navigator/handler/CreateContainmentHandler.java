/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.handler;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.ecpemfstorebridge.EMFStoreModelelementContext;
import org.unicase.metamodel.ModelElement;
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
			final ModelElement newMEInstance;

			final ModelElement selectedME = ActionHelper.getSelectedModelElement();
			EPackage ePackage = newMEType.getEPackage();
			newMEInstance = (ModelElement) ePackage.getEFactoryInstance().create(newMEType);
			final EReference eReference = getStructuralFeature(newMEInstance, selectedME);
			if ((selectedME != null) && (!eReference.isContainer())) {
				TransactionalEditingDomain domain = WorkspaceManager.getInstance().getCurrentWorkspace()
					.getEditingDomain();
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					@SuppressWarnings("unchecked")
					protected void doExecute() {
						if (newMEInstance.eContainer() == null) {
							selectedME.getProject().addModelElement(newMEInstance);
						}
						Object object = selectedME.eGet(eReference);
						if ((eReference.getUpperBound() == -1)) {
							EList<EObject> eList = (EList<EObject>) object;
							eList.add(newMEInstance);
						} else {
							selectedME.eSet(eReference, newMEInstance);
						}
						ActionHelper.openModelElement(newMEInstance, this.getClass().getName(),
							new EMFStoreModelelementContext(newMEInstance));
					}
				});
			}
		}
		return null;
	}

	private EReference getStructuralFeature(final ModelElement newMEInstance, EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass().getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			if (containmentitem.getEReferenceType().equals(newMEInstance)) {
				reference = containmentitem;

				break;
			} else if (containmentitem.getEReferenceType().isSuperTypeOf(newMEInstance.eClass())) {

				reference = containmentitem;
				break;
			}
		}
		return reference;
	}
}
