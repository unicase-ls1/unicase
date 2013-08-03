/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.papyrus.clazz;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.swt.graphics.Point;
import org.unicase.leap.action.ILeapActionHandler;
import org.unicase.leap.action.LeapActionCancelledException;
import org.unicase.leap.events.LeapActionEvent;

/**
 * Implementation of the {@link ILeapActionHandler} that will move papyrus diagram elements based on the nodes focussed
 * by the user. If only one node is focussed, that node will be moved to the current cursor location. If more than one
 * node is focussed and only one of these nodes is a package node, all focussed class nodes will be moved to the
 * focussed package. Otherwise, nothing will happen.
 * 
 * @author mharut
 */
public class LeapElementMover implements ILeapActionHandler {

	/**
	 * Helper object used for papyrus class diagram manipulations.
	 */
	private LeapPapyrusClassDiagramHelper helper;
	/**
	 * The action event that this handler is handling.
	 */
	private LeapActionEvent leapEvent;
	/**
	 * List of nodes that are focussed by the user.
	 */
	private List<Node> focussedNodes;
	/**
	 * List of class nodes that are focussed by the user.
	 */
	private List<Node> classNodes;
	/**
	 * List of package nodes that are focussed by the user.
	 */
	private List<Node> packageNodes;

	@Override
	public void handleLeapAction(LeapActionEvent leapEvent, IProgressMonitor monitor) {
		this.helper = new LeapPapyrusClassDiagramHelper(leapEvent, monitor);
		this.leapEvent = leapEvent;
		focussedNodes = helper.getFocussedNodes();
		classNodes = new ArrayList<Node>(focussedNodes.size());
		packageNodes = new ArrayList<Node>(focussedNodes.size());
		// determine focussed class and package nodes
		for (Node node : focussedNodes) {
			EObject element = node.getElement();
			if (element instanceof org.eclipse.uml2.uml.Class) {
				classNodes.add(node);
			} else if (element instanceof org.eclipse.uml2.uml.Package) {
				packageNodes.add(node);
			}
		}
		new MoveElementCommand().run(false);
	}

	@Override
	public boolean showProgress() {
		return false;
	}

	/**
	 * {@link ECPCommand} extension that will execute actions to move an element in a papyrus class diagram.
	 * 
	 * @author mharut
	 */
	private final class MoveElementCommand extends ECPCommand {

		/**
		 * Constructs a new command for the diagram that fired the leap event.
		 */
		public MoveElementCommand() {
			super(helper.getDiagram());
		}

		@Override
		protected void doRun() {
			try {
				if (packageNodes.size() == 1) {
					Node packageNode = packageNodes.get(0);
					if (classNodes.isEmpty()) {
						Point location = leapEvent.getMousePosition();
						helper.setLocation(packageNode, location.x, location.y, true);
					} else {
						for (Node classNode : classNodes) {
							helper.addClassToPackage(classNode, packageNode);
						}
					}
				} else if (focussedNodes.size() == 1) {
					Node node = focussedNodes.get(0);
					Point location = leapEvent.getMousePosition();
					helper.setLocation(node, location.x, location.y, true);
				}
			} catch (LeapActionCancelledException e) {
				// do nothing
			}
		}
	}
}
