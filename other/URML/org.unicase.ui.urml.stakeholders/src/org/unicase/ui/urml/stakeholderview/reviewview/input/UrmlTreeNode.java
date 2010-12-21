/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview.reviewview.input;

import org.eclipse.jface.viewers.TreeNode;
import org.unicase.model.urml.UrmlModelElement;

public class UrmlTreeNode extends TreeNode {

	public UrmlTreeNode(UrmlModelElement value) {
		super(value);
	}
	
	@Override
	public UrmlModelElement getValue() {
		return (UrmlModelElement) value;
	}

}
