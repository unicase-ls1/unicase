/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.provider.ServerEditPlugin;
import org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationGroup;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.provider.CompositeOperationItemProvider;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticCompositeOperation;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticCompositeOperation} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SemanticCompositeOperationItemProvider extends CompositeOperationItemProvider implements
	IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
	IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticCompositeOperationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SemanticCompositeOperation)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_SemanticCompositeOperation_type") :
			getString("_UI_SemanticCompositeOperation_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ServerEditPlugin.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.provider.CompositeOperationItemProvider#getChildren(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<?> getChildren(Object object) {
		if (object instanceof SemanticCompositeOperation) {
			SemanticCompositeOperation operation = (SemanticCompositeOperation) object;
			ArrayList<Object> result = new ArrayList<Object>();

			OperationsFactory factory = OperationsFactory.eINSTANCE;
			for (EStructuralFeature feature : operation.eClass().getEStructuralFeatures()) {
				if (feature instanceof EReference) {
					EReference reference = (EReference) feature;

					ModelElementGroup referenceGroup = factory.createModelElementGroup();
					String key = "_UI_" + reference.getEContainingClass().getName() + "_" + reference.getName()
						+ "_feature";
					referenceGroup.setName(getString(key));
					if (reference.isMany()) {
						List<ModelElementId> value = (List<ModelElementId>) operation.eGet(reference);
						referenceGroup.getModelElements().addAll(value);
					} else {
						ModelElementId value = (ModelElementId) operation.eGet(reference);
						referenceGroup.getModelElements().add(value);
					}
					result.add(referenceGroup);
				}
			}

			OperationGroup detailsGroup = factory.createOperationGroup();
			detailsGroup.setName("Sub Operations");
			detailsGroup.getOperations().addAll(operation.getSubOperations());
			result.add(detailsGroup);

			return result;
		}
		return super.getChildren(object);
	}
}
