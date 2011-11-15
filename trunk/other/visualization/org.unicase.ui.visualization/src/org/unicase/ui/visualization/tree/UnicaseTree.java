package org.unicase.ui.visualization.tree;

import java.awt.Color;
import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import ch.randelshofer.tree.NodeInfo;
import ch.randelshofer.tree.TreeNode;

/**
 * Represents a tree to visualize.
 * Also builds it up on init and contains relations between {@link UnicaseNode}s and {@link EObject} and colors. 
 * 
 * @author Julian Sommerfeldt
 *
 */
public class UnicaseTree {

	private UnicaseNode root;
	
	private HashMap<EObject, UnicaseNode> nodes;
	
	public static enum Coloring {CREATION_DATE, RANDOM, MANUALLY}
	
	private Coloring coloring = Coloring.CREATION_DATE;
	
	private HashMap<EClass, Color> colors;
			
	public UnicaseTree(UnicaseNode root){
		this.root = root;		
		buildTree();
	}
	
	private void buildTree() {
		nodes = new HashMap<EObject, UnicaseNode>();
		addChildrenNodes(root);
	}

	public void setRoot(UnicaseNode root){
		this.root = root;
	}

	public TreeNode getRoot() {
		return root;
	}

	public NodeInfo getInfo() {		
		return new UnicaseNodeInfo(this);
	}

	public HashMap<EObject, UnicaseNode> getNodes() {
		return nodes;
	}
	
	private void addChildrenNodes(UnicaseNode root) {
		EObject object = root.getObject();
		if (object == null) return;
		for (EObject e : object.eContents()) {
			// Node			
			UnicaseNode child = new UnicaseNode(e);			
			root.addChild(child);
			nodes.put(e, child);
						
			// references						
			for (EObject reference : e.eCrossReferences()) {	
				child.addChild(new ReferenceUnicaseNode(reference));
			}
			
			// normal children			
			addChildrenNodes(child);			
		}
	}
	
	public void setColor(EClass type, Color color){
		if(colors == null) colors = new HashMap<EClass, Color>();
		colors.put(type, color);
	}
	
	public Color getColor(EClass type){
		if( colors == null ) return null;
		return colors.get(type);
	}

	public void setColoring(Coloring coloring) {
		this.coloring = coloring;
	}

	public Coloring getColoring() {
		return coloring;
	}
}
