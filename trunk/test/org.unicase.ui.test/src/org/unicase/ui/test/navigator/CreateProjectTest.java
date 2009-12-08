package org.unicase.ui.test.navigator;

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
public class CreateProjectTest {

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
	public void canCreateANewProject() throws Exception {
		Logger logger = Logger.getLogger("LoggerTest");
		UITestCommon.openView(bot, UNICASE_NODE, BROWSER);
		SWTBotView viewById = bot.activeView();
		SWTBotTreeItem[] items = viewById.bot().tree().getAllItems();
		items[0].getText();
		logger.addHandler(new FileHandler("createnewprojectlog.txt"));
		int countofelem = (items[0].expand().rowCount());
		boolean flag = true;
		int testprojectposition = -1;
		SWTBotTreeItem[] subitem = items[0].getItems();
		for (int i = 0; i < countofelem && flag == true; i++) {
			if (subitem[i].getText().equalsIgnoreCase("testproject")) {
				flag = false;
				testprojectposition = i;
				logger.info("testproject exists " + testprojectposition);
			}

		}
		if (flag || countofelem == 0) {
			logger.info("creating a new project called :testproject");
			items[0].select().contextMenu("Create new project...").click();
			bot.textWithLabel("Name:").typeText("testproject");
			bot.button("OK").click();
			items[0].expand();
		} else {
			logger.info("testproject already exists");
		}

	}

	@AfterClass
	public static void sleep() {
		bot.sleep(2000);
		SetupHelper.stopServer();
	}
}
