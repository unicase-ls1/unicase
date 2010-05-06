/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.test.navigator;

import java.io.IOException;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;
import org.unicase.workspace.util.WorkspaceUtil;

public class NavigatorControlTest {
		
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

		public NavigatorControlTest() {
			super();
		}
		
		public static SWTWorkbenchBot getBot() {
			return bot;
		}

		private static SWTWorkbenchBot bot;
		private static boolean runcount ;
		
		@BeforeClass
		public static void setupClass() throws IOException {
			bot = new SWTWorkbenchBot();
			
			if(!runcount){
				getBot().viewByTitle("Welcome").close();
				runcount = true;
			}
			WorkspaceUtil.deleteTestWorkspace();
			Configuration.setTesting(true);
			WorkspaceManager.getInstance();
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
		
		protected <T> T runAsnc(final UnicaseCommandWithResult<T> command) {
			RunnableWithType<T> runnable = new RunnableWithType<T>(command);
			Display.getDefault().asyncExec(runnable);
					
			bot.sleep(4000);
			return runnable.getResult();
		}

		@AfterClass
		public static void tearDownClass() throws IOException {
			bot = null;
			WorkspaceUtil.deleteTestWorkspace();
		}
		
	}



