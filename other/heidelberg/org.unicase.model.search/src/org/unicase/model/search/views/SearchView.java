package org.unicase.model.search.views;


import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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
import org.unicase.model.search.controller.SearchController;
import org.unicase.model.search.model.SearchModel;
import org.unicase.model.search.model.SearchParameter;
import org.unicase.model.search.views.contentprovider.ConditionContentProvider;
import org.unicase.model.search.views.editingsupport.ConditionEditingSupport;
import org.unicase.model.search.views.labelprovider.ConditionLabelProvider;
import org.unicase.model.search.widgets.SearchresultsContainer;
import org.unicase.ui.common.MEClassLabelProvider;
import org.unicase.ui.navigator.wizards.ModelTreeContentProvider;


/**
 * Vie for the unicase search
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
	
	private Label lblConditions = null;
	private Label lblTypes = null;
	private TableViewer tableViewerConditions = null;
	private Button btnAddCondition = null;
	private Button btnRemoveCondition = null;
	private CheckboxTreeViewer treeViewerTypes = null;
	
	private Composite compositeProject = null;
	private Label lblProject = null;
	
	private EClass selected;
	
	private SearchModel model = null;
	private SearchController controller = null;
	
	private ScrolledComposite scrolledComposite = null;
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
	
	public void init() {
		if (compositeProject == null) {
			createCompositeProject(this.parent);
		}
		if (mainComposite == null) {
			scrolledComposite = new ScrolledComposite(parent, SWT.V_SCROLL);
			scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			mainComposite = new Composite(scrolledComposite, SWT.NONE);
			mainComposite.setLayout(new GridLayout(1, true));
			scrolledComposite.setContent(mainComposite);
					
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

	public void updateScrolledSize() {
		Point sizeScrolled = mainComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		
		scrolledComposite.setMinWidth(sizeScrolled.x);
		scrolledComposite.setMinHeight(sizeScrolled.y);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		this.parent = parent;		
		parent.setLayout(new GridLayout(1, true));
		
		model.updateProjectData();
		
		if (model.isProjectSet()) {
			init();
		} else {
			createCompositeProject(parent);
		}	
	}
	
	private void createCompositeProject(Composite c) {
		compositeProject = new Composite(c, SWT.BORDER);
		compositeProject.setLayout(new GridLayout(1, false));
		compositeProject.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		lblProject = new Label(compositeProject, SWT.NONE);
		lblProject.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		lblProject.setText("Please select a project first!");
	}
	
	private void createCompositeSearch(Composite c) {
		GridData gridData = new GridData();
		gridData.horizontalSpan = 1;
		gridData.verticalAlignment = GridData.CENTER;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = SWT.FILL;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 9;
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
		lblResults = new Label(compositeSearch, SWT.NONE);
		lblResults.setText("results to show:");
		comboResults = new Combo(compositeSearch, SWT.READ_ONLY);
		comboResults.setItems(new String[] { "10", "25", "50" });
		comboResults.select(0);
	}
	
	private void createCompositeOptions(Composite c) {
		final ExpandBar bar = new ExpandBar(c, SWT.V_SCROLL);
		bar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.makeColumnsEqualWidth = false;
		compositeOptions = new Composite(bar, SWT.NONE);
		compositeOptions.setLayout(gridLayout);
		
		lblTypes = new Label(compositeOptions, SWT.LEFT);
		lblTypes.setText("Select type:");
		GridData txtDataType = new GridData();
		txtDataType.horizontalSpan = 1;
		txtDataType.verticalSpan = 1;
		txtDataType.horizontalAlignment = SWT.FILL;
		txtDataType.grabExcessHorizontalSpace = true;
		lblTypes.setLayoutData(txtDataType);
		
		lblConditions = new Label(compositeOptions, SWT.LEFT);
		lblConditions.setText("Set search conditions:");
		GridData txtDataConditions = new GridData();
		txtDataConditions.horizontalSpan = 2;
		txtDataConditions.verticalSpan = 1;
		txtDataConditions.horizontalAlignment = SWT.FILL;
		txtDataConditions.grabExcessHorizontalSpace = true;
		lblConditions.setLayoutData(txtDataConditions);
		
		createTreeTypes(compositeOptions);
		
		createTableConditions(compositeOptions);
		
		btnAddCondition = new Button(compositeOptions, SWT.NONE);
		btnAddCondition.setText("new condition");
		btnAddCondition.addListener(SWT.Selection, controller);
		btnRemoveCondition = new Button(compositeOptions, SWT.NONE);
		btnRemoveCondition.setText("remove condition");
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
	
	private void createTreeTypes(Composite c) {
		GridData data = new GridData();
		data.horizontalSpan = 1;
		data.verticalSpan = 2;
		data.heightHint = 140;
		data.widthHint = 225;
		data.horizontalAlignment = SWT.FILL;
		data.grabExcessHorizontalSpace = true;
		
		// TODO: add "all"
		treeViewerTypes = new CheckboxTreeViewer(c, SWT.BORDER);
		treeViewerTypes.getTree().setLayoutData(data);
		treeViewerTypes.setContentProvider(new ModelTreeContentProvider(selected));
		treeViewerTypes.setLabelProvider(new MEClassLabelProvider());
		// give an empty object, otherwise it does not initialize
		treeViewerTypes.setInput(new Object());
		
		treeViewerTypes.addCheckStateListener(controller);
		
	}
	
	private void createTableConditions(Composite c) {
		GridData data = new GridData();
		data.horizontalSpan = 1;
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
		int[] columnWidth = { 75, 170, 75, 150 };
		for (int i = 0; i < columnNames.length; i++) {
			column = new TableViewerColumn(tableViewerConditions, SWT.NONE);
			column.getColumn().setText(columnNames[i]);
			column.getColumn().setWidth(columnWidth[i]);
			column.setEditingSupport(new ConditionEditingSupport(tableViewerConditions, i));
		}
		
		Table table = tableViewerConditions.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tableViewerConditions.setContentProvider(new ConditionContentProvider());
		tableViewerConditions.setLabelProvider(new ConditionLabelProvider());
		
		tableViewerConditions.setInput(model.getConditions());	
	}
	
	private void createCompositeResults(Composite parent) {
		groupResults = new Group(parent, SWT.NONE);
		groupResults.setText("Search results");
		groupResults.setLayout(new GridLayout(1, true));
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.widthHint = parent.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
		groupResults.setLayoutData(data);
		
		Collection<EObject> result = model.getSearchResult();
		lblResultsStatus = new Label(groupResults, SWT.NONE);
		if (result.size() == 0) {
			lblResultsStatus.setText("No Elements found for search term: \"" + txtSearch.getText() + "\"");
		} else {
			lblResultsStatus.setText("Searched for \"" + txtSearch.getText() + "\" - Found " + result.size()
				+ " elements.");
			SearchresultsContainer resultsContainer = new SearchresultsContainer(groupResults, SWT.NONE, 
				Integer.valueOf(comboResults.getText()), result, txtSearch.getText(), this);
			resultsContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		}
		
		
	}

	@Override
	public void setFocus() {
		if (txtSearch != null) {
			txtSearch.setFocus();
		} else {
			this.parent.setFocus();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Integer updateReason = (Integer) arg;
		if (updateReason == model.UPDATE_PROJECT_SELECTION) {
			updateSelectedProject();	
		} else if (updateReason == model.UPDATE_RESULTS) {
			updateResults(false);
		} else if (updateReason == model.UPDATE_RESULTS_RESET) {
			updateResults(true);
		}
		
	}
	
	private void updateResults(boolean reset) {
		// clear results
		if (groupResults != null && !groupResults.isDisposed()) {
			groupResults.dispose();
		}
		
		if (!reset) {
			createCompositeResults(mainComposite);
		}
		updateScrolledSize();
		
		parent.layout();
		
	}

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
		} else if (selected != null) {
			if (initDone) {
				if (!mainComposite.isVisible()) {
					setSearchVisible(true);
				}
				lblProject.setText("selected project: " + model.getProjectSpace().getProjectName());
			} else {
				init();
			}
		}
	}

	private void setSearchVisible(boolean visible) {
		mainComposite.setVisible(visible);
		scrolledComposite.setVisible(visible);
	}

	public Button getBtnSearch() {
		return btnSearch;
	}

	public Text getTxtSearch() {
		return txtSearch;
	}

	public Combo getComboResults() {
		return comboResults;
	}
	
	public CheckboxTreeViewer getModelElementTreeViewer() {
		return treeViewerTypes;
	}
	
	public Composite getParent() {
		return parent;
	}

	public Button getBtnAddCondition() {
		return btnAddCondition;
	}

	public Button getBtnRemoveCondition() {
		return btnRemoveCondition;
	}

	public TableViewer getTableViewerConditions() {
		return tableViewerConditions;
	}

	public Combo getComboOrder() {
		return comboOrder;
	}
}