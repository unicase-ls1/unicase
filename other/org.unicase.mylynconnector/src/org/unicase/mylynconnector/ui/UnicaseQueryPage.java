package org.unicase.mylynconnector.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryConnector;
import org.eclipse.mylyn.tasks.core.IRepositoryQuery;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.TasksUi;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositoryQueryPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.FilteredList;
import org.unicase.model.ModelElement;
import org.unicase.mylynconnector.core.UnicaseConnector;

public class UnicaseQueryPage extends AbstractRepositoryQueryPage {

	private static final String UNICASE_QUERY = "Unicase Query";
	private FilteredList filteredList;

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
		for(Object selection : selections) {
			if(selection instanceof ModelElement) {
				result += ((ModelElement) selection).getModelElementId().getId()+";";
			}
		}
		if(result!="") {
			// cut off last ;
			result = result.substring(0, result.length()-1);
		}
		query.setAttribute("modelElementIds", result);
	}

	@Override
	public String getQueryTitle() {
		return UNICASE_QUERY;
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.BORDER);
		 composite.setLayout(new GridLayout(1, false));
		 GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).applyTo(composite);
		 
		Label label = new Label(composite, SWT.NONE);
		label.setText("Select your ActionItem:");

		filteredList = new FilteredList(composite, SWT.BORDER | SWT.MULTI
				| SWT.V_SCROLL, new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof ModelElement) {
					return ((ModelElement) element).getName();
				} else {
					return "";
				}
			}
		}, true, true, true);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).applyTo(filteredList);
		filteredList.setVisible(true);
		fillList();
		setControl(composite);
	}

	private void fillList() {
		List<? extends ModelElement> list = getConnector().getAllActionItems(getTaskRepository());
		if(list != null) {
			filteredList.setElements(list.toArray(new Object[list.size()]));
		}
		filteredList.pack();
	}

	private UnicaseConnector getConnector() {
		AbstractRepositoryConnector repositoryConnector = TasksUi.getRepositoryConnector(getTaskRepository().getConnectorKind());
		return (UnicaseConnector) repositoryConnector;
	}

}
