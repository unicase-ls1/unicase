package org.unicase.rap.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public abstract class ConfigurationTabView {

	private String tabName;
	private CTabFolder parentFolder;
	
	private CTabItem tabItem;
	private Composite composite;
	
	public ConfigurationTabView() {
		
	}

	private void init() {
		tabItem = new CTabItem(parentFolder, SWT.NONE);
		tabItem.setText(tabName);
		composite = new Composite(parentFolder, SWT.NONE);
		
		getComposite().setLayout(new GridLayout(1, false));
		
		// composite.setLayout(new FillLayout());	
		
	    tabItem.setControl(getComposite());
	    createTab();
	}

	protected abstract void createTab();

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public String getTabName() {
		return tabName;
	}

	public void setParentFolder(CTabFolder parentFolder) {
		this.parentFolder = parentFolder;
		// TODO:!!!
		init();
	}

	public CTabFolder getParentFolder() {
		return parentFolder;
	}

	public Composite getComposite() {
		return composite;
	}
}
