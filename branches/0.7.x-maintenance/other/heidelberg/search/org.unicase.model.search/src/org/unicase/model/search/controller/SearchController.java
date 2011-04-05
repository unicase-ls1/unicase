package org.unicase.model.search.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.unicase.model.search.exceptions.SearchParameterException;
import org.unicase.model.search.exceptions.SearchParameterLoadException;
import org.unicase.model.search.exceptions.SearchParameterSaveException;
import org.unicase.model.search.helper.TableConditionsHelper;
import org.unicase.model.search.helper.TypeTreeHelper;
import org.unicase.model.search.model.Condition;
import org.unicase.model.search.model.SearchModel;
import org.unicase.model.search.model.SearchParameter;
import org.unicase.model.search.model.SearchParameterContainer;
import org.unicase.model.search.views.SearchView;
import org.unicase.model.search.views.contentprovider.TypesTreeContentProvider;
import org.unicase.model.search.views.editingsupport.ConditionEditingSupport;
import org.unicase.model.search.views.validator.DescriptionValidator;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

/**
 * The Controller for the SearchModel and the SearchView.
 * @author Markus Fischer
 *
 */
public class SearchController extends AdapterImpl implements Listener, ICheckStateListener {
	
	private SearchModel model = null;
	private SearchView view = null;
	private TypeTreeHelper treeHelper = null;
	
	/**
	 * Creates a new Search Controller.
	 * @param model the search model.
	 * @param view the search view.
	 */
	public SearchController(SearchModel model, SearchView view) {
		this.model = model;
		this.view = view;
		
		treeHelper = TypeTreeHelper.getInstance();
		
		Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		workspace.eAdapters().add(this);
	}

	/**
	 * Handles the events of the buttons of the search view. 
	 * {@inheritDoc}
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	@Override
	public void handleEvent(Event event) {
		if (event.widget == view.getBtnSearch() || (event.widget == view.getTxtSearch() && event.keyCode == SWT.CR)) {
			startSearch();
		} else if (event.widget == view.getBtnAddCondition()) {
			createSearchCondition();
		} else if (event.widget == view.getBtnRemoveCondition()) {
			IStructuredSelection selection = (IStructuredSelection) view.getTableViewerConditions().getSelection();
			removeSearchCondition(selection);
		} else if (event.widget == view.getBtnSaveQuery()) {
			saveQuery();
		} else if (event.widget == view.getBtnOpenQuery()) {
			loadQuery();
		} else if (event.widget == view.getBtnRemoveQuery()) {
			removeQuery();
		} else if (event.widget == view.getBtnNoTypes()) {
			deselectAllTypes();
		} else if (event.widget == view.getBtnAllTypes()) {
			selectAllTypes();
		} else if (event.widget == view.getBtnConditionsOnly()) {
			view.getTxtSearch().setEnabled(!view.getBtnConditionsOnly().getSelection());
		} else if (event.widget == view.getComboOrder()) {
			if (model.getSearchResult() != null) {
				if (model.getSearchParameter().isConditionsOnly()
					&& view.getComboOrder().getText().equals(SearchParameter.ORDER_RELEVANCE)) {
					return;
				}
				EList<EObject> result = model.orderBy(view.getComboOrder().getText(), 
					model.getSearchResult(), model.getSearchParameter().getSearchTerm());
				model.setSearchResult(result);
			}
		} else if (event.widget == view.getComboResults()) {
			if (model.getSearchResult() != null) {
				model.updatePager();
			}
		}
	}


	/**
	 * Checks the user selection for the active project.
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification msg) {
		if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
			model.updateProjectData();
		}
	}
	
	/**
	 * Handles the events of the CheckboxTreeViewer.
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ICheckStateListener#checkStateChanged(org.eclipse.jface.viewers.CheckStateChangedEvent)
	 */
	@Override
	public void checkStateChanged(CheckStateChangedEvent event) {
		view.getModelElementTreeViewer().setSubtreeChecked(event.getElement(), event.getChecked());

		if (event.getElement() instanceof EClass) {
			EClass tmpClass = (EClass) event.getElement();
			treeHelper.updateTreeClasses(tmpClass, view.getModelElementTreeViewer());
		}
		updateSearchConditions(false);
	}
	
