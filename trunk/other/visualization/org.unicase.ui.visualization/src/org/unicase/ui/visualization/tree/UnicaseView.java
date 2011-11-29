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
