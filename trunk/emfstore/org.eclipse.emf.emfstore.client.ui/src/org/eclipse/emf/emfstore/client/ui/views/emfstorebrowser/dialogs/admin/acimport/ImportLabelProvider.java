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
package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.acimport;

import java.util.ArrayList;

import org.eclipse.emf.emfstore.client.ui.Activator;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

/**
 * @author deser
 */
public class ImportLabelProvider implements ILabelProvider {

	private ImportSource source;

	private Image userImage;
	private Image groupImage;

	private ArrayList<ILabelProviderListener> listeners;

	/**
	 * Constructs a FileTreeLabelProvider.
	 * 
	 * @param controller
	 *            the controller which handles the import
	 */
	public ImportLabelProvider(ImportController controller) {
		this.setSource(controller.getImportSource());
		this.listeners = new ArrayList<ILabelProviderListener>();

		this.userImage = Activator.getImageDescriptor("icons/user.png").createImage();
		this.groupImage = Activator.getImageDescriptor("icons/Group.gif").createImage();
	}

	/**
	 * Gets the image to display for a node in the tree.
	 * 
	 * @param arg0
	 *            the node
	 * @return Image
	 */
	public Image getImage(Object arg0) {
		ACOrgUnit orgUnit = ((ImportItemWrapper) arg0).getOrgUnit();
		if (orgUnit instanceof ACUser) {
			return userImage;
		}
		if (orgUnit instanceof ACGroup) {
			return groupImage;
		}
		return null;
	}

	/**
	 * Gets the text to display for a node in the tree.
	 * 
	 * @param arg0
	 *            the node
	 * @return String
	 */
	public String getText(Object arg0) {
		return ((ImportItemWrapper) arg0).getOrgUnit().getName();
	}

	/**
	 * Called when this LabelProvider is being disposed.
	 */
	public void dispose() {
		groupImage.dispose();
		userImage.dispose();
	}

	/**
	 * Returns whether changes to the specified property on the specified
	 * element would affect the label for the element.
	 * 
	 * @param arg0
	 *            the element
	 * @param arg1
	 *            the property
	 * @return boolean
	 */
	public boolean isLabelProperty(Object arg0, String arg1) {
		return false;
	}

	/**
	 * Adds a listener to this label provider.
	 * 
	 * @param arg0
	 *            the listener
	 */
	public void addListener(ILabelProviderListener arg0) {
		this.listeners.add(arg0);
	}

	/**
	 * Removes the listener.
	 * 
	 * @param arg0
	 *            the listener to remove
	 */
	public void removeListener(ILabelProviderListener arg0) {
		this.listeners.remove(arg0);
	}

	/**
	 * @param source
	 *            the import source
	 */
	public void setSource(ImportSource source) {
		this.source = source;
	}

	/**
	 * @return the import source
	 */
	public ImportSource getSource() {
		return source;
	}

}
