/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.ui.labelproviders;

import org.eclipse.swt.graphics.Image;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;

import org.unicase.rap.Activator;
import org.unicase.model.bug.Severity;
import org.unicase.model.bug.BugReport;
import org.unicase.model.rationale.Issue;
import org.unicase.model.change.MergingIssue;

/**
 * Observable Map Label Provider.
 * 
 * @author Fatih Ulusoy
 */
public class UnicaseObservableMapLabelProvider extends
		ObservableMapLabelProvider {

	/**
	 * The constructor.
	 * 
	 * @param attributeMaps Attribute maps.
	 */
	public UnicaseObservableMapLabelProvider(IObservableMap[] attributeMaps) {
		super(attributeMaps);
	}

	/**
	 * {@inheritDoc}
	 */
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
						"icons/obj16/Bug_blocker.png").createImage();
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

