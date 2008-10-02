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
import org.eclipse.jface.viewers.EditingSupport;
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
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

public class METableViewer extends TableViewer {

	private Project currentProject;
	private AdapterFactory adapterFactory;

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

		final Workspace workspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();

		workspace.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					ProjectSpace activeProjectSpace = workspace
							.getActiveProjectSpace();
					if (activeProjectSpace != null) {
						currentProject = activeProjectSpace.getProject();
						setInput(currentProject);
					}

				}
				super.notifyChanged(msg);
			}
		});

		this.setAdapterFactory(adapterFactory);

		if (workspace.getActiveProjectSpace() != null) {
			setInput(workspace.getActiveProjectSpace().getProject());
		}

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

	@Override
	protected void inputChanged(Object input, Object oldInput) {
		super.inputChanged(input, oldInput);
	}

	private void createColumns() {
		EAttribute check = TaskPackage.Literals.CHECKABLE__CHECKED;
		TableViewerColumn currentColumn = new TableViewerColumn(this,
				SWT.CENTER);
		currentColumn.getColumn().setWidth(30);
		currentColumn.getColumn().setMoveable(true);
		currentColumn.getColumn().setResizable(false);
		ColumnLabelProvider provider = new GenericColumnLabelProvider(this,
				check);
		currentColumn.setLabelProvider(provider);

		EditingSupport es = new CheckableEditingSupport(this);
		currentColumn.setEditingSupport(es);

		EAttribute name = ModelPackage.Literals.MODEL_ELEMENT__NAME;
		TableViewerColumn nameColumn = prepareStandardColumn(name, 250);
		nameColumn.getColumn().setAlignment(SWT.LEFT);

		EReference assignee = TaskPackage.Literals.WORK_ITEM__ASSIGNEE;
		TableViewerColumn assigneeColumn = prepareStandardColumn(assignee, 150);

		EAttribute creator = ModelPackage.Literals.MODEL_ELEMENT__CREATOR;
		TableViewerColumn creatorColumn = prepareStandardColumn(creator, 100);

		EAttribute creationDate = ModelPackage.Literals.MODEL_ELEMENT__CREATION_DATE;
		TableViewerColumn creationDateColumn = prepareStandardColumn(
				creationDate, 150);

		EReference container = TaskPackage.Literals.WORK_ITEM__CONTAINING_WORKPACKAGE;
		TableViewerColumn containerColumn = prepareStandardColumn(container,
				150);
	}

	private String getFeatureName(EStructuralFeature feature) {
		EStructuralFeature currentFeature = feature;
		String nameLookupString = "_UI_"
				+ ((EClass) currentFeature.eContainer()).getName() + "_"
				+ currentFeature.getName() + "_feature";
		return ModelEditPlugin.INSTANCE.getString(nameLookupString);
	}

	// public void setRestrictedToCurrentUser(){
	// ViewerFilter userFilter = new TaskViewFilter();
	// this.setFilters(filters)
	// }

	private TableViewerColumn prepareStandardColumn(
			EStructuralFeature currentFeature, int width) {
		TableViewerColumn currentColumn = new TableViewerColumn(this,
				SWT.CENTER);

		String name = getFeatureName(currentFeature);
		currentColumn.getColumn().setText(name);
		currentColumn.getColumn().setWidth(width);

		currentColumn.getColumn().setMoveable(true);
		currentColumn.getColumn().setResizable(true);

		ColumnLabelProvider provider = new GenericColumnLabelProvider(this,
				currentFeature);
		currentColumn.setLabelProvider(provider);

		ViewerComparator comp = new TableViewerColumnSorter(this,
				currentColumn, provider);
		currentColumn.getViewer().setComparator(comp);

		return currentColumn;
	}

}