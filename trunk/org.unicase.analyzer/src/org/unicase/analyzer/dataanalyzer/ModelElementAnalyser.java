/**
 * 
 */
package org.unicase.analyzer.dataanalyzer;

import java.util.ArrayList;
import java.util.List;

import org.unicase.analyzer.ProjectAnalysisData;

/**
 * @author liya
 *
 */
public class ModelElementAnalyser implements DataAnalyzer {

	private static final String MECOUNT = "ModelElement #";

	//private final static String DMECOUNT = "Domain ModelElement #";
	/**
	 * (non-Javadoc).
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 * @return return
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add(MECOUNT);
	//names.add(DMECOUNT);
		return names;
	}

	/** (non-Javadoc).
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 * @param data data
	 *@return return 
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		
		// Number of all ModelElements
		values.add(data.getProjectState().getModelElements().size());
		
		// Number of all Domain ModelElements
//		ProjectDescriptor descriptor = DescriptorAccess.getInstance()
//				.getProjectDescriptor(data.getProjectId());
//		values.add(descriptor.getDomainElements().length);
		return values;
	}

}
