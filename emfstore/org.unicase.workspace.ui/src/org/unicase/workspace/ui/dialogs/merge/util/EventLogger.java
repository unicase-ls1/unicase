/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.util;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent;
import org.unicase.emfstore.esmodel.versioning.events.MergeChoiceSelection;
import org.unicase.emfstore.esmodel.versioning.events.MergeEvent;
import org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceEvent;
import org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceSelection;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption.OptionType;
import org.unicase.workspace.ui.dialogs.merge.conflict.options.MergeTextOption;

/**
 * Helper class for logging events in merge dialog.
 * 
 * @author wesendon
 */
public class EventLogger {

	private ProjectSpace projectSpace;

	/**
	 * Default constructor.
	 * 
	 * @param project active project
	 */
	public EventLogger(Project project) {
		projectSpace = WorkspaceManager.getProjectSpace(project);
	}

	/**
	 * Merge Event.
	 * 
	 * @param base version
	 * @param target version
	 * @param numberOfConflicts int
	 * @param localChanges list of changes
	 */
	public void createMergeEvent(PrimaryVersionSpec base, PrimaryVersionSpec target, int numberOfConflicts,
		List<AbstractOperation> localChanges) {
		MergeEvent mergeEvent = EventsFactory.eINSTANCE.createMergeEvent();
		mergeEvent.setBaseVersion((PrimaryVersionSpec) EcoreUtil.copy(base));
		mergeEvent.setTargetVersion((PrimaryVersionSpec) EcoreUtil.copy(target));
		mergeEvent.setNumberOfConflicts(numberOfConflicts);
		for (AbstractOperation op : localChanges) {
			mergeEvent.getLocalChanges().add((AbstractOperation) EcoreUtil.copy(op));
		}
		addEvent(mergeEvent);
	}

	/**
	 * Option selected event.
	 * 
	 * @param conflict related conflict
	 */
	public void optionSelected(Conflict conflict) {
		MergeChoiceEvent choiceEvent = EventsFactory.eINSTANCE.createMergeChoiceEvent();
		String attribute = conflict.getConflictContext().getAttribute();
		choiceEvent.setContextFeature(attribute);

		EObject modelElement = conflict.getConflictContext().getModelElement();
		if (modelElement != null) {
			ModelElementId modelElementId;
			if (ModelUtil.getProject(modelElement) != null) {
				modelElementId = ModelUtil.getProject(modelElement).getModelElementId(modelElement);
			} else {
				CreateDeleteOperation createDeleteOp = (CreateDeleteOperation) ModelUtil.getParent(
					CreateDeleteOperation.class, modelElement);
				modelElementId = ModelUtil.clone(createDeleteOp.getEObjectToIdMap().get(modelElement));
			}

			choiceEvent.setContextModelElement(modelElementId);
		}

		if (OptionType.MyOperation.equals(conflict.getSolution().getType())) {
			choiceEvent.setSelection(MergeChoiceSelection.MINE);
			addOperations(conflict, choiceEvent);
		} else if (OptionType.TheirOperation.equals(conflict.getSolution().getType())) {
			choiceEvent.setSelection(MergeChoiceSelection.THEIR);
			addOperations(conflict, choiceEvent);
		} else if (conflict.getSolution() instanceof MergeTextOption) {
			choiceEvent.setSelection(MergeChoiceSelection.MERGED_TEXT);
			addOperations(conflict, choiceEvent);
		} else if (conflict.getSolution().getClass().getSimpleName().equals("IssueOption")) {
			System.err.println("test");
			choiceEvent.setSelection(MergeChoiceSelection.ISSUE);
			choiceEvent.setCreatedIssueName(conflict.getSolution().getOptionLabel());
		}

		addEvent(choiceEvent);
	}

	private void addOperations(Conflict conflict, MergeChoiceEvent choiceEvent) {
		for (AbstractOperation my : conflict.getAcceptedMine()) {
			choiceEvent.getMyAcceptedChanges().add(my.getOperationId());
		}
		for (AbstractOperation their : conflict.getRejectedTheirs()) {
			choiceEvent.getTheirRejectedChanges().add(their.getOperationId());
		}
	}

	/**
	 * Select all mine pressed.
	 */
	public void selectedAllMine() {
		createGlobalChoiceEvent(MergeGlobalChoiceSelection.ALL_MINE);
	}

	/**
	 * Select all theirs pressed.
	 */
	public void selectedAllTheirs() {
		createGlobalChoiceEvent(MergeGlobalChoiceSelection.ALL_THEIR);
	}

	/**
	 * Pressed ok and dialog closes.
	 */
	public void selectedOK() {
		createGlobalChoiceEvent(MergeGlobalChoiceSelection.OK_FINISHED);
	}

	/**
	 * Pressed ok, but not all decisions are resolved.
	 */
	public void selectedOKButNotFinished() {
		createGlobalChoiceEvent(MergeGlobalChoiceSelection.OK_NOT_FINISHED);
	}

	/**
	 * Dialog is canceled.
	 */
	public void selectedCancel() {
		createGlobalChoiceEvent(MergeGlobalChoiceSelection.CANCEL);
	}

	private void createGlobalChoiceEvent(MergeGlobalChoiceSelection type) {
		MergeGlobalChoiceEvent globalChoiceEvent = EventsFactory.eINSTANCE.createMergeGlobalChoiceEvent();
		globalChoiceEvent.setSelection(type);
		addEvent(globalChoiceEvent);
	}

	private void addEvent(Event event) {
		event.setTimestamp(new Date());
		if (projectSpace != null) {
			projectSpace.addEvent(event);
		}
	}

}
