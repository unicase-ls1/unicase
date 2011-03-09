package org.unicase.model.testspec.ui.editor.commands;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Command to delete multiple unicase model elements.
 * 
 * @author Sharon Friedrich
 * 
 */
public final class DeleteMultipleMECommand extends UnicaseCommand {

    /**
     * Array of model elements that shall be deleted.
     */
    private ArrayList<ModelElement> modelElementList = new ArrayList<ModelElement>();

    /**
     * Constant text.
     */
    private static final String CONFIRM_BOX_TITLE = "Confirmation";
    private static final String CONFIRM_QUESTION = "Do you really want to delete all selected elements?";
    private static final String CONFIRM_ANSWER_YES = "Yes";
    private static final String CONFIRM_ANSWER_NO = "No";
    private static final String PROGRESS_BAR_TEXT = "Deleting elements...";

    /**
     * Default constructor.
     * 
     * @param modelElementArrayList
     *            - ArrayList of all model elements that shall be deleted
     */
    public DeleteMultipleMECommand(ArrayList<ModelElement> modelElementList) {
        this.modelElementList = modelElementList;
    }

    /**
     * Delete command.
     * 
     */
    @Override
    protected void doRun() {
        if (modelElementList != null) {
            /* Ask to confirm deletion */
            MessageDialog dialog = new MessageDialog(null, CONFIRM_BOX_TITLE,
                    null, CONFIRM_QUESTION, MessageDialog.QUESTION,
                    new String[] { CONFIRM_ANSWER_YES, CONFIRM_ANSWER_NO }, 0);
            int result = dialog.open();
            /* Only delete model elements if answer was yes */
            if (result == MessageDialog.OK) {
                /* Show progress bar of deletion action */
                ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(
                        PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                                .getShell());
                progressDialog.open();
                progressDialog.getProgressMonitor().beginTask(
                        PROGRESS_BAR_TEXT, 100);
                progressDialog.getProgressMonitor().worked(20);
                /* Delete all selected model elements */
                try {
                    for (int i = 0; i < modelElementList.size(); i++) {
                        modelElementList.get(i).delete();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    /* Close progress bar when finished */
                } finally {
                    progressDialog.getProgressMonitor().done();
                    progressDialog.close();
                }
            }
        }
    }
}
