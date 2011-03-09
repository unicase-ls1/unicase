package org.unicase.model.search.views;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ExpandAdapter;
import org.eclipse.swt.events.ExpandEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.search.Activator;
import org.unicase.model.search.controller.SearchController;
import org.unicase.model.search.helper.TableConditionsHelper;
import org.unicase.model.search.model.SearchModel;
import org.unicase.model.search.model.SearchParameter;
import org.unicase.model.search.views.contentprovider.ConditionContentProvider;
import org.unicase.model.search.views.contentprovider.TypesTreeContentProvider;
import org.unicase.model.search.views.editingsupport.ConditionEditingSupport;
import org.unicase.model.search.views.labelprovider.ConditionLabelProvider;
import org.unicase.model.search.widgets.SearchresultsContainer;
import org.unicase.ui.common.MEClassLabelProvider;


/**
 * View for the unicase search
 * @author Markus Fischer
 */
public class SearchView extends ViewPart implements Observer {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.unicase.model.search.views.SearchView";

	private Composite compositeSearch = null;
	private Label lblSearch = null;
	private Text txtSearch = null;
	private Button btnSearch = null;
	private Composite compositeOptions = null;
	private Label lblOrder = null;
	private Combo comboOrder = null;
	private Label lblResults = null;
	private Combo comboResults = null;
	private Button btnOpenQuery = null;
	private Button btnSaveQuery = null;
	private Button btnRemoveQuery = null;
	private Button btnAllTypes = null;
	private Button btnNoTypes = null;
	
	private Label lblConditions = null;
	private Button btnConditionsOnly = null;
	private Label lblTypes = null;
	private TableViewer tableViewerConditions = null;
	private TableViewerColumn conditionColumnFields = null;

	private Button btnAddCondition = null;
	private Button btnRemoveCondition = null;
	private CheckboxTreeViewer treeViewerTypes = null;
	
	private Composite compositeProject = null;
	private Label lblProject = null;
	
	private EClass selected;
	
	private SearchModel model = null;
	private SearchController controller = null;
	
	private ScrolledComposite compositeResults = null;
	private Composite mainComposite = null;
	private Group groupResults = null;
	private Label lblResultsStatus = null;

	private Composite parent = null;
	
	private boolean initDone = false;

	/**
	 * The constructor.
	 */
	public SearchView() {
		this.model = new SearchModel();
		this.model.addObserver(this);
		this.controller = new SearchController(model, this);
	}
	
	/**
	 * Initializes the view
	 */
	private void init() {
		if (compositeProject == null) {
			createCompositeProject(this.parent);
		}
		if (mainComposite == null) {
			mainComposite = new Composite(parent, SWT.NONE);
			mainComposite.setLayout(new GridLayout(1, true));
			
			mainComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
					
			lblProject.setText("selected project: " + model.getProjectSpace().getProjectName());
			createCompositeSearch(mainComposite);
			compositeSearch.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
			createCompositeOptions(mainComposite);
			compositeOptions.setLayoutData(new GridData(SWT.LEFT, SWT.LEFT, true, false));
			
			updateScrolledSize();
			
			parent.layout();
			setFocus();
		}
		initDone = true;
	}

