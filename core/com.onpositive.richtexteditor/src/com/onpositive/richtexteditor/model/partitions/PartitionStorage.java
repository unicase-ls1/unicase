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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.onpositive.richtexteditor.model.BasePartitionLayer;

/**
 * @author kor
 * Storage for partitions list 
 */
public class PartitionStorage {

	private ArrayList<BasePartition> partitions = new ArrayList<BasePartition>();
	private BasePartitionLayer layer;

	/**
	 * @return {@link ILineAttributeModel} associated with storage
	 */
	public ILineAttributeModel getLineAttributeModel() {
		return ((AbstractModel) layer).getLineAttributeModel();
	}

	/**
	 * Basic constructor
	 * @param layer new storage's layer
	 */
	public PartitionStorage(BasePartitionLayer layer) {
		super();
		this.layer = layer;

	}

	/**
	 * Applies a change to storage
	 * @param change change to apply
	 * @return {@link PartitionDelta} for change
	 */
	public PartitionDelta apply(Change change) {
		PartitionDelta delta = new PartitionDelta(this);
		change.apply(delta);
		Set<BasePartition> changed = delta.getChanged();
		if (delta.isOptimizeParitions()) {
			for (BasePartition p : changed) {
				tryMerge(delta, change, p);
			}
		}
		Collections.reverse(delta.getUndoChange().getParts());
		validate();
		return delta;
	}

	private void tryMerge(PartitionDelta delta, Change change, BasePartition p) {
		int pa = p.getPosition();
		if (pa == -1) {
			return;
		}
		while (pa > 0 && pa < partitions.size()) {
			BasePartition pz = partitions.get(pa - 1);
			if (pz != p && pz.equalsByStyle(p)) {
				AddRemovePartitionChange addRemovePartitionChange = new AddRemovePartitionChange(
						pz.getPosition(), pz, false);
				addRemovePartitionChange.apply(delta);
				AdjustPartitionChange adjustPartitionChange = new AdjustPartitionChange(
						p, pz.getOffset(), p.getLength() + pz.getLength());
				adjustPartitionChange.apply(delta);
				pa--;
			} else {
				break;
			}
		}
		pa = p.getPosition();
		while (pa < partitions.size() - 1 && size() > 1) {
			BasePartition pz = partitions.get(pa + 1);
			if (pz != p && pz.equalsByStyle(p)) {
				AddRemovePartitionChange addRemovePartitionChange = new AddRemovePartitionChange(
						pz.getPosition(), pz, false);
				addRemovePartitionChange.apply(delta);
				AdjustPartitionChange adjustPartitionChange = new AdjustPartitionChange(
						p, p.getOffset(), p.getLength() + pz.getLength());
				adjustPartitionChange.apply(delta);
			} else {
				break;
			}
		}
	}

	void insertPartition(int index, BasePartition partition) {
		
		partitions.add(index, partition);
		partition.index = index;
		int size = partitions.size();
		for (int a = index + 1; a < size; a++) {
			partitions.get(a).index++;
		}
	}

	/**
	 * @param partition Partition to remove
	 */
	public void removePartition(BasePartition partition) {
		if (partition.index >= 0) {
			partitions.remove(partition.index);
			int size = partitions.size();
			for (int a = partition.index; a < size; a++) {
				partitions.get(a).index--;
			}
			partition.index = -1;
		}
	}

	/**
	 * Get partition from storage
	 * @param i index f partition we want to get
	 * @return partition
	 */
	public BasePartition get(int i) {
		return partitions.get(i);
	}

	/**
	 * @return storage size
	 */
	public int size() {
		return partitions.size();
	}

	/**
	 * @return last partition from the storage
	 */
	public BasePartition getLastPartition() {
		return partitions.get(partitions.size() - 1);
	}

	/**
	 * Gets partition containing specified offset
	 * @param offset Offset
	 * @return partition containing specified offset
	 */
	public BasePartition getPartitionAtOffset(int offset) {
		int size = partitions.size();
		for (int a = 0; a < size; a++) {
			BasePartition partition = (BasePartition) partitions.get(a);
			if (partition.getOffset() + partition.getLength() > offset)
				return partition;
		}
		return null;
	}

	/**
	 * @return all partitions of storage
	 */
	public List<BasePartition> getPartitions() {
		return partitions;
	}

	/**
	 * @return new partition for this storage
	 */
	public BasePartition newPartition() {
		return new BasePartition(layer, 0, 0);
	}

	/**
	 * Create a new partition for this store
	 * @param offset new partition's offset
	 * @param length new partition's length
	 * @param p partition to copy attrs from
	 * @return new partition
	 */
	public BasePartition newPartition(int offset, int length, BasePartition p) {
		return PartitionFactory.createAsSampleStyle(p, layer, offset, length);
	}

	/**
	 * @param newPartitions partitions list to set to this storage
	 */
	public void setPartitions(List<BasePartition> newPartitions) {
		this.partitions.clear();
		int size = newPartitions.size();
		for (int a = 0; a < size; a++) {
			BasePartition e = newPartitions.get(a);
			this.partitions.add(e);
			e.index = a;
		}
	}

	/**
	 * Removes specified partition
	 * @param index Index of partition to remove
	 * @return removed partition
	 */
	public BasePartition removePartition(int index) {
		BasePartition remove = partitions.remove(index);
		int size = partitions.size();
		for (int a = index; a < size; a++) {
			partitions.get(a).index--;
		}
		return remove;
	}

	/**
	 * @return copy of storages partitions list
	 */
	public List<BasePartition> clonePartitions() {
		ArrayList<BasePartition> partition = new ArrayList<BasePartition>();
		for (BasePartition p : this.partitions) {
			partition.add(p.clone());
		}
		return partition;
	}
	
	protected void validate()
	{
		
		int size = partitions.size();
		for (int i = 1; i < size; i++)
		{
			BasePartition partition = partitions.get(i);
			if (partition.getOffset() != partitions.get(i-1).getOffset() +  partitions.get(i-1).getLength())
			{
				String message = "Partitios list failure: partitions \n" +
						partitions.get(i-1) + "\n" +
						partition;
				throw new RuntimeException(message);
			}			
		}
	}
	
	
	public String toString()
	{
		return partitions.toString();
	}
}
