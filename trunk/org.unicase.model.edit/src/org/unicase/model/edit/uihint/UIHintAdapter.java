/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.edit.uihint;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface UIHintAdapter {
	FeatureUIHint getFeatureUIHint(EStructuralFeature feature);

	EObjectUIHint getEObjectUIHint(EObject eObject);
}
