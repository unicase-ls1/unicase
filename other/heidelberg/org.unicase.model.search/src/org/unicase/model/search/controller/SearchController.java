package org.unicase.model.search.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.unicase.model.search.helper.TypeTreeHelper;
import org.unicase.model.search.model.Condition;
import org.unicase.model.search.model.SearchModel;
import org.unicase.model.search.model.SearchParameter;
import org.unicase.model.search.views.SearchView;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

public class SearchController extends AdapterImpl implements Listener, ICheckStateListener {
	
	private SearchModel model = null;
	private SearchView view = null;
	
	public SearchController(SearchModel model, SearchView view) {
		this.model = model;
		this.view = view;
		
		Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		workspace.eAdapters().add(this);
	}

	// Listener Interface
	@Override
	public void handleEvent(Event event) {
		if (event.widget == view.getBtnSearch() || (event.widget == view.getTxtSearch() && event.keyCode == SWT.CR)) {
			startSearch();
		} else if (event.widget == view.getBtnAddCondition()) {
			view.getTableViewerConditions().add(new Condition());
		} else if (event.widget == view.getBtnRemoveCondition()) {
			// TODO: remove
		} 
	}

	// AdapterImpl
	@Override
	public void notifyChanged(Notification msg) {
		if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
			model.updateProjectData();
		}
	}
	
	private void startSearch() {
		final SearchParameter params = new SearchParameter();
		params.setSearchTerm(view.getTxtSearch().getText());
		params.setMaxResults(Integer.valueOf(view.getComboResults().getText()));
		params.setOrderBy(view.getComboOrder().getText());
		Object[] checked = view.getModelElementTreeViewer().getCheckedElements();
		ArrayList<EObject> checkedTypes = new ArrayList<EObject>();
		for (int i = 0; i < checked.length; i++) {
			if (!(checked[i] instanceof EPackage)) {
				checkedTypes.add((EObject) checked[i]); 
			}
		}
		if (checkedTypes.size() > 0) {
			params.setTypes(checkedTypes);
		}
		
		if (view.getTxtSearch().getText() == null || view.getTxtSearch().getText().length() == 0) {
			MessageDialog.openWarning(null, "Enter Text", "No search term defined!");
			model.resetSearchResult();
			return;
		}
		try {
			new ProgressMonitorDialog(view.getParent().getShell()).run(true, true, 
				new IRunnableWithProgress() {
					
					@Override
					public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
						final Collection<EObject> result = model.performQuery(params, monitor);
						view.getParent().getDisplay().asyncExec(new Runnable() {
							public void run() {
								model.setSearchResult(result);
							}
						});
					}
				}
			);
		} catch (InvocationTargetException iE) {
			MessageDialog.openError(view.getParent().getShell(), "Error", iE.getMessage());
			model.setSearchResult(null);
		} catch (InterruptedException iR) {
			model.setSearchResult(null);
		}
	}

	@Override
	public void checkStateChanged(CheckStateChangedEvent event) {
		// for CheckboxTreeViewer
		view.getModelElementTreeViewer().setSubtreeChecked(event.getElement(), event.getChecked());

		if (event.getElement() instanceof EPackage) {
			EPackage tmpPackage = (EPackage) event.getElement();
			TypeTreeHelper.getInstance().checkSubPackages(tmpPackage, event.getChecked(),
				view.getModelElementTreeViewer());
			TypeTreeHelper.getInstance().updateTreePackages(tmpPackage, view.getModelElementTreeViewer());
		} else if (event.getElement() instanceof EClass) {
			EClass tmpClass = (EClass) event.getElement();
			TypeTreeHelper.getInstance().updateTreeClasses(tmpClass, view.getModelElementTreeViewer());
			TypeTreeHelper.getInstance().updateTreePackages(tmpClass.getEPackage(), 
				view.getModelElementTreeViewer());
		}
	}
	
	

}
