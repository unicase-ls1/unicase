/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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

/**
 * . This is the ContentProvider for TreeViewer on Hierarchy tab.
 * 
 * @author Hodaie
 */

public class HierarchyTabContentProvider extends AdapterFactoryContentProvider {

	/**
	 * . Constructor
	 */
	public HierarchyTabContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public Object[] getElements(Object object) {
		if (object instanceof WorkPackage) {
			return getElementsForWorkPackage(object);

		} else if (object instanceof ModelElement) {
			return getElementsForModelElement(object);

		} else {
			return super.getElements(object);
		}

	}

	/**
	 * . Returns all model elements being annotated by WorkItems contained in this WorckPackage.
	 * 
	 * @param object WorkPackage
	 * @return
	 */
	private Object[] getElementsForWorkPackage(Object object) {

		Set<ModelElement> ret = new HashSet<ModelElement>();
		WorkPackage workPackage = (WorkPackage) object;
		List<WorkItem> containedWorkItems = workPackage.getContainedWorkItems();
		for (WorkItem workItem : containedWorkItems) {
			ret.addAll(workItem.getAnnotatedModelElements());
		}
		return ret.toArray(new Object[ret.size()]);
	}

	/**
	 * . Returns all openers of input element. I believe that for a model element as input there should also be an
	 * implementation like that of a WorkPackage, i.e. for every opener that is an Annotation, instead of this opener
	 * its annotated model elements should be shown. This is implemented but currently commented out.
	 * 
	 * @param object model element
	 * @return
	 */
	private Object[] getElementsForModelElement(Object object) {
		ModelElement me = (ModelElement) object;

		Set<ModelElement> openers = new HashSet<ModelElement>();
		openers.addAll(TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getOpeners(me));

		Set<ModelElement> ret = new HashSet<ModelElement>();
		ret.addAll(openers);

		// for(ModelElement opener : openers){
		// if(opener instanceof Annotation){
		// Annotation annotation = (Annotation) opener;
		// if(annotation.getAnnotatedModelElements().size() > 0){
		// ret.remove(annotation);
		// ret.addAll(annotation.getAnnotatedModelElements());
		// }
		// }
		// }

		ret.addAll(me.getAnnotations());
		return ret.toArray(new Object[ret.size()]);
	}

	/**
	 * . {@inheritDoc} Returns true if input has any openers of any Annotations
	 */
	@Override
	public boolean hasChildren(Object object) {

		if (object instanceof ModelElement) {
			ModelElement me = (ModelElement) object;
			List<Annotation> annotations = ((ModelElement) object).getAnnotations();
			Set<ModelElement> openers = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getOpeners(me);
			return (annotations.size() > 0 || openers.size() > 0);

		} else {
			return super.hasChildren(object);
		}

	}

	/**
	 * . {@inheritDoc} Returns super.getChildren plus any direct Annotations of the model element
	 */
	@Override
	public Object[] getChildren(Object object) {
		List<Object> children = new ArrayList<Object>();
		children.addAll(Arrays.asList(super.getChildren(object)));
		List<Annotation> annotations = ((ModelElement) object).getAnnotations();

		children.addAll(annotations);

		return children.toArray(new Object[children.size()]);
	}

}
