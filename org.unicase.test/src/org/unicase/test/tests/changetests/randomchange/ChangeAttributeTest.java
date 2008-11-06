package org.unicase.test.tests.changetests.randomchange;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;

public class ChangeAttributeTest extends RandomChangeTestCase {

	private int totalChanges = 0;

	public ChangeAttributeTest(String testName, long randomSeed) {
		super(testName, randomSeed);

	}

	@Override
	public void runTest() {

		List<ModelElement> modelElements = getTestProject()
				.getAllModelElements();
		System.out.println(modelElements.size() + " MEs");
		int numOfChanges = getRandom().nextInt(modelElements.size() / 8);
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		for (int i = 0; i < numOfChanges; i++) {
			final ModelElement me = modelElements.get(getRandom().nextInt(
					modelElements.size() - 1));

			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					if (changeAttribute(me)) {
						totalChanges++;
					}
				}

			});
		}

		System.out.println(ChangeAttributeTest.class.getSimpleName() + "; "
				+ totalChanges + " attribute changes");

	}

	
	
	protected boolean changeAttribute(ModelElement me) {

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

// //========================================================================00
// List<ModelElement> modelElements = getTestProject()
// .getAllModelElements();
// System.out.println(modelElements.size() + " MEs");
// int numOfChanges = getRandom().nextInt(modelElements.size() / 8);
// TransactionalEditingDomain domain =
// TransactionalEditingDomain.Registry.INSTANCE
// .getEditingDomain("org.unicase.EditingDomain");
// System.out.println(numOfChanges + " renames");
// for (int i = 0; i < numOfChanges; i++) {
// final ModelElement me = modelElements.get(getRandom().nextInt(modelElements
// .size() - 1));
// final String oldName = me.getName();
// domain.getCommandStack().execute(new RecordingCommand(domain){
//
// @Override
// protected void doExecute() {
// me.setName("Changed-" + oldName);
// }
//
// });
// }
//
// System.out.println(ChangeAttributeTest.class.getSimpleName() + "; " +
// numOfChanges + " renames");
