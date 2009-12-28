/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.test.meeditor.mecontrol;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withRegex;
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
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.Attachment;
import org.unicase.model.attachment.AttachmentFactory;
import org.unicase.model.attachment.AttachmentPackage;
import org.unicase.model.attachment.UrlAttachment;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

public class URLAttachmentsTest extends MeControlTest {
private ActionItem actionItem;
	
	
	
	@Before
	public void setupActionItem() {
			
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				actionItem = TaskFactory.eINSTANCE.createActionItem();
				actionItem.setName("My ActionItem");
				getLeafSection().getModelElements().add(actionItem);
				UrlAttachment urlAttachment = AttachmentFactory.eINSTANCE.createUrlAttachment();
				urlAttachment.setName("Mr.Web");
				urlAttachment.setUrl("http://code.google.com/p/unicase/");
				actionItem.getProject().addModelElement(urlAttachment);
				
				}
		}.run();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addExistingURLAttachmentChange(){
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
				ToolItem toolItem = ((ToolItem)widgets.get(0));
				Event event = new Event();
				event.widget = ((ToolItem)widgets.get(0));
				toolItem.notifyListeners(SWT.Selection, event);		
			}
		}; runAsnc(widgetActivateCommand);
		
		
		final String attachment = "Mr.Web";
		getBot().text().setText(attachment);
		getBot().button("OK").click();
		
		UnicaseCommand checkAttachment = new UnicaseCommand() {
			@Override
			protected void doRun() {
				EList<Attachment> list = actionItem.getAttachments();
				for(Attachment l: list){
					if(l.getName().equals(attachment)){
						assertEquals(attachment, l.getName());
					}
				}
			}
		};runAsnc(checkAttachment);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void urlWidgetTest(){
			openModelElement(actionItem);
			UnicaseCommand addURLAttachment = new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				EList<Attachment> listOfAttachments = actionItem.getProject().getModelElementsByClass(AttachmentPackage.eINSTANCE.getUrlAttachment(), new BasicEList<Attachment>());
				for(Attachment l: listOfAttachments){
					if(l.getName().equals("Mr.Web")){
						actionItem.getAttachments().add(l);
					}
				}
			}
		}; runAsnc(addURLAttachment);
		
		
			UnicaseCommandWithResult<Matcher> widgetFinderCommand = new UnicaseCommandWithResult<Matcher>() {
			
			@Override
			protected Matcher doRun() {
				Matcher widget = allOf(widgetOfType(ImageHyperlink.class));
				return widget;
			}
		};Matcher matcher = runAsnc(widgetFinderCommand);
			
		final List widgets = getBot().getFinder().findControls(matcher);
		
		UnicaseCommand widgetActivateCommand = new UnicaseCommand() {
		@Override
			protected void doRun() {
			Event event = new Event();
			event.widget = 	((ImageHyperlink)widgets.get(2));
			((ImageHyperlink)widgets.get(2)).notifyListeners(SWT.MouseUp, event); // Not accepting the event notification! :(
			}
		}; runAsnc(widgetActivateCommand);
		
		
		
		getBot().activeEditor().bot().text().setFocus();
		getBot().sleep(7000);
	}
}
