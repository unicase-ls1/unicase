/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.statusview;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.Assignable;
import org.unicase.model.task.util.TaxonomyAccess;


/**.
 * 
 * This is the ContentProvider for Users tab.
 * 
 * @author Hodaie
 *
 */
public class UserTabContentProvider extends AdapterFactoryContentProvider {

	//input model element to status view
	private ModelElement input;
	
	/**.
	 * Constructor
	 */
	public UserTabContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		
		
	}

	
	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public Object[] getElements(Object object) {
		return getAssignees(object);
	}

	
	/**
	 * This returns a recursive list of all OrgUnits participating in progress
	 * of a model element.  
	 * 
	 * 
	 * @param object input model element
	 * @return
	 */
	private Object[] getAssignees(Object object) {
		Set<OrgUnit> ret = new HashSet<OrgUnit>();
		if (object instanceof ModelElement) {
			ModelElement me = (ModelElement) object;
			// first check the annotations of input object
			for (Annotation annotation : me.getAnnotations()) {
				if (annotation instanceof Assignable) {
					if (((Assignable) annotation).getAssignee() != null) {
						ret.add(((Assignable) annotation).getAssignee());
					}

				}
			}
			// then check its openers (the openers are considered hierarchical)
			Set<ModelElement> openers = TaxonomyAccess.getInstance()
					.getOpeningLinkTaxonomy().getOpenersRecursive(me);
			for (ModelElement opener : openers) {
				if (opener instanceof Assignable) {
					if (((Assignable) opener).getAssignee() != null) {
						ret.add(((Assignable) opener).getAssignee());
					}
				}
				// for every opener also check its annotations.
				for (Annotation annotation : opener.getAnnotations()) {
					if (annotation instanceof Assignable) {
						if (((Assignable) annotation).getAssignee() != null) {
							ret.add(((Assignable) annotation).getAssignee());
						}
					}
				}
			}
		}

		return ret.toArray(new Object[ret.size()]);
	}

	
	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public boolean hasChildren(Object object) {
		if(object instanceof OrgUnit){
			return getAssignables((OrgUnit)object).length > 0;
		}else{
			return super.hasChildren(object);
		}
		
				
	}

	
	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof OrgUnit) {
			return getAssignables((OrgUnit) object);
						
		} else {
			return super.getChildren(object);
		}

	}

	
	
	/**.
	 * 
	 * This goes through openers hierarchy and gathers all Assignables 
	 * assigned to this Assignee.
	 * I think it would be more convenient to change the model, so that
	 * any OrgUnit maintains a list of all its assigned tasks.
	 * 
	 * @param assignee OrgUnit assignee
	 * @return
	 */
	private Object[] getAssignables(OrgUnit assignee) {
		
		Set<Assignable> assignables = new HashSet<Assignable>();
		// first check the annotations
		// and if there's an assignable for this OrgUnit, then add it
		assignables.addAll(getAssignablesFromAnnotations(input, assignee));
		
		// then check its openers (hierarchical)
		Set<ModelElement> openers = TaxonomyAccess.getInstance()
				.getOpeningLinkTaxonomy().getOpenersRecursive(input);
		for (ModelElement opener : openers) {
			if (opener instanceof Assignable) {
				Assignable assignable = (Assignable) opener;
				if (assignable.getAssignee() !=null && assignable.getAssignee().equals(assignee)) {
					assignables.add(assignable);
				}
			}
			// for every opener also check its annotations.
			assignables.addAll(getAssignablesFromAnnotations(opener, assignee));
		}

		return assignables.toArray(new Object[assignables.size()]);
	}
	
	
	/**.
	 *  Find all the assignables for this OrgUnit in Annotations of ME 
	 * @param me ModelElement
	 * @param assignee OrgUnit
	 * @return
	 */
	private Set<Assignable> getAssignablesFromAnnotations(ModelElement me, OrgUnit assignee) {
		Set<Assignable> ret = new HashSet<Assignable>();
		for (Annotation annotation : me.getAnnotations()) {
			if (annotation instanceof Assignable) {
				Assignable assignable = (Assignable) annotation;
				if (assignable.getAssignee() !=null && assignable.getAssignee().equals(assignee)) {
					ret.add(assignable);
				}
			}
		}
		return ret;
	}


	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		super.inputChanged(viewer, oldInput, newInput);
	
		//keep track of input to status view
		//this will be used in getAssignables() method
		this.input = (ModelElement) newInput;
	}



}
