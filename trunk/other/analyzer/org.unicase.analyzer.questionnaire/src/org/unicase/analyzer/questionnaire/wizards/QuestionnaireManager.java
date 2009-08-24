/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.questionnaire.wizards;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.compare.CompareUI;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSetSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.compare.util.ModelUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.analyzer.exporters.CSVExporter;
import org.unicase.analyzer.exporters.ExportersFactory;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.ui.views.CompareView;
import org.unicase.workspace.ui.views.StructuralView;
import org.unicase.workspace.util.ResourceHelper;

/**
 * Controller for Questionnaire is a singleton.
 * 
 * @author liya
 */
public final class QuestionnaireManager {

	private static final String DIR = Configuration.getWorkspaceDirectory();
	private static QuestionnaireManager instance;

	private int user;
	private Map<Integer, Boolean> commitsMap;

	private Iterator<Integer> it;

	private long time;
	private int version;
	private CSVExporter exporter;
	private int evaluationResult;
	private IEditorPart activeEditor;

	public static QuestionnaireManager getInstance() {
		if (instance == null) {
			instance = new QuestionnaireManager();
		}
		return instance;
	}

	public static void dispose() {
		instance = null;
	}

	private QuestionnaireManager() {
		commitsMap = new HashMap<Integer, Boolean>();

	}

	public boolean hasNext() {
		return it.hasNext();
	}

	public void next() {
		version = it.next();
		if (commitsMap.get(version)) {
			String projectFileName = DIR + user + "/projectstate-" + (version - 1) + ".ups";
			String changeFileName = DIR + user + "/changepackage-" + version + ".ucp";
			try {
				Project project = ResourceHelper.getElementFromResource(projectFileName, Project.class, 0);
				ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
				projectSpace.setProject(project);
				ChangePackage changePackage = ResourceHelper.getElementFromResource(changeFileName,
					ChangePackage.class, 0);

				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				String viewId = "org.unicase.workspace.ui.views.CompareView";
				CompareView compareView = (CompareView) page.showView(viewId);

				if (compareView != null) {
					compareView.setInput(project, changePackage);
				}
				StructuralView structuralView = (StructuralView) page
					.showView("org.unicase.workspace.ui.views.StructuralView");

				if (structuralView != null) {
					structuralView.setInput(projectSpace);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		} else {
			String diffFileName = DIR + user + "/" + "diffModel" + version + ".emfdiff";

			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(URI.createFileURI(diffFileName), true);
			EList<EObject> directContents = resource.getContents();
			ComparisonResourceSetSnapshot diff = (ComparisonResourceSetSnapshot) directContents.get(0);

			try {
				EObject loadedSnapshot = ModelUtils.load(URI.createFileURI(diffFileName), resourceSet);
				if (loadedSnapshot instanceof ComparisonSnapshot) {
					if (activeEditor != null) {
						activeEditor.getSite().getPage().closeEditor(activeEditor, false);
					}
					CompareUI.openCompareEditorOnPage(new ModelCompareEditorInput((ComparisonSnapshot) loadedSnapshot),
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage());
					activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
						.getActiveEditor();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void initExporter() {
		exporter = ExportersFactory.eINSTANCE.createCSVExporter();
		try {
			exporter.init(DIR + user + File.separatorChar + "result.csv");

			List<Object> header = new ArrayList<Object>();
			header.add("Version #");
			header.add("Time");
			header.add("Self-assessment");
			exporter.writeLine(header);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initCommitMap() {
		try {
			readFile();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		it = commitsMap.keySet().iterator();
	}

	/**
	 * @return the user
	 */
	public int getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(int user) {
		this.user = user;
	}

	/**
	 * @return the commitsMap
	 */
	public Map<Integer, Boolean> getCommitsMap() {
		return commitsMap;
	}

	/**
	 * @param commitsMap the commitsMap to set
	 */
	public void setCommitsMap(Map<Integer, Boolean> commitsMap) {
		this.commitsMap = commitsMap;
	}

	private void readFile() throws NumberFormatException, IOException {
		File file = new File(DIR + user + File.separatorChar + "versionInfo.csv");// read information of versions and
		// its representation

		BufferedReader bufRdr = new BufferedReader(new FileReader(file));

		String line = null;
		String[] temp = new String[3];

		// read each line of text file
		while ((line = bufRdr.readLine()) != null) {
			int col = 0;
			StringTokenizer st = new StringTokenizer(line, ",");
			while (st.hasMoreTokens()) {
				// get next token and store it in the array
				temp[col] = st.nextToken();
				col++;
			}
			if (!temp[1].contains("Version")) {
				commitsMap.put(Integer.valueOf(temp[1]), Boolean.valueOf(temp[2]));
			}
		}
	}

	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}

	/**
	 * @return the exporter
	 */
	public CSVExporter getExporter() {
		return exporter;
	}

	/**
	 * @param exporter the exporter to set
	 */
	public void setExporter(CSVExporter exporter) {
		this.exporter = exporter;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the evaluationResult
	 */
	public int getEvaluationResult() {
		return evaluationResult;
	}

	/**
	 * @param evaluationResult the evaluationResult to set
	 */
	public void setEvaluationResult(int evaluationResult) {
		this.evaluationResult = evaluationResult;
	}
}
