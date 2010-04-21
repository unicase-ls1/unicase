/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.spellcheck;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Composite;

/**
 * Spellchecked version of a source viewer.
 * @author jfinis 
 */
public class SpellcheckedSourceViewer extends SourceViewer {

	/**
	 * Default constructor.
	 * 
	 * @param parent parent composite.
	 * @param styles style constants.
	 */
	public SpellcheckedSourceViewer(Composite parent, int styles) {
		super(parent, null, styles);

		//The spellchecking magic lies in the altered text annotaiton model and the
		//text source viewer configuration.
		TextAnnotationModel model = new TextAnnotationModel();
		this.setDocument(new Document(), model);
		configure(new TextSourceViewerConfiguration(this));

		model.setText(getTextWidget());
	}


}
