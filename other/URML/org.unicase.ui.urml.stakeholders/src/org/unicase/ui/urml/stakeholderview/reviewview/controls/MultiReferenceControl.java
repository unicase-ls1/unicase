/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview.reviewview.controls;

import java.util.ArrayList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
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
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl;
import org.unicase.ui.urml.reviewview.AbstractControlBuilder;

/**
 * GUI Control for the review view reference multilinks.
 * 
 * @author kterzieva
 */
public class MultiReferenceControl extends AbstractControlBuilder {

	private FormToolkit toolKit;
	
	/**
	 *  Rebuilds the links.
	 * 
	 * @author kterzieva
	 */	
	private final class RebuildLinksCommand extends ECPCommand {
		
		private final int sizeLimit;

		public RebuildLinksCommand(EObject modelElement, int sizeLimit) {
			super(modelElement);
			this.sizeLimit = sizeLimit;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void doRun() {
			Object objectList = getModelElement().eGet(eReference);
			if (objectList instanceof EList) {
				EList<EObject> referenceList = (EList<EObject>) objectList;
				if (referenceList.size() <= sizeLimit) {
					linkArea = toolKit.createComposite(composite, style);
					linkArea.setLayout(tableLayout);
					linkArea.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				} else {

					scrollPane = new ScrolledComposite(composite, SWT.V_SCROLL | SWT.H_SCROLL);
					scrollPane.setBackgroundMode(SWT.INHERIT_FORCE);
					
					scrollClient = new Composite(scrollPane, style);
					scrollPane.setContent(scrollClient);
					toolKit.getColors().createColor("white", 255, 255, 255);
					scrollClient.setBackground(toolKit.getColors().getColor("white"));
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
				for (EObject object : referenceList) {
					MELinkControl meLinkControl = new MELinkControl(){
						@Override
						protected void createDeleteAction(int style) {}
					};
					meLinkControl.createControl((referenceList.size() <= sizeLimit ? linkArea : scrollClient), style,
						getItemPropertyDescriptor(), object, getModelElement(), toolKit, getContext());
								
					linkControls.add(meLinkControl);
				}
				if (scrollPane != null && !scrollPane.isDisposed()) {
					scrollPane.setMinSize(scrollClient.computeSize(SWT.DEFAULT, SWT.DEFAULT));
					scrollClient.layout();
					scrollPane.layout();
				} else {
					linkArea.layout();
				}
				if (referenceList.size() > 0) {
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

		toolBarManager.update(true);
		section.setTextClient(toolbar);
	}

	/**
	 * Creates the widget for the multilinks.
	 * 
	 * @param parent the parent composite
	 * @param urmlElement the urml element
	 * @return check the check button
	 */
	protected Control doCreateControl(Composite parent, UrmlModelElement urmlElement) {
		toolKit = new FormToolkit(parent.getDisplay());
		linkControls = new ArrayList<MELinkControl>();
		feature = getItemPropertyDescriptor().getFeature(getModelElement());
		this.eReference = (EReference) feature;
		modelElementChangeListener = new org.unicase.ui.meeditor.ModelElementChangeListener(getModelElement()) {

			@Override
			public void onChange(Notification notification) {
				if ((notification.getEventType() != Notification.RESOLVE)
					&& (notification.getFeature().equals(feature))) {
					//rebuildLinkSection();
				}

			}

		};

		tableLayout = new GridLayout(1, false);
		section = toolKit.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText(getItemPropertyDescriptor().getDisplayName(getModelElement()));
		createSectionToolbar(section, toolKit);
		composite = toolKit.createComposite(section, style);
		composite.setLayout(tableLayout);

		rebuildLinkSection();
		GridDataFactory.fillDefaults().grab(true, false).applyTo(section);
		section.setClient(composite);
		

		return section;
	}

	/**
	 * Refresh (rebuilding) the composite section.
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
		// JH: TransactionUtil.getEditingDomain(modelElement);
		new RebuildLinksCommand(getModelElement(), sizeLimit).run();
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
		super.dispose();
	}

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, UrmlModelElement urmlElement) {
		Object feature = itemPropertyDescriptor.getFeature(urmlElement);
		if (feature instanceof EReference
			&& EObject.class.isAssignableFrom(((EReference) feature).getEType().getInstanceClass())
			&& ((EReference) feature).isMany()) {

			return PRIORITY;
		}
		return AbstractControlBuilder.DO_NOT_RENDER;
	}

}