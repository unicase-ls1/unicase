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

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

import com.onpositive.richtexteditor.model.BasePartitionLayer;
import com.onpositive.richtexteditor.model.IPartition;
import com.onpositive.richtexteditor.model.LayerEvent;
import com.onpositive.richtexteditor.model.LayerManager;
import com.onpositive.richtexteditor.model.resources.ImageManager;

/**
 * @author 32kda Made in USSR
 * Encapsulates image containing partition
 */

public class ImagePartition extends ObjectPartition {
	protected Image image;
	protected String imagePath;
	protected boolean loadSheduled;
	

	/**
	 * Basic constructor
	 * @param layer Layer where partition'll be situated
	 * @param offset offset of part. 
	 * @param length length of part.Now - always 1.
	 * @param image Image object associated with the partition
	 * @param imageFileName Image file name associated with the partition
	 */
	public ImagePartition(BasePartitionLayer layer, int offset, int length,
			Image image, String imageFileName) {
		super(layer, offset, length);
		this.image = image;
		this.imagePath = imageFileName;
	}

	/**
	 * Basic constructor
	 * @param layer Layer where partition'll be situated
	 * @param offset offset of part. 
	 * @param length length of part.Now - always 1.
	 * @param image Image object associated with the partition
	 */
	public ImagePartition(BasePartitionLayer layer, int offset, int length,
			Image image) {
		super(layer, offset, length);
		this.image = image;
	}

	/**
	 * @return Image object associated with the partition
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image Image object associated with the partition
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/** (non-Javadoc)
	 * @see com.onpositive.richtexteditor.model.partitions.ObjectPartition#getObject()
	 */
	public Object getObject() {
		return image;
	}

	/** (non-Javadoc)
	 * @see com.onpositive.richtexteditor.model.partitions.ObjectPartition#setObject(java.lang.Object)
	 */
	public void setObject(Object object) {
		this.image = (Image) object;
	}

	/**
	 * Returns partition style-matching style range for it's displaying
	 * @param manager LayerManager responsible for partition handling
	 * @return new StyleRange
	 */
	public StyleRange getStyleRange(final LayerManager manager) {

		if (!loadSheduled && image == null) {
			loadSheduled = true;
			ImageManager imageCache = manager.getImageManager();
			image=imageCache.getImage(imagePath, new Observer() {

				public void update(Observable o, final Object arg) {
					Display display = Display.getDefault();
					display.syncExec(new Runnable() {

						public void run() {
							image=(Image) arg;
							if (ImagePartition.this.getPosition()!=-1) {
								ArrayList<IPartition> changedPartitions = new ArrayList<IPartition>();
								changedPartitions.add(ImagePartition.this);
								manager.layerChanged(new LayerEvent(layer,
										changedPartitions));
							}
						}

					});
				}

			});
		}
		StyleRange style = new StyleRange();
		style.start = getOffset();
		style.length = 1;
		Rectangle rect = image!=null?image.getBounds():new Rectangle(0,0,20,20);
		style.metrics = new GlyphMetrics(rect.height, 0, rect.width);
		return style;
	}

	
	/**
	 * @param manager LayerManager
	 * @return always null
	 */
	public Color getColor(LayerManager manager)
	{
		return null;
	}
	
	/**
	 * @param manager LayerManager
	 * @return always null
	 */
	public Color getBgColor(LayerManager manager)
	{
		return null;
	}
	
	/**
	 * @param partition2 part. to compare
	 * @return always false
	 */
	public boolean equalsByStyle(BasePartition partition2) {
		return false;
	}

	/**
	 * @return image file name
	 */
	public String getImageFileName() {
		return imagePath;
	}

	/**
	 * @param imageFileName image file name
	 */
	public void setImageFileName(String imageFileName) {
		this.imagePath = imageFileName;
	}

}
