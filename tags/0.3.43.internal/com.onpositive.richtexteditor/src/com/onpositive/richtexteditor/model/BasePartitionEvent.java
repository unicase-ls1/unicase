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

import java.util.EventObject;

import com.onpositive.richtexteditor.model.partitions.BasePartition;



/**
 * @author 32kda
 * Event for indicating, that partition has changed
 */
public class BasePartitionEvent extends EventObject implements PartitionEvent
{
	BasePartition sourcePartition = null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6253669475552506423L;

	
	/**
	 * Basic constructor
	 * @param source event source Partition
	 */
	public BasePartitionEvent(BasePartition source)
	{
		super(source);
		sourcePartition = source;
	}

	
	/**
	 * @return event source partition 
	 * 
	 */
	public IPartition getPartition()
	{
		return sourcePartition;
	}

}
