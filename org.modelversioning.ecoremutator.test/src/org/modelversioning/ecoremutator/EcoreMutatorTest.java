/**
 * <copyright>
 *
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */

package org.modelversioning.ecoremutator;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.modelversioning.ecoremutator.mutations.ModelProvider;
import org.modelversioning.ecoremutator.mutations.impl.AddObjectMutation;

/**
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class EcoreMutatorTest extends TestCase {

	ResourceSet resourceSet = new ResourceSetImpl();
	Resource sample1Resource;
	private IModelProvider modelProviderSample1;

	/**
	 * @throws java.lang.Exception
	 */
	protected void setUp() throws Exception {
		// load sample 1 model
		sample1Resource = loadResource("models/sample1.ecore");
		Assert.assertTrue(sample1Resource.getContents().size() == 1);
		// initialize sample 1 model provider
		modelProviderSample1 = new ModelProvider();
		modelProviderSample1.setModelResource(sample1Resource);
	}

	/**
	 * Loads the resource with the specified <code>fileURI</code>.
	 * 
	 * @param fileURI
	 *            to load.
	 * @return loaded resource.
	 */
	private Resource loadResource(String fileURIString) {
		URI fileURI = URI.createURI(fileURIString, true);
		return resourceSet.getResource(fileURI, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		sample1Resource.unload();
	}

	/**
	 * Tests the proper usage of the editing domain.
	 */
	public void testEditingDomainUsage() {
		EcoreMutator mutator = new EcoreMutator();
		ReflectiveItemProviderAdapterFactory adapterFactory = new ReflectiveItemProviderAdapterFactory();
		BasicCommandStack commandStack = new BasicCommandStack();

		EditingDomain editingDomain = new AdapterFactoryEditingDomain(
				adapterFactory, commandStack, new HashMap<Resource, Boolean>());
		modelProviderSample1.setEditingDomain(editingDomain);
		mutator.addMutation(new AddObjectMutation());

		final List<EventObject> events = new ArrayList<EventObject>();
		editingDomain.getCommandStack().addCommandStackListener(
				new CommandStackListener() {
					@Override
					public void commandStackChanged(EventObject event) {
						events.add(event);
					}
				});
		mutator.mutate(modelProviderSample1, 50);
		assertTrue(events.size() > 0);
	}

}
