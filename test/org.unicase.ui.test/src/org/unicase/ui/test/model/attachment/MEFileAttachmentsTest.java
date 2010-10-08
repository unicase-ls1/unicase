/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.model.attachment;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withRegex;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withTooltip;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.Attachment;
import org.unicase.model.attachment.AttachmentFactory;
import org.unicase.model.attachment.AttachmentPackage;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.MEEditorTest;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * Test cases to verify File attachment functionality.
 * 
 * @author Nitesh
 */
public class MEFileAttachmentsTest extends MEEditorTest {
	private ActionItem actionItem;
	private FileAttachment fileAttachment;
	private File testFile;

	/**
	 * Helper method to setup environment.
	 */
	@Before
	public void setupActionItem() {
		SetupHelper.startSever();
		actionItem = TaskFactory.eINSTANCE.createActionItem();
		actionItem.setName("My ActionItem");
		/**
		 * Unicase command, executes the inclosed statements in UI thread!.
		 */
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getLeafSection().getModelElements().add(actionItem);
				Usersession session = getProjectSpace().getUsersession();
				if (session == null) {
					session = WorkspaceFactory.eINSTANCE.createUsersession();
				}
				ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
				serverInfo.setPort(1099);
				serverInfo.setUrl("localhost");
				serverInfo.setCertificateAlias("unicase.org test test(!!!) certificate");
				session.setServerInfo(serverInfo);
				session.setUsername("super");
				session.setPassword("super");
				try {
					getProjectSpace().shareProject(session);
				} catch (EmfStoreException e) {
					e.printStackTrace();
				}
				fileAttachment = AttachmentFactory.eINSTANCE.createFileAttachment();
				fileAttachment.setName("Test the file attachment");
				ModelUtil.getProject(actionItem).addModelElement(fileAttachment);
			}
		}.run();

	}

	/**
	 * Create a dummy file attachment and see if the attachment works fine. Can be extended to commit the attachment in
	 * server and retrieve it.
	 * 
	 * @throws IOException Exception can be thrown while creating dummy attachment file.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void attachedFileTest() throws IOException {

		UITestCommon.openPerspective(getBot(), "Unicase");
		openModelElement(actionItem);
		final String aiName = getBot().activeEditor().bot().textWithLabel("Name").getText();
		openModelElement(fileAttachment);

		// Time to add this fileAttachment to the ActioItem.
		final String attachment = "Test the file attachment";
		UnicaseCommand addFileAttachment = new UnicaseCommand() {
			@Override
			protected void doRun() {
				EList<Attachment> listOfAttachments = ModelUtil.getProject(actionItem).getModelElementsByClass(
					AttachmentPackage.eINSTANCE.getFileAttachment(), new BasicEList<Attachment>());
				for (Attachment l : listOfAttachments) {
					if (l.getName().equals(attachment)) {
						actionItem.getAttachments().add(l);

					}
				}
			}
		};
		runAsnc(addFileAttachment);

		// Test the UI for being updated!
		UnicaseCommandWithResult<Matcher> refferingMEForAttachment = new UnicaseCommandWithResult<Matcher>() {
			@Override
			protected Matcher doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip(aiName));
				return matchwidget;
			}
		};
		Matcher widgetmatcher = runAsnc(refferingMEForAttachment);
		final List widgetcontrol = getBot().getFinder().findControls(widgetmatcher);
		String refferingElement = ((Hyperlink) widgetcontrol.get(0)).getText();
		if (!(refferingElement == null)) {
			assertEquals(aiName, refferingElement);
		} else {
			fail();
		}

		// creating a dummy file :)
		String dummyText = "This is the dummy file \n" + " with some text \n" + " to test file Attachments in UNICASE.";
		char[] buffer = new char[dummyText.length()];
		testFile = new File("test-file.txt");
		dummyText.getChars(0, dummyText.length(), buffer, 0);
		FileWriter fileWriter = new FileWriter(testFile);
		for (int i = 0; i < buffer.length; i++) {
			fileWriter.write(buffer[i]);
		}
		fileWriter.close();

		// Time to add the actual file in the fileAttachment and observe the effects :)
		UnicaseCommand attachAFile = new UnicaseCommand() {

			@Override
			protected void doRun() {
				FileInformation something = new FileInformation();
				something.setFileVersion(-1);
				something.setFileName(testFile.getName());
				something.setFileAttachmentId((fileAttachment).getFileID());
				// adding a pending file request!
				try {
					WorkspaceManager.getProjectSpace(fileAttachment).addFileTransfer(something, testFile, true, true);
				} catch (FileTransferException e) {
					e.printStackTrace();
				}

				fileAttachment.setFileID(something.getFileIdentifier());
				fileAttachment.setFileName(something.getFileName());
				fileAttachment.setFileSize(something.getFileSize());

			}
		};
		runAsnc(attachAFile);

		// Check the UI if the file-name is reflected!
		UnicaseCommand someCommand = new UnicaseCommand() {

			@Override
			protected void doRun() {
				Matcher matchwidget = allOf(widgetOfType(Widget.class), withRegex(testFile.getName()));
				final List widgetList = getBot().getFinder().findControls(matchwidget);

				String fileNameLinkText = ((Link) widgetList.get(0)).getText();
				if (!(fileNameLinkText == null)) {
					assertEquals("<a>" + testFile.getName() + "</a>", fileNameLinkText);
				} else {
					fail();
				}
			}
		};
		runAsnc(someCommand);
		getBot().sleep(2000);
	}

	/**
	 * Stop the server and delete the dummy file attachment.
	 */
	@After
	public void setupRollBack() {
		SetupHelper.stopServer();
		if (testFile.exists()) {
			testFile.delete();
		}
	}

}
