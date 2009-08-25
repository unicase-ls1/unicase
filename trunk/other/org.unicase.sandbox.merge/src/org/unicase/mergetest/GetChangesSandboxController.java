package org.unicase.mergetest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.ui.stackview.CommandStackViewerAction;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.mergetest.AnalyzeChangeSandboxController.Result;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.KeyStoreManager;

public class GetChangesSandboxController {

	private static final int step = 1;
	private ConnectionManager connectionManager;
	private SessionId sessionId;

	public void run() throws Exception {
		loginServer("super", "super", "127.0.0.1", null, null);

		ProjectInfo projectInfo = getProjectInfo("DOLLI2", false);

		 iterateOverAll(projectInfo);

//		showOne(projectInfo, 2143);

		// storeChanges(projectInfo,"...");

	}

	private void showOne(ProjectInfo projectInfo, int num)
			throws EmfStoreException, RMISerializationException {
		ConflictDetector conflictDetector = new ConflictDetector();

		PrimaryVersionSpec source = getVersionSpec(num - 2);
		PrimaryVersionSpec target = getVersionSpec(num);
		List<ChangePackage> changes = connectionManager.getChanges(sessionId,
				projectInfo.getProjectId(), source, target);
		if (changes.size() != 2) {
			System.exit(0);
		}
		Set<AbstractOperation> conflicting = conflictDetector.getConflicting(
				changes.get(0).getOperations(), changes.get(1).getOperations());

		for (AbstractOperation ao : conflicting) {
			System.out.println(SerializationUtil.eObjectToString(ao));
		}
	}

	private void iterateOverAll(ProjectInfo projectInfo) throws IOException {
		Result result = new AnalyzeChangeSandboxController().new Result();
		ConflictDetector conflictDetector = new ConflictDetector();

		int total = projectInfo.getVersion().getIdentifier();
		System.out.println("total: " + total);
		int i = 2;
		while (i < total) {
			try {
				PrimaryVersionSpec source = getVersionSpec(i - 2);
				PrimaryVersionSpec target = getVersionSpec(i);
				List<ChangePackage> changes = connectionManager.getChanges(
						sessionId, projectInfo.getProjectId(), source, target);
				if (changes.size() != 2) {
					continue;
				}
				Set<AbstractOperation> conflicting = conflictDetector
						.getConflicting(changes.get(0).getOperations(), changes
								.get(1).getOperations());
				result.add(conflicting, i);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.print(".");
			if (i % 50 == 0)
				System.out.println("]");
			i++;
		}

		FileWriter fileWriter = new FileWriter(
				"C:/Users/Otto/Desktop/test.txt", true);

		List<Object> render = result.render();
		for (Object obj : render) {
			System.out.println(obj);
			fileWriter.write(obj.toString());
			fileWriter.write(System.getProperty("line.separator"));
		}
		fileWriter.close();
	}

	private void storeChanges(ProjectInfo projectInfo, String name)
			throws Exception {
		Resource resource = getResource(name);

		int total = projectInfo.getVersion().getIdentifier();
		System.out.println("total: " + total);
		int i = 0;
		while (i < total) {
			try {
				PrimaryVersionSpec source = getVersionSpec(i);
				i = (i + step) > total ? total : i + step;
				PrimaryVersionSpec target = getVersionSpec(i);

				System.out.println("getting changes from: "
						+ source.getIdentifier() + " to: "
						+ target.getIdentifier());
				resource.getContents().addAll(
						connectionManager.getChanges(sessionId, projectInfo
								.getProjectId(), source, target));
			} catch (Exception e) {
				e.printStackTrace();
				resource.getContents().add(
						VersioningFactory.eINSTANCE.createChangePackage());
			}
		}
		resource.save(null);
	}

	private Resource getResource(String name) {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		return resourceSet.createResource(URI.createFileURI(Configuration
				.getWorkspaceDirectory()
				+ name + ".pcpc"));
	}

	private ProjectInfo getProjectInfo(String name, boolean contains)
			throws Exception {
		for (ProjectInfo info : connectionManager.getProjectList(sessionId)) {
			if ((!contains && info.getName().equals(name))
					|| (contains && info.getName().contains(name))) {
				return info;
			}
		}
		throw new IllegalStateException();
	}

	private void loginServer(String username, String password, String url,
			String clientVsn, String certificate) throws Exception {
		connectionManager = WorkspaceManager.getInstance()
				.getConnectionManager();
		ClientVersionInfo clientVersion = Configuration.getClientVersion();
		if (clientVsn != null) {
			clientVersion.setVersion(clientVsn);
		}
		ServerInfo serverInfo = getServerInfo(url, certificate);
		sessionId = connectionManager.logIn(username, KeyStoreManager
				.getInstance().encrypt(password, serverInfo), serverInfo,
				clientVersion);
	}

	private ServerInfo getServerInfo(String url, String certificate) {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setPort(1099);
		serverInfo.setUrl(url);
		if (certificate != null) {
			serverInfo.setCertificateAlias(certificate);
		}
		return serverInfo;
	}

	private PrimaryVersionSpec getVersionSpec(int id) {
		PrimaryVersionSpec primaryVersionSpec = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		primaryVersionSpec.setIdentifier(id);
		return primaryVersionSpec;
	}
}
