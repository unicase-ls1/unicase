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
import org.unicase.ui.test.TestProjectParmeters;

/**
 * This is a compare test. It takes randomly a ME from test project, changes one
 * of its EAttributes, extract changes from test project, applies changes to
 * compare project. Test succeeds when compare project and test project are
 * identical.
 * 
 * @author Hodaie
 * 
 */
public class ChangeSimpleAttributeTest extends RandomChangeTestCase implements
		IChangePackageTest {

	private static final int EXPECTED_NUM_OF_CHANGES = 1;

	
	
	public ChangeSimpleAttributeTest(String testName,TestProjectParmeters testProjParams) {
		super(testName, testProjParams);

	}

	@Override
	public void runTest() {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		final ModelElement me = ChangeTestHelper.getRandomME(getTestProject());

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				changeAttribute(me);
			}

		});

	}

	protected void changeAttribute(ModelElement me) {

		List<EAttribute> attributes = new ArrayList<EAttribute>();
		for (EAttribute attr : me.eClass().getEAllAttributes()) {
			if (attr.isChangeable() && attr.getFeatureID() != ModelPackage.MODEL_ELEMENT__IDENTIFIER) {
				attributes.add(attr);
			}
		}
	
		int size = attributes.size();
		EAttribute attribute = attributes.get(size == 1 ? 0 : getRandom().nextInt(size - 1));

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

	public int getExpectedNumOfChanges() {
		return EXPECTED_NUM_OF_CHANGES;
	}

	private Date getRandomDate() {
		return new Date();
	}

}
