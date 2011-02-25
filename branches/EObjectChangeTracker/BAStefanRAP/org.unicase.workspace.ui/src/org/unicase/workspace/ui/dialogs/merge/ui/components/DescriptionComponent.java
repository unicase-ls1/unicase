/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.ui.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.ui.DecisionBox;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;

/**
 * Displays the description in the decision box.
 * 
 * @author wesendon
 */
// TODO RAP
public class DescriptionComponent extends Composite {

	/**
	 * Default constructor.
	 * 
	 * @param parent parent
	 * @param conflict conflict
	 */
	public DescriptionComponent(DecisionBox parent, Conflict conflict) {
		super(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.horizontalSpacing = 20;
		setLayout(layout);
		setLayoutData(new GridData(GridData.FILL_BOTH));

		Label image = new Label(this, SWT.NONE);
		image.setImage(DecisionUtil.getImage(conflict.getConflictDescription().getImage()));
		image.setToolTipText(conflict.getClass().getSimpleName());
		image.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		image.setBackground(parent.getBackground());

		String description = "";
		for (String tmp : splitText(parent, conflict.getConflictDescription())) {
			if (tmp.startsWith("::")) {
				description += tmp.substring(2);
			} else {
				description += tmp;
			}
		}

		Group group = new Group(this, SWT.NONE);
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		FillLayout groupLayout = new FillLayout();
		groupLayout.marginHeight = 5;
		groupLayout.marginWidth = 6;
		group.setLayout(groupLayout);
		group.setBackground(parent.getBackground());
		group.setText("Conflict Description:");
	}

	private List<String> splitText(DecisionBox box, ConflictDescription conflict) {
		String description = conflict.getDescription();
		// for(String string : description.split("\\["+"[a-zA-Z]*"+"\\]")) {
		ChangePackageVisualizationHelper visualHelper = box.getDecisionManager().getChangePackageVisualizationHelper();
		ArrayList<String> result = new ArrayList<String>();
		for (String string : description.split("\\[")) {
			String[] split = string.split("\\]");
			if (split.length > 1) {
				Object obj = conflict.getValues().get(split[0]);
				String tmp = "";
				if (obj instanceof EObject) {
					tmp = DecisionUtil.getClassAndName((EObject) obj);
					tmp = DecisionUtil.cutString(tmp, 45, true);
				} else if (obj instanceof AbstractOperation) {
					tmp = visualHelper.getDescription((AbstractOperation) obj);
				} else if (obj != null) {
					tmp = obj.toString();
					tmp = DecisionUtil.cutString(tmp, 85, true);
				} else {
					tmp = "";
				}
				tmp = DecisionUtil.stripNewLine(tmp);
				split[0] = "::" + tmp;
			}
			result.addAll(Arrays.asList(split));
		}
		return result;
	}
}
