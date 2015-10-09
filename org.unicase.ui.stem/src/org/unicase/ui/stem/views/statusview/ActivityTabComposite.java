/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.emfstore.internal.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.internal.common.model.util.IdEObjectCollectionChangeObserver;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.stem.views.TaskTableUtil;
import org.unicase.ui.stem.views.statusview.dnd.ActivityTabDropAdapter;
import org.unicase.ui.stem.views.statusview.dnd.StatusViewTabsDragAdapter;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * Composite to show the activity views.
 * 
 * @author helming
 */
public class ActivityTabComposite extends Composite implements IdEObjectCollectionChangeObserver {

	private TreeViewer treeViewer;
	private ECPWorkspace workspace;
	private AdapterImpl adapterImpl;
	private ActivityTabDropAdapter activityTabDropAdapter;
	private StatusViewTabsDragAdapter activityTabDragAdapter;

	/**
	 * default constructor.
	 * 
	 * @param parent the parent composite
	 * @param style the swt style
	 */
	public ActivityTabComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTree();

		try {
			workspace = ECPWorkspaceManager.getInstance().getWorkSpace();
		} catch (NoWorkspaceException e) {
			ModelUtil.logException("Failed to receive Project!", e);
			return;
		}
		if (workspace.getActiveProject() != null) {
			((Project) workspace.getActiveProject().getRootContainer()).addIdEObjectCollectionChangeObserver(this);
		}
		adapterImpl = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(ECPWorkspace.class)) == org.eclipse.emf.ecp.common.model.workSpaceModel.WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT) {

					// remove old listeners
					Object oldValue = msg.getOldValue();
					if (oldValue instanceof ECPProject) {
						((Project) ((ECPProject) oldValue).getRootContainer())
							.removeIdEObjectCollectionChangeObserver(ActivityTabComposite.this);
					}
					// add listener to get notified when work items get deleted/added/changed
					if (workspace.getActiveProject() != null) {
						((Project) workspace.getActiveProject().getRootContainer())
							.addIdEObjectCollectionChangeObserver(ActivityTabComposite.this);
					}
				}
			}
		};
		workspace.eAdapters().add(adapterImpl);
	}

	private void createTree() {
		treeViewer = new TreeViewer(this, SWT.BORDER);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		ActivityTabContentProvider contentProvider = new ActivityTabContentProvider();
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(new ActivityTabLabelProvider());
		treeViewer.setComparator(new ViewerComparator());
		TaskTableUtil.addColumns(treeViewer);

		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event.getSelection();
				if (sel.getFirstElement() instanceof UnicaseModelElement) {
					UnicaseActionHelper.openModelElement((UnicaseModelElement) sel.getFirstElement(), treeViewer
						.getClass().getName());
				}
			}

		});

		addDnDSupport();
	}

	private void addDnDSupport() {
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };

		activityTabDropAdapter = new ActivityTabDropAdapter();
		treeViewer.addDropSupport(dndOperations, transfers, activityTabDropAdapter);
		activityTabDragAdapter = new StatusViewTabsDragAdapter(treeViewer);
		treeViewer.addDragSupport(dndOperations, transfers, activityTabDragAdapter);

	}

	/**
	 * Set input to TreeViewer.
	 * 
	 * @param me input model element
	 * @param statusView the active status view. This is needed for drag and drop.
	 */
	public void setInput(UnicaseModelElement me, StatusView statusView) {
		activityTabDropAdapter.setCurrentOpenME(me);
		treeViewer.setInput(me);

		if ((treeViewer.getInput() == null) || (!treeViewer.getInput().equals(me))) {
			treeViewer.setInput(me);
		} else {
			treeViewer.refresh();
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementAdded(org.unicase.metamodel.Project,
	 *      org.unicase.model.UnicaseModelElement)
	 */
	public void modelElementAdded(IdEObjectCollection project, EObject modelElement) {
		treeViewer.refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.UnicaseModelElement)
	 */
	public void modelElementRemoved(IdEObjectCollection project, EObject modelElement) {
		// nothing to do;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.metamodel.Project, org.unicase.model.UnicaseModelElement)
	 */
	public void notify(Notification notification, IdEObjectCollection project, EObject modelElement) {
		treeViewer.refresh();
	}

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {

		workspace.eAdapters().remove(adapterImpl);
		if (workspace.getActiveProject() != null && workspace.getActiveProject().getRootContainer() != null) {
			((Project) workspace.getActiveProject().getRootContainer()).removeIdEObjectCollectionChangeObserver(this);
		}
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#collectionDeleted(org.eclipse.emf.emfstore.common.model.IdEObjectCollection)
	 */
	public void collectionDeleted(IdEObjectCollection collection) {
		// nothing to do
	}

}
