package org.unicase.emfstore.fixes;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;

public class AddChangeOperationFix extends AbstractFix {

	@Override
	void fix() {
		for (Version version : projectHistory.getVersions()) {
			if (version.getChanges() == null) {
				continue;
			}

			if (false && version(version) == 244) {
				MultiReferenceOperation multiReferenceOperation = OperationsFactory.eINSTANCE
					.createMultiReferenceOperation();
				multiReferenceOperation.setAdd(true);
				multiReferenceOperation.setBidirectional(false);
				multiReferenceOperation.setModelElementId(createMEID("_AxpfgLy3Ed2XF4y-xW__9g"));
				multiReferenceOperation.setFeatureName("includedUseCases");
				multiReferenceOperation.getReferencedModelElements().add(createMEID("_3RFHMLzBEd2XF4y-xW__9g"));
				multiReferenceOperation.setIndex(2);

				addOperation(version, multiReferenceOperation);
			}

			if (false && version.getPrimarySpec().getIdentifier() == 500) {

				addOperation(version, createMultiDelete("_Ffc6kMrdEd2FLcQLgl5R9Q", "outgoingAssociations", "source",
					new String[] { "_6WUNgMrdEd2FLcQLgl5R9Q" }));

				addOperation(version, createMultiDelete("_PZzD0MrdEd2FLcQLgl5R9Q", "outgoingAssociations", "source",
					new String[] { "_q4bjMMrdEd2FLcQLgl5R9Q", "_vfnwwMrdEd2FLcQLgl5R9Q" }));

				addOperation(version, createMultiDelete("_50L4AMXTEd2ol-2GGz06Vg", "outgoingAssociations", "source",
					new String[] { "_EWtUMMXXEd2ol-2GGz06Vg" }));

				addOperation(version, createMultiDelete("_EOZQQMXYEd2ol-2GGz06Vg", "incomingAssociations", "target",
					new String[] { "__GcpkMXYEd2ol-2GGz06Vg" }));

				addOperation(version, createMultiDelete("_fFoDUMXWEd2ol-2GGz06Vg", "outgoingAssociations", "source",
					new String[] { "_fPDPoMXXEd2ol-2GGz06Vg", "_gEGBQMXXEd2ol-2GGz06Vg" }));

				addOperation(version, createMultiDelete("_0iriIMXTEd2ol-2GGz06Vg", "incomingAssociations", "target",
					new String[] { "_CB7gEMXVEd2ol-2GGz06Vg" }));
			}

			if (false && version.getPrimarySpec().getIdentifier() == 550) {
				addOperation(version, createMultiDelete("_2K4YwJUwEd2_ld_pN7IQ9Q", "assignments", "assignee",
					new String[] { "_KuuzoPz1Ed2TGLNSjOpjxw" }));

				SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
					.createSingleReferenceOperation();
				singleReferenceOperation.setModelElementId(createMEID("_LDPJAL-1Ed2R2f5SXPgd1A"));
				singleReferenceOperation.setBidirectional(false);
				singleReferenceOperation.setFeatureName("stakeholder");
				singleReferenceOperation.setNewValue(null);
				singleReferenceOperation.setOldValue(createMEID("_vQ-hsJUwEd2_ld_pN7IQ9Q"));
				addOperation(version, singleReferenceOperation);

				addOperation(version, createMultiDelete("_6f9uMMrcEd2FLcQLgl5R9Q", "outgoingAssociations", "source",
					new String[] { "_gAskoMrdEd2FLcQLgl5R9Q" }));

				addOperation(version, createMultiDelete("_0ILiAMXUEd2ol-2GGz06Vg", "outgoingAssociations", "source",
					new String[] { "_wI9d8MXVEd2ol-2GGz06Vg" }));

				addOperation(version, createMultiDelete("_mLwDYMXUEd2ol-2GGz06Vg", "outgoingAssociations", "source",
					new String[] { "_RVRR0MXWEd2ol-2GGz06Vg" }));

				addOperation(version, createMultiDelete("_EOZQQMXYEd2ol-2GGz06Vg", "outgoingAssociations", "source",
					new String[] { "_npCugMXZEd2ol-2GGz06Vg" }));
			}

			if (version(version) == 600) {
				// addOperation(version, createMultiDelete("_vQ-hsJUwEd2_ld_pN7IQ9Q", "assignments", "assignee",
				// new String[] { "_IT_QsP0PEd2TGLNSjOpjxw" }));

				// addOperation(version, createMultiDelete("_3Tm7YJUwEd2_ld_pN7IQ9Q", "assignments", "assignee",
				// new String[] { "_z7Y6UP9HEd2-D-gfFWiodg" }));

				// addOperation(version, createMultiDelete("_4PMZ4JUwEd2_ld_pN7IQ9Q", "assignments", "assignee",
				// new String[] { "_cJTK0P2qEd2-D-gfFWiodg" }));

				// SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
				// .createSingleReferenceOperation();
				// singleReferenceOperation.setBidirectional(true);
				// singleReferenceOperation.setFeatureName("instantiatedActor");
				// singleReferenceOperation.setModelElementId(createMEID("_fN77oLWMEd2OEbFJENZnxg"));
				// singleReferenceOperation.setOppositeFeatureName("instances");
				// singleReferenceOperation.setNewValue(null);
				// singleReferenceOperation.setOldValue(createMEID("_uho6MMFIEd2Dlp5EMJWWaQ"));
				// addOperation(version, singleReferenceOperation);

				// SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
				// .createSingleReferenceOperation();
				// singleReferenceOperation.setBidirectional(true);
				// singleReferenceOperation.setFeatureName("initiatingActor");
				// singleReferenceOperation.setModelElementId(createMEID("_hsHrwLzTEd2RWJ3BzLnjrw"));
				// singleReferenceOperation.setOppositeFeatureName("initiatedUseCases");
				// singleReferenceOperation.setNewValue(null);
				// singleReferenceOperation.setOldValue(createMEID("_tkno8LVuEd2zjrhKjes5hg"));
				// addOperation(version, singleReferenceOperation);

				// SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
				// .createSingleReferenceOperation();
				// singleReferenceOperation.setBidirectional(true);
				// singleReferenceOperation.setFeatureName("initiatingActor");
				// singleReferenceOperation.setModelElementId(createMEID("_QYtUwLyHEd2oQZN-8if49g"));
				// singleReferenceOperation.setOppositeFeatureName("initiatedUseCases");
				// singleReferenceOperation.setNewValue(null);
				// singleReferenceOperation.setOldValue(createMEID("_MhVcUKmIEd28EtQH-SBtNg"));
				// addOperation(version, singleReferenceOperation);

			}
			if (version(version) == 622) {
				// addOperation(version, createMultiDelete("_vQ-hsJUwEd2_ld_pN7IQ9Q", "assignments", "assignee",
				// new String[] { "_Y562QP0REd2TGLNSjOpjxw", "_pZmUwP0REd2TGLNSjOpjxw" }));
				//
				// addOperation(version, createMultiDelete("_3Tm7YJUwEd2_ld_pN7IQ9Q", "assignments", "assignee",
				// new String[] { "_tr5VYP9LEd2-D-gfFWiodg" }));

				SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
					.createSingleReferenceOperation();
				singleReferenceOperation.setModelElementId(createMEID("_IJf3gMCAEd2XvKJDMrClbg"));
				singleReferenceOperation.setBidirectional(false);
				singleReferenceOperation.setFeatureName("stakeholder");
				singleReferenceOperation.setNewValue(null);
				singleReferenceOperation.setOldValue(createMEID("_4PMZ4JUwEd2_ld_pN7IQ9Q"));
				addOperation(version, singleReferenceOperation);
			}
		}

	}

	private MultiReferenceOperation createMultiDelete(String meId, String feature, String oppositeFeature,
		String[] elements) {
		MultiReferenceOperation multiReferenceOperation = OperationsFactory.eINSTANCE.createMultiReferenceOperation();
		multiReferenceOperation.setAdd(false);
		multiReferenceOperation.setBidirectional(true);
		multiReferenceOperation.setModelElementId(createMEID(meId));
		multiReferenceOperation.setFeatureName(feature);
		multiReferenceOperation.setOppositeFeatureName(oppositeFeature);
		for (String element : elements) {
			multiReferenceOperation.getReferencedModelElements().add(createMEID(element));
		}
		return multiReferenceOperation;
	}

	private void addOperation(Version version, AbstractOperation operation) {
		ChangePackage changes = version.getChanges();
		if (changes != null && operation != null && !containedInChangePackage(changes, serializeOperation(operation))) {
			System.out.println("version " + version.getPrimarySpec().getIdentifier() + ": added operation - "
				+ operation);
			changes.getOperations().add(operation);
			save(changes);
		}
	}

	@Override
	String getFixName() {
		return "add or change operation fix";
	}

}
