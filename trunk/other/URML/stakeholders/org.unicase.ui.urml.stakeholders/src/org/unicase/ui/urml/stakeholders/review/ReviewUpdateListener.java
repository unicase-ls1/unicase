package org.unicase.ui.urml.stakeholders.review;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TableViewer;

import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.model.urml.UrmlModelElement;

public class ReviewUpdateListener implements ModelElementChangeListener {

	private UrmlModelElement urmlElement;
	private TableViewer elementsViewer;

	public ReviewUpdateListener(UrmlModelElement urmlElement, TableViewer elementsViewer) {
		this.urmlElement = urmlElement;
		this.elementsViewer = elementsViewer;
	}

	@Override
	public void onChange(Notification notification) {
		Object notificationFeature = notification.getFeature();
		if (notification.getEventType() == Notification.RESOLVE) {
			return;
		}
		Object nameFeature = urmlElement.eClass().getEStructuralFeature("name");
		Object reviewedFeature = urmlElement.eClass().getEStructuralFeature("reviewed");
		if (notificationFeature.equals(nameFeature) || notificationFeature.equals(reviewedFeature)) {
			elementsViewer.refresh();
		}
		
	}

	@Override
	public void onRuntimeExceptionInListener(RuntimeException exception) {
	
		
	}



}
