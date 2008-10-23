/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.PaintObjectEvent;
import org.eclipse.swt.custom.PaintObjectListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.ui.meeditor.Activator;

/**
 * The standard widget for multi line text fields.
 * 
 * @author helming
 * 
 */
public class MERichTextControl extends AbstractMEControl {

	private EAttribute attribute;

	private AdapterImpl eAdapter;

	/**
	 * Default constructor.
	 * 
	 * @param feature
	 *            The displayed feature
	 * @param editingDomain
	 *            the editing domain
	 * @param modelElement
	 *            the modelelement
	 * @param toolkit
	 *            the toolkit
	 */
	public MERichTextControl(EAttribute feature, EditingDomain editingDomain,
			EObject modelElement, FormToolkit toolkit) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = feature;

		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() != null
						&& msg.getFeature().equals(
								MERichTextControl.this.attribute)) {
					load();
				}
				super.notifyChanged(msg);
			}
		};
		getModelElement().eAdapters().add(eAdapter);
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		composite = new Composite(parent, style);
		composite.setLayout(new GridLayout());
		createToolBar();
		createStyledText();
		load();

		return composite;
	}

	private Composite composite;

	private ToolBar toolBar;

	private StyledText text;

	private TextViewer viewer;

	private void createStyledText() {

		viewer = new TextViewer(composite, SWT.BORDER | SWT.MULTI | SWT.WRAP
				| SWT.V_SCROLL);
		viewer.setDocument(new Document());

		text = viewer.getTextWidget();
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

		text.addPaintObjectListener(new PaintObjectListener() {
			public void paintObject(PaintObjectEvent event) {
				Display display = event.display;
				StyleRange style = event.style;
				Font font = style.font;
				if (font == null) {
					font = text.getFont();
				}
				TextLayout layout = new TextLayout(display);
				layout.setAscent(event.ascent);
				layout.setDescent(event.descent);
				layout.setFont(font);
				layout.setText("\u2023 1." + event.bulletIndex + ")");
				layout.draw(event.gc, event.x + 10, event.y);
				layout.dispose();
			}
		});
	}

	private void createToolBar() {
		toolBar = new ToolBar(composite, SWT.NULL);
		ToolItem item;
		item = new ToolItem(toolBar, SWT.PUSH);
		ImageDescriptor descriptor = Activator.getImageDescriptor("icons/bullet.jpg");
		item.setImage(descriptor.createImage());
		item.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				Point selectionRange = text.getSelectionRange();
				int x = selectionRange.x;
				int y = selectionRange.y;
				int startLine = text.getLineAtOffset(x);
				int endLine = text.getLineAtOffset(x + y);
				for (int i = startLine; i <= endLine; i++) {
					if (text.getLineBullet(i) == null) {
						bullet(i, 1);
					} else {
						unbullet(i, 1);
					}

				}
			}
		});

	}

	/**
	 * Removes bullets.
	 * 
	 * @param line
	 *            The startline
	 * @param count
	 *            The number of lines
	 */
	protected void unbullet(int line, int count) {
		text.setLineBullet(line + count - 1, 1, null);

	}

	private void save() {
		List<Integer> bulletedLines = new ArrayList<Integer>();
		for (int i = 0; i < text.getLineCount(); i++) {
			if (text.getLineBullet(i) != null) {
				bulletedLines.add(i);
			}
		}
		StringBuffer txt = new StringBuffer();
		for (Integer bulletedLine : bulletedLines) {
			txt.append(bulletedLine + ",");
		}
		txt.append(";,");
		txt.append("\n");
		txt.append("%BEGINNTEXT%");
		txt.append(text.getText());
		final String value = txt.toString();
		TransactionalEditingDomain domain = TransactionUtil
				.getEditingDomain(getModelElement());
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				getModelElement().eSet(attribute, value);
			}
		});
	}

	private void load() {

		List<Integer> bulletedLines = new ArrayList<Integer>();
		String txt = "";
			final StringBuffer value = new StringBuffer();
			TransactionalEditingDomain domain = TransactionUtil
					.getEditingDomain(getModelElement());
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					if (getModelElement().eGet(attribute) == null) {
						value.append("");
					} else {
						value.append(getModelElement().eGet(attribute));
					}
				}
			});
			txt = value.toString();

			String[] split = txt.split("%BEGINNTEXT%");
			
			if (split.length == 1) {
				viewer.getDocument().set("");
			} else {

				StringTokenizer stringTokenizer = new StringTokenizer(split[0], ",");
				while (stringTokenizer.hasMoreElements()) {
					String nextElement = (String) stringTokenizer.nextElement();
					if (nextElement.equals(";")) {
						break;
					} else {
						bulletedLines.add(Integer.parseInt(nextElement));
					}
				}
				viewer.getDocument().set(split[1]);
			}
			for (int i = 0; i < text.getLineCount(); i++) {
				text.setLineBullet(i, 1, null);
			}
		for (Integer line : bulletedLines) {
			bullet(line, 1);
		}

	}

	/**
	 * Adds bullets.
	 * 
	 * @param line
	 *            The start line
	 * @param count
	 *            The number of lines
	 */
	protected void bullet(int line, int count) {

		StyleRange style0 = new StyleRange();
		style0.metrics = new GlyphMetrics(0, 0, 40);
		Bullet bullet0 = new Bullet(style0);
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
	public void applyCustomLayoutData() {
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).hint(250, 150).grab(true, false).applyTo(composite);
	}
}