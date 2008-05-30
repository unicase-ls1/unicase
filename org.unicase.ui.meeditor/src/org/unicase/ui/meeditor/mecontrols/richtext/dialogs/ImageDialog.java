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
public class ImageDialog extends TitleAreaDialog {

    private String source = null;
    private String alt = null;
    private String border = null;
    private String hspace = null;
    private String vspace = null;
    private String width =  null;
    private String height = null;
    private String align = null;
    private Text srcText;
    private Text descriptionText;
    private Spinner borderSpinner;
    private Text widthText;
    private Text heightText;
    private Spinner vpsaceSpinner;
    private Spinner hspaceSpinner;
    /**
     * @param parentShell
     * @param source
     * @param alt
     * @param border
     * @param hsapce
     * @param vspace
     * @param width
     * @param height
     * @param align
     */
    public ImageDialog(Shell parentShell, String source, String alt,
            String border, String hsapce, String vspace, String width,
            String height, String align) {
        super(parentShell);
        this.source = source != null ? source : ""; //$NON-NLS-1$
        this.alt = alt != null ? alt : ""; //$NON-NLS-1$;
        this.border = border != null ? border : ""; //$NON-NLS-1$
        this.hspace = hsapce != null ? hsapce : ""; //$NON-NLS-1$
        this.vspace = vspace != null ? vspace : ""; //$NON-NLS-1$
        this.width = width != null ? width : ""; //$NON-NLS-1$
        this.height = height != null ? height : ""; //$NON-NLS-1$
        this.align = align != null ? align : ""; //$NON-NLS-1$
        
        
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Insert/Edit Image");
        
    }
    /* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        setTitle("Insert/Edit Image");
        setMessage("Specify the attributes of your image.");
        Composite comp = new Composite((Composite) super.createDialogArea(parent), SWT.NONE);
        comp.setLayout(new GridLayout(2,false));
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        comp.setLayoutData(gd);
        
        Label srcLabel = new Label(comp, SWT.NONE);
        srcLabel.setText("Source");
        gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
        gd.widthHint = 100;
        srcLabel.setLayoutData(gd);
        
        this.srcText = new Text(comp, SWT.BORDER);
        this.srcText.setText(this.source);
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.srcText.setLayoutData(gd);
        
        Label descLabel = new Label(comp, SWT.NONE);
        descLabel.setText("Description");
        gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
        gd.widthHint = 100;
        descLabel.setLayoutData(gd);
        
        this.descriptionText = new Text(comp, SWT.BORDER);
        this.descriptionText.setText(this.alt);
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.descriptionText.setLayoutData(gd);
        
        Label borderLabel = new Label(comp, SWT.NONE);
        borderLabel.setText("Border");
        gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
        gd.widthHint = 100;
        borderLabel.setLayoutData(gd);
        
        this.borderSpinner = new Spinner(comp, SWT.BORDER);
        this.borderSpinner.setIncrement(1);
        this.borderSpinner.setMaximum(10);
        this.borderSpinner.setMinimum(0);
        try {
            this.borderSpinner.setSelection(new Integer(this.border));
        } catch (NumberFormatException e) {
            this.borderSpinner.setSelection(0);
        }
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.borderSpinner.setLayoutData(gd);
        
        Label widthLabel = new Label(comp, SWT.NONE);
        widthLabel.setText("Width");
        gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
        gd.widthHint = 100;
        widthLabel.setLayoutData(gd);
        
        this.widthText = new Text(comp, SWT.BORDER);
        this.widthText.setText(this.width);
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.widthText.setLayoutData(gd);
        
        Label heightLabel = new Label(comp, SWT.NONE);
        heightLabel.setText("Height");
        gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
        gd.widthHint = 100;
        heightLabel.setLayoutData(gd);
        
        this.heightText = new Text(comp, SWT.BORDER);
        this.heightText.setText(this.height);
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.heightText.setLayoutData(gd);
        
        Label vspaceLabel = new Label(comp, SWT.NONE);
        vspaceLabel.setText("Vspace");
        gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
        gd.widthHint = 100;
        vspaceLabel.setLayoutData(gd);
        
        this.vpsaceSpinner = new Spinner(comp, SWT.BORDER);
        this.vpsaceSpinner.setIncrement(1);
        this.vpsaceSpinner.setMaximum(10);
        this.vpsaceSpinner.setMinimum(0);
        try {
            this.vpsaceSpinner.setSelection(new Integer(this.vspace));
        } catch (NumberFormatException e) {
            this.vpsaceSpinner.setSelection(0);
        }
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.vpsaceSpinner.setLayoutData(gd);
        
        Label hspaceLabel = new Label(comp, SWT.NONE);
        hspaceLabel.setText("Hspace");
        gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
        gd.widthHint = 100;
        hspaceLabel.setLayoutData(gd);
        
        this.hspaceSpinner = new Spinner(comp, SWT.BORDER);
        this.hspaceSpinner.setIncrement(1);
        this.hspaceSpinner.setMaximum(10);
        this.hspaceSpinner.setMinimum(0);
        try {
            this.hspaceSpinner.setSelection(new Integer(this.hspace));
        } catch (NumberFormatException e) {
            this.hspaceSpinner.setSelection(0);
        }
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.hspaceSpinner.setLayoutData(gd);
        
        return comp;
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.Dialog#okPressed()
     */
    @Override
    protected void okPressed() {
        this.source = this.srcText.getText();
        this.alt = this.descriptionText.getText();
        this.border = String.valueOf(this.borderSpinner.getSelection());
        this.width = this.widthText.getText();
        this.height = this.heightText.getText();
        this.vspace = String.valueOf(this.vpsaceSpinner.getSelection());
        this.hspace = String.valueOf(this.hspaceSpinner.getSelection());
        super.okPressed();
    }
    /**
     * @return the source
     */
    public String getSource() {
        return this.source;
    }
    /**
     * @return the alt
     */
    public String getAlt() {
        return this.alt;
    }
    /**
     * @return the border
     */
    public String getBorder() {
        return this.border;
    }
    /**
     * @return the hsapce
     */
    public String getHspace() {
        return this.hspace;
    }
    /**
     * @return the vspace
     */
    public String getVspace() {
        return this.vspace;
    }
    /**
     * @return the width
     */
    public String getWidth() {
        return this.width;
    }
    /**
     * @return the height
     */
    public String getHeight() {
        return this.height;
    }
    /**
     * @return the align
     */
    public String getAlign() {
        return this.align;
    }
  
}
