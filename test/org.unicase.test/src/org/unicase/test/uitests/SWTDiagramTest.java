package org.unicase.test.uitests;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTBotGefTestCase;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unicase.workspace.test.SetupHelper;

@RunWith(SWTBotJunit4ClassRunner.class)
public class SWTDiagramTest extends SWTBotGefTestCase {

	private static SWTWorkbenchBot bot;

	@BeforeClass
	public static void beforeClass() throws Exception {
		bot = new SWTWorkbenchBot();
		bot.viewByTitle("Welcome").close();
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
		SWTBotTreeItem[] uninavigatoritem = viewById.bot().tree().getAllItems();

		if (uninavigatoritem.length == 0) {

			bot.menu("Window").menu("Show View").menu("Other...").click();
			shell1 = bot.shell("Show View");
			shell1.activate();
			bot.tree().expandNode("unicase").select("EmfStore Browser");
			bot.button("OK").click();

			viewById = bot.activeView();
			SWTBotTreeItem[] emfbrowseritem = viewById.bot().tree().getAllItems();
			emfbrowseritem[0].doubleClick();
			SWTBotTreeItem[] subitem = emfbrowseritem[0].getItems();
			bot.sleep(2000);
			subitem[0].select().contextMenu("Checkout").click().setFocus();

			bot.sleep(2000);
			bot.menu("Window").menu("Open Perspective").menu("Other...").click();
			SWTBotShell openPerspectiveShell = bot.shell("Open Perspective");
			openPerspectiveShell.activate();
			bot.table().select("Unicase");
			bot.button("OK").click();
			// bot.viewById("Unicase Navigator").show();

			bot.menu("Window").menu("Show View").menu("Other...").click();
			shell1 = bot.shell("Show View");
			shell1.activate();
			bot.tree().expandNode("unicase").select("Unicase Navigator");
			bot.button("OK").click();
		}
		viewById = bot.activeView();
		SWTBotTreeItem[] items = viewById.bot().tree().getAllItems();
		SWTBotTreeItem[] subitem = items[0].expand().getItems();
		items = subitem[0].expand().getItems();
		subitem = items[3].expand().getItems();
		subitem[0].doubleClick();

		bot.sleep(2000);

		bot.menu("Window").menu("Navigation").menu("Activate Editor").click();
		bot.menu("Window").menu("Show View").menu("Other...").click();
		shell = bot.shell("Show View");
		shell.activate();
		bot.tree().expandNode("General").select("Palette");
		bot.button("OK").click();
		System.out.println(bot.activeView().getTitle());
		SWTGefBot gefBot = new SWTGefBot();
		gefBot.activeEditor().setFocus();
		SWTBotGefEditor editor = gefBot.gefEditor("WalkThroughAutomaticDoor Class Diagram");
		editor.activateTool("Class");
		editor.mouseMoveLeftClick(50, 50);
		gefBot.text().typeText("Test class");

		bot.menu("Window").menu("Show View").menu("Other...").click();
		shell1 = bot.shell("Show View");
		shell1.activate();
		bot.tree().expandNode("General").select("Properties");
		bot.button("OK").click();

	}

	@AfterClass
	public static void sleep() {
		bot.sleep(200000);
	}

}
