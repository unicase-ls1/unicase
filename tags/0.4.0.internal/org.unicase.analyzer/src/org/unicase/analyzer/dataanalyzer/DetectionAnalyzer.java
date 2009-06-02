/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.dataanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.util.BasicEList;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.VersionIterator;
import org.unicase.analyzer.exporter.Exporter;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.emfstore.esmodel.versioning.events.UpdateEvent;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
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

	private String funcRequirement;
	
	/**
	 * Constructor of DetectionAnalyzer. A special analyzer for detecting the 
	 * update time and read time for each user, after a modelElement has been modified.
	 * @param funcRequirement given FunctionalRequirement for detecting.
	 * @param it VersionIterator.
	 */
	public DetectionAnalyzer(String funcRequirement, VersionIterator it){
		
		this.funcRequirement = funcRequirement;
		this.users = new ArrayList<String>();
		this.update = new ArrayList<Date>();
		this.read = new ArrayList<Date>();
		this.view = new ArrayList<String>();
		this.diff = new ArrayList<Date>();
		
		List<User> userElist = new ArrayList<User>();
		try {
			Project project = it.getConnectionManager().getProject(it.getUsersession().getSessionId(), it.getProjectId(), VersioningFactory.eINSTANCE.createHeadVersionSpec());
			userElist = project.getAllModelElementsbyClass(OrganizationFactory.eINSTANCE.createUser().eClass(), new BasicEList<User>());
			for(User user : userElist){
				this.users.add(user.getName());
			}
		} catch (EmfStoreException e) {
			String message = "Could not get changes from server";
			WorkspaceUtil.logException(message, e);
			throw new NoSuchElementException(message + ":\n" + e);
		}
		
		for(int i=0; i<users.size();i++){
			update.add(null);
			read.add(null);
			view.add(null);
			diff.add(null);
		}
		
	
	}
	/**
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 * 
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

	/**
	 * @param data {@link ProjectAnalysisData}
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = this.getValue();
		return values;
	}

	/**
	 * Analyze the given ProjectAnalysisData.
	 * @param data ProjectAnalysisData
	 * @param it VersionIterator
	 */
	public void analyzeData(ProjectAnalysisData data, VersionIterator it){
		Date updateDate = new Date();
		
		PrimaryVersionSpec base;
		PrimaryVersionSpec target;
		Map<ModelElementId, Date> meIdMap = null;//Map for the ModelElement candidates
		
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
								if(base.getIdentifier()- 20 > 0){
									target.setIdentifier(base.getIdentifier()- 20); //just consider the last 20 revisions
								}
								else{
									target.setIdentifier(0);
								}
							}
							// just store the earliest update date for each user
//							if(update.get(index)== null || update.get(index).after(updateDate)){
//								update.set(index, updateDate);
//							}
							try {
								List<ChangePackage> updateChanges = it.getConnectionManager().getChanges(it.getUsersession().getSessionId(), 
									it.getProjectId(), base, target);
								//Map for the ModelElement candidates
								meIdMap = new HashMap<ModelElementId, Date>();
								for(ChangePackage updateChange : updateChanges){
									for(AbstractOperation op : updateChange.getOperations()){
										meIdMap.put(op.getModelElementId(), event.getTimestamp());
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
					}
				}
			}
		}			
	}
	
	// check the ReadEvent reads the given FunctionalRequirements or not, if yes, record the ReadDate and ReadView
	private void checkReadEvent(int index, ModelElementId meId, Map<ModelElementId, Date> meIdMap, 
		ReadEvent readEvent, ProjectAnalysisData data){
		Date readDate = new Date();
		if(meIdMap != null){
			if(meIdMap.containsKey(meId)){
				ModelElement me = data.getProjectState().getModelElement(meId);
				if(me instanceof FunctionalRequirement && me.getName().contains(funcRequirement)){
					readDate = readEvent.getTimestamp();
					// just store the earliest read date for each user
					if(read.get(index)== null || read.get(index).after(readDate)){
						update.set(index, meIdMap.get(meId));
						read.set(index, readDate);
						view.set(index, readEvent.getReadView());
						Date diffDate = new Date(read.get(index).getTime()-update.get(index).getTime());
						diff.set(index, diffDate);
					}
				}
			}
		}
	}
	/**
	 * Export the analysis result to the given exporter.
	 * @param exporter Exporter
	 * @throws IOException @see {@link IOException}
	 */
	public void runAnalysis(Exporter exporter) throws IOException {
		
		List<Object> values =  getValue();
		int columnsNumber = getName().size();
		int linesNumber = values.size()/columnsNumber;
		
		for(int i = 0; i < linesNumber; i++){
			List<Object> line = new ArrayList<Object>();
			for(int j = 0; j < columnsNumber; j++){
				line.add(values.get(i*columnsNumber+j));
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
				values.add(update.get(index));
			}else{
				values.add("-");
			}
			if(read.get(index) != null){
				values.add(read.get(index));
			}else{
				values.add("-");
			}
			if(view.get(index) != null){
				values.add(view.get(index));
			}else{
				values.add("-");
			}
			if(diff.get(index) != null){
				values.add(diff.get(index).getTime());
			}else{
				values.add("-");
			}
		}
		return values;
	}

}
