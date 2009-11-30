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

import java.util.HashMap;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;

import com.onpositive.richtexteditor.model.LayerManager;

/**
 * @author kor
 * Parent action for all coloring actions
 */
public abstract class ColorAction extends Action implements IMenuCreator {

	private HashMap<RGB, Color> colors = new HashMap<RGB, Color>();
	private HashMap<RGB, Image> images = new HashMap<RGB, Image>();

	private Color color;

	
	protected LayerManager manager;

	/**
	 * Basic constructor
	 * @param manager {@link LayerManager} instance
	 */
	public ColorAction(LayerManager manager) {
		super("", Action.AS_DROP_DOWN_MENU);		
		setMenuCreator(this);
		setColor(getDefaultColor());
		this.manager = manager;
	}

	

	protected RGB getDefaultColor() {
		return new RGB(255, 255, 255);
	}

	
	/**	 
	 * @param clr color to set
	 */
	public void setColor(RGB clr) 
	{
		if (clr == null) clr = getDefaultColor(); 
			
		processColor(clr);
		Image image2 = images.get(clr);
		setImageDescriptor(ImageDescriptor.createFromImage(image2));
		this.color = colors.get(clr);
	}

	private void processColor(final RGB clr) {
		Color color2 = colors.get(clr);
		if (color2 == null) {
			RGB clr1 = clr;
			if (clr.blue == 0 && clr.green == 0 && clr.red == 0) {
				// small hack
				clr1 = new RGB(1, 1, 1);
			}
			Color s = new Color(Display.getCurrent(), clr1);
			colors.put(clr, s);
			ImageData da = new ImageData(16, 16, 32, new PaletteData(1, 1, 1));
			da.transparentPixel = 0;
			Image im = new Image(Display.getCurrent(), da);
			GC gc = new GC(im);
			createImage(s, gc);
			gc.dispose();
			images.put(clr, im);
		}
	}

	protected void createImage(Color s, GC gc) {
		gc.setBackground(s);
		gc.fillRectangle(0, 4, 16, 10);
	}
	

	/**
	 * Returns currently selected color
	 * @return selected color
	 */
	public Color getColor() {
		return color;
	}

	
	/**
	 * Disposes all used resources
	 */
	public void dispose() {
		for (Color c : colors.values()) {
			c.dispose();
		}
		for (Image c : images.values()) {
			c.dispose();
		}
	}
	
	/**
	 * Opens the dialog
	 */
	public void run()
	{
		ColorDialog colorDialog = new ColorDialog(Display.getCurrent().getActiveShell());
		colorDialog.setText("Select color");
		RGB open = colorDialog.open();
		if (open!=null)
		{
			setIntervalColor(open);
			setColor(open);
		}
	}

	
	/**
	 * Creates a menu for this action
	 * @param parent parent control for this menu
	 * @return created menu
	 */
	public Menu getMenu(Control parent) {
		MenuManager ma = new MenuManager();
		int n = 0;
		for (final RGB r : manager.getColorRegistry().getColors()) {

			processColor(r);
			Image image2 = images.get(r);
			Action a =	new Action() {
				public void run() 
				{
					setIntervalColor(r);					
					setColor(r);
				} };			
			a.setImageDescriptor(ImageDescriptor.createFromImage(image2));
			if (color != null) {
				RGB rgb = color.getRGB();
				if (rgb.equals(r)) {
					a.setChecked(true);
				}
			}
			String text = manager.getColorRegistry().getColorName(n);
			a.setText(text);
			ma.add(a);
			n++;
		}
		Menu createContextMenu = ma.createContextMenu(parent);
		return createContextMenu;
	}
	
	/**
	 * Abstract method for setting a color of selected interval
	 * @param r color for setting
	 */
	public abstract void setIntervalColor(RGB r);


	/**
	 * Not supported 
	 * @param parent parent menu
	 * @return menu
	 */
	public Menu getMenu(Menu parent) 
	{
		throw new UnsupportedOperationException();
	}
}
