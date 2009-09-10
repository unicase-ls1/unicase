/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.AdminBroker;

/**
 * @author gurcankarakoc
 */
public class TabContentProvider extends AdapterFactoryContentProvider {

	private TabContent tabContent;
	private AdminBroker adminBroker;

	/**
	 * @param tabContent TabContent.
	 * @param adminBroker AdminBroker is needed to communicate with server.
	 */
	public TabContentProvider(TabContent tabContent, AdminBroker adminBroker) {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		this.tabContent = tabContent;
		this.adminBroker = adminBroker;
	}

	/**
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
	 * @param object Object.
	 * @return Object[].
	 */
	@Override
	public Object[] getElements(Object object) {

		Object[] result = new Object[0];
		try {
			if (this.tabContent instanceof ProjectTabContent) {
				// return a list of Projects in project space
				List<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
				projectInfos.addAll(this.adminBroker.getProjectInfos());
				result = projectInfos.toArray(new ProjectInfo[projectInfos.size()]);

			} else if (this.tabContent instanceof GroupTabContent) {
				// return a list of Groups in project space
				List<ACGroup> groups = new ArrayList<ACGroup>();
				groups.addAll(this.adminBroker.getGroups());
				result = groups.toArray(new ACGroup[groups.size()]);

			} else if (this.tabContent instanceof UserTabContent) {
				// return a list of Users in project space
				List<ACUser> users = new ArrayList<ACUser>();
				users.addAll(this.adminBroker.getUsers());
				result = users.toArray(new ACUser[users.size()]);
			}
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		return result;
	}
}
