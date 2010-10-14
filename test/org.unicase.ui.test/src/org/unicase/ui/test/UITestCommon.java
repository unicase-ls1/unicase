/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.unicase.model.organization.User;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.test.SetupHelper;

/**
 * Provides method to open perspective and views.
 * 
 * @author Nitesh
 */
public class UITestCommon {

	/**
	 * Method to open a view.
	 * 
	 * @param bot swtbot
	 * @param node Node of the perspective for example Unicase is the node for
	 * @param view The actual view to be opened.
	 */
	public static void openView(SWTWorkbenchBot bot, String node, String view) {

		bot.menu("Window").menu("Show View").menu("Other...").click();
		SWTBotShell shell1 = bot.shell("Show View");
		shell1.activate();
		bot.tree().expandNode(node).select(view);
		bot.button("OK").click();

	}

	/**
	 * Method to open a perspective.
	 * 
	 * @param bot swtbot
	 * @param perspective actual name of the perspective as appear in eclipse.
	 */
	public static void openPerspective(SWTWorkbenchBot bot, String perspective) {

		bot.menu("Window").menu("Open Perspective").menu("Other...").click();
		SWTBotShell openPerspectiveShell = bot.shell("Open Perspective");
		openPerspectiveShell.activate();
		bot.table().select(perspective);
		bot.button("OK").click();

	}

	/**
	 * Method to create a user session and related to a specific workspace.
	 * 
	 * @param user contains the user's properties
	 * @param password contains the user's password
	 * @return Usersession
	 */

	public static Usersession createUsersession(User user, String password) {
		Usersession session = WorkspaceFactory.eINSTANCE.createUsersession();
		// WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions().add(session);
		session.setServerInfo(SetupHelper.getServerInfo());
		session.setUsername(user.getName());
		session.setPassword(password);
		return session;
	}

}
