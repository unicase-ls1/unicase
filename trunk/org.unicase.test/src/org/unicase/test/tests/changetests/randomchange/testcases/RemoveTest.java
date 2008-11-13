package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;

/**
 * 
 * This is change package test. It does the following: takes randomly a ME A
 * from test project, takes randomly one of its containment features, remove
 * randomly one of the contained MEs B from this feature.
 * 
 * The expected change package should contain two operations: - change
 * operation: changed A.contRef - delete operation: deleted B
 * 
 * @author Hodaie
 * 
 */
public class RemoveTest extends RandomChangeTestCase {

	private EReference ref;
	
	public RemoveTest(String testName, long randomSeed) {
		super(testName, randomSeed);

	}

	@Override
	public void runTest() {

		List<ModelElement> modelElements = getTestProject()
				.getAllModelElements();
		int numOfMEs = modelElements.size();
		int numOfChanges = getRandom().nextInt(numOfMEs / 30);
		List<ModelElement> changedMEs = new ArrayList<ModelElement>();
		
		int i = 0;
		do {
			ModelElement meToChange = modelElements.get(getRandom().nextInt(
					numOfMEs - 1));
			if (hasEnoughContainments(meToChange)
					&& !changedMEs.contains(meToChange)) {

				changedMEs.add(meToChange);
				Object object = meToChange.eGet(ref);
				final EList<EObject> eList = (EList<EObject>) object;
				final int indexToRemove = eList.size() == 1 ? 0 : getRandom()
						.nextInt(eList.size());

				TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
						.getEditingDomain("org.unicase.EditingDomain");
				domain.getCommandStack().execute(new RecordingCommand(domain) {

					@Override
					protected void doExecute() {

						eList.remove(indexToRemove);

					}

				});
				
				i++;
			}
			
		} while (i < numOfChanges);

	}

	
	
	private boolean hasEnoughContainments(ModelElement me) {
		List<EReference> containments = me.eClass().getEAllContainments();
		if (containments.size() < 2) {
			return false;
		}

		EReference tmpRef = containments.get(getRandom().nextInt(
				containments.size() - 1));

		Object object = me.eGet(tmpRef);
		EList<EObject> eList = (EList<EObject>) object;

		if (eList == null || eList.size() == 0) {
			return false;
		}
		
		ref = tmpRef;
		return true;
	}

}



////=======================================================================
//package org.unicase.test.tests.changetests.randomchange.testcases;
//
//import java.util.List;
//
//import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EReference;
//import org.eclipse.emf.transaction.RecordingCommand;
//import org.eclipse.emf.transaction.TransactionalEditingDomain;
//import org.unicase.model.ModelElement;
//import org.unicase.test.tests.changetests.ChangeTestHelper;
//import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;
//
///**
// * 
// * This is change package test. It does the following: takes randomly a ME A
// * from test project, takes randomly one of its containment features, remove
// * randomly one of the contained MEs B from this feature.
// * 
// * The expected change package should contain two operations: 
// * - change operation: changed A.contRef 
// * - delete operation: deleted B
// * 
// * @author Hodaie
// * 
// */
//public class RemoveTest extends RandomChangeTestCase {
//
//	public RemoveTest(String testName, long randomSeed) {
//		super(testName, randomSeed);
//
//	}
//
//	@Override
//	public void runTest() {
//		
//		List<ModelElement> modelElements = ChangeTestHelper.getRandomMEs(
//				getTestProject(), 1, true);
//		ModelElement me = modelElements.get(0);
//		List<EReference> containments = me.eClass().getEAllContainments();
//		if (containments.size() < 2) {
//			return;
//		}
//
//		EReference ref = containments.get(getRandom().nextInt(
//				containments.size()));
//
//		Object object = me.eGet(ref);
//		final EList<EObject> eList = (EList<EObject>) object;
//
//		if (eList == null || eList.size() == 0) {
//			return;
//		}
//		final int indexToBeRemoved = eList.size() == 1 ? 0 : getRandom()
//				.nextInt(eList.size());
//
//		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
//				.getEditingDomain("org.unicase.EditingDomain");
//		domain.getCommandStack().execute(new RecordingCommand(domain) {
//
//			@Override
//			protected void doExecute() {
//
//				eList.remove(indexToBeRemoved);
//			}
//
//		});
//
//	}
//
//}
