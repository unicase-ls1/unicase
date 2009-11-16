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

import org.eclipse.jface.text.IDocument;

/**
 * @author 32kda
 * Basic partition layer interface
 */
public interface IPartitionLayer
{
	/**
	 * Return partition containing symbol at specified offset
	 * @param offset Offset to search at 
	 * @return partition
	 */
	IPartition getPartitionAtOffset(int offset); 
	
	/**
	 * @param doc document for connecting
	 */
	void connectToDocument(IDocument doc);
	
	/**
	 * disconnect from document
	 */
	void disconnectFromDocument();
	
	/**
	 * @param listener {@link IPartitionListener} to add
	 */
	void addPartitionListener(IPartitionListener listener);

	/**
	 * @param listener Listener to remove 
	 */
	void removePartitionListener(IPartitionListener listener);
	
		
}
