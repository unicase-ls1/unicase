/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.unicaseAnalyzers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.exporters.Exporter;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Analyze each read event.
 * 
 * @author liya
 */
public class ReadEventAnalyzer implements DataAnalyzer {

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
	 * @param data {@link ProjectAnalysisData}
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		return values;
	}

	/**
	 * Analyze the give ProjectAnalysisData.
	 * 
	 * @param data ProjectAnalysisData
	 * @param exporter Exporter
	 */
	public void analyzeData(ProjectAnalysisData data, Exporter exporter) {
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
					try {
						exporter.writeLine(line);
					} catch (IOException e) {
						WorkspaceUtil.logException("Problem occurs when exporting.", e);
					}
				}
			}
		}
	}

	/**
	 * @param exporter @see {@link Exporter}
	 * @throws IOException @see {@link IOException}
	 */
	public void writeHeader(Exporter exporter) throws IOException {
		ArrayList<Object> line = new ArrayList<Object>();
		for (String name : this.getName()) {
			line.add(name);
		}
		exporter.writeLine(line);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#isGlobal()
	 */
	public boolean isGlobal() {
		return false;
	}
}
