package org.unicase.ui.test.meeditor;

import java.util.Random;
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
		bot.sleep(3000);
		this.openWorkItem();
		bot.sleep(5000);
		this.testName();
		bot.sleep(4000);
		this.testDescription();
		
	}
	
	
	public void testDescription() {
		this.openWorkItem();
		bot.sleep(3000);
		String oldtext = bot.styledText().getText();
		bot.styledText().typeText("changed text in the description field", 1);
		String changedtext = bot.styledText().getText();
		bot.sleep(1000);
		bot.activeEditor().setFocus();
		bot.sleep(6000);
		bot.activeEditor().close();
		bot.sleep(2000);
		this.openWorkItem();
		bot.sleep(5000);
		if (!bot.styledText().getText().equals(changedtext)){
			logger.info("Changed text in description was not saved");
		}
		else logger.info("Description field test was successfull. Resetting the old text of the field and exiting");
		bot.styledText().typeText(oldtext);
		
	}

	public void testName(){
		String actualname = bot.activeEditor().bot().textWithLabel("Name").getText();
		bot.activeEditor().bot().textWithLabel("Name").typeText(actualname + " and something else", 1);
		bot.sleep(4000);
		String changedname = bot.activeEditor().bot().textWithLabel("Name").getText();
		logger.info("changed actual name:\""+ actualname + "\" to \""+changedname + "\" before loosing focus!");
		bot.activeEditor().close();
		bot.sleep(4000);
		this.openWorkItem();
		bot.sleep(3000);
		
		if( ! bot.activeEditor().bot().textWithLabel("Name").getText().equalsIgnoreCase(changedname)){
			logger.info("Name field was not saved automatically after last change!");
			
		}else
			logger.info("It was saved last time! check current : \""+ bot.activeEditor().bot().textWithLabel("Name").getText() + "\" -- and the old before loosing focus:\""+ changedname+"\"");
		
		bot.sleep(2000);
		logger.info("Resetting the actual name of the model elemnt!");
		bot.activeEditor().bot().textWithLabel("Name").setText(actualname);
		bot.sleep(1000);
		bot.activeEditor().close();
		
	}
	
	
	
	public void openWorkItem(){
		if (! bot.activeView().getTitle().equals("Unicase Navigator")){
	
		UITestCommon.openView(bot, "Unicase", "Unicase Navigator");
		
		}
		
		SWTBotView viewById = bot.activeView();
		 //logger.info(viewById.getTitle());
		SWTBotTreeItem[] items = viewById.bot().tree().getAllItems();
		//logger.info(items[0].getText());
		items[0].expand().getNode(0).select().doubleClick();
		
	}
	
	
	@AfterClass
	public static void sleep() {

		bot.sleep(10000);
		SetupHelper.stopServer();

	}

}
