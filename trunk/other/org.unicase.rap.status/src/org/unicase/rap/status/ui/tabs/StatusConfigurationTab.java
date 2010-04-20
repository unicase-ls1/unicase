/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.status.ui.tabs;

import java.util.List;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.rap.config.ActivatedProjectsCache;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.IActivatedProjectsListener;
import org.unicase.rap.status.config.StatusConfigEntity;
import org.unicase.rap.ui.tabs.ConfigurationTab;
import org.unicase.rap.ui.viewers.ProjectsTableViewer;
import org.unicase.workspace.ProjectSpace;

import config.ConfigEntity;

/**
 * Status configuration tab.
 * 
 * @author Edgar Müller.
 */
public class StatusConfigurationTab extends ConfigurationTab implements IActivatedProjectsListener {

	/**
	 * The table viewer for projects.
	 */
	private ProjectsTableViewer projectsTableViewer;
	
	/**
	 * The configuration entity used by the configuration tab.
	 */
	private StatusConfigEntity cfgEntity;
	
	private Text crypticElementTextfield;
	
	private Button teamListVisisbleCheckBox;
	
	private Button workItemsVisibleCheckBox;
	

	/**
	 * The currently selected project space.
	 */
	private ProjectSpace currentProjectSpace;
	
	
	/**
	 * Initializes a new instance of the WorkTeamItemsConfigurationTab class.
	 */
	public StatusConfigurationTab() {
		
	}
	
	/**
	 * 
	 */
	public void setFocus() {
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createConfigurationTab(Composite parent) {
		
		// TODO
//		getSite().setSelectionProvider(projectsTableViewer);
//		Composite top = new Composite(parent, SWT.BORDER);
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
	    tableComposite.setLayoutData(data);
	    projectsTableViewer.setInput(ActivatedProjectsCache.getInstance().getProjects());
		ActivatedProjectsCache.getInstance().addListener(this);

		projectsTableViewer.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				ProjectSpace pSpace = (ProjectSpace) e.item.getData();
				currentProjectSpace = pSpace;
				loadSettings();
			}
			
			public void widgetDefaultSelected(SelectionEvent e) { }
		});
		
		// setup bold font
		Font boldFont = JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);
		
		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
	
		Composite c = new Composite(parent, SWT.BORDER);
		GridLayout g = new GridLayout();
		g.numColumns = 2;
		c.setLayoutData(data);
		c.setLayout(g);
		
		Label l = new Label(c, SWT.WRAP);
		l.setText("Cryptic element:");
		l.setFont(boldFont);
		crypticElementTextfield = new Text(c, SWT.BORDER);
		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		crypticElementTextfield.setLayoutData(data);
		
		l = new Label(c, SWT.WRAP);
		l.setText("Team list visible:");
		l.setFont(boldFont);
		teamListVisisbleCheckBox = new Button(c, SWT.CHECK); 
		
		l = new Label(c, SWT.WRAP);
		l.setText("Work item list visible:");
		l.setFont(boldFont);
		workItemsVisibleCheckBox = new Button(c, SWT.CHECK); 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConfigEntity getConfigEntity() {
		cfgEntity = new StatusConfigEntity(currentProjectSpace);
		cfgEntity.setAssociatedProjectIdentifier(currentProjectSpace.getProjectName());
		cfgEntity.setCrypticElement(crypticElementTextfield.getText());
		cfgEntity.setTeamListVisible(teamListVisisbleCheckBox.getSelection());
		cfgEntity.setWorkItemsVisible(workItemsVisibleCheckBox.getSelection());

		return cfgEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void loadSettings() {
		
		StatusConfigEntity configEntity = new StatusConfigEntity(currentProjectSpace);
		
		ConfigEntity cfgEntity = ConfigEntityStore.loadConigEntity(
				configEntity, configEntity.eClass());
		
		// TODO: eliminate code redundancy
		if (cfgEntity != null) {
			String crypticElement = (String) cfgEntity.getProperties().get(StatusConfigEntity.Keys.CRYPTIC_ELEMENT_KEY);
			Boolean teamListVisible = (Boolean) cfgEntity.getProperties().get(StatusConfigEntity.Keys.TEAMLIST_KEY);
			Boolean workItemsVisible = (Boolean) cfgEntity.getProperties().get(StatusConfigEntity.Keys.WORKITEMLIST_KEY);
			teamListVisisbleCheckBox.setSelection(teamListVisible);
			workItemsVisibleCheckBox.setSelection(workItemsVisible);
			crypticElementTextfield.setText(crypticElement);
		} else {
			teamListVisisbleCheckBox.setSelection(false);
			workItemsVisibleCheckBox.setSelection(false);
			crypticElementTextfield.setText("");
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void activatedProjectsChangd(List<ProjectSpace> projectSpaces) {
		projectsTableViewer.setInput(projectSpaces);
	}
	
}

