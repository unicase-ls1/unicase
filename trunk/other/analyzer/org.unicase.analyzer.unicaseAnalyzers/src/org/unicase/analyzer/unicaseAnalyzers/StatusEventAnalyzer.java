/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.unicaseAnalyzers;

import java.util.ArrayList;
import java.util.List;

import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.TwoDDataAnalyzer;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent;
import org.unicase.emfstore.esmodel.versioning.events.PresentationSwitchEvent;

/**
 * This analyzter recordes all events focussing the status view.
 * 
 * @author helming
 */
public class StatusEventAnalyzer implements TwoDDataAnalyzer {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#getName()
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("Date");
		names.add("Type");
		names.add("Tab");
		names.add("Author");
		return names;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#isGlobal()
	 */
	public boolean isGlobal() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.TwoDDataAnalyzer#analyzeData(org.unicase.analyzer.ProjectAnalysisData,
	 *      org.unicase.analyzer.iterator.VersionIterator)
	 */
	public void analyzeData(ProjectAnalysisData data, VersionIterator it) {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.TwoDDataAnalyzer#get2DValue(org.unicase.analyzer.ProjectAnalysisData,
	 *      org.unicase.analyzer.iterator.VersionIterator)
	 */
	public List<List<Object>> get2DValue(ProjectAnalysisData data, VersionIterator it) {
		List<List<Object>> lines = new ArrayList<List<Object>>();

		for (ChangePackage change : data.getChangePackages()) {

			for (Event event : change.getEvents()) {
				List<Object> line = new ArrayList<Object>();
				if (event instanceof PluginFocusEvent) {
					PluginFocusEvent pluginStartEvent = (PluginFocusEvent) event;
					if (pluginStartEvent.getPluginId().equals("org.unicase.ui.treeview.views.StatusView")) {
						line.add(pluginStartEvent.getStartDate());
						line.add("Focus");
						line.add("");
					}
				} else if (event instanceof PresentationSwitchEvent) {
					PresentationSwitchEvent presentationSwitchEvent = (PresentationSwitchEvent) event;
					if (presentationSwitchEvent.getReadView().equals("org.unicase.ui.treeview.views.StatusView")) {
						line.add(presentationSwitchEvent.getTimestamp());
						line.add("Switch");
						line.add(presentationSwitchEvent.getNewPresentation());
					}
				}

				if (!line.isEmpty()) {
					line.add(change.getLogMessage().getAuthor());
					lines.add(line);
				}

			}
		}
		return lines;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		// TODO Auto-generated method stub
		return null;
	}

}
