package org.unicase.ui.unicasecommon.meeditor.mecontrols.issuecontrol;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SolutionSelectionDialog extends Dialog {

	protected SolutionSelectionDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		parent.setLayout(new GridLayout());

		final ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.WRAP | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(scrolledComposite);

		final Composite container = new Composite(scrolledComposite, SWT.None);
		container.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));
		container.setLayout(new GridLayout());

		for (int i = 0; i < 60; i++) {
			new Entry(container);
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

		return scrolledComposite;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setSize(600, 400);
	}

	private class Entry extends Composite {

		public Entry(Composite parent) {
			super(parent, SWT.None);
			setLayout(new GridLayout());
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(this);
			CLabel title = new CLabel(this, SWT.WRAP);
			title
				.setText("Within an issue trying to create and link new criteria results in the new criteria land in orphans ");
			title.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false));
			StyledText text = new StyledText(this, SWT.WRAP | SWT.MULTI);
			text
				.setText("Within an issue if there is already a proposal selected(or created and linked just now). Then trying to create and link new criteria results in the new criteria land in orphans and then 2 warnings with An exception was ignored during command execution occurs while trying to create new reference!");
			text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		}
	}

}
