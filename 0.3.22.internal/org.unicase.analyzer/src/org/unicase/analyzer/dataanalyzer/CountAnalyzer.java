/**
 * 
 */
package org.unicase.analyzer.dataanalyzer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.model.ModelElement;

/**
 * @author liya
 *
 */
public class CountAnalyzer implements DataAnalyzer {

	private EClass eclass;
	
	/**
	 * Constructor of CountAnalyzer. A analyzer which can count
	 * the number of modelElements of a given EClass.
	 * @param eclass EClass
	 */
	public CountAnalyzer(EClass eclass){
		this.eclass = eclass;
	}
	/* (non-Javadoc)
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add(eclass.getName()+'#');
		return names;
	}

	/* (non-Javadoc)
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		values.add(data.getProjectState().getModelElementsByClass(eclass, new BasicEList<ModelElement>()).size());
		return values;
	}

}
