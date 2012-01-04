package org.unicase.ui.visualization.tree;

import javax.swing.JPanel;

import ch.randelshofer.tree.hypertree.HyperTree;
import ch.randelshofer.tree.hypertree.SwingHTView;

/**
 * Class to represent the hyperbolic view.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class UnicaseHyperbolicView implements UnicaseView {

	private UnicaseTree unicaseTree;
	
	private HyperTree hyperTree;
	
	private SwingHTView view;
		
	public UnicaseHyperbolicView(UnicaseTree unicaseTree, UnicaseNode root){
		this.unicaseTree = unicaseTree;
		UnicaseNode equalNode = unicaseTree.getEqualNode(root);
		// if there is no corresponding node, set root to a new empty one
		root = (equalNode == null ? new UnicaseNode("") : equalNode.getReferenceNode());
		hyperTree = new HyperTree(root, unicaseTree.getInfo());
		view = hyperTree.getView();
		view.setToolTipEnabled(true);
	}

	@Override
	public UnicaseTree getUnicaseTree() {
		return unicaseTree;
	}

	@Override
	public void repaintView() {
		view.repaintView();
	}

	@Override
	public JPanel getView() {		
		return view;
	}

	@Override
	public UnicaseNode getSelectedNode() {
		return null;
	}

	@Override
	public boolean isLinked() {
		return false;
	}

	@Override
	public boolean setIsLinked() {
		return isLinked();
	}

	@Override
	public void selectNode(UnicaseNode node) {}
}
