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
 * Implementation of the {@link ILeapActionHandler} that will create the adapter pattern at the current cursor location,
 * once a {@link LeapActionEvent} is raised.
 * 
 * @author mharut
 */
public class LeapAdapterCreator implements ILeapActionHandler {

	@Override
	public void handleLeapAction(LeapActionEvent leapEvent) {
		final LeapPapyrusClassDiagramHelper helper = new LeapPapyrusClassDiagramHelper(leapEvent);

		final Point location = leapEvent.getMousePosition();
		new ECPCommand(helper.getDiagram()) {

			@Override
			protected void doRun() {
				Node clientNode = helper.createClass("Client", false);

				Node adapterNode = helper.createClass("Adapter", false);
				helper.addOperation("doThis", false, adapterNode);
				Node adapteeNode = helper.createClass("Adaptee", false);
				helper.addOperation("doThat", false, adapteeNode);

				helper.createAssociation(clientNode, adapterNode, "adapter");
				helper.createAssociation(adapterNode, adapteeNode, "adaptee");

				helper.setLocation(clientNode, location.x, location.y, true);
				helper.setLocation(adapterNode, location.x + 250, location.y, true);
				helper.setLocation(adapteeNode, location.x + 250, location.y + 150, true);

			}
		}.run(false);
	}

}
