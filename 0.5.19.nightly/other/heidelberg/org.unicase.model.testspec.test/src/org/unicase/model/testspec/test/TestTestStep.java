package org.unicase.model.testspec.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecFactory;


public class TestTestStep {
    TestStep testStep;
    HashMap<TestStepInput, String> inputIdentifierMap = new HashMap<TestStepInput, String>();
    HashMap<TestStepOutput, String> outputIdentifierMap = new HashMap<TestStepOutput, String>();
    @Before
    public void setUp() throws Exception {
        System.out.println("------------------Set up test-------------------");
        System.out.println("Create test step");
        this.testStep = TestspecFactory.eINSTANCE.createTestStep();
        System.out.println("Create test step inputs and add to test step");
        for (int i = 0; i < 50; i++) {
            TestStepInput newInput = TestspecFactory.eINSTANCE.createTestStepInput();
            this.testStep.getInput().add(newInput);
            this.inputIdentifierMap.put(newInput, newInput.getIdentifier());
        }
        System.out.println("Create test step outputs and add to test step");
        for (int i = 0; i < 50; i++) {
            TestStepOutput newOutput = TestspecFactory.eINSTANCE.createTestStepOutput();
            this.testStep.getOutput().add(newOutput);
            this.outputIdentifierMap.put(newOutput, newOutput.getIdentifier());
        }
        System.out.println("--------------FINISHED Set up test--------------");
    }
    @After
    public void tearDown() throws Exception {
  
    }
    
    @Test
    public void testGetInputByIdentifier() {
        System.out.println("Test get input by identifier");    
        for(Map.Entry<TestStepInput, String> entry : this.inputIdentifierMap.entrySet()) {
            String identifier = entry.getValue();
            assertEquals(entry.getKey(), this.testStep.getInputByIdentifier(identifier));   
        }
        assertNull(this.testStep.getInputByIdentifier("Some Identifier"));
        assertNull(this.testStep.getInputByIdentifier(null));
        System.out.println("PASSED");
    }
    
    @Test
    public void testGetOutputByIdentifier() {
        System.out.println("Test get output by identifier");    
        for(Map.Entry<TestStepOutput, String> entry : this.outputIdentifierMap.entrySet()) {
            String identifier = entry.getValue();
            assertEquals(entry.getKey(), this.testStep.getOutputByIdentifier(identifier));   
        }
        assertNull(this.testStep.getOutputByIdentifier("Some Identifier"));
        assertNull(this.testStep.getOutputByIdentifier(null));
        System.out.println("PASSED");
    }
}
