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
 * LexEvent impl for attribute values
 */
public class AttrValueLexEvent extends LexEvent
{
	
	/**
	 * Type of attr
	 */
	public int type;
	
	
	/**
	 * Basic constructor
	 * @param l attr value str
	 * @param type attr type
	 */
	public AttrValueLexEvent(String l, int type)
	{
		super(l);
		this.type = type;
	}
	
	
	public String toString()
	{
		return "value = " + l;
	}
}
