package org.unicase.workspace.ui.dialogs.merge.util;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent;
import org.unicase.emfstore.esmodel.versioning.events.MergeChoiceSelection;
import org.unicase.emfstore.esmodel.versioning.events.MergeEvent;
import org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceEvent;
import org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceSelection;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption.OptionType;
import org.unicase.workspace.ui.dialogs.merge.conflict.options.IssueOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.options.MergeTextOption;

public class EventLogger {

	private ProjectSpace projectSpace;

	public EventLogger(Project project) {
		projectSpace = WorkspaceManager.getProjectSpace(project);
	}

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

	public void optionSelected(Conflict conflict) {
		MergeChoiceEvent choiceEvent = EventsFactory.eINSTANCE.createMergeChoiceEvent();
		String attribute = conflict.getConflictContext().getAttribute();
		choiceEvent.setContextFeature(attribute);

		ModelElement modelElement = conflict.getConflictContext().getModelElement();
		if (modelElement != null) {
			choiceEvent.setContextModelElement(modelElement.getModelElementId());
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
		} else if (conflict.getSolution() instanceof IssueOption) {
			choiceEvent.setSelection(MergeChoiceSelection.ISSUE);
			choiceEvent.setCreatedIssueName(((IssueOption) conflict.getSolution()).getOptionLabel());
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

	public void selectedAllMine() {
		createGlobalChoiceEvent(MergeGlobalChoiceSelection.ALL_MINE);
	}

	public void selectedAllTheirs() {
		createGlobalChoiceEvent(MergeGlobalChoiceSelection.ALL_THEIR);
	}

	public void selectedOK() {
		createGlobalChoiceEvent(MergeGlobalChoiceSelection.OK_FINISHED);
	}

	public void selectedOKButNotFinished() {
		createGlobalChoiceEvent(MergeGlobalChoiceSelection.OK_NOT_FINISHED);
	}

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
