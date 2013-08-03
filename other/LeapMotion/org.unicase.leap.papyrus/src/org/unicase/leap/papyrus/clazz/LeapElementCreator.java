/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.papyrus.clazz;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.swt.graphics.Point;
import org.unicase.leap.action.ILeapActionHandler;
import org.unicase.leap.action.LeapActionCancelledException;
import org.unicase.leap.events.LeapActionEvent;
import org.unicase.leap.events.LeapSpeechEvent;

import edu.cmu.sphinx.result.Result;

/**
 * Implementation of the {@link ILeapActionHandler} that will create a UML model element, based on the received speech
 * input.
 * 
 * @author mharut
 */
public class LeapElementCreator implements ILeapActionHandler {

	/**
	 * Helper object used for papyrus class diagram manipulations.
	 */
	private LeapPapyrusClassDiagramHelper helper;
	/**
	 * The action event that this handler is handling.
	 */
	private LeapActionEvent leapEvent;
	/**
	 * Progress monitor used to display progress of this handler's process.
	 */
	private IProgressMonitor monitor;

	@Override
	public void handleLeapAction(LeapActionEvent leapEvent, IProgressMonitor monitor) {
		this.helper = new LeapPapyrusClassDiagramHelper(leapEvent, monitor);
		this.leapEvent = leapEvent;
		this.monitor = monitor;
		List<LeapSpeechEvent> speechEvents = leapEvent.getSpeechEvents();
		for (LeapSpeechEvent speechEvent : speechEvents) {
			Result result = speechEvent.getResult();
			String phrase = result.getBestFinalResultNoFiller();
			if (phrase.regionMatches(true, 0, "create ", 0, 7)) {
				String elementName = phrase.substring(7, phrase.length());
				new CreateElementCommand(elementName).run(false);
			}
		}
		monitor.done();
	}

	@Override
	public boolean showProgress() {
		return true;
	}

	/**
	 * {@link ECPCommand} extension that will execute actions to create an element in a papyrus class diagram.
	 * 
	 * @author mharut
	 */
	private final class CreateElementCommand extends ECPCommand {

		/**
		 * The name of the element to create.
		 */
		private final String elementName;

		/**
		 * Constructs a new command for a name of the element to create.
		 * 
		 * @param elementName the name of the element to create
		 */
		public CreateElementCommand(String elementName) {
			super(helper.getDiagram());
			this.elementName = elementName;
		}

		@Override
		protected void doRun() {
			try {
				monitor.beginTask("Create " + elementName, 1);
				helper.setWorkWeight(1);
				if ("class".equalsIgnoreCase(elementName)) {
					Node node = helper.createClass("MyClass", false);
					Point location = leapEvent.getMousePosition();
					helper.setLocation(node, location.x, location.y, true);
				} else if ("package".equalsIgnoreCase(elementName)) {
					Node node = helper.createPackage("MyPackage");
					Point location = leapEvent.getMousePosition();
					helper.setLocation(node, location.x, location.y, true);
				}
			} catch (LeapActionCancelledException e) {
				// do nothing
			}
		}
	}
}
