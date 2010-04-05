/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols.issuecontrol;

import static org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil.cutString;
import static org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil.getAdapterFactory;
import static org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil.stripNewLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionConfig;

/**
 * Selection dialog for a list of model elements. Multiselection not possible at the moment. This dialog was created for
 * merging issue resolution. It could be extended for general usage.
 * 
 * @author wesendon
 */
public class SolutionSelectionDialog extends Dialog {

	private ArrayList<UnicaseModelElement> elements;
	private List<Entry> entries;
	private String description;
	private int selectedIndex;

	/**
	 * Default constructor.
	 * 
	 * @param parentShell parent shell
	 */
	protected SolutionSelectionDialog(Shell parentShell) {
		super(parentShell);
		elements = new ArrayList<UnicaseModelElement>();
		selectedIndex = -1;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#isResizable()
	 */
	@Override
	protected boolean isResizable() {
		return true;
	}

	/**
	 * Set Elements which shall be listed.
	 * 
	 * @param elements elements
	 */
	public void setElements(UnicaseModelElement[] elements) {
		this.elements.addAll(Arrays.asList(elements));
	}

	/**
	 * Set description.
	 * 
	 * @param text description
	 */
	public void setDescription(String text) {
		description = text;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		parent.setLayout(new GridLayout());

		if (description != null) {
			Text text = new Text(parent, SWT.WRAP);
			text.setText(description);
			text.setEditable(false);
			text.setEnabled(false);
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(text);
		}

		final ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.WRAP | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(scrolledComposite);

		final Composite container = new Composite(scrolledComposite, SWT.None);
		container.setLayout(new GridLayout());

		entries = new ArrayList<Entry>();
		for (UnicaseModelElement me : elements) {
			entries.add(new Entry(container, me));
		}

		scrolledComposite.setContent(container);
		scrolledComposite.setMinSize(parent.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		scrolledComposite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				Rectangle r = scrolledComposite.getClientArea();
				scrolledComposite.setMinSize(container.computeSize(r.width, SWT.DEFAULT));
			}
		});

		refreshItems();

		return scrolledComposite;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setSize(450, 350);
	}

	private void refreshItems() {
		for (int i = 0; i < entries.size(); i++) {
			Entry entry = entries.get(i);

			if (i == selectedIndex) {
				entry.setColor(DecisionConfig.getOptionSelectedBack(), DecisionConfig.getOptionSelectedFor());
				continue;
			}

			if (i % 2 == 0) {
				entry.setColor(DecisionConfig.getFirstDecisionBoxColor(), DecisionConfig.getDefaultTextColor());
			} else {
				entry.setColor(DecisionConfig.getSecondDecisionBoxColor(), DecisionConfig.getDefaultTextColor());
			}
		}
	}

	private void setSolution(Entry entry) {
		selectedIndex = entries.indexOf(entry);
	}

	/**
	 * Returns the selected element.
	 * 
	 * @return element
	 */
	public UnicaseModelElement getSolution() {
		return elements.get(selectedIndex);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		if (selectedIndex != -1) {
			super.okPressed();
		}
	}

	/**
	 * This class represents an entry in the list.
	 * 
	 * @author wesendon
	 */
	private class Entry extends Composite {

		private CLabel title;
		private StyledText text;

		public Entry(Composite parent, UnicaseModelElement element) {
			super(parent, SWT.BORDER);
			setLayout(new GridLayout());
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(this);
			AdapterFactoryLabelProvider labelProvider = getAdapterFactory();

			title = new CLabel(this, SWT.WRAP);
			title.setText(labelProvider.getText(element));
			title.setImage(labelProvider.getImage(element));
			title.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false));

			text = new StyledText(this, SWT.WRAP | SWT.MULTI);
			text.setText(cutString(stripNewLine(element.getDescription()), 250, true));
			text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			text.setEditable(false);
			text.setEnabled(false);

			OptionMouseListener listener = new OptionMouseListener(this);
			this.addListener(SWT.MouseEnter, listener);
			this.addListener(SWT.MouseExit, listener);
			this.addListener(SWT.MouseUp, listener);
			title.addListener(SWT.MouseEnter, listener);
			title.addListener(SWT.MouseExit, listener);
			title.addListener(SWT.MouseUp, listener);
			text.addListener(SWT.MouseEnter, listener);
			text.addListener(SWT.MouseExit, listener);
			text.addListener(SWT.MouseUp, listener);
		}

		public void setColor(Color background, Color foreground) {
			this.setBackground(background);
			title.setBackground(background);
			text.setBackground(background);

			title.setForeground(foreground);
			text.setForeground(foreground);
		}

		/**
		 * Listener.
		 * 
		 * @author wesendon
		 */
		private final class OptionMouseListener implements Listener {

			private final Entry entry;

			public OptionMouseListener(Entry entry) {
				this.entry = entry;
				entry.setCursor(new Cursor(entry.getDisplay(), SWT.CURSOR_HAND));
			}

			public void handleEvent(Event event) {
				switch (event.type) {

				case SWT.MouseExit:
					refreshItems();
					break;

				case SWT.MouseEnter:
					entry.setColor(DecisionConfig.getOptionEnteredColor(), DecisionConfig.getDefaultTextColor());
					break;

				case SWT.MouseUp:
					setSolution(entry);
					refreshItems();
					break;
				default:
					break;
				}
			}
		}
	}

}
