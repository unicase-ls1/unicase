/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor.mecontrols.melinkcontrol;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.ActivityType;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.ui.test.UITestCommon;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Tests the ability of opening model elements from different views.
 * 
 * @author staudta
 */
public class MEEditorOpenFromDifferentViewsTest {

	private static SWTWorkbenchBot bot = new SWTWorkbenchBot();

	private static final String NAVIGATOR = "Unicase Navigator";
	private static final String UNICASE_NODE = "Unicase";
	private static final String TASKVIEW = "Task View";

	private static ProjectSpace projectSpace;
	private static ActionItem actionItem;

	/**
	 * Closes the welcome screen and initializes the environment. Deletes the existing test workspace, if any.
	 * 
	 * @throws IOException deleting existing test workspace failed
	 */
	@BeforeClass
	public static void setupClass() throws IOException {
		bot = new SWTWorkbenchBot();

		bot.viewByTitle("Welcome").close();
		WorkspaceUtil.deleteTestWorkspace();
		Configuration.setTesting(true);
		WorkspaceManager.getInstance();

		// create test project
		new TestProjectCreator().run();
	}

	/**
	 * Reset perspective.
	 */
	@Before
	public void setupTest() {
		// part of test that requires UI-thread
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				// requires UI-thread since it is gonna invoke PlatformUI.getWorkbench()
				resetWorkbench();
			}
		});

		UITestCommon.openPerspective(bot, UNICASE_NODE);
		bot.sleep(2000);

		UITestCommon.openView(bot, UNICASE_NODE, NAVIGATOR);
		bot.sleep(2000);
	}

	/**
	 * All opened windows and editors will be closed. The current perspective will be reseted and the default
	 * perspective will be activated and also reseted.
	 */
	private void resetWorkbench() {
		try {
			IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			Shell activeShell = Display.getCurrent().getActiveShell();
			if (activeShell != workbenchWindow.getShell()) {
				activeShell.close();
			}
			page.closeAllEditors(false);
			page.resetPerspective();
			String defaultPerspectiveId = workbench.getPerspectiveRegistry().getDefaultPerspective();
			workbench.showPerspective(defaultPerspectiveId, workbenchWindow);
			page.resetPerspective();
			bot.sleep(2000);

		} catch (WorkbenchException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Creates a test project for these test cases.
	 */
	static class TestProjectCreator extends UnicaseCommand {

		/**
		 * Project will be created in an transaction.
		 * 
		 * @see org.unicase.workspace.util.UnicaseCommand#doRun()
		 */
		@Override
		protected void doRun() {
			Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
			projectSpace = currentWorkspace.createLocalProject("TestProject", "Test Description");
			Project project = projectSpace.getProject();
			CompositeSection document = DocumentFactory.eINSTANCE.createCompositeSection();
			document.setName("Requirements Document");
			project.addModelElement(document);
			LeafSection leafSection = DocumentFactory.eINSTANCE.createLeafSection();
			leafSection.setName("LeafSection");
			document.getSubsections().add(leafSection);

			// add users to leaf section
			User userJoker = OrganizationFactory.eINSTANCE.createUser();
			userJoker.setName("Joker");
			leafSection.getModelElements().add(userJoker);
			User userBatman = OrganizationFactory.eINSTANCE.createUser();
			userBatman.setName("Batman");
			leafSection.getModelElements().add(userBatman);

			// create a WorkPackage
			{
				WorkPackage workpackage = TaskFactory.eINSTANCE.createWorkPackage();
				workpackage.setName("Sprint 1");
				leafSection.getModelElements().add(workpackage);

				// add an action item to the previous WorkPackage
				ActionItem actionItemA = TaskFactory.eINSTANCE.createActionItem();
				actionItemA.setName("Action A");
				actionItemA.setContainingWorkpackage(workpackage);
				actionItemA.setAssignee(userBatman);
				actionItemA.setActivity(ActivityType.ANALYSIS);

				// add the relevant action item to the previous WorkPackage
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("Action B");
				actionItem.setContainingWorkpackage(workpackage);
				actionItem.setAssignee(userJoker);
				actionItem.setReviewer(userBatman);
				actionItem.setActivity(ActivityType.IMPLEMENTATION);

				// add an action item to the previous WorkPackage
				ActionItem actionItemC = TaskFactory.eINSTANCE.createActionItem();
				actionItemC.setName("Action C");
				actionItemC.setContainingWorkpackage(workpackage);
				actionItemC.setAssignee(userJoker);
				actionItemC.setActivity(ActivityType.IMPLEMENTATION);
			}
		}
	}

	/**
	 * Selects from a table the row that matches the expected cellText.
	 * 
	 * @param table a table
	 * @param cellText the text that should be search inside the table
	 */
	private void select(SWTBotTable table, String cellText) {
		for (int row = 0; row < table.rowCount(); row++) {
			for (int column = 0; column < table.columnCount(); column++) {
				if (table.cell(row, column).equals(cellText)) {
					table.select(row);
					return;
				}
			}
		}
	}

	/**
	 * Opens the task view. Than the ActionItem B is is opened.
	 * 
	 * @throws PartInitException will be thrown if the active editor throws an exception
	 */
	@Test
	public void taskView() throws PartInitException {
		UITestCommon.openView(bot, UNICASE_NODE, TASKVIEW);
		bot.sleep(2000);

		// part of test that requires UI-thread
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				final SWTBotTable table = bot.activeView().bot().table();
				select(table, "Action B");
				table.widget.notifyListeners(SWT.DefaultSelection, new Event());
			}

		});
		bot.sleep(2000);

		// check which element was opened
		SWTBotEditor activeEditor = bot.activeEditor();
		IEditorInput editorInput = activeEditor.getReference().getEditorInput();
		if (editorInput instanceof MEEditorInput) {
			MEEditorInput meEditorInput = (MEEditorInput) editorInput;
			EObject modelElement = meEditorInput.getModelElement();
			assertTrue(modelElement.equals(actionItem));
		}
	}

	// /**
	// * Opens from the project the WorkPackage with name "Sprint 1" in the status view.
	// */
	// private void showStatusView() {
	// UITestCommon.openView(bot, UNICASE_NODE, NAVIGATOR);
	// bot.sleep(2000);
	//
	// Display.getDefault().syncExec(new Runnable() {
	// public void run() {
	// SWTBotTreeItem projectNode = bot.activeView().bot().tree().getTreeItem("TestProject(Not shared)");
	// SWTBotTreeItem documentNode = projectNode.expand().getNode("Requirements Document");
	// SWTBotTreeItem leafNode = documentNode.expand().getNode("LeafSection");
	// SWTBotTreeItem sprint1Node = leafNode.expand().getNode("Sprint 1");
	// sprint1Node.contextMenu("Show Status").click();
	// }
	// });
	// bot.sleep(2000);
	// }

	// /**
	// * Opens the status view and activates the flat view. Than the ActionItem B will be opened.
	// *
	// * @throws PartInitException will be thrown if the active editor throws an exception
	// */
	// @Test
	// public void statusViewFlatViewTest() throws PartInitException {
	// showStatusView();
	//
	// Display.getDefault().syncExec(new Runnable() {
	// public void run() {
	// SWTBotTabItem tabItemFlatView = bot.activeView().bot().tabItem("Flat view");
	// tabItemFlatView.activate();
	//
	// SWTBotTable table = bot.activeView().bot().table();
	// select(table, "Action B");
	// table.widget.notifyListeners(SWT.DefaultSelection, new Event());
	// }
	// });
	// bot.sleep(2000);
	//
	// // check which element was opened
	// SWTBotEditor activeEditor = bot.activeEditor();
	// IEditorInput editorInput = activeEditor.getReference().getEditorInput();
	// if (editorInput instanceof MEEditorInput) {
	// MEEditorInput meEditorInput = (MEEditorInput) editorInput;
	// EObject modelElement = meEditorInput.getModelElement();
	// assertTrue(modelElement.equals(actionItem));
	// }
	// }
	//
	// /**
	// * Opens the status view and activates the hierachical view. Than the ActionItem B will be opened.
	// *
	// * @throws PartInitException will be thrown if the active editor throws an exception
	// */
	// @Test
	// public void statusViewHierachicalViewTest() throws PartInitException {
	// // don't call the showStatusView() method.
	// // We need the leaf section as basis for the status view and not the WorkPackage status view.
	//
	// UITestCommon.openView(bot, UNICASE_NODE, NAVIGATOR);
	// bot.sleep(2000);
	//
	// // show status for the leaf node
	// Display.getDefault().syncExec(new Runnable() {
	// public void run() {
	// SWTBotTreeItem projectNode = bot.activeView().bot().tree().getTreeItem("TestProject(Not shared)");
	// SWTBotTreeItem documentNode = projectNode.expand().getNode("Requirements Document");
	// SWTBotTreeItem leafNode = documentNode.expand().getNode("LeafSection");
	// leafNode.contextMenu("Show Status").click();
	// }
	// });
	// bot.sleep(2000);
	//
	// Display.getDefault().syncExec(new Runnable() {
	// public void run() {
	// SWTBotTabItem tabItemUsersView = bot.activeView().bot().tabItem("Hierachical view");
	// tabItemUsersView.activate();
	//
	// SWTBotTreeItem nodeWorkPackage = bot.activeView().bot().tree().getTreeItem("Sprint 1");
	// SWTBotTreeItem nodeActionB = nodeWorkPackage.expand().getNode("Action B");
	// nodeActionB.doubleClick();
	// }
	// });
	// bot.sleep(2000);
	//
	// // check which element was opened
	// SWTBotEditor activeEditor = bot.activeEditor();
	// IEditorInput editorInput = activeEditor.getReference().getEditorInput();
	// if (editorInput instanceof MEEditorInput) {
	// MEEditorInput meEditorInput = (MEEditorInput) editorInput;
	// EObject modelElement = meEditorInput.getModelElement();
	// assertTrue(modelElement.equals(actionItem));
	// }
	// }
	//
	// /**
	// * Opens the status view and activates the users view. Than the ActionItem B will be opened.
	// *
	// * @throws PartInitException will be thrown if the active editor throws an exception
	// */
	// @Test
	// public void statusViewUsersViewTest() throws PartInitException {
	// showStatusView();
	//
	// Display.getDefault().syncExec(new Runnable() {
	// public void run() {
	// SWTBotTabItem tabItemUsersView = bot.activeView().bot().tabItem("Users view");
	// tabItemUsersView.activate();
	//
	// SWTBotTreeItem nodeActionItemB = bot.activeView().bot().tree().getTreeItem("Joker").expand().getNode(
	// "Action B");
	// nodeActionItemB.doubleClick();
	// }
	// });
	// bot.sleep(2000);
	//
	// // check which element was opened
	// SWTBotEditor activeEditor = bot.activeEditor();
	// IEditorInput editorInput = activeEditor.getReference().getEditorInput();
	// if (editorInput instanceof MEEditorInput) {
	// MEEditorInput meEditorInput = (MEEditorInput) editorInput;
	// EObject modelElement = meEditorInput.getModelElement();
	// assertTrue(modelElement.equals(actionItem));
	// }
	// }
	//
	// /**
	// * Opens the status view and activates the activity view. Than the ActionItem B will be opened.
	// *
	// * @throws PartInitException will be thrown if the active editor throws an exception
	// */
	// @Test
	// public void statusViewActivityViewTest() throws PartInitException {
	// showStatusView();
	//
	// Display.getDefault().syncExec(new Runnable() {
	// public void run() {
	// SWTBotTabItem tabItemActivityView = bot.activeView().bot().tabItem("Activity view");
	// tabItemActivityView.activate();
	//
	// SWTBotTreeItem nodeImplementation = bot.activeView().bot().tree().getTreeItem("Implementation");
	// SWTBotTreeItem nodeActionItemB = nodeImplementation.expand().getNode("Action B");
	// nodeActionItemB.doubleClick();
	// }
	// });
	// bot.sleep(2000);
	//
	// // check which element was opened
	// SWTBotEditor activeEditor = bot.activeEditor();
	// IEditorInput editorInput = activeEditor.getReference().getEditorInput();
	// if (editorInput instanceof MEEditorInput) {
	// MEEditorInput meEditorInput = (MEEditorInput) editorInput;
	// EObject modelElement = meEditorInput.getModelElement();
	// assertTrue(modelElement.equals(actionItem));
	// }
	// }
}
