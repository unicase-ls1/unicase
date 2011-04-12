/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import scrm.SCRMDiagram;
import scrm.ScrmFactory;
import scrm.ScrmPackage;

import scrm.knowledge.KnowledgeFactory;

import scrm.requirements.RequirementsFactory;
import scrm.dataProcessing.DataProcessingFactory;

/**
 * This is the item provider adapter for a {@link scrm.SCRMDiagram} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SCRMDiagramItemProvider extends SCRMModelElementItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCRMDiagramItemProvider(AdapterFactory adapterFactory) {
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

			addElementsPropertyDescriptor(object);
			addDiagramLayoutPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Elements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_SCRMDiagram_elements_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_SCRMDiagram_elements_feature",
						"_UI_SCRMDiagram_type"),
				ScrmPackage.Literals.SCRM_DIAGRAM__ELEMENTS, true, false, true,
				null, null, null));
	}

	/**
	 * This adds a property descriptor for the Diagram Layout feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDiagramLayoutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_SCRMDiagram_diagramLayout_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_SCRMDiagram_diagramLayout_feature",
						"_UI_SCRMDiagram_type"),
				ScrmPackage.Literals.SCRM_DIAGRAM__DIAGRAM_LAYOUT, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS);
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
	 * This returns SCRMDiagram.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/SCRMDiagram"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
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

		switch (notification.getFeatureID(SCRMDiagram.class)) {
		case ScrmPackage.SCRM_DIAGRAM__DIAGRAM_LAYOUT:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
			return;
		case ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM:
		case ScrmPackage.SCRM_DIAGRAM__NEW_ELEMENTS:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
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
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				ScrmFactory.eINSTANCE.createSCRMDiagram()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				KnowledgeFactory.eINSTANCE.createKnowledgeSpace()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				KnowledgeFactory.eINSTANCE.createScientificProblem()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				KnowledgeFactory.eINSTANCE.createMathematicalModel()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				KnowledgeFactory.eINSTANCE.createNumericalMethod()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				KnowledgeFactory.eINSTANCE.createAssumption()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				RequirementsFactory.eINSTANCE.createRequirement()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				RequirementsFactory.eINSTANCE.createRequirementSpace()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				RequirementsFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				RequirementsFactory.eINSTANCE.createHardware()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				RequirementsFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				RequirementsFactory.eINSTANCE.createUserInterface()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				RequirementsFactory.eINSTANCE.createSoftwareInterface()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				RequirementsFactory.eINSTANCE.createProcess()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				RequirementsFactory.eINSTANCE.createPerformance()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				RequirementsFactory.eINSTANCE.createDataFlow()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				RequirementsFactory.eINSTANCE.createDataDefinition()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				DataProcessingFactory.eINSTANCE.createInputDataReading()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				DataProcessingFactory.eINSTANCE.createDataHandling()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				DataProcessingFactory.eINSTANCE.createResultsOutput()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				DataProcessingFactory.eINSTANCE.createErrorHandling()));

		newChildDescriptors.add(createChildParameter(
				ScrmPackage.Literals.SCRM_DIAGRAM__NEW_ELEMENTS,
				DataProcessingFactory.eINSTANCE.createStatusMonitoring()));
	}

}
