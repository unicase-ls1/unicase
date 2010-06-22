/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.meeditor;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.unicase.ecpemfstorebridge.EMFStoreModelelementContext;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Parent class for all the UI Test cases involving MEEDitor. Contains all the helper and setup method. This class
 * creates an environment before test cases run and finally tear it down.
 * 
 * @author Nitesh
 */
public class MEEditorTest {
	/**
	 * Run command in UI Thread.
	 * 
	 * @author Nitesh
	 * @param <T>
	 */
	private final class RunnableWithType<T> implements Runnable {
		private final UnicaseCommandWithResult<T> command;
		private T result;

		private RunnableWithType(UnicaseCommandWithResult<T> command) {
			this.command = command;
		}

		/**
		 * @return the result
		 */
		public T getResult() {
			return result;
		}

		public void run() {
			result = command.run();
		}
	}

	private ProjectSpace projectSpace;
	private LeafSection leafSection;

	/**
	 * @return the projectSpace
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	/**
	 * @return the leafSection
	 */
	public LeafSection getLeafSection() {
		return leafSection;
	}

	/**
	 * @return the bot
	 */
	public static SWTWorkbenchBot getBot() {
		return bot;
	}

	private static SWTWorkbenchBot bot;
	private static boolean runcount;

	/**
	 * Public constructor.
	 */
	public MEEditorTest() {
		super();
	}

	/**
	 * Closes the welcome screen and initializes the environment. Deletes the existing test workspace, if any.
	 * 
	 * @throws IOException deleting existing test workspace failed
	 */
	@BeforeClass
	public static void setupClass() throws IOException {
		bot = new SWTWorkbenchBot();

		if (!runcount) {
			getBot().viewByTitle("Welcome").close();
			runcount = true;
		}
		WorkspaceUtil.deleteTestWorkspace();
		Configuration.setTesting(true);
		WorkspaceManager.getInstance();
	}

	/**
	 * Create a project "TestProject" in the workspace and add a composite and a leaf section.
	 */
	@Before
	public void setup() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				projectSpace = currentWorkspace.createLocalProject("TestProject", "Test Description");
				Project project = projectSpace.getProject();
				CompositeSection document = DocumentFactory.eINSTANCE.createCompositeSection();
				document.setName("Requirements Document");
				project.addModelElement(document);
				leafSection = DocumentFactory.eINSTANCE.createLeafSection();
				leafSection.setName("LeafSection");
				document.getSubsections().add(leafSection);
			}
		}.run();
	}

	/**
	 * Tear down the whole test environment by deleting the projectspace.
	 */
	@After
	public void tearDown() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				try {
					currentWorkspace.deleteProjectSpace(projectSpace);
				} catch (IOException e) {
					fail();
				}
			}
		}.run();
	}

	/**
	 * Open the model element available in project.
	 * 
	 * @param element modelelement to be opened.
	 */
	protected void openModelElement(final ModelElement element) {
		Display.getDefault().asyncExec(new Runnable() {

			@SuppressWarnings("deprecation")
			public void run() {
				ActionHelper.openModelElement(element, "test", new EMFStoreModelelementContext(element));
			}
		});
		bot.sleep(4000);
	}

	/**
	 * Run the command in UI thread without result.
	 * 
	 * @param command command to be executed
	 */
	protected void runAsnc(final UnicaseCommand command) {
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				command.run();
			}
		});

		bot.sleep(4000);
	}

	/**
	 * Run the command in UI thread with result.
	 * 
	 * @param <T> type
	 * @param command command to be executed
	 * @return result
	 */
	protected <T> T runAsnc(final UnicaseCommandWithResult<T> command) {
		RunnableWithType<T> runnable = new RunnableWithType<T>(command);
		Display.getDefault().asyncExec(runnable);

		bot.sleep(4000);
		return runnable.getResult();
	}

	/**
	 * Delete test workspace completely.
	 * 
	 * @throws IOException exception while deleting workspace
	 */
	@AfterClass
	public static void tearDownClass() throws IOException {
		bot = null;
		WorkspaceUtil.deleteTestWorkspace();
	}

}