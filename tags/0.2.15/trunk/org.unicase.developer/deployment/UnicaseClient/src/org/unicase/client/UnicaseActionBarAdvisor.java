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

	public UnicaseActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

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

	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		// Adding the Actions to the CoolBar.
		IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);

		coolBar.add(new ToolBarContributionItem(toolbar, "main"));
		toolbar.add(undoAction);
		toolbar.add(redoAction);
		toolbar.add(deleteAction);

	}

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