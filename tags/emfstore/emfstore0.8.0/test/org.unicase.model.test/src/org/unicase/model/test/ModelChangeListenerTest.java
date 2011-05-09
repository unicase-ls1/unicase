/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.notify.Notification;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.util.ModelElementChangeListenerImpl;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;

/**
 * Test the change listeners of model element.
 * 
 * @author koegel
 */
public class ModelChangeListenerTest {

	private Actor actor;
	private LeafSection leafsection;
	private UseCase useCase;
	private int notifyCount;

	/**
	 * Setup the test case.
	 */
	@Before
	public void setup() {
		actor = RequirementFactory.eINSTANCE.createActor();
		leafsection = DocumentFactory.eINSTANCE.createLeafSection();
		useCase = RequirementFactory.eINSTANCE.createUseCase();
		notifyCount = 0;
	}

	/**
	 * Test the notification.
	 */
	@Test
	public void testNotification() {
		ModelElementChangeListenerImpl listener = new ModelElementChangeListenerImpl() {

			@Override
			public void onRuntimeExceptionInListener(RuntimeException exception) {
				// do nothing
			}

			@Override
			public void onChange(Notification notification) {
				notifyCount++;
			}
		};
		actor.addModelElementChangeListener(listener);
		actor.setName("newName");
		actor.getInitiatedUseCases().add(useCase);
		leafsection.getModelElements().add(actor);
		assertEquals(3, notifyCount);
		useCase.setInitiatingActor(null);
		actor.setLeafSection(null);
		assertEquals(5, notifyCount);
	}

	/**
	 * Test adding and removing listener.
	 */
	@Test
	public void testAddAndRemoveListener() {
		assertEquals(0, actor.eAdapters().size());
		ModelElementChangeListenerImpl listener = new ModelElementChangeListenerImpl() {

			@Override
			public void onRuntimeExceptionInListener(RuntimeException exception) {
				// do nothing
			}

			@Override
			public void onChange(Notification notification) {
				notifyCount++;
			}
		};
		actor.addModelElementChangeListener(listener);
		assertEquals(1, actor.eAdapters().size());
		actor.setName("newName");
		assertEquals(1, notifyCount);
		assertEquals(1, actor.eAdapters().size());
		actor.removeModelElementChangeListener(listener);
		assertEquals(0, actor.eAdapters().size());
	}

	/**
	 * Test adding and removing 2 listeners.
	 */
	@Test
	public void testAddAndRemoveListeners() {
		assertEquals(0, actor.eAdapters().size());
		ModelElementChangeListenerImpl listener = new ModelElementChangeListenerImpl() {

			@Override
			public void onRuntimeExceptionInListener(RuntimeException exception) {
				// do nothing
			}

			@Override
			public void onChange(Notification notification) {
				notifyCount++;
			}
		};
		ModelElementChangeListenerImpl listener2 = new ModelElementChangeListenerImpl() {

			@Override
			public void onRuntimeExceptionInListener(RuntimeException exception) {
				// do nothing
			}

			@Override
			public void onChange(Notification notification) {
				notifyCount++;
			}
		};
		actor.addModelElementChangeListener(listener);
		actor.addModelElementChangeListener(listener2);

		assertEquals(1, actor.eAdapters().size());
		actor.setName("newName");
		assertEquals(2, notifyCount);
		assertEquals(1, actor.eAdapters().size());
		actor.removeModelElementChangeListener(listener);
		assertEquals(1, actor.eAdapters().size());
		actor.removeModelElementChangeListener(listener2);
		assertEquals(0, actor.eAdapters().size());
	}

	/**
	 * Test NPE in notification.
	 */
	@Test
	public void testAddListenerWithNPE() {
		ModelElementChangeListenerImpl listener = new ModelElementChangeListenerImpl() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.unicase.metamodel.util.ModelElementChangeListenerImpl#onChange(org.eclipse.emf.common.notify.Notification)
			 */
			@Override
			public void onChange(Notification notification) {
				throw new NullPointerException();
			}

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.unicase.metamodel.util.ModelElementChangeListenerImpl#onRuntimeExceptionInListener(java.lang.RuntimeException)
			 */
			@Override
			public void onRuntimeExceptionInListener(RuntimeException exception) {
				notifyCount++;
			}

		};
		assertEquals(0, actor.eAdapters().size());
		actor.addModelElementChangeListener(listener);
		actor.setName("newName");
		assertEquals(1, notifyCount);
		assertEquals(1, actor.eAdapters().size());
	}

	/**
	 * Test NPE in exceptionHandling.
	 */
	@Test
	public void testAddListenerWithNPEinNPEHandling() {
		ModelElementChangeListenerImpl listener = new ModelElementChangeListenerImpl() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.unicase.metamodel.util.ModelElementChangeListenerImpl#onChange(org.eclipse.emf.common.notify.Notification)
			 */
			@Override
			public void onChange(Notification notification) {
				throw new NullPointerException();
			}

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.unicase.metamodel.util.ModelElementChangeListenerImpl#onRuntimeExceptionInListener(java.lang.RuntimeException)
			 */
			@Override
			public void onRuntimeExceptionInListener(RuntimeException exception) {
				notifyCount++;
				throw new NullPointerException();
			}

		};
		assertEquals(0, actor.eAdapters().size());
		actor.addModelElementChangeListener(listener);
		actor.setName("newName");
		assertEquals(1, notifyCount);
		assertEquals(0, actor.eAdapters().size());
	}
}
