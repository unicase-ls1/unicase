package org.unicase.ui.web.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Composite;

import org.unicase.ui.web.tabs.TableViewerExample;


/**
 * 
 * @author fxulusoy
 *
 */
public class ExampleTableTab extends AbstractTab {

	private boolean isContentCreated;
	private final CTabFolder tabFolder;
	private final CTabItem tabItem;

	
	/**
	 * 
	 * @param parent
	 */
	public ExampleTableTab(CTabFolder parent) {
		tabFolder = parent;
		isContentCreated = false;
	    tabItem = new CTabItem( tabFolder, SWT.NONE );
	    tabItem.setText("Example Table Tab");
	}
	
	public void createContent() {
		if (!isContentCreated) {
		    Composite com = new Composite(tabFolder, SWT.NONE);
		    createTabContent(com);
		    tabItem.setControl(com);
			isContentCreated = true;
		}
	}
	
	
	/**
	 * 
	 * @param parent
	 */
	private void createTabContent(Composite parent) {
		
		TableViewerExample tableViewer = new TableViewerExample();
		tableViewer.createControl(parent);
		
	}

}
