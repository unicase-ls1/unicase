package org.unicase.ui.test.emfStoreBrowser;

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

@SuppressWarnings( { "unused" })
@RunWith(SWTBotJunit4ClassRunner.class)
public class CheckoutProjectTest {

	private static final String RESTRICTION = "restriction";
	private static SWTWorkbenchBot bot;
	private static final String UNICASE_NODE = "Unicase";
	private static final String BROWSER = "EmfStore Browser";

	@BeforeClass
	public static void beforeClass() throws Exception {
		bot = new SWTWorkbenchBot();
		bot.viewByTitle("Welcome").close();

		// bot.getFinder();
		SetupHelper.startSever();

	}

	@Test
	public void checkoutProject() throws Exception {
		
		
		Logger logger = Logger.getLogger("LoggerTest");
		logger.addHandler(new FileHandler("checkoutlog.txt"));
		
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
			try {
				// logger.info(bot.viewById("org.unicase.ui.navigator.viewer").getTitle());

				UITestCommon.openPerspective(bot, UNICASE_NODE);

				// TBotPrespective= bot.perspectives();
			} catch (Exception e) {
				logger.info("Output" + e);
			}

			// SWTBotView[] Allviews= bot.
			// logger.info(bot.viewById("org.unicase.ui.navigator").getTitle());
			// ("Unicase Navigator").show();
		}

	}

	@AfterClass
	public static void sleep() {
		bot.sleep(5000);
		SetupHelper.stopServer();
	}

}
