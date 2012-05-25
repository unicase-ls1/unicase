/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.visualization.tree;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentsEList.FeatureIterator;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.unicase.ui.visualization.util.VisualizationUtil;

import ch.randelshofer.tree.NodeInfo;

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
	
	/**
	 * The coloring of the tree.
	 */
	public static enum Coloring {
		/**
		 * Color in creation date.
		 */
		CREATION_DATE, 
		/**
		 * Color randomly.
		 */
		RANDOM, 
		/**
		 * Set colors manually.
		 */
		MANUALLY, 
		/**
		 * Color the diff between a version.
		 */
		VERSION, 
		/**
		 * Show two versions.
		 */
		TWO_VERSIONS, 
		/**
		 * Show the version slider.
		 */
		VERSION_SLIDER
	}
	
	private Coloring coloring = Coloring.CREATION_DATE;
	
	private HashMap<EClass, Color> colors;
	
	private List<EObject> changedElements = new ArrayList<EObject>();
	
	private List<HistoryInfo> historyInfos;
	
	private List<String> infos;
				
	/**
	 * @param root The root of the tree.
	 */
	public UnicaseTree(UnicaseNode root){
		this(root, null);
	}
	
	/**
	 * @param root The root of the tree.
	 * @param eClassTypes The {@link EClass}-types to filter for.
	 */
	public UnicaseTree(UnicaseNode root, List<EClass> eClassTypes){
		this.root = root;	
		nodes = new HashMap<EObject, UnicaseNode>();
		addChildrenNodes(eClassTypes, root);		
	}
	
	/**
	 * @param eClassTypes The {@link EClass}-types to filter for.
	 * @return A new instance of the tree but filtered.
	 */
	public UnicaseTree getFilteredUnicaseTree(List<EClass> eClassTypes){
		UnicaseTree tree = new UnicaseTree(new UnicaseNode(root.getEObject()), eClassTypes);
		tree.coloring = coloring;
		tree.infos = infos;
		tree.historyInfos = historyInfos;
		tree.colors = colors;
		tree.changedElements = changedElements;
		return tree;
	}
	
	/**
	 * @param root The new root.
	 */
	public void setRoot(UnicaseNode root){
		this.root = root;
	}

	/**
	 * @return The root of the tree.
	 */
	public UnicaseNode getRoot() {
		return root;
	}
	
	/**
	 * @return The {@link NodeInfo} of the tree.
	 */
	public NodeInfo getInfo() {		
		return new UnicaseNodeInfo(this);
	}

	/**
	 * @return The nodes connected to the {@link EObject}s.
	 */
	public HashMap<EObject, UnicaseNode> getNodes() {
		return nodes;
	}
	
	private boolean addChildrenNodes(List<EClass> eClassTypes, UnicaseNode root) {
		boolean ret = false;
		EObject object = root.getEObject();
		if (object == null){
			return ret;
		}
		for (EObject e : object.eContents()) {
			UnicaseNode child = new UnicaseNode(e);			
			
			// filter
			if(addChildrenNodes(eClassTypes, child) || eClassTypes == null || eClassTypes.contains(e.eClass())){	
				
				// Node			
				root.addChild(child);
				nodes.put(e, child);
				
				// references						
				for (FeatureIterator<EObject> featureIterator = (FeatureIterator<EObject>)e.eCrossReferences().iterator(); featureIterator.hasNext(); ) {					
					ReferenceUnicaseNode node = new ReferenceUnicaseNode(featureIterator.next());
					node.addInfo("ReferenceType: " + featureIterator.feature().getName());
					child.addReference(node);
			    } 

				ret = true;
			}
		}
		return ret;
	}
		
	/**
	 * Set the Color for a special {@link EClass}.
	 * 
	 * @param type The {@link EClass} type.
	 * @param color The color.
	 */
	public void setColor(EClass type, Color color){
		if(colors == null){
			colors = new HashMap<EClass, Color>();
		}
		colors.put(type, color);
	}
	
	/**
	 * Get a Color of a given {@link EClass} type.
	 * 
	 * @param type The {@link EClass} type.
	 * @return The color of the given {@link EClass}.
	 */
	public Color getColor(EClass type){
		if( colors == null ){
			return null;
		}
		return colors.get(type);
	}
	
	/**
	 * Set the Coloring for the tree.
	 * 
	 * @param coloring The {@link Coloring}.
	 */
	public void setColoring(Coloring coloring) {
		this.coloring = coloring;
		ProjectSpace projectSpace = VisualizationUtil.getProjectSpace(root.getEObject());
		if(coloring == Coloring.VERSION){
			this.changedElements = VisualizationUtil.getChangedElements(projectSpace, false);
		} else if(coloring == Coloring.TWO_VERSIONS){
			historyInfos = VisualizationUtil.getVersionsFromUser(projectSpace, true);
			this.changedElements = VisualizationUtil.getChangedElements(projectSpace, historyInfos);
		} else if(coloring == Coloring.VERSION_SLIDER){
			historyInfos = VisualizationUtil.getVersionsFromUser(projectSpace, true);			
		}
	}
	
	/**
	 * @return The {@link Coloring} of the tree.
	 */
	public Coloring getColoring() {
		return coloring;
	}
	
	/**
	 * @param node The corresponding node.
	 * @return The corresponding (same) node; e.g. from another tree. 
	 */
	public UnicaseNode getEqualNode(UnicaseNode node){
		for(UnicaseNode n : nodes.values()){
			if(n.equals(node)){
				return n;
			}
		}
		return null;
	}
	
	/**
	 * @param s The info to add to the tree.
	 */
	public void addInfo(String s){
		if(infos == null){
			infos = new ArrayList<String>();
		}
		infos.add(s);
	}
	
	/**
	 * @return The infos of the tree.
	 */
	public List<String> getInfos(){
		return infos;
	}
	
	/**
	 * @return The elements changed in a previously asked history.
	 */
	public List<EObject> getChangedElements() {
		return changedElements;
	}
	
	/**
	 * @param changedElements Set the changed elements.
	 */
	public void setChangedElements(List<EObject> changedElements) {
		this.changedElements = changedElements;
	}

	/**
	 * @return The previously asked history infos.
	 */
	public List<HistoryInfo> getHistoryInfos() {
		return historyInfos;
	}
}
