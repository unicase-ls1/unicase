/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.wizards;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.changetracking.release.ReleaseBuildingSettings;
import org.unicase.changetracking.ui.dialogs.IDialogHead;
import org.unicase.changetracking.vcs.INameValidator;
import org.unicase.changetracking.vcs.IVCSAdapter;
import org.unicase.model.changetracking.Release;
import org.unicase.model.changetracking.RepositoryLocation;

/**
 * Second page of the build release wizard in which settings for the build can
 * be chosen.
 * 
 * Currently, only the name of the tag to be created for the release can be
 * chosen.
 * 
 * @author jfinis
 * 
 */
public class BuildSettingsPage extends WizardPage implements IDialogHead {

	private static final String TAG_NAME_LABEL_TEXT = "Tag name for the built revision:";
	private static final String DEFAULT_PAGE_MESSAGE = "Choose build settings.";
	private static final String UPLOAD_BUTTON_TEXT = "Upload result directly to remote repository";
	private static final String UPLOAD_BUTTON_TOOLTIP = "If checked, the resulting commit, tag and all modified branches will directly be committed to the remote repository. If you want to review the result before committing it, leave unchecked. Then, you have to perform the commit manually afterwards.";
	private Release release;
	private Text tagNameText;
	private Button wantUploadButton;
	private INameValidator validator;
	private RepositoryLocation repoLoc;

	/**
	 * Default constructor.
	 * 
	 * @param pageName page name
	 * @param title page title
	 * @param titleImage title image
	 * @param release release to be built
	 * @param vcs VCS adapter to be used
	 * @param repoLoc repository location of the remote repository on which the
	 *            release code lies
	 */
	protected BuildSettingsPage(String pageName, String title, ImageDescriptor titleImage, Release release, IVCSAdapter vcs, RepositoryLocation repoLoc) {
		super(pageName, title, titleImage);
		this.release = release;
		validator = vcs.getNameValidator();
		this.repoLoc = repoLoc;
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		Composite c = new Composite(parent, SWT.NONE);
		GridDataFactory.swtDefaults().grab(true, true).align(SWT.CENTER, SWT.CENTER).applyTo(c);
		GridDataFactory leftGridFactory = GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER);
		GridDataFactory rightGridFactory = GridDataFactory.swtDefaults().grab(true, false).align(SWT.LEFT, SWT.CENTER);

		GridLayoutFactory.swtDefaults().margins(20, 20).numColumns(2).spacing(20, 40).applyTo(c);

		setMessage(DEFAULT_PAGE_MESSAGE, INFORMATION);

		Label textLabel = new Label(c, SWT.NONE);
		textLabel.setText(TAG_NAME_LABEL_TEXT);
		rightGridFactory.applyTo(textLabel);

		tagNameText = new Text(c, SWT.SINGLE);
		tagNameText.setText(validator.cleanName(release.getName()));
		tagNameText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				refreshStatus();
			}
		});
		leftGridFactory.applyTo(tagNameText);
		
		wantUploadButton = new Button(c, SWT.CHECK);
		wantUploadButton.setText(UPLOAD_BUTTON_TEXT);
		wantUploadButton.setToolTipText(UPLOAD_BUTTON_TOOLTIP);
		GridDataFactory.swtDefaults().grab(true, false).span(2, 1).align(SWT.LEFT, SWT.CENTER).applyTo(wantUploadButton);

		refreshStatus();
		setControl(c);
	}

	private void refreshStatus() {
		String error = validator.isNewTagNameValid(tagNameText.getText(), repoLoc);
		setErrorMessage(error);
		if (error != null) {
			((BuildReleaseWizard) getWizard()).setFinishable(false);
		} else {
			((BuildReleaseWizard) getWizard()).setFinishable(true);
		}
	}

	/**
	 * Returns the chosen tag name.
	 * 
	 * @return tag name
	 */
	public String getTagName() {
		return tagNameText.getText();
	}

	public ReleaseBuildingSettings getSettings() {
		return new ReleaseBuildingSettings(tagNameText.getText(), wantUploadButton.getSelection());
	}

}