	/**
	 * Starts a new search. This method checks if all needed parameters are given and calls the 
	 * search method of the model.
	 */
	private void startSearch() {
		try {
			final SearchParameter params = collectSearchParameter();
			model.checkSearchParameter(params);
			
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
		} catch (SearchParameterException sEx) {
			MessageDialog.openWarning(view.getParent().getShell(), "Parameter Exception", sEx.getMessage());
		}
	}

	/**
	 * Updates the conditions table for a new selection of valid types. This methods checks 
	 * if existing conditions are still valid and can also check the conditions of the model 
	 * if it is requested by the parameter.
	 * @param checkConditionModel checks the reference value of the conditions of the model if true
	 */
	private void updateSearchConditions(boolean checkConditionModel) {
		if (view.getTableViewerConditions() == null) {
			return;
		}
		List<EClass> types = TypeTreeHelper.getInstance().getSelectedTypes(view.getModelElementTreeViewer());
		boolean foundReferences = false;
		for (EClass eClass : types) {
			if (eClass.getEReferences().size() > 0) {
				foundReferences = true;
				break;
			}
		}
		
		if (foundReferences) {
			TableConditionsHelper.getInstance().updateFields(model, types, view.getConditionColumnFields(),
				ConditionEditingSupport.COLUMN_FIELD, view.getTableViewerConditions());
			if (checkConditionModel) {
				for (Condition condition : model.getConditions()) {
					condition.setReference(TableConditionsHelper.getInstance().getEReferenceByFieldName(condition.getField()));
				}
				view.getTableViewerConditions().setInput(model.getConditions());
			}
			view.getBtnAddCondition().setEnabled(true);
			view.getBtnRemoveCondition().setEnabled(model.getConditions().size() > 0);
		} else {
			model.getConditions().clear();
			view.getBtnAddCondition().setEnabled(false);
			view.getBtnRemoveCondition().setEnabled(false);
		}
			
		view.getTableViewerConditions().refresh();
		
	}
	
	/**
	 * Collects all the search parameter from the widgets of the search view.
	 * @return the collected search parameter 
	 */
	private SearchParameter collectSearchParameter() {
		SearchParameter params = new SearchParameter();
		if (!view.getBtnConditionsOnly().getSelection()) { 
			params.setSearchTerm(view.getTxtSearch().getText());
		}
		params.setMaxResults(Integer.valueOf(view.getComboResults().getText()));
		params.setOrderBy(view.getComboOrder().getText());
		params.setTypes(TypeTreeHelper.getInstance().getSelectedTypes(view.getModelElementTreeViewer()));
		
		params.setSearchConditions(model.getConditions());
		params.setConditionsOnly(view.getBtnConditionsOnly().getSelection());
		
		return params;
	}
	
	/**
	 * Saves the current search parameters to disk and requests a description for it.
	 */
	private void saveQuery() {
		try {
			SearchParameter params = collectSearchParameter();
			
			ArrayList<String> descriptions = new ArrayList<String>();
			SearchParameterContainer container = null;
			try {
				container = model.loadQueryData();
			} catch (SearchParameterLoadException ex) {
				// suppress cause we are saving
			}
			if (container == null) {
				container = new SearchParameterContainer(new ArrayList<SearchParameter>());
			}
			for (SearchParameter param : container.getParameters()) {
				descriptions.add(param.getDescription());
			}
			IInputValidator validator = new DescriptionValidator(descriptions);
			
			InputDialog dialog = new InputDialog(view.getParent().getShell(), "Enter Description",
				"Please enter a short description for this query", "", validator);
			if (dialog.open() == Window.CANCEL) {
				return;
			} else {
				params.setDescription(dialog.getValue());
			}
			container.getParameters().add(params);
			model.saveQueryData(container);
		} catch (SearchParameterSaveException ex) {
			MessageDialog.openError(view.getParent().getShell(), "Error Saving Query", ex.getMessage());
		}
	}
	
