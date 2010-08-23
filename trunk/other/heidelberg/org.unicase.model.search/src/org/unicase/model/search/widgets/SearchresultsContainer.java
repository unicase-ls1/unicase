package org.unicase.model.search.widgets;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.unicase.model.search.views.SearchView;

/**
 * Manages multiple SearchResultWidget objects and adds a pager.
 * @author Markus Fischer
 */
public class SearchresultsContainer extends Composite implements Listener {

	private EObject[] searchResults;
	private Composite compositePager;
	private Button btnPrev;
	private Button btnNext;
	private Label lblCurrent;
	private int resultsPerPage;
	private int pages;
	private int currentPage;
	private Composite compositeWidgets;
	private String searchTerm;
	private SearchView searchView;
	
	/**
	 * Creates a new search results container.
	 * @param parent the parent composite
	 * @param style style attributes
	 * @param resultsPerPage results per page setting
	 * @param searchResults Collection of search results
	 * @param searchTerm the search term
	 * @param view the search view
	 */
	public SearchresultsContainer(Composite parent, int style, int resultsPerPage, 
			Collection<EObject> searchResults, String searchTerm, SearchView view) {
		super(parent, style);
		this.setLayout(new GridLayout(1, true));
		
		this.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		
		this.searchResults = searchResults.toArray(new EObject[searchResults.size()]);
		this.resultsPerPage = resultsPerPage;
		if (searchResults.size() % resultsPerPage == 0) {
			this.pages = (int) (searchResults.size() / resultsPerPage);
		} else {
			this.pages = (int) (searchResults.size() / resultsPerPage) + 1;
		}
		
		this.currentPage = 1;
		this.searchTerm = searchTerm;
		this.searchView = view;
		
		init();
	}
	
	/**
	 * Initializes the pager and the SearchResultWidget objects.
	 */
	private void init() {
		compositePager = new Composite(this, SWT.CENTER);
		compositePager.setLayoutData(new GridData(SWT.CENTER, SWT.NONE, true, false));
		compositePager.setLayout(new GridLayout(3, true));
		
		btnPrev = new Button(compositePager, SWT.PUSH);
		btnPrev.addListener(SWT.Selection, this);
		btnPrev.setText("previous");
		lblCurrent = new Label(compositePager, SWT.NONE);
		btnNext = new Button(compositePager, SWT.PUSH);
		btnNext.addListener(SWT.Selection, this);
		btnNext.setText("next");		
		
		updatePager();
		
		createCompositeWidgets();
	}

	/**
	 * Creates the composite for the widgets.
	 */
	private void createCompositeWidgets() {
		compositeWidgets = new Composite(this, SWT.NONE);
		compositeWidgets.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		compositeWidgets.setLayout(new GridLayout(1, true));
		
		buildPage();
		
		searchView.updateScrolledSize();
		this.layout();
	}
	
	/**
	 * Updates the pager.
	 */
	private void updatePager() {
		btnPrev.setEnabled(currentPage > 1);
		lblCurrent.setText("Page " + currentPage + " of " + pages);
		btnNext.setEnabled(currentPage < pages);
	}
	
	/**
	 * Builds the current page.
	 */
	private void buildPage() {
		int startIndex = 0;
		int endIndex = 0;
		
		startIndex = (currentPage-1)*resultsPerPage;
		if (startIndex + resultsPerPage > searchResults.length) {
			endIndex = searchResults.length;
		} else {
			endIndex = startIndex + resultsPerPage; 
		}
		
		for (int i = startIndex; i < endIndex; i++) {
			SearchresultWidget resultWidget = new SearchresultWidget(compositeWidgets, 
				SWT.NONE, searchResults[i], searchTerm);
			resultWidget.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	@Override
	public void handleEvent(Event event) {
		boolean changed = false;
		if (event.widget == btnPrev) {
			currentPage -= 1;
			changed = true;
		} else if (event.widget == btnNext) {
			currentPage += 1;
			changed = true;
		}
		if (changed) {
			updatePager();
			compositeWidgets.dispose();
			createCompositeWidgets();
		}
	}
	
	

}
