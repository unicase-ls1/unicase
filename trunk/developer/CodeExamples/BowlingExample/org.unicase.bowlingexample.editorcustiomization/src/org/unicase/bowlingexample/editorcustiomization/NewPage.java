package org.unicase.bowlingexample.editorcustiomization;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.unicase.ui.meeditor.AbstractMEEditorPage;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.MEFormPage;

import bowling.Tournament;

//import org.unicase.ui.meeditor.multiattribute.StringAttributeControl;

public class NewPage extends AbstractMEEditorPage {

	private static final String ID = "myID";
	private static final String NAME = "Custom Page";
	private Tournament tournament;

	private ScrolledForm form;
	private Composite composite;
	Text text;
	GridLayout gridLayout = new GridLayout(1, true);
	
	public NewPage() {
		super();
	}

	@Override
	public FormPage createPage(MEEditor editor, EditingDomain arg1, EObject arg2) {
		
		//create special page for tournament otherwise create empty page
		if (arg2 instanceof Tournament){
			tournament = (Tournament) arg2;
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
			//empty page
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
		text = new Text(composite, SWT.MULTI);
		text.setEditable(false);
		
		rebuildText();
		
	}

	//Summary of the tournament printed on the second page. Tournament title, type, all matchups, and title of playerlist 
	private void rebuildText() {
		try{
		String description = "";
		
		if (tournament.getTitle() == null){
			text.setText("No information for this Tournament set!\nPlease edit!");
		}
		else {
		if(tournament.getTitle() != null){
			description = "Title: " + tournament.getTitle() + "\nType: " + tournament.getType() + "\n";
			text.setText(description);
		}
		if(tournament.getMatchup() != null){
			for (int i = 0; i <= tournament.getMatchup().size()-1; i++ ){
			description += "\nMatchup " + (i+1) + ": " + tournament.getMatchup().get(i).getGames().get(0).getPlayer().getLastname()+ 
			" vs. " + tournament.getMatchup().get(i).getGames().get(1).getPlayer().getLastname();
			}
			text.setText(description);
			
		}
		if(tournament.getPlayerlist() != null){
			description += "\n\nPlayerlist: "+ tournament.getPlayerlist().getName();
			text.setText(description);
		}
		
		}
		}catch(Exception e){
			//catching exception that is thrown if a matchup only contains one game and opening
			//a window that asks the user to complete all matchups before using the page 
			Thread messageThread = new Thread("Message"){
				public void run(){
			
			final Display display = new Display();
			Shell shell = new Shell(display);
			MessageBox ms = new MessageBox(shell, SWT.ICON_ERROR);
			ms.setText("Sorry!");
			ms.setMessage("Please set up all the Matchups with two Games!");
			ms.open();
			display.dispose();
			
				}
			
			};
			messageThread.start();
			
		}
	}
}
