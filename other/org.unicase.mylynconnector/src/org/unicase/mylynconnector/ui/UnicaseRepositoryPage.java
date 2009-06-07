package org.unicase.mylynconnector.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositorySettingsPage;
import org.eclipse.mylyn.tasks.ui.wizards.ITaskRepositoryPage;
import org.eclipse.swt.widgets.Composite;
import org.unicase.mylynconnector.core.UnicaseConnector;

public class UnicaseRepositoryPage extends AbstractRepositorySettingsPage
		implements ITaskRepositoryPage {

	public UnicaseRepositoryPage(TaskRepository taskRepository) {
		super("Unicase Repository", "Configure your unicase repository.", taskRepository);
		setNeedsAnonymousLogin(true);
		setNeedsAdvanced(false);
		setNeedsEncoding(false);
		setNeedsHttpAuth(false);
		setNeedsProxy(false);
	}

	@Override
	protected void createAdditionalControls(Composite parent) {
	}

	@Override
	public String getConnectorKind() {
		return UnicaseConnector.CONNECTOR_KIND;
	}

	@Override
	protected Validator getValidator(TaskRepository repository) {
		return new Validator() {
			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
			}
		};
	}

	@Override
	protected boolean isValidUrl(String url) {
		return url.equalsIgnoreCase(UnicaseConnector.DOLLI2);
	}

}
