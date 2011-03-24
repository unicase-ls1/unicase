/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui.dialogs.merge.ui.widgets;

import org.eclipse.emf.emfstore.client.ui.dialogs.merge.DecisionManager;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.ConflictOption;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.util.DecisionUtil;
import org.eclipse.emf.emfstore.client.ui.views.changes.ChangePackageVisualizationHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * This details widget shows other involved operations using default
 * representation.
 * 
 * @author wesendon
 */
public class OtherInvolvedWidget extends Composite {

	private static final int COLUMNS = 1;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            parent
	 * @param decisionManager
	 *            decisionManager
	 * @param option
	 *            option
	 */
	public OtherInvolvedWidget(Composite parent,
			DecisionManager decisionManager, ConflictOption option) {
		super(parent, SWT.None);
		TableWrapLayout wrapLayout = new TableWrapLayout();
		wrapLayout.numColumns = COLUMNS;
		wrapLayout.makeColumnsEqualWidth = true;
		setLayout(wrapLayout);
		setBackground(parent.getBackground());

		Label label = new Label(this, SWT.NONE);
		label.setText("Other Involved Changes: ");
		label.setBackground(parent.getBackground());
		TableWrapData wrapData = new TableWrapData();
		wrapData.colspan = COLUMNS;
		label.setLayoutData(wrapData);

		ChangePackageVisualizationHelper visualizationHelper = decisionManager
				.getChangePackageVisualizationHelper();

		for (AbstractOperation ao : option.getOperations()) {
			Image image = visualizationHelper.getImage(DecisionUtil
					.getAdapterFactory(), ao);

			CLabel meLabel = new CLabel(this, SWT.WRAP);
			if (image != null) {
				meLabel.setImage(image);
			}
			meLabel.setText(visualizationHelper.getDescription(ao));
			meLabel.setBackground(parent.getBackground());
		}
	}
}
