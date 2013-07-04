/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.papyrus.clazz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.swt.graphics.Point;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.unicase.leap.action.ILeapActionHandler;
import org.unicase.leap.events.LeapActionEvent;

/**
 * Implementation of the {@link ILeapActionHandler} that will extract all focussed nodes from the leap motion sensor
 * data and generate a generalized superclass once a {@link LeapActionEvent} is raised.. Any common operations or
 * attributes will be added to this superclass as well.
 * 
 * @author mharut
 */
public class LeapClassGeneralizer implements ILeapActionHandler {

	@Override
	public void handleLeapAction(LeapActionEvent leapEvent) {
		final LeapPapyrusClassDiagramHelper helper = new LeapPapyrusClassDiagramHelper(leapEvent);
		new GeneralizeClassCommand(helper).run(false);
	}

	/**
	 * {@link ECPCommand} extension that will execute actions to create a generalized superclass from a list of class
	 * nodes.
	 * 
	 * @author mharut
	 */
	private final class GeneralizeClassCommand extends ECPCommand {

		/**
		 * Helper object used for papyrus class diagram manipulations.
		 */
		private LeapPapyrusClassDiagramHelper helper;
		/**
		 * List of GMF nodes that are being focussed by the user.
		 */
		private List<Node> focussedNodes;
		/**
		 * List of class nodes as a sublist of the focussed nodes.
		 */
		private List<Node> classNodes;
		/**
		 * List of all operation names appearing across all classes.
		 */
		private List<String> operationNames;
		/**
		 * List of all attribute names appearing across all classes.
		 */
		private List<String> attributeNames;

		/**
		 * Constructs a new command for a papyrus class diagram helper object.
		 * 
		 * @param helper the helper object used for papyrus diagram manipulations
		 */
		public GeneralizeClassCommand(LeapPapyrusClassDiagramHelper helper) {
			super(helper.getDiagram());
			this.helper = helper;
			focussedNodes = helper.getFocussedNodes();
			classNodes = new ArrayList<Node>(focussedNodes.size());
			operationNames = new LinkedList<String>();
			attributeNames = new LinkedList<String>();
		}

		@Override
		protected void doRun() {
			extractClassNodes();
			createGeneralizedClass();
		}

		/**
		 * Iterates over all focussed nodes to extract the class nodes. In the process, all operation and attribute
		 * names shared across all classes are determined.
		 */
		private void extractClassNodes() {
			boolean first = true;
			for (Node node : focussedNodes) {
				EObject element = node.getElement();
				if (element instanceof org.eclipse.uml2.uml.Class) {
					classNodes.add(node);
					org.eclipse.uml2.uml.Class specificClass = (org.eclipse.uml2.uml.Class) element;
					if (first) {
						// for the first class, all operations and attributes are added
						for (Operation operation : specificClass.getOperations()) {
							operationNames.add(operation.getName());
						}
						for (Property attribute : specificClass.getAttributes()) {
							attributeNames.add(attribute.getName());
						}
						first = false;
					} else {
						// for every subsequent class, all operation and attribute names that this class doesn't share
						// are removed
						for (Iterator<String> it = operationNames.iterator(); it.hasNext();) {
							String operationName = it.next();
							boolean contains = false;
							for (Operation operation : specificClass.getOperations()) {
								if (operationName.equals(operation.getName())) {
									contains = true;
									break;
								}
							}
							if (!contains) {
								it.remove();
							}
						}
						for (Iterator<String> it = attributeNames.iterator(); it.hasNext();) {
							String attributeName = it.next();
							boolean contains = false;
							for (Property attribute : specificClass.getAttributes()) {
								if (attributeName.equals(attribute.getName())) {
									contains = true;
									break;
								}
							}
							if (!contains) {
								it.remove();
							}
						}
					}
				}
			}
		}

		/**
		 * Creates a generalized class from all previously extracted class nodes by creating
		 * generalization-relationships for all involved classes and adding commonly shared operations and attributes.
		 * Finally, the location of the superclass is set to be in the middle (horizontally) and above (vertically) all
		 * subclasses.
		 */
		private void createGeneralizedClass() {
			int size = classNodes.size();
			if (2 <= size) {
				Node generalizedNode = helper.createClass("Generalized Class", false);
				for (String operationName : operationNames) {
					helper.addOperation(operationName, false, generalizedNode);
				}
				for (String attributeName : attributeNames) {
					helper.addAttribute(attributeName, generalizedNode);
				}
				List<Point> nodeLocations = new ArrayList<Point>(size);
				for (Node node : classNodes) {
					helper.createGeneralization(generalizedNode, node);
					Point location = helper.getLocation(node);
					nodeLocations.add(location);
				}
				int x = 0;
				int y = Integer.MAX_VALUE;
				for (Point nodeLocation : nodeLocations) {
					x += nodeLocation.x;
					y = Math.min(y, nodeLocation.y);
				}
				helper.setLocation(generalizedNode, x / size, y - 150, false);
			}
		}

	}
}
