/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.wizards;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.LeafSection;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.IssueMeetingSection;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * @author Hodaie This is implementation of New Model Element wizard. This
 *         wizard is show through "Add new model element..." command in context
 *         menu of Navigator (only on right click on LeafSection). The wizard
 *         shows a tree of model packages and their classes. The user can select
 *         a Model Element type in this tree and on finish the model element is
 *         created, added to Leaf- or CompositeSection and opend for editing.
 */
@SuppressWarnings("restriction")
public class NewModelElementWizard extends Wizard implements IWorkbenchWizard {

	private UnicaseModelElement selectedME;
	/**
	 * . Through this field, the ModelTreePage tells the wizard which model
	 * element type is selected
	 */
	private EClass newMEType;

	/**
	 * Through this field, the ModelTreePage tells the wizard if it's ready to
	 * finish, i.e. if the selection a model element is and not a package.
	 */
	private boolean treePageCompleted;
	private Object projectRoot;

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public void addPages() {

		ModelTreePage treePage = new ModelTreePage("ModelTreePage");
		addPage(treePage);

	}

	/**
	 * . ({@inheritDoc}) This method creates a model element instance from
	 * selected type, adds it to Leaf- or CompositeSection, and opens it.
	 */
	@Override
	public boolean performFinish() {
		final EObject newMEInstance;
		if ((selectedME != null || projectRoot != null) && newMEType != null) {
			EPackage ePackage = newMEType.getEPackage();
			newMEInstance = ePackage.getEFactoryInstance().create(newMEType);
			if (selectedME instanceof LeafSection) {
				new EMFStoreCommand() {
					@Override
					protected void doRun() {
						((LeafSection) selectedME).getModelElements().add(
								newMEInstance);

					}
				}.run(true);
			} else if (newMEInstance instanceof Meeting) {
				new EMFStoreCommand() {
					@Override
					protected void doRun() {
						setupMeetingSections((Meeting) newMEInstance);

					}
				}.run(true);

				new EMFStoreCommand() {
					@Override
					protected void doRun() {

						setupMeetingSubSections((Meeting) newMEInstance);
					}
				}.run(true);
			} else if (projectRoot != null && projectRoot instanceof ECPProject) {
				((ECPProject) projectRoot).getEditingDomain().getCommandStack()
						.execute(new ChangeCommand(newMEInstance) {
							@Override
							protected void doExecute() {
								((ECPProject) projectRoot).getContents().add(
										newMEInstance);
							}
						});
			}
			// 3.open the newly created ME
			UnicaseActionHelper.openModelElement(newMEInstance, this.getClass()
					.getName());
		}

		return true;
	}

	// FIXME: added DOLLI meeting structure as default - needs flexible
	// approach.
	private void setupMeetingSections(Meeting meeting) {
		meeting.setName("Team meeting");

		// create all DOLLI sections
		CompositeMeetingSection objectiveSection = MeetingFactory.eINSTANCE
				.createCompositeMeetingSection();
		CompositeMeetingSection informationExchangeSection = MeetingFactory.eINSTANCE
				.createCompositeMeetingSection();
		CompositeMeetingSection wrapUpSection = MeetingFactory.eINSTANCE
				.createCompositeMeetingSection();
		IssueMeetingSection discussionSection = MeetingFactory.eINSTANCE
				.createIssueMeetingSection();

		// set attributes
		objectiveSection.setName("Objective");
		informationExchangeSection.setName("Information sharing");
		wrapUpSection.setName("Wrap up");
		discussionSection.setName("Discussion");

		informationExchangeSection.setAllocatedTime(30);
		discussionSection.setAllocatedTime(50);
		wrapUpSection.setAllocatedTime(10);

		// set links
		meeting.getSections().add(objectiveSection);
		meeting.getSections().add(informationExchangeSection);
		meeting.getSections().add(discussionSection);
		meeting.getSections().add(wrapUpSection);

		meeting.setIdentifiedIssuesSection(discussionSection);
	}

	private void setupMeetingSubSections(Meeting meeting) {
		CompositeMeetingSection miscSection = MeetingFactory.eINSTANCE
				.createCompositeMeetingSection();
		CompositeMeetingSection meetingCritiqueSection = MeetingFactory.eINSTANCE
				.createCompositeMeetingSection();
		WorkItemMeetingSection workItemsSection = MeetingFactory.eINSTANCE
				.createWorkItemMeetingSection();
		WorkItemMeetingSection newWorkItemsSection = MeetingFactory.eINSTANCE
				.createWorkItemMeetingSection();

		miscSection.setName("Misc");
		meetingCritiqueSection.setName("Meeting critique");
		workItemsSection.setName("Action items");
		newWorkItemsSection.setName("New action items");

		CompositeMeetingSection informationExchangeSection = (CompositeMeetingSection) meeting
				.getSections().get(1);
		CompositeMeetingSection wrapUpSection = (CompositeMeetingSection) meeting
				.getSections().get(3);

		informationExchangeSection.getSubsections().add(workItemsSection);
		informationExchangeSection.getSubsections().add(miscSection);
		wrapUpSection.getSubsections().add(newWorkItemsSection);
		wrapUpSection.getSubsections().add(meetingCritiqueSection);

		meeting.setIdentifiedWorkItemsSection(newWorkItemsSection);
	}

	/**
	 * . ({@inheritDoc})
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// get the in navigator selected ME
		Object o;
		if (!selection.isEmpty()) {
			o = selection.getFirstElement();
			if (o instanceof UnicaseModelElement) {
				selectedME = (UnicaseModelElement) o;
			} else if (o instanceof ECPProject) {
				projectRoot = o;
			}
		}

	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public boolean canFinish() {
		return treePageCompleted;

	}

	/**
	 * @see newMEType
	 * @param newMEType
	 *            The ME type that was in ModelTreePage selected.
	 */
	public void setNewMEType(EClass newMEType) {
		this.newMEType = newMEType;
	}

	/**
	 * @see treePageCompeleted
	 * @param treePageCompleted
	 *            If ModelTreePage is complete (i.e. its selection is a ME)
	 */
	public void setTreePageCompleted(boolean treePageCompleted) {
		this.treePageCompleted = treePageCompleted;
	}

}
