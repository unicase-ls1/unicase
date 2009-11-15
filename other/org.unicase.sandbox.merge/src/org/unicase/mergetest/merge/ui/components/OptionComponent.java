package org.unicase.mergetest.merge.ui.components;

import org.eclipse.emf.transaction.NotificationFilter.Custom;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.conflict.ConflictOption.OptionType;
import org.unicase.mergetest.merge.util.DecisionUtil;

public class OptionComponent {

	private Group group;

	public OptionComponent(
			Composite parent,
			Conflict conflict) {
		group = new Group(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.horizontalSpacing=1;
		layout.verticalSpacing=1;
		group.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.verticalSpan = 2;
		group.setLayoutData(gridData);
		group.setText("Choose your Option: ");

		for (ConflictOption option : conflict.getOptions()) {
			createOption(option);
		}
	}

	private void createOption(ConflictOption option) {
		final Composite composite = new Composite(group, SWT.BORDER
				| SWT.INHERIT_FORCE);
		GridLayout layout = new GridLayout();
		layout.verticalSpacing=1;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		composite.addMouseTrackListener(new MouseTrackListenerImplementation(
				composite));
		Label option1 = new Label(composite, SWT.NONE);

		String result = generateOptionDescription(option);
		
		option1.setText(result);
	}

	private String generateOptionDescription(ConflictOption option) {
		String result = "";
		switch(option.getType()) {
		case MyOperation:
			result = "Keep my value: ";
			break;
		case TheirOperation:
			result = "Keep their value: ";
			break;
		case Issue:
				result = "Create Issue: ";
			break;
		case Custom:
			break;
		}
		result += DecisionUtil.cutString(option.getOptionLabel(), 40, true);
		return result;
	}

	private final class MouseTrackListenerImplementation implements
			MouseTrackListener {
		private final Composite composite;

		private MouseTrackListenerImplementation(Composite composite) {
			this.composite = composite;
		}

		public void mouseHover(MouseEvent e) {
		}

		public void mouseExit(MouseEvent e) {
			composite.setBackground(null);
			for(Control control : composite.getChildren()) {
				control.setBackground(null);
			}
		}

		public void mouseEnter(MouseEvent e) {
			composite.setBackground(composite.getDisplay().getSystemColor(
					SWT.COLOR_INFO_BACKGROUND));
			for(Control control : composite.getChildren()) {
				control.setBackground(composite.getDisplay().getSystemColor(
					SWT.COLOR_INFO_BACKGROUND));
			}
		}
	}
}
