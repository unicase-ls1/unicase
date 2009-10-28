/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.iterationplanningview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.unicase.metamodel.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.WorkspaceManager;

/**
 * Example for a ganttchart item provider.
 * 
 * @author helming
 */
public class GantItemProvider extends TransactionalAdapterFactoryContentProvider implements IContentProvider {
	/**
	 * Comapartor to order workpackages by their name.
	 * 
	 * @author helming
	 */
	public class WPComparator implements Comparator<EObject> {
		/**
		 * {@inheritDoc}
		 */
		public int compare(EObject o1, EObject o2) {
			WorkPackage wp1 = (WorkPackage) o1;
			WorkPackage wp2 = (WorkPackage) o2;
			return wp1.getName().compareTo(wp2.getName());
		}

	}

	/**
	 * default constructor.
	 */
	public GantItemProvider() {
		super(WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain(), new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * . {@inheritDoc} returns WorkPackages contained in a Project
	 */
	@Override
	public Object[] getElements(Object object) {
		List<EObject> ret = new ArrayList<EObject>();
		if (object instanceof Project) {
			Project project = (Project) object;
			EList<WorkPackage> allModelElementsbyClass = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE
				.getWorkPackage(), new BasicEList<WorkPackage>());
			for (WorkPackage workPackage : allModelElementsbyClass) {
				if (workPackage.getContainingWorkpackage() == null) {
					ret.add(workPackage);
				}
			}

		}
		Collections.sort(ret, new WPComparator());
		return ret.toArray();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object object) {
		Object[] children = super.getChildren(object);
		List<Object> ret = new ArrayList<Object>();
		for (Object child : children) {
			if (child instanceof WorkPackage) {
				ret.add(child);
			}
		}
		return ret.toArray();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object object) {
		Object[] children = super.getChildren(object);
		List<Object> ret = new ArrayList<Object>();
		for (Object child : children) {
			if (child instanceof WorkPackage) {
				ret.add(child);
			}
		}
		return (ret.size() > 0);
	}

}
