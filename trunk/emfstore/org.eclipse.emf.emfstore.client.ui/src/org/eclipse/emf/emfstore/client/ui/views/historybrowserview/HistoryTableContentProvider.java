/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.historybrowserview;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;

/**
 * . This is the content provider for versions table on HistroyBrowser's browser
 * tab.
 * 
 * @author Hodaie
 */
public class HistoryTableContentProvider extends AdapterFactoryContentProvider {

	/**
	 * . Constructor
	 */
	public HistoryTableContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

	/**
	 * . {@inheritDoc} The input to table is a list of versions
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object[] getElements(Object object) {
		List<HistoryInfo> historyInfo = (List<HistoryInfo>) object;
		return historyInfo.toArray(new Object[historyInfo.size()]);

	}

}
