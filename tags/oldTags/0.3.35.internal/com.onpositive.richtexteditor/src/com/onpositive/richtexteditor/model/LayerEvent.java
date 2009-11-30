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

package com.onpositive.richtexteditor.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;

import com.onpositive.richtexteditor.model.partitions.BasePartition;


/**
 * @author 32kda
 * Layer event, means htat several partitions has changed
 */
public class LayerEvent extends EventObject
{
	private static final long serialVersionUID = 8698496996609675219L;
	
	private ArrayList<IPartition> changedPartitions=new ArrayList<IPartition>();

	/**
	 * Basic constructor
	 * @param source source layer
	 */
	public LayerEvent(IPartitionLayer source)
	{
		super(source);
		this.source = source;
	}
	
	/**
	 * Commonly used constructor
	 * @param source Source layer
	 * @param changedPartitions changed partitions list
	 */
	public LayerEvent(IPartitionLayer source, Collection<IPartition> changedPartitions)
	{
		super(source);
		this.source = source;
		this.changedPartitions = new ArrayList<IPartition>(changedPartitions);
	}

	
	/**
	 * @return changed partitions list
	 */
	public Collection<IPartition> getChangedPartitions()
	{
		return changedPartitions;
	}
	
	/**
	 * @see java.util.EventObject#getSource()
	 */
	public IPartitionLayer getSource(){
		return (IPartitionLayer) source;
	}
	
	
	/**
	 * Add single changed partition to event
	 * @param partition changed partition 
	 */
	public void addChangedPartition(BasePartition partition)
	{
		changedPartitions.add(partition);
	}
}
