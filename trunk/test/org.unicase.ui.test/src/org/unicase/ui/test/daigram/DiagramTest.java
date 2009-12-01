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

@RunWith(SWTBotJunit4ClassRunner.class)
public class DiagramTest {

    private static SWTWorkbenchBot bot;
    private static final String BROWSER = "EmfStore Browser";
    private static final String NAVIGATOR = "Unicase Navigator";
   

    @BeforeClass
    public static void beforeClass() throws Exception {
        bot = new SWTWorkbenchBot();
        bot.viewByTitle("Welcome").close();
        SetupHelper.startSever();

    }

    @Test
    public void testDiagram() throws Exception {
        
        DiagramTestCommon.openView(bot, BROWSER);
        DiagramTestCommon.openView(bot, NAVIGATOR);
        
        SWTBotView viewById = bot.activeView();
        SWTBotTreeItem[] items = viewById.bot().tree().getAllItems();
        SWTBotTreeItem[] subitem = items[0].expand().getItems();
        items = subitem[0].expand().getItems();
        subitem = items[3].expand().getItems();
        subitem[0].doubleClick();

        bot.menu("Window").menu("Show View").menu("Other...").click();
        SWTBotShell shell3 = bot.shell("Show View");
        shell3.activate();
        bot.tree().expandNode("General").select("Palette");
        bot.button("OK").click();
        bot.sleep(20000);
        viewById = bot.activeView();

    }

    @AfterClass
    public static void sleep() {
        bot.sleep(20000);
    }

}