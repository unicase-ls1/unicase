/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.status.ui.viewers;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;

import org.unicase.metamodel.Project;
import org.unicase.model.ModelPackage;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.rap.ui.viewers.AbstractETableViewer;

/**
 * Viewer class for work-items.
 * 
 * @author Edgar Müller
 */
public class WorkItemsTableViewer extends AbstractETableViewer {

	/**
	 * The constructor.
	 * 
	 * @param composite Parent composite.
	 */
	public WorkItemsTableViewer(Composite composite) {
		super(composite);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init() {		
		super.init();
		GridData tableData = new GridData(SWT.FILL, SWT.FILL, true, true);
		tableData.horizontalSpan = 2;
		getTable().setLayoutData(tableData);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<EStructuralFeature> getFeaturesList() {
		ArrayList<EStructuralFeature> list = new ArrayList<EStructuralFeature>();
		list.add(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__STATE);
		list.add(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__NAME);
		list.add(TaskPackage.Literals.WORK_ITEM__ASSIGNEE);
		list.add(MetamodelPackage.Literals.MODEL_ELEMENT__CREATION_DATE);
		list.add(MetamodelPackage.Literals.MODEL_ELEMENT__CREATOR);
		list.add(TaskPackage.Literals.WORK_ITEM__CONTAINING_WORKPACKAGE);
		list.add(TaskPackage.Literals.WORK_ITEM__DUE_DATE);
		list.add(TaskPackage.Literals.WORK_ITEM__PRIORITY);
		
		return list;
	}
	
	/**
	 * 
	 * @param project Project.
	 */
	public void setInput(Project project) {
		final List<? extends Checkable> taskItems = project.getAllModelElementsbyClass(
			TaskPackage.eINSTANCE.getCheckable(), new BasicEList<Checkable>());

//		for (Iterator<? extends Checkable> iterator = taskItems.iterator(); iterator.hasNext();) {
//			Checkable item = iterator.next();
//			if (item instanceof ActionItem) {
//				if (((ActionItem) item).isDone()) {
//					iterator.remove();
//				}
//			} else if (item instanceof BugReport) {
//				if (((BugReport) item).isDone()) {
//					iterator.remove();
//				}
//			} else if (item instanceof Issue) {
//				if (((Issue) item).getSolution() != null) {
//					iterator.remove();
//				}
//			}
//		}

		final WritableList list = (WritableList) (this.getInput());
		if (list == null) {
			// the case of first time of input setting to table
			WritableList emfList = new WritableList(Realm.getDefault(), taskItems, UnicaseModelElement.class);
			this.setInput(emfList);
		} else {
			list.getRealm().asyncExec(new Runnable() {

				public void run() {
					// remove all elements
					list.retainAll(new BasicEList<UnicaseModelElement>());
					// adds new task items
					list.addAll(taskItems);
				}
			});
		}
	}


}


