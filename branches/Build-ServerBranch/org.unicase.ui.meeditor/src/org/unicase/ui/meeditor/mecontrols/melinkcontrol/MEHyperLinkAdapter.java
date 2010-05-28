/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * A {@link HyperlinkAdapter} to the model elements.
 * 
 * @author helming
 */
public class MEHyperLinkAdapter extends HyperlinkAdapter implements IHyperlinkListener {

	private ModelElement target;
	private final ModelElement source;
	private final String featureName;

	/**
	 * Default constructor.
	 * 
	 * @param source the source of the model link
	 * @param target the target of the model link
	 * @param featureName the feature of the model link
	 */
	public MEHyperLinkAdapter(ModelElement target, ModelElement source, String featureName) {
		super();
		this.target = target;
		this.source = source;
		this.featureName = featureName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void linkActivated(HyperlinkEvent event) {
		ActionHelper.openModelElement(target, "org.unicase.ui.meeditor");
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
					.getActiveProjectSpace();
				WorkspaceUtil.logTraceEvent(activeProjectSpace, source.getModelElementId(), target.getModelElementId(),
					featureName);
			}
		}.run();
		super.linkActivated(event);
	}
}
