/**
 * 
 */
package org.unicase.analyzer.dataanalyzer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.exporter.Exporter;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.emfstore.esmodel.versioning.events.UpdateEvent;
import org.unicase.model.ModelElementId;
import org.unicase.model.requirement.FunctionalRequirement;


/**
 * @author liya
 *
 */
public class DetectionAnalyzer implements DataAnalyzer {

	private List<String> users;
	private List<Date> update;
	private List<Date> read;
	private List<String> sender;
	private List<Date> diff;

	private DateFormat format;
	private DateFormat diffFormat;
	
	/**
	 * Constructor of DetectionAnalyzer. A special analyzer for detecting the 
	 * update time and read time for each user, after a modelElement has been modified.
	 * @param users List of given users
	 */
	public DetectionAnalyzer(List<String> users){

		this.users = users;
		this.update = new ArrayList<Date>();
		this.read = new ArrayList<Date>();
		this.sender = new ArrayList<String>();
		this.diff = new ArrayList<Date>();
		for(int i=0; i<users.size();i++){
			update.add(null);
			read.add(null);
			sender.add(null);
			diff.add(null);
		}
		
		this.format = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss Z");
		this.diffFormat = new SimpleDateFormat("D 'days' HH:mm:ss");
	
	}
	/* (non-Javadoc)
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("User");
		names.add("Update Time");
		names.add("Read Time");
		names.add("Sender");
		names.add("Time Difference");
		return names;
	}

	/* (non-Javadoc)
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = this.getValue();
		return values;
	}

	/**
	 * Analyze the give ProjectAnalysisData.
	 * @param data ProjectAnalysisData
	 */
	public void analyzeData(ProjectAnalysisData data){
		Date updateDate = new Date();
		Date readDate = new Date();
		for(ChangePackage change : data.getChangePackages()){
			for(String user : users){
				int index = users.indexOf(user);
				if(change.getLogMessage().getAuthor().equals(user)){
					for(Event event : change.getEvents()){
						//UpdateEvent
						if(event instanceof UpdateEvent){
							updateDate = event.getTimestamp();
							// just store the earliest update date for each user
							if(update.get(index)== null || update.get(index).after(updateDate)){
								update.set(index, updateDate);
							}
						}
						//ReadeEvent
						else if(event instanceof ReadEvent){
							ReadEvent readEvent = (ReadEvent) event;
							ModelElementId meId = readEvent.getModelElement();
							if(data.getProjectState().getModelElement(meId) instanceof FunctionalRequirement){
								readDate = event.getTimestamp();
								// just store the earliest read date for each user
								if(read.get(index)== null || read.get(index).after(readDate)){
									read.set(index, readDate);
									sender.set(index, readEvent.getReadView());
								}
							}
						}
					}
				}
				if(read.get(index)!=null && update.get(index)!=null){
					Date diffDate = new Date(read.get(index).getTime()-update.get(index).getTime());
					diff.set(index, diffDate);
				}
			}			
		}
	}
	
	/**
	 * Export the analysis result to the given exporter.
	 * @param exporter Exporter
	 * @throws IOException
	 */
	public void runAnalysis(Exporter exporter) throws IOException {
		
		List<Object> values =  getValue();
		int linesNumber = values.size()/5;
		
		for(int i = 0; i < linesNumber; i++){
			List<Object> line = new ArrayList<Object>();
			for(int j = 0; j < 5; j++){
				line.add(values.get(i*linesNumber+j));
			}
			exporter.writeLine(line);
		}
	}
	
	// Store the 2 dimensional table as an 1 dimensional array
	private List<Object> getValue() {
		List<Object> values = new ArrayList<Object>();

		for(String user : users){
			int index = users.indexOf(user);
						
			values.add(user);
			if(update.get(index) != null){
				values.add(format.format(update.get(index)));
			}else{
				values.add("-");
			}
			if(read.get(index) != null){
				values.add(format.format(read.get(index)));
			}else{
				values.add("-");
			}
			if(sender.get(index) != null){
				values.add(sender.get(index));
			}else{
				values.add("-");
			}
			if(diff.get(index) != null){
				values.add(diffFormat.format(diff.get(index)));
			}else{
				values.add("-");
			}
		}
		return values;
	}

}
