/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.forms.editor.FormPage;
import org.unicase.metamodel.ModelElement;

/**
 * An abstract class for the MEEditorPages.
 * 
 * @author shterev
 */
public abstract class AbstractMEEditorPage {

	/**
	 * Default init.
	 * 
	 * @param editor the {@link MEEditor}
	 * @param editingDomain the editingDomain
	 * @param modelElement the modelElement
	 * @return FormPage
	 */
	public abstract FormPage createPage(MEEditor editor, EditingDomain editingDomain, ModelElement modelElement);

}