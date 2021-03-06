package org.unicase.ui.diagram.urml.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureConstrainingNonFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureDetailingFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureExcludedFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureRequiredFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AbstractFeatureSubFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ActorEditPart;
import org.unicase.ui.diagram.urml.edit.parts.AssetTriggeredDangersEditPart;
import org.unicase.ui.diagram.urml.edit.parts.DangerEditPart;
import org.unicase.ui.diagram.urml.edit.parts.DangerHarmedAssetsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FeatureEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FunctionalRequirementEditPart;
import org.unicase.ui.diagram.urml.edit.parts.FunctionalRequirementSubFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalRealizedFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReference2EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReference3EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReference4EditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalReferenceEditPart;
import org.unicase.ui.diagram.urml.edit.parts.GoalSubGoalsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.MitigationMitigatedDangersEditPart;
import org.unicase.ui.diagram.urml.edit.parts.NonFunctionalRequirementEditPart;
import org.unicase.ui.diagram.urml.edit.parts.NonFunctionalRequirementSubNonFunctionalRequirementsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProceduralMitigationEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProductEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProductFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ProductVariationPointInstancesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.RequirementImplementingServicesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ServiceEditPart;
import org.unicase.ui.diagram.urml.edit.parts.ServiceSubServicesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.StakeholderEditPart;
import org.unicase.ui.diagram.urml.edit.parts.StakeholderGoalsEditPart;
import org.unicase.ui.diagram.urml.edit.parts.URMLDiagramEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointInstanceEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointInstanceSelectedFeaturesEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointInstanceVariationPointEditPart;
import org.unicase.ui.diagram.urml.edit.parts.VariationPointOptionalSubFeaturesEditPart;
import org.unicase.ui.diagram.urml.part.Messages;
import org.unicase.ui.diagram.urml.part.UrmlVisualIDRegistry;

/**
 * @generated
 */
