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
import org.unicase.model.Project;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.IChangePackageTest;
import org.unicase.test.tests.change.random.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;


/**
 * 
 * This is a change package test.
 * It creates randomly a model element, changes one of its non-containment references,
 * and deletes this ME. 
 * The expected change package should contain no operations.
 * 
 * @author Hodaie
 *
 */
public class CreateAndDeleteTest extends RandomChangeTestCase implements IChangePackageTest{

	private static final int EXPECTED_NUM_OF_CHANGES = 0;
	
	public CreateAndDeleteTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {
		final ModelElement me = ChangeTestHelper.createRandomME();
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					getTestProject().getModelElements().add(me);
					changeSimpleRef(me);
					deleteME(me);
				}

			});
		
		

	}

	
	private void changeSimpleRef(ModelElement me) {
		
		List<EReference> nonContainmentRefs = new ArrayList<EReference>();
		for (EReference ref : me.eClass().getEAllReferences()) {
			if (!ref.isContainment()) {
				nonContainmentRefs.add(ref);
			}
		}
		
		EReference ref = nonContainmentRefs.get(getRandom().nextInt(
				nonContainmentRefs.size() - 1));
		EClass refType = ref.getEReferenceType();
		List<ModelElement> refTypeMEs = getTestProject()
				.getAllModelElementsbyClass(refType,
						new BasicEList<ModelElement>());
		
		ModelElement toBeReferencedME = refTypeMEs.get(getRandom().nextInt(refTypeMEs.size() - 1));
		
		Object object = me.eGet(ref);
		if(ref.isMany()){
			EList<EObject> eList = (EList<EObject>) object;
			if(eList == null){
				throw new IllegalStateException("Null list return for feature " + ref.getName() + " on " + me.getName()); 
			}else{
				eList.add(toBeReferencedME);
			}
		}else{
			me.eSet(ref, toBeReferencedME);
		}
		

	}
	
	
	protected void deleteME(ModelElement me) {
		//EcoreUtil.delete(me, true);
		EcoreUtil.delete(me);
	}

	public int getExpectedNumOfChanges() {
		// TODO Auto-generated method stub
		return EXPECTED_NUM_OF_CHANGES;
	}

	public boolean isSuccessful() {
		//temp impl
		return EXPECTED_NUM_OF_CHANGES == 0;
	}

	
}
