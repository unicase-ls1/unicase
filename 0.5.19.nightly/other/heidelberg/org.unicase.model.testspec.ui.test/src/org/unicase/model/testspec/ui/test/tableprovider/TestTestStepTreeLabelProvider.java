package org.unicase.model.testspec.ui.test.tableprovider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.swt.graphics.Image;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.testspec.TestProtocol;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecFactory;
import org.unicase.model.testspec.ui.editor.tableprovider.TestStepTreeLabelProvider;

public class TestTestStepTreeLabelProvider {

    private static final int COLUMN_NAME = 0;
    private static final int COLUMN_TYPE = 1;
    private static final int COLUMN_RANGE = 2;
    private static final int COLUMN_VALUE = 3;
    private static final int COLUMN_ID = 4;
    private static final int COLUMN_ELEMENT_TYPE = 5;
    private static final int COLUMN_INVALID = 6;

    private static final String INPUT_NAME = "Input Name";
    private static final String INPUT_TYPE = "Input Type";
    private static final String INPUT_RANGE = "Input Range";
    private static final String INPUT_VALUE = "Input Value";
    private static final String INPUT_ID = "Input ID";

    private static final String OUTPUT_NAME = "Output Name";
    private static final String OUTPUT_TYPE = "Output Type";
    private static final String OUTPUT_RANGE = "Output Range";
    private static final String OUTPUT_VALUE = "Output Value";
    private static final String OUTPUT_ID = "Output ID";

    private static final String STEP_NAME = "Step Name";
    private static final String STEP_ID = "Step ID";
    private static final String EMPTY = "";

    private TestStep testStep;
    private TestStepInput testStepInput;
    private TestStepOutput testStepOutput;
    private TestProtocol testProtocol;
    private TestStepTreeLabelProvider provider;
    private Image image;

    @Before
    public void setUp() throws Exception {
        System.out.println("------------------Set up test-------------------");
        System.out.println("Create test protocol");
        this.testProtocol = TestspecFactory.eINSTANCE.createTestProtocol();
        System.out.println("Create provider");
        this.provider = new TestStepTreeLabelProvider(this.testProtocol);
        System.out.println("Create test step");
        this.testStep = TestspecFactory.eINSTANCE.createTestStep();
        this.testStep.setName(STEP_NAME);
        this.testStep.setIdentifier(STEP_ID);
        System.out.println("Create test step parameters");
        this.testStepInput = TestspecFactory.eINSTANCE.createTestStepInput();
        this.testStepInput.setName(INPUT_NAME);
        this.testStepInput.setType(INPUT_TYPE);
        this.testStepInput.setRange(INPUT_RANGE);
        this.testStepInput.getValues().put(this.testProtocol, INPUT_VALUE);
        this.testStepInput.setIdentifier(INPUT_ID);
        this.testStepOutput = TestspecFactory.eINSTANCE.createTestStepOutput();
        this.testStepOutput.setName(OUTPUT_NAME);
        this.testStepOutput.setType(OUTPUT_TYPE);
        this.testStepOutput.setRange(OUTPUT_RANGE);
        this.testStepOutput.getValues().put(this.testProtocol, OUTPUT_VALUE);
        this.testStepOutput.setIdentifier(OUTPUT_ID);

        System.out.println("--------------FINISHED Set up test--------------");
    }

    @After
    public void tearDown() throws Exception {
        System.out
                .println("------------------Tear down test-------------------");
        if (this.image != null) {
            this.image.dispose();
        }
        System.out.println("------------FINISHED Tear down test--------------");
    }

