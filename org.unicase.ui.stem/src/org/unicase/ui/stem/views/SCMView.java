package org.unicase.ui.stem.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ui.stem.views.historybrowserview.HistoryComposite;

public abstract class SCMView extends ViewPart {

	protected TabItem browserTab;
	protected TabFolder tabFolder;
	protected Label lblCriteria;

	@Override
	public void createPartControl(Composite parent) {

		//view
		GridLayout gridLayout = new GridLayout();
		parent.setLayout(gridLayout);
		

		//toolBar
		Composite toolBar = new Composite(parent, SWT.BORDER);
		toolBar.setLayout(new GridLayout(2, false));
		toolBar.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
	
		
		//btnRefresh
		Button btnRefresh = new Button(toolBar, SWT.PUSH);
		btnRefresh.setLayoutData(new GridData());
		btnRefresh.setText("Refresh");
		btnRefresh.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				refreshClicked();
			}
			
		});
		
		lblCriteria = new Label(toolBar, SWT.NONE );
		lblCriteria.setLayoutData(new GridData());
		lblCriteria.setText("press refresh to be refreshed! :)");
		
		tabFolder = new TabFolder(parent, SWT.TOP);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		browserTab = new TabItem(tabFolder, SWT.NONE);
		browserTab.setControl(setBrowserTabControl());
				
		//tabItem queryTab
		TabItem queryTab = new TabItem(tabFolder, SWT.NONE);
		queryTab.setText("Query");
		queryTab.setControl(new QueryComosite(tabFolder, SWT.NONE));
		
		tabFolder.setSelection(1);

	}

	protected abstract Control setBrowserTabControl(); 
	

	protected abstract void refreshClicked();

	@Override
	public void setFocus() {
		

	}

}
