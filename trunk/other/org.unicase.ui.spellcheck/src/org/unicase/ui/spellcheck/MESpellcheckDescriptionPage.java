/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.spellcheck;

import org.unicase.ui.spellcheck.controls.MESpellcheckRichTextControl;
import org.unicase.ui.unicasecommon.meeditor.MEDescriptionPage;
/**
 * The editor page for the description feature.
 * 
 * @author shterev
 */
public class MESpellcheckDescriptionPage extends MEDescriptionPage {

	private static final String ID = "org.unicase.ui.unicasecommon.meeditor.descriptionpage";
	private static final String NAME = "Description";

	public MESpellcheckDescriptionPage(){
		super(new MESpellcheckRichTextControl());		
	}
}