/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.historybrowserview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;

/**
 * . This is the LabelProvider for versions table on HistroyBrowser's browser
 * tab.
 * 
 * @author Hodaie
 */
public class HistoryTableLabelProvider extends AdapterFactoryLabelProvider {

	private static final int REVISION_COLUMN = 0;
	private static final int TAG_COLUMN = 1;
	private static final int DATE_COLUMN = 2;
	private static final int AUTHOR_COLUMN = 3;
	private static final int LOGMSG_COLUMN = 4;

	/**
	 * . Constructor
	 */
	public HistoryTableLabelProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public String getColumnText(Object object, int columnIndex) {
		if (object instanceof HistoryInfo) {
			HistoryInfo historyInfo = (HistoryInfo) object;
			switch (columnIndex) {
			case REVISION_COLUMN:
				return Integer.toString(historyInfo.getPrimerySpec().getIdentifier());
			case TAG_COLUMN:
				String tags = "";
				for (TagVersionSpec tag : historyInfo.getTagSpecs()) {
					tags += tag.getName() + " ";
				}
				return tags;
			case DATE_COLUMN:
				return historyInfo.getLogMessage().getDate().toString();
			case AUTHOR_COLUMN:
				return historyInfo.getLogMessage().getAuthor();
			case LOGMSG_COLUMN:
				return historyInfo.getLogMessage().getMessage();
			default:
				return "";
			}
		} else {
			return super.getColumnText(object, columnIndex);

		}
	}

}
