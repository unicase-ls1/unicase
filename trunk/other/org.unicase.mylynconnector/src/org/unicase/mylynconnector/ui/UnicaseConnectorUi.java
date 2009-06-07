package org.unicase.mylynconnector.ui;

import org.unicase.mylynconnector.core.UnicaseConnector;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.mylyn.tasks.core.IRepositoryQuery;
import org.eclipse.mylyn.tasks.core.ITaskMapping;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.AbstractRepositoryConnectorUi;
import org.eclipse.mylyn.tasks.ui.wizards.ITaskRepositoryPage;
import org.eclipse.mylyn.tasks.ui.wizards.RepositoryQueryWizard;

public class UnicaseConnectorUi extends
		AbstractRepositoryConnectorUi {

	public UnicaseConnectorUi() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getConnectorKind() {
		return UnicaseConnector.CONNECTOR_KIND;
	}

	@Override
	public IWizard getNewTaskWizard(TaskRepository taskRepository,
			ITaskMapping selection) {
		return null;
	}

	@Override
	public IWizard getQueryWizard(TaskRepository taskRepository,
			IRepositoryQuery queryToEdit) {
		RepositoryQueryWizard repositoryQueryWizard = new RepositoryQueryWizard(taskRepository);
		repositoryQueryWizard.addPage(new UnicaseQueryPage(taskRepository,queryToEdit));
		return repositoryQueryWizard;
	}

	@Override
	public ITaskRepositoryPage getSettingsPage(TaskRepository taskRepository) {
		return new UnicaseRepositoryPage(taskRepository);
	}

	@Override
	public boolean hasSearchPage() {
		return false;
	}

}