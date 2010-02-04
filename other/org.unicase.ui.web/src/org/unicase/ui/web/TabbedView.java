package org.unicase.ui.web;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.swt.SWT;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.rwt.RWT;
import org.eclipse.rwt.graphics.Graphics;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;

import org.unicase.ui.web.tabs.*;

/**
 * 
 * 
 * @author Fatih Ulusoy
 */
public class TabbedView extends ViewPart implements ISelectionListener {

	public static final String ID = "org.unicase.ui.web.TabbedView";
	
	private String currProjectName;
	private TaskItemsTab taskItemsTab;
	private TeamTab teamTab;
	private BugReportTab bugReportTab;

	@Override
	public void createPartControl(Composite parent) {
	
		parent.setLayout(new GridLayout(2, false));
		int style = SWT.TOP | SWT.FLAT | SWT.BORDER;
		final CTabFolder topFolder = new CTabFolder(parent, style);
		topFolder.marginWidth = 8;
		topFolder.marginHeight = 8;
		ensureMinTabHeight(topFolder);

		
		
		HttpServletRequest request = RWT.getRequest();
		String projectName = request.getParameter("project");
		
		ISelectionService service =  getSite().getWorkbenchWindow().getSelectionService();
		service.addSelectionListener(new ISelectionListener() {
			
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				System.out.println(selection.toString());
			}
		});
			
		if (projectName != null) {
			setCurrProjectName(projectName);
			taskItemsTab = new TaskItemsTab(projectName, topFolder);
			teamTab = new TeamTab(projectName, topFolder);
			bugReportTab = new BugReportTab(projectName, topFolder);
			
			final AbstractTab[] tabs = new AbstractTab[] {
					taskItemsTab,
					teamTab,
					bugReportTab
//					new ExampleTableTab(topFolder), new InputTab(topFolder) 
			};

			

			topFolder.setSelection(0);
			tabs[0].createTabContent();
			topFolder.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(final SelectionEvent evt) {
					int index = topFolder.getSelectionIndex();
					tabs[index].createTabContent();
				}
			});
		} else {
			InfoTab infoTab = new InfoTab(topFolder);
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

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		System.out.println(selection);	
	}

}

