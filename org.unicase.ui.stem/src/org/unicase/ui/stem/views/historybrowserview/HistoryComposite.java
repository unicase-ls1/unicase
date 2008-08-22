package org.unicase.ui.stem.views.historybrowserview;



import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.ui.common.exceptions.ExceptionDialogHandler;
import org.unicase.ui.stem.views.changebrowserview.ChangeBrowserView;

public class HistoryComposite extends Composite {

	private TableViewer tableViewer;
	private Version sourceVersion;
	private Version targetVersion;
	private Label lblSourceVersion;
	private Label lblTargetVersion;
	
	public HistoryComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTable();
		tableViewer.setInput(getVersions());
		
		for(TableColumn column : tableViewer.getTable().getColumns()){
			column.pack();
		}
		
		createButtons();
	}
	
	

	private void createTable() {
		tableViewer = new TableViewer(this, SWT.FULL_SELECTION);
		tableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableViewerColumn tclmRevision = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmRevision.getColumn().setText("Revision");
				
		TableViewerColumn tclmTag = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmTag.getColumn().setText("Tag");
		
		TableViewerColumn tclmDate = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmDate.getColumn().setText("Date");
		
		TableViewerColumn tclmAuthor = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmAuthor.getColumn().setText("Author");
		
		TableViewerColumn tclmLogMsg = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmLogMsg.getColumn().setText("Log Message");
		
		tableViewer.setContentProvider(new HistoryTableContentProvider());
		tableViewer.setLabelProvider(new HistoryTableLabelProvider());
		tableViewer.setInput(getVersions());
		
		hookTableCntextMenu();
		
		
	}
	
	private void hookTableCntextMenu() {
		Action actionSetSource = new Action("Set as source"){
			@Override
			public void run(){
				IStructuredSelection selection = (IStructuredSelection)tableViewer.getSelection();
				if(!selection.isEmpty()){
					setSourceVersion((Version)selection.getFirstElement());
				}
			
				
			}
			
		};
		
		Action actionSetTarget = new Action("Set as target"){
			@Override
			public void run(){
				IStructuredSelection selection = (IStructuredSelection)tableViewer.getSelection();
				if(!selection.isEmpty()){
					setTargetVersion((Version)selection.getFirstElement());
				}
			}
		};
		
		Action actionShowChangePackages = new Action("Show associated change packages..."){
			@Override
			public void run(){
				IStructuredSelection selection = (IStructuredSelection)tableViewer.getSelection();
				if(!selection.isEmpty()){
					showChangePackages((Version)selection.getFirstElement());
				}
			}
		};
		
		
		MenuManager mgr = new MenuManager();
		mgr.add(actionSetSource);
		mgr.add(actionSetTarget);
		mgr.add(new Separator());
		mgr.add(actionShowChangePackages);
		
		tableViewer.getControl().setMenu(mgr.createContextMenu(tableViewer.getControl()));
		
		
		
//		mgr.setRemoveAllWhenShown(true);
//		mgr.addMenuListener(new IMenuListener(){
//
//			public void menuAboutToShow(IMenuManager manager) {
//				IStructuredSelection selection = (IStructuredSelection)tableViewer.getSelection();
//				if(!selection.isEmpty()){
//					mgr.add(actionSetSource);
//				}
//				
//			}
//			
//		});
		
	}



	protected void showChangePackages(Version version) {
		//show ChangeBrowserView with version.ChangePackage as input
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		ChangeBrowserView changeBrowserView = null;
		try {
			changeBrowserView = (ChangeBrowserView)page.showView("org.unicase.ui.stem.ChangeBrowserView");
		} catch (PartInitException e) {
			ExceptionDialogHandler.showExceptionDialog(e);
		}
		
		if(changeBrowserView != null){
			changeBrowserView.setInput(version.getChanges());
		}
			
	}



	private List<Version> getVersions() {
		
		return createDummyVersions();
	}


	private List<Version> createDummyVersions() {
		Version[] versions = new Version[6];
		for(int i = 0; i < 6; i++){
			versions[i] = VersioningFactory.eINSTANCE.createVersion();
			LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
			logMessage.setAuthor("author" + i);
			logMessage.setDate(new Date());
			logMessage.setMessage("a mesage " + i);
			
			PrimaryVersionSpec verSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
			verSpec.setIdentifier(i);
			
			TagVersionSpec tagSpec = VersioningFactory.eINSTANCE.createTagVersionSpec();
			tagSpec.setName("tag" + i);
			
			versions[i].setLogMessage(logMessage);
			versions[i].setPrimarySpec(verSpec);
			versions[i].getTagSpecs().add(tagSpec);
		}
		
		return Arrays.asList(versions);
		
	}



	private void createButtons() {
		Group grpButtons = new Group(this, SWT.NONE);
		grpButtons.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		grpButtons.setLayout(new GridLayout(10, false));
		
		Label lblFrom = new Label(grpButtons, SWT.NONE);
		lblFrom.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		lblFrom.setText("From:");
		lblFrom.setFont(new Font(Display.getDefault(), "Tahoma", 8,SWT.BOLD));
		lblSourceVersion = new Label(grpButtons, SWT.NONE);
		lblSourceVersion.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1 ));
		lblSourceVersion.setText("here is the selected From version shown ....");
		
		Label lblTo = new Label(grpButtons, SWT.NONE);
		lblTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		lblTo.setText("To:");			
		lblTo.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD));
		lblTargetVersion = new Label(grpButtons, SWT.NONE);
		lblTargetVersion.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1));
		lblTargetVersion.setText("here is the selected To version shown ....");
		
		
		Composite composite = new Composite(grpButtons, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 10, 1));
		composite.setLayout(new GridLayout(5, true));
		
		Button btnDiff = new Button(composite, SWT.PUSH);
		btnDiff.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		btnDiff.setText("Diff");
		
		Button btnCreateTag = new Button(composite, SWT.PUSH | SWT.CENTER);
		btnCreateTag.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		btnCreateTag.setText("Create Tag");
	
		Button btnUpdate = new Button(composite, SWT.PUSH);
		btnUpdate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		btnUpdate.setText("Update");
		
		Button btnSwitch = new Button(composite, SWT.PUSH);
		btnSwitch.setLayoutData( new GridData(SWT.FILL, SWT.FILL, true, true));
		btnSwitch.setText("Switch");
		
		Button btnRollback = new Button(composite, SWT.PUSH);
		btnRollback.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		btnRollback.setText("Rollback");
			
	}



	public void setSourceVersion(Version sourceVersion) {
		this.sourceVersion = sourceVersion;
		lblSourceVersion.setText(Integer.toString(sourceVersion.getPrimarySpec().getIdentifier()));
		
	}



	public Version getSourceVersion() {
		return sourceVersion;
	}



	public void setTargetVersion(Version targetVersion) {
		this.targetVersion = targetVersion;
		lblTargetVersion.setText(Integer.toString(targetVersion.getPrimarySpec().getIdentifier()));
	}



	public Version getTargetVersion() {
		return targetVersion;
	}

	
}
