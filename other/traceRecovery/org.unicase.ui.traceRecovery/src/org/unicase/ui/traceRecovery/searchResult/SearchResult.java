/**
 * 
 */
package org.unicase.ui.traceRecovery.searchResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
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
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.trace.CodeLocation;
import org.unicase.ui.traceRecovery.traceRecvoery.pages.RunRecovery;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.workspace.util.UnicaseCommand;

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
	ArrayList<Link> links;
	RunRecovery recovery;
	Composite composite;
	Project project;
	Shell parent;
	Rectangle point;
	FontMetrics fm;
	int height;
	Button saveAs;
	Resource resource;
	boolean load = false;

	// for the xml resource
	EList<EObject> content;
	private CompositeSection compositeDocument;
	private LeafSection codeLocationDoc;
	private LeafSection linkDoc;

	/**
	 * @return the resource
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 * @param resource
	 *            the resource to set
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	/**
	 * @return the point
	 */
	public Rectangle getPoint() {
		return point;
	}

	/**
	 * @param rectangle
	 *            the point to set
	 */
	public void setPoint(Rectangle rectangle) {
		this.point = rectangle;
	}

	/**
	 * will start creating the shell
	 */
	public void createControl(String choose) {
		Display disp = Display.getCurrent();

		parent = new Shell(disp);
		parent.setLayout(new GridLayout());
		parent.setLocation(point.x, point.y);
		// parent.setBounds(point);
		composite = new Composite(parent, SWT.NULL);

		composite.setLayout(new GridLayout(3, false));

		composite.setLocation(point.x, point.y);

		fm = new GC(Display.getCurrent()).getFontMetrics();
		height = fm.getHeight() * 2;
		// FileDialog file = new FileDialog(parent, SWT.SAVE);
		// String save = file.open();
		// System.out.println("This is the path of the file to be saved " +
		// save);
		// File file = new File();

		table = new Table(composite, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);

		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;

		table.setLayoutData(data);
		table.addListener(SWT.MouseDoubleClick, this);

		table.addListener(SWT.MeasureItem, this);

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
		linkType.setText("Link Type                 ");
		highlight.setText("hit text                         ");

		if (choose.equals("recovery")) {

			saveAs = new Button(composite, SWT.NONE);
			saveAs.setText("Save As..");
			saveAs.addListener(SWT.Selection, this);

			createRecoveryResultPage();
		} else if (choose.equals("load")) {
			load = true;
			populate();
		}
	}

	/**
	 * Load the XML resource of the recovered links and creates the layout of
	 * the recovered links result page.
	 */
	public void populate() {

		content = resource.getContents();
		links = new ArrayList<Link>();

		for (int i = 0; i < content.size(); i++) {
			LeafSection link = (LeafSection) content.get(i);

			EList<UnicaseModelElement> list = link.getModelElements();
			for (int j = 0; j < list.size(); j++) {
				Link lin = (Link) list.get(j);
				links.add(lin);
			}

			System.out.println("kalam");
		}

		createResultPageLayout();
	}

	private void createResultPageLayout() {
		for (int i = 0; i < links.size(); i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			Link result = links.get(i);
			String[] text = new String[5];
			text[0] = result.getSource().getName();
			text[1] = result.getTarget().getName();
			text[2] = result.getConfidence() + "";
			text[3] = result.getType();

			for (int j = 0; j < 4; j++) {
				item.setText(j, text[j]);

			}

//			if (recovery != null) {
				ArrayList<StyleRange> range = higlightRange(result.getDescription());

				StyledText textt = new StyledText(table, SWT.WRAP
						| SWT.V_SCROLL | SWT.BORDER);

//				String tex = recovery.getRecovery().text.get(i);

				String tex = result.getDescription();
				
				// tex = tex.replace("<B>", "");
				// tex = tex.replace("</B>", "");

				if (tex != null) {
					textt.setText(tex);

					// String t = textt.getText();

					for (int j = 0; j < range.size(); j++) {
						textt.setStyleRange(range.get(j));

					}

					TableEditor editor = new TableEditor(table);

					editor.minimumWidth = textt.getSize().x;
					editor.grabHorizontal = true;
					editor.minimumHeight = textt.getSize().y;
					// editor.horizontalAlignment = SWT.CENTER;

					textt.setEditable(false);
					editor.setEditor(textt, item, 4);

					// item.setText(text);
					// item.get
				}
			}
//		}

		// table.layout();
		// table.redraw();
		// composite.layout();

		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumn(i).pack();

		}

		// Display.getCurrent().getActiveShell().addListener(SWT.SYSTEM_MODAL,
		// this);
		parent.layout();
		parent.pack();
		parent.open();
	}

	/**
	 * called to start the recovery process
	 */

	private void createRecoveryResultPage() {
		if (recovery.getImagevalue() == 1) {
			links = recoverMEtoCode();
		} else if (recovery.getImagevalue() == 2) {
			links = recoverCodetoME(recovery.getCodeLanguage());
		}

		createResultPageLayout();

	}

	private ArrayList<StyleRange> higlightRange(String text) {

		int start;
		int end;

		// boolean first = false;
		// int startOffset = 0;
		// int endOffset = 0;
		//
		ArrayList<StyleRange> r = new ArrayList<StyleRange>();
		for (int i = 0; i < text.length(); i++) {
			start = text.indexOf("<B>", i);
			end = text.indexOf("</B>", i);

			if (start == -1) {
				break;
			} else if(end == -1)
			{
//				StyleRange range = new StyleRange();
//				range.start = start;
//				range.length = text.length()-1;
//				range.fontStyle = SWT.BOLD;
//				range.foreground = Display.getCurrent().getSystemColor(
//						SWT.COLOR_BLUE);
//				r.add(range);
				break;
			}

			i = end + 3;

			StyleRange range = new StyleRange();
			range.start = start;
			range.length = end - start;
			range.fontStyle = SWT.BOLD;
			range.foreground = Display.getCurrent().getSystemColor(
					SWT.COLOR_BLUE);
			r.add(range);

		}

		return r;
	}

	/**
	 * if the recovery choosen was to recover from Model Element to code then
	 * this method will be called to start the process
	 * 
	 * @return this is the arraylist of the hits that occured in the search
	 */

	private ArrayList<Link> recoverMEtoCode() {
		try {
			ArrayList<UnicaseModelElement> ME = recovery.getChoosenME();

			Query query = TraceRecoveryFactory.eINSTANCE.createQuery();
			for (int i = 0; i < ME.size(); i++) {
				if (ME.get(i).getDescription() != null) {
					query.getModelElements().add(ME.get(i));
				}
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
	private ArrayList<Link> recoverCodetoME(String type) {

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
		return links;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(ArrayList<Link> link) {
		this.links = link;
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
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param p
	 *            the p to set
	 */
	public void setProject(Project p) {
		this.project = p;
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
		if (event.type == SWT.MeasureItem) {
			event.height = height;
		} else if (event.widget == table) {
			if (load) {
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				Link link = (Link) content.get(table.getSelectionIndex());

				if (link.getTarget() instanceof CodeLocation) {
					File f = new File(
							((CodeLocation) link.getTarget()).getDescription());
					IFileStore fileStore = EFS.getLocalFileSystem().getStore(
							f.toURI());
					try {
						IDE.openEditorOnFileStore(page, fileStore);
					} catch (PartInitException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			} else

			if (recovery.getImagevalue() == 1) {

				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				File file = new File(links.get(table.getSelectionIndex())
						.getTarget().getDescription());
				IFileStore fileStore = EFS.getLocalFileSystem().getStore(
						file.toURI());
				try {
					if (recovery.getCodeLanguage().equals("java")) {
						// IDE.openEditor(page, file.toURI(),
						// "org.eclipse.jdt.ui.CompilationUnitEditor", true);
						IDE.openEditorOnFileStore(page, fileStore);

					} else {
						// IDE.openEditorOnFileStore( page, fileStore );
						IDE.openEditorOnFileStore(page, fileStore);
					}
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (recovery.getImagevalue() == 2) {
				links.get(table.getSelectionIndex()).getTarget()
						.getModelElementId();

				UnicaseActionHelper.openModelElement(
						project.getModelElement(links
								.get(table.getSelectionIndex()).getTarget()
								.getModelElementId()),
						links.get(table.getSelectionIndex()).getTarget()
								.getModelElementId().getId());

			}

		}

		if (event.widget == saveAs) {
			FileDialog save = new FileDialog(Display.getCurrent()
					.getActiveShell(), SWT.SAVE);
			String path = save.open();
			if (!path.endsWith("xml")) {
				path += ".xml";
			}
			File f = new File(path);
			Resource resource = new XMLResourceImpl(URI.createURI(f.toURI()
					.toString()));
			saveXML(resource);

		}

		System.out.print("Kalame kalame kalame kalamae");

	}

	class HelpWrite extends UnicaseCommand {
		Link link;
		Project project;

		public HelpWrite(Link link, Project p) {
			this.link = link;
			project = p;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.unicase.workspace.util.UnicaseCommand#doRun()
		 */
		@Override
		protected void doRun() {
			// TODO Auto-generated method stub

			UnicaseModelElement target = link.getTarget();
			project.addModelElement(target);
			target.setLeafSection(codeLocationDoc);

			project.addModelElement(link);
			link.setLeafSection(linkDoc);

		}
	}

	private void saveXML(Resource resource) {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				compositeDocument = DocumentFactory.eINSTANCE
						.createCompositeSection();
				compositeDocument.setName("Traceability");
				project.addModelElement(compositeDocument);

				codeLocationDoc = DocumentFactory.eINSTANCE.createLeafSection();
				codeLocationDoc.setName("Code Locations");
				project.addModelElement(codeLocationDoc);
				compositeDocument.getSubsections().add(codeLocationDoc);

				linkDoc = DocumentFactory.eINSTANCE.createLeafSection();
				linkDoc.setName("Traceability Links");
				project.addModelElement(linkDoc);
				compositeDocument.getSubsections().add(linkDoc);

			}
		}.run(true);

		for (int i = 0; i < links.size(); i++) {

			new HelpWrite(links.get(i), project).run(true);

		}

		try {
			resource.getContents().add(EcoreUtil.copy(linkDoc));
			resource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
