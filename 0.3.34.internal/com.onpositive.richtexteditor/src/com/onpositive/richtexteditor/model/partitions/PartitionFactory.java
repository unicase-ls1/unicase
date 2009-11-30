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


import com.onpositive.richtexteditor.model.BasePartitionLayer;

/**
 * Factory, which constructs new partitions from old using some logics
 * @author 32kda
 * made in USSR
 */
public class PartitionFactory
{
	/**
	 * Creates partition as sample partition without applying sample style
	 * @param sample Sample partition
	 * @param layer Layer of partition
	 * @param offset new partition's offset
	 * @param length new partition's length
	 * @return newly created parittion
	 */
	static BasePartition createAsSample(BasePartition sample, int offset, int length)
	{
		BasePartition partition = sample.clone();
		partition.setOffset(offset);
		partition.setLength(length);		
		//partition.applyAttributes(sample);
		return partition;
	}

	/**
	 * Creates partition as sample partition with applying sample style
	 * @param sample Sample partition
	 * @param layer Layer of partition
	 * @param offset new partition's offset
	 * @param length new partition's length
	 * @return newly created partition
	 */
	public static BasePartition createAsSampleStyle(BasePartition sample, BasePartitionLayer layer, int offset, int length)
	{		
		BasePartition partition = createAsSample(sample,offset,length);
		partition.applyAttributes(sample);
		return partition;
	}
	
	
}
