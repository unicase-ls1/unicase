package org.unicase.ui.urml.stakeholders;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;

public class ChangeObserverAdapter implements ProjectChangeObserver {

	@Override
	public void notify(Notification notification, Project project,
			EObject modelElement) {
	}

	@Override
	public void modelElementAdded(Project project, EObject modelElement) {
	}

	@Override
	public void modelElementRemoved(Project project, EObject modelElement) {
	}

	@Override
	public void projectDeleted(Project project) {
	}

}
