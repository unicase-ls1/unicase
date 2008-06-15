/*******************************************************************************
 * Copyright (c) 2006 Tom Seidel, Spirit Link GmbH
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * 
 * Contributors:
 *     Tom Seidel - initial API and implementation
 *******************************************************************************/
package org.unicase.ui.meeditor.mecontrols.richtext.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
public class TableDialog extends TitleAreaDialog {

	private String cellpadding = null;
	private String cellspacing = null;
	private String clazz = null;
	private String style = null;
	private String id = null;
	private String align = null;
	private Spinner paddingSpinner;
	private Spinner spacingSpinner;
	private Text classText;
	private Text styleText;
	private Text idText;
	private Text alignText;

	/**
	 * @param parentShell
	 * @param cellpadding
	 * @param cellspacing
	 * @param clazz
	 * @param style
	 * @param id
	 * @param align
	 */
	public TableDialog(Shell parentShell, String cellpadding,
			String cellspacing, String clazz, String style, String id,
			String align) {
		super(parentShell);
		this.cellpadding = cellpadding != null ? cellpadding : ""; //$NON-NLS-1$
		this.cellspacing = cellspacing != null ? cellspacing : ""; //$NON-NLS-1$;
		this.clazz = clazz != null ? clazz : ""; //$NON-NLS-1$
		this.style = style != null ? style : ""; //$NON-NLS-1$
		this.id = id != null ? id : ""; //$NON-NLS-1$
		this.align = align != null ? align : ""; //$NON-NLS-1$

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets
	 * .Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Insert/Edit Image");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse
	 * .swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Insert/Edit Table");
		setMessage("Specify the attributes of the table.");
		Composite comp = new Composite((Composite) super
				.createDialogArea(parent), SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		comp.setLayoutData(gd);

		Label paddingLabel = new Label(comp, SWT.NONE);
		paddingLabel.setText("Cellpadding");
		gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
		gd.widthHint = 100;
		paddingLabel.setLayoutData(gd);

		this.paddingSpinner = new Spinner(comp, SWT.BORDER);
		this.paddingSpinner.setMinimum(0);
		this.paddingSpinner.setMaximum(10);
		try {
			this.paddingSpinner.setSelection(new Integer(this.cellpadding));
		} catch (NumberFormatException e) {
			this.paddingSpinner.setSelection(0);
		}
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		this.paddingSpinner.setLayoutData(gd);

		Label spacingLabel = new Label(comp, SWT.NONE);
		spacingLabel.setText("Cellspacing");
		gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
		gd.widthHint = 100;
		spacingLabel.setLayoutData(gd);

		this.spacingSpinner = new Spinner(comp, SWT.BORDER);
		this.spacingSpinner.setMinimum(0);
		this.spacingSpinner.setMaximum(10);
		try {
			this.spacingSpinner.setSelection(new Integer(this.cellspacing));
		} catch (NumberFormatException e1) {
			this.spacingSpinner.setSelection(0);
		}

		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		this.spacingSpinner.setLayoutData(gd);

		Label classLabel = new Label(comp, SWT.NONE);
		classLabel.setText("Class");
		gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
		gd.widthHint = 100;
		classLabel.setLayoutData(gd);

		this.classText = new Text(comp, SWT.BORDER);
		this.classText.setText(this.clazz);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		this.classText.setLayoutData(gd);

		Label styleLabel = new Label(comp, SWT.NONE);
		styleLabel.setText("Style");
		gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
		gd.widthHint = 100;
		styleLabel.setLayoutData(gd);

		this.styleText = new Text(comp, SWT.BORDER);
		this.styleText.setText(this.style);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		this.styleText.setLayoutData(gd);

		Label idLabel = new Label(comp, SWT.NONE);
		idLabel.setText("Id");
		gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
		gd.widthHint = 100;
		idLabel.setLayoutData(gd);

		this.idText = new Text(comp, SWT.BORDER);
		this.idText.setText(this.id);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		this.idText.setLayoutData(gd);

		Label alignLabel = new Label(comp, SWT.NONE);
		alignLabel.setText("Align");
		gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
		gd.widthHint = 100;
		alignLabel.setLayoutData(gd);

		this.alignText = new Text(comp, SWT.BORDER);
		this.alignText.setText(this.align);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		this.alignText.setLayoutData(gd);

		return comp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		this.cellpadding = String.valueOf(this.paddingSpinner.getSelection());
		this.cellspacing = String.valueOf(this.spacingSpinner.getSelection());
		this.clazz = this.classText.getText();
		this.align = this.alignText.getText();
		this.id = this.idText.getText();
		this.style = this.styleText.getText();
		super.okPressed();
	}

	/**
	 * @return the source
	 */
	public String getCellpadding() {
		return this.cellpadding;
	}

	/**
	 * @return the alt
	 */
	public String getCellspacing() {
		return this.cellspacing;
	}

	/**
	 * @return the border
	 */
	public String getClazz() {
		return this.clazz;
	}

	/**
	 * @return the hsapce
	 */
	public String getStyle() {
		return this.style;
	}

	/**
	 * @return the vspace
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @return the align
	 */
	public String getAlign() {
		return this.align;
	}

}
