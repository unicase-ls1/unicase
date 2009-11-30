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

import java.util.List;

import com.onpositive.richtexteditor.model.partitions.BasePartition;
import com.onpositive.richtexteditor.model.partitions.ImagePartition;
import com.onpositive.richtexteditor.model.partitions.LinkPartition;

/**
 * @author kor
 * Holds different important information about selected region:
 * selected partition, common
 */
public class RichSelectionState {

	List<BasePartition>allPartitions;
		
	BasePartition sumPartition;
	
	boolean hasLinks;
	
	boolean hasImages;
	

	/**
	 * @return all selected partitions
	 */
	public List<BasePartition> getAllPartitions() {
		return allPartitions;
	}

	/**
	 * @return common style partition for all selected partition
	 * This partition has some style (bold, italic, red-colored etc.) only if all selected 
	 * partitions also have it.
	 */
	public BasePartition getSumPartition() {
		return sumPartition;
	}

	/**
	 * @return true, if selection has one or more links
	 */
	public boolean isHasLinks() {
		return hasLinks;
	}

	/**
	 * @return true, if selection has one or more images
	 */
	public boolean isHasImages() {
		return hasImages;
	}

	/**
	 * Basic constructor
	 * @param allPartitions All selected partitions 
	 * @param partition BasePartition
	 */
	public RichSelectionState(List<BasePartition> allPartitions,
			BasePartition partition) {
		super();
		this.allPartitions = allPartitions;
		for (BasePartition p:allPartitions){
			if (p instanceof LinkPartition){
				hasLinks=true;
			}
			if (p instanceof ImagePartition){
				hasImages=true;
			}
		}
		this.sumPartition=partition;
	}

}
