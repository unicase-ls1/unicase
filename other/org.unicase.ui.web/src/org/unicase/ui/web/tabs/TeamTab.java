package org.unicase.ui.web.tabs;

import java.util.ArrayList;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;

/**
 * 
 * @author Edgar Müller
 * @author Fatih Ulusoy
 */
public class TeamTab extends AbstractTab {

	private TeamListView listView;
	
	private ObservableListContentProvider contentProvider;
	
	/**
	 * 
	 * @param projectName
	 * @param parent
	 */
	public TeamTab(String projectName, CTabFolder parent) {
		super(projectName, parent, "Teams");
		listView = new TeamListView(getProjectSpace(), getTabComposite());
		contentProvider = new ObservableListContentProvider();
		listView.setContentProvider(contentProvider);
	}

	@Override
	public void createTabContent() {
		if (isContentCreated())
			return;

		ArrayList<EStructuralFeature> featureList = listView.getFeatureList();
		EStructuralFeature[] featureArray = new EStructuralFeature[featureList.size()];
		featureArray = featureList.toArray(featureArray);

		IObservableSet knownElements = contentProvider.getKnownElements();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				knownElements, featureArray);
		ObservableMapLabelProvider labelProvider = new ObservableMapLabelProvider(observeMaps);

		listView.createColumns(featureList, labelProvider);

		listView.setListInput();
		setContentCreated(true);
	}
	
	
}


