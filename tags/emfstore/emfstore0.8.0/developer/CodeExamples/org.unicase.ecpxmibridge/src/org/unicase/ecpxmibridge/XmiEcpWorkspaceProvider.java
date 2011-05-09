/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpxmibridge;

import java.io.File;
import java.io.IOException;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.ecpxmibridge.containerModel.ContainerModelFactory;
import org.unicase.ecpxmibridge.containerModel.XMIRootContainer;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.ui.navigator.workSpaceModel.WorkSpaceModelFactory;
import org.unicase.ui.navigator.workSpaceModel.util.ECPWorkspaceProvider;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Provides a workspace for ECP based on XMI Resources.
 * @author koegel
 *
 */
public class XmiEcpWorkspaceProvider implements ECPWorkspaceProvider {

	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.EditingDomain";

	private static ECPWorkspace workspace;
	
	private Set<Resource> dirtyResources;
	
	/**
	 * Constructor.
	 */
	public XmiEcpWorkspaceProvider() {
		dirtyResources = new HashSet<Resource>();
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.navigator.workSpaceModel.util.ECPWorkspaceProvider#getECPWorkspace()
	 */
	public ECPWorkspace getECPWorkspace() {
		if (workspace != null) {
			return workspace;
		}
		final ResourceSet resourceSet = new ResourceSetImpl();
		final TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE
			.createEditingDomain(resourceSet);
		TransactionalEditingDomain.Registry.INSTANCE.add(TRANSACTIONAL_EDITINGDOMAIN_ID, domain);
		domain.setID(TRANSACTIONAL_EDITINGDOMAIN_ID);
		
		
		RecordingCommand command = new RecordingCommand(domain) {
			
			@Override
			protected void doExecute() {
				workspace = initWorkspace(resourceSet, domain);
			}
		};
		domain.getCommandStack().execute(command);
		return workspace;
		
	}
	
	private ECPWorkspace initWorkspace(ResourceSet resourceSet, TransactionalEditingDomain domain) {
		//load workspace
	
		URI fileURI = URI.createFileURI(Configuration.getWorkspacePath());
		File workspaceFile = new File(Configuration.getWorkspacePath());
		final ECPWorkspace workspace;
		final Resource resource;
		if (!workspaceFile.exists()) {

			// no workspace content found, create a workspace
			resource = resourceSet.createResource(fileURI);
			workspace = WorkSpaceModelFactory.eINSTANCE.createECPWorkspace();
			resource.getContents().add(workspace);

			try {
				resource.save(Configuration.getResourceSaveOptions());
			} catch (IOException e) {
				WorkspaceUtil.logException("Creating new workspace failed! Delete workspace folder: "
					+ Configuration.getWorkspaceDirectory(), e);
			}

		} else {
			resource = resourceSet.getResource(fileURI, true);
			EList<EObject> directContents = resource.getContents();

			workspace = (ECPWorkspace) directContents.get(0);
		}
		
//		//enable auto saving
//		workspace.eAdapters().add(new EContentAdapter() {
//
//			/** 
//			 * {@inheritDoc}
//			 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
//			 */
//			@Override
//			public void notifyChanged(Notification notification) {
//				super.notifyChanged(notification);
//				Object notifier = notification.getNotifier();
//				if (notifier instanceof EObject && ((EObject)notifier).eResource()!=null) {
//					dirtyResources.add(((EObject)notifier).eResource());
//				}
//			}
//		});
//		
//		domain.getCommandStack().addCommandStackListener(new CommandStackListener() {
//			
//			public void commandStackChanged(EventObject event) {
//				for (Resource resource: dirtyResources) {
//					try {
//						resource.save(null);
//					} catch (IOException e) {
//
//					}
//				}
//				dirtyResources.clear();
//			}
//		});
		
		workspace.setEditingDomain(domain);
		
		XMIRootContainer xmiRootContainer = ContainerModelFactory.eINSTANCE.createXMIRootContainer();
		
		ECPXMIProject ecpxmiProject = new ECPXMIProject(domain, xmiRootContainer);
		
		workspace.getProjects().add(ecpxmiProject);
		
//		try {
//			resource.save(null);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return workspace;
	}
}
