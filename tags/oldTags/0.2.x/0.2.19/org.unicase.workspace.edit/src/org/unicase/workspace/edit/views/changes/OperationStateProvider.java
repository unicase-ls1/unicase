package org.unicase.workspace.edit.views.changes;

/**
 * Provides the MergeChangesComposite with the state information for each Operation.
 * @author Shterev
 *
 */
public class OperationStateProvider {
	
	public static final int ACCEPTED = 1;
	
	public static final int REJECTED = 2;

	public static final int NONE = 0;
	
	private boolean checkedState;
	
	private int previewState;
	
}
