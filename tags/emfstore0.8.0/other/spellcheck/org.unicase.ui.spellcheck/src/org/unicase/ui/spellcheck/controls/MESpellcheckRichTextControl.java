/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.spellcheck.controls;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.meeditor.Activator;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.MERichTextControl;
import org.unicase.ui.spellcheck.SpellcheckedSourceViewer;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Spellchecked version of the MERichTextControl.
 * 
 * @author jfinis
 */
public class MESpellcheckRichTextControl extends MERichTextControl {

	private static final int PRIORITY = 4;
	private EAttribute attribute;
	private Composite composite;
	private AdapterImpl eAdapter;
	private TextViewer viewer;
	private StyledText text;
	private boolean shoudShowExpand;
	private ToolBar toolBar;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control createControl(Composite parent, int style) {
		Composite composite = getToolkit().createComposite(parent, style);
		return createControl(parent, style, composite, new SpellcheckedSourceViewer(composite, SWT.BORDER
			| SWT.MULTI | SWT.WRAP | SWT.V_SCROLL));
	}
	
	private Control createControl(Composite parent, int style, Composite c, TextViewer t) {
		Object feature = getItemPropertyDescriptor().getFeature(getModelElement());
		this.attribute = (EAttribute) feature;
		if (c == null) {
			composite = getToolkit().createComposite(parent, style);

		} else {
			composite = c;
		}
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setLayout(new GridLayout());

		createToolBar();
		createStyledText(t);
		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() != null && msg.getFeature().equals(attribute)) {
					load();
				}
				super.notifyChanged(msg);
			}
		};
		getModelElement().eAdapters().add(eAdapter);

		shoudShowExpand = true;
		load();

		return composite;
	}
	
	private void load() {

		String txt = "";
		final StringBuffer value = new StringBuffer();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				if (getModelElement().eGet(attribute) == null) {
					value.append("");
				} else {
					value.append(getModelElement().eGet(attribute));
				}
			}
		}.run();
		txt = value.toString();
		viewer.getDocument().set(txt);
	}

	private void createStyledText(TextViewer t) {

		if (t == null) {
			viewer = new TextViewer(composite, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
			viewer.setDocument(new Document());
		} else {
			viewer = t;
		}

		text = viewer.getTextWidget();
		text.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		text.setSize(10, 100);
		text.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent e) {
				save();
				super.focusLost(e);
			}

		});
		GridData spec = new GridData();
		spec.horizontalAlignment = GridData.FILL;
		spec.grabExcessHorizontalSpace = true;
		spec.verticalAlignment = GridData.FILL;
		spec.grabExcessVerticalSpace = true;
		spec.heightHint = 200;
		text.setLayoutData(spec);
	}
	
	private void save() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getModelElement().eSet(attribute, text.getText());
			}
		}.run();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void applyCustomLayoutData() {
		GridDataFactory.fillDefaults().grab(true, false).hint(250, 150).align(SWT.FILL, SWT.TOP).applyTo(composite);
	}
	
	private void createToolBar() {
		toolBar = new ToolBar(composite, SWT.NULL);
		// final ToolItem bulletsItem = new ToolItem(toolBar, SWT.PUSH);
		// ImageDescriptor descriptor = Activator.getImageDescriptor("icons/bullet.jpg");
		// bulletsItem.setImage(descriptor.createImage());
		// bulletsItem.addSelectionListener(new SelectionAdapter() {
		//
		// @Override
		// public void widgetSelected(SelectionEvent event) {
		// toggleBullet();
		// }
		// });

		if (shoudShowExpand) {
			ToolItem textItem = new ToolItem(toolBar, SWT.PUSH);
			ImageDescriptor textImageDescriptor = Activator.getImageDescriptor("icons/text.png");
			textItem.setImage(textImageDescriptor.createImage());
			textItem.setToolTipText("Go to the description tab");
			textItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent event) {
					final IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().getActiveEditor();
					if (activeEditor instanceof MEEditor) {
						((MEEditor) activeEditor).setActivePage("Description");
					}
				}
			});
		}
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute && ((EAttribute) feature).getEType().getInstanceClass().equals(String.class)) {

			if (itemPropertyDescriptor.isMultiLine(feature)) {
				return PRIORITY;
			}
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}
}