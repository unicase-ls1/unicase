package org.unicase.rap.ui.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * This class represents a tab in the configuration view.
 */
public abstract class AbstractTab {
	
	private String tabName;
	private CTabFolder parentFolder;
	
	private CTabItem tabItem;
	private Composite composite;
	
	/**
	 * Create the content of this tab
	 * 
	 * @param parent The parent composite.
	 */
	public abstract void createTab(Composite parent);

	/**
	 * Sets the name of this tab
	 * 
	 * @param tabName The name of this tab
	 */
	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	/**
	 * Gets the name of this tab.
	 * @return The name of this tab
	 */
	public String getTabName() {
		return tabName;
	}

	/**
	 * Sets the parent folder of this tab.
	 * @param parentFolder The folder this tab should be part of.
	 */
	public void setParentFolder(CTabFolder parentFolder) {
		this.parentFolder = parentFolder;

		composite = new Composite(parentFolder, SWT.BORDER);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		composite.setLayout(layout);
		GridData d = new GridData();
		d.grabExcessHorizontalSpace = true;
		d.grabExcessVerticalSpace = true;
		composite.setLayoutData(d);

		tabItem = new CTabItem(parentFolder, SWT.NONE);
		tabItem.setText(tabName);
		tabItem.setControl(composite);

		Composite c = new Composite(composite, SWT.BORDER);
		createTab(c);
	}

	/**
	 * Returns the folder this tab is part of.
	 * @return The parent folder of this tab.
	 */
	public CTabFolder getParentFolder() {
		return parentFolder;
	}
}
