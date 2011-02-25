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

package com.onpositive.richtexteditor.io.html;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.graphics.Image;

import com.onpositive.richtexteditor.io.html_scaner.HTMLLexListener;
import com.onpositive.richtexteditor.io.html_scaner.Scanner;
import com.onpositive.richtexteditor.model.BulletFactory;
import com.onpositive.richtexteditor.model.BasePartitionLayer;
import com.onpositive.richtexteditor.model.ISimpleRichTextModel;
import com.onpositive.richtexteditor.model.LayerManager;
import com.onpositive.richtexteditor.model.partitions.BasePartition;
import com.onpositive.richtexteditor.model.partitions.ImagePartition;
import com.onpositive.richtexteditor.model.partitions.LinkPartition;
import com.onpositive.richtexteditor.model.resources.FontStyleManager;
import com.onpositive.richtexteditor.model.resources.ImageManager;


/**
 * @author kor
 *  Default implementation of IHTMLLoader
 */
public class DefaultHTMLLoader implements IHTMLLoader {

	private BasePartitionLayer layer;
	private FontStyleManager fontStyleManager;
	private ImageManager imageManager;
	private BasePartition linkPrototypePartition;
	private LayerManager currentManager;

	/**
	 * Basic constructor
	 * @param manager {@link LayerManager} instance
	 */
	public DefaultHTMLLoader(LayerManager manager) {
		this.layer=manager.getLayer();
		this.fontStyleManager=manager.getFontStyleManager();
		this.imageManager=manager.getImageManager();
		this.linkPrototypePartition=manager.getLinkPrototype();
	}
	
	
	/**
	 * Wraps parse process
	 * @param html String with html content to parse
	 * @return ISimpleRichTextModel
	 */
	public ISimpleRichTextModel parse(String html) {
		Scanner scanner = new Scanner();
		final HTMLLexListener listener = createLexingListener(scanner);
		scanner.addLexListener(listener);
		try {
			scanner.process(new StringReader(html), html.length());
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		final ArrayList<BasePartition> partitions = listener.getPartitions();
		setNewPartitionsFonts(partitions);
		final ArrayList<Integer> lineAligns = listener.getLineAligns();
		final ArrayList<Integer> lineBullets = listener.getLineBullets();
		ISimpleRichTextModel z = new ISimpleRichTextModel() {

			public int getAlign(int line) {
				return lineAligns.get(line).intValue();
			}

			public Object getBullet(int line) {
				int bulletNum = lineBullets.get(line);
				Bullet bullet = BulletFactory.getBulletForNum(bulletNum);
				return bullet;
			}

			public int getLineCount() {
				return lineAligns.size();
			}

			public List<BasePartition> getPartitions() {
				return partitions;
			}

			public String getText() {
				return listener.getText();
			}

		};
		return z;
	}

	private HTMLLexListener createLexingListener(Scanner scanner) {
		return new HTMLLexListener(layer,scanner);
	}

	protected void setNewPartitionsFonts(ArrayList<BasePartition> partitions) {
		for (Iterator<BasePartition> iterator = partitions.iterator(); iterator
				.hasNext();) {
			BasePartition basePartition = (BasePartition) iterator.next();
			if (!basePartition.getFontDataName().equals("")) {
				String innerName = fontStyleManager
						.getNameForStyleString(basePartition.getFontDataName());
				basePartition.setFontDataName(innerName);
			}
			if (basePartition instanceof LinkPartition)
				basePartition.applyAttributes(linkPrototypePartition);
			if (basePartition instanceof ImagePartition) {
				ImagePartition imagePartition = (ImagePartition) basePartition;
				if (imageManager.checkImage(imagePartition.getImageFileName()) == null) {
					Image image = ((ImagePartition) basePartition).getImage();
					if (image != null) {
						imageManager.registerImage(imagePartition
								.getImageFileName(), image);
					}
				}
			}
		}
	}

	/**
	 * Wraps parse process
	 * @param reader Contents reader
	 * @return ISimpleRichTextModel
	 * @throws IOException in case of reading error
	 */
	public ISimpleRichTextModel parse(Reader reader) throws IOException {
		StringBuilder bld=new StringBuilder();
		while (true){
			int read = reader.read();
			if(read!=-1){
				bld.append((char)read);
			}
			else{
				break;
			}
		}
		return parse(bld.toString());
	}

	/**
	 * Wraps parse process
	 * @param stream Contents input stream
	 * @return ISimpleRichTextModel
	 * @throws IOException in case of reading error
	 */
	public ISimpleRichTextModel parse(InputStream stream) throws IOException {
		return parse(new InputStreamReader(stream));
	}

	/**
	 * @return {@link LayerManager}, for which this loader was created
	 */
	public LayerManager getCurrentManager()
	{
		return currentManager;
	}

}
