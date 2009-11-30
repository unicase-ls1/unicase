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

package com.onpositive.richtexteditor.actions;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.RGB;

import com.onpositive.richtexteditor.model.LayerManager;

/**
 * Action for selecting text foreground color
 * @author kor
 *
 */
public class ForeGroundColorAction extends ColorAction{

	/**
	 * Main constructor
	 * @param manager {@link LayerManager} instance
	 */
	public ForeGroundColorAction(LayerManager manager) 
	{
		super(manager);
		setText("Foreground color");
	}
	
	protected void createImage(Color s, GC gc) 
	{		
		gc.setBackground(s);
		gc.fillRectangle(0, 8, 16, 4);				
	}
	
	protected RGB getDefaultColor() 
	{
		return new RGB(1, 1, 1);
	}
	
	/**
	 * Main method for setting color
	 * @param r color'sRGB
	 */
	public void setIntervalColor(RGB r)
	{
		manager.setSelectedIntervalForegroundColor(r);
	}

}
