package org.unicase.ui.taskview;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.Project;
import org.unicase.ui.tableview.viewer.TableViewColumnLabelProvider;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

public class METableViewer extends TableViewer {

	private Project currentProject;
	private AdapterFactory adapterFactory;

	public void setAdapterFactory(AdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
		AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(
				this.adapterFactory);
		this.setContentProvider(contentProvider);
		setInput(currentProject);
	}

	private EClass itemMetaClass;

	/**
	 * Constructor that directly sets the input of the table view.
	 * 
	 * @param parent
	 *            the parent control
	 * @param adapterFactory
	 *            the adapterFactory to use
	 * @param input
	 *            the new content for the table
	 * @param itemMetaClass
	 *            the EClass of the items that shall be displayed in the table
	 */
	public METableViewer(Composite parent, AdapterFactory adapterFactory,
			Object input, EClass itemMetaClass) {
		this(parent, adapterFactory, itemMetaClass);
		this.setInput(input);
	}

	/**
	 * Standard constructor.
	 * 
	 * @param parent
	 *            the parent control
	 * @param adapterFactory
	 *            the adapterFactory to use
	 * @param itemMetaClass
	 *            the EClass of the items that shall be displayed in the table
	 */
	public METableViewer(Composite parent, AdapterFactory adapterFactory,
			EClass itemMetaClass) {
		super(parent);
		this.adapterFactory = adapterFactory;
		this.itemMetaClass = itemMetaClass;

		Workspace workspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();

		workspace.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					currentProject = WorkspaceManager.getInstance()
							.getCurrentWorkspace().getActiveProjectSpace()
							.getProject();
					setInput(currentProject);
				}
				super.notifyChanged(msg);
			}
		});

		this.setAdapterFactory(adapterFactory);
		this.setSorter(new ViewerSorter());

		this.createColumns();
		this.getTable().setLinesVisible(true);
		this.getTable().setHeaderVisible(true);
	}

	/**
	 * All props to the guy who coded the {@link AdapterFactoryItemDelegator}
	 * class.
	 * 
	 * @param object
	 * @return the list of property descriptors for the given object
	 * @see AdapterFactoryItemDelegator#getPropertyDescriptors(Object)
	 */
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		//
		IItemPropertySource itemPropertySource = (IItemPropertySource) adapterFactory
				.adapt(object, IItemPropertySource.class);

		return itemPropertySource != null ? itemPropertySource
				.getPropertyDescriptors(object) : null;
	}

	private void createColumns() {

		Object templateObject = itemMetaClass.getEPackage()
				.getEFactoryInstance().create(itemMetaClass);

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
			}
		}

	}

}