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
import java.util.List;
import java.util.Map;
import java.util.Random;
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
import org.unicase.analyzer.exporters.CSVExporter;
import org.unicase.analyzer.exporters.ExportersFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
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

	public RandomGenerator() {
		map = new HashMap<Object, Object>();
		category1 = new ArrayList<Object>();
		category2 = new ArrayList<Object>();
		category3 = new ArrayList<Object>();

		projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		session = projectSpace.getUsersession();
		pid = (ProjectId) EcoreUtil.copy(projectSpace.getProjectId());
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
	 * @param usersAmount the total amount of users
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws EmfStoreException
	 */
	public void generateUserFolder(int usersAmount) throws IOException, InterruptedException, EmfStoreException {
		for (int i = 0; i < usersAmount; i++) {
			(new File(DIR + i)).mkdir();
			CSVExporter exporter = ExportersFactory.eINSTANCE.createCSVExporter();
			exporter.setFileName(DIR + i + File.separatorChar + "versionInfo.csv");
			exporter.init();

			List<Object> header = new ArrayList<Object>();
			header.add("Category #");
			header.add("Version #");
			header.add("Representation");
			exporter.writeLine(header);

			generateCommits(category1, 1, 5, i, exporter);
			generateCommits(category2, 2, 5, i, exporter);
			generateCommits(category3, 3, 5, i, exporter);

		}
	}

	private void generateCommits(List<Object> category, int categoryNum, int commitsNum, int userNum,
		CSVExporter exporter) throws IOException, EmfStoreException, InterruptedException {
		Random rand = new Random();
		int version;
		boolean representation;// if true operation-based, false state-based

		for (int j = 0; j < 6; j++) {

			version = rand.nextInt(category.size());
			representation = rand.nextBoolean();
			generateRepresentationForCommit(representation, version, categoryNum, userNum, category, exporter);

		}
	}

	private void generateRepresentationForCommit(boolean representation, int version, int categoryNum, int userNum,
		List<Object> category, CSVExporter exporter) throws IOException, EmfStoreException, InterruptedException {
		List<Object> values;
		values = new ArrayList<Object>();
		values.add(categoryNum);
		values.add(category.get(version));
		values.add(representation);
		exporter.writeLine(values);
		version = Integer.valueOf(category.get(version).toString());
		int previousVersion = version - 1;

		PrimaryVersionSpec previousVersionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		previousVersionSpec.setIdentifier(previousVersion);
		Project project1 = (Project) EcoreUtil.copy(WorkspaceManager.getInstance().getConnectionManager().getProject(
			session.getSessionId(), pid, previousVersionSpec));
		killAllDiagrams(project1);

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createFileURI(DIR + userNum + File.separatorChar
			+ "projectstate-" + (version - 1) + ".ups"));
		resource.getContents().add(project1);
		resource.save(null);
		// GeneratorHelper.copyfile(DOLLI_DIR + "/projectstate-" + previousVersion + ".ups", DIR + "/" + i + "/" +
		// "/projectstate-" + previousVersion + ".ups" );

		ChangePackage changePackage = ResourceHelper.getElementFromResource(DOLLI_DIR + "changepackage-" + version
			+ ".ucp", ChangePackage.class, 0);

		Project project2 = (Project) EcoreUtil.copy(project1);
		changePackage.apply(project2);
		// resourceSet = new ResourceSetImpl();
		resource = resourceSet.createResource(URI.createFileURI(DIR + userNum + File.separatorChar + "projectstate-"
			+ version + ".ups"));
		resource.getContents().add(project2);
		resource.save(null);

		if (representation) {
			GeneratorHelper.copyfile(DOLLI_DIR + "changepackage-" + version + ".ucp", DIR + userNum
				+ File.separatorChar + "changepackage-" + version + ".ucp");
		} else {

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
			Resource createResource = resourceSet.createResource(URI.createFileURI(DIR + userNum + File.separatorChar
				+ "diffModel" + version + ".emfdiff"));
			createResource.getContents().add(snapshot);
			createResource.save(null);
			//			
			// final EObject loadedSnapshot = ModelUtils.load(fileURI2, resourceSet);
			//
			// if (loadedSnapshot instanceof ComparisonSnapshot) {
			// CompareUI.openCompareEditorOnPage(new ModelCompareEditorInput((ComparisonSnapshot) loadedSnapshot),
			// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage());
			// }

		}

	}

	private void killAllDiagrams(Project project) {
		EList<MEDiagram> allDiagrams = project.getAllModelElementsbyClass(DiagramPackage.eINSTANCE.getMEDiagram(),
			new BasicEList<MEDiagram>());
		for (MEDiagram diagram : allDiagrams) {
			project.deleteModelElement(diagram);
		}
	}

}
