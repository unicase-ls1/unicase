/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.views.changescomposite;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;

/**
 * This is the content provider for TreeViewer on ChangesTreeComposite.
 * 
 * @author Hodaie
 * @author Shterev
 * 
 */
public class ChangesTreeContentProvider extends AdapterFactoryContentProvider
		implements IContentProvider {

	/**
	 * Identifier for the operation context.
	 */
	public static final int DETAILED = 1; 

	/**
	 * Identifier for the ME context.
	 */
	public static final int COMPACT = 2;

	private int context; 
	
	/**
	 * Constructor.
	 * @param context The context the viewer should be built upon. Allowed values are {@link #COMPACT} and {@link #DETAILED}.  
	 */
	public ChangesTreeContentProvider(int context) {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		this.context = context;

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object[] getElements(Object object) {
		List<ChangePackage> packages = (List<ChangePackage>) object;
		return packages.toArray(new Object[packages.size()]);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof ChangePackage && context==DETAILED){
			ChangePackage cPackage = (ChangePackage)object;
			return cPackage.getOperations().toArray();
		}
		if (object instanceof CompositeOperation) {
			return ((CompositeOperation) object)
					.getSubOperations().toArray();
		}
//TODO AS: implement
//		if (object instanceof ChangePackage && context==COMPACT){
//			ChangePackage cPackage = (ChangePackage)object;
//			ChangePackageVisualizationHelper helper = new ChangePackageVisualizationHelper(Arrays.asList(cPackage), null);
//			return helper.getAllModelElements(cPackage).toArray();
//		}
		return super.getChildren(object);

	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object object) {
		if (object instanceof CompositeOperation
				|| object instanceof ChangePackage) {
			return true;
		} else {
			return super.hasChildren(object);
		}
	}

}
