/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.MEEditorInput;

/**
 * A {@link HyperlinkAdapter} to the model elements.
 * 
 * @author helming
 */
public class MEHyperLinkAdapter extends HyperlinkAdapter implements
		IHyperlinkListener {

	private ModelElement me;

	/**
	 * Default constructor.
	 * 
	 * @param me
	 *            the model element
	 */
	public MEHyperLinkAdapter(ModelElement me) {
		super();
		this.me = me;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void linkActivated(HyperlinkEvent event) {
		MEEditorInput input = new MEEditorInput(me);
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().openEditor(input,
							"org.unicase.ui.meeditor", true);
		} catch (PartInitException e) {
			// JH Auto-generated catch block
			e.printStackTrace();
		}
		super.linkActivated(event);
	}

}
