/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.albireo.core.SwingControl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.ImageDescriptor;
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
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.ui.meeditor.Activator;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.workspace.util.UnicaseCommand;

import com.hexidec.ekit.EkitCore;

/**
 * The standard widget for multi line text fields.
 * 
 * @author helming
 */
public class MERichTextControl extends AbstractMEControl {

	private EAttribute attribute;

	private AdapterImpl eAdapter;

	private final String bulletString = "  \u2022 ";

	private static final int PRIORITY = 2;
	private EkitCore viewer;
	private JPanel panel;

	protected Control createControl(Composite parent, int style, Composite c, TextViewer t) {
		Object feature = getItemPropertyDescriptor().getFeature(getModelElement());
		this.attribute = (EAttribute) feature;
		if (c == null) {
			composite = getToolkit().createComposite(parent, style);

		} else {
			composite = c;
		}
		composite.setLayout(new FormLayout());
		UnicaseCommand createRichEditor = new UnicaseCommand() {

			@Override
			protected void doRun() {
				createStyledText(composite);

			}
		};
		runAsnc(createRichEditor);

		getModelElement().addModelElementChangeListener(new ModelElementChangeListener() {

			public void onRuntimeExceptionInListener(RuntimeException exception) {
				// TODO Auto-generated method stub

			}

			public void onChange(Notification notification) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						if (getViewer() != null) {
							getViewer().setDocumentText(load());
						}
					}
				});

			}
		});

		// load();

		return composite;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control createControl(Composite parent, int style) {
		return createControl(parent, style, null, null);
	}

	private Composite composite;

	private ToolBar toolBar;

	private StyledText text;

	public EkitCore getViewer() {
		return viewer;
	}

	private boolean shoudShowExpand;

	private void createStyledText(Composite composite2) {

		Control control = new SwingControl(composite2, SWT.EMBEDDED | SWT.NO_BACKGROUND) {
			@SuppressWarnings("unchecked")
			@Override
			protected JComponent createSwingComponent() {
				try {
					System.setProperty("sun.awt.noerasebackground", "true");
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (NoSuchMethodError error) {
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				panel = new JPanel();
				panel.setLayout(new GridBagLayout());

				viewer = new EkitCore();
				// Menu Items
				Vector vcMenus = new Vector();
				vcMenus.add(EkitCore.KEY_MENU_INSERT);
				vcMenus.add(EkitCore.KEY_MENU_SEARCH);

				JMenuBar menubar = new JMenuBar();
				menubar.add(viewer.getCustomMenuBar(vcMenus));
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.anchor = GridBagConstraints.NORTH;
				gbc.gridheight = 1;
				gbc.gridwidth = 1;
				gbc.weightx = 1.0;
				gbc.weighty = 0.0;
				gbc.gridx = 0;
				viewer.setDocumentText(load());

				// Toolbar options
				viewer.initializeSingleToolbar("CT|CP|PS|UN|RE|BL|IT|UD|UL|OL|LK|TI|TE|CE|RI|CI|RD|CD|ST|");
				Dimension dimension = null;
				try {
					dimension = Dimension.class.newInstance();
					dimension.setSize(500, 200);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				viewer.setPreferredSize(dimension);
				viewer.setAutoscrolls(false);
				panel.add(menubar, gbc);
				panel.add(viewer.getToolBar(true), gbc);
				panel.add(viewer, gbc);

				return panel;

			}

			@Override
			public Composite getLayoutAncestor() {
				return composite;
			}
		};

		control.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent e) {
				save();
				super.focusLost(e);

			}

		});

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

	@SuppressWarnings("unused")
	private void toggleBullet() {
		int size = text.getText().length();
		StringBuilder newText = new StringBuilder();
		int newOffset = 0;
		if (!text.getSelectionText().equals("")) {
			Point selectionRange = text.getSelectionRange();
			int start = selectionRange.x;
			int length = selectionRange.y;

			String before = "";
			if (start > 0) {
				before = text.getText(0, start - 1);
			}
			String target = text.getSelectionText();

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
			int pos = text.getCaretOffset();
			int line = text.getLineAtOffset(pos);
			String target = text.getLine(line);
			String before = "";
			int start = text.getOffsetAtLine(line);
			if (start > 0) {
				before = text.getText(0, start - 1);
			}
			String after = "";
			if (line + 1 < text.getLineCount()) {
				start = text.getOffsetAtLine(line + 1);
				int end = size - 1;
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
		viewer.setDocumentText(newText.toString());
	}

	/**
	 * Sets if the expand toolbar button should be shown.
	 * 
	 * @param show if shown.
	 */
	public void setShowExpand(boolean show) {
		shoudShowExpand = show;
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
	protected void unbullet(int line, int count) {
		text.setLineBullet(line + count - 1, 1, null);

	}

	private void save() {
		UnicaseCommand command = new UnicaseCommand() {

			@Override
			protected void doRun() {
				getModelElement().eSet(attribute, getViewer().getDocumentText());

			}
		};
		runAsnc(command);
	}

	private void runAsnc(final UnicaseCommand command) {
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				command.run();
			}
		});

	}

	private String load() {

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
		return txt;
	}

	/**
	 * Adds bullets.
	 * 
	 * @param line The start line
	 * @param count The number of lines
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
	@Override
	public void applyCustomLayoutData() {
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).hint(500, 250).grab(true, false).applyTo(composite);
	}

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute && ((EAttribute) feature).getEType().getInstanceClass().equals(String.class)) {

			if (itemPropertyDescriptor.isMultiLine(feature)) {
				return PRIORITY;
			}
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}
}