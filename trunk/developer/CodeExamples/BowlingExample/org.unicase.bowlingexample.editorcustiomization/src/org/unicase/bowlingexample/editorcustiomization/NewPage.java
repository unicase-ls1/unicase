package org.unicase.bowlingexample.editorcustiomization;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.unicase.ui.meeditor.AbstractMEEditorPage;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.MEFormPage;

public class NewPage extends AbstractMEEditorPage {

	private static final String ID = "myID";
	private static final String NAME = "Custom Page";

	private ScrolledForm form;
	private Composite composite;
	GridLayout gridLayout = new GridLayout(1, true);

	public NewPage() {
		super();
	}

	@Override
	public FormPage createPage(MEEditor editor, EditingDomain arg1, EObject arg2) {
		MEFormPage page = new MEFormPage(editor, ID, NAME) {
			/**
			 * {@inheritDoc}
			 */
			@Override
			protected void createFormContent(IManagedForm managedForm) {
				super.createFormContent(managedForm);

				form = managedForm.getForm();
				form.getBody().setLayout(gridLayout);
				form.setText(getEditor().getTitle() + ": Hello World");
				createWidget();
				form.pack();
			}
		};
		page.setParentMEPage(this);
		return page;
	}
	
	private void createWidget() {
		if (composite != null) {
			composite.dispose();
		}
		composite = new Composite(form.getBody(), SWT.NONE);
		composite.setLayout(gridLayout);
		
		Text text = new Text(composite, SWT.BORDER);
		text.setEditable(false);
		text.setText("Hello World Hello World Hello World.");
	}

}
