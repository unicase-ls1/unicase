/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.papyrus.clazz.pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.swt.graphics.Point;
import org.unicase.leap.action.ILeapActionHandler;
import org.unicase.leap.action.LeapActionCancelledException;
import org.unicase.leap.events.LeapActionEvent;
import org.unicase.leap.papyrus.clazz.LeapPapyrusClassDiagramHelper;

/**
 * Implementation of the {@link ILeapActionHandler} that will create the strategy pattern at the current cursor
 * location, once a {@link LeapActionEvent} is raised.
 * 
 * @author mharut
 */
public class LeapStrategyCreator implements ILeapActionHandler {

	@Override
	public void handleLeapAction(LeapActionEvent leapEvent, final IProgressMonitor monitor) {
		final LeapPapyrusClassDiagramHelper helper = new LeapPapyrusClassDiagramHelper(leapEvent, monitor);

		final Point location = leapEvent.getMousePosition();
		new ECPCommand(helper.getDiagram()) {

			@Override
			protected void doRun() {
				try {
					monitor.beginTask("Create Strategy Pattern", 100);
					helper.setWorkWeight(15);
					Node contextNode = helper.createClass("Context", false);
					Node strategyNode = helper.createClass("Strategy", true);
					Node strategyANode = helper.createClass("ConcreteStrategyA", false);
					Node strategyBNode = helper.createClass("ConcreteStrategyB", false);

					helper.setWorkWeight(5);
					helper.addOperation("execute", false, strategyNode);

					helper.setWorkWeight(10);
					helper.createContainment(contextNode, strategyNode);
					helper.createGeneralization(strategyNode, strategyANode);
					helper.createGeneralization(strategyNode, strategyBNode);

					helper.setWorkWeight(1);
					helper.setLocation(contextNode, location.x, location.y, true);
					helper.setLocation(strategyNode, location.x + 250, location.y, true);
					helper.setLocation(strategyANode, location.x + 100, location.y + 150, true);
					helper.setLocation(strategyBNode, location.x + 400, location.y + 150, true);

					monitor.done();
				} catch (LeapActionCancelledException e) {
					// do nothing
				}
			}
		}.run(false);
	}

	@Override
	public boolean showProgress() {
		return true;
	}

}
