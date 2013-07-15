/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.client;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.registry.ActionSetRegistry;
import org.eclipse.ui.internal.registry.IActionSetDescriptor;

/**
 * Action bar advisor for unicase.
 * 
 * @author naughton
 */
@SuppressWarnings("restriction")
public class UnicaseActionBarAdvisor extends ActionBarAdvisor {

	// Declaring all the Workbench Actions
	private IWorkbenchAction closeAction;
	private IWorkbenchAction closeallAction;
	private IWorkbenchAction aboutAction;
	private IWorkbenchAction exitAction;

	// Declaring the ContributionItem
	private IContributionItem showViewItem;

	/**
	 * Default Constructor.
	 * 
	 * @param configurer the configurer
	 */
	public UnicaseActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.application.ActionBarAdvisor#makeActions(org.eclipse.ui.IWorkbenchWindow)
	 */
	@Override
	protected void makeActions(IWorkbenchWindow window) {

		// All the actions are defined here.
		closeAction = ActionFactory.CLOSE.create(window);
		register(closeAction);

		closeallAction = ActionFactory.CLOSE_ALL.create(window);
		register(closeallAction);

		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);

		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);

		showViewItem = ContributionItemFactory.VIEWS_SHORTLIST.create(window);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.application.ActionBarAdvisor#fillMenuBar(org.eclipse.jface.action.IMenuManager)
	 */
	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		// Adding the Actions to the Menu Bar.
		MenuManager fileMenu = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);
		MenuManager windowMenu = new MenuManager("&Show View", IWorkbenchActionConstants.WINDOW_EXT);
		MenuManager helpMenu = new MenuManager("&Help", IWorkbenchActionConstants.HELP_START);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menuBar.add(helpMenu);

		fileMenu.add(closeAction);
		fileMenu.add(closeallAction);
		fileMenu.add(new Separator());
		fileMenu.add(exitAction);
		
		windowMenu.add(showViewItem);
		
		helpMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
        helpMenu.add(new Separator());
        helpMenu.add(aboutAction);
		
		removeEntry("org.eclipse.ui.edit.text.actionSet.convertLineDelimitersTo"); //$NON-NLS-1$
		
		removeEntry("org.eclipse.ui.actionSet.openFiles");
	}

	private void removeEntry(String actionSetId) {
		ActionSetRegistry reg = WorkbenchPlugin.getDefault().getActionSetRegistry();
		IActionSetDescriptor[] actionSets = reg.getActionSets();
		for (int i = 0; i <actionSets.length; i++)
		{
		    if (!actionSets[i].getId().equals(actionSetId))
		        continue;
		    IExtension ext = actionSets[i].getConfigurationElement()
		            .getDeclaringExtension();
		   reg.removeExtension(ext, new Object[] { actionSets[i] });
		}
	}

}