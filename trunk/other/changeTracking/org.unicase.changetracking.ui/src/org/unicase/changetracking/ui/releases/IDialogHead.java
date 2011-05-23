/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.releases;

/**
 * A dialog head displays a message and an icon. The message type determines the
 * icon to be displayed.
 * 
 * @author jfinis
 * 
 */
public interface IDialogHead {
	/**
	 * Sets the message to be displayed.
	 * 
	 * @param newMessage message
	 */
	void setMessage(String newMessage);

	/**
	 * Sets the message and the message type to be displayed.
	 * 
	 * Use constants from class org.eclipse.jface.dialogs.IMessageProvider for
	 * the message type
	 * 
	 * @param newMessage message
	 * @param newType message type
	 */
	void setMessage(String newMessage, int newType);
}
