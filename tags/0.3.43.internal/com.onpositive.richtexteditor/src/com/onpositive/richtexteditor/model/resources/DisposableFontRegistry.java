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
package com.onpositive.richtexteditor.model.resources;

import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.swt.widgets.Display;


/**
 * @author 32kda
 * JFace FontRegistry child, which can be disposed "by hands"
 */
public class DisposableFontRegistry extends FontRegistry
{

	/**
	 * Basic constructor
	 * @param display the Display
	 */
	public DisposableFontRegistry(Display display)
	{
		super(display);
	}

	/**
	 * "By hands" contents dispose
	 */
	public void dispose()
	{
		clearCaches();
	}
}
