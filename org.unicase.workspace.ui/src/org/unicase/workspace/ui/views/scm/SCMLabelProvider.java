/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.scm;

import java.text.SimpleDateFormat;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.graphics.Image;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.ModelElement;

/**
 * Label provider for the scm views.
 * 
 * @author Shterev
 * 
 */
public class SCMLabelProvider extends ColumnLabelProvider {
	
	

	private AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
		if (element instanceof TreeNode) {
			Object value = ((TreeNode) element).getValue();
			if (value instanceof HistoryInfo) {
				HistoryInfo historyInfo = (HistoryInfo) value;
				return "Version "
						+ historyInfo.getPrimerySpec().getIdentifier() + " ["
						+ historyInfo.getLogMessage().getAuthor() + " @ "
						+ dateFormat.format(historyInfo.getLogMessage().getClientDate()) + "] "
						+ historyInfo.getLogMessage().getMessage();
			}else if(value instanceof AbstractOperation){
				return ((AbstractOperation)value).getDescription();
			}else if(value instanceof ModelElement){
				return ((ModelElement)value).getName();
			}else if(value instanceof EObject){
				return ((EObject)value).eClass().getName();
			}
			return value.toString();
		}
		return super.getText(element);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		
		if (element instanceof TreeNode) {
			Object value = ((TreeNode) element).getValue();
			return adapterFactoryLabelProvider.getImage(value);
		}
		
		return super.getImage(element);
	}
}
