package org.unicase.model.testspec.ui.editor.tableprovider;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.testspec.TestProtocol;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.provider.TestStepInputItemProvider;
import org.unicase.model.testspec.provider.TestStepItemProvider;
import org.unicase.model.testspec.provider.TestStepOutputItemProvider;
import org.unicase.model.testspec.provider.TestspecItemProviderAdapterFactory;

/**
 * Label provider of the dynamic tree holding the test steps, input parameters
 * and output parameters.
 * 
 * It is responsible to process the data received by the content provider in
 * that way that it can be displayed by the tree.
 * 
 * @author Sharon Friedrich
 * 
 */
public class TestStepTreeLabelProvider extends LabelProvider implements
        ITableLabelProvider {

    /**
     * Constant text.
     */
    private static final String EMPTY = "";
    /**
     * Constant tree column index.
     */
    private static final int COLUMN_NAME = 0;
    private static final int COLUMN_TYPE = 1;
    private static final int COLUMN_RANGE = 2;
    private static final int COLUMN_VALUE = 3;
    private static final int COLUMN_ID = 4;
    private static final int COLUMN_ELEMENT_TYPE = 5;

    /**
     * Constant element types.
     */
    private static final String ELEMENT_TYPE_TESTSTEP = "TestStep";
    private static final String ELEMENT_TYPE_TESTSTEPINPUT = "TestStepInput";
    private static final String ELEMENT_TYPE_TESTSTEPOUTPUT = "TestStepOutput";

    private TestProtocol testProtocol;
    /**
     * Constructor.
     */
    public TestStepTreeLabelProvider(TestProtocol testProtocol) {
        this.testProtocol = testProtocol;
    }
    /**
     * Returns the image that shall be displayed for an object in a column.
     */
    public Image getColumnImage(Object element, int columnIndex) {
        /* Only display an image in the name column */
        if (columnIndex == COLUMN_NAME && element != null) {
            if (element instanceof TestStep) {
                TestStepItemProvider testStepItemProvider = (TestStepItemProvider) new TestspecItemProviderAdapterFactory()
                        .createTestStepAdapter();
                return ExtendedImageRegistry.getInstance().getImageDescriptor(
                        testStepItemProvider.getImage(element)).createImage();
            } else if (element instanceof TestStepInput) {
                TestStepInputItemProvider testStepInputItemProvider = (TestStepInputItemProvider) new TestspecItemProviderAdapterFactory()
                        .createTestStepInputAdapter();
                return ExtendedImageRegistry.getInstance().getImageDescriptor(
                        testStepInputItemProvider.getImage(element))
                        .createImage();
            } else if (element instanceof TestStepOutput) {
                TestStepOutputItemProvider testStepOutputItemProvider = (TestStepOutputItemProvider) new TestspecItemProviderAdapterFactory()
                        .createTestStepOutputAdapter();
                return ExtendedImageRegistry.getInstance().getImageDescriptor(
                        testStepOutputItemProvider.getImage(element))
                        .createImage();
            }
        }
        return null;
    }

    /**
     * Fills column with the given index with specific information of given
     * element.
     * 
     * @param element
     *            -
     * @param columnIndex
     *            - index of column
     */
    public String getColumnText(Object element, int columnIndex) {
        if (element != null && element instanceof TestStepInput) {
            switch (columnIndex) {
            case COLUMN_NAME:
                return ((TestStepInput) element).getName();
            case COLUMN_TYPE:
                return ((TestStepInput) element).getType();
            case COLUMN_RANGE:
                return ((TestStepInput) element).getRange();
            case COLUMN_VALUE:
                return ((TestStepInput) element).getValues().get(testProtocol);
            case COLUMN_ID:
                return ((TestStepInput) element).getIdentifier();
            case COLUMN_ELEMENT_TYPE:
                return ELEMENT_TYPE_TESTSTEPINPUT;
            default:
                return EMPTY;
            }
        } else if (element != null && element instanceof TestStepOutput) {
            switch (columnIndex) {
            case COLUMN_NAME:
                return ((TestStepOutput) element).getName();
            case COLUMN_TYPE:
                return ((TestStepOutput) element).getType();
            case COLUMN_RANGE:
                return ((TestStepOutput) element).getRange();
            case COLUMN_VALUE:
                return ((TestStepOutput) element).getValues().get(testProtocol);
            case COLUMN_ID:
                return ((TestStepOutput) element).getIdentifier();
            case COLUMN_ELEMENT_TYPE:
                return ELEMENT_TYPE_TESTSTEPOUTPUT;
            default:
                return EMPTY;
            }
        } else if (element != null && element instanceof TestStep) {
            switch (columnIndex) {
            case COLUMN_NAME:
                return ((TestStep) element).getName();
            case COLUMN_TYPE:
                return EMPTY;
            case COLUMN_RANGE:
                return EMPTY;
            case COLUMN_VALUE:
                return EMPTY;
            case COLUMN_ID:
                return ((TestStep) element).getIdentifier();
            case COLUMN_ELEMENT_TYPE:
                return ELEMENT_TYPE_TESTSTEP;
            default:
                return EMPTY;
            }
        } else {
            return EMPTY;
        }
    }
}
