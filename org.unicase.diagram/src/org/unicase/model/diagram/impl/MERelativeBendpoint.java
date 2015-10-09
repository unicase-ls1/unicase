/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.impl;

import java.io.Serializable;

import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;

/**
 * Serializable extension of GMF's {@link RelativeBendpoint}.
 * 
 * @author mharut
 */
public class MERelativeBendpoint extends RelativeBendpoint implements Serializable {

	private static final long serialVersionUID = -6307559151584936745L;

	/**
	 * Default constructor required for serialization.
	 */
	public MERelativeBendpoint() {
		super();
	}

	/**
	 * Initializes a bendpoint by setting the required coordinates.
	 * 
	 * @param sourceX the source's x-coordinate
	 * @param sourceY the source's y-coordinate
	 * @param targetX the target's x-coordinate
	 * @param targetY the target's y-coordinate
	 */
	public MERelativeBendpoint(int sourceX, int sourceY, int targetX, int targetY) {
		super(sourceX, sourceY, targetX, targetY);
	}

}
