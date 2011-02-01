package org.unicase.bowlingexample.editorcustiomization;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.forms.editor.FormPage;
import org.unicase.ui.meeditor.AbstractMEEditorPage;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.MEFormPage;

public class EmptyPage extends AbstractMEEditorPage {

	private static final String ID = "myID";
	private static final String NAME = "Custom Page";

	public EmptyPage() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public FormPage createPage(MEEditor editor, EditingDomain arg1, EObject arg2) {
		MEFormPage page = new MEFormPage(editor, ID, NAME) {
			
		};
		page.setParentMEPage(this);
		return page;
	}

}
