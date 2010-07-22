/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.navigator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unicase.metamodel.Project;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.util.UnicaseCommand;

public class UpdateProjectUITest extends MEEditorTest {
	/**
	 * Setup the environment for testing.
	 */

	@BeforeClass
	public static void beforeClass() throws Exception {

		SetupHelper.startSever();

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				ProjectSpace ps = currentWorkspace.getActiveProjectSpace();
				Project project = ps.getProject();
				CompositeSection document = DocumentFactory.eINSTANCE.createCompositeSection();
				document.setName("Requirements Document");
				project.addModelElement(document);
				LeafSection ls = DocumentFactory.eINSTANCE.createLeafSection();
				ls.setName("dodo");
				document.getSubsections().add(ls);
			}
		}.run();
	}

	/**
	 * Create a project "TestProject" in the workspace and add a composite and a leaf section.
	 */

	@Test
	public void updateProjectUpdate() {

		UITestCommon.openPerspective(getBot(), "Unicase");

		/*
		 * new UnicaseCommand() {
		 * @Override protected void doRun() { } }.run();
		 */
		UITestCommon.openView(getBot(), "Unicase", "Unicase Navigator");

		getBot().sleep(100000);

	}

	@Test
	public void updateProjectChange() {

	}

	@AfterClass
	public static void afterClass() {
		SetupHelper.stopServer();

	}
}
