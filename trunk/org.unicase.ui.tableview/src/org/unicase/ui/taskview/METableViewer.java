package org.unicase.ui.taskview;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

public class METableViewer extends TableViewer {

	private Project currentProject;
	private AdapterFactory adapterFactory;
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
		super(parent, SWT.FULL_SELECTION);
		this.adapterFactory = adapterFactory;
		this.itemMetaClass = itemMetaClass;

		final Workspace workspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();

		workspace.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					currentProject = workspace.getActiveProjectSpace()
							.getProject();
					setInput(currentProject);
				}
				super.notifyChanged(msg);
			}
		});

		this.setAdapterFactory(adapterFactory);

		this.createColumns();
		this.getTable().setLinesVisible(true);
		this.getTable().setHeaderVisible(true);
	}

	/**
	 * Updates the {@code adapterFactory} attribute of this class. Calls
	 * {@link #setInput(Object)} to reflect the changed set of items that shall
	 * be displayed.
	 * 
	 * @param adapterFactory
	 *            the new adapter factory that is used to create the
	 *            AdapterFactoryContentProvider that bridges jFace to EMF
	 *            provider calls.
	 */
	public void setAdapterFactory(AdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
		AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(
				this.adapterFactory);
		this.setContentProvider(contentProvider);

		setInput(currentProject);
	}

	private void createColumns() {
		EAttribute name = ModelPackage.Literals.MODEL_ELEMENT__NAME;
		TableViewerColumn nameColumn = prepareColumn(name, 250);

		EAttribute creator = ModelPackage.Literals.MODEL_ELEMENT__CREATOR;
		TableViewerColumn creatorColumn = prepareColumn(creator, 100);

		EAttribute creationDate = ModelPackage.Literals.MODEL_ELEMENT__CREATION_DATE;
		TableViewerColumn creationDateColumn = prepareColumn(creationDate, 150);

		EAttribute state = ModelPackage.Literals.MODEL_ELEMENT__STATE;
		TableViewerColumn stateColumn = prepareColumn(state, 140);

		EReference assignee = TaskPackage.Literals.WORK_ITEM__ASSIGNEE;
		TableViewerColumn assigneeColumn = prepareColumn(assignee, 150);

		EReference container = TaskPackage.Literals.WORK_ITEM__CONTAINING_WORKPACKAGE;
		TableViewerColumn containerColumn = prepareColumn(container, 150);
	}

	private String getFeatureName(EStructuralFeature feature) {
		EStructuralFeature currentFeature = feature;
		String nameLookupString = "_UI_"
				+ ((EClass) currentFeature.eContainer()).getName() + "_"
				+ currentFeature.getName() + "_feature";
		return ModelEditPlugin.INSTANCE.getString(nameLookupString);
	}

	private TableViewerColumn prepareColumn(EStructuralFeature currentFeature,
			int width) {
		TableViewerColumn currentColumn;
		currentColumn = new TableViewerColumn(this, SWT.CENTER);

		String name = getFeatureName(currentFeature);
		currentColumn.getColumn().setText(name);
		currentColumn.getColumn().setWidth(width);

		currentColumn.getColumn().setMoveable(true);
		currentColumn.getColumn().setResizable(true);

		ColumnLabelProvider provider = new GenericColumnLabelProvider(
				currentFeature);
		currentColumn.setLabelProvider(provider);

		ViewerComparator comp = new TableViewerColumnSorter(this,
				currentColumn, provider);
		currentColumn.getViewer().setComparator(comp);

		return currentColumn;
	}

}