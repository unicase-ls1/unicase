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
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;

/**
 * This is a ChangePackageTest.
 * This test takes a random ME A.
 * Change A.someSimpleAttribute = a
 * Change A.someSimpleAttribute = b
 * Change A.someSimpleAttribute = c
 * The expected change package should contain only one 
 * operation: value of A.someSimpleAttribute changed from a to c
 * 
 * 
 * @author Hodaie
 *
 */
public class TransitivelyChangeAttributeTest extends RandomChangeTestCase {

	

	public TransitivelyChangeAttributeTest(String testName, long randomSeed) {
		super(testName, randomSeed);
		
	}
	
	
	@Override
	public void runTest() {
		List<ModelElement> modelElements = getTestProject()
		.getAllModelElements();
		
		final ModelElement me = modelElements.get(getRandom().nextInt(
				modelElements.size() - 1));

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					changeSimpleAttribute(me);
				
				}

			});
		
		

	}


	protected void changeSimpleAttribute(ModelElement me) {
		List<EAttribute> attribs = me.eClass().getEAllAttributes();
		List<EAttribute> changeableAttribs = new ArrayList<EAttribute>();
		for(EAttribute attrib : attribs){
			if(attrib.getName().equalsIgnoreCase("identifier")){
				continue;
			}
			if(attrib.isChangeable()) {
				changeableAttribs.add(attrib);
			}
		}
		
		EAttribute attribToChange;
		if (changeableAttribs.size() < 2) {
			attribToChange = changeableAttribs.get(0);
		} else {
			attribToChange = changeableAttribs.get(getRandom().nextInt(
					changeableAttribs.size() - 1));
		}

		//attribute = a (initialization)
		if(!me.eIsSet(attribToChange)){
			changeAttribute(me, attribToChange);
		}
		
		//attribute = b
		changeAttribute(me, attribToChange);
		//attribute = c
		changeAttribute(me, attribToChange);
	}


	private void changeAttribute(ModelElement me, EAttribute attribute) {
		
		if (attribute.getEType().getInstanceClass().equals(String.class)) {
			String oldValue = (String) me.eGet(attribute);
			String newValue = "changed-" + oldValue;
			me.eSet(attribute, newValue);

		} else if (attribute.getEType().getInstanceClass()
				.equals(boolean.class)) {
			me.eSet(attribute, !((Boolean) me.eGet(attribute)));

		} else if (attribute.getEType().getInstanceClass().equals(int.class)) {
			me.eSet(attribute, getRandom().nextInt());

		} else if (attribute.getEType().getInstanceClass().equals(Date.class)) {
			me.eSet(attribute, getRandomDate());

		}
		if (attribute.getEType().getInstanceClass().equals(EEnum.class)) {
			EEnum en = (EEnum) attribute;
			int index = getRandom().nextInt(en.getELiterals().size());
			EEnumLiteral value = en.getELiterals().get(index);
			me.eSet(attribute, value);
		}

			
	}
	
	
	private Date getRandomDate() {
		return new Date();
	}

}
