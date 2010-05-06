package org.unicase.mergetest;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
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
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.rmi.RMIConnectionManagerImpl;
import org.unicase.workspace.exceptions.ChangeConflictException;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.observers.ConflictResolver;
import org.unicase.workspace.util.UnicaseCommand;

public class MergeSandboxController {

	public static ProjectSpace server;
	public static ProjectSpace client;

	private Project createProject() {
		Project project = MetamodelFactory.eINSTANCE.createProject();

		CompositeSection compositeSection = DocumentFactory.eINSTANCE
				.createCompositeSection();
		CompositeSection compositeSection2 = DocumentFactory.eINSTANCE
				.createCompositeSection();

		project.addModelElement(compositeSection);
		project.addModelElement(compositeSection2);

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		project.addModelElement(section);
		project.addModelElement(section2);

		User user1 = OrganizationFactory.eINSTANCE.createUser();
		User user2 = OrganizationFactory.eINSTANCE.createUser();
		User user3 = OrganizationFactory.eINSTANCE.createUser();

		project.addModelElement(user1);
		project.addModelElement(user2);
		project.addModelElement(user3);

		ActionItem actionItem = TaskFactory.eINSTANCE.createActionItem();
		project.addModelElement(actionItem);

		nameMEs(project);
		return project;
	}

	private void doChanges() {
		cg("User1", User.class).setFirstName("Günther");
		sg("User1", User.class).setFirstName("Horst");

		cg("User1", User.class).setLeafSection(
				cg("LeafSection1", LeafSection.class));
		sg("User1", User.class).setLeafSection(
				sg("LeafSection2", LeafSection.class));

		// cg("User3", User.class).getAssignments().add(
		// cg("ActionItem1", ActionItem.class));
		// sg("User3", User.class).getAssignments().add(
		// sg("ActionItem1", ActionItem.class));
		// sg("User3", User.class).getAssignments().remove(
		// sg("ActionItem1", ActionItem.class));

		// cg("LeafSection1", LeafSection.class).setParent(
		// cg("CompositeSection1", CompositeSection.class));
		// sg("LeafSection1", LeafSection.class).setParent(
		// sg("CompositeSection1", CompositeSection.class));
		// sg("LeafSection1", LeafSection.class).setParent(null);

		cg("User3", User.class)
				.setDescription(
						"Schiller - Die goldene Zeit der Geistlichkeit fiel immer in die Gefangenschaft des menschlichen Geistes.");
		// sg("User3", User.class)
		// .setDescription(
		// "Goethe - Was Ihr den Geist der Zeiten heißt, das ist im Grund der Herren eigener Geist, in dem die Zeiten sich nur spiegeln.");

		sg("User3", User.class).delete();

		// cg("User2", User.class).setLeafSection(
		// cg("LeafSection2", LeafSection.class));
		// sg("User2", User.class).delete();
		// sg("LeafSection1",LeafSection.class).delete();

		// CompositeOperationHandle compositeOperation =
		// client.beginCompositeOperation();
		// cg("User3", User.class)
		// .setDescription(
		// "Schiller - Die goldene Zeit der Geistlichkeit fiel immer in die Gefangenschaft des menschlichen Geistes.");
		// try {
		// compositeOperation.end("Literature Composite",
		// "Literature Composite knows the best Literature.", cg("User3",
		// User.class).getModelElementId());
		// } catch (InvalidHandleException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	//
	//
	// ---------------------------------------------------------------------------------------
	//
	//

	public void run() throws Exception {
		Project project = createProject();
		initProjectSpaces(project);
		initConnectionManager();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				WorkspaceManager.getInstance().getCurrentWorkspace()
						.setActiveProjectSpace(client);
			}
		}.run();

		// ///

		doChanges();

		// ///

		Display display = new Display();
		Shell shell = new Shell(display);
		// MergeWizard conflictResolver = new MergeWizard();
		// WizardDialog dialog = new WizardDialog(shell,conflictResolver);
		ConflictResolver conflictResolver = new MergeProjectHandler();
		try {
			client.update(VersionSpec.HEAD_VERSION, null);
		} catch (ChangeConflictException e) {
			PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE
					.createPrimaryVersionSpec();
			System.out.println("!!!entering merge!!!");
			client.merge(versionSpec, conflictResolver);
		}
		// dialog.open();
	}

	/**
	 * Client Get
	 */
	private <T> T cg(String name, Class<T> clazz) {
		return serverClientGet(client, name, clazz);
	}

	/**
	 * Server Get
	 */
	private <T> T sg(String name, Class<T> clazz) {
		return serverClientGet(server, name, clazz);
	}

	@SuppressWarnings("unchecked")
	private <T> T serverClientGet(ProjectSpace space, String name,
			Class<T> clazz) {
		for (ModelElement me : space.getProject().getAllModelElements()) {
			if (me instanceof UnicaseModelElement) {
				if (((UnicaseModelElement) me).getName().equals(name)) {
					return (T) me;
				}
			}
		}
		return null;
	}

	private void nameMEs(Project project) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (ModelElement tmp : project.getAllModelElements()) {
			UnicaseModelElement element = (UnicaseModelElement) tmp;
			String elementName = element.eClass().getName();
			if (map.get(elementName) != null) {
				Integer value = map.get(elementName);
				element.setName(elementName + value);
				map.put(elementName, value + 1);
			} else {
				map.put(elementName, 2);
				element.setName(elementName + "1");
			}
			System.out.println(element.getName());
		}
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
