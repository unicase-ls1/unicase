package org.unicase.ui.stem.views.statusview;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.TaxonomyAccess;
import org.unicase.ui.common.exceptions.DialogHandler;

/**
 * This is the label provider for status column on user tab of status view.
 * 
 * @author Hodaie
 */
public class UserTabStatusColumnLabelProvider extends ColumnLabelProvider {

	private ModelElement currentOpenME;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof ModelElement) {
			ModelElement me = (ModelElement) element;
			String status = MEState.CLOSED;
			try {

				if (me instanceof OrgUnit) {
					status = getStatus((OrgUnit) me);
				} else {
					status = me.getMEState().getStatus();
				}

			} catch (CircularDependencyException e) {
				DialogHandler.showExceptionDialog(e);
			}

			String path = "icons/closed.gif";
			if (status.equals(MEState.OPEN)) {
				path = "icons/open.gif";
			}
			if (status.equals(MEState.BLOCKED)) {
				path = "icons/blocked.gif";
			}
			URL url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"), new Path(path), null);
			ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
			return imageDescriptor.createImage();

		}
		return null;
	}

	private String getStatus(OrgUnit assignee) {

		for (WorkItem workItem : getWorkItems(assignee)) {

			if (workItem.getState() == MEState.BLOCKED) {
				return MEState.BLOCKED;
			}
		}
		for (WorkItem workItem : getWorkItems(assignee)) {

			if (workItem.getState() == MEState.OPEN) {
				return MEState.OPEN;
			}
		}

		return MEState.CLOSED;
	}

	/**
	 * This goes through openers hierarchy and gathers all Assignables assigned to this Assignee. I think it would be
	 * more convenient to change the model, so that any OrgUnit maintains a list of all its assigned tasks.
	 * 
	 * @param assignee OrgUnit assignee
	 * @return
	 */
	private List<WorkItem> getWorkItems(OrgUnit assignee) {

		List<WorkItem> workItems = new ArrayList<WorkItem>();
		// then check its openers (hierarchical)
		Set<ModelElement> openers = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getLeafOpeners(currentOpenME);
		for (ModelElement opener : openers) {
			if (opener instanceof WorkItem) {
				OrgUnit assignee2 = ((WorkItem) opener).getAssignee();
				if (assignee2 != null && assignee.equals(assignee2)) {
					workItems.add((WorkItem) opener);
				}
			}
		}
		return workItems;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		return "";

	}

	/**
	 * This keeps track of model element currently open in status view. This is used to extract work items each user has
	 * relating this currently model element.
	 * 
	 * @param me Model element that is currently open in status view.
	 */
	public void setCurrentOpenME(ModelElement me) {
		this.currentOpenME = me;
	}

}
