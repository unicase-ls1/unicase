package org.unicase.workspace.ui.dialogs.merge.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.ui.components.ContextComponent;
import org.unicase.workspace.ui.dialogs.merge.ui.components.DescriptionComponent;
import org.unicase.workspace.ui.dialogs.merge.ui.components.DetailsComponent;
import org.unicase.workspace.ui.dialogs.merge.ui.components.OptionComponent;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;

public class DecisionBox extends Composite {

	private final Conflict conflict;
	private final DecisionManager decisionManager;

	public DecisionBox(Composite parent, DecisionManager decisionManager,
			Color color, Conflict conflict) {
		super(parent, SWT.BORDER);
		this.decisionManager = decisionManager;
		this.conflict = conflict;
		init(color);
	}

	private void init(Color color) {

		GridLayout decisionLayout = new GridLayout(2, true);
		this.setLayout(decisionLayout);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		if (color != null) {
			setBackground(color);
		}

		new ContextComponent(this, conflict);
		new OptionComponent(this, conflict);
		new DescriptionComponent(this, conflict);

		if (DecisionUtil.detailsNeeded(conflict)) {
			new DetailsComponent(this, conflict);
		}

		for (Control control : getChildren()) {
			control.setBackground(getBackground());
		}
	}

	public DecisionManager getDecisionManager() {
		return decisionManager;
	}

	public void layoutPage() {
		getParent().getParent().layout();
	}
}
