/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;

/**
 * @author Shterev
 */

public class WorkPackageTabLabelProvider extends ColumnLabelProvider implements IColorProvider {

	/**
	 * Constructor.
	 */
	public WorkPackageTabLabelProvider() {
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
	 * {@inheritDoc} [19:03:20] … name [19:03:31] … priorität [19:03:45] … die einzelnen kategorien nach priorität
	 * sortieren [19:04:00] … assignee [19:04:06] … partcipant [19:04:14] … den participant tester nennen [19:04:44] …
	 * checked [19:05:47] … predeccessor [19:06:00] … den predecessor als blocker anzeigen [19:06:17] … wenn die
	 * atribute nicht belegt sind dann nichts anzeigen [19:06:43] … estimate
	 */
	@Override
	public String getText(Object object) {
		StringBuilder buffer = new StringBuilder();
		WorkItem wi = (WorkItem) object;
		buffer.append("Name: ");
		buffer.append(wi.getName());
		buffer.append("\n");
		buffer.append("Assignee: ");
		buffer.append(wi.getAssignee().getName());
		buffer.append("\n");
		buffer.append("Tester: ");
		for (OrgUnit p : wi.getParticipants()) {
			buffer.append(p.getName());
			buffer.append(" ");
		}
		buffer.append("\n");
		buffer.append("Done: ");
		buffer.append((((Checkable) wi).isChecked() ? "Yes" : "No"));
		buffer.append("\n");
		buffer.append("Blocker: ");
		for (WorkItem w : wi.getPredecessors()) {
			buffer.append(w.getName());
			buffer.append(" ");
		}
		buffer.append("\n");
		buffer.append("Estimate: ");
		buffer.append(wi.getEstimate());
		buffer.append("\n");
		buffer.append("Annotating: ");
		for (ModelElement me : wi.getAnnotatedModelElements()) {
			buffer.append(me.getName());
			buffer.append(" ");
		}
		return buffer.toString();
	}

}
