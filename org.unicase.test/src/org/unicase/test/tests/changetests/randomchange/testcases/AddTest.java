package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.randomchange.IChangePackageTest;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;

/**
 * 
 * This test takes a random ME A; Takes randomly one of its containment
 * references contRef; Creates a model element of corresponding type; adds newly
 * created ME to A.contRef; extracts changes on test project and applies them on
 * compare project; Test succeeds when test and compare projects are identical.
 * 
 * 
 * 
 * @author Hodaie
 * 
 */
public class AddTest extends RandomChangeTestCase  implements IChangePackageTest{

	private int totalOps;
	private static final int EXPECTED_NUM_OF_CHANGES = 2;
	
	

	public AddTest(String testName, long randomSeed) {
		super(testName, randomSeed);

	}

	@Override
	public void runTest() {


		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		runSimpleTest(domain);
		//runFullRandomTest(domain);

	}

	private void runSimpleTest(TransactionalEditingDomain domain) {

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

				EReference ref = containments.get(0);
				EClass refType = ref.getEReferenceType();

				ModelElement newInstance = ChangeTestHelper
						.createInstance(refType);

				if (newInstance == null) {
					return;
				}

				Object object = me.eGet(ref);
				EList<EObject> eList = (EList<EObject>) object;
				eList.add(newInstance);
				totalOps++;

			}

		});

	}

	private void runFullRandomTest(TransactionalEditingDomain domain) {

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

				final EReference ref = containments
						.get(containments.size() == 1 ? 0 : getRandom()
								.nextInt(containments.size() - 1));
				EClass refType = ref.getEReferenceType();

				ModelElement newInstance = ChangeTestHelper
						.createInstance(refType);

				if (newInstance == null) {
					return;
				}

				
				Object object = me.eGet(ref);
				if(ref.isMany()){
					EList<EObject> eList = (EList<EObject>) object;
					if(eList == null){
						List<Object> list = new ArrayList<Object>();
						list.add(newInstance);
						me.eSet(ref, list);
					}else{
						eList.add(newInstance);
					}
				}else{
					me.eSet(ref, newInstance);
				}
				
				totalOps++;

			}

		});

	}


	public int getExpectedNumOfChanges() {
		return EXPECTED_NUM_OF_CHANGES;
	}

}
