package org.unicase.model.testspec.ui.test.commands;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecFactory;
import org.unicase.model.testspec.TestspecPackage;
import org.unicase.model.testspec.ui.test.commands.StubUnicaseCommand;

/**
 * Create input or output parameter of a given test step.
 * 
 * @author Sharon Friedrich
 * 
 */
public final class CreateNewTestStepParameterCommand extends StubUnicaseCommand {
    private TestStep testStep;
    private int classifierID = -1;

    /**
     * Constant text.
     */
    private static final String INPUT_DEFAULT_NAME = "new Input";
    private static final String OUTPUT_DEFAULT_NAME = "new Output";

    /**
     * Default constructor.
     * 
     * @param modelElement
     *            - test step for which parameter shall be created
     * @param classifierID
     *            - classifierID of TestStepInput or TestStepOutput
     */
    public CreateNewTestStepParameterCommand(final ModelElement modelElement,
            final int classifierID) {
        this.testStep = (TestStep) modelElement;
        this.classifierID = classifierID;
    }

    /**
     * Creation command.
     */
    @Override
    protected void doRun() {
        if (this.testStep != null && this.classifierID != -1) {
            Project project = this.testStep.getProject();
            TestspecFactory factory = TestspecFactory.eINSTANCE;
            /* Should an input parameter be created ? */
            if (classifierID == TestspecPackage.TEST_STEP_INPUT) {
                TestStepInput testStepInput = factory.createTestStepInput();
                project.addModelElement(testStepInput);
                testStepInput.setName(INPUT_DEFAULT_NAME);
                EList<TestStepInput> allSteps = testStep.getInput();
                allSteps.add(testStepInput);
                /* Or an output parameter? */
            } else if (classifierID == TestspecPackage.TEST_STEP_OUTPUT) {
                TestStepOutput testStepOutput = factory.createTestStepOutput();
                project.addModelElement(testStepOutput);
                testStepOutput.setName(OUTPUT_DEFAULT_NAME);
                EList<TestStepOutput> allSteps = testStep.getOutput();
                allSteps.add(testStepOutput);
            }
        }
    }
}
