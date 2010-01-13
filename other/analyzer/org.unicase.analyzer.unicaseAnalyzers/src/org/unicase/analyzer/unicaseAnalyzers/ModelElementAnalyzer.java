/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.unicaseAnalyzers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.activity.ActivityFactory;
import org.unicase.model.attachment.AttachmentFactory;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.change.ChangeFactory;
import org.unicase.model.classes.ClassesFactory;
import org.unicase.model.component.ComponentFactory;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.profile.ProfileFactory;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.state.StateFactory;
import org.unicase.model.task.TaskFactory;

/**
 * @author liya
 */
public class ModelElementAnalyzer implements DataAnalyzer {

	private static final String MECOUNT = "ModelElement #";

	/**
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add(MECOUNT);
		names.add("Task #");
		names.add("Organization #");
		names.add("Diagram #");
		names.add("Requirement #");
		names.add("Class #");
		names.add("Document #");
		names.add("Change #");
		names.add("Bug #");
		names.add("Rationale #");
		names.add("Component #");
		names.add("State #");
		names.add("Meeting #");
		names.add("Activity #");
		names.add("Profile #");
		names.add("Attachment #");
		return names;
	}

	/**
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 * @param data {@link ProjectAnalysisData}
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		int task = 0;
		int organization = 0;
		int diagram = 0;
		int requirements = 0;
		int classes = 0;
		int documents = 0;
		int change = 0;
		int bug = 0;
		int rationale = 0;
		int component = 0;
		int state = 0;
		int meeting = 0;
		int activity = 0;
		int profile = 0;
		int attachment = 0;

		// Number of all ModelElements
		values.add(data.getProjectState().getAllModelElements().size());

		// Number of MEs for each package
		EList<ModelElement> meList = data.getProjectState().getAllModelElements();
		for (ModelElement me : meList) {
			if (me.eClass().getEPackage().equals(TaskFactory.eINSTANCE.getEPackage())) {
				task++;
			} else if (me.eClass().getEPackage().equals(OrganizationFactory.eINSTANCE.getEPackage())) {
				organization++;
			} else if (me.eClass().getEPackage().equals(DiagramFactory.eINSTANCE.getEPackage())) {
				diagram++;
			} else if (me.eClass().getEPackage().equals(RequirementFactory.eINSTANCE.getEPackage())) {
				requirements++;
			} else if (me.eClass().getEPackage().equals(ClassesFactory.eINSTANCE.getEPackage())) {
				classes++;
			} else if (me.eClass().getEPackage().equals(DocumentFactory.eINSTANCE.getEPackage())) {
				documents++;
			} else if (me.eClass().getEPackage().equals(ChangeFactory.eINSTANCE.getEPackage())) {
				change++;
			} else if (me.eClass().getEPackage().equals(BugFactory.eINSTANCE.getEPackage())) {
				bug++;
			} else if (me.eClass().getEPackage().equals(RationaleFactory.eINSTANCE.getEPackage())) {
				rationale++;
			} else if (me.eClass().getEPackage().equals(ComponentFactory.eINSTANCE.getEPackage())) {
				component++;
			} else if (me.eClass().getEPackage().equals(StateFactory.eINSTANCE.getEPackage())) {
				state++;
			} else if (me.eClass().getEPackage().equals(MeetingFactory.eINSTANCE.getEPackage())) {
				meeting++;
			} else if (me.eClass().getEPackage().equals(ActivityFactory.eINSTANCE.getEPackage())) {
				activity++;
			} else if (me.eClass().getEPackage().equals(ProfileFactory.eINSTANCE.getEPackage())) {
				profile++;
			} else if (me.eClass().getEPackage().equals(AttachmentFactory.eINSTANCE.getEPackage())) {
				attachment++;
			}

		}
		values.add(task);
		values.add(organization);
		values.add(diagram);
		values.add(requirements);
		values.add(classes);
		values.add(documents);
		values.add(change);
		values.add(bug);
		values.add(rationale);
		values.add(component);
		values.add(state);
		values.add(meeting);
		values.add(activity);
		values.add(profile);
		values.add(attachment);

		return values;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#isGlobal()
	 */
	public boolean isGlobal() {
		return false;
	}
}
