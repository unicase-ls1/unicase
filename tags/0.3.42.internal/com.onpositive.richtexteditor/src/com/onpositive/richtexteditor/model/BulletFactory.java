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

package com.onpositive.richtexteditor.model;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.widgets.Display;

/**
 * Factory for getting and controlling instances of line bullets for StyledText
 * @author 32kda
 * Made in USSR
 */
public class BulletFactory
{
	protected static HashMap<Integer,Bullet> listBullets = new HashMap<Integer,Bullet>();
	protected static StyleRange bulletStyle;
	
	/**
	 * Means no list at spec. line
	 */
	public static final int NONE_LIST_CONST = -1;
	/**
	 * Means bulleted list at spec. line
	 */
	public static final int BULLETED_LIST_CONST = 0;
	
	static 
	{
		bulletStyle = new StyleRange();
		bulletStyle.font=Display.getCurrent().getSystemFont();
		bulletStyle.length=1;
		bulletStyle.start=0;
		bulletStyle.metrics=new GlyphMetrics(10,10,10);			
		listBullets.put(BULLETED_LIST_CONST,new Bullet(bulletStyle));		
	}
	
	
	/**
	 * @return instance of bullet for bulleted list
	 */
	public static Bullet getNewBulletedListBulletInstance()
	{
		return new Bullet(bulletStyle);
	}
	
	
	/**
	 * @return bullet for new numbered list
	 */
	public static Bullet getNewNumberedListBulletInstance()
	{
		Bullet bullet = new Bullet(ST.BULLET_NUMBER | ST.BULLET_TEXT, bulletStyle);
		try
		{
			Field declaredField = Bullet.class
					.getDeclaredField("linesIndices");
			declaredField.setAccessible(true);
			declaredField.set(bullet, new int[] { -1 });
			declaredField = Bullet.class.getDeclaredField("count");
			declaredField.setAccessible(true);
			declaredField.set(bullet, Integer.valueOf(1));
		} catch (Exception e)
		{
		}
		bullet.text = ".";
		return bullet;
	}
	
	/**
	 * Returns bullet for some numbered list, determined by num,
	 * We need this for correct numbered lists loading from html
	 * @param num characterize, which list we read and process now. 
	 * e.g. list 1 may have 5 points with 2 unnumbered between them,
	 * and we should correctly display such list
	 * @return Bullet for list with specified index
	 */
	public static Bullet getBulletForNum(int num)
	{
		if (num == NONE_LIST_CONST) return null;
		if (!listBullets.containsKey(num)) //Если для такого числа ещё не  было, создадим новый
			listBullets.put(num, getNewNumberedListBulletInstance());
		return listBullets.get(num);
	}
}
