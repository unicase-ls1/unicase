/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.unicase.ui.common.preferences.UnicasePreferenceConstants;
import org.unicase.ui.iterationplanner.Activator;

public class AssigneeRecommenderPreferencesPage extends PreferencePage implements IWorkbenchPreferencePage {

	private Button btnEnableRecommendation;
	private Group grpAssigneeRecommendation;
	private Button rdSimpleRecommender;
	private Button rdMlRecommender;
	private Group grpMlRecommender;
	private Label lblClassifier;
	private Combo cmbCalssifier;

	public AssigneeRecommenderPreferencesPage() {}

	public AssigneeRecommenderPreferencesPage(String title) {
		super(title);
	}

	public AssigneeRecommenderPreferencesPage(String title, ImageDescriptor image) {
		super(title, image);
	}

	@Override
	protected Control createContents(Composite parent) {
		parent.setLayout(new GridLayout());
		Composite content = new Composite(parent, SWT.NONE);
		content.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		content.setLayout(new GridLayout());

		btnEnableRecommendation = new Button(content, SWT.CHECK);
		btnEnableRecommendation.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnEnableRecommendation.setText("Enable assignee recommendation");

		grpAssigneeRecommendation = new Group(content, SWT.NONE);
		grpAssigneeRecommendation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		grpAssigneeRecommendation.setLayout(new GridLayout(1, false));
		grpAssigneeRecommendation.setText("Assignee Recommendation");

		rdSimpleRecommender = new Button(grpAssigneeRecommendation, SWT.RADIO);
		rdSimpleRecommender.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		rdSimpleRecommender.setText("Use simple assignee recommender");

		rdMlRecommender = new Button(grpAssigneeRecommendation, SWT.RADIO);
		rdMlRecommender.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		rdMlRecommender.setText("Use machine learning assignee recommender");
		rdMlRecommender.setEnabled(false);

		grpMlRecommender = new Group(grpAssigneeRecommendation, SWT.NONE);
		grpMlRecommender.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		grpMlRecommender.setLayout(new GridLayout(2, false));
		grpMlRecommender.setText("Machine learning recommender");

		lblClassifier = new Label(grpMlRecommender, SWT.NONE);
		lblClassifier.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 2, 1));
		lblClassifier.setText("Select Calssifier:");

		cmbCalssifier = new Combo(grpMlRecommender, SWT.DROP_DOWN);
		GridData layoutData = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
		layoutData.widthHint = 200;
		cmbCalssifier.setLayoutData(layoutData);
		cmbCalssifier.setItems(new String[] { "SVM", "LibLinear" });

		Button btnTrainClassifier = new Button(grpMlRecommender, SWT.PUSH);
		btnTrainClassifier.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnTrainClassifier.setText("Train Classifier");

		Label lblNote = new Label(grpMlRecommender, SWT.WRAP);
		GridData gridData = new GridData(SWT.BEGINNING, SWT.FILL, false, true, 2, 1);
		gridData.widthHint = 300;
		lblNote.setLayoutData(gridData);
		lblNote
			.setText("Note: Based on the selected Classifier, and project size it may take multiple hours to train the classifier.");

		// rdMlRecommender.addSelectionListener(new SelectionListener() {
		// public void widgetSelected(SelectionEvent e) {
		// boolean enabled = rdMlRecommender.getSelection();
		// grpMlRecommender.setEnabled(enabled);
		// for (int i = 0; i < grpMlRecommender.getChildren().length; i++) {
		// grpMlRecommender.getChildren()[i].setEnabled(enabled);
		// }
		// }
		//
		// public void widgetDefaultSelected(SelectionEvent e) {}
		// });

		btnEnableRecommendation.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				boolean enabled = btnEnableRecommendation.getSelection();
				grpAssigneeRecommendation.setEnabled(enabled);
				for (int i = 0; i < grpAssigneeRecommendation.getChildren().length; i++) {
					grpAssigneeRecommendation.getChildren()[i].setEnabled(enabled);
					rdMlRecommender.setEnabled(false);
				}
				// grpMlRecommender.setEnabled(enabled && rdMlRecommender.getSelection());
				// for (int i = 0; i < grpMlRecommender.getChildren().length; i++) {
				// grpMlRecommender.getChildren()[i].setEnabled(enabled && rdMlRecommender.getSelection());
				// }
			}

			public void widgetDefaultSelected(SelectionEvent e) {}
		});

		btnEnableRecommendation.setSelection(false);
		grpAssigneeRecommendation.setEnabled(false);
		for (int i = 0; i < grpAssigneeRecommendation.getChildren().length; i++) {
			grpAssigneeRecommendation.getChildren()[i].setEnabled(false);
		}
		grpMlRecommender.setEnabled(false);
		for (int i = 0; i < grpMlRecommender.getChildren().length; i++) {
			grpMlRecommender.getChildren()[i].setEnabled(false);
		}

		initializeValues();

		return content;
	}

	private void initializeValues() {
		boolean enableAssigneeRecommendation = org.unicase.ui.common.Activator.getDefault().getPreferenceStore()
			.getBoolean(UnicasePreferenceConstants.ENABLE_ASSIGNEE_RECOMMENDATION);
		btnEnableRecommendation.setSelection(enableAssigneeRecommendation);
		if (!enableAssigneeRecommendation) {
			grpAssigneeRecommendation.setEnabled(false);
			for (int i = 0; i < grpAssigneeRecommendation.getChildren().length; i++) {
				grpAssigneeRecommendation.getChildren()[i].setEnabled(false);
			}
			grpMlRecommender.setEnabled(false);
			for (int i = 0; i < grpMlRecommender.getChildren().length; i++) {
				grpMlRecommender.getChildren()[i].setEnabled(false);
			}
		} else {
			grpAssigneeRecommendation.setEnabled(true);
			for (int i = 0; i < grpAssigneeRecommendation.getChildren().length; i++) {
				grpAssigneeRecommendation.getChildren()[i].setEnabled(true);
				rdMlRecommender.setEnabled(false);
			}
			// grpMlRecommender.setEnabled(true && rdMlRecommender.getSelection());
			// for (int i = 0; i < grpMlRecommender.getChildren().length; i++) {
			// grpMlRecommender.getChildren()[i].setEnabled(true && rdMlRecommender.getSelection());
			// }
		}

		boolean useSimpleRecommender = getPreferenceStore().getBoolean(
			AssigneeRecommendationPreferenceConstants.USE_SIMPLE_ASSIGNEE_RECOMMENDER);
		rdSimpleRecommender.setSelection(useSimpleRecommender);

		boolean useMLRecommender = getPreferenceStore().getBoolean(
			AssigneeRecommendationPreferenceConstants.USE_ML_ASSIGNEE_RECOMMENDER);
		useMLRecommender = false;
		rdMlRecommender.setSelection(useMLRecommender);
		if (!useMLRecommender) {
			grpMlRecommender.setEnabled(false);
			for (int i = 0; i < grpMlRecommender.getChildren().length; i++) {
				grpMlRecommender.getChildren()[i].setEnabled(false);
			}
		} else {
			// grpMlRecommender.setEnabled(true && enableAssigneeRecommendation);
			// for (int i = 0; i < grpMlRecommender.getChildren().length; i++) {
			// grpMlRecommender.getChildren()[i].setEnabled(true && enableAssigneeRecommendation);
			// }
		}
		String classifier = getPreferenceStore().getString(AssigneeRecommendationPreferenceConstants.ML_CLASSIFIER);
		cmbCalssifier.select(cmbCalssifier.indexOf(classifier));

	}

	public void initDefaults() {
		org.unicase.ui.common.Activator.getDefault().getPreferenceStore().setDefault(
			UnicasePreferenceConstants.ENABLE_ASSIGNEE_RECOMMENDATION, false);
		getPreferenceStore()
			.setDefault(AssigneeRecommendationPreferenceConstants.USE_SIMPLE_ASSIGNEE_RECOMMENDER, true);
		getPreferenceStore().setDefault(AssigneeRecommendationPreferenceConstants.USE_ML_ASSIGNEE_RECOMMENDER, false);
		getPreferenceStore().setDefault(AssigneeRecommendationPreferenceConstants.ML_CLASSIFIER, "SVM");
	}

	@Override
	protected void performDefaults() {
		initializeDefaultValuesOnPage();
		super.performDefaults();
	}

	/**
	 * 
	 */
	private void initializeDefaultValuesOnPage() {
		btnEnableRecommendation.setSelection(false);
		grpAssigneeRecommendation.setEnabled(false);
		for (int i = 0; i < grpAssigneeRecommendation.getChildren().length; i++) {
			grpAssigneeRecommendation.getChildren()[i].setEnabled(false);
		}

		rdSimpleRecommender.setSelection(true);

		rdMlRecommender.setSelection(false);

		grpMlRecommender.setEnabled(false);
		for (int i = 0; i < grpMlRecommender.getChildren().length; i++) {
			grpMlRecommender.getChildren()[i].setEnabled(false);
		}

	}

	@Override
	public boolean performOk() {
		saveValues();
		return super.performOk();
	}

	/**
	 * 
	 */
	private void saveValues() {
		org.unicase.ui.common.Activator.getDefault().getPreferenceStore().setValue(
			UnicasePreferenceConstants.ENABLE_ASSIGNEE_RECOMMENDATION, btnEnableRecommendation.getSelection());
		getPreferenceStore().setValue(AssigneeRecommendationPreferenceConstants.USE_SIMPLE_ASSIGNEE_RECOMMENDER,
			rdSimpleRecommender.getSelection());
		getPreferenceStore().setValue(AssigneeRecommendationPreferenceConstants.USE_ML_ASSIGNEE_RECOMMENDER,
			rdMlRecommender.getSelection());
		getPreferenceStore().setValue(AssigneeRecommendationPreferenceConstants.ML_CLASSIFIER, cmbCalssifier.getText());
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		initDefaults();
	}

}
