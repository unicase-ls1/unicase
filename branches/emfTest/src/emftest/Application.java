package emftest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.registry.Registry;
import java.util.Collections;
import java.util.Date;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.emfstore.connection.rmi.RMIUtil;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.changemanagment.ChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.emfstore.esmodel.changemanagment.LogMessage;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.component.Component;
import org.unicase.model.component.ComponentFactory;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.impl.ProjectSpaceImpl;
import org.unicase.workspace.impl.WorkspaceImpl;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	private ChangeRecorder changeRecorder;
	private ChangePackage cpBefore;
	private TransactionalEditingDomain domain;

	public static String filePath = Configuration.getWorkspaceDirectory()
			+ "test";

	// public static URI eObjectToString = URI.createFileURI(filePath);
	public static URI eObjectToString = URI.createURI("my.eobject/uri");

	public ResourceSet rs = WorkspaceManager.getInstance()
			.getCurrentWorkspace().eResource().getResourceSet();

	private Project project;

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.
	 * IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("Hello RCP World!");
		final ConnectionManager cm = WorkspaceManager.getInstance()
				.getConnectionManager();
		final Workspace currentWorkspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();

		domain = currentWorkspace.getEditingDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			protected void doExecute() {
				try {
					// login
					final Usersession usersession = WorkspaceFactory.eINSTANCE
							.createUsersession();
					ServerInfo defaultServerInfo = Configuration
							.getDefaultServerInfo();
					currentWorkspace.getServerInfos().add(defaultServerInfo);
					usersession.setServerInfo(defaultServerInfo);
					usersession.setUsername("");
					usersession.setPassword("");
					usersession.logIn();

					final ProjectInfo projectInfo = usersession.createProject(
							"name", "description");
					ProjectSpace projectSpace = currentWorkspace.checkout(
							usersession, projectInfo);
					currentWorkspace.getProjectSpaces().add(projectSpace);
					project = projectSpace.getProject();

					changeRecorder = new ChangeRecorder();
					changeRecorder.beginRecording(Collections
							.singleton(project));

					Component com = ComponentFactory.eINSTANCE
							.createComponent();
					com.setDescription("a component");
					com.setName("component");

					project.addModelElement(com);

					cpBefore = save();
					((ProjectSpaceImpl) projectSpace).setProjectGen(null);
					ResourceSet resourceSet = new ResourceSetImpl();

					Resource resource2 = resourceSet.createResource(URI
							.createURI("jfdksdddd"));
					resource2.getContents().add(project);
					rs = resourceSet;
					resource2.save(null);


				Diagnostician.INSTANCE.validate(cpBefore);

				// System.out.println(eObjectToString(cpBefore));

				ChangePackage cpAfter = (ChangePackage) stringToEObject(eObjectToString(cpBefore));

				System.out.println(cpAfter);

				Diagnostician.INSTANCE.validate(cpAfter);

				LogMessage log = ChangemanagmentFactory.eINSTANCE
						.createLogMessage();
				log.setAuthor("");
				log.setMessage("");
				log.setDate(new Date());

				PrimaryVersionSpec resolvedVersion = cm.resolveVersionSpec(
						usersession.getSessionId(), projectInfo.getProjectId(),
						ChangemanagmentFactory.eINSTANCE
								.createHeadVersionSpec());
				PrimaryVersionSpec pri = cm.createVersion(usersession
						.getSessionId(), projectInfo.getProjectId(),
						resolvedVersion, cpBefore, log);
				System.out.println("Primary: " + pri);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		System.out.println("ENDE");
		//
		// PrimaryVersionSpec pri2 = cm.resolveVersionSpec(id,
		// pinfo.getProjectId(),
		// ChangemanagmentFactory.eINSTANCE.createHeadVersionSpec());
		//
		// System.out.println("Primary: "+pri);

		return IApplication.EXIT_OK;
	}

	private ChangePackage save() {
		ChangeDescription changeDescription = this.changeRecorder
				.endRecording();
		ChangeDescription backwardChangeDescription = (ChangeDescription) EcoreUtil
				.copy(changeDescription);
		changeDescription.applyAndReverse();
		ChangeDescription forwardChangeDescription = (ChangeDescription) EcoreUtil
				.copy(changeDescription);
		changeDescription.apply();
		ChangePackage changePackage = ChangemanagmentFactory.eINSTANCE
				.createChangePackage();
		changePackage.setBackwardDelta(backwardChangeDescription);
		changePackage.setFowardDelta(forwardChangeDescription);
		return changePackage;
	}

	public void stop() {
		// nothing to do
	}

	public Resource initTestResource() {
		File test = new File(filePath);
		// rs.getURIConverter().getURIMap().put(RMIUtil.eObjectToString,
		// URI.createFileURI(Configuration.getWorkspacePath()));
		// if(!test.exists()) {
		return rs.createResource(eObjectToString);
		// } else {
		//
		// return rs.getResource(eObjectToString,true);
		// }
		// return rs.getResource(eObjectToString, true);

	}

	public String eObjectToString(final EObject object) throws IOException {
		// TODO Uri
		final Resource res = initTestResource();
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				res.getContents().add(object);
				try {
					res.save(out, null);
					// res.save(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		return out.toString();
		// return "";
	}

	public EObject stringToEObject(final String object)
			throws UnsupportedEncodingException, IOException {
		// TODO Uri
		final Resource res = initTestResource();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				try {
					// res.load(null);
					res.load(
							new ByteArrayInputStream(object.getBytes("UTF-8")),
							null);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		return res.getContents().get(0);
	}
}
