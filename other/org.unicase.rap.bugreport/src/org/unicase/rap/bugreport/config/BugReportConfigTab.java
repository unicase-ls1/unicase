/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.bugreport.config;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.model.task.WorkPackage;
import org.unicase.rap.bugreport.SelectWorkPackageDialog;
import org.unicase.rap.bugreport.config.BugReportingConfigEntity.Keys;
import org.unicase.rap.config.ActivatedProjectsCache;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.IActivatedProjectsListener;
import org.unicase.rap.config.ProjectKeysConfigEntity;
import org.unicase.rap.ui.tabs.ConfigurationTab;
import org.unicase.rap.ui.viewers.ProjectsTableViewer;
import org.unicase.rap.ui.viewers.URLDialog;
import org.unicase.workspace.ProjectSpace;

import config.ConfigEntity;

/**
 * Configuration tab for bug reporting app.
 * 
 * @author Edgar Müller
 */
public class BugReportConfigTab extends ConfigurationTab 
					implements IActivatedProjectsListener {
	
	private BugReportingConfigEntity cfgEntity;
	
	/**
	 * Text field that holds the ID of the container that 
	 * is used to place fresh bug reports.
	 */
	private Text bugContainerIdTextField;

	/**
	 * A table viewer of all available projects.
	 */
	private ProjectsTableViewer projectsTableViewer;

	/**
	 * The currently selected project space.
	 */
	private ProjectSpace currentProjectSpace;
	
	/**
	 * The current bug container.
	 */
	private String currentBugContainerId;
	
	/**
	 * The constructor.
	 */
	public BugReportConfigTab() {
		
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.rap.ui.tabs.ConfigurationTab#createConfigurationTab(Composite)
	 */
	@Override
	public void createConfigurationTab(Composite parent) {
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 1;
	    GridData data = new GridData();
	    data.horizontalAlignment = SWT.FILL;
	    data.verticalAlignment = SWT.FILL;
	    data.grabExcessHorizontalSpace = true;
	    data.grabExcessVerticalSpace = true;
	    parent.setLayout(gridLayout);
	    parent.setLayoutData(data);

	    Composite tableComposite = new Composite(parent, SWT.NONE);
		projectsTableViewer = new ProjectsTableViewer(tableComposite);	
		ActivatedProjectsCache.getInstance().addListener(this);
		
		// set initial input
		List<ProjectSpace> inputList = new ArrayList<ProjectSpace>();
		inputList.addAll(ActivatedProjectsCache.getInstance().getProjects());
		projectsTableViewer.setInput(inputList);
		tableComposite.setLayoutData(data);
		
		final Label currentlySelectedProject = new Label(parent, SWT.BORDER);
		currentlySelectedProject.setLayoutData(data);
		currentlySelectedProject.setText("Selected project:");
		
		final Button button = new Button(parent, SWT.BORDER);
		button.setText("Get View URL");
		button.setEnabled(false);
		button.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = projectsTableViewer.getTable().getSelectionIndex();
				ProjectSpace projectSpace = (ProjectSpace) projectsTableViewer.getTable().getItem(selectedIndex).getData();
				
				ProjectKeysConfigEntity configEntity = new ProjectKeysConfigEntity();
				ConfigEntityStore.loadConfigEntity(configEntity, configEntity.eClass());
				
				String url = "http://127.0.0.1:2222/rap?startup=unicase&view=bugreport&name=" + projectSpace.getProjectName() 
								+ "&key=" + configEntity.getAccessKey(projectSpace.getProjectName());
				// place the link on the system clipboard
				StringSelection stringSelection = new StringSelection(url);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, stringSelection);
				URLDialog dlg = new URLDialog(Display.getCurrent().getActiveShell(), "The URL has been copied to the clipboard.", url);
				dlg.open();
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		
		Composite c = new Composite(parent, SWT.BORDER);
		GridLayout g = new GridLayout();
		g.numColumns = 3;
		c.setLayout(g);
		data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		c.setLayoutData(data);
		
		Label l = new Label(c, SWT.NONE);
		l.setText("Current bug reporting container:");
		
		bugContainerIdTextField = new Text(c, SWT.BORDER);
		bugContainerIdTextField.setEditable(false);
		bugContainerIdTextField.setLayoutData(data);
	
		final Button btSelectBugContainer = new Button(c, SWT.BORDER);
		btSelectBugContainer.setText("Select bug container");
		btSelectBugContainer.setEnabled(false);
		btSelectBugContainer.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = projectsTableViewer.getTable().getSelectionIndex();
				ProjectSpace projectSpace = (ProjectSpace) projectsTableViewer.getTable().getItem(selectedIndex).getData();
				openDialogWindow(projectSpace);
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		
		projectsTableViewer.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = projectsTableViewer.getTable().getSelectionIndex();
				ProjectSpace projectSpace = (ProjectSpace) projectsTableViewer.getTable().getItem(selectedIndex).getData();
				currentlySelectedProject.setText("Selected project: " + projectSpace.getProjectName());
				btSelectBugContainer.setEnabled(true);
				currentProjectSpace = projectSpace;
				button.setEnabled(true);
				loadSettings();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
	
	/**
	 * @param pSpace
	 */
	private void openDialogWindow(final ProjectSpace pSpace) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				SelectWorkPackageDialog dlg = new SelectWorkPackageDialog(pSpace,
					"Select work package used as bug container");

				if (dlg.open() == Window.OK) {
					// TODO: 
					WorkPackage workPackage = (WorkPackage) dlg.getFirstResult();
					currentBugContainerId = workPackage.getIdentifier();
					bugContainerIdTextField.setText(currentBugContainerId);
				}

			}
		});
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.rap.ui.tabs.ConfigurationTab#getConfigEntity()
	 */
	@Override
	public ConfigEntity getConfigEntity() {
		cfgEntity = new BugReportingConfigEntity(currentProjectSpace);
		cfgEntity.setAssociatedProjectIdentifier(currentProjectSpace.getProjectName());
		cfgEntity.setBugContainerName(currentBugContainerId);
		return cfgEntity;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.rap.ui.tabs.ConfigurationTab#loadSettings()
	 */
	@Override
	public void loadSettings() {

		BugReportingConfigEntity configEntity = new BugReportingConfigEntity(currentProjectSpace);

		ConfigEntity cfgEntity = ConfigEntityStore.loadConigEntity(configEntity, configEntity.eClass());

		if (cfgEntity != null) {
			currentBugContainerId = (String) cfgEntity.getProperties().get(Keys.BUG_CONTAINER);
			bugContainerIdTextField.setText(currentBugContainerId);
		} else {
			bugContainerIdTextField.setText("");
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.rap.config.IActivatedProjectsListener#activatedProjectsChangd(List)
	 */
	public void activatedProjectsChangd(List<ProjectSpace> projectSpaces) {
		projectsTableViewer.setInput(projectSpaces);
	}
	
}

