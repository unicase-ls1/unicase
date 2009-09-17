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
 * Partition shifting command
 */
public class ShiftPartitionAtPositionChange extends Change {

	private int index;
	private int amount;

	/**
	 * Basic constructor
	 * @param index offset of shifted partition
	 * @param amount amount to shift to
	 */
	public ShiftPartitionAtPositionChange(int index, int amount) {
		super();
		this.amount = amount;
		this.index = index;
	}

	
	protected void apply(PartitionDelta delta) {
		final PartitionStorage partitionStorage = delta.getStorage();
		final int i = index;
		for (int a = i; a < partitionStorage.size(); a++) {
			BasePartition basePartition = partitionStorage.get(a);
			basePartition.setOffset(basePartition.getOffset() + amount);
		}
		Change change = new Change() {

			
			protected void apply(PartitionDelta delta) {

				for (int a = i; a < partitionStorage.size(); a++) {
					BasePartition basePartition = partitionStorage.get(a);
					basePartition.setOffset(basePartition.getOffset() - amount);
				}
				delta.getUndoChange().add(ShiftPartitionAtPositionChange.this);
			}

		};
		delta.getUndoChange().add(change);
	}
	
	
	public String toString()
	{
		return "Shift partition# " + index + " amount " + amount;
	}

}
