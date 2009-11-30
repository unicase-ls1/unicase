/**
 * 
 */
package org.unicase.analyzer.dataanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.exporter.Exporter;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;

import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;


/**
 * @author liya
 *
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

	/* (non-Javadoc)
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("ChangePackage");
		names.add("ModelElement");
		names.add("ReadView");
		names.add("SourceView");
		return names;
	}

	/* (non-Javadoc)
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		return values;
	}
	/**
	 * Analyze the give ProjectAnalysisData.
	 * @param data ProjectAnalysisData
	 * @param exporter Exporter
	 */
	public void analyzeData(ProjectAnalysisData data, Exporter exporter){
		for(ChangePackage change : data.getChangePackages()){
			
			for(Event event : change.getEvents()){
				//ReadeEvent
				if(event instanceof ReadEvent){
					List<Object> line = new ArrayList<Object>();
					ReadEvent readEvent = (ReadEvent) event;
					ModelElementId meId = readEvent.getModelElement();
					ModelElement me = data.getProjectState().getModelElement(meId);
					//add ChangePackage number
					line.add(data.getPrimaryVersionSpec().getIdentifier()-data.getChangePackages().size()+data.getChangePackages().indexOf(change));
					if(me != null && me.getClass().getName()!= null){
						line.add(me.getClass().getName());
					}else{line.add("-");}
					if(readEvent.getReadView()!=null){
						line.add(readEvent.getReadView());
					}else{line.add("-");
						Date currentTime = readEvent.getTimestamp();
						if(latestTime==null){
							latestTime=currentTime;
						}
						if(currentTime.after(latestTime)){
							latestTime=currentTime;
						}
					}
					if(readEvent.getSourceView()!=null){
						line.add(readEvent.getSourceView());
					}else{line.add("-");}
					try {
						exporter.writeLine(line);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void writeHeader(Exporter exporter) throws IOException {
		ArrayList<Object> line = new ArrayList<Object>();
		for(String name : this.getName()) {
			line.add(name);				
		}
		exporter.writeLine(line);
	}

}
