package org.unicase.mergetest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.ui.stackview.CommandStackViewerAction;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.UpdateEvent;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.mergetest.AnalyzeChangeSandboxController.Result;
import org.unicase.model.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.KeyStoreManager;

public class AnalyzeConflictsController {

	public static final int step = 1;
	public ConnectionManager connectionManager;
	public SessionId sessionId;
	public int i;
	public int size;
	public ArrayList<int[]> conflicts;
	public ProjectInfo projectInfo;

	public void run() throws Exception {
		loginServer("super", "super", "127.0.0.1", null, null);

		projectInfo = getProjectInfo("tale", true);

		conflicts = new ArrayList<int[]>();
		
		iterateOverAll(projectInfo);
		
		Display display = new Display();
		ShowConflictsDialog conflictsDialog = new ShowConflictsDialog(this);
		conflictsDialog.open();

		// showOne(projectInfo, 2143);

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
//		Result result = new AnalyzeChangeSandboxController().new Result();

		TreeMap<Integer, List<UpdateEvent>> sortedMap = getUpdateEvents(projectInfo);

//		for (Integer integer : sortedMap.keySet()) {
//			System.out.print(integer + " ");
//			for (UpdateEvent update : sortedMap.get(integer)) {
//				System.out.print("[" + update.getBaseVersion().getIdentifier()
//						+ ":" + update.getTargetVersion().getIdentifier()
//						+ "] ");
//			}
//			System.out.println("");
//		}

		for (Integer integer : sortedMap.keySet()) {
			try {
				List<ChangePackage> myChanges = connectionManager.getChanges(
						sessionId, projectInfo.getProjectId(), getVersionSpec(integer - 1), getVersionSpec(integer));
				
				List<UpdateEvent> list = sortedMap.get(integer);
				UpdateEvent lastUpdateEvent = list.get(list.size()-1);
				List<ChangePackage> theirChanges = connectionManager.getChanges(
						sessionId, projectInfo.getProjectId(), lastUpdateEvent.getBaseVersion(), lastUpdateEvent.getTargetVersion());
				
				if(myChanges.size()!=1) {
					throw new IllegalStateException();
				}
				checkForConflicts(integer, lastUpdateEvent.getBaseVersion().getIdentifier(), lastUpdateEvent.getTargetVersion().getIdentifier(), myChanges.get(0), theirChanges);
			
			} catch (EmfStoreException e) {
				e.printStackTrace();
			}

		}

		// saveToFile(result,"test");
	}

	private void checkForConflicts(int versionNumber, int base, int target,
			ChangePackage myChanges, List<ChangePackage> theirChanges) {
		ConflictDetector conflictDetector = new ConflictDetector();
		if(conflictDetector.doConflict(myChanges, theirChanges)) {
			
			conflicts.add(new int[] {versionNumber,base,target});

			printCollision(versionNumber, base, target, myChanges, theirChanges);
			
			int j = 1;
			for(AbstractOperation ao : myChanges.getOperations()) {
				int cpc = 0;
				for(ChangePackage cp : theirChanges) {
					for(AbstractOperation theirAo : cp.getOperations()) {
						if(conflictDetector.doConflict(ao, theirAo)) {
							printCollidingOperation(j++, ao, cpc, theirAo);
							
						}
					}
					cpc++;
				}
			}
		}
		
	}

	public Project getProject(int version) throws EmfStoreException {
		return connectionManager.getProject(sessionId, projectInfo.getProjectId(), getVersionSpec(version));
	}
	
	public List<ChangePackage> getChanges(int source, int target) throws EmfStoreException {
		return connectionManager.getChanges(sessionId, projectInfo.getProjectId(), getVersionSpec(source), getVersionSpec(target));
	}
	
	private void printCollidingOperation(int j, AbstractOperation ao, int cpc,
			AbstractOperation theirAo) {
		System.out.print("\t\t"+j+". cp: "+cpc+" - ");
		System.out.print(ao.getClass().getSimpleName());
		if(ao instanceof CompositeOperation) {
			System.out.print(" ("+((CompositeOperation) ao).getSubOperations().size()+")");
		}
		System.out.print(" => ");
		System.out.print(theirAo.getClass().getSimpleName());
		if(theirAo instanceof CompositeOperation) {
			System.out.print(" ("+((CompositeOperation) theirAo).getSubOperations().size()+")");
		}
		System.out.println("");
	}

	private void printCollision(int versionNumber, int base, int target,
			ChangePackage myChanges, List<ChangePackage> theirChanges) {
		System.out.print("["+(i++)+"]Collision in version: "+versionNumber);
		System.out.print(" ("+base+"-"+target+")");
		System.out.print(" myOperations: "+myChanges.getOperations().size());
		System.out.print(" theirCP: "+theirChanges.size());
		int totalsize = 0;
		String cpSizes = "";
		for(ChangePackage cp : theirChanges) {
			cpSizes += " "+cp.getOperations().size()+",";
			totalsize += cp.getOperations().size();
		}
		System.out.println(" theirTotalOperations: "+totalsize+" operationsPerCP:"+cpSizes);
	}

	private TreeMap<Integer, List<UpdateEvent>> getUpdateEvents(
			ProjectInfo projectInfo) {
		TreeMap<Integer, List<UpdateEvent>> sortedMap = new TreeMap<Integer, List<UpdateEvent>>();

		int total = projectInfo.getVersion().getIdentifier();
		System.out.println("total: " + total);
		int i = 1;
		while (i < total) {
			try {
				PrimaryVersionSpec source = getVersionSpec(i - 1);
				PrimaryVersionSpec target = getVersionSpec(i);
				List<ChangePackage> changes = connectionManager.getChanges(
						sessionId, projectInfo.getProjectId(), source, target);
				if (changes.size() != 1) {
					continue;
				}

				for (ChangePackage cp : changes) {
					for (Event event : cp.getEvents()) {
						if (event instanceof UpdateEvent) {
							List<UpdateEvent> list = sortedMap.get(i);
							if (list == null) {
								list = new ArrayList<UpdateEvent>();
								sortedMap.put(i, list);
							}
							list.add((UpdateEvent) event);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}
		return sortedMap;
	}

	private void saveToFile(Result result, String fileName) throws IOException {
		FileWriter fileWriter = new FileWriter("C:/Users/Otto/Desktop/"
				+ fileName + ".txt", true);

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

	public PrimaryVersionSpec getVersionSpec(int id) {
		PrimaryVersionSpec primaryVersionSpec = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		primaryVersionSpec.setIdentifier(id);
		return primaryVersionSpec;
	}
}
