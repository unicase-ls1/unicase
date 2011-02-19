/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.test.others;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.ui.IEditorInput;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.bug.BugReport;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.provider.ActionItemItemProvider;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.UITestSetup;
import org.unicase.workspace.util.UnicaseCommand;

public class AdapterFactoryLabelProviderDisposeTest extends UITestSetup {

	private ActionItem actionItem;
	private BugReport bugReport;

	/**
	 * Setup the environment for testing.
	 */
	@Before
	public void setupActionItem() {

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("Do some work today!");
				bugReport = BugFactory.eINSTANCE.createBugReport();
				bugReport.setName("Big nasty bug!");
				getLeafSection().getModelElements().add(actionItem);
				getLeafSection().getModelElements().add(bugReport);

				// link bugreport to actionItem or vice versa
				List<Object> data = new ArrayList<Object>();
				data.add(bugReport);
				actionItem.eSet(bugReport.eClass().getEStructuralFeature("successors"), data);
			}

		}.run();
	}

	/**
	 * Test if the editor gets closed in a case if the ME is deleted. Test whether ActionItemItemProvider and Actionitem
	 * (ActionItemImpl) are disposed when closing MEEditorInput.
	 */
	@Test
	public void DisposeTestByClosineME() {

		IEditorInput editorInput = null;
		LinkedList<ActionItemItemProvider> actionItemProviders = new LinkedList<ActionItemItemProvider>();
		LinkedList<ActionItemItemProvider> actionItemProvidersBeforeOpen = new LinkedList<ActionItemItemProvider>();
		UITestCommon.openPerspective(getBot(), "Unicase");

		// collect actionitem from actionitem before open
		bugReport.eAdapters();
		for (Adapter adapter : actionItem.eAdapters()) {
			if (adapter instanceof ActionItemItemProvider && adapter.getTarget() == actionItem) {
				actionItemProvidersBeforeOpen.add((ActionItemItemProvider) adapter);
			}
		}
		openModelElement(actionItem);

		/*
		 * When open a actionItem there is more than one ActionItemItemProvider with a reference to an ActionItem?!!??
		 */
		// collect all ActionItemItemProvider from actionItem:
		for (Adapter adapter : actionItem.eAdapters()) {
			if (adapter instanceof ActionItemItemProvider && adapter.getTarget() == actionItem) {
				if (!actionItemProvidersBeforeOpen.contains(adapter))
					actionItemProviders.add((ActionItemItemProvider) adapter);
			}
		}

		/*
		 * try { editorInput = getBot().activeEditor().getReference().getEditorInput(); } catch (PartInitException e) {
		 * } DecoratingLabelProvider decoratingLabelProvider = ((MEEditorInput) editorInput).getLabelProvider();
		 * AdapterFactoryLabelProvider labelProvider = (AdapterFactoryLabelProvider) decoratingLabelProvider
		 * .getLabelProvider(); ComposedAdapterFactory adapterFactory = (ComposedAdapterFactory)
		 * labelProvider.getAdapterFactory();
		 */

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}

		getBot().activeEditor().close();

		/*
		 * After closing there must be one ActionItemItemProvider disposed at least. Therefore we have to find one
		 * ActionItemItemProvider that is not referenced by actionItem.eAdapters() . And this instance of
		 * ActionItemItemProvider mustn't have a reference to the Actionitem.
		 */

		boolean oneActionItemProviderDisposed = false;
		for (ActionItemItemProvider itemprovider : actionItemProviders) {
			if (!actionItem.eAdapters().contains(itemprovider)) {
				oneActionItemProviderDisposed = true;
				assertTrue(itemprovider.getTarget() == null);
				break;
			}
		}
		assertTrue(oneActionItemProviderDisposed);

	}
}
