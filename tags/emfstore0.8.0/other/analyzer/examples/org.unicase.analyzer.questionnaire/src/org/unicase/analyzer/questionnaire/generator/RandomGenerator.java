/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.questionnaire.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSetSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffResourceSet;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchFactory;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.MatchResourceSet;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.analyzer.exporters.CSVExporter;
import org.unicase.analyzer.exporters.ExportersFactory;
import org.unicase.analyzer.iterator.IteratorFactory;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.ResourceHelper;

/**
 * @author liya
 */
public class RandomGenerator {

	private static final String DIR = Configuration.getWorkspaceDirectory();
	private final String DOLLI_DIR;

	private final Map<Object, Object> map;
	private final List<Object> category1;
	private final List<Object> category2;
	private final List<Object> category3;
	private final ProjectSpace projectSpace;
	private final Usersession session;
	private final ProjectId pid;
	private List<HistoryInfo> history;
	private Set<String> seenMessages;

	public RandomGenerator() {
		map = new HashMap<Object, Object>();
		category1 = new ArrayList<Object>();
		category2 = new ArrayList<Object>();
		category3 = new ArrayList<Object>();

		projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		session = projectSpace.getUsersession();
		pid = (ProjectId) EcoreUtil.copy(projectSpace.getProjectId());

		VersionIterator it = IteratorFactory.eINSTANCE.createVersionIterator();
		try {
			it.init(session, pid, 1);
			history = it.getProjectHistory();
		} catch (IteratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DOLLI_DIR = DIR + "emfstore" + File.separatorChar + "project-" + pid.getId() + File.separatorChar;
	}

	public void readFile(File file) throws IOException {
		BufferedReader bufRdr = new BufferedReader(new FileReader(file));

		String line = null;
		String[] temp = new String[4];

		// read each line of text file
		while ((line = bufRdr.readLine()) != null) {
			int col = 0;
			StringTokenizer st = new StringTokenizer(line, ",");
			while (st.hasMoreTokens()) {
				// get next token and store it in the array
				temp[col] = st.nextToken();
				col++;
			}

			try {
				int parseInt = Integer.parseInt(temp[2]);
				if (parseInt < 5) {
					continue;
				}
				if (parseInt > 30) {
					continue;
				}
			} catch (NumberFormatException e) {
				continue;
			}

			map.put(temp[0], temp[1]);
			if (temp[1].equals("1")) {
				category1.add(temp[0]);
			} else if (temp[1].equals("2")) {
				category2.add(temp[0]);
			} else if (temp[1].equals("3")) {
				category3.add(temp[0]);
			}
		}
	}

	/**
	 * Generate the user folders, each contains random project from different categories, change package and diffmodel
	 * depends on different representation.
	 * 
	 * @param folderAmount the total amount of folders
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws EmfStoreException
	 */
	public void generateUserFolder(int folderAmount) throws IOException, InterruptedException, EmfStoreException {
		for (int i = 0; i < folderAmount; i++) {
			(new File(DIR + i)).mkdir();
			CSVExporter exporter0 = ExportersFactory.eINSTANCE.createCSVExporter();
			int user0 = 2 * i;
			exporter0.setFileName(DIR + i + File.separatorChar + "versionInfo-" + user0 + ".csv");
			exporter0.init();

			CSVExporter exporter1 = ExportersFactory.eINSTANCE.createCSVExporter();
			int user1 = 2 * i + 1;
			exporter1.setFileName(DIR + i + File.separatorChar + "versionInfo-" + user1 + ".csv");
			exporter1.init();

			List<Object> header = new ArrayList<Object>();
			header.add("Category #");
			header.add("Version #");
			header.add("Representation");
			exporter0.writeLine(header);
			exporter1.writeLine(header);

			generateCommits(category1, 1, 5, i, exporter0, exporter1);
			generateCommits(category2, 2, 5, i, exporter0, exporter1);
			generateCommits(category3, 3, 5, i, exporter0, exporter1);

		}
	}

	private void generateCommits(List<Object> category, int categoryNum, int commitsNum, int folderNum,
		CSVExporter exporter0, CSVExporter exporter1) throws IOException, EmfStoreException, InterruptedException {
		Random rand = new Random();
		int version;
		boolean representation = false;// if true operation-based, false state-based

		for (int j = 0; j < 6; j++) {

			version = rand.nextInt(category.size());
			representation = !representation; // rand.nextBoolean();
			generateRepresentationForCommit(representation, version, categoryNum, folderNum, category, exporter0,
				exporter1);

		}
	}

	private void generateRepresentationForCommit(boolean representation, int version, int categoryNum, int folderNum,
		List<Object> category, CSVExporter exporter0, CSVExporter exporter1) throws IOException, EmfStoreException,
		InterruptedException {

		seenMessages = new HashSet<String>();
		List<Object> values0 = new ArrayList<Object>();
		values0.add(categoryNum);
		values0.add(category.get(version));
		values0.add(representation);
		exporter0.writeLine(values0);

		List<Object> values1 = new ArrayList<Object>();
		values1.add(categoryNum);
		values1.add(category.get(version));
		values1.add(!representation);
		exporter1.writeLine(values1);

		version = Integer.valueOf(category.get(version).toString());
		int previousVersion = version - 1;

		PrimaryVersionSpec previousVersionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		previousVersionSpec.setIdentifier(previousVersion);
		Project project1 = (Project) EcoreUtil.copy(WorkspaceManager.getInstance().getConnectionManager().getProject(
			session.getSessionId(), pid, previousVersionSpec));
		Set<ModelElementId> allDiagrams = killAllDiagrams(project1);

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createFileURI(DIR + folderNum + File.separatorChar
			+ "projectstate-" + (version - 1) + ".ups"));
		// ProjectSpace projectSpace1 = WorkspaceFactory.eINSTANCE.createProjectSpace();
		// projectSpace1.setProjectName("Project");
		// projectSpace1.setIdentifier(("Project"));
		// projectSpace1.setProject(project1);
		resource.getContents().add(project1);
		resource.save(null);
		// GeneratorHelper.copyfile(DOLLI_DIR + "/projectstate-" + previousVersion + ".ups", DIR + "/" + i + "/" +
		// "/projectstate-" + previousVersion + ".ups" );

		ChangePackage changePackage = ResourceHelper.getElementFromResource(DOLLI_DIR + "changepackage-" + version
			+ ".ucp", ChangePackage.class, 0);

		killAllDiagramOperations(changePackage, allDiagrams);

		Project project2 = (Project) EcoreUtil.copy(project1);
		changePackage.apply(project2);
		// resourceSet = new ResourceSetImpl();
		resource = resourceSet.createResource(URI.createFileURI(DIR + folderNum + File.separatorChar + "projectstate-"
			+ version + ".ups"));
		// ProjectSpace projectSpace2 = WorkspaceFactory.eINSTANCE.createProjectSpace();
		// projectSpace2.setProjectName("Project");
		// projectSpace2.setIdentifier("Project");
		// projectSpace2.setProject(project2);
		resource.getContents().add(project2);
		resource.save(null);

		GeneratorHelper.copyfile(DOLLI_DIR + "changepackage-" + version + ".ucp", DIR + folderNum + File.separatorChar
			+ "changepackage-" + version + ".ucp");

		// GeneratorHelper.copyfile(DOLLI_DIR + "/projectstate-" + version + ".ups", DIR + "/" + i + "/" +
		// "/projectstate-" + version + ".ups" );

		// resourceSet = new ResourceSetImpl();
		MatchModel match = MatchService.doMatch(project2, project1, Collections.<String, Object> emptyMap());
		DiffModel diff = DiffService.doDiff(match, false);
		DiffResourceSet diffSet = DiffFactory.eINSTANCE.createDiffResourceSet();
		diffSet.getDiffModels().add(diff);
		MatchResourceSet matchSet = MatchFactory.eINSTANCE.createMatchResourceSet();
		matchSet.getMatchModels().add(match);
		ComparisonResourceSetSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSetSnapshot();
		snapshot.setDiffResourceSet(diffSet);
		snapshot.setMatchResourceSet(matchSet);
		// ModelUtils.save(snapshot, DIR + i + File.separatorChar + "diffModel" + version + ".emfdiff");
		Resource createResource = resourceSet.createResource(URI.createFileURI(DIR + folderNum + File.separatorChar
			+ "diffModel" + version + ".emfdiff"));
		createResource.getContents().add(snapshot);
		createResource.save(null);

		// get log message
		Random rand = new Random();

		List<String> logMsgs = new ArrayList<String>();
		List<Boolean> correct = new ArrayList<Boolean>();

		String correctMessage = history.get(history.size() - 1 - version).getLogMessage().getMessage();
		logMsgs.add(trim(correctMessage));
		seenMessages.add(correctMessage);
		correct.add(true);
		for (int i = 1; i < 10; i++) {
			int ind = rand.nextInt(logMsgs.size() + 1);
			logMsgs.add(ind, getLogMessage(rand));
			correct.add(ind, false);
		}

		CSVExporter log = ExportersFactory.eINSTANCE.createCSVExporter();
		log.init(DIR + folderNum + File.separatorChar + "logMsgs-" + version + ".csv");
		for (String message : logMsgs) {
			List<Object> line = new ArrayList<Object>();
			line.add(message);
			log.writeLine(line);
		}

		CSVExporter choice = ExportersFactory.eINSTANCE.createCSVExporter();
		choice.init(DIR + folderNum + File.separatorChar + "choices-" + version + ".csv");
		for (Boolean cor : correct) {
			List<Object> line = new ArrayList<Object>();
			line.add(cor);
			choice.writeLine(line);
		}

	}

