package org.unicase.test.tests.change.random.testcases;

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
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public class ContainmentReferenceMoveTest extends ChangePackageTest{


	private static final int EXPECTED_NUM_OF_CHANGES = 2;
	
	
	public ContainmentReferenceMoveTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		doMove(domain);

	}

	private void doMove(TransactionalEditingDomain domain) {

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@SuppressWarnings("unchecked")
			@Override
			protected void doExecute() {
				ModelElement me = ChangeTestHelper
						.getRandomME(getTestProject());

				List<EReference> containments = new ArrayList<EReference>();
				for(EReference containment : me.eClass().getEAllContainments()){
					if(!containment.isContainer()){
						containments.add(containment);
					}
				}
				

				while (containments.size() == 0) {
					me = ChangeTestHelper.getRandomME(getTestProject());
					for(EReference containment : me.eClass().getEAllContainments()){
						if(!containment.isContainer()){
							containments.add(containment);
						}
					}
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
						throw new IllegalStateException("Null list return for feature " + ref.getName() + " on " + me.getName());					
					}else{
						eList.add(toBeMovedME);
					}
				}else{
					me.eSet(ref, toBeMovedME);
				}
				

			}

		});

	}
	
	

	public int getExpectedNumOfChanges() {
		
		return EXPECTED_NUM_OF_CHANGES;
	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		//temp impl
		return EXPECTED_NUM_OF_CHANGES == 2;
	}

	
}
