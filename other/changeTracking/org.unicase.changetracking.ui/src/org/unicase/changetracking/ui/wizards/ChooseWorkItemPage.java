/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.changetracking.common.ChangeTrackingUtil;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.ui.dialogs.AttacheeSelectionDialog;
import org.unicase.changetracking.ui.widgets.ImageAndTextLabel;
import org.unicase.changetracking.vcs.IVCSAdapter;
import org.eclipse.emf.emfstore.common.model.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.task.WorkItem;

/**
 * Wizard page of the "create change package" wizard.
 * 
 * Allows to choose a work item and a repository location for the change
 * package. If the version control adapter specifies that no repository location
 * is needed, then only the work item can be chosen.
 * 
 * @author jfinis
 * 
 */
public class ChooseWorkItemPage extends WizardPage {

	private static final Image PROJECT_IMAGE = Activator.getImageDescriptor("icons/cprj_obj.gif").createImage();
	private static final Image NO_SELECTION_IMAGE = Activator.getImageDescriptor("icons/error.gif").createImage();
	private static final String WORK_ITEM_TOOLTIP = "Select a work item to which the change package will be attached.";
	private static final String PROJECT_TOOLTIP = "The Unicase project to which the change package will be added.\n\nIs automatically inferred from the work item to which the change package will be attached";
	private static final String REPOSITORY_TOOLTIP = "The remote repository in the Unicase project.\n\nThe repository must match the local repository from which the change package is created.\nIf the project contains no matching repository, you can create one here.";
	private ImageAndTextLabel workItemLabel;
	private ImageAndTextLabel projectLabel;
	private ImageAndTextLabel remoteRepoLabel;
	private AttacheeSelectionDialog attacheeDialog;
	private org.eclipse.emf.emfstore.common.model.Project selectedProject;
	private UnicaseModelElement selectedWorkItem;
	private ILabelProvider labelProvider;
	private RepositoryLocation selectedRepository;
	private Composite composite;
	private Button createRepoButton;
	private String selectedProjectName;
	private IVCSAdapter vcs;
	private IProject[] workspaceProjects;

	/**
	 * Returns the selected project. I.e. the project in which the selected work
	 * item resides.
	 * 
	 * @return selected project
	 */
	public Project getSelectedProject() {
		return selectedProject;
	}

	/**
	 * Returns the selected work item.
	 * 
	 * @return the selected work item
	 */
	public WorkItem getSelectedWorkItem() {
		return (WorkItem) selectedWorkItem;
	}

	/**
	 * Returns the selected repository location.
	 * 
	 * @return the selected repository location
	 */
	public RepositoryLocation getSelectedRepository() {
		return selectedRepository;
	}

	/**
	 * Returns the name of the selected project.
	 * 
	 * @return selected project name
	 */
	public String getSelectedProjectName() {
		return selectedProjectName;
	}

	/**
	 * Default constructor.
	 * 
	 * @param pageName page name
	 * @param title page title
	 * @param titleImage page title image
	 * @param vcs VCS adapter
	 * @param selectedProjects project from which the change package is to be
	 *            created.
	 */
	protected ChooseWorkItemPage(String pageName, String title, ImageDescriptor titleImage, IVCSAdapter vcs, IProject[] selectedProjects) {
		super(pageName, title, titleImage);

		attacheeDialog = new AttacheeSelectionDialog("Choose work item", "Choose a work item to attach the change package to.");
		this.vcs = vcs;
		this.workspaceProjects = selectedProjects;
		labelProvider = attacheeDialog.getLabelProvider();

	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).margins(10, 0).spacing(5, 5).applyTo(composite);
		setControl(composite);

		// Layout datas
		GridDataFactory fillTwoColsLayout = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).span(1, 1);
		GridDataFactory fillOneColLayout = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true);
		GridDataFactory notFillOneColLayout = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(false, true);
		int labelStyleBits = SWT.BORDER;
		int descriptionStyleBits = SWT.NONE;

		// First line
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

		// Second line
		label = new Label(composite, descriptionStyleBits);
		label.setText("Project:");
		label.setToolTipText(PROJECT_TOOLTIP);
		notFillOneColLayout.applyTo(label);
		projectLabel = new ImageAndTextLabel(composite, labelStyleBits, labelProvider);
		fillTwoColsLayout.applyTo(projectLabel);
		projectLabel.setToolTipText(PROJECT_TOOLTIP);
		// Composite for taking place, only for layouting
		new Composite(composite, descriptionStyleBits);

		// Third line
		if (vcs.doesChangePackageNeedRepoLocation()) {
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
					try {
						selectedRepository = vcs.createRepositoryLocation(workspaceProjects);
						ChangeTrackingUtil.addToProjectRelative(selectedRepository, selectedWorkItem == null ? selectedProject : selectedWorkItem, true);
						updateFields();
					} catch (VCSException e1) {
						UIUtil.handleException("The repository could not be created", e1);
					} catch (CancelledByUserException e1) {}

				}
			});
			createRepoButton.setEnabled(false);
			notFillOneColLayout.applyTo(createRepoButton);
		}

		// Open MESelection Dialog
		openDialog();
	}

	private void openDialog() {
		attacheeDialog.open();
		if (attacheeDialog.getReturnCode() == Window.OK) {
			selectedProject = attacheeDialog.getSelectedProjectSpace().getProject();
			selectedProjectName = attacheeDialog.getSelectedProjectSpace().getProjectName();
			selectedWorkItem = attacheeDialog.getSelectedModelElement();
			if (vcs.doesChangePackageNeedRepoLocation()) {
				try {
					selectedRepository = vcs.findRepoLocation(workspaceProjects, selectedProject);
				} catch (VCSException e) {
					UIUtil.handleException(e);
				}
			}
		}
		updateFields();
	}
	
	/**
	 * Places the work item in the project.
	 * This is only done if the user has chosen
	 * to create a new work item. Otherwise,
	 * this method does nothing.
	 */
	public void performWorkItemPlacement(){
		attacheeDialog.performPlacement();
	}

	private void updateFields() {
		if (selectedWorkItem == null) {
			workItemLabel.setContent(NO_SELECTION_IMAGE, "<< No workitem chosen >>");
			projectLabel.setContent(NO_SELECTION_IMAGE, "<< No workitem chosen >>");
			if (vcs.doesChangePackageNeedRepoLocation()) {
				remoteRepoLabel.setContent(NO_SELECTION_IMAGE, "<< No workitem chosen >>");
				createRepoButton.setEnabled(false);
			}
			setPageComplete(false);
			setMessage("Choose a model element to attach the change package to.", DialogPage.ERROR);
		} else {
			workItemLabel.setInput(selectedWorkItem);
			projectLabel.setContent(PROJECT_IMAGE, selectedProjectName);
			if (!vcs.doesChangePackageNeedRepoLocation()) {
				setPageComplete(true);
				setMessage("", DialogPage.NONE);
			} else if (selectedRepository == null) {
				remoteRepoLabel.setContent(NO_SELECTION_IMAGE, "<< No matching repository in project >>");
				createRepoButton.setEnabled(true);
				setPageComplete(false);
				setMessage("The chosen project does not contain a remote repository matching the local repository. Create one first.", DialogPage.ERROR);
			} else {
				remoteRepoLabel.setInput(selectedRepository);
				createRepoButton.setEnabled(false);
				setPageComplete(true);
				setMessage("", DialogPage.NONE);
			}
		}
		composite.redraw();

	}

}
