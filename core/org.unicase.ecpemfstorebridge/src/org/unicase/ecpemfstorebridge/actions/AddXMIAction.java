/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpemfstorebridge.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IActionDelegate;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.WorkspaceImpl;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Action for adding XMI files to workspace.
 * 
 * @author koegel
 */
public class AddXMIAction implements IActionDelegate {

	private ISelection selection;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		if (selection instanceof TreeSelection) {
			WorkspaceManager.init();
			final Object firstElement = ((TreeSelection) selection).getFirstElement();
			new UnicaseCommand() {

				@Override
				protected void doRun() {
					runImport(firstElement);
				}
			}.run();
		}

	}

	@SuppressWarnings("unchecked")
	private void runImport(Object firstElement) {
		if (firstElement instanceof IFile) {
			IFile file = (IFile) firstElement;

			URI fileURI = URI.createFileURI(file.getRawLocationURI().getPath());

			Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
			ResourceSet resourceSet = currentWorkspace.eResource().getResourceSet();
			Resource resource = resourceSet.getResource(fileURI, true);

			ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
			Project project = MetamodelFactory.eINSTANCE.createProject();
			projectSpace.setProject(project);
			projectSpace.setProjectName(file.getName());
			projectSpace.setProjectDescription("Imported.");
			projectSpace.setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());

			project.getModelElements().addAll(resource.getContents());
			((WorkspaceImpl) currentWorkspace).addProjectSpace(projectSpace);
			projectSpace.init();

			currentWorkspace.save();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;

	}

}
