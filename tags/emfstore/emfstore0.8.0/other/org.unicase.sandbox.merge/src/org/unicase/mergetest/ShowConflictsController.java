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
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.mergetest.AnalyzeChangeSandboxController.Result;
import org.unicase.mergetest.util.SpreadSheet;
import org.unicase.mergetest.util.Sum;
import org.unicase.metamodel.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.KeyStoreManager;

public class ShowConflictsController {

	public static final int step = 1;
	public ConnectionManager connectionManager;
	public SessionId sessionId;
	public int i;
	public int size;
	public ArrayList<int[]> conflicts;
	public ProjectInfo projectInfo;

	public SpreadSheet analysis;
	private Sum conflictUpdateRange;

	public void run() throws Exception {
		loginServer("super", "super", "127.0.0.1", null, null);

		projectInfo = getProjectInfo("kings", true);

		analysis = new SpreadSheet();
		analysis.addRow(0, "Project name").add(projectInfo.getName());
		analysis.addRow(6, "Versions (Commits)").add(
				projectInfo.getVersion().getIdentifier());

		conflictUpdateRange = new Sum();
		conflicts = new ArrayList<int[]>();
		iterateOverAll(projectInfo);

		analyse(conflicts);

		analysis.addRow(7, "Average Update Range for Conflict").add(
				conflictUpdateRange.getAverage());
		analysis.addRow(8, "Conflict per Commit").add(
				conflicts.size()
						/ ((float) projectInfo.getVersion().getIdentifier()));

		analysis.display();

		Display c = new Display();
		ShowConflictsDialog conflictsDialog = new ShowConflictsDialog(this);
		conflictsDialog.open();

		// showOne(projectInfo, 2143);

		// storeChanges(projectInfo,"...");

	}

	private void analyse(ArrayList<int[]> conflicts) {
		ArrayList<Integer> attCol = new ArrayList<Integer>(3);
		attCol.add(0);
		attCol.add(0);
		attCol.add(0);
		ArrayList<Integer> refCol = new ArrayList<Integer>(3);
		refCol.add(0);
		refCol.add(0);
		refCol.add(0);
		ArrayList<Integer> delCol = new ArrayList<Integer>(3);
		delCol.add(0);
		delCol.add(0);
		delCol.add(0);
		
		Sum averageConflictSize = new Sum();
		
		Sum averageRangeConflict = new Sum();

		Sum averageMyOperationsTop = new Sum();
		Sum averageTheirOperationsTop = new Sum();
		
		int other = 0;
		for (int[] conflict : conflicts) {
			try {
				ChangePackage myChanges = getChanges(conflict[0] - 1,
						conflict[0]).get(0);
				List<ChangePackage> theirChanges = getChanges(conflict[1],
						conflict[2]);
				
				averageRangeConflict.add((float) (conflict[2]-conflict[1]));
				averageMyOperationsTop.add((float) myChanges.getOperations().size());
				int s = 0;
				for(ChangePackage cp : theirChanges){
					s += cp.getOperations().size();
				}
				averageTheirOperationsTop.add((float) s);
				
				
				
				ConflictDetector conflictDetector = new ConflictDetector();
				
				int size=0;
				for(AbstractOperation myOperation : myChanges.getOperations()) {
					for(ChangePackage theirCP : theirChanges) {
						for(AbstractOperation theirOperation : theirCP.getOperations()) {
							if(conflictDetector.doConflict(myOperation, theirOperation)) {
								if(myOperation instanceof AttributeOperation) {
									check(attCol,theirOperation);
								} else if(myOperation instanceof CompositeOperation) {
									check(refCol,theirOperation);
								} else if(myOperation instanceof CreateDeleteOperation) {
									check(delCol,theirOperation);
								} else {
									other++;
									System.out.println("[Other] myOp: "+myOperation.getClass().getSimpleName()+" => theirOp: "+theirOperation.getClass().getSimpleName());
								}
								size++;
							}
						}
					}
				}
				averageConflictSize.add((float)size);

			} catch (EmfStoreException e) {
				e.printStackTrace();
			}
		}
		
		analysis.addRow(8, "Total my Operatiosn if Conflict").add(averageMyOperationsTop.getAverage());
		analysis.addRow(8, "Total their Operations if Conflict").add(averageTheirOperationsTop.getAverage());

		analysis.addRow(7, "Average Update Range if Conflict").add(averageRangeConflict.getAverage());
		analysis.addRow(9, "Average Operations in Conflict").add(averageConflictSize.getAverage());
		List<Object> addRow = analysis.addRow(10, "MY\\THEIR");
		addRow.add("Attribute");
		addRow.add("Ref (Composite)");
		addRow.add("CreateDelete");
		analysis.addRow(11, "Attribute").addAll(attCol);
		analysis.addRow(12, "Ref (Composite)").addAll(refCol);
		analysis.addRow(13, "CreateDelete").addAll(delCol);
		analysis.addRow(14, "Other Conflicts").add(other);
	}

