package org.unicase.xmi.workspace;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.unicase.ui.navigator.workSpaceModel.ECPProject;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.ui.navigator.workSpaceModel.impl.ECPWorkspaceImpl;
import org.unicase.workspace.Configuration;
import org.unicase.xmi.structure.XMIECPFileProject;

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
		TransactionalEditingDomain editingDomain2 = Configuration.getEditingDomain();
		if (editingDomain2 == null) {
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
		if(testCounter  == 0) {
			String testFile = Platform.getLocation().toString() + "xmiworkspace.ucw";
			XMIECPFileProject ecpp = new XMIECPFileProject(testFile,this);
			projects.add(ecpp);
			super.setActiveProject(ecpp);
			testCounter++;
		}
		// test end
		
		return projects;
	}
}
