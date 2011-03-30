/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui.views.changes;

/**
 * Provides the MergeChangesComposite with the state information for each
 * Operation.
 * 
 * @author Shterev
 */
public class OperationState {

	/**
	 * The operation should be (preview) marked as accepted.
	 */
	public static final int ACCEPTED = 1;

	/**
	 * The operation should be (preview) marked as rejected.
	 */
	public static final int REJECTED = 2;

	/**
	 * The operation should not be (preview) marked at all.
	 */
	public static final int NONE = 0;

	private boolean checkedState;

	private int previewState;

	/**
	 * @param checkedState
	 *            the checkedState to set
	 */
	public void setCheckedState(boolean checkedState) {
		this.checkedState = checkedState;
	}

	/**
	 * @return the checkedState
	 */
	public boolean isCheckedState() {
		return checkedState;
	}

	/**
	 * @param previewState
	 *            the previewState to set
	 */
	public void setPreviewState(int previewState) {
		this.previewState = previewState;
	}

	/**
	 * @return the previewState
	 */
	public int getPreviewState() {
		return previewState;
	}

}
