/*******************************************************************************
 * Copyright (c) 2007, 2008 OnPositive Technologies (http://www.onpositive.com/) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     OnPositive Technologies (http://www.onpositive.com/) - initial API and implementation
 *******************************************************************************/

package com.onpositive.richtexteditor.model.partitions;

/**
 * @author kor
 * Change class incapsulating adding/removing partition command
 */
public class AddRemovePartitionChange extends AbstractPartitionChange{

	boolean add;
	int index;
	
	/**
	 * Basic constructor
	 * @param index Change index 
	 * @param partition partition to add/remove
	 * @param add true if we should add partition, false - if remove
	 */
	public AddRemovePartitionChange(int index,BasePartition partition,boolean add) {
		super(partition);
		if (!add){
			if (partition.index ==-1){
				throw new IllegalArgumentException();
			}
		}
		this.index=index;
		this.add=add;
	}

	

	
	protected void apply(PartitionDelta delta) {
		PartitionStorage storage=delta.getStorage();
		if (add){
			storage.insertPartition(index, partition);
			delta.added(partition);
		}
		else{			
			if (partition.index==-1){ //TODO something strange
				BasePartition removePartition = storage.removePartition(index);
				if (removePartition instanceof RegionPartition)
					((RegionPartition) removePartition).dispose();
				delta.removed(removePartition);
			}
			else{
				if (partition instanceof RegionPartition)
					((RegionPartition) partition).dispose();
				storage.removePartition(partition);
				delta.removed(partition);
			}
		}
		delta.getUndoChange().add(new AddRemovePartitionChange(index,partition,!add));
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String res;
		if (add)
			res = "Add ";
		else
			res = "Remove ";
		res = res + partition.toString() + " index " + index; 
		return res;
	}

}
