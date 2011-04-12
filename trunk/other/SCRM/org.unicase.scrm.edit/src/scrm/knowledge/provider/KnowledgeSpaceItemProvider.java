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

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import scrm.knowledge.KnowledgeFactory;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.KnowledgeSpace;

import scrm.provider.SCRMModelElementItemProvider;
import scrm.provider.ScrmEditPlugin;

/**
 * This is the item provider adapter for a {@link scrm.knowledge.KnowledgeSpace} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class KnowledgeSpaceItemProvider extends SCRMModelElementItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KnowledgeSpaceItemProvider(AdapterFactory adapterFactory) {
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
			addContainedScientificProblemPropertyDescriptor(object);
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
	 * This adds a property descriptor for the Contained Scientific Problem feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainedScientificProblemPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_KnowledgeSpace_containedScientificProblem_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_KnowledgeSpace_containedScientificProblem_feature",
								"_UI_KnowledgeSpace_type"),
						KnowledgePackage.Literals.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM,
						true, false, false, null, null, null));
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
					.add(KnowledgePackage.Literals.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM);
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
	 * This returns KnowledgeSpace.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/KnowledgeSpace"));
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

		switch (notification.getFeatureID(KnowledgeSpace.class)) {
		case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM:
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

		newChildDescriptors
				.add(createChildParameter(
						KnowledgePackage.Literals.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM,
						KnowledgeFactory.eINSTANCE.createKnowledgeSpace()));

		newChildDescriptors
				.add(createChildParameter(
						KnowledgePackage.Literals.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM,
						KnowledgeFactory.eINSTANCE.createScientificProblem()));

		newChildDescriptors
				.add(createChildParameter(
						KnowledgePackage.Literals.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM,
						KnowledgeFactory.eINSTANCE.createMathematicalModel()));

		newChildDescriptors
				.add(createChildParameter(
						KnowledgePackage.Literals.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM,
						KnowledgeFactory.eINSTANCE.createNumericalMethod()));

		newChildDescriptors
				.add(createChildParameter(
						KnowledgePackage.Literals.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM,
						KnowledgeFactory.eINSTANCE.createAssumption()));
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
