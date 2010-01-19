/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.provider;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.ui.Activator;

/**
 * Label provider for the ESBrowser TreeViewer.
 * 
 * @author shterev
 */
public class ESBrowserLabelProvider extends StyledCellLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		if (element instanceof ServerInfo) {
			ServerInfo serverInfo = (ServerInfo) element;
			StyledString styledString = new StyledString(serverInfo.getName());
			String url = serverInfo.getUrl();
			styledString.append(" [" + url + "]", StyledString.DECORATIONS_STYLER);

			cell.setText(styledString.toString());
			cell.setStyleRanges(styledString.getStyleRanges());

			cell.setImage(Activator.getImageDescriptor("icons/ServerInfo.gif").createImage());
		} else if (element instanceof ProjectInfo) {
			ProjectInfo projectInfo = (ProjectInfo) element;
			StyledString styledString = new StyledString(projectInfo.getName());
			cell.setText(styledString.toString());
			cell.setStyleRanges(styledString.getStyleRanges());

			cell.setImage(Activator.getImageDescriptor("icons/prj_obj.gif").createImage());
		}
		super.update(cell);
	}

}
