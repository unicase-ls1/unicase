/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.requests;

import java.util.List;

import org.eclipse.gmf.runtime.common.ui.dialogs.ExpansionType;
import org.eclipse.gmf.runtime.diagram.ui.requests.ShowRelatedElementsRequest;

/**
 * @author schroech
 */
public class ShowRelatedElementsModeRequest extends ShowRelatedElementsRequest {

	private final boolean enable;

	/**
	 * Constructor for ShowRelatedElementsModeRequest. Filter is set to the default of true and the default list of
	 * models will be used.
	 * 
	 * @param shapes List of IShapeView objects that were selected
	 * @param relationshipTypesToShow List of relationship type hints to show. Use CoreUMLTypeInfo.
	 * @param isExpandIndefinite true to expand indefinitely, false not to.
	 * @param expandLevel specify an int level here for the number of levels to expand if you set isExpandIndefinite to
	 *            false.
	 * @param expansionType should include incoming or outgoing relationships when searching for related elements if
	 *            this is true
	 * @param enable enable or disable the mode
	 */
	@SuppressWarnings("unchecked")
	public ShowRelatedElementsModeRequest(List shapes, List relationshipTypesToShow, boolean isExpandIndefinite,
		int expandLevel, ExpansionType expansionType, boolean enable) {
		super(shapes, relationshipTypesToShow, isExpandIndefinite, expandLevel, expansionType);
		this.enable = enable;
	}

	/**
	 * @return If the edit mode should be enabled
	 */
	public boolean isEnable() {
		return enable;
	}

}
