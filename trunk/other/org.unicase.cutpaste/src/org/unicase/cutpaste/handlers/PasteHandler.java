/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.cutpaste.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
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
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * The Paste Handler. Loads a UnicaseTransferable from the system clipboard, handles the paste action and ends the begun
 * CompositeOperation.
 * 
 * @author weiglt
 */
public final class PasteHandler extends AbstractHandler {

	private ModelElement meSource, meTarget;
	private ProjectSpace psTarget;
	private Object target; // Since Target can also be a ProjectSpace which is not a ME
	private CompositeOperationHandle handle;
	private Clipboard clipboard;
	private Transferable transferable;
	private String prevLocation, prevLocationType;

	/**
	 * Executes the paste command.
	 * 
	 * @param event The MouseClick Event
	 * @return null
	 * @throws ExecutionException ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		target = ActionHelper.getModelElement(event);
		if (target == null) {
			target = ActionHelper.getProjectSpace(event);
		}

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				paste(target);
			}
		}.run();

		return null;
	}

	private void paste(final Object target) {

		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		transferable = clipboard.getContents(null);

		if (target instanceof ModelElement) {
			meTarget = (ModelElement) target;

			try { // get data from clipboard
				meSource = (ModelElement) transferable.getTransferData(new DataFlavor(
					org.unicase.metamodel.ModelElement.class, "ModelElement"));
				handle = (CompositeOperationHandle) transferable.getTransferData(new DataFlavor(
					org.unicase.workspace.CompositeOperationHandle.class, "CompositeOperationHandle"));

				// Save old ME data before changing
				if (((UnicaseModelElement) meSource).getContainerModelElement() instanceof UnicaseModelElement) {
					prevLocation = ((UnicaseModelElement) ((UnicaseModelElement) meSource).getContainerModelElement())
						.getName();
					prevLocationType = (((UnicaseModelElement) meSource).getContainerModelElement()).eClass().getName();
				}

				// paste implements AllowedCutPaste-v3.txt, can also be found in this package

				if (meTarget instanceof LeafSection && meSource instanceof UnicaseModelElement
					&& !(meSource instanceof CompositeSection)) {
					((LeafSection) meTarget).getModelElements().add((UnicaseModelElement) meSource);
				} else if (meTarget instanceof UnicaseModelElement && meSource instanceof Comment) {
					((Comment) meSource).setCommentedElement((UnicaseModelElement) meTarget);
				} else if (meTarget instanceof FunctionalRequirement && meSource instanceof FunctionalRequirement) {
					((FunctionalRequirement) meSource).setRefinedRequirement((FunctionalRequirement) meTarget);
				} else if (meTarget instanceof WorkPackage && meSource instanceof WorkItem) {
					((WorkItem) meSource).setContainingWorkpackage((WorkPackage) meTarget);
				} else if (meTarget instanceof Meeting && meSource instanceof MeetingSection) {
					genericPaste(meTarget, meSource);
				} else if (meTarget instanceof CompositeMeetingSection && meSource instanceof MeetingSection) {
					genericPaste(meTarget, meSource);
				} else if (meTarget instanceof Component && meSource instanceof ComponentService) {
					((ComponentService) meSource).setOfferingComponent((Component) meTarget);
				} else if (meTarget instanceof org.unicase.model.classes.Package) {
					if (meSource instanceof org.unicase.model.classes.Class) {
						((org.unicase.model.classes.Class) meSource)
							.setParentPackage((org.unicase.model.classes.Package) meTarget);
					} else if (meSource instanceof org.unicase.model.classes.Package) {
						((org.unicase.model.classes.Package) meSource)
							.setParentPackage((org.unicase.model.classes.Package) meTarget);
					}
				} else if (meTarget instanceof org.unicase.model.classes.Class) {
					if (meSource instanceof Method) {
						((Method) meSource).setDefiningClass((org.unicase.model.classes.Class) meTarget);

					} else if (meSource instanceof Attribute) {
						((Attribute) meSource).setDefiningClass((org.unicase.model.classes.Class) meTarget);
					}
				} else if (meTarget instanceof Method && meSource instanceof MethodArgument) {
					genericPaste(meTarget, meSource);
				} else if (meTarget instanceof CompositeSection) {
					if (meSource instanceof CompositeSection) {
						genericPaste(meTarget, meSource);
					} else if (meSource instanceof LeafSection) {
						genericPaste(meTarget, meSource);
					}
				} else {
					System.out.println("Cannot paste into type: " + meTarget.getClass());
				}

				// end CompositeOperation, clear clipboard
				try {
					handle.end("Cutted and pasted ModelElement", "Moved " + meSource.eClass().getName() + " \""
						+ ((UnicaseModelElement) meSource).getName() + "\" from " + prevLocationType + " \""
						+ prevLocation + "\" to " + meTarget.eClass().getName() + " \""
						+ ((UnicaseModelElement) meTarget).getName() + "\"", ((UnicaseModelElement) meSource)
						.getModelElementId());
					clipboard.setContents(new StringSelection(""), null);
					System.out.println("Paste Operation finished. CompositeOperation finished.");
					refreshDecorator();
				} catch (InvalidHandleException e) {
					e.printStackTrace();
					System.out.println("ERROR paste: there was no begun cut action.");
				}

			} catch (UnsupportedFlavorException e) {
				e.printStackTrace();
				// flavor could not be provided (clipboard empty/corrupted?). actually the
				// propertytester should prevent this and thus this exception should never be thrown.
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (target instanceof ProjectSpace) {
			psTarget = (ProjectSpace) target;
			System.out.print("Paste on ProjectSpace detected. Not possible yet, sorry.");

		}
	}

	@SuppressWarnings("unchecked")
	private void genericPaste(final ModelElement meTarget, final ModelElement source) {

		EReference theRef = getTargetRef(meTarget, meSource);
		if (theRef == null) {
			return;
		}

		if (theRef.getEOpposite() != null) {
			// if it is a bidirectional reference, instead of adding source to target, set target to the opposite
			// reference.
			EReference oppositeRef = theRef.getEOpposite();

			Object object = meSource.eGet(oppositeRef);
			if (oppositeRef.isMany()) {
				EList<EObject> eList = (EList<EObject>) object;
				eList.add(meTarget);
			} else {
				meSource.eSet(oppositeRef, meTarget);
			}

		} else {
			if (theRef.isMany()) {

				Object object = meTarget.eGet(theRef);
				EList<EObject> eList = (EList<EObject>) object;
				eList.add(meSource);
			} else {
				meTarget.eSet(theRef, meSource);
			}

		}

	}

	private EReference getTargetRef(EObject targetContainer, ModelElement dropee) {

		List<EReference> refs = targetContainer.eClass().getEAllContainments();
		for (EReference ref : refs) {
			if (ref.isContainer()) {
				continue;
			}
			// checking for source reference type is based only on first element
			// of drag source. We suppose that elements with different types are
			// not allowed to be drag and dropped.
			if (ref.getEReferenceType().equals(dropee.eClass())
				|| ref.getEReferenceType().isSuperTypeOf(dropee.eClass())) {
				return ref;
			}
		}
		return null;

	}

	private void refreshDecorator() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				PlatformUI.getWorkbench().getDecoratorManager().update("org.unicase.cutpaste.decorator1");
			}
		});
	}
}