package org.unicase.emfstore.fixes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.Meeting;

public class MeetingCreationFix extends AbstractFix {

	private List<AbstractOperation> newOperations;
	private List<AbstractOperation> deletedOperations;

	@Override
	void fix() {
		newOperations = new ArrayList<AbstractOperation>();
		for (Version version : projectHistory.getVersions()) {
			if (version.getChanges() == null) {
				continue;
			}
			for (int i = 0; i < version.getChanges().getOperations().size(); i++) {
				AbstractOperation operation = version.getChanges().getOperations().get(i);
				if (operation instanceof CreateDeleteOperation && !((CreateDeleteOperation) operation).isDelete()) {
					CreateDeleteOperation deleteOperation = (CreateDeleteOperation) operation;
					ModelElement modelElement = deleteOperation.getModelElement();
					if (modelElement instanceof Meeting && ((Meeting) modelElement).getSections().size() != 0) {
						System.out.println("fixing meeting in version " + version.getPrimarySpec().getIdentifier());
						if (((Meeting) modelElement).getSections().size() != 4) {
							System.out.println("ERROR: couldnt load all subsections");
							continue;
						}
						fixMeeting((Meeting) modelElement, deleteOperation);
						version.getChanges().getOperations().remove(i);
						version.getChanges().getOperations().addAll(i, newOperations);
						newOperations.clear();
					}
					if (modelElement instanceof CompositeMeetingSection
						&& ((CompositeMeetingSection) modelElement).getSubsections().size() != 0) {
						System.out.println("CompositeMeetingSection has children "
							+ version.getPrimarySpec().getIdentifier());
						CompositeMeetingSection subsection = (CompositeMeetingSection) modelElement;
						fixCompositeMeetingSection(deleteOperation, subsection);
						version.getChanges().getOperations().remove(i);
						version.getChanges().getOperations().addAll(i, newOperations);
						newOperations.clear();
					}
				}
			}
			save(version);
		}
	}

	private void fixCompositeMeetingSection(CreateDeleteOperation deleteOperation, CompositeMeetingSection subsection) {
		newOperations.add(createCreateOperation(deleteOperation, subsection.getSubsections().get(0)));
		newOperations.add(createCreateOperation(deleteOperation, subsection.getSubsections().get(1)));
		MultiReferenceOperation reference = createMultiReference(deleteOperation, subsection.getSubsections(),
			"subsections", subsection.getModelElementId());
		subsection.getSubsections().clear();
		newOperations.add(createCreateOperation(deleteOperation, subsection));
		newOperations.add(reference);
	}

	private void fixMeeting(Meeting meeting, CreateDeleteOperation deleteOperation) {
		// Objective
		newOperations.add(createCreateOperation(deleteOperation, meeting.getSections().get(0)));

		//
		CompositeMeetingSection subsection = (CompositeMeetingSection) meeting.getSections().get(1);
		newOperations.add(createCreateOperation(deleteOperation, subsection.getSubsections().get(0)));
		newOperations.add(createCreateOperation(deleteOperation, subsection.getSubsections().get(1)));
		MultiReferenceOperation reference = createMultiReference(deleteOperation, subsection.getSubsections(),
			"subsections", subsection.getModelElementId());
		subsection.getSubsections().clear();
		newOperations.add(createCreateOperation(deleteOperation, subsection));
		newOperations.add(reference);

		//
		newOperations.add(createCreateOperation(deleteOperation, meeting.getSections().get(2)));
		//
		subsection = (CompositeMeetingSection) meeting.getSections().get(3);
		newOperations.add(createCreateOperation(deleteOperation, subsection.getSubsections().get(0)));
		newOperations.add(createCreateOperation(deleteOperation, subsection.getSubsections().get(1)));
		reference = createMultiReference(deleteOperation, subsection.getSubsections(), "subsections", subsection
			.getModelElementId());
		subsection.getSubsections().clear();
		newOperations.add(createCreateOperation(deleteOperation, subsection));
		newOperations.add(reference);

		// //
		reference = createMultiReference(deleteOperation, meeting.getSections(), "sections", meeting
			.getModelElementId());
		meeting.getSections().clear();
		newOperations.add(createCreateOperation(deleteOperation, meeting));
		newOperations.add(reference);
	}

	// private void createSingleReference(CreateDeleteOperation deleteOperation, ModelElementId parent,
	// String featureName, ModelElementId child) {
	// SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
	// .createSingleReferenceOperation();
	// singleReferenceOperation.setClientDate(deleteOperation.getClientDate());
	// singleReferenceOperation.setFeatureName(featureName);
	// singleReferenceOperation.setModelElementId(parent);
	// singleReferenceOperation.setNewValue(child);
	// }

	private MultiReferenceOperation createMultiReference(CreateDeleteOperation deleteOperation,
		List<? extends ModelElement> elements, String featureName, ModelElementId parent) {
		MultiReferenceOperation multiReferenceOperation = OperationsFactory.eINSTANCE.createMultiReferenceOperation();
		multiReferenceOperation.setAdd(true);
		multiReferenceOperation.setFeatureName(featureName);
		multiReferenceOperation.setClientDate(deleteOperation.getClientDate());
		multiReferenceOperation.setModelElementId(parent);
		for (ModelElement me : elements) {
			multiReferenceOperation.getReferencedModelElements().add(
				(ModelElementId) EcoreUtil.copy(me.getModelElementId()));
		}
		return multiReferenceOperation;
	}

	private CreateDeleteOperation createCreateOperation(CreateDeleteOperation deleteOperation, ModelElement section) {
		CreateDeleteOperation createSection = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		createSection.setClientDate(deleteOperation.getClientDate());
		createSection.setModelElement((ModelElement) EcoreUtil.copy(section));
		createSection.setModelElementId((ModelElementId) EcoreUtil.copy(section.getModelElementId()));
		return createSection;
	}

	@Override
	String getFixName() {
		return "Meeting Creation Fix";
	}

}
