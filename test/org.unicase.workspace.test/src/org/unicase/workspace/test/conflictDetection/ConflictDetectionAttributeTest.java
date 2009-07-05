/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.conflictDetection;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.conflictDetection.FineGrainedConflictDetectionStrategy;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.Project;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.workspace.ProjectSpace;

/**
 * ...
 * 
 * @author chodnick
 */
public class ConflictDetectionAttributeTest extends ConflictDetectionTest {

	@Test
	public void conflictAttribute() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		actor.setName("old name");

		getProject().addModelElement(section);
		section.getModelElements().add(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		actor1.setName("change 1");
		actor2.setName("change 2");

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(new FineGrainedConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);

		assertEquals(conflicts.size(), 1);

	}

}
