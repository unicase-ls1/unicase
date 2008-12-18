package org.unicase.test.tests.change.random.testcases;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.requirement.impl.StepImpl;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

/**
 * This is a change package test. It takes a random model element from test
 * project and changes one of its non-containment references, applies this
 * change to compare project. Test succeeds when both projects are identical,
 * and fails otherwise.
 * 
 * @author Hodaie
 * 
 */
public class NonContainmentReferenceAddTest extends ChangePackageTest {

	private ModelElement me;
	private EReference refToChange;
	private ModelElement meToReference;
	private Object oldValueOfOppositeRef;
	private Object oldValueOfRef;
	private List<UseCase> oldValueOfIncludedUsecasesOfParent;

	private boolean uniqueContainingTarget;
	private boolean touchNotification;

	public NonContainmentReferenceAddTest(ProjectSpace testProjectSpace,
			String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {

		uniqueContainingTarget = false;
		touchNotification = false;
		oldValueOfIncludedUsecasesOfParent = new ArrayList<UseCase>();
		oldValueOfRef = null;
		oldValueOfOppositeRef = null;

		me = ChangeTestHelper.getRandomME(getTestProject());
		refToChange = ChangeTestHelper.getRandomNonContainmentRef(me);

		while (refToChange == null) {
			me = ChangeTestHelper.createRandomME();
			refToChange = ChangeTestHelper.getRandomNonContainmentRef(me);
		}

		oldValueOfRef = me.eGet(refToChange);

		meToReference = ChangeTestHelper.getRandomMEofType(getTestProject(),
				refToChange.getEReferenceType());
		// make a copy of old value of opposite reference for later inspection
		// (see getExpectedNumOfChanges())
		if (refToChange.getEOpposite() != null) {

			oldValueOfOppositeRef = meToReference.eGet(refToChange
					.getEOpposite());
		}

		// I really don't understand why this does not work:
		// refToChange instanceof
		// RequirementPackage.Literals.STEP__INCLUDED_USE_CASE;
		if (me instanceof Step
				&& refToChange.getName().equals("includedUseCase")) {
			UseCase parentUseCase = ((Step) me).getUseCase();
			if (parentUseCase != null) {
				for (UseCase useCase : parentUseCase.getIncludedUseCases()) {
					oldValueOfIncludedUsecasesOfParent.add(useCase);
				}
			}

		}

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doChangeSimpleRef();
			}

		});
	}

	@SuppressWarnings("unchecked")
	private void doChangeSimpleRef() {

		Object object = me.eGet(refToChange);
		if (refToChange.isMany()) {
			EList<EObject> eList = (EList<EObject>) object;
			if (eList == null) {
				throw new IllegalStateException("Null list return for feature "
						+ refToChange.getName() + " on " + me.getName());
			} else {
				if (refToChange.isUnique() && eList.contains(meToReference)) {
					uniqueContainingTarget = true;
				}

			}
		} else {
			if (object != null && object.equals(meToReference)) {
				touchNotification = true;
			}
		}

		ChangeTestHelper.changeSimpleRef(me, refToChange, meToReference);

		
	}

	public int getExpectedNumOfChanges() {

		// a CreateDeleteOperation
		// and a MultiReferenceOpertaion
		// if refToChange or its opposite has upper bound 1 then additionally a
		// SimpleRefOp

		if (uniqueContainingTarget || touchNotification) {
			return 0;
		}

		if (refToChange.getUpperBound() == 1
				|| (refToChange.getEOpposite() != null && refToChange
						.getEOpposite().getUpperBound() == 1)) {
			// why don't we test refToChange.getUpperBound() == 1 ?
			// because even if refToChange for newly created model element has
			// upper bound 1,
			// its initial value is null! and therefore we do not expect a
			// SingleRefOp for it to be created.
			if ((refToChange.isMany() && oldValueOfOppositeRef != null)
					|| (refToChange.getEOpposite() != null
							&& refToChange.getEOpposite().isMany() && oldValueOfRef != null)) {
				// why do we check this?
				// because if both refToChange and its opposite have upper bound
				// 1, then there is just one SingleRefOp to create. Hence number
				// of operations is just 1.

				return 2;
			}

		}

		// I really don't understand why this does not work:
		// refToChange instanceof
		// RequirementPackage.Literals.STEP__INCLUDED_USE_CASE;
		if (me instanceof StepImpl
				&& refToChange.getName().equalsIgnoreCase("includedUseCase")) {
			if (((Step) me).getUseCase() != null) {
				if (oldValueOfIncludedUsecasesOfParent.contains(meToReference)) {
					return 1;
				} else {
					return 2;
				}
			}
		}

		return 1;
	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {

		boolean ret = (changePackage.getOperations().size() == getExpectedNumOfChanges());
		return ret;
	}

}
