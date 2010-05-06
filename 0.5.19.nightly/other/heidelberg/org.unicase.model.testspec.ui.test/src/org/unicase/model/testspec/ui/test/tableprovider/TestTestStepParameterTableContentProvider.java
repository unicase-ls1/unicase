package org.unicase.model.testspec.ui.test.tableprovider;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.BasicEList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecFactory;
import org.unicase.model.testspec.ui.editor.tableprovider.TestStepParameterTableContentProvider;

public class TestTestStepParameterTableContentProvider {

    TestStepParameterTableContentProvider provider;
    private TestStep testStep;
    BasicEList<TestStepInput> inputList = new BasicEList<TestStepInput>();
    BasicEList<TestStepOutput> outputList = new BasicEList<TestStepOutput>();

    @Before
    public void setUp() throws Exception {
        System.out.println("------------------Set up test-------------------");
        System.out.println("Create provider");
        this.provider = new TestStepParameterTableContentProvider();
        System.out.println("Create test step");
        this.testStep = TestspecFactory.eINSTANCE.createTestStep();
        System.out.println("Create test step parameters and add to test step");
        for (int i = 0; i < 50; i++) {
            TestStepInput newInput = TestspecFactory.eINSTANCE
                    .createTestStepInput();
            TestStepOutput newOutput = TestspecFactory.eINSTANCE
                    .createTestStepOutput();
            this.testStep.getInput().add(newInput);
            this.testStep.getOutput().add(newOutput);
            this.inputList.add(newInput);
            this.outputList.add(newOutput);
        }
        System.out.println("--------------FINISHED Set up test--------------");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetElements() {
        System.out.println("Test getElements");
        assertNull(this.provider.getElements(null));
        assertNull(this.provider.getElements("Test"));
        Object[] elements = this.provider.getElements(inputList);
        assertTrue(elements.length == inputList.size());
        for (int i = 0; i < inputList.size(); i++) {
            assertTrue(inputList.contains(elements[i]));
        }
        Object[] elements2 = this.provider.getElements(outputList);
        assertTrue(elements2.length == outputList.size());
        for (int i = 0; i < outputList.size(); i++) {
            assertTrue(outputList.contains(elements2[i]));
        }
        System.out.println("PASSED");
    }
}
