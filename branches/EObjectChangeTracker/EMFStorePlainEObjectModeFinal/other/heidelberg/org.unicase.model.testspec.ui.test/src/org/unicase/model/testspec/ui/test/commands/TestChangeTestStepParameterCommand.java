package org.unicase.model.testspec.ui.test.commands;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.testspec.TestProtocol;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecFactory;

public class TestChangeTestStepParameterCommand {
    /**
     * Constant table column index.
     */
    private static final int COLUMN_NAME = 0;
    private static final int COLUMN_TYPE = 1;
    private static final int COLUMN_RANGE = 2;
    private static final int COLUMN_VALUE = 3;
    private static final int COLUMN_INVALID = 4;
    
    private static final String OLD_INPUT_NAME = "Old Input Name";
    private static final String OLD_INPUT_TYPE = "Old Input Type";
    private static final String OLD_INPUT_RANGE = "Old Input Range";
    private static final String OLD_INPUT_VALUE = "Old Input Value";
    
    private static final String OLD_OUTPUT_NAME = "Old Output Name";
    private static final String OLD_OUTPUT_TYPE = "Old Output Type";
    private static final String OLD_OUTPUT_RANGE = "Old Output Range";
    private static final String OLD_OUTPUT_VALUE = "Old Output Value";
    
    private TestStepInput testStepInput;
    private TestStepOutput testStepOutput;
    private String changedValue;
    private int columnIndex;
    private TestProtocol testProtocol;
    
    @Before
    public void setUp() throws Exception {
        System.out.println("------------------Set up test-------------------");
        System.out.println("Create test protocol");
        this.testProtocol = TestspecFactory.eINSTANCE.createTestProtocol();
        System.out.println("Create test step input");
        this.testStepInput = TestspecFactory.eINSTANCE.createTestStepInput();
        this.testStepInput.setName(OLD_INPUT_NAME);
        this.testStepInput.setType(OLD_INPUT_TYPE);
        this.testStepInput.setRange(OLD_INPUT_RANGE);
        this.testStepInput.getValues().put(testProtocol, OLD_INPUT_VALUE);
        System.out.println("Create test step output");
        this.testStepOutput = TestspecFactory.eINSTANCE.createTestStepOutput();
        this.testStepOutput.setName(OLD_OUTPUT_NAME);
        this.testStepOutput.setType(OLD_OUTPUT_TYPE);
        this.testStepOutput.setRange(OLD_OUTPUT_RANGE);
        this.testStepOutput.getValues().put(testProtocol, OLD_OUTPUT_VALUE);
        System.out.println("--------------FINISHED Set up test--------------");
    }
    @After
    public void tearDown() throws Exception {
  
    }
    
    @Test
    public void testChangeInputParameterName () {
        System.out.println("Test change input parameter name");
        this.columnIndex = COLUMN_NAME;
        this.changedValue = "New Input Name";
        new ChangeTestStepParameterCommand(this.testStepInput,
                this.changedValue, this.columnIndex, this.testProtocol).run();
        assertEquals(this.testStepInput.getName(), this.changedValue);
        assertEquals(this.testStepInput.getType(), OLD_INPUT_TYPE);
        assertEquals(this.testStepInput.getRange(), OLD_INPUT_RANGE);
        assertEquals(this.testStepInput.getValues().get(this.testProtocol), OLD_INPUT_VALUE);
        
        assertEquals(this.testStepOutput.getName(), OLD_OUTPUT_NAME);
        assertEquals(this.testStepOutput.getType(), OLD_OUTPUT_TYPE);
        assertEquals(this.testStepOutput.getRange(), OLD_OUTPUT_RANGE);
        assertEquals(this.testStepOutput.getValues().get(this.testProtocol), OLD_OUTPUT_VALUE);
        System.out.println("PASSED");
    }
    
    @Test
    public void testChangeInputParameterType () {
        System.out.println("Test change input parameter type");      
        this.columnIndex = COLUMN_TYPE;
        this.changedValue = "New Input Type";
        new ChangeTestStepParameterCommand(this.testStepInput,
                this.changedValue, this.columnIndex, this.testProtocol).run();
        assertEquals(this.testStepInput.getName(), OLD_INPUT_NAME);
        assertEquals(this.testStepInput.getType(), this.changedValue);
        assertEquals(this.testStepInput.getRange(), OLD_INPUT_RANGE);
        assertEquals(this.testStepInput.getValues().get(this.testProtocol), OLD_INPUT_VALUE);
        
        assertEquals(this.testStepOutput.getName(), OLD_OUTPUT_NAME);
        assertEquals(this.testStepOutput.getType(), OLD_OUTPUT_TYPE);
        assertEquals(this.testStepOutput.getRange(), OLD_OUTPUT_RANGE);
        assertEquals(this.testStepOutput.getValues().get(this.testProtocol), OLD_OUTPUT_VALUE);
        System.out.println("PASSED");
    }
    
