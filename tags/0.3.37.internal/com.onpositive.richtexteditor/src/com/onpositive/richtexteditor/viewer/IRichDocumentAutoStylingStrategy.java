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

package com.onpositive.richtexteditor.viewer;

import org.eclipse.jface.text.DocumentEvent;

import com.onpositive.richtexteditor.model.partitions.CompositeChange;
import com.onpositive.richtexteditor.model.partitions.PartitionDelta;

/**
 * @author kor
 *  Auto Styling Strategy interface
 */
public interface IRichDocumentAutoStylingStrategy {

	/**
	 * Determines changes needed to be performed for auto styling strategy
	 * @param event DocuentEvent
	 * @param change change to add auto styling changes to
	 * @param existingDelta delta of already performed change
	 */
	public void customizeStyleChanges(DocumentEvent event,CompositeChange change, PartitionDelta existingDelta);
}
