/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.notification.recording;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

import java.util.Arrays;
import java.util.List;

/**
 * Tests the notification recording for attribute features.
 * @author chodnick
 *
 */
public class MultiReferenceNotificationTest extends NotificationTest{

	/**
	 * Add multiple references.
	 */
	
	@SuppressWarnings("unchecked")
	@Test
	public void addReferences1toN(){
	
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		UseCase useCase1 = RequirementFactory.eINSTANCE.createUseCase();
		UseCase useCase2 = RequirementFactory.eINSTANCE.createUseCase();
		UseCase useCase3 = RequirementFactory.eINSTANCE.createUseCase();		
		
		getProject().addModelElement(useCase1);
		getProject().addModelElement(useCase2);
		getProject().addModelElement(useCase3);
		getProject().addModelElement(actor);
		
		actor.setName("testActor");
		useCase1.setName("testUseCase1");
		useCase2.setName("testUseCase2");
		useCase3.setName("testUseCase3");
		
		// notifications from this operations are tested
		UseCase[] useCases = {useCase1, useCase2, useCase3};
		actor.getInitiatedUseCases().addAll(Arrays.asList(useCases));

		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<NotificationInfo> rec = recording.asMutableList();
		
		// exactly one ADD_MANY notification is expected
		assertEquals(1, rec.size());

		NotificationInfo n = rec.get(0);

		assertSame(actor, n.getNotifier());
		assertTrue(n.isReferenceNotification());
		assertTrue(n.isAddManyEvent());
		assertEquals(((EList<UseCase>) n.getNewValue()).size(), 3);
		assertEquals(n.getReference().getName(), "initiatedUseCases");
		
	}
	/**
	 * Add references on a n:n relationship and check results.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void addReferencesNtoN(){
	
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		UseCase useCase1 = RequirementFactory.eINSTANCE.createUseCase();
		UseCase useCase2 = RequirementFactory.eINSTANCE.createUseCase();
		UseCase useCase3 = RequirementFactory.eINSTANCE.createUseCase();		
		
		getProject().addModelElement(useCase1);
		getProject().addModelElement(useCase2);
		getProject().addModelElement(useCase3);
		getProject().addModelElement(actor);
		
		actor.setName("testActor");
		useCase1.setName("testUseCase1");
		useCase2.setName("testUseCase2");
		useCase3.setName("testUseCase3");
		
		// notifications from this operations are tested
		UseCase[] useCases = {useCase1, useCase2, useCase3};
		actor.getParticipatedUseCases().addAll(Arrays.asList(useCases));

		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<NotificationInfo> rec = recording.asMutableList();
		
		// exactly one ADD_MANY notification is expected
		assertEquals(1, rec.size());

		NotificationInfo n = rec.get(0);

		assertSame(actor, n.getNotifier());
		assertTrue(n.isReferenceNotification());
		assertTrue(n.isAddManyEvent());
		assertEquals(((EList<UseCase>) n.getNewValue()).size(), 3);
		assertEquals(n.getReference().getName(), "participatedUseCases");
		
	}	
	
	/**
	 * Remove multiple references and check the generated notification.
	 */
	
	@Test
	public void removeReferences1ToN(){
		
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		UseCase useCase1 = RequirementFactory.eINSTANCE.createUseCase();
		UseCase useCase2 = RequirementFactory.eINSTANCE.createUseCase();
		UseCase useCase3 = RequirementFactory.eINSTANCE.createUseCase();		
		
		getProject().addModelElement(useCase1);
		getProject().addModelElement(useCase2);
		getProject().addModelElement(useCase3);
		getProject().addModelElement(actor);
		
		actor.setName("testActor");
		useCase1.setName("testUseCase1");
		useCase2.setName("testUseCase2");
		useCase3.setName("testUseCase3");
		
		// notifications from this operations are tested
		UseCase[] useCasesIn = {useCase1, useCase2, useCase3};
		UseCase[] useCasesOut = {useCase1, useCase3};
		actor.getInitiatedUseCases().addAll(Arrays.asList(useCasesIn));
		actor.getInitiatedUseCases().removeAll(Arrays.asList(useCasesOut));

		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<NotificationInfo> rec = recording.asMutableList();
		
		// exactly one REMOVE_MANY notification is expected
		assertEquals(1, rec.size());

		NotificationInfo n = rec.get(0);

		assertSame(actor, n.getNotifier());
		assertTrue(n.isReferenceNotification());
		assertTrue(n.isRemoveManyEvent());
		assertEquals(((int[]) n.getNewValue()).length, 2);
		assertEquals(n.getReference().getName(), "initiatedUseCases");
		
	}
	
	/**
	 * Remove references on a n:n relationship and check results.
	 */

	@Test
	public void removeReferencesNtoN(){
	
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		UseCase useCase1 = RequirementFactory.eINSTANCE.createUseCase();
		UseCase useCase2 = RequirementFactory.eINSTANCE.createUseCase();
		UseCase useCase3 = RequirementFactory.eINSTANCE.createUseCase();		
		
		getProject().addModelElement(useCase1);
		getProject().addModelElement(useCase2);
		getProject().addModelElement(useCase3);
		getProject().addModelElement(actor);
		
		actor.setName("testActor");
		useCase1.setName("testUseCase1");
		useCase2.setName("testUseCase2");
		useCase3.setName("testUseCase3");
		
		// notifications from this operations are tested
		UseCase[] useCasesIn = {useCase1, useCase2, useCase3};
		UseCase[] useCasesOut = {useCase1, useCase3};
		actor.getParticipatedUseCases().addAll(Arrays.asList(useCasesIn));
		actor.getParticipatedUseCases().removeAll(Arrays.asList(useCasesOut));

		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<NotificationInfo> rec = recording.asMutableList();
		
		// exactly one REMOVE_MANY notification is expected
		assertEquals(1, rec.size());

		NotificationInfo n = rec.get(0);

		assertSame(actor, n.getNotifier());
		assertTrue(n.isReferenceNotification());
		assertTrue(n.isRemoveManyEvent());
		assertEquals(((int[]) n.getNewValue()).length, 2);
		assertEquals(n.getReference().getName(), "participatedUseCases");
		
	}	
}
