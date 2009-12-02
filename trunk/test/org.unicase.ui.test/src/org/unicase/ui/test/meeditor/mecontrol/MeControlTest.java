/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.test.meeditor.mecontrol;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.eclipse.core.internal.dtree.TestHelper;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.ui.internal.ide.dialogs.CreateLinkedResourceGroup;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.UiUtil;
import org.unicase.ui.meeditor.commands.OpenModelElementHandler;
import org.unicase.ui.test.UITestCommon;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

public class MeControlTest {

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
	private static boolean runcount = false;

	public MeControlTest() {
		super();
	}
	
	@BeforeClass
	public static void setupClass() {
		bot = new SWTWorkbenchBot();
		
		if(!runcount){
			getBot().viewByTitle("Welcome").close();
			runcount = true;
		}
		WorkspaceManager.getInstance();
	}
	
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
	
	protected void openModelElement(final ModelElement element) {
		Display.getDefault().asyncExec(new Runnable() {
			
			public void run() {
				ActionHelper.openModelElement(element, "test");
			}
		});
		bot.sleep(4000);
	}
	
	protected void runAsnc(final UnicaseCommand command) {
		Display.getDefault().asyncExec(new Runnable() {
			
			public void run() {
				command.run();
			}
		});
		
		bot.sleep(4000);
	}

	@AfterClass
	public static void tearDownClass() {
		bot = null;
	}
	
}