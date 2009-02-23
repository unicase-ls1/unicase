/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.views;

import java.io.IOException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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
import org.unicase.docExport.exceptions.TemplateSaveException;

/**
 * @author Sebastian Höcht
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
			TemplateRegistry.getAllTemplates();
		} catch (TemplateSaveException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		AdapterFactory myAdapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		viewer = new TreeViewer(parent);
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(myAdapterFactory));
		viewer.setContentProvider(new AdapterFactoryContentProvider(myAdapterFactory));

		// viewer.setLabelProvider(new TreeLabelProvider());
		// viewer.setContentProvider(new TreeContentProvider());

		viewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

		// viewer.setLabelProvider(new TreeLabelProvider());
		// viewer.setContentProvider(new ExportModelItemProviderAdapterFactory().);

		try {
			viewer.setInput(TemplateRegistry.getTemplatesResource());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// try {
		// viewer.setInput(TemplateRegistry.getAllTemplates().get(0));
		// } catch (TemplateSaveException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }

		// viewer.setLabelProvider(labelProvider);
		// try {
		// viewer.setInput(TemplateRegistry.getAllTemplates());
		// } catch (TemplateSaveException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }

		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(viewer.getTree());
		// Set the MenuManager
		viewer.getTree().setMenu(menu);
		getSite().registerContextMenu(menuManager, viewer);
		// Make the selection available
		getSite().setSelectionProvider(viewer);

		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {

				IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);

				try {
					handlerService.executeCommand(TemplateEditor.COMMAND_ID, null);
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotDefinedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotEnabledException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotHandledException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		getSite().setSelectionProvider(viewer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
	}

}
