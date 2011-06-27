/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.unicaseAnalyzers;

import java.util.ArrayList;
import java.util.List;

import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.ProjectAnalysisData;
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
public class StatusEventAnalyzer implements DataAnalyzer {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#getColumnNames()
	 */
	public List<String> getColumnNames() {
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
	 * @see org.unicase.analyzer.DataAnalyzer#getValues(org.unicase.analyzer.ProjectAnalysisData,
	 *      org.unicase.analyzer.iterator.VersionIterator)
	 */
	public List<List<Object>> getValues(ProjectAnalysisData data, VersionIterator it) {
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

}
