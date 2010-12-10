package org.unicase.xmi.workspace;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ecp.model.workSpaceModel.impl.ECPWorkspaceImpl;
import org.unicase.workspace.Configuration;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructureFactory;


public class XMIECPWorkspace extends ECPWorkspaceImpl implements ECPWorkspace {
	
	/**
	 * Copied transactional domain
	 */
	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.EditingDomain";
	
	/**
	 * Internal list of projects contained in the workspace.
	 */
	private EList<ECPProject> projects;

	private int testCounter = 0;

	/**
	 * Builds new ECPWorkspace being able to hold xmi-persistable projects.
	 */
	public XMIECPWorkspace() {
		projects = new BasicEList<ECPProject>();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPWorkspace#getEditingDomain()
	 */
	@Override
	public TransactionalEditingDomain getEditingDomain() {
		if (Configuration.getEditingDomain() == null) {
			final TransactionalEditingDomain domain = new TransactionalEditingDomainImpl(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			TransactionalEditingDomain.Registry.INSTANCE.add(TRANSACTIONAL_EDITINGDOMAIN_ID, domain);
			domain.setID(TRANSACTIONAL_EDITINGDOMAIN_ID);
		}		
		return Configuration.getEditingDomain();
	}
	
	@Override
	public EList<ECPProject> getProjects() {
		
		// test
		if(testCounter == 0) {
			// new test-file-project
			String testFile = Platform.getLocation().toString() + "xmiworkspace.ucw";
			XMIECPFileProject ecpp = XmiworkspacestructureFactory.eINSTANCE.createXMIECPFileProject();
			ecpp.setWorkspace(this);
			ecpp.setXmiFilePath(testFile);
			ecpp.setProjectName("Library Test Project");
			projects.add(ecpp);
			
			super.setActiveProject(ecpp);
			
			/*
			// new test-folder
			XMIECPFolder folder = XmiworkspacestructureFactory.eINSTANCE.createXMIECPFolder();
			folder.setWorkspace(this);
			folder.setXmiDirectoryPath(Platform.getLocation().toString());
			*/
			
			testCounter++;
		}
		// test end
		
		return projects;
	}
}
