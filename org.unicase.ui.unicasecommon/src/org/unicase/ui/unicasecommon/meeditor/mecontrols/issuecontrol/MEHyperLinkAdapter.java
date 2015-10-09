package org.unicase.ui.unicasecommon.meeditor.mecontrols.issuecontrol;

/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;

/**
 * A {@link HyperlinkAdapter} to the model elements.
 * 
 * @author helming
 */
public class MEHyperLinkAdapter extends HyperlinkAdapter implements
		IHyperlinkListener {

	private EObject target;

	/**
	 * Default constructor.
	 * 
	 * @param source
	 *            the source of the model link
	 * @param target
	 *            the target of the model link
	 * @param featureName
	 *            the feature of the model link
	 */
	public MEHyperLinkAdapter(EObject target, EObject source, String featureName) {
		super();
		this.target = target;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void linkActivated(HyperlinkEvent event) {
		super.linkActivated(event);
	}
}
