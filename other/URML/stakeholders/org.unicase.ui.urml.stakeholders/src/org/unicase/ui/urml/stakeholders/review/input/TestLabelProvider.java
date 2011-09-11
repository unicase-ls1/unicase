/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review.input;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.graphics.Image;

/**
 * Test labelprovider.
 * 
 * @author kterzieva
 * 
 */
public class TestLabelProvider implements ILabelProvider {
	
	//delegation for using the appropriate label provider for the different model elements
	
	private AdapterFactoryLabelProvider factoryLabel;
	
	/**
	 * The construct.
	 * @param factoryLabel the factory label provider
	 */
	public TestLabelProvider(AdapterFactoryLabelProvider factoryLabel){
		this.factoryLabel = factoryLabel;
	}

	@Override
	public Image getImage(Object element) {
		//one TreeNode has one urml element
		return factoryLabel.getImage(((TreeNode) element).getValue());
	}

	@Override
	public String getText(Object element) {
		return factoryLabel.getText(((TreeNode) element).getValue());
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		 factoryLabel.addListener(listener);
		
	}

	@Override
	public void dispose() {
		 factoryLabel.dispose();
		
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

}
