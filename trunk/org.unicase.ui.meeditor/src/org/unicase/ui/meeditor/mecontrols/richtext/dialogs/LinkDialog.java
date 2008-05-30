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
import org.eclipse.swt.widgets.Text;

/**
 * 
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
public class LinkDialog extends TitleAreaDialog {
    
    private String href = null;
    
    private String titel = null;
    
    private String target = null;
    
    private String clazz = null;

    private Text hrefText;

    private Text titleText;

    private Text targetText;

    private Text classText;

    /**
     * @param parentShell
     * @param href
     * @param titel
     * @param target
     * @param clazz
     */
    public LinkDialog(Shell parentShell, String href, String titel,
            String target, String clazz) {
        super(parentShell);
        this.href = href != null ? href : ""; //$NON-NLS-1$
        this.titel = titel != null ? titel : ""; //$NON-NLS-1$
        this.target = target != null ? target : ""; //$NON-NLS-1$
        this.clazz = clazz != null ? clazz : ""; //$NON-NLS-1$;
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        setTitle("Insert/Edit Link");
        setMessage("Specify the name of your link.");
        Composite comp = new Composite((Composite) super.createDialogArea(parent), SWT.NONE);
        comp.setLayout(new GridLayout(2,false));
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        comp.setLayoutData(gd);
        
        Label hrefLabel = new Label(comp, SWT.NONE);
        hrefLabel.setText("Href");
        gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
        gd.widthHint = 100;
        hrefLabel.setLayoutData(gd);
        
        this.hrefText = new Text(comp, SWT.BORDER);
        this.hrefText.setText(this.href);
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.hrefText.setLayoutData(gd);
        
        Label titleLabel = new Label(comp, SWT.NONE);
        titleLabel.setText("Titel");
        gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
        gd.widthHint = 100;
        titleLabel.setLayoutData(gd);
        
        this.titleText = new Text(comp, SWT.BORDER);
        this.titleText.setText(this.titel);
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.titleText.setLayoutData(gd);
        
        Label targetLabel = new Label(comp, SWT.NONE);
        targetLabel.setText("Target");
        gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
        gd.widthHint = 100;
        targetLabel.setLayoutData(gd);
        
        this.targetText = new Text(comp, SWT.BORDER);
        this.targetText.setText(this.target);
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.targetText.setLayoutData(gd);
        
        Label classLabel = new Label(comp, SWT.NONE);
        classLabel.setText("Style-Class");
        gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
        gd.widthHint = 100;
        classLabel.setLayoutData(gd);
        
        this.classText = new Text(comp, SWT.BORDER);
        this.classText.setText(this.clazz);
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.classText.setLayoutData(gd);
        
        return comp;
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.Dialog#okPressed()
     */
    @Override
    protected void okPressed() {
        this.href = this.hrefText.getText();
        this.titel = this.titleText.getText();
        this.target = this.targetText.getText();
        this.clazz = this.classText.getText();
        super.okPressed();
    }

    /**
     * @return the href
     */
    public String getHref() {
        return this.href;
    }

    /**
     * @return the titel
     */
    public String getTitel() {
        return this.titel;
    }

    /**
     * @return the target
     */
    public String getTarget() {
        return this.target;
    }

    /**
     * @return the clazz
     */
    public String getClazz() {
        return this.clazz;
    }

}