    @Test
    public void testGetColumnImageNotNameColumn() {
        System.out.println("Test getColumnImage for not name column");
        this.image = this.provider.getColumnImage(this.testStep, COLUMN_TYPE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(this.testStep, COLUMN_RANGE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(this.testStep, COLUMN_VALUE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(this.testStep, COLUMN_ID);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(this.testStep,
                COLUMN_ELEMENT_TYPE);
        assertNull(this.image);

        this.image = this.provider.getColumnImage(this.testStepInput,
                COLUMN_TYPE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(this.testStepInput,
                COLUMN_RANGE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(this.testStepInput,
                COLUMN_VALUE);
        assertNull(this.image);
        this.image = this.provider
                .getColumnImage(this.testStepInput, COLUMN_ID);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(this.testStepInput,
                COLUMN_ELEMENT_TYPE);
        assertNull(this.image);

        this.image = this.provider.getColumnImage(this.testStepOutput,
                COLUMN_TYPE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(this.testStepOutput,
                COLUMN_RANGE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(this.testStepOutput,
                COLUMN_VALUE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(this.testStepOutput,
                COLUMN_ID);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(this.testStepOutput,
                COLUMN_ELEMENT_TYPE);
        assertNull(this.image);
        System.out.println("PASSED");
    }

    @Test
    public void testGetColumnImageNameColumn() {
        System.out.println("Test getColumnImage for name column");
        this.image = this.provider.getColumnImage(this.testStep, COLUMN_NAME);
        assertNotNull(this.image);
        assertTrue(this.image instanceof Image);

        this.image = this.provider.getColumnImage(this.testStepInput,
                COLUMN_NAME);
        assertNotNull(this.image);
        assertTrue(this.image instanceof Image);

        this.image = this.provider.getColumnImage(this.testStepOutput,
                COLUMN_NAME);
        assertNotNull(this.image);
        assertTrue(this.image instanceof Image);
        System.out.println("PASSED");
    }

    @Test
    public void testGetColumnImageInvalidElement() {
        System.out.println("Test getColumnImage with invalid element");
        this.image = this.provider.getColumnImage(null, COLUMN_NAME);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(null, COLUMN_TYPE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(null, COLUMN_RANGE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(null, COLUMN_VALUE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(null, COLUMN_ID);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(null, COLUMN_ELEMENT_TYPE);
        assertNull(this.image);

        this.image = this.provider.getColumnImage((TestStep) null, COLUMN_NAME);
        assertNull(this.image);
        this.image = this.provider.getColumnImage((TestStep) null, COLUMN_TYPE);
        assertNull(this.image);
        this.image = this.provider
                .getColumnImage((TestStep) null, COLUMN_RANGE);
        assertNull(this.image);
        this.image = this.provider
                .getColumnImage((TestStep) null, COLUMN_VALUE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage((TestStep) null, COLUMN_ID);
        assertNull(this.image);
        this.image = this.provider.getColumnImage((TestStep) null,
                COLUMN_ELEMENT_TYPE);
        assertNull(this.image);

        this.image = this.provider.getColumnImage((TestStepInput) null,
                COLUMN_NAME);
        assertNull(this.image);
        this.image = this.provider.getColumnImage((TestStepInput) null,
                COLUMN_TYPE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage((TestStepInput) null,
                COLUMN_RANGE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage((TestStepInput) null,
                COLUMN_VALUE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage((TestStepInput) null,
                COLUMN_ID);
        assertNull(this.image);
        this.image = this.provider.getColumnImage((TestStepInput) null,
                COLUMN_ELEMENT_TYPE);
        assertNull(this.image);

        this.image = this.provider.getColumnImage((TestStepOutput) null,
                COLUMN_NAME);
        assertNull(this.image);
        this.image = this.provider.getColumnImage((TestStepOutput) null,
                COLUMN_TYPE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage((TestStepOutput) null,
                COLUMN_RANGE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage((TestStepOutput) null,
                COLUMN_VALUE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage((TestStepOutput) null,
                COLUMN_ID);
        assertNull(this.image);
        this.image = this.provider.getColumnImage((TestStepOutput) null,
                COLUMN_ELEMENT_TYPE);
        assertNull(this.image);

        this.image = this.provider.getColumnImage(EMPTY, COLUMN_NAME);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(EMPTY, COLUMN_TYPE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(EMPTY, COLUMN_RANGE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(EMPTY, COLUMN_VALUE);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(EMPTY, COLUMN_ID);
        assertNull(this.image);
        this.image = this.provider.getColumnImage(EMPTY, COLUMN_ELEMENT_TYPE);
        assertNull(this.image);
        System.out.println("PASSED");
    }

    @Test
    public void testGetColumnTextInvalidElement() {
        System.out.println("Test getColumnText with invalid element");
        String text = this.provider.getColumnText(null, COLUMN_NAME);
        assertEquals("", text);
        text = this.provider.getColumnText(null, COLUMN_TYPE);
        assertEquals("", text);
        text = this.provider.getColumnText(null, COLUMN_RANGE);
        assertEquals("", text);
        text = this.provider.getColumnText(null, COLUMN_VALUE);
        assertEquals("", text);
        text = this.provider.getColumnText(null, COLUMN_ID);
        assertEquals("", text);
        text = this.provider.getColumnText(null, COLUMN_ELEMENT_TYPE);
        assertEquals("", text);

        text = this.provider.getColumnText((TestStep) null, COLUMN_NAME);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStep) null, COLUMN_TYPE);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStep) null, COLUMN_RANGE);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStep) null, COLUMN_VALUE);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStep) null, COLUMN_ID);
        assertEquals("", text);
        text = this.provider
                .getColumnText((TestStep) null, COLUMN_ELEMENT_TYPE);
        assertEquals("", text);

        text = this.provider.getColumnText((TestStepInput) null, COLUMN_NAME);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStepInput) null, COLUMN_TYPE);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStepInput) null, COLUMN_RANGE);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStepInput) null, COLUMN_VALUE);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStepInput) null, COLUMN_ID);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStepInput) null,
                COLUMN_ELEMENT_TYPE);
        assertEquals("", text);

        text = this.provider.getColumnText((TestStepOutput) null, COLUMN_NAME);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStepOutput) null, COLUMN_TYPE);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStepOutput) null, COLUMN_RANGE);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStepOutput) null, COLUMN_VALUE);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStepOutput) null, COLUMN_ID);
        assertEquals("", text);
        text = this.provider.getColumnText((TestStepOutput) null,
                COLUMN_ELEMENT_TYPE);
        assertEquals("", text);

        text = this.provider.getColumnText("Test", COLUMN_NAME);
        assertEquals("", text);
        text = this.provider.getColumnText("Test", COLUMN_TYPE);
        assertEquals("", text);
        text = this.provider.getColumnText("Test", COLUMN_RANGE);
        assertEquals("", text);
        text = this.provider.getColumnText("Test", COLUMN_VALUE);
        assertEquals("", text);
        text = this.provider.getColumnText("Test", COLUMN_ID);
        assertEquals("", text);
        text = this.provider.getColumnText("Test", COLUMN_ELEMENT_TYPE);
        assertEquals("", text);
        System.out.println("PASSED");
    }

    @Test
    public void testGetColumnTextValidElement() {
        System.out.println("Test getColumnText for input/output parameter");
        String text = this.provider.getColumnText(this.testStep, COLUMN_NAME);
        assertEquals(STEP_NAME, text);
        text = this.provider.getColumnText(this.testStep, COLUMN_TYPE);
        assertEquals(EMPTY, text);
        text = this.provider.getColumnText(this.testStep, COLUMN_RANGE);
        assertEquals(EMPTY, text);
        text = this.provider.getColumnText(this.testStep, COLUMN_VALUE);
        assertEquals(EMPTY, text);
        text = this.provider.getColumnText(this.testStep, COLUMN_ID);
        assertEquals(STEP_ID, text);
        text = this.provider.getColumnText(this.testStep, COLUMN_ELEMENT_TYPE);
        assertEquals("TestStep", text);

        text = this.provider.getColumnText(this.testStepInput, COLUMN_NAME);
        assertEquals(INPUT_NAME, text);
        text = this.provider.getColumnText(this.testStepInput, COLUMN_TYPE);
        assertEquals(INPUT_TYPE, text);
        text = this.provider.getColumnText(this.testStepInput, COLUMN_RANGE);
        assertEquals(INPUT_RANGE, text);
        text = this.provider.getColumnText(this.testStepInput, COLUMN_VALUE);
        assertEquals(INPUT_VALUE, text);
        text = this.provider.getColumnText(this.testStepInput, COLUMN_ID);
        assertEquals(INPUT_ID, text);
        text = this.provider.getColumnText(this.testStepInput,
                COLUMN_ELEMENT_TYPE);
        assertEquals("TestStepInput", text);

        text = this.provider.getColumnText(this.testStepOutput, COLUMN_NAME);
        assertEquals(OUTPUT_NAME, text);
        text = this.provider.getColumnText(this.testStepOutput, COLUMN_TYPE);
        assertEquals(OUTPUT_TYPE, text);
        text = this.provider.getColumnText(this.testStepOutput, COLUMN_RANGE);
        assertEquals(OUTPUT_RANGE, text);
        text = this.provider.getColumnText(this.testStepOutput, COLUMN_VALUE);
        assertEquals(OUTPUT_VALUE, text);
        text = this.provider.getColumnText(this.testStepOutput, COLUMN_ID);
        assertEquals(OUTPUT_ID, text);
        text = this.provider.getColumnText(this.testStepOutput,
                COLUMN_ELEMENT_TYPE);
        assertEquals("TestStepOutput", text);
        System.out.println("PASSED");
    }

    @Test
    public void testGetColumnTextInvalidColumn() {
        System.out.println("Test getColumnText with invalid column index");
        String text = this.provider
                .getColumnText(this.testStep, COLUMN_INVALID);
        assertEquals("", text);
        text = this.provider.getColumnText(this.testStepInput, COLUMN_INVALID);
        assertEquals("", text);
        text = this.provider.getColumnText(this.testStepOutput, COLUMN_INVALID);
        assertEquals("", text);
        System.out.println("PASSED");
    }
}
