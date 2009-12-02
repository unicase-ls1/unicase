package org.unicase.ui.test.meeditor.mecontrol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PlatformUI;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.ui.test.UITestCommon;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.util.UnicaseCommand;

@SuppressWarnings( { "unused" })
@RunWith(SWTBotJunit4ClassRunner.class)
public class MERichTextControlTest extends MeControlTest {

	private ActionItem actionItem;

	@Before
	public void setupActionItem() {
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("My ActionItem");
				getLeafSection().getModelElements().add(actionItem);
			}
		}.run();
	}
	
	@Test
	public void testDescriptionChange() throws Exception {
		
		openModelElement(actionItem);
		
		SWTBotStyledText styledText = getBot().activeEditor().bot().styledTextWithLabel("Description");
		SWTBotText text = getBot().activeEditor().bot().textWithLabel("Name");
		final String newDescription = "changed text in the description field";
		
		styledText.typeText(newDescription, 1);
		text.setFocus();
		
		getBot().sleep(2000);
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				assertEquals(newDescription, actionItem.getDescription());
			}
		}.run();
	}

	@Test
	public void testDescriptionUpdate() throws Exception {
		
		openModelElement(actionItem);
		
		final String newDescription = "jkflšdajfkljfsadklšfjsadklšfjsfklšasfjsašfsajdklf";
		
		UnicaseCommand unicaseCommand = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				actionItem.setDescription(newDescription);
			}
		};
		runAsnc(unicaseCommand);
		
		getBot().sleep(3000);
		
		String text = getBot().activeEditor().bot().styledTextWithLabel("Description").getText();
		
		assertEquals(newDescription, text);
	}
	
}
