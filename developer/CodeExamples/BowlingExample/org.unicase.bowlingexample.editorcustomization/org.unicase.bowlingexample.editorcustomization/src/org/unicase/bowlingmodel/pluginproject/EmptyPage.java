package org.unicase.bowlingmodel.pluginproject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.forms.editor.FormPage;
import org.unicase.ui.meeditor.AbstractMEEditorPage;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.MEEditorPage;
import org.unicase.ui.meeditor.MEFormPage;

public class EmptyPage extends AbstractMEEditorPage{

	private static final String ID = "myID";
	private static final String Name = "Custom page";
	
	public EmptyPage(){
		
	}
	
	@Override
	public FormPage createPage(MEEditor editor, EditingDomain editingDomain,
			EObject modelElement) {
		// TODO Auto-generated method stub
		MEFormPage page = new MEFormPage(editor, ID, Name){
			
		};
		page.setParentMEPage(this);
		return page;
	}

	
}
