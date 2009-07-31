/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.unicaseanalyzers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.unicase.analyzer.DataAnalyzer;
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

	/** 
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 * 
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("ChangePackage");
		names.add("ModelElement");
		names.add("ReadView");
		names.add("SourceView");
		return names;
	}

	/**
	 * @param data {@link ProjectAnalysisData}
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
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
	
	/**
	 * @param exporter @see {@link Exporter}
	 * @throws IOException @see {@link IOException}
	 */
	public void writeHeader(Exporter exporter) throws IOException {
		ArrayList<Object> line = new ArrayList<Object>();
		for(String name : this.getName()) {
			line.add(name);				
		}
		exporter.writeLine(line);
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
}
