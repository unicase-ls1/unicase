package org.unicase.ui.taskview;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkItem;

/**
 * In addition to the EClass attribute of its superclass
 * {@link EClassFilterItemProvider}, this class uses a specific instance of
 * {@link User} to determine which items to provide or not to provide.
 * 
 * @author Florian Schneider
 * 
 */
public class UserAndEClassFilterItemProvider extends EClassFilterItemProvider {

	private User owner;

	public UserAndEClassFilterItemProvider(AdapterFactory adapterFactory,
			EClass itemClass, User user) {
		super(adapterFactory, itemClass);
		this.owner = user;
	}

	@Override
	protected boolean permitsObject(Object objectToTest) {
		if (super.permitsObject(objectToTest)) {
			OrgUnit unit = null;
			if (objectToTest instanceof WorkItem) {
				unit = ((WorkItem) objectToTest).getAssignee();
			} else if (objectToTest instanceof ActionItem) {
				unit = ((ActionItem) objectToTest).getAssignedTo().get(0);
			} else {
				return false;
			}
			if (unit instanceof User) {
				return unit.equals(owner);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
