/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.test.daigram;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unicase.workspace.test.SetupHelper;

public class DiagramTestCommon {
	
	private static SWTWorkbenchBot bot;
	private static String view;

	public static void openView(SWTWorkbenchBot bot, String view){
		
		DiagramTestCommon.bot = bot;
		DiagramTestCommon.view = view;
		
		bot.menu("Window").menu("Show View").menu("Other...").click();
        SWTBotShell shell1 = bot.shell("Show View");
        shell1.activate();
        bot.tree().expandNode("Unicase").select(view);
        bot.button("OK").click();

	}
	

}