	private void check(ArrayList<Integer> col,
			AbstractOperation theirOperation) {
		if(theirOperation instanceof AttributeOperation) {
			col.set(0, col.get(0)+1);
		} else if(theirOperation instanceof CompositeOperation) {
			col.set(1, col.get(1)+1);
		} else if(theirOperation instanceof CreateDeleteOperation) {
			col.set(2, col.get(2)+1);
		}
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
		// Result result = new AnalyzeChangeSandboxController().new Result();

		TreeMap<Integer, List<UpdateEvent>> sortedMap = getUpdateEvents(projectInfo);

		analysis.addRow(1, "Versions with UpdateEvents").add(
				sortedMap.keySet().size());
		analysis.addRow(2, "Average #Version with UpdateEvents").add(
				sortedMap.keySet().size()
						/ ((float) projectInfo.getVersion().getIdentifier()));

		printUpdateEvents(sortedMap);

		for (Integer integer : sortedMap.keySet()) {
			try {
				List<ChangePackage> myChanges = connectionManager.getChanges(
						sessionId, projectInfo.getProjectId(),
						getVersionSpec(integer - 1), getVersionSpec(integer));

				List<UpdateEvent> list = sortedMap.get(integer);
				UpdateEvent lastUpdateEvent = list.get(list.size() - 1);

				// changed
				lastUpdateEvent.setBaseVersion(list.get(0).getBaseVersion());

				List<ChangePackage> theirChanges = connectionManager
						.getChanges(sessionId, projectInfo.getProjectId(),
								lastUpdateEvent.getBaseVersion(),
								lastUpdateEvent.getTargetVersion());

				if (myChanges.size() != 1) {
					throw new IllegalStateException();
				}
				checkForConflicts(integer, lastUpdateEvent.getBaseVersion()
						.getIdentifier(), lastUpdateEvent.getTargetVersion()
						.getIdentifier(), myChanges.get(0), theirChanges);

			} catch (EmfStoreException e) {
				e.printStackTrace();
			}

		}

		// saveToFile(result,"test");
	}

	private void printUpdateEvents(TreeMap<Integer, List<UpdateEvent>> sortedMap) {
		int updateEvents = 0;
		Sum averageUpdateEvents = new Sum();
		for (Integer integer : sortedMap.keySet()) {
			System.out.print(integer + " ");
			List<UpdateEvent> events = sortedMap.get(integer);
			averageUpdateEvents.add((float) events.size());
			for (UpdateEvent update : events) {
				System.out.print("[" + update.getBaseVersion().getIdentifier()
						+ ":" + update.getTargetVersion().getIdentifier()
						+ "] ");
				updateEvents++;
			}
			System.out.println("");
		}
		analysis.addRow(3, "Total # UpdateEvents").add(updateEvents);
		analysis.addRow(4, "Average # UpdateEvents").add(
				averageUpdateEvents.getAverage());
	}

	private void checkForConflicts(int versionNumber, int base, int target,
			ChangePackage myChanges, List<ChangePackage> theirChanges) {
		ConflictDetector conflictDetector = new ConflictDetector();

		conflictUpdateRange.add((float) (target - base));

		if (conflictDetector.doConflict(myChanges, theirChanges)) {

			conflicts.add(new int[] { versionNumber, base, target });

			printCollision(versionNumber, base, target, myChanges, theirChanges);

			int j = 1;
			for (AbstractOperation myOperation : myChanges.getOperations()) {
				int cpc = 0;
				for (ChangePackage cp : theirChanges) {
					for (AbstractOperation theirOperation : cp.getOperations()) {
						if (conflictDetector.doConflict(myOperation, theirOperation)) {
							printCollidingOperation(j++, myOperation, cpc, theirOperation);

						}
					}
					cpc++;
				}
			}
		}
	}

	public Project getProject(int version) throws EmfStoreException {
		return connectionManager.getProject(sessionId, projectInfo
				.getProjectId(), getVersionSpec(version));
	}

	public List<ChangePackage> getChanges(int source, int target)
			throws EmfStoreException {
		return connectionManager
				.getChanges(sessionId, projectInfo.getProjectId(),
						getVersionSpec(source), getVersionSpec(target));
	}

	private void printCollidingOperation(int j, AbstractOperation ao, int cpc,
			AbstractOperation theirAo) {
		System.out.print("\t\t" + j + ". cp: " + cpc + " - ");
		System.out.print(ao.getClass().getSimpleName());
		if (ao instanceof CompositeOperation) {
			System.out
					.print(" ("
							+ ((CompositeOperation) ao).getSubOperations()
									.size() + ")");
		}
		System.out.print(" => ");
		System.out.print(theirAo.getClass().getSimpleName());
		if (theirAo instanceof CompositeOperation) {
			System.out.print(" ("
					+ ((CompositeOperation) theirAo).getSubOperations().size()
					+ ")");
		}
		System.out.println("");
	}

	private void printCollision(int versionNumber, int base, int target,
			ChangePackage myChanges, List<ChangePackage> theirChanges) {
		System.out.print("[" + (i++) + "]Collision in version: "
				+ versionNumber);
		System.out.print(" (" + base + "-" + target + ")");
		System.out.print(" myOperations: " + myChanges.getOperations().size());
		System.out.print(" theirCP: " + theirChanges.size());
		int totalsize = 0;
		String cpSizes = "";
		for (ChangePackage cp : theirChanges) {
			cpSizes += " " + cp.getOperations().size() + ",";
			totalsize += cp.getOperations().size();
		}
		System.out.println(" theirTotalOperations: " + totalsize
				+ " operationsPerCP:" + cpSizes);
	}

	private TreeMap<Integer, List<UpdateEvent>> getUpdateEvents(
			ProjectInfo projectInfo) {
		TreeMap<Integer, List<UpdateEvent>> sortedMap = new TreeMap<Integer, List<UpdateEvent>>();

		Sum commitSizeTopLevel = new Sum();
		Sum commitSizeLeafLevel = new Sum();

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

				commitSizeTopLevel.add((float) changes.get(0).getOperations()
						.size());
				commitSizeLeafLevel.add((float) changes.get(0)
						.getLeafOperations().size());

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
		analysis.addRow(5, "Average Commit Size Top Level Operations").add(
				commitSizeTopLevel.getAverage());
		analysis.addRow(6, "Average Commit Size Leaf Level Operations").add(
				commitSizeLeafLevel.getAverage());

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
