package org.unicase.test.uitests;

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
public class SWTDiagramTest {

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
	public void testDiagram() throws Exception {
		bot.menu("Window").menu("Show View").menu("Other...").click();
		SWTBotShell shell1 = bot.shell("Show View");
		shell1.activate();
		bot.tree().expandNode("unicase").select("EmfStore Browser");
		bot.button("OK").click();

		bot.menu("Window").menu("Show View").menu("Other...").click();
		SWTBotShell shell = bot.shell("Show View");
		shell.activate();
		bot.tree().expandNode("unicase").select("Unicase Navigator");
		bot.button("OK").click();

		SWTBotView viewById = bot.activeView();
		SWTBotTreeItem[] items = viewById.bot().tree().getAllItems();
		SWTBotTreeItem[] tempitem = items[0].expand().getItems();
		items = tempitem[0].expand().getItems();
		tempitem = items[3].expand().getItems();
		tempitem[0].doubleClick();

	}

	@AfterClass
	public static void sleep() {
		bot.sleep(20000);
	}

}
