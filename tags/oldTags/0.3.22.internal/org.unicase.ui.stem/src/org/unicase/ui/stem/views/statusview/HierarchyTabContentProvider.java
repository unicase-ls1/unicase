/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.task.util.TaxonomyAccess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This is the ContentProvider for TreeViewer on Hierarchy tab.
 * 
 * @author Hodaie
 */

public class HierarchyTabContentProvider extends AdapterFactoryContentProvider {

	private ModelElement root;

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
			Set<ModelElement> elementsForWorkPackage = getElementsForWorkPackage(object);
			return elementsForWorkPackage.toArray(new Object[elementsForWorkPackage.size()]);

		} else if (object instanceof ModelElement) {
			return getElementsForModelElement(object);

		} else {
			return super.getElements(object);
		}

	}

	/**
	 * . Returns all model elements being annotated by WorkItems contained in this WorkPackage.
	 * 
	 * @param object WorkPackage
	 * @return
	 */
	private Set<ModelElement> getElementsForWorkPackage(Object object) {

		Set<ModelElement> ret = new HashSet<ModelElement>();
		WorkPackage workPackage = (WorkPackage) object;
		List<WorkItem> containedWorkItems = workPackage.getAllContainedWorkItems();
		for (WorkItem workItem : containedWorkItems) {
			ret.addAll(workItem.getAnnotatedModelElements());
			if (workItem instanceof WorkPackage) {
				ret.addAll(getElementsForWorkPackage(workItem));
			}
		}
		return ret;
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

		ret.addAll(me.getAnnotations());
		return ret.toArray(new Object[ret.size()]);
	}

	/**
	 * . {@inheritDoc} Returns true if input has any openers of any Annotations
	 */
	@Override
	public boolean hasChildren(Object object) {
		if (!(object instanceof ModelElement)) {
			return super.hasChildren(object);
		}
		ModelElement modelElement = (ModelElement) object;
		if (viewer.getInput() instanceof WorkPackage) {
			WorkPackage workPackage = (WorkPackage) viewer.getInput();
			Set<ModelElement> allContainedModelElements = workPackage.getAllContainedModelElements();
			EList<Annotation> annotations = modelElement.getAnnotations();
			for (Annotation annotation : annotations) {
				if (allContainedModelElements.contains(annotation)) {
					return true;
				}
			}

		}
		List<Annotation> annotations = ((ModelElement) object).getAnnotations();
		Set<ModelElement> openers = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getOpeners(modelElement);
		return (annotations.size() > 0 || openers.size() > 0);

	}

	/**
	 * . {@inheritDoc} Returns super.getChildren plus any direct Annotations of the model element
	 */
	@Override
	public Object[] getChildren(Object object) {
		if (!(object instanceof ModelElement)) {
			return super.getChildren(object);
		}
		ModelElement modelElement = (ModelElement) object;
		List<ModelElement> ret = new ArrayList<ModelElement>();
		if (root instanceof WorkPackage) {
			WorkPackage workPackage = (WorkPackage) root;
			Set<WorkItem> relativeWorkItems = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
				.getRelativeWorkItems(workPackage, modelElement);

			return relativeWorkItems.toArray(new Object[ret.size()]);

		} else {

			Set<ModelElement> openers = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getOpeners(modelElement);
			ret.addAll(openers);

			return ret.toArray(new Object[ret.size()]);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		super.inputChanged(viewer, oldInput, newInput);

		// keep track of input to status view
		// this will be used in getAssignables() method
		this.root = (ModelElement) newInput;
	}

	/**
	 * Returns the model element currently open in status view.
	 * 
	 * @return the model element currently open in status view.
	 */
	public ModelElement getRoot() {
		return root;
	}

}
