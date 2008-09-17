package org.unicase.model.util;

import org.eclipse.emf.common.notify.Notification;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;

public interface ProjectChangeObserver {

	void notify(Notification notification, Project project, ModelElement modelElement);
	
	void modelElementAdded(Project project, ModelElement modelElement);
	
	void modelElementRemoved(Project project, ModelElement modelElement);
}
