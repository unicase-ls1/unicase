package org.unicase.model.testspec.ui.editor.tableprovider;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.provider.TestStepInputItemProvider;
import org.unicase.model.testspec.provider.TestStepOutputItemProvider;
import org.unicase.model.testspec.provider.TestspecItemProviderAdapterFactory;

/**
 * Label provider of the dynamic table holding the test step parameters.
 * 
 * It is responsible to process the data received by the content provider in
 * that way that it can be displayed by the table.
 * 
 * @author Sharon Friedrich
 * 
 */
public class TestStepParameterTableLabelProvider extends LabelProvider
        implements ITableLabelProvider {

    /**
     * Constant text.
     */
    private static final String EMPTY = "";
    /**
     * Constant table column index.
     */
    private static final int COLUMN_NAME = 0;
    private static final int COLUMN_TYPE = 1;
    private static final int COLUMN_RANGE = 2;
    private static final int COLUMN_ID = 3;

    /**
     * Returns the image that shall be displayed for an object in a column.
     */
    public Image getColumnImage(Object element, int columnIndex) {
        /* Only display an image in the name column */
        if (columnIndex == COLUMN_NAME && element != null) {
            if (element instanceof TestStepInput) {
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
     *            - either input or output parameter
     * @param columnIndex
     *            - index of column
     */
    public String getColumnText(Object element, int columnIndex) {
        if (element != null && element instanceof TestStepInput) {
            TestStepInput testStepInput = (TestStepInput) element;
            switch (columnIndex) {
            case COLUMN_NAME:
                return testStepInput.getName();
            case COLUMN_TYPE:
                return testStepInput.getType();
            case COLUMN_RANGE:
                return testStepInput.getRange();
            case COLUMN_ID:
                return testStepInput.getIdentifier();
            default:
                return EMPTY;
            }
        } else if (element != null && element instanceof TestStepOutput) {
            TestStepOutput testStepOutput = (TestStepOutput) element;
            switch (columnIndex) {
            case COLUMN_NAME:
                return testStepOutput.getName();
            case COLUMN_TYPE:
                return testStepOutput.getType();
            case COLUMN_RANGE:
                return testStepOutput.getRange();
            case COLUMN_ID:
                return testStepOutput.getIdentifier();
            default:
                return EMPTY;
            }
        } else {
            return EMPTY;
        }
    }
}
