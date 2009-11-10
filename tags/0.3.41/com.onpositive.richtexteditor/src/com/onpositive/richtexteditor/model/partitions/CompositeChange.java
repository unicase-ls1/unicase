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
import java.util.List;

import com.onpositive.richtexteditor.model.FontStyle;
import com.onpositive.richtexteditor.model.IPartition;

/**
 * @author kda
 * Change command, that can contain several changes
 */
public class CompositeChange extends Change {

	private ArrayList<Change> parts = new ArrayList<Change>();
	private PartitionStorage storage;
	private int newSize;

	/**
	 * Apply style with style merging to text region
	 * @param offset Offset
	 * @param length Length
	 * @param style Style to apply
	 */
	public void applyStyleTo(int offset, int length, FontStyle style) {
		List<IPartition> extractChangedRegion = extractChangedRegion(offset,
				length);
		for (IPartition p : extractChangedRegion) {
			PartitionStyleChange partitionStyleChange = new PartitionStyleChange(
					(BasePartition) p, style, true);
			add(partitionStyleChange);
		}
	}
	
	/**
	 * Apply style with style merging to text region
	 * @param partition Partition to apply style on
	 * @param style Style to apply
	 */
	public void applyStyleToPartition(BasePartition partition, FontStyle style) {
			PartitionStyleChange partitionStyleChange = new PartitionStyleChange(
					partition, style, true);
			add(partitionStyleChange);		
	}

	/**
	 * Apply style with style merging to text region
	 * @param offset Offset
	 * @param length Length
	 * @param style Style to apply
	 */
	public void setStyleOn(int offset, int length, FontStyle style) {
		List<IPartition> extractChangedRegion = extractChangedRegion(offset,
				length);
		for (IPartition p : extractChangedRegion) {
			PartitionStyleChange partitionStyleChange = new PartitionStyleChange(
					(BasePartition) p, style, false);
			partitionStyleChange.setSet(true);
			add(partitionStyleChange);
		}
	}
	
	/**
	 * Remove style with style from text region
	 * @param offset Offset
	 * @param length Length
	 * @param style Style to apply
	 */
	public void removeStyleFrom(int offset, int length, FontStyle style) {
		List<IPartition> extractChangedRegion = extractChangedRegion(offset,
				length);
		for (IPartition p : extractChangedRegion) {
			PartitionStyleChange partitionStyleChange = new PartitionStyleChange(
					(BasePartition) p, style, false);
			add(partitionStyleChange);
		}
	}

	/**
	 * Remove or resize partitions in case of text deletion
	 * @param offset Offset of deleted text fragment
	 * @param length Length of deleted text fragment
	 */
	public void removePartitionsFromTo(int offset, int length) {
		CompositeChange change = this;
		int end = offset + length;

		for (BasePartition p : storage.getPartitions()) {
			int poffset = p.getOffset();
			int plength = p.getLength();
			int pend = poffset + plength;
			if (pend < offset) {
				continue;
			} else if (poffset >= end) {
				break;
			}
			// this partition is subject of interest;
			if (poffset >= offset && pend <= end) {
				// just remove it
				remove(p);
			} else if (poffset < offset) {
				int newLength = poffset - offset;
				{
					if (pend < end) {
						change.setLength(p, -newLength);
					} else {
						BasePartition newPartition = storage.newPartition(
								poffset, offset - poffset, p);
						BasePartition newPartition2 = storage.newPartition(end,
								pend - end, p);
						if (newPartition.getLength() > 0) {
							change.addPartition(p.getPosition() - 1,
									newPartition);

						}
						if (newPartition2.getLength() > 0) {
							change.addPartition(p.getPosition() + 1,
									newPartition2);

						}
						change.remove(p);
					}
				}
			} else if (pend > end) {
				int newLength = pend - end;
				change.adjustPartition(p, end, newLength);
			}
		}
	}

