/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols.commentcontrol;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.unicasecommon.meeditor.mecontrols.AbstractUnicaseMEControl;

/**
 * Standard widget to show the number of comments.
 * 
 * @author shterev
 */
public class MECommentsLinkControl extends AbstractUnicaseMEControl {
	/**
	 * Project Changeobserever for comment thread.
	 * 
	 * @author helming
	 */
	private final class ProjectChangeObserverImplementation implements IdEObjectCollectionChangeObserver {

		public void notify(Notification notification, IdEObjectCollection project, EObject modelElement) {
			// TODO Auto-generated method stub

		}

		public void modelElementAdded(IdEObjectCollection project, EObject modelElement) {
			if (modelElement instanceof Comment) {
				Comment newComment = (Comment) modelElement;
				UnicaseModelElement currentModelElement = (UnicaseModelElement) getModelElement();
				if (ModelUtil.getAllContainedModelElements(currentModelElement, false).contains(newComment)) {
					update();
				}
			}

		}

		public void modelElementRemoved(IdEObjectCollection project, EObject modelElement) {
			// TODO Auto-generated method stub

		}

		public void collectionDeleted(IdEObjectCollection project) {
			// TODO Auto-generated method stub

		}
	}

	private IdEObjectCollectionChangeObserver observerImpl;
	private EReference reference;
	private Composite commentComposite;

	private ImageHyperlink commentIcon;
	private Link commentsLink;
	private AdapterFactoryLabelProvider labelProvider;
	private Project project;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control createControl(Composite parent, int style) {
		EStructuralFeature feature = (EStructuralFeature) getItemPropertyDescriptor().getFeature(getModelElement());
		this.reference = (EReference) feature;
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		observerImpl = new ProjectChangeObserverImplementation();

		if (getModelElement() instanceof UnicaseModelElement) {
			UnicaseModelElement me = (UnicaseModelElement) getModelElement();
			project = WorkspaceManager.getProjectSpace(me).getProject();
			project.addIdEObjectCollectionChangeObserver(observerImpl);
		}
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
				UnicaseActionHelper.openDiscussion(getModelElement(), false);
			}
		});

	}

	/**
	 * Remove adapter. {@inheritDoc}
	 */
	@Override
	public void dispose() {
		project.removeIdEObjectCollectionChangeObserver(observerImpl);
		super.dispose();
	}

	private void update() {
		new EMFStoreCommand() {
			@SuppressWarnings("unchecked")
			@Override
			protected void doRun() {
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
		}.run(true);
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		EStructuralFeature feature = (EStructuralFeature) itemPropertyDescriptor.getFeature(modelElement);
		if (!(feature instanceof EReference)) {
			return AbstractMEControl.DO_NOT_RENDER;
		}
		EReference reference = (EReference) feature;
		if (!reference.getEReferenceType().equals(RationalePackage.eINSTANCE.getComment())) {
			return AbstractMEControl.DO_NOT_RENDER;
		}

		return 2;
	}
}
