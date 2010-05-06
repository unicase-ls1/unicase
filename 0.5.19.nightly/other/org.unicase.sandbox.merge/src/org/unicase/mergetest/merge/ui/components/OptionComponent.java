package org.unicase.mergetest.merge.ui.components;

import java.util.HashMap;

import org.eclipse.emf.transaction.NotificationFilter.Custom;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.conflict.ConflictOption.OptionType;
import org.unicase.mergetest.merge.ui.DecisionBox;
import org.unicase.mergetest.merge.util.DecisionConfig;
import org.unicase.mergetest.merge.util.DecisionUtil;

public class OptionComponent {

	private Group group;
	private final Conflict conflict;
	private final DecisionBox parent;

	public OptionComponent(DecisionBox parent, Conflict conflict) {
		this.parent = parent;
		this.conflict = conflict;
		group = new Group(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.horizontalSpacing = 1;
		layout.verticalSpacing = 1;
		group.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.verticalSpan = 2;
		group.setLayoutData(gridData);
		group.setText("Choose your Option: ");

		for (ConflictOption option : conflict.getOptions()) {
			new CompositeExtension(conflict, option);
		}

		refreshButtonColor();
	}

	private String generatePrefix(ConflictOption option) {
		String result = "";
		switch (option.getType()) {
		case MyOperation:
			result = "Keep My Value: ";
			break;
		case TheirOperation:
			result = "Keep Their Value: ";
			break;
		case Issue:
			result = "Create Issue: ";
			break;
		case Custom:
			break;
		}
		return result;
	}

	private void addMouseListener(Composite composite, Listener listener) {
		composite.addListener(SWT.MouseEnter, listener);
		composite.addListener(SWT.MouseExit, listener);
		composite.addListener(SWT.MouseDown, listener);
		composite.addListener(SWT.MouseUp, listener);
		for (Control child : composite.getChildren()) {
			child.addListener(SWT.MouseEnter, listener);
			child.addListener(SWT.MouseExit, listener);
			child.addListener(SWT.MouseDown, listener);
			child.addListener(SWT.MouseUp, listener);
		}
	}

	private void refreshButtonColor() {
		for (Control composite : group.getChildren()) {
			if (composite instanceof CompositeExtension) {
				if (conflict.isResolved()
						&& conflict.getSolution() == ((CompositeExtension) composite)
								.getOption()) {
					setColor((Composite) composite, DecisionConfig
							.getOptionSelectedBack(), DecisionConfig
							.getOptionSelectedFor());
				} else {
					setColor((Composite) composite, DecisionConfig
							.getDefaultColor(), DecisionConfig
							.getDefaultColor());
				}
			}
		}
	}

	private void setColor(Composite composite, Color background,
			Color foreground) {
		composite.setBackground(background);
		composite.setForeground(foreground);
		for (Control control : composite.getChildren()) {
			control.setBackground(background);
			control.setForeground(foreground);
		}
	}

	private final class CompositeExtension extends Composite {

		private final ConflictOption option;

		private CompositeExtension(Conflict conflict, ConflictOption option) {
			super(group, SWT.BORDER | SWT.INHERIT_FORCE);
			this.option = option;
			GridLayout layout = new GridLayout();
			layout.verticalSpacing = 1;
			setLayout(layout);
			setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

//			StyledText styledText = new StyledText(this, SWT.NONE);
			
			String result = generatePrefix(option);
			result += DecisionUtil.cutString(option.getStrippedOptionLabel(),
					DecisionConfig.OPTION_LENGTH, true);

			Label label = new Label(this, SWT.NONE);
			label.setText(result);
			
//			StyleRange prefixRange = new StyleRange();
//		    prefixRange.start = 0;
//		    prefixRange.length = result.length();
//		    prefixRange.fontStyle = SWT.ITALIC;
//			styledText.setText(result);
//			styledText.setEditable(false);
//			styledText.setBackground(getBackground());
//			styledText.setStyleRange(prefixRange);

			OptionMouseListener listener = new OptionMouseListener(this);
			OptionComponent.this.addMouseListener(this, listener);
		}

		public ConflictOption getOption() {
			return option;
		}
	}

	private final class OptionMouseListener implements Listener {
		private final CompositeExtension composite;

		public OptionMouseListener(CompositeExtension composite) {
			this.composite = composite;
		}

		@Override
		public void handleEvent(Event event) {
			switch (event.type) {

			case SWT.MouseExit:
				refreshButtonColor();
				break;

			case SWT.MouseEnter:
				if (conflict.isResolved()
						&& conflict.getSolution() == composite.getOption()) {
					setColor(composite, DecisionConfig
							.getOptionSelectedBackEnter(), DecisionConfig
							.getDefaultColor());
				} else {
					setColor(composite, DecisionConfig.getOptionEnteredColor(),
							DecisionConfig.getDefaultColor());
				}
				break;

			case SWT.MouseUp:
				if (conflict.isResolved()
						&& conflict.getSolution() == composite.getOption()) {
					conflict.setSolution(null);
				} else {
					conflict.setSolution(composite.getOption());
				}
				refreshButtonColor();
				break;

			case SWT.MouseDown:
				break;

			}
		}
	}
}
