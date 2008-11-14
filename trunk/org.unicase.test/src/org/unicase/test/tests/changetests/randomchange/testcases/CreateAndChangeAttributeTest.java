package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.changetests.ChangeTestHelper;
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

public class CreateAndChangeAttributeTest extends RandomChangeTestCase {

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
				me.setName("newly created " + me.eClass().getName());
				//changeRandomAttribute(me);
			}

		});

	}
	
	
	
	
	protected boolean changeRandomAttribute(ModelElement me) {

		List<EAttribute> attributes = new ArrayList<EAttribute>();
		attributes.addAll(me.eClass().getEAllAttributes());
		EAttribute identifier = null;
		for(EAttribute attr : attributes){
			if(attr.getName().equalsIgnoreCase("identifier")){
				identifier = attr;
			}
		}
		if(identifier != null){
			attributes.remove(identifier);
		}
		
		EAttribute attribute = null;

		if (attributes.size() < 2) {
			attribute = attributes.get(0);
		} else {
			attribute = attributes.get(getRandom().nextInt(
					attributes.size() - 1));
		}

		if (!attribute.isChangeable()) {
			return false;
		}

		if (attribute.getEType().getInstanceClass().equals(String.class)) {
			String oldValue = (String) me.eGet(attribute);
			String newValue = "changed-" + oldValue;
			me.eSet(attribute, newValue);
			return true;

		} else if (attribute.getEType().getInstanceClass()
				.equals(boolean.class)) {
			me.eSet(attribute, !((Boolean) me.eGet(attribute)));
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

}
