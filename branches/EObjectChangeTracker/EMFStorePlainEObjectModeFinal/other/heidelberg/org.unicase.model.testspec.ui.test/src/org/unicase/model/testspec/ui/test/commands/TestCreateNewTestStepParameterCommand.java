package org.unicase.model.testspec.ui.test.commands;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecFactory;
import org.unicase.model.testspec.TestspecPackage;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.model.testspec.ui.test.commands.CreateNewTestStepParameterCommand;



public class TestCreateNewTestStepParameterCommand {

    private TestStep testStep;
    private TestStepInput testStepInput;
    private TestStepOutput testStepOutput;
    private Project project;
    private int classifierID;
   
    private static final String INPUT_DEFAULT_NAME = "new Input";
    private static final String OUTPUT_DEFAULT_NAME = "new Output";

    @Before
    public void setUp() throws Exception {
        System.out.println("------------------Set up test-------------------");
        System.out.println("Create test step");
        this.testStep = TestspecFactory.eINSTANCE.createTestStep();
        System.out.println("Create test step input");
        this.testStepInput = TestspecFactory.eINSTANCE.createTestStepInput();
        System.out.println("Create test step output");
        this.testStepOutput = TestspecFactory.eINSTANCE.createTestStepOutput();
        System.out.println("Create project");
        this.project = MetamodelFactory.eINSTANCE.createProject();
        System.out.println("Add test step to project");
        this.project.addModelElement(this.testStep);
        System.out.println("Add test step input to test step");
        this.testStep.getInput().add(this.testStepInput);
        System.out.println("Add test step output to test step");
        this.testStep.getOutput().add(this.testStepOutput);
        System.out.println("--------------FINISHED Set up test--------------");
    }

    @After
    public void tearDown() throws Exception {
  
    }
    
    @Test
    public void testCreateTestStepInput() {
        System.out.println("Test create test step input");
        this.classifierID = TestspecPackage.TEST_STEP_INPUT;
        new CreateNewTestStepParameterCommand(this.testStep,
                this.classifierID).run();
        assertTrue(this.testStep.getInput().size() == 2);
        assertTrue(this.testStep.getOutput().size() == 1);
        TestStepInput newCreatedInput = this.testStep.getInput().get(1);
        assertEquals(INPUT_DEFAULT_NAME, newCreatedInput.getName());
        assertTrue(this.project.contains(newCreatedInput));
        System.out.println("PASSED");
    }
    
    @Test
    public void testCreateTestStepOutput() {
        System.out.println("Test create test step output");
        this.classifierID = TestspecPackage.TEST_STEP_OUTPUT;
        new CreateNewTestStepParameterCommand(this.testStep,
                this.classifierID).run();
        assertTrue(this.testStep.getOutput().size() == 2);
        assertTrue(this.testStep.getInput().size() == 1);
        TestStepOutput newCreatedOutput = this.testStep.getOutput().get(1);
        assertEquals(OUTPUT_DEFAULT_NAME, newCreatedOutput.getName());
        assertTrue(this.project.contains(newCreatedOutput));
        System.out.println("PASSED");
    }
    
    @Test
    public void testNegativeCaseNotRightClassifierID() {
        System.out.println("Test not right classifier id");
        this.classifierID = TestspecPackage.TEST_STEP_INPUT + TestspecPackage.TEST_STEP_OUTPUT;
        new CreateNewTestStepParameterCommand(this.testStep,
                this.classifierID).run();
        assertTrue(this.testStep.getOutput().size() == 1);
        assertTrue(this.testStep.getInput().size() == 1);
        assertTrue(this.project.getAllModelElements().size() == 3);
        System.out.println("PASSED");
    }
    
    @Test
    public void testNegativeCaseTestStepNull() {
        System.out.println("Test test step = null");
        this.classifierID = TestspecPackage.TEST_STEP_INPUT;
        new CreateNewTestStepParameterCommand(null,
                this.classifierID).run();
        assertTrue(this.testStep.getOutput().size() == 1);
        assertTrue(this.testStep.getInput().size() == 1);
        assertTrue(this.project.getAllModelElements().size() == 3);
        
        this.classifierID = TestspecPackage.TEST_STEP_OUTPUT;
        new CreateNewTestStepParameterCommand(null,
                this.classifierID).run();
        assertTrue(this.testStep.getOutput().size() == 1);
        assertTrue(this.testStep.getInput().size() == 1);
        assertTrue(this.project.getAllModelElements().size() == 3);
        
        this.classifierID = TestspecPackage.TEST_STEP_INPUT + TestspecPackage.TEST_STEP_OUTPUT;
        new CreateNewTestStepParameterCommand(null,
                this.classifierID).run();
        assertTrue(this.testStep.getOutput().size() == 1);
        assertTrue(this.testStep.getInput().size() == 1);
        assertTrue(this.project.getAllModelElements().size() == 3);
        System.out.println("PASSED");
    }
}
