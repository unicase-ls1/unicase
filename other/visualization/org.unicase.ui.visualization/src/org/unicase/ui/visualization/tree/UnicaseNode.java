package org.unicase.ui.visualization.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;

import ch.randelshofer.tree.TreeNode;

/**
 * Represents a node in a {@link UnicaseTree}. 
 * Normally linked with an {@link EObject}.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class UnicaseNode implements TreeNode, Comparable<UnicaseNode> {

	private ArrayList<TreeNode> children;
	
	private List<UnicaseNode> implicitNodes;
	
	private ArrayList<TreeNode> references;
	
	private boolean isImplicit;
	
	private String name;
	
	private List<String> infos;
	
	private EObject object;
					
	public UnicaseNode(EObject obj){	
		if(obj instanceof Project) obj = obj.eContainer();		
		if(obj instanceof ProjectSpace){
			ProjectSpace projectSpace = (ProjectSpace)obj;
			this.name = projectSpace.getProjectName();
			this.object = projectSpace.getProject();
		} else {
			this.name = ((UnicaseModelElement)obj).getName();
			this.object = obj;
		}	
		
		addInfo("Name: " + this.name);
		addInfo("Type: " + obj.eClass().getName());		
	}
	
	public UnicaseNode(String name){
		this.name = name;
	}
	
	/**
	 * Builds a copy of the Node only containing the references.
	 * 
	 * @return A copy of the Node.
	 */
	public UnicaseNode getReferenceNode(){
		UnicaseNode node = new UnicaseNode(object);
		node.children = references;
		return node;
	}
	
	public void addReference(UnicaseNode node){
		if(references == null) references = new ArrayList<TreeNode>();
		references.add(node);
	}
		
	/**
	 * Receives the children of the node. Containing also the implicit nodes.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TreeNode> children() {		
		if(children == null){
			return Collections.EMPTY_LIST;
		} else if(implicitNodes != null) {
			List<TreeNode> nodes = new ArrayList<TreeNode>();
			nodes.addAll(implicitNodes);
			nodes.addAll(children);
			return nodes;
		} else {
			return children;
		}
	}

	public void addChild(TreeNode child) {
        if (children == null) {
            children = new ArrayList<TreeNode>();
        }
        children.add(child);
    }
	
	public void addImplicitNode(UnicaseNode node){
		if(implicitNodes == null){
			implicitNodes = new ArrayList<UnicaseNode>();
		}
		node.setImplicit(true);
		implicitNodes.add(node);
	}

    @Override
    public boolean getAllowsChildren() {
        return children != null;
    }
    
    public void addInfo(String info){
    	if(infos == null){
    		infos = new ArrayList<String>();
    	}
    	infos.add(info);
    }
    
    public List<String> getInfos(){
    	return infos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
        
    @Override
    public String toString(){
    	return getName();
    }

	public EObject getObject() {
		return object;
	}

	public void setImplicit(boolean isImplicit) {
		this.isImplicit = isImplicit;
	}

	public boolean isImplicit() {
		return isImplicit;
	}
	
	@Override
	public boolean equals(Object o){
		// it its not a unicasenode
		if(!(o instanceof UnicaseNode)) return false;
		EObject eObj = ((UnicaseNode)o).getObject();
		
		// if its the same eobject
		if(eObj.equals(getObject())) return true;
		
		// if its the same eobject, but not the same object 
		if(eObj instanceof UnicaseModelElement && getObject() instanceof UnicaseModelElement){
			if(((UnicaseModelElement)eObj).getIdentifier().equals( ((UnicaseModelElement)getObject()).getIdentifier() ) ) return true;
		}
		if(eObj instanceof Project && getObject() instanceof Project){
			if( ((ProjectSpace) ((Project)eObj).eContainer()).getProjectId().equals( ((ProjectSpace) ((Project)getObject()).eContainer()).getProjectId() ) ) return true;
		}
		
		return false;
	}
	
	/**
	 * Compares two UnicaseNodes by comparing the creation date of their {@link EObject}s.
	 */
	@Override
	public int compareTo(UnicaseNode node) {
		EObject o = node.getObject();
		if(o == null || object == null) return -1;
		if(object instanceof UnicaseModelElement && o instanceof UnicaseModelElement){
			Date creationDate1 = ((UnicaseModelElement)object).getCreationDate();
			Date creationDate2 = ((UnicaseModelElement)o).getCreationDate();
			if(creationDate1 == null || creationDate2 == null) return -1;
			return creationDate1.compareTo(creationDate2);
		}
		throw new IllegalArgumentException("The object has to be a UnicaseModelElement!");
	}
}
