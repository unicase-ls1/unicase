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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * @author kor
 * Class for color managing
 */
public class ColorManager {

	private Display display;
	private HashMap<RGB, Color> colors = new HashMap<RGB, Color>();

	private ArrayList<RGB> ra = new ArrayList<RGB>();
	private ArrayList<String> names = new ArrayList<String>();
	
	//TODO ADD MORE COLORS
	private void createDefaultColors() {
		ra.add(new RGB(0, 0, 0));
		names.add("Black");
		ra.add(new RGB(255, 0, 0));
		names.add("Red");
		ra.add(new RGB(0, 255, 0));
		names.add("Green");
		ra.add(new RGB(0, 0, 255));
		names.add("Blue");
		ra.add(new RGB(127, 127, 127));
		names.add("Grey");
		ra.add(new RGB(180, 180, 180));
		names.add("Light Grey");
		ra.add(new RGB(255,255,255));
		names.add("White");
	}
	
	/**
	 * Add new color
	 * @param name Name for color
	 * @param rgb RGB of color
	 */
	public void addColor(String name,RGB rgb)
	{
		this.names.add(name);
		this.ra.add(rgb);
	}
	
	/**
	 * Basic constructor
	 * @param display  the device on which to allocate the color
	 */
	public ColorManager(Display display) {
		this.display = display;
		createDefaultColors();
	}

	/**
	 * Get color for specified RGB
	 * @param rgb RGB
	 * @return Color
	 */
	public Color getColor(RGB rgb) {
		Color color = colors.get(rgb);
		if (color == null) {
			color = new Color(display, rgb);
			colors.put(rgb, color);
		}
		return color;
	}
	
	/**
	 * Dispose all colors created
	 */
	public void dispose(){
		for (Color c:colors.values()){
			c.dispose();
		}
	}

	/**
	 * @return list of all colors
	 */
	public List<RGB> getColors() {
		return ra;
	}

	/**
	 * Get color name for specified index
	 * @param n index
	 * @return color name
	 */
	public String getColorName(int n) {
		return names.get(n);
	}
}
