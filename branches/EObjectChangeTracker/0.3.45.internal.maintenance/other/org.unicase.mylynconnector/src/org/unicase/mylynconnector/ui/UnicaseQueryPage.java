package org.unicase.mylynconnector.ui;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryConnector;
import org.eclipse.mylyn.tasks.core.IRepositoryQuery;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.TasksUi;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositoryQueryPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredList;
import org.unicase.model.ModelElement;
import org.unicase.mylynconnector.core.UnicaseConnector;

public class UnicaseQueryPage extends AbstractRepositoryQueryPage {

	private static final String UNICASE_QUERY = "Unicase Query";
	private FilteredList filteredList;
	private Text queryNameText;

	public UnicaseQueryPage(String pageName, TaskRepository taskRepository) {
		super(pageName, taskRepository);
	}

	public UnicaseQueryPage(TaskRepository taskRepository,
			IRepositoryQuery queryToEdit) {
		super(UNICASE_QUERY, taskRepository, queryToEdit);
	}

	@Override
	public void applyTo(IRepositoryQuery query) {
		Object[] selections = filteredList.getSelection();
		String result = "";
		for (Object selection : selections) {
			if (selection instanceof ModelElement) {
				result += ((ModelElement) selection).getModelElementId()
						.getId()
						+ ";";
			}
		}
		if (result != "") {
			// cut off last ;
			result = result.substring(0, result.length() - 1);
		}
		if (getQueryTitle() != null) {
			query.setSummary(getQueryTitle());
		}
		query.setAttribute("modelElementIds", result);
	}

	@Override
	public String getQueryTitle() {
		return (queryNameText != null) ? queryNameText.getText()
				: UNICASE_QUERY;
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.BORDER);

		GridLayoutFactory.fillDefaults().applyTo(composite);
		GridDataFactory.fillDefaults().applyTo(composite);

		Label queryName = new Label(composite, SWT.NONE);
		queryName.setText("Name of Query:");

		queryNameText = new Text(composite, SWT.NONE);
		queryNameText.setText(UNICASE_QUERY);
		queryNameText.setSelection(0, queryNameText.getText().length());
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).applyTo(
				queryNameText);
		queryNameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				getContainer().updateButtons();
			}
		});

		Label listLabel = new Label(composite, SWT.NONE);
		listLabel.setText("Select your ActionItem:");

		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		filteredList = new FilteredList(composite, SWT.BORDER | SWT.MULTI
				| SWT.V_SCROLL, labelProvider, true, true, true);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(filteredList);
		filteredList.setVisible(true);
		fillList();
		setControl(composite);
	}

	private void fillList() {
		List<? extends ModelElement> list = getConnector().getAllActionItems(
				getTaskRepository());
		if (list != null) {
			filteredList.setElements(list.toArray(new Object[list.size()]));
		}
		filteredList.pack();
	}

	private UnicaseConnector getConnector() {
		AbstractRepositoryConnector repositoryConnector = TasksUi
				.getRepositoryConnector(getTaskRepository().getConnectorKind());
		return (UnicaseConnector) repositoryConnector;
	}

}
