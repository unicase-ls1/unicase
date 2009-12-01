package org.unicase.ui.test.meeditor;

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
public class EditModelElementDescriptionTest {
	private static final String RESTRICTION = "restriction";
	private static SWTWorkbenchBot bot;
	private static Logger logger;

	@BeforeClass
	public static void beforeClass() throws Exception {
		bot = new SWTWorkbenchBot();
		bot.viewByTitle("Welcome").close();
		SetupHelper.startSever();
		logger = Logger.getLogger("LoggerTest");
		logger.addHandler(new FileHandler("editmodelelement.txt"));

	}

	@Test
	public void editModelElement() throws Exception {

		UITestCommon.openPerspective(bot, "Unicase");
		SWTBotView viewById = bot.activeView();
		logger.info(viewById.getTitle());
		SWTBotTreeItem[] items = viewById.bot().tree().getAllItems();
		logger.info(items[0].getText());
		items[0].expand().getNode(0).select().doubleClick();

		// logger.info("active editor" + bot.activeEditor().);
		// bot.textWithLabel("Name").typeText("hi");
		logger.info("check1:" + bot.editorById("org.unicase.ui.meeditor").getTitle());
		// logger.info("check2:" + bot.editorByTitle("Name").getTitle())

		// bot.e
		
		bot.styledText().typeText("hello  world");

	}

	@AfterClass
	public static void sleep() {

		bot.sleep(20000);
		SetupHelper.stopServer();

	}

}
