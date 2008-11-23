package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;

public class MoveTest extends RandomChangeTestCase {

	private int totalOps = 0;

	public MoveTest(String testName, long randomSeed) {
		super(testName, randomSeed);

	}

	@Override
	public void runTest() {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		doMove(domain);
		// runFullRandomTest(domain);

	}

	private void doMove(TransactionalEditingDomain domain) {

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				ModelElement me = ChangeTestHelper
						.getRandomME(getTestProject());

				List<EReference> containments = me.eClass()
						.getEAllContainments();

				while (containments.size() == 0) {
					me = ChangeTestHelper.getRandomME(getTestProject());
					containments = me.eClass().getEAllContainments();
				}

				EReference ref = containments
						.get(containments.size() == 1 ? 0 : getRandom()
								.nextInt(containments.size() - 1));
				EClass refType = ref.getEReferenceType();
				List<ModelElement> moveableMEs = getTestProject()
						.getAllModelElementsbyClass(refType,
								new BasicEList<ModelElement>());
				//to be sure....
				moveableMEs.remove(me);
				if (moveableMEs.size() == 0) {
					return;
				}

				int size = moveableMEs.size();
				ModelElement toBeMovedME = moveableMEs.get(size == 1 ? 0 : getRandom().nextInt(size - 1));
				while(EcoreUtil.isAncestor(toBeMovedME, me)){
					toBeMovedME = moveableMEs.get(size == 1 ? 0 : getRandom().nextInt(size - 1));
				}

				Object object = me.eGet(ref);
				if(ref.isMany()){
					EList<EObject> eList = (EList<EObject>) object;
					if(eList == null){
						List<Object> list = new ArrayList<Object>();
						list.add(toBeMovedME);
						me.eSet(ref, list);
					}else{
						eList.add(toBeMovedME);
					}
				}else{
					me.eSet(ref, toBeMovedME);
				}
				
				totalOps++;

			}

		});

	}

}
