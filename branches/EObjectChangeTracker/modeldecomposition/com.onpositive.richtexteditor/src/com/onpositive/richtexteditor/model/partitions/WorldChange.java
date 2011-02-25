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

import java.util.List;

import com.onpositive.richtexteditor.model.ISimpleRichTextModel;

/**
 * @author kor
 * Multiple aligns and bullets change
 */
public class WorldChange extends Change{

	protected List<BasePartition>newPartitions;
	protected int[] aligns;
	protected Object[] bullets;

	/**
	 * Basic constructor
	 * @param clonePartitions Cloned partitions list
	 * @param aligns list of aligns to set
	 * @param bullets list of bullets to set
	 */
	public WorldChange(List<BasePartition> clonePartitions, int[] aligns, Object[] bullets) {
		newPartitions=clonePartitions;
		this.aligns=aligns;
		this.bullets=bullets;
	}

	

	/**
	 * Basic constructor
	 * @param clonePartitions Cloned partitions list
	 * @param oldAligns list of old aligns
	 * @param oldBullets list of old bullets
	 */
	public WorldChange(List<BasePartition> clonePartitions,
			List<Integer> oldAligns, List<Object> oldBullets) {
		newPartitions=clonePartitions;
		this.aligns=new int[oldAligns.size()];
		for (int a=0;a<aligns.length;a++){
			aligns[a]=oldAligns.get(a);
		}
		bullets=oldBullets.toArray();
	}



	/**
	 * @param model
	 */
	public WorldChange(ISimpleRichTextModel model)
	{
		newPartitions=model.getPartitions();
		this.aligns=new int[model.getLineCount()];
		bullets=new Object[model.getLineCount()];
		for (int a=0;a<aligns.length;a++){
			aligns[a]=model.getAlign(a);
			bullets[a]=model.getBullet(a);
		}
		
	}



	
	protected void apply(PartitionDelta delta) {
		PartitionStorage storage = delta.getStorage();
		final List<BasePartition> clonePartitions = storage.clonePartitions();
		ILineAttributeModel lineAttributeModel = delta.getStorage().getLineAttributeModel();
		int lineCount = lineAttributeModel.lineCount();
		int[] aligns=new int[lineCount];
		Object[] bullets=new Object[lineCount];
		for (int a=0;a<lineCount;a++){
			aligns[a]=lineAttributeModel.getLineAlign(a);
			bullets[a]=lineAttributeModel.getBullet(a);
		}		
		storage.setPartitions(newPartitions);
		for (int a=0;a<this.aligns.length;a++){
			lineAttributeModel.setLineAlign(a, 0,this.aligns[a]);
			Object bullet = this.bullets[a];
			if (bullet!=null){
			lineAttributeModel.setLineBullet(a, 0,bullet);
			}
		}
		delta.getUndoChange().add(new WorldChange(clonePartitions,aligns,bullets));
	}
    	
}
