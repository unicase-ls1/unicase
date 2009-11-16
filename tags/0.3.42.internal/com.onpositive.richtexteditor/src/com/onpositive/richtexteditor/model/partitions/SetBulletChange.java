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

import com.onpositive.richtexteditor.model.LayerManager;

/**
 * @author kor
 * Change Bullet command
 */
public class SetBulletChange extends Change{

	private Object bullet;
	private int line;
	private int count;
	
	/**
	 * Basic constructor
	 * @param line first line 
	 * @param count line count
	 * @param bullet Bullet to set
	 */
	public SetBulletChange(int line, int count, Object bullet) {
		super();
		this.bullet = bullet;
		this.count = count;
		this.line = line;
	}
	
	protected int defineSumAlignStyle(ILineAttributeModel editor,int startLineNum, int endLineNum) {
		int align = editor.getLineAlign(startLineNum);		
		return align;		
	}

	
	protected void apply(PartitionDelta delta) {
		int firstLineNum=line;
		int lastLineNum=line+count;
		final ILineAttributeModel lineAttributeModel = delta.getStorage().getLineAttributeModel();
		int defineSumAlignStyle = defineSumAlignStyle(lineAttributeModel,firstLineNum, lastLineNum);
		if (defineSumAlignStyle != LayerManager.LEFT_ALIGN
				&& defineSumAlignStyle != LayerManager.FIT_ALIGN)
		{
			new SetAlignChange(line,count,LayerManager.LEFT_ALIGN).apply(delta);			
		}		
		final Object[]bullets=new Object[count];
		for (int a=line;a<line+count;a++){
			bullets[a-line]=lineAttributeModel.getBullet(a);
		}
		lineAttributeModel.setLineBullet(line, count, null);
		lineAttributeModel.setLineBullet(line, count, bullet);
		delta.getUndoChange().add(new Change(){

			
			protected void apply(PartitionDelta delta) {
				lineAttributeModel.setLineBullet(line, count, null);
				for (int a=0;a<bullets.length;a++){
					lineAttributeModel.setLineBullet(a+line, 0, bullets[a]);
				}
				delta.getUndoChange().add(SetBulletChange.this);
			}			
		});
	}

}
