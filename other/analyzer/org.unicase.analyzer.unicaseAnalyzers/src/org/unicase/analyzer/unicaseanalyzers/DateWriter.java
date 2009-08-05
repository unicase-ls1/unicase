/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.unicaseanalyzers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
	 * Constructor of DateWriter.
	 * @param projectIterator VersionIterator
	 */
	public DateWriter(VersionIterator projectIterator){
		this.projectIterator = projectIterator;
		this.date = new Date();
		this.format = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss Z");
		this.calendar = Calendar.getInstance();
	}
	
	
	/**
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 * 
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("Date");
		return names;
	}

	/**
	 * @param data {@link ProjectAnalysisData}
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		if(projectIterator instanceof TimeIterator){
			TimeIterator it = (TimeIterator) projectIterator;
			calendar.setTime(it.getDateSpec().getDate());
		}
		else{
			List<ChangePackage> changepackages = data.getChangePackages();
			if(data.getChangePackages() != null && data.getChangePackages().size() != 0) {
				ChangePackage changePackage = changepackages.get(changepackages.size()-1);
				if( changePackage !=null) {
					setTime(changePackage);
				}
			}
		}
		date = calendar.getTime();
		values.add(format.format(date));
		return values;
	}
	
	private void setTime(ChangePackage changePackage){
		if(changePackage.getLogMessage() != null) {
			if(changePackage.getLogMessage().getDate() != null) {
				calendar.setTime(changePackage.getLogMessage().getDate());
			}
		}
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
