package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;

public class MoveTest extends RandomChangeTestCase {

	
	private int totalOps = 0;

	public MoveTest(String testName, long randomSeed) {
		super(testName, randomSeed);

	}

	@Override
	public void runTest() {

		System.out.println("getting list of all model elements in project...");
		final List<ModelElement> modelElements = getTestProject()
				.getAllModelElements();
		System.out.println(modelElements.size() + " MEs in project...");

		int numOfChanges = getRandom().nextInt(modelElements.size() / 4);

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		
		//runSimpleTest(modelElements, numOfChanges, domain);
		runFullRandomTest(modelElements, numOfChanges, domain);

	}

	private void runSimpleTest(final List<ModelElement> modelElements, int numOfChanges, TransactionalEditingDomain domain) {
		
		for (int i = 0; i < numOfChanges; i++) {

			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					ModelElement me = modelElements.get(getRandom().nextInt(
							modelElements.size() - 1));

					List<EReference> containments = me.eClass()
							.getEAllContainments();
					if (containments.size() == 0) {
						return;
					}
					EReference ref = containments.get(0);
					EClass refType = ref.getEReferenceType();
					List<ModelElement> moveableMEs = getTestProject()
							.getAllModelElementsbyClass(refType,
									new BasicEList<ModelElement>());
					if (moveableMEs.size() == 0) {
						return;
					}

					ModelElement toBeMovedME = moveableMEs.get(0);

					Object object = me.eGet(ref);
					EList<EObject> eList = (EList<EObject>) object;
					eList.add(toBeMovedME);
					totalOps++;

				}

			});
		}

		System.out.println(getTestName() + "; " + totalOps + " moves");

	}

	private void runFullRandomTest(final List<ModelElement> modelElements, int numOfChanges, TransactionalEditingDomain domain) {
		
		for (int i = 0; i < numOfChanges; i++) {

			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					final ModelElement me = modelElements.get(getRandom()
							.nextInt(modelElements.size() - 1));

					List<EReference> containments = me.eClass().getEAllContainments();
					if (containments.size() == 0) {
						return;
					}
					final EReference ref = containments
							.get(containments.size() == 1 ? 0 : getRandom()
									.nextInt(containments.size() - 1));
					EClass refType = ref.getEReferenceType();
					final List<ModelElement> moveableMEs = getTestProject()
							.getAllModelElementsbyClass(refType,
									new BasicEList<ModelElement>());
					if (moveableMEs.size() < 2) {
						return;
					}
					final int maxNumOfMoves = Math.min(10, moveableMEs.size());
					List<ModelElement> toBeMovedMEs = new ArrayList<ModelElement>();
					int numOfMoves = getRandom().nextInt(maxNumOfMoves);
					for (int j = 0; j < numOfMoves; j++) {
						ModelElement toBeMovedME = moveableMEs.get(getRandom()
								.nextInt(moveableMEs.size() - 1));
						if (!toBeMovedMEs.contains(toBeMovedME)) {
							toBeMovedMEs.add(toBeMovedME);
							totalOps++;
						}

					}

					// //since moving many elements is not yet supported in
					// ProjectSpaceImp()
					// //we cannot use the following simple method.
					// //we must loop over toBeMovedMEs and add them
					// individually.

					// Object object = me.eGet(ref);
					// EList<EObject> eList = (EList<EObject>) object;
					// eList.addAll(toBeMovedMEs);
					Object object = me.eGet(ref);
					EList<EObject> eList = (EList<EObject>) object;
					for (ModelElement me2 : toBeMovedMEs) {
						eList.add(me2);
					}
				}

			});
		}

		System.out.println(getTestName() + "; " + totalOps + " moves");

	}


}

