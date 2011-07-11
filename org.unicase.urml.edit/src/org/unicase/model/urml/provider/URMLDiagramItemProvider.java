/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.unicase.model.ModelPackage;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.provider.MEDiagramItemProvider;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlFactory;
import org.unicase.model.urml.danger.DangerFactory;
import org.unicase.model.urml.feature.FeatureFactory;
import org.unicase.model.urml.goal.GoalFactory;
import org.unicase.model.urml.requirement.RequirementFactory;
import org.unicase.model.urml.service.ServiceFactory;
import org.unicase.model.urml.usecase.UsecaseFactory;

/**
 * This is the item provider adapter for a {@link org.unicase.model.urml.URMLDiagram} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class URMLDiagramItemProvider extends MEDiagramItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URMLDiagramItemProvider(AdapterFactory adapterFactory) {
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
	 * This returns URMLDiagram.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/URMLDiagram"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((URMLDiagram) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_URMLDiagram_type")
				: getString("_UI_URMLDiagram_type") + " " + label;
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
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				UrmlFactory.eINSTANCE.createStakeholder()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				UrmlFactory.eINSTANCE.createURMLDiagram()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				GoalFactory.eINSTANCE.createGoal()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				GoalFactory.eINSTANCE.createGoalReference()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RequirementFactory.eINSTANCE.createFunctionalRequirement()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				RequirementFactory.eINSTANCE.createNonFunctionalRequirement()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				UsecaseFactory.eINSTANCE.createApplicationDomainUseCase()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				UsecaseFactory.eINSTANCE.createSolutionDomainUseCase()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				UsecaseFactory.eINSTANCE.createActor()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				ServiceFactory.eINSTANCE.createService()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				DangerFactory.eINSTANCE.createDanger()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				DangerFactory.eINSTANCE.createProceduralMitigation()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				FeatureFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				FeatureFactory.eINSTANCE.createVariationPoint()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				FeatureFactory.eINSTANCE.createVariationPointInstance()));

		newChildDescriptors.add(createChildParameter(
				DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS,
				FeatureFactory.eINSTANCE.createProduct()));
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

		boolean qualify = childFeature == ModelPackage.Literals.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES
				|| childFeature == DiagramPackage.Literals.ME_DIAGRAM__NEW_ELEMENTS
				|| childFeature == ModelPackage.Literals.UNICASE_MODEL_ELEMENT__COMMENTS;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] {
					getTypeText(childObject), getFeatureText(childFeature),
					getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return UrmlEditPlugin.INSTANCE;
	}

}
