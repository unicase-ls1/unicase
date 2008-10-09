package org.unicase.test.tests.changetests;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;

public class ChangeTestHelper {

	private static TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");

	public static ProjectSpace createEmptyProjectSpace(String name) {
		Workspace workSpace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();
		List<ProjectSpace> projectSpaces = workSpace.getProjectSpaces();
		for (ProjectSpace ps : projectSpaces) {
			if (ps.getProjectName().equalsIgnoreCase(name)) {
				return ps;
			}
		}

		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE
				.createProjectSpace();
		ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
		projectId.setId(name);
		projectSpace.setIdentifier(name);
		projectSpace.setProjectId(projectId);
		projectSpace.setProjectName(name);
		projectSpace.setProjectDescription("description");
		PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		versionSpec.setIdentifier(0);
		projectSpace.setBaseVersion(versionSpec);
		projectSpace.setLastUpdated(new Date());
		projectSpace.setUsersession(null);
		// projectSpace.setProject(ModelFactory.eINSTANCE.createProject());
		projectSpace.setResourceCount(0);
		return projectSpace;
	}

	public static ChangePackage getChangePackage(
			final List<AbstractOperation> operations, final boolean cannonize) {
		final ChangePackage changePackage = VersioningFactory.eINSTANCE
				.createChangePackage();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				changePackage.getOperations().addAll(operations);
				if (cannonize) {
					changePackage.cannonize();
				}
			}

		});
		return changePackage;
	}

	public static boolean compare(final ProjectSpace testSpace,
			final ProjectSpace compareSpace) {

		final ChangePackage changePackage = getChangePackage(testSpace
				.getOperations(), false);

		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				System.out.println("applying changes to compareSpace...");
				changePackage.apply(compareSpace.getProject());
			}
		});

		return ModelUtil.areEqual(testSpace.getProject(), compareSpace
				.getProject());
	}

}
