package org.unicase.ui.visualization.tree;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.visualization.util.VisualizationUtil;
import org.unicase.ui.visualization.views.VisualizationView;

import ch.randelshofer.tree.TreeNode;
import ch.randelshofer.tree.sunburst.SunburstNode;
import ch.randelshofer.tree.sunburst.SunburstTree;
import ch.randelshofer.tree.sunburst.SunburstView;

/**
 * 
 * Extends the {@link SunburstView} class in order to add special functionality.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class UnicaseSunburstView extends SunburstView implements UnicaseView {

	private static final long serialVersionUID = 1L;
	
	private UnicaseTree unicaseTree;
	
	private SunburstTree sunburstTree;
	
	private VisualizationView viewPart;
	
	private SunburstNode selectedNode;
	
	private boolean isLinked = true;
	
	public static UnicaseSunburstView createUnicaseSunburstView(UnicaseTree tree, VisualizationView view){
		return new UnicaseSunburstView(tree, new SunburstTree(tree.getRoot(), tree.getInfo()), view);
	}
	
	public UnicaseSunburstView(UnicaseTree unicaseTree, SunburstTree sunburstTree, VisualizationView view) {		
		super(sunburstTree);
		this.unicaseTree = unicaseTree;	
		this.sunburstTree = sunburstTree;
		this.setToolTipEnabled(true);
		this.viewPart = view;		
		this.addMouseListener(mouseAdapter);
		this.selectedNode = sunburstTree.getRoot();
	}
	
	/**
	 * Override super method to save the selected node.
	 */
	@Override
	public void setSelectedNode(SunburstNode node){		
		// if the node is null, it is the root
		if(node == null) {
			selectedNode = sunburstTree.getRoot();			
		} else {			
			selectedNode = node;	
		}
		
		super.setSelectedNode(sunburstTree.getRoot().equals(node) ? null : node);
		
		viewPart.setSelectedNode((UnicaseNode) selectedNode.getNode());
	}
	
	/**
	 * Select a UnicaseNode.
	 * 
	 * @param node The UnicaseNode to select
	 */
	public void selectNode(UnicaseNode node){
		if(isLinked){
			SunburstNode sNode = selectedNode;
			findNode(node, sunburstTree.getRoot());
			if(sNode != selectedNode) setSelectedNode(selectedNode);
			this.repaintView();
		}
	}
	
	/**
	 * Finds a corresponding SunburstNode to a TreeNode and sets it to {@link #selectedNode}. 
	 * 
	 * @param node The TreeNode to find the right {@link SunburstNode}.
	 * @param root The {@link SunburstNode}, to search in.
	 */
	private void findNode(TreeNode node, SunburstNode root){
		if(node == null) return;
		if(node.equals(root.getNode())){
			this.selectedNode = root;
			return;
		}
		for(SunburstNode n : root.children()){
			TreeNode uNode = n.getNode();
			if(uNode != null && node.equals(uNode)){
				this.selectedNode = n;
				return;
			}
			findNode(node, n);
		}
	}
	
	/**
	 * Overrides the paintComponent method to add functionality. 
	 */
	@Override
    public void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		
		// draws the additional infos of a node to the screen
		if(this.selectedNode != null){
			List<String> infos = ((UnicaseNode)selectedNode.getNode()).getInfos();
			if(infos != null){
				int y = 30;
				for(String s : infos){
					gr.drawString(s, 30, y);
					y += 15;
				}				
			}
		}
		
		// draw the infos of the tree
		List<String> infos = unicaseTree.getInfos();
		if(infos != null){
			int y = 30;
			int x = getWidth() - 70;			
			for(String s : infos){
				gr.drawString(s, x, y);
				y += 15;
			}
		}
		
	}
		
	/**
	 * MouseListener to control the linked views/editor.
	 */
	private MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(final MouseEvent e) {
			final EObject obj = ((UnicaseNode)selectedNode.getNode()).getEObject();						
			if(obj instanceof UnicaseModelElement){					
				viewPart.getSite().getShell().getDisplay().syncExec(new Runnable() {
					
					@Override
					public void run() {
						if(e.getClickCount() == 2) {
							VisualizationUtil.openModelElement(obj, viewPart);
						} else {
							VisualizationUtil.setNavigatorSelection(obj, isLinked);
						}
					}
				});
			}			
		}
	};
	
	public boolean  setIsLinked(){
		return (isLinked = !isLinked);
	}
	
	public boolean isLinked(){
		return isLinked;
	}

	@Override
	public UnicaseTree getUnicaseTree() {		
		return unicaseTree;
	}

	@Override
	public JPanel getView() {
		return this;
	}

	@Override
	public UnicaseNode getSelectedNode() {
		if(selectedNode == null) return null;
		return (UnicaseNode) selectedNode.getNode();		
	}
}
