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

import bowling.Tournament;

public class NewPage extends AbstractMEEditorPage {

	private static final String ID = "myID";
	private static final String NAME = "Custom Page";
	public Tournament tournament;

	private ScrolledForm form;
	private Composite composite;
	GridLayout gridLayout = new GridLayout(1, true);
	
	
	public NewPage() {
		super();
	}

	@Override
	public FormPage createPage(MEEditor editor, EditingDomain arg1, EObject arg2) {
		
		if (arg2 instanceof Tournament){
		MEFormPage page = new MEFormPage(editor, ID, NAME) {
			/**
			 * {@inheritDoc}
			 */
			@Override
			protected void createFormContent(IManagedForm managedForm) {
				super.createFormContent(managedForm);

				form = managedForm.getForm();
				form.getBody().setLayout(gridLayout);
				form.setText(getEditor().getTitle() + ": Tournament");
				createWidget();
				form.pack();
			}
		};
		
		page.setParentMEPage(this);
		return page;
		}
		else {
			MEFormPage page = new MEFormPage(editor, ID, NAME) {};
			page.setParentMEPage(this);
			return page;
		}
	}
	
	private void createWidget() {
		if (composite != null) {
			composite.dispose();
		}
		
		composite = new Composite(form.getBody(), SWT.NONE);
		composite.setLayout(gridLayout);
		
		Text text = new Text(composite, SWT.MULTI);
		text.setEditable(false);
//		text.setText("text\ntest");
		if(tournament.getTitle() != null){
			text.setText(tournament.getTitle());
		}
//		else if(tournament.getTitle() != null && tournament.getMatchup() != null){
//			text.setText(tournament.getTitle()+"\n"+ tournament.getMatchup().toString());
//		}
//		else if(tournament.getTitle() != null && tournament.getMatchup() != null && tournament.getPlayerlist() != null){
//			text.setText(tournament.getTitle()+"\n"+ tournament.getMatchup().toString()+"\n"+ tournament.getPlayerlist().toString());
//		}
		else{
			text.setText("No information for this Tournament set!\n Please edit!");
		}
		
//		text.setText(tournament.getTitle()+"\n"+
//					 tournament.getMatchup().toString()+"\n"+
//					 tournament.getPlayerlist().toString());
		
	}

}
