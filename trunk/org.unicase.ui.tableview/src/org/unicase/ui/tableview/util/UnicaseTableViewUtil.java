/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.util;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.ui.tableview.Activator;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Utility class for the UniCase TableViews.
 * 
 * @author abdelhamidbarzali.
 */
public final class UnicaseTableViewUtil {
	/**
	 * the Constructor.
	 */
	private UnicaseTableViewUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * resize UnicaseTableView columns .
	 * 
	 * @param tableViewer {@link TableViewer}.
	 */
	public static void resizeColumns(TableViewer tableViewer) {
		Table table = tableViewer.getTable();
		TableColumn[] columns = table.getColumns();
		if (columns.length == 0) {
			return;
		}
		int resize = table.getClientArea().width / columns.length;
		for (int i = 0; i < columns.length; i++) {
			boolean resizecondition = columns[i].getText().contains("Assignee")
				|| columns[i].getText().contains("Creator") || columns[i].getText().contains("Reviewer")
				|| columns[i].getText().contains("Date") || columns[i].getText().equalsIgnoreCase("Name")
				|| columns[i].getText().equalsIgnoreCase("Email");
			if (columns[i].getText().length() <= 8 && !resizecondition) {

				columns[i].setWidth(55);
				resize = resize + 20;
			}

			else if (columns.length > 6) {
				columns[i].setWidth(resize + 50);
			}

			else {
				columns[i].setWidth(resize);
			}

		}

	}

	/**
	 * shows Dialog to select elements out of a list of elements. Returns the first Object of all non-abstract,
	 * non-interface subclasses of the given input. Looks in whole graph starting from the root package - i.e.
	 * ModelPackage. Returns null if no element has been selected.
	 * 
	 * @param shell Shell .
	 * @param initialContent Collection<?> the label renderer.
	 * @param renderer LabelProvider.
	 * @return {@link ModelElement}.
	 */
	public static EClass showAllMEsTypeDialog(Shell shell, Collection<?> initialContent, ILabelProvider renderer) {
		// adapterFactory an adapter factory that yield adapters that
		// implement the various item label provider interfaces.

		if (renderer.equals(null)) {
			// set default AdapterFactoryLabelProvider .
			renderer = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell.getShell(), renderer);
		Object[] items = initialContent.toArray(new Object[initialContent.size()]);
		dialog.setElements(items);
		dialog.setTitle("Select Element Type");
		dialog.setBlockOnOpen(true);
		dialog.setMultipleSelection(false);

		EClass eclass = null;
		if (dialog.open() == Window.OK) {
			eclass = (EClass) dialog.getFirstResult();

		}

		return eclass;

	}

	/**
	 * clear all Columns in the Table.
	 * 
	 * @param tableViewer TableViewer.
	 */
	public static void removeColumns(TableViewer tableViewer) {

		Table tabl = tableViewer.getTable();

		if (tabl != null && !tabl.isDisposed()) {
			TableColumn[] columns = tabl.getColumns();

			for (int i = 0; i < columns.length; i++) {
				if (!columns[i].getText().equals("Name")) {

					columns[i].dispose();

				}
			}

		}

		resizeColumns(tableViewer);

	}

	/**
	 * return all {@link ModelElement}s.
	 * 
	 * @return ModelElement[].
	 */
	public static ModelElement[] getAllProjectMEs() {

		Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		if (workspace == null) {
			return null;
		} else {
			ProjectSpace actoveprojectspace = workspace.getActiveProjectSpace();
			if (actoveprojectspace == null) {
				return null;
			}
			Project proj = actoveprojectspace.getProject();
			if (proj == null) {
				return null;
			}
			EList<ModelElement> melist = proj.getAllModelElements();
			ModelElement[] mesarray = new ModelElement[melist.size()];
			for (int i = 0; i < melist.size(); i++) {
				ModelElement me = melist.get(i);
				mesarray[i] = me;
			}
			return mesarray;
		}
	}

	/**
	 * @param tableViewer {@link TableViewer}.
	 * @return Action {@link Action}.
	 */
	public static Action createRefreshAction(final TableViewer tableViewer) {
		final Table table = tableViewer.getTable();

		Action action = new Action("Refreshes this Tableviewer") {
			@Override
			public void run() {

				if (table != null) {
					// Deselects all selected item.
					table.deselectAll();

					if (table.getColumnCount() > 0) {

						tableViewer.setInput(getAllProjectMEs());
						tableViewer.refresh();
						updateSLManager(tableViewer, null);

					}
				}

			}
		};
		action.setToolTipText("refresh TableViewer");
		action.setImageDescriptor(Activator.getImageDescriptor("/icons/refresh.png"));
		return action;
	}

	/**
	 * update the status line manager . + update with filtered ME-icon in status line manager.
	 * 
	 * @param tableViewer {@link TableViewer}.
	 * @param icon Image.
	 */
	public static void updateSLManager(TableViewer tableViewer, Image icon) {

		String selectionCount = "";
		String itemCount = "";
		Table table = tableViewer.getTable();
		if (table != null) {
			selectionCount = table.getSelectionCount() + "";
			itemCount = table.getItemCount() + "";
		}

		IStatusLineManager isLineManager = getIStatusLineManager();

		if (isLineManager != null && !isLineManager.equals(null)) {
			if (icon == null) {
				isLineManager.setMessage(selectionCount + " Items selected / " + itemCount);
			} else {
				isLineManager.setMessage(icon, selectionCount + " Items selected / " + itemCount);
			}

		}

	}

	/**
	 * Returns the status line manager.
	 * 
	 * @return {@link IStatusLineManager}.
	 */
	public static IStatusLineManager getIStatusLineManager() {
		IStatusLineManager statusLineManager = null;
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage activePage = workbenchWindow.getActivePage();
		if (activePage != null) {
			IWorkbenchPart activePart = activePage.getActivePart();

			if (activePart instanceof IViewPart) {
				IViewSite iviewsite = ((IViewPart) activePart).getViewSite();
				if (iviewsite != null) {
					statusLineManager = iviewsite.getActionBars().getStatusLineManager();
				}

			} else if (activePart instanceof IEditorPart) {
				IEditorSite iedEditorSite = ((IEditorPart) activePart).getEditorSite();
				if (iedEditorSite != null) {
					statusLineManager = iedEditorSite.getActionBars().getStatusLineManager();
				}

			}
		}
		return statusLineManager;
	}

}
