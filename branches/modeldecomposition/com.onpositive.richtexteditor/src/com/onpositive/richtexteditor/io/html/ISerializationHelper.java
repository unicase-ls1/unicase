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
package com.onpositive.richtexteditor.io.html;

import com.onpositive.richtexteditor.model.partitions.BasePartition;
import com.onpositive.richtexteditor.model.partitions.ImagePartition;
import com.onpositive.richtexteditor.model.partitions.LinkPartition;


/**
 * @author kor
 * Basic SerializationHelper interface
 * Instances of ISerializationHelper allows to customize, how HTML or other text content is stored 
 */
public interface ISerializationHelper {

	/**
	 * 
	 * @param partition Image Partition
	 * @return value that should have 'src' attribute in corresponding <img> tag
	 */
	public String getImageLocation(ImagePartition partition);
	
	/**
	 * 
	 * @param partition Image Partition
	 * @return value that should have 'href' attribute in corresponding <A> tag
	 */
	public String getLinkURL(LinkPartition partition);

	/**
	 * 
	 * @param partition Base Partition
	 * @return additional prefix to partition text or null if prefix not needed
	 */
	public String getAdditionPartitionPrefix(BasePartition partition);
	
	/**
	 * 
	 * @param partition Base Partition
	 * @return additional suffix to partition text or null if suffix not needed
	 */
	public String getAdditionPartitionSuffix(BasePartition partition);
	
	
}
