/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.goal.provider;

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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.model.urml.goal.Goal;
import org.unicase.model.urml.goal.GoalFactory;
import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.model.urml.provider.UrmlEditPlugin;
import org.unicase.model.urml.provider.UrmlModelElementItemProvider;

/**
 * This is the item provider adapter for a {@link org.unicase.model.urml.goal.Goal} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class GoalItemProvider extends UrmlModelElementItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GoalItemProvider(AdapterFactory adapterFactory) {
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

			addSoftPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addStakeholdersPropertyDescriptor(object);
			addRealizedFeaturesPropertyDescriptor(object);
			addDetailingUseCasesPropertyDescriptor(object);
			addSubGoalsPropertyDescriptor(object);
			addInfluencingGoalsPropertyDescriptor(object);
			addInfluencedGoalsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Soft feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSoftPropertyDescriptor(Object object) {
		itemPropertyDescriptors
			.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_Goal_soft_feature"), getString(
					"_UI_PropertyDescriptor_description", "_UI_Goal_soft_feature", "_UI_Goal_type"),
				GoalPackage.Literals.GOAL__SOFT, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Type feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
			.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_Goal_type_feature"), getString(
					"_UI_PropertyDescriptor_description", "_UI_Goal_type_feature", "_UI_Goal_type"),
				GoalPackage.Literals.GOAL__TYPE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Stakeholders feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStakeholdersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_Goal_stakeholders_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_Goal_stakeholders_feature", "_UI_Goal_type"),
			GoalPackage.Literals.GOAL__STAKEHOLDERS, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Realized Features feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addRealizedFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_Goal_realizedFeatures_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_Goal_realizedFeatures_feature", "_UI_Goal_type"),
			GoalPackage.Literals.GOAL__REALIZED_FEATURES, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Detailing Use Cases feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addDetailingUseCasesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_Goal_detailingUseCases_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_Goal_detailingUseCases_feature", "_UI_Goal_type"),
			GoalPackage.Literals.GOAL__DETAILING_USE_CASES, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Sub Goals feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSubGoalsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_Goal_subGoals_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_Goal_subGoals_feature", "_UI_Goal_type"),
			GoalPackage.Literals.GOAL__SUB_GOALS, true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Influencing Goals feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addInfluencingGoalsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_Goal_influencingGoals_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_Goal_influencingGoals_feature", "_UI_Goal_type"),
			GoalPackage.Literals.GOAL__INFLUENCING_GOALS, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Influenced Goals feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addInfluencedGoalsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_Goal_influencedGoals_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_Goal_influencedGoals_feature", "_UI_Goal_type"),
			GoalPackage.Literals.GOAL__INFLUENCED_GOALS, true, false, true, null, null, null));
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
			childrenFeatures.add(GoalPackage.Literals.GOAL__SUB_GOALS);
			childrenFeatures.add(GoalPackage.Literals.GOAL__INFLUENCED_GOALS);
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
	 * This returns Goal.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Goal"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Goal) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Goal_type") : getString("_UI_Goal_type") + " "
			+ label;
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

		switch (notification.getFeatureID(Goal.class)) {
		case GoalPackage.GOAL__SOFT:
		case GoalPackage.GOAL__TYPE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case GoalPackage.GOAL__SUB_GOALS:
		case GoalPackage.GOAL__INFLUENCED_GOALS:
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

		newChildDescriptors.add(createChildParameter(GoalPackage.Literals.GOAL__SUB_GOALS, GoalFactory.eINSTANCE
			.createGoal()));

		newChildDescriptors.add(createChildParameter(GoalPackage.Literals.GOAL__INFLUENCED_GOALS, GoalFactory.eINSTANCE
			.createGoalReference()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return UrmlEditPlugin.INSTANCE;
	}

}
