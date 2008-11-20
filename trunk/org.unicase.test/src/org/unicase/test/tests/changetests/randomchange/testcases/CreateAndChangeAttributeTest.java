package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.randomchange.IChangePackageTest;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;

/**
 * 
 * This is change package test. It does the following: creates randomly a ME A
 * in test project, changes randomly one of its simple attributes attr
 * 
 * The expected change package should contain only one operation: -create
 * operation: created A (note that A.attr should be set)
 * 
 * @author Hodaie
 * 
 */

public class CreateAndChangeAttributeTest extends RandomChangeTestCase implements IChangePackageTest{

	private static final int EXPECTED_NUM_OF_CHANGES = 1;
	
	
	public CreateAndChangeAttributeTest(String testName, long randomSeed) {
		super(testName, randomSeed);

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
				//me.setName("newly created " + me.eClass().getName());
				changeRandomAttribute(me);
			}

		});

	}
	
	
	
	
	protected boolean changeRandomAttribute(ModelElement me) {

		List<EAttribute> attributes = new ArrayList<EAttribute>();
		for (EAttribute attr : me.eClass().getEAllAttributes()) {
			if (attr.isChangeable() && attr.getFeatureID() != ModelPackage.MODEL_ELEMENT__IDENTIFIER){
				attributes.add(attr);
			}
		}
	
		EAttribute attribute = attributes.size() == 1 ? attributes.get(0)
				: attributes.get(getRandom().nextInt(attributes.size() - 1));

		
		if (attribute.getEType().getInstanceClass().equals(String.class)) {
			String oldValue = (String) me.eGet(attribute);
			String newValue = "changed-" + oldValue;
			me.eSet(attribute, newValue);
			return true;

		} else if (attribute.getEType().getInstanceClass()
				.equals(boolean.class)) {
			if(!me.eIsSet(attribute)){
				me.eSet(attribute, getRandom().nextBoolean());
			}else{
				me.eSet(attribute, !((Boolean) me.eGet(attribute)));
			}
			
			return true;

		} else if (attribute.getEType().getInstanceClass().equals(int.class)) {
			me.eSet(attribute, getRandom().nextInt());
			return true;

		} else if (attribute.getEType().getInstanceClass().equals(Date.class)) {
			me.eSet(attribute, getRandomDate());
			return true;

		}
		if (attribute.getEType().getInstanceClass().equals(EEnum.class)) {
			EEnum en = (EEnum) attribute;
			int index = getRandom().nextInt(en.getELiterals().size());
			EEnumLiteral value = en.getELiterals().get(index);
			me.eSet(attribute, value);
			return true;
		}

		return false;

	}

	private Date getRandomDate() {
		return new Date();
	}

	public int getExpectedNumOfChanges() {
		return EXPECTED_NUM_OF_CHANGES;
	}

}
