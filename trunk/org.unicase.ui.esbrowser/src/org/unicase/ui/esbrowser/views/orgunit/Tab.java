package org.unicase.ui.esbrowser.views.orgunit;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.ui.PlatformUI;

public class Tab  {

	private ListViewer list;
	private Composite tabFolderPage;
	private String tabName;
	
	
	public Tab(String tabName) {
		this.tabName = tabName;
	}


	Composite createTabFolderPage(TabFolder tabFolder){
		
		tabFolderPage = new Composite (tabFolder, SWT.NONE);
		tabFolderPage.setLayoutData (new GridData(SWT.FILL, SWT.FILL, true, true));
		tabFolderPage.setLayout (new FillLayout ());
		tabFolder.setBackground(PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_BLUE));
		return tabFolderPage;
		
	}
	
	public String getName(){
		return tabName;
	}
	
	

}
