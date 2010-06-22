/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.emfStoreBrowser;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unicase.ui.test.UITestCommon;
import org.unicase.workspace.test.SetupHelper;

/**
 * Test calss to validate peroper functioning of checkout functionality.
 * 
 * @author Nitesh
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CheckoutProjectTest {

	@SuppressWarnings("unused")
	private static final String RESTRICTION = "restriction";
	private static SWTWorkbenchBot bot;
	private static final String UNICASE_NODE = "Unicase";
	private static final String BROWSER = "EmfStore Browser";

	/**
	 * Helper Method to start the server before the test cases run.
	 */
	@BeforeClass
	public static void beforeClass() {
		bot = new SWTWorkbenchBot();
		bot.viewByTitle("Welcome").close();

		// bot.getFinder();
		SetupHelper.startSever();

	}

	/**
	 * Checkout the project from EMFStore Browser view.
	 * 
	 * @throws Exception
	 */
	@Test
	public void checkoutProject() {
		// TODO This test case need to be fiexed or re-implementd!

		Logger logger = Logger.getLogger("LoggerTest");
		try {
			logger.addHandler(new FileHandler("checkoutlog.txt"));
		} catch (SecurityException e) {
			// ModelUtil.logException(e);
		} catch (IOException e) {
			// ModelUtil.logException(e);
		}

		UITestCommon.openPerspective(bot, UNICASE_NODE);
		UITestCommon.openView(bot, UNICASE_NODE, BROWSER);

		SWTBotView viewById = bot.activeView();
		SWTBotTreeItem[] items = viewById.bot().tree().getAllItems();
		items[0].doubleClick();
		// need to be fixed here to give the password automatically !
		bot.sleep(8000);
		int countofelem = (items[0].getItems().length);
		if (countofelem == 0) {
			logger.info("the project list is empty");
			items[0].select().contextMenu("Create new project...").click();
			bot.textWithLabel("Name:").typeText("testproject");
			bot.button("OK").click();
			items[0].expand();
		} else {
			logger.info("the project list is not empty");
			SWTBotTreeItem[] subitem = items[0].getItems();
			subitem[0].select().contextMenu("Checkout").click();

			// logger.info(bot.viewById("org.unicase.ui.navigator.viewer").getTitle());

			UITestCommon.openPerspective(bot, UNICASE_NODE);

			// TBotPrespective= bot.perspectives();

			// SWTBotView[] Allviews= bot.
			// logger.info(bot.viewById("org.unicase.ui.navigator").getTitle());
			// ("Unicase Navigator").show();
		}

	}

	/**
	 * After class method to stop the server once the test case has run.
	 */
	@AfterClass
	public static void sleep() {
		bot.sleep(5000);
		SetupHelper.stopServer();
	}

}
