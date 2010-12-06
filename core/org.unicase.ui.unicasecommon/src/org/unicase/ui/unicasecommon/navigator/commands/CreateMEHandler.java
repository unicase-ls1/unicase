/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.LeafSection;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.IssueMeetingSection;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author Hodaie This is the handler for createME command (org.unicase.ui.unicasecommon.navigator.createME). This
 *         command is just a command definition with a parameter. This command is not shown itself in the context menu.
 *         In DynamicMECreationCommands class the actually required command to create a Model element are created and
 *         assigned the ID of this generic createME command. When the user selects one of these commands this handler is
 *         executed. The generic createME command gets an EClass as parameter, and the handler creates a ModelElement of
 *         this EClass, adds it to the selected LeafSection and opens it for editing.
 */
public class CreateMEHandler extends AbstractHandler implements IHandler {

	/**
	 * The Id for EClass parameter to command. A model element of this EClass type is created in this handler.
	 */
	public static final String COMMAND_ECLASS_PARAM = "org.unicase.ui.navigator.eClassParameter";

	/**
	 * The Id for DiagramType parameter to command. A diagram of this type is created in the handler.
	 */
	public static final String COMMAND_DIAGRAMTYPE_PARAM = "org.unicase.ui.navigator.diagramTypeParameter";

	/**
	 * . ({@inheritDoc})
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// get the command parameter (EClass)
		Object o = event.getObjectParameterForExecution(COMMAND_ECLASS_PARAM);
		if (o instanceof EClass) {
			EClass newMEType = (EClass) o;
			final UnicaseModelElement newMEInstance;
			// create a new model element from this EClass
			newMEInstance = (UnicaseModelElement) newMEType.getEPackage().getEFactoryInstance().create(newMEType);
			newMEInstance.setName("new " + newMEType.getName());

			// if model element if MEDiagram, set the diagram type

			// if (newMEInstance instanceof MEDiagram) {
			// Object p = event.getObjectParameterForExecution(COMMAND_DIAGRAMTYPE_PARAM);
			// Diagram newDiagramType = (Diagram) p;
			// ((MEDiagram) newMEInstance).setGmfdiagram(newDiagramType);
			// newMEInstance.setName("new " + newDiagramType.getDiagram().getType());
			// }

			// add this newly created model element to LeafSection
			final LeafSection leafSection = (LeafSection) ActionHelper.getSelectedModelElement();
			if (leafSection != null) {
				TransactionalEditingDomain domain = WorkspaceManager.getInstance().getCurrentWorkspace()
					.getEditingDomain();
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						leafSection.getModelElements().add(newMEInstance);
					}
				});

				if (newMEInstance instanceof Meeting) {
					domain.getCommandStack().execute(new RecordingCommand(domain) {
						@Override
						protected void doExecute() {
							// FIXME: added DOLLI meeting structure as default - needs flexible approach.
							addMeetingSections((Meeting) newMEInstance);
						}
					});

					domain.getCommandStack().execute(new RecordingCommand(domain) {
						@Override
						protected void doExecute() {
							addMeetingSubSections((Meeting) newMEInstance);
						}
					});
				}
				UnicaseActionHelper.openModelElement(newMEInstance, this.getClass().getName());
			}
		}
		return null;

	}

	private void addMeetingSections(Meeting meeting) {
		meeting.setName("Team meeting");

		CompositeMeetingSection objectiveSection = MeetingFactory.eINSTANCE.createCompositeMeetingSection();
		CompositeMeetingSection informationExchangeSection = MeetingFactory.eINSTANCE.createCompositeMeetingSection();
		CompositeMeetingSection wrapUpSection = MeetingFactory.eINSTANCE.createCompositeMeetingSection();
		IssueMeetingSection discussionSection = MeetingFactory.eINSTANCE.createIssueMeetingSection();

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

	private void addMeetingSubSections(Meeting meeting) {
		CompositeMeetingSection miscSection = MeetingFactory.eINSTANCE.createCompositeMeetingSection();
		CompositeMeetingSection meetingCritiqueSection = MeetingFactory.eINSTANCE.createCompositeMeetingSection();
		WorkItemMeetingSection workItemsSection = MeetingFactory.eINSTANCE.createWorkItemMeetingSection();
		WorkItemMeetingSection newWorkItemsSection = MeetingFactory.eINSTANCE.createWorkItemMeetingSection();

		workItemsSection.setName("Action items");
		newWorkItemsSection.setName("New action items");
		miscSection.setName("Misc");
		meetingCritiqueSection.setName("Meeting critique");

		CompositeMeetingSection informationExchangeSection = (CompositeMeetingSection) meeting.getSections().get(1);
		CompositeMeetingSection wrapUpSection = (CompositeMeetingSection) meeting.getSections().get(3);

		// set links
		informationExchangeSection.getSubsections().add(workItemsSection);
		informationExchangeSection.getSubsections().add(miscSection);
		wrapUpSection.getSubsections().add(newWorkItemsSection);
		wrapUpSection.getSubsections().add(meetingCritiqueSection);

		meeting.setIdentifiedWorkItemsSection(newWorkItemsSection);
	}
}
