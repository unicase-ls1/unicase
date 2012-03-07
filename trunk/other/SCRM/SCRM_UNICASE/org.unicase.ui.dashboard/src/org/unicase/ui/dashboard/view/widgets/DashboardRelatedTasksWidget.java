/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.view.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.common.util.ModelElementClassTooltip;
import org.unicase.ui.dashboard.view.DashboardPage;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.ui.util.ModelElementTooltip;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ui.util.URLHelper;
import org.unicase.workspace.ui.util.URLSelectionListener;
import org.unicase.workspace.util.NoCurrentUserException;

/**
 * A dashboard widget displaying an overview of related tasks.
 * 
 * @author Shterev
 */
public class DashboardRelatedTasksWidget extends AbstractDashboardWidget {

	private static final String WIDGET_ID = "DashboardRelatedTaskWidget";
	private ProjectSpace ps;
	private User user;
	private ArrayList<WorkItem> workItems;
	private Set<Group> groups;
	private Set<WorkItem> relatedTasks;

	/**
	 * Default constructor.
	 */
	public DashboardRelatedTasksWidget() {
		super();
		setTitle("Tasks that might be related to you");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDashboard(DashboardPage dashboard) {
		super.setDashboard(dashboard);
		this.ps = dashboard.getProjectSpace();
		relatedTasks = new HashSet<WorkItem>();
		try {
			user = OrgUnitHelper.getUser(ps);
			groups = OrgUnitHelper.getAllGroupsOfOrgUnit(user);
			workItems = new ArrayList<WorkItem>();

			List<WorkItem> allWI = ps.getProject().getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(),
				new BasicEList<WorkItem>());

			for (WorkItem wi : allWI) {
				if (applies(wi)) {
					workItems.add(wi);
				}
			}

			allWI.removeAll(workItems);

		} catch (NoCurrentUserException e) {
			return;
		} catch (CannotMatchUserInProjectException e) {
			return;
		}
	}

	private boolean applies(WorkItem wi) {
		return applies(TaskPackage.eINSTANCE.getWorkItem_Assignee(), wi)
			|| applies(TaskPackage.eINSTANCE.getWorkItem_Participants(), wi)
			|| applies(TaskPackage.eINSTANCE.getWorkItem_Reviewer(), wi);
	}

	@SuppressWarnings("unchecked")
	private boolean applies(EReference reference, WorkItem wi) {
		Object value = wi.eGet(reference);
		if (value == null) {
			return false;
		}
		if (reference.getUpperBound() == -1 && value instanceof List) {
			List<OrgUnit> orgUnits = (List<OrgUnit>) value;
			for (OrgUnit orgUnit : orgUnits) {
				if (applies(orgUnit)) {
					return true;
				}
			}
		} else {
			OrgUnit orgUnit = (OrgUnit) value;
			return applies(orgUnit);
		}
		return false;
	}

	private boolean applies(OrgUnit orgUnit) {
		if (orgUnit instanceof User && orgUnit.equals(user)) {
			return true;
		}
		if (orgUnit instanceof Group && groups.contains(orgUnit)) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createContentPanel() {
		super.createContentPanel();

		Composite panel = getContentPanel();
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).spacing(3, 2).applyTo(panel);

		if (relatedTasks.size() > 0) {
			WorkItem[] items = relatedTasks.toArray(new WorkItem[0]);
			for (int i = 0; i < Math.min(10, relatedTasks.size()); i++) {
				WorkItem wi = items[i];
				ImageHyperlink image = new ImageHyperlink(panel, SWT.TOP);
				image.setImage(getLabelProvider().getImage(wi));
				image.setData(wi.eClass());
				ModelElementClassTooltip.enableFor(image);
				GridDataFactory.fillDefaults().align(SWT.END, SWT.BEGINNING).applyTo(image);
				Link link = new Link(panel, SWT.WRAP | SWT.MULTI);
				link.setData(wi);
				ModelElementTooltip.enableFor(link);
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(URLHelper.getHTMLLinkForModelElement(wi, getDashboard().getProjectSpace(), 20));
				link.setText(stringBuilder.toString());
				link.addSelectionListener(URLSelectionListener.getInstance(getDashboard().getProjectSpace()));
				GridDataFactory.fillDefaults()
					.hint(getComposite().computeSize(SWT.DEFAULT, SWT.DEFAULT).x, SWT.DEFAULT).grab(true, false)
					.applyTo(link);
			}
		} else {
			Label label = new Label(panel, SWT.WRAP);
			label.setText("No related tasks");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getId() {
		return WIDGET_ID;
	}

}