	/**
	 * Updates the scroll size of the view.
	 */
	public void updateScrolledSize() {
		if (groupResults != null && !groupResults.isDisposed()) {
			Point sizeGroup = groupResults.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			Point sizeProject = compositeProject.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			if (compositeResults != null && !compositeResults.isDisposed()) {
				compositeResults.setMinWidth(sizeProject.x);
				compositeResults.setMinHeight(sizeGroup.y);
				compositeResults.setExpandHorizontal(true);
				compositeResults.setExpandVertical(true);
				
				GridData data = (GridData) compositeResults.getLayoutData();
				data.widthHint = sizeProject.x;
				data.heightHint = sizeGroup.y;
				compositeResults.setLayoutData(data);
			}
		}
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 * @param parent the parent composite
	 */
	public void createPartControl(Composite parent) {
		this.parent = parent;		
		parent.setLayout(new GridLayout(1, true));
		
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		
		model.updateProjectData();
		
		if (model.isProjectSet()) {
			init();
		} else {
			createCompositeProject(parent);
		}	
	}
	
	/**
	 * Creates the project composite
	 * @param c the parent composite
	 */
	private void createCompositeProject(Composite c) {
		compositeProject = new Composite(c, SWT.BORDER);
		compositeProject.setLayout(new GridLayout(1, false));
		compositeProject.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		lblProject = new Label(compositeProject, SWT.NONE);
		lblProject.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		lblProject.setText("Please select a project first!");
	}
	
	/**
	 * Creates the search composite
	 * @param c the parent composite
	 */
	private void createCompositeSearch(Composite c) {
		GridData gridData = new GridData();
		gridData.horizontalSpan = 1;
		gridData.verticalAlignment = GridData.CENTER;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = SWT.FILL;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 12;
		gridLayout.makeColumnsEqualWidth = false;
		gridLayout.horizontalSpacing = 3;
		gridLayout.marginLeft = 5;
		gridLayout.marginRight = 5;
		compositeSearch = new Composite(c, SWT.NONE);
		compositeSearch.setLayout(gridLayout);
		lblSearch = new Label(compositeSearch, SWT.NONE);
		lblSearch.setText("Search:");
		txtSearch = new Text(compositeSearch, SWT.SEARCH | SWT.ICON_CANCEL);
		txtSearch.setLayoutData(gridData);
		txtSearch.addListener(SWT.KeyDown, controller);
		btnSearch = new Button(compositeSearch, SWT.NONE);
		btnSearch.setText("start search");
		btnSearch.addListener(SWT.Selection, controller);
		
		lblOrder = new Label(compositeSearch, SWT.NONE);
		lblOrder.setText("order by:");
		comboOrder = new Combo(compositeSearch, SWT.READ_ONLY);
		comboOrder.setItems(new String[] { SearchParameter.ORDER_RELEVANCE, SearchParameter.ORDER_TYPE, 
			SearchParameter.ORDER_DATE_NEW, SearchParameter.ORDER_DATE_OLD });
		comboOrder.select(0);
		comboOrder.addListener(SWT.Selection, controller);
		
		lblResults = new Label(compositeSearch, SWT.NONE);
		lblResults.setText("results per page:");
		comboResults = new Combo(compositeSearch, SWT.READ_ONLY);
		comboResults.setItems(new String[] { "10", "25", "50" });
		comboResults.select(0);
		comboResults.addListener(SWT.Selection, controller);
		
		btnOpenQuery = new Button(compositeSearch, SWT.NONE);
		btnOpenQuery.setImage(Activator.getImageDescriptor("icons/fldr_obj_16x16.gif").createImage());
		btnOpenQuery.setToolTipText("Load saved query");
		btnOpenQuery.addListener(SWT.Selection, controller);
		btnSaveQuery = new Button(compositeSearch, SWT.NONE);
		btnSaveQuery.setImage(Activator.getImageDescriptor("icons/save_edit_16x16.gif").createImage());
		btnSaveQuery.setToolTipText("Save query");
		btnSaveQuery.addListener(SWT.Selection, controller);
		btnRemoveQuery = new Button(compositeSearch, SWT.NONE);
		btnRemoveQuery.setImage(Activator.getImageDescriptor("icons/delete_16x16.gif").createImage());
		btnRemoveQuery.setToolTipText("Remove saved queries");
		btnRemoveQuery.addListener(SWT.Selection, controller);
	}
	
	/**
	 * Creates the options composite
	 * @param c the parent composite
	 */
	private void createCompositeOptions(Composite c) {
		final ExpandBar bar = new ExpandBar(c, SWT.V_SCROLL);
		bar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 5;
		gridLayout.makeColumnsEqualWidth = false;
		compositeOptions = new Composite(bar, SWT.NONE);
		compositeOptions.setLayout(gridLayout);
		
		lblTypes = new Label(compositeOptions, SWT.LEFT);
		lblTypes.setText("Select type:");
		GridData txtDataType = new GridData();
		txtDataType.horizontalSpan = 2;
		txtDataType.verticalSpan = 1;
		txtDataType.horizontalAlignment = SWT.FILL;
		txtDataType.grabExcessHorizontalSpace = true;
		lblTypes.setLayoutData(txtDataType);
		
		lblConditions = new Label(compositeOptions, SWT.LEFT);
		lblConditions.setText("Set search conditions:");
		GridData txtDataConditions = new GridData();
		txtDataConditions.horizontalSpan = 1;
		txtDataConditions.verticalSpan = 1;
		txtDataConditions.horizontalAlignment = SWT.FILL;
		txtDataConditions.grabExcessHorizontalSpace = false;
		lblConditions.setLayoutData(txtDataConditions);
		
		btnConditionsOnly = new Button(compositeOptions, SWT.CHECK);
		btnConditionsOnly.setText("Use conditions only");
		btnConditionsOnly.addListener(SWT.Selection, controller);
		btnConditionsOnly.setLayoutData(new GridData(SWT.RIGHT, SWT.NONE, true, false, 2, 1));
		
		btnAllTypes = new Button(compositeOptions, SWT.NONE);
		btnAllTypes.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));
		btnAllTypes.addListener(SWT.Selection, controller);
		btnAllTypes.setImage(Activator.getImageDescriptor("icons/id_selector_16x16.gif").createImage());
		btnAllTypes.setToolTipText("Select all types");
		
