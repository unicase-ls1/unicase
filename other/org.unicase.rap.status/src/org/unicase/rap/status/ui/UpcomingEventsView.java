package org.unicase.rap.status.ui;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.rap.status.ui.tabs.UpcomingEventsTab;
import org.unicase.rap.ui.views.ProjectAwareView;

public class UpcomingEventsView extends ProjectAwareView {

	public static final String ID = "org.unicase.rap.status.ui.UpcomingEventsView";
	
	private CTabFolder tabFolder;
	private UpcomingEventsTab upcomingEventsTab;
	
	public UpcomingEventsView() {
		super();
	}
	
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		int style = SWT.TOP | SWT.FLAT | SWT.BORDER;
		
		tabFolder = new CTabFolder(parent, style);
		tabFolder.marginWidth = 8;
		tabFolder.marginHeight = 8;
		
		upcomingEventsTab = new UpcomingEventsTab(projectSpace, tabFolder, "Upcoming Events");

		upcomingEventsTab.createTabContent();
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getId() {
		return ID;
	}

	public void notify(Notification notification, Project project, ModelElement modelElement) {
		// TODO Auto-generated method stub

	}

	public void modelElementAdded(Project project, ModelElement modelElement) {
		// TODO Auto-generated method stub

	}

	public void modelElementDeleteStarted(Project project, ModelElement modelElement) {
		// TODO Auto-generated method stub

	}

	public void modelElementDeleteCompleted(Project project, ModelElement modelElement) {
		// TODO Auto-generated method stub

	}

	public void projectDeleted(Project project) {
		// TODO Auto-generated method stub
		
	}

}
