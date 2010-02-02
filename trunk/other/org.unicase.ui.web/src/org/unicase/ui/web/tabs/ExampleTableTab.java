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
	private final CTabItem tabItem;

	/**
	 * 
	 * @param parent
	 */
	public ExampleTableTab(CTabFolder parent) {
		super(parent, "Example Tab");
		isContentCreated = false;
	    tabItem = new CTabItem(getTabFolder(), SWT.NONE );
	    tabItem.setText("Example Table Tab");
	}
	
	public void createTabContent() {
		if (!isContentCreated) {
		    Composite com = new Composite(getTabFolder(), SWT.NONE);
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
