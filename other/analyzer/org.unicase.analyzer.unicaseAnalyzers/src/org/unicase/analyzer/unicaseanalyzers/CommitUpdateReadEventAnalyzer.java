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
import org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.emfstore.esmodel.versioning.events.UpdateEvent;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelElementId;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Check the time of the Commit, update, and read event for the same ME.
 * @author liya
 *
 */
public class CommitUpdateReadEventAnalyzer implements TwoDDataAnalyzer {


	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.TwoDDataAnalyzer#get2DValue(org.unicase.analyzer.ProjectAnalysisData, org.unicase.analyzer.iterator.VersionIterator)
	 */
	
	public List<List<Object>> get2DValue(ProjectAnalysisData data, VersionIterator it) {
		List<List<Object>> values = new ArrayList<List<Object>>();
		
		PrimaryVersionSpec base;
		PrimaryVersionSpec target;
		Map<ModelElementId, Date> meIdMap = null;
		Map<ModelElementId, Date> commitMap = null;
		String user;
		
		for(ChangePackage change : data.getChangePackages()){
			user = change.getLogMessage().getAuthor();
			meIdMap = new HashMap<ModelElementId, Date>();
			commitMap = new HashMap<ModelElementId, Date>();
			for(Event event : change.getEvents()){
				//UpdateEvent
				if(event instanceof UpdateEvent || event instanceof CheckoutEvent){
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
						for(ChangePackage updateChange : updateChanges){
							for(AbstractOperation op : updateChange.getOperations()){
								meIdMap.put(op.getModelElementId(), event.getTimestamp());
								commitMap.put(op.getModelElementId(), updateChange.getLogMessage().getDate());
							}
						}

					} catch (EmfStoreException e) {
						String message = "Could not get changes from server";
						WorkspaceUtil.logException(message, e);
						throw new NoSuchElementException(message + ":\n" + e);
					}
				}

				//ReadEvent
				if(event instanceof ReadEvent){
					ReadEvent readEvent = (ReadEvent) event;
					ModelElementId meId = readEvent.getModelElement();
					if(meIdMap != null){
						if(meIdMap.containsKey(meId)){
							List<Object> line = addLine(meId, user, commitMap, meIdMap, readEvent);						
							values.add(line);
						}
					}
				}
			}
		}
		return values;
	}
	

	private List<Object> addLine(ModelElementId meId, String user, Map<ModelElementId, Date> commitMap, Map<ModelElementId, Date> meIdMap, ReadEvent readEvent){
		List<Object> line = new ArrayList<Object>();
		line.add(meId);
		line.add(user);
		line.add(commitMap.get(meId));//commit time
		line.add(meIdMap.get(meId));//update time
		line.add(readEvent.getTimestamp());//read time
		
		long time = readEvent.getTimestamp().getTime() - commitMap.get(meId).getTime();
		Date diff = new Date(time);		
		line.add(diff.getTime());

		time = meIdMap.get(meId).getTime() - commitMap.get(meId).getTime();
		diff.setTime(time);//Time difference between update and commit the same ME
		line.add(diff.getTime());
		
		return line;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.DataAnalyzer#getName()
	 */
	
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("ModelElementId");	
		names.add("User");
		names.add("Commit Time");
		names.add("Update Time");
		names.add("Read Time");
		names.add("Commit-Read Time Difference");
		names.add("Update-Commit Time Difference");
		return names;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	
	public List<Object> getValue(ProjectAnalysisData data) {
		throw new UnsupportedOperationException();
	}


	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#isExportOnce()
	 */
	
	public boolean isExportOnce() {
		return false;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eAllContents()
	 */
	
	public TreeIterator<EObject> eAllContents() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eClass()
	 */
	
	public EClass eClass() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eContainer()
	 */
	
	public EObject eContainer() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eContainingFeature()
	 */
	
	public EStructuralFeature eContainingFeature() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eContainmentFeature()
	 */
	
	public EReference eContainmentFeature() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eContents()
	 */
	
	public EList<EObject> eContents() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eCrossReferences()
	 */
	
	public EList<EObject> eCrossReferences() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	
	public Object eGet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature, boolean)
	 */
	
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eIsProxy()
	 */
	
	public boolean eIsProxy() {
		// TODO Auto-generated method stub
		return false;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eIsSet(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	
	public boolean eIsSet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return false;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eResource()
	 */
	
	public Resource eResource() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eSet(org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
	 */
	
	public void eSet(EStructuralFeature feature, Object newValue) {
		// TODO Auto-generated method stub
		
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.EObject#eUnset(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	
	public void eUnset(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.notify.Notifier#eAdapters()
	 */
	
	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.notify.Notifier#eDeliver()
	 */
	
	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.notify.Notifier#eNotify(org.eclipse.emf.common.notify.Notification)
	 */
	
	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub
		
	}


	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.notify.Notifier#eSetDeliver(boolean)
	 */
	
	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub
		
	}


	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.TwoDDataAnalyzer#analyzeData(org.unicase.analyzer.ProjectAnalysisData, org.unicase.analyzer.iterator.VersionIterator)
	 */
	
	public void analyzeData(ProjectAnalysisData data,
			org.unicase.analyzer.iterator.VersionIterator it) {
		// TODO Auto-generated method stub
		
	}

}
