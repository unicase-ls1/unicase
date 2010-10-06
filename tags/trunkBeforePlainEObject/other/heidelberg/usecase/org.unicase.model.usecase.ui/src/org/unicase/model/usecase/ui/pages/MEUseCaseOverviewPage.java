package org.unicase.model.usecase.ui.pages;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.forms.editor.FormPage;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.meeditor.AbstractMEEditorPage;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.model.usecase.UseCase;

/**
 * Modified Overview Page for Use Cases (first Tab)
 * 
 * The implementation follows the structure of MEDescriptionPage.java in
 * org.unicase.ui.unicasecommon.meeditor and MEEditorPage.java in org.unicase.ui.meeditor
 * 
 * @author phil
 */


//----------------Deprecated------------------------------------------
// first approach: using standardview instead of modified overview tab

public class MEUseCaseOverviewPage extends AbstractMEEditorPage {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FormPage createPage(MEEditor editor, EditingDomain editingDomain,
			ModelElement modelElement) {
		if (!(modelElement instanceof UseCase)) {
			return null;
		} else {
			
			return null;
		}

	}

}
