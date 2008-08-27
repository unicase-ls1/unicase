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

public class UserTabContentProvider extends AdapterFactoryContentProvider {

	private ModelElement input;
	
	

	public UserTabContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		
		
	}

	
	@Override
	public Object[] getElements(Object object) {
		return getAssignees(object);
	}

	
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
			// then check its openers
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

	@Override
	public boolean hasChildren(Object object) {
		if(object instanceof OrgUnit){
			return getAssignables((OrgUnit)object).length > 0;
		}else{
			return super.hasChildren(object);
		}
		
				
	}

	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof OrgUnit) {
			return getAssignables((OrgUnit) object);
						
		} else {
			return super.getChildren(object);
		}

	}

	private Object[] getAssignables(OrgUnit assignee) {
		
		Set<Assignable> assignables = new HashSet<Assignable>();
		// first check the annotations
		// and if there's an assignable for this OrgUnit, then add it
		for (Annotation annotation : input.getAnnotations()) {
			if (annotation instanceof Assignable) {
				Assignable assignable = (Assignable) annotation;
				if (assignable.getAssignee() !=null && assignable.getAssignee().equals(assignee)) {
					assignables.add(assignable);
				}
			}
		}

		// then check its openers
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
			for (Annotation annotation : opener.getAnnotations()) {
				if (annotation instanceof Assignable) {
					Assignable assignable = (Assignable) annotation;
					if (assignable.getAssignee() !=null && assignable.getAssignee().equals(assignee)) {
						assignables.add(assignable);
					}
				}
			}
		}

		return assignables.toArray(new Object[assignables.size()]);
	}
	
	

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		super.inputChanged(viewer, oldInput, newInput);
		this.input = (ModelElement) newInput;
	}



}
