package org.unicase.changetracking.ui.createChangePackage;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.git.GitRepoFindUtil;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.CreateRepositoryActionDelegate;
import org.unicase.changetracking.ui.ImageAndTextLabel;
import org.unicase.changetracking.ui.dialogs.AttacheeSelectionDialog;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.navigator.ContentProvider;

public class ChooseWorkItemPage extends WizardPage{

	private static final Image PROJECT_IMAGE = Activator.getImageDescriptor("icons/cprj_obj.gif").createImage();
	private static final Image NO_SELECTION_IMAGE = Activator.getImageDescriptor("icons/error.gif").createImage();
	private static final String WORK_ITEM_TOOLTIP = "Select a work item to which the change package will be attached.";
	private static final String PROJECT_TOOLTIP = "The Unicase project to which the change package will be added.\n\nIs automatically inferred from the work item to which the change package will be attached";
	private static final String REPOSITORY_TOOLTIP = "The remote repository in the Unicase project.\n\nThe repository must match the local repository from which the change package is created.\nIf the project contains no matching repository, you can create one here.";
	private ChangeTrackingRelease release;
	private ImageAndTextLabel workItemLabel;
	private ImageAndTextLabel projectLabel;
	private ImageAndTextLabel remoteRepoLabel;
	private AttacheeSelectionDialog attacheeDialog;
	private Project selectedProject;
	private UnicaseModelElement selectedWorkItem;
	private ILabelProvider labelProvider;
	private GitRepository selectedRepository;
	private Composite composite;
	private Button createRepoButton;
	private String selectedProjectName;
	private Repository localRepo;
	
	

	public Project getSelectedProject() {
		return selectedProject;
	}

	public WorkItem getSelectedWorkItem() {
		return (WorkItem) selectedWorkItem;
	}

	public GitRepository getSelectedRepository() {
		return selectedRepository;
	}

	public String getSelectedProjectName() {
		return selectedProjectName;
	}

	protected ChooseWorkItemPage(String pageName, String title,
			ImageDescriptor titleImage, Repository localRepo) {
		super(pageName, title, titleImage);
		this.release = release;
		attacheeDialog = new AttacheeSelectionDialog("Choose work item","Choose a work item to attach the change package to.");
		this.localRepo = localRepo;
		labelProvider = attacheeDialog.getLabelProvider();
		
	}

	@Override
	public void createControl(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).margins(10, 0).spacing(5, 5).applyTo(composite);
		setControl(composite);
		
		//Layout datas
		GridDataFactory fillTwoColsLayout = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).span(1, 1);
		GridDataFactory fillOneColLayout = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true);
		GridDataFactory notFillOneColLayout = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(false, true);
		int labelStyleBits = SWT.BORDER;
		int descriptionStyleBits = SWT.NONE;
		
		
		//First line
		Label label = new Label(composite, descriptionStyleBits);
		label.setText("Attach to:");
		label.setToolTipText(WORK_ITEM_TOOLTIP);
		notFillOneColLayout.applyTo(label);
		workItemLabel = new ImageAndTextLabel(composite, labelStyleBits, labelProvider);
		workItemLabel.setToolTipText(WORK_ITEM_TOOLTIP);
		fillOneColLayout.applyTo(workItemLabel);
		Button button = new Button(composite, SWT.PUSH);
		button.setText("Change...");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				openDialog();
			}
		});
		notFillOneColLayout.applyTo(button);
		
		//Second line
		label = new Label(composite, descriptionStyleBits);
		label.setText("Project:");
		label.setToolTipText(PROJECT_TOOLTIP);
		notFillOneColLayout.applyTo(label);
		projectLabel = new ImageAndTextLabel(composite, labelStyleBits, labelProvider);
		fillTwoColsLayout.applyTo(projectLabel);
		projectLabel.setToolTipText(PROJECT_TOOLTIP);
		//Composite for taking place, only for layouting
		new Composite(composite,descriptionStyleBits);

		//Third line
		label = new Label(composite, descriptionStyleBits);
		label.setText("Repository:");
		label.setToolTipText(REPOSITORY_TOOLTIP);
		notFillOneColLayout.applyTo(label);
		remoteRepoLabel = new ImageAndTextLabel(composite, labelStyleBits, labelProvider);
		remoteRepoLabel.setToolTipText(REPOSITORY_TOOLTIP);
		fillTwoColsLayout.applyTo(remoteRepoLabel);
		createRepoButton = new Button(composite, SWT.PUSH);
		createRepoButton.setText("Create");
		createRepoButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedRepository = new CreateRepositoryActionDelegate().createRepository(localRepo, selectedProject);
				updateFields();
			}
		});
		createRepoButton.setEnabled(false);
		notFillOneColLayout.applyTo(createRepoButton);

		//Open MESelection Dialog
		openDialog();
	}

	private void openDialog() {
		attacheeDialog.open();
		if(attacheeDialog.getReturnCode() == Window.OK){
			selectedProject = attacheeDialog.getSelectedProjectSpace().getProject();
			selectedProjectName = attacheeDialog.getSelectedProjectSpace().getProjectName();
			selectedWorkItem = attacheeDialog.getSelectedModelElementNoCreate();
			selectedRepository = GitRepoFindUtil.findRemoteInProject(localRepo, selectedProject);;
		}
		updateFields();
	}
	
	private void updateFields(){
		if(selectedWorkItem == null){
			workItemLabel.setContent(NO_SELECTION_IMAGE,"<< No workitem chosen >>");
			projectLabel.setContent(NO_SELECTION_IMAGE,"<< No workitem chosen >>");
			remoteRepoLabel.setContent(NO_SELECTION_IMAGE,"<< No workitem chosen >>");
			createRepoButton.setEnabled(false);
			setPageComplete(false);
			setMessage("Choose a model element to attach the change package to.", DialogPage.ERROR);
		} else {
			workItemLabel.setInput(selectedWorkItem);
			projectLabel.setContent(PROJECT_IMAGE, selectedProjectName);
			if(selectedRepository == null){
				remoteRepoLabel.setContent(NO_SELECTION_IMAGE,"<< No matching repository in project >>");
				createRepoButton.setEnabled(true);
				setPageComplete(false);
				setMessage("The chosen project does not contain a remote repository matching the local repository. Create one first.", DialogPage.ERROR);
			} else {
				remoteRepoLabel.setInput(selectedRepository);
				createRepoButton.setEnabled(false);
				setPageComplete(true);
				setMessage("",DialogPage.NONE);
			}
		}
		composite.redraw();
		
		
		
	}

	
	
	

}
