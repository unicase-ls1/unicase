package org.unicase.rap.status.ui.tabs;

import java.util.Date;
import java.util.Comparator;
import java.util.Collections;
import java.text.SimpleDateFormat;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.rwt.graphics.Graphics;
import org.eclipse.rwt.widgets.ExternalBrowser;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.rap.status.Utility;
import org.unicase.rap.ui.tabs.ProjectAwareTab;
import org.unicase.workspace.ProjectSpace;

/**
 * 
 * @author fxulusoy
 */
public class UpcomingEventsTab extends ProjectAwareTab {

	
	public UpcomingEventsTab(ProjectSpace projectSpace, CTabFolder parent, String tabName) {
		super(projectSpace, parent, tabName);		
	}
	
	@Override
	protected void createTab(Composite parent) {
		
	}

	// TODO :
	public void createTabContent() {
		
		Group group = new Group(composite, SWT.NONE);
		GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);		
		
		group.setLayoutData(gridData);
		GridLayout gridLayout = new GridLayout(3, false);
		group.setLayout(gridLayout);
		
	    ClassLoader classLoader = getClass().getClassLoader();
		Image image1 = Graphics.getImage("icons/Meeting.gif", classLoader);
		Image image2 = Graphics.getImage("icons/WorkPackage.gif", classLoader);
		Image image3 = Graphics.getImage("icons/ActionItem.png", classLoader);
		Image image4 = Graphics.getImage("icons/Bug_major.png", classLoader);		
		
		EList<ModelElement> items = initItems();

		final int count = items.size();
		String[] eventItems;
		
		SimpleDateFormat day = new SimpleDateFormat("EEE, d MMM");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm");
		if (count > 0) {
			eventItems = new String[Math.min(10, count)];
			for (int i = 0; i < Math.min(10, count); i++) {
				UnicaseModelElement modelElement = (UnicaseModelElement) items.get(i);
				
				
				String msg = "";
				if (modelElement instanceof WorkItem) {
					msg = "  is due on ";
				} else if (modelElement instanceof Meeting) {
					msg = "  starts on ";
				}
				Date date = getDate(modelElement);
				StringBuilder stringBuilder = new StringBuilder();
				// TODO: name can be long, we should limit it
				// stringBuilder.append(modelElement.getName());
				stringBuilder.append(msg);
				stringBuilder.append(day.format(date));
				stringBuilder.append(" at ");
				stringBuilder.append(time.format(date));
				
				eventItems[i] = stringBuilder.toString();
				
				String str = Utility.getLinkForModelElement(getProjectSpace(), modelElement);
				
				if(modelElement instanceof Meeting)
					addEvent(modelElement, group, image1, modelElement.getName(), str,stringBuilder.toString());
				else if(modelElement instanceof BugReport) 
					addEvent(modelElement, group, image4, modelElement.getName(), str, stringBuilder.toString());
				else if(modelElement instanceof ActionItem) 
					addEvent(modelElement, group, image3, modelElement.getName(), str, stringBuilder.toString());
				else 
					addEvent(modelElement, group, image2, modelElement.getName(), str, stringBuilder.toString());				
			}
		} else {
			eventItems = new String[5];
			eventItems[0] = "No upcoming events";
		}
		// eventsList.setItems(eventItems);
	}
	
	private void addEvent(UnicaseModelElement element, Group group, Image image, String linkTextStr, final String linkStr, String text) {
		
		Label imageLabel1 = new Label(group, SWT.NONE);
		imageLabel1.setImage(image);
		imageLabel1.setToolTipText(element.eClass().getName());
		
		final Link link = new Link(group, SWT.NONE);
		link.setText("<a href=\"" + linkStr +" \">" + linkTextStr + "</a>");
		link.setToolTipText(linkTextStr);
		link.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(final SelectionEvent e) {
				ExternalBrowser.open("www.google.de", linkStr, SWT.NONE);
			}
		});

		Label simpleLabel = new Label(group, SWT.NONE);
		simpleLabel.setText(text);

		Label seperator = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);

		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 3;
		seperator.setLayoutData(gridData);
		
	}
	
	private EList<ModelElement> initItems() {
		
		Project project = getProjectSpace().getProject();
		
		EList<ModelElement> total = new BasicEList<ModelElement>();

		EList<WorkItem> workItems = new BasicEList<WorkItem>();
		EList<Meeting> meetings = new BasicEList<Meeting>();

		project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(), workItems, true);
		project.getAllModelElementsbyClass(MeetingPackage.eINSTANCE.getMeeting(), meetings);

		final Date now = new Date();
		addUpcomingEvents(total, workItems, now);
		addUpcomingEvents(total, meetings, now);

		Collections.sort(total, new Comparator<ModelElement>() {
			public int compare(ModelElement o1, ModelElement o2) {
				Date d1 = getDate(o1);
				Date d2 = getDate(o2);
				if (d1 != null && d2 == null) {
					return -1;
				} else if (d1 == null && d2 != null) {
					return 1;
				} else if (d1 != null && d2 != null) {
					return d1.compareTo(d2);
				}
				return 0;
			}
		});

		return total;
	}

	private void addUpcomingEvents(EList<ModelElement> target,
			EList<? extends ModelElement> source, Date now) {
		for (ModelElement modelElement : source) {
			Date date = getDate(modelElement);
			if (date != null && date.after(now)) {
				target.add(modelElement);
			}
		}
	}
	
	private Date getDate(ModelElement modelElement) {
		Date date = null;
		if (modelElement instanceof WorkItem) {
			date = ((WorkItem) modelElement).getDueDate();
		} else if (modelElement instanceof WorkPackage) {
			date = ((WorkPackage) modelElement).getEndDate();
		} else if (modelElement instanceof Meeting) {
			date = ((Meeting) modelElement).getStarttime();
		}
		return date;
	}


}
