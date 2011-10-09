/**
 * 
 */
package org.unicase.ui.traceRecovery.traceRecvoery.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.unicase.metamodel.Project;
import org.unicase.model.Attachment;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.activity.ActivityObject;
import org.unicase.model.bug.BugReport;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Dependency;
import org.unicase.model.classes.Literal;
import org.unicase.model.classes.Method;
import org.unicase.model.classes.MethodArgument;
import org.unicase.model.classes.PackageElement;
import org.unicase.model.component.Component;
import org.unicase.model.component.ComponentService;
import org.unicase.model.component.DeploymentNode;
import org.unicase.model.document.Section;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingSection;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.profile.Profile;
import org.unicase.model.profile.Stereotype;
import org.unicase.model.profile.StereotypeAttribute;
import org.unicase.model.profile.StereotypeAttributeInstance;
import org.unicase.model.profile.StereotypeInstance;
import org.unicase.model.rationale.Assessment;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.Criterion;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.Solution;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.ActorInstance;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.Scenario;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.SystemFunction;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.requirement.UserTask;
import org.unicase.model.state.StateNode;
import org.unicase.model.state.Transition;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.traceRecovery.searchResult.SearchResult;
import org.unicase.workspace.Workspace;

import traceRecovery.Directory;
import traceRecovery.TraceRecoveryFactory;
import traceRecovery.Fortran.FortranCodeIndexer;
import traceRecovery.Fortran.SearchFortran;
import traceRecovery.Java.JavaSourceCodeIndexer;
import traceRecovery.Java.SearchJava;
import traceRecovery.handler.Search;

//import traceRecovery.ui.TreeItemHelper;

/**
 * @author taher
 * 
 */
public class RunRecovery extends WizardPage implements Listener {

	Tree code;
	Tree ME;
	Display display;
	Queue<TreeItemHelper> directories;
	Button direction;
	Button search;
	Button selectAllME;
	Button SelectAllDir;
	int imagevalue = 1;
	Project p;
	String codeLanguage;
	String path;
	String indexPath;
	EList<EObject> e;

	Search recovery;

	// SearchResult runRecovery;

	TreeItem organization;
	TreeItem task;
	TreeItem classes;
	TreeItem document;
	TreeItem requirement;
	TreeItem rational;
	TreeItem change;
	TreeItem bug;
	TreeItem component;
	TreeItem meeting;
	TreeItem state;
	TreeItem attatchement;
	TreeItem profile;
	TreeItem util;
	TreeItem activity;
	TreeItem release;

	ArrayList<UnicaseModelElement> org;
	ArrayList<UnicaseModelElement> tas;
	ArrayList<UnicaseModelElement> classe;
	ArrayList<UnicaseModelElement> doc;
	ArrayList<UnicaseModelElement> req;
	ArrayList<UnicaseModelElement> rat;
	ArrayList<UnicaseModelElement> chan;
	ArrayList<UnicaseModelElement> bugg;
	ArrayList<UnicaseModelElement> comp;
	ArrayList<UnicaseModelElement> meet;
	ArrayList<UnicaseModelElement> stat;
	ArrayList<UnicaseModelElement> attat;
	ArrayList<UnicaseModelElement> prof;
	ArrayList<UnicaseModelElement> uti;
	ArrayList<UnicaseModelElement> act;
	ArrayList<UnicaseModelElement> rel;

	ArrayList<UnicaseModelElement> choosenME;

	ArrayList<String> dir = new ArrayList<String>();

	TreeItem parent1;

	Composite composite;

