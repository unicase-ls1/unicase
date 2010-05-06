/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.unicaseAnalyzers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.SimpleDataAnalyzer;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;

/**
 * Write the time stamp of the current project state.
 * 
 * @author liya
 */
public class DateWriter extends SimpleDataAnalyzer {

	private Date date;
	private final DateFormat format;
	private final Calendar calendar;

	/**
	 * Constructor of DateWriter.
	 */
	public DateWriter() {
		// this.projectIterator = projectIterator;
		this.date = new Date();
		this.format = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss Z");
		this.calendar = Calendar.getInstance();
	}

	private void setTime(ChangePackage changePackage) {
		if (changePackage.getLogMessage() != null) {
			if (changePackage.getLogMessage().getDate() != null) {
				calendar.setTime(changePackage.getLogMessage().getDate());
			} else {
				calendar.setTime(changePackage.getLogMessage().getClientDate());
			}
		} else {

		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.SimpleDataAnalyzer#getSimpleValues(org.unicase.analyzer.ProjectAnalysisData)
	 */
	@Override
	public List<Object> getSimpleValues(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		// if(projectIterator instanceof TimeIterator){
		// TimeIterator it = (TimeIterator) projectIterator;
		// FIXME add the getDateSpec() method in TimeIterator
		// This writes the time from the iterator, instead of version
		// calendar.setTime(it.getDateSpec().getDate());
		// }
		// else{
		List<ChangePackage> changepackages = data.getChangePackages();
		if (data.getChangePackages() != null && data.getChangePackages().size() != 0) {
			ChangePackage changePackage = changepackages.get(changepackages.size() - 1);
			if (changePackage != null) {
				setTime(changePackage);
			}
		}
		// }
		date = calendar.getTime();
		values.add(format.format(date));
		return values;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#getColumnNames()
	 */
	public List<String> getColumnNames() {
		List<String> names = new ArrayList<String>();
		names.add("Date");
		return names;
	}

}
