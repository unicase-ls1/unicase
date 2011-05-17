/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.releases;


import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.vcs.NameValidator;
import org.unicase.changetracking.vcs.VCSAdapter;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.RepositoryLocation;

public class BuildSettingsPage extends WizardPage implements IDialogHead{

	private ChangeTrackingRelease release;
	private ReleaseCheckReport report;
	private Text tagNameText;
	private NameValidator validator;
	private RepositoryLocation repoLoc;

	protected BuildSettingsPage(String pageName, String title,
			ImageDescriptor titleImage, ChangeTrackingRelease release, ReleaseCheckReport report, VCSAdapter vcs, RepositoryLocation repoLoc) {
		super(pageName, title, titleImage);
		this.release = release;
		this.report = report;
		validator = vcs.getNameValidator();
		this.repoLoc = repoLoc;
	}

	public void createControl(Composite parent) {
		Composite c = new Composite(parent, SWT.NONE);
		GridDataFactory.swtDefaults().grab(true, true).applyTo(c);
		GridDataFactory leftGridFactory = GridDataFactory.swtDefaults().grab(true, false).align(SWT.RIGHT, SWT.CENTER);
		GridDataFactory rightGridFactory = GridDataFactory.swtDefaults().grab(true, false).align(SWT.LEFT, SWT.CENTER);
		
		GridLayoutFactory.swtDefaults().margins(20, 20).numColumns(2).applyTo(c);
		
		
		setMessage("Choose a name for the tag to be created.", INFORMATION);
		
		Label textLabel = new Label(c, SWT.NONE);
		textLabel.setText("Tag name:");
		leftGridFactory.applyTo(textLabel);
		
		tagNameText = new Text(c, SWT.SINGLE);
		tagNameText.setText(validator.cleanName(release.getName()));
		tagNameText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				refreshStatus();
			}
		});
		rightGridFactory.applyTo(tagNameText);
		
		
		refreshStatus();
		setControl(c);
	}


	private void refreshStatus() {
		String error = validator.isNewTagNameValid(tagNameText.getText(), repoLoc);
		setErrorMessage(error);
		if(error != null){
			((BuildReleaseWizard) getWizard()).setFinishable(false);
		} else {
			((BuildReleaseWizard) getWizard()).setFinishable(true);
		}
	}

	public String getTagName() {
		return tagNameText.getText();
	}

}
