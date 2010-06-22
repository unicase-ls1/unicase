/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.others;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.bug.BugReport;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Test the response of the editor itself if the ME or the project is deleted.
 * 
 * @author Nitesh
 */
public class EditorCloseTest extends MEEditorTest {

	private ActionItem actionItem;
	private BugReport bugReport;

	/**
	 * Setup the environment for testing.
	 */
	@Before
	public void setupActionItem() {

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("Do some work today!");
				bugReport = BugFactory.eINSTANCE.createBugReport();
				bugReport.setName("Big nasty bug!");
				getLeafSection().getModelElements().add(actionItem);
				getLeafSection().getModelElements().add(bugReport);

			}

		}.run();
	}

	/**
	 * Test if the editor gets closed in a case if the ME is deleted.
	 */
	@Test
	public void singleEditorCloseTestByDeletingME() {
		UITestCommon.openPerspective(getBot(), "Unicase");
		openModelElement(actionItem);
		String title = getBot().activeEditor().getTitle();
		assertTrue(title.toLowerCase().contains("do some work today!"));

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProjectSpace().getProject().deleteModelElement(actionItem);

			}
		}.run();

		try {
			getBot().activeEditor().getTitle();
			assertTrue(false);
			return;
		} catch (WidgetNotFoundException e) {
			assert true;
		} finally {
			// Hence due to WidgetNotFoundException the previous assert statement was not reached thus we are on the
			// the right track and lets tell that the test case was a success!
			assertTrue(true);
		}

	}

	/**
	 * Test if the multiple editors are closed if there corresponding ME's are deleted.
	 */
	@Test
	public void multipleEditorCloseTestByDeletingME() {
		UITestCommon.openPerspective(getBot(), "Unicase");
		openModelElement(actionItem);
		String title1 = getBot().activeEditor().getTitle();
		assertTrue(title1.toLowerCase().contains("do some work today!"));
		openModelElement(bugReport);
		String title2 = getBot().activeEditor().getTitle();
		assertTrue(title2.toLowerCase().contains("big nasty bug!"));

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProjectSpace().getProject().deleteModelElement(actionItem);
				getProjectSpace().getProject().deleteModelElement(bugReport);
			}
		}.run();
		getBot().sleep(2000);
		try {
			getBot().activeEditor().getTitle();
			assertTrue(false);
			return;
		} catch (WidgetNotFoundException e) {
			assert true;
		} finally {
			// Hence due to WidgetNotFoundException the previous assert statement was not reached thus we are on the
			// the right track and lets tell that the test case was a success!
			assertTrue(true);
		}

	}

	/**
	 * Test if the editor is closed if the project itself is deleted.
	 */
	@Test
	public void singleEditorCloseTestByDeletingProject() {
		UITestCommon.openPerspective(getBot(), "Unicase");
		openModelElement(actionItem);
		String title1 = getBot().activeEditor().getTitle();
		assertTrue(title1.toLowerCase().contains("do some work today!"));
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				try {
					currentWorkspace.deleteProjectSpace(getProjectSpace());
				} catch (IOException e) {
					ModelUtil.logException(e);
				}
			}
		}.run();
		// Wait to show that project has been deleted and no longer available in Navigator!
		getBot().sleep(2000);
		try {
			getBot().activeEditor().getTitle();
			assertTrue(false);
			return;
		} catch (WidgetNotFoundException e) {
			assert true;
		} finally {
			// Hence due to WidgetNotFoundException the previous assert statement was not reached thus we are on the
			// the right track and lets tell that the test case was a success!
			assertTrue(true);
		}

	}

	/**
	 * Test if the multiple editors are closed if the project itself is deleted.
	 */
	@Test
	public void multipleEditorCloseTestByDeletingProject() {
		UITestCommon.openPerspective(getBot(), "Unicase");
		openModelElement(actionItem);
		String title1 = getBot().activeEditor().getTitle();
		assertTrue(title1.toLowerCase().contains("do some work today!"));
		openModelElement(bugReport);
		String title2 = getBot().activeEditor().getTitle();
		assertTrue(title2.toLowerCase().contains("big nasty bug!"));
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				try {
					currentWorkspace.deleteProjectSpace(getProjectSpace());
				} catch (IOException e) {
					ModelUtil.logException(e);
				}
			}
		}.run();
		// Wait to show that project has been deleted and no longer available in Navigator!
		getBot().sleep(2000);
		try {
			getBot().activeEditor().getTitle();
			assertTrue(false);
			return;
		} catch (WidgetNotFoundException e) {
			assert true;
		} finally {
			// Hence due to WidgetNotFoundException the previous assert statement was not reached thus we are on the
			// the right track and lets tell that the test case was a success!
			assertTrue(true);
		}

	}
}
