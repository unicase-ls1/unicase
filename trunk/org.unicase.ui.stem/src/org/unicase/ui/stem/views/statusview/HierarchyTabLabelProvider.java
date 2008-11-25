/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;


/**.
 * The LabelProvider for hierarchy tab.
 * This just takes care of background color. 
 * Elements that have state closed are shown green.
 * 
 * @author Hodaie
 *
 */
public class HierarchyTabLabelProvider extends AdapterFactoryLabelProvider
		implements IColorProvider {

	/**.
	 * Constructor
	 */
	public HierarchyTabLabelProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

}
