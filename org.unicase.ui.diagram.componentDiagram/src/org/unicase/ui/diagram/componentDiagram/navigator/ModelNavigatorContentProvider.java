/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.componentDiagram.navigator;

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

/**
 * @generated
 */
public class ModelNavigatorContentProvider implements ICommonContentProvider {

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
	public ModelNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
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
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
					public void dispose() {
					}

					public boolean handleResourceChanged(final Resource resource) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}

					public boolean handleResourceDeleted(Resource resource) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
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
		for (Iterator it = myEditingDomain.getResourceSet().getResources()
				.iterator(); it.hasNext();) {
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
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			Collection result = new ArrayList();
			result
					.addAll(createNavigatorItems(
							selectViewsByType(
									resource.getContents(),
									org.unicase.ui.diagram.componentDiagram.edit.parts.MEDiagramEditPart.MODEL_ID),
							file, false));
			return result.toArray();
		}

		if (parentElement instanceof org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorItem) parentElement;
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
		switch (org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {

		case org.unicase.ui.diagram.componentDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup links = new org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup(
					org.unicase.ui.diagram.componentDiagram.part.Messages.NavigatorGroupName_ComponentDiagram_88_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(
					Collections.singleton(view),
					org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
							.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentServiceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
							.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(view),
					org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
							.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentOfferedServicesEditPart.VISUAL_ID));
			links
					.addChildren(createNavigatorItems(connectedViews, links,
							false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(view),
					org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
							.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentConsumedServicesEditPart.VISUAL_ID));
			links
					.addChildren(createNavigatorItems(connectedViews, links,
							false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentServiceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup incominglinks = new org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup(
					org.unicase.ui.diagram.componentDiagram.part.Messages.NavigatorGroupName_ComponentService_2001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
							.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentOfferedServicesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
							.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentConsumedServicesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup outgoinglinks = new org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup(
					org.unicase.ui.diagram.componentDiagram.part.Messages.NavigatorGroupName_Component_2002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
							.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentOfferedServicesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
							.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentConsumedServicesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentOfferedServicesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup target = new org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup(
					org.unicase.ui.diagram.componentDiagram.part.Messages.NavigatorGroupName_ComponentOfferedServices_4001_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup source = new org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup(
					org.unicase.ui.diagram.componentDiagram.part.Messages.NavigatorGroupName_ComponentOfferedServices_4001_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(
					Collections.singleton(view),
					org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
							.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentServiceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(
					Collections.singleton(view),
					org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
							.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentConsumedServicesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup target = new org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup(
					org.unicase.ui.diagram.componentDiagram.part.Messages.NavigatorGroupName_ComponentConsumedServices_4002_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup source = new org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorGroup(
					org.unicase.ui.diagram.componentDiagram.part.Messages.NavigatorGroupName_ComponentConsumedServices_4002_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(
					Collections.singleton(view),
					org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
							.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentServiceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(
					Collections.singleton(view),
					org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
							.getType(org.unicase.ui.diagram.componentDiagram.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
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
			if (type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
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
			if (type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
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
		return org.unicase.ui.diagram.componentDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(org.unicase.ui.diagram.componentDiagram.part.ModelVisualIDRegistry
						.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent,
			boolean isLeafs) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			result
					.add(new org.unicase.ui.diagram.componentDiagram.navigator.ModelNavigatorItem(
							(View) it.next(), parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof org.unicase.ui.diagram.componentDiagram.navigator.ModelAbstractNavigatorItem) {
			org.unicase.ui.diagram.componentDiagram.navigator.ModelAbstractNavigatorItem abstractNavigatorItem = (org.unicase.ui.diagram.componentDiagram.navigator.ModelAbstractNavigatorItem) element;
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
