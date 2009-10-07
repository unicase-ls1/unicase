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
 * Change Align command
 */
public class SetAlignChange extends Change{

	private int align;
	private int line;
	private int count;
	
	/**
	 * Basic constructor
	 * @param align Align constant to set
	 * @param count line count
	 * @param line first line
	 */
	public SetAlignChange(int align, int count, int line) {
		super();
		this.align = align;
		this.count = count;
		this.line = line;
	}

	
	protected void apply(PartitionDelta delta) {
		final ILineAttributeModel lineAttributeModel = delta.getStorage().getLineAttributeModel();
		final int[]aligns=new int[count+1];
		for (int a=line;a<=line+count;a++){
			aligns[a-line]=lineAttributeModel.getLineAlign(a);
		}
		lineAttributeModel.setLineAlign(line, count, align);
		delta.getUndoChange().add(new Change(){

			
			protected void apply(PartitionDelta delta) {
				for (int a=0;a<aligns.length;a++){
					lineAttributeModel.setLineAlign(a+line, 0, aligns[a]);
				}
				delta.getUndoChange().add(SetAlignChange.this);
			}			
		});
	}

}
