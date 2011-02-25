package org.unicase.workspace.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.UnkownFeatureException;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

public class OperationFilter {
	private int operationcache;
	private Command commandcache;
	private ProjectSpace projectSpacecache;

	private Project projectcache;
	private Collection<Object> clipboard;
	private EList<ModelElement> projectContainedME;

	public int getOperationListSizeBeforeCommand() {
		return operationcache;
	}

	/*
	 * Starts filtering the operations as notified by the commandStarted listener.
	 */

	public void setFilteringStarted(Command command, ProjectSpace projectSpace) {
		this.commandcache = command;
		this.clipboard = Configuration.getEditingDomain().getClipboard();
		this.projectcache = projectSpace.getProject();

		Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		if (!(projectSpace.getProject() == null)) {
			if (!(currentWorkspace.getProjectSpaces() == null)) {
				// this.projectContainedME = project.getAllModelElements();
				projectSpacecache = currentWorkspace.getActiveProjectSpace();
			}
		}
		if (!(projectSpacecache == null)) {
			operationcache = projectSpacecache.getOperations().size();

		}

	}

	/*
	 * Notifies of the commandEnded state.
	 */

	public void setFilteringOver(Command command, ProjectSpace projectSpace) {

		List<AbstractOperation> operations = extractOperations(command, projectSpace);
		if (containmentLost(projectSpace.getProject(), operations)) {
			this.resetCommandTrace();
			return;
		} else if (isCopyCommand()) {
			// Now that was a copy command!
			this.resetCommandTrace();
			return;
		}

	}

	private boolean isCopyCommand() {
		Collection<Object> domainClipboard = Configuration.getEditingDomain().getClipboard();
		if ((this.clipboard == null) && (domainClipboard == null)) {
			// There is nothing in clipboard before and after command execution.
			return false;

		} else if (domainClipboard != null && this.clipboard != null) {
			if (domainClipboard.containsAll(this.clipboard)) {
				// The same value in clipboard as earlier...might be copied the same element twice!
				return false;
			}
		}

		else if ((domainClipboard != null) && (this.clipboard == null)) {
			// Confirmed copy command!
			return true;
		}
		return false;
	}

	/*
	 * Checks if the feature is containment,checks if the 'modelelement' have a container and finally checks in the
	 * cache if there was any element with the ID as the one which has lost container! Based on the previous 3 it
	 * concludes that the last commad was a DeleteOperation.
	 */

	private boolean containmentLost(Project project, List<AbstractOperation> operations) {
		if ((operations != null) && (operations.size() > 0)) {
			for (Object opers : operations) {
				List<AbstractOperation> leafOperations = ((AbstractOperation) opers).getLeafOperations();
				if (leafOperations != null && leafOperations.size() > 0) {
					for (AbstractOperation leafOP : leafOperations) {
						if (leafOP instanceof ReferenceOperation) {
							Set<ModelElementId> modelelements = ((ReferenceOperation) leafOP)
								.getAllInvolvedModelElements();
							EReference feature = null;

							for (ModelElementId modelElementID : modelelements) {
								try {
									ModelElement modelElement = project.getModelElement(modelElementID);
									if ((modelElement != null) && !(opers instanceof CompositeOperation)) {
										ModelElementId modelE = ((FeatureOperation) opers).getModelElementId();
										if (modelE != modelElementID) {
											feature = (EReference) ((MultiReferenceOperation) leafOP)
												.getFeature(project.getModelElement(modelE));
											if (feature != null && modelElement.getContainerModelElement() == null
												&& feature.isContainment()
												&& this.projectContainedME.contains(modelElement)) {
												// The containment is broken, it can be either a cut to clipboard
												// command or a
												// delete command...to make sure if its cut check if the element is
												// in clipboard.
												if (!isCutCommand(modelElement)) {
													project.deleteModelElement(modelElement);
													return true;
												} else {
													// Handle cut Operation by moving the element to a temporary
													// place!
													project.deleteModelElement(modelElement);
													this.resetCommandTrace();
												}

											}

										}

									}

								} catch (UnkownFeatureException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
		return false;

	}

	private boolean isCutCommand(ModelElement modelElement) {
		Collection<Object> domainClipboard = Configuration.getEditingDomain().getClipboard();
		if ((this.clipboard == null) && (domainClipboard == null)) {
			// There is nothing in clipboard before and after command execution.
			return false;

		} else if (domainClipboard != null && this.clipboard != null) {
			if (domainClipboard.containsAll(this.clipboard)) {
				// The same value in clipboard as earlier
				return false;
			}
		}

		else if (domainClipboard != null) {
			if (domainClipboard.contains(modelElement)) {
				// Thats a Cut command.
				return true;
			}
		}
		return false;
	}

	/**
	 * Extracts all the operations from the workspace since the time of last command successfully executed.
	 */
	private List<AbstractOperation> extractOperations(Command command, ProjectSpace projectSpace) {
		List<AbstractOperation> result = new ArrayList<AbstractOperation>();

		// sanity checks
		if ((this.commandcache != command) || (projectSpace.getProject() != this.projectcache)) {
			return result;
		}

		List<AbstractOperation> newOperationList = projectSpace.getOperations();

		for (int i = this.getOperationListSizeBeforeCommand(); i < newOperationList.size(); i++) {
			result.add(newOperationList.get(i));
		}
		return result;
	}

	/*
	 * This method resets the value of all fields to the value before command started!
	 */
	private void resetCommandTrace() {
		this.commandcache = null;
		this.operationcache = 0;
		this.projectcache = null;
		this.projectSpacecache = null;

	}

	public void setCommandFailed() {
		resetCommandTrace();

	}

}
