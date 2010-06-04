package org.unicase.model.testspec.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.testspec.TestCase;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestspecFactory;

public class TestTestCase {
    TestCase testCase;
    HashMap<TestStep, String> stepIdentifierMap = new HashMap<TestStep, String>();
    @Before
    public void setUp() throws Exception {
        System.out.println("------------------Set up test-------------------");
        System.out.println("Create test case");
        this.testCase = TestspecFactory.eINSTANCE.createTestCase();
        System.out.println("Create test steps and add to test case");
        for (int i = 0; i < 50; i++) {
            TestStep newStep = TestspecFactory.eINSTANCE.createTestStep();
            this.testCase.getStep().add(newStep);
            this.stepIdentifierMap.put(newStep, newStep.getIdentifier());
        }
        System.out.println("--------------FINISHED Set up test--------------");
    }
    @After
    public void tearDown() throws Exception {
  
    }
    
    @Test
    public void testGetTestStepByIdentifier() {
        System.out.println("Test get test step by identifier");    
        for(Map.Entry<TestStep, String> entry : this.stepIdentifierMap.entrySet()) {
            String identifier = entry.getValue();
            assertEquals(entry.getKey(), this.testCase.getTestStepByIdentifier(identifier));   
        }
        assertNull(this.testCase.getTestStepByIdentifier("Some identifier"));
        assertNull(this.testCase.getTestStepByIdentifier(null));
        System.out.println("PASSED");
    } 
}
