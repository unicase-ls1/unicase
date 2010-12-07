/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.unicase.ecp.model.ModelElementContext;
import org.unicase.ui.common.NotificationManager;
import org.unicase.ui.common.util.ActionHelper;

/**
 * A {@link HyperlinkAdapter} to the model elements.
 * 
 * @author helming
 */
public class MEHyperLinkAdapter extends HyperlinkAdapter implements IHyperlinkListener {

	private EObject target;
	private final EObject source;
	private final String featureName;
	private final ModelElementContext context;

	/**
	 * Default constructor.
	 * 
	 * @param source the source of the model link
	 * @param target the target of the model link
	 * @param featureName the feature of the model link
	 * @param context the {@link ModelElementContext}
	 */
	public MEHyperLinkAdapter(EObject target, EObject source, String featureName, ModelElementContext context) {
		super();
		this.target = target;
		this.source = source;
		this.featureName = featureName;
		this.context = context;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void linkActivated(HyperlinkEvent event) {
		ActionHelper.openModelElement(target, "org.unicase.ui.meeditor", context);
		NotificationManager.getInstance().onTrace(source, target, featureName, "org.unicase.ui.meeditor");

		super.linkActivated(event);
	}
}