public class UrmlNavigatorContentProvider implements ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	public UrmlNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					nextResource.unload();
				}
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					nextResource.unload();
				}
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					nextResource.unload();
				}
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}
		});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
			Resource resource = (Resource) it.next();
			resource.unload();
		}
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			Collection result = new ArrayList();
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), URMLDiagramEditPart.MODEL_ID),
				file, false));
			return result.toArray();
		}

		if (parentElement instanceof UrmlNavigatorGroup) {
			UrmlNavigatorGroup group = (UrmlNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof UrmlNavigatorItem) {
			UrmlNavigatorItem navigatorItem = (UrmlNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (UrmlVisualIDRegistry.getVisualID(view)) {

		case URMLDiagramEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup links = new UrmlNavigatorGroup(Messages.NavigatorGroupName_URMLDiagram_1000_links,
				"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(StakeholderEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FunctionalRequirementEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ServiceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(NonFunctionalRequirementEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(DangerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ActorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ProceduralMitigationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointInstanceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ProductEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(StakeholderGoalsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureSubFeaturesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureRequiredFeaturesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalRealizedFeaturesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalSubGoalsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalReferenceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalReference2EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalReference3EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalReference4EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(RequirementImplementingServicesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(NonFunctionalRequirementSubNonFunctionalRequirementsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FunctionalRequirementSubFunctionalRequirementsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(MitigationMitigatedDangersEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(DangerHarmedAssetsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AssetTriggeredDangersEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ServiceSubServicesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointOptionalSubFeaturesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointInstanceVariationPointEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ProductVariationPointInstancesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ProductFeaturesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case StakeholderEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup outgoinglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_Stakeholder_2002_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(StakeholderGoalsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case GoalEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup incominglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_Goal_2001_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup outgoinglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_Goal_2001_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(StakeholderGoalsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalRealizedFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalSubGoalsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalSubGoalsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalReferenceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalReferenceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalReference2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalReference2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalReference3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalReference3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalReference4EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalReference4EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FunctionalRequirementEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup incominglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_FunctionalRequirement_2006_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup outgoinglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_FunctionalRequirement_2006_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(RequirementImplementingServicesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FunctionalRequirementSubFunctionalRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FunctionalRequirementSubFunctionalRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(MitigationMitigatedDangersEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FeatureEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup incominglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_Feature_2012_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup outgoinglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_Feature_2012_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureSubFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureSubFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureRequiredFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureRequiredFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalRealizedFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointOptionalSubFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ProductFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ServiceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup incominglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_Service_2007_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup outgoinglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_Service_2007_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(RequirementImplementingServicesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(DangerHarmedAssetsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AssetTriggeredDangersEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ServiceSubServicesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ServiceSubServicesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case NonFunctionalRequirementEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup incominglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_NonFunctionalRequirement_2008_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup outgoinglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_NonFunctionalRequirement_2008_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(RequirementImplementingServicesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(NonFunctionalRequirementSubNonFunctionalRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(NonFunctionalRequirementSubNonFunctionalRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(MitigationMitigatedDangersEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case DangerEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup incominglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_Danger_2009_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup outgoinglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_Danger_2009_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(MitigationMitigatedDangersEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(DangerHarmedAssetsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AssetTriggeredDangersEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ActorEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup incominglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_Actor_2010_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup outgoinglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_Actor_2010_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(DangerHarmedAssetsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AssetTriggeredDangersEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ProceduralMitigationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup outgoinglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_ProceduralMitigation_2011_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(MitigationMitigatedDangersEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case VariationPointEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup incominglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_VariationPoint_2013_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup outgoinglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_VariationPoint_2013_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureSubFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureSubFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureRequiredFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureRequiredFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalRealizedFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointOptionalSubFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointOptionalSubFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointInstanceVariationPointEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case VariationPointInstanceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup outgoinglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_VariationPointInstance_2014_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup incominglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_VariationPointInstance_2014_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointInstanceVariationPointEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ProductVariationPointInstancesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ProductEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup outgoinglinks = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_Product_2015_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ProductVariationPointInstancesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ProductFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case StakeholderGoalsEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_StakeholderGoals_4008_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_StakeholderGoals_4008_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(StakeholderEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case AbstractFeatureSubFeaturesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_AbstractFeatureSubFeatures_4034_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_AbstractFeatureSubFeatures_4034_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case AbstractFeatureDetailingFunctionalRequirementsEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_AbstractFeatureDetailingFunctionalRequirements_4035_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_AbstractFeatureDetailingFunctionalRequirements_4035_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FunctionalRequirementEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case AbstractFeatureConstrainingNonFunctionalRequirementsEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_AbstractFeatureConstrainingNonFunctionalRequirements_4036_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_AbstractFeatureConstrainingNonFunctionalRequirements_4036_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(NonFunctionalRequirementEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case AbstractFeatureRequiredFeaturesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_AbstractFeatureRequiredFeatures_4045_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_AbstractFeatureRequiredFeatures_4045_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case AbstractFeatureExcludedFeaturesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_AbstractFeatureExcludedFeatures_4038_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_AbstractFeatureExcludedFeatures_4038_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case GoalRealizedFeaturesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_GoalRealizedFeatures_4004_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_GoalRealizedFeatures_4004_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case GoalSubGoalsEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(Messages.NavigatorGroupName_GoalSubGoals_4018_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(Messages.NavigatorGroupName_GoalSubGoals_4018_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case GoalReferenceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(Messages.NavigatorGroupName_GoalReference_4016_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(Messages.NavigatorGroupName_GoalReference_4016_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case GoalReference2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(Messages.NavigatorGroupName_GoalReference_4023_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(Messages.NavigatorGroupName_GoalReference_4023_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case GoalReference3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(Messages.NavigatorGroupName_GoalReference_4024_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(Messages.NavigatorGroupName_GoalReference_4024_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case GoalReference4EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(Messages.NavigatorGroupName_GoalReference_4025_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(Messages.NavigatorGroupName_GoalReference_4025_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(GoalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case RequirementImplementingServicesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_RequirementImplementingServices_4005_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_RequirementImplementingServices_4005_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ServiceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FunctionalRequirementEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(NonFunctionalRequirementEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case NonFunctionalRequirementSubNonFunctionalRequirementsEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_NonFunctionalRequirementSubNonFunctionalRequirements_4043_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_NonFunctionalRequirementSubNonFunctionalRequirements_4043_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(NonFunctionalRequirementEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(NonFunctionalRequirementEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FunctionalRequirementSubFunctionalRequirementsEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_FunctionalRequirementSubFunctionalRequirements_4044_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_FunctionalRequirementSubFunctionalRequirements_4044_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FunctionalRequirementEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FunctionalRequirementEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case MitigationMitigatedDangersEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_MitigationMitigatedDangers_4012_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_MitigationMitigatedDangers_4012_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(DangerEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FunctionalRequirementEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(NonFunctionalRequirementEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ProceduralMitigationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case DangerHarmedAssetsEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_DangerHarmedAssets_4013_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_DangerHarmedAssets_4013_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ServiceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ActorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(DangerEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case AssetTriggeredDangersEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_AssetTriggeredDangers_4017_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_AssetTriggeredDangers_4017_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(DangerEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ServiceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ActorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ServiceSubServicesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_ServiceSubServices_4022_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_ServiceSubServices_4022_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ServiceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ServiceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case VariationPointOptionalSubFeaturesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_VariationPointOptionalSubFeatures_4046_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_VariationPointOptionalSubFeatures_4046_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case VariationPointInstanceVariationPointEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_VariationPointInstanceVariationPoint_4033_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_VariationPointInstanceVariationPoint_4033_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointInstanceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case VariationPointInstanceSelectedFeaturesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_VariationPointInstanceSelectedFeatures_4040_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_VariationPointInstanceSelectedFeatures_4040_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointInstanceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ProductVariationPointInstancesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_ProductVariationPointInstances_4032_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(
				Messages.NavigatorGroupName_ProductVariationPointInstances_4032_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(VariationPointInstanceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ProductEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ProductFeaturesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			UrmlNavigatorGroup target = new UrmlNavigatorGroup(Messages.NavigatorGroupName_ProductFeatures_4047_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UrmlNavigatorGroup source = new UrmlNavigatorGroup(Messages.NavigatorGroupName_ProductFeatures_4047_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), UrmlVisualIDRegistry
				.getType(ProductEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksTargetByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getOutgoingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(Collection diagrams, String type) {
		Collection result = new ArrayList();
		for (Iterator it = diagrams.iterator(); it.hasNext();) {
			Diagram nextDiagram = (Diagram) it.next();
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection selectViewsByType(Collection views, String type) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return URMLDiagramEditPart.MODEL_ID.equals(UrmlVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent, boolean isLeafs) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			result.add(new UrmlNavigatorItem((View) it.next(), parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof UrmlAbstractNavigatorItem) {
			UrmlAbstractNavigatorItem abstractNavigatorItem = (UrmlAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
