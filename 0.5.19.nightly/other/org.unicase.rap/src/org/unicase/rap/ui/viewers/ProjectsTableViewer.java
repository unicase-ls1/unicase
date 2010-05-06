/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.ui.viewers;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;

import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspacePackage;

/**
 * Provides a table like overview of all available projects. 
 * TODO: currently only observes a single EMF store server
 * 
 * @author Edgar Müller, Fatih Ulusoy
 */
public class ProjectsTableViewer extends AbstractETableViewer implements SelectionListener {

	private List<SelectionListener> listeners;
	
	/**
	 * The constructor.
	 * 
	 * @param composite Composite
	 */
	public ProjectsTableViewer(Composite composite) {
		super(composite);	
		listeners = new ArrayList<SelectionListener>();
		getTable().addSelectionListener((SelectionListener) this);
	}
	
	/**
	 * 
	 * @param projectSpaces Project spaces that sets the project table.
	 */
	public void setInput(final List<ProjectSpace> projectSpaces) {
		
		final WritableList list = (WritableList) (super.getInput());
		if (list == null) {
			WritableList emfList = new WritableList(Realm.getDefault(), projectSpaces, ProjectSpace.class);
			super.setInput(emfList);
			super.refresh();
		} else {
			final List<ProjectSpace> mylist = projectSpaces;
			final ProjectsTableViewer myThis = this;
			list.getRealm().asyncExec(new Runnable() {

				public void run() {
					// remove all elements
					list.retainAll(new BasicEList<UnicaseModelElement>());
					// adds new task items
					list.addAll(mylist);
					myThis.refresh();
				}
			});
		}
		
		
	}

	/**
	 * 
	 * @param part WorkbenchPart
	 * @param selection Selection.
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {

	}

	/**
	 * 
	 * @param e Selection event
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		System.out.println("ProjectListView: " + e.data.toString());
	}

	/**
	 * 
	 * @param e Selection event
	 */
	public void widgetSelected(SelectionEvent e) {
		System.out.println("ProjectListView: " + e.item.getData().toString());	
		for (SelectionListener l : listeners) {
			l.widgetSelected(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<EStructuralFeature> getFeaturesList() {
		ArrayList<EStructuralFeature> list = new ArrayList<EStructuralFeature>();
		list.add(WorkspacePackage.Literals.PROJECT_SPACE__PROJECT_NAME);
		return list;
	}
	
	/**
	 * 
	 * @param listener Selection listener on project table.
	 */
	public void addSelectionListener(SelectionListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * 
	 * @param listener Selection listener on project table.
	 */
	public void removeSelectionListener(SelectionListener listener) {
		listeners.remove(listener);
	}
}
