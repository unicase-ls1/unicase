/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.historybrowserview;

import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.graphics.Image;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ui.views.scm.SCMLabelProvider;

/**
 * Column LabelProvider to show info from the log message, such as commiter, date, etc.
 * 
 * @author shterev
 */
public class LogMessageColumnLabelProvider extends SCMLabelProvider {

	public LogMessageColumnLabelProvider(Project project) {
		super(project);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof TreeNode && !(((TreeNode) element).getValue() instanceof HistoryInfo)) {
			String toolTipText = super.getToolTipText(element);
			return toolTipText;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		return null;
	}

}