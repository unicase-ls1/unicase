/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.visualization.tree;

import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.Action;
import javax.swing.event.ChangeListener;

import org.eclipse.emf.ecore.EObject;
import org.unicase.ui.visualization.tree.UnicaseTree.Coloring;

import ch.randelshofer.tree.Colorizer;
import ch.randelshofer.tree.TreeNode;
import ch.randelshofer.tree.TreePath2;
import ch.randelshofer.tree.Weighter;
import ch.randelshofer.tree.demo.AbstractNodeInfo;

/**
 * Class to build the info of a {@link UnicaseNode}.
 * Responsible for coloring etc.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class UnicaseNodeInfo extends AbstractNodeInfo {
	
	private UnicaseTree tree;
	
	private HashMap<UnicaseNode, Color> colors;
	
	private float h = 0.25f;
	
	private float saturation = 0.5f;
	
	private float factor;
	
	private float spectrum = 0.4f;
	
	private static final Color IMPLICIT = new Color(0xd6d6d6);
	
	private static final Color REFERENCE = new Color(0xcb3636);
	
	private static final Color BASE = new Color(0xFFB14A);
	
	/**
	 * @param tree The corresponding {@link UnicaseTree}.
	 */
	public UnicaseNodeInfo(UnicaseTree tree){
		this.tree = tree;		
	}
	
	@Override
	public void init(TreeNode root) {
		fillColors();
	}

	@Override
	public String getName(TreePath2<TreeNode> path) {		       
        return ((UnicaseNode) path.getLastPathComponent()).getName();
	}
	
	/**
	 * Builds the color of a {@link UnicaseNode} according to the selected {@link Coloring}.
	 * 
	 * @param path The path.
	 * @return The color.
	 */
	@Override
	public Color getColor(TreePath2<TreeNode> path) {
		UnicaseNode node = (UnicaseNode) path.getLastPathComponent(); 
		if(node instanceof ReferenceUnicaseNode){
			return REFERENCE;
		}
		if(node.isImplicit()){
			return IMPLICIT;
		}
		if(node.equals(tree.getRoot())){
			return Color.WHITE;
		}
		
		Color color = BASE;
		
		Coloring coloring = tree.getColoring();
		if(coloring.equals(Coloring.CREATION_DATE)){
			Color c = colors.get(node);
			if(c == null){
				c = getContainerColor(node.getEObject());			
			}
			if(c != null){
				color = c;
			}
		} else if (coloring.equals(Coloring.RANDOM)){
			color = new Color(stringToRGBInt(node.getEObject().eClass().getName()));		
		} else if (coloring.equals(Coloring.MANUALLY)){
			color = tree.getColor(node.getEObject().eClass());
			if( color == null ){
				color = BASE;
			}
		} else if (coloring.equals(Coloring.VERSION) || coloring.equals(Coloring.TWO_VERSIONS)){
			if(tree.getChangedElements().contains(node.getEObject())){
				color = Color.GREEN;
			}
		}
		return color;
	}
	
	/**
	 * Finds the color of a container if there is no color for the {@link EObject}.
	 * 
	 * @param obj The {@link EObject} there is no color for.
	 * @return The color of the next container, which has a color.  
	 */
	private Color getContainerColor(EObject obj){
		if(obj == null){
			return null;
		}
		EObject container = obj.eContainer();
		Color c = colors.get(tree.getNodes().get(container));
		if(c == null){
			return getContainerColor(container);
		}
		return c;
	}
	
	/**
	 * Fill the colors initial for all nodes.
	 */
	private void fillColors(){
		// sort nodes by timestamp
		SortedSet<UnicaseNode> sortedNodes = new TreeSet<UnicaseNode>();
		for(UnicaseNode n : tree.getNodes().values()){			
			if(n != null){
				sortedNodes.add(n);
			}
		}
		
		// create colors for nodes
		int i = 0;
		factor = 1.0f / ((float)sortedNodes.size());
		colors = new HashMap<UnicaseNode, Color>();
		for (UnicaseNode n : sortedNodes) {
			colors.put(n, getHSBColor(i));
			i++;
		}
	}
	
	private Color getHSBColor(int index){		
		float b = factor * (float)index;
		b = b * spectrum + (1.0f - spectrum);	
		return Color.getHSBColor(h, saturation, b);		
	}
	
	private int stringToRGBInt(String s){
		int hash = s.hashCode();
	    String hex = Integer.toHexString(((hash>>16)&0xFF))+ Integer.toHexString(((hash>>8)&0xFF))+ Integer.toHexString((hash&0xFF));
	    return Integer.parseInt(hex, 16);
	}

	@Override
	public long getWeight(TreePath2<TreeNode> path) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCumulatedWeight(TreePath2<TreeNode> path) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getWeightFormatted(TreePath2<TreeNode> path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTooltip(TreePath2<TreeNode> path) {
		return path.getLastPathComponent().toString();
	}

	@Override
	public Action[] getActions(TreePath2<TreeNode> path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImage(TreePath2<TreeNode> path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Weighter getWeighter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Colorizer getColorizer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addChangeListener(ChangeListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeChangeListener(ChangeListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toggleColorWeighter() {
		// TODO Auto-generated method stub

	}

}
