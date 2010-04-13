/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;

/**
 * This is the item provider adapter for a {@link org.unicase.metamodel.Project} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ProjectItemProvider extends RootElementItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS);
			childrenFeatures.add(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENT_WRAPPERS);
			childrenFeatures.add(MetamodelPackage.Literals.PROJECT__NEW_MODEL_ELEMENT_WRAPPERS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
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

		switch (notification.getFeatureID(Project.class)) {
		case MetamodelPackage.PROJECT__MODEL_ELEMENTS:
		case MetamodelPackage.PROJECT__MODEL_ELEMENT_WRAPPERS:
		case MetamodelPackage.PROJECT__NEW_MODEL_ELEMENT_WRAPPERS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
	 * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			MetamodelFactory.eINSTANCE.createProject()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			MetamodelFactory.eINSTANCE.createModelElementId()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			MetamodelFactory.eINSTANCE.createModelVersion()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
			MetamodelFactory.eINSTANCE.createModelElementEObjectWrapper()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__MODEL_ELEMENT_WRAPPERS,
			MetamodelFactory.eINSTANCE.createModelElementEObjectWrapper()));

		newChildDescriptors.add(createChildParameter(MetamodelPackage.Literals.PROJECT__NEW_MODEL_ELEMENT_WRAPPERS,
			MetamodelFactory.eINSTANCE.createModelElementEObjectWrapper()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS
			|| childFeature == MetamodelPackage.Literals.PROJECT__MODEL_ELEMENT_WRAPPERS
			|| childFeature == MetamodelPackage.Literals.PROJECT__NEW_MODEL_ELEMENT_WRAPPERS;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] { getTypeText(childObject),
				getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return MetamodelEditPlugin.INSTANCE;
	}

	/**
	 * This returns Project.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT {@inheritDoc}
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/project.png"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> .<!-- end-user-doc -->
	 * 
	 * @generated NOT {@inheritDoc}
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof Project) {
			Project project = (Project) object;
			boolean isInProjectSpace = project.eContainer() != null
				&& project.eContainer().eClass().getName().equals("ProjectSpace");
			if (isInProjectSpace) {
				return "Orphans";
			}
		}
		return "Project";
	}

	@Override
	public Collection<?> getChildren(Object object) {
		if (object instanceof Project) {
			final Project project = (Project) object;
			final Collection<ModelElement> ret = new ArrayList<ModelElement>();
			EObject econtainer = null;
			EList<ModelElement> allmes = project.getAllModelElements();
			// FIXME: ugly hack to avoid dependency to workspace
			boolean isInProjectSpace = project.eContainer() != null
				&& project.eContainer().eClass().getName().equals("ProjectSpace");
			// FIXME: ugly hack to avoid dependency to model
			for (ModelElement temp : allmes) {
				econtainer = temp.eContainer();
				if ((!isInProjectSpace && (econtainer instanceof Project) && (temp.eClass().getName()
					.equals("CompositeSection")))
					|| (isInProjectSpace && (econtainer instanceof Project) && !(temp.eClass().getName()
						.equals("CompositeSection")))) {
					ret.add(temp);
				}
			}
			return ret;
		} else {
			return super.getChildren(object);
		}
	}

}
