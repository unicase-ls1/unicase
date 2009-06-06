/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.commentcontrol;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.util.ProjectChangeObserver;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.MEControl;
import org.unicase.workspace.WorkspaceManager;

/**
 * Standard widget to show the number of comments.
 * 
 * @author shterev
 */
public class MECommentsLinkControl extends AbstractMEControl implements MEControl {

	private ProjectChangeObserver observerImpl;
	private EReference reference;
	private Composite commentComposite;

	private ImageHyperlink commentIcon;
	private Link commentsLink;
	private AdapterFactoryLabelProvider labelProvider;
	private Project project;

	/**
	 * default constructor.
	 * 
	 * @param reference the comments reference
	 * @param toolkit see {@link AbstractMEControl}
	 * @param modelElement see {@link AbstractMEControl}
	 * @param editingDomain see {@link AbstractMEControl}
	 */
	public MECommentsLinkControl(EReference reference, FormToolkit toolkit, EObject modelElement,
		EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		this.reference = reference;
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		observerImpl = new ProjectChangeObserver() {

			public void modelElementAdded(Project project, ModelElement modelElement) {
				if (modelElement instanceof Comment) {
					Comment newComment = (Comment) modelElement;
					ModelElement currentModelElement = (ModelElement) getModelElement();
					if (currentModelElement.getAllContainedModelElements().contains(newComment)) {
						update();
					}
				}
			}

			public void modelElementDeleteCompleted(Project project, ModelElement modelElement) {
			}

			public void modelElementDeleteStarted(Project project, ModelElement modelElement) {
			}

			public void notify(Notification notification, Project project, ModelElement modelElement) {
			}

		};

		if (ModelPackage.eINSTANCE.getModelElement().isInstance(modelElement)) {
			ModelElement me = (ModelElement) modelElement;
			project = WorkspaceManager.getProjectSpace(me).getProject();
			project.addProjectChangeObserver(observerImpl);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		commentComposite = getToolkit().createComposite(parent);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(2, 0).applyTo(commentComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(commentComposite);
		commentComposite.setBackgroundMode(SWT.INHERIT_FORCE);
		update();
		return commentComposite;
	}

	private void createCommentWidget(int num) {
		commentIcon = new ImageHyperlink(commentComposite, SWT.TOP);
		commentIcon.setImage(labelProvider.getImage(RationaleFactory.eINSTANCE.createComment()));
		commentIcon.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));

		commentsLink = new Link(commentComposite, SWT.NONE);
		commentsLink.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		String comments = "comments";
		if (num == 1) {
			comments = "comment";
		}
		commentsLink.setText("<a>" + num + " " + comments + "</a>");
		commentsLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				final IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();
				if (activeEditor instanceof MEEditor) {
					((MEEditor) activeEditor).setActivePage("Discussion");
				}
			}
		});

	}

	/**
	 * Remove adapter. {@inheritDoc}
	 */
	@Override
	public void dispose() {
		project.removeProjectChangeObserver(observerImpl);
		super.dispose();
	}

	private void update() {

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(getModelElement());
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@SuppressWarnings("unchecked")
			@Override
			protected void doExecute() {
				List<Comment> comments = (List<Comment>) getModelElement().eGet(reference);
				if (comments != null) {
					if (commentIcon != null) {
						commentIcon.dispose();
						commentsLink.dispose();
					}
					int i = 0;
					for (Comment c : comments) {
						i += sizeOf(c);
					}
					createCommentWidget(i);
				}
				commentComposite.layout(true);
				commentComposite.getParent().layout(true);
				commentComposite.getParent().getParent().layout(true);
			}
		});
	}

	/**
	 * The recursive size of the comment's children.
	 * 
	 * @param comment the comment
	 * @return the size
	 */
	public static int sizeOf(Comment comment) {
		int i = 1;
		for (Comment c : comment.getComments()) {
			i += sizeOf(c);
		}
		return i;
	}
}
