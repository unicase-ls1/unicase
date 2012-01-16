/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.visualization.tree;

import javax.swing.JPanel;

/**
 * The main interface for views (viewtypes).
 * 
 * @author Julian Sommerfeldt
 *
 */
public interface UnicaseView {
	
	/**
	 * @return The {@link UnicaseTree).
	 */
	UnicaseTree getUnicaseTree();
	
	/**
	 * Repaint the complete view.
	 */
	void repaintView();
	
	/**
	 * @return The JPanel containing the view.
	 */
	JPanel getView();
	
	/**
	 * @return The currently selected {@link UnicaseNode}.
	 */
	UnicaseNode getSelectedNode();
	
	/**
	 * @param node The {@link UnicaseNode} to select.
	 */
	void selectNode(UnicaseNode node);
		
	/**
	 * @return Is it linked to the navigator?
	 */
	boolean isLinked();
	
	/**
	 * Sets the view to the opposite of the current value.
	 * 
	 * @return The new isLinked value.
	 */
	boolean setIsLinked();
}
