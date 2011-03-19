/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.provider;

import org.eclipse.emf.emfstore.client.ServerInfo;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.workspace.ui.Activator;

/**
 * Label provider for the ESBrowser TreeViewer.
 * 
 * @author shterev
 */
public class ESBrowserLabelProvider extends ColumnLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object obj) {
		if (obj instanceof TreeNode) {
			Object element = ((TreeNode) obj).getValue();
			if (element instanceof ServerInfo) {
				ServerInfo serverInfo = (ServerInfo) element;
				StringBuilder builder = new StringBuilder();
				builder.append(serverInfo.getUrl());
				builder.append(" [");
				builder.append(serverInfo.getName());
				builder.append("]");
				return builder.toString();
			} else if (element instanceof ProjectInfo) {
				ProjectInfo projectInfo = (ProjectInfo) element;
				return projectInfo.getName();
			}
		}
		return super.getText(obj);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object obj) {
		if (obj instanceof TreeNode) {
			Object element = ((TreeNode) obj).getValue();
			if (element instanceof ServerInfo) {
				return Activator.getImageDescriptor("icons/ServerInfo.gif").createImage();
			} else if (element instanceof ProjectInfo) {
				return Activator.getImageDescriptor("icons/prj_obj.gif").createImage();
			}
		}
		return super.getImage(obj);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(ViewerCell cell) {
		Object obj = cell.getElement();
		if (obj instanceof TreeNode) {
			Object element = ((TreeNode) obj).getValue();
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
		}
		super.update(cell);
	}

}
