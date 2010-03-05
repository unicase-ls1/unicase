/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.unicaseAnalyzers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.TwoDDataAnalyzer;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;

/**
 * Analyze each read event.
 * 
 * @author liya
 */
public class ReadEventAnalyzer implements TwoDDataAnalyzer {

	private Date latestTime;

	/**
	 * @return the latestTime
	 */
	public Date getLatestTime() {
		return latestTime;
	}

	/**
	 * @param latestTime the latestTime to set
	 */
	public void setLatestTime(Date latestTime) {
		this.latestTime = latestTime;
	}

	/**
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("ChangePackage");
		names.add("ModelElement");
		names.add("ReadView");
		names.add("SourceView");
		return names;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#isGlobal()
	 */
	public boolean isGlobal() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.TwoDDataAnalyzer#analyzeData(org.unicase.analyzer.ProjectAnalysisData,
	 *      org.unicase.analyzer.iterator.VersionIterator)
	 */
	public void analyzeData(ProjectAnalysisData data, VersionIterator it) {
		// TODO Auto-generated method stub

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
				// ReadeEvent
				if (event instanceof ReadEvent) {
					List<Object> line = new ArrayList<Object>();
					ReadEvent readEvent = (ReadEvent) event;
					ModelElementId meId = readEvent.getModelElement();
					ModelElement me = data.getProjectState().getModelElement(meId);
					// add ChangePackage number
					line.add(data.getPrimaryVersionSpec().getIdentifier() - data.getChangePackages().size()
						+ data.getChangePackages().indexOf(change));
					if (me != null && me.getClass().getName() != null) {
						line.add(me.getClass().getName());
					} else {
						line.add("-");
					}
					if (readEvent.getReadView() != null) {
						line.add(readEvent.getReadView());
					} else {
						line.add("-");
						Date currentTime = readEvent.getTimestamp();
						if (latestTime == null) {
							latestTime = currentTime;
						}
						if (currentTime.after(latestTime)) {
							latestTime = currentTime;
						}
					}
					if (readEvent.getSourceView() != null) {
						line.add(readEvent.getSourceView());
					} else {
						line.add("-");
					}

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
