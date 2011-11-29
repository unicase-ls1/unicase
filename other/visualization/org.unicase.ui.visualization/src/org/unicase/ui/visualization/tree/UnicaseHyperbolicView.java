package org.unicase.ui.visualization.tree;

import javax.swing.JPanel;

import ch.randelshofer.tree.hypertree.HyperTree;

/**
 * Class to represent the hyperbolic view.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class UnicaseHyperbolicView implements UnicaseView {

	private UnicaseTree unicaseTree;
	
	private HyperTree hyperTree;
	
	
	public UnicaseHyperbolicView(UnicaseTree unicaseTree) {
		this.unicaseTree = unicaseTree;
		hyperTree = new HyperTree(unicaseTree.getRoot(), unicaseTree.getInfo());
	}
	
	public UnicaseHyperbolicView(UnicaseTree unicaseTree, UnicaseNode root){
		this.unicaseTree = unicaseTree;
		hyperTree = new HyperTree(root, unicaseTree.getInfo());		
	}

	@Override
	public UnicaseTree getUnicaseTree() {
		return unicaseTree;
	}

	@Override
	public void repaintView() {
		hyperTree.getView().repaintView();
	}

	@Override
	public JPanel getView() {		
		return hyperTree.getView();
	}

	@Override
	public UnicaseNode getSelectedNode() {
		// not implemented for the Hyperbolicview (yet)
		return null;
	}

	@Override
	public void selectNode(UnicaseNode node) {
		// not implemented for the Hyperbolicview (yet)
	}

	@Override
	public boolean isLinked() {
		return false;
	}

	@Override
	public boolean setIsLinked() {
		// not implemented for the Hyperbolicview (yet)
		return false;
	}

}
