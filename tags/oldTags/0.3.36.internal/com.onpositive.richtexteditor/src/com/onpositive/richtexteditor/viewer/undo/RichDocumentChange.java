/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.onpositive.richtexteditor.viewer.undo;

import com.onpositive.richtexteditor.model.partitions.PartitionDelta;

/**
 * @author kor
 *
 */
public class RichDocumentChange {

	private final PartitionDelta delta;

	/**
	 * @param delta (partition delta)
	 */
	public RichDocumentChange(PartitionDelta delta) {
		super();
		this.delta=delta;
	}

	/**
	 * @return delta
	 */
	public PartitionDelta getDelta() {
		return delta;
	}
	
	
}
