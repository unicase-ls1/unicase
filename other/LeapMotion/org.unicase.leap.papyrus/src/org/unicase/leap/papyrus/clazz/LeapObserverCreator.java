/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.papyrus.clazz;

import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.swt.graphics.Point;
import org.unicase.leap.action.ILeapActionHandler;
import org.unicase.leap.events.LeapActionEvent;

/**
 * Implementation of the {@link ILeapActionHandler} that will create the observer pattern at the current cursor
 * location, once a {@link LeapActionEvent} is raised.
 * 
 * @author mharut
 */
public class LeapObserverCreator implements ILeapActionHandler {

	@Override
	public void handleLeapAction(LeapActionEvent leapEvent) {
		final LeapPapyrusClassDiagramHelper helper = new LeapPapyrusClassDiagramHelper(leapEvent);

		final Point location = leapEvent.getMousePosition();
		new ECPCommand(helper.getDiagram()) {

			@Override
			protected void doRun() {
				Node observerNode = helper.createClass("Observer", true);
				helper.addOperation("notify", true, observerNode);
				Node observerANode = helper.createClass("ConcreteObserverA", false);
				Node observerBNode = helper.createClass("ConcreteObserverB", false);
				Node subjectNode = helper.createClass("Subject", false);

				Node attachNode = helper.addOperation("attach", false, subjectNode);
				helper.addParameter("observer", observerNode, attachNode);
				Node detachNode = helper.addOperation("detach", false, subjectNode);
				helper.addParameter("observer", observerNode, detachNode);
				helper.addOperation("notifyAll", false, subjectNode);

				helper.createContainment(subjectNode, observerNode);
				helper.createGeneralization(observerNode, observerANode);
				helper.createGeneralization(observerNode, observerBNode);

				helper.setLocation(subjectNode, location.x, location.y, true);
				helper.setLocation(observerNode, location.x + 250, location.y, true);
				helper.setLocation(observerANode, location.x + 100, location.y + 150, true);
				helper.setLocation(observerBNode, location.x + 400, location.y + 150, true);

			}
		}.run(false);
	}

}
