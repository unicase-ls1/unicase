/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.stem.views.iterationplanningview.IterationPlanningLabelProvider;

/**
 * . LabelProvider for Assigned to column in IterationPlanningView
 * 
 * @author Helming
 */
public class AssignedToLabelProvider extends IterationPlanningLabelProvider {

	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;

	/**
	 * . Constructor
	 */
	public AssignedToLabelProvider() {
		super();
		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		// jc: done
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		EObject assignee = getAssignee(element);
		if (assignee == null) {
			return null;
		}
		return adapterFactoryLabelProvider.getImage(assignee);
	}

	/**
	 * . returns the Assignee of an Assignable element
	 * 
	 * @param element the Assignable
	 * @return
	 */
	private EObject getAssignee(Object element) {
		if (element instanceof WorkItem) {
			return ((WorkItem) element).getAssignee();
		}
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		EObject assignee = getAssignee(element);
		if (assignee == null) {
			return "N/A";
		}
		return adapterFactoryLabelProvider.getText(assignee);
	}

	@Override
	public void dispose() {
		adapterFactoryLabelProvider.dispose();
		if (adapterFactoryLabelProvider.getAdapterFactory() instanceof IDisposable) {
			((IDisposable) adapterFactoryLabelProvider.getAdapterFactory()).dispose();

		}

		super.dispose();
	}

}
