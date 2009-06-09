/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.notification.recording;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

/**
 * Tests the notification recording for attribute features.
 * @author chodnick
 *
 */
public class ReferenceNotificationTest extends NotificationTest{

	/**
	 * Change an reference and check the generated notification.
	 */
	@Test
	public void changeReference1toN() {

		
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		
		getProject().addModelElement(useCase);
		getProject().addModelElement(actor);
		
		actor.setName("testActor");
		useCase.setName("testUseCase");
		
		// notifications from this operations are tested
		useCase.setInitiatingActor(actor);

		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<NotificationInfo> rec = recording.asMutableList();
		
		// exactly one SET notification is expected with attribute feature "initiatingActor" on our useCase and newValue actor
		assertEquals(1, rec.size());

		NotificationInfo n = rec.get(0);

		assertSame(useCase, n.getNotifier());
		assertTrue(n.isReferenceNotification());
		assertTrue(n.isSetEvent());
		assertSame(n.getNewValue(), actor);
		assertEquals(n.getReference().getName(), "initiatingActor");
		assertNull(n.getOldValue());
		
	}

	/**
	 * Change an reference and check the generated notification.
	 */
	@Ignore
	public void changeReference1to1() {
		fail("FIXME: MK where do we have 1:1 non-containment references?");
	}	
	
	/**
	 * Add an reference and check the generated notification.
	 */
	
	@Test
	public void addReferenceNto1(){
	
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		
		getProject().addModelElement(useCase);
		getProject().addModelElement(actor);
		
		actor.setName("testActor");
		useCase.setName("testUseCase");
		
		// notifications from this operations are tested
		actor.getInitiatedUseCases().add(useCase);

		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<NotificationInfo> rec = recording.asMutableList();
		
		// exactly one ADD notification is expected 
		assertEquals(1, rec.size());

		NotificationInfo n = rec.get(0);

		assertSame(actor, n.getNotifier());
		assertTrue(n.isReferenceNotification());
		assertTrue(n.isAddEvent());
		assertSame(n.getNewValue(), useCase);
		assertEquals(n.getReference().getName(), "initiatedUseCases");
				
		
	}
	
	/**
	 * Add a reference and check the generated notification.
	 */
	
	@Test
	public void addReferenceNtoN(){
	
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		
		getProject().addModelElement(useCase);
		getProject().addModelElement(actor);
		
		actor.setName("testActor");
		useCase.setName("testUseCase");
		
		// notifications from this operations are tested
		useCase.getParticipatingActors().add(actor);

		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<NotificationInfo> rec = recording.asMutableList();
		
		// exactly one ADD notification is expected 
		assertEquals(1, rec.size());

		NotificationInfo n = rec.get(0);

		assertSame(useCase, n.getNotifier());
		assertTrue(n.isReferenceNotification());
		assertTrue(n.isAddEvent());
		assertSame(n.getNewValue(), actor);
		assertEquals(n.getReference().getName(), "participatingActors");
				
	}	
	
	/**
	 * Remove a reference and check the generated notification.
	 */
	
	@Test
	public void removeReferenceNto1(){
	
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		
		
		getProject().addModelElement(useCase);
		getProject().addModelElement(actor);
		
		actor.setName("testActor");
		useCase.setName("testUseCase");
		
		// notifications from this operations are tested
		actor.getInitiatedUseCases().add(useCase);
		actor.getInitiatedUseCases().remove(useCase);

		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<NotificationInfo> rec = recording.asMutableList();
		
		// exactly one REMOVE notification is expected from the actor 
		assertEquals(1, rec.size());

		NotificationInfo n = rec.get(0);

		assertSame(actor, n.getNotifier());
		assertTrue(n.isReferenceNotification());
		assertTrue(n.isRemoveEvent());
		assertSame(n.getOldValue(), useCase);
		assertEquals(n.getReference().getName(), "initiatedUseCases");
				
		
	}
	
	/**
	 * Remove a reference and check the generated notification.
	 */
	
	@Test
	public void removeReferenceNtoN(){
	
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		
		getProject().addModelElement(useCase);
		getProject().addModelElement(actor);
		
		actor.setName("testActor");
		useCase.setName("testUseCase");
		
		// notifications from this operations are tested
		useCase.getParticipatingActors().add(actor);
		useCase.getParticipatingActors().remove(actor);

		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<NotificationInfo> rec = recording.asMutableList();
		
		// exactly one REMOVE notification is expected from useCase
		assertEquals(1, rec.size());

		NotificationInfo n = rec.get(0);

		assertSame(useCase, n.getNotifier());
		assertTrue(n.isReferenceNotification());
		assertTrue(n.isRemoveEvent());
		assertSame(n.getOldValue(), actor);
		assertEquals(n.getReference().getName(), "participatingActors");
				
	}		
	

}
