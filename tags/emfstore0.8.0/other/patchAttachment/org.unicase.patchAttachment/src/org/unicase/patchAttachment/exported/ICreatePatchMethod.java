/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.patchAttachment.exported;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;

/**
 * A Create patch method creates a patch from a source.
 * @author jfinis
 *
 */
public interface ICreatePatchMethod {

	/**
	 * Creates a patch.
	 * @param source from which source?
	 * @return the patch
	 */
	IStorage createPatch(IResource source);
}
