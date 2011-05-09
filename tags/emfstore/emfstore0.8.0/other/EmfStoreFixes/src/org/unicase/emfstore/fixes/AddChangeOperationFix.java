package org.unicase.emfstore.fixes;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;

public class AddChangeOperationFix extends AbstractFix {

	@Override
	void fix() {
		for (Version version : projectHistory.getVersions()) {
			if (version.getChanges() == null) {
				continue;
			}

			// if (false && version(version) == 244) {
			// MultiReferenceOperation multiReferenceOperation = OperationsFactory.eINSTANCE
			// .createMultiReferenceOperation();
			// multiReferenceOperation.setAdd(true);
			// multiReferenceOperation.setBidirectional(false);
			// multiReferenceOperation.setModelElementId(createMEID("_AxpfgLy3Ed2XF4y-xW__9g"));
			// multiReferenceOperation.setFeatureName("includedUseCases");
			// multiReferenceOperation.getReferencedModelElements().add(createMEID("_3RFHMLzBEd2XF4y-xW__9g"));
			// multiReferenceOperation.setIndex(2);
			//
			// addOperation(version, multiReferenceOperation);
			// }
			//
			// if (false && version.getPrimarySpec().getIdentifier() == 500) {
			//
			// addOperation(version, createMultiDelete("_Ffc6kMrdEd2FLcQLgl5R9Q", "outgoingAssociations", "source",
			// new String[] { "_6WUNgMrdEd2FLcQLgl5R9Q" }));
			//
			// addOperation(version, createMultiDelete("_PZzD0MrdEd2FLcQLgl5R9Q", "outgoingAssociations", "source",
			// new String[] { "_q4bjMMrdEd2FLcQLgl5R9Q", "_vfnwwMrdEd2FLcQLgl5R9Q" }));
			//
			// addOperation(version, createMultiDelete("_50L4AMXTEd2ol-2GGz06Vg", "outgoingAssociations", "source",
			// new String[] { "_EWtUMMXXEd2ol-2GGz06Vg" }));
			//
			// addOperation(version, createMultiDelete("_EOZQQMXYEd2ol-2GGz06Vg", "incomingAssociations", "target",
			// new String[] { "__GcpkMXYEd2ol-2GGz06Vg" }));
			//
			// addOperation(version, createMultiDelete("_fFoDUMXWEd2ol-2GGz06Vg", "outgoingAssociations", "source",
			// new String[] { "_fPDPoMXXEd2ol-2GGz06Vg", "_gEGBQMXXEd2ol-2GGz06Vg" }));
			//
			// addOperation(version, createMultiDelete("_0iriIMXTEd2ol-2GGz06Vg", "incomingAssociations", "target",
			// new String[] { "_CB7gEMXVEd2ol-2GGz06Vg" }));
			// }
			//
			// if (false && version.getPrimarySpec().getIdentifier() == 550) {
			// addOperation(version, createMultiDelete("_2K4YwJUwEd2_ld_pN7IQ9Q", "assignments", "assignee",
			// new String[] { "_KuuzoPz1Ed2TGLNSjOpjxw" }));
			//
			// SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
			// .createSingleReferenceOperation();
			// singleReferenceOperation.setModelElementId(createMEID("_LDPJAL-1Ed2R2f5SXPgd1A"));
			// singleReferenceOperation.setBidirectional(false);
			// singleReferenceOperation.setFeatureName("stakeholder");
			// singleReferenceOperation.setNewValue(null);
			// singleReferenceOperation.setOldValue(createMEID("_vQ-hsJUwEd2_ld_pN7IQ9Q"));
			// addOperation(version, singleReferenceOperation);
			//
			// addOperation(version, createMultiDelete("_6f9uMMrcEd2FLcQLgl5R9Q", "outgoingAssociations", "source",
			// new String[] { "_gAskoMrdEd2FLcQLgl5R9Q" }));
			//
			// addOperation(version, createMultiDelete("_0ILiAMXUEd2ol-2GGz06Vg", "outgoingAssociations", "source",
			// new String[] { "_wI9d8MXVEd2ol-2GGz06Vg" }));
			//
			// addOperation(version, createMultiDelete("_mLwDYMXUEd2ol-2GGz06Vg", "outgoingAssociations", "source",
			// new String[] { "_RVRR0MXWEd2ol-2GGz06Vg" }));
			//
			// addOperation(version, createMultiDelete("_EOZQQMXYEd2ol-2GGz06Vg", "outgoingAssociations", "source",
			// new String[] { "_npCugMXZEd2ol-2GGz06Vg" }));
			// }
			//
			// if (version(version) == 600) {
			// // addOperation(version, createMultiDelete("_vQ-hsJUwEd2_ld_pN7IQ9Q", "assignments", "assignee",
			// // new String[] { "_IT_QsP0PEd2TGLNSjOpjxw" }));
			//
			// // addOperation(version, createMultiDelete("_3Tm7YJUwEd2_ld_pN7IQ9Q", "assignments", "assignee",
			// // new String[] { "_z7Y6UP9HEd2-D-gfFWiodg" }));
			//
			// // addOperation(version, createMultiDelete("_4PMZ4JUwEd2_ld_pN7IQ9Q", "assignments", "assignee",
			// // new String[] { "_cJTK0P2qEd2-D-gfFWiodg" }));
			//
			// // SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
			// // .createSingleReferenceOperation();
			// // singleReferenceOperation.setBidirectional(true);
			// // singleReferenceOperation.setFeatureName("instantiatedActor");
			// // singleReferenceOperation.setModelElementId(createMEID("_fN77oLWMEd2OEbFJENZnxg"));
			// // singleReferenceOperation.setOppositeFeatureName("instances");
			// // singleReferenceOperation.setNewValue(null);
			// // singleReferenceOperation.setOldValue(createMEID("_uho6MMFIEd2Dlp5EMJWWaQ"));
			// // addOperation(version, singleReferenceOperation);
			//
			// // SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
			// // .createSingleReferenceOperation();
			// // singleReferenceOperation.setBidirectional(true);
			// // singleReferenceOperation.setFeatureName("initiatingActor");
			// // singleReferenceOperation.setModelElementId(createMEID("_hsHrwLzTEd2RWJ3BzLnjrw"));
			// // singleReferenceOperation.setOppositeFeatureName("initiatedUseCases");
			// // singleReferenceOperation.setNewValue(null);
			// // singleReferenceOperation.setOldValue(createMEID("_tkno8LVuEd2zjrhKjes5hg"));
			// // addOperation(version, singleReferenceOperation);
			//
			// // SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
			// // .createSingleReferenceOperation();
			// // singleReferenceOperation.setBidirectional(true);
			// // singleReferenceOperation.setFeatureName("initiatingActor");
			// // singleReferenceOperation.setModelElementId(createMEID("_QYtUwLyHEd2oQZN-8if49g"));
			// // singleReferenceOperation.setOppositeFeatureName("initiatedUseCases");
			// // singleReferenceOperation.setNewValue(null);
			// // singleReferenceOperation.setOldValue(createMEID("_MhVcUKmIEd28EtQH-SBtNg"));
			// // addOperation(version, singleReferenceOperation);
			//
			// }
			// if (version(version) == 622) {
			// // addOperation(version, createMultiDelete("_vQ-hsJUwEd2_ld_pN7IQ9Q", "assignments", "assignee",
			// // new String[] { "_Y562QP0REd2TGLNSjOpjxw", "_pZmUwP0REd2TGLNSjOpjxw" }));
			// //
			// // addOperation(version, createMultiDelete("_3Tm7YJUwEd2_ld_pN7IQ9Q", "assignments", "assignee",
			// // new String[] { "_tr5VYP9LEd2-D-gfFWiodg" }));
			//
			// // SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
			// // .createSingleReferenceOperation();
			// // singleReferenceOperation.setModelElementId(createMEID("_IJf3gMCAEd2XvKJDMrClbg"));
			// // singleReferenceOperation.setBidirectional(false);
			// // singleReferenceOperation.setFeatureName("stakeholder");
			// // singleReferenceOperation.setNewValue(null);
			// // singleReferenceOperation.setOldValue(createMEID("_4PMZ4JUwEd2_ld_pN7IQ9Q"));
			// // addOperation(version, singleReferenceOperation);
			// }

			// if (version(version) == 1317) {
			// MultiReferenceOperation referenceOperation = createMultiReference("includedWorkItems",
			// "_itIBosx9Ed2l67tsUbfziw", new String[] { "_2NoqALfbEd2tjZoGRXOCBA", "_xj1sUMx_Ed2l67tsUbfziw",
			// "bf32e7d4-ee0c-413a-bfd1-fa35b754b986" });
			// addOperation(version, referenceOperation);
			// }

			// if (version(version) == 1431) {
			// addOperation(version, createMultiReference("annotations", "annotatedModelElements",
			// "_mRmrUuGBEd2Cj8bSVj7Xcg", new String[] { "_pUUOYOGBEd2Cj8bSVj7Xcg" }));
			// }

			// if (version(version) == 1587) {
			// addOperation(version, createMultiReference("annotations", "annotatedModelElements",
			// "_XpOdoMzxEd2B-430Kbp7Bw", new String[] { "_CeUcIO-NEd2E5Mqh_bUBFA" }));
			// }

			// if (version(version) == 1700) {
			// CreateDeleteOperation deleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
			// deleteOperation.setDelete(true);
			// deleteOperation.setModelElementId(createMEID("_l47pwOKLEd2l9sZGrse9RQ"));
			// BugReport bugReport = BugFactory.eINSTANCE.createBugReport();
			// bugReport.setIdentifier("_l47pwOKLEd2l9sZGrse9RQ");
			// deleteOperation.setModelElement(bugReport);
			// addOperation(version, deleteOperation);
			//
			// deleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
			// deleteOperation.setDelete(true);
			// deleteOperation.setModelElementId(createMEID("_KGoicO1KEd2TeokOtgtAIg"));
			// bugReport = BugFactory.eINSTANCE.createBugReport();
			// bugReport.setIdentifier("_KGoicO1KEd2TeokOtgtAIg");
			// deleteOperation.setModelElement(bugReport);
			// addOperation(version, deleteOperation);
			// }

			// if (version(version) == 1750) {
			// addOperation(version, createMultiDelete("24c703eb-9f9c-466d-9dbf-0cc6fc230d35", "assignments",
			// "assignee", new String[] { "_cawQAKBcEd22TMJsWWixMg" }));
			// }
			// if (version(version) == 1800) {
			// addOperation(version, createMultiDelete("_jUD_CJ9QEd2r_u3OOJxjeg", "assignments", "assignee",
			// new String[] { "_fwkLkOFSEd2Ia89dEOcE_Q" }));
			// }

			// if (version(version) == 1898) {
			// CreateDeleteOperation deleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
			// deleteOperation.setDelete(true);
			// deleteOperation.setModelElementId(createMEID("_O6WHoCrYEd60nZ0IFtlOgQ"));
			// Attribute attribute = ClassesFactory.eINSTANCE.createAttribute();
			// attribute.setIdentifier("_O6WHoCrYEd60nZ0IFtlOgQ");
			// deleteOperation.setModelElement(attribute);
			// addOperation(version, deleteOperation);
			//
			// deleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
			// deleteOperation.setDelete(true);
			// deleteOperation.setModelElementId(createMEID("_POAqgCrYEd60nZ0IFtlOgQ"));
			// attribute = ClassesFactory.eINSTANCE.createAttribute();
			// attribute.setIdentifier("_POAqgCrYEd60nZ0IFtlOgQ");
			// deleteOperation.setModelElement(attribute);
			// addOperation(version, deleteOperation);
			// }
			//
			// if (version(version) == 1931) {
			// for (String str : (new String[] { "_gfwuIB3-Ed6apaYdF8CI-A", "_bvMiIB3-Ed6apaYdF8CI-A",
			// "_Z_ffEB3-Ed6apaYdF8CI-A", "_QP7pgB3-Ed6apaYdF8CI-A" })) {
			// CreateDeleteOperation deleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
			// deleteOperation.setDelete(true);
			// deleteOperation.setModelElementId(createMEID(str));
			// Proposal proposal = RationaleFactory.eINSTANCE.createProposal();
			// proposal.setIdentifier(str);
			// deleteOperation.setModelElement(proposal);
			// addOperation(version, deleteOperation);
			// }
			// }
		}

	}

	private MultiReferenceOperation createMultiReference(String feature, String opposite, String MEID, String[] elements) {
		MultiReferenceOperation referenceOperation = OperationsFactory.eINSTANCE.createMultiReferenceOperation();
		referenceOperation.setAdd(true);
		referenceOperation.setBidirectional((opposite != null));
		referenceOperation.setFeatureName(feature);
		referenceOperation.setOppositeFeatureName(opposite);
		referenceOperation.setModelElementId(createMEID(MEID));
		for (String element : elements) {
			referenceOperation.getReferencedModelElements().add(createMEID(element));
		}
		return referenceOperation;
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
