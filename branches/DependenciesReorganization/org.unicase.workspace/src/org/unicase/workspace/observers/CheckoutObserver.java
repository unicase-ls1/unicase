package org.unicase.workspace.observers;

import org.unicase.workspace.ProjectSpace;

public interface CheckoutObserver extends AbstractObserver {

	void checkoutDone(ProjectSpace projectSpace);

}
