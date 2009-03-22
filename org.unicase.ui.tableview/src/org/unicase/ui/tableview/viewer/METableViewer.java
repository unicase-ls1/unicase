/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.viewer;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.ui.tableview.labelproviders.AbstractCheckboxColumnLabelProvider;
import org.unicase.ui.tableview.labelproviders.DateColumnLabelProvider;
import org.unicase.ui.tableview.labelproviders.GenericColumnLabelProvider;
import org.unicase.ui.tableview.labelproviders.StatusLabelProvider;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

/**
 * A tableviewer for modelelements.
 * 
 * @author schneidf
 */
public class METableViewer extends TableViewer {
	private final Workspace workspace;

	/**
	 * remove adapter. {@inheritDoc}
	 */
	@Override
	protected void handleDispose(DisposeEvent event) {
		workspace.eAdapters().remove(adapterImpl);
		super.handleDispose(event);
	}

	private Project currentProject;
	private AdapterImpl adapterImpl;

	/**
	 * Standard constructor.
	 * 
	 * @param parent the parent control
	 */
	public METableViewer(Composite parent) {
		super(parent, SWT.FULL_SELECTION);
		// this.adapterFactory = adapterFactory;
		this.setContentProvider(new IStructuredContentProvider() {

			private Project project;

			public Object[] getElements(Object inputElement) {
				if (project != null) {
					List<Checkable> checkables = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE
						.getCheckable(), new BasicEList<Checkable>());
					return checkables.toArray();
				}
				return new Object[0];
			}

			public void dispose() {

			}

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

				if (newInput instanceof Project) {
					this.project = (Project) newInput;
				}
			}

		});

		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		adapterImpl = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					ProjectSpace activeProjectSpace = workspace.getActiveProjectSpace();
					if (activeProjectSpace != null) {
						currentProject = activeProjectSpace.getProject();
						setInput(currentProject);
					}

				}
				super.notifyChanged(msg);
			}
		};
		workspace.eAdapters().add(adapterImpl);

		this.createColumns();
		this.getTable().setLinesVisible(true);
		this.getTable().setHeaderVisible(true);

		// if viewer input is set before columns are created, sometime checkbox images are not shown (or created?)
		// correctly (see GenericColumnLabelProvider for checkbox images)
		if (workspace.getActiveProjectSpace() != null) {
			setInput(workspace.getActiveProjectSpace().getProject());
		}

	}

	private void createColumns() {
		EAttribute check = TaskPackage.Literals.CHECKABLE__CHECKED;
		TableViewerColumn currentColumn = new TableViewerColumn(this, SWT.CENTER);
		currentColumn.getColumn().setWidth(30);
		currentColumn.getColumn().setMoveable(true);
		currentColumn.getColumn().setResizable(false);
		ColumnLabelProvider provider = new AbstractCheckboxColumnLabelProvider() {

			@Override
			public Image getImage(Object element) {
				Image image = null;
				if (element instanceof Checkable) {
					Checkable checkable = (Checkable) element;
					if (checkable.isChecked()) {
						image = JFaceResources.getImage(AbstractCheckboxColumnLabelProvider.CHECKED);
					} else {
						image = JFaceResources.getImage(AbstractCheckboxColumnLabelProvider.UNCHECK);
					}

				}
				return image;
			}

		};
		currentColumn.setLabelProvider(provider);

		EditingSupport es = new CheckableEditingSupport(this, null);
		currentColumn.setEditingSupport(es);

		TableViewerColumn state = new TableViewerColumn(this, SWT.NONE);
		state.getColumn().setWidth(20);
		state.setLabelProvider(new StatusLabelProvider());
		state.getColumn().setText("State");

		EAttribute name = ModelPackage.Literals.MODEL_ELEMENT__NAME;
		TableViewerColumn nameColumn = prepareStandardColumn(name, 250);
		nameColumn.getColumn().setAlignment(SWT.LEFT);

		EReference assignee = TaskPackage.Literals.WORK_ITEM__ASSIGNEE;
		prepareStandardColumn(assignee, 150);

		EAttribute creator = ModelPackage.Literals.MODEL_ELEMENT__CREATOR;
		prepareStandardColumn(creator, 100);

		EAttribute creationDate = ModelPackage.Literals.MODEL_ELEMENT__CREATION_DATE;
		prepareStandardColumn(creationDate, 150);

		EReference container = TaskPackage.Literals.WORK_ITEM__CONTAINING_WORKPACKAGE;
		prepareStandardColumn(container, 150);

		EAttribute dueDate = TaskPackage.Literals.WORK_ITEM__DUE_DATE;
		prepareStandardColumn(dueDate, 150);

		EAttribute priority = TaskPackage.Literals.WORK_ITEM__PRIORITY;
		prepareStandardColumn(priority, 50);

	}

	private String getFeatureName(EStructuralFeature feature) {
		EStructuralFeature currentFeature = feature;
		String nameLookupString = "_UI_" + ((EClass) currentFeature.eContainer()).getName() + "_"
			+ currentFeature.getName() + "_feature";
		return ModelEditPlugin.INSTANCE.getString(nameLookupString);
	}

	private TableViewerColumn prepareStandardColumn(EStructuralFeature currentFeature, int width) {
		TableViewerColumn currentColumn = new TableViewerColumn(this, SWT.CENTER);

		String name = getFeatureName(currentFeature);
		currentColumn.getColumn().setText(name);
		currentColumn.getColumn().setWidth(width);

		currentColumn.getColumn().setMoveable(true);
		currentColumn.getColumn().setResizable(true);
		ColumnLabelProvider provider;
		if (currentFeature.getEType().equals(EcorePackage.Literals.EDATE)) {
			provider = new DateColumnLabelProvider(currentFeature);
		} else {
			provider = new GenericColumnLabelProvider(currentFeature);
		}
		currentColumn.setLabelProvider(provider);

		ViewerComparator comp = new TableViewerColumnSorter(this, currentColumn, provider);
		currentColumn.getViewer().setComparator(comp);

		return currentColumn;
	}

}