    @Test
    public void testChangeInputParameterRange() {
        System.out.println("Test change input parameter range");      
        this.columnIndex = COLUMN_RANGE;
        this.changedValue = "New Input Range";
        new ChangeTestStepParameterCommand(this.testStepInput,
                this.changedValue, this.columnIndex, this.testProtocol).run();
        assertEquals(this.testStepInput.getName(), OLD_INPUT_NAME);
        assertEquals(this.testStepInput.getType(), OLD_INPUT_TYPE);
        assertEquals(this.testStepInput.getRange(), this.changedValue);
        assertEquals(this.testStepInput.getValues().get(this.testProtocol), OLD_INPUT_VALUE);
        
        assertEquals(this.testStepOutput.getName(), OLD_OUTPUT_NAME);
        assertEquals(this.testStepOutput.getType(), OLD_OUTPUT_TYPE);
        assertEquals(this.testStepOutput.getRange(), OLD_OUTPUT_RANGE);
        assertEquals(this.testStepOutput.getValues().get(this.testProtocol), OLD_OUTPUT_VALUE);
        System.out.println("PASSED");
    }
    
    @Test
    public void testChangeInputParameterValue() {
        System.out.println("Test change input parameter value");      
        this.columnIndex = COLUMN_VALUE;
        this.changedValue = "New Input Value";
        new ChangeTestStepParameterCommand(this.testStepInput,
                this.changedValue, this.columnIndex, this.testProtocol).run();
        assertEquals(this.testStepInput.getName(), OLD_INPUT_NAME);
        assertEquals(this.testStepInput.getType(), OLD_INPUT_TYPE);
        assertEquals(this.testStepInput.getRange(), OLD_INPUT_RANGE);
        assertEquals(this.testStepInput.getValues().get(this.testProtocol), this.changedValue);
        
        assertEquals(this.testStepOutput.getName(), OLD_OUTPUT_NAME);
        assertEquals(this.testStepOutput.getType(), OLD_OUTPUT_TYPE);
        assertEquals(this.testStepOutput.getRange(), OLD_OUTPUT_RANGE);
        assertEquals(this.testStepOutput.getValues().get(this.testProtocol), OLD_OUTPUT_VALUE);
        System.out.println("PASSED");
    }
    
    @Test
    public void testChangeOutputParameterName () {
        System.out.println("Test change output parameter name");
        this.columnIndex = COLUMN_NAME;
        this.changedValue = "New Output Name";
        new ChangeTestStepParameterCommand(this.testStepOutput,
                this.changedValue, this.columnIndex, this.testProtocol).run();
        assertEquals(this.testStepOutput.getName(), this.changedValue);
        assertEquals(this.testStepOutput.getType(), OLD_OUTPUT_TYPE);
        assertEquals(this.testStepOutput.getRange(), OLD_OUTPUT_RANGE);
        assertEquals(this.testStepOutput.getValues().get(this.testProtocol), OLD_OUTPUT_VALUE);
        
        assertEquals(this.testStepInput.getName(), OLD_INPUT_NAME);
        assertEquals(this.testStepInput.getType(), OLD_INPUT_TYPE);
        assertEquals(this.testStepInput.getRange(), OLD_INPUT_RANGE);
        assertEquals(this.testStepInput.getValues().get(this.testProtocol), OLD_INPUT_VALUE);
        System.out.println("PASSED");
    }
    
    @Test
    public void testChangeOutputParameterType () {
        System.out.println("Test change output parameter type");      
        this.columnIndex = COLUMN_TYPE;
        this.changedValue = "New Output Type";
        new ChangeTestStepParameterCommand(this.testStepOutput,
                this.changedValue, this.columnIndex, this.testProtocol).run();       
        assertEquals(this.testStepOutput.getName(), OLD_OUTPUT_NAME);
        assertEquals(this.testStepOutput.getType(), this.changedValue);
        assertEquals(this.testStepOutput.getRange(), OLD_OUTPUT_RANGE);
        assertEquals(this.testStepOutput.getValues().get(this.testProtocol), OLD_OUTPUT_VALUE);
        
        assertEquals(this.testStepInput.getName(), OLD_INPUT_NAME);
        assertEquals(this.testStepInput.getType(), OLD_INPUT_TYPE);
        assertEquals(this.testStepInput.getRange(), OLD_INPUT_RANGE);
        assertEquals(this.testStepInput.getValues().get(this.testProtocol), OLD_INPUT_VALUE);
        System.out.println("PASSED");
    }
    
