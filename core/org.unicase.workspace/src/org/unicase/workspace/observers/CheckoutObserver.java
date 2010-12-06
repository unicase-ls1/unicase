package org.unicase.workspace.observers;

import org.unicase.util.observer.IObserver;
import org.unicase.workspace.ProjectSpace;

public interface CheckoutObserver extends IObserver {

	void checkoutDone(ProjectSpace projectSpace);

}
