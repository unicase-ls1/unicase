/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.notification.recording;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

import java.util.List;

/**
 * Tests the notification recording for attribute features.
 * @author chodnick
 *
 */
public class AttributeNotificationTest extends NotificationTest{

	/**
	 * Change an attribute and check the generated notification.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void changeAttribute() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		getProject().addModelElement(useCase);

		useCase.setName("newName");
		assertEquals("newName", useCase.getName());
		
		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<NotificationInfo> rec = recording.asMutableList();
		
		// exactly one SET notification is expected with attribute feature "name" on our useCase and newValue newName
		assertEquals(1, rec.size());

		NotificationInfo n = rec.get(0);
		assertSame(useCase, n.getNotifier());
		assertTrue(n.isAttributeNotification());
		assertTrue(n.isSetEvent());
		assertEquals(n.getNewValue(), "newName");
		assertEquals(n.getAttribute().getName(), "name");
		assertNull(n.getOldValue());
		
	}
	

}
