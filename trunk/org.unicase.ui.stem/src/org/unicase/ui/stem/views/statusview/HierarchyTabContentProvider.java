package org.unicase.ui.stem.views.statusview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.task.util.TaxonomyAccess;

public class HierarchyTabContentProvider extends AdapterFactoryContentProvider {

	public HierarchyTabContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		
	}

	@Override
	public Object[] getElements(Object object) {
		if (object instanceof WorkPackage) {
			Set<ModelElement> ret = new HashSet<ModelElement>();
			WorkPackage workPackage = (WorkPackage) object;
			List<WorkItem> containedWorkItems = workPackage
					.getContainedWorkItems();
			for (WorkItem workItem : containedWorkItems) {
				ret.addAll(workItem.getAnnotatedModelElements());
			}
			return ret.toArray(new Object[ret.size()]);
		}
		
		if (object instanceof ModelElement) {
			ModelElement me = (ModelElement) object;
			
			Set<ModelElement> openers = TaxonomyAccess.getInstance()
						.getOpeningLinkTaxonomy().getOpeners(me); 
			
			openers.addAll(me.getAnnotations());
			return openers.toArray(new Object[openers.size()]);
		} else{
				return super.getElements(object);
		}
		
	}

	@Override
	public boolean hasChildren(Object object) {
		
		if (object instanceof ModelElement) {
			ModelElement me = (ModelElement) object;
			List<Annotation> annotations = ((ModelElement) object)
					.getAnnotations();
			Set<ModelElement> openers = TaxonomyAccess.getInstance()
						.getOpeningLinkTaxonomy().getOpeners(me); 
			return (annotations.size() > 0 || openers.size() > 0);
		} else
			return super.hasChildren(object);
	}

	@Override
	public Object[] getChildren(Object object) {
		List<Object> children = new ArrayList<Object>();
		children.addAll(Arrays.asList(super.getChildren(object)));
		List<Annotation> annotations = ((ModelElement) object)
						.getAnnotations();
		
		children.addAll(annotations);
		
		
		return children.toArray(new Object[children.size()]);
	}
	
	

}
