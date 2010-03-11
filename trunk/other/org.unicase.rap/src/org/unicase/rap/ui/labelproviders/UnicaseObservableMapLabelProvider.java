package org.unicase.rap.ui.labelproviders;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.bug.BugReport;
import org.unicase.model.bug.Severity;
import org.unicase.model.change.MergingIssue;
import org.unicase.model.rationale.Issue;
import org.unicase.rap.Activator;

public class UnicaseObservableMapLabelProvider extends
		ObservableMapLabelProvider {

	public UnicaseObservableMapLabelProvider(IObservableMap[] attributeMaps) {
		super(attributeMaps);
	}

	public Image getImage(Object element) {
		Image image = null;
		if (element instanceof BugReport) {
			BugReport bugReport = (BugReport) element;
			Severity sev = bugReport.getSeverity();
			switch (sev.getValue()) {
			case Severity.MAJOR_VALUE:
				image = Activator.getImageDescriptor(
						"icons/obj16/Bug_major.png").createImage();
				break;
			case Severity.MINOR_VALUE:
				image = Activator.getImageDescriptor(
						"icons/obj16/Bug_minor.png").createImage();
				break;
			case Severity.FEATURE_VALUE:
				image = Activator.getImageDescriptor(
						"icons/obj16/Bug_feature.png").createImage();
				break;
			case Severity.BLOCKER_VALUE:
				image = Activator.getImageDescriptor(
						"icons/obj16/Bug_bloker.png").createImage();
				break;
			case Severity.TRIVIAL_VALUE:
				image = Activator.getImageDescriptor(
						"icons/obj16/Bug_trivial.png").createImage();
				break;
			default:
				image = Activator.getImageDescriptor(
						"icons/obj16/BugReport.png").createImage();
			}
		} else if (element instanceof MergingIssue) {
			image = Activator
					.getImageDescriptor("icons/obj16/MergingIssue.gif")
					.createImage();
		} else if (element instanceof Issue) {
			image = Activator.getImageDescriptor("icons/obj16/Issue.gif")
					.createImage();
		} else {
			image = Activator.getImageDescriptor("icons/obj16/ActionItem.png")
					.createImage();
		}

		return image;
	}
	
}
