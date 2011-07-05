/**
 * 
 */
package traceRecovery.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.trace.CodeLocation;
import org.unicase.ui.meeditor.commands.OpenModelElementHandler;

import traceRecovery.Directory;
import traceRecovery.Link;
import traceRecovery.Query;
import traceRecovery.TraceRecoveryFactory;
import traceability.handler.Search;

import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.util.ModelElementOpener;

/**
 * @author taher
 * this class will show the result of the search in a table and allow you to inspect the results more
 * 
 */
public class SearchResult implements SelectionListener, Listener {
	Display display;
	Shell shell;
	TableCursor cursor;
	Table table;
	ArrayList<Link> link;

	RunRecovery recovery;

	/**
	 * This is the run method that will start running to show the results of search
	 * @param recovery this is the runrecovery to allow me to access all the instance variable of it
	 */
	public void run(RunRecovery recovery) {
		try {
			recovery.shell.dispose();
			display = Display.getCurrent();

			this.recovery = recovery;

			shell = new Shell(display);
			shell.setLayout(new GridLayout(3, false));

			table = new Table(shell, SWT.MULTI | SWT.BORDER
					| SWT.FULL_SELECTION);

			table.setLinesVisible(true);
			table.setHeaderVisible(true);
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.heightHint = 200;
			table.setLayoutData(data);
			table.addListener(SWT.MouseDoubleClick, this);

			TableColumn source = new TableColumn(table, SWT.V_SCROLL
					| SWT.H_SCROLL);

			TableColumn target = new TableColumn(table, SWT.V_SCROLL
					| SWT.H_SCROLL);
			TableColumn score = new TableColumn(table, SWT.V_SCROLL
					| SWT.H_SCROLL);
			TableColumn linkType = new TableColumn(table, SWT.V_SCROLL
					| SWT.H_SCROLL);

			source.setText("Source");
			target.setText("Target");
			score.setText("Score");
			linkType.setText("Link Type");

			// Query query = TraceRecoveryFactory.eINSTANCE.createQuery();
			// UnicaseModelElement me = (UnicaseModelElement) recovery.e.get(0);
			// query.getModelElements().add(
			// (UnicaseModelElement) recovery.e.get(0));
			// //
			// Directory dir = TraceRecoveryFactory.eINSTANCE.createDirectory();
			// dir.setPath(recovery.indexPath);
			// //
			// link = recovery.recovery.runRecoveryMEToCode(query, dir);
			// //

			if (recovery.imagevalue == 1) {
				link = recoveryMEtoCode();

			} else {
				link = recoveryCodetoME(recovery.codeLanguage);

			}

			for (int i = 0; i < link.size(); i++) {
				TableItem item = new TableItem(table, SWT.NONE);
				Link result = link.get(i);
				String[] text = new String[4];
				text[0] = result.getSource().getName();
				text[1] = result.getTarget().getName();
				text[2] = result.getConfidence() + "";
				text[3] = result.getType();

				item.setText(text);

			}

			//
			// cursor = new TableCursor(table, SWT.NONE);
			// cursor.addListener(SWT.MouseDoubleClick, this);

			// TableItem item = new TableItem(table, SWT.NONE);
			//
			// Link result = link.get(0);
			//
			// String [] text = new String [4];
			// text [0] = result.getSource().getName();
			// text [1] = result.getTarget().getName();
			// text [2] = result.getConfidence() + "";
			// text [3] = result.getType();
			//
			// System.out.println(text[1] +
			// " kalam keter keda kan lazem yet2l lama ne3mel keda");
			//
			// item.setText(text);
			// TableItem item2 = new TableItem(table, SWT.NONE);
			// item2.setText("bardo kalam fare3'");

			for (int i = 0; i < table.getColumnCount(); i++) {
				table.getColumn(i).pack();
			}

			shell.open();

			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * if the recovery choosen was to recover from Model Element to code then this method will be called to start the process 
	 * @return 
	 * 			this is the arraylist of the hits that occured in the search 
	 */
	
	public ArrayList<Link> recoveryMEtoCode() {
		try {
			ArrayList<UnicaseModelElement> ME = recovery.choosenME;

			Query query = TraceRecoveryFactory.eINSTANCE.createQuery();
			for (int i = 0; i < ME.size(); i++) {
				query.getModelElements().add(ME.get(i));
			}

			Directory dir = TraceRecoveryFactory.eINSTANCE.createDirectory();
			dir.setPath(recovery.indexPath);

			ArrayList<Link> links = recovery.recovery.runRecoveryMEToCode(
					query, dir);

			return links;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * this will perform the recovery if it is performed from code and trying to recover model elements.
	 * @param type
	 * 				this is to specify what language of code is going to be used
	 * @return
	 * 			this is an array list of the links of the result of the search done to retrieve the Model Elements
	 */
	public ArrayList<Link> recoveryCodetoME(String type) {

		ArrayList<String> dirs = recovery.dir;
		ArrayList<File> files = new ArrayList<File>();

		Directory dir = TraceRecoveryFactory.eINSTANCE.createDirectory();
		dir.setPath(recovery.indexPath);

		for (int i = 0; i < dirs.size(); i++) {
			File f = new File(dirs.get(i));
			files.add(f);
		}

		Query query = recovery.recovery.createQeuryCode(files, type);

		ArrayList<Link> link = recovery.recovery
				.runRecoveryCodeToME(query, dir);

		return link;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt
	 * .events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse
	 * .swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * this method will show the start and end position of the words that should be highlighted.
	 * @param line
	 * 				this is the line of text that contains words to highlight
	 * @return
	 * 			this is the return of the highlighted text start and offset.
	 */
	public ArrayList<Integer> highlight(String line) {
		StyleRange range = new StyleRange();
		ArrayList<Integer> start = new ArrayList<Integer>();

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '<' && line.charAt(i + 1) == 'B') {
				range.start = i + 3;
			} else if (line.charAt(i) == '<' && line.charAt(i + 1) == '/') {
				range.length = i - range.start;
				start.add(range.start);
				start.add(range.length);

				range.fontStyle = SWT.BOLD;
				range.foreground = display
						.getSystemColor(SWT.COLOR_DARK_YELLOW);
			}
		}
		return start;
	}

	/*
	 * (non-Javadoc)
	 * this will perform the actions of double click to further explore the model elements.
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */
	public void handleEvent(Event event) {
		if (event.widget == table) {
			if (event.type == SWT.MouseDoubleClick) {
				if (recovery.imagevalue == 1) {
					Link lin = link.get(table.getSelectionIndex());
					String line = recovery.recovery.text.get(table
							.getSelectionIndex());
					if (lin.getTarget() instanceof CodeLocation) {
						CodeLocation loc = (CodeLocation) lin.getTarget();
						System.out
								.println(loc.getDescription()
										+ " this should be the path law 7asal we 3amal printing le deh 2slan :D");

					}
					Shell sh = new Shell(display);
					// shell.setVisible(false);

					ArrayList<Integer> start = highlight(line);

					sh.setLayout(new GridLayout(1, false));
					StyledText txt = new StyledText(sh, SWT.None);
					txt.setText(line);
					for (int i = 0; i < start.size(); i += 2) {
						StyleRange range = new StyleRange();
						range.start = start.get(i);
						range.length = start.get(i+1);
						range.fontStyle = SWT.BOLD;
						range.foreground = display
								.getSystemColor(SWT.COLOR_YELLOW);
						txt.setStyleRange(range);
					}
					// highlight(line,txt);

					sh.open();

					while (!shell.isDisposed()) {
						if (!display.readAndDispatch())
							display.sleep();
					}
				} else if (recovery.imagevalue == 2) {
					Link lin = link.get(table.getSelectionIndex());

					Project p = RunRecovery.getActiveProject();

					// System.out.println((link.get(0).getTarget().getName()) +
					// "this is kalama kalam kalam kalam");

					UnicaseActionHelper.openModelElement(
							p.getModelElement(link.get(0).getTarget()
									.getModelElementId()), link.get(0)
									.getTarget().getModelElementId().getId());
				}
			}

		}

	}
}
