/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.unicase.model.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.WorkspaceManager;

public class WorkpackageContentProvider extends
		TransactionalAdapterFactoryContentProvider {

	public WorkpackageContentProvider() {
		super(WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain(),
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	@Override
	public Object[] getChildren(Object object) {
		// TODO Auto-generated method stub
		return super.getChildren(object);
	}

	@Override
	public Object[] getElements(Object object) {
		if (object instanceof Project){
			return ((Project) object).getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkPackage(), new BasicEList<WorkPackage>()).toArray();
		}
		return super.getElements(object);
	}
	

}
