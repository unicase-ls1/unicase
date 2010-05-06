package org.unicase.model.testspec.ui.test.commands;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecFactory;

public class TestDeleteMultipleMECommand {
    ArrayList<ModelElement> inputList = new ArrayList<ModelElement>();
    ArrayList<ModelElement> outputList = new ArrayList<ModelElement>();
    Project project;
    
    @Before
    public void setUp() throws Exception {
        System.out.println("------------------Set up test-------------------");
        System.out.println("Create project");
        this.project = MetamodelFactory.eINSTANCE.createProject();
        System.out.println("Create list of test step inputs");
        for (int i = 0; i < 50; i++) {
            TestStepInput newInput = TestspecFactory.eINSTANCE.createTestStepInput();
            this.inputList.add(newInput);
            this.project.addModelElement(newInput);
        }
        System.out.println("Create list of test step outputs");
        for (int i = 0; i < 50; i++) {
            TestStepOutput newOutput = TestspecFactory.eINSTANCE.createTestStepOutput();
            this.outputList.add(newOutput);
            this.project.addModelElement(newOutput);
        }
        System.out.println("--------------FINISHED Set up test--------------");
    }
    @After
    public void tearDown() throws Exception {
  
    }
    
    @Test
    public void testDeleteMultipleInputParameters () {
        System.out.println("Test delete multiple input parameters");
        try {
            for (int i = 0; i < this.inputList.size(); i++) {
                ModelElement input = this.inputList.get(i);
                assertTrue(this.project.contains(input));
                input.delete();
                assertFalse(this.project.contains(input));
            }
        } catch (Exception e) {
            assertNull(e);
        }
        System.out.println("PASSED");     
    }
    
    @Test
    public void testDeleteMultipleOutputParameters () {
        System.out.println("Test delete multiple output parameters");
        try {
            for (int i = 0; i < this.outputList.size(); i++) {
                ModelElement output = this.outputList.get(i);
                assertTrue(this.project.contains(output));
                output.delete();
                assertFalse(this.project.contains(output));
            }
        } catch (Exception e) {
            assertNull(e);
        }
        System.out.println("PASSED"); 
    }
}
