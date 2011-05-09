/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.test;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.TraceEvent;
import org.unicase.linkrecommendation.recommendationStrategies.updateableStrategies.ARMStrategy;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementFactory;

/**
 * Tests the ARM strategy.
 * 
 * @author koegel
 * @deprecated
 */
@Deprecated
public class ArmStrategyTest {

	private ARMStrategy armStrategy;
	private ModelElementId elementId1;
	private ModelElementId elementId2;
	private ModelElementId elementId3;
	private ModelElementId elementId4;
	private ModelElementId elementId5;
	private ModelElementId elementId6;
	private ModelElementId elementId7;
	private ModelElementId elementId8;
	private ChangePackage changePackage;

	/**
	 * Setup the test case.
	 */
	@Before
	public void setUp() {
		armStrategy = new ARMStrategy();
		changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		elementId1 = MetamodelFactory.eINSTANCE.createModelElementId();
		elementId1.setId("111");
		elementId2 = MetamodelFactory.eINSTANCE.createModelElementId();
		elementId2.setId("222");
		elementId3 = MetamodelFactory.eINSTANCE.createModelElementId();
		elementId3.setId("333");
		elementId4 = MetamodelFactory.eINSTANCE.createModelElementId();
		elementId4.setId("444");
		elementId5 = MetamodelFactory.eINSTANCE.createModelElementId();
		elementId5.setId("555");
		elementId6 = MetamodelFactory.eINSTANCE.createModelElementId();
		elementId6.setId("666");
		elementId7 = MetamodelFactory.eINSTANCE.createModelElementId();
		elementId7.setId("777");
		elementId8 = MetamodelFactory.eINSTANCE.createModelElementId();
		elementId8.setId("888");

		TraceEvent event1 = EventsFactory.eINSTANCE.createTraceEvent();
		event1.setSourceElement(ModelUtil.clone(elementId1));
		event1.setTargetElement(ModelUtil.clone(elementId2));

		TraceEvent event2 = EventsFactory.eINSTANCE.createTraceEvent();
		event2.setSourceElement(ModelUtil.clone(elementId3));
		event2.setTargetElement(ModelUtil.clone(elementId4));

		TraceEvent event3 = EventsFactory.eINSTANCE.createTraceEvent();
		event3.setSourceElement(ModelUtil.clone(elementId5));
		event3.setTargetElement(ModelUtil.clone(elementId6));

		TraceEvent event4 = EventsFactory.eINSTANCE.createTraceEvent();
		event4.setSourceElement(ModelUtil.clone(elementId7));
		event4.setTargetElement(ModelUtil.clone(elementId8));

		TraceEvent event5 = EventsFactory.eINSTANCE.createTraceEvent();
		event5.setSourceElement(ModelUtil.clone(elementId1));
		event5.setTargetElement(ModelUtil.clone(elementId3));

		TraceEvent event6 = EventsFactory.eINSTANCE.createTraceEvent();
		event6.setSourceElement(ModelUtil.clone(elementId3));
		event6.setTargetElement(ModelUtil.clone(elementId5));

		TraceEvent event7 = EventsFactory.eINSTANCE.createTraceEvent();
		event7.setSourceElement(ModelUtil.clone(elementId1));
		event7.setTargetElement(ModelUtil.clone(elementId3));

		TraceEvent event8 = EventsFactory.eINSTANCE.createTraceEvent();
		event8.setSourceElement(ModelUtil.clone(elementId1));
		event8.setTargetElement(ModelUtil.clone(elementId3));

		EList<Event> events = changePackage.getEvents();
		events.add(event1);
		events.add(event2);
		events.add(event3);
		events.add(event4);
		events.add(event5);
		events.add(event6);
		events.add(event7);
		events.add(event8);

	}

	/**
	 * Tear down the test case data.
	 */
	@After
	public void tearDown() {
		armStrategy = null;
	}

	/**
	 * Test getting a machting map for base 1 and targets 2,3,4 and 5 with an empty link map in the strategy.
	 */
	@Test
	public void testGetMatchingMapEmpty() {

		FunctionalRequirement modelElement1 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement1.setIdentifier(elementId1.getId());

		Collection<ModelElement> targetCandidates = new HashSet<ModelElement>();
		FunctionalRequirement modelElement2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement2.setIdentifier(elementId2.getId());
		FunctionalRequirement modelElement3 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement3.setIdentifier(elementId3.getId());
		FunctionalRequirement modelElement4 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement4.setIdentifier(elementId4.getId());
		FunctionalRequirement modelElement5 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement5.setIdentifier(elementId5.getId());
		targetCandidates.add(modelElement2);
		targetCandidates.add(modelElement3);
		targetCandidates.add(modelElement4);
		targetCandidates.add(modelElement5);

		Map<ModelElement, Double> matchingMap = armStrategy.getMatchingMap(modelElement1, targetCandidates);
		assertEquals(0, matchingMap.keySet().size());
	}

