/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.utilities.CannotMatchUserInProjectException;
import org.eclipse.emf.ecp.editor.AbstractMEEditorPage;
import org.eclipse.emf.ecp.editor.MEEditor;
import org.eclipse.emf.ecp.editor.MEFormPage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.exceptions.NoCurrentUserException;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
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
import org.unicase.ui.unicasecommon.Activator;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.ui.unicasecommon.common.widgets.MECommentReplyWidget;
import org.unicase.ui.unicasecommon.common.widgets.MECommentWidget;
import org.unicase.ui.unicasecommon.common.widgets.MECommentWidgetListener;

/**
 * The editor page for the comment thread.
 * 
 * @author shterev
 */
public class METhreadPage extends AbstractMEEditorPage implements MECommentWidgetListener {
	private static final String ID = "org.unicase.ui.unicasecommon.meeditor.methreadpage";
	private static final String NAME = "Discussion";
	private EObject modelElement;
	private FormToolkit toolkit;

	private static String activeModelelement = "activeModelelement";
	private ScrolledForm form;
	private Composite body;
	private Composite inputComposite;
	private MECommentReplyWidget inputEntry;
	private boolean toggleReply = true;
	private User currentUser;

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

		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				List<Comment> comments = ((UnicaseModelElement) modelElement).getComments();
				for (Comment c : comments) {
					MECommentWidget widget = new MECommentWidget(c, body);
					widget.addCommentWidgetListener(METhreadPage.this);
					GridDataFactory.fillDefaults().grab(true, false).applyTo(widget);
				}
			}
		}.run(false);
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
			"toolbar:org.eclipse.emf.ecp.editor.METhreadPage");
		form.getToolBarManager().update(true);
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
		inputEntry = new MECommentReplyWidget((UnicaseModelElement) modelElement, inputComposite, currentUser);
		inputEntry.addCommentWidgetListener(this);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(inputEntry);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(inputComposite);
		toggleReply = false;
		commentLayoutUpdated();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.meeditor.AbstractMEEditorPage#createPage(org.unicase.ui.meeditor.MEEditor,
	 *      org.eclipse.emf.edit.domain.EditingDomain, org.unicase.metamodel.ModelElement)
	 */
	@Override
	public FormPage createPage(MEEditor editor, EditingDomain editingDomain, EObject modelElement) {
		this.modelElement = modelElement;
		try {
			currentUser = OrgUnitHelper.getUser(WorkspaceManager.getProjectSpace(this.modelElement));
		} catch (NoCurrentUserException e1) {
			// Do nothing
		} catch (CannotMatchUserInProjectException e1) {
			// Do nothing
		}
		MEFormPage page = new MEFormPage(editor, ID, NAME) {
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
				form.setImage(Activator.getImageDescriptor("icons/Comment.png").createImage());
				form.setText(getEditor().getTitle() + ": Discussion");
				form.getBody().setBackgroundMode(SWT.INHERIT_FORCE);
				form.getBody().setBackground(new Color(Display.getCurrent(), 225, 225, 225));
				createToolbar();
				createWidget();
				form.pack();
			}
		};
		page.setParentMEPage(this);
		return page;
	}
}