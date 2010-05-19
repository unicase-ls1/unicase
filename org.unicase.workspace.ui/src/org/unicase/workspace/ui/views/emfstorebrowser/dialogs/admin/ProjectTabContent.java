/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.AdminBroker;

/**
 * @author gurcankarakoc, deser
 */
public class ProjectTabContent extends TabContent {

	/**
	 * Project Table Provider.
	 * 
	 * @author koegel
	 * 
	 */
	private final class ITableLabelProviderImplementation implements
			ITableLabelProvider {
		public void addListener(ILabelProviderListener listener) {
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
		}

		public void dispose() {
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			return ((ProjectInfo) element).getName() + " ["
					+ ((ProjectInfo) element).getVersion().getIdentifier()
					+ "]";
		}
	}

	/**
	 * @param string
	 *            the name of tab.
	 * @param adminBroker
	 *            AdminBroker is needed to communicate with server.
	 * @param frm
	 *            used to set input to properties form and update its table
	 *            viewer upon deletion of OrgUnits.
	 */
	public ProjectTabContent(String string, AdminBroker adminBroker,
			PropertiesForm frm) {
		super(string, adminBroker, frm);
		this.setTab(this);
	}

	/**
	 * @see org.unicase.ui.esbrowser.dialogs.admin.TabContent#createContents(org.eclipse.swt.widgets.TabFolder)
	 * @param tabFolder
	 *            TabFolder.
	 * @return Composite.
	 */
	@Override
	protected Composite createContents(TabFolder tabFolder) {
		Composite tabContent = new Composite(tabFolder, SWT.NONE);
		tabContent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tabContent.setLayout(new GridLayout(2, false));

		initList(tabContent);

		return tabContent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITableLabelProvider getLabelProvider() {
		return new ITableLabelProviderImplementation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStructuredContentProvider getContentProvider() {
		return new IStructuredContentProvider() {

			public Object[] getElements(Object inputElement) {
				// return a list of Projects in project space
				List<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
				try {
					projectInfos.addAll(getAdminBroker().getProjectInfos());
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}
				return projectInfos
						.toArray(new ProjectInfo[projectInfos.size()]);
			}

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}
		};
	}

}
