package org.unicase.mylynconnector.core;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryConnector;
import org.eclipse.mylyn.tasks.core.IRepositoryQuery;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.core.data.TaskData;
import org.eclipse.mylyn.tasks.core.data.TaskDataCollector;
import org.eclipse.mylyn.tasks.core.sync.ISynchronizationSession;
import org.unicase.model.ModelElement;

public class UnicaseConnector extends AbstractRepositoryConnector {

	public static final String DOLLI2 = "dolli2";
	public static final String CONNECTOR_KIND = "org.unicase.mylynconnector";

	private UnicaseTaskDataHandler taskDataHandler;
	private UnicaseContextListener unicaseContextListener;

	public UnicaseTaskDataHandler getTaskDataHandler() {
		return taskDataHandler;
	}

	public UnicaseConnector() {
		taskDataHandler = new UnicaseTaskDataHandler();
		unicaseContextListener = new UnicaseContextListener();
	}

	@Override
	public boolean canCreateNewTask(TaskRepository repository) {
		return false;
	}

	@Override
	public boolean canCreateTaskFromKey(TaskRepository repository) {
		return false;
	}

	@Override
	public String getConnectorKind() {
		return CONNECTOR_KIND;
	}

	@Override
	public String getLabel() {
		return "Unicase Repository";
	}

	@Override
	public String getRepositoryUrlFromTaskUrl(String taskFullUrl) {
		return null;
	}

	@Override
	public TaskData getTaskData(TaskRepository taskRepository, String taskId,
			IProgressMonitor monitor) throws CoreException {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		return taskDataHandler.getTaskData(taskRepository, taskId);
	}

	@Override
	public String getTaskIdFromTaskUrl(String taskFullUrl) {
		return null;
	}

	@Override
	public String getTaskUrl(String repositoryUrl, String taskId) {
		return null;
	}

	@Override
	public boolean hasTaskChanged(TaskRepository taskRepository, ITask task,
			TaskData taskData) {
		return false;
	}

	@Override
	public IStatus performQuery(TaskRepository repository,
			IRepositoryQuery query, TaskDataCollector collector,
			ISynchronizationSession session, IProgressMonitor monitor) {
		String attribute = query.getAttribute("modelElementIds");

		if (attribute != null) {
			for (String meId : attribute.split(";")) {
				if (taskExists(repository, meId)) {
					try {
						collector.accept(getTaskData(repository,
								UnicaseConnectorUtil.convertMeIdToTaskId(meId),
								monitor));
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return Status.OK_STATUS;
	}

	private boolean taskExists(TaskRepository repository, String meIds) {
		meIds = UnicaseConnectorUtil.convertTaskIdToMeId(meIds);
		for (ModelElement me : getAllActionItems(repository)) {
			if (me.getIdentifier().equals(meIds)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void updateRepositoryConfiguration(TaskRepository taskRepository,
			IProgressMonitor monitor) throws CoreException {
	}

	@Override
	public void updateTaskFromTaskData(TaskRepository taskRepository,
			ITask task, TaskData taskData) {
	}

	public List<? extends ModelElement> getAllActionItems(
			final TaskRepository repository) {
		return taskDataHandler.getAllActionItems(repository);
	}
}
