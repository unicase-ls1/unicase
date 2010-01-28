package org.unicase.ui.web.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CTabFolder;

import org.unicase.web.util.ExampleUtil;

/**
 * Info tab is used when no project name is given via URL parameters.
 * <br><br>
 * Example URL:
 * http://mydomain.de/rap?project=unicase
 * 
 * @author Fatih Ulusoy
 */
public class InfoTab extends AbstractTab {

	private CTabItem tabItem;
	private CTabFolder tabFolder;
	private Composite tabComposite;
	
	/**
	 * Constructor.
	 * 
	 * @param parent
	 */
	public InfoTab(CTabFolder parent) {
		tabFolder = parent;
		tabItem = new CTabItem(tabFolder, SWT.NONE);
		tabItem.setText("Info");
	    
		tabComposite = new Composite(tabFolder, SWT.NONE);
		tabComposite.setLayout(ExampleUtil.createGridLayout(1, false, 10, 20));
	    tabItem.setControl(tabComposite);
	}
	
	@Override
	public void createTabContent() {
		Group group = new Group(tabComposite, SWT.NONE);
		group.setText("Missing Project Name");
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		group.setLayout(ExampleUtil.createGridLayout(2, false, 10, 20));

		Composite leftComp = new Composite(group, SWT.NONE);
		leftComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		leftComp.setLayout(new GridLayout());

		String text = "You should give project name with an URL parameter \"project\". " +
					   "Example URL is given below in case of your project name \"unicase\":";
		new Label(leftComp, SWT.NONE).setText(text);
		
		String text2 = "http://mydomain.de/rap?project=unicase";
		new Label(leftComp, SWT.NONE).setText(text2);
		
	}

}


