package org.unicase.ui.taskview;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.ModelElement;
import org.unicase.ui.tableview.viewer.TableViewColumnLabelProvider;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

public class METableViewer<T extends ModelElement> extends TableViewer {

	private T templateObject;

	public METableViewer(T template, Composite parent) {
		super(parent);

		this.templateObject = template;

		// TableColumn[] columns = this.getTable().getColumns();
		AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(
				new CollectionAdapterFactory());

		this.setContentProvider(contentProvider);
		this.setSorter(new ViewerSorter());

		this.createColumns();
		this.getTable().setLinesVisible(true);
		this.getTable().setHeaderVisible(true);

		EList<T> inputList = getAllMEs();
		this.setInput(inputList);
	}

	private EList<T> getAllMEs() {
		Workspace ws = WorkspaceManager.getInstance().getCurrentWorkspace();

		EList<ProjectSpace> psl = ws.getProjectSpaces();

		EList<T> inputList = new BasicEList<T>();

		for (ProjectSpace p : psl) {
			inputList.addAll(p.getProject().getAllModelElementsbyClass(
					templateObject.eClass(), new BasicEList<T>()));

		}
		return inputList;
	}

	@Deprecated
	public void updateInput() {
		this.setInput(getAllMEs());
	}

	private void createColumns() {

		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		List<IItemPropertyDescriptor> descriptors = adapterFactoryItemDelegator
				.getPropertyDescriptors(templateObject);

		for (IItemPropertyDescriptor currentDescriptor : descriptors) {
			if (!currentDescriptor.isMany(templateObject)) {
				TableViewerColumn currentColumn = new TableViewerColumn(this,
						SWT.CENTER);
				currentColumn.getColumn().setText(
						currentDescriptor.getDisplayName(templateObject));
				currentColumn.getColumn().setWidth(100);
				currentColumn.getColumn().setMoveable(true);
				currentColumn.getColumn().setResizable(true);

				currentColumn
						.setLabelProvider(new TableViewColumnLabelProvider(
								currentDescriptor));
				// currentColumn.setEditingSupport(EditingSupport
			}
		}

	}
}
