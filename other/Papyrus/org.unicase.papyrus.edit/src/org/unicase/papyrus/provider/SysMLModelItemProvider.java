/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.papyrus.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.uml2.uml.edit.providers.ModelItemProvider;

import org.unicase.papyrus.PapyrusFactory;
import org.unicase.papyrus.PapyrusPackage;
import org.unicase.papyrus.SysMLModel;
import org.unicase.papyrus.UMLModel;

/**
 * This is the item provider adapter for a {@link org.unicase.papyrus.SysMLModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SysMLModelItemProvider extends ModelItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SysMLModelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * This returns SysMLModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/SysMLModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((SysMLModel) object).getName();
		return label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(SysMLModel.class)) {
		case PapyrusPackage.SYS_ML_MODEL__GMF_DIAGRAM:
		case PapyrusPackage.SYS_ML_MODEL__DIAGRAM_TYPE:
		case PapyrusPackage.SYS_ML_MODEL__DIAGRAM_LAYOUT:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				UMLPackage.Literals.PACKAGE__OWNED_TYPE,
				PapyrusFactory.eINSTANCE.createSysMLClass()));

		newChildDescriptors.add(createChildParameter(
				UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT,
				PapyrusFactory.eINSTANCE.createUMLModel()));

		newChildDescriptors.add(createChildParameter(
				UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT,
				PapyrusFactory.eINSTANCE.createSysMLModel()));

		newChildDescriptors.add(createChildParameter(
				UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT,
				PapyrusFactory.eINSTANCE.createSysMLClass()));

		newChildDescriptors.add(createChildParameter(
				UMLPackage.Literals.PACKAGE__NESTED_PACKAGE,
				PapyrusFactory.eINSTANCE.createUMLModel()));

		newChildDescriptors.add(createChildParameter(
				UMLPackage.Literals.PACKAGE__NESTED_PACKAGE,
				PapyrusFactory.eINSTANCE.createSysMLModel()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == UMLPackage.Literals.NAMED_ELEMENT__NAME_EXPRESSION
				|| childFeature == UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT
				|| childFeature == UMLPackage.Literals.NAMESPACE__OWNED_RULE
				|| childFeature == UMLPackage.Literals.PACKAGE__OWNED_TYPE
				|| childFeature == UMLPackage.Literals.PACKAGE__NESTED_PACKAGE;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] {
					getTypeText(childObject), getFeatureText(childFeature),
					getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PapyrusEditPlugin.INSTANCE;
	}

}
