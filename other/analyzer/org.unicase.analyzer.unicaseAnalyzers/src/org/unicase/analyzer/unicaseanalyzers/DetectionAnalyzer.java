/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.unicaseanalyzers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.TwoDDataAnalyzer;
import org.unicase.analyzer.iterator.VersionIterator;
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
public class DetectionAnalyzer implements TwoDDataAnalyzer {

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
	 * @param it VersionIterator
	 */
	public DetectionAnalyzer(String funcRequirement, VersionIterator it){
		
		this.funcRequirement = funcRequirement;
		this.users = new ArrayList<String>();
		this.update = new ArrayList<Date>();
		this.read = new ArrayList<Date>();
		this.view = new ArrayList<String>();
		this.diff = new ArrayList<Date>();
		
		getUsers(it);
		
	}


	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.DataAnalyzer#getName()
	 */
	@Override
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("User");
		names.add("Update Time");
		names.add("Read Time");
		names.add("Read View");
		names.add("Time Difference");
		return names;
	}

	private void getUsers(VersionIterator it){
		
		List<User> userList = new ArrayList<User>();
		try {
			Project project = it.getConnectionManager().getProject(it.getUsersession().getSessionId(), it.getProjectId(), VersioningFactory.eINSTANCE.createHeadVersionSpec());
			userList = project.getAllModelElementsbyClass(OrganizationFactory.eINSTANCE.createUser().eClass(), new BasicEList<User>());
			for(User user : userList){
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
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.TwoDDataAnalyzer#analyzeData(org.unicase.analyzer.ProjectAnalysisData, org.unicase.analyzer.iterator.VersionIterator)
	 */
	@Override
	public void analyzeData(ProjectAnalysisData data, VersionIterator it){

		Map<ModelElementId, Date> meIdMap = null;//Map for the ModelElement candidates
		
		for(ChangePackage change : data.getChangePackages()){
			for(String user : users){
				int index = users.indexOf(user);
				if(change.getLogMessage().getAuthor().equals(user)){
					for(Event event : change.getEvents()){
						//UpdateEvent
						if(event instanceof UpdateEvent || event instanceof CheckoutEvent){
							meIdMap = generateMeIdMap(it, event);							
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
	
	private Map<ModelElementId, Date> generateMeIdMap(VersionIterator it, Event event){
		PrimaryVersionSpec base;
		PrimaryVersionSpec target;
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
		try {
			List<ChangePackage> updateChanges = it.getConnectionManager().getChanges(it.getUsersession().getSessionId(), 
				it.getProjectId(), base, target);
			//Map for the ModelElement candidates
			Map<ModelElementId, Date> meIdMap = new HashMap<ModelElementId, Date>();
			for(ChangePackage updateChange : updateChanges){
				for(AbstractOperation op : updateChange.getOperations()){
					meIdMap.put(op.getModelElementId(), event.getTimestamp());
				}
			}
			return meIdMap;

		} catch (EmfStoreException e) {
			String message = "Could not get changes from server";
			WorkspaceUtil.logException(message, e);
			throw new NoSuchElementException(message + ":\n" + e);
		}
	}
	
	// check the ReadEvent reads the given FunctionalRequirements or not, if yes, record the ReadDate and ReadView
	private void checkReadEvent(int index, ModelElementId meId, Map<ModelElementId, Date> meIdMap, 
		ReadEvent readEvent, ProjectAnalysisData data){
		if(meIdMap != null){
			if(meIdMap.containsKey(meId)){
				ModelElement me = data.getProjectState().getModelElement(meId);
				if(me instanceof FunctionalRequirement && me.getName().contains(funcRequirement)){
					record(meId, meIdMap, index, readEvent);
				}
			}
		}
	}
	
	private void record(ModelElementId meId, Map<ModelElementId, Date> meIdMap, int index, ReadEvent readEvent){
		Date readDate = readEvent.getTimestamp();
		// just store the earliest read date for each user
		if(read.get(index)== null || read.get(index).after(readDate)){
			update.set(index, meIdMap.get(meId));
			read.set(index, readDate);
			view.set(index, readEvent.getReadView());
			Date diffDate = new Date(read.get(index).getTime()-update.get(index).getTime());
			diff.set(index, diffDate);
		}
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.dataanalyzer.TwoDDataAnalyzer#get2DValue(org.unicase.analyzer.ProjectAnalysisData, org.unicase.analyzer.VersionIterator)
	 */
	@Override
	public List<List<Object>> get2DValue(ProjectAnalysisData data, VersionIterator it) {
		List<List<Object>> values = new ArrayList<List<Object>>();	

		for(String user : users){
			List<Object> line = new ArrayList<Object>();
			int index = users.indexOf(user);
					
			line.add(user);
			if(update.get(index) != null){
				line.add(update.get(index));
			}else{
				line.add("-");
			}
			if(read.get(index) != null){
				line.add(read.get(index));
			}else{
				line.add("-");
			}
			if(view.get(index) != null){
				line.add(view.get(index));
			}else{
				line.add("-");
			}
			if(diff.get(index) != null){
				line.add(diff.get(index).getTime());
			}else{
				line.add("-");
			}
			values.add(line);
		}
		return values;
	}
	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		throw new UnsupportedOperationException();
	}
	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#isExportOnce()
	 */
	public boolean isExportOnce() {
		return true;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eAllContents()
	 */
	@Override
	public TreeIterator<EObject> eAllContents() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eClass()
	 */
	@Override
	public EClass eClass() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eContainer()
	 */
	@Override
	public EObject eContainer() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eContainingFeature()
	 */
	@Override
	public EStructuralFeature eContainingFeature() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eContainmentFeature()
	 */
	@Override
	public EReference eContainmentFeature() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eContents()
	 */
	@Override
	public EList<EObject> eContents() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eCrossReferences()
	 */
	@Override
	public EList<EObject> eCrossReferences() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	@Override
	public Object eGet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature, boolean)
	 */
	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eIsProxy()
	 */
	@Override
	public boolean eIsProxy() {
		// TODO Auto-generated method stub
		return false;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eIsSet(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return false;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eResource()
	 */
	@Override
	public Resource eResource() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eSet(org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
	 */
	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		// TODO Auto-generated method stub
		
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eUnset(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	@Override
	public void eUnset(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.notify.Notifier#eAdapters()
	 */
	@Override
	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.notify.Notifier#eDeliver()
	 */
	@Override
	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.notify.Notifier#eNotify(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub
		
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.notify.Notifier#eSetDeliver(boolean)
	 */
	@Override
	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub
		
	}

}
