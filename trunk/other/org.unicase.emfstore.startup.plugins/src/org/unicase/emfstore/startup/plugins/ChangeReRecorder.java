package org.unicase.emfstore.startup.plugins;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.Project;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.impl.ProjectSpaceImpl;

public class ChangeReRecorder {

	private ProjectSpaceImpl projectSpace;

	public void init(Project project) {
		if (project == null) {
			throw new IllegalStateException();
		}
		projectSpace = (ProjectSpaceImpl) WorkspaceFactory.eINSTANCE.createProjectSpace();
		projectSpace.setBaseVersion(VersioningFactory.eINSTANCE.createPrimaryVersionSpec());
		projectSpace.setIdentifier("testProjectSpace");
		projectSpace.setLastUpdated(new Date());
		projectSpace.setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());
		projectSpace.setProjectDescription("ps description");
		projectSpace.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());
		projectSpace.setProjectName("ps name");
		projectSpace.setProject(project);
		projectSpace.makeTransient();
		projectSpace.init();
	}

	public List<AbstractOperation> convertOperations(List<AbstractOperation> operations) {
		projectSpace.getOperations().clear();
		projectSpace.applyOperationsWithRecording(operations, true);
		ChangePackage changePackage = projectSpace.getLocalChangePackage(true);
		return changePackage.getCopyOfOperations();
	}

	public Project getProject() {
		return (Project) EcoreUtil.copy(projectSpace.getProject());
	}

}
