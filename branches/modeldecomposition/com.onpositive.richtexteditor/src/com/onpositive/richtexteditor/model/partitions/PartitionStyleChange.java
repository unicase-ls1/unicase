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

import com.onpositive.richtexteditor.model.FontStyle;

/**
 * @author kor
 * Partition Style Change command
 */
public class PartitionStyleChange extends AbstractPartitionChange {

	private FontStyle style;
	private boolean add;
	private boolean set;

	/**
	 * @return is this change hardly setting style or applying/removing it?
	 */
	public boolean isSet() {
		return set;
	}

	/**
	 * @param set Set,is this change hardly setting style or applying/removing it
	 */
	public void setSet(boolean set) {
		this.set = set;
	}

	/**
	 * Basic constructor
	 * @param partition partition to change
	 * @param style style of change
	 * @param add add/remove
	 */
	public PartitionStyleChange(BasePartition partition, FontStyle style,
			boolean add) {
		super(partition);
		this.style = style;
		this.add = add;
	}

	
	protected void apply(PartitionDelta delta) {
		partition.getBgColorRGB();
		final FontStyle oldStyle = new FontStyle(partition);
		if (set) {
			style.setStyle(partition);
		} else {
			if (add) {
				style.applyStyle(partition);
			} else {
				style.removeStyle(partition);
			}
		}
		AbstractPartitionChange abstractPartitionChange = new AbstractPartitionChange(
				partition) {

			protected void apply(PartitionDelta partitionStorage) {
				oldStyle.setStyle(partition);
				partitionStorage.getUndoChange().add(PartitionStyleChange.this);
			}

		};
		delta.changed(partition);
		delta.getUndoChange().add(abstractPartitionChange);
	}
	
	
	public String toString()
	{
		String s;
		if (add)
			s = "Apply style ";
		else
			s = "Remove style ";		 
		return s + style + " " + partition;
	}

}
