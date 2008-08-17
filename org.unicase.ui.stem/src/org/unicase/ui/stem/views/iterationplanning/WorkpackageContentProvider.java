/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.iterationplanning;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.WorkspaceManager;

public class WorkpackageContentProvider extends
		TransactionalAdapterFactoryContentProvider {

	public static final int FLAT_GROUP = 0;
	public static final int USER_GROUP = 1;
	public static final int ANNOTATED_GROUP = 2;
	int groupBy = FLAT_GROUP;

	public WorkpackageContentProvider() {
		super(WorkspaceManager.getInstance().getCurrentWorkspace()
				.getEditingDomain(), new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	@Override
	public Object[] getElements(Object object) {
		if (object instanceof Project) {
			return ((Project) object).getAllModelElementsbyClass(
					TaskPackage.eINSTANCE.getWorkPackage(),
					new BasicEList<WorkPackage>()).toArray();
		}
		return super.getElements(object);
	}

	@Override
	public Object[] getChildren(Object object) {
		switch (groupBy) {
		case FLAT_GROUP: {
			return super.getChildren(object);
		}
		case USER_GROUP: {
			return getUserGroupChildren(object);
		}
		case ANNOTATED_GROUP: {
			return getAnnotatedGroupChildren(object);
		}
		default: {
			return super.getChildren(object);
		}
		}

	}

	
	private Object[] getUserGroupChildren(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object object) {
		switch (groupBy) {
		case FLAT_GROUP: {
			return super.hasChildren(object);
		}
		case USER_GROUP: {
			return hasUserGroupChildren(object);
		}
		case ANNOTATED_GROUP: {
			return hasAnnotatedGroupChildren(object);
		}
		default: {
			return super.hasChildren(object);
		}
		}
	}

	private boolean hasAnnotatedGroupChildren(Object object) {
		if (object instanceof WorkPackage) {
			return super.hasChildren(object);
		}
		if (object instanceof ModelElement) {
			List<Annotation> annotations = ((ModelElement) object)
					.getAnnotations();
			return (annotations.size() > 0);
		} else
			return super.hasChildren(object);
	}

	private boolean hasUserGroupChildren(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	private Object[] getAnnotatedGroupChildren(Object object) {

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
			List<Annotation> annotations = me.getAnnotations();
			Object parent = getParent(me);
			return annotations.toArray(new Object[annotations.size()]);
		} else
			return super.getChildren(object);
	}

	public int getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(int groupBy) {
		this.groupBy = groupBy;
	}
}
