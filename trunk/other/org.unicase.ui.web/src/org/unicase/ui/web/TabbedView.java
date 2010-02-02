package org.unicase.ui.web;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.swt.SWT;
import org.eclipse.rwt.RWT;
import org.eclipse.rwt.graphics.Graphics;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;

import org.unicase.ui.web.tabs.*;

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

		HttpServletRequest request = RWT.getRequest();
		String projectName = request.getParameter("project");
	
		if (projectName != null) {
			setCurrProjectName(projectName);
			final AbstractTab[] tabs = new AbstractTab[] {
					new TaskItemsTab(projectName, topFolder), new BugReportTab(topFolder),
					new TeamTab(projectName, topFolder), new ExampleTableTab(topFolder),
					new InputTab(topFolder) };

			topFolder.setSelection(0);
//			tabs[0].createContent(getCurrProjectName());
			topFolder.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(final SelectionEvent evt) {
					int index = topFolder.getSelectionIndex();
					tabs[index].createTabContent();
				}
			});
		} else {
			InfoTab infoTab = new InfoTab(topFolder);
//			infoTab.createContent(null);
		}
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

