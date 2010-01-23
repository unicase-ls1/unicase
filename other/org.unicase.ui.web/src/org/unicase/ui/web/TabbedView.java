package org.unicase.ui.web;

import org.eclipse.rwt.RWT;
import org.eclipse.rwt.graphics.Graphics;
import org.eclipse.swt.SWT;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;

import org.unicase.ui.web.tabs.*;
import org.unicase.web.updater.UpdateProjectHandler;
import org.unicase.web.updater.handlers.LoginHandler;
import org.unicase.web.util.Configuration;

/**
 * 
 * 
 * @author Fatih Ulusoy
 */
public class TabbedView extends ViewPart {

	public static final String ID = "org.unicase.ui.web.TabbedView";
	
	private String currProjectName;

	@Override
	public void createPartControl(Composite parent) {
		
		parent.setLayout(new FillLayout());
		int style = SWT.TOP | SWT.FLAT | SWT.BORDER;
		final CTabFolder topFolder = new CTabFolder(parent, style);
		topFolder.marginWidth = 8;
		topFolder.marginHeight = 8;
		ensureMinTabHeight(topFolder);

		// tabs[0].foo();  //.createContent();
		Object o = RWT.getRequest().getParameterMap().get("project");
				
		if (o != null) {
			setCurrProjectName(((String[]) o)[0]);
		}
		
//		if (currProjectName != null) {
//			Configuration.initialize();
//			LoginHandler login = new LoginHandler(Configuration.getProperties().getProperty("hostname"));
//			login.run();
//			Thread updaterThread = new Thread(new ProjectUpdater(currProjectName));
//			updaterThread.start();
//		}
		
		final AbstractTab[] tabs = new AbstractTab[] {
				new TaskItemsTab(topFolder), new BugReportTab(topFolder),
				new ExampleTableTab(topFolder), new InputTab(topFolder) };
		
		topFolder.setSelection(0);
		topFolder.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(final SelectionEvent evt) {
				int index = topFolder.getSelectionIndex();
				tabs[index].createContent(getCurrProjectName());
			}
		});
	}

	@Override
	public void setFocus() {
		
	}

	/**
	 * Ensures minimum tab height.
	 * 
	 * @param folder
	 */
	private static void ensureMinTabHeight(final CTabFolder folder) {
		int result = Graphics.getCharHeight(folder.getFont());
		if (result < 18) {
			folder.setTabHeight(18);
		}
	}

	/**
	 * Gets current project name.
	 * 
	 * @return
	 */
	public String getCurrProjectName() {
		return currProjectName;
	}

	/**
	 * Sets current project name.
	 * 
	 * @param currProjectName
	 */
	public void setCurrProjectName(String currProjectName) {
		this.currProjectName = currProjectName;
	}

}