	/**
	 * public constructor to create the object
	 */
	public RunRecovery() {
		super("RunRecovery");
		setTitle("Run Recovery");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(Composite parent) {

		setPageComplete(true);
		display = Display.getCurrent();

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 12;

		composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new FormLayout());

		Label chooseModel = new Label(composite, SWT.NONE);
		// chooseModel.setBounds(10, 10, 161, 17);

		FormData fd_lblChooseModelElement = new FormData();
		fd_lblChooseModelElement.top = new FormAttachment(0, 10);
		fd_lblChooseModelElement.left = new FormAttachment(0, 10);
		chooseModel.setLayoutData(fd_lblChooseModelElement);
		chooseModel.setText("Choose Model Element");

		Label lblChooseDirectory = new Label(composite, SWT.NONE);
		FormData fd_lblChooseDirectory = new FormData();
		fd_lblChooseDirectory.top = new FormAttachment(chooseModel, 0, SWT.TOP);
		fd_lblChooseDirectory.right = new FormAttachment(100, -31);
		lblChooseDirectory.setLayoutData(fd_lblChooseDirectory);
		lblChooseDirectory.setText("Choose Directory       ");

		// GridData label1 = new GridData();
		// label1.horizontalAlignment = 5;
		//
		// GridData label2 = new GridData();
		// label2.horizontalAlignment = 5;
		//
		// Label model = new Label(composite, SWT.NONE);
		// model.setLayoutData(label1);
		// model.setText("Choose Model Element(s)");
		//
		// Label label = new Label(composite, SWT.NONE);
		// label.setText("click to choose direction of recovery");
		//
		// Label codeDirectory = new Label(composite, SWT.NONE);
		// codeDirectory.setLayoutData(label2);
		// codeDirectory.setText("Choose Directory(s)");

		org = new ArrayList<UnicaseModelElement>();
		tas = new ArrayList<UnicaseModelElement>();
		classe = new ArrayList<UnicaseModelElement>();
		doc = new ArrayList<UnicaseModelElement>();
		req = new ArrayList<UnicaseModelElement>();
		rat = new ArrayList<UnicaseModelElement>();
		chan = new ArrayList<UnicaseModelElement>();
		bugg = new ArrayList<UnicaseModelElement>();
		comp = new ArrayList<UnicaseModelElement>();
		meet = new ArrayList<UnicaseModelElement>();
		stat = new ArrayList<UnicaseModelElement>();
		attat = new ArrayList<UnicaseModelElement>();
		prof = new ArrayList<UnicaseModelElement>();
		uti = new ArrayList<UnicaseModelElement>();
		act = new ArrayList<UnicaseModelElement>();
		rel = new ArrayList<UnicaseModelElement>();

		choosenME = new ArrayList<UnicaseModelElement>();

		// SelecDirectory selectDirecotry = (SelecDirectory)
		// getWizard().getPage(
		// "SelectDirectory");
		//
		// codeLanguage = selectDirecotry.getLanguage();

		// this.path = selectDirecotry.getLastPath();
		// this.indexPath = selectDirecotry.getLastIndexPath();

		// composite.setLayout(gridLayout);

		// GridData treeLayout = new GridData(SWT.FILL, SWT.FILL, true, true, 1,
		// 1);

		// treeLayout.verticalAlignment = SWT.FILL;

		ME = new Tree(composite, SWT.CHECK);

		FormData fd_tree = new FormData();
		fd_tree.right = new FormAttachment(chooseModel, 0, SWT.RIGHT);
		// fd_tree.bottom = new FormAttachment(chooseModel, 207, SWT.BOTTOM);
		fd_tree.top = new FormAttachment(chooseModel, 6);
		fd_tree.left = new FormAttachment(0, 0);
		ME.setLayoutData(fd_tree);
		// ME.setLayout(gridLayout);
		ME.addListener(SWT.Selection, this);

		createModelTree(ME);
		createModel();

		// GridData directionLayout = new GridData();
		// directionLayout.horizontalSpan = 1;
		// directionLayout.verticalSpan = 4;
		// directionLayout.horizontalAlignment = SWT.FILL;

		code = new Tree(composite, SWT.CHECK | SWT.V_SCROLL);
		FormData fd_tree_1 = new FormData();
		fd_tree_1.bottom = new FormAttachment(ME, 0, SWT.BOTTOM);
		fd_tree_1.top = new FormAttachment(lblChooseDirectory, 6);
		fd_tree_1.left = new FormAttachment(lblChooseDirectory, 0, SWT.LEFT);
		fd_tree_1.right = new FormAttachment(lblChooseDirectory, 0, SWT.RIGHT);

		code.setLayoutData(fd_tree_1);

		// parent1 = new TreeItem(code, SWT.CHECK);
		// parent1.setText("emy bentest beky ;)");
		// parent1.setText(path);

		directories = new LinkedList<TreeItemHelper>();

		if (path != null) {
			code = new Tree(composite, SWT.CHECK | SWT.V_SCROLL);
			code.redraw();
			code.setLayoutData(fd_tree_1);
			code.addListener(SWT.Selection, this);
			ME.redraw();
			parent1 = new TreeItem(code, SWT.CHECK);
			createTree();
		}

		// File dir = new File(path);

		// directories.add(new TreeItemHelper(parent1, " "));//hena kan feh 7gaa

		// TreeViewer codeViewer = new TreeViewer(code);

		// GridData searchLayout = new GridData(SWT.RIGHT, SWT.CENTER, true,
		// false);
		// searchLayout.horizontalSpan = 10;
		//
		// search = new Button(composite, SWT.PUSH);
		// search.setLayoutData(searchLayout);
		// search.addListener(SWT.Selection, this);
		// search.setText("Search");
		direction = new Button(composite, SWT.PUSH);
		direction.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		// direction.setText("this is a button");
		Image image = new Image(display, "Screenshot-1.png");
		direction.setImage(image);
		direction.addListener(SWT.Selection, this);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(0, 109);
		fd_btnNewButton.left = new FormAttachment(ME, 90);
		direction.setLayoutData(fd_btnNewButton);

		Label lblChooseDirection = new Label(composite, SWT.WRAP);
		FormData fd_lblChooseDirection = new FormData();
		fd_lblChooseDirection.bottom = new FormAttachment(direction, -25);
		fd_lblChooseDirection.left = new FormAttachment(ME, 50);
		fd_lblChooseDirection.right = new FormAttachment(code, 20, SWT.LEFT);
		lblChooseDirection.setLayoutData(fd_lblChooseDirection);
		lblChooseDirection.setText("Click button to change the");

		Label l = new Label(composite, SWT.NONE);
		l.setText("direction the recovery is going to run");
		FormData fd_lblChoose = new FormData();
		fd_lblChoose.bottom = new FormAttachment(direction, -5);
		fd_lblChoose.left = new FormAttachment(ME, 50);
		fd_lblChoose.right = new FormAttachment(code, 20, SWT.LEFT);
		l.setLayoutData(fd_lblChoose);

		selectAllME = new Button(composite, SWT.CHECK);
		FormData fd_SelectAllME = new FormData();
		fd_SelectAllME.left = new FormAttachment(ME, 0, SWT.LEFT);
		fd_SelectAllME.top = new FormAttachment(ME, 10, SWT.BOTTOM);
		selectAllME.setLayoutData(fd_SelectAllME);
		selectAllME.setText("Select All Model Elements");
		selectAllME.addListener(SWT.Selection, this);

		SelectAllDir = new Button(composite, SWT.CHECK);
		FormData fd_SelectAllDir = new FormData();
		fd_SelectAllDir.left = new FormAttachment(code, 0, SWT.LEFT);
		fd_SelectAllDir.top = new FormAttachment(code, 10, SWT.BOTTOM);
		SelectAllDir.setLayoutData(fd_SelectAllDir);
		SelectAllDir.setText("Select All Directory");
		SelectAllDir.addListener(SWT.Selection, this);

		code.layout();
		composite.layout();
		ME.layout();
		getShell().layout();

		setControl(composite);

	}

	public void treeSetUp() {
		File dir = new File(path);
		code.removeAll(); // recheck this
		if (path != null) {

			code.addListener(SWT.Selection, this);
			parent1 = new TreeItem(code, SWT.CHECK);
			parent1.setText(path);
			directories.add(new TreeItemHelper(parent1, dir));
			if (dir.isDirectory()) {
				createTree();
			}

			// code.layout();
			composite.layout();
			getShell().layout();

		}
	}

	/**
	 * this will get the directories of the chosen files from the tree
	 * 
	 * @param item
	 *            this is the item that would be traversed to check if it
	 *            contains any chosen items
	 * @param mainPath
	 *            this is the main path of the directory to start the search
	 *            from
	 */

