package org.unicase.test.uitests;

import java.util.logging.Logger;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unicase.workspace.test.SetupHelper;

@SuppressWarnings( { "unused" })
@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateNewProject {

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
	public void canCreateANewJavaProject() throws Exception {
		Logger logger = Logger.getLogger("LoggerTest");

		logger.info("testing");
	}

	@AfterClass
	public static void sleep() {
		bot.sleep(2000);
		SetupHelper.stopServer();
	}
}
