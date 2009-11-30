/*******************************************************************************
 * Copyright (c) 2007, 2008 OnPositive Technologies (http://www.onpositive.com/) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     OnPositive Technologies (http://www.onpositive.com/) - initial API and implementation
 *******************************************************************************/

package com.onpositive.richtexteditor.dialogs;

import org.eclipse.osgi.util.NLS;

/**
 * @author kor
 *
 */
public class Messages extends NLS
{

	private static final String BUNDLE_NAME = "com.onpositive.richtexteditor.dialogs.messages"; //$NON-NLS-1$
	/**
	 * 
	 */
	public static String HyperlinkDialog_Label;
	/**
	 * 
	 */
	public static String HyperlinkDialog_TITLE;
	/**
	 * 
	 */
	public static String HyperlinkDialog_URL;
	static
	{
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages()
	{
	}
}
