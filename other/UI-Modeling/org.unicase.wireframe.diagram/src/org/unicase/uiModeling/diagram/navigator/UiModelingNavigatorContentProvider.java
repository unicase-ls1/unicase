/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

/**
 * @generated
 */
public class UiModelingNavigatorContentProvider implements ICommonContentProvider {

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
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public UiModelingNavigatorContentProvider() {
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
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				unloadAllResources();
				asyncRefresh();
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
		myViewer = null;
		unloadAllResources();
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
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet().getResources()) {
			nextResource.unload();
		}
	}

	/**
	 * @generated
	 */
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
		}
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
			ArrayList<org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem> result = new ArrayList<org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(
				selectViewsByType(topViews, org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.MODEL_ID), file,
				false));
			return result.toArray();
		}

		if (parentElement instanceof org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorGroup) {
			org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorGroup group = (org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem) {
			org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem navigatorItem = (org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem) parentElement;
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
		switch (org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(view)) {

		case org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.VISUAL_ID: {
			LinkedList<org.unicase.uiModeling.diagram.navigator.UiModelingAbstractNavigatorItem> result = new LinkedList<org.unicase.uiModeling.diagram.navigator.UiModelingAbstractNavigatorItem>();
			Diagram sv = (Diagram) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID: {
			LinkedList<org.unicase.uiModeling.diagram.navigator.UiModelingAbstractNavigatorItem> result = new LinkedList<org.unicase.uiModeling.diagram.navigator.UiModelingAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
				org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksSourceByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
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
	private Collection<View> getLinksTargetByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
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
	private Collection<View> getOutgoingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
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
		return org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.MODEL_ID
			.equals(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem> createNavigatorItems(
		Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem> result = new ArrayList<org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem>(
			views.size());
		for (View nextView : views) {
			result.add(new org.unicase.uiModeling.diagram.navigator.UiModelingNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof org.unicase.uiModeling.diagram.navigator.UiModelingAbstractNavigatorItem) {
			org.unicase.uiModeling.diagram.navigator.UiModelingAbstractNavigatorItem abstractNavigatorItem = (org.unicase.uiModeling.diagram.navigator.UiModelingAbstractNavigatorItem) element;
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