	/**
	 * Test getting a mathing map for base 1 and targets 2,3,4 and 5.
	 */
	@Test
	public void testGetMatchingMap() {
		Collection<ChangePackage> changes = new LinkedList<ChangePackage>();
		changes.add(changePackage);
		armStrategy.updateStrategyData(changes);

		FunctionalRequirement modelElement1 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement1.setIdentifier(elementId1.getId());

		Collection<ModelElement> targetCandidates = new HashSet<ModelElement>();
		FunctionalRequirement modelElement2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement2.setIdentifier(elementId2.getId());
		FunctionalRequirement modelElement3 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement3.setIdentifier(elementId3.getId());
		FunctionalRequirement modelElement4 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement4.setIdentifier(elementId4.getId());
		FunctionalRequirement modelElement5 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement5.setIdentifier(elementId5.getId());
		targetCandidates.add(modelElement2);
		targetCandidates.add(modelElement3);
		targetCandidates.add(modelElement4);
		targetCandidates.add(modelElement5);

		Map<ModelElement, Double> matchingMap = armStrategy.getMatchingMap(modelElement1, targetCandidates);
		assertEquals(2, matchingMap.keySet().size());

		assertEquals(new Double(0.25), matchingMap.get(modelElement2));
		assertEquals(new Double(0.75), matchingMap.get(modelElement3));
		assertEquals(null, matchingMap.get(modelElement4));
		assertEquals(null, matchingMap.get(modelElement5));

	}

	/**
	 * Test the update of a strategy by adding additional data.
	 */
	@Test
	public void testUpdateStrategyData() {

		Collection<ChangePackage> changes = new LinkedList<ChangePackage>();
		changes.add(changePackage);
		armStrategy.updateStrategyData(changes);

		FunctionalRequirement modelElement1 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement1.setIdentifier(elementId1.getId());

		Collection<ModelElement> targetCandidates = new HashSet<ModelElement>();
		FunctionalRequirement modelElement2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement2.setIdentifier(elementId2.getId());
		FunctionalRequirement modelElement3 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement3.setIdentifier(elementId3.getId());
		FunctionalRequirement modelElement4 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement4.setIdentifier(elementId4.getId());
		FunctionalRequirement modelElement5 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		modelElement5.setIdentifier(elementId5.getId());
		targetCandidates.add(modelElement2);
		targetCandidates.add(modelElement3);
		targetCandidates.add(modelElement4);
		targetCandidates.add(modelElement5);

		Map<ModelElement, Double> matchingMap = armStrategy.getMatchingMap(modelElement1, targetCandidates);
		assertEquals(4, matchingMap.keySet().size());

		assertEquals(new Double(0.25), matchingMap.get(modelElement2));
		assertEquals(new Double(0.75), matchingMap.get(modelElement3));
		assertEquals(new Double(0), matchingMap.get(modelElement4));
		assertEquals(new Double(0), matchingMap.get(modelElement5));

		ChangePackage newChangePackage = VersioningFactory.eINSTANCE.createChangePackage();
		TraceEvent event9 = EventsFactory.eINSTANCE.createTraceEvent();
		event9.setSourceElement(ModelUtil.clone(elementId1));
		event9.setTargetElement(ModelUtil.clone(elementId2));

		TraceEvent event10 = EventsFactory.eINSTANCE.createTraceEvent();
		event10.setSourceElement(ModelUtil.clone(elementId1));
		event10.setTargetElement(ModelUtil.clone(elementId4));

		TraceEvent event11 = EventsFactory.eINSTANCE.createTraceEvent();
		event11.setSourceElement(ModelUtil.clone(elementId1));
		event11.setTargetElement(ModelUtil.clone(elementId3));

		EList<Event> events = newChangePackage.getEvents();
		events.add(event9);
		events.add(event10);
		events.add(event11);

		Collection<ChangePackage> newChanges = new LinkedList<ChangePackage>();
		newChanges.add(newChangePackage);
		armStrategy.updateStrategyData(newChanges);

		matchingMap = armStrategy.getMatchingMap(modelElement1, targetCandidates);
		assertEquals(4, matchingMap.keySet().size());

		assertEquals(new Double(2.0 / 7), matchingMap.get(modelElement2));
		assertEquals(new Double(4.0 / 7), matchingMap.get(modelElement3));
		assertEquals(new Double(1.0 / 7), matchingMap.get(modelElement4));
		assertEquals(new Double(0), matchingMap.get(modelElement5));

	}

}
