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


/**
 * @author 32kda
 * Basic interface for partitions change listener
 */
public interface IPartitionListener
{
	
	/**
	 * Occurs, when layer (several partitions) changes
	 * @param event {@link LayerEvent} instance
	 */
	public void layerChanged(LayerEvent event);
	
	/**
	 * Occurs, when single partition changes
	 * @param event {@link PartitionEvent} instance
	 */
	public void partitionChanged(PartitionEvent event);
}
