package org.eclipse.emf.emfstore.client.model.observers;

import org.eclipse.emf.emfstore.common.observer.IObserver;

public interface ExceptionObserver extends IObserver {

	boolean handleError(RuntimeException e);
}
