/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.workpackagetransfer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;

/**
 * 
 * @author mkagel
 * This final class contains utility methods for handling the CheckBoxes of the WorkItem-Tree.
 *
 */
public final class TreeHandler {
	
	private AdapterFactoryLabelProvider labelProvider;
	private WorkPackage rootWorkPackage;
	
	
	/**
	 * Class-Constructor.
	 * 
	 * @param labelProvider to get the image of a WorkItem
	 * @param rootWorkPackage the source WorkPackage of the move operation
	 */
	public TreeHandler(AdapterFactoryLabelProvider labelProvider, WorkPackage rootWorkPackage) {
		this.labelProvider = labelProvider;
		this.rootWorkPackage = rootWorkPackage;
	}
	
	
	/**
	 * Creates the Structure of the WorkItem tree in the wizard.		
	 * @param tree handle for the treeItems
	 */
	public void createTreeStructure(Tree tree) {
		TreeItem rootItem = createTreeItem(tree, rootWorkPackage);
		
		if(rootWorkPackage.getContainedWorkItems() != null && !rootWorkPackage.getContainedWorkItems().isEmpty()) {
			initialCreateTreeItems(rootItem);
			initialCheckTreeItems(rootItem);
		}		
	}
	
	/**
	 * Method to uncheck a treeItem. Unchecks the parent and children elements too, if the controls are set.
	 * @param treeItem which is the source of the action
	 * @param uncheckParents control to uncheck also parent treeItems (true=uncheck them / false=don't uncheck them)
	 * @param uncheckChildren control to uncheck also children treeItems (true=uncheck them / false=don't uncheck them)
	 */
	public void uncheckTreeItem(TreeItem treeItem, boolean uncheckParents, boolean uncheckChildren) {
		treeItem.setChecked(false);
				
		WorkItem workItem = (WorkItem)treeItem.getData();
			
		if(uncheckParents && !((workItem instanceof WorkPackage) && ((WorkPackage)workItem).equals(rootWorkPackage))) {
			uncheckTreeItem(treeItem.getParentItem(), uncheckParents, false);
		} 
		
		if(uncheckChildren) {
			List<TreeItem> children = Arrays.asList(treeItem.getItems());
			for(TreeItem child : children) {
				uncheckTreeItem(child, false, uncheckChildren);
			}
		}
	}		
		
	/**
	 * Method to check a treeItem. Checks the children elements too, if the controls are set.
	 * @param nodeTreeItem which is the source of the action
	 * @param checkChildren control to check also children treeItems (true=check them / false=don't check them)
	 */
	public void checkTreeItem(TreeItem nodeTreeItem, boolean checkChildren) {
		nodeTreeItem.setChecked(true);
		if(checkChildren) {
			List<TreeItem> treeItems = Arrays.asList(nodeTreeItem.getItems());
			
			for(TreeItem treeItem : treeItems) {
				treeItem.setChecked(true);
				if((WorkItem)treeItem.getData() instanceof WorkPackage) {
					checkTreeItem(treeItem, checkChildren);
				}
			}
		}
	}
	
	/**
	 * Return a List with all WorkItems, whose treeItems are checked.
	 * @param tree handle for the whole tree
	 * @return a List with WorkItems, which should be moved
	 */
	public List<WorkItem> getCheckedWorkItems(Tree tree) {
		List<WorkItem> checkedWorkedItems = new ArrayList<WorkItem>();
		List<TreeItem> treeItems = Arrays.asList(tree.getItems());
		
		for(TreeItem treeItem : treeItems) {
			checkedWorkedItems.addAll(getCheckedWorkItems(treeItem));
		}
		
		return checkedWorkedItems;
	}
	
	
	
	
	
	
	
	/**
	 * Helper method for getCheckedWorkItems(Tree), it's checking the treeItems, which are checked and collect them in a list.
	 * @param nodeTreeItem treeItem which should be checked
	 * @return list with checked treeItems
	 */
	private List<WorkItem> getCheckedWorkItems(TreeItem nodeTreeItem) {
		List<WorkItem> checkedWorkedItems = new ArrayList<WorkItem>();
		
		if(nodeTreeItem.getChecked()) {
			checkedWorkedItems.add((WorkItem)nodeTreeItem.getData());
		}
		
		List<TreeItem> treeItems = Arrays.asList(nodeTreeItem.getItems());
		
		for(TreeItem treeItem : treeItems) {
			checkedWorkedItems.addAll(getCheckedWorkItems(treeItem));
		}
		
		return checkedWorkedItems;
	}
	
	/**
	 * Makes the initial treeItem check. WorkItems which are closed have to be unchecked, all others must be checked.
	 * @param rootItem rootItem of the tree
	 */
	private void initialCheckTreeItems(TreeItem rootItem) {
		
		checkTreeItem(rootItem, true);
		
		List<TreeItem> treeItems = Arrays.asList(rootItem.getItems());
		
		for(TreeItem treeItem : treeItems) {
			WorkItem workItem = (WorkItem)treeItem.getData();
			
			try {
				if(workItem.getMEState().getStatus().equals(MEState.CLOSED)) {
					uncheckTreeItem(treeItem, true, false);
				}
			} catch (CircularDependencyException e) {
				//nothing
			}
			
			if(workItem instanceof WorkPackage){	
				initialCheckTreeItems(treeItem);
			}			
		}		
	}
	
	/**
	 * Creates the treeItems like the structure of the WorkItems.
	 * @param rootItem rootItem of the Tree
	 */
	private void initialCreateTreeItems(TreeItem rootItem) {
		WorkPackage parentWorkPackage = (WorkPackage)rootItem.getData();
		List<WorkItem> workItems = parentWorkPackage.getContainedWorkItems();
		
		for(WorkItem workItem : workItems) {
			TreeItem treeItem = createTreeItem(rootItem, workItem);			
			
			if(workItem instanceof WorkPackage){	
				initialCreateTreeItems(treeItem);
			}			
		}
	}	
	
	/**
	 * Creates a treeItem for a tree and fills it with data from the workItem.
	 * @param tree where the treeItem belongs to, the treeItem is the root element of the tree
	 * @param workItem delivers the data for the treeItem
	 * @return the created treeItem
	 */
	private TreeItem createTreeItem(Tree tree, WorkItem workItem) {
		TreeItem rootItem = new TreeItem(tree, 0);
		fillTreeItemWithData(rootItem, workItem);
		
		return rootItem;
	}
	
	/**
	 * Creates a treeItem for another treeItem and fills it with data from the workItem.
	 * @param rootItem where the treeItem belongs to
	 * @param workItem delivers the data for the treeItem
	 * @return the created treeItem
	 */
	private TreeItem createTreeItem(TreeItem rootItem, WorkItem workItem) {
		TreeItem treeItem = new TreeItem(rootItem, 0);
		fillTreeItemWithData(treeItem, workItem);	
		
		return treeItem;
	}	
	
	/**
	 * Fills a treeItem with the data of the given workItem.
	 * @param treeItem which should be filled with data
	 * @param workItem delivers the data for the treeItem
	 */
	private void fillTreeItemWithData(TreeItem treeItem, WorkItem workItem) {
		treeItem.setData(workItem);
		treeItem.setImage(labelProvider.getImage(workItem));
		treeItem.setText(workItem.getName());
	}
	
}
