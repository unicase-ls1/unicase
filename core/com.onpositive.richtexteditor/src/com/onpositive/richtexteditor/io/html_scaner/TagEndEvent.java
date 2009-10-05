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

package com.onpositive.richtexteditor.io.html_scaner;

import com.onpositive.richtexteditor.io.LexEvent;


/**
 * @author 32kda
 * Indicates, that we reached tag end symbol ( ">" )
 */
public class TagEndEvent extends LexEvent
{
	int type;
	boolean open;
	
	
	/**
	 * @return tag type constant
	 */
	public int getType()
	{
		return type;
	}

	
	/**
	 * @param type tag type constant to set
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	
	/**
	 * @return is this a open (&lt;x&gt;) or a close (&lt;/x&gt;) tag?  
	 */
	public boolean isOpen()
	{
		return open;
	}

	/**
	 * @param open is this a open (&lt;x&gt;) or a close (&lt;/x&gt;) tag?
	 */	
	public void setOpen(boolean open)
	{
		this.open = open;
	}

	
	/**
	 * Basic constructor
	 * @param type tag type constant to 
	 * @param open is this a open (&lt;x&gt;) or a close (&lt;/x&gt;) tag?
	 */
	public TagEndEvent(int type, boolean open)
	{
		this.type = type;
		this.open = open;
	}
}
