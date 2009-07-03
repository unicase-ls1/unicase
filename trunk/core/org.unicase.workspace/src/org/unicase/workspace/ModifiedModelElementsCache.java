/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import java.util.HashMap;
import java.util.Map;

import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;

/**
 * @author hodaie
 */
public class ModifiedModelElementsCache {

	private Map<ModelElementId, ModelElement> modifiedMEs = new HashMap<ModelElementId, ModelElement>();

	/**
	 * If this model element has been modified.
	 * 
	 * @param modelElement model element
	 * @return If this model element has been modified.
	 */
	public boolean isDirty(ModelElement modelElement) {

		return modifiedMEs.containsKey(modelElement.getModelElementId());
	}

	/**
	 * If this model element has been modified.
	 * 
	 * @param meId model element id
	 * @return If this model element has been modified.
	 */
	public boolean isDirty(ModelElementId meId) {

		return modifiedMEs.containsKey(meId);
	}

}