	private void killAllDiagramOperations(ChangePackage changePackage, Set<ModelElementId> diagrams) {
		Set<AbstractOperation> operationsToRemove = new HashSet<AbstractOperation>();
		for (AbstractOperation operation : changePackage.getOperations()) {
			if (diagrams.contains(operation.getModelElementId())) {
				operationsToRemove.add(operation);
			} else if (operation instanceof CreateDeleteOperation) {
				CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;
				if (createDeleteOperation.getModelElement() instanceof MEDiagram) {
					operationsToRemove.add(operation);
				}
			}

		}
		changePackage.getOperations().removeAll(operationsToRemove);
	}

	private String trim(String message) {
		String result = message.replace(",", ".");
		result = result.replace("\n", " | ");
		result = result.replace("\r", " | ");
		return result;
	}

	private String getLogMessage(Random rand) {
		String result;
		result = history.get(rand.nextInt(history.size())).getLogMessage().getMessage();
		while (!isValid(result)) {
			result = history.get(rand.nextInt(history.size())).getLogMessage().getMessage();
		}
		return trim(result);
	}

	private boolean isValid(String result) {
		if (result == null) {
			return false;
		}
		if (result.length() < 3) {
			return false;
		}
		if (seenMessages.contains(result)) {
			return false;
		}
		if (result.equals("<Empty log message>")) {
			return false;
		}
		seenMessages.add(result);
		return true;
	}

	private Set<ModelElementId> killAllDiagrams(Project project) {
		Set<ModelElementId> result = new HashSet<ModelElementId>();
		EList<MEDiagram> allDiagrams = project.getAllModelElementsbyClass(DiagramPackage.eINSTANCE.getMEDiagram(),
			new BasicEList<MEDiagram>());
		for (MEDiagram diagram : allDiagrams) {
			result.add(diagram.getModelElementId());
			project.deleteModelElement(diagram);
		}
		return result;
	}

}
