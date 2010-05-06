/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.ui.views;

import java.util.Map;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.rwt.graphics.Graphics;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.unicase.rap.ui.tabs.AbstractTab;

/**
 * A view with multiple tabs.
 * 
 * @author Edgar Müller
 */
public abstract class AbstractTabView extends AbstractView {
	
	/**
	 *  Contains all tabs, that should be shown in the configuration view. 
	 */
	private Map<String, AbstractTab> tabs = new HashMap<String, AbstractTab>();
	
	private CTabFolder tabFolder;
	
	/**
	 * Ensures minimum tab height.
	 * 
	 * @param folder Tab folder.
	 */
	protected static void ensureMinTabHeight(final CTabFolder folder) {
		int result = Graphics.getCharHeight(folder.getFont());
		if (result < 18) {
			folder.setTabHeight(18);
		}
	}
	
	/**
	 * Returns a map of the tabs, this view currently holds, and their name.
	 * 
	 * @return Map of tabs and their name
	 */
	public Map<String, AbstractTab> getTabs() {
		return tabs;
	}

	/**
	 * Returns the tab folder of the view.
	 * 
	 * @return the tab folder
	 */
	public CTabFolder getTabFolder() {
		return tabFolder;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		int style = SWT.TOP | SWT.FLAT | SWT.BORDER;

		tabFolder = new CTabFolder(parent, style);
		tabFolder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent evt) {

			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});

		tabFolder.marginWidth = 8;
		tabFolder.marginHeight = 8;
		ensureMinTabHeight(getTabFolder());

		tabs = new HashMap<String, AbstractTab>();

		createTabs(parent);
	}

	/**
	 * @param parent Parent element.
	 */
	protected abstract void createTabs(Composite parent);

	/**
	 * Add an additional tab to the configuration view.
	 * 
	 * @param tabName The name of the tab that will be used when displaying the tab.
	 * @param configTab The tab itself
	 */
	public void addTab(String tabName, AbstractTab configTab) {
		tabs.put(tabName, configTab);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {

	}
		
}

