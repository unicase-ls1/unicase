/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.ContributionManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.services.IEvaluationService;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Comment;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.meeditor.Activator;
import org.unicase.ui.unicasecommon.util.OrgUnitHelper;
import org.unicase.ui.unicasecommon.widgets.MECommentReplyWidget;
import org.unicase.ui.unicasecommon.widgets.MECommentWidget;
import org.unicase.ui.unicasecommon.widgets.MECommentWidgetListener;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * The editor page for the comment thread.
 * 
 * @author shterev
 */
public class METhreadPage extends FormPage implements MECommentWidgetListener {

	private UnicaseModelElement modelElement;
	private FormToolkit toolkit;

	private static String activeModelelement = "activeModelelement";
	private ScrolledForm form;
	private Composite body;
	private Composite inputComposite;
	private MECommentReplyWidget inputEntry;
	private boolean toggleReply = true;
	private User currentUser;

	/**
	 * Default constructor.
	 * 
	 * @param editor the {@link MEEditor}
	 * @param id the {@link FormPage#id}
	 * @param title the title
	 * @param editingDomain the editingDomain
	 * @param modelElement the modelElement
	 */
	public METhreadPage(MEEditor editor, String id, String title, EditingDomain editingDomain,
		UnicaseModelElement modelElement) {
		super(editor, id, title);
		this.modelElement = modelElement;
		try {
			currentUser = OrgUnitHelper.getUser(WorkspaceManager.getProjectSpace(modelElement));
		} catch (NoCurrentUserException e1) {
			return;
		} catch (CannotMatchUserInProjectException e1) {
			return;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);

		toolkit = this.getEditor().getToolkit();
		form = managedForm.getForm();
		toolkit.decorateFormHeading(form.getForm());
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(form.getBody());
		form.setImage(Activator.getImageDescriptor("icons/comments.png").createImage());
		form.setText(getEditor().getTitle() + ": Discussion");
		form.getBody().setBackgroundMode(SWT.INHERIT_FORCE);
		form.getBody().setBackground(new Color(Display.getCurrent(), 225, 225, 225));
		createToolbar();
		createWidget();
		form.pack();
	}

	private void createWidget() {
		if (body != null) {
			body.dispose();
		}
		body = new Composite(form.getBody(), SWT.NONE);
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(body);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, true).applyTo(body);

		inputComposite = new Composite(body, SWT.NONE);
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(inputComposite);
		GridDataFactory.fillDefaults().grab(true, false).hint(-1, 0).applyTo(inputComposite);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				List<Comment> comments = modelElement.getComments();
				for (Comment c : comments) {
					MECommentWidget widget = new MECommentWidget(c, body);
					widget.addCommentWidgetListener(METhreadPage.this);
					GridDataFactory.fillDefaults().grab(true, false).applyTo(widget);
				}
			}
		}.run();
	}

	private void createToolbar() {
		IMenuService menuService = (IMenuService) PlatformUI.getWorkbench().getService(IMenuService.class);
		ISourceProvider sourceProvider = new AbstractSourceProvider() {
			public void dispose() {
			}

			@SuppressWarnings("unchecked")
			public Map getCurrentState() {
				HashMap<Object, Object> map = new HashMap<Object, Object>();
				map.put(activeModelelement, modelElement);
				return map;
			}

			public String[] getProvidedSourceNames() {
				String[] namens = new String[1];
				namens[0] = activeModelelement;
				return namens;
			}

		};

		IEvaluationService service = (IEvaluationService) PlatformUI.getWorkbench()
			.getService(IEvaluationService.class);
		service.addSourceProvider(sourceProvider);
		menuService.populateContributionManager((ContributionManager) form.getToolBarManager(),
			"toolbar:org.unicase.ui.meeditor.METhreadPage");
		form.getToolBarManager().update(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	/**
	 * {@inheritDoc} This method is added to solve the focus bug of navigator. Every time that a ME is opened in editor,
	 * navigator has to lose focus so that its action contributions are set correctly for next time.
	 */
	@Override
	public void setFocus() {
		super.setFocus();
	}

	/**
	 * @see org.org.unicase.ui.unicasecommon.widgets.MECommentWidgetListener#commentLayoutUpdated()
	 */
	public void commentLayoutUpdated() {
		form.layout();
		form.reflow(true);
	}

	/**
	 * {@inheritDoc}
	 */
	public void commentAdded(Comment newComment) {
		toggleReply = true;
		createWidget();
		commentLayoutUpdated();
	}

	/**
	 * @see org.org.unicase.ui.unicasecommon.widgets.MECommentWidgetListener#commentInputClosed()
	 */
	public void commentInputClosed() {
		inputEntry.dispose();
		GridDataFactory.fillDefaults().grab(true, false).hint(-1, 0).applyTo(inputComposite);
		toggleReply = true;
		commentLayoutUpdated();
	}

	/**
	 * Add a root comment input entry to the thread.
	 */
	public void addComment() {
		if (!toggleReply && currentUser == null) {
			return;
		}
		inputEntry = new MECommentReplyWidget(modelElement, inputComposite, currentUser);
		inputEntry.addCommentWidgetListener(this);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(inputEntry);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(inputComposite);
		toggleReply = false;
		commentLayoutUpdated();
	}
}