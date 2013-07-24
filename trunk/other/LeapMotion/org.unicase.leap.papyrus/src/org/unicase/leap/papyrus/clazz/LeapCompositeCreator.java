/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.papyrus.clazz;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.swt.graphics.Point;
import org.unicase.leap.action.ILeapActionHandler;
import org.unicase.leap.action.LeapActionCancelledException;
import org.unicase.leap.events.LeapActionEvent;

/**
 * Implementation of the {@link ILeapActionHandler} that will create the composite pattern at the current cursor
 * location, once a {@link LeapActionEvent} is raised.
 * 
 * @author mharut
 */
public class LeapCompositeCreator implements ILeapActionHandler {

	@Override
	public void handleLeapAction(LeapActionEvent leapEvent, final IProgressMonitor monitor) {
		final LeapPapyrusClassDiagramHelper helper = new LeapPapyrusClassDiagramHelper(leapEvent, monitor);

		final Point location = leapEvent.getMousePosition();
		new ECPCommand(helper.getDiagram()) {

			@Override
			protected void doRun() {
				try {
					monitor.beginTask("Create Compsite Pattern", 90);
					helper.setWorkWeight(15);
					Node componentNode = helper.createClass("Component", true);
					Node leafNode = helper.createClass("Leaf", false);
					Node compositeNode = helper.createClass("Composite", false);

					helper.setWorkWeight(5);
					helper.addOperation("doThis", true, componentNode);
					helper.addOperation("addElement", false, compositeNode);

					helper.setWorkWeight(10);
					helper.createGeneralization(componentNode, leafNode);
					helper.createGeneralization(componentNode, compositeNode);
					helper.createContainment(compositeNode, componentNode);

					helper.setWorkWeight(2);
					helper.setLocation(componentNode, location.x, location.y, true);
					helper.setLocation(leafNode, location.x - 150, location.y + 150, true);
					helper.setLocation(compositeNode, location.x + 150, location.y + 150, true);

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
