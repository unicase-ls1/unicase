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

		if ((notification.getFeature() instanceof EReference)) {
			EReference reference = (EReference) notification.getFeature();
			if (reference.isContainment()) {
				switch (notification.getEventType()) {
				case Notification.ADD:

					EObject newValue = (EObject) notification.getNewValue();
					if (ModelPackage.eINSTANCE.getModelElement().isInstance(
							newValue)) {
						ModelElement modelElement = (ModelElement) newValue;
						if (!project.contains(modelElement)) {
							newValue.eAdapters().add(this);
							this.projectChangeObserver.modelElementAdded(
									project, (ModelElement) newValue);
						}
					}

					break;
				case Notification.ADD_MANY:

					List<EObject> newValues = (List<EObject>) notification
							.getNewValue();
					for (EObject newElement : newValues) {
						if (ModelPackage.eINSTANCE.getModelElement()
								.isInstance(newElement)) {
							ModelElement modelElement = (ModelElement) newElement;
							if (!project.contains(modelElement)) {
								newElement.eAdapters().add(this);
								this.projectChangeObserver.modelElementAdded(
										project, modelElement);
							}
						}

					}

					break;
				case Notification.REMOVE:
					EObject oldValue = (EObject) notification.getOldValue();
					if (ModelPackage.eINSTANCE.getModelElement().isInstance(
							oldValue)) {
						ModelElement modelElement = (ModelElement) oldValue;
						oldValue.eAdapters().remove(this);
						this.projectChangeObserver.modelElementRemoved(project,
								(ModelElement) oldValue);
					}

					break;
				case Notification.REMOVE_MANY:

					List<EObject> oldValues = (List<EObject>) notification
							.getOldValue();
					for (EObject newElement : oldValues) {
						if (ModelPackage.eINSTANCE.getModelElement()
								.isInstance(newElement)) {
							ModelElement modelElement = (ModelElement) newElement;
							newElement.eAdapters().remove(this);
							this.projectChangeObserver.modelElementRemoved(
									project, modelElement);
						}

					}
					break;
				case Notification.SET:
					Object newSetValue = notification.getNewValue();
					Object oldSetValue = notification.getOldValue();
					if (newSetValue != null) {
						if (newSetValue instanceof ModelElement) {
							this.projectChangeObserver.modelElementAdded(
									project, (ModelElement) newSetValue);
						}
					} else {
						if (oldSetValue instanceof ModelElement)
							this.projectChangeObserver.modelElementRemoved(
									project, (ModelElement) oldSetValue);
					}
				}

			}

		}

		Object notifier = notification.getNotifier();
		if (notifier instanceof ModelElement) {
			this.projectChangeObserver.notify(notification, project,
					(ModelElement) notifier);
		}

	}

}
