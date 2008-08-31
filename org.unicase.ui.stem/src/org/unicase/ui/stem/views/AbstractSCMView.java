/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
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

/**.
 * 
 * This is the abstract SCMView. History Browser and Change Browser inherit 
 * this view. It contains two tabs, QueryTab and BrowserTab. The Query tab
 * is common for both History Browser and Change Browser. The broswer tab
 * will be set by inheriting classes using the abstract method setBrowserTabContor().
 * This view also contains a Refresh bar at top part. Refresh bar has a
 * refresh button and a Label which shows the criteria selected in Query tab.
 * 
 * @author Hodaie
 *
 */
public abstract class AbstractSCMView extends ViewPart {

	//I don't know why does CheckStyle complain about 
	//protected member variables. I don't want to change them 
	//in private variables and use a getter instead. 
	
	/**.
	 * This is the bowser tab whose contents are set by inheriting classes
	 */
	protected TabItem browserTab;
	/**.
	 * Reference to tabFolder will be used in inheriting classes as parent of
	 * browser tab content. 
	 */
	protected TabFolder tabFolder;
	
	protected Label lblCriteria;
	
	protected QueryComosite queryComposite;

	/**.
	 * {@inheritDoc}
	 */
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
		lblCriteria.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
		lblCriteria.setText("press refresh to be refreshed! :)");
		
		tabFolder = new TabFolder(parent, SWT.TOP);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		//tabItem browserTab
		browserTab = new TabItem(tabFolder, SWT.NONE);
		browserTab.setControl(setBrowserTabControl());
				
		//tabItem queryTab
		TabItem queryTab = new TabItem(tabFolder, SWT.NONE);
		queryTab.setText("Query");
		this.queryComposite = new QueryComosite(tabFolder, SWT.NONE);
		queryTab.setControl(queryComposite);
						
		//tabFolder.setSelection(1);

	}

	/**.
	 * This method will be implemented by inheriting classes to set the 
	 * contents of browser tab. 
	 * @return contents of browser tab
	 */
	protected abstract Control setBrowserTabControl(); 
	

	/**.
	 * This will be implemented by inheriting classes to update the 
	 * information shown on browser tab based on criteria selected in 
	 * Query tab.
	 */
	protected abstract void refreshClicked();

	
	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
	
	}

}
