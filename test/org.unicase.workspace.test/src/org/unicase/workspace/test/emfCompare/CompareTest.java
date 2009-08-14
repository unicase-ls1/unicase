/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test.emfCompare;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.util.ModelUtil;

/**
 * Test the comparison of projects with emf compare.
 * 
 * @author koegel
 */
public class CompareTest {

	private Project project1;
	private Project project2;
	private LeafSection functionalRequirementsSection;
	private LeafSection nonFunctionalRequirementsSection;

	/**
	 * Setup the two projects for comparison.
	 */
	@Before
	public void setup() {
		ResourceSet resourceSet1 = new ResourceSetImpl();
		Resource resource1 = resourceSet1.createResource(ModelUtil.VIRTUAL_URI);
		project1 = ModelFactory.eINSTANCE.createProject();
		resource1.getContents().add(project1);

		CompositeSection rad = DocumentFactory.eINSTANCE.createCompositeSection();
		rad.setName("Requirements Analysis Document");
		rad.setDescription("This is the Requirements Analysis Document");
		project1.addModelElement(rad);
		CompositeSection requirements = DocumentFactory.eINSTANCE.createCompositeSection();
		requirements.setName("Requirements");
		rad.getSubsections().add(requirements);
		functionalRequirementsSection = DocumentFactory.eINSTANCE.createLeafSection();
		functionalRequirementsSection.setName("Functional Requirements");
		requirements.getSubsections().add(functionalRequirementsSection);
		nonFunctionalRequirementsSection = DocumentFactory.eINSTANCE.createLeafSection();
		nonFunctionalRequirementsSection.setName("Non-Functional Requirements");
		requirements.getSubsections().add(nonFunctionalRequirementsSection);
		FunctionalRequirement fr1 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr1.setName("FR1");
		functionalRequirementsSection.getModelElements().add(fr1);
		FunctionalRequirement fr2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr2.setName("FR2");
		functionalRequirementsSection.getModelElements().add(fr2);
		FunctionalRequirement fr3 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr3.setName("FR3");
		functionalRequirementsSection.getModelElements().add(fr3);
		FunctionalRequirement fr4 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr4.setName("FR4");
		functionalRequirementsSection.getModelElements().add(fr4);
		NonFunctionalRequirement nfr = RequirementFactory.eINSTANCE.createNonFunctionalRequirement();
		nfr.setName("NFR");
		nonFunctionalRequirementsSection.getModelElements().add(nfr);

		ResourceSet resourceSet2 = new ResourceSetImpl();
		URI uri2 = URI.createURI("virtualUnicaseUri2");
		Resource resource2 = resourceSet2.createResource(uri2);
		project2 = ModelUtil.clone(project1);
		resource2.getContents().add(project2);
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		project1 = null;
		project2 = null;
	}

	/**
	 * Compares two copies of same project with the default matcher.
	 * 
	 * @throws InterruptedException if test fails
	 */
	@Test
	public void compareSameProjectWithDefaultMatcher() throws InterruptedException {
		MatchModel match = MatchService.doMatch(project1, project2, Collections.<String, Object> emptyMap());
		DiffModel diff = DiffService.doDiff(match, false);
		List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
		// one strange difference is in there, seems to be a group element for differences
		assertEquals(1, differences.size());
		assertEquals(0, differences.get(0).getSubDiffElements().size());
	}

	/**
	 * Compares two different projects with the default matcher.
	 * 
	 * @throws InterruptedException if test fails
	 */
	@Test
	public void compareTwoProjectsWithDefaultMatcher() throws InterruptedException {
		// change project 1
		functionalRequirementsSection.getModelElements().get(1).setName("oldFR1");
		functionalRequirementsSection.getModelElements().remove(2);
		NonFunctionalRequirement nfr2 = RequirementFactory.eINSTANCE.createNonFunctionalRequirement();
		nfr2.setName("NFR2");
		nonFunctionalRequirementsSection.getModelElements().add(nfr2);

		MatchModel match = MatchService.doMatch(project1, project2, Collections.<String, Object> emptyMap());
		DiffModel diff = DiffService.doDiff(match, false);
		List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
		assertEquals(1, differences.size());
		assertEquals(1, differences.get(0).getSubDiffElements().size());
	}
}