	/**
	 * Show the existing queries and loads the parameters. Also refreshes the widgets of the 
	 * search view.
	 */
	private void loadQuery() {
		SearchParameterContainer container = null;
		try {
			container = model.loadQueryData();
		} catch (SearchParameterLoadException ex) {
			MessageDialog.openWarning(view.getParent().getShell(), "Error Loading Queries", ex.getMessage());
			return;
		}
		
		ListDialog listDialog = new ListDialog(view.getParent().getShell());
		
		listDialog.setTitle("Queries");
		listDialog.setMessage("Select a query to load");
		listDialog.setContentProvider(ArrayContentProvider.getInstance());
		listDialog.setLabelProvider(new LabelProvider());
		List<String> descriptions = new ArrayList<String>();
		for (SearchParameter param : container.getParameters()) {
			descriptions.add(param.getDescription());
		}
		listDialog.setInput(descriptions);
		if (listDialog.open() == Dialog.CANCEL) {
			return;
		} else {
			Object[] result = listDialog.getResult();
			String selected = (String) result[0];
			
			for (SearchParameter param : container.getParameters()) {
				if (param.getDescription().equals(selected)) {
					view.getTxtSearch().setText(param.getSearchTerm());

					view.getComboOrder().select(view.getComboOrder().indexOf(param.getOrderBy()));
					view.getComboResults()
						.select(view.getComboResults().indexOf(String.valueOf(param.getMaxResults())));
					
					TypesTreeContentProvider provider = (TypesTreeContentProvider) view.getModelElementTreeViewer().getContentProvider();
					HashMap<String, EClass> eClasses = provider.getClassesMap();
					deselectAllTypes();
					for (String type : param.getStringTypes()) {
						if (eClasses.containsKey(type)) {
							view.getModelElementTreeViewer().setSubtreeChecked(eClasses.get(type), true);
							treeHelper.updateTreeClasses(eClasses.get(type), view.getModelElementTreeViewer());
						}
					}
					
					view.getBtnConditionsOnly().setSelection(param.isConditionsOnly());
					view.getBtnConditionsOnly().notifyListeners(SWT.Selection, null);
					
					model.setConditions(param.getSearchConditions());
					updateSearchConditions(true);
					return;
				}
			}
		}
	}
	
	/**
	 * Shows the existing queries and one can select one or multiple entries for removal.
	 */
	private void removeQuery() {
		try {
			SearchParameterContainer container = model.loadQueryData();
			List<String> descriptions = new ArrayList<String>();
			for (SearchParameter param : container.getParameters()) {
				descriptions.add(param.getDescription());
			}
			
			ListSelectionDialog listDialog = new ListSelectionDialog(view.getParent().getShell(), descriptions,
				ArrayContentProvider.getInstance(), new LabelProvider(), "Select queries to remove.");
			listDialog.setTitle("Queries");
			if (listDialog.open() == Dialog.CANCEL) {
				return;
			} else {
				Object[] result = listDialog.getResult();
				List<SearchParameter> toRemove = new ArrayList<SearchParameter>();
				for (Object res : result) {
					String selected = (String) res;
					for (SearchParameter searchParameter : container.getParameters()) {
						if (searchParameter.getDescription().equals(selected)) {
							toRemove.add(searchParameter);
							continue;
						}
					}
				}
				container.getParameters().removeAll(toRemove);
				
				model.saveQueryData(container);
			}
			
		} catch (SearchParameterLoadException ex) {
			MessageDialog.openWarning(view.getParent().getShell(), "Loading Queries", ex.getMessage());
			return;
		} catch (SearchParameterSaveException e) {
			MessageDialog.openWarning(view.getParent().getShell(), "Saving Queries", e.getMessage());
			return;
		}
	}
	
	/**
	 * Selects all model types.
	 */
	private void selectAllTypes() {
		TypesTreeContentProvider provider = (TypesTreeContentProvider) view.getModelElementTreeViewer().getContentProvider();
		for (EPackage ePackage : provider.getPackagesSet()) {
			view.getModelElementTreeViewer().setGrayed(ePackage, false);
			view.getModelElementTreeViewer().setSubtreeChecked(ePackage, true);
		}
		updateSearchConditions(false);
	}

	/**
	 * Deselects all model types.
	 */
	private void deselectAllTypes() {
		view.getModelElementTreeViewer().setCheckedElements(new Object[]{});
		updateSearchConditions(false);
	}
	
	/**
	 * Remove a Search Condition from the conditions table.
	 * @param selection Selection of the conditions table
	 */
	private void removeSearchCondition(IStructuredSelection selection) {
		if (selection != null) {
			model.getConditions().removeAll(selection.toList());
			view.getTableViewerConditions().refresh();
			view.getBtnRemoveCondition().setEnabled(model.getConditions().size() > 0);
		}
	}
	
	/**
	 * Creates a new Search Condition in the conditions table.
	 */
	private void createSearchCondition() {
		model.getConditions().add(new Condition());
		view.getTableViewerConditions().refresh();
		view.getBtnRemoveCondition().setEnabled(true);
	}

}
