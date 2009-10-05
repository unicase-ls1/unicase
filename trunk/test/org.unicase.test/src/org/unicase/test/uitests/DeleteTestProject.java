package org.unicase.test.uitests;

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
import org.unicase.workspace.test.SetupHelper;

@SuppressWarnings( { "unused" })
@RunWith(SWTBotJunit4ClassRunner.class)
public class DeleteTestProject {
	private static final String RESTRICTION = "restriction";
	private static SWTWorkbenchBot bot;

	@BeforeClass
	public static void beforeClass() throws Exception {
		bot = new SWTWorkbenchBot();
		bot.viewByTitle("Welcome").close();
		// bot.getFinder();
		SetupHelper.startSever();

	}

	@Test
	public void canDeleteProject() throws Exception {
		Logger logger = Logger.getLogger("LoggerTest");
		bot.menu("Window").menu("Show View").menu("Other...").click();
		SWTBotShell shell = bot.shell("Show View");
		shell.activate();
		bot.tree().expandNode("unicase").select("EmfStore Browser");
		bot.button("OK").click();
		SWTBotView viewById = bot.activeView();
		SWTBotTreeItem[] items = viewById.bot().tree().getAllItems();
		items[0].getText();
		// items[0].expand();
		logger.addHandler(new FileHandler("deletetestprojectlog.txt"));
		boolean flag = true;
		int countofelem = (items[0].expand().rowCount());
		int testprojectposition = -1;
		if (countofelem > 0) {
			logger.info("deleting a project called :testproject");
			SWTBotTreeItem[] subitem = items[0].getItems();
			for (int i = 0; i < countofelem && flag == true; i++) {
				if (subitem[i].getText().equalsIgnoreCase("testproject")) {
					flag = false;
					testprojectposition = i;
					logger.info("testproject exists " + testprojectposition);
				}

			}
			if (flag) {
				logger.info("testproject dosn't exists");
			} else {
				subitem[testprojectposition].select().contextMenu("Delete on server").click();
				shell = bot.shell("Delete testproject");
				shell.activate();
				String checkboxname = (bot.checkBox().getText());
				logger.info(checkboxname);
				bot.checkBox().select();
				bot.button("OK").click();

			}

		} else {
			logger.info("project list is empty nothing to be deleted ");

		}

	}

	@AfterClass
	public static void sleep() {
		bot.sleep(20000);
		SetupHelper.stopServer();
	}

}
