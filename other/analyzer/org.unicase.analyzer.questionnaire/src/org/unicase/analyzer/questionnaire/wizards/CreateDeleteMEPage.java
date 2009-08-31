/**
 * 
 */
package org.unicase.analyzer.questionnaire.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

/**
 * @author liya
 */
public class CreateDeleteMEPage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Create Delete Model Element";
	private static final String PAGE_DESCRIPTION = "Choose the activity of this Model Element which matches the commit.";
	private Button createButton;
	private Button deleteButton;
	private Button noThingButton;
	private Button noIdea;
	private int index;

	protected CreateDeleteMEPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		index = 0;
	}

	/**
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		QuestionnaireManager questionnaireManager = QuestionnaireManager.getInstance();
		if (createButton.getSelection()
			|| questionnaireManager.getCreatedDeletedTruth().get(index) == QuestionnaireManager.CREATED) {
			questionnaireManager.setCreateDeleteResult(1);
		} else if (createButton.getSelection()
			|| questionnaireManager.getCreatedDeletedTruth().get(index) != QuestionnaireManager.CREATED) {
			questionnaireManager.setCreateDeleteResult(0);
		} else if (deleteButton.getSelection()
			|| questionnaireManager.getCreatedDeletedTruth().get(index) == QuestionnaireManager.DELETED) {
			questionnaireManager.setCreateDeleteResult(1);
		} else if (deleteButton.getSelection()
			|| questionnaireManager.getCreatedDeletedTruth().get(index) != QuestionnaireManager.DELETED) {
			questionnaireManager.setCreateDeleteResult(0);
		} else if (noThingButton.getSelection()
			|| questionnaireManager.getCreatedDeletedTruth().get(index) == QuestionnaireManager.NONE) {
			questionnaireManager.setCreateDeleteResult(1);
		} else if (noThingButton.getSelection()
			|| questionnaireManager.getCreatedDeletedTruth().get(index) != QuestionnaireManager.NONE) {
			questionnaireManager.setCreateDeleteResult(0);
		} else {
			questionnaireManager.setCreateDeleteResult(-1);
		}
	}

	/**
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {

		QuestionnaireManager questionnaireManager = QuestionnaireManager.getInstance();
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout();
		int ncol = 4;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		new Label(composite, SWT.NONE).setText("What happened to"
			+ questionnaireManager.getCreatedDeleteMENames().get(index) + "?");

		createButton = new Button(composite, SWT.RADIO);
		createButton.setText("Created");
		createButton.addListener(SWT.Selection, this);

		deleteButton = new Button(composite, SWT.RADIO);
		deleteButton.setText("Deleted");
		deleteButton.addListener(SWT.Selection, this);

		noThingButton = new Button(composite, SWT.RADIO);
		noThingButton.setText("Neither");
		noThingButton.addListener(SWT.Selection, this);

		noIdea = new Button(composite, SWT.RADIO);
		noIdea.setText("No Idea");
		noIdea.addListener(SWT.Selection, this);

		setControl(composite);

	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

}