	/**
	 * Extract all partitions from changed region to perform change on them
	 * @param offset Offset of changed text fragment
	 * @param length Length of changed text fragment
	 * @return list of partitions that changed/should be changed
	 */
	public List<IPartition> extractChangedRegion(int offset, int length) {
		CompositeChange change = this;
		int end = offset + length;
		ArrayList<IPartition> result = new ArrayList<IPartition>();
		int shift = 0; //we need this to take into account previously added partitions cont, when creating add partition command TODO
		for (BasePartition p : storage.getPartitions()) {
			int poffset = p.getOffset();
			int plength = p.getLength();
			int pend = poffset + plength;
			if (pend < offset) {
				continue;
			} else if (poffset >= end) {
				break;
			}
			// this partition is subject of interest;
			if (poffset >= offset && pend <= end) {
				// just add this partition
				result.add(p);
			} else if (poffset < offset) {
				// split on left and right parts
				int newLength = poffset - offset;
				if (newLength > 0) {
					BasePartition newPartition = storage.newPartition(offset,
							pend - offset, p);

					change.addPartition(p.getPosition() + shift++, newPartition);
					change.setLength(p, newLength);
					result.add(newPartition);
				} else {
					if (pend < end) {
						BasePartition newPartition = storage.newPartition(
								offset, pend - offset, p);
						if (newPartition.getLength() > 0) {
							change.addPartition(p.getPosition() + shift++, newPartition);
							result.add(newPartition);
						}
						change.setLength(p, -newLength);

					} else {
						BasePartition newPartition = storage.newPartition(
								poffset, offset - poffset, p);
						BasePartition newPartition2 = storage.newPartition(end,
								pend - end, p);
						if (newPartition.getLength() > 0) {
							change.addPartition(p.getPosition() - 1,
									newPartition);

						}
						if (newPartition2.getLength() > 0) {
							change.addPartition(p.getPosition() + 1,
									newPartition2);

						}
						change.adjustPartition(p, offset, length);
						result.add(p);
					}
				}
			} else if (pend > end) {
				int newLength = pend - end;
				BasePartition newPartition = storage.newPartition(poffset, end
						- poffset, p);
				if (newPartition.getLength() > 0) {
					change.addPartition(p.getPosition() - 1 + shift++, newPartition); //TODO something strange here
					result.add(newPartition);
				}
				change.adjustPartition(p, end, newLength);

				// split on right and left parts
			}
		}
		return result;
	}

	/**
	 * @return new Storage size
	 */
	public int getNewStorageSize() {
		return newSize;
	}

	/**
	 * Basic constructor
	 * @param storage Partition storage
	 */
	public CompositeChange(PartitionStorage storage) {
		this.storage = storage;
		newSize = storage.size();
	}

	/**
	 * Add merge change to this
	 * @param partitionIdx first merged partition
	 */
	public void addMergeChange(int partitionIdx) {
		BasePartition cur = storage.get(partitionIdx);
		BasePartition next = storage.get(partitionIdx + 1);
		setLength(cur, cur.getLength() + next.getLength());
		remove(partitionIdx + 1);
	}

	/**
	 * New set length change
	 * @param startPartition partition to set length to 
	 * @param length new length
	 */
	public void setLength(BasePartition startPartition, int length) {
		adjustPartition(startPartition, startPartition.getOffset(), length);
	}

	/**
	 * Shifts all partitions offsets to preserve partition consistency
	 * @param startIndex index of start partition to shift
	 * @param amount Shifting amount
	 */
	public void shiftOffsets(int startIndex, int amount) {
		if (startIndex < storage.size()) {
			for (int i = startIndex; i < storage.size(); i++) {
				adjustPartition(storage.get(i), storage.get(i).getOffset()
						+ amount, storage.get(i).getLength());
			}
		}
	}

