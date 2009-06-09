/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.part.ViewPart;

/**
 * This is the abstract SCMView. History Browser and Change Browser inherit this view. It contains two tabs, QueryTab
 * and BrowserTab. The Query tab is common for both History Browser and Change Browser. The broswer tab will be set by
 * inheriting classes using the abstract method setBrowserTabContor(). This view also contains a Refresh bar at top
 * part. Refresh bar has a refresh button and a Label which shows the criteria selected in Query tab.
 * 
 * @author Hodaie
 */
public abstract class AbstractSCMView extends ViewPart {

	private TabItem browserTab;

	private TabFolder tabFolder;

	private Label lblCriteria;

	private QueryComposite queryComposite;

	/**
	 * Get the bowser tab whose contents are set by inheriting classes.
	 * 
	 * @return the browserTab
	 */
	protected TabItem getBrowserTab() {
		return browserTab;
	}

	/**
	 * Set the bowser tab whose contents are set by inheriting classes.
	 * 
	 * @param browserTab the browserTab to set
	 */
	protected void setBrowserTab(TabItem browserTab) {
		this.browserTab = browserTab;
	}

	/**
	 * Get the tabFolder; will be used in inheriting classes as parent of browser tab content.
	 * 
	 * @return the tabFolder
	 */
	protected TabFolder getTabFolder() {
		return tabFolder;
	}

	/**
	 * Set the tabFolder; will be used in inheriting classes as parent of browser tab content.
	 * 
	 * @param tabFolder the tabFolder to set
	 */
	protected void setTabFolder(TabFolder tabFolder) {
		this.tabFolder = tabFolder;
	}

	/**
	 * @return the lblCriteria
	 */
	protected Label getLblCriteria() {
		return lblCriteria;
	}

	/**
	 * @param lblCriteria the lblCriteria to set
	 */
	protected void setLblCriteria(Label lblCriteria) {
		this.lblCriteria = lblCriteria;
	}

	/**
	 * @return the queryComposite
	 */
	protected QueryComposite getQueryComposite() {
		return queryComposite;
	}

	/**
	 * @param queryComposite the queryComposite to set
	 */
	protected void setQueryComposite(QueryComposite queryComposite) {
		this.queryComposite = queryComposite;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {

		// view
		GridLayout gridLayout = new GridLayout();
		parent.setLayout(gridLayout);

		tabFolder = new TabFolder(parent, SWT.TOP);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// tabItem browserTab
		browserTab = new TabItem(tabFolder, SWT.NONE);
		browserTab.setControl(setBrowserTabControl());

		// tabItem queryTab
		// TabItem queryTab = new TabItem(tabFolder, SWT.NONE);
		// queryTab.setText("Query");
		// this.queryComposite = new QueryComosite(tabFolder, SWT.NONE);
		// queryTab.setControl(queryComposite);

		// tabFolder.setSelection(1);

	}

	/**
	 * . This method will be implemented by inheriting classes to set the contents of browser tab.
	 * 
	 * @return contents of browser tab
	 */
	protected abstract Control setBrowserTabControl();

	/**
	 * . This will be implemented by inheriting classes to update the information shown on browser tab based on criteria
	 * selected in Query tab.
	 */
	protected abstract void refresh();

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setFocus() {

	}

}
