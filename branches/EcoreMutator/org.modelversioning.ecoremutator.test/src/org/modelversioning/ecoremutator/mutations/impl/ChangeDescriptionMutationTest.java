/**
 * <copyright>
 *
 * Copyright (c) 2010 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */

package org.modelversioning.ecoremutator.mutations.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.Resource;
import org.modelversioning.ecoremutator.IModelProvider;
import org.modelversioning.ecoremutator.mutations.ModelProvider;

/**
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class ChangeDescriptionMutationTest extends MutationTestCase {

	/**
	 * Test method for
	 * {@link org.modelversioning.ecoremutator.mutations.impl.ChangeDescriptionMutation#mutate(org.modelversioning.ecoremutator.mutations.ModelProvider, org.modelversioning.ecoremutator.tracker.IMutationTracker)}
	 * .
	 */
	public void testMutate() {
		// initialize model provider
		IModelProvider modelProvider = new ModelProvider();
		modelProvider.setModelResource(sample1Resource);

		EClass employerClass = (EClass) sample1Resource.getContents().get(0)
				.eContents().get(0);
		int operationSize = employerClass.getEOperations().size();

		// load change description
		Resource changeDescResource = loadResource("models/sample1.ecore.changedescription");
		EObject eObject = changeDescResource.getContents().get(0);
		assertTrue(eObject instanceof ChangeDescription);
		ChangeDescription changeDescription = (ChangeDescription) eObject;

		// create mutation and mutate
		ChangeDescriptionMutation mutation = new ChangeDescriptionMutation(
				changeDescription);
		mutation.mutate(modelProvider, this);

		// test model
		// we removed an operation
		assertTrue(operationSize == employerClass.getEOperations().size() + 1);
		// we changed attribute street to street2
		EAttribute changedEAttribute = (EAttribute) sample1Resource
				.getEObject("_EhhhmEO6Ed-T8POTkiYiBg"); //$NON-NLS-1$
		assertEquals("street2", changedEAttribute.getName());
		// we added a newOperation
		EClass addressClass = (EClass) sample1Resource
				.getEObject("_Ehhhl0O6Ed-T8POTkiYiBg"); //$NON-NLS-1$
		assertEquals("newOperation", addressClass.getEOperations().get(0)
				.getName());

	}

}
