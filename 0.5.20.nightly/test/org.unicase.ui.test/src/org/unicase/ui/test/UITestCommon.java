/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

public class UITestCommon {
	

	public static void openView(SWTWorkbenchBot bot, String node, String view){
	
		
		bot.menu("Window").menu("Show View").menu("Other...").click();
        SWTBotShell shell1 = bot.shell("Show View");
        shell1.activate();
        bot.tree().expandNode(node).select(view);
        bot.button("OK").click();

	}
	
	
	public static void openPerspective(SWTWorkbenchBot bot, String perspective){
		
		
		bot.menu("Window").menu("Open Perspective").menu("Other...").click();
		SWTBotShell openPerspectiveShell = bot.shell("Open Perspective");
		openPerspectiveShell.activate();
		bot.table().select(perspective);
		bot.button("OK").click();

	}
	

}
