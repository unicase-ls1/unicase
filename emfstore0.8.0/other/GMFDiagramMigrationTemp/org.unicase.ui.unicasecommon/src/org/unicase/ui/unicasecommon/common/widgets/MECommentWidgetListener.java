/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.widgets;

import org.unicase.model.rationale.Comment;

/**
 * Interface for classes that should receive notifications when the comment widget has been updated.
 * 
 * @author Shterev
 */
public interface MECommentWidgetListener {

	/**
	 * Will be called when the widget's layout updates.
	 */
	void commentInputClosed();

	/**
	 * Will be called when the widget's layout updates.
	 */
	void commentLayoutUpdated();

	/**
	 * Will be called when a new comment is added.
	 * 
	 * @param newComment the new comment
	 */
	void commentAdded(Comment newComment);

}
