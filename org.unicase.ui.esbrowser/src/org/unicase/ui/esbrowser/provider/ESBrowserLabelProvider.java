/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.esbrowser.provider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.ui.esbrowser.Activator;
import org.unicase.workspace.ServerInfo;

/**
 * Label provider for the ESBrowser TreeViewer.
 * @author shterev
 *
 */
public class ESBrowserLabelProvider extends StyledCellLabelProvider implements IStyledLabelProvider{
	
	/**
	 * {@inheritDoc}
	 */
	//AS: Check, this method is never called!
	public Image getImage(Object element) {
		if (element instanceof ServerInfo){
			return Activator.getImageDescriptor("icons/ServerInfo.gif").createImage();
		}else if (element instanceof ProjectInfo){
			return Activator.getImageDescriptor("icons/ProjectInfo.gif").createImage();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("deprecation")
	public void update(ViewerCell cell) {
		Object element= cell.getElement();
		if(element instanceof ServerInfo){
			ServerInfo serverInfo = (ServerInfo) element;
			StyledString styledString= new StyledString(serverInfo.getName());
			String url = serverInfo.getUrl();
			styledString.append(" ["+url+"]", StyledString.DECORATIONS_STYLER);
			
			cell.setText(styledString.toString());
			cell.setStyleRanges(styledString.getStyleRanges());
			
			cell.setImage(Activator.getImageDescriptor("icons/ServerInfo.gif").createImage());
		} else if(element instanceof ProjectInfo){
			ProjectInfo projectInfo = (ProjectInfo) element;
			StyledString styledString= new StyledString(projectInfo.getName());
			cell.setText(styledString.toString());
			cell.setStyleRanges(styledString.getStyleRanges());
			
			cell.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_PROJECT));
		}
		super.update(cell);
	}

	/**
	 * {@inheritDoc}
	 */
	public StyledString getStyledText(Object element) {
		StyledString ret = new StyledString();
		return ret;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

}
