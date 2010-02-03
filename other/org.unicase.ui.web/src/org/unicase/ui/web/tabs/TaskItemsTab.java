package org.unicase.ui.web.tabs;

import java.util.ArrayList;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.rwt.widgets.ExternalBrowser;

import org.eclipse.jface.action.Action;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;

import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.web.labelproviders.UnicaseObservableMapLabelProvider;

/**
 * TaskItemsTab shows checkables (work items which can be set to done).
 * 
 * @author Fatih Ulusoy
 */
public class TaskItemsTab extends AbstractTab {
	
	private TaskListView listView;
	
	private ObservableListContentProvider contentProvider;
	
	/**
	 * Constructor.
	 * 
	 * @param parent
	 */
	public TaskItemsTab(String projectName, CTabFolder parent) {
		super(projectName, parent, "Task Items");
		listView = new TaskListView(getProjectSpace(), getTabComposite());
		contentProvider = new ObservableListContentProvider();
		listView.setContentProvider(contentProvider);
	}
		
	@Override 
	public void createTabContent() {
		if(isContentCreated()) {
			return;
		}
		ArrayList<EStructuralFeature> featureList = listView.getFeatureList();
		EStructuralFeature[] featureArray = new EStructuralFeature[featureList.size()]; 
		featureArray = featureList.toArray(featureArray);		
		
		IObservableSet knownElements = contentProvider.getKnownElements();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(knownElements, featureArray);
		ObservableMapLabelProvider labelProvider = new UnicaseObservableMapLabelProvider(observeMaps);
		
		listView.createColumns(featureList, labelProvider);
		listView.setListInput();
		
		hookDoubleClickAction();
		
		setContentCreated(true);	
	}
	
	
	/**
	 * Hooks a double click action for the table.
	 */
	private void hookDoubleClickAction() {
		final Action doubleClickAction = new Action() {
			@Override
			public void run() {
				int index = listView.getTable().getSelectionIndex();
				TableItem item = listView.getTable().getItem(index);
				UnicaseModelElement element = (UnicaseModelElement) item.getData();
				String link = createLink(element);
				
				int style = ExternalBrowser.LOCATION_BAR
						| ExternalBrowser.NAVIGATION_BAR
						| ExternalBrowser.STATUS;
				ExternalBrowser.open("someId", link, style);
			}
			
			private String createLink(UnicaseModelElement me) {
				String meName = ((UnicaseModelElement) me).getName().replaceAll(" ", "");
				// Get model element id
				String meId = me.getModelElementId().getId();

				// remove spaces from the project name
				String projectName = getProjectSpace().getProjectName().replaceAll(" ", "");
				String projectId = getProjectSpace().getProjectId().getId();

				String serverUrl = getProjectSpace().getUsersession().getServerInfo().getUrl();
				int serverPort = getProjectSpace().getUsersession().getServerInfo().getPort();

				// Assemble the link
				String link = "unicase://" + serverUrl + ":" + serverPort + "/"
						+ projectName + "%" + projectId + "/" + meName + "%"
						+ meId;
				return link;
			}
			
		};
		listView.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	
}



