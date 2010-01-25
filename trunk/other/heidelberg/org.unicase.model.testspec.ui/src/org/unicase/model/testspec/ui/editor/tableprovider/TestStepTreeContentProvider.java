package org.unicase.model.testspec.ui.editor.tableprovider;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;

/**
 * Content provider of the dynamic tree holding the test steps and its
 * parameters. The class reads the data model and returns the data as an array.
 * 
 * @author Sharon Friedrich
 * 
 */
public class TestStepTreeContentProvider implements ITreeContentProvider {
    /**
     * Method that is called if the tree shall be filled with new objects.
     * 
     * Method not necessary. All important operations can be done by
     * getElements(Object inputElement).
     * 
     * @param viewer
     *            - tree viewer
     * @param oldInput
     *            - old input to tree
     * @param newInput
     *            - new input to tree
     */
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    /**
     * Gets the children for a test step, input or output parameter. Hereby,
     * only test steps have children, namely the corresponding input or output
     * parameters.
     * 
     * @param parentElement
     *            - the test step, input or output parameter
     * @return Object[] - empty or input and output parameters
     */
    @Override
    public Object[] getChildren(Object parentElement) {
        /* Get all input and output parameter of a given test step */
        ArrayList<UnicaseModelElement> testStepParameter = new ArrayList<UnicaseModelElement>();
        if (parentElement instanceof TestStep && parentElement != null) {
            testStepParameter.addAll(((TestStep) parentElement).getInput());
            testStepParameter.addAll(((TestStep) parentElement).getOutput());
            return testStepParameter.toArray();
        }
        /* Input or Output parameter do not have any children */
        return new Object[] {};
    }

    /**
     * Gets the corresponding test step of an input or output parameter.
     * 
     * @param - input or output parameter
     * @return Object - test step
     */
    @Override
    public Object getParent(Object element) {
        if (element instanceof TestStepInput && element != null) {
            return ((TestStepInput) element).getTestStep();
        } else if (element instanceof TestStepOutput) {
            return ((TestStepOutput) element).getTestStep();
        } else {
            return null;
        }
    }

    /**
     * Returns whether the tree item has children. Note: Only items from type
     * TestStep can have children, namely the input and output parameters
     * 
     * @param element
     *            - test step, input or output parameter
     * @return boolean - element has/has not children
     */
    @Override
    public boolean hasChildren(Object element) {
        return getChildren(element).length > 0;
    }

    /**
     * Returns test steps as an array.
     * 
     * It provides the input for the tree.
     * 
     * @param inputElement
     *            - list of test steps
     * @return Object[] - array of test steps
     */
    @SuppressWarnings("unchecked")
    public Object[] getElements(Object inputElement) {
        if (inputElement != null) {
            try {
                return ((EList<TestStep>) inputElement).toArray();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /* Should not happen */
        return null;
    }

    /**
     * Dispose method. Nothing special has to be done.
     */
    public void dispose() {
    }
}