	private void directoriesBuild(TreeItem item, String mainPath) {

		// File fff = new File(path);

		TreeItem[] items = item.getItems();

		if (dir.size() > 0) {
			dir.clear();
		}

		for (int i = 0; i < items.length; i++) {
			if (items[i].getChecked()) {
				if (File.pathSeparatorChar == ':') {
					String tex = mainPath + "/" + items[i].getText();
					dir.add(tex);
					System.out.println(tex);
				} else if (File.pathSeparatorChar == ';') {
					String tex = mainPath + "\\" + items[i].getText();
					dir.add(tex);
					System.out.println(tex);
				}

			} else if (items[i].getGrayed()) {
				if (File.pathSeparatorChar == ':') {
					directoriesBuild(items[i],
							mainPath + "/" + items[i].getText());
				} else if (File.pathSeparatorChar == ';') {
					directoriesBuild(items[i],
							mainPath + "\\" + items[i].getText());
				}

			}

		}
		File ff = new File("helper");
		ff.mkdir();
		for (int i = 0; i < dir.size(); i++) {
			File f = new File(dir.get(0));
			if (f.isDirectory()) {

			}
		}

	}

	public void finish() {

		if (codeLanguage.toLowerCase().equals("java")) {
			recovery = new SearchJava();
		} else if (codeLanguage.toLowerCase().equals("fortran")) {
			recovery = new SearchFortran();
		}

		// recovery = new Search();

		recovery.setProject(getP());

		Directory codeDir = TraceRecoveryFactory.eINSTANCE.createDirectory();
		codeDir.setPath(path);

		Directory sourceDir = TraceRecoveryFactory.eINSTANCE.createDirectory();
		sourceDir.setPath(indexPath);

		if (choosenME.size() > 0) {
			choosenME.clear();

		}

		choosenME();
		recovery.setAnalyzer(codeLanguage);
		if (imagevalue == 1) {
			if (codeLanguage.equals("java")) {
				((SearchJava) recovery).setIndexer(codeDir, sourceDir);
			} else if (codeLanguage.equals("fortran")) {
				recovery.setIndexer("fortran", codeDir, sourceDir);
			}

			if (code.getItem(0).getChecked()) {
				if (codeLanguage.equals("java")) {
					JavaSourceCodeIndexer indexer = new JavaSourceCodeIndexer();
					recovery.index(indexer);
				} else if (codeLanguage.equals("fortran")) {
					FortranCodeIndexer indexer = new FortranCodeIndexer();
					recovery.index(indexer);
				}

				// recovery.index();
			} else {
				directoriesBuild(code.getItem(0), code.getItem(0).getText());
				if (codeLanguage.equals("java")) {
					JavaSourceCodeIndexer indexer = new JavaSourceCodeIndexer();
					recovery.index(dir, indexer);
				} else if (codeLanguage.equals("fortran")) {
					FortranCodeIndexer indexer = new FortranCodeIndexer();
					recovery.index(dir, indexer);
				}

			}

		} else {

			if (code.getItem(0).getChecked()) {
				dir.add(code.getItem(0).getText());
			} else {
				directoriesBuild(code.getItem(0), code.getItem(0).getText());
			}

			recovery.setIndexer("me", codeDir, sourceDir);

			recovery.indexMe(choosenME, sourceDir);
		}

		SearchResult runRecovery = new SearchResult();
		runRecovery.setRecovery(this);
		runRecovery.setProject(getP());
		runRecovery.setPoint(this.getShell().getBounds());
		runRecovery.createControl("recovery");

	}

	/**
	 * @return the recovery
	 */
	public Search getRecovery() {
		return recovery;
	}

	/**
	 * @param recovery
	 *            the recovery to set
	 */
	public void setRecovery(Search recovery) {
		this.recovery = recovery;
	}

	/**
	 * @return the runRecovery
	 */
	// public SearchResult getRunRecovery() {
	// return runRecovery;
	// }

	/**
	 * @param runRecovery
	 *            the runRecovery to set
	 */
	// public void setRunRecovery(SearchResult runRecovery) {
	// this.runRecovery = runRecovery;
	// }

	/**
	 * @return the composite
	 */
	public Composite getComposite() {
		return composite;
	}

	/**
	 * @param composite
	 *            the composite to set
	 */
	public void setComposite(Composite composite) {
		this.composite = composite;
	}

	/**
	 * Checks to see if any of the Model elements where chosen to allow for the
	 * recovery to run.
	 */
	public boolean choosenME() {
		boolean checked = false;

		boolean checked1 = choosenOrg();
		boolean checked2 = choosenTask();
		boolean checked3 = choosenClasses();
		boolean checked4 = choosenDoc();
		boolean checked5 = choosenRequirement();
		boolean checked6 = choosenRat();
		boolean checked7 = choosenChan();
		boolean checked8 = choosenBug();
		boolean checked9 = choosenComp();
		boolean checked10 = choosenMeet();
		boolean checked11 = choosenStat();
		boolean checked12 = choosenAttat();
		boolean checked13 = choosenProf();
		boolean checked14 = choosenUti();
		boolean checked15 = choosenAct();
		boolean checked16 = choosenRel();

		if (checked1 || checked2 || checked3 || checked4 || checked5
				|| checked6 || checked7 || checked8 || checked9 || checked10
				|| checked11 || checked12 || checked13 || checked14
				|| checked15 || checked16) {
			checked = true;
		}
		return checked;
	}

