/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.test.diagram;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unicase.ui.test.UITestCommon;

/**
 * Test the GMF diagrams.
 * 
 * @author Nitesh
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DiagramTest {

	private static SWTWorkbenchBot bot;

	private static final String NAVIGATOR = "Unicase Navigator";
	private static final String GENERAL_NODE = "General";
	private static final String UNICASE_NODE = "Unicase";
	private static final String PALETTE = "Palette";

	/**
	 * Helper method to close the welcome screen.
	 */
	@BeforeClass
	public static void beforeClass() {
		bot = new SWTWorkbenchBot();
		bot.viewByTitle("Welcome").close();
	}

	/**
	 * Test the diagram by opening it.
	 */
	@Test
	public void testDiagram() {

		UITestCommon.openPerspective(bot, UNICASE_NODE);
		UITestCommon.openView(bot, UNICASE_NODE, NAVIGATOR);

		SWTBotView viewById = bot.activeView();
		SWTBotTreeItem[] items = viewById.bot().tree().getAllItems();
		SWTBotTreeItem[] subitem = items[0].expand().getItems();
		items = subitem[0].expand().getItems();
		subitem = items[3].expand().getItems();
		subitem[0].doubleClick();

		UITestCommon.openView(bot, GENERAL_NODE, PALETTE);

		bot.sleep(20000);
		viewById = bot.activeView();

	}

}