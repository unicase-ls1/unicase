/**
 * 
 */
package org.unicase.analyzer.dataanalyzer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.TimeIterator;
import org.unicase.analyzer.VersionIterator;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;

/**
 * @author liya
 *
 */
public class DateWriter implements DataAnalyzer {

	private VersionIterator projectIterator;
	private Date date;
	private DateFormat format;
	private Calendar calendar;
	/**
	 * Constructor of DateWriter
	 * @param projectIterator VersionIterator
	 */
	public DateWriter(VersionIterator projectIterator){
		this.projectIterator = projectIterator;
		this.date = new Date();
		this.format = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss Z");
		this.calendar = Calendar.getInstance();
	}
	
	
	/* (non-Javadoc)
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("Date");
		return names;
	}

	/* (non-Javadoc)
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		if(projectIterator instanceof TimeIterator){
			TimeIterator It = (TimeIterator) projectIterator;
			calendar.setTime(It.getDateSpec().getDate());
		}
		else{
			List<ChangePackage> changepackages = data.getChangePackages();
			if(data.getChangePackages() != null && data.getChangePackages().size() != 0) {
				ChangePackage changePackage = changepackages.get(changepackages.size()-1);
				if( changePackage !=null) {
					if(changePackage.getLogMessage() != null) {
						if(changePackage.getLogMessage().getDate() != null) {
							calendar.setTime(changePackage.getLogMessage().getDate());
						}
					}
				}
			}
		}
		date = calendar.getTime();
		values.add(format.format(date));
		return values;
	}

}
