/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import scrm.ScrmPackage;
import scrm.provider.SCRMModelElementItemProvider;
import scrm.provider.ScrmEditPlugin;
import scrm.requirements.RequirementsFactory;
import scrm.requirements.RequirementsPackage;

import scrm.requirements.dataProcess.DataProcessFactory;
import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.DataProcessSpace;

/**
 * This is the item provider adapter for a {@link scrm.requirements.dataProcess.DataProcessSpace} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DataProcessSpaceItemProvider extends SCRMModelElementItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessSpaceItemProvider(AdapterFactory adapterFactory) {
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

			addRepresentingDiagramPropertyDescriptor(object);
			addContainingRequirementSpacePropertyDescriptor(object);
			addRefinementsPropertyDescriptor(object);
			addRefinedRequirementPropertyDescriptor(object);
			addSpecifiedFeaturePropertyDescriptor(object);
			addDefiningDataPropertyDescriptor(object);
			addRealizedMethodPropertyDescriptor(object);
			addDataFlowPropertyDescriptor(object);
			addPredecessorPropertyDescriptor(object);
			addSuccessorPropertyDescriptor(object);
			addContainedDataProcessStepsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Contained Data Process Steps feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainedDataProcessStepsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_DataProcessSpace_containedDataProcessSteps_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_DataProcessSpace_containedDataProcessSteps_feature",
								"_UI_DataProcessSpace_type"),
						DataProcessPackage.Literals.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
						true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Representing Diagram feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRepresentingDiagramPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_SCRMSpace_representingDiagram_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_SCRMSpace_representingDiagram_feature",
						"_UI_SCRMSpace_type"),
				ScrmPackage.Literals.SCRM_SPACE__REPRESENTING_DIAGRAM, false,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Containing Requirement Space feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainingRequirementSpacePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_IRequirement_containingRequirementSpace_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_IRequirement_containingRequirementSpace_feature",
								"_UI_IRequirement_type"),
						RequirementsPackage.Literals.IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE,
						true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Refinements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefinementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Requirement_refinements_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Requirement_refinements_feature",
						"_UI_Requirement_type"),
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS, true,
				false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Refined Requirement feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefinedRequirementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Requirement_refinedRequirement_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Requirement_refinedRequirement_feature",
						"_UI_Requirement_type"),
				RequirementsPackage.Literals.REQUIREMENT__REFINED_REQUIREMENT,
				true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Specified Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpecifiedFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Requirement_specifiedFeature_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Requirement_specifiedFeature_feature",
						"_UI_Requirement_type"),
				RequirementsPackage.Literals.REQUIREMENT__SPECIFIED_FEATURE,
				true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Defining Data feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefiningDataPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Requirement_definingData_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Requirement_definingData_feature",
						"_UI_Requirement_type"),
				RequirementsPackage.Literals.REQUIREMENT__DEFINING_DATA, true,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Realized Method feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRealizedMethodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Requirement_realizedMethod_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Requirement_realizedMethod_feature",
						"_UI_Requirement_type"),
				RequirementsPackage.Literals.REQUIREMENT__REALIZED_METHOD,
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Data Flow feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDataFlowPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Process_dataFlow_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Process_dataFlow_feature", "_UI_Process_type"),
				DataProcessPackage.Literals.PROCESS__DATA_FLOW, true, false,
				true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Predecessor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPredecessorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Process_predecessor_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Process_predecessor_feature", "_UI_Process_type"),
				DataProcessPackage.Literals.PROCESS__PREDECESSOR, true, false,
				true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Successor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuccessorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Process_successor_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_Process_successor_feature", "_UI_Process_type"),
				DataProcessPackage.Literals.PROCESS__SUCCESSOR, true, false,
				true, null, null, null));
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
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS);
			childrenFeatures
					.add(DataProcessPackage.Literals.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS);
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
	 * This returns DataProcessSpace.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/DataProcessSpace"));
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

		switch (notification.getFeatureID(DataProcessSpace.class)) {
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINEMENTS:
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS:
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
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createProcess()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createInputDataReading()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createDataHandling()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createResultsOutput()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createErrorHandling()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createStatusMonitoring()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				DataProcessFactory.eINSTANCE.createDataProcessSpace()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				RequirementsFactory.eINSTANCE.createRequirement()));

		newChildDescriptors.add(createChildParameter(
				RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS,
				RequirementsFactory.eINSTANCE.createPerformance()));

		newChildDescriptors
				.add(createChildParameter(
						DataProcessPackage.Literals.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
						DataProcessFactory.eINSTANCE.createProcess()));

		newChildDescriptors
				.add(createChildParameter(
						DataProcessPackage.Literals.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
						DataProcessFactory.eINSTANCE.createInputDataReading()));

		newChildDescriptors
				.add(createChildParameter(
						DataProcessPackage.Literals.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
						DataProcessFactory.eINSTANCE.createDataHandling()));

		newChildDescriptors
				.add(createChildParameter(
						DataProcessPackage.Literals.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
						DataProcessFactory.eINSTANCE.createResultsOutput()));

		newChildDescriptors
				.add(createChildParameter(
						DataProcessPackage.Literals.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
						DataProcessFactory.eINSTANCE.createErrorHandling()));

		newChildDescriptors
				.add(createChildParameter(
						DataProcessPackage.Literals.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
						DataProcessFactory.eINSTANCE.createStatusMonitoring()));

		newChildDescriptors
				.add(createChildParameter(
						DataProcessPackage.Literals.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
						DataProcessFactory.eINSTANCE.createDataProcessSpace()));
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

		boolean qualify = childFeature == RequirementsPackage.Literals.REQUIREMENT__REFINEMENTS
				|| childFeature == DataProcessPackage.Literals.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS;

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
		return ScrmEditPlugin.INSTANCE;
	}

}
