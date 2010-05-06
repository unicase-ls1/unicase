package org.unicase.model.testspec.ui.test.tableprovider;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecFactory;
import org.unicase.model.testspec.ui.editor.tableprovider.TestStepTreeContentProvider;

public class TestTestStepTreeContentProvider {

    TestStepTreeContentProvider provider;
    TestStep testStep;
    ArrayList<ModelElement> parameterList = new ArrayList<ModelElement>();

    @Before
    public void setUp() throws Exception {
        System.out.println("------------------Set up test-------------------");
        System.out.println("Create provider");
        this.provider = new TestStepTreeContentProvider();
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
            this.parameterList.add(newInput);
            this.parameterList.add(newOutput);
        }
        System.out.println("--------------FINISHED Set up test--------------");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetChildren() {
        System.out.println("Test getChildren");
        assertTrue(this.provider.getChildren(null).length == 0);
        assertTrue(this.provider.getChildren(this.testStep.getInput().get(0)).length == 0);
        Object[] children = this.provider.getChildren(this.testStep);
        assertTrue(children.length == parameterList.size());
        for (int i = 0; i < children.length; i++) {
            assertTrue(parameterList.contains(children[i]));
        }
        System.out.println("PASSED");
    }

    @Test
    public void testGetParent() {
        System.out.println("Test getParent");
        assertNull(this.provider.getParent(null));
        assertNull(this.provider.getParent(this.testStep));
        for (int i = 0; i < parameterList.size(); i++) {
            assertEquals(this.testStep, this.provider.getParent(parameterList
                    .get(i)));
        }
        System.out.println("PASSED");
    }

    @Test
    public void testHasChildren() {
        System.out.println("Test hasChildren");
        assertFalse(this.provider.hasChildren(null));
        assertFalse(this.provider.hasChildren(this.testStep.getInput().get(0)));
        assertTrue(this.provider.hasChildren(this.testStep));
        System.out.println("PASSED");
    }

    @Test
    public void testGetElements() {
        System.out.println("Test getElements");
        BasicEList<TestStep> stepList = new BasicEList<TestStep>();
        stepList.add(this.testStep);
        for (int i = 1; i < 50; i++) {
            stepList.add(TestspecFactory.eINSTANCE.createTestStep());
        }
        assertNull(this.provider.getElements(null));
        assertNull(this.provider.getElements("Test"));
        Object[] elements = this.provider.getElements(stepList);
        assertTrue(elements.length == stepList.size());
        for (int i = 0; i < stepList.size(); i++) {
            assertTrue(stepList.contains(elements[i]));
        }
        System.out.println("PASSED");
    }
}
