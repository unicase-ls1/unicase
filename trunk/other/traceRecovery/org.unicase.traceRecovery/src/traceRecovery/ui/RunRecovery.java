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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
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

import org.unicase.metamodel.Project;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.ProjectSpace;
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
	EList<EObject> e;

	public void run(String path, String language) {
		display = Display.getCurrent();
		shell = new Shell(display);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 10;

		codeLanguage = language;
		this.path = path;

		shell.setLayout(gridLayout);

		GridData treeLayout = new GridData();
		treeLayout.horizontalSpan = 2;
		treeLayout.verticalSpan = 8;
		treeLayout.horizontalAlignment = SWT.FILL;
		treeLayout.verticalAlignment = SWT.FILL;

		List model = new List(shell, SWT.MULTI);
		model.setLayoutData(treeLayout);

		p = getActiveProject();
		createModel(model);
		// createME();

		// ME = new Tree(shell, SWT.CHECK);
		// ME.setLayoutData(treeLayout);
		// ME.setLayout(gridLayout);

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

		GridData searchLayout = new GridData(SWT.RIGHT, SWT.CENTER, true, false);
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

	}

	public void createModel(List list) {
		EList<EObject> elements = p.getAllModelElementsbyClass(
				EcorePackage.Literals.EOBJECT, new BasicEList<EObject>());
		e = p.getAllModelElementsbyClass(EcorePackage.Literals.EOBJECT,
				new BasicEList<EObject>());
		for (int i = e.size() - 1; i >= 0; i--) {
			e.remove(i);
		}
		System.out.println(e.size() + " kalaaaaaaaaaaaaaaaaaaaaaaaam");
		if (elements != null) {
			for (EObject me : (EList<EObject>) elements) {
				if (me instanceof WorkItem) {
					list.add(((WorkItem) me).getName());
					e.add(me);

				}

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

	AdapterFactoryLabelProvider labelProvider;
	Set<EObject> workspaceME;

	public void createME() {
		EList<ProjectSpace> projectSpace = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getProjectSpaces();
		int i = 0;
		for (ProjectSpace ps : projectSpace) {
			Project p = ps.getProject();
			workspaceME = p.getAllModelElements();
			Iterator iterator = workspaceME.iterator();

			// while (iterator.hasNext()) {
			// System.out.println(iterator.next().toString()
			// + " this is the value of i " + i);
			// }
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
			sourceDir.setPath("lucene-index");

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
			recovery = new Search();
			recovery.setAnalyzer(codeLanguage);
			Directory codeDir = TraceRecoveryFactory.eINSTANCE
					.createDirectory();
			codeDir.setPath(path);

			Directory sourceDir = TraceRecoveryFactory.eINSTANCE
					.createDirectory();
			sourceDir.setPath("lucene-index");

			recovery.setIndexer(codeLanguage, codeDir, sourceDir);
			new SearchResult().run(this);

		}

	}

	ArrayList<String> dir = new ArrayList<String>();

	void directoriesBuild(TreeItem item, String mainPath) {

		TreeItem[] items = item.getItems();

		for (int i = 0; i < items.length; i++) {
			if (items[i].getChecked()) {
				String tex = mainPath + "/" + items[i].getText();
				dir.add(tex);
				System.out.println(tex);

			} else if (items[i].getGrayed()) {
				directoriesBuild(items[i], mainPath + "/" + items[i].getText());

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
