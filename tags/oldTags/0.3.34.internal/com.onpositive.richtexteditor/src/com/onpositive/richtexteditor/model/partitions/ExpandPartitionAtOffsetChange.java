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

import java.util.List;

import com.onpositive.richtexteditor.model.FontStyle;
import com.onpositive.richtexteditor.model.IPartition;

/**
 * @author kor
 * Expanding partition change
 */
public class ExpandPartitionAtOffsetChange extends Change {

	private int offset;
	private int amount;
	private BasePartition current;
	
	private BasePartition psToCreate;

	/**
	 * Basic constructor
	 * @param offset Offset of part. to expand
	 * @param amount Amount to expand to
	 * @param currentFontPartition Current Font Partition
	 */
	public ExpandPartitionAtOffsetChange(int offset, int amount,
			BasePartition currentFontPartition) {
		super();
		this.amount = amount;
		this.offset = offset;
		this.current = currentFontPartition;
	}

	
	protected void apply(PartitionDelta delta) {
		PartitionStorage storage = delta.getStorage();
		PartitionStorage partitionStorage = storage;
		BasePartition partitionAtPosition = partitionStorage
				.getPartitionAtOffset(Math.max(offset - 1, 0));
		BasePartition initial = current != null ? null : partitionAtPosition;
		if (initial instanceof LinkPartition
				|| initial instanceof ObjectPartition) {
			if (offset == 0) {
				initial = null;
			} else {
				if (initial.getOffset() == offset
						|| initial.getOffset() + initial.getLength() == offset) {
					expandOtherPartition(delta, initial);
					return;
				}
			}

		}
		final BasePartition original = initial;
		final BasePartition partitionAtOffset = original != null ? original
				: createPartition(partitionStorage);
		if (original == null) {
			// int pos = determineInsertionOffset(partitionStorage);
			IPartition pa=null;
			pa = getPartitionToInsertIn(storage, pa);
			if (pa==null) {
				int pos = determineInsertionOffset(partitionStorage);
				partitionStorage.insertPartition(pos, partitionAtOffset);
				delta.added(partitionAtOffset);
			} else {
				CompositeChange cq=new CompositeChange(storage);
				BasePartition fp = (BasePartition) pa;
				cq.setLength(fp, pa.getLength()+amount);
				cq.shiftOffsets(fp.getPosition()+1, amount);
				cq.apply(delta);
				cq=new CompositeChange(storage);
				List<IPartition> extractChangedRegion = cq.extractChangedRegion(
						offset, amount);
				FontStyle fs = new FontStyle(current);
				for (IPartition p : extractChangedRegion) {
					PartitionStyleChange change = new PartitionStyleChange(
							(BasePartition) p, fs, false);
					change.setSet(true);
					cq.add(change);
				}
				cq.apply(delta);				
				return;
			}
		}
		partitionAtOffset.setLength(partitionAtOffset.getLength() + amount);
		delta.changed(partitionAtOffset);
		final int i = partitionAtOffset.getPosition() + 1;
		for (int a = i; a < partitionStorage.size(); a++) {
			BasePartition basePartition = partitionStorage.get(a);
			basePartition.setOffset(basePartition.getOffset() + amount);
		}
		Change change = new Change() {

			
			protected void apply(PartitionDelta delta) {
				PartitionStorage partitionStorage = delta.getStorage();
				if (original == null) {
					partitionStorage.removePartition(partitionAtOffset);
				}
				if (partitionAtOffset != null) {
					partitionAtOffset.setLength(partitionAtOffset.getLength()
							- amount);
				}
				for (int a = original!=null?i:i-1; a < partitionStorage.size(); a++) {
					BasePartition basePartition = partitionStorage.get(a);
					basePartition.setOffset(basePartition.getOffset() - amount);
				}
				delta.getUndoChange().add(ExpandPartitionAtOffsetChange.this);
			}

		};
		delta.getUndoChange().add(change);
	}

	private IPartition getPartitionToInsertIn(PartitionStorage storage,
			IPartition pa) {
		for (IPartition p:storage.getPartitions()){
			boolean b = p.getOffset()<offset;
			if (b)
			{
				if (p.getOffset()+p.getLength()>offset){
					pa=p;
					break;
				}
			}
			else{
				break;
			}
		}
		return pa;
	}

	private int determineInsertionOffset(PartitionStorage partitionStorage) {
		int pos = partitionStorage.size();
		for (int a = 0; a < partitionStorage.size(); a++) {
			IPartition pa = partitionStorage.get(a);
			if (pa.getOffset() >= offset) {
				pos = a;
				break;
			}
		}
		return pos;
	}

	private BasePartition createPartition(PartitionStorage partitionStorage) {
		if (psToCreate!=null){
			return psToCreate;
		}
		BasePartition internalCreatePartition = internalCreatePartition(partitionStorage);
		psToCreate=internalCreatePartition;
		return internalCreatePartition;
	}

	private BasePartition internalCreatePartition(
			PartitionStorage partitionStorage) {
		if (current != null) {
			return partitionStorage.newPartition(offset, 0, current);
		}
		return partitionStorage.newPartition();
	}

	private void expandOtherPartition(PartitionDelta delta, BasePartition ps) {
		PartitionStorage partitionStorage = delta.getStorage();
		final BasePartition original = getNextUsualPartition(partitionStorage);
		final BasePartition partitionAtOffset = original != null ? partitionStorage
				.newPartition(offset, amount, original)
				: createPartition(partitionStorage);
		partitionStorage.insertPartition(ps.getPosition() + 1,
				partitionAtOffset);
		partitionAtOffset.setOffset(offset);
		partitionAtOffset.setLength(amount);
		delta.added(partitionAtOffset);

		final int i = partitionAtOffset.getPosition() + 1;
		for (int a = i; a < partitionStorage.size(); a++) {
			BasePartition basePartition = partitionStorage.get(a);
			basePartition.setOffset(basePartition.getOffset() + amount);
		}
		Change change = new Change() {

			
			protected void apply(PartitionDelta delta) {
				PartitionStorage partitionStorage = delta.getStorage();
				if (original == null) {
					partitionStorage.removePartition(partitionAtOffset);
				} else if (partitionAtOffset != null) {
					partitionAtOffset.setOffset(partitionAtOffset.getOffset()
							+ amount);
				}
				for (int a = i; a < partitionStorage.size(); a++) {
					BasePartition basePartition = partitionStorage.get(a);
					basePartition.setOffset(basePartition.getOffset() + amount);
				}
				delta.getUndoChange().add(ExpandPartitionAtOffsetChange.this);
			}

		};
		delta.getUndoChange().add(change);
	}

	private BasePartition getNextUsualPartition(
			PartitionStorage partitionStorage) {
		int pos = offset + 1;
		while (true) {
			BasePartition partitionAtOffset = partitionStorage
					.getPartitionAtOffset(pos);
			if (partitionAtOffset instanceof LinkPartition
					|| partitionAtOffset instanceof ObjectPartition) {
				pos = partitionAtOffset.getOffset()
						+ partitionAtOffset.getLength();
			} else {
				return partitionAtOffset;
			}
		}
	}
	
	
	public String toString()
	{
		return "Expand " + current + " at " + offset + " amount: " + amount;
	}
}