		createTreeTypes(compositeOptions);
		
		createTableConditions(compositeOptions);
		
		btnAddCondition = new Button(compositeOptions, SWT.NONE);
		btnAddCondition.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));
		btnAddCondition.setImage(Activator.getImageDescriptor("icons/new_untitled_text_file_16x16.gif").createImage());
		btnAddCondition.setToolTipText("Add Conidition");
		btnAddCondition.addListener(SWT.Selection, controller);
		
		btnNoTypes = new Button(compositeOptions, SWT.NONE);
		btnNoTypes.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, true));
		btnNoTypes.addListener(SWT.Selection, controller);
		btnNoTypes.setImage(Activator.getImageDescriptor("icons/disabled_co_16x16.gif").createImage());
		btnNoTypes.setToolTipText("Deselect all types");
		
		btnRemoveCondition = new Button(compositeOptions, SWT.NONE);
		btnRemoveCondition.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, true));
		btnRemoveCondition.setImage(Activator.getImageDescriptor("icons/delete_16x16.gif").createImage());
		btnRemoveCondition.setToolTipText("Remove selected condition");
		btnRemoveCondition.setEnabled(false);
		btnRemoveCondition.addListener(SWT.Selection, controller);
		
		ExpandItem item = new ExpandItem(bar, SWT.NONE, 0);
		item.setText("advanced search options");
		item.setHeight(compositeOptions.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		item.setControl(compositeOptions);
		item.setExpanded(false);
		
		bar.addExpandListener(new ExpandAdapter(){
			 
	        @Override
	        public void itemCollapsed(ExpandEvent e) {
	        	Display.getCurrent().asyncExec(new Runnable(){
	        		public void run() {
	        			updateScrolledSize();
	        			bar.getParent().layout();
	                }
	            });
	        }
	 
	        @Override
	        public void itemExpanded(ExpandEvent e) {
	        	Display.getCurrent().asyncExec(new Runnable(){
	        		public void run() {
	        			updateScrolledSize();
	        			bar.getParent().layout();
	        		}
	        	});
	        }
		});
	}
	
	/**
	 * Creates the tree for the types.
	 * @param c the parent composite
	 */
	private void createTreeTypes(Composite c) {
		GridData data = new GridData();
		data.horizontalSpan = 1;
		data.verticalSpan = 2;
		data.heightHint = 140;
		data.widthHint = 225;
		data.horizontalAlignment = SWT.FILL;
		data.grabExcessHorizontalSpace = true;
		
		treeViewerTypes = new CheckboxTreeViewer(c, SWT.BORDER);
		treeViewerTypes.getTree().setLayoutData(data);
		treeViewerTypes.setContentProvider(new TypesTreeContentProvider());
		treeViewerTypes.setLabelProvider(new MEClassLabelProvider());
		// give an empty object, otherwise it does not initialize
		treeViewerTypes.setInput(new Object());
		
		treeViewerTypes.addCheckStateListener(controller);
		
		// select all!
		btnAllTypes.notifyListeners(SWT.Selection, null);
	}
	
	/**
	 * Creates the table for the conditions.
	 * @param c the parent composite
	 */
	@SuppressWarnings("unchecked")
	private void createTableConditions(Composite c) {
		GridData data = new GridData();
		data.horizontalSpan = 2;
		data.verticalSpan = 2;
		data.heightHint = 140;
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		
		tableViewerConditions = new TableViewer(c, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		tableViewerConditions.getTable().setLayoutData(data);
		TableViewerColumn column = null;
		String[] columnNames = new String[] { "condition", "field", "operator", "value" }; 
		int[] columnWidth = { 75, 340, 100, 100 };
		
		Object[] checked = treeViewerTypes.getCheckedElements();
		Collection<EClass> checkedTypes = new ArrayList<EClass>();
		for (int i = 0; i < checked.length; i++) {
			if (!(checked[i] instanceof EPackage)) {
				checkedTypes.add((EClass) checked[i]); 
			}
		}
		
		for (int i = 0; i < columnNames.length; i++) {
			column = new TableViewerColumn(tableViewerConditions, SWT.NONE);
			column.getColumn().setText(columnNames[i]);
			column.getColumn().setWidth(columnWidth[i]);
			
			List<String> fields = null;
			HashMap<String, EReference> fieldsAndReferences = null;
			if (i == ConditionEditingSupport.COLUMN_FIELD) {
				List<Object> result = TableConditionsHelper.getInstance().initializeFields(checkedTypes);
				fields = (List<String>) result.get(0);
				fieldsAndReferences = (HashMap<String, EReference>) result.get(1);
				conditionColumnFields = column;
			}
			ConditionEditingSupport editingSupport = new ConditionEditingSupport(tableViewerConditions, i, 
				fields,	fieldsAndReferences, model);
			column.setEditingSupport(editingSupport);
		}
		
		Table table = tableViewerConditions.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tableViewerConditions.setContentProvider(new ConditionContentProvider());
		tableViewerConditions.setLabelProvider(new ConditionLabelProvider());
		
		tableViewerConditions.setInput(model.getConditions());	
	}
	
	/**
	 * Creates the result composite
	 * @param parent the parent composite
	 */
	private void createCompositeResults(Composite parent) {
		compositeResults = new ScrolledComposite(parent, SWT.V_SCROLL | SWT.H_SCROLL);
		compositeResults.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
		groupResults = new Group(compositeResults, SWT.NONE);
		groupResults.setText("Search results");
		groupResults.setLayout(new GridLayout(1, true));
		GridData data = new GridData(SWT.FILL, SWT.NONE, false, false);
		groupResults.setLayoutData(data);
		
		compositeResults.setContent(groupResults);
		
		Collection<EObject> result = model.getSearchResult();
		lblResultsStatus = new Label(groupResults, SWT.NONE);
		if (result.size() == 0) {
			lblResultsStatus.setText("No Elements found.");
		} else {
			lblResultsStatus.setText("Found " + result.size() + " elements.");
			SearchresultsContainer resultsContainer = new SearchresultsContainer(groupResults, SWT.NONE, 
				Integer.valueOf(comboResults.getText()), result, model.getSearchParameter().getSearchTerm(), this);
			resultsContainer.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		}
		
		
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		if (txtSearch != null) {
			txtSearch.setFocus();
		} else {
			this.parent.setFocus();
		}
	}

	/**
	 * Observes the selected project and the search results stored in the model.
	 * {@inheritDoc}
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		Integer updateReason = (Integer) arg;
		if (updateReason == SearchModel.UPDATE_PROJECT_SELECTION) {
			updateSelectedProject();	
		} else if (updateReason == SearchModel.UPDATE_RESULTS) {
			updateResults(false);
		} else if (updateReason == SearchModel.UPDATE_RESULTS_RESET) {
			updateResults(true);
		}
		
	}
	
	/**
	 * Updates the results composite.
	 * @param reset if true the update is because of a result reset
	 */
	private void updateResults(boolean reset) {
		// clear results
		if (compositeResults != null && !compositeResults.isDisposed()) {
			compositeResults.dispose();
		}
		if (groupResults != null && !groupResults.isDisposed()) {
			groupResults.dispose();
		}
		
		if (!reset) {
			createCompositeResults(mainComposite);
		}
		updateScrolledSize();
		
		mainComposite.layout();
	}

	/**
	 * Updates the selected project.
	 */
	private void updateSelectedProject() {
		this.selected = null;
		// refresh selected project
		if (model.getProjectSpace() != null) {
			this.selected = model.getProjectSpace().eClass();
		}
		if (selected == null && initDone) {
			// no project set
			setSearchVisible(false);
			lblProject.setText("Please select a project first!");
			updateResults(true);
		} else if (selected != null) {
			if (initDone) {
				if (!mainComposite.isDisposed() && !mainComposite.isVisible()) {
					setSearchVisible(true);
				}
				lblProject.setText("selected project: " + model.getProjectSpace().getProjectName());
			} else {
				init();
			}
		}
	}

	/**
	 * Sets the search visible if parameter true. Search is not visible if no project is selected.
	 * @param visible 
	 */
	private void setSearchVisible(boolean visible) {
		mainComposite.setVisible(visible);
	}

	/**
	 * @return the button start search
	 */
	public Button getBtnSearch() {
		return btnSearch;
	}

	/**
	 * @return the search text field
	 */
	public Text getTxtSearch() {
		return txtSearch;
	}

	/**
	 * @return the combobox for the setting maximum results per page
	 */
	public Combo getComboResults() {
		return comboResults;
	}
	
	/**
	 * @return the tree for the types
	 */
	public CheckboxTreeViewer getModelElementTreeViewer() {
		return treeViewerTypes;
	}
	
	/**
	 * @return the parent of the search view
	 */
	public Composite getParent() {
		return parent;
	}

	/**
	 * @return the button add condition
	 */
	public Button getBtnAddCondition() {
		return btnAddCondition;
	}

	/**
	 * @return the button remove condition
	 */
	public Button getBtnRemoveCondition() {
		return btnRemoveCondition;
	}

	/**
	 * @return the condition table
	 */
	public TableViewer getTableViewerConditions() {
		return tableViewerConditions;
	}

	/**
	 * @return the combobox for the order by setting
	 */
	public Combo getComboOrder() {
		return comboOrder;
	}

	/**
	 * @return the button for loading a saved query
	 */
	public Button getBtnOpenQuery() {
		return btnOpenQuery;
	}

	/**
	 * @return the button save query
	 */
	public Button getBtnSaveQuery() {
		return btnSaveQuery;
	}
	
	/**
	 * @return the button remove query
	 */
	public Button getBtnRemoveQuery() {
		return btnRemoveQuery;
	}

	/**
	 * @return the button select all types
	 */
	public Button getBtnAllTypes() {
		return btnAllTypes;
	}

	/**
	 * @return the button deselect all types
	 */
	public Button getBtnNoTypes() {
		return btnNoTypes;
	}

	/**
	 * @return the TableViewerColumn object for the field column of the conditions table
	 */
	public TableViewerColumn getConditionColumnFields() {
		return conditionColumnFields;
	}

	/**
	 * @return the button use conditions only
	 */
	public Button getBtnConditionsOnly() {
		return btnConditionsOnly;
	}
}