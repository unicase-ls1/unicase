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
 * Implementation of the {@link ILeapActionHandler} that will create the abstract factory pattern at the current cursor
 * location, once a {@link LeapActionEvent} is raised.
 * 
 * @author mharut
 */
public class LeapAbstractFactoryCreator implements ILeapActionHandler {

	@Override
	public void handleLeapAction(LeapActionEvent leapEvent, final IProgressMonitor monitor) {
		final LeapPapyrusClassDiagramHelper helper = new LeapPapyrusClassDiagramHelper(leapEvent, monitor);

		final Point location = leapEvent.getMousePosition();
		new ECPCommand(helper.getDiagram()) {

			@Override
			protected void doRun() {
				try {
					monitor.beginTask("Create Abstract Factory Pattern", 300);
					helper.setWorkWeight(15);
					Node clientNode = helper.createClass("Client", true);
					Node factoryNode = helper.createClass("AbstractFactory", true);
					Node factory1Node = helper.createClass("ConcreteFactory1", false);
					Node factory2Node = helper.createClass("ConcreteFactory2", false);

					Node productANode = helper.createClass("AbstractProductA", true);
					Node productA1Node = helper.createClass("ProductA1", true);
					Node productA2Node = helper.createClass("ProductA2", true);

					Node productBNode = helper.createClass("AbstractProductB", true);
					Node productB1Node = helper.createClass("ProductB1", true);
					Node productB2Node = helper.createClass("ProductB2", true);

					helper.setWorkWeight(5);
					helper.addOperation("createProductA", true, factoryNode);
					helper.addOperation("createProductB", true, factoryNode);

					helper.setWorkWeight(10);
					helper.createGeneralization(factoryNode, factory1Node);
					helper.createGeneralization(factoryNode, factory2Node);
					helper.createGeneralization(productANode, productA1Node);
					helper.createGeneralization(productANode, productA2Node);
					helper.createGeneralization(productBNode, productB1Node);
					helper.createGeneralization(productBNode, productB2Node);

					helper.createDependency(clientNode, factoryNode, "import");
					helper.createDependency(clientNode, productANode, "import");
					helper.createDependency(clientNode, productBNode, "import");
					helper.createDependency(factory1Node, productA1Node, "instantiate");
					helper.createDependency(factory1Node, productB1Node, "instantiate");
					helper.createDependency(factory2Node, productA2Node, "instantiate");
					helper.createDependency(factory2Node, productB2Node, "instantiate");

					helper.setWorkWeight(1);
					helper.setLocation(factoryNode, location.x, location.y, true);
					helper.setLocation(factory1Node, location.x - 150, location.y + 150, true);
					helper.setLocation(factory2Node, location.x + 150, location.y + 150, true);
					helper.setLocation(clientNode, location.x + 650, location.y, true);
					helper.setLocation(productANode, location.x + 450, location.y + 120, true);
					helper.setLocation(productA1Node, location.x + 300, location.y + 270, true);
					helper.setLocation(productA2Node, location.x + 600, location.y + 270, true);
					helper.setLocation(productBNode, location.x + 450, location.y + 300, true);
					helper.setLocation(productB1Node, location.x + 300, location.y + 450, true);
					helper.setLocation(productB2Node, location.x + 600, location.y + 450, true);

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
