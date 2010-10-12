/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.workspace.WorkspaceManager;

/**
 * GUI Control for the ME reference multilinks.
 * 
 * @author helming
 */
public class MEMultiLinkControl extends AbstractMEControl {

	/**
	 * Command to rebuild the links.
	 * 
	 * @author helming
	 */
	private final class RebuildLinksCommand extends RecordingCommand {
		private final int sizeLimit;

		private RebuildLinksCommand(TransactionalEditingDomain domain, int sizeLimit) {
			super(domain);
			this.sizeLimit = sizeLimit;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void doExecute() {
			Object objectList = getModelElement().eGet(eReference);
			if (objectList instanceof EList) {
				EList<EObject> eList = (EList<EObject>) objectList;
				if (eList.size() <= sizeLimit) {
					linkArea = getToolkit().createComposite(composite, style);
					linkArea.setLayout(tableLayout);
					linkArea.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				} else {

					scrollPane = new ScrolledComposite(composite, SWT.V_SCROLL | SWT.H_SCROLL | SWT.TRANSPARENT);
					scrollClient = new Composite(scrollPane, style);
					scrollPane.setContent(scrollClient);
					getToolkit().getColors().createColor("white", 255, 255, 255);
					scrollClient.setBackground(getToolkit().getColors().getColor("white"));
					scrollPane.setExpandVertical(true);
					scrollPane.setExpandHorizontal(true);
					RowLayout layout = new RowLayout(SWT.VERTICAL);
					layout.wrap = true;
					scrollClient.setLayout(layout);
					GridData spec = new GridData(400, 150);
					spec.horizontalAlignment = GridData.FILL;
					spec.grabExcessHorizontalSpace = true;
					scrollPane.setLayoutData(spec);
					scrollPane.setMinSize(150, 150);
				}

				for (EObject object : eList) {

					MELinkControlFactory controlFactory = new MELinkControlFactory();
					MELinkControl meControl = controlFactory.createMELinkControl(getItemPropertyDescriptor(), object,
						getModelElement(), getContext());
					meControl.createControl((eList.size() <= sizeLimit ? linkArea : scrollClient), style,
						getItemPropertyDescriptor(), object, getModelElement(), getToolkit(), getContext());
					linkControls.add(meControl);

				}
				if (scrollPane != null && !scrollPane.isDisposed()) {
					scrollPane.setMinSize(scrollClient.computeSize(SWT.DEFAULT, SWT.DEFAULT));
					scrollClient.layout();
					scrollPane.layout();
				} else {
					linkArea.layout();
				}
				if (eList.size() > 0) {
					section.setExpanded(false);
					section.setExpanded(true);
				}
			}
		}
	}

	private EReference eReference;

	private int style;

	private ScrolledComposite scrollPane;

	private Section section;

	private Composite linkArea;

	private Composite composite;

	private ArrayList<MELinkControl> linkControls;

	private GridLayout tableLayout;

	private Composite scrollClient;

	private DropTarget sectionDropTarget;

	private static final int PRIORITY = 1;

	private Object feature;

	private org.unicase.ui.meeditor.ModelElementChangeListener modelElementChangeListener;

	private void createSectionToolbar(Section section, FormToolkit toolkit) {
		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(section);
		final Cursor handCursor = new Cursor(Display.getCurrent(), SWT.CURSOR_HAND);
		toolbar.setCursor(handCursor);
		// Cursor needs to be explicitly disposed
		toolbar.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				if (!handCursor.isDisposed()) {
					handCursor.dispose();
				}
			}
		});

		toolBarManager.add(new AddReferenceAction(getModelElement(), eReference, getItemPropertyDescriptor(),
			getContext()));
		toolBarManager.add(new NewReferenceAction(getModelElement(), eReference, getItemPropertyDescriptor(),
			getContext()));
		toolBarManager.update(true);
		section.setTextClient(toolbar);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control createControl(final Composite parent, int style) {
		linkControls = new ArrayList<MELinkControl>();
		feature = getItemPropertyDescriptor().getFeature(getModelElement());
		this.eReference = (EReference) feature;
		modelElementChangeListener = new org.unicase.ui.meeditor.ModelElementChangeListener(getModelElement()) {

			@Override
			public void onChange(Notification notification) {
				if ((notification.getEventType() != Notification.RESOLVE)
					&& (notification.getFeature().equals(feature))) {
					rebuildLinkSection();
				}

			}

		};

		this.style = style;
		tableLayout = new GridLayout(1, false);
		section = getToolkit().createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText(getItemPropertyDescriptor().getDisplayName(getModelElement()));
		createSectionToolbar(section, getToolkit());
		composite = getToolkit().createComposite(section, style);
		composite.setLayout(tableLayout);

		rebuildLinkSection();

		section.setClient(composite);
		addDnDSupport();
		return section;
	}

	private void addDnDSupport() {
		sectionDropTarget = new DropTarget(section, DND.DROP_COPY);
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		sectionDropTarget.setTransfer(transfers);
		sectionDropTarget.addDropListener(new MEMultiLinkControlDropAdapter(getEditingDomain(), getModelElement(),
			eReference, getContext()));

	}

	/**
	 * Method for refreshing (rebuilding) the composite section.
	 */
	private void rebuildLinkSection() {
		final int sizeLimit = 5;

		for (MELinkControl link : linkControls) {
			link.dispose();
		}
		if (scrollPane != null) {
			scrollPane.dispose();
		}
		if (linkArea != null) {
			linkArea.dispose();
		}
		linkControls.clear();
		TransactionalEditingDomain domain = WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain();
		// JH: TransactionUtil.getEditingDomain(modelElement);
		domain.getCommandStack().execute(new RebuildLinksCommand(domain, sizeLimit));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		modelElementChangeListener.remove();
		for (MELinkControl link : linkControls) {
			link.dispose();
		}
		if (sectionDropTarget != null) {
			sectionDropTarget.dispose();
		}
	}

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EReference
			&& EObject.class.isAssignableFrom(((EReference) feature).getEType().getInstanceClass())
			&& ((EReference) feature).isMany()) {

			return PRIORITY;
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}

}