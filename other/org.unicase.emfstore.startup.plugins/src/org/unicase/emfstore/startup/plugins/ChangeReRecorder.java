package org.unicase.emfstore.startup.plugins;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
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
		applyOperationForOperation(operations);
		ChangePackage changePackage = projectSpace.getLocalChangePackage(true);
		return changePackage.getCopyOfOperations();
	}

	private void applyOperationForOperation(List<AbstractOperation> operations) {
		int index = 0;
		for(AbstractOperation operation : operations) {
			Date clientDate = operation.getClientDate();
			projectSpace.applyOperationsWithRecording(Arrays.asList(operation), true);
			if(index >= projectSpace.getOperations().size()) {
				continue;
			}
			ListIterator<AbstractOperation> listIterator = projectSpace.getOperations().listIterator(index);
			while(listIterator.hasNext()) {
				setDate(clientDate,listIterator.next());
			}
			index = projectSpace.getOperations().size();
		}
	}

	private void setDate(Date clientDate, AbstractOperation operation) {
		if(operation instanceof CompositeOperation) {
			for(AbstractOperation subOperation : ((CompositeOperation) operation).getSubOperations()) {
				setDate(clientDate, subOperation);
			}
		}
		operation.setClientDate(clientDate==null?null:(Date) clientDate.clone());
	}

	public Project getProject() {
		return (Project) EcoreUtil.copy(projectSpace.getProject());
	}

}
