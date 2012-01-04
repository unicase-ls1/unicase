package org.unicase.ui.visualization.tree;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentsEList.FeatureIterator;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.ui.visualization.util.VisualizationUtil;
import org.unicase.workspace.ProjectSpace;

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
	
	public static enum Coloring {CREATION_DATE, RANDOM, MANUALLY, VERSION, TWO_VERSIONS}
	
	private Coloring coloring = Coloring.CREATION_DATE;
	
	private HashMap<EClass, Color> colors;
	
	private List<EObject> changedElements = new ArrayList<EObject>();

	private List<HistoryInfo> historyInfos;
	
	private List<String> infos;
				
	public UnicaseTree(UnicaseNode root){
		this(root, null);
	}
	
	public UnicaseTree(UnicaseNode root, List<EClass> eClassTypes){
		this.root = root;	
		nodes = new HashMap<EObject, UnicaseNode>();
		addChildrenNodes(eClassTypes, root);		
	}
	
	public UnicaseTree getFilteredUnicaseTree(List<EClass> eClassTypes){
		UnicaseTree tree = new UnicaseTree(new UnicaseNode(root.getEObject()), eClassTypes);
		tree.coloring = coloring;
		tree.infos = infos;
		tree.historyInfos = historyInfos;
		tree.colors = colors;
		tree.changedElements = changedElements;
		return tree;
	}
	
	public void setRoot(UnicaseNode root){
		this.root = root;
	}

	public UnicaseNode getRoot() {
		return root;
	}

	public NodeInfo getInfo() {		
		return new UnicaseNodeInfo(this);
	}

	public HashMap<EObject, UnicaseNode> getNodes() {
		return nodes;
	}
	
	private boolean addChildrenNodes(List<EClass> eClassTypes, UnicaseNode root) {
		boolean ret = false;
		EObject object = root.getEObject();
		if (object == null) return ret;
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
		ProjectSpace projectSpace = VisualizationUtil.getProjectSpace(root.getEObject());
		if(coloring == Coloring.VERSION){
			this.changedElements = VisualizationUtil.getChangedElements(projectSpace, false);
		} else if(coloring == Coloring.TWO_VERSIONS){
			historyInfos = VisualizationUtil.getVersionsFromUser(projectSpace, true);
			this.changedElements = VisualizationUtil.getChangedElements(projectSpace, historyInfos);
		}
	}
	
	public Coloring getColoring() {
		return coloring;
	}
	
	public UnicaseNode getEqualNode(UnicaseNode node){
		for(UnicaseNode n : nodes.values()){
			if(n.equals(node)) return n;
		}
		return null;
	}
	
	public void addInfo(String s){
		if(infos == null) infos = new ArrayList<String>();
		infos.add(s);
	}
	
	public List<String> getInfos(){
		return infos;
	}

	public void setChangedElements(List<EObject> changedElements) {
		this.changedElements = changedElements;
	}

	public List<EObject> getChangedElements() {
		return changedElements;
	}

	public List<HistoryInfo> getHistoryInfos() {
		return historyInfos;
	}
}
