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

package com.onpositive.richtexteditor.model.partitions;

/**
 * @author kor
 * Encapsulates model, that contain line attributes like aligns and bullets. 
 */
public interface ILineAttributeModel 
{

	/**
	 * Sets selected interval align
	 * @param startLine first line
	 * @param count line count
	 * @param align Align constant to set
	 */
	public void    setLineAlign(int startLine,int count,int align);
	/**
	 * Gets line align
	 * @param line line index
	 * @return align of that line
	 */
	public int     getLineAlign(int line);
	/**
	 * Gets line bullet
	 * @param line line index
	 * @return line bullet
	 */
	public Object  getBullet(int line);
	/**
	 * Sets selected interval bullet
	 * @param startLine first line
	 * @param count line count
	 * @param bullet Bullet to set
	 */
	public void    setLineBullet(int startLine,int count,Object bullet);	
	/**
	 * @return line count
	 */
	public int     lineCount();
}
