/**
 * 
 */
package traceRecovery.ui;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.apache.lucene.document.Field;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

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
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

import traceRecovery.Directory;
import traceRecovery.TraceRecoveryFactory;
import traceability.handler.Search;

/**
 * @author taher
 * 
 */
public class RunRecovery implements Listener {
	Shell shell;
	Display display;
	Tree code;
	Tree ME;
	boolean firstTime;
	Queue<TreeItemHelper> directories;
	Button direction;
	Button search;
	int imagevalue = 1;
	Project p;
	String codeLanguage;
	String path;
	String indexPath;
	EList<EObject> e;

	public void run(String path, String indexPath, String language) {
		try {
			display = Display.getCurrent();
			shell = new Shell(display);
			GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 10;

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

			codeLanguage = language;
			this.path = path;
			this.indexPath = indexPath;

			shell.setLayout(gridLayout);

			GridData treeLayout = new GridData();
			treeLayout.horizontalSpan = 2;
			treeLayout.verticalSpan = 8;
			treeLayout.horizontalAlignment = SWT.FILL;
			treeLayout.verticalAlignment = SWT.FILL;

			// List model = new List(shell, SWT.MULTI);
			// model.setLayoutData(treeLayout);

			p = getActiveProject();
			// createModel(model);
			// createME();

			ME = new Tree(shell, SWT.CHECK);
			ME.setLayoutData(treeLayout);
			ME.setLayout(gridLayout);

			createModelTree(ME);
			createModel();

			// IWorkbenchWindow window =
			// PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			// ISelection selection =
			// window.getSelectionService().getSelection("org.eclipse.jdt.ui.PackageExplorer");
			//
			// IStructuredSelection structured = (IStructuredSelection)
			// selection;
			//
			//
			// System.out.println(structured.getFirstElement().getClass());
			//
			// IPackageFragmentRoot project = (IPackageFragmentRoot)
			// structured.getFirstElement();
			//
			// chooseProject(structured);

			// IFile file = (IFile) structured.getFirstElement();

			// IPath pa = project.getLocation();
			// System.out.println(pa.toPortableString() +
			// " this is the value of the path that i was looking for besm alah el ra7man el ra7eem :D");

			// IStructuredSelection structured = (IStructuredSelection) service
			// .getSelection("org.eclipse.jdt.ui.PackageExplorer");

			GridData directionLayout = new GridData();
			directionLayout.horizontalSpan = 1;
			directionLayout.verticalSpan = 4;
			directionLayout.horizontalAlignment = SWT.FILL;
			direction = new Button(shell, SWT.PUSH);
			direction.setLayoutData(directionLayout);
			// direction.setText("this is a button");
			Image image = new Image(display, "Screenshot-1.png");
			direction.setImage(image);
			direction.addListener(SWT.Selection, this);

			code = new Tree(shell, SWT.CHECK | SWT.V_SCROLL);
			// code.setLayoutData(treeLayout);

			parent = new TreeItem(code, SWT.CHECK);
			parent.setText(path);

			directories = new LinkedList<TreeItemHelper>();

			File dir = new File(path);

			directories.add(new TreeItemHelper(parent, dir));

			createTree();
			// TreeViewer codeViewer = new TreeViewer(code);
			code.addListener(SWT.Selection, this);

			GridData searchLayout = new GridData(SWT.RIGHT, SWT.CENTER, true,
					false);
			searchLayout.horizontalSpan = 10;

			search = new Button(shell, SWT.PUSH);
			search.setLayoutData(searchLayout);
			search.addListener(SWT.Selection, this);
			search.setText("Search");

			// shell.pack();
			shell.open();

			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void chooseProject(IStructuredSelection selection) {
		try {
			IPackageFragmentRoot packa = (IPackageFragmentRoot) selection
					.getFirstElement();
		} catch (Exception e) {
			// chooseProject(selection);

			MessageDialog.open(SWT.ERROR, shell, "wrong folder",
					"choose a correct src folder", SWT.None);

		}
	}

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

	public void createModel() {
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

				TreeItem item = new TreeItem(requirement, SWT.CHECK);
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

	public static Project getActiveProject() {
		ProjectSpace ps = WorkspaceManager.getInstance().getCurrentWorkspace()
				.getActiveProjectSpace();
		if (ps == null) {
			return null;
		}
		if (ps.getProject() != null) {
			return ps.getProject();
		}
		return null;
	}

	TreeItem parent;

	public void createTree() {

		parent = new TreeItem(parent, SWT.CHECK);
		while (!directories.isEmpty()) {
			TreeItemHelper top = directories.remove();
			parent = top.parent;
			parent.setExpanded(true);
			File[] files = top.dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					TreeItem sub = new TreeItem(parent, SWT.CHECK);
					sub.setExpanded(true);
					sub.setText(files[i].getName());
					directories.add(new TreeItemHelper(sub, files[i]));
				} else {
					TreeItem child = new TreeItem(parent, SWT.CHECK);
					child.setText(files[i].getName());
					child.setText(0, files[i].getName());

				}
			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub

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
		} else if (event.widget == search) {

			searchData();

		} else if (event.widget == code) {
			TreeItem item = (TreeItem) event.item;
			boolean checked = item.getChecked();
			checkItems(item, checked);
			checkPath(item.getParentItem(), checked, false);

		} else if (event.widget == ME) {
			TreeItem item = (TreeItem) event.item;
			boolean checked = item.getChecked();
			checkItems(item, checked);
			checkPath(item.getParentItem(), checked, false);
		}

	}

	Search recovery;

	public void searchData() {
		if (imagevalue == 1) {
			recovery = new Search();
			recovery.setAnalyzer(codeLanguage);
			Directory codeDir = TraceRecoveryFactory.eINSTANCE
					.createDirectory();
			codeDir.setPath(path);

			Directory sourceDir = TraceRecoveryFactory.eINSTANCE
					.createDirectory();
			sourceDir.setPath(indexPath);

			recovery.setIndexer(codeLanguage, codeDir, sourceDir);

			boolean checked = false;

			if (code.getItem(0).getChecked()) {

				recovery.index();
				checked = true;
			} else if (code.getItem(0).getGrayed()) {

				directoriesBuild(code.getItem(0), code.getItem(0).getText());

				recovery.index(dir);

				checked = true;
			}

			if (checked) {
				new SearchResult().run(this);
			}
		} else {
			if (!(code.getItem(0).getChecked() || code.getItem(0).getGrayed())) {
				MessageDialog
						.open(SWT.ERROR,
								shell,
								"no folders/filse choosen",
								"you have not choosen a file of a folder to run the code on",
								SWT.None);
			} else if (!choosenME()) {
				MessageDialog
						.open(SWT.ERROR,
								shell,
								"No ME choosen",
								"you have not choosen an ME to run the trace recovery on",
								SWT.None);
			} else {

				recovery = new Search();

				Directory codeDir = TraceRecoveryFactory.eINSTANCE
						.createDirectory();
				codeDir.setPath(path);

				Directory sourceDir = TraceRecoveryFactory.eINSTANCE
						.createDirectory();
				sourceDir.setPath(indexPath);
				
				recovery.indexMe(choosenME, sourceDir);
				
				new SearchResult().run(this);

			}
		}

	}

	ArrayList<UnicaseModelElement> choosenME;

	ArrayList<String> dir = new ArrayList<String>();

	void directoriesBuild(TreeItem item, String mainPath) {

		File fff = new File(path);

		TreeItem[] items = item.getItems();

		for (int i = 0; i < items.length; i++) {
			if (items[i].getChecked()) {
				if (fff.pathSeparatorChar == ':') {
					String tex = mainPath + "/" + items[i].getText();
					dir.add(tex);
					System.out.println(tex);
				} else if (fff.pathSeparatorChar == ';') {
					String tex = mainPath + "\\" + items[i].getText();
					dir.add(tex);
					System.out.println(tex);
				}

			} else if (items[i].getGrayed()) {
				if (fff.pathSeparatorChar == ':') {
					directoriesBuild(items[i],
							mainPath + "/" + items[i].getText());
				} else if (fff.pathSeparatorChar == ';') {
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

	void checkItems(TreeItem item, boolean checked) {
		item.setGrayed(false);
		item.setChecked(checked);
		TreeItem[] items = item.getItems();
		for (int i = 0; i < items.length; i++) {
			checkItems(items[i], checked);
		}
	}

	void checkPath(TreeItem item, boolean checked, boolean grayed) {
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
}
