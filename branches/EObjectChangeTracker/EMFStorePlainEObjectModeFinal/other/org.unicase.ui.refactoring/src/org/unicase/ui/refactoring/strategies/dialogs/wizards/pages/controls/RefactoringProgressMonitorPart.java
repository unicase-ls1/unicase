/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.controls;

import org.eclipse.jface.dialogs.ProgressIndicator;
import org.eclipse.jface.wizard.ProgressMonitorPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;

/**
 * @author pfeifferc
 */
public class RefactoringProgressMonitorPart extends ProgressMonitorPart {

	/**
	 * @param parent the
	 * @param layout the
	 */
	public RefactoringProgressMonitorPart(Composite parent, Layout layout) {
		super(parent, layout);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.ProgressMonitorPart#initialize(org.eclipse.swt.widgets.Layout, int)
	 */
	@Override
	protected void initialize(Layout layout, int progressIndicatorHeight) {
		if (layout == null) {
			GridLayout l = new GridLayout();
			l.marginWidth = 0;
			l.marginHeight = 0;
			l.numColumns = 1;
			layout = l;
		}
		setLayout(layout);

		fLabel = new Label(this, SWT.WRAP);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.heightHint = 30;
		fLabel.setLayoutData(gridData);
		if (progressIndicatorHeight == SWT.DEFAULT) {
			GC gc = new GC(fLabel);
			FontMetrics fm = gc.getFontMetrics();
			gc.dispose();
			progressIndicatorHeight = fm.getHeight();
		}

		fProgressIndicator = new ProgressIndicator(this);
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessHorizontalSpace = true;
		gd.verticalAlignment = GridData.CENTER;
		gd.heightHint = progressIndicatorHeight;
		fProgressIndicator.setLayoutData(gd);
	}
}