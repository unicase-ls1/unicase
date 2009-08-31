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
public class MEChoicePage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Model Element";
	private static final String PAGE_DESCRIPTION = "Choose the model element which matches the commit.";
	private Button leftButton;
	private Button right;

	protected MEChoicePage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
	}

	/**
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		int result;
		if (leftButton.getSelection() && QuestionnaireManager.getInstance().getLeft()) {
			result = 1;
		} else if (right.getSelection() && !QuestionnaireManager.getInstance().getLeft()) {
			result = 1;
		}
		if (leftButton.getSelection() && !QuestionnaireManager.getInstance().getLeft()) {
			result = 0;
		} else if (right.getSelection() && QuestionnaireManager.getInstance().getLeft()) {
			result = 0;
		} else {
			return;
		}
		QuestionnaireManager.getInstance().addMEResult(result);
	}

	/**
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout();
		int ncol = 4;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		new Label(composite, SWT.NONE).setText("Please choose:");

		leftButton = new Button(composite, SWT.RADIO);
		leftButton.setText("Left");
		leftButton.addListener(SWT.SELECTED, this);

		right = new Button(composite, SWT.RADIO);
		right.setText("Right");
		right.addListener(SWT.SELECTED, this);

		Button noIdea = new Button(composite, SWT.RADIO);
		noIdea.setText("No Idea");
		noIdea.addListener(SWT.SELECTED, this);

		setControl(composite);

	}

}
