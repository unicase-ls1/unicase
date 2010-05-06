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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
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
import org.unicase.workspace.ProjectSpace;

/**
 * This property tester provides various test cases for the cut and paste operation.
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

		if (property.equals("canPaste") && receiver instanceof org.eclipse.jface.viewers.TreeSelection) {

			clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			transferable = clipboard.getContents(null);

			if (transferable.isDataFlavorSupported(new DataFlavor(org.unicase.metamodel.ModelElement.class,
				"ModelElement"))
				&& transferable.isDataFlavorSupported(new DataFlavor(
					org.unicase.workspace.CompositeOperationHandle.class, "CompositeOperationHandle"))) {

				try {
					meSource = (ModelElement) transferable.getTransferData(new DataFlavor(
						org.unicase.metamodel.ModelElement.class, "ModelElement"));
				} catch (UnsupportedFlavorException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (((org.eclipse.jface.viewers.TreeSelection) receiver).getFirstElement() instanceof ModelElement
					&& ((org.eclipse.jface.viewers.TreeSelection) receiver).size() <= 1) {

					meTarget = (ModelElement) ((org.eclipse.jface.viewers.TreeSelection) receiver).getFirstElement();

					return canPasteIntoMETest();

				} else if (((org.eclipse.jface.viewers.TreeSelection) receiver).getFirstElement() instanceof ProjectSpace
					&& ((org.eclipse.jface.viewers.TreeSelection) receiver).size() <= 1) {

					return canPasteIntoPSTest();
				}
			}

		} else if (property.equals("canCut") && receiver instanceof org.eclipse.jface.viewers.TreeSelection
			&& ((org.eclipse.jface.viewers.TreeSelection) receiver).size() <= 1) {
			if ((((org.eclipse.jface.viewers.TreeSelection) receiver).getFirstElement() instanceof UnicaseModelElement)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Tests, if the source element can be pasted into target.
	 */
	private boolean canPasteIntoMETest() {

		if (meSource.equals(meTarget) || EcoreUtil.isAncestor(meSource, meTarget)) {
			return false;
		}
		if (meTarget instanceof LeafSection && meSource instanceof UnicaseModelElement
			&& !(meSource instanceof CompositeSection)) {
			return true;
		}
		if (meTarget instanceof UnicaseModelElement && meSource instanceof Comment) {
			return true;
		}
		if (meTarget instanceof FunctionalRequirement && meSource instanceof FunctionalRequirement) {
			return true;
		}
		if (meTarget instanceof WorkPackage && meSource instanceof WorkItem) {
			return true;
		}
		if (meTarget instanceof Meeting && meSource instanceof MeetingSection) {
			return true;
		}
		return canPasteIntoMETest2();
	}

	/**
	 * Tests, if the source element can be pasted into target. (cont...)
	 */
	private boolean canPasteIntoMETest2() {
		if (meTarget instanceof CompositeMeetingSection && meSource instanceof MeetingSection) {
			return true;
		}
		if (meTarget instanceof Component && meSource instanceof ComponentService) {
			return true;
		}
		if (meTarget instanceof org.unicase.model.classes.Package
			&& (meSource instanceof org.unicase.model.classes.Class || meSource instanceof org.unicase.model.classes.Package)) {
			return true;
		}
		if (meTarget instanceof org.unicase.model.classes.Class
			&& (meSource instanceof Method || meSource instanceof Attribute)) {
			return true;
		}
		if (meTarget instanceof Method && meSource instanceof MethodArgument) {
			return true;
		}
		return canPasteIntoMETest3();
	}

	/**
	 * Tests, if the source element can be pasted into target. (cont...)
	 */
	private boolean canPasteIntoMETest3() {
		if (meTarget instanceof CompositeSection
			&& (meSource instanceof CompositeSection || meSource instanceof LeafSection)) {
			return true;
		}
		if (meTarget instanceof Project && meSource instanceof CompositeSection) {
			return true;
		}
		return false;
	}

	/**
	 * Tests, if the source element can be pasted into project root.
	 */
	private boolean canPasteIntoPSTest() {

		if (meSource instanceof CompositeSection) {
			return true;
		}
		return false;
	}
}
