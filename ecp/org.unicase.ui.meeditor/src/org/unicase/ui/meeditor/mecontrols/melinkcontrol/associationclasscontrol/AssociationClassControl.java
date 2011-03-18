/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol.associationclasscontrol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
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
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControlFactory;

/**
 * The GUI control for AssociationClassElements.
 * 
 * @author Michael Haeger
 */
public class AssociationClassControl extends AbstractMEControl {

	/**
	 * Command to rebuild the links.
	 * 
	 * @author Michael Haeger
	 */
	private final class RebuildLinksCommand extends ECPCommand {

		private int sizeLimit;

		public RebuildLinksCommand(EObject eObject) {
			super(eObject);
		}

		public RebuildLinksCommand(EObject eObject, int sizeLimit) {
			this(eObject);
			this.sizeLimit = sizeLimit;
		}

		@Override
		protected void doRun() {
			Object evaluatedFeature = getModelElement().eGet(eReference);
			LinkedList<Object> associations = new LinkedList<Object>();
			if (eReference.isMany()) {
				associations.addAll((List<?>) evaluatedFeature);
			} else {
				associations.add(evaluatedFeature);
			}
			if (associations.size() <= sizeLimit) {
				linkArea = getToolkit().createComposite(composite, style);
				linkArea.setLayout(tableLayout);
				linkArea.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			} else {
				scrollPane = new ScrolledComposite(composite, SWT.V_SCROLL | SWT.H_SCROLL);
				scrollPane.setBackgroundMode(SWT.INHERIT_FORCE);
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
			for (Object association : associations) {
				MELinkControlFactory controlFactory = new MELinkControlFactory();
				MELinkControl meControl = controlFactory.createMELinkControl(getItemPropertyDescriptor(),
					(EObject) association, getModelElement(), getContext());
				meControl.createControl((associations.size() <= sizeLimit ? linkArea : scrollClient), style,
					getItemPropertyDescriptor(), (EObject) association, getModelElement(), getToolkit(), getContext());
				linkControls.add(meControl);
			}
			if (scrollPane != null && !scrollPane.isDisposed()) {
				scrollPane.setMinSize(scrollClient.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				scrollClient.layout();
				scrollPane.layout();
			} else {
				linkArea.layout();
			}
			if (associations.size() > 0) {
				section.setExpanded(false);
				section.setExpanded(true);
			}
		}
	}

	private static final int PRIORITY = 2;
	private EReference eReference;
	private int style;
	private ScrolledComposite scrollPane;
	private Section section;
	private Composite linkArea;
	private Composite composite;
	private Composite scrollClient;
	private GridLayout tableLayout;
	private org.unicase.ui.meeditor.ModelElementChangeListener modelElementChangeListener;
	private ArrayList<MELinkControl> linkControls;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (getContext() != null
			&& feature instanceof EReference
			&& getContext().getMetaModelElementContext().isAssociationClassElement(
				((EReference) feature).getEReferenceType())) {
			return PRIORITY;
		}
		return AbstractMEControl.DO_NOT_RENDER;
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
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.AbstractMEControl#createControl(org.eclipse.swt.widgets.Composite, int)
	 */
	@Override
	protected Control createControl(Composite parent, int style) {
		linkControls = new ArrayList<MELinkControl>();
		eReference = (EReference) getItemPropertyDescriptor().getFeature(getModelElement());
		modelElementChangeListener = new org.unicase.ui.meeditor.ModelElementChangeListener(getModelElement()) {
			@Override
			public void onChange(Notification notification) {
				if ((notification.getEventType() != Notification.RESOLVE)
					&& (notification.getFeature().equals(eReference))) {
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
		return section;
	}

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
		toolBarManager.add(new AddAssociationClassAction(getModelElement(), eReference, getItemPropertyDescriptor(),
			getContext()));
		toolBarManager.add(new NewAssociationClassAction(getModelElement(), eReference, getItemPropertyDescriptor(),
			getContext()));
		toolBarManager.update(true);
		section.setTextClient(toolbar);
	}

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
		new RebuildLinksCommand(getModelElement(), sizeLimit).run(true);
	}
}
