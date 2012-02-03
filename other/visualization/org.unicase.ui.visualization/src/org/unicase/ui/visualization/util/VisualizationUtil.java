/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.visualization.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.ecp.editor.MEEditor;
import org.eclipse.emf.ecp.editor.MEEditorInput;
import org.eclipse.emf.ecp.navigator.TreeView;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceImpl;
import org.eclipse.emf.emfstore.client.ui.commands.ServerRequestCommandHandler;
import org.eclipse.emf.emfstore.client.ui.views.changes.ChangePackageVisualizationHelper;
import org.eclipse.emf.emfstore.client.ui.views.scm.SCMContentProvider;
import org.eclipse.emf.emfstore.client.ui.views.scm.SCMLabelProvider;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.impl.ProjectImpl;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.WorkbenchPart;
import org.unicase.ui.visualization.tree.UnicaseNode;
import org.unicase.ui.visualization.tree.UnicaseTree;

/**
 * A util class for visualization purposes.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class VisualizationUtil {

	/**
	 * Open an {@link EObject} in the editor. Needed because of the AWT integration to manually set an active {@link WorkbenchPart}. 
	 * 
	 * @param obj The Object to open.
	 * @param part The active part. If null, it receives it static from the {@link PlatformUI}. 
	 */
	public static void openModelElement(EObject obj, WorkbenchPart part){		
		try {
			final MEEditorInput input = new MEEditorInput(obj, ECPWorkspaceManager.getInstance().getWorkSpace().getProject(obj));
		
			if(part == null){
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, MEEditor.ID, true);
			} else {
				part.getSite().getWorkbenchWindow().getActivePage().openEditor(input, MEEditor.ID, true);
			}
		} catch (PartInitException e) {								
			e.printStackTrace();
		} catch (NoWorkspaceException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Set the selection of the navigator.
	 * 
	 * @param obj The Object to select.
	 * @param isLinked Should it really be selected?
	 */
	public static void setNavigatorSelection(EObject obj, boolean isLinked){
		if(isLinked){
			TreeViewer viewer = TreeView.getTreeViewer();
			viewer.setSelection(new TreeSelection(new TreeSelection(new TreePath(new Object[]{obj})).getPaths()[0].createChildPath(obj)), true);
		}
	}
	
	/**
	 * Resolves the {@link ProjectSpace} of an {@link EObject}.
	 * 
	 * @param obj The {@link EObject} to search the {@link ProjectSpace} for.
	 * @return The {@link ProjectSpace}, which contains the {@link EObject}.
	 */
	public static ProjectSpace getProjectSpace(EObject obj){
		EObject container = obj.eContainer();
		return container instanceof ProjectSpace ? (ProjectSpace) container : getProjectSpace(container);
	}	
	
	/**
	 * Returns a copy of the given {@link ProjectSpace} reverted to the given {@link VersionSpec}. 
	 * The Project needs to be on the head version.
	 * 
	 * @param projectSpace The current {@link ProjectSpace}.
	 * @param versionSpec The {@link VersionSpec} to revert to.
	 * @return A copy of the reverted {@link ProjectSpace}.
	 */
	public static ProjectSpace getRevertedProjectSpace(ProjectSpace projectSpace, VersionSpec versionSpec){
		return getRevertedProjectSpace(projectSpace, getChanges(projectSpace, versionSpec));
	}
	
	/**
	 * Returns a new {@link UnicaseTree}, reverted to the given {@link PrimaryVersionSpec}.
	 * 
	 * @param projectSpace The current {@link ProjectSpace}.
	 * @param versionSpec The {@link PrimaryVersionSpec} to set the {@link UnicaseTree} to.
	 * @return A new {@link UnicaseTree}, reverted the the given {@link PrimaryVersionSpec}.
	 */
	public static UnicaseTree getRevertedUnicaseTree(ProjectSpace projectSpace, PrimaryVersionSpec versionSpec){		
		UnicaseTree tree = new UnicaseTree(new UnicaseNode(VisualizationUtil.getRevertedProjectSpace(projectSpace, versionSpec)));
		tree.addInfo("Version: " + versionSpec.getIdentifier());
		return tree;
	}
	
	/**
	 * Return a new {@link UnicaseTree}, reverted to the given {@link PrimaryVersionSpec} with the given {@link HistoryInfo}s.
	 * 
	 * @param projectSpace The current {@link ProjectSpace}.
	 * @param versionSpec The {@link PrimaryVersionSpec} to set the {@link UnicaseTree} to.
	 * @param historyInfos The {@link HistoryInfo}s containing the {@link ChangePackage}s to apply.
	 * @return A new {@link UnicaseTree}, reverted the the given {@link PrimaryVersionSpec}.
	 */
	public static UnicaseTree getRevertedUnicaseTree(ProjectSpace projectSpace, PrimaryVersionSpec versionSpec, List<HistoryInfo> historyInfos){
		List<ChangePackage> changePackages = new ArrayList<ChangePackage>();
		for (HistoryInfo info : historyInfos) {
			if(versionSpec.compareTo(info.getPrimerySpec()) < 0){
				changePackages.add(info.getChangePackage());
			}
		}
		UnicaseTree tree = new UnicaseTree(new UnicaseNode(VisualizationUtil.getRevertedProjectSpace(projectSpace, changePackages)));
		tree.addInfo("Version: " + versionSpec.getIdentifier());
		return tree;
	}
	
	/**
	 * Returns a copy of the given {@link ProjectSpace} reverted with all given {@link ChangePackage}s.
	 * The Project needs to be on the head version.
	 * 
	 * @param projectSpace The current {@link ProjectSpace}.
	 * @param changePackages The {@link ChangePackage}s to apply reverted.
	 * @return A copy of the reverted {@link ProjectSpace}.
	 */
	public static ProjectSpace getRevertedProjectSpace(ProjectSpace projectSpace, List<ChangePackage> changePackages){		
		// apply changes in new ProjectSpace
		ProjectSpaceImpl ps = (ProjectSpaceImpl) EcoreUtil.copy(projectSpace);		
		
		// project.copy() needed to keep the modelelement ids
		ProjectImpl origProject = (ProjectImpl) projectSpace.getProject();
		Project newProject = origProject.copy();
		ps.setProject(newProject);
		
		for(ChangePackage changePackage : changePackages){
			changePackage.reverse().apply(newProject, true);
		}
		
		return ps;
	}
	
	/**
	 * Returns all changes from the Head version to the given {@link VersionSpec}. 
	 * 
	 * @param projectSpace The {@link ProjectSpace} to search in.
	 * @param versionSpec The {@link VersionSpec} to compare with the head version.
	 * @return A list of {@link ChangePackage}s with the changes. 
	 */
	public static List<ChangePackage> getChanges(ProjectSpace projectSpace, VersionSpec versionSpec){		
		try {
			return projectSpace.getChanges(versionSpec, VersionSpec.HEAD_VERSION);
		} catch (EmfStoreException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	/**
	 * Asks the user to select one or two versions.
	 * 
	 * @param projectSpace The {@link ProjectSpace} to search in.
	 * @param twoVersions Should the user asked for one or for two versions?
	 * @return The selected {@link HistoryInfo}s.
	 */
	public static List<HistoryInfo> getVersionsFromUser(ProjectSpace projectSpace, boolean twoVersions){
		List<HistoryInfo> infos = new ArrayList<HistoryInfo>();		
		for(int i = 1; i <= (twoVersions ? 2 : 1); i++){
			HistoryInfo info = showVersionHistory(projectSpace, twoVersions ? "Please choose version " + i + " of two versions." : "");
			if(info == null){
				return Collections.emptyList();
			}
			selectedHistoryInfo = null;
			infos.add(info);			
		}
		return infos;
	}
	
	/**
	 * Receive the changed elements of a version in a {@link ProjectSpace}. Asks the user to set the version.
	 * 
	 * @param projectSpace The {@link ProjectSpace} to search in.
	 * @param twoVersions Get elements of two versions.
	 * @return The changed elements.
	 */
	public static List<EObject> getChangedElements(ProjectSpace projectSpace, boolean twoVersions){			
		return getChangedElements(projectSpace, getVersionsFromUser(projectSpace, twoVersions));	
	}
	
	/**
	 * Temporary variable. Necessary to assign in inner dialog definition.
	 */
	private static HistoryInfo selectedHistoryInfo;
	
	/**
	 * Shows the Historyversion, to select one {@link HistoryInfo}.
	 * 
	 * @param projectSpace The {@link ProjectSpace} where to search in.
	 * @param string 
	 * @return The selected {@link HistoryInfo} or <code>null</code> if cancel is pressed or nothing is selected.
	 */
	private static HistoryInfo showVersionHistory(final ProjectSpace projectSpace, final String msg){		
		if (new HistoryDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), projectSpace, msg).open() == Dialog.OK){
			return selectedHistoryInfo;		
		}
		return null;					
	}
	
	/**
	 * A inner class to ask for histories.
	 */
	static class HistoryDialog extends Dialog{
		
		private String msg;
		private ProjectSpace projectSpace;
		
		/**
		 * @param parentShell The parent shell.
		 * @param projectSpace The projectSpace to search in.
		 * @param msg The message to show.
		 */
		protected HistoryDialog(Shell parentShell, ProjectSpace projectSpace, String msg) {
			super(parentShell);
			this.projectSpace = projectSpace;
			this.msg = msg;
		}

		@Override
	    protected Control createDialogArea(Composite p) {
	    	// init ui with viewer
	    	Composite composite = new Composite(p, SWT.NONE);
	    	composite.setLayout(new GridLayout());
	    	Button reload = new Button(composite, SWT.PUSH);
	    	reload.setText("Reload History");
	    	reload.setToolTipText("Clears the cache and reloads History");
	    	new Label(composite, SWT.NONE).setText(msg);
	    	
	    	ScrolledComposite sc = new ScrolledComposite(composite, SWT.H_SCROLL | SWT.V_SCROLL);
	    	sc.setLayoutData(new GridData(500,400)); 
	    	
	    	final TreeViewer viewer = new TreeViewer(sc, SWT.BORDER | SWT.MULTI);
	        
	        viewer.getControl().setSize(500, 400);
	        sc.setContent(viewer.getControl());
	        
	        setViewerInput(viewer, getHistoryInfos(projectSpace), projectSpace);

	        // set a selection listener to save the current selection
	        viewer.addSelectionChangedListener(new ISelectionChangedListener() {
				
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					TreeNode treeNode = (TreeNode) ((IStructuredSelection) event.getSelection()).getFirstElement();
					if(null != treeNode){
						Object value = treeNode.getValue();
						if(value instanceof HistoryInfo) {
							selectedHistoryInfo = (HistoryInfo) value;
						}
					}
				}
			});
	        
	        // reload the history
	        reload.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					historyInfos = null;
					setViewerInput(viewer, getHistoryInfos(projectSpace), projectSpace);
				}
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {}
	          });
	        
	        return composite;
		}
	}
	
	private static void setViewerInput(TreeViewer viewer, List<HistoryInfo> infos, ProjectSpace projectSpace){		
        List<ChangePackage> changePackages = new ArrayList<ChangePackage>();
        for (HistoryInfo historyInfo : infos) {
        	if(null != historyInfo.getChangePackage()){
        		changePackages.add(historyInfo.getChangePackage());
        	}			
		}
        
        // set the providers of the the viewer
        SCMLabelProvider labelProvider = new SCMLabelProvider(projectSpace.getProject());
		viewer.setLabelProvider(labelProvider);
        SCMContentProvider.Detailed contentProvider = new SCMContentProvider.Detailed(viewer);
		viewer.setContentProvider(contentProvider);
        
        ChangePackageVisualizationHelper changePackageVisualizationHelper = new ChangePackageVisualizationHelper(changePackages, projectSpace.getProject());
		labelProvider.setChangePackageVisualizationHelper(changePackageVisualizationHelper);
		contentProvider.setChangePackageVisualizationHelper(changePackageVisualizationHelper);
		
		// set the input
        viewer.setInput(infos);
	}
	
	/**
	 * HashMap to cache the fetched {@link HistoryInfo}s.
	 */
	private static HashMap<ProjectSpace, List<HistoryInfo>> historyInfos;
		
	/**
	 * Receive all {@link HistoryInfo}s of a {@link ProjectSpace}. Caches the infos.
	 * 
	 * @param projectSpace The {@link ProjectSpace} where to search in.
	 * @return The {@link HistoryInfo}s of the {@link ProjectSpace}.
	 */
	private static List<HistoryInfo> getHistoryInfos(final ProjectSpace projectSpace){
		if(historyInfos == null){
			historyInfos = new HashMap<ProjectSpace, List<HistoryInfo>>();		
		}
		List<HistoryInfo> i = historyInfos.get(projectSpace);		
		if(i != null){
			return i;
		}
		
		final List<HistoryInfo> infos = new ArrayList<HistoryInfo>();
		try {
			new ServerRequestCommandHandler() {
				
				@Override
				protected Object run() throws EmfStoreException {
					Usersession usersession = projectSpace.getUsersession();
					usersession.logIn();
					infos.addAll(usersession.getHistoryInfo(projectSpace.getProjectId(), getQuery(projectSpace)));									
					return null;
				}
			}.execute(new ExecutionEvent());
			
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		historyInfos.put(projectSpace, infos);
		return infos;	
	}
	
	/**
	 * Get all {@link HistoryInfo}s between the two given.
	 * 
	 * @param projectSpace The current {@link ProjectSpace}.
	 * @param infos The two infos to look between.
	 * @return All {@link HistoryInfo}s between the given two.
	 */
	public static List<HistoryInfo> getHistoryInfos(final ProjectSpace projectSpace, final List<HistoryInfo> infos){
		final List<HistoryInfo> allInfos = new ArrayList<HistoryInfo>();
		
		try {
			new ServerRequestCommandHandler() {
				
				@Override
				protected Object run() throws EmfStoreException {
					Usersession usersession = projectSpace.getUsersession();
					usersession.logIn();
					allInfos.addAll(usersession.getHistoryInfo(projectSpace.getProjectId(), getQuery(projectSpace, infos.get(0).getPrimerySpec().getIdentifier(), infos.get(1).getPrimerySpec().getIdentifier())));									
					return null;
				}
			}.execute(new ExecutionEvent());
			
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		return allInfos;
	}
	
	/**
	 * 
	 * Receive all changed elements of the {@link HistoryInfo}s.
	 * 
	 * @param projectSpace The {@link ProjectSpace} where to search in.
	 * @param infos The {@link HistoryInfo}s where to get the changes from.
	 * @return The {@link EObject}s, which are changed in this versions.
	 */
	public static List<EObject> getChangedElements(final ProjectSpace projectSpace, final List<HistoryInfo> infos) {
		return getChangedElementsOfPackages(projectSpace, getChangePackages(projectSpace, infos));		
	}
	
	/**
	 * Receive all {@link EObject}s out of a list of {@link ChangePackage}s.
	 * 
	 * @param projectSpace The {@link ProjectSpace} where to search in.
	 * @param changePackages The {@link ChangePackage}s containing the changed elements.
	 * @return The {@link EObject}s, which are changed in this {@link ChangePackage}s.
	 */
	public static List<EObject> getChangedElementsOfPackages(final ProjectSpace projectSpace, List<ChangePackage> changePackages) {
		// get the changed elements out of the changepackages
		ChangePackageVisualizationHelper cpvh = new ChangePackageVisualizationHelper(changePackages, projectSpace.getProject());		
		ArrayList<EObject> elements = new ArrayList<EObject>();
		
		for (ChangePackage changePackage : changePackages) {
			for(AbstractOperation a : changePackage.getOperations()){									
				elements.add(cpvh.getModelElement(a.getModelElementId()));
			}
		}
		return elements;
	}
	
	/**
	 * Receive all ChangePackages between the given {@link HistoryInfo}s.
	 * 
	 * @param projectSpace The {@link ProjectSpace} where to search in.
	 * @param infos The {@link HistoryInfo}s where to get the changes between.
	 * @return The {@link ChangePackage}s between the two infos.
	 */
	public static List<ChangePackage> getChangePackages(final ProjectSpace projectSpace, final List<HistoryInfo> infos){
		if( infos.size() == 0 ){
			return Collections.emptyList();
		}
		// receive the changepackages of the version(s)
		final List<ChangePackage> changePackages = new ArrayList<ChangePackage>();
		if(infos.size() == 1){
			changePackages.add(infos.get(0).getChangePackage());
		} else if (infos.size() == 2){
			try {
				new ServerRequestCommandHandler() {
					
					@Override
					protected Object run() throws EmfStoreException {
						changePackages.addAll(projectSpace.getChanges(infos.get(0).getPrimerySpec(), infos.get(1).getPrimerySpec()));
						return null;
					}
				}.execute(new ExecutionEvent());				
			} catch (ExecutionException e) {
				e.printStackTrace();
			}			
		}
		
		// this condition occurs when the initial commit happens (there are no changes as everything is new)
		for (ChangePackage cp : changePackages){
			if(cp == null){
				return Collections.emptyList();
			}
		}
		
		return changePackages;
	}
	
	/**
	 * Receive a query for special start and end versions.
	 * 
	 * @param projectSpace The {@link ProjectSpace} where to search.
	 * @param start the start version.
	 * @param end the end version.
	 * @return A Query which searches all versions between start and end.
	 */
	private static HistoryQuery getQuery(ProjectSpace projectSpace, int start, int end){
		HistoryQuery query = VersioningFactory.eINSTANCE.createHistoryQuery();
				
		PrimaryVersionSpec source = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		source.setIdentifier(start < end ? start : end);
		PrimaryVersionSpec target = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		target.setIdentifier(end > start ? end : start);
		query.setSource(source);
		query.setTarget(target);
		query.setIncludeChangePackage(true);		
		
		return query;
	}
	
	/**
	 * Receive a {@link HistoryQuery} to query for the {@link HistoryInfo}s.
	 *  
	 * @param projectSpace The {@link ProjectSpace} where to search.
	 * @return A Query which searches all versions.
	 * @throws EmfStoreException
	 */
	private static HistoryQuery getQuery(ProjectSpace projectSpace) throws EmfStoreException {		
		return getQuery(projectSpace, 0, projectSpace.resolveVersionSpec(VersionSpec.HEAD_VERSION).getIdentifier());
	}
}
