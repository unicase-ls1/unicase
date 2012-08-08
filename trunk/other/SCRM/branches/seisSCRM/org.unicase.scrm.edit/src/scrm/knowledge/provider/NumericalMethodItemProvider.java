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

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.NumericalMethod;

import scrm.provider.SCRMModelElementItemProvider;
import scrm.provider.ScrmEditPlugin;

/**
 * This is the item provider adapter for a {@link scrm.knowledge.NumericalMethod} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NumericalMethodItemProvider extends SCRMModelElementItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethodItemProvider(AdapterFactory adapterFactory) {
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

			addContainingKnowledgeSpacePropertyDescriptor(object);
			addSolvedProblemPropertyDescriptor(object);
			addDependenciesPropertyDescriptor(object);
			addRealizingRequirementPropertyDescriptor(object);
			addUsingMathematicalModelPropertyDescriptor(object);
			addPerformancePropertyDescriptor(object);
			addAlgorithmPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Containing Knowledge Space feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainingKnowledgeSpacePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_ScientificKnowledge_containingKnowledgeSpace_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_ScientificKnowledge_containingKnowledgeSpace_feature",
								"_UI_ScientificKnowledge_type"),
						KnowledgePackage.Literals.SCIENTIFIC_KNOWLEDGE__CONTAINING_KNOWLEDGE_SPACE,
						true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Solved Problem feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSolvedProblemPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_NumericalMethod_solvedProblem_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_NumericalMethod_solvedProblem_feature",
						"_UI_NumericalMethod_type"),
				KnowledgePackage.Literals.NUMERICAL_METHOD__SOLVED_PROBLEM,
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Dependencies feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDependenciesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_NumericalMethod_dependencies_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_NumericalMethod_dependencies_feature",
						"_UI_NumericalMethod_type"),
				KnowledgePackage.Literals.NUMERICAL_METHOD__DEPENDENCIES, true,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Realizing Requirement feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRealizingRequirementPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_NumericalMethod_realizingRequirement_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_NumericalMethod_realizingRequirement_feature",
								"_UI_NumericalMethod_type"),
						KnowledgePackage.Literals.NUMERICAL_METHOD__REALIZING_REQUIREMENT,
						true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Using Mathematical Model feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsingMathematicalModelPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_NumericalMethod_usingMathematicalModel_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_NumericalMethod_usingMathematicalModel_feature",
								"_UI_NumericalMethod_type"),
						KnowledgePackage.Literals.NUMERICAL_METHOD__USING_MATHEMATICAL_MODEL,
						true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Performance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPerformancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_NumericalMethod_performance_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_NumericalMethod_performance_feature",
						"_UI_NumericalMethod_type"),
				KnowledgePackage.Literals.NUMERICAL_METHOD__PERFORMANCE, true,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Algorithm feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAlgorithmPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_NumericalMethod_algorithm_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_NumericalMethod_algorithm_feature",
						"_UI_NumericalMethod_type"),
				KnowledgePackage.Literals.NUMERICAL_METHOD__ALGORITHM, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This returns NumericalMethod.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/NumericalMethod"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT: return name attribute without EClass-name
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

		switch (notification.getFeatureID(NumericalMethod.class)) {
		case KnowledgePackage.NUMERICAL_METHOD__ALGORITHM:
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
