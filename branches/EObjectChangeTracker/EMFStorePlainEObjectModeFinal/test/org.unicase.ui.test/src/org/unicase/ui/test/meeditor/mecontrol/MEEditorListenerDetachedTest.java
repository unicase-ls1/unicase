package org.unicase.ui.test.meeditor.mecontrol;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.util.UnicaseCommand;

public class MEEditorListenerDetachedTest extends MEEditorTest {
	private ActionItem actionItem;
	private User user;

	@Before
	public void setupActionItem() {

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("My ActionItem");
				getLeafSection().getModelElements().add(actionItem);
				user = OrganizationFactory.eINSTANCE.createUser();
				user.setName("Some user");
				getLeafSection().getModelElements().add(user);
			}
		}.run();
	}

	@Test
	public void listenersDetachedTest() {
		UITestCommon.openPerspective(getBot(), "Unicase");
		openModelElement(actionItem);
		getBot().activeEditor().close();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actionItem.setName("Do nothing today!");
				actionItem.setDescription("This is all about doing nothing");
				actionItem.setAssignee(user);
				actionItem.setDone(false);
				actionItem.setResolved(false);
				actionItem.setReviewer(user);
				actionItem.setEffort(0);
				actionItem.setDueDate(new Date());
				actionItem.setPriority(0);
				ActionItem annotatedAI = TaskFactory.eINSTANCE.createActionItem();
				annotatedAI.setName("Some one just annotated ME!");
				getLeafSection().getModelElements().add(annotatedAI);
				actionItem.getAnnotatedModelElements().add(annotatedAI);
				actionItem.setDescription(null);
			}
		}.run();

		openModelElement(actionItem);
		String meassage = "If you are seeing this and didn't get any Widget disposed Error then the test case worked "
			+ "and if you got Widget disposed error then there was a listener which was not detached when the editor was"
			+ "closed for the first time. You should probably debug the UincaseCommand in this test case@";
		getBot().activeEditor().bot().styledTextWithLabel("Description").typeText(meassage, 2);
	}

}
