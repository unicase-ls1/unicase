/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.views;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.exceptions.DefaultTemplateLoadException;
import org.unicase.docExport.exceptions.TemplatesFileNotFoundException;

/**
 * This view lists all templates in a treeview.
 * 
 * @author Sebastian Hoecht
 */
public class TemplatesView extends ViewPart {

	/**
	 * the ID of this view.
	 */
	public static final String ID = "org.unicase.templatesView";

	private static TreeViewer viewer;

	/**
	 * The constructor.
	 */
	public TemplatesView() {

	}

	/**
	 * @param parent the SWT parent object.
	 */
	@Override
	public void createPartControl(Composite parent) {

		try {
			TemplateRegistry.loadDefaultTemplatesFromZipFile();
		} catch (DefaultTemplateLoadException e1) {
			WorkspaceUtil.log("Default templates could not be loaded", e1, IStatus.ERROR);
		}

		AdapterFactory myAdapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		viewer = new TreeViewer(parent);
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(myAdapterFactory));
		viewer.setContentProvider(new TemplatesViewContentProvider(myAdapterFactory));

		viewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

		try {
			viewer.setInput(TemplateRegistry.getTemplatesResource());
		} catch (TemplatesFileNotFoundException e1) {
			WorkspaceUtil.log("Templates file could not be loaded", e1, IStatus.ERROR);
		}

		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(viewer.getTree());
		viewer.getTree().setMenu(menu);
		getSite().registerContextMenu(menuManager, viewer);
		getSite().setSelectionProvider(viewer);

		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
				try {
					handlerService.executeCommand(TemplateEditor.COMMAND_ID, null);
				} catch (ExecutionException e) {
					logTemplateError(e);
				} catch (NotDefinedException e) {
					logTemplateError(e);
				} catch (NotEnabledException e) {
					logTemplateError(e);
				} catch (NotHandledException e) {
					logTemplateError(e);
				}
			}
		});

		getSite().setSelectionProvider(viewer);
	}

	private void logTemplateError(Exception e) {
		WorkspaceUtil.log("The Template editor could not be opened", e, IStatus.ERROR);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
	}
}
