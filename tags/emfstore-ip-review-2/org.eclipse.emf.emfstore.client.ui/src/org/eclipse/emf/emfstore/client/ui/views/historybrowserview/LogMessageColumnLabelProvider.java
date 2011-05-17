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
package org.eclipse.emf.emfstore.client.ui.views.historybrowserview;

import org.eclipse.emf.emfstore.client.ui.views.scm.SCMLabelProvider;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.graphics.Image;

/**
 * Column LabelProvider to show info from the log message, such as commiter, date, etc.
 * 
 * @author shterev
 */
public class LogMessageColumnLabelProvider extends SCMLabelProvider {

	/**
	 * Default constructor.
	 * 
	 * @param project the project
	 */
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
