package org.unicase.ui.web.tabs;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.rwt.widgets.ExternalBrowser;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;

import org.unicase.metamodel.Project;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.model.ModelPackage;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.model.bug.Severity;
import org.unicase.model.change.MergingIssue;
import org.unicase.model.organization.OrganizationPackage;

import org.unicase.workspace.ProjectSpace;
import org.unicase.ui.web.Activator;
import org.unicase.ui.web.labelproviders.DateColumnLabelProvider;
import org.unicase.ui.web.labelproviders.GenericColumnLabelProvider;
import org.unicase.ui.web.labelproviders.StatusLabelProvider;
import org.unicase.ui.web.sorters.TableViewerColumnSorter;


/**
 * TaskItemsTab shows checkables (work items which can be set to done).
 * 
 * @author Fatih Ulusoy
 */
public class TaskItemsTab extends AbstractTab {
	
	private TaskListView taskView;
	private List<TableViewerColumn> columns;
	private ObservableListContentProvider contentProvider;
	
	/**
	 * Constructor.
	 * 
	 * @param parent
	 */
	public TaskItemsTab(String projectName, CTabFolder parent) {
		super(projectName, parent, "Task Items");
	}
		
	@Override 
	public void createTabContent() {
		if(isContentCreated()) {
			return;
		}
		
		ArrayList<EStructuralFeature> featureList = taskView.getFeatureList();
		EStructuralFeature[] featureArray = new EStructuralFeature[featureList.size()]; 
		featureArray = featureList.toArray(featureArray);		
		
		IObservableSet knownElements = contentProvider.getKnownElements();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(knownElements, featureArray);
		
		taskView.createLabelProvider(observeMaps);
				
//		getProject().addProjectChangeObserver(TaskItemsTab.this);
		setContentCreated(true);		
	}
}



