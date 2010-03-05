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

	private int folder;// folder number, each contains 2 users
	private int user;
	private Map<Integer, Boolean> commitsMap;

	private Iterator<Integer> it;

	private long time;
	private int version;
	private CSVExporter exporter;
	private int evaluationResult;
	private int logMsgResult;// True if the user selected the right log message of this commit
	private List<String> meResults;

	private Project project;
	private Project preProject;
	private ChangePackage changePackage;
	private boolean left;

	private boolean selectionOpen;
	private boolean isFirstTime;
	private int currentMEresult;
	private IWorkbenchPage activePage;

	private CompareView compareView;
	private StructuralView structuralView;

	private ArrayList<Integer> createdDeletedTruth;

	private ArrayList<String> logResults;

	private int createDeleteResult;
	private ArrayList<String> createDeleteResults;
	private Boolean representation;

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
		meResults = new ArrayList<String>();
		createDeleteResults = new ArrayList<String>();
		createdDeletedTruth = new ArrayList<Integer>();
		logResults = new ArrayList<String>();
		selectionOpen = false;

	}

	public boolean hasNext() {
		return it.hasNext();
	}

	public void next() {
		isFirstTime = true;
		version = it.next();
		representation = commitsMap.get(version);
		String projectFileName = DIR + folder + "/projectstate-" + version + ".ups";
		String preProjectFileName = DIR + folder + "/projectstate-" + (version - 1) + ".ups";
		String changeFileName = DIR + folder + "/changepackage-" + version + ".ucp";
		this.left = false;
		this.logMsgResult = 0;
		this.meResults = new ArrayList<String>();
		this.createDeleteResults = new ArrayList<String>();
		this.logResults = new ArrayList<String>();
		this.evaluationResult = 0;
		this.createdDeleteMENames = new ArrayList<String>();
		this.createdDeletedTruth = new ArrayList<Integer>();
		try {
			project = ResourceHelper.getElementFromResource(projectFileName, Project.class, 0);
			preProject = ResourceHelper.getElementFromResource(preProjectFileName, Project.class, 0);
			addToProjectSpace(project);
			addToProjectSpace(preProject);

			changePackage = ResourceHelper.getElementFromResource(changeFileName, ChangePackage.class, 0);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (commitsMap.get(version)) {

			try {

				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				String viewId = "org.unicase.workspace.ui.views.CompareView";
				compareView = (CompareView) page.showView(viewId);

				if (compareView != null) {
					compareView.setInput(project, changePackage);
				}
				structuralView = (StructuralView) page.showView("org.unicase.workspace.ui.views.StructuralView");

				if (structuralView != null) {
					structuralView.setInput((ProjectSpace) project.eContainer());
				}

			} catch (PartInitException e) {
				e.printStackTrace();
			}
		} else {
			String diffFileName = DIR + folder + "/" + "diffModel" + version + ".emfdiff";

			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(URI.createFileURI(diffFileName), true);
			EList<EObject> directContents = resource.getContents();
			ComparisonResourceSetSnapshot diff = (ComparisonResourceSetSnapshot) directContents.get(0);

			try {
				EObject loadedSnapshot = ModelUtils.load(URI.createFileURI(diffFileName), resourceSet);
				if (loadedSnapshot instanceof ComparisonSnapshot) {
					// if (activeEditor != null) {
					// activeEditor.getSite().getPage().closeEditor(activeEditor, false);
					// }
					if (activePage != null) {
						activePage.closeAllEditors(false);
					}
					CompareUI.openCompareEditorOnPage(new ModelCompareEditorInput((ComparisonSnapshot) loadedSnapshot),
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage());
					// activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					// .getActiveEditor();
					activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		this.time = System.currentTimeMillis();

	}

	public void stopViews() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		page.hideView(compareView);
		page.hideView(structuralView);

		if (activePage != null) {
			activePage.closeAllEditors(false);
		}

	}

	private void addToProjectSpace(Project project) {
		ProjectSpace projectSpace1 = WorkspaceFactory.eINSTANCE.createProjectSpace();
		projectSpace1.setProjectName("Project");
		projectSpace1.setIdentifier("Project");
		projectSpace1.setProject(project);
	}

	public void initExporter() {
		exporter = ExportersFactory.eINSTANCE.createCSVExporter();
		try {
			exporter.init(DIR + folder + File.separatorChar + "result-" + user + ".csv");

			List<Object> header = new ArrayList<Object>();
			header.add("Version #");
			header.add("Op-based");
			header.add("Time");
			header.add("LogMsg_1");
			header.add("LogMsg_2");
			header.add("LogMsg_3");
			header.add("LogMsg Rank");
			header.add("Self-assessment");
			for (int i = 1; i <= 5; i++) {
				header.add("ME result " + i);
			}
			for (int i = 1; i <= 2; i++) {
				header.add("CreateDelete result " + i);
			}
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
		this.setFolder((int) Math.floor(user / 2));
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
		File file = new File(DIR + folder + File.separatorChar + "versionInfo-" + user + ".csv");// read information of
		// versions and
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

	/**
	 * @return the logMsgResult
	 */
	public int getLogMsgResult() {
		return logMsgResult;
	}

	/**
	 * @param logMsgResult the logMsgResult to set
	 */
	public void setLogMsgResult(int logMsgResult) {
		this.logMsgResult = logMsgResult;
	}

	/**
	 * @return the folder
	 */
	public int getFolder() {
		return folder;
	}

	/**
	 * @param folder the folder to set
	 */
	public void setFolder(int folder) {
		this.folder = folder;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the preProject
	 */
	public Project getPreProject() {
		return preProject;
	}

	/**
	 * @param preProject the preProject to set
	 */
	public void setPreProject(Project preProject) {
		this.preProject = preProject;
	}

	/**
	 * @return the changePackage
	 */
	public ChangePackage getChangePackage() {
		return changePackage;
	}

	/**
	 * @param changePackage the changePackage to set
	 */
	public void setChangePackage(ChangePackage changePackage) {
		this.changePackage = changePackage;
	}

	public boolean getMEisComplete() {
		// TODO Auto-generated method stub
		return getCurrentMECount() == 5;
	}

	public int getCurrentMECount() {
		return this.meResults.size();
	}

	public void addMEResult(int result) {
		this.meResults.add(result + "");
	}

	public void addLogResult(int b) {
		this.logResults.add(b + "");
	}

	public void addCreateDeleteResult(int result) {
		this.createDeleteResults.add(result + "");
	}

	public List<String> getMEResult() {
		return this.meResults;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean getLeft() {
		return left;
	}

	/**
	 * @return the selectionOpen
	 */
	public boolean isSelectionOpen() {
		return selectionOpen;
	}

	/**
	 * @param selectionOpen the selectionOpen to set
	 */
	public void setSelectionOpen(boolean selectionOpen) {
		this.selectionOpen = selectionOpen;
	}

	public boolean isFirstTime() {
		return this.isFirstTime;
	}

	/**
	 * @param isFirstTime the isFirstTime to set
	 */
	public void setFirstTime(boolean isFirstTime) {
		this.isFirstTime = isFirstTime;
	}

	public void setCurrentMEResult(int i) {
		currentMEresult = i;
	}

	/**
	 * @return the result
	 */
	public int getCurrentMEResult() {
		return currentMEresult;
	}

	public final static int CREATED = 1;
	public final static int DELETED = 2;
	public final static int NONE = 3;
	private List<String> createdDeleteMENames;

	public void addCreateDeleteData(String name, int truth) {
		createdDeleteMENames.add(name);
		createdDeletedTruth.add(truth);
		createDeleteResults.add(new Integer(-1).toString());
	}

	/**
	 * @return the createdDeletedTruth
	 */
	public ArrayList<Integer> getCreatedDeletedTruth() {
		return createdDeletedTruth;
	}

	/**
	 * @param createdDeletedTruth the createdDeletedTruth to set
	 */
	public void setCreatedDeletedTruth(ArrayList<Integer> createdDeletedTruth) {
		this.createdDeletedTruth = createdDeletedTruth;
	}

	/**
	 * @return the createdDeleteMENames
	 */
	public List<String> getCreatedDeleteMENames() {
		return createdDeleteMENames;
	}

	/**
	 * @return the createDeleteResult
	 */
	public int getCreateDeleteResult() {
		return createDeleteResult;
	}

	/**
	 * @param createDeleteResult the createDeleteResult to set
	 */
	public void setCreateDeleteResult(int createDeleteResult) {
		this.createDeleteResult = createDeleteResult;
	}

	/**
	 * @return the createDeleteResults
	 */
	public ArrayList<String> getCreateDeleteResults() {
		return createDeleteResults;
	}

	/**
	 * @param createDeleteResults the createDeleteResults to set
	 */
	public void setCreateDeleteResults(ArrayList<String> createDeleteResults) {
		this.createDeleteResults = createDeleteResults;
	}

	/**
	 * @return the representation
	 */
	public Boolean getRepresentation() {
		return representation;
	}

	/**
	 * @param representation the representation to set
	 */
	public void setRepresentation(Boolean representation) {
		this.representation = representation;
	}

	/**
	 * @return the logResults
	 */
	public ArrayList<String> getLogResults() {
		return logResults;
	}

}
