package org.unicase.model.testspec.ui.editor.tableprovider;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * Content provider of the dynamic table holding the test step parameters. The
 * class reads the data model and returns the data as an array.
 * 
 * @author Sharon Friedrich
 * 
 */
public class TestStepParameterTableContentProvider implements
        IStructuredContentProvider {
    /**
     * Method that is called if table shall be filled with new objects.
     * 
     * Method not necessary. All important operations can be done by
     * getElements(Object inputElement).
     * 
     * @param viewer
     *            - table viewer
     * @param oldInput
     *            - old input to table
     * @param newInput
     *            - new input to table
     */
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    /**
     * Returns test step parameters as an array.
     * 
     * It provides the input for the table.
     * 
     * @param inputElement
     *            - list of input or output parameters
     * @return Object[] - array of either input or output parameters
     */
    public Object[] getElements(Object inputElement) {
        if (inputElement != null) {
            try {
                return ((EList<?>) inputElement).toArray();
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
