/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.test.diagram;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unicase.ui.test.UITestCommon;
import org.unicase.workspace.test.SetupHelper;

@RunWith(SWTBotJunit4ClassRunner.class)
public class DiagramTest {

    private static SWTWorkbenchBot bot;
 
    private static final String NAVIGATOR = "Unicase Navigator";
    private static final String GENERAL_NODE = "General";
    private static final String UNICASE_NODE = "Unicase";
    private static final String PALETTE = "Palette";
    
   

    @BeforeClass
    public static void beforeClass() throws Exception {
        bot = new SWTWorkbenchBot();
        bot.viewByTitle("Welcome").close();
        SetupHelper.startSever();

    }

    @Test
    public void testDiagram() throws Exception {
        
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

    @AfterClass
    public static void sleep() {
        bot.sleep(20000);
    }

}