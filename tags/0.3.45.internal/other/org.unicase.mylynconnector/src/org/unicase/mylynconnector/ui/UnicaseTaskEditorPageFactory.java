package org.unicase.mylynconnector.ui;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.mylyn.tasks.ui.TasksUi;
import org.eclipse.mylyn.tasks.ui.TasksUiUtil;
import org.eclipse.mylyn.tasks.ui.editors.AbstractTaskEditorPageFactory;
import org.eclipse.mylyn.tasks.ui.editors.TaskEditor;
import org.eclipse.mylyn.tasks.ui.editors.TaskEditorInput;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.forms.editor.IFormPage;
import org.unicase.model.ModelElement;
import org.unicase.mylynconnector.core.UnicaseConnector;
import org.unicase.mylynconnector.core.UnicaseConnectorUtil;
import org.unicase.ui.meeditor.MEEditorPage;

public class UnicaseTaskEditorPageFactory extends AbstractTaskEditorPageFactory {

	private ModelElement modelElement;

	public UnicaseTaskEditorPageFactory() {
	}

	@Override
	public boolean canCreatePageFor(TaskEditorInput input) {
		UnicaseConnector connector = (UnicaseConnector) TasksUi
				.getRepositoryConnector(UnicaseConnector.CONNECTOR_KIND);
		if (connector == null) {
			return false;
		}
		modelElement = connector.getTaskDataHandler().getModelElement(
				input.getTaskRepository(),
				UnicaseConnectorUtil.convertTaskIdToMeId(input.getTask()
						.getTaskId()));
		if (modelElement == null) {
			return false;
		}
		return (input.getTask().getConnectorKind().equals(
				UnicaseConnector.CONNECTOR_KIND) || TasksUiUtil
				.isOutgoingNewTask(input.getTask(),
						UnicaseConnector.CONNECTOR_KIND));
	}

	@Override
	public Image getPageImage() {
		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		return provider.getImage(modelElement);
	}

	@Override
	public String getPageText() {
		return "MEEditor";
	}

	@Override
	public int getPriority() {
		return AbstractTaskEditorPageFactory.PRIORITY_TASK;
	}

	@Override
	public IFormPage createPage(TaskEditor parentEditor) {

		return new MEEditorPage(parentEditor, "someid", "embedded MeEditor",
				UnicaseConnectorUtil.getDomain(), modelElement);
	}
}
