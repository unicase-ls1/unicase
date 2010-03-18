/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.cutpaste.stuff;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.eclipse.core.expressions.PropertyTester;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Method;
import org.unicase.model.classes.MethodArgument;
import org.unicase.model.component.Component;
import org.unicase.model.component.ComponentService;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.LeafSection;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingSection;
import org.unicase.model.rationale.Comment;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * This property tester checks if the paste handler is active.
 * 
 * @author weiglt
 */
public class CanCutPasteCombiTester extends PropertyTester {

	private Clipboard clipboard;
	private Transferable transferable;
	private ModelElement meSource, meTarget;

	/**
	 * {@inheritDoc}
	 */
	public boolean test(Object receiver, String property, Object[] args, final Object expectedValue) {

		if (property.equals("canPaste")) {

			clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			transferable = clipboard.getContents(null);

			if (((org.eclipse.jface.viewers.TreeSelection) receiver).getFirstElement() instanceof ModelElement
				&& transferable.isDataFlavorSupported(new DataFlavor(org.unicase.metamodel.ModelElement.class,
					"ModelElement"))
				&& transferable.isDataFlavorSupported(new DataFlavor(
					org.unicase.workspace.CompositeOperationHandle.class, "CompositeOperationHandle"))) {

				meTarget = (ModelElement) ((org.eclipse.jface.viewers.TreeSelection) receiver).getFirstElement();

				try {
					meSource = (ModelElement) transferable.getTransferData(new DataFlavor(
						org.unicase.metamodel.ModelElement.class, "ModelElement"));

					if ((meTarget instanceof LeafSection && meSource instanceof UnicaseModelElement)
						|| (meTarget instanceof UnicaseModelElement && meSource instanceof Comment)
						|| (meTarget instanceof FunctionalRequirement && meSource instanceof FunctionalRequirement)
						|| (meTarget instanceof WorkPackage && meSource instanceof WorkItem)
						|| (meTarget instanceof Meeting && meSource instanceof MeetingSection)
						|| (meTarget instanceof CompositeMeetingSection && meSource instanceof MeetingSection)
						|| (meTarget instanceof Component && meSource instanceof ComponentService)
						|| (meTarget instanceof org.unicase.model.classes.Package && (meSource instanceof org.unicase.model.classes.Class || meSource instanceof org.unicase.model.classes.Package))
						|| (meTarget instanceof org.unicase.model.classes.Class && (meSource instanceof Method) || (meSource instanceof Attribute))
						|| (meTarget instanceof Method && meSource instanceof MethodArgument)) {

						return true;

					}

				} catch (UnsupportedFlavorException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else if (property.equals("canCut")) {
			if ((((org.eclipse.jface.viewers.TreeSelection) receiver).getFirstElement() instanceof UnicaseModelElement)
				&& !(((org.eclipse.jface.viewers.TreeSelection) receiver).getFirstElement() instanceof CompositeSection)) {
				return true;
			}
		}
		return false;
	}
}