	/**
	 * checks if a release Model Element was chosen
	 * 
	 * @return returns true of the release was chosen and false otherwise
	 */
	public boolean choosenRel() {
		TreeItem item = ME.getItem(15);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(rel.get(i));
					checked = true;
				}
			}
		}
		return checked;
	}

	/**
	 * checks if a certain activity Model Element was chosen
	 * 
	 * @return returns true if on was chosen and false otherwise.
	 */
	public boolean choosenAct() {
		TreeItem item = ME.getItem(14);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(act.get(i));
					checked = true;
				}
			}
		}
		return checked;
	}

	/**
	 * checks if a Utility Model Element was chosen
	 * 
	 * @return returns true if on was chosen and false otherwise.
	 */
	public boolean choosenUti() {
		TreeItem item = ME.getItem(13);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(uti.get(i));
					checked = true;
				}
			}
		}
		return checked;
	}

	/**
	 * checks if a Profile Model Element was chosen
	 * 
	 * @return returns true if on was chosen and false otherwise.
	 */
	public boolean choosenProf() {
		TreeItem item = ME.getItem(12);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(prof.get(i));
					checked = true;
				}
			}
		}
		return checked;
	}

	/**
	 * checks if an Attachment Model Element was chosen
	 * 
	 * @return returns true if on was chosen and false otherwise.
	 */
	public boolean choosenAttat() {
		TreeItem item = ME.getItem(11);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(attat.get(i));
					checked = true;
				}
			}
		}
		return checked;
	}

	/**
	 * check if a State Model Element was chosen.
	 * 
	 * @return returns true if one was chosen and false otherwise.
	 */
	public boolean choosenStat() {
		TreeItem item = ME.getItem(10);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(stat.get(i));
					checked = true;
				}
			}
		}
		return checked;
	}

	/**
	 * check if a meeting is chosen
	 * 
	 * @return returns if a meeting was chosen and false otherwise.
	 */
	public boolean choosenMeet() {
		TreeItem item = ME.getItem(9);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(meet.get(i));
					checked = true;
				}
			}
		}
		return checked;
	}

	/**
	 * check if a component was chosen
	 * 
	 * @return returns true if was chosen and false otherwise
	 */
	public boolean choosenComp() {
		TreeItem item = ME.getItem(8);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(comp.get(i));
					checked = true;
				}
			}
		}
		return checked;
	}

	/**
	 * checks f a bug was chosen
	 * 
	 * @return returns true if was chosen and false otherwise
	 */
	public boolean choosenBug() {
		TreeItem item = ME.getItem(7);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(bugg.get(i));
					checked = true;
				}
			}
		}
		return checked;
	}

	/**
	 * check if a change model element was chosen
	 * 
	 * @return returns true if was chosen and false otherwise
	 */
	public boolean choosenChan() {
		TreeItem item = ME.getItem(6);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(chan.get(i));
					checked = true;
				}
			}
		}
		return checked;
	}

	/**
	 * checks if a Rational was chosen
	 * 
	 * @return returns true if was chosen and false otherwise
	 */
	public boolean choosenRat() {
		TreeItem item = ME.getItem(5);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(rat.get(i));
					checked = true;
				}
			}
		}
		return checked;
	}

	/**
	 * check if a requirement was chosen
	 * 
	 * @return returns true if was chosen and false otherwise
	 */
	public boolean choosenRequirement() {
		TreeItem item = ME.getItem(4);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(req.get(i));
					checked = true;
				}
			}
		}
		return checked;
	}

	/**
	 * check if a document was chosen
	 * 
	 * @return returns true if was chosen and false otherwise
	 */
	public boolean choosenDoc() {
		TreeItem item = ME.getItem(3);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(doc.get(i));
					checked = true;
				}
			}
		}
		return checked;
	}

	/**
	 * check if a class was chosen
	 * 
	 * @return returns true if was chosen and false otherwise
	 */
	public boolean choosenClasses() {
		TreeItem item = ME.getItem(2);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(classe.get(i));
					checked = true;
				}
			}
		}

		return checked;
	}

	/**
	 * check if a task was chosen
	 * 
	 * @return returns true if was chosen and false otherwise
	 */
	public boolean choosenTask() {
		TreeItem item = ME.getItem(1);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(tas.get(i));
					checked = true;
				}
			}
		}

		return checked;
	}

	/**
	 * check if an orgunit was chosen
	 * 
	 * @return returns true if was chosen and false otherwise
	 */
	public boolean choosenOrg() {
		TreeItem item = ME.getItem(0);
		boolean checked = false;
		if (item.getChecked() || item.getGrayed()) {
			TreeItem items[] = item.getItems();

			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					choosenME.add(org.get(i));
					checked = true;
				}
			}
		}

		return checked;
	}

	// public void setUp(){
	// choosenME = new ArrayList<UnicaseModelElement>();
	//
	// SelecDirectory selectDirecotry = (SelecDirectory) getWizard().getPage(
	// "SelectDirectory");
	//
	// codeLanguage = selectDirecotry.getLanguage();
	//
	// // this.path = selectDirecotry.getLastPath();
	// // this.indexPath = selectDirecotry.getLastIndexPath();
	//
	// // composite.setLayout(gridLayout);
	//
	// GridData treeLayout = new GridData();
	// treeLayout.horizontalSpan = 5;
	// treeLayout.verticalSpan = 8;
	// treeLayout.horizontalAlignment = SWT.FILL;
	// treeLayout.verticalAlignment = SWT.FILL;
	//
	// ME = new Tree(composite, SWT.CHECK);
	// ME.setLayoutData(treeLayout);
	// // ME.setLayout(gridLayout);
	// ME.addListener(SWT.Selection, this);
	//
	// createModelTree(ME);
	// createModel();
	//
	// GridData directionLayout = new GridData();
	// directionLayout.horizontalSpan = 1;
	// directionLayout.verticalSpan = 4;
	// directionLayout.horizontalAlignment = SWT.FILL;
	// direction = new Button(composite, SWT.PUSH);
	// direction.setLayoutData(directionLayout);
	// // direction.setText("this is a button");
	// Image image = new Image(display, "Screenshot-1.png");
	// direction.setImage(image);
	// direction.addListener(SWT.Selection, this);
	//
	// code = new Tree(composite, SWT.CHECK | SWT.V_SCROLL);
	// // code.setLayoutData(treeLayout);
	//
	// parent1 = new TreeItem(code, SWT.CHECK);
	// parent1.setText(path);
	//
	// directories = new LinkedList<TreeItemHelper>();
	//
	// File dir = new File(path);
	//
	// directories.add(new TreeItemHelper(parent1, dir));
	//
	// createTree();
	// // TreeViewer codeViewer = new TreeViewer(code);
	// code.addListener(SWT.Selection, this);
	//
	// // GridData searchLayout = new GridData(SWT.RIGHT, SWT.CENTER, true,
	// // false);
	// // searchLayout.horizontalSpan = 10;
	// //
	// // search = new Button(composite, SWT.PUSH);
	// // search.setLayoutData(searchLayout);
	// // search.addListener(SWT.Selection, this);
	// // search.setText("Search");
	//
	// }

	/**
	 * this will create the tree of directories to allow for the choose of a
	 * directory.
	 */
	public void createTree() {

		parent1 = new TreeItem(parent1, SWT.CHECK);
		while (!directories.isEmpty()) {
			TreeItemHelper top = directories.remove();
			parent1 = top.parent;
			parent1.setExpanded(true);
			File[] files = top.dir.listFiles();
			if (files != null) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						TreeItem sub = new TreeItem(parent1, SWT.CHECK);
						sub.setExpanded(true);
						sub.setText(files[i].getName());
						directories.add(new TreeItemHelper(sub, files[i]));
					} else {
						TreeItem child = new TreeItem(parent1, SWT.CHECK);
						child.setText(files[i].getName());
						child.setText(0, files[i].getName());

					}
				}
			}

		}

	}

	/**
	 * will create the tree that contains the Model Elements
	 * 
	 * @param model
	 *            this is the tree that the Model Elements should be added to.
	 */
	public void createModelTree(Tree model) {
		organization = new TreeItem(model, SWT.CHECK);
		organization.setText("organization");

		task = new TreeItem(model, SWT.CHECK);
		task.setText("task");
		classes = new TreeItem(model, SWT.CHECK);
		classes.setText("classes");
		document = new TreeItem(model, SWT.CHECK);
		document.setText("document");
		requirement = new TreeItem(model, SWT.CHECK);
		requirement.setText("requirement");
		rational = new TreeItem(model, SWT.CHECK);
		rational.setText("rational");
		change = new TreeItem(model, SWT.CHECK);
		change.setText("change");
		bug = new TreeItem(model, SWT.CHECK);
		bug.setText("bug");
		component = new TreeItem(model, SWT.CHECK);
		component.setText("component");
		meeting = new TreeItem(model, SWT.CHECK);
		meeting.setText("meeting");
		state = new TreeItem(model, SWT.CHECK);
		state.setText("state");
		attatchement = new TreeItem(model, SWT.CHECK);
		attatchement.setText("attatchement");
		profile = new TreeItem(model, SWT.CHECK);
		profile.setText("profile");
		util = new TreeItem(model, SWT.CHECK);
		util.setText("util");
		activity = new TreeItem(model, SWT.CHECK);
		activity.setText("activity");
		release = new TreeItem(model, SWT.CHECK);
		release.setText("release");
	}

	/**
	 * this will add the model elements to the correct tree item in the Model
	 * Elements tree.
	 */
	public void createModel() {
		if (p != null) {
			EList<EObject> elements = p.getAllModelElementsbyClass(
					EcorePackage.Literals.EOBJECT, new BasicEList<EObject>());
			e = p.getAllModelElementsbyClass(EcorePackage.Literals.EOBJECT,
					new BasicEList<EObject>());
			for (EObject me : elements) {
				if (me instanceof OrgUnit) {
					TreeItem item = new TreeItem(organization, SWT.CHECK);
					item.setText(((OrgUnit) me).getName());

					org.add((UnicaseModelElement) me);

				} else if (me instanceof BugReport) {
					TreeItem item = new TreeItem(bug, SWT.CHECK);
					item.setText(((BugReport) me).getName());

					bugg.add((UnicaseModelElement) me);

				} else if (me instanceof WorkItem) {

					TreeItem item = new TreeItem(task, SWT.CHECK);
					item.setText(((WorkItem) me).getName());

					tas.add((UnicaseModelElement) me);

				} else if (me instanceof Checkable) {

					TreeItem item = new TreeItem(task, SWT.CHECK);
					item.setText(((Checkable) me).getName());

					tas.add((UnicaseModelElement) me);

				} else if (me instanceof PackageElement) {

					TreeItem item = new TreeItem(classes, SWT.CHECK);
					item.setText(((PackageElement) me).getName());

					classe.add((UnicaseModelElement) me);

				} else if (me instanceof Association) {

					TreeItem item = new TreeItem(classes, SWT.CHECK);
					item.setText(((Association) me).getName());

					classe.add((UnicaseModelElement) me);

				} else if (me instanceof Attribute) {

					TreeItem item = new TreeItem(classes, SWT.CHECK);
					item.setText(((Attribute) me).getName());

					classe.add((UnicaseModelElement) me);

				} else if (me instanceof Method) {

					TreeItem item = new TreeItem(classes, SWT.CHECK);
					item.setText(((Method) me).getName());

					classe.add((UnicaseModelElement) me);

				} else if (me instanceof MethodArgument) {

					TreeItem item = new TreeItem(classes, SWT.CHECK);
					item.setText(((MethodArgument) me).getName());

					classe.add((UnicaseModelElement) me);

				} else if (me instanceof Dependency) {

					TreeItem item = new TreeItem(classes, SWT.CHECK);
					item.setText(((Dependency) me).getName());

					classe.add((UnicaseModelElement) me);

				} else if (me instanceof Literal) {

					TreeItem item = new TreeItem(classes, SWT.CHECK);
					item.setText(((Literal) me).getName());

					classe.add((UnicaseModelElement) me);

				} else if (me instanceof Section) {

					TreeItem item = new TreeItem(document, SWT.CHECK);
					item.setText(((Section) me).getName());

					doc.add((UnicaseModelElement) me);

				} else if (me instanceof FunctionalRequirement) {

					TreeItem item = new TreeItem(requirement, SWT.CHECK);
					item.setText(((FunctionalRequirement) me).getName());

					req.add((UnicaseModelElement) me);

				} else if (me instanceof UseCase) {

					TreeItem item = new TreeItem(requirement, SWT.CHECK);
					item.setText(((UseCase) me).getName());

					req.add((UnicaseModelElement) me);

				} else if (me instanceof Scenario) {

					TreeItem item = new TreeItem(requirement, SWT.CHECK);
					item.setText(((Scenario) me).getName());

					req.add((UnicaseModelElement) me);

				} else if (me instanceof Actor) {

					TreeItem item = new TreeItem(requirement, SWT.CHECK);
					item.setText(((Actor) me).getName());

					req.add((UnicaseModelElement) me);

				} else if (me instanceof ActorInstance) {

					TreeItem item = new TreeItem(requirement, SWT.CHECK);
					item.setText(((ActorInstance) me).getName());

					req.add((UnicaseModelElement) me);

				} else if (me instanceof Step) {

					TreeItem item = new TreeItem(requirement, SWT.CHECK);
					item.setText(((Step) me).getName());

					req.add((UnicaseModelElement) me);

				} else if (me instanceof SystemFunction) {

					TreeItem item = new TreeItem(requirement, SWT.CHECK);
					item.setText(((SystemFunction) me).getName());

					req.add((UnicaseModelElement) me);

				} else if (me instanceof UserTask) {

					TreeItem item = new TreeItem(requirement, SWT.CHECK);
					item.setText(((UserTask) me).getName());

					req.add((UnicaseModelElement) me);

				} else if (me instanceof Workspace) {

					// TreeItem item = new TreeItem(requirement, SWT.CHECK);
					// item.setText(me.get)

				} else if (me instanceof Proposal) {

					TreeItem item = new TreeItem(rational, SWT.CHECK);
					item.setText(((Proposal) me).getName());

					rat.add((UnicaseModelElement) me);

				} else if (me instanceof Solution) {

					TreeItem item = new TreeItem(rational, SWT.CHECK);
					item.setText(((Solution) me).getName());

					rat.add((UnicaseModelElement) me);

				} else if (me instanceof Criterion) {

					TreeItem item = new TreeItem(rational, SWT.CHECK);
					item.setText(((Criterion) me).getName());

					rat.add((UnicaseModelElement) me);

				} else if (me instanceof Assessment) {

					TreeItem item = new TreeItem(rational, SWT.CHECK);
					item.setText(((Assessment) me).getName());

					rat.add((UnicaseModelElement) me);

				} else if (me instanceof Comment) {

					TreeItem item = new TreeItem(rational, SWT.CHECK);
					item.setText(((Comment) me).getName());

					rat.add((UnicaseModelElement) me);

				} else if (me instanceof Component) {

					TreeItem item = new TreeItem(component, SWT.CHECK);
					item.setText(((Component) me).getName());

					comp.add((UnicaseModelElement) me);

				} else if (me instanceof ComponentService) {

					TreeItem item = new TreeItem(component, SWT.CHECK);
					item.setText(((ComponentService) me).getName());

					comp.add((UnicaseModelElement) me);

				} else if (me instanceof DeploymentNode) {

					TreeItem item = new TreeItem(component, SWT.CHECK);
					item.setText(((DeploymentNode) me).getName());

					comp.add((UnicaseModelElement) me);

				} else if (me instanceof Meeting) {

					TreeItem item = new TreeItem(meeting, SWT.CHECK);
					item.setText(((Meeting) me).getName());

					meet.add((UnicaseModelElement) me);

				} else if (me instanceof MeetingSection) {

					TreeItem item = new TreeItem(meeting, SWT.CHECK);
					item.setText(((MeetingSection) me).getName());

					meet.add((UnicaseModelElement) me);

				} else if (me instanceof Transition) {

					TreeItem item = new TreeItem(state, SWT.CHECK);
					item.setText(((Transition) me).getName());

					stat.add((UnicaseModelElement) me);

				} else if (me instanceof StateNode) {

					TreeItem item = new TreeItem(state, SWT.CHECK);
					item.setText(((StateNode) me).getName());

					stat.add((UnicaseModelElement) me);

				} else if (me instanceof Attachment) {

					TreeItem item = new TreeItem(attatchement, SWT.CHECK);
					item.setText(((Attachment) me).getName());

					attat.add((UnicaseModelElement) me);

				} else if (me instanceof Profile) {

					TreeItem item = new TreeItem(attatchement, SWT.CHECK);
					item.setText(((Profile) me).getName());

					attat.add((UnicaseModelElement) me);

				} else if (me instanceof Stereotype) {

					TreeItem item = new TreeItem(profile, SWT.CHECK);
					item.setText(((Stereotype) me).getName());

					prof.add((UnicaseModelElement) me);

				} else if (me instanceof StereotypeInstance) {

					TreeItem item = new TreeItem(profile, SWT.CHECK);
					item.setText(((StereotypeInstance) me).getName());

					prof.add((UnicaseModelElement) me);

				} else if (me instanceof StereotypeAttribute) {

					TreeItem item = new TreeItem(profile, SWT.CHECK);
					item.setText(((StereotypeAttribute) me).getName());

					prof.add((UnicaseModelElement) me);

				} else if (me instanceof StereotypeAttributeInstance) {

					TreeItem item = new TreeItem(profile, SWT.CHECK);
					item.setText(((StereotypeAttributeInstance) me).getName());

					prof.add((UnicaseModelElement) me);

				} else if (me instanceof ActivityObject) {

					TreeItem item = new TreeItem(activity, SWT.CHECK);
					item.setText(((ActivityObject) me).getName());

					act.add((UnicaseModelElement) me);

				} else if (me instanceof org.unicase.model.activity.Transition) {

					TreeItem item = new TreeItem(activity, SWT.CHECK);
					item.setText(((org.unicase.model.activity.Transition) me)
							.getName());
					act.add((UnicaseModelElement) me);

				}
			}

		}
	}

	public boolean canFinish() {
		return !((!choosenME() || (!code.getItem(0).getGrayed() && !code
				.getItem(0).getChecked())));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */
	@Override
	public void handleEvent(Event event) {
		if (event.widget == direction) {
			if (imagevalue == 1) {
				Image image = new Image(display, "Screenshot-2.png");
				direction.setImage(image);
				imagevalue = 2;
			} else {
				Image image = new Image(display, "Screenshot-1.png");
				direction.setImage(image);
				imagevalue = 1;
			}
		} else if (event.widget == code) {
			TreeItem item = (TreeItem) event.item;
			boolean checked = item.getChecked();
			checkItems(item, checked);
			checkPath(item.getParentItem(), checked, false);
			setPageComplete(canFinish());
			this.getWizard().canFinish();

		} else if (event.widget == ME) {
			TreeItem item = (TreeItem) event.item;
			boolean checked = item.getChecked();
			checkItems(item, checked);
			checkPath(item.getParentItem(), checked, false);
			setPageComplete(canFinish());
			this.getWizard().canFinish();
		} else if (event.widget == SelectAllDir) {
			boolean checked = SelectAllDir.getSelection();
			TreeItem[] items = code.getItems();
			for (int i = 0; i < items.length; i++) {
				TreeItem t = items[i];
				checkItems(t, checked);
				checkPath(t, checked, false);
			}
		} else if (event.widget == selectAllME) {
			boolean checked = selectAllME.getSelection();
			TreeItem[] items = ME.getItems();
			for (int i = 0; i < items.length; i++) {
				TreeItem t = items[i];
				checkItems(t, checked);
				checkPath(t, checked, false);
			}
		}

	}

	/**
	 * set the choosen item to checked
	 * 
	 * @param item
	 *            this is the item that was checked
	 * @param checked
	 *            if it was checked or unchecked
	 */
	private void checkItems(TreeItem item, boolean checked) {
		item.setGrayed(false);
		item.setChecked(checked);
		TreeItem[] items = item.getItems();
		for (int i = 0; i < items.length; i++) {
			checkItems(items[i], checked);
		}
	}

	/**
	 * will check the path of the tree to make sure that all children are also
	 * chosen.
	 * 
	 * @param item
	 *            this is the item we want to check it's children.
	 * @param checked
	 *            if it was checked or unchecked
	 * @param grayed
	 *            if it was grayed or not.
	 */
	private void checkPath(TreeItem item, boolean checked, boolean grayed) {
		if (item == null)
			return;

		int index = 0;
		TreeItem[] items = item.getItems();
		while (index < items.length) {
			TreeItem child = items[index];
			if (child.getGrayed() || child.getChecked()) {
				checked = grayed = true;
				break;
			}
			index++;
		}

		item.setChecked(item.getChecked());
		item.setGrayed(grayed);
		checkPath(item.getParentItem(), checked, grayed);
	}

	/**
	 * @return the code
	 */
	public Tree getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(Tree code) {
		this.code = code;
	}

	/**
	 * @return the mE
	 */
	public Tree getME() {
		return ME;
	}

	/**
	 * @param mE
	 *            the mE to set
	 */
	public void setME(Tree mE) {
		ME = mE;
	}

	/**
	 * @return the display
	 */
	public Display getDisplay() {
		return display;
	}

	/**
	 * @param display
	 *            the display to set
	 */
	public void setDisplay(Display display) {
		this.display = display;
	}

	/**
	 * @return the directories
	 */
	public Queue<TreeItemHelper> getDirectories() {
		return directories;
	}

	/**
	 * @param directories
	 *            the directories to set
	 */
	public void setDirectories(Queue<TreeItemHelper> directories) {
		this.directories = directories;
	}

	/**
	 * @return the direction
	 */
	public Button getDirection() {
		return direction;
	}

	/**
	 * @param direction
	 *            the direction to set
	 */
	public void setDirection(Button direction) {
		this.direction = direction;
	}

	/**
	 * @return the search
	 */
	public Button getSearch() {
		return search;
	}

	/**
	 * @param search
	 *            the search to set
	 */
	public void setSearch(Button search) {
		this.search = search;
	}

	/**
	 * @return the imagevalue
	 */
	public int getImagevalue() {
		return imagevalue;
	}

	/**
	 * @param imagevalue
	 *            the imagevalue to set
	 */
	public void setImagevalue(int imagevalue) {
		this.imagevalue = imagevalue;
	}

	/**
	 * @return the p
	 */
	public Project getP() {
		return p;
	}

	/**
	 * @param p
	 *            the p to set
	 */
	public void setP(Project p) {
		this.p = p;
	}

	/**
	 * @return the codeLanguage
	 */
	public String getCodeLanguage() {
		return codeLanguage;
	}

	/**
	 * @param codeLanguage
	 *            the codeLanguage to set
	 */
	public void setCodeLanguage(String codeLanguage) {
		this.codeLanguage = codeLanguage;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the indexPath
	 */
	public String getIndexPath() {
		return indexPath;
	}

	/**
	 * @param indexPath
	 *            the indexPath to set
	 */
	public void setIndexPath(String indexPath) {
		this.indexPath = indexPath;
	}

	/**
	 * @return the e
	 */
	public EList<EObject> getE() {
		return e;
	}

	/**
	 * @param e
	 *            the e to set
	 */
	public void setE(EList<EObject> e) {
		this.e = e;
	}

	/**
	 * @return the organization
	 */
	public TreeItem getOrganization() {
		return organization;
	}

	/**
	 * @param organization
	 *            the organization to set
	 */
	public void setOrganization(TreeItem organization) {
		this.organization = organization;
	}

	/**
	 * @return the task
	 */
	public TreeItem getTask() {
		return task;
	}

	/**
	 * @param task
	 *            the task to set
	 */
	public void setTask(TreeItem task) {
		this.task = task;
	}

	/**
	 * @return the classes
	 */
	public TreeItem getClasses() {
		return classes;
	}

	/**
	 * @param classes
	 *            the classes to set
	 */
	public void setClasses(TreeItem classes) {
		this.classes = classes;
	}

	/**
	 * @return the document
	 */
	public TreeItem getDocument() {
		return document;
	}

	/**
	 * @param document
	 *            the document to set
	 */
	public void setDocument(TreeItem document) {
		this.document = document;
	}

	/**
	 * @return the requirement
	 */
	public TreeItem getRequirement() {
		return requirement;
	}

	/**
	 * @param requirement
	 *            the requirement to set
	 */
	public void setRequirement(TreeItem requirement) {
		this.requirement = requirement;
	}

	/**
	 * @return the rational
	 */
	public TreeItem getRational() {
		return rational;
	}

	/**
	 * @param rational
	 *            the rational to set
	 */
	public void setRational(TreeItem rational) {
		this.rational = rational;
	}

	/**
	 * @return the change
	 */
	public TreeItem getChange() {
		return change;
	}

	/**
	 * @param change
	 *            the change to set
	 */
	public void setChange(TreeItem change) {
		this.change = change;
	}

	/**
	 * @return the bug
	 */
	public TreeItem getBug() {
		return bug;
	}

	/**
	 * @param bug
	 *            the bug to set
	 */
	public void setBug(TreeItem bug) {
		this.bug = bug;
	}

	/**
	 * @return the component
	 */
	public TreeItem getComponent() {
		return component;
	}

	/**
	 * @param component
	 *            the component to set
	 */
	public void setComponent(TreeItem component) {
		this.component = component;
	}

	/**
	 * @return the meeting
	 */
	public TreeItem getMeeting() {
		return meeting;
	}

	/**
	 * @param meeting
	 *            the meeting to set
	 */
	public void setMeeting(TreeItem meeting) {
		this.meeting = meeting;
	}

	/**
	 * @return the state
	 */
	public TreeItem getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(TreeItem state) {
		this.state = state;
	}

	/**
	 * @return the attatchement
	 */
	public TreeItem getAttatchement() {
		return attatchement;
	}

	/**
	 * @param attatchement
	 *            the attatchement to set
	 */
	public void setAttatchement(TreeItem attatchement) {
		this.attatchement = attatchement;
	}

	/**
	 * @return the profile
	 */
	public TreeItem getProfile() {
		return profile;
	}

	/**
	 * @param profile
	 *            the profile to set
	 */
	public void setProfile(TreeItem profile) {
		this.profile = profile;
	}

	/**
	 * @return the util
	 */
	public TreeItem getUtil() {
		return util;
	}

	/**
	 * @param util
	 *            the util to set
	 */
	public void setUtil(TreeItem util) {
		this.util = util;
	}

	/**
	 * @return the activity
	 */
	public TreeItem getActivity() {
		return activity;
	}

	/**
	 * @param activity
	 *            the activity to set
	 */
	public void setActivity(TreeItem activity) {
		this.activity = activity;
	}

	/**
	 * @return the release
	 */
	public TreeItem getRelease() {
		return release;
	}

	/**
	 * @param release
	 *            the release to set
	 */
	public void setRelease(TreeItem release) {
		this.release = release;
	}

	/**
	 * @return the org
	 */
	public ArrayList<UnicaseModelElement> getOrg() {
		return org;
	}

	/**
	 * @param org
	 *            the org to set
	 */
	public void setOrg(ArrayList<UnicaseModelElement> org) {
		this.org = org;
	}

	/**
	 * @return the tas
	 */
	public ArrayList<UnicaseModelElement> getTas() {
		return tas;
	}

	/**
	 * @param tas
	 *            the tas to set
	 */
	public void setTas(ArrayList<UnicaseModelElement> tas) {
		this.tas = tas;
	}

	/**
	 * @return the classe
	 */
	public ArrayList<UnicaseModelElement> getClasse() {
		return classe;
	}

	/**
	 * @param classe
	 *            the classe to set
	 */
	public void setClasse(ArrayList<UnicaseModelElement> classe) {
		this.classe = classe;
	}

	/**
	 * @return the doc
	 */
	public ArrayList<UnicaseModelElement> getDoc() {
		return doc;
	}

	/**
	 * @param doc
	 *            the doc to set
	 */
	public void setDoc(ArrayList<UnicaseModelElement> doc) {
		this.doc = doc;
	}

	/**
	 * @return the req
	 */
	public ArrayList<UnicaseModelElement> getReq() {
		return req;
	}

	/**
	 * @param req
	 *            the req to set
	 */
	public void setReq(ArrayList<UnicaseModelElement> req) {
		this.req = req;
	}

	/**
	 * @return the rat
	 */
	public ArrayList<UnicaseModelElement> getRat() {
		return rat;
	}

	/**
	 * @param rat
	 *            the rat to set
	 */
	public void setRat(ArrayList<UnicaseModelElement> rat) {
		this.rat = rat;
	}

	/**
	 * @return the chan
	 */
	public ArrayList<UnicaseModelElement> getChan() {
		return chan;
	}

	/**
	 * @param chan
	 *            the chan to set
	 */
	public void setChan(ArrayList<UnicaseModelElement> chan) {
		this.chan = chan;
	}

	/**
	 * @return the bugg
	 */
	public ArrayList<UnicaseModelElement> getBugg() {
		return bugg;
	}

	/**
	 * @param bugg
	 *            the bugg to set
	 */
	public void setBugg(ArrayList<UnicaseModelElement> bugg) {
		this.bugg = bugg;
	}

	/**
	 * @return the comp
	 */
	public ArrayList<UnicaseModelElement> getComp() {
		return comp;
	}

	/**
	 * @param comp
	 *            the comp to set
	 */
	public void setComp(ArrayList<UnicaseModelElement> comp) {
		this.comp = comp;
	}

	/**
	 * @return the meet
	 */
	public ArrayList<UnicaseModelElement> getMeet() {
		return meet;
	}

	/**
	 * @param meet
	 *            the meet to set
	 */
	public void setMeet(ArrayList<UnicaseModelElement> meet) {
		this.meet = meet;
	}

	/**
	 * @return the stat
	 */
	public ArrayList<UnicaseModelElement> getStat() {
		return stat;
	}

	/**
	 * @param stat
	 *            the stat to set
	 */
	public void setStat(ArrayList<UnicaseModelElement> stat) {
		this.stat = stat;
	}

	/**
	 * @return the attat
	 */
	public ArrayList<UnicaseModelElement> getAttat() {
		return attat;
	}

	/**
	 * @param attat
	 *            the attat to set
	 */
	public void setAttat(ArrayList<UnicaseModelElement> attat) {
		this.attat = attat;
	}

	/**
	 * @return the prof
	 */
	public ArrayList<UnicaseModelElement> getProf() {
		return prof;
	}

	/**
	 * @param prof
	 *            the prof to set
	 */
	public void setProf(ArrayList<UnicaseModelElement> prof) {
		this.prof = prof;
	}

	/**
	 * @return the uti
	 */
	public ArrayList<UnicaseModelElement> getUti() {
		return uti;
	}

	/**
	 * @param uti
	 *            the uti to set
	 */
	public void setUti(ArrayList<UnicaseModelElement> uti) {
		this.uti = uti;
	}

	/**
	 * @return the act
	 */
	public ArrayList<UnicaseModelElement> getAct() {
		return act;
	}

	/**
	 * @param act
	 *            the act to set
	 */
	public void setAct(ArrayList<UnicaseModelElement> act) {
		this.act = act;
	}

	/**
	 * @return the rel
	 */
	public ArrayList<UnicaseModelElement> getRel() {
		return rel;
	}

	/**
	 * @param rel
	 *            the rel to set
	 */
	public void setRel(ArrayList<UnicaseModelElement> rel) {
		this.rel = rel;
	}

	/**
	 * @return the choosenME
	 */
	public ArrayList<UnicaseModelElement> getChoosenME() {
		return choosenME;
	}

	/**
	 * @param choosenME
	 *            the choosenME to set
	 */
	public void setChoosenME(ArrayList<UnicaseModelElement> choosenME) {
		this.choosenME = choosenME;
	}

	/**
	 * @return the dir
	 */
	public ArrayList<String> getDir() {
		return dir;
	}

	/**
	 * @param dir
	 *            the dir to set
	 */
	public void setDir(ArrayList<String> dir) {
		this.dir = dir;
	}

	/**
	 * @return the parent1
	 */
	public TreeItem getParent1() {
		return parent1;
	}

	/**
	 * @param parent1
	 *            the parent1 to set
	 */
	public void setParent1(TreeItem parent1) {
		this.parent1 = parent1;
	}

}
