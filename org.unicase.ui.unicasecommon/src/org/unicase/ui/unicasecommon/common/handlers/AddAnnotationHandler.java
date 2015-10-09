/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.internal.common.model.Project;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.LeafSection;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * . This is a generic handler to add different types of Annotations to a
 * ModelElement
 * 
 * @author Hodaie
 */
public class AddAnnotationHandler extends AbstractHandler {
	/**
	 * Adds a annotation to the next possible containment.
	 * 
	 * @author helming
	 */
	private final class AddAnnotationCommand extends EMFStoreCommand {
		private final int i;
		private final Object object;
		private final Annotation result;

		private AddAnnotationCommand(int i, Object object, Annotation result) {
			this.i = i;
			this.object = object;
			this.result = result;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void doRun() {
			if (i == 1) {
				((LeafSection) object).getModelElements().add(result);
			} else if (i == 2) {

				EObject parent = ((EObject) object).eContainer();
				while (!(parent instanceof Project)
						&& result.eContainer() == null
						&& !(object instanceof LeafSection)) {
					EReference reference = getStructuralFeature(result, parent);
					if (reference != null && reference.isMany()) {
						Object object = parent.eGet(reference);
						EList<EObject> eList = (EList<EObject>) object;
						eList.add(result);
					}

				}

			} else if (i == 3) {
				((Project) object).getModelElements().add(result);
			}
		}
	}

	private static final String ADD_ACTIONITEM_COMMAND_ID = "org.unicase.ui.common.commands.annotateActionItem";
	private static final String ADD_ISSUE_COMMAND_ID = "org.unicase.ui.common.commands.annotateIssue";

	private ExecutionEvent event;

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Annotation annotation = null;
		this.event = event;

		// 1. extract the model element, to which the Annotation will be
		// attached
		// see ActionHelper.getModelElement()
		UnicaseModelElement me = UnicaseActionHelper.getModelElement(event);
		// 2. extract command and create the appropriate annotation object
		Project project = ModelUtil.getProject(me);
		LeafSection leafSection = getLeafSection(me);
		if (leafSection != null) {
			annotation = createAnnotation(leafSection, 1);
		} else if (me.eContainer() instanceof WorkPackage) {
			annotation = createAnnotation(me, 2);
		} else if (!(project == null)) {
			annotation = createAnnotation(project, 3);
		} else {
			return null;
		}
		attachAnnotation(me, annotation);

		// 3. open annotation object for further editing
		openAnnotation(annotation);

		return null;
	}

	private LeafSection getLeafSection(UnicaseModelElement me) {
		EObject container = me.eContainer();
		// try to find a parent LeafSection
		while (container != null) {
			if (container instanceof LeafSection) {
				return (LeafSection) container;
			}
			container = container.eContainer();
		}
		// check if element is itself a LeafSection
		if (me instanceof LeafSection) {
			return (LeafSection) me;
		}
		return null;
	}

	/**
	 * . This creates the appropriate Annotation based on selected menu command
	 * and adds it to Project
	 * 
	 * @param leafSection
	 * @return
	 */
	private Annotation createAnnotation(final Object object, final int i) {
		final Annotation result;

		if (event.getCommand().getId().equals(ADD_ACTIONITEM_COMMAND_ID)) {
			result = TaskFactory.eINSTANCE.createActionItem();
			result.setName("New Action Item");
			result.setDescription("");

		} else if (event.getCommand().getId().equals(ADD_ISSUE_COMMAND_ID)) {
			result = RationaleFactory.eINSTANCE.createIssue();
			result.setName("New Issue");
			result.setDescription("");
		} else {
			result = null;
		}
		new AddAnnotationCommand(i, object, result).run();

		return result;
	}

	/**
	 * . This attaches the Annotation to ModelElement
	 * 
	 * @param me
	 * @param annotation
	 */
	private void attachAnnotation(final UnicaseModelElement me,
			final Annotation annotation) {
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				me.getAnnotations().add(annotation);
			}
		}.run();
	}

	/**
	 * . This opens Annotation for further editing
	 * 
	 * @param annotation
	 */
	private void openAnnotation(Annotation annotation) {
		UnicaseActionHelper.openModelElement(annotation, this.getClass()
				.getName());
	}

	private EReference getStructuralFeature(final EObject newMEInstance,
			EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass()
				.getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			EClass eReferenceType = containmentitem.getEReferenceType();
			if (eReferenceType.equals(newMEInstance)) {
				reference = containmentitem;

				break;
			} else if (eReferenceType.equals(EcorePackage.eINSTANCE
					.getEObject())
					|| (eReferenceType.isSuperTypeOf(newMEInstance.eClass()))) {
				reference = containmentitem;
				break;
			}
		}
		return reference;
	}

}