	protected BasePartition getNextPartititon(BasePartition partition) {
		int n = partition.getPosition();
		if (n < storage.size() - 1)
			return storage.get(n + 1);
		return null;
	}

	
	protected void apply(PartitionDelta delta) {
		for (Change c : parts) {
			c.apply(delta);
		}
	}


	/**
	 * @param change Change to add to this change
	 */
	public void add(Change change) {
		parts.add(change);
	}

	/**
	* Adds an add partition change to this change 
	 * @param partition part. to add
	 */
	public void addPartition(BasePartition partition) {
		addPartition(newSize - 1, partition);
	}

	/**
     * Adds a remove partition change to this change 
	 * @param i part. index to remove
	 */
	public void remove(int i) {
		add(new AddRemovePartitionChange(i, storage.get(i), false));
		newSize--;
	}

	/**
	* Adds an add partition change to this change 
	 * @param i index, after which new part. will be inserted
	 * @param startPartition part. to add
	 */
	public void addPartition(int i, BasePartition startPartition) {
		add(new AddRemovePartitionChange(i + 1, startPartition, true));
		newSize++;
	}

	/**
	 * Add to this change "add partition at offset change"
	 * @param startPartition part. to add
	 * @param offset Offset, where to add
	 */
	public void addPartitionAtOffset(final BasePartition startPartition,
			final int offset) {
		add(new Change() {

			
			protected void apply(PartitionDelta delta) {
				BasePartition partitionAtOffset = storage
						.getPartitionAtOffset(startPartition.getOffset() - 1);
				if (partitionAtOffset != null && startPartition.offset != 0) {
					int offset = partitionAtOffset.getPosition() + 1;
					BasePartition rightPartition = null;
					if (offset < storage.size()) rightPartition = storage.get(offset);
					new AddRemovePartitionChange(offset, startPartition, true)
							.apply(delta);
					if (rightPartition != null && (startPartition.getLength() + startPartition.getOffset() != rightPartition.getOffset()))
					{
						new ShiftPartitionAtPositionChange(startPartition
								.getPosition() + 1, startPartition.getLength()
								- offset).apply(delta);//TODO something strange, offset means index here
					}
				} else {
					new AddRemovePartitionChange(0, startPartition, true)
							.apply(delta);
					new ShiftPartitionAtPositionChange(1, startPartition
							.getLength()
							- offset).apply(delta);
				}
			}
			
			
			public String toString()
			{				
				return "Add&shift (inner class) " + startPartition + " at index " + offset;
			}

		});
		newSize++;
	}

	/**
	 *	Ad an adjust partition change
	 * @param partition part. to change
	 * @param offset new offset
	 * @param length new length
	 */
	public void adjustPartition(BasePartition partition, int offset, int length) {
		add(new AdjustPartitionChange(partition, offset, length));
	}

	/**
	 * Unused yet
	 */
	public void applyAttributes(BasePartition newPartition,
			BasePartition curPartition) {
	}

	/**
	 * @return parts of this change
	 */
	public List<Change> getParts() {
		return parts;
	}

	/**
	 * Add all parts to this change
	 * @param parts parts to add 
	 */
	public void addAll(List<Change> parts) {
		this.parts.addAll(parts);
	}

	/**
	 * @return Partition Storage
	 */
	public PartitionStorage getStorage() {
		return storage;
	}

	/**
	 * Add a remove partition change
	 * @param part Partition to remove
	 */
	public void remove(BasePartition part) {
		add(new AddRemovePartitionChange(part.getPosition(), part, false));
	}

	/**
	 * Add all parts to this change
	 * @param i index to begin adding from
	 * @param parts parts to add
	 */
	public void addAll(int i, List<Change> parts) 
	{
		this.parts.addAll(i, parts);
	}
	
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder("Composite: {\n");
		int size = parts.size();
		for (int i = 0; i < size; i++)
		{
			builder.append(parts.get(i) + "\n");
		}	
		builder.append("}");
		return builder.toString();
	}

}
