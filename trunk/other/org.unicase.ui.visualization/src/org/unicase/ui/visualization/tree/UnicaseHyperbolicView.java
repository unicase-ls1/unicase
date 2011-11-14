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
	
	public UnicaseHyperbolicView(UnicaseTree unicaseTree) {
		this.unicaseTree = unicaseTree;
		hyperTree = new HyperTree(unicaseTree.getRoot(), unicaseTree.getInfo());
		view = hyperTree.getView();
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
		return hyperTree.getView();
	}

	@Override
	public UnicaseNode getSelectedNode() {
		throw new UnsupportedOperationException("This does not work for the Hyperbolicview (yet).");
	}

	@Override
	public void selectNode(UnicaseNode node) {
		throw new UnsupportedOperationException("This does not work for the Hyperbolicview (yet).");
	}

	@Override
	public boolean isLinked() {
		return false;
	}

	@Override
	public void setIsLinked() {
		throw new UnsupportedOperationException("This does not work for the Hyperbolicview (yet).");
	}

}
