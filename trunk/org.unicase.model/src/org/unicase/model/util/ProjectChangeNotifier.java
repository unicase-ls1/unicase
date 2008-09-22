package org.unicase.model.util;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;

public class ProjectChangeNotifier extends AdapterImpl {

	private ProjectChangeObserver projectChangeObserver;
	private Project project;

	public ProjectChangeNotifier(Project project,
			ProjectChangeObserver projectChangeObserver) {
		this.projectChangeObserver = projectChangeObserver;
		this.project = project;
		TreeIterator<EObject> allContents = project.eAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (ModelPackage.eINSTANCE.getModelElement().isInstance(next)) {
				ModelElement modelElement = (ModelElement) next;
				modelElement.eAdapters().add(this);
			}
		}
		project.eAdapters().add(this);
	}

	public void notifyChanged(Notification notification) {

		switch (notification.getEventType()) {
		case Notification.ADD:
			if (notification.getFeature() instanceof EReference) {
				EObject newValue = (EObject) notification.getNewValue();
				if (ModelPackage.eINSTANCE.getModelElement().isInstance(
						newValue)) {
					ModelElement modelElement = (ModelElement) newValue;
					if (!project.contains(modelElement)) {
						newValue.eAdapters().add(this);
						this.projectChangeObserver.modelElementAdded(project,
								(ModelElement) newValue);
					}
				}
			}
			break;
		case Notification.ADD_MANY:
			if (notification.getFeature() instanceof EReference) {
				List<EObject> newValues = (List<EObject>) notification
						.getNewValue();
				for (EObject newElement : newValues) {
					if (ModelPackage.eINSTANCE.getModelElement().isInstance(
							newElement)) {
						ModelElement modelElement = (ModelElement) newElement;
						if (!project.contains(modelElement)) {
							newElement.eAdapters().add(this);
							this.projectChangeObserver.modelElementAdded(
									project, modelElement);
						}
					}

				}
			}
			break;
		case Notification.REMOVE:
			if (notification.getFeature() instanceof EReference) {
				EObject newValue = (EObject) notification.getOldValue();
				if (ModelPackage.eINSTANCE.getModelElement().isInstance(
						newValue)) {
					ModelElement modelElement = (ModelElement) newValue;
					newValue.eAdapters().remove(this);
					this.projectChangeObserver.modelElementRemoved(project,
							(ModelElement) newValue);
				}
			}
			break;
		case Notification.REMOVE_MANY:
			if (notification.getFeature() instanceof EReference) {
				List<EObject> oldValues = (List<EObject>) notification
						.getOldValue();
				for (EObject newElement : oldValues) {
					if (ModelPackage.eINSTANCE.getModelElement().isInstance(
							newElement)) {
						ModelElement modelElement = (ModelElement) newElement;
						newElement.eAdapters().add(this);
						this.projectChangeObserver.modelElementRemoved(project,
								modelElement);
					}

				}
			}
			break;
		}

		Object notifier = notification.getNotifier();
		if (notifier instanceof ModelElement) {
			this.projectChangeObserver.notify(notification, project,
					(ModelElement) notifier);
		}

	}

}
