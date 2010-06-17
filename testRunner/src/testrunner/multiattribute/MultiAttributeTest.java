package testrunner.multiattribute;

import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.workspace.util.UnicaseCommand;

import testModel.TestElement;
import testModel.TestModelFactory;
import testrunner.test.WorkspaceTest;

public class MultiAttributeTest extends WorkspaceTest {

	
	
	@Test
	public void test() {
		
		new UnicaseCommand() {
			protected void doRun() {
				TestElement testElement = getTestElement();
				
//				testElement.getValues().add("firstTestValue");
				testElement.getValues().add("secondTestValue");
				testElement.getValues().add("secondTestValue");
				testElement.getValues().addAll(Arrays.asList("third","forth"));
				
				testElement.getValues().remove("secondTestValue");
				
				System.out.println(testElement.getValues());
			}
		}.run();
		plotOperations();
	}
	
	@Test
	public void applyTest() {
		new UnicaseCommand() {
			protected void doRun() {
				TestElement testElement = getTestElement();
				
				assertTrue(testElement.getValues().size()==0);
				
				MultiAttributeOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeOperation();
				operation.setAdd(true);
				operation.setFeatureName("values");
				operation.setIndex(0);
				operation.getReferencedValues().add("inserted");
				operation.setModelElementId(testElement.getModelElementId());
				
				operation.apply(getProject());
				
				assertTrue(testElement.getValues().size()==1);
				assertTrue(testElement.getValues().get(0).equals("inserted"));
			}
		}.run();
	}
	
	
	
	
	private void plotOperations() {
		for(AbstractOperation op : getProjectSpace().getOperations()) {
			System.out.println(op);
		}
	}

	private TestElement getTestElement() {
		TestElement element = TestModelFactory.eINSTANCE.createTestElement();
		getProject().getModelElements().add(element);
		return element;
	}
}
