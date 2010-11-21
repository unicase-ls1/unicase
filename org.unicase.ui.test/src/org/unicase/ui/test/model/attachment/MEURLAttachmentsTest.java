/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.test.model.attachment;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withTooltip;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.Attachment;
import org.unicase.model.attachment.AttachmentFactory;
import org.unicase.model.attachment.AttachmentPackage;
import org.unicase.model.attachment.UrlAttachment;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * Tes the URL attachment for ME's.
 * 
 * @author Nitesh
 */
public class MEURLAttachmentsTest extends MEEditorTest {
	private ActionItem actionItem;
	private UrlAttachment urlAttachment;

	/**
	 * Helper method to create some pre-requiste ME's.
	 */
	@Before
	public void setupActionItem() {

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("My ActionItem");
				getLeafSection().getModelElements().add(actionItem);
				urlAttachment = AttachmentFactory.eINSTANCE.createUrlAttachment();
				urlAttachment.setName("Mr.Web");
				urlAttachment.setUrl("http://code.google.com/p/unicase/");
				actionItem.getProject().addModelElement(urlAttachment);

			}
		}.run();
	}

	/**
	 * Add an existing URLattachment(existing in project) to a ME from UI and see if the changes are persisted.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void addExistingURLAttachmentChange() {
		openModelElement(actionItem);
		UnicaseCommandWithResult<Matcher> widgetFinderCommand = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher widget = allOf(widgetOfType(Widget.class), withTooltip("Link Attachment"));
				return widget;
			}
		};
		Matcher matcher = runAsnc(widgetFinderCommand);
		final List widgets = getBot().getFinder().findControls(matcher);

		UnicaseCommand widgetActivateCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {
				ToolItem toolItem = ((ToolItem) widgets.get(0));
				Event event = new Event();
				event.widget = ((ToolItem) widgets.get(0));
				toolItem.notifyListeners(SWT.Selection, event);
			}
		};
		runAsnc(widgetActivateCommand);

		final String attachment = "Mr.Web";
		getBot().text().setText(attachment);
		getBot().button("OK").click();

		UnicaseCommand checkAttachment = new UnicaseCommand() {
			@Override
			protected void doRun() {
				EList<Attachment> list = actionItem.getAttachments();
				for (Attachment l : list) {
					if (l.getName().equals(attachment)) {
						assertEquals(attachment, l.getName());
					}
				}
			}
		};
		runAsnc(checkAttachment);
	}

	/**
	 * Add an URLattachment from UI and then checks if UI repsonse is as expected.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void urlAttachmentTest() {
		openModelElement(actionItem);

		final String elementWithAttachment = getBot().activeEditor().bot().textWithLabel("Name").getText();
		UnicaseCommandWithResult<Matcher> attachmentWidgetFinder = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip("Create and link new Attachment"));
				return matchwidget;
			}
		};
		Matcher matcher = runAsnc(attachmentWidgetFinder);
		final List widgetcontrol = getBot().getFinder().findControls(matcher);

		UnicaseCommand widgetActivateCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {
				ToolItem toolItem = ((ToolItem) widgetcontrol.get(0));
				Event event = new Event();
				event.widget = ((ToolItem) widgetcontrol.get(0));
				toolItem.notifyListeners(SWT.Selection, event);
			}
		};
		runAsnc(widgetActivateCommand);

		String attach = "UrlAttachment";
		getBot().text().setText(attach);
		getBot().button("OK").click();
		getBot().sleep(2000);
		final String attachmentName = "Unicase attachment";
		getBot().activeEditor().bot().textWithLabel("Name").typeText(attachmentName, 2);
		getBot().activeEditor().bot().styledTextWithLabel("Description").typeText(
			"This is a testing or URL Attachment.");
		getBot().activeEditor().bot().button().click();
		final String attachURL = "http://code.google.com/p/unicase";
		getBot().text().setText(attachURL);
		getBot().button("OK").click();

		UnicaseCommandWithResult<Matcher> refferingElementFinder = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip(elementWithAttachment));
				return matchwidget;
			}
		};
		Matcher refferingLinkmatcher = runAsnc(refferingElementFinder);
		final List list = getBot().getFinder().findControls(refferingLinkmatcher);
		String refferingElement = ((Hyperlink) list.get(0)).getText();
		assertEquals(elementWithAttachment, refferingElement);
		getBot().activeEditor().close();
		getBot().activeEditor().setFocus();

		UnicaseCommandWithResult<Matcher> attachedElementFinder = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher widget = allOf(widgetOfType(Widget.class), withTooltip(attachmentName));
				return widget;
			}
		};
		Matcher attachmentLinkmatcher = runAsnc(attachedElementFinder);
		final List hyperlinkList = getBot().getFinder().findControls(attachmentLinkmatcher);
		String attachedElement = ((Hyperlink) hyperlinkList.get(0)).getText();
		assertEquals(attachmentName, attachedElement);

	}

	/**
	 * Change the URL in the existing attachment from UI.
	 */
	@Test
	public void attachedURLChangeTest() {
		openModelElement(actionItem);
		final String attachment = "Mr.Web";
		UnicaseCommand addURLAttachment = new UnicaseCommand() {

			@Override
			protected void doRun() {
				EList<Attachment> listOfAttachments = actionItem.getProject().getModelElementsByClass(
					AttachmentPackage.eINSTANCE.getUrlAttachment(), new BasicEList<Attachment>());
				for (Attachment l : listOfAttachments) {
					if (l.getName().equals(attachment)) {
						actionItem.getAttachments().add(l);
					}
				}
			}
		};
		runAsnc(addURLAttachment);

		openModelElement(urlAttachment);
		getBot().activeEditor().bot().button().click();
		final String attachURL = "http://www.unicase.org";
		getBot().text().setText(attachURL);
		getBot().button("OK").click();

		UnicaseCommand checkAttachmentURL = new UnicaseCommand() {
			@Override
			protected void doRun() {
				EList<Attachment> list = actionItem.getAttachments();
				for (Attachment l : list) {
					if (l.getName().equals(attachment)) {
						assertEquals(attachURL, ((UrlAttachment) l).getUrl());
					}
				}
			}
		};
		runAsnc(checkAttachmentURL);
	}

	/**
	 * Change the URL programattically and see if the changes are reflected in UI.
	 */
	@Test
	public void attachedURLUpdateTest() {
		openModelElement(actionItem);
		openModelElement(urlAttachment);
		getBot().activeEditor().bot().button().click();
		final String previuosURL = getBot().text().getText();
		getBot().button("Cancel").click();
		final String attachment = "Mr.Web";
		final String newURL = "http://www.testall-UI.org";

		UnicaseCommand addURLAttachment = new UnicaseCommand() {
			@Override
			protected void doRun() {
				EList<Attachment> listOfAttachments = actionItem.getProject().getModelElementsByClass(
					AttachmentPackage.eINSTANCE.getUrlAttachment(), new BasicEList<Attachment>());
				for (Attachment l : listOfAttachments) {
					if (l.getName().equals(attachment)) {
						actionItem.getAttachments().add(l);
						assertEquals(previuosURL, ((UrlAttachment) l).getUrl());
						((UrlAttachment) l).setUrl(newURL);

					}
				}
			}
		};
		runAsnc(addURLAttachment);

		getBot().activeEditor().bot().button().click();
		String tempURL = getBot().text().getText();
		getBot().button("Cancel").click();
		assertEquals(newURL, tempURL);

	}

}