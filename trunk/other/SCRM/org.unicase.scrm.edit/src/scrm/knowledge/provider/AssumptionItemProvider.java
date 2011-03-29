/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import scrm.knowledge.Assumption;
import scrm.knowledge.KnowledgePackage;

import scrm.provider.SCRMModelElementItemProvider;
import scrm.provider.ScrmEditPlugin;

import scrm.requirements.RequirementsFactory;

import scrm.requirements.dataProcessing.DataProcessingFactory;

/**
 * This is the item provider adapter for a {@link scrm.knowledge.Assumption} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AssumptionItemProvider
	extends SCRMModelElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssumptionItemProvider(AdapterFactory adapterFactory) {
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
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Assumption.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Assumption"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Assumption)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Assumption_type") :
			getString("_UI_Assumption_type") + " " + label;
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

		switch (notification.getFeatureID(Assumption.class)) {
			case KnowledgePackage.ASSUMPTION__REQUIREMENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createHardware()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createUserInterface()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createSoftwareInterface()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createProcess()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createPerformance()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createDataFlow()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 RequirementsFactory.eINSTANCE.createDataDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createInputDataReading()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createDataHandling()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createResultsOutput()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createErrorHandling()));

		newChildDescriptors.add
			(createChildParameter
				(KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS,
				 DataProcessingFactory.eINSTANCE.createStatusMonitoring()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ScrmEditPlugin.INSTANCE;
	}

}
