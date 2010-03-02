/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.ui.widgets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.options.MergeTextOption;
import org.unicase.workspace.ui.dialogs.merge.ui.DecisionBox;

import diff.match.patch.diff_match_patch;
import diff.match.patch.diff_match_patch.Diff;
import diff.match.patch.diff_match_patch.Operation;

/**
 * Is used to display longer conflicting text and to merge them.
 * 
 * @author wesendon
 */
public class MultilineWidget {

	private final DecisionBox decisionBox;
	private ArrayList<ConflictOption> options;

	/**
	 * Default constructor.
	 * 
	 * @param decisionBox
	 *            container
	 */
	public MultilineWidget(DecisionBox decisionBox) {
		this.decisionBox = decisionBox;
		options = new ArrayList<ConflictOption>();
	}

	/**
	 * Add involved ConflictOptions.
	 * 
	 * @param option
	 *            option
	 */
	public void addOption(ConflictOption option) {
		options.add(option);
	}

	/**
	 * Called by container in order to build gui.
	 * 
	 * @param parent
	 *            container
	 */
	public void createContent(Composite parent) {
		TabFolder tabFolder = new TabFolder(parent, SWT.NONE);
		tabFolder.setBackground(parent.getBackground());
		tabFolder.setLayout(new TableWrapLayout());

		for (ConflictOption option : options) {
			createTab(tabFolder, option);
		}
	}

	private void createTab(TabFolder tabFolder, ConflictOption option) {
		TabItem tab = new TabItem(tabFolder, SWT.NONE);
		tab.setText(getTitle(option));
		StyledText text = new StyledText(tabFolder, SWT.MULTI | SWT.WRAP);
		setText(option, text);
		text.setBackground(tabFolder.getBackground());
		text.setEditable(isEditable(option));
		text.setWordWrap(true);
		text.setTopMargin(5);
		text.setLeftMargin(5);
		text.setRightMargin(5);
		tab.setControl(text);
	}

	private void setText(ConflictOption option, final StyledText styledText) {
		if (option instanceof MergeTextOption) {
			handleMergeTextOption(option, styledText);
		} else {
			styledText.setText(option.getFullOptionLabel());
		}
	}

	private void handleMergeTextOption(ConflictOption option,
			final StyledText styledText) {
		final MergeTextOption mergeOption = (MergeTextOption) option;
		diff_match_patch dmp = new diff_match_patch();
		dmp.Diff_EditCost = 10;
		LinkedList<Diff> diffMain = dmp.diff_main(mergeOption.getMyText(),
				mergeOption.getTheirString());
		dmp.diff_cleanupEfficiency(diffMain);

		String description = "";
		List<StyleRange> styleRanges = new ArrayList<StyleRange>();

		for (Diff diff : diffMain) {
			String text = diff.text;
			if (!diff.operation.equals(Operation.EQUAL)) {
				StyleRange styleRange = new StyleRange();
				styleRange.start = description.length();
				styleRange.length = text.length();

				if (diff.operation.equals(Operation.DELETE)) {
					styleRange.foreground = Display.getDefault()
							.getSystemColor(SWT.COLOR_RED);
				} else if (diff.operation.equals(Operation.INSERT)) {
					styleRange.foreground = Display.getDefault()
							.getSystemColor(SWT.COLOR_DARK_GREEN);
				}
				styleRanges.add(styleRange);
			}
			description += text;
		}
		styledText.setText(description);
		styledText.setStyleRanges(styleRanges
				.toArray(new StyleRange[styleRanges.size()]));
		styledText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String newText = styledText.getText();
				String oldText = mergeOption.getMergedText();
				if (newText != null && !newText.equals(oldText)) {
					mergeOption.setMergedText(newText);
					decisionBox.setSolution(mergeOption);
				}
			}
		});
	}

	private boolean isEditable(ConflictOption option) {
		return option instanceof MergeTextOption;
	}

	private String getTitle(ConflictOption option) {
		switch (option.getType()) {
		case MyOperation:
			return "My Version";
		case TheirOperation:
			return "Version from Repository";
		case Custom:
		case MergeText:
			return option.getOptionLabel();
		default:
			return "";
		}
	}
}
