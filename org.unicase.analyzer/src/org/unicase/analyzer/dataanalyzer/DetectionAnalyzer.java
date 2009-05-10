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
import java.util.NoSuchElementException;

import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.VersionIterator;
import org.unicase.analyzer.exporter.Exporter;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.emfstore.esmodel.versioning.events.UpdateEvent;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.ActionItem;
import org.unicase.workspace.util.WorkspaceUtil;


/**
 * @author liya
 *
 */
public class DetectionAnalyzer implements DataAnalyzer {

	private List<String> users;
	private List<Date> update;
	private List<Date> read;
	private List<String> view;
	private List<Date> diff;

	private DateFormat format;
	private DateFormat diffFormat;
	private List<String> funcRequirements;
	
	/**
	 * Constructor of DetectionAnalyzer. A special analyzer for detecting the 
	 * update time and read time for each user, after a modelElement has been modified.
	 * @param users List of given users
	 * @param funcRequirements List of given FunctionalRequirements of 
	 * each user for detecting.
	 */
	public DetectionAnalyzer(List<String> users, List<String> funcRequirements){

		this.users = users;
		this.funcRequirements = funcRequirements;
		this.update = new ArrayList<Date>();
		this.read = new ArrayList<Date>();
		this.view = new ArrayList<String>();
		this.diff = new ArrayList<Date>();
		for(int i=0; i<users.size();i++){
			update.add(null);
			read.add(null);
			view.add(null);
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
		names.add("Read View");
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
	 * @param It VersionIterator
	 */
	public void analyzeData(ProjectAnalysisData data, VersionIterator It){
		Date updateDate = new Date();
		
		PrimaryVersionSpec base;
		PrimaryVersionSpec target;
		List<ModelElementId> meIdMap = null;//Map for the ModelElement candidates
		
		for(ChangePackage change : data.getChangePackages()){
			for(String user : users){
				int index = users.indexOf(user);
				if(change.getLogMessage().getAuthor().equals(user)){
					for(Event event : change.getEvents()){
						//UpdateEvent
						if(event instanceof UpdateEvent || event instanceof CheckoutEvent){
							updateDate = event.getTimestamp();
							if(event instanceof UpdateEvent){
								base = ((UpdateEvent) event).getBaseVersion();
								target = ((UpdateEvent) event).getTargetVersion();
							}
							else{
								base = ((CheckoutEvent) event).getBaseVersion();
								target = EsModelUtil.clone(base);
								target.setIdentifier(base.getIdentifier()- 20); //just consider the last 10 revisions
							}
							// just store the earliest update date for each user
							if(update.get(index)== null || update.get(index).after(updateDate)){
								update.set(index, updateDate);
							}
							try {
								List<ChangePackage> updateChanges = It.getConnectionManager().getChanges(It.getUsersession().getSessionId(), 
									It.getProjectId(), base, target);
								//Map for the ModelElement candidates
								meIdMap = new ArrayList<ModelElementId>();
								for(ChangePackage updateChange : updateChanges){
									for(AbstractOperation op : updateChange.getOperations()){
										meIdMap.add(op.getModelElementId());
									}
								}

							} catch (EmfStoreException e) {
								String message = "Could not get changes from server";
								WorkspaceUtil.logException(message, e);
								throw new NoSuchElementException(message + ":\n" + e);
							}
						}
						//ReadEvent
						else if(event instanceof ReadEvent){
							ReadEvent readEvent = (ReadEvent) event;
							ModelElementId meId = readEvent.getModelElement();
							checkReadEvent(index, meId, meIdMap, readEvent, data);
						}
						if(read.get(index)!=null && update.get(index)!=null){
							Date diffDate = new Date(read.get(index).getTime()-update.get(index).getTime());
							diff.set(index, diffDate);
						}
					}
				}
			}
		}			
	}
	
	// check the ReadEvent reads the given FunctionalRequirements not, if yes, record the ReadDate and ReadView
	private void checkReadEvent(int index, ModelElementId meId, List<ModelElementId> meIdMap, 
		ReadEvent readEvent, ProjectAnalysisData data){
		Date readDate = new Date();
		if(meIdMap != null){
			if(meIdMap.contains(meId)){
				ModelElement me = data.getProjectState().getModelElement(meId);
				if(me instanceof FunctionalRequirement && me.getName().contains(funcRequirements.get(index))){
					readDate = readEvent.getTimestamp();
					// just store the earliest read date for each user
					if(read.get(index)== null || read.get(index).after(readDate)){
						read.set(index, readDate);
						view.set(index, readEvent.getReadView());
					}
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
			if(view.get(index) != null){
				values.add(view.get(index));
			}else{
				values.add("-");
			}
			if(diff.get(index) != null){
				//values.add(diffFormat.format(diff.get(index)));
				values.add(diff.get(index).getTime());
			}else{
				values.add("-");
			}
		}
		return values;
	}

}