    @Test
    public void testChangeOutputParameterRange() {
        System.out.println("Test change output parameter range");      
        this.columnIndex = COLUMN_RANGE;
        this.changedValue = "New Output Range";
        new ChangeTestStepParameterCommand(this.testStepOutput,
                this.changedValue, this.columnIndex, this.testProtocol).run();      
        assertEquals(this.testStepOutput.getName(), OLD_OUTPUT_NAME);
        assertEquals(this.testStepOutput.getType(), OLD_OUTPUT_TYPE);
        assertEquals(this.testStepOutput.getRange(), this.changedValue);
        assertEquals(this.testStepOutput.getValues().get(this.testProtocol), OLD_OUTPUT_VALUE);
        
        assertEquals(this.testStepInput.getName(), OLD_INPUT_NAME);
        assertEquals(this.testStepInput.getType(), OLD_INPUT_TYPE);
        assertEquals(this.testStepInput.getRange(), OLD_INPUT_RANGE);
        assertEquals(this.testStepInput.getValues().get(this.testProtocol), OLD_INPUT_VALUE);
        System.out.println("PASSED");
    }
    
    @Test
    public void testChangeOutputParameterValue() {
        System.out.println("Test change output parameter value");      
        this.columnIndex = COLUMN_VALUE;
        this.changedValue = "New Output Value";
        new ChangeTestStepParameterCommand(this.testStepOutput,
                this.changedValue, this.columnIndex, this.testProtocol).run();
        assertEquals(this.testStepOutput.getName(), OLD_OUTPUT_NAME);
        assertEquals(this.testStepOutput.getType(), OLD_OUTPUT_TYPE);
        assertEquals(this.testStepOutput.getRange(), OLD_OUTPUT_RANGE);
        assertEquals(this.testStepOutput.getValues().get(this.testProtocol), this.changedValue);
        
        assertEquals(this.testStepInput.getName(), OLD_INPUT_NAME);
        assertEquals(this.testStepInput.getType(), OLD_INPUT_TYPE);
        assertEquals(this.testStepInput.getRange(), OLD_INPUT_RANGE);
        assertEquals(this.testStepInput.getValues().get(this.testProtocol), OLD_INPUT_VALUE);
        System.out.println("PASSED");
    }
    
    @Test
    public void testInvalidColumnIndex() {
        System.out.println("Test invalid column index");      
        this.columnIndex = COLUMN_INVALID;
        this.changedValue = "Some Value";
        new ChangeTestStepParameterCommand(this.testStepInput,
                this.changedValue, this.columnIndex, this.testProtocol).run();
        assertEquals(this.testStepInput.getName(), OLD_INPUT_NAME);
        assertEquals(this.testStepInput.getType(), OLD_INPUT_TYPE);
        assertEquals(this.testStepInput.getRange(), OLD_INPUT_RANGE);
        assertEquals(this.testStepInput.getValues().get(this.testProtocol), OLD_INPUT_VALUE);
        
        new ChangeTestStepParameterCommand(this.testStepOutput,
                this.changedValue, this.columnIndex, this.testProtocol).run();
        assertEquals(this.testStepOutput.getName(), OLD_OUTPUT_NAME);
        assertEquals(this.testStepOutput.getType(), OLD_OUTPUT_TYPE);
        assertEquals(this.testStepOutput.getRange(), OLD_OUTPUT_RANGE);
        assertEquals(this.testStepOutput.getValues().get(this.testProtocol), OLD_OUTPUT_VALUE);
        System.out.println("PASSED");
    }
    
    @Test
    public void testInvalidModelElement() {
        System.out.println("Test invalid model element");      
        this.columnIndex = COLUMN_NAME;
        this.changedValue = "Some Value";
        new ChangeTestStepParameterCommand(this.testProtocol,
                this.changedValue, this.columnIndex, this.testProtocol).run();
        assertEquals(this.testStepInput.getName(), OLD_INPUT_NAME);
        
        new ChangeTestStepParameterCommand(this.testProtocol,
                this.changedValue, this.columnIndex, this.testProtocol).run();
        assertEquals(this.testStepOutput.getName(), OLD_OUTPUT_NAME);
        System.out.println("PASSED");
    }
    
    @Test
    public void testNullModelElement() {
        System.out.println("Test model element = null");      
        this.columnIndex = COLUMN_NAME;
        this.changedValue = "Some Value";
        new ChangeTestStepParameterCommand(null,
                this.changedValue, this.columnIndex, this.testProtocol).run();
        assertEquals(this.testStepInput.getName(), OLD_INPUT_NAME);
        
        new ChangeTestStepParameterCommand(null,
                this.changedValue, this.columnIndex, this.testProtocol).run();
        assertEquals(this.testStepOutput.getName(), OLD_OUTPUT_NAME);
        System.out.println("PASSED");
    }
}
