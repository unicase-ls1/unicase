/**
 * 
 */
package org.unicase.ui.traceRecovery.searchResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.traceRecvoery.pages.RunRecovery;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

import traceRecovery.Directory;
import traceRecovery.Link;
import traceRecovery.Query;
import traceRecovery.TraceRecoveryFactory;

/**
 * @author taher
 * 
 */
public class SearchResult implements Listener {

	Table table;
	ArrayList<Link> link;
	RunRecovery recovery;
	Composite composite;
	Project p;
	Shell parent;
	Rectangle point;

	/**
	 * @return the point
	 */
	public Rectangle getPoint() {
		return point;
	}

	/**
	 * @param rectangle the point to set
	 */
	public void setPoint(Rectangle rectangle) {
		this.point = rectangle;
	}

	/**
	 * will start creating the shell
	 */
	public void createControl() {
		Display disp = Display.getCurrent();

		parent = new Shell(disp);
		parent.setLayout(new GridLayout());
		parent.setBounds(point);
		composite = new Composite(parent, SWT.NULL);

		composite.setLayout(new GridLayout(3, false));
		
		composite.setBounds(point);

		table = new Table(composite, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);

		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;
		table.setLayoutData(data);
		table.addListener(SWT.MouseDoubleClick, this);

		TableColumn source = new TableColumn(table, SWT.V_SCROLL | SWT.H_SCROLL);

		TableColumn target = new TableColumn(table, SWT.V_SCROLL | SWT.H_SCROLL);
		TableColumn score = new TableColumn(table, SWT.V_SCROLL | SWT.H_SCROLL);
		TableColumn linkType = new TableColumn(table, SWT.V_SCROLL
				| SWT.H_SCROLL);
		TableColumn highlight = new TableColumn(table, SWT.V_SCROLL
				| SWT.H_SCROLL);

		source.setText("Source");
		target.setText("Target");
		score.setText("Score");
		linkType.setText("Link Type");
		highlight.setText("hit text");

		Recovery();
	}

	/**
	 * called to start the recovery process
	 */

	public void Recovery() {
		if (recovery.getImagevalue() == 1) {
			link = recoveryMEtoCode();
		} else if (recovery.getImagevalue() == 2) {
			link = recoveryCodetoME(recovery.getCodeLanguage());
		}

		for (int i = 0; i < link.size(); i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			Link result = link.get(i);
			String[] text = new String[5];
			text[0] = result.getSource().getName();
			text[1] = result.getTarget().getName();
			text[2] = result.getConfidence() + "";
			text[3] = result.getType();
			// text[4] = recovery.getRecovery().text.get(i);
			TableEditor editor = new TableEditor(table);

			StyledText textt = new StyledText(table, SWT.V_SCROLL
					| SWT.H_SCROLL);
			textt.setText(recovery.getRecovery().text.get(i));
			editor.setEditor(textt, item, 4);

			item.setText(text);
		}

		// table.layout();
		// table.redraw();
		// composite.layout();

		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumn(i).pack();
		}

		parent.layout();
		parent.pack();
		parent.open();

	}

	/**
	 * if the recovery choosen was to recover from Model Element to code then
	 * this method will be called to start the process
	 * 
	 * @return this is the arraylist of the hits that occured in the search
	 */

	public ArrayList<Link> recoveryMEtoCode() {
		try {
			ArrayList<UnicaseModelElement> ME = recovery.getChoosenME();

			Query query = TraceRecoveryFactory.eINSTANCE.createQuery();
			for (int i = 0; i < ME.size(); i++) {
				query.getModelElements().add(ME.get(i));
			}

			Directory dir = TraceRecoveryFactory.eINSTANCE.createDirectory();
			dir.setPath(recovery.getIndexPath());

			ArrayList<Link> links = recovery.getRecovery().runRecoveryMEToCode(
					query, dir);

			return links;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * this will perform the recovery if it is performed from code and trying to
	 * recover model elements.
	 * 
	 * @param type
	 *            this is to specify what language of code is going to be used
	 * @return this is an array list of the links of the result of the search
	 *         done to retrieve the Model Elements
	 */
	public ArrayList<Link> recoveryCodetoME(String type) {

		ArrayList<String> dirs = recovery.getDir();
		ArrayList<File> files = new ArrayList<File>();

		Directory dir = TraceRecoveryFactory.eINSTANCE.createDirectory();
		dir.setPath(recovery.getIndexPath());

		for (int i = 0; i < dirs.size(); i++) {
			File f = new File(dirs.get(i));
			files.add(f);
		}

		Query query = recovery.getRecovery().createQeuryCode(files, type);

		ArrayList<Link> link = recovery.getRecovery().runRecoveryCodeToME(
				query, dir);

		return link;

	}

	/**
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * @param table
	 *            the table to set
	 */
	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * @return the link
	 */
	public ArrayList<Link> getLink() {
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(ArrayList<Link> link) {
		this.link = link;
	}

	/**
	 * @return the recovery
	 */
	public RunRecovery getRecovery() {
		return recovery;
	}

	/**
	 * @param recovery
	 *            the recovery to set
	 */
	public void setRecovery(RunRecovery recovery) {
		this.recovery = recovery;
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */
	@Override
	public void handleEvent(Event event) {
		if (event.widget == table) {
			if (recovery.getImagevalue() == 1) {

				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				File file = new File(link.get(table.getSelectionIndex())
						.getTarget().getDescription());
				IFileStore fileStore = EFS.getLocalFileSystem().getStore(
						file.toURI());
				try {
					if (recovery.getCodeLanguage() == "java") {
						// IDE.openEditor(page, file.toURI(),
						// "org.eclipse.jdt.ui.CompilationUnitEditor", true);
						IDE.openEditorOnFileStore(page, fileStore);

					} else {
						// IDE.openEditorOnFileStore( page, fileStore );
						IDE.openEditor(page, file.toURI(),
								"org.eclipse.photran.ui.FortranEditor", true);
					}
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (recovery.getImagevalue() == 2) {
				UnicaseActionHelper.openModelElement(
						p.getModelElement(link.get(table.getSelectionIndex())
								.getTarget().getModelElementId()),
						link.get(table.getSelectionIndex()).getTarget()
								.getModelElementId().getId());

			}
		}

	}

}
