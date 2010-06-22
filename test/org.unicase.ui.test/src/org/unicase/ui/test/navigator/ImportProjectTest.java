/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.navigator;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unicase.ui.test.UITestCommon;
import org.unicase.workspace.test.SetupHelper;

@SuppressWarnings( { "unused" })
@RunWith(SWTBotJunit4ClassRunner.class)
public class ImportProjectTest {

	private static final String RESTRICTION = "restriction";
	private static SWTWorkbenchBot bot;
	private static Logger logger;
	private static final String UNICASE_NODE = "Unicase";
	private static final String BROWSER = "EmfStore Browser";
	private static SWTBotShell openPerspectiveShell;

	@BeforeClass
	public static void beforeClass() throws Exception {
		bot = new SWTWorkbenchBot();
		bot.viewByTitle("Welcome").close();
		SetupHelper.startSever();
		logger = Logger.getLogger("LoggerTest");
		logger.addHandler(new FileHandler("importproject.txt"));

	}

	@Test
	public void importproject() throws Exception {
		UITestCommon.openView(bot, UNICASE_NODE, BROWSER);
		UITestCommon.openPerspective(bot, UNICASE_NODE);
		SWTBotView viewById = bot.activeView();
		int x1 = bot.tree().rowCount();
		SWTBotTreeItem[] items = viewById.bot().tree().getAllItems();
		try {

			logger.info(bot.tree().contextMenu("Import").menu("Import Project").getText());
			bot.tree().contextMenu("Import").menu("Import Project").click();
		} catch (RuntimeException e) {
			logger.info("" + e);
		}
		logger.info("sleeping down for the first time to select the imported project");
		bot.sleep(9000);

		logger.info("waking up for the first time");
		openPerspectiveShell = bot.shell("Project Name");
		openPerspectiveShell.activate();
		// logger.info(bot.textWithLabel("Please enter a name for the import project:").getText());
		// bot.button("OK").click();
		bot.text().typeText("test2");
		bot.button("OK").click();
		bot.button("OK").click();
		UITestCommon.openPerspective(bot, UNICASE_NODE);
		int x2 = bot.tree().rowCount();
		logger.info(x1 + " " + x2);
		items = bot.tree().getAllItems();
		logger.info(items[x2 - 1].getText());
		try {
			logger.info("Check:" + items[x2 - 1].select().contextMenu("Share  Project").getText());
			items[x2 - 1].select().contextMenu("Share  Project").click();
			openPerspectiveShell = bot.shell("Select Usersession");
			openPerspectiveShell.activate();
			bot.table().select(0);
			bot.button("OK").click();
			bot.table().select(0);
			bot.button("OK").click();
			bot.button("OK").click();
		} catch (Exception e) {
			logger.info(" " + e);
		}
	}

	@AfterClass
	public static void sleep() {
		logger.info("sleeping down for the 2nd time and closing the server");
		bot.sleep(9000);
		SetupHelper.stopServer();
		logger.info("waking up for the last time and project will end");

	}

}
