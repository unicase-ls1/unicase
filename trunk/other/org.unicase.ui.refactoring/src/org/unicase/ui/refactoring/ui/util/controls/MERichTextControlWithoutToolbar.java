/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.ui.util.controls;

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
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Point;
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
import org.unicase.workspace.util.UnicaseCommand;

/**
 * The standard widget for multi line text fields.
 * 
 * @author helming
 */
public class MERichTextControlWithoutToolbar extends AbstractMEControl {

	private EAttribute attribute;

	private AdapterImpl eAdapter;

	private final String bulletString = "  \u2022 ";

	private static final int PRIORITY = 2;

	/**
	 * Create the control.
	 * 
	 * @param parent the
	 * @param style the
	 * @param c comment
	 * @param t textViewer
	 * @return the control
	 */
	protected Control createControl(final Composite parent, final int style, final Composite c, final TextViewer t) {
		final Object feature = getItemPropertyDescriptor().getFeature(getModelElement());
		this.attribute = (EAttribute) feature;
		if (c == null) {
			composite = getToolkit().createComposite(parent, style);

		} else {
			composite = c;
		}
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setLayout(new GridLayout());

		// createToolBar();
		createStyledText(t);
		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(final Notification msg) {
				if (msg.getFeature() != null && msg.getFeature().equals(MERichTextControlWithoutToolbar.this.attribute)) {
					load();
				}
				super.notifyChanged(msg);
			}
		};
		getModelElement().eAdapters().add(eAdapter);

		shouldShowExpand = true;
		load();

		return composite;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control createControl(final Composite parent, final int style) {
		return createControl(parent, style, null, null);
	}

	private Composite composite;

	private ToolBar toolBar;

	private StyledText text;

	private TextViewer viewer;

	/**
	 * 
	 * @return the text viewer
	 */
	public TextViewer getViewer() {
		return viewer;
	}

	private boolean shouldShowExpand;

	private void createStyledText(final TextViewer t) {

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
			public void focusLost(final FocusEvent e) {
				save();
				super.focusLost(e);
			}

		});
		final GridData spec = new GridData();
		spec.horizontalAlignment = GridData.FILL;
		spec.grabExcessHorizontalSpace = true;
		spec.verticalAlignment = GridData.FILL;
		spec.grabExcessVerticalSpace = true;
		spec.heightHint = 200;
		text.setLayoutData(spec);
	}

	@SuppressWarnings("unused")
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

		if (shouldShowExpand) {
			final ToolItem textItem = new ToolItem(toolBar, SWT.PUSH);
			final ImageDescriptor textImageDescriptor = Activator.getImageDescriptor("icons/text.png");
			textItem.setImage(textImageDescriptor.createImage());
			textItem.setToolTipText("Go to the description tab");
			textItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent event) {
					final IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().getActiveEditor();
					if (activeEditor instanceof MEEditor) {
						((MEEditor) activeEditor).setActivePage("Description");
					}
				}
			});
		}
	}

	@SuppressWarnings("unused")
	private void toggleBullet() {
		final int size = text.getText().length();
		final StringBuilder newText = new StringBuilder();
		int newOffset = 0;
		if (!text.getSelectionText().equals("")) {
			final Point selectionRange = text.getSelectionRange();
			final int start = selectionRange.x;
			final int length = selectionRange.y;

			String before = "";
			if (start > 0) {
				before = text.getText(0, start - 1);
			}
			final String target = text.getSelectionText();

			String after = "";
			if (start + length < size) {
				after = text.getText(start + length, size - 1);
			}
			newText.append(before);
			if (!target.contains(bulletString)) {
				newText.append("\n");
				newText.append(bulletString);
				newText.append(target);
				newOffset = newText.length();
				newText.append("\n");
			} else {
				newText.append(target.replaceFirst(bulletString, ""));
				newOffset = newText.length();
			}
			newText.append(after);
		} else {
			final int pos = text.getCaretOffset();
			final int line = text.getLineAtOffset(pos);
			final String target = text.getLine(line);
			String before = "";
			int start = text.getOffsetAtLine(line);
			if (start > 0) {
				before = text.getText(0, start - 1);
			}
			String after = "";
			if (line + 1 < text.getLineCount()) {
				start = text.getOffsetAtLine(line + 1);
				final int end = size - 1;
				if (start < end) {
					after = text.getText(start, end);
				}
			}
			newText.append(before);
			newText.append(bulletString);
			newText.append(target);
			newText.append("\n");
			newOffset = newText.length();
			newText.append(after);
		}
		viewer.getDocument().set(newText.toString());
		text.setCaretOffset(newOffset);
	}

	/**
	 * Sets if the expand toolbar button should be shown.
	 * 
	 * @param show if shown.
	 */
	public void setShowExpand(final boolean show) {
		shouldShowExpand = show;
	}

	/**
	 * @return the toolbar.
	 */
	public ToolBar getToolbar() {
		return toolBar;
	}

	/**
	 * Removes bullets.
	 * 
	 * @param line The startline
	 * @param count The number of lines
	 */
	protected void unbullet(final int line, final int count) {
		text.setLineBullet(line + count - 1, 1, null);

	}

	private void save() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getModelElement().eSet(attribute, text.getText());
			}
		}.run();
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
		if(viewer.getDocument() != null) {
			viewer.getDocument().set(txt);
		}
	}

	/**
	 * Adds bullets.
	 * 
	 * @param line The start line
	 * @param count The number of lines
	 */
	protected void bullet(final int line, final int count) {

		final StyleRange style0 = new StyleRange();
		style0.metrics = new GlyphMetrics(0, 0, 40);
		final Bullet bullet0 = new Bullet(style0);
		for (int i = 0; i < count; i++) {

			text.setLineBullet(line + count - 1, 1, bullet0);

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		getModelElement().eAdapters().remove(eAdapter);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void applyCustomLayoutData() {
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).hint(250, 150).grab(true, false).applyTo(composite);
	}
	
	/**
	 * Can render.
	 * 
	 * @param itemPropertyDescriptor the
	 * @param modelElement the
	 * @return status
	 */
	@Override
	public int canRender(final IItemPropertyDescriptor itemPropertyDescriptor, final EObject modelElement) {
		final Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute && ((EAttribute) feature).getEType().getInstanceClass().equals(String.class)) {

			if (itemPropertyDescriptor.isMultiLine(feature)) {
				return PRIORITY;
			}
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}
}