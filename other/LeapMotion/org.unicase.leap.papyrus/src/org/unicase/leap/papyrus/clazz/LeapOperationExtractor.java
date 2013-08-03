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
import org.eclipse.uml2.uml.Operation;
import org.unicase.leap.action.ILeapActionHandler;
import org.unicase.leap.action.LeapActionCancelledException;
import org.unicase.leap.events.LeapActionEvent;
import org.unicase.leap.events.LeapSpeechEvent;

import edu.cmu.sphinx.result.Result;

/**
 * Implementation of the {@link ILeapActionHandler} that will extract all focussed class nodes from the leap motion
 * sensor data and based on the speech input either transfer an operation from one class to another or from one class to
 * its superclass, if any exists.
 * 
 * @author mharut
 */
public class LeapOperationExtractor implements ILeapActionHandler {

	/**
	 * Helper object used for papyrus class diagram manipulations.
	 */
	private LeapPapyrusClassDiagramHelper helper;
	/**
	 * Progress monitor used to display progress of this handler's process.
	 */
	private IProgressMonitor monitor;
	/**
	 * List of GMF nodes that are being focussed by the user.
	 */
	private List<Node> classNodes;

	@Override
	public void handleLeapAction(LeapActionEvent leapEvent, IProgressMonitor monitor) {
		this.helper = new LeapPapyrusClassDiagramHelper(leapEvent, monitor);
		this.monitor = monitor;
		// retrieve all focussed class nodes
		List<Node> focussedNodes = helper.getFocussedNodes();
		classNodes = new ArrayList<Node>(focussedNodes.size());
		for (Node node : focussedNodes) {
			EObject element = node.getElement();
			if (element instanceof org.eclipse.uml2.uml.Class) {
				classNodes.add(node);
			}
		}
		// check all speech events for commands to execute
		List<LeapSpeechEvent> speechEvents = leapEvent.getSpeechEvents();
		for (LeapSpeechEvent speechEvent : speechEvents) {
			Result result = speechEvent.getResult();
			String phrase = result.getBestFinalResultNoFiller();
			if (phrase.regionMatches(true, 0, "extract ", 0, 8)) {
				String operationName = phrase.substring(8, phrase.length());
				new ExtractOperationCommand(operationName).run(false);
			} else if (phrase.regionMatches(true, 0, "pull up ", 0, 8)) {
				String operationName = phrase.substring(8, phrase.length());
				new PullUpOperationCommand(operationName).run(false);
			}
		}
		monitor.done();
	}

	@Override
	public boolean showProgress() {
		return true;
	}

	/**
	 * Extracts an operation with a certain name from one node and transfers it to another.
	 * 
	 * @param source the node to extract the operation from
	 * @param target the node to transfer the operation to
	 * @param name the name of the operation
	 * @return whether or not the operation was extracted and transferred successfully
	 * @throws LeapActionCancelledException if the process has been cancelled by the user
	 */
	private boolean extractOperation(Node source, Node target, String name) throws LeapActionCancelledException {
		org.eclipse.uml2.uml.Class clazz = (org.eclipse.uml2.uml.Class) source.getElement();
		Operation operationToTransfer = null;
		for (Operation operation : clazz.getOperations()) {
			if (name.equals(operation.getName())) {
				operationToTransfer = operation;
				break;
			}
		}
		if (operationToTransfer != null) {
			helper.transferOperation(operationToTransfer, new Node[] { source }, target);
			return true;
		}
		return false;
	}

	/**
	 * {@link ECPCommand} extension that will execute actions to extract an operation and transfer it from one class to
	 * another.
	 * 
	 * @author mharut
	 */
	private final class ExtractOperationCommand extends ECPCommand {

		/**
		 * The name of the operation to extract.
		 */
		private final String operationName;

		/**
		 * Constructs a new command for the name of the operation to extract.
		 * 
		 * @param operationName the name of the operation to extract
		 */
		public ExtractOperationCommand(String operationName) {
			super(helper.getDiagram());
			this.operationName = operationName;
		}

		@Override
		protected void doRun() {
			try {
				monitor.beginTask("Extract Attribute", classNodes.size() * 5);
				helper.setWorkWeight(4);
				if (classNodes.size() == 2) {
					Node source = classNodes.get(0);
					Node target = classNodes.get(1);
					// try to guess source and target
					boolean extracted = extractOperation(source, target, operationName);
					monitor.worked(1);
					if (!extracted) {
						// if it didn't work, try it the other way round
						extractOperation(target, source, operationName); // if this is false, extraction failed
					}
				}
			} catch (LeapActionCancelledException e) {
				// do nothing
			}
		}
	}

	/**
	 * {@link ECPCommand} extension that will execute actions to pull up an operation from a class to its superclass, if
	 * any is present.
	 * 
	 * @author mharut
	 */
	private final class PullUpOperationCommand extends ECPCommand {

		/**
		 * The name of the operation to pull up.
		 */
		private final String operationName;

		/**
		 * Constructs a new command for the name of the operation to pull up.
		 * 
		 * @param operation Name the name of the operation to pull up
		 */
		public PullUpOperationCommand(String operationName) {
			super(helper.getDiagram());
			this.operationName = operationName;
		}

		@Override
		protected void doRun() {
			monitor.beginTask("Pull Up Operation", classNodes.size() * 5);
			helper.setWorkWeight(4);
			try {
				for (Node source : classNodes) {
					org.eclipse.uml2.uml.Class clazz = (org.eclipse.uml2.uml.Class) source.getElement();
					List<org.eclipse.uml2.uml.Class> superClasses = clazz.getSuperClasses();
					// operations can only be pull up if there is exactly one super class
					if (superClasses.size() == 1) {
						org.eclipse.uml2.uml.Class superClass = superClasses.get(0);
						boolean extracted = false;
						for (Object child : helper.getDiagram().getChildren()) {
							if (child instanceof Node) {
								Node node = (Node) child;
								if (node.getElement() == superClass) {
									monitor.worked(1);
									extracted = extractOperation(source, node, operationName);
									break;
								}
							}
						}
						if (!extracted) {
							// extraction failed -> update progress manually
							monitor.worked(4);
						}
					} else {
						// invalid source node -> update progress manually
						monitor.worked(5);
					}
				}
			} catch (LeapActionCancelledException e) {
				// do nothing
			}
		}
	}

}
