/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.client;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * Action bar advisor for unicase.
 * @author naughton
 *
 */
public class UnicaseActionBarAdvisor extends ActionBarAdvisor {

	// Declaring all the Workbench Actions
	private IWorkbenchAction closeAction;
	private IWorkbenchAction closeallAction;
	private IWorkbenchAction revertAction;
	private IWorkbenchAction aboutAction;
	private IWorkbenchAction deleteAction;
	private IWorkbenchAction undoAction;
	private IWorkbenchAction redoAction;
	private IWorkbenchAction selectallAction;
	private IWorkbenchAction exitAction;
	private IWorkbenchAction openPerspective;

	// Declaring the ContributionItem
	private IContributionItem showViewItem;

	/**
	 * Default Constructor.
	 * @param configurer the configurer
	 */
	public UnicaseActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	/** 
	 * {@inheritDoc}
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

		revertAction = ActionFactory.REVERT.create(window);
		register(revertAction);

		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);

		deleteAction = ActionFactory.DELETE.create(window);
		register(deleteAction);

		undoAction = ActionFactory.UNDO.create(window);
		register(undoAction);

		redoAction = ActionFactory.REDO.create(window);
		register(redoAction);

		selectallAction = ActionFactory.SELECT_ALL.create(window);
		register(selectallAction);

		showViewItem = ContributionItemFactory.VIEWS_SHORTLIST.create(window);

		openPerspective = ActionFactory.OPEN_PERSPECTIVE_DIALOG.create(window);
		register(openPerspective);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.ui.application.ActionBarAdvisor#fillCoolBar(org.eclipse.jface.action.ICoolBarManager)
	 */
	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		// Adding the Actions to the CoolBar.
		IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);

		coolBar.add(new ToolBarContributionItem(toolbar, "main"));
		toolbar.add(undoAction);
		toolbar.add(redoAction);
		toolbar.add(deleteAction);

	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.ui.application.ActionBarAdvisor#fillMenuBar(org.eclipse.jface.action.IMenuManager)
	 */
	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		// Adding the Actions to the Menu Bar.
		MenuManager fileMenu = new MenuManager("&File",
				IWorkbenchActionConstants.M_FILE);
		menuBar.add(fileMenu);

		MenuManager editMenu = new MenuManager("&Edit",
				IWorkbenchActionConstants.M_EDIT);
		menuBar.add(editMenu);

		MenuManager windowMenu = new MenuManager("&Window",
				IWorkbenchActionConstants.WINDOW_EXT);
		menuBar.add(windowMenu);

		MenuManager helpMenu = new MenuManager("&Help",
				IWorkbenchActionConstants.HELP_START);
		menuBar.add(helpMenu);

		fileMenu.add(closeAction);
		fileMenu.add(closeallAction);
		fileMenu.add(new Separator());
		fileMenu.add(revertAction);
		fileMenu.add(new Separator());
		fileMenu.add(exitAction);

		editMenu.add(undoAction);
		editMenu.add(redoAction);
		editMenu.add(new Separator());
		editMenu.add(deleteAction);
		editMenu.add(selectallAction);

		helpMenu.add(aboutAction);

		windowMenu.add(openPerspective);
		windowMenu.add(showViewItem);
	}

}