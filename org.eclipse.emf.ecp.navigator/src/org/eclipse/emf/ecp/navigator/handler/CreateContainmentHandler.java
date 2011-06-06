/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.navigator.handler;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.ecp.common.util.ActionHelper;
import org.eclipse.emf.ecp.common.util.UiUtil;

/**
 * . This is the generic handler for commands to create containments of a model element
 * 
 * @author Hodaie
 */
public class CreateContainmentHandler extends AbstractHandler {

	/**
	 * The Id for EClass parameter to command. A model element of this EClass type is created in this handler.
	 */
	public static final String COMMAND_ECLASS_PARAM = "org.eclipse.emf.ecp.navigator.eClassParameter";

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// get the command parameter (EClass)
		Object o = event.getObjectParameterForExecution(COMMAND_ECLASS_PARAM);
		if (o instanceof EClass) {
			final EClass newMEType = (EClass) o;
			final EObject newMEInstance;

			final EObject selectedME = UiUtil.getSelectedModelelement();
			EPackage ePackage = newMEType.getEPackage();
			newMEInstance = ePackage.getEFactoryInstance().create(newMEType);
			final EReference eReference = getStructuralFeature(newMEInstance, selectedME);
			if ((selectedME != null) && (!eReference.isContainer())) {
				new ECPCommand(selectedME) {
					@SuppressWarnings("unchecked")
					@Override
					protected void doRun() {
						Object object = selectedME.eGet(eReference);
						if ((eReference.isMany())) {
							EList<EObject> eList = (EList<EObject>) object;
							eList.add(newMEInstance);
						} else {
							selectedME.eSet(eReference, newMEInstance);
						}
						ActionHelper.openModelElement(newMEInstance, this.getClass().getName());
					}
				}.run(false);
			}
		}
		return null;
	}

	private EReference getStructuralFeature(final EObject newMEInstance, EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass().getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			EClass eReferenceType = containmentitem.getEReferenceType();
			if (eReferenceType.equals(newMEInstance)) {
				reference = containmentitem;

				break;
			} else if (eReferenceType.isSuperTypeOf(newMEInstance.eClass())
				|| eReferenceType.equals(EcorePackage.eINSTANCE.getEObject())) {

				reference = containmentitem;
				break;
			}
		}
		return reference;
	}
}
