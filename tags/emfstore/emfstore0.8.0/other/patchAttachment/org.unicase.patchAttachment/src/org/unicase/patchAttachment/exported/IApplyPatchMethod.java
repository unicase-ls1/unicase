/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.patchAttachment.exported;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;

/**
 * An apply patch method is a class that allows to apply a patch.
 * @author jfinis
 *
 */
public interface IApplyPatchMethod {

	/**
	 * Applies a patch onto a target.
	 * @param patch the storage containing the patch
	 * @param target the target for the patch
	 */
	void applyPatch(IStorage patch, IResource target);
}
