/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.sprintstatus;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;

/**
 * @author Shterev
 */

public class SprintStatusLabelProvider extends ColumnLabelProvider {

	/**
	 * Constructor.
	 */
	public SprintStatusLabelProvider() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object object) {
		return super.getImage(null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object object) {
		StringBuilder buffer = new StringBuilder();
		WorkItem wi = (WorkItem) object;
		buffer.append("Name: ");
		buffer.append(wi.getName());
		buffer.append("\n");
		if (wi.getAssignee() != null) {
			buffer.append("Assignee: ");
			buffer.append(wi.getAssignee().getName());
			buffer.append("\n");
		}
		if (!wi.getParticipants().isEmpty()) {
			buffer.append("Tester: ");
			for (OrgUnit p : wi.getParticipants()) {
				buffer.append(p.getName());
				buffer.append(" ");
			}
			buffer.append("\n");
		}
		buffer.append("Priority: ");
		buffer.append(wi.getPriority());
		buffer.append(" ");
		buffer.append("Estimate: ");
		buffer.append(wi.getEstimate());
		buffer.append("\n");
		if (!wi.getPredecessors().isEmpty()) {
			buffer.append("Blocker: ");
			for (WorkItem w : wi.getPredecessors()) {
				buffer.append(w.getName());
				buffer.append(" ");
			}
			buffer.append("\n");
		}
		if (!wi.getAnnotatedModelElements().isEmpty()) {
			buffer.append("Annotating: ");
			for (UnicaseModelElement me : wi.getAnnotatedModelElements()) {
				buffer.append(me.getName());
				buffer.append(" ");
			}
		}
		return buffer.toString();
	}
}
