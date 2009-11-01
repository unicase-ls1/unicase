package org.unicase.mergetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.rmi.RMIConnectionManagerImpl;
import org.unicase.workspace.exceptions.ChangeConflictException;
import org.unicase.workspace.observers.ConflictResolver;
import org.unicase.workspace.util.UnicaseCommand;

public class MergeSandboxController {
	
	public static ProjectSpace server;
	public static ProjectSpace client;
	private ArrayList<ModelElementId> meIds;

	
	public void run() throws Exception {
		meIds = new ArrayList<ModelElementId>();
		Project project = createProject();
		initProjectSpaces(project);
		initConnectionManager();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				WorkspaceManager.getInstance().getCurrentWorkspace().setActiveProjectSpace(client);				
			}
		}.run();
		
		// ///

		((UnicaseModelElement) server.getProject().getModelElement(meIds.get(0))).setName("value 2");
		((UnicaseModelElement) client.getProject().getModelElement(meIds.get(0))).setName("value 3");

		// ///

		Display display = new Display();
		Shell shell = new Shell(display);
//		MergeWizard conflictResolver = new MergeWizard();
//		WizardDialog dialog = new WizardDialog(shell,conflictResolver);
				ConflictResolver conflictResolver = new MergeProjectHandler();
		try {
			client.update(VersionSpec.HEAD_VERSION, null);
		} catch (ChangeConflictException e) {
			PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE
					.createPrimaryVersionSpec();
			client.merge(versionSpec, conflictResolver);
		}
//		dialog.open();
	}
	

	private void initConnectionManager() {
		ConnectionManager connectionManagerImpl = new RMIConnectionManagerImpl() {
			@Override
			public List<ChangePackage> getChanges(SessionId sessionId,
					ProjectId projectId, VersionSpec source, VersionSpec target)
					throws EmfStoreException {
				return Arrays.asList(server.getLocalChangePackage(false));
			}

			@Override
			public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId,
					ProjectId projectId, VersionSpec versionSpec)
					throws EmfStoreException {
				PrimaryVersionSpec primaryVersionSpec = VersioningFactory.eINSTANCE
						.createPrimaryVersionSpec();
				primaryVersionSpec.setIdentifier(100);
				return primaryVersionSpec;
			}
		};
		WorkspaceManager.getInstance().setConnectionManager(
				connectionManagerImpl);
	}

	private Project createProject() {
		Project project = MetamodelFactory.eINSTANCE.createProject();
		CompositeSection section = DocumentFactory.eINSTANCE
				.createCompositeSection();
		meIds.add(ModelUtil.clone(section.getModelElementId()));
		section.setName("Name");
		project.addModelElement(section);
		return project;
	}

	private void initProjectSpaces(Project project) {
		server = WorkspaceFactory.eINSTANCE.createProjectSpace();
		server.setBaseVersion(VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec());
		server.setIdentifier("server");
		server.setLastUpdated(new Date());
		server.setProjectDescription("server");
		server.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());
		server.setProjectName("server");

		server.setProject(ModelUtil.clone(project));

		server.makeTransient();
		server.init();

		client = WorkspaceFactory.eINSTANCE.createProjectSpace();
		client.setBaseVersion(VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec());
		client.setIdentifier("client");
		client.setLastUpdated(new Date());
		client.setLocalOperations(WorkspaceFactory.eINSTANCE
				.createOperationComposite());
		client.setProjectDescription("client");
		client.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());
		client.setProjectName("client");
		client.setUsersession(WorkspaceFactory.eINSTANCE.createUsersession());

		client.setProject(ModelUtil.clone(project));

		client.makeTransient();
		client.init();
	}

	
}
