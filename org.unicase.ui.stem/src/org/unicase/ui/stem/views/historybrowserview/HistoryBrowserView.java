/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.historybrowserview;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.ui.stem.views.AbstractSCMView;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**.
 * This the History Browser view. It inherits AbstractSCMView and hence has
 * a query tab, where the user can set criteria for view's content. It also 
 * has a browser tab (a HistoryComposite). 
 * @author Hodaie
 *
 */
public class HistoryBrowserView extends AbstractSCMView {

	//temporarily used to show dialogs.
	private Composite parent;
	
	private List<HistoryInfo> historyInfos;
	
	/**.
	 * Constructor
	 */
	public HistoryBrowserView() {
		load();
	}

	private void load() {
		historyInfos = new ArrayList<HistoryInfo>();
		
		try {
		Resource resource = new ResourceSetImpl().createResource(URI.createURI("test"));

		HistoryQuery query = VersioningFactory.eINSTANCE.createHistoryQuery();
		PrimaryVersionSpec source = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		source.setIdentifier(0);
		PrimaryVersionSpec target = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		target.setIdentifier(2);
		query.setSource(source);
		query.setTarget(target);
		
		resource.getContents().add(query);
		resource.getContents().add(source);
		resource.getContents().add(target);
		
		ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		List<HistoryInfo> result = activeProjectSpace.getUsersession().getHistoryInfo(activeProjectSpace.getProjectId(), query);
		
		if(result != null) {
			historyInfos = result;			
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		browserTab.setText("History");
		this.parent = parent;
	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
	
		
	}

	/**.
	 * TODO final implementation
	 */
	@Override
	protected void refreshClicked() {
//		lblCriteria.setText(queryComposite.getQuery().getDescription());

//************************************************
//		//these were just used to show different dialogs.
//		//because i did not know how should the dialogs be shown.
//		CommitDialog commitDialog = new CommitDialog(parent.getShell());
//		commitDialog.create();
//		commitDialog.open();
		
//		UpdateDialog updateDialog = new UpdateDialog(parent.getShell());
//		updateDialog.create();
//		updateDialog.open();
		
//		MergeDialog mergeDialog = new MergeDialog(parent.getShell());
//		mergeDialog.create();
//		mergeDialog.open();
//************************************************		
	}


	/**.
	 * this will be called to set contents of browser tab.
	 * 
	 */
	@Override
	protected Control setBrowserTabControl() {
		return new HistoryComposite(tabFolder, SWT.NONE,historyInfos);
	}

}
