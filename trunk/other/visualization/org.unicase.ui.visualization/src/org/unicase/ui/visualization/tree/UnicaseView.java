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
	
	public UnicaseTree getUnicaseTree();
	
	public void repaintView();
	
	public JPanel getView();
	
	public UnicaseNode getSelectedNode();
	
	public void selectNode(UnicaseNode node);
		
	public boolean isLinked();
	
	public boolean setIsLinked();
}
