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
package com.onpositive.richtexteditor.viewer;

import org.eclipse.jface.preference.IPreferenceStore;

import com.onpositive.richtexteditor.model.LayerManager;

/**
 * @author kor
 * Configuration for RichTextViewer
 */
public class RichTextViewerControlConfiguration {

	private boolean createToolbar=true;
	private IPreferenceStore preferenceStore;
	

	/**
	 * @return create toolbar or not
	 */
	public boolean isCreateToolbar() {
		return createToolbar;
	}

	/**
	 * @param createToolbar create toolbar or not
	 */
	public void setCreateToolbar(boolean createToolbar) {
		this.createToolbar = createToolbar;
	}
	
	/**
	 * @return configuration store
	 */
	public IPreferenceStore getPreferenceStore() {
		return preferenceStore;
	}

	/**
	 * @param preferenceStore configuration store
	 */
	public void setPreferenceStore(IPreferenceStore preferenceStore) {
		this.preferenceStore = preferenceStore;
	}
	
	protected void configureLayerManager(LayerManager manager){
		
	}
}
