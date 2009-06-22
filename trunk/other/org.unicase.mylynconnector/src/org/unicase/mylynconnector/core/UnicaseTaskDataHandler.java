package org.unicase.mylynconnector.core;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.mylyn.tasks.core.ITaskMapping;
import org.eclipse.mylyn.tasks.core.RepositoryResponse;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.core.data.AbstractTaskDataHandler;
import org.eclipse.mylyn.tasks.core.data.TaskAttribute;
import org.eclipse.mylyn.tasks.core.data.TaskAttributeMapper;
import org.eclipse.mylyn.tasks.core.data.TaskAttributeMetaData;
import org.eclipse.mylyn.tasks.core.data.TaskData;
import org.unicase.model.ModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.RecordingCommandWithResult;

public class UnicaseTaskDataHandler extends AbstractTaskDataHandler {

	public UnicaseTaskDataHandler() {
		super();
	}

	@Override
	public TaskAttributeMapper getAttributeMapper(TaskRepository taskRepository) {
		return new TaskAttributeMapper(taskRepository);
	}

	@Override
	public boolean initializeTaskData(TaskRepository repository,
			TaskData taskData, ITaskMapping initializationData,
			IProgressMonitor monitor) throws CoreException {

		createAttribute(taskData, TaskAttribute.SUMMARY,
				TaskAttribute.TYPE_SHORT_RICH_TEXT, true, "Summary", true);

		createAttribute(taskData, TaskAttribute.TASK_KEY,
				TaskAttribute.TYPE_SHORT_RICH_TEXT, true, "Taskkey", true);

		createAttribute(taskData, TaskAttribute.DESCRIPTION,
				TaskAttribute.TYPE_LONG_RICH_TEXT, true, "Description", true);

		createAttribute(taskData, TaskAttribute.DATE_CREATION,
				TaskAttribute.TYPE_DATE, true, "Created", true);

		return true;
	}

	TaskAttribute createAttribute(TaskData data, String keyID, String attrType,
			boolean isVisible, String label, boolean readOnly) {
		TaskAttribute attr = data.getRoot().createAttribute(keyID);

		TaskAttributeMetaData metaData = attr.getMetaData();
		metaData.setType(attrType);
		metaData.setKind(isVisible ? TaskAttribute.KIND_DEFAULT : null);
		metaData.setLabel(label);
		metaData.setReadOnly(readOnly);

		return attr;
	}

	@Override
	public RepositoryResponse postTaskData(TaskRepository repository,
			TaskData taskData, Set<TaskAttribute> oldAttributes,
			IProgressMonitor monitor) throws CoreException {
		return null;
	}

	@SuppressWarnings("restriction")
	public TaskData getTaskData(TaskRepository taskRepository, String taskId) {
		ModelElement modelElement = getModelElement(taskRepository,
				UnicaseConnectorUtil.convertTaskIdToMeId(taskId));
		if (modelElement != null) {
			TaskData taskData = new TaskData(
					getAttributeMapper(taskRepository), taskRepository
							.getConnectorKind(), taskRepository
							.getRepositoryUrl(), taskId);

			try {
				initializeTaskData(taskRepository, taskData, null, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}

			TaskAttribute attribute = taskData.getRoot().createAttribute(
					TaskAttribute.SUMMARY);
			attribute.setValue(modelElement.getName());

			attribute = taskData.getRoot().createAttribute(
					TaskAttribute.TASK_KEY);
			attribute.setValue(modelElement.getName());

			attribute = taskData.getRoot().createAttribute(
					TaskAttribute.DESCRIPTION);
			attribute.setValue(modelElement.getDescription());

			attribute = taskData.getRoot().createAttribute(
					TaskAttribute.DATE_CREATION);
			taskData.getAttributeMapper().setDateValue(attribute,
					modelElement.getCreationDate());

			return taskData;
		} else {
			return null;
		}
	}

	public List<? extends ModelElement> getAllActionItems(
			final TaskRepository repository) {
		TransactionalEditingDomain domain = getDomain();
		RecordingCommandWithResult<List<? extends ModelElement>> commandWithResult = new RecordingCommandWithResult<List<? extends ModelElement>>(
				domain) {
			@Override
			protected void doExecute() {
				ProjectSpace projectSpace = getProjectSpace(repository);
				if (projectSpace != null) {
					EList<ActionItem> actionItems = projectSpace.getProject()
							.getAllModelElementsbyClass(
									TaskPackage.eINSTANCE.getActionItem(),
									new BasicEList<ActionItem>());
					setTypedResult(actionItems);
				}
			}
		};
		domain.getCommandStack().execute(commandWithResult);
		return commandWithResult.getTypedResult();
	}

	public ModelElement getModelElement(final TaskRepository taskRepository,
			final String taskId) {
		TransactionalEditingDomain domain = getDomain();
		RecordingCommandWithResult<ModelElement> commandWithResult = new RecordingCommandWithResult<ModelElement>(
				domain) {
			@Override
			protected void doExecute() {
				ProjectSpace projectSpace = getProjectSpace(taskRepository);
				if (projectSpace != null) {
					setTypedResult(projectSpace.getProject().getModelElement(
							ModelUtil.createModelElementId(taskId)));
				}
			}
		};
		domain.getCommandStack().execute(commandWithResult);
		return commandWithResult.getTypedResult();
	}

	/**
	 * Should only be used within a command.
	 * 
	 * @param repository
	 *            repository
	 * @return null or projectspace
	 */
	private ProjectSpace getProjectSpace(final TaskRepository repository) {
		Workspace currentWorkspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();
		ProjectSpace projectSpace = null;
		for (ProjectSpace ps : currentWorkspace.getProjectSpaces()) {
			if (ps.getProjectName().equalsIgnoreCase(
					repository.getRepositoryUrl())) {
				projectSpace = ps;
				break;
			}
		}
		return projectSpace;
	}

	public TransactionalEditingDomain getDomain() {
		return UnicaseConnectorUtil.getDomain();
	}
}